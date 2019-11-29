package browser;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.PropertyHandler;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class Browser {
    private RemoteWebDriver driver;
    private static final String REMOTE_WEBDRIVER_URL = PropertyHandler.getValue("hubURL");

    private void createRemoteWebDriverChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--incognito");

        Configuration.startMaximized = true;
        Configuration.reopenBrowserOnFail = true;

        try {
            driver = new RemoteWebDriver(new URL(REMOTE_WEBDRIVER_URL), chromeOptions);
            setWebDriver(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void quitWebDriver() {
        closeWebDriver();
    }
}
