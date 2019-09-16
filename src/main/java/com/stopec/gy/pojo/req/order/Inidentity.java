package com.stopec.gy.pojo.req.order;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class Inidentity {
    @XmlElement(name = "version")
    private String version;//接口的版本号
    @XmlElement(name = "baa008")
    private String baa008;//参保地统筹区编号	not null	varchar(6)	参保地州、市行政区划代码
    @XmlElement(name = "baa010")
    private String baa010;//就医地统筹区编号	not null	varchar(6)	就医地州、市行政区划代码
    @XmlElement(name = "akb020")
    private String akb020;//医疗服务机构编码	not null	varchar(20)
    @XmlElement(name = "akb021")
    private String akb021;//医疗服务机构名称	not null	varchar(200)

    @XmlTransient
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlTransient
    public String getBaa008() {
        return baa008;
    }

    public void setBaa008(String baa008) {
        this.baa008 = baa008;
    }

    @XmlTransient
    public String getBaa010() {
        return baa010;
    }

    public void setBaa010(String baa010) {
        this.baa010 = baa010;
    }

    @XmlTransient
    public String getAkb020() {
        return akb020;
    }

    public void setAkb020(String akb020) {
        this.akb020 = akb020;
    }

    @XmlTransient
    public String getAkb021() {
        return akb021;
    }

    public void setAkb021(String akb021) {
        this.akb021 = akb021;
    }
}
