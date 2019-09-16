package com.stopec.gy.pojo.res.order;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "output")
public class Outputxml001 {
    @XmlTransient
    public Outidentity getOutidentity() {
        return outidentity;
    }

    public void setOutidentity(Outidentity outidentity) {
        this.outidentity = outidentity;
    }


    @XmlTransient
    public Outbusinesscontent getOutbusinesscontent() {
        return outbusinesscontent;
    }

    public void setOutbusinesscontent(Outbusinesscontent outbusinesscontent) {
        this.outbusinesscontent = outbusinesscontent;
    }

    @XmlElement(name = "outidentity")
    private Outidentity outidentity;
    @XmlElement(name = "outbusinesscontent")
    private Outbusinesscontent outbusinesscontent;

}
