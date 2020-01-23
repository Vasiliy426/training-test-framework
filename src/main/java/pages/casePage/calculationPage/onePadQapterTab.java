package pages.casePage.calculationPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.qapterPage.QapterPage;

import static com.codeborne.selenide.Selenide.$;

public class onePadQapterTab {

    private static SelenideElement startQapterBtn = $(By.id("BREForm_root.task.damageCapture.webpadButton"));

    public void clickStartQapterButton() {
        startQapterBtn.click();
    }
}
