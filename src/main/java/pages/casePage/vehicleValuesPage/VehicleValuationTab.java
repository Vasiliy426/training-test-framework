package pages.casePage.vehicleValuesPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import util.Utils;
import util.XmlParser;

import static com.codeborne.selenide.Selenide.$;

public class VehicleValuationTab {

    private SelenideElement valueCodeSelect = $(By.id("BREForm_root.task.vehicleValuation.valueCode"));
    private SelenideElement accidentDateField = $(By.id("BREForm_root.task.vehicleValuation.valuationDate"));
    private SelenideElement valuationButton = $(By.id("BREForm_root.task.vehicleValuation.valuationButton"));
    private SelenideElement longValuationEntry = $(By.xpath("//td[text() = 'Langbewertung']"));
    private SelenideElement showValuationBtn = $(By.id("BREForm_root.task.valuationResult.valuationOutput"));

    public VehicleValuationTab verifyValueCodeValue(String expectedValue) {
        valueCodeSelect.shouldHave(Condition.text(expectedValue));
        return this;
    }

    public VehicleValuationTab verifyAccidentDate() {
        XmlParser xmlParser = new XmlParser();
        String expectedAccidentDate = xmlParser.getAccidentDate();
        accidentDateField.shouldHave(Condition.value(expectedAccidentDate));
        return this;
    }

    public VehicleValuationTab createValuation() {
        valuationButton.click();
        longValuationEntry.should(Condition.visible);
        showValuationBtn.should(Condition.enabled);
        return this;
    }

    public void downloadValuationFile() {
        showValuationBtn.click();
        Utils.downloadFile();
    }


}
