package com.stopec.gy.mybatis.handler.pojo;

public class CreateTableParam {
    private String fieldName;
    private String fieldType;
    private int fieldLength;
    private int fieldDecimalLength;
    private boolean fieldIsNull;
    private boolean fieldIsKey;
    private boolean fieldIsAutoIncrement;
    private String fieldDefaultValue;
    private boolean fieldIsUnique;
    private String fieldComment;
    private String tableDdl;


    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return this.fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public int getFieldLength() {
        return this.fieldLength;
    }

    public void setFieldLength(int fieldLength) {
        this.fieldLength = fieldLength;
    }

    public int getFieldDecimalLength() {
        return this.fieldDecimalLength;
    }

    public void setFieldDecimalLength(int fieldDecimalLength) {
        this.fieldDecimalLength = fieldDecimalLength;
    }

    public boolean isFieldIsNull() {
        return this.fieldIsKey ? false : this.fieldIsNull;
    }

    public void setFieldIsNull(boolean fieldIsNull) {
        this.fieldIsNull = fieldIsNull;
    }

    public boolean isFieldIsKey() {
        return this.fieldIsKey;
    }

    public void setFieldIsKey(boolean fieldIsKey) {
        this.fieldIsKey = fieldIsKey;
    }

    public boolean isFieldIsAutoIncrement() {
        return this.fieldIsAutoIncrement;
    }

    public void setFieldIsAutoIncrement(boolean fieldIsAutoIncrement) {
        this.fieldIsAutoIncrement = fieldIsAutoIncrement;
    }

    public String getFieldDefaultValue() {
        return this.fieldDefaultValue;
    }

    public void setFieldDefaultValue(String fieldDefaultValue) {
        this.fieldDefaultValue = fieldDefaultValue;
    }

    public boolean isFieldIsUnique() {
        return this.fieldIsUnique;
    }

    public void setFieldIsUnique(boolean fieldIsUnique) {
        this.fieldIsUnique = fieldIsUnique;
    }

    public String getFieldComment() {
        return this.fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }

    public String getTableDdl() {
        return this.tableDdl;
    }

    public void setTableDdl(String tableDdl) {
        this.tableDdl = tableDdl;
    }
}

