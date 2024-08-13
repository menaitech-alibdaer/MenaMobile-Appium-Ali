package webBackend.personnelInformation;

import bases.WebBase;
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

import utilities.MssqlConnect;

import java.util.List;

public class Dependents extends WebBase {

    @FindBy(id = "dep_name_man1")
    WebElement firstNameDependents;
    @FindBy(id = "dep_name_man2")
    WebElement secondNameDependents;
    @FindBy(id = "dep_name_man3")
    WebElement thirdNameDependents;
    @FindBy(id = "dep_name_man4")
    WebElement familyNameDependents;
    @FindBy(id = "dep_name_other1")
    WebElement firstArNameDependents;
    @FindBy(id = "dep_name_other2")
    WebElement secondArNameDependents;
    @FindBy(id = "dep_name_other3")
    WebElement thirdArNameDependents;
    @FindBy(id = "dep_name_other4")
    WebElement familyArNameDependents;
    @FindBy(xpath = "//div[@class='textAlign']//label[contains(@style, 'font-size:20px')]")
    WebElement alertText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    WebElement alertBox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addBtn;
    @FindBy(xpath = "//div[contains(@onclick, 'Dependencies.php')]")
    WebElement dependentsPage;
    @FindBy(xpath = "//span[contains(@onclick, 'confirm_delete')]")
    WebElement deleteDependentsBtn;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDeleteDependents;
    @FindBy(xpath = "//div[contains(@onclick, 'employment_information.php')]")
    WebElement employmentInformationPage;
    @FindBy(id = "body_frame")
    WebElement frame;
    @FindBy(id = "blah")
    WebElement checkPicture;
    @FindBy(name = "is_MC_covered")
    WebElement medicalClaimCoverageCheckbox;
    @FindBy(id = "claim_start_date")
    WebElement medicalClaimStartDateE;
    @FindBy(name = "insured")
    WebElement insuredCheckbox;
    @FindBy(id = "insurance_date")
    WebElement insuranceStartDateE;
    @FindBy(id = "dep_end_ins_date")
    WebElement insuranceCardExpiryE;
    @FindBy(xpath = "//span[contains(@id, 'select2-nationality')]")
    WebElement nationalityE;
    @FindBy(name = "national_code")
    WebElement nationalCodeE;
    @FindBy(xpath = "//span[contains(@id, 'select2-Gender')]")
    WebElement genderE;
    @FindBy(id = "birth_date")
    WebElement birthDateE;
    @FindBy(id = "dependent_picture")
    WebElement pictureE;
    @FindBy(xpath = "//span[contains(@id, 'select2-relegion')]")
    WebElement relegionE;
    @FindBy(xpath = "//span[contains(@id, 'select2-relationship')]")
    WebElement relationship;
    @FindBy(name = "ssn")
    WebElement GOSIe;
    @FindBy(name = "home_phone")
    WebElement homePhoneE;
    @FindBy(name = "street")
    WebElement streetE;
    @FindBy(name = "zip_code")
    WebElement zipCodeE;
    @FindBy(name = "city")
    WebElement cityE;
    @FindBy(name = "comments")
    WebElement commentsE;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    WebElement item;
    @FindBy(xpath =  "//ul[contains(@class, 'bg-icon')]//li[@class='nav-item']")
    List<WebElement> items;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    List<WebElement> checkItem;
    SoftAssert softAssert = new SoftAssert();
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    PersonnelInformation personnelInformation;
    PersonalInformation_OCT personalInformationOct;
    String employeeCode = null;

    public void addDependents(String relationships, String gender, String nationalCode, String GOSI, String birthDate,
                              String religion, String nationality, boolean medicalClaimCoverage, String medicalClaimStartDate,
                              boolean insured, String insuranceStartDate, String insuranceCardExpiry, String homePhone,
                              String street, String zipCode, String city, String comments){

        hold(500);
        elementWaitAdvanced(By.id("dep_name_man1"));
        employeeCode = empCode.getAttribute("value");
        setText(firstNameDependents, employeeCode+"FD");
        setText(secondNameDependents, employeeCode+"SD");
        setText(thirdNameDependents, employeeCode+"TD");
        setText(familyNameDependents, employeeCode+"LD");
        setText(firstArNameDependents, employeeCode+"FAD");
        setText(secondArNameDependents, employeeCode+"SAD");
        setText(thirdArNameDependents, employeeCode+"TAD");
        setText(familyArNameDependents, employeeCode+"LAD");
        selectOption(relationship, relationships);
        selectOption(genderE, gender);
        setText(nationalCodeE, nationalCode);
        setText(GOSIe, GOSI);
        scrollToElement(checkPicture);
        birthDateE.clear();
        hold(400);
        setText(birthDateE, birthDate);
        selectOption(relegionE, religion);
        selectOption(nationalityE, nationality);
        hold(400);

        if(!liteGetter()){
            if(medicalClaimCoverage){
                if(!medicalClaimCoverageCheckbox.isSelected()){
                    clickOn(medicalClaimCoverageCheckbox);
                }
                hold(400);
                setText(medicalClaimStartDateE, medicalClaimStartDate);
            }else{
                if(medicalClaimCoverageCheckbox.isSelected()){
                    clickOn(medicalClaimCoverageCheckbox);
                }
            }
        }

        hold(400);
        if(insured){
            clickOn(insuredCheckbox);
            hold(400);
            setText(insuranceStartDateE, insuranceStartDate);
            setText(insuranceCardExpiryE, insuranceCardExpiry);
        }
        hold(400);
        setText(homePhoneE, homePhone);
        setText(streetE, street);
        setText(zipCodeE, zipCode);
        setText(cityE, city);
        setText(commentsE, comments);
        //pictureE.sendKeys(uploadRandomImage());
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(300);

    }

    public void addDependents(String relationships, String gender, String nationalCode, String GOSI, String birthDate,
                              String religion, String nationality, boolean medicalClaimCoverage, String medicalClaimStartDate,
                              boolean insured, String insuranceStartDate, String insuranceCardExpiry, String homePhone,
                              String street, String zipCode, String city, String comments, boolean uploadPhoto){

        hold(500);
        elementWaitAdvanced(By.id("dep_name_man1"));
        employeeCode = empCode.getAttribute("value");
        setText(firstNameDependents, employeeCode+"FD");
        setText(secondNameDependents, employeeCode+"SD");
        setText(thirdNameDependents, employeeCode+"TD");
        setText(familyNameDependents, employeeCode+"LD");
        setText(firstArNameDependents, employeeCode+"FAD");
        setText(secondArNameDependents, employeeCode+"SAD");
        setText(thirdArNameDependents, employeeCode+"TAD");
        setText(familyArNameDependents, employeeCode+"LAD");
        selectOption(relationship, relationships);
        selectOption(genderE, gender);
        setText(nationalCodeE, nationalCode);
        setText(GOSIe, GOSI);
        scrollToElement(checkPicture);
        birthDateE.clear();
        hold(400);
        setText(birthDateE, birthDate);
        selectOption(relegionE, religion);
        selectOption(nationalityE, nationality);
        hold(400);

        if(!liteGetter()){
            if(medicalClaimCoverage){
                if(!medicalClaimCoverageCheckbox.isSelected()){
                    clickOn(medicalClaimCoverageCheckbox);
                }
                hold(400);
                setText(medicalClaimStartDateE, medicalClaimStartDate);
            }else{
                if(medicalClaimCoverageCheckbox.isSelected()){
                    clickOn(medicalClaimCoverageCheckbox);
                }
            }
        }

        hold(400);
        if(insured){
            clickOn(insuredCheckbox);
            hold(400);
            setText(insuranceStartDateE, insuranceStartDate);
            setText(insuranceCardExpiryE, insuranceCardExpiry);
        }
        hold(400);
        setText(homePhoneE, homePhone);
        setText(streetE, street);
        setText(zipCodeE, zipCode);
        setText(cityE, city);
        setText(commentsE, comments);
        if(uploadPhoto){
            pictureE.sendKeys(uploadRandomImage());
        }
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(300);

    }

    public void addDependent(String relationships, String gender, String nationalCode, String socialSecurityNumber, String birthDate,
                              String religion, String nationality, boolean medicalClaimCoverage, String medicalClaimStartDate,
                              boolean insured, String insuranceStartDate, String insuranceCardExpiry, String homePhone,
                              String street, String zipCode, String city, String comments){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            hold(500);
            clickOn(dependentsPage);
            elementWaitAdvanced(By.id("dep_name_man1"));
            employeeCode = empCode.getAttribute("value");
            setText(firstNameDependents, firstName());
            setText(secondNameDependents, "");
            setText(thirdNameDependents, "");
            setText(familyNameDependents, lastName());
            setText(firstArNameDependents, firstName());
            setText(secondArNameDependents, "");
            setText(thirdArNameDependents, "");
            setText(familyArNameDependents, lastName());
            selectOption(relationship, relationships);
            selectOption(genderE, gender);
            setText(nationalCodeE, nationalCode);
            setText(GOSIe, socialSecurityNumber);
            scrollToElement(checkPicture);
            birthDateE.clear();
            hold(400);
            setText(birthDateE, birthDate);
            selectOption(relegionE, religion);
            selectOption(nationalityE, nationality);
            hold(400);

            if(!liteGetter()){
                if(medicalClaimCoverage){
                    if(!medicalClaimCoverageCheckbox.isSelected()){
                        clickOn(medicalClaimCoverageCheckbox);
                    }
                    hold(400);
                    setText(medicalClaimStartDateE, medicalClaimStartDate);
                }else{
                    if(medicalClaimCoverageCheckbox.isSelected()){
                        clickOn(medicalClaimCoverageCheckbox);
                    }
                }
            }

            hold(400);
            if(insured){
                clickOn(insuredCheckbox);
                hold(400);
                setText(insuranceStartDateE, insuranceStartDate);
                setText(insuranceCardExpiryE, insuranceCardExpiry);
            }
            hold(400);
            setText(homePhoneE, homePhone);
            setText(streetE, street);
            setText(zipCodeE, zipCode);
            setText(cityE, city);
            setText(commentsE, comments);
            //pictureE.sendKeys(uploadRandomImage());
            scrollToElement(empCode);
            clickOn(saveBtn);
            hold(300);

        }else {

            personalInformationOct = new PersonalInformation_OCT();
            personalInformationOct.addDependent(relationships, gender, nationalCode, socialSecurityNumber, birthDate,
                    religion, nationality, medicalClaimCoverage, medicalClaimStartDate,
                    insured, insuranceStartDate, insuranceCardExpiry, homePhone,
                    street, zipCode, city, comments);

        }

    }

    public void addDependentsWithFirstAndLastName(String firstName, String lastName, String relationships, String gender, String nationalCode, String GOSI, String birthDate,
                              String religion, String nationality, boolean medicalClaimCoverage, String medicalClaimStartDate,
                              boolean insured, String insuranceStartDate, String insuranceCardExpiry, String homePhone,
                              String street, String zipCode, String city, String comments){

        hold(500);
        elementWaitAdvanced(By.id("dep_name_man1"));
        employeeCode = empCode.getAttribute("value");
        setText(firstNameDependents, firstName);
        setText(familyNameDependents, lastName);
        setText(firstArNameDependents, firstName);
        setText(familyArNameDependents, lastName);
        selectOption(relationship, relationships);
        selectOption(genderE, gender);
        setText(nationalCodeE, nationalCode);
        setText(GOSIe, GOSI);
        scrollToElement(checkPicture);
        birthDateE.clear();
        hold(400);
        setText(birthDateE, birthDate);
        selectOption(relegionE, religion);
        selectOption(nationalityE, nationality);
        hold(400);

        if(!liteGetter()){
            if(medicalClaimCoverage){
                if(!medicalClaimCoverageCheckbox.isSelected()){
                    clickOn(medicalClaimCoverageCheckbox);
                }
                hold(400);
                setText(medicalClaimStartDateE, medicalClaimStartDate);
            }else{
                if(medicalClaimCoverageCheckbox.isSelected()){
                    clickOn(medicalClaimCoverageCheckbox);
                }
            }
        }

        hold(400);
        if(insured){
            clickOn(insuredCheckbox);
            hold(400);
            setText(insuranceStartDateE, insuranceStartDate);
            setText(insuranceCardExpiryE, insuranceCardExpiry);
        }
        hold(400);
        setText(homePhoneE, homePhone);
        setText(streetE, street);
        setText(zipCodeE, zipCode);
        setText(cityE, city);
        setText(commentsE, comments);
        //pictureE.sendKeys(uploadRandomImage());
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(300);

    }

    public void addDependentsFullAssertion(String relationships, String gender, String nationalCode, String GOSI, String birthDate,
                                           String religion, String nationality, boolean medicalClaimCoverage, String medicalClaimStartDate,
                                           boolean insured, String insuranceStartDate, String insuranceCardExpiry, String homePhone,
                                           String street, String zipCode, String city, String comments){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("Amman", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        clickOn(dependentsPage);
        hold(300);
        elementWaitAdvanced(By.id("dep_name_man1"));

        addDependents(relationships, gender, nationalCode, GOSI, birthDate, religion, nationality, medicalClaimCoverage,
                medicalClaimStartDate, insured, insuranceStartDate, insuranceCardExpiry, homePhone, street, zipCode,
                city, comments);


        softAssert.assertTrue(item.isDisplayed(), "-Issue, Dependents Button Not Appear!");
        clickOn(item);
        hold(300);

        softAssert.assertEquals(firstNameDependents.getAttribute("value"), employeeCode+"FD");
        softAssert.assertEquals(secondNameDependents.getAttribute("value"), employeeCode+"SD");
        softAssert.assertEquals(thirdNameDependents.getAttribute("value"), employeeCode+"TD");
        softAssert.assertEquals(familyNameDependents.getAttribute("value"), employeeCode+"LD");
        softAssert.assertEquals(firstArNameDependents.getAttribute("value"), employeeCode+"FAD");
        softAssert.assertEquals(secondArNameDependents.getAttribute("value"), employeeCode+"SAD");
        softAssert.assertEquals(thirdArNameDependents.getAttribute("value"), employeeCode+"TAD");
        softAssert.assertEquals(familyArNameDependents.getAttribute("value"), employeeCode+"LAD");
        softAssert.assertEquals(relationship.getText(), relationships);
        softAssert.assertEquals(genderE.getText(), gender);
        softAssert.assertEquals(nationalCodeE.getAttribute("value"), nationalCode);
        softAssert.assertEquals(GOSIe.getAttribute("value"), GOSI);
        scrollToElement(checkPicture);
        softAssert.assertEquals(birthDateE.getAttribute("value"), birthDate);
        softAssert.assertEquals(relegionE.getText(), religion);
        softAssert.assertEquals(nationalityE.getText(), nationality);
        softAssert.assertEquals(insuredCheckbox.isSelected(), insured);
        if(insured){
            softAssert.assertEquals(insuranceStartDateE.getAttribute("value"), insuranceStartDate);
            softAssert.assertEquals(insuranceCardExpiryE.getAttribute("value"), insuranceCardExpiry);
        }
        if(!liteGetter()){
            softAssert.assertEquals(medicalClaimCoverageCheckbox.isSelected(), medicalClaimCoverage);
            if(medicalClaimCoverage){
                softAssert.assertEquals(medicalClaimStartDateE.getAttribute("value"), medicalClaimStartDate);
            }
        }
//        if(checkPicture.getAttribute("src").contains("Image/import.svg")){
//            softAssert.fail("The Photo Not Uploaded");
//        }else{
//            softAssert.assertEquals(VerifyImage(checkPicture), 200,"This image is broken : "+checkPicture.getAttribute("src"));
//        }

        softAssert.assertAll();

    }

    public void editDependents(boolean medicalClaimCoverage, boolean insured){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("Amman", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        clickOn(dependentsPage);
        hold(300);
        elementWaitAdvanced(By.id("dep_name_man1"));

        addDependents("Father", "Male", randomNumber2()+"1",
                randomNumber()+"37", "01/01/1950", "Islam", "Jordanian", true,
                "01/01/2020", true, "01/01/2020", "01/01/2030",
                "0538"+randomNumber2(), "ST NO."+randomNumber(), randomNumber()+"87",
                "Amman", "Test Comments in Dependents");


        softAssert.assertTrue(item.isDisplayed(), "-Issue, Children Button Not Appear!");
        clickOn(item);
        hold(300);

        elementWaitAdvanced(By.xpath("//li[@class='nav-item']//button[1]"));
        clickOn(employmentInformationPage);
        hold(300);
        elementWaitAdvanced(By.id("select2-site_1-container"));
        clickOn(dependentsPage);
        hold(500);
        elementWaitAdvanced(By.id("dep_name_man1"));
        clickOn(item);
        hold(300);

        firstNameDependents.clear();
        hold(200);
        setText(firstNameDependents, employeeCode+"Edited");
        familyNameDependents.clear();
        hold(200);
        setText(familyNameDependents, employeeCode+"Edited");
        hold(200);
        selectOption(relationship, "Brother");
        String nationalCodeEdit = randomNumber()+"11";
        nationalCodeE.clear();
        hold(200);
        setText(nationalCodeE, nationalCodeEdit);
        hold(200);
        GOSIe.clear();
        String GOSIEdit = randomNumber2()+"99";
        hold(200);
        setText(GOSIe, GOSIEdit);
        scrollToElement(checkPicture);
        birthDateE.clear();
        hold(200);
        setText(birthDateE, "10/10/1971");
        selectOption(nationalityE, "Egyptian");
        hold(400);
        if(insured){
            if(insuredCheckbox.isSelected()){
                insuranceStartDateE.clear();
                hold(200);
                setText(insuranceStartDateE, "02/02/2022");
            }
        }else{
            if(insuredCheckbox.isSelected()){
                insuredCheckbox.click();
            }
        }
        hold(400);
        if(!liteGetter()){
            if(medicalClaimCoverage){
                if(!medicalClaimCoverageCheckbox.isSelected()){
                    clickOn(medicalClaimCoverageCheckbox);
                }
            }else{
                if(medicalClaimCoverageCheckbox.isSelected()){
                    clickOn(medicalClaimCoverageCheckbox);
                }
            }
        }
        homePhoneE.clear();
        String homePhoneEdit = "078"+randomNumber2();
        hold(200);
        setText(homePhoneE, homePhoneEdit);
        streetE.clear();
        String streetEdit = "Edited "+randomNumber();
        hold(200);
        setText(streetE, streetEdit);
        hold(500);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertEquals(firstNameDependents.getAttribute("value"), employeeCode+"Edited");
        softAssert.assertEquals(familyNameDependents.getAttribute("value"), employeeCode+"Edited");
        softAssert.assertEquals(relationship.getText(), "Brother");
        softAssert.assertEquals(nationalCodeE.getAttribute("value"), nationalCodeEdit);
        softAssert.assertEquals(GOSIe.getAttribute("value"), GOSIEdit);
        softAssert.assertEquals(birthDateE.getAttribute("value"), "10/10/1971");
        softAssert.assertEquals(nationalityE.getText(), "Egyptian");
        if(!liteGetter()){
            softAssert.assertEquals(medicalClaimCoverageCheckbox.isSelected(), medicalClaimCoverage);
        }
        softAssert.assertEquals(insuredCheckbox.isSelected(), insured);
        if(insured){
            softAssert.assertEquals(insuranceStartDateE.getAttribute("value"), "02/02/2022");
        }
        softAssert.assertEquals(homePhoneE.getAttribute("value"), homePhoneEdit);
        softAssert.assertEquals(streetE.getAttribute("value"), streetEdit);
        softAssert.assertAll();

    }

    public void deleteDependents(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("Amman", "Development", "PHP Development",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "PHP Developer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(dependentsPage);
        hold(300);
        elementWaitAdvanced(By.id("dep_name_man1"));

        addDependents("Father", "Male", "",
                "", "01/01/1950", "", "Jordanian", false,
                "", false, "", "",
                "", "", "", "", "");

        clickOn(item);
        hold(300);

        elementWaitAdvanced(By.xpath("//li[@class='nav-item']//button[1]"));
        clickOn(deleteDependentsBtn);
        hold(500);
        clickOn(alertButtonOkDeleteDependents);
        hold(500);
        clickOn(dependentsPage);
        hold(300);
        elementWaitAdvanced(By.id("dep_name_man1"));
        Assert.assertTrue(checkElementIfNotAppear(checkItem));

    }

    public void uploadPhotoWithWrongExtension(){

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

        hold(300);
        clickOn(dependentsPage);

        addDependents("Father", "Male", "",
                "", "01/01/1950", "", "", false,
                "", false, "", "",
                "", "", "", "", "");

        clickOn(item);
        hold(300);
        scrollToElement(checkPicture);
        hold(500);
        pictureE.sendKeys(uploadDocFile());
        hold(500);
        scrollToElement(empCode);
        hold(100);
        clickOn(saveBtn);
        hold(300);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Can Not Upload Any File With The Extension: docx");
        softAssert.assertAll();

    }

    public void uploadPhotoNotAllowedUser(){

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
        hold(300);
        login.ali5User();
        menaModules.menaPAY();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        hold(300);
        clickOn(dependentsPage);

        addDependents("Father", "Male", "",
                "", "01/01/1950", "", "", false,
                "", false, "", "",
                "", "", "", "", "", true);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Do Not Have Permission To Upload Files!");
        softAssert.assertAll();

    }

    public void changePhoto(){

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

        hold(300);
        clickOn(dependentsPage);

        addDependents("Father", "Male", "",
                "", "01/01/1950", "", "", false,
                "", false, "", "",
                "", "", "", "", "");
        clickOn(item);
        hold(300);
        scrollToElement(checkPicture);
        hold(500);
        pictureE.sendKeys(uploadRandomImage());
        hold(500);
        scrollToElement(empCode);
        hold(100);
        clickOn(saveBtn);
        hold(300);
        Assert.assertEquals(VerifyImage(checkPicture), 200,"This image is broken : "+checkPicture.getAttribute("src"));

    }

    public void addMoreThanOneDependents(int dependentsCount){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("Amman", "Development", "PHP Development",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "PHP Developer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(dependentsPage);
        hold(300);
        elementWaitAdvanced(By.id("dep_name_man1"));
        hold(300);

        for (int i = 1; i <= dependentsCount; i++){

            String randNum = String.valueOf(randomNumber2());
            addDependentsWithFirstAndLastName(randNum+" Dep "+i, randNum+" LDep "+i, "Brother",
                    "Male", "", "", "01/01/1999", "", "Jordanian",
                    false, "", false, "", "",
                    "", "", "", "", "");

            hold(300);
            clickOn(addBtn);
            hold(500);

        }

        Assert.assertEquals(items.size(), dependentsCount, "Issue in the number of Dependents!");

    }

    public void flag_is_claim(String flag){

        MssqlConnect.sqlQuery("update adm_company set is_claim = "+flag+" where company_code = 'automation'");

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

        hold(300);
        clickOn(dependentsPage);
        hold(300);
        scrollToElement(checkPicture);

        if(flag.equals("0")){
            softAssert.assertEquals(medicalClaimCoverageCheckbox.getAttribute("disabled"), "true", "- Medical Claim Coverage Should be Hidden");
        }else{
            softAssert.assertEquals(medicalClaimCoverageCheckbox.getAttribute("disabled"), null, "- Medical Claim Coverage Should be Appear");
        }
        MssqlConnect.sqlQuery("update adm_company set is_claim = 1 where company_code = 'automation'");
        softAssert.assertAll();

    }

    public void flag_is_equality(String flag){

        MssqlConnect.sqlQuery("update adm_branch set is_equality = "+flag+" where branch_code = 'auto_a1'");

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

        hold(300);
        clickOn(dependentsPage);
        hold(300);
        scrollToElement(checkPicture);

        if(flag.equals("1")){
            softAssert.assertTrue(checkElementIfNotAppear(driver.findElements(By.xpath("//span[contains(@id, 'select2-nationality')]"))), "The Nationality Field appear, it should be NOT Appear!");
        }else{
            softAssert.assertTrue(driver.findElements(By.xpath("//span[contains(@id, 'select2-nationality')]")).size()>0, "The Nationality Field Still NOT Appear!");
        }
        MssqlConnect.sqlQuery("update adm_branch set is_equality = 0 where branch_code = 'auto_a1'");
        softAssert.assertAll();

    }

}
