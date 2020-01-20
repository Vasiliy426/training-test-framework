package pages.casePage.calculationPage;

import com.codeborne.selenide.SelenideElement;
import logger.LoggerTool;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CalculationPage {

    private static SelenideElement onePadQapterTab = $(By.xpath("//li[@data-block='BREForm_block.OnePadQapter']"));

    public onePadQapterTab openOnePadQapterTab() {
        onePadQapterTab.click();
        LoggerTool.logInfo("Switched to OnePadQapter tab.");
        return new onePadQapterTab();
    }
}
