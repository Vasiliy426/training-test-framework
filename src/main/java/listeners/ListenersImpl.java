package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static reporter.ReporterTool.*;

public class ListenersImpl implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        reportInfo("Test have started.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        reportTestPassed("TEST PASSED.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        reportTestFailed("TEST FAILED: "+ result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        reportWarning("TEST SKIPPED: " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        stub
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
