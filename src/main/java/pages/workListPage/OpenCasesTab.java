package pages.workListPage;

import browser.Browser;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import exceptions.TestFrameworkException;
import logger.LoggerTool;
import org.openqa.selenium.By;
import pages.casePage.CasePageGeneral;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static util.Waits.waitForJavaScriptReady;

public class OpenCasesTab {

    private ElementsCollection casesNumbersList = $$(By.cssSelector("[aria-describedby='claimNumber']"));
    private ElementsCollection searchResultsTable = $$(By.xpath("//table[@class='bordered highlight fht-table fht-table-init']/tbody//tr"));
    private SelenideElement selectCaseElement = $(By.cssSelector("[for='cb0']"));
    private SelenideElement deleteBtn = $(By.xpath("//i[text()='delete']"));
    private SelenideElement searchBtn = $(By.id("tbSearch"));
    private String searchIFrameName = "taskActionFrame";
    private SelenideElement claimNumberFieldOnSearchWindow = $(By.id("BREForm_root.wfGrid.workList.search.claimNumber"));
    private SelenideElement searchWindow = $(By.xpath("//div[@class='container_16']"));

    public OpenCasesTab searchCaseByNumber(String caseNumber) {
        LoggerTool.logInfo("Searching case with number " + caseNumber + " ...");
        searchBtn.click();
        Browser.getWebdriver().switchTo().frame(searchIFrameName);
        claimNumberFieldOnSearchWindow
                .waitUntil(visible, 2000)
                .setValue(caseNumber)
                .pressEnter();
        searchWindow.shouldNotBe(visible);
        switchTo().defaultContent();
        return this;
    }

    public void openFirstCaseFromSearchResults() throws TestFrameworkException{
        waitForJavaScriptReady();
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
        LoggerTool.logWarning("Case with number " + caseNumber + " was deleted.");
    }
}
