package com.stopec.gy.mybatis.handler;
import com.stopec.gy.mapper.CreateMysqlTablesMapper;
import com.stopec.gy.mybatis.handler.common.ClassTools;
import com.stopec.gy.mybatis.handler.common.ColumnType;
import com.stopec.gy.mybatis.handler.pojo.CreateTableParam;
import com.stopec.gy.mybatis.handler.pojo.SysMysqlColumns;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * mybatis自动创建表
 */
public class AutoTableHandle {

    private static final Logger log = LoggerFactory.getLogger(AutoTableHandle.class);
    private CreateMysqlTablesMapper createMysqlTablesMapper;
    private static final int VARCHAR_DEFAULT_LENGTH = 255;
    private String packs;
    private String tableAuto;
    private boolean isUpdate = false;

    private Map<String, String> jdbcTypeMap = new HashMap<>();

    public AutoTableHandle(CreateMysqlTablesMapper createMysqlTablesMapper, String packs, String tableAuto) {
        this.createMysqlTablesMapper = createMysqlTablesMapper;
        this.packs = packs;
        this.tableAuto = tableAuto;
        initTypeMap();


    }

    private void initTypeMap() {
        jdbcTypeMap.put("String", JdbcType.VARCHAR.name());
        jdbcTypeMap.put("BigDecimal", JdbcType.DECIMAL.name());
        jdbcTypeMap.put("boolean", JdbcType.BOOLEAN.name());
        jdbcTypeMap.put("Byte", JdbcType.TINYINT.name());
        jdbcTypeMap.put("int", JdbcType.BIGINT.name());
        jdbcTypeMap.put("short", JdbcType.SMALLINT.name());
        jdbcTypeMap.put("long", JdbcType.BIGINT.name());
        jdbcTypeMap.put("float", JdbcType.REAL.name());
        jdbcTypeMap.put("double", JdbcType.DOUBLE.name());
        jdbcTypeMap.put("Date", JdbcType.DATE.name());
        //  jdbcTypeMap.put(Timestamp.class.getName(), JdbcType.TIMESTAMP.name());
        // jdbcTypeMap.put(Array.class.getName(), JdbcType.ARRAY.name());
    }

    public void createMysqlTable() {
        if ("none".equals(this.tableAuto)) {
            log.info("配置mybatis.table.auto=none，不需要做任何事情");
        } else if (!this.isUpdate) {
            this.isUpdate = true;
            //需要创建的包路径
            String[] packArr = this.packs.split(",");
            int packLength = packArr.length;
            for (int item = 0; item < packLength; ++item) {
                String pack = packArr[item];
                Map<String, List<Object>> newTableMap = new HashMap();
                Map<String, List<Object>> modifyTableMap = new HashMap();
                Map<String, List<Object>> addTableMap = new HashMap();
                Map<String, List<Object>> removeTableMap = new HashMap();
                Map<String, List<Object>> dropKeyTableMap = new HashMap();
                Map<String, List<Object>> dropUniqueTableMap = new HashMap();
                Set<Class<?>> classes = ClassTools.getClasses(pack, true, Table.class);
                allTableMapConstruct(classes, newTableMap, modifyTableMap, addTableMap, removeTableMap, dropKeyTableMap, dropUniqueTableMap);
                createOrModifyTableConstruct(newTableMap, modifyTableMap, addTableMap, removeTableMap, dropKeyTableMap, dropUniqueTableMap);
            }

        }
    }

    private void allTableMapConstruct(Set<Class<?>> classes, Map<String, List<Object>> newTableMap, Map<String, List<Object>> modifyTableMap, Map<String, List<Object>> addTableMap, Map<String, List<Object>> removeTableMap, Map<String, List<Object>> dropKeyTableMap, Map<String, List<Object>> dropUniqueTableMap) {
        classes.forEach(clas -> {
            Table table = clas.getAnnotation(Table.class);
            if (null != table) {
                List<Object> newFieldList = new ArrayList();
                List<Object> removeFieldList = new ArrayList();
                List<Object> addFieldList = new ArrayList();
                List<Object> modifyFieldList = new ArrayList();
                List<Object> dropKeyFieldList = new ArrayList();
                List<Object> dropUniqueFieldList = new ArrayList();
                //将所有的字段取出来
                tableFieldsConstruct(clas, newFieldList);
                if ("create".equals(this.tableAuto)) {
                    this.createMysqlTablesMapper.dorpTableByName(table.name());
                }
                //判断表是否存在
                int exist = this.createMysqlTablesMapper.findTableCountByTableName(table.name());
                //如果不存在，添加表
                if (exist == 0) {
                    newTableMap.put(table.name(), newFieldList);
                } else {
                    //获取存在的字段
                    List<SysMysqlColumns> tableColumnList = this.createMysqlTablesMapper.findTableEnsembleByTableName(table.name());
                    List<String> columnNames = tableColumnList.stream().map(SysMysqlColumns::getColumnName).collect(Collectors.toList());
                    buildAddAndRemoveAndModifyFields(modifyTableMap, addTableMap, removeTableMap, dropKeyTableMap, dropUniqueTableMap, table, newFieldList, removeFieldList, addFieldList, modifyFieldList, dropKeyFieldList, dropUniqueFieldList, tableColumnList, columnNames);
                }
            }
        });
    }

    private void buildAddAndRemoveAndModifyFields(Map<String, List<Object>> modifyTableMap, Map<String, List<Object>> addTableMap, Map<String, List<Object>> removeTableMap, Map<String, List<Object>> dropKeyTableMap, Map<String, List<Object>> dropUniqueTableMap, Table table, List<Object> newFieldList, List<Object> removeFieldList, List<Object> addFieldList, List<Object> modifyFieldList, List<Object> dropKeyFieldList, List<Object> dropUniqueFieldList, List<SysMysqlColumns> tableColumnList, List<String> columnNames) {
        buildNewFields(addTableMap, table, newFieldList, addFieldList, columnNames);
        Map<String, CreateTableParam> fieldMap = new HashMap();
        Iterator newField = newFieldList.iterator();
        while (newField.hasNext()) {
            Object obj = newField.next();
            CreateTableParam createTableParam = (CreateTableParam) obj;
            fieldMap.put(createTableParam.getFieldName(), createTableParam);
        }
        this.buildRemoveFields(removeTableMap, table, removeFieldList, columnNames, fieldMap);
        this.buildModifyFields(modifyTableMap, dropKeyTableMap, dropUniqueTableMap, table, modifyFieldList, dropKeyFieldList, dropUniqueFieldList, tableColumnList, fieldMap);
    }

    private void buildModifyFields(Map<String, List<Object>> modifyTableMap, Map<String, List<Object>> dropKeyTableMap, Map<String, List<Object>> dropUniqueTableMap, Table table, List<Object> modifyFieldList, List<Object> dropKeyFieldList, List<Object> dropUniqueFieldList, List<SysMysqlColumns> tableColumnList, Map<String, CreateTableParam> fieldMap) {
        Iterator var10 = tableColumnList.iterator();

        while (true) {
            while (var10.hasNext()) {
                SysMysqlColumns sysColumn = (SysMysqlColumns) var10.next();
                CreateTableParam createTableParam = (CreateTableParam) fieldMap.get(sysColumn.getColumnName());
                if (createTableParam == null) {
                    if ("PRI".equals(sysColumn.getColumnKey())) {
                        CreateTableParam tableParam = new CreateTableParam();
                        tableParam.setFieldName(sysColumn.getColumnName());
                        tableParam.setFieldType("int");
                        tableParam.setFieldLength(11);
                        dropKeyFieldList.add(tableParam);
                    }
                } else {
                    if ("PRI".equals(sysColumn.getColumnKey()) && !createTableParam.isFieldIsKey()) {
                        dropKeyFieldList.add(createTableParam);
                    }

                    if ("UNI".equals(sysColumn.getColumnKey()) && !createTableParam.isFieldIsUnique()) {
                        dropUniqueFieldList.add(createTableParam);
                    }

                    if (sysColumn.getDataType().toLowerCase().equals(createTableParam.getFieldType().toLowerCase()) || sysColumn.getDataType().toLowerCase().equals("int") && createTableParam.getFieldType().toLowerCase().equals("integer")) {
                        String typeAndLength = createTableParam.getFieldType().toLowerCase();
                        if (createTableParam.getFieldLength() != 0 && createTableParam.getFieldDecimalLength() != 0) {
                            typeAndLength = typeAndLength + "(" + createTableParam.getFieldLength() + "," + createTableParam.getFieldDecimalLength() + ")";
                        } else if (createTableParam.getFieldLength() != 0) {
                            typeAndLength = typeAndLength + "(" + createTableParam.getFieldLength() + ")";
                        }

                        if (!sysColumn.getColumnType().toLowerCase().equals(typeAndLength)) {
                            modifyFieldList.add(createTableParam);
                        } else if (!"PRI".equals(sysColumn.getColumnKey()) && createTableParam.isFieldIsKey()) {
                            modifyFieldList.add(createTableParam);
                        } else if ("auto_increment".equals(sysColumn.getExtra()) && !createTableParam.isFieldIsAutoIncrement()) {
                            modifyFieldList.add(createTableParam);
                        } else if ((sysColumn.getColumnDefault() == null || sysColumn.getColumnDefault().equals(createTableParam.getFieldDefaultValue())) && (createTableParam.getFieldDefaultValue() == null || createTableParam.getFieldDefaultValue().equals(sysColumn.getColumnDefault()))) {
                            if (sysColumn.getIsNullable().equals("NO") && !createTableParam.isFieldIsKey()) {
                                if (createTableParam.isFieldIsNull()) {
                                    modifyFieldList.add(createTableParam);
                                    continue;
                                }
                            } else if (sysColumn.getIsNullable().equals("YES") && !createTableParam.isFieldIsKey() && !createTableParam.isFieldIsNull()) {
                                modifyFieldList.add(createTableParam);
                                continue;
                            }

                            if (!"UNI".equals(sysColumn.getColumnKey()) && createTableParam.isFieldIsUnique()) {
                                modifyFieldList.add(createTableParam);
                            } else if (StringUtils.isNotBlank(sysColumn.getColumnComment()) && !sysColumn.getColumnComment().equals(createTableParam.getFieldComment()) || StringUtils.isNotBlank(createTableParam.getFieldComment()) && !createTableParam.getFieldComment().equals(sysColumn.getColumnComment())) {
                                modifyFieldList.add(createTableParam);
                            }
                        } else {
                            modifyFieldList.add(createTableParam);
                        }
                    } else {
                        modifyFieldList.add(createTableParam);
                    }
                }
            }

            if (modifyFieldList.size() > 0) {
                modifyTableMap.put(table.name(), modifyFieldList);
            }

            if (dropKeyFieldList.size() > 0) {
                dropKeyTableMap.put(table.name(), dropKeyFieldList);
            }

            if (dropUniqueFieldList.size() > 0) {
                dropUniqueTableMap.put(table.name(), dropUniqueFieldList);
            }

            return;
        }
    }

    private void buildRemoveFields(Map<String, List<Object>> removeTableMap, Table table, List<Object> removeFieldList, List<String> columnNames, Map<String, CreateTableParam> fieldMap) {
        Iterator var6 = columnNames.iterator();

        while (var6.hasNext()) {
            String fieldNm = (String) var6.next();
            if (fieldMap.get(fieldNm) == null) {
                removeFieldList.add(fieldNm);
            }
        }

        if (removeFieldList.size() > 0) {
            removeTableMap.put(table.name(), removeFieldList);
        }

    }

    /**
     * 判断字段是否已经存在
     *
     * @param addTableMap
     * @param table
     * @param newFieldList
     * @param addFieldList
     * @param columnNames
     */
    private void buildNewFields(Map<String, List<Object>> addTableMap, Table table, List<Object> newFieldList, List<Object> addFieldList, List<String> columnNames) {
        Iterator buildNewFields = newFieldList.iterator();

        while (buildNewFields.hasNext()) {
            Object obj = buildNewFields.next();
            CreateTableParam createTableParam = (CreateTableParam) obj;
            if (!columnNames.contains(createTableParam.getFieldName())) {
                addFieldList.add(obj);
            }
        }
        if (addFieldList.size() > 0) {
            addTableMap.put(table.name(), addFieldList);
        }

    }

    private void tableFieldsConstruct(Class<?> clas, List<Object> newFieldList) {
        Field[] fields = clas.getDeclaredFields();
        fields = recursionParents(clas, fields);
        String fieldName = null;
        String type = "varchar";
        boolean fieldIsNull = true;
        boolean fieldIsKey = false;
        boolean fieldIsAutoIncrement = false;
        boolean fieldIsUnique = false;
        String fieldComment = null;
        String fieldDefaultValue = null;
        for (int i = 0; i < fields.length; ++i) {
            Field field = fields[i];
            //忽略Transient注解的属性
            if (!field.isAnnotationPresent(Transient.class)) {
                boolean hasAnnotation = field.isAnnotationPresent(Column.class);
                JdbcType jdbcType = null;
                fieldName = null;
                type = "varchar";
                int length = 0;
                int fieldDecimalLength = 0;
                fieldIsNull = true;
                fieldIsKey = false;
                fieldIsAutoIncrement = false;
                fieldIsUnique = false;
                fieldComment = null;
                fieldDefaultValue = null;
                fieldIsKey = field.isAnnotationPresent(Id.class);
                ColumnType columnType = field.getAnnotation(ColumnType.class);
                if (columnType == null) {
                    String fieldType = field.getType().getSimpleName();
                    //根据字段类型获取mybatis的类型
                    type = getTypeFidle(fieldType);
                    if (StringUtils.isBlank(type)) {
                        type = JdbcType.VARCHAR.name();
                        length = 255;
                    }
                    if (StringUtils.isNotBlank(type)) {
                        //需要区分部分类型
                        if (StringUtils.equalsAny(type, "DATE")) {
                            type = "datetime";
                        }
                        if (!StringUtils.equalsAny(type, "datetime", "Boolean", "Date")) {
                            length = 255;
                        }
                    }
                } else {
                    jdbcType = columnType.jdbcType();
                    switch (jdbcType) {
                        case LONGVARCHAR:
                            type = "text";
                            break;
                        case INTEGER:
                            type = "int";
                            length = 11;
                            break;
                        case BIGINT:
                            length = 11;
                            break;
                        case TINYINT:
                            length = 1;
                            break;
                        case DECIMAL:
                        case DOUBLE:
                            length = 16;
                            fieldDecimalLength = 3;
                            break;
                        case DATETIMEOFFSET:
                            type = "datetime";
                            break;
                        default:
                            type = jdbcType.name().toLowerCase();
                    }
                }
                if (hasAnnotation) {
                    Column column = field.getAnnotation(Column.class);
                    fieldName = column.name();
                    if (jdbcType == JdbcType.VARCHAR || jdbcType != JdbcType.VARCHAR && column.length() != 255) {
                        length = column.length();
                    }
                    fieldDefaultValue = jdbcType != JdbcType.VARCHAR && StringUtils.isBlank(column.table()) ? null : column.table();
                    fieldDecimalLength = column.scale();
                    fieldIsUnique = column.unique();
                    if (!fieldIsKey && !fieldIsUnique) {
                        fieldIsNull = column.nullable();
                    } else {
                        fieldIsNull = false;
                    }
                    fieldComment = StringUtils.isBlank(column.columnDefinition()) ? null : column.columnDefinition();
                }

                if (StringUtils.isBlank(fieldName)) {
                    fieldName = camel2Underline(field.getName());
                }
                CreateTableParam param = new CreateTableParam();
                param.setFieldName(fieldName);
                param.setFieldType(type);
                param.setFieldLength(length);
                param.setFieldComment(fieldComment);
                param.setFieldDecimalLength(fieldDecimalLength);
                param.setFieldDefaultValue(fieldDefaultValue);
                param.setFieldIsAutoIncrement(fieldIsKey);
                param.setFieldIsKey(fieldIsKey);
                param.setFieldIsNull(fieldIsKey ? false : fieldIsNull);
                param.setFieldIsUnique(fieldIsUnique);
                newFieldList.add(param);
            }
        }

    }

    private String getTypeFidle(String fieldType) {
        if (jdbcTypeMap.containsKey(fieldType)) {
            return jdbcTypeMap.get(fieldType);
        }
        return null;
    }

    private Field[] recursionParents(Class<?> clas, Field[] fields) {
        if (clas.getSuperclass() != null) {
            Class clsSup = clas.getSuperclass();
            fields = ArrayUtils.addAll(fields, clsSup.getDeclaredFields());
            fields = this.recursionParents(clsSup, fields);
        }

        return fields;
    }

    private void createOrModifyTableConstruct(Map<String, List<Object>> newTableMap, Map<String, List<Object>> modifyTableMap, Map<String, List<Object>> addTableMap, Map<String, List<Object>> removeTableMap, Map<String, List<Object>> dropKeyTableMap, Map<String, List<Object>> dropUniqueTableMap) {
        this.createTableByMap(newTableMap);
        this.dropFieldsKeyByMap(dropKeyTableMap);
        this.dropFieldsUniqueByMap(dropUniqueTableMap);
        this.addFieldsByMap(addTableMap);
        this.removeFieldsByMap(removeTableMap);
        this.modifyFieldsByMap(modifyTableMap);
    }

    private void modifyFieldsByMap(Map<String, List<Object>> modifyTableMap) {
        if (modifyTableMap.size() > 0) {
            Iterator var2 = modifyTableMap.entrySet().iterator();

            while (var2.hasNext()) {
                Map.Entry<String, List<Object>> entry = (Map.Entry) var2.next();
                Iterator var4 = ((List) entry.getValue()).iterator();
                while (var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    CreateTableParam fieldProperties = (CreateTableParam) obj;
                    log.info("开始修改表" + entry.getKey() + "中的字段" + fieldProperties.getFieldName());
                    this.createMysqlTablesMapper.modifyTableField(map);
                    log.info("完成修改表" + entry.getKey() + "中的字段" + fieldProperties.getFieldName());
                }
            }
        }

    }

    private void removeFieldsByMap(Map<String, List<Object>> removeTableMap) {
        if (removeTableMap.size() > 0) {
            Iterator var2 = removeTableMap.entrySet().iterator();

            while (var2.hasNext()) {
                Map.Entry<String, List<Object>> entry = (Map.Entry) var2.next();
                Iterator var4 = ((List) entry.getValue()).iterator();

                while (var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    String fieldName = (String) obj;
                    log.info("开始删除表" + (String) entry.getKey() + "中的字段" + fieldName);
                    this.createMysqlTablesMapper.removeTableField(map);
                    log.info("完成删除表" + (String) entry.getKey() + "中的字段" + fieldName);
                }
            }
        }

    }

    private void addFieldsByMap(Map<String, List<Object>> addTableMap) {
        if (addTableMap.size() > 0) {
            Iterator var2 = addTableMap.entrySet().iterator();

            while (var2.hasNext()) {
                Map.Entry<String, List<Object>> entry = (Map.Entry) var2.next();
                Iterator var4 = ((List) entry.getValue()).iterator();

                while (var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    CreateTableParam fieldProperties = (CreateTableParam) obj;
                    log.info("开始为表" + entry.getKey() + "增加字段" + fieldProperties.getFieldName());
                    this.createMysqlTablesMapper.addTableField(map);
                    log.info("完成为表" + entry.getKey() + "增加字段" + fieldProperties.getFieldName());
                }
            }
        }

    }

    private void dropFieldsKeyByMap(Map<String, List<Object>> dropKeyTableMap) {
        if (dropKeyTableMap.size() > 0) {
            Iterator var2 = dropKeyTableMap.entrySet().iterator();

            while (var2.hasNext()) {
                Map.Entry<String, List<Object>> entry = (Map.Entry) var2.next();
                Iterator var4 = ((List) entry.getValue()).iterator();

                while (var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    CreateTableParam fieldProperties = (CreateTableParam) obj;
                    log.info("开始为表" + (String) entry.getKey() + "删除主键" + fieldProperties.getFieldName());
                    this.createMysqlTablesMapper.dropKeyTableField(map);
                    log.info("完成为表" + (String) entry.getKey() + "删除主键" + fieldProperties.getFieldName());
                }
            }
        }

    }

    private void dropFieldsUniqueByMap(Map<String, List<Object>> dropUniqueTableMap) {
        if (dropUniqueTableMap.size() > 0) {
            Iterator var2 = dropUniqueTableMap.entrySet().iterator();

            while (var2.hasNext()) {
                Map.Entry<String, List<Object>> entry = (Map.Entry) var2.next();
                Iterator var4 = ((List) entry.getValue()).iterator();

                while (var4.hasNext()) {
                    Object obj = var4.next();
                    Map<String, Object> map = new HashMap();
                    map.put(entry.getKey(), obj);
                    CreateTableParam fieldProperties = (CreateTableParam) obj;
                    log.info("开始为表" + (String) entry.getKey() + "删除唯一约束" + fieldProperties.getFieldName());
                    this.createMysqlTablesMapper.dropUniqueTableField(map);
                    log.info("完成为表" + (String) entry.getKey() + "删除唯一约束" + fieldProperties.getFieldName());
                    log.info("开始修改表" + (String) entry.getKey() + "中的字段" + fieldProperties.getFieldName());
                    this.createMysqlTablesMapper.modifyTableField(map);
                    log.info("完成修改表" + (String) entry.getKey() + "中的字段" + fieldProperties.getFieldName());
                }
            }
        }

    }

    private void createTableByMap(Map<String, List<Object>> newTableMap) {
        if (newTableMap.size() > 0) {
            Iterator var2 = newTableMap.entrySet().iterator();

            while (var2.hasNext()) {
                Map.Entry<String, List<Object>> entry = (Map.Entry) var2.next();
                Map<String, List<Object>> map = new HashMap();
                map.put(entry.getKey(), entry.getValue());
                log.info("开始创建表：" + (String) entry.getKey());
                this.createMysqlTablesMapper.createTable(map);
                log.info("完成创建表：" + (String) entry.getKey());
            }
        }

    }

    public static String camel2Underline(String line) {
        if (line != null && !"".equals(line)) {
            line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
            StringBuffer sb = new StringBuffer();
            Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String word = matcher.group();
                sb.append(word.toLowerCase());
                sb.append(matcher.end() == line.length() ? "" : "_");
            }

            return sb.toString().toLowerCase();
        } else {
            return "";
        }
    }
}
