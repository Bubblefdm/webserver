package com.stopec.gy.service;

import com.stopec.gy.mybatis.Dao.getOrderDetailsMapper;
import com.stopec.gy.pojo.req.order.Inputxml001;
import com.stopec.gy.utils.XMLUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@WebService(serviceName = "orderService",
        targetNamespace = "http://service.webservice.gy.stopec.com/",
        endpointInterface = "com.stopec.gy.service.OrderService")
@MapperScan("com.stopec.gy.mybatis.Dao")

@Service
public class OrderServiceImpl implements OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private getOrderDetailsMapper  getOrderDetailsMapper;

    @Override
    public String getOrderDetails(String input) {
        Inputxml001 inputxml001 = XMLUtils.convertXml2Object(input, Inputxml001.class);
        String aac001 = inputxml001.getInbusinesscontent().getAac001();
        String aac002 = inputxml001.getInbusinesscontent().getAac002();
        String version = inputxml001.getInidentity().getVersion();
        String akb020 = inputxml001.getInidentity().getAkb020();
        String akb021 = inputxml001.getInidentity().getAkb021();
        String baa008 = inputxml001.getInidentity().getBaa008();
        String baa010 = inputxml001.getInidentity().getBaa010();
        logger.info(inputxml001.getInbusinesscontent().getAac001());
        String order = getOrderDetailsMapper.getOrder(aac001);
        System.out.println(order);
        return order;
    }
}
