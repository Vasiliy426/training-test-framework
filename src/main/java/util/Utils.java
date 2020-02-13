package util;

import com.codeborne.selenide.WebDriverRunner;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class Utils {

    public static void downloadFile() {
        switchTo().window(1);
        try {
            download(WebDriverRunner.url());
        } catch (IOException e) {
            e.printStackTrace();
        }
        executeJavaScript("window.close();");
        switchTo().window(0);
    }

}
