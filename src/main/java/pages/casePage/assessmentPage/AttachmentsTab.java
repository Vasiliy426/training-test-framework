package pages.casePage.assessmentPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class AttachmentsTab {

    private SelenideElement caterogyListDropdown = $(By.id("BREForm_root.task.uploadAttachments.categorylist"));
    private SelenideElement uploadBtn = $(By.xpath("//input[@type = 'file']"));

    public AttachmentsTab selectCategoryListValue(String value) {
        caterogyListDropdown.selectOptionByValue(value);
        return this;
    }

    public AttachmentsTab uploadFile(String path) {
        File file = new File(path);
        uploadBtn.uploadFile(file);
        return this;
    }

}
