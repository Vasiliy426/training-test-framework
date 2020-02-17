package pages.casePage.combinedVehicleData;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TechnicalDataTab {

    private SelenideElement readMileageSourceRadioBtn = $(By.xpath("//label[@for='BREForm_root.task.basicClaimData.vehicle.vehicleEngineering.mileageSource_Read']"));

    public void selectReadMileageSource() {
        readMileageSourceRadioBtn.click();
    }
}