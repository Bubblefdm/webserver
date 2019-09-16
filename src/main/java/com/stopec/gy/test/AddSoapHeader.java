package com.stopec.gy.test;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.helpers.DOMUtils;
import javax.xml.namespace.QName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;


public class AddSoapHeader extends AbstractSoapInterceptor {


    private static String nameURI="http://localhost:8090/services/orderService";

    public AddSoapHeader() {
        super(Phase.PRE_PROTOCOL);
    }


    @Override
    public void handleMessage(SoapMessage Message) throws Fault {
        String spPassword="root";
        String spName="root";
        QName qname=new QName("RequestSOAPHeader");
        Document doc=DOMUtils.createDocument();
        //自定义节点
        Element spId=doc.createElement("tns:spId");
        spId.setTextContent(spName);
        //自定义节点
        Element spPass=doc.createElement("tns:spPassword");
        spPass.setTextContent(spPassword);
        Element root=doc.createElementNS(nameURI, "tns:RequestSOAPHeader");
        root.appendChild(spId);
        root.appendChild(spPass);
        SoapHeader head=new SoapHeader(qname,root);
        List<Header> headers = Message.getHeaders();
        headers.add(head);
        System.out.println(">>>>>添加header<<<<<<<");
    }
}
