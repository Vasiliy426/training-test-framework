package reporter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;

import static util.Constants.REPORT_FILE_PATH;

public class Reporter {
    public static ExtentReports extentReporter;
    public static ExtentTest extentTest;

    public static synchronized void startReporter() {
        ExtentReports extentReporter = null
        extentTest = extentReporter.startTest("SearchForConcreteCarTest");
    }

    public static synchronized ExtentReports getExtentReporter() { //lazy initialization
        if (extentReporter.get() == null) {
            extentReporter = new ExtentReports(REPORT_FILE_PATH);
        }
        return extentReporter;
    }

    public static synchronized ExtentTest getExtentTest() {
        return extentTest;
    }

    public static ThreadLocal getExtent() {
        if (extent.get() == null) {
            extent.set(TestSuiteReport.getSuiteReport());
        }
        return extent;
    }



    public void logTestStep(String stepName, String stepDescription) {
        String message = "<h5>" + stepName + ": " + stepDescription + "</h5>";
        TestSuiteManager.getTest().log(LogStatus.INFO, message);
        putStep(message);
        LoggingUtils.logBold(stepName + ": " + stepDescription);
        countOfCall++;
    }

    public void logTestSubStep(String stepDescription) {
        String message = "<h5>Test Sub Step " + stepDescription + "</h5>";
        TestSuiteManager.getTest().log(LogStatus.INFO, message);
        putStep(message);
    }
}
