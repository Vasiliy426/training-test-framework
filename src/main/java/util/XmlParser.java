package util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
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

import static util.Constants.*;

public class XmlParser {
    private Document document = null;

    public void prepareXmlForSoap(String login, String password) {
        this.convertFileToDomDocument(RAW_XML_PATH)
                .addHeaderAndFooter(XML_SOAP_HEADER, XML_SOAP_FOOTER)
                .updateCredentials(login, password) //TODO get values from json
                .updateClaimNumber(new RandomClaimNumberGenerator().generate())
                .writeDomDocumentToFile(READY_XML_PATH);
    }

    private XmlParser convertFileToDomDocument(String pathToRawXml) {
        File rawXmlFile = new File(pathToRawXml);
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(rawXmlFile);
            document.getDocumentElement().normalize();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return this;
    }

    private XmlParser addHeaderAndFooter(String xmlHeader, String xmlFooter) {
        //TODO
        return this;
    }

    private XmlParser updateCredentials(String newLogin, String newPassword) {
        NodeList nodeList = document.getDocumentElement().getElementsByTagName("ser:value");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element credentialsDomElem = (Element) nodeList.item(i);
            String credentialsElemValue = credentialsDomElem.getNodeValue();
            if (credentialsElemValue.equals("LOGIN")) {
                credentialsDomElem.setNodeValue(newLogin);
                continue;
            }
            if (credentialsElemValue.equals("PASSWORD")) {
                credentialsDomElem.setNodeValue(newPassword);
                break;
            }
        }
        return this;
    }

    private XmlParser updateClaimNumber(String newClaimNumber) {
        NodeList nodeList = document.getDocumentElement().getElementsByTagName("ClaimNumber");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element claimNumberDomElem = (Element) nodeList.item(i);
            String claimNumberTadName = claimNumberDomElem.getTagName();
            if (claimNumberTadName.equals("ClaimNumber")) {
                claimNumberDomElem.setNodeValue(newClaimNumber);
                break;
            }
        }
        return this;
    }

    public static boolean taskIsUploaded(SOAPMessage soapMessage) {
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

    private void writeDomDocumentToFile(String pathToUpdatedXml) {
        document.getDocumentElement().normalize();
        Transformer transformer;
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(pathToUpdatedXml));
        try {
            transformer = transformerFactory.newTransformer();
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        // TODO add logger event
    }
}