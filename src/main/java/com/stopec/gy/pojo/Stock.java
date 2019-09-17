package com.stopec.gy.pojo;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;

@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11, columnDefinition = "主键")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private int id;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "count")
    private int count;
    @Column(name = "sale")
    private int sale;
    @Column(name = "version")
    private int version;
    @Column(name = "desc_commit")
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
