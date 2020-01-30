package tests;

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
    private QapterPage qapterPage;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        LoggerTool.logSetUp();
        open(PropertyHandler.getValue("appURL"));
        loginPage = new LoginPage();
        qapterPage = new QapterPage();
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
                "Click on the Tab 'DamageCapturing'\n Click the button 'Qapter starten'",
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
        qapterPage.openModelOptionsTab()
                .clickLeftMenuMotorOption()
                .verifyCheckedElementsHaveRightValues();

        logTestStep("Step 19",
                "On the displayed 'Navigation Vehicle' click on the zone 'Karosserie vorn aussen' for the DamageCapturing.\n" +
                        "Capturing of some parts with the RepairMethod E.\n" +
                        "All captured parts are also displayed in the Checklist as 'Standard Positions'",
                "Verify, that in the Grafic the selected parts are marked as red \n" +
                        "Check that all captured parts are available and displayed as 'Standard Positions'");
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
        NavigationMenu.openWorkListPage()
                .openOpenCasesTab()
                .searchCaseByNumber(CASE_NAME)
                .deleteCase(CASE_NAME);
        // todo delete case via b2b (requires taskID(from URL) + creds)
    }
}
