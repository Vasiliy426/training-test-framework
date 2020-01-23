package tests;

import browser.Browser;
import logger.LoggerTool;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavigationMenu;
import pages.qapterPage.QapterPage;
import soap.SOAP;
import util.PropertyHandler;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static util.Constants.CASE_NAME;

public class C65148_WorkflowBREOnline8020DEAllianzTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        LoggerTool.logSetUp();
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

        logTestStep("Step 2",
                "Login as AllianzBRE-User allianz.sad.ralf@audatex.de / Pw: demo",
                "Verify, that the case still available on the Allianz-BRE-User OPEN LIST\n" +
                        "Check responsible User = Allianz.sad.ralf@audatex.de");
        loginPage.loginApp()
                .checkUser(loginPage.getCredentials())
                .openOpenCasesTab()
                .searchCaseByNumber(CASE_NAME)
                .openFirstCaseFromSearchResults();

        NavigationMenu.openVehicleSearchPage()
                .downloadKBAReport();

        logTestStep("Step 17",
                "Click on the Tab 'DamageCapturing'\n" +
                        "Click the button 'Qapter starten'",
                "Verfiy, that Onepad is opened.");
        NavigationMenu
                .openCalculationPage()
                .openOnePadQapterTab()
                .openQapter();


        logTestStep("Step 18",
                "Click on the Button 'ModelOptions' and in left menu select motor/getriebe" +
                        "All existing VehicleData and the selected ModelOptions are available" +
                        "go back to car overview",
                "Model options tab with appropriate data is opened\n" +
                        "Check, if following data are available:\n" +
                        "- The before identified and captured VehicleData\n" +
                        "- the selected ModelOptions");
        QapterPage qapterPage = new QapterPage()
                .openModelOptionsTab()
                .clickLeftMenuMotorOption()
                .verifyCheckedElementsHaveRightValues();

        qapterPage.openCar3DViewTab()
                .addDamageForHood()
                .checkDamagesChecklist();

//        NavigationMenu.openAssessmentPage()
//                .openAttachmentsTab()
//                .selectCategoryListValue("EKAS")
//                .uploadFile(CAR_IMAGE_PATH);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        switchTo().window(0);
        NavigationMenu
                .openWorkListPage()
                .openOpenCasesTab()
                .searchCaseByNumber(CASE_NAME)
                .deleteCase(CASE_NAME);
        Browser.quitWebDriver();
    }
}
