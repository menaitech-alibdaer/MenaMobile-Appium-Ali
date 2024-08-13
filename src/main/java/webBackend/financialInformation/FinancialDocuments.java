package webBackend.financialInformation;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class FinancialDocuments extends WebBase {

    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'pay_emp_financial_doc.php')]")
    WebElement financialDocumentsTab;
    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addBtn;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDelete;
    @FindBy(id = "select2-attachment_type-container")
    WebElement attachmentTypeE;
    @FindBy(id = "date")
    WebElement attachmentDateE;
    @FindBy(name = "document_number")
    WebElement documentNumberE;
    @FindBy(id = "expiry_date")
    WebElement expiresOnE;
    @FindBy(id = "file_path")
    WebElement attachmentFileE;
    @FindBy(name = "description")
    WebElement descriptionE;
    @FindBy(xpath = "//a[contains(@href, 'download_page')]")
    WebElement checkAttachment;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    WebElement item;
    @FindBy(xpath =  "//ul[contains(@class, 'bg-icon')]//li[@class='nav-item']")
    List<WebElement> items;
    @FindBy(xpath = "//span[contains(@onclick, 'delete_attach')]")
    WebElement deleteItem;

    public void setEmployeeCode(String employeeCode){

        goToFrame(bodyFrame);
        elementWaitAdvanced(By.id("employee_code"));
        hold(300);
        setText(empCode, employeeCode);
        hold(300);
        setText(empCode, Keys.TAB);
        hold(300);
        elementWaitAdvanced(By.xpath("//label[contains(text(),'Active Employee')]"));

        setLog("Set Employee Code: "+employeeCode);

    }

    public void documents(String attachmentType, String attachmentDate, String documentNumber, String expiresOn,
                          boolean attachFile, String description, boolean deleteAfterSave){

        clickOn(financialDocumentsTab);
        hold(300);
        elementWaitAdvanced(By.id("date"));
        clickOn(addBtn);
        hold(300);
        if(!attachmentType.isEmpty()){
            selectOption(attachmentTypeE, attachmentType);
            hold(200);
        }
        if(!attachmentDate.isEmpty()){
            attachmentDateE.clear();
            hold(200);
            setText(attachmentDateE, attachmentDate);
        }
        if(!documentNumber.isEmpty()){
            setText(documentNumberE, documentNumber);
            hold(200);
        }
        if(!expiresOn.isEmpty()){
            setText(expiresOnE, expiresOn);
            hold(200);
        }
        if(attachFile){
            attachmentFileE.sendKeys(uploadRandomImage());
        }
        if(!description.isEmpty()){
            descriptionE.clear();
            hold(200);
            setText(descriptionE, description);
            hold(200);
        }
        clickOn(saveBtn);
        hold(500);
        clickOn(item);
        hold(500);

        if(deleteAfterSave){
            clickOn(deleteItem);
            hold(500);
            clickOn(alertButtonOkDelete);
            hold(500);
        }

        setLog("Financial Documents"
        +" - attachment Type: "+attachmentType
        +" - attachment Date: "+attachmentDate
        +" - document Number: "+documentNumber
        +" - expires On: "+expiresOn
        +" - attach File: "+attachFile
        +" - description: "+description
        +" - delete After Save: "+deleteAfterSave);

    }

}
