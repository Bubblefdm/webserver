package com.stopec.gy.pojo.res.order;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class Outidentity {
    @XmlElement(name = "returnid")
    public String returnid;

    @XmlElement(name = "returnmsg")
    public String returnmsg;

    @XmlTransient
    public String getReturnid() {
        return this.returnid;
    }

    public void setReturnid(String returnid) {
        this.returnid = returnid;
    }

    @XmlTransient
    public String getReturnmsg() {
        return this.returnmsg;
    }

    public void setReturnmsg(String returnmsg) {
        this.returnmsg = returnmsg;
    }
}
