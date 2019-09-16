package com.stopec.gy.pojo.req.order;


import com.stopec.gy.pojo.res.order.DataRow;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class Inbusinesscontent {
    @XmlElement(name = "aac002")
    private String aac002;//身份证号码(社会保障号码)	not null	varchar(18)
    @XmlElement(name = "aac001")
    private String aac001;//个人编码	not null	varchar(20)

    @XmlTransient
    public String getAac002() {
        return aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }

    @XmlTransient
    public String getAac001() {
        return aac001;
    }

    public void setAac001(String aac001) {
        this.aac001 = aac001;
    }


    //002的属性
    @XmlElement(name = "hisOrderId")
    private String hisOrderId;

    @XmlTransient
    public String getHisOrderId() {
        return this.hisOrderId;
    }

    public void setHisOrderId(String hisOrderId) {
        this.hisOrderId = hisOrderId;
    }

    @XmlElement(name = "aaz217")
    public String aaz217;

    @XmlTransient
    public String getAaz217() {
        return this.aaz217;
    }

    public void setAaz217(String aaz217) {
        this.aaz217 = aaz217;
    }

    @XmlElement(name = "aaz216")
    public String aaz216;

    @XmlTransient
    public String getAaz216() {
        return this.aaz216;
    }

    public void setAaz216(String aaz216) {
        this.aaz216 = aaz216;
    }

    @XmlElement(name = "baa008")
    public String baa008;

    @XmlTransient
    public String getBaa008() {
        return this.baa008;
    }

    public void setBaa008(String baa008) {
        this.baa008 = baa008;
    }

    @XmlElement(name = "baa009")
    public String baa009;

    @XmlTransient
    public String getBaa009() {
        return this.baa009;
    }

    public void setBaa009(String baa009) {
        this.baa009 = baa009;
    }

    @XmlElement(name = "baa010")
    public String baa010;

    @XmlTransient
    public String getBaa010() {
        return this.baa010;
    }

    public void setBaa010(String baa010) {
        this.baa010 = baa010;
    }

    @XmlElement(name = "aac003")
    public String aac003;

    @XmlTransient
    public String getAac003() {
        return this.aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    @XmlElement(name = "aac004")
    public String aac004;

    @XmlTransient
    public String getAac004() {
        return this.aac004;
    }

    public void setAac004(String aac004) {
        this.aac004 = aac004;
    }

    @XmlElement(name = "aae140")
    public String aae140;

    @XmlTransient
    public String getAae140() {
        return this.aae140;
    }

    public void setAae140(String aae140) {
        this.aae140 = aae140;
    }

    @XmlElement(name = "aac066")
    public String aac066;

    @XmlTransient
    public String getAac066() {
        return this.aac066;
    }

    public void setAac066(String aac066) {
        this.aac066 = aac066;
    }

    @XmlElement(name = "bkc113")
    public String bkc113;

    @XmlTransient
    public String getBkc113() {
        return this.bkc113;
    }

    public void setBkc113(String bkc113) {
        this.bkc113 = bkc113;
    }

    @XmlElement(name = "akc264")
    public String akc264;

    @XmlTransient
    public String getAkc264() {
        return this.akc264;
    }

    public void setAkc264(String akc264) {
        this.akc264 = akc264;
    }

    @XmlElement(name = "akc253")
    public String akc253;

    @XmlTransient
    public String getAkc253() {
        return this.akc253;
    }

    public void setAkc253(String akc253) {
        this.akc253 = akc253;
    }

    @XmlElement(name = "akc228")
    public String akc228;

    @XmlTransient
    public String getAkc228() {
        return this.akc228;
    }

    public void setAkc228(String akc228) {
        this.akc228 = akc228;
    }

    @XmlElement(name = "akc268")
    public String akc268;

    @XmlTransient
    public String getAkc268() {
        return this.akc268;
    }

    public void setAkc268(String akc268) {
        this.akc268 = akc268;
    }

    @XmlElement(name = "bkc042")
    public String bkc042;

    @XmlTransient
    public String getBkc042() {
        return this.bkc042;
    }

    public void setBkc042(String bkc042) {
        this.bkc042 = bkc042;
    }

    @XmlElement(name = "bke002")
    public String bke002;

    @XmlTransient
    public String getBke002() {
        return this.bke002;
    }

    public void setBke002(String bke002) {
        this.bke002 = bke002;
    }

    @XmlElement(name = "bke003")
    public String bke003;

    @XmlTransient
    public String getBke003() {
        return this.bke003;
    }

    public void setBke003(String bke003) {
        this.bke003 = bke003;
    }

    @XmlElement(name = "akb066")
    public String akb066;

    @XmlTransient
    public String getAkb066() {
        return this.akb066;
    }

    public void setAkb066(String akb066) {
        this.akb066 = akb066;
    }

    @XmlElement(name = "akb068")
    public String akb068;

    @XmlTransient
    public String getAkb068() {
        return this.akb068;
    }

    public void setAkb068(String akb068) {
        this.akb068 = akb068;
    }

    @XmlElement(name = "akb067")
    public String akb067;

    @XmlTransient
    public String getAkb067() {
        return this.akb067;
    }

    public void setAkb067(String akb067) {
        this.akb067 = akb067;
    }

    @XmlElement(name = "ake039")
    public String ake039;

    @XmlTransient
    public String getAke039() {
        return this.ake039;
    }

    public void setAke039(String ake039) {
        this.ake039 = ake039;
    }

    @XmlElement(name = "ake035")
    public String ake035;

    @XmlTransient
    public String getAke035() {
        return this.ake035;
    }

    public void setAke035(String ake035) {
        this.ake035 = ake035;
    }

    @XmlElement(name = "ake029")
    public String ake029;

    @XmlTransient
    public String getAke029() {
        return this.ake029;
    }

    public void setAke029(String ake029) {
        this.ake029 = ake029;
    }

    @XmlElement(name = "ake039_jm")
    public String ake039_jm;

    @XmlTransient
    public String getAke039_jm() {
        return this.ake039_jm;
    }

    public void setAke039_jm(String ake039_jm) {
        this.ake039_jm = ake039_jm;
    }

    @XmlElement(name = "bkc010")
    public String bkc010;

    @XmlTransient
    public String getBkc010() {
        return this.bkc010;
    }

    public void setBkc010(String bkc010) {
        this.bkc010 = bkc010;
    }

    @XmlElement(name = "yka530_jm")
    public String yka530_jm;

    @XmlTransient
    public String getYka530_jm() {
        return this.yka530_jm;
    }

    public void setYka530_jm(String yka530_jm) {
        this.yka530_jm = yka530_jm;
    }

    @XmlElement(name = "ake039_xnh")
    public String ake039_xnh;

    @XmlTransient
    public String getAke039_xnh() {
        return this.ake039_xnh;
    }

    public void setAke039_xnh(String ake039_xnh) {
        this.ake039_xnh = ake039_xnh;
    }

    @XmlElement(name = "ake039_qt")
    public String ake039_qt;

    @XmlTransient
    public String getAke039_qt() {
        return this.ake039_qt;
    }

    public void setAke039_qt(String ake039_qt) {
        this.ake039_qt = ake039_qt;
    }

    @XmlElement(name = "aae240")
    public String aae240;

    @XmlTransient
    public String getAae240() {
        return this.aae240;
    }

    public void setAae240(String aae240) {
        this.aae240 = aae240;
    }

    @XmlElement(name = "bkc143")
    public String bkc143;

    @XmlTransient
    public String getBkc143() {
        return this.bkc143;
    }

    public void setBkc143(String bkc143) {
        this.bkc143 = bkc143;
    }

    @XmlElement(name = "bke031")
    public String bke031;

    @XmlTransient
    public String getBke031() {
        return this.bke031;
    }

    public void setBke031(String bke031) {
        this.bke031 = bke031;
    }

    @XmlElement(name = "aae036")
    public String aae036;

    @XmlTransient
    public String getAae036() {
        return this.aae036;
    }

    public void setAae036(String aae036) {
        this.aae036 = aae036;
    }

    @XmlElement(name = "datarow")
    public DataRow datarow;

    @XmlTransient
    public DataRow getDatarow() {
        return this.datarow;
    }

    public void setDatarow(DataRow datarow) {
        this.datarow = datarow;
    }
}
