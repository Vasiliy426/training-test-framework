package tests;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import soap.SOAP;
import util.PropertyHandler;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class C65148_WorkflowBREOnline8020DEAllianzTest extends BaseTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        Browser browser =  new Browser();
        browser.createRemoteWebDriverChrome();
        open(PropertyHandler.getValue("appURL"));
        loginPage = new LoginPage();
    }

    @Test
    public void c65148_WorkflowBREOnline8020DEAllianzTest() {
        logTestStep("Step 1",
                "Upload of the attached Case TC_WorkflowOnline.xml (Use SokraTest)",
                "The Case is successfully uploaded to the User.");
        SOAP.createCase();
        loginPage.loginApp().openCase(util.XmlParser.randomClaimNumber);
        //just to test that it works
        System.out.println("works");
        sleep(5000);

        logTestStep("Step 2",
                "Login as AllianzBRE-User allianz.sad.ralf@audatex.de / Pw: demo",
                "Verify, that the case still available on the Allianz-BRE-User OPEN LIST\n" +
                        "Check responsible User = Allianz.sad.ralf@audatex.de");

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        Browser.quitWebDriver();
    }
}
