package com.stopec.gy.service;

import javax.jws.WebService;

@WebService(targetNamespace = "http://service.webservice.gy.stopec.com/", name = "payResultService")

public interface PayResultService {

    String getPayResult(String input);
}
