package listeners;

import com.codeborne.selenide.WebDriverRunner;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {
    private long suiteExecClearTime = 0L;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        //stub
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(LogStatus.PASS, "Test passed");
        suiteExecClearTime += result.getEndMillis() - result.getStartMillis();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.getExtentTest.log(LogStatus.FAIL, "Test failed >>> "+ result.getThrowable());
        suiteExecClearTime += result.getEndMillis() - result.getStartMillis();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.getExtentTest.log(LogStatus.SKIP, "Test skipped >>>" + result.getThrowable());
        suiteExecClearTime += result.getEndMillis() - result.getStartMillis();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //stub
    }

    @Override
    public void onStart(ITestContext context) {
        int testMethodsCount = context.getAllTestMethods().length;
    }

    @Override
    public void onFinish(ITestContext context) {
        float suiteExecClearTimeSecs = convertMillisToDecimalSeconds(suiteExecClearTime);
    }

    private float convertMillisToDecimalSeconds(long millis) {
        return millis / 1000.0f;
    }
}
