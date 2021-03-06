package pages;

import com.codeborne.selenide.SelenideElement;
import logger.LoggerTool;
import org.openqa.selenium.By;
import pages.casePage.VehicleSearchPage;
import pages.casePage.assessmentPage.AssessmentPage;
import pages.casePage.calculationPage.CalculationPage;
import pages.casePage.combinedVehicleData.CombinedVehicleDataPage;
import pages.casePage.vehicleValuesPage.VehicleValuesPage;
import pages.workListPage.WorkListPage;

import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu {

    private static SelenideElement backBtn = $(By.id("backIcon"));
    private static SelenideElement calculationPageBtn = $(By.id("toDoListItem_Calculation"));
    private static SelenideElement assessmentPageBtn = $(By.id("toDoListItem_Assessment"));
    private static SelenideElement vehicleSearchPageBtn = $(By.id("icon_toDoListItem_VehicleSearch"));
    private static SelenideElement vehicleValuesPageBtn = $(By.id("toDoListItem_VehicleValues"));
    private static SelenideElement combinedVehicleDataPageBtn = $(By.id("toDoListItem_CombinedVehicleData"));

    public static WorkListPage openWorkListPage() {
        backBtn.click();
        LoggerTool.logInfo("Returned to WorkList Grid page.");
        return new WorkListPage();
    }

    public static CalculationPage openCalculationPage() {
        calculationPageBtn.click();
        LoggerTool.logInfo("Calculation page is opened.");
        return new CalculationPage();
    }

    public static AssessmentPage openAssessmentPage() {
        assessmentPageBtn.click();
        LoggerTool.logInfo("Assessment page is opened.");
        return new AssessmentPage();
    }

    public static VehicleSearchPage openVehicleSearchPage() {
        vehicleSearchPageBtn.click();
        LoggerTool.logInfo("Vehicle search page is opened.");
        return new VehicleSearchPage();
    }

    public static VehicleValuesPage openVehicleValuesPage() {
        vehicleValuesPageBtn.click();
        LoggerTool.logInfo("Vehicle values page is opened.");
        return new VehicleValuesPage();
    }

    public static CombinedVehicleDataPage openCombinedVehicleDataPage() {
        combinedVehicleDataPageBtn.click();
        LoggerTool.logInfo("CombinedVehicleData page is opened.");
        return new CombinedVehicleDataPage();
    }

}
