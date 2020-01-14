package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.workListPage.OpenCasesTab;

import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu {

    private SelenideElement backBtn = $(By.id("backIcon"));

    public OpenCasesTab openWLG() {
        backBtn.click();
        return new OpenCasesTab();
    }

}
