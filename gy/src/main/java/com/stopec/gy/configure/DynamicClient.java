package com.stopec.gy.configure;

import com.stopec.gy.interceptor.AuthInterceptor;
import com.stopec.gy.service.OrderService;
import com.stopec.gy.service.PayResultService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class DynamicClient {
    @Autowired
    private DynamicConfigure dynamicConfigure;

    @Autowired
    private OrderService orderService;


    @Autowired
    private PayResultService payResultService;


//    @Bean
//    protected Client getClient() {
//        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//        Client client = dcf.createClient(dynamicConfigure.getUrl());
//        //client.getOutInterceptors().add(new AuthInterceptor(dynamicConfigure.getUsername(), dynamicConfigure.getPassword()));
//        return client;
//    }

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");// 发布服务名称 localhost:8080/cxf

    }


    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl immnuneendpoint = new EndpointImpl(springBus(), orderService);
        immnuneendpoint.getOutInterceptors().add(new AuthInterceptor());//添加校验拦截器
        immnuneendpoint.publish("/orderService");



        EndpointImpl immnuneendpoisnts = new EndpointImpl(springBus(), payResultService);
        immnuneendpoisnts.getOutInterceptors().add(new AuthInterceptor());//添加校验拦截器
        immnuneendpoisnts.publish("/payResultService");


        return immnuneendpoint;
    }



}
