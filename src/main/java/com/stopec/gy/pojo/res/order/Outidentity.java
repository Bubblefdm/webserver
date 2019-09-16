package com.stopec.gy.pojo.res.order;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public  class Outidentity {
    @XmlElement(name = "returnid")
    private String returnid;//返回编号	not null	varchar(6)	正确返回0，错误返回-1
    @XmlElement(name = "returnmsg")
    private String returnmsg;//错误信息文本		varchar(1000)	正确为空，错误填写错误原因。

    @XmlTransient
    public String getReturnid() {
        return returnid;
    }

    public void setReturnid(String returnid) {
        this.returnid = returnid;
    }

    @XmlTransient
    public String getReturnmsg() {
        return returnmsg;
    }

    public void setReturnmsg(String returnmsg) {
        this.returnmsg = returnmsg;
    }
}
