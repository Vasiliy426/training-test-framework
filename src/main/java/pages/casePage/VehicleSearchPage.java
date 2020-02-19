package pages.casePage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import util.Utils;

import static com.codeborne.selenide.Selenide.$;

public class VehicleSearchPage {

    private SelenideElement kbaReportBtn = $(By.id("BREForm_root.task.kbaReport.generate.kba.report"));

    public void downloadKBAReport() {
        kbaReportBtn.click();
        Utils.downloadFile();
    }

}
