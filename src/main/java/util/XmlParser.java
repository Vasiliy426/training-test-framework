package util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static util.Constants.*;

public class XmlParser {
    private Document domDocument = null;
    private String xmlDocumentAsString;
    public static String randomClaimNumber = new RandomClaimNumberGenerator().generate();

    public static boolean isTaskUploaded(SOAPMessage soapMessage) {
        SOAPBody soapBody = null;
        try {
            soapBody = soapMessage.getSOAPBody();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        NodeList nodes = soapBody.getElementsByTagName("messageCode");
        Node code = (Node) nodes.item(0).getFirstChild();
        if (code.getNodeValue().equals("TaskUpload.OK")) {
            return true;
        }
        return false;
    }

    public void prepareXmlForSoap(String login, String password) {
        this.convertFileToDomDocument(RAW_XML_PATH)
                .convertDomDocumentToString()
                .addHeaderAndFooter(XML_SOAP_HEADER, XML_SOAP_FOOTER)
                .updateCredentials(login, password) //TODO get values from json
                .updateClaimNumber(randomClaimNumber)
                .writeDomDocumentToFile(READY_XML_PATH);
    }

    private XmlParser convertFileToDomDocument(String pathToRawXml) {
        File rawXmlFile = new File(pathToRawXml);
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            domDocument = dBuilder.parse(rawXmlFile);
            domDocument.getDocumentElement().normalize();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return this;
    }

    private XmlParser convertDomDocumentToString() {
        try {
            DOMSource domSource = new DOMSource(domDocument);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            String xmlDocumentAsString = writer.toString().replaceAll("\n|\r", "");
        } catch (Exception e) {
            throw new RuntimeException("Error converting to String", e);
        }
        return this;
    }

    private XmlParser addHeaderAndFooter(String xmlHeader, String xmlFooter) {
        xmlDocumentAsString = xmlDocumentAsString.replace(XML_OLD_HEADER, XML_SOAP_HEADER);
        xmlDocumentAsString = xmlDocumentAsString + XML_SOAP_FOOTER;
        return this;
    }

    private XmlParser updateCredentials(String newLogin, String newPassword) {
        xmlDocumentAsString = xmlDocumentAsString
                .replace("LOGIN", newLogin)
                .replace("PASSWORD", newPassword);
        return this;
    }

    private XmlParser updateClaimNumber(String newClaimNumber) {
        xmlDocumentAsString = xmlDocumentAsString.replace("ClaimNumber", newClaimNumber);
        return this;
    }

    private void writeDomDocumentToFile(String pathToUpdatedXml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new InputSource(new StringReader(pathToUpdatedXml)));
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        // TODO add logger event
    }
}
