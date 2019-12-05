package pages;

import com.codeborne.selenide.SelenideElement;
import data.Credentials;
import util.DataHandler;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private Credentials credentials;
    private SelenideElement loginField = $("#ssousername");
    private SelenideElement pswField = $("#password");
    private SelenideElement loginBtn = $(".btn-submit");

    public LoginPage() {
        credentials = DataHandler.getCredentials();
    }

    public WLGPage loginApp() {
        loginField.setValue(credentials.getUserName());
        pswField.setValue(credentials.getPassword());
        loginBtn.click();
        return new WLGPage();
    }

}
