package tests;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.casePage.VehicleSearch;
import pages.casePage.damageDataPage.CaseDataTab;
import pages.workListPage.OpenedCasesTab;
import soap.SOAP;
import util.PropertyHandler;
import util.RandomClaimNumberGenerator;

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

        logTestStep("Step 2",
                "Login as AllianzBRE-User allianz.sad.ralf@audatex.de / Pw: demo",
                "Verify, that the case still available on the Allianz-BRE-User OPEN LIST\n" +
                        "Check responsible User = Allianz.sad.ralf@audatex.de");
        loginPage.login().openCase(new RandomClaimNumberGenerator.generate()); //pass generated number here

        logTestStep("Step 3",
                "Click on the line of the new Case and open the Case.",
                "Verify, that the case is opened and the the tab DamageData / CaseData is displayed");
        CaseDataTab.getTabInstance().getTabName(); // verify tab name here

        logTestStep("Step 4",
                "For the VehicleIdentification open the Tile VehicleSearch",
                "Verify, that the Vehicle is identified via VIN-querry. All the VehicleData are displayed, e.g.");
        VehicleSearch.getTabInstance(). // some methods
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        Browser.quitWebDriver();
    }
}
