package com.stopec.gy.mapper;

import com.stopec.gy.mybatis.handler.pojo.SysMysqlColumns;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface CreateMysqlTablesMapper extends Mapper<SysMysqlColumns> {
    void createTable(@Param("tableMap") Map<String, List<Object>> tableMap);

    int findTableCountByTableName(@Param("tableName") String tableName);

    List<SysMysqlColumns> findTableEnsembleByTableName(@Param("tableName") String tableName);

    void addTableField(@Param("tableMap") Map<String, Object> tableMap);

    void removeTableField(@Param("tableMap") Map<String, Object> tableMap);

    void modifyTableField(@Param("tableMap") Map<String, Object> tableMap);

    void dropKeyTableField(@Param("tableMap") Map<String, Object> tableMap);

    void dropUniqueTableField(@Param("tableMap") Map<String, Object> tableMap);

    void dorpTableByName(@Param("tableName") String tableName);

    String getSqlByTableName(@Param("tableName") String tableName);
}
