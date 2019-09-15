package com.stopec.gy.pojo.res.order;

import java.math.BigDecimal;
import java.util.Date;

public class test {
    private int 系统编号;
    private Date   发生时间;
    private String 业务类型;
    private int 住院编号;
    private BigDecimal 余额增加;
    private BigDecimal 累计余额;
    private  int 操作员;

    public int get系统编号() {
        return 系统编号;
    }

    public void set系统编号(int 系统编号) {
        this.系统编号 = 系统编号;
    }

    public Date get发生时间() {
        return 发生时间;
    }

    public void set发生时间(Date 发生时间) {
        this.发生时间 = 发生时间;
    }

    public String get业务类型() {
        return 业务类型;
    }

    public void set业务类型(String 业务类型) {
        this.业务类型 = 业务类型;
    }

    public int get住院编号() {
        return 住院编号;
    }

    public void set住院编号(int 住院编号) {
        this.住院编号 = 住院编号;
    }

    public BigDecimal get余额增加() {
        return 余额增加;
    }

    public void set余额增加(BigDecimal 余额增加) {
        this.余额增加 = 余额增加;
    }

    public BigDecimal get累计余额() {
        return 累计余额;
    }

    public void set累计余额(BigDecimal 累计余额) {
        this.累计余额 = 累计余额;
    }

    public int get操作员() {
        return 操作员;
    }

    public void set操作员(int 操作员) {
        this.操作员 = 操作员;
    }

    @Override
    public String toString() {
        return "test{" +
                "系统编号=" + 系统编号 +
                ", 发生时间=" + 发生时间 +
                ", 业务类型='" + 业务类型 + '\'' +
                ", 住院编号=" + 住院编号 +
                ", 余额增加=" + 余额增加 +
                ", 累计余额=" + 累计余额 +
                ", 操作员=" + 操作员 +
                '}';
    }
}
