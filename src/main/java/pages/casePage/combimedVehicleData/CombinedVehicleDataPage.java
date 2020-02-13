package pages.casePage.combimedVehicleData;

import com.codeborne.selenide.SelenideElement;
import logger.LoggerTool;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CombinedVehicleDataPage {

    private static SelenideElement technicalDataTab = $(By.xpath("//li[@data-block='BREForm_block.TechnicalData']"));

    public TechnicalDataTab openTechnicalDataTab() {
        technicalDataTab.click();
        LoggerTool.logInfo("Switched to TechnicalData tab.");
        return new TechnicalDataTab();
    }

}
