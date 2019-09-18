package com.stopec.gy.test;


import com.stopec.gy.pojo.req.order.Inputxml001;
import com.stopec.gy.pojo.req.pay.Inputxml002;
import com.stopec.gy.pojo.res.order.Outbusinesscontent;
import com.stopec.gy.pojo.res.order.Outidentity;
import com.stopec.gy.pojo.res.order.Outputxml001;
import com.stopec.gy.pojo.res.pay.Outputxml002;
import com.stopec.gy.utils.XMLUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;

public class XmlPrase {

    private static Logger logger = LoggerFactory.getLogger(XmlPrase.class);

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

        Inputxml001 inputxml001 = XMLUtils.convertXml2Object(xml, Inputxml001.class);
        logger.info(inputxml001.getInbusinesscontent().getAac002());


        String payXml = "<?xml version=\"1.0\" encoding=\"utf-8\"  ?>\n" +
                "<output>\n" +
                "<!-- 标识 -->\n" +
                "<outidentity>\n" +
                "   <returnid>返回编号</returnid>\n" +
                "   <returnmsg>错误信息文本</returnmsg>\n" +
                "</outidentity>\n" +
                "<!--返回的业务处理结果报文-->\n" +
                "<outbusinesscontent>\n" +
                "</outbusinesscontent>\n" +
                "</output>\n";
        Outputxml002 outputxml002 = XMLUtils.convertXml2Object(payXml, Outputxml002.class);

        logger.info(outputxml002.getOutidentity().getReturnmsg());


        Outputxml002 outputxml0021 = new Outputxml002();
        Outidentity outidentity = new Outidentity();
        outidentity.setReturnid("00001");
        outidentity.setReturnmsg("success");
        Outbusinesscontent outbusinesscontent = new Outbusinesscontent();
        outbusinesscontent.setAac002("121");
        outputxml0021.setOutbusinesscontent(outbusinesscontent);
        outputxml0021.setOutidentity(outidentity);
        String s = XMLUtils.convertObject2XmlString(outputxml0021);
        logger.info("输出xml{}", s);


        String outxml001 = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<output>\n" +
                "    <outidentity>\n" +
                "        <returnid>返回编号</returnid>\n" +
                "        <returnmsg>错误信息文本</returnmsg>\n" +
                "    </outidentity>\n" +
                "    <!--返回的业务处理结果报文-->\n" +
                "    <outbusinesscontent>\n" +
                "        <hisOrderId>his订单号</hisOrderId>\n" +
                "        <aac003>姓名</aac003>\n" +
                "        <aac002>身份证号</aac002>\n" +
                "        <aka130>医疗类别代码</aka130>\n" +
                "        <akc193>门诊主诊断</akc193>\n" +
                "        <bkc020>门诊诊断中文名称(医院来组织)</bkc020>\n" +
                "        <disease>\n" +
                "            <row>\n" +
                "                <bkc014>特慢病病种编码</bkc014>\n" +
                "                <bkc117>特慢病病种名称</bkc117>\n" +
                "            </row>\n" +
                "        </disease>\n" +
                "        <bkc131>经办人姓名</bkc131>\n" +
                "        <aae030>费用发生时间</aae030>\n" +
                "        <nums>明细数量</nums>\n" +
                "        <datarow>\n" +
                "            <row>\n" +
                "                <bke019>费用明细序号(记账流水号)</bke019>\n" +
                "                <bke030>商品码</bke030>\n" +
                "                <ake001>社保三大目录统一编码</ake001>\n" +
                "                <ake002>社保三大目录名称</ake002>\n" +
                "                <bke026>院内(药店)收费项目编码</bke026>\n" +
                "                <bke027>院内(药店)收费项目名称</bke027>\n" +
                "                <aka074_yn>院内(药店)收费项目规格</aka074_yn>\n" +
                "                <aka070_yn>院内(药店)收费项目剂型</aka070_yn>\n" +
                "                <aka067_yn>本单收费单位</aka067_yn>\n" +
                "                <aka067>最小收费单位</aka067>\n" +
                "                <akc226>数量</akc226>\n" +
                "                <akc225>单价</akc225>\n" +
                "                <akc264>费用总额</akc264>\n" +
                "                <bkc048>处方医生编码</bkc048>\n" +
                "                <bkc049>处方医生姓名</bkc049>\n" +
                "                <aaz307>所属科室(医院内部编码)</aaz307>\n" +
                "                <aae386>科室名称</aae386>\n" +
                "                <bkc045>用法</bkc045>\n" +
                "                <bkc044>每次用量</bkc044>\n" +
                "                <aka074>与单次用量同单位规格(数值型)</aka074>\n" +
                "                <yke112>医嘱记录序号</yke112>\n" +
                "                <aae072>单据号</aae072>\n" +
                "                <aka017>单据类型</aka017>\n" +
                "                <yke330>院外检查标志</yke330>\n" +
                "                <xzyyspbz>限制用药审批标志</xzyyspbz>\n" +
                "            </row>\n" +
                "        </datarow>\n" +
                "        <bkc033>\n" +
                "            <row>\n" +
                "                <bkc022>门诊次要诊断编码</bkc022>\n" +
                "                <akc076>门诊次要诊断名称</akc076>\n" +
                "            </row>\n" +
                "            <row>\n" +
                "                <bkc022>门诊次要诊断编码</bkc022>\n" +
                "                <akc076>门诊次要诊断名称</akc076>\n" +
                "            </row>\n" +
                "        </bkc033>\n" +
                "    </outbusinesscontent>\n" +
                "</output>";

        Outputxml001 outputxml001 = XMLUtils.convertXml2Object(outxml001, Outputxml001.class);

        logger.info(outputxml001.getOutbusinesscontent().getDatarow().getRow().toString());
        logger.info(outputxml001.getOutbusinesscontent().getDisease().getRow().toString());
        logger.info(outputxml001.getOutbusinesscontent().getBkc033().getRow().toString());


        String xmloutPut = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<input>\n" +
                "<inidentity>\n" +
                "    <version>1.1</version>\n" +
                "    <baa008>参保地统筹区编号</baa008>\n" +
                "    <baa010>就医地统筹区编号</baa010>\n" +
                "    <akb020>医疗服务机构编码(就医地医院编码)</akb020>\n" +
                "    <akb021>医疗服务机构名称</akb021>\n" +
                "</inidentity>\n" +
                "<inbusinesscontent>\n" +
                "    <hisOrderId>his订单号</hisOrderId>\n" +
                "    <aaz217>就诊登记号</aaz217>\n" +
                "    <aaz216>人员医疗结算事件id(就诊结算id)</aaz216>\n" +
                "    <baa008>参保地统筹区编号</baa008>\n" +
                "    <baa009>参保地分中心编码</baa009>\n" +
                "    <baa010>就医地统筹区编号</baa010>\n" +
                "    <aac001>个人编号</aac001>\n" +
                "    <aac002>身份证号码</aac002>\n" +
                "    <aac003>姓名</aac003>\n" +
                "    <aac004>性别</aac004>\n" +
                "    <aae140>险种类型</aae140>\n" +
                "    <aac066>参保身份</aac066>\n" +
                "    <bkc113>特殊人员类别</bkc113>\n" +
                "    <akc264>费用总额</akc264>\n" +
                "    <akc253>全自费部分</akc253>\n" +
                "    <akc228>先自付部分</akc228>\n" +
                "    <akc268>超限自付部分</akc268>\n" +
                "    <bkc042>进入报销范围部分</bkc042>\n" +
                "    <bke002>本次起付线</bke002>\n" +
                "    <bke003>本年累积起付线</bke003>\n" +
                "    <akb066>个人账户支付</akb066>\n" +
                "    <akb068>医保统筹支付合计（不包含个人账户支付）</akb068>\n" +
                "    <akb067>现金支付</akb067>\n" +
                "    <ake039>城镇职工基本保险</ake039>\n" +
                "    <ake035>公务员医疗保险</ake035>\n" +
                "    <ake029>城镇职工大病保险</ake029>\n" +
                "    <ake039_jm>城乡居民基本险</ake039_jm>\n" +
                "    <bkc010>城乡居民大病险</bkc010>\n" +
                "    <yka530_jm>居民精准贫困</yka530_jm>\n" +
                "    <ake039_xnh>新农合</ake039_xnh>\n" +
                "    <ake039_qt>其它险种</ake039_qt>\n" +
                "    <aae240>本次结算后的个人帐户余额</aae240>\n" +
                "    <bkc143>本次个人账户最多可支付金额</bkc143>\n" +
                "    <bke031>报销情况说明</bke031>\n" +
                "    <aae036>医保结算时间</aae036>\n" +
                "    <datarow>\n" +
                "        <row>\n" +
                "            <bke019>费用明细序号</bke019>\n" +
                "            <aka068>定价上限金额</aka068>\n" +
                "            <aka057>自费比例</aka057>\n" +
                "            <akc253>全自费部分</akc253>\n" +
                "            <akc228>先自付部分</akc228>\n" +
                "            <akc268>超限自付部分</akc268>\n" +
                "            <bkc042>进入报销范围部分</bkc042>\n" +
                "            <aka065>收费项目等级</aka065>\n" +
                "        </row>\n" +
                "    </datarow>\n" +
                "\n" +
                "</inbusinesscontent>\n" +
                "</input>";
//        Inputxml002 outputxml0021 = XMLUtils.convertXml2Object(xmloutPut, Inputxml002.class);
//        logger.info(outputxml0021.getInbusinesscontent().getDatarow().getRow().toString());


        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8090/services/orderService?wsdl");
        client.getOutInterceptors().add(new AddSoapHeader());
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
