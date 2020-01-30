package reporter;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static util.Constants.*;

public class ReporterTool {

    private static ExtentReports extentReporter;
    private static ExtentTest extentTest;

    public static synchronized ExtentReports getExtentReporter() {
        if (extentReporter == null) {
            extentReporter = new ExtentReports(REPORT_FILE_PATH, true, DisplayOrder.OLDEST_FIRST);
        }
        return extentReporter;
    }

    public static synchronized ExtentTest getExtentTest() {
        if (extentTest == null) {
            extentTest = new ExtentTest("C65148_WorkflowBREOnline8020DEAllianzTest", "Test Description");
        }
        return extentTest;
    }

    public static synchronized void startTest(String testName, String testDescription) {
        getExtentReporter().loadConfig(ExtentReports.class, EXTENTREPORTS_CONFIG_PATH);
        extentTest = getExtentReporter().startTest(testName, testDescription);
    }

    public static void reportTestStepHeader(String stepDescription) {
        String message = "<h5>" + stepDescription + "</h5>";
        extentTest.log(LogStatus.INFO, message);
    }

    public static void reportInfo(String stepDescription) {
        String message = "<h6>" + stepDescription + "</h6>";
        extentTest.log(LogStatus.INFO, message);
    }

    public static void reportTestPassed(String stepDescription) {
        String message = "<h6>" + stepDescription + "</h6>";
        extentTest.log(LogStatus.PASS, message);
    }

    public static void reportTestFailed(String stepDescription) {
        String message = "<h6>" + stepDescription + "</h6>";
        extentTest.log(LogStatus.FAIL, message);
    }

    public static void reportWarning(String stepDescription) {
        String message = "<h6>" + stepDescription + "</h6>";
        extentTest.log(LogStatus.WARNING, message);
    }

    public static void reportError(String stepDescription) {
        String message = "<h6>" + stepDescription + "</h6>";
        extentTest.log(LogStatus.ERROR, message);
    }

    public static void logHtmlLink(String stepDescription, String htmlLink) {
        String message = stepDescription + " <h6><a href=\"" + htmlLink + "\"></h6>" + htmlLink;
        extentTest.log(LogStatus.INFO, message);
    }
}
