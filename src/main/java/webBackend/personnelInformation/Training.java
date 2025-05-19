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

public class Training extends WebBase {

    @FindBy(xpath = "//span[contains(@id, 'select2-source_filter')]")
    WebElement trainingSourceE;
    @FindBy(id = "start_date")
    WebElement startDateE;
    @FindBy(id = "end_date")
    WebElement toDateE;
    @FindBy(id = "select2-course_type-container")
    WebElement courseTypeE;
    @FindBy(id = "course_type_Text")
    WebElement otherCourseTypeE;
    @FindBy(id = "select2-course_attended-container")
    WebElement courseAttendedE;
    @FindBy(id = "course_attended_Text")
    WebElement otherCourseAttendedE;
    @FindBy(name = "cost")
    WebElement costE;
    @FindBy(name = "training_hours")
    WebElement numberOfHoursE;
    @FindBy(xpath = "//span[contains(@id, 'select2-training_type')]")
    WebElement trainingTypeE;
    @FindBy(xpath = "//span[contains(@id, 'select2-show_in_CV')]")
    WebElement showInE;
    @FindBy(id = "file_path")
    WebElement attachmentE;
    @FindBy(name = "comments")
    WebElement commentsE;
    @FindBy(name = "training_source")
    WebElement checkTrainingSource;
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
    @FindBy(xpath = "//div[contains(@onclick, 'HR_Training.php')]")
    WebElement trainingPage;
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

    public void addTraining(String trainingSource, String startDate, String toDate, String courseType, String otherCourseType,
                            String courseAttended, String otherCourseAttended, String cost, String numberOfHours, String trainingType,
                            String showIn, String comments){

        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        selectOption(trainingSourceE, trainingSource);
        hold(300);
        startDateE.clear();
        hold(400);
        setText(startDateE, startDate);
        setText(toDateE, toDate);
        selectOption(courseTypeE, courseType);
        if(courseType.equalsIgnoreCase("Other"))
            setText(otherCourseTypeE, otherCourseType);
        selectOption(courseAttendedE, courseAttended);
        if(courseAttended.equalsIgnoreCase("Other"))
            setText(otherCourseAttendedE, otherCourseAttended);
        setText(costE, cost);
        setText(numberOfHoursE, numberOfHours);
        scrollToElement(commentsE);
        selectOption(trainingTypeE, trainingType);
        selectOption(showInE, showIn);
        attachmentE.sendKeys(uploadRandomImage());
        setText(commentsE, comments);
        hold(500);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(300);

    }


    public void addTrainingWithAssertion(String trainingSource, String startDate, String toDate, String courseType, String otherCourseType,
                                         String courseAttended, String otherCourseAttended, String cost, String numberOfHours, String trainingType,
                                         String showIn, String comments){

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
        clickOn(trainingPage);
        hold(500);
        addTraining(trainingSource, startDate, toDate, courseType, otherCourseType, courseAttended,
                otherCourseAttended, cost, numberOfHours, trainingType, showIn, comments);

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(500);

        softAssert.assertEquals(startDateE.getDomAttribute("value"), startDate, "startDate");
        softAssert.assertEquals(toDateE.getDomAttribute("value"), toDate, "to date");
        softAssert.assertEquals(courseTypeE.getText(), courseType, "courseType");
        softAssert.assertEquals(otherCourseTypeE.getDomAttribute("value"), otherCourseType, "otherCourseType");
        softAssert.assertEquals(courseAttendedE.getText(), courseAttended, "courseAttended");
        softAssert.assertEquals(otherCourseAttendedE.getDomAttribute("value"), otherCourseAttended, "otherCourseAttended");
        softAssert.assertEquals(costE.getDomAttribute("value"), cost, "cost");
        softAssert.assertEquals(numberOfHoursE.getDomAttribute("value"), numberOfHours, "numberOfHours");
        softAssert.assertEquals(trainingTypeE.getText(), trainingType, "trainingType");
        softAssert.assertEquals(showInE.getText(), showIn, "showIn");
        softAssert.assertEquals(commentsE.getDomAttribute("value"), comments, "comments");
        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile.getDomAttribute("href").isEmpty(), "- Attachment File");
        //softAssert.assertEquals(checkTrainingSource.getDomAttribute("value"), trainingSource, "training Source");
        if(!courseType.equalsIgnoreCase("Other"))
            softAssert.assertEquals(otherCourseTypeE.getDomAttribute("disabled"), "true");
        if(!courseAttended.equalsIgnoreCase("Other"))
            softAssert.assertEquals(otherCourseAttendedE.getDomAttribute("disabled"), "true");
        softAssert.assertAll();


    }

    public void editTraining(){

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
        clickOn(trainingPage);
        hold(500);
        addTraining("Previous Training", "01/01/2020", "02/02/2021", "Other",
                "Course Type Test", "Other", "Course Attended Test", "300.000", "80.000",
                "International", "Both", "");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);

        otherCourseAttendedE.clear();
        hold(300);
        setText(otherCourseAttendedE, "Course Edited");
        costE.clear();
        hold(300);
        setText(costE, "200.000");
        clickOn(saveBtn);
        hold(300);
        clickOn(item);
        hold(300);

        softAssert.assertEquals(otherCourseAttendedE.getDomAttribute("value"), "Course Edited", "otherCourseAttended");
        softAssert.assertEquals(costE.getDomAttribute("value"), "200.000", "cost");
        softAssert.assertAll();

    }

    public void deleteTraining(){

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
        clickOn(trainingPage);
        hold(500);
        addTraining("Previous Training", "01/01/2020", "02/02/2021", "Other",
                "Course Type Test", "Other", "Course Attended Test", "300.000", "80.000",
                "International", "Both", "");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);
        clickOn(deleteBtn);
        hold(500);
        clickOn(alertButtonOkDelete);
        hold(300);
        clickOn(trainingPage);
        hold(300);

        Assert.assertTrue(checkElementIfNotAppear(items), "Item NOT Deleted!");

    }

    public void addMoreThanOneRecord(int trainingCount){

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
        clickOn(trainingPage);
        hold(500);

        for (int i = 1; i <= trainingCount; i++) {

            String randNum = String.valueOf(randomNumber2());
            addTraining("Previous Training", "01/0"+i+"/2020", "01/0"+(i+1)+"/2021", "Other",
                    "Course Type Test", "Other", "Course Attended Test "+i, i+"00.000", i+"0.000",
                    "International", "Both", randNum);

            hold(300);
            clickOn(addBtn);
            hold(1500);

        }

        Assert.assertEquals(items.size(), trainingCount, "- issue in item counter");

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
        clickOn(trainingPage);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        startDateE.clear();
        hold(300);
        setText(startDateE, "01/01/2018");
        setText(toDateE, "01/01/2020");
        selectOption(courseAttendedE, "Other");
        setText(otherCourseAttendedE, "Test Upload");
        scrollToElement(commentsE);
        attachmentE.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        scrollToElement(empCode);
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
        clickOn(trainingPage);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        startDateE.clear();
        hold(300);
        setText(startDateE, "01/01/2018");
        setText(toDateE, "01/01/2020");
        selectOption(courseAttendedE, "Other");
        setText(otherCourseAttendedE, "Test Upload");
        scrollToElement(commentsE);
        attachmentE.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        scrollToElement(empCode);
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
        clickOn(trainingPage);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        startDateE.clear();
        hold(300);
        setText(startDateE, "01/01/2018");
        setText(toDateE, "01/01/2020");
        selectOption(courseAttendedE, "Other");
        setText(otherCourseAttendedE, "Test Upload");
        scrollToElement(commentsE);
        attachmentE.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        scrollToElement(empCode);
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
        clickOn(trainingPage);
        addTraining("Previous Training", "01/01/2020", "02/02/2021", "",
                "", "Training Courses 1", "", "", "",
                "", "", "");
        hold(300);
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
        clickOn(trainingPage);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        startDateE.clear();
        hold(300);
        setText(startDateE, "01/01/2018");
        setText(toDateE, "01/01/2020");
        selectOption(courseAttendedE, "Other");
        setText(otherCourseAttendedE, "Test Upload");
        scrollToElement(commentsE);
        attachmentE.sendKeys(uploadRandomImage());
        hold(500);
        scrollToElement(empCode);
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
        clickOn(trainingPage);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        startDateE.clear();
        hold(300);
        setText(startDateE, "01/01/2018");
        setText(toDateE, "01/01/2020");
        selectOption(courseAttendedE, "Other");
        setText(otherCourseAttendedE, "Test Upload");
        scrollToElement(commentsE);
        attachmentE.sendKeys(uploadDocFile());
        hold(500);
        scrollToElement(empCode);
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
