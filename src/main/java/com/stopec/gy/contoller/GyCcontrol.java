package com.stopec.gy.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GyCcontrol {

    @GetMapping("/getOrder")
    public String getOrderDetails() {



        return "";
    }

    @GetMapping("/getPayResult")
    public String getPayResult() {

        return "";
    }
}
