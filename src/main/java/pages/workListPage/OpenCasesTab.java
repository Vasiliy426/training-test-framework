package pages.workListPage;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class OpenCasesTab {
    private static ElementsCollection casesNumbersList = $$(By.cssSelector("[aria-describedby='claimNumber']"));

    public void openCase(String caseNumber) {
        System.out.println(casesNumbersList.size());
        casesNumbersList.findBy(text(caseNumber)).click();
    }
}
