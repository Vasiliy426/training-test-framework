package pages;

import com.codeborne.selenide.SelenideElement;
import data.Credentials;
import logger.LoggerTool;
import pages.workListPage.WorkListPage;
import util.JsonHandler;

import static com.codeborne.selenide.Selenide.$;
import static util.Constants.USER_DATA_PATH;

public class LoginPage {

    private Credentials credentials;
    private SelenideElement loginField = $("#ssousername");
    private SelenideElement pswField = $("#password");
    private SelenideElement loginBtn = $(".btn-submit");

    public LoginPage() {
        credentials = JsonHandler.fromStringToObject(USER_DATA_PATH, Credentials.class);
    }

    public WorkListPage loginApp() {
        loginField.setValue(credentials.getLogin());
        pswField.setValue(credentials.getPassword());
        loginBtn.click();
        LoggerTool.logInfo("Signed in with login: " + credentials.getLogin() + " and password: " + credentials.getPassword());
        return new WorkListPage();
    }

    public Credentials getCredentials() {
        return credentials;
    }
}
