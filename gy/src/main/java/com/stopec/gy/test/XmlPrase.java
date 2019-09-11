package com.stopec.gy.test;

import com.stopec.gy.pojo.req.order.Inputxml001;
import com.stopec.gy.pojo.res.order.Disease;
import com.stopec.gy.utils.XMLUtils;

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
                "<aac001>个人编号</aac001> \n" +
                "</inbusinesscontent>\n" +
                "</input>\n";
        Inputxml001 inputxml001 = XMLUtils.convertXml2Object(xml, Inputxml001.class);
        System.out.println(inputxml001.getInidentity().getVersion());




    }
}
