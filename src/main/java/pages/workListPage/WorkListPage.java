package pages.workListPage;

import com.codeborne.selenide.SelenideElement;
import data.Credentials;
import junit.framework.Assert;
import logger.LoggerTool;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WorkListPage {

    private SelenideElement openCasesTab = $(By.id("worklistgrid_custom_open"));
    private SelenideElement userNameElement = $(By.className("username"));

    public OpenCasesTab openOpenCasesTab() {
        openCasesTab.click();
        LoggerTool.logInfo("Switched to OpenCases tab.");
        return new OpenCasesTab();
    }

    public WorkListPage checkUser(Credentials credentials) {
        LoggerTool.logInfo("Checking equality of usernames from credentials and from Worklist page ...");
        String userNameFromCredentials = credentials.getUserName();
        String userNameFromPage = userNameElement.getText();
        Assert.assertEquals(userNameFromCredentials, userNameFromPage);
        LoggerTool.logInfo("Usernames are the same.");
        return this;
    }
}
