package pages;

import com.codeborne.selenide.SelenideElement;
import logger.LoggerTool;
import org.openqa.selenium.By;
import pages.casePage.assessmentPage.AssessmentPage;
import pages.casePage.calculationPage.CalculationPage;
import pages.workListPage.WorkListPage;

import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu {

    private static SelenideElement backBtn = $(By.id("backIcon"));
    private static SelenideElement calculationPageBtn = $(By.id("toDoListItem_Calculation"));
    private static SelenideElement assessmentPageBtn = $(By.id("toDoListItem_Assessment"));

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

}
