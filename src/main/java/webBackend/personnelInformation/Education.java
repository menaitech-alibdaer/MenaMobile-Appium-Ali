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
import static utilities.VersionGetter.liteGetter;
import static utilities.VersionGetter.versionGetter;

import java.util.List;

public class Education extends WebBase {

    @FindBy(id = "start_date")
    WebElement startDateE;
    @FindBy(id = "end_date")
    WebElement endDateE;
    @FindBy(id = "Until_Now")
    WebElement untilNowE;
    @FindBy(xpath = "//span[contains(@id, 'select2-country_code')]")
    WebElement countryE;
    @FindBy(xpath = "//span[contains(@id, 'select2-city_code')]")
    WebElement cityE;
    @FindBy(xpath = "//span[contains(@id, 'select2-school')]")
    WebElement schoolE;
    @FindBy(id = "other_school")
    WebElement otherSchoolE;
    @FindBy(xpath = "//span[contains(@id, 'select2-faculty')]")
    WebElement facultyE;
    @FindBy(id = "other_fac")
    WebElement otherFacultyE;
    @FindBy(xpath = "//span[contains(@id, 'select2-degree')]")
    WebElement qualificationE;
    @FindBy(id = "other_degree")
    WebElement otherQualificationE;
    @FindBy(xpath = "//span[contains(@id, 'select2-major')]")
    WebElement majorE;
    @FindBy(id = "other_major")
    WebElement otherMajorE;
    @FindBy(xpath = "//span[contains(@id, 'select2-university_average')]")
    WebElement universityAverageE;
    @FindBy(name = "grade_text")
    WebElement gradeE;
    @FindBy(xpath = "//span[contains(@id, 'select2-Year')]")
    WebElement graduationYearE;
    @FindBy(name = "notes")
    WebElement educationNotesE;
    @FindBy(id = "certificate_path")
    WebElement attachmentFile;
    @FindBy(xpath = "//img[@alt='Attachment Thumbnail']")
    WebElement checkAttachmentImg;
    @FindBy(xpath = "//div[@class='col-md-3']//a[1]")
    WebElement checkAttachmentFile;
    @FindBy(xpath = "//input[@name='Education_Minor'][@value='1']")
    WebElement educationMinorYes;
    @FindBy(xpath = "//input[@name='Education_Minor'][@value='2']")
    WebElement educationMinorNo;
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
    @FindBy(xpath = "//img[@alt='Attachment Thumbnail']")
    List<WebElement> checkAttach;
    @FindBy(xpath = "//div[@class='div-delete-employee']")
    List<WebElement> checkDeleteAttachment;
    @FindBy(xpath = "//img[contains(@src, 'locked_attachment.png')]")
    WebElement checkAttachForUserDontHavePermission;

    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    WebElement item;
    @FindBy(xpath =  "//ul[contains(@class, 'bg-icon')]//li[@class='nav-item']")
    List<WebElement> items;
    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'Education.php')]")
    WebElement educationPage;
    SoftAssert softAssert = new SoftAssert();
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    PersonnelInformation personnelInformation;
    AttachmentsSetup attachmentsSetup;
    String employeeCode = null;
    PersonalInformation_OCT personalInformationOct;

    public void goToEducation(){
        if(!versionGetter().equalsIgnoreCase("OCT")){
            clickOn(educationPage);
            elementWaitAdvanced(By.id("start_date"));
        }
    }

    public void addEducation(String startDate, String endDate, boolean untilNow, String country, String city, String school,
                             String otherSchool, String faculty, String otherFaculty, String qualification, String otherQualification,
                             String major, String otherMajor, String universityAverage, String grade, String graduationYear, String educationNotes,
                             String educationMinor){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            hold(500);
            elementWaitAdvanced(By.id("start_date"));
            setText(startDateE, startDate);
            setText(endDateE, endDate);
            if(untilNow){
                clickOn(untilNowE);
            }
            selectOption(countryE, country);
            selectOption(cityE, city);
            selectOption(schoolE, school);
            if(school.equalsIgnoreCase("Other")){
                setText(otherSchoolE, otherSchool);
            }
            selectOption(facultyE, faculty);
            if(faculty.equalsIgnoreCase("Other")){
                setText(otherFacultyE, otherFaculty);
            }
            selectOption(qualificationE, qualification);
            if(qualification.equalsIgnoreCase("Other")){
                setText(otherQualificationE, otherQualification);
            }
            scrollToElement(educationNotesE);
            selectOption(majorE, major);
            if(major.equalsIgnoreCase("Other")){
                setText(otherMajorE, otherMajor);
            }
            selectOption(universityAverageE, universityAverage);
            setText(gradeE, grade);
            selectOption(graduationYearE, graduationYear);
            setText(educationNotesE, educationNotes);

            if(!liteGetter()){
                attachmentFile.sendKeys(uploadRandomImage());
            }

            if(educationMinor.equalsIgnoreCase("Yes")){
                clickOn(educationMinorYes);
            }else{
                clickOn(educationMinorNo);
            }
            scrollToElement(empCode);
            clickOn(saveBtn);
            hold(300);

        }else {

            personalInformationOct = new PersonalInformation_OCT();
            personalInformationOct.addEducation(startDate, endDate, untilNow, country, city, school,
                    otherSchool, faculty, otherFaculty, qualification, otherQualification,
                    major, otherMajor, universityAverage, grade, graduationYear, educationNotes,
                    educationMinor);

        }

    }

    public void addEducationWithAssertion(String startDate, String endDate, boolean untilNow, String country, String city, String school,
                                          String otherSchool, String faculty, String otherFaculty, String qualification, String otherQualification,
                                          String major, String otherMajor, String universityAverage, String grade, String graduationYear, String educationNotes,
                                          String educationMinor){

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
        clickOn(educationPage);
        hold(300);
        addEducation(startDate, endDate, untilNow, country, city, school, otherSchool, faculty, otherFaculty, qualification,
                otherQualification, major, otherMajor, universityAverage, grade, graduationYear, educationNotes, educationMinor);

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);
        softAssert.assertEquals(startDateE.getAttribute("value"), startDate, "- Start Date");
        softAssert.assertEquals(endDateE.getAttribute("value"), endDate, "- End Date");
        softAssert.assertEquals(untilNowE.isSelected(), untilNow, "- Until Now");
        softAssert.assertEquals(countryE.getText(), country, "- Country");
        softAssert.assertEquals(cityE.getText(), city, "- City");
        softAssert.assertEquals(schoolE.getText(), school, "- School");
        softAssert.assertEquals(otherSchoolE.getAttribute("value"), otherSchool, "- Other School");
        softAssert.assertEquals(facultyE.getText(), faculty, "- Faculty");
        softAssert.assertEquals(otherFacultyE.getAttribute("value"), otherFaculty, "- Other Faculty");
        softAssert.assertEquals(qualificationE.getText(), qualification, "- Qualification");
        softAssert.assertEquals(otherQualificationE.getAttribute("value"), otherQualification, "- Other Qualification");
        softAssert.assertEquals(majorE.getText(), major, "- Major");
        softAssert.assertEquals(otherMajorE.getAttribute("value"), otherMajor, "- Other Major");
        softAssert.assertEquals(universityAverageE.getText(), universityAverage, "- University Average");
        softAssert.assertEquals(gradeE.getAttribute("value"), grade, "- Grade");
        softAssert.assertEquals(graduationYearE.getText(), graduationYear, "- Graduation Year");
        softAssert.assertEquals(educationNotesE.getAttribute("value"), educationNotes, "- Education Notes");
        if(!liteGetter()){
            softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
            softAssert.assertFalse(checkAttachmentFile.getAttribute("onclick").isEmpty(), "- Attachment File");
        }
        if(educationMinor.equalsIgnoreCase("Yes")){
            softAssert.assertTrue(educationMinorYes.isSelected(), "Education Minor: Yes");
        } else if (educationMinor.equalsIgnoreCase("No")) {
            softAssert.assertTrue(educationMinorNo.isSelected(), "Education Minor: No");
        }

        softAssert.assertAll();

    }

    public void editEducation(){

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
        clickOn(educationPage);
        hold(300);
        addEducation("01/01/2013", "08/08/2018", false, "Jordan", "Zarqa", "Schools 1",
                "", "Faculties 1", "", "Academic Degrees 1", "", "Majors 1", "",
                "Very Good", "80.500", "2018", "Education Note Test", "Yes");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);
        startDateE.clear();
        hold(300);
        setText(startDateE, "10/10/2012");
        endDateE.clear();
        hold(300);
        setText(endDateE, "05/05/2017");
        selectOption(schoolE, "Schools 2");
        scrollToElement(educationNotesE);
        selectOption(facultyE, "Faculties 2");
        selectOption(majorE, "Majors 2");
        selectOption(universityAverageE, "Excellent");
        gradeE.clear();
        hold(300);
        setText(gradeE, "85.700");
        selectOption(graduationYearE, "2017");
        educationNotesE.clear();
        hold(300);
        setText(educationNotesE, "Edited Edu");
        clickOn(educationMinorNo);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(300);
        clickOn(item);
        hold(300);

        softAssert.assertEquals(startDateE.getAttribute("value"), "10/10/2012");
        softAssert.assertEquals(endDateE.getAttribute("value"), "05/05/2017");
        softAssert.assertEquals(schoolE.getText(), "Schools 2");
        softAssert.assertEquals(facultyE.getText(), "Faculties 2");
        softAssert.assertEquals(majorE.getText(), "Majors 2");
        softAssert.assertEquals(universityAverageE.getText(), "Excellent");
        softAssert.assertEquals(gradeE.getAttribute("value"), "85.700");
        softAssert.assertEquals(graduationYearE.getText(), "2017");
        softAssert.assertEquals(educationNotesE.getAttribute("value"), "Edited Edu");
        softAssert.assertTrue(educationMinorNo.isSelected());
        softAssert.assertAll();

    }

    public void deleteEducation(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(educationPage);
        hold(300);
        addEducation("01/01/2013", "08/08/2018", false, "Jordan", "Zarqa", "Schools 1",
                "", "Faculties 1", "", "Academic Degrees 1", "", "Majors 1", "",
                "Very Good", "80.500", "2018", "Education Note Test", "Yes");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);
        clickOn(deleteBtn);
        hold(500);
        clickOn(alertButtonOkDelete);
        hold(300);
        clickOn(educationPage);
        hold(300);
        Assert.assertTrue(checkElementIfNotAppear(items), "- item still appear");

    }

    public void addMoreThanOneRecord(int educationCount) {

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
        clickOn(educationPage);
        hold(300);

        for (int i = 1; i <= educationCount; i++) {

            String randNum = String.valueOf(randomNumber2());
            addEducation("01/0" + i + "/2013", "08/0" + i + "/2018", false, "Jordan", "Zarqa", "Schools 1",
                    "", "Faculties 1", "", "Academic Degrees 1", "", "Majors 1", "",
                    "", "", "", "Education Note Test " + randNum, "Yes");

            hold(300);
            clickOn(addBtn);
            hold(1500);

        }

        Assert.assertEquals(items.size(), educationCount, "- issue in item counter");

    }

    public void validateFromDateAfterEndDate(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(educationPage);
        hold(300);
        addEducation("01/01/2013", "08/08/2011", false, "Jordan", "Zarqa", "Schools 1",
                "", "Faculties 1", "", "Academic Degrees 1", "", "Majors 1", "",
                "", "", "", "", "");

        hold(300);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The End Date Can Not Be Before The Start Date! Please Re-enter The End Date");
        softAssert.assertTrue(endDateE.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void validateGraduationYearBeforeEndDate(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(educationPage);
        hold(300);
        addEducation("01/01/2013", "08/08/2017", false, "Jordan", "Zarqa", "Schools 1",
                "", "Faculties 1", "", "Academic Degrees 1", "", "Majors 1", "",
                "", "", "2015", "", "");

        hold(300);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertTrue(alertText.getText().contains("The Graduation Year Can Not Be Before The End Date"), "- Alert Title issue");
        softAssert.assertAll();

    }

    public void validateFillSpecialCharactersInGradeField(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(educationPage);
        hold(300);
        addEducation("01/01/2013", "08/08/2017", false, "Jordan", "Zarqa", "Schools 1",
                "", "Faculties 1", "", "Academic Degrees 1", "", "Majors 1", "",
                "", "test", "2015", "", "");

        hold(300);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Should Only Contain Decimal Values.");
        softAssert.assertTrue(gradeE.getAttribute("class").contains("validationErrorCSS"), "- The Grade Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void validateMandatoryFields(){

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
        clickOn(educationPage);
        hold(300);

        softAssert.assertTrue(startDateE.getAttribute("validation").contains("required"), "Start Date Should be Mandatory!");
        softAssert.assertTrue(endDateE.getAttribute("validation").contains("required"), "End Date Should be Mandatory!");
        softAssert.assertTrue(driver.findElement(By.id("degree")).getAttribute("validation").contains("required"), "Qualification Should be Mandatory!");
        softAssert.assertTrue(driver.findElement(By.id("major")).getAttribute("validation").contains("required"), "Major Should be Mandatory!");

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Must Be Filled!");
        softAssert.assertTrue(startDateE.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        hold(500);
        clickOn(okBtnAlert);
        hold(200);
        setText(startDateE, "01/01/2012");
        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Must Be Filled!");
        softAssert.assertTrue(endDateE.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        hold(500);
        clickOn(okBtnAlert);
        hold(200);
        setText(endDateE, "01/01/2015");
        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Must Be Filled!");
        hold(500);
        clickOn(okBtnAlert);
        hold(200);
        selectOption(qualificationE, "Academic Degrees 1");
        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Must Be Filled!");
        hold(500);
        clickOn(okBtnAlert);
        scrollToElement(educationNotesE);
        hold(100);
        selectOption(majorE, "Majors 1");
        hold(500);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(300);
        softAssert.assertTrue(item.isDisplayed(), "Not Save!");
        softAssert.assertAll();

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

        hold(300);
        clickOn(educationPage);
        elementWaitAdvanced(By.id("start_date"));
        setText(startDateE, "01/01/2018");
        setText(endDateE, "01/01/2020");
        selectOption(qualificationE, "Academic Degrees 1");
        scrollToElement(educationNotesE);
        selectOption(majorE, "Majors 1");
        attachmentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile.getAttribute("href").isEmpty(), "- Attachment File");

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

        hold(300);
        clickOn(educationPage);
        elementWaitAdvanced(By.id("start_date"));
        setText(startDateE, "01/01/2018");
        setText(endDateE, "01/01/2020");
        selectOption(qualificationE, "Academic Degrees 1");
        scrollToElement(educationNotesE);
        selectOption(majorE, "Majors 1");
        attachmentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        scrollToElement(empCode);
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

        hold(300);
        clickOn(educationPage);
        elementWaitAdvanced(By.id("start_date"));
        setText(startDateE, "01/01/2018");
        setText(endDateE, "01/01/2020");
        selectOption(qualificationE, "Academic Degrees 1");
        scrollToElement(educationNotesE);
        selectOption(majorE, "Majors 1");
        attachmentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "File Size Exceed The Maximum Upload Size");
        softAssert.assertTrue(checkElementIfNotAppear(checkAttach), "- Attached ICON still appear");
        softAssert.assertTrue(checkElementIfNotAppear(checkDeleteAttachment), "- Delete Attachment ICON still appear");

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

        clickOn(educationPage);
        elementWaitAdvanced(By.id("start_date"));

        addEducation("01/01/2013", "08/08/2017", false, "", "", "",
                "", "Faculties 1", "", "Academic Degrees 1", "", "Majors 1", "",
                "", "", "", "", "");

        hold(300);
        clickOn(item);
        hold(300);

        softAssert.assertTrue(checkAttachForUserDontHavePermission.isDisplayed(), "- LOCKED Attachment NOT appear");
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

        employeeCode = empCode.getAttribute("value");

        closeIFrame();
        clickOn(personnelInformation.logout);
        hold(500);
        login.ali5User();
        menaModules.menaPAY();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);

        clickOn(educationPage);
        elementWaitAdvanced(By.id("start_date"));

        setText(startDateE, "01/01/2018");
        setText(endDateE, "01/01/2020");
        selectOption(qualificationE, "Academic Degrees 1");
        scrollToElement(educationNotesE);
        selectOption(majorE, "Majors 1");
        attachmentFile.sendKeys(uploadRandomImage());
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

        clickOn(educationPage);
        elementWaitAdvanced(By.id("start_date"));
        setText(startDateE, "01/01/2018");
        setText(endDateE, "01/01/2020");
        selectOption(qualificationE, "Academic Degrees 1");
        scrollToElement(educationNotesE);
        selectOption(majorE, "Majors 1");
        attachmentFile.sendKeys(uploadDocFile());
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