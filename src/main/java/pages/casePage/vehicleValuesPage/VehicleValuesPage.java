package pages.casePage.vehicleValuesPage;

import com.codeborne.selenide.SelenideElement;
import logger.LoggerTool;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class VehicleValuesPage {

    private static SelenideElement vehicleValuesTab = $(By.xpath("//li[@data-block='BREForm_block.VehicleValuation']"));

    public VehicleValuationTab openVehicleValuationTab() {
        vehicleValuesTab.click();
        LoggerTool.logInfo("Switched to VehicleValuation tab.");
        return new VehicleValuationTab();
    }
}
