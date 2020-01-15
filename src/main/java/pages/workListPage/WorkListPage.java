package pages.workListPage;

import com.codeborne.selenide.SelenideElement;
import data.Credentials;
import junit.framework.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WorkListPage {

    private SelenideElement openCasesTab = $(By.id("worklistgrid_custom_open"));
    private SelenideElement userNameElement = $(By.className("username"));

    public OpenCasesTab openOpenCasesTab() {
        openCasesTab.click();
        return new OpenCasesTab();
    }

    public WorkListPage checkUser(Credentials credentials) {
        String usernameFromCreds = credentials.getUserName();
        // usernme == email,
        String usernameFromPage = userNameElement.getValue();
        Assert.assertEquals(usernameFromCreds, usernameFromPage);
        return this;
    }
}
