package com.stopec.gy.pojo.req.order;

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
}
