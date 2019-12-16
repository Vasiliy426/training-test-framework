package pages.casePage.damageDataPage;

import org.openqa.selenium.By;
import pages.workListPage.OpenedCasesTab;

import static com.codeborne.selenide.Selenide.$;

public class CaseDataTab {
    private static CaseDataTab caseDataTab;

    private CaseDataTab() {}

    public static CaseDataTab getTabInstance(){
        if(caseDataTab == null){
            caseDataTab = new CaseDataTab();
        }
        return caseDataTab;
    }

    public String getTabName(CaseDataTab this) {
        return $(By.xpath("//li[@class='tab-active'//a")).getText();
    }
}
