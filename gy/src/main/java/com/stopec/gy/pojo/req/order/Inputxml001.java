package com.stopec.gy.pojo.req.order;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "input")
public class Inputxml001 {


    @XmlElement(name = "inidentity")
    private Inidentity inidentity;

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

    @XmlElement(name = "inbusinesscontent")
    private Inbusinesscontent inbusinesscontent;

}
