package pages.casePage.damageDataPage;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CaseDataTab {

    public String getTabName(CaseDataTab this) {
        return $(By.xpath("//li[@class='tab-active'//a")).getText();
    }
}
