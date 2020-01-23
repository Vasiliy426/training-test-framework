package pages.casePage.calculationPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.qapterPage.QapterPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class onePadQapterTab {

    private static SelenideElement startQapterBtn = $(By.id("BREForm_root.task.damageCapture.webpadButton"));

    public QapterPage openQapter() {
        startQapterBtn.click();
        switchTo().window(1);
        return new QapterPage();
    }


}
