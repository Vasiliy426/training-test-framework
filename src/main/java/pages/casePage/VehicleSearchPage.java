package pages.casePage;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class VehicleSearchPage {

    private SelenideElement kbaReportBtn = $(By.id("BREForm_root.task.kbaReport.generate.kba.report"));

    public void downloadKBAReport() {
        kbaReportBtn.click();
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
