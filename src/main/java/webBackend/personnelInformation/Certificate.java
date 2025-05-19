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

public class Certificate extends WebBase {

    @FindBy(id = "start_date")
    WebElement startDateE;
    @FindBy(id = "end_date")
    WebElement toDateE;
    @FindBy(id = "select2-certificate_type_code-container")
    WebElement certificateTypeE;
    @FindBy(id = "certificate_type_other")
    WebElement otherCertificateTypeE;
    @FindBy(id = "select2-certificate-container")
    WebElement certificateNameE;
    @FindBy(id = "certificate_name_other")
    WebElement otherCertificateNameE;
    @FindBy(id = "issue_date")
    WebElement issueDateE;
    @FindBy(name = "repair_man")
    WebElement certificateSerialE;
    @FindBy(name = "grade")
    WebElement gradeE;
    @FindBy(name = "certificate_Ref")
    WebElement certificateNumberE;
    @FindBy(xpath = "//span[contains(@id, 'select2-show_in_CV')]")
    WebElement showInE;
    @FindBy(id = "certificate_path")
    WebElement attachmentE;
    @FindBy(xpath = "//input[@name='status'][@value='1']")
    WebElement statusPassed;
    @FindBy(xpath = "//input[@name='status'][@value='0']")
    WebElement statusFailed;
    @FindBy(xpath = "//input[@name='status'][@value='2']")
    WebElement statusPending;
    @FindBy(name = "notes")
    WebElement notesE;
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
    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'Education.php')]")
    WebElement learningAndDevelopmentTab;
    @FindBy(xpath = "//div[contains(@onclick, 'employee_certificates.php')]")
    WebElement certificatePage;
    @FindBy(xpath = "//img[contains(@src, 'locked_attachment.png')]")
    WebElement checkAttachForUserDontHavePermission;
    @FindBy(xpath = "//img[@alt='Attachment Thumbnail']")
    List<WebElement> checkAttach;
    @FindBy(xpath = "//img[@alt='Attachment Thumbnail']")
    WebElement checkAttachmentImg;
    @FindBy(xpath = "//div[@class='col-md-3']//a[1]")
    WebElement checkAttachmentFile;
    SoftAssert softAssert = new SoftAssert();
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    PersonnelInformation personnelInformation;
    AttachmentsSetup attachmentsSetup;
    String employeeCode = null;

    public void addCertificate(String startDate, String toDate, String certificateType, String otherCertificateType, String certificateName,
                               String otherCertificateName, String issueDate, String certificateSerial, String grade, String certificateNumber,
                               String showIn, String status, String notes){

        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        startDateE.clear();
        hold(400);
        setText(startDateE, startDate);
        setText(toDateE, toDate);
        selectOption(certificateTypeE, certificateType);
        setText(otherCertificateTypeE, otherCertificateType);
        selectOption(certificateNameE, certificateName);
        setText(otherCertificateNameE, otherCertificateName);
        setText(issueDateE, issueDate);
        setText(certificateSerialE, certificateSerial);
        setText(gradeE, grade);
        setText(certificateNumberE, certificateNumber);
        selectOption(showInE, showIn);
        attachmentE.sendKeys(uploadRandomImage());
        scrollToElement(notesE);
        if(status.equalsIgnoreCase("Passed")){
            clickOn(statusPassed);
        } else if (status.equalsIgnoreCase("Failed")) {
            clickOn(statusFailed);
        }else if (status.equalsIgnoreCase("Pending")){
            clickOn(statusPending);
        }
        setText(notesE, notes);
        hold(500);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(300);

    }

    public void addCertificateWithAssertion(String startDate, String toDate, String certificateType, String otherCertificateType, String certificateName,
                                            String otherCertificateName, String issueDate, String certificateSerial, String grade, String certificateNumber,
                                            String showIn, String status, String notes){

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
        clickOn(learningAndDevelopmentTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(certificatePage);
        hold(500);
        addCertificate(startDate, toDate, certificateType, otherCertificateType, certificateName,
                otherCertificateName, issueDate, certificateSerial, grade, certificateNumber, showIn, status,
                notes);

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);

        softAssert.assertEquals(startDateE.getDomAttribute("value"), startDate, "startDate");
        softAssert.assertEquals(toDateE.getDomAttribute("value"), toDate, "toDate");
        softAssert.assertEquals(certificateTypeE.getText(), certificateType, "certificateType");
        softAssert.assertEquals(otherCertificateTypeE.getDomAttribute("value"), otherCertificateType, "otherCertificateType");
        softAssert.assertEquals(certificateNameE.getText(), certificateName, "certificateName");
        softAssert.assertEquals(otherCertificateNameE.getDomAttribute("value"), otherCertificateName, "otherCertificateName");
        softAssert.assertEquals(issueDateE.getDomAttribute("value"), issueDate, "issueDate");
        softAssert.assertEquals(certificateSerialE.getDomAttribute("value"), certificateSerial, "certificateSerial");
        softAssert.assertEquals(gradeE.getDomAttribute("value"), grade, "grade");
        softAssert.assertEquals(certificateNumberE.getDomAttribute("value"), certificateNumber, "certificateNumber");
        softAssert.assertEquals(showInE.getText(), showIn, "showIn");
        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile.getDomAttribute("href").isEmpty(), "- Attachment File");
        if(status.equalsIgnoreCase("Passed")){
            softAssert.assertTrue(statusPassed.isSelected());
        }else if(status.equalsIgnoreCase("Failed")){
            softAssert.assertTrue(statusFailed.isSelected());
        }else if(status.equalsIgnoreCase("Pending")){
            softAssert.assertTrue(statusPending.isSelected());
        }
        softAssert.assertEquals(notesE.getDomAttribute("value"), notes);
        softAssert.assertAll();

    }

    public void editCertificate(){

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
        clickOn(learningAndDevelopmentTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(certificatePage);
        hold(500);
        addCertificate("01/01/2019", "01/01/2020", "Certificate Type 1", "",
                "Training Certificates 1", "", "01/01/2019", ""+ randomNumber(), "1.000",
                ""+randomNumber2(), "Detailed Resume", "Passed", "Test Note");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);
        startDateE.clear();
        hold(300);
        setText(startDateE, "05/05/2019");
        selectOption(certificateTypeE, "Other");
        hold(200);
        setText(otherCertificateTypeE, "Other Certificate Type");
        selectOption(certificateNameE, "Other");
        hold(200);
        setText(otherCertificateNameE, "Other Certificate Name");
        issueDateE.clear();
        hold(300);
        setText(issueDateE, "05/04/2019");
        gradeE.clear();
        hold(300);
        setText(gradeE, "2.000");
        scrollToElement(notesE);
        clickOn(statusPending);
        clickOn(saveBtn);
        hold(300);
        clickOn(item);
        hold(300);

        softAssert.assertEquals(startDateE.getDomAttribute("value"), "05/05/2019", "Start date");
        softAssert.assertEquals(certificateTypeE.getText(), "Other", "certificateType");
        softAssert.assertEquals(otherCertificateTypeE.getDomAttribute("value"), "Other Certificate Type", "Other Certificate Type");
        softAssert.assertEquals(certificateNameE.getText(), "Other", "certificateName");
        softAssert.assertEquals(otherCertificateNameE.getDomAttribute("value"), "Other Certificate Name", "Other Certificate Name");
        softAssert.assertEquals(issueDateE.getDomAttribute("value"), "05/04/2019", "issueDate");
        softAssert.assertEquals(gradeE.getDomAttribute("value"), "2.000", "grade");
        softAssert.assertAll();

    }

    public void deleteCertificate(){

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
        clickOn(learningAndDevelopmentTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(certificatePage);
        hold(500);
        addCertificate("01/01/2019", "01/01/2020", "Certificate Type 1", "",
                "Training Certificates 1", "", "01/01/2019", ""+ randomNumber(), "1.000",
                ""+randomNumber2(), "Detailed Resume", "Passed", "Test Note");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);
        clickOn(deleteBtn);
        hold(300);
        clickOn(alertButtonOkDelete);
        hold(300);
        clickOn(certificatePage);
        hold(300);
        Assert.assertTrue(checkElementIfNotAppear(items), "Item NOT deleted");

    }

    public void addMoreThanOneRecord(int certificateCount){

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
        clickOn(learningAndDevelopmentTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(certificatePage);
        hold(500);

        for (int i = 1; i <= certificateCount; i++) {

            String randNum = String.valueOf(randomNumber2());
            addCertificate("01/0"+i+"/2019", "", "Certificate Type 1", "",
                    "Training Certificates 1", "", "01/01/2019", ""+randNum, i+".000",
                    ""+randNum, "Detailed Resume", "Passed", "Test Note");

            hold(300);
            clickOn(addBtn);
            hold(1500);

        }

        Assert.assertEquals(items.size(), certificateCount, "- issue in item counter");

    }

    public void addAttachmentWithAllowUpperLimit(){

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

        clickOn(learningAndDevelopmentTab);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(certificatePage);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        startDateE.clear();
        hold(300);
        setText(startDateE, "01/01/2018");
        selectOption(certificateTypeE, "Certificate Type 1");
        selectOption(certificateNameE, "Training Certificates 1");
        attachmentE.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile.getDomAttribute("href").isEmpty(), "- Attachment File");

        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void addAttachmentWithAlertMessageUpperLimit(){

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

        clickOn(learningAndDevelopmentTab);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(certificatePage);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        startDateE.clear();
        hold(300);
        setText(startDateE, "01/01/2018");
        selectOption(certificateTypeE, "Certificate Type 1");
        selectOption(certificateNameE, "Training Certificates 1");
        attachmentE.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "Please Note The Maximum Size To Upload Here Is 2 MB");
        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile.getDomAttribute("href").isEmpty(), "- Attachment File");

        clickOn(okBtnAlert);
        hold(200);
        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void addAttachmentWithDontAllowUpperLimit(){

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

        clickOn(learningAndDevelopmentTab);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(certificatePage);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        startDateE.clear();
        hold(300);
        setText(startDateE, "01/01/2018");
        selectOption(certificateTypeE, "Certificate Type 1");
        selectOption(certificateNameE, "Training Certificates 1");
        attachmentE.sendKeys(uploadBigSizeImg5MB());
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

    public void checkUserWithOptionDontAllowDownloadFile(){

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

        clickOn(learningAndDevelopmentTab);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(certificatePage);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));

        addCertificate("01/01/2019", "", "Certificate Type 1", "",
                "Training Certificates 1", "", "", "", "",
                "", "", "", "");

        clickOn(item);
        hold(300);

        softAssert.assertTrue(checkAttachForUserDontHavePermission.isDisplayed(), "- LOCKED Attachment NOT appear");
        softAssert.assertEquals(checkAttachForUserDontHavePermission.getDomAttribute("alt"), "Sorry You Do Not Have Permission To Access Uploaded Files !");
        softAssert.assertAll();

    }

    public void checkUserWithOptionDontAllowUploadFile(){

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
        employeeCode = empCode.getDomAttribute("value");

        closeIFrame();
        clickOn(personnelInformation.logout);
        hold(500);
        login.ali5User();
        menaModules.menaPAY();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);

        clickOn(learningAndDevelopmentTab);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(certificatePage);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        startDateE.clear();
        hold(300);
        setText(startDateE, "01/01/2018");
        selectOption(certificateTypeE, "Certificate Type 1");
        selectOption(certificateNameE, "Training Certificates 1");
        attachmentE.sendKeys(uploadRandomImage());
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

    public void uploadAttachmentWithWrongExtension(){

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

        clickOn(learningAndDevelopmentTab);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(certificatePage);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        startDateE.clear();
        hold(300);
        setText(startDateE, "01/01/2018");
        selectOption(certificateTypeE, "Certificate Type 1");
        selectOption(certificateNameE, "Training Certificates 1");
        attachmentE.sendKeys(uploadDocFile());
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

}
