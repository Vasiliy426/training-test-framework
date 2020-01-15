package util;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Waits {

    public static void waitForJavaScriptReady() {
        boolean jsReady = (executeJavaScript("return document.readyState").equals("complete"));
        if (!jsReady) {
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
            ExpectedCondition<Boolean> jsLoad = (driver) -> {
                return (executeJavaScript("return document.readyState").equals("complete"));
            };
            wait.until(jsLoad);
        }
    }

}
