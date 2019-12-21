package pages;

import com.codeborne.selenide.SelenideElement;
import data.Credentials;
import pages.workListPage.OpenCasesTab;
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

    public OpenCasesTab loginApp() {
        loginField.setValue(credentials.getUserName());
        pswField.setValue(credentials.getPassword());
        loginBtn.click();
        return new OpenCasesTab();
    }

}
