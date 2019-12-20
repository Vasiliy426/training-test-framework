package listeners;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import reporter.ReporterTool;

public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ReporterTool.extentTest.log(LogStatus.INFO, "Test have started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReporterTool.extentTest.log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ReporterTool.extentTest.log(LogStatus.FAIL, "Test failed >>> "+ result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReporterTool.extentTest.log(LogStatus.SKIP, "Test skipped >>>" + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //stub
    }

    @Override
    public void onStart(ITestContext context) {
//        stub
    }

    @Override
    public void onFinish(ITestContext context) {
//        stub
    }
}
