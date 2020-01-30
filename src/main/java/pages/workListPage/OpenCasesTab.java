package pages.workListPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import exceptions.TestFrameworkException;
import logger.LoggerTool;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static util.Waits.*;

public class OpenCasesTab {

    private ElementsCollection casesNumbersList = $$(By.cssSelector("[aria-describedby='claimNumber']"));
    private ElementsCollection searchResultsTable = $$(By.xpath("//table[@class='bordered highlight fht-table fht-table-init']/tbody//tr"));
    private SelenideElement selectCaseElement = $(By.cssSelector("[for='cb0']"));
    private SelenideElement deleteBtn = $(By.xpath("//i[text()='delete']"));
    private SelenideElement searchField = $(By.id("quickfilter.searchbox"));


    public OpenCasesTab searchCaseByNumber(String caseNumber) {
        LoggerTool.logInfo("Searching case with number " + caseNumber + "...");
        searchField.sendKeys(caseNumber);
        waitForJavaScriptReady();
        waitForJQueryLoad();
        return this;
    }

    public void openFirstCaseFromSearchResults() throws TestFrameworkException{
        if (!searchResultsTable.isEmpty()) {
            searchResultsTable.first().click();
            LoggerTool.logInfo("First search result from results grid was chosen.");
            return;
        }
        LoggerTool.logError("Results grid is empty.");
        throw new TestFrameworkException();
    }

    public void deleteCase(String caseNumber) {
        selectCaseElement.click();
        deleteBtn.click();
        confirm();
        LoggerTool.logInfo("Case with number " + caseNumber + " was deleted.");
    }
}
