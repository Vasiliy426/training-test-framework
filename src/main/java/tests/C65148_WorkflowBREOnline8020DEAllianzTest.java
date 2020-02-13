package tests;

import logger.LoggerTool;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavigationMenu;
import pages.casePage.vehicleValuesPage.VehicleValuationTab;
import pages.qapterPage.QapterPage;
import soap.SOAP;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static util.Constants.CASE_NAME;

public class C65148_WorkflowBREOnline8020DEAllianzTest extends BaseTest {

    private LoginPage loginPage;
    private QapterPage qapterPage;
    private VehicleValuationTab vehicleValuationTab;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        LoggerTool.logSetUp();
        open(System.getProperty("appURL"));
        loginPage = new LoginPage();
        qapterPage = new QapterPage();
        vehicleValuationTab = new VehicleValuationTab();
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

        logTestStep("Step 17",
                "Click on the Tab 'DamageCapturing'\n Click the button 'Qapter starten'",
                "Verfiy, that Onepad is opened.");
        NavigationMenu
                .openCalculationPage()
                .openOnePadQapterTab()
                .openQapter();

        logTestStep("Step 27",
                "Open the Tab VehicleValuation.",
                "Verify, that the Tab VehicleValuation is opened.\n" +
                "Check, that followin data is available:\n" +
                "- the Valuation date (should be the same as the Accident Date / should be taken over automatically)\n" +
                "- the ValueCode '933 Wiederbeschaffungswert m. MwSt' is selected as default\n" +
                "- In the section results the result from the ShortValuation should be displayed\n" +
                "- another data are not exists in the tab VehicleValuation" );
        NavigationMenu.openVehicleValuesPage().
                openVehicleValuationTab()
                .verifyValueCodeValue("933 Wiederbeschaffungswert m. MwSt")
                .verifyAccidentDate();
        // In the section results the result from the ShortValuation should be displayed - was not done - dependency from Vasiliy

        logTestStep("Step 28",
                "Click on the Button Valuation.",
                "Verify, that the creating of the Valuation is started.\n" +
                        "Verify, that the result of the Valuation is displayed\n" +
                        "Verify, that now a button 'Bewertung anzeigen' is available" );
        NavigationMenu.openCombinedVehicleDataPage()
                .openTechnicalDataTab()
                .selectReadMileageSource(); //was needed to create valuation (related to step12)
        NavigationMenu.openVehicleValuesPage()
                .openVehicleValuationTab()
                .createValuation();

        logTestStep("Step 29",
                "For the display of the created Valuation, click on the button 'Bewertung anzeigen'\n" +
                "After Display of the Valuation, close the popup with a click on 'X'",
                "Verify, that a Popup is opened with the displayed VehicleValuation\n" +
                        "Verify, that the Results are displayed, e.g. Grundwert" );
        vehicleValuationTab.downloadAndCheckValuationFile();

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
