package util;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.WebDriverRunner;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class Utils {

    public static PDF downloadFile() {
        PDF pdf = null;
        switchTo().window(1);
        try {
            pdf = new PDF(download(WebDriverRunner.url()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        executeJavaScript("window.close();");
        switchTo().window(0);
        return pdf;
    }

}
