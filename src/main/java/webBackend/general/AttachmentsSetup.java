package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import static utilities.WebHelper.*;

public class AttachmentsSetup extends WebBase {

    @FindBy(name = "max_upload_size")
    WebElement maximumUploadSizeSelect;
    @FindBy(xpath = "//input[@name='max_upload_type'][@value='0']")
    WebElement doNotCheckMaximumUploadSize;
    @FindBy(xpath = "//input[@name='max_upload_type'][@value='1']")
    WebElement alertWhenExceedingMaximumUploadSize;
    @FindBy(xpath = "//input[@name='max_upload_type'][@value='2']")
    WebElement neverExceedMaximumUploadSize;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "body_frame")
    WebElement frame;

    public void maximumUploadSizeAndSetType(String size, String type){

        hold(500);
        goToFrame(frame);
        elementWaitAdvanced(By.name("max_upload_size"));
        hold(500);
        Select uploadSize = new Select(maximumUploadSizeSelect);
        uploadSize.selectByVisibleText(size);
        hold(300);
        if(type.equalsIgnoreCase("Do Not Check Maximum Upload Size")){
            clickOn(doNotCheckMaximumUploadSize);
        } else if (type.equalsIgnoreCase("Alert When Exceeding Maximum Upload Size")) {
            clickOn(alertWhenExceedingMaximumUploadSize);
        } else if (type.equalsIgnoreCase("Never Exceed Maximum Upload Size")) {
            clickOn(neverExceedMaximumUploadSize);
        }else{
            clickOn(doNotCheckMaximumUploadSize);
        }
        hold(500);
        getDriver().switchTo().defaultContent();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(300);
        getDriver().switchTo().defaultContent();
        hold(1500);

    }

}
