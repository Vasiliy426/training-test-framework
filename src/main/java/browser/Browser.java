package browser;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class Browser {
    private static RemoteWebDriver newRemoteWebDriverChrome;
    private static final String REMOTE_WEBDRIVER_URL = "http://localhost:5555/wd/hub";

    private static void createRemoteWebDriverChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--incognito");

        Configuration.startMaximized = true;
        Configuration.reopenBrowserOnFail = true;

        try {
            newRemoteWebDriverChrome = new RemoteWebDriver(new URL(REMOTE_WEBDRIVER_URL), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getUserCreatedWebDriver() {
        createRemoteWebDriverChrome();
        return newRemoteWebDriverChrome;
    }

    public static void quitWebDriver() {
        closeWebDriver();
    }

}
