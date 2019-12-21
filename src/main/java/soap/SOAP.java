package soap;

import org.apache.commons.compress.utils.IOUtils;
import util.PropertyHandler;
import util.XmlParser;

import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

import static util.Constants.TEST_XML_PATH;

public class SOAP {

    private static SOAPMessage createSOAPRequest(String strPath) throws Exception {

        FileInputStream fis = new FileInputStream(new File(strPath));
        MessageFactory factory = MessageFactory.newInstance();
        MimeHeaders header = new MimeHeaders();
        header.addHeader("Content-Type", "text/xml");
        SOAPMessage message = factory.createMessage(header, new ByteArrayInputStream(IOUtils.toByteArray(fis)));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        return message;
    }

    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.println("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }

    public static void createCase() {
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            String path = Objects.requireNonNull(PropertyHandler.class.getClassLoader().getResource(TEST_XML_PATH)).getPath();
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(path), PropertyHandler.getValue("soapURL"));

            if (!XmlParser.isTaskUploaded(soapResponse)) {
                throw new Exception("Task in not uploaded");
            }

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }

    }
}
