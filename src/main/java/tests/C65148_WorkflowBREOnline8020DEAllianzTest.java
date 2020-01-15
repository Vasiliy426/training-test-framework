package tests;

import browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavigationMenu;
import soap.SOAP;
import util.PropertyHandler;

import static com.codeborne.selenide.Selenide.open;
import static util.Constants.CASE_NAME;

public class C65148_WorkflowBREOnline8020DEAllianzTest extends BaseTest {

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
                "Upload of the attached Case TC_WorkflowOnline.xml",
                "The Case is successfully uploaded to the system.");
        SOAP.createCase(this.getClass().getSimpleName());
        loginPage.loginApp().openCase(CASE_NAME);

        logTestStep("Step 2",
                "Login as AllianzBRE-User allianz.sad.ralf@audatex.de / Pw: demo",
                "Verify, that the case still available on the Allianz-BRE-User OPEN LIST\n" +
                        "Check responsible User = Allianz.sad.ralf@audatex.de");

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        NavigationMenu navigationMenu = new NavigationMenu();
        navigationMenu.openWLG().deleteCase(CASE_NAME);
        Browser.quitWebDriver();
    }
}
