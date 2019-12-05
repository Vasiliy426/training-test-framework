package util;

public class Constants {
    public static final String REPORT_FILE_PATH = "reporter/results.html";
    public static final String USER_DATA_PATH = "test_data/json/users/users.json";
    public static final String RAW_XML_PATH = "test_data/xml/C65148_WorkflowBREOnline8020.xml";
    public static final String READY_XML_PATH = "test_data/xml/C65148_WorkflowBREOnline8020_header_footer.xml";
    public static final String APP_PROPERTIES_PATH = "test_properties/runner.properties";
    public static final String LOG4J_CONFIG_PATH = "properties/log4j.xml";

    public static final String XML_SOAP_HEADER =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
            "                  xmlns:ser=\"http://serviceinterface_v1.b2b.audatex.com\">\n" +
            "    <soapenv:Header/>\n" +
            "    <soapenv:Body>\n" +
            "        <ser:createTaskRequest>\n" +
            "            <!--Zero or more repetitions:-->\n" +
            "            <ser:parameter xsltParameter=\"?\">\n" +
            "                <ser:name>loginId</ser:name>\n" +
            "                <ser:value>LOGIN</ser:value>\n" +
            "            </ser:parameter>\n" +
            "            <ser:parameter xsltParameter=\"?\">\n" +
            "                <ser:name>password</ser:name>\n" +
            "                <ser:value>PASSWORD</ser:value>\n" +
            "            </ser:parameter>\n" +
            "            <!--Optional:-->\n" +
            "            <ser:payload>";

    public static final String XML_SOAP_FOOTER =
            "             </ser:payload>\n" +
            "        </ser:createTaskRequest>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";

}
