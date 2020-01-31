package tests;

import browser.Browser;
import com.codeborne.selenide.WebDriverRunner;
import listeners.ListenersImpl;
import logger.LoggerTool;
import org.testng.annotations.*;
import reporter.ReporterTool;
import util.PropertyHandler;

import java.lang.reflect.Method;

@Listeners({ListenersImpl.class})
public class BaseTest {

    public void logTestStep(String stepName, String stepActionsToPerform, String stepExpectedResults) {
        LoggerTool.logTestStep(stepName + ": \n" + stepActionsToPerform + "\n" + stepExpectedResults);
    }

    @BeforeSuite
    public void beforeSuite() {
        PropertyHandler.readProperties();
        Browser browser = new Browser();
        browser.createRemoteWebDriverChrome();
    }

    @BeforeMethod
    protected void beforeMethod(Method method) {
        ReporterTool.startTest(method.getName(), "Report for test method: " + method.getName());
    }

    @AfterMethod
    public void afterMethod() {
        ReporterTool.getExtentReporter().endTest(ReporterTool.getExtentTest());
        ReporterTool.getExtentReporter().flush();
        ReporterTool.getExtentReporter().close();
    }

    @AfterSuite
    public void afterSuite() {
        Browser.quitWebDriver();
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }
}
