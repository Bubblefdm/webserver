package com.stopec.gy.pojo.res.pay;

import com.stopec.gy.pojo.res.order.Outbusinesscontent;
import com.stopec.gy.pojo.res.order.Outidentity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "output")
public class Outputxml002 {
    @XmlElement(name = "outidentity")
    private Outidentity outidentity;
    @XmlElement(name = "outbusinesscontent")
    private Outbusinesscontent outbusinesscontent;


    public Outidentity getOutidentity() {
        return outidentity;
    }

    @XmlTransient
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
}
