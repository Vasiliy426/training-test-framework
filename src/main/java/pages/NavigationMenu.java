package pages;

import com.codeborne.selenide.SelenideElement;
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
        return new WorkListPage();
    }

    public static CalculationPage openCalculationPage() {
        calculationPageBtn.click();
        return new CalculationPage();
    }

    public static AssessmentPage openAssessmentPage() {
        assessmentPageBtn.click();
        return new AssessmentPage();
    }

}
