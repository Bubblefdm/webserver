package com.stopec.gy.pojo.res.order;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class DataRow {
    @XmlElement(name = "row")
    private Row row;

    @XmlTransient
    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }
}
