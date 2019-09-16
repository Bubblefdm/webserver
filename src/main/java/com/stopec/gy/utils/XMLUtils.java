package com.stopec.gy.utils;

import com.stopec.gy.pojo.res.order.outputxml001;
import org.springframework.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;

public class XMLUtils {

    /**
     * convert object to xml string by encoding
     *
     * @param object
     * @param encoding
     * @return
     */
    public static String convertObject2XmlString(Object object, String encoding) {
        try {
            StringWriter writer = new StringWriter();
            createMarshaller(encoding, object.getClass()).marshal(object, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * convert object to xml string by encoding
     *
     * @param object
     * @return
     */
    public static String convertObject2XmlString(Object object) {
        try {
            StringWriter writer = new StringWriter();
            createMarshaller(null, object.getClass()).marshal(object, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @param xml
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T convertXml2Object(String xml, String encoding, Class<T> t) {
        try {
            StringReader reader = new StringReader(xml);
            return (T) createUnMarshaller(t.getClass(), encoding).unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param xml
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T convertXml2Object(String xml, Class<T> t) {
        try {
            StringReader reader = new StringReader(xml);
            return (T) createUnMarshaller(t, null).unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Xml->Java Object, 支持大小写敏感或不敏感.
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromXml(String xml, boolean caseSensitive, String encoding, Class<T> t) {
        try {
            String fromXml = xml;
            if (!caseSensitive)
                fromXml = xml.toLowerCase();
            StringReader reader = new StringReader(fromXml);
            return (T) createUnMarshaller(t, encoding).unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建Marshaller, 设定encoding(可为Null).
     */
    private static Marshaller createMarshaller(String encoding, Class clazz) {
        try {
            Marshaller marshaller = JAXBContext.newInstance(clazz).createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            if (!StringUtils.isEmpty(encoding)) {
                marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            }
            return marshaller;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建UnMarshaller.
     */
    private static Unmarshaller createUnMarshaller(Class c, String encoding) {
        try {
            Unmarshaller unmarshaller = JAXBContext.newInstance(c).createUnmarshaller();
            if (!StringUtils.isEmpty(encoding)) {
                unmarshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            }
            return unmarshaller;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 封装Root Element 是 Collection的情况.
     */
    public static class CollectionWrapper {
        @XmlAnyElement
        protected Collection collection;
    }

    /**
     * 输出xml
     */
    public static String   outxml( outputxml001 pojo){
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<output>\n" +
                "   <outidentity>\n" +
                "       <returnid>"+pojo.getReturnid()+"</returnid>\n" +
                "       <returnmsg>"+pojo.getReturnmsg()+"</returnmsg>\n" +
                "   </outidentity>\n" +
                "   <outbusinesscontent>\n" +
                "       <hisOrderId>"+pojo.getHisOrderId()+"</hisOrderId>\n" +
                "       <aac003>"+pojo.getAac003()+"</aac003> \n" +
                "       <aac002>"+pojo.getAac002()+"</aac002>\n" +
                "       <aka130>"+pojo.getAka130()+"</aka130> \n" +
                "       <akc193>"+pojo.getAkc193()+"</akc193>\n" +
                "       <bkc020>"+pojo.getBkc020()+"</bkc020> \n" +
                "       <disease>\n" +
                "           <row>\n" +
                "               <bkc014>"+pojo.getBkc014()+"</bkc014>\n" +
                "               <bkc117>"+pojo.getBkc117()+"</bkc117> \n" +
                "           </row>\n" +
                "       </disease>\n" +
                "       <bkc131>"+pojo.getBkc131()+"</bkc131> \n" +
                "       <aae030>"+pojo.getAae030()+"</aae030> \n" +
                "       <nums>"+pojo.getNums()+"</nums>\n"+
                "       <datarow>\n" +
                "           <row>\n" +
                "               <bke019>"+pojo.getBke019()+"</bke019>\n" +
                "               <bke030>"+pojo.getBke030()+"</bke030> \n" +
                "               <ake001>"+pojo.getAke001()+"</ake001>\n" +
                "               <ake002>"+pojo.getAke002()+"</ake002> \n" +
                "               <bke026>"+pojo.getBke026()+"</bke026>\n" +
                "               <bke027>"+pojo.getBke027()+"</bke027> \n" +
                "               <aka074_yn>"+pojo.getAka074_yn()+"</aka074_yn>\n" +
                "               <aka070_yn>"+pojo.getAka070_yn()+"</aka070_yn> \n" +
                "               <aka067_yn>"+pojo.getAka067_yn()+"</aka067_yn>\n" +
                "               <aka067>"+pojo.getAka067()+"</aka067>\n" +
                "               <akc226>"+pojo.getAkc226()+"</akc226>\n" +
                "               <akc225>"+pojo.getAkc225()+"</akc225>\n" +
                "               <akc264>"+pojo.getAkc264()+"</akc264>\n" +
                "               <bkc048>"+pojo.getBkc048()+"</bkc048>\n" +
                "               <bkc049>"+pojo.getBkc049()+"</bkc049>\n" +
                "               <aaz307>"+pojo.getAaz307()+"</aaz307>\n" +
                "               <aae386>"+pojo.getAae386()+"</aae386>\n" +
                "               <bkc045>"+pojo.getBkc045()+"</bkc045> \n" +
                "               <bkc044>"+pojo.getBkc044()+"</bkc044> \n" +
                "               <aka074>"+pojo.getAka074()+"</aka074>\n" +
                "               <yke112>"+pojo.getYke112()+"</yke112>\n" +
                "               <aae072>"+pojo.getAae072()+"</aae072>\n" +
                "               <aka017>"+pojo.getAka017()+"</aka017>\n" +
                "               <yke330>"+pojo.getYke330()+"</yke330>\n" +
                "               <xzyyspbz>"+pojo.getXzyyspbz()+"</xzyyspbz>\n" +
                "           </row>\n" +
                "       </datarow>\n" +
                "       <bkc033>\n" +
                "           <row>\n" +
                "               <bkc022>"+pojo.getBkc022()+"</bkc022>\n" +
                "               <akc076>"+pojo.getAkc076()+"</akc076>\n" +
                "           </row>\n" +
                "           <row>\n" +
                "               <bkc022>"+pojo.getBkc020()+"</bkc022>\n" +
                "               <akc076>"+pojo.getAkc076()+"</akc076>\n" +
                "           </row>\n" +
                "       </bkc033>\n" +
                "   </outbusinesscontent>\n" +
                "</output>\n";

        return  xml;
    }
}
