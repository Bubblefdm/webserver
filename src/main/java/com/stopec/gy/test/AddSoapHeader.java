package com.stopec.gy.test;

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


    public AddSoapHeader() {
        super(Phase.PREPARE_SEND);
    }


    public void handleMessage(SoapMessage soap) throws Fault {
        // TODO Auto-generated method stub
        List<Header> headers = soap.getHeaders();

        Document doc = DOMUtils.createDocument();

        Element auth = doc.createElement("authrity");
        Element username = doc.createElement("username");
        Element password = doc.createElement("password");

        username.setTextContent("root");
        password.setTextContent("root");

        auth.appendChild(username);
        auth.appendChild(password);

        headers.add(0, new Header(new QName("tiamaes"), auth));
    }
}
