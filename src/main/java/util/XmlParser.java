package util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import static util.Constants.RAW_XML_PATH;
import static util.Constants.READY_XML_PATH;
import static util.Constants.XML_SOAP_FOOTER;
import static util.Constants.XML_SOAP_HEADER;

public class XmlParser {
    private Document document = null;

    public void prepareXmlForSoap() {
        this.convertFileToDomDocument(RAW_XML_PATH)
                .addHeaderAndFooter(XML_SOAP_HEADER, XML_SOAP_FOOTER)
                .updateCredentials(LOGIN, PASSWORD) //TODO get values from json
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