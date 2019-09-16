package com.stopec.gy.pojo.req.pay;

import com.stopec.gy.pojo.req.order.Inbusinesscontent;
import com.stopec.gy.pojo.req.order.Inidentity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement(name = "input")
public class Inputxml002 {
    @XmlElement(name = "inidentity")
    private Inidentity inidentity;
    @XmlElement(name = "inbusinesscontent")
    private com.stopec.gy.pojo.req.order.Inbusinesscontent inbusinesscontent;

    @XmlTransient
    public Inidentity getInidentity() {
        return inidentity;
    }

    public void setInidentity(Inidentity inidentity) {
        this.inidentity = inidentity;
    }

    @XmlTransient
    public Inbusinesscontent getInbusinesscontent() {
        return inbusinesscontent;
    }

    public void setInbusinesscontent(Inbusinesscontent inbusinesscontent) {
        this.inbusinesscontent = inbusinesscontent;
    }
}
