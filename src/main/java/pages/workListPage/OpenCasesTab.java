package pages.workListPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OpenCasesTab {

    private ElementsCollection casesNumbersList = $$(By.cssSelector("[aria-describedby='claimNumber']"));
    private SelenideElement selectCaseElement = $(By.cssSelector("[for='cb0']"));
    private SelenideElement deleteBtn = $(By.xpath("//i[text()='delete']"));

    public void openCase(String caseNumber) {
        casesNumbersList.findBy(text(caseNumber)).click();
    }

    public void deleteCase(String caseNumber) {
        //add searching case
        selectCaseElement.click();
        deleteBtn.click();
        confirm();
    }
}
