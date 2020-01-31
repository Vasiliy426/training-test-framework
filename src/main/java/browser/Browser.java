package browser;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class Browser {
    private static RemoteWebDriver driver;
    private static final String REMOTE_WEBDRIVER_URL = System.getProperty("hubURL");

    public void createRemoteWebDriverChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--lang=de");

        Configuration.startMaximized = true;
        Configuration.reopenBrowserOnFail = true;
        Configuration.timeout = Long.parseLong(System.getProperty("selenide.timeout"));
        Configuration.collectionsTimeout = Long.parseLong(System.getProperty("collections.timeout"));

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
