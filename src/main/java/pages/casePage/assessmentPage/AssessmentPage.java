package pages.casePage.assessmentPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AssessmentPage {

    private static SelenideElement attachmentsTab = $(By.xpath("//li[@data-block='BREForm_block.Attachments']"));

    public AttachmentsTab openAttachmentsTab() {
        attachmentsTab.click();
        return new AttachmentsTab();
    }

}
