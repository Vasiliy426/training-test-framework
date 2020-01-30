package util;

import java.io.File;

public class Constants {

    public static final String CASE_NAME = "AX2018-11111115";
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String SEP = File.separator;
    public static final int TIMEOUT_IN_SECS_5 = 5;

    public static final String SOURCES_FOLDER = USER_DIR + SEP + "src" + SEP + "main" + SEP + "java";
    public static final String RESOURCES_FOLDER = USER_DIR + SEP + "src" + SEP + "main" + SEP + "resources";
    public static final String TEST_DATA_XML_FOLDER = RESOURCES_FOLDER + SEP + "test_data" + SEP + "xml" + SEP;
    public static final String FILES_DATA_FOLDER = RESOURCES_FOLDER + SEP + "test_data" + SEP + "files";

    public static final String USER_DATA_PATH = RESOURCES_FOLDER + SEP + "test_data" + SEP + "json" + SEP + "users" + SEP + "users.json";
    public static final String RAW_XML_PATH = RESOURCES_FOLDER + SEP + "test_data" + SEP + "xml" + SEP + "C65148_WorkflowBREOnline8020.xml";
    public static final String READY_XML_PATH = RESOURCES_FOLDER + SEP + "test_data" + SEP + "xml" + SEP + "C65148_WorkflowBREOnline8020_header_footer.xml";
    public static final String APP_PROPERTIES_PATH = RESOURCES_FOLDER + SEP + "test_properties" + SEP + "runner.properties";
    public static final String REPORT_FILE_PATH = SOURCES_FOLDER + SEP + "reporter" + SEP + "TestReport.html";
    public static final String EXTENTREPORTS_CONFIG_PATH =  RESOURCES_FOLDER + SEP + "extent-config.xml";
    public static final String LOG4J_CONFIG_PATH = RESOURCES_FOLDER + SEP + "log4j.xml";
    public static final String CAR_IMAGE_PATH = FILES_DATA_FOLDER + SEP + "car.jpeg";

    public static final String XML_OLD_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    public static final String XML_SOAP_HEADER =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
            "                  xmlns:ser=\"http://serviceinterface_v1.b2b.audatex.com\">\n" +
            "    <soapenv:Header/>\n" +
            "    <soapenv:Body>\n" +
            "        <ser:createTaskRequest>\n" +
            "            <ser:parameter xsltParameter=\"?\">\n" +
            "                <ser:name>loginId</ser:name>\n" +
            "                <ser:value>LOGIN</ser:value>\n" +
            "            </ser:parameter>\n" +
            "            <ser:parameter xsltParameter=\"?\">\n" +
            "                <ser:name>password</ser:name>\n" +
            "                <ser:value>PASSWORD</ser:value>\n" +
            "            </ser:parameter>\n" +
            "            <ser:payload>";
    public static final String XML_SOAP_FOOTER =
            "             </ser:payload>\n" +
            "        </ser:createTaskRequest>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>";

}
