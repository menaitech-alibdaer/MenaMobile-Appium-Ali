package webBackend.personnelInformation;

import bases.WebBase;
import webBackend.general.AttachmentsSetup;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static utilities.WebHelper.*;

import java.util.List;

public class AssetsAndDocuments extends WebBase {

    @FindBy(xpath = "//span[contains(@id, 'select2-type')]")
    WebElement attachmentTypeE;
    @FindBy(id = "date")
    WebElement attachmentDateE;
    @FindBy(id = "document_number")
    WebElement documentNumberE;
    @FindBy(id = "expiry_date")
    WebElement expireOnE;
    @FindBy(xpath = "//span[contains(@id, 'select2-related_to')]")
    WebElement relatedToE;
    @FindBy(id = "file_path")
    WebElement attachmentFile;
    @FindBy(id = "description")
    WebElement descriptionE;
    @FindBy(xpath = "//img[@alt='Attachment Thumbnail']")
    WebElement checkAttachmentImg;
    @FindBy(xpath = "//div[@class='col-md-3']//a[1]")
    WebElement checkAttachmentFile;
    @FindBy(xpath = "//div[@class='col-md-3']//a[1]")
    WebElement checkAttachmentFile2;
    @FindBy(xpath = "//div[@class='div-delete-employee']")
    List<WebElement> deleteAttachmentBtn;
    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'Attachments.php')]")
    WebElement assetsAndDocumentsTab;
    @FindBy(xpath = "//div[contains(@onclick, 'Assets.php')]")
    WebElement assetsPage;
    @FindBy(xpath = "//div[contains(@onclick, 'employee_notes.php')]")
    WebElement notePage;
    @FindBy(id = "date")
    WebElement deliveryDateE;
    @FindBy(id = "expire_date")
    WebElement expireDateE;
    @FindBy(id = "drop_date")
    WebElement dropDateE;
    @FindBy(xpath = "//span[contains(@id, 'select2-assets_code')]")
    WebElement assetDescriptionE;
    @FindBy(name = "value")
    WebElement costE;
    @FindBy(name = "count")
    WebElement countE;
    @FindBy(name = "model")
    WebElement modelE;
    @FindBy(id = "assets_attached_file")
    WebElement assetsAttachmentFile;
    @FindBy(name = "serial_no")
    WebElement serialNumberE;
    @FindBy(name = "location")
    WebElement locationE;
    @FindBy(id = "decreasing")
    WebElement decreasingE;
    @FindBy(id = "notes")
    WebElement notesE;
    @FindBy(id = "note_date")
    WebElement noteDateE;
    @FindBy(name = "note_text")
    WebElement noteE;
    @FindBy(name = "employee_comment")
    WebElement employeeCommentE;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    WebElement item;
    @FindBy(xpath =  "//ul[contains(@class, 'bg-icon')]//li[@class='nav-item']")
    List<WebElement> items;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addBtn;
    @FindBy(xpath = "//div[@class='textAlign']//label[contains(@style, 'font-size:20px')]")
    WebElement alertText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    WebElement alertBox;
    @FindBy(xpath = "//span[contains(@onclick, 'confirm_delete')]")
    WebElement deleteBtn;
    @FindBy(id = "btok")
    WebElement okBtnAlert;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDelete;
    @FindBy(xpath = "//img[contains(@src, 'locked_attachment.png')]")
    WebElement checkAttachForUserDontHavePermission;
    @FindBy(xpath = "//img[@alt='Attachment Thumbnail']")
    List<WebElement> checkAttach;
    SoftAssert softAssert = new SoftAssert();
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    PersonnelInformation personnelInformation;
    AttachmentsSetup attachmentsSetup;
    String employeeCode = null;

    public void addAttachments(String attachmentType, String attachmentDate, String documentNumber, String expiresOn,
                               String relatedTo, String description){

        hold(500);
        elementWaitAdvanced(By.id("date"));
        selectOption(attachmentTypeE, attachmentType);
        attachmentDateE.clear();
        hold(300);
        setText(attachmentDateE, attachmentDate);
        setText(documentNumberE, documentNumber);
        setText(expireOnE, expiresOn);
        selectOption(relatedToE, relatedTo);
        attachmentFile.sendKeys(uploadRandomImage());
        setText(descriptionE, description);
        clickOn(saveBtn);
        hold(300);

    }

    public void addAttachmentsWithAssertion(String attachmentType, String attachmentDate, String documentNumber, String expiresOn,
                                String relatedTo, String description){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(500);
        addAttachments(attachmentType, attachmentDate, documentNumber, expiresOn, relatedTo, description);

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);

        softAssert.assertEquals(attachmentTypeE.getText(), attachmentType, "attachmentType");
        softAssert.assertEquals(attachmentDateE.getAttribute("value"), attachmentDate, "attachmentDate");
        softAssert.assertEquals(documentNumberE.getAttribute("value"), documentNumber, "documentNumber");
        softAssert.assertEquals(expireOnE.getAttribute("value"), expiresOn, "expiresOn");
        softAssert.assertEquals(relatedToE.getText(), relatedTo, "relatedTo");
        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile.getAttribute("href").isEmpty(), "- Attachment File");
        softAssert.assertEquals(descriptionE.getAttribute("value").trim(), description, "description");
        softAssert.assertAll();

    }

    public void editAttachment(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(500);
        addAttachments("Personal Identification", "10/10/2021", ""+ randomNumber(),
                "01/01/2029", "Employee", "Test");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);

        selectOption(attachmentTypeE, "Passport");
        attachmentDateE.clear();
        hold(300);
        setText(attachmentDateE, "01/01/2021");
        descriptionE.clear();
        hold(300);
        setText(descriptionE, "Edited Description");
        clickOn(saveBtn);
        hold(300);
        clickOn(item);
        hold(300);

        softAssert.assertEquals(attachmentTypeE.getText(), "Passport");
        softAssert.assertEquals(attachmentDateE.getAttribute("value"), "01/01/2021");
        softAssert.assertEquals(descriptionE.getAttribute("value").trim(), "Edited Description");
        softAssert.assertAll();

    }

    public void deleteAttachment(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(500);
        addAttachments("Personal Identification", "10/10/2021", ""+ randomNumber(),
                "01/01/2029", "Employee", "Test");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);
        clickOn(deleteBtn);
        hold(500);
        clickOn(alertButtonOkDelete);
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(300);

        Assert.assertTrue(checkElementIfNotAppear(items), "Item NOT Deleted!");

    }

    public void addMoreThanOneRecordAttachment(int attachmentCount){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(300);

        for (int i = 1; i <= attachmentCount; i++) {

            String randNum = String.valueOf(randomNumber2());
            addAttachments("Personal Identification", "10/0"+i+"/2021", ""+randNum,
                    "01/01/2029", "Employee", "Test "+i);

            hold(300);
            clickOn(addBtn);
            hold(1500);

        }

        Assert.assertEquals(items.size(), attachmentCount, "- issue in item counter");

    }

    public void addAttachmentWithAllowUpperLimit_Attachment(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings","Attachments Setup");

        attachmentsSetup = new AttachmentsSetup();
        attachmentsSetup.maximumUploadSizeAndSetType("2", "Do Not Check Maximum Upload Size");

        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(assetsAndDocumentsTab);
        hold(500);
        elementWaitAdvanced(By.id("date"));
        selectOption(attachmentTypeE, "Passport");
        attachmentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile.getAttribute("href").isEmpty(), "- Attachment File");

        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void addAttachmentWithAlertMessageUpperLimit_Attachment(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings","Attachments Setup");

        attachmentsSetup = new AttachmentsSetup();
        attachmentsSetup.maximumUploadSizeAndSetType("2", "Alert When Exceeding Maximum Upload Size");

        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(assetsAndDocumentsTab);
        hold(500);
        elementWaitAdvanced(By.id("date"));
        selectOption(attachmentTypeE, "Passport");
        attachmentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "Please Note The Maximum Size To Upload Here Is 2 MB");
        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile.getAttribute("href").isEmpty(), "- Attachment File");

        clickOn(okBtnAlert);
        hold(200);
        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void addAttachmentWithDontAllowUpperLimit_Attachment(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings","Attachments Setup");

        attachmentsSetup = new AttachmentsSetup();
        attachmentsSetup.maximumUploadSizeAndSetType("2", "Never Exceed Maximum Upload Size");

        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(assetsAndDocumentsTab);
        hold(500);
        elementWaitAdvanced(By.id("date"));
        selectOption(attachmentTypeE, "Passport");
        attachmentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "File Size Exceed The Maximum Upload Size");
        softAssert.assertTrue(checkElementIfNotAppear(checkAttach), "- Attached should be not upload");

        clickOn(okBtnAlert);
        hold(200);
        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void checkUserWithOptionDontAllowDownloadFile_Attachment(){

        login = new Login();
        login.ali6User();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(assetsAndDocumentsTab);
        addAttachments("Personal Identification", "", "",
                "", "", "");

        clickOn(item);
        hold(300);

        softAssert.assertTrue(checkAttachForUserDontHavePermission.isDisplayed(), "- LOCKED Attachment NOT appear");
        softAssert.assertAll();

    }

    public void checkUserWithOptionDontAllowUploadFile_Attachment(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getAttribute("value");

        closeIFrame();
        clickOn(personnelInformation.logout);
        hold(500);
        login.ali5User();
        menaModules.menaPAY();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);

        clickOn(assetsAndDocumentsTab);
        hold(500);
        elementWaitAdvanced(By.id("date"));
        selectOption(attachmentTypeE, "Passport");
        attachmentFile.sendKeys(uploadRandomImage());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Do Not Have Permission To Upload Files!");

        clickOn(okBtnAlert);
        hold(200);
        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void uploadAttachmentWithWrongExtension_Attachment(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(assetsAndDocumentsTab);
        hold(500);
        elementWaitAdvanced(By.id("date"));
        selectOption(attachmentTypeE, "Passport");
        attachmentFile.sendKeys(uploadDocFile());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Can Not Upload Any File With The Extension: docx");

        clickOn(okBtnAlert);
        hold(200);
        clickOn(deleteBtn);
        hold(300);
        clickOn(alertButtonOkDelete);
        softAssert.assertAll();

    }

    //////////////// Assets ///////////////

    public void addAssets(String deliveryDate, String expireDate, String dropDate, String assetDescription, String cost, String count,
                          String model, String serialNumber, String location, boolean decreasing, String notes){

        hold(500);
        elementWaitAdvanced(By.id("date"));
        setText(deliveryDateE, deliveryDate);
        setText(expireDateE, expireDate);
        setText(dropDateE, dropDate);
        selectOption(assetDescriptionE, assetDescription);
        setText(costE, cost);
        setText(countE, count);
        setText(modelE, model);
        assetsAttachmentFile.sendKeys(uploadRandomImage());
        setText(serialNumberE, serialNumber);
        setText(locationE, location);
        if(decreasing){
            clickOn(decreasingE);
        }else{
            if(decreasingE.isSelected()){
                clickOn(decreasingE);
            }
        }
        setText(notesE, notes);
        hold(300);
        clickOn(saveBtn);
        hold(300);

    }

    public void addAssetsWithAssertion(String deliveryDate, String expireDate, String dropDate, String assetDescription, String cost, String count,
                                       String model, String serialNumber, String location, boolean decreasing, String notes){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(300);
        elementWaitAdvanced(By.id("date"));
        clickOn(assetsPage);
        addAssets(deliveryDate, expireDate, dropDate, assetDescription, cost, count, model, serialNumber, location, decreasing, notes);

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);

        softAssert.assertEquals(deliveryDateE.getAttribute("value"), deliveryDate, "deliveryDate");
        softAssert.assertEquals(expireDateE.getAttribute("value"), expireDate, "expireDate");
        softAssert.assertEquals(dropDateE.getAttribute("value"), dropDate, "dropDate");
        softAssert.assertEquals(assetDescriptionE.getText(), assetDescription, "assetDescription");
        softAssert.assertEquals(costE.getAttribute("value"), cost, "cost");
        softAssert.assertEquals(countE.getAttribute("value"), count, "count");
        softAssert.assertEquals(modelE.getAttribute("value"), model, "model");
        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile2.getAttribute("href").isEmpty(), "- Attachment File");
        softAssert.assertTrue(deleteAttachmentBtn.get(0).isDisplayed(), "Delete Attachment Button NOT Appear");
        softAssert.assertEquals(serialNumberE.getAttribute("value"), serialNumber, "serialNumber");
        softAssert.assertEquals(locationE.getAttribute("value"), location, "location");
        softAssert.assertEquals(decreasingE.isSelected(), decreasing, "decreasing");
        softAssert.assertEquals(notesE.getAttribute("value"), notes, "notes");
        softAssert.assertAll();

    }

    public void editAssets(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(300);
        elementWaitAdvanced(By.id("date"));
        clickOn(assetsPage);
        addAssets("01/01/2020", "01/01/2029", "08/08/2021", "Asset 1", "20.000",
                "3", ""+randomNumber(), ""+randomNumber2(), "Test Location", true, "Test");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);

        deliveryDateE.clear();
        hold(300);
        setText(deliveryDateE, "02/02/2020");
        expireDateE.clear();
        dropDateE.clear();
        selectOption(assetDescriptionE, "Asset 2");
        costE.clear();
        hold(300);
        setText(costE, "30.500");
        if(decreasingE.isSelected()){
            clickOn(decreasingE);
        }
        clickOn(saveBtn);
        hold(300);
        clickOn(item);
        hold(300);

        softAssert.assertEquals(deliveryDateE.getAttribute("value"), "02/02/2020", "deliveryDate");
        softAssert.assertTrue(expireDateE.getAttribute("value").isEmpty(), "Expire Date Should be Empty");
        softAssert.assertTrue(dropDateE.getAttribute("value").isEmpty(), "Drop Date Should be Empty");
        softAssert.assertEquals(assetDescriptionE.getText(), "Asset 2");
        softAssert.assertEquals(costE.getAttribute("value"), "30.500");
        softAssert.assertEquals(decreasingE.isSelected(), false, "Decreasing Should be NOT Selected");
        softAssert.assertAll();

    }

    public void deleteAssets(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(300);
        elementWaitAdvanced(By.id("date"));
        clickOn(assetsPage);
        addAssets("01/01/2020", "01/01/2029", "08/08/2021", "Asset 1", "20.000",
                "3", ""+randomNumber(), ""+randomNumber2(), "Test Location", true, "Test");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);
        clickOn(deleteBtn);
        hold(300);
        clickOn(alertButtonOkDelete);
        hold(300);
        clickOn(assetsPage);
        hold(300);
        Assert.assertTrue(checkElementIfNotAppear(items), "The item NOT Deleted!");

    }

    public void addMoreThanOneRecordAssets(int assetCount){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(300);
        elementWaitAdvanced(By.id("date"));
        clickOn(assetsPage);
        hold(500);

        for (int i = 1; i <= assetCount; i++) {

            String randNum = String.valueOf(randomNumber2());
            addAssets("01/01/2020", "", "", "Asset 1", "",
                    "", "", "", "Test Location "+i, true, "Test "+i);

            hold(300);
            clickOn(addBtn);
            hold(1500);

        }

        Assert.assertEquals(items.size(), assetCount, "- issue in item counter");

    }

    public void addAttachmentWithAllowUpperLimit_Assets(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings","Attachments Setup");

        attachmentsSetup = new AttachmentsSetup();
        attachmentsSetup.maximumUploadSizeAndSetType("2", "Do Not Check Maximum Upload Size");

        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(assetsAndDocumentsTab);
        hold(500);
        clickOn(assetsPage);
        hold(900);
        elementWaitAdvanced(By.id("date"));
        selectOption(assetDescriptionE, "Asset 1");
        assetsAttachmentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile2.getAttribute("href").isEmpty(), "- Attachment File");

        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void addAttachmentWithAlertMessageUpperLimit_Assets(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings","Attachments Setup");

        attachmentsSetup = new AttachmentsSetup();
        attachmentsSetup.maximumUploadSizeAndSetType("2", "Alert When Exceeding Maximum Upload Size");

        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(assetsAndDocumentsTab);
        hold(500);
        clickOn(assetsPage);
        hold(900);
        elementWaitAdvanced(By.id("date"));
        selectOption(assetDescriptionE, "Asset 1");
        assetsAttachmentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "Please Note The Maximum Size To Upload Here Is 2 MB");
        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile2.getAttribute("href").isEmpty(), "- Attachment File");

        clickOn(okBtnAlert);
        hold(200);
        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void addAttachmentWithDontAllowUpperLimit_Assets(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings","Attachments Setup");

        attachmentsSetup = new AttachmentsSetup();
        attachmentsSetup.maximumUploadSizeAndSetType("2", "Never Exceed Maximum Upload Size");

        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(assetsAndDocumentsTab);
        hold(500);
        clickOn(assetsPage);
        hold(900);
        elementWaitAdvanced(By.id("date"));
        selectOption(assetDescriptionE, "Asset 1");
        assetsAttachmentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "File Size Exceed The Maximum Upload Size");
        softAssert.assertTrue(checkElementIfNotAppear(checkAttach), "- Attached should be not upload");

        clickOn(okBtnAlert);
        hold(200);
        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void checkUserWithOptionDontAllowDownloadFile_Assets(){

        login = new Login();
        login.ali6User();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(assetsAndDocumentsTab);
        hold(500);
        clickOn(assetsPage);
        hold(900);
        addAssets("", "", "", "Asset 1", "", "", "",
                "", "", false, "");
        clickOn(assetsPage);
        hold(900);
        clickOn(item);
        hold(300);

        softAssert.assertTrue(checkAttachForUserDontHavePermission.isDisplayed(), "- LOCKED Attachment NOT appear");
        softAssert.assertEquals(checkAttachForUserDontHavePermission.getAttribute("alt"), "Sorry You Do Not Have Permission To Access Uploaded Files !");
        softAssert.assertAll();

    }

    public void checkUserWithOptionDontAllowUploadFile_Assets(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getAttribute("value");

        closeIFrame();
        clickOn(personnelInformation.logout);
        hold(500);
        login.ali5User();
        menaModules.menaPAY();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);

        clickOn(assetsAndDocumentsTab);
        hold(500);
        clickOn(assetsPage);
        hold(900);
        elementWaitAdvanced(By.id("date"));
        selectOption(assetDescriptionE, "Asset 1");
        assetsAttachmentFile.sendKeys(uploadRandomImage());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Do Not Have Permission To Upload Files!");

        clickOn(okBtnAlert);
        hold(200);
        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void uploadAttachmentWithWrongExtension_Assets(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(assetsAndDocumentsTab);
        hold(500);
        clickOn(assetsPage);
        hold(900);
        elementWaitAdvanced(By.id("date"));
        selectOption(assetDescriptionE, "Asset 1");
        assetsAttachmentFile.sendKeys(uploadDocFile());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Can Not Upload Any File With The Extension: docx");

        clickOn(okBtnAlert);
        hold(200);
        clickOn(deleteBtn);
        hold(300);
        clickOn(alertButtonOkDelete);
        softAssert.assertAll();

    }

    public void validateCostAndCountFieldWithSpecialCharacterAndMandatoryField(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(300);
        elementWaitAdvanced(By.id("date"));
        clickOn(assetsPage);
        addAssets("01/01/2020", "", "", "", "cost",
                "count", "", "", "", false, "");

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Must Be Filled!");

        clickOn(okBtnAlert);
        hold(500);
        selectOption(assetDescriptionE, "Asset 1");
        clickOn(saveBtn);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Should Only Contain Decimal Values.");

        clickOn(okBtnAlert);
        hold(500);
        costE.clear();
        hold(500);
        setText(costE, "11.000");
        clickOn(saveBtn);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Should Only Contain Numeric Values.");

        clickOn(okBtnAlert);
        hold(500);
        countE.clear();
        hold(500);
        setText(countE, "4");
        clickOn(saveBtn);
        hold(300);

        softAssert.assertTrue(item.isDisplayed(), "item not appear");
        softAssert.assertAll();

    }

    ///////////// Notes /////////////

    public void addNotes(String noteDate, String note, String employeeComment){

        hold(500);
        elementWaitAdvanced(By.id("note_date"));
        setText(noteDateE, noteDate);
        setText(noteE, note);
        setText(employeeCommentE, employeeComment);
        hold(300);
        clickOn(saveBtn);
        hold(300);

    }

    public void addNotesWithAssertion(String noteDate, String note, String employeeComment){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(300);
        elementWaitAdvanced(By.id("date"));
        clickOn(notePage);
        hold(300);
        elementWaitAdvanced(By.id("note_date"));
        addNotes(noteDate, note, employeeComment);

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);

        softAssert.assertEquals(noteDateE.getAttribute("value"), noteDate, "Note Date");
        softAssert.assertEquals(noteE.getAttribute("value"), note, "Note Text");
        softAssert.assertEquals(employeeCommentE.getAttribute("value"), employeeComment, "Employee Comment");
        softAssert.assertAll();

    }

    public void editNotes(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(300);
        elementWaitAdvanced(By.id("date"));
        clickOn(notePage);
        hold(300);
        elementWaitAdvanced(By.id("note_date"));
        addNotes("04/04/2021", "Test Note", "Test Comment");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);

        noteDateE.clear();
        hold(300);
        setText(noteDateE, "02/02/2022");
        noteE.clear();
        hold(300);
        setText(noteE, "Note Edited");
        employeeCommentE.clear();
        hold(300);
        setText(employeeCommentE, "Comment Edited");
        clickOn(saveBtn);
        hold(300);
        clickOn(item);
        hold(300);

        softAssert.assertEquals(noteDateE.getAttribute("value"), "02/02/2022");
        softAssert.assertEquals(noteE.getAttribute("value"), "Note Edited");
        softAssert.assertEquals(employeeCommentE.getAttribute("value"), "Comment Edited");
        softAssert.assertAll();

    }

    public void deleteNotes(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(300);
        elementWaitAdvanced(By.id("date"));
        clickOn(notePage);
        hold(300);
        elementWaitAdvanced(By.id("note_date"));
        addNotes("04/04/2021", "Test Note", "Test Comment");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);

        clickOn(deleteBtn);
        hold(500);
        clickOn(alertButtonOkDelete);
        hold(300);
        clickOn(notePage);
        hold(300);
        Assert.assertTrue(checkElementIfNotAppear(items), "item NOT deleted!");

    }

    public void checkMandatoryFieldNotes(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(assetsAndDocumentsTab);
        hold(300);
        elementWaitAdvanced(By.id("date"));
        clickOn(notePage);
        hold(300);
        elementWaitAdvanced(By.id("note_date"));
        clickOn(saveBtn);
        hold(300);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Must Be Filled!");
        softAssert.assertTrue(noteDateE.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        clickOn(okBtnAlert);
        hold(300);
        setText(noteDateE, "03/03/2022");
        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Must Be Filled!");
        softAssert.assertTrue(noteE.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        clickOn(okBtnAlert);
        hold(300);
        setText(noteE, "Test Note TEXT");
        clickOn(saveBtn);
        hold(300);
        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        softAssert.assertAll();

    }

}
