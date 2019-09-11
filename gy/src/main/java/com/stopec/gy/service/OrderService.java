package com.stopec.gy.service;

import javax.jws.WebService;

@WebService(targetNamespace = "http://service.webservice.gy.stopec.com/", name = "orderService")
public interface OrderService {

    String getOrderDetails(String input);
}
