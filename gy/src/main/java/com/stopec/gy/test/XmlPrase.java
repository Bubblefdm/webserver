package com.stopec.gy.test;


import com.stopec.gy.pojo.req.order.Inputxml001;
import com.stopec.gy.utils.XMLUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

public class XmlPrase {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<input>\n" +
                "      <inidentity>\n" +
                "       <version>1.1</version>\n" +
                "   <baa008>参保地统筹区编号</baa008>\n" +
                "   <baa010>就医地统筹区编号</baa010>\n" +
                "   <akb020>医疗服务机构编码(就医地医院编码)</akb020>\n" +
                "<akb021>医疗服务机构名称</akb021>\n" +
                "    </inidentity>\n" +
                "<inbusinesscontent>\n" +
                "   <aac002>身份证号码(社会保障号码)</aac002>\n" +
                "<aac001>7</aac001> \n" +
                "</inbusinesscontent>\n" +
                "</input>\n";

//        采用动态工厂方式 不需要指定服务接口
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8090/services/orderService?wsdl");
        Object[] result = null;
        try {
            //如果有命名空间的话
            QName operationName = new QName("http://service.webservice.gy.stopec.com/", "getOrderDetails"); //如果有命名空间需要加上这个，第一个参数为命名空间名称，第二个参数为WebService方法名称
            result = client.invoke(operationName, xml);//后面为WebService请求参数数组
            //如果没有命名空间的话
        } catch (Exception e) {
            String errMsg = "WebService发生异常！";
            result = new Object[]{errMsg};
            e.printStackTrace();
        }
        System.out.println(result[0]);




    }
}
