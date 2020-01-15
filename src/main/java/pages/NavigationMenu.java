package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.casePage.calculationPage.CalculationPage;
import pages.workListPage.WorkListPage;

import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu {

    private static SelenideElement backBtn = $(By.id("backIcon"));
    private static SelenideElement calculationPageBtn = $(By.id("toDoListItem_Calculation"));

    public static WorkListPage openWorkListPage() {
        backBtn.click();
        return new WorkListPage();
    }

    public static CalculationPage openCalculationPage() {
        calculationPageBtn.click();
        return new CalculationPage();
    }

}
