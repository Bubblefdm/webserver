package com.stopec.gy.contoller;

import com.alibaba.fastjson.JSON;
import com.stopec.gy.mapper.StockMapper;
import com.stopec.gy.pojo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GyCcontrol {
    @Autowired(required = false)
    private StockMapper stockMapper;

    @GetMapping("/getOrder")
    public String getOrderDetails() {
        List<Stock> stocks = stockMapper.selectAll();
        return JSON.toJSONString(stocks);
    }

    @GetMapping("/getPayResult")
    public String getPayResult() {

        return "";
    }
}
