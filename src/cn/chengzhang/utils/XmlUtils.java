package cn.chengzhang.utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.FileOutputStream;
import java.io.IOException;

import static javax.xml.parsers.DocumentBuilderFactory.newInstance;

/**
 * Created by chen on 07/07/2017.
 */
public class XmlUtils {

    private static String filename = "src/exam.xml";

    public static Document getDocument() throws Exception {

        DocumentBuilderFactory factory = newInstance();
       DocumentBuilder builder= factory.newDocumentBuilder();
       return builder.parse(filename);
    }

    public static void write2Xml(Document document) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer tf =factory.newTransformer();
        tf.transform(new DOMSource(document),new StreamResult(new FileOutputStream(filename)));
    }
}
