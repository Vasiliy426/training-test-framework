package pages.qapterPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class QapterPage {

    private SelenideElement modelOptionsBtn = $(By.id("navigation-adjustment"));
    private SelenideElement leftMenuMotorOption = $(By.xpath("//[@id='model-options-section-6'//span[contains(text(),'Motor/Getriebe']"));

    private SelenideElement getriebeRowElement = $(By.id("s-mP6"));
    private SelenideElement generatorRowElement = $(By.id("s-mM9"));
    private SelenideElement dieselRowElement = $(By.id("s-mO2"));
    private SelenideElement startStopRowElementCheckbox = $(By.id("s-mC3"));
    private SelenideElement dsgRowElementCheckbox = $(By.id("s-mP2"));

    private SelenideElement getriebeRowElementSpan = $(By.xpath("//div[@id='s-mP6']//span"));
    private SelenideElement generatorRowElementSpan = $(By.xpath("//div[@id='s-mM9']//span"));
    private SelenideElement dieselRowElementSpan = $(By.xpath("//div[@id='s-mO2']//span"));

    public QapterPage clickModelOptionsBtn() {
        modelOptionsBtn.click();
        return this;
    }

    public QapterPage clickLeftMenuMotorOption() {
        leftMenuMotorOption.click();
        return this;
    }
    
    public QapterPage verifyCheckedElementsHaveRightValues() {
        Assert.assertTrue(getriebeRowElement.toString().contains("selected"));
        Assert.assertTrue(generatorRowElement.toString().contains("selected"));
        Assert.assertTrue(dieselRowElement.toString().contains("selected"));
        Assert.assertTrue(startStopRowElementCheckbox.toString().contains("selected"));
        Assert.assertTrue(dsgRowElementCheckbox.toString().contains("selected"));

        getriebeRowElementSpan.shouldHave(Condition.text("P6 - 6-Gang DSG"));
        generatorRowElementSpan.shouldHave(Condition.text("M9 - Generator 180A"));
        dieselRowElementSpan.shouldHave(Condition.text("O2 - 1968ccm (2.0 Ltr) 103kW  CFFB"));

        return this;
    }

}
