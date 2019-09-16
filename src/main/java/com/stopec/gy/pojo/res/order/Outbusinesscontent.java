package com.stopec.gy.pojo.res.order;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class Outbusinesscontent {
    @XmlElement(name = "hisOrderId")
    private String hisOrderId;

    @XmlTransient
    public String getHisOrderId() {
        return this.hisOrderId;
    }

    public void setHisOrderId(String hisOrderId) {
        this.hisOrderId = hisOrderId;
    }

    @XmlElement(name = "aac003")
    private String aac003;

    @XmlTransient
    public String getAac003() {
        return this.aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    @XmlElement(name = "aac002")
    public String aac002;

    @XmlTransient
    public String getAac002() {
        return this.aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }

    @XmlElement(name = "aka130")
    private String aka130;

    @XmlTransient
    public String getAka130() {
        return this.aka130;
    }

    public void setAka130(String aka130) {
        this.aka130 = aka130;
    }

    @XmlElement(name = "akc193")
    private String akc193;

    @XmlTransient
    public String getAkc193() {
        return this.akc193;
    }

    public void setAkc193(String akc193) {
        this.akc193 = akc193;
    }

    @XmlElement(name = "bkc020")
    private String bkc020;

    @XmlTransient
    public String getBkc020() {
        return this.bkc020;
    }

    public void setBkc020(String bkc020) {
        this.bkc020 = bkc020;
    }

    @XmlElement(name = "disease")
    private Disease disease;

    @XmlTransient
    public Disease getDisease() {
        return this.disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    @XmlElement(name = "bkc131")
    private String bkc131;

    @XmlTransient
    public String getBkc131() {
        return this.bkc131;
    }

    public void setBkc131(String bkc131) {
        this.bkc131 = bkc131;
    }

    @XmlElement(name = "aae030")
    private String aae030;

    @XmlTransient
    public String getAae030() {
        return this.aae030;
    }

    public void setAae030(String aae030) {
        this.aae030 = aae030;
    }

    @XmlElement(name = "nums")
    private String nums;

    @XmlTransient
    public String getNums() {
        return this.nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }


    @XmlElement(name = "datarow")
    private DataRow datarow;

    @XmlTransient
    public DataRow getDatarow() {
        return this.datarow;
    }

    public void setDatarow(DataRow datarow) {
        this.datarow = datarow;
    }

    @XmlElement(name = "bkc033")
    private Bkc033 bkc033;

    @XmlTransient
    public Bkc033 getBkc033() {
        return this.bkc033;
    }

    public void setBkc033(Bkc033 bkc033) {
        this.bkc033 = bkc033;
    }
}
