package pages.qapterPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class QapterPage {

    //list of tabs
    private SelenideElement modelOptionsTabBtn = $(By.id("navigation-adjustment"));
    private SelenideElement сar3DViewTabBtn = $(By.id("navigation-vehicle"));
    private SelenideElement checklistTabBtn = $(By.id("navigation-checklist"));

    //ModelOptions tab elements
    private SelenideElement leftMenuMotorOption = $(By.xpath("//div[@id='model-options-section-6']//span[contains(text(),'Motor/Getriebe')]"));

    private SelenideElement getriebeRowElement = $(By.id("s-mP6"));
    private SelenideElement generatorRowElement = $(By.id("s-mM9"));
    private SelenideElement dieselRowElement = $(By.id("s-mO2"));
    private SelenideElement startStopRowElementCheckbox = $(By.id("s-mC3"));
    private SelenideElement dsgRowElementCheckbox = $(By.id("s-mP2"));

    private SelenideElement getriebeRowElementSpan = $(By.xpath("//div[@id='s-mP6']//span"));
    private SelenideElement generatorRowElementSpan = $(By.xpath("//div[@id='s-mM9']//span"));
    private SelenideElement dieselRowElementSpan = $(By.xpath("//div[@id='s-mO2']//span"));

    //3DCarView tab elements
    private SelenideElement frontBody = $(By.id("0_1_30000038"));
    private SelenideElement hood = $(By.id("32_2_32000019"));
    private SelenideElement repairMethodE = $(By.id("repair-method-selector-E"));
    private SelenideElement closePopupBtn = $(By.id("#un-close"));

    //Checklist tab elements
    private ElementsCollection damagesList = $$(By.xpath("//span[@class='checklist-body-part-description']"));
    private SelenideElement loader = $(By.className("loader-big"));

    // todo - to select 3D parts the way Dmitry want, check out the VehiclePageQapter.java from prod framework

    public QapterPage openModelOptionsTab() {
        modelOptionsTabBtn.click();
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

    public QapterPage openCar3DViewTab() {
        сar3DViewTabBtn.click();
        return this;
    }

    public QapterPage openChecklistTab() {
        checklistTabBtn.click();
        loader.waitUntil(Condition.disappear, 5000);
        return this;
    }

    public QapterPage addDamageForHood() {
        frontBody.click();
        hood.click();
        repairMethodE.click();
        closePopupBtn.click();
        return this;
    }

    public void checkDamagesChecklist() {
        openChecklistTab();
        Assert.assertTrue(damagesList.texts().contains("DECKEL V"));
    }

}
