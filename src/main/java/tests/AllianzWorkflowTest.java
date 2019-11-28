package tests;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import util.PropertyHandler;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class AllianzWorkflowTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        driver = Browser.getUserCreatedWebDriver();
        setWebDriver(driver);
        open(PropertyHandler.getValue("appURL"));
        loginPage = new LoginPage();
    }

    @Test
    public void c65148_WorkflowBREOnline8020() {
        loginPage.loginApp();
        //just to test that it works
        System.out.println("works");
        sleep(5000);

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        Browser.quitWebDriver();
    }
}
