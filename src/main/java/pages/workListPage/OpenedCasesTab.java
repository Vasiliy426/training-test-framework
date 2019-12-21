package pages.workListPage;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class OpenedCasesTab {
    private static OpenedCasesTab openedCasesTab = null;
    private static ElementsCollection casesNumbersList = $$(By.cssSelector("[aria-describedby='claimNumber']"));

    private OpenedCasesTab() {}

    public static OpenedCasesTab getTabInstance(){
        if(openedCasesTab == null){
            openedCasesTab = new OpenedCasesTab();
        }
        return openedCasesTab;
    }

    public static void openCase(String caseNumber) {
        System.out.println(casesNumbersList.size());
        casesNumbersList.findBy(text(caseNumber)).click();
    }
}
