package reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IExtentTestClass;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;
import logger.LoggerTool;

import java.util.Date;

import static util.Constants.REPORT_FILE_PATH;

public class ReporterTool {
    public static ExtentReports extentReporter;
    public static ExtentTest extentTest;
    private static int numberOfStepInReport = 0;

    public static synchronized ExtentReports getExtentReporter() {
        if (extentReporter == null) {
            extentReporter = new ExtentReports(REPORT_FILE_PATH, true);
        }
        return extentReporter;
    }

    public static synchronized void startReporter() {
        extentReporter = null;
        extentTest = extentReporter.startTest("C65148_WorkflowBREOnline8020DEAllianzTest");
    }

    public static synchronized ExtentTest getExtentTest() {
        if (extentTest == null) {
            extentTest = new ExtentTest("C65148_WorkflowBREOnline8020DEAllianzTest", "Test Description");
        }
        return extentTest;
    }

    public void logTestStep(String stepName, String stepDescription) {
        String message = "<h5>" + stepName + ": " + stepDescription + "</h5>";
        extentTest.log(LogStatus.INFO, numberOfStepInReport + message);
        numberOfStepInReport++;
    }

    public void logTestSubStep(String stepDescription) {
        String message = "<h5>Test Sub Step " + stepDescription + "</h5>";
        extentTest.log(LogStatus.INFO, message);
    }

}
