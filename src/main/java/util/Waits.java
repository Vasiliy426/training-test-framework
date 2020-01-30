package util;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static util.Constants.TIMEOUT_IN_SECS_5;

public class Waits {

        public static void waitForJavaScriptReady() {
        boolean jsReady = (executeJavaScript("return document.readyState").equals("complete"));
        if (!jsReady) {
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), TIMEOUT_IN_SECS_5);
            ExpectedCondition<Boolean> jsLoad = (driver) -> {
                return (executeJavaScript("return document.readyState").equals("complete"));
            };
            wait.until(jsLoad);
        }
    }

    public static void waitForJQueryLoad() {
        boolean jqueryReady = executeJavaScript("return jQuery.active==0", new Object[0]);
        if (!jqueryReady) {
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), TIMEOUT_IN_SECS_5);
            ExpectedCondition<Boolean> jQueryLoad = (driver) -> {
                return (Long) executeJavaScript("return jQuery.active", new Object[0]) == 0L;
            };
            wait.until(jQueryLoad);
        }
    }
}
