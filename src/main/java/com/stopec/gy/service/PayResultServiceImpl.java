package com.stopec.gy.service;

import org.springframework.stereotype.Service;

import javax.jws.WebService;

@WebService(serviceName = "payResultService",
        targetNamespace = "http://service.webservice.gy.stopec.com/",
        endpointInterface = "com.stopec.gy.service.PayResultService")
@Service
public class PayResultServiceImpl implements PayResultService {
    @Override
    public String getPayResult(String input) {
        return "测试";
    }
}
