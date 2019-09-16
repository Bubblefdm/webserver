package com.stopec.gy.utils;
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
}
