package webBackend.personnelInformation;

import bases.WebBase;
import webBackend.general.AttachmentsSetup;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static utilities.WebHelper.*;
import static utilities.VersionGetter.liteGetter;
import static utilities.VersionGetter.versionGetter;

import java.util.List;

public class Other extends WebBase {

    @FindBy(id = "select2-document_type-container")
    WebElement documentTypeE;
    @FindBy(id = "documrnt_code")
    WebElement documentCodeE;
    @FindBy(id = "document_issue_date")
    WebElement documentIssueE;
    @FindBy(id = "document_expiry_date")
    WebElement documentExpiryE;
    @FindBy(id = "release_place")
    WebElement placeOfIssueE;
    @FindBy(id = "insurance_number")
    WebElement insuranceCodeE;
    @FindBy(id = "search_word")
    WebElement keyWordE;
    @FindBy(id = "universal_code")
    WebElement universalCodeE;
    @FindBy(id = "national_code")
    WebElement nationalCodeE;
    @FindBy(id = "social_code")
    WebElement socialCodeGOSIE;
    @FindBy(id = "tax_code")
    WebElement taxCodeE;
    @FindBy(id = "ext_number")
    WebElement extNumberE;
    @FindBy(id = "gradeate_da_te")
    WebElement graduationYearE;
    @FindBy(id = "mother_name")
    WebElement motherNameE;
    @FindBy(id = "select2-birth_place-container")
    WebElement birthPlaceE;
    @FindBy(id = "marry_date")
    WebElement marriageDateE;
    @FindBy(id = "personal_number")
    WebElement personalNumberE;
    @FindBy(id = "card_id")
    WebElement cardIdE;
    @FindBy(id = "shift_or_roster_1")
    WebElement rosterE;
    @FindBy(id = "shift_or_roster_2")
    WebElement regularShiftE;
    @FindBy(id = "select2-shift_code_type-container")
    WebElement shiftTypeE;
    @FindBy(id = "select2-shift_code-container")
    WebElement shiftCode;
    @FindBy(id = "extra_date1")
    WebElement extraDate1E;
    @FindBy(id = "extra_date2")
    WebElement extraDate2E;
    @FindBy(id = "extra_date3")
    WebElement extraDate3E;
    @FindBy(id = "upgrade_date")
    WebElement upgradeDateE;
    @FindBy(id = "degree_date")
    WebElement classificationDateE;
    @FindBy(id = "military_class_period")
    WebElement militaryServiceClassifiedPeriodE;
    @FindBy(id = "military_unclass_period")
    WebElement militaryServiceUnclassifiedPeriodE;
    @FindBy(id = "CSB_number")
    WebElement civilServiceNumberE;
    @FindBy(name = "is_MC_covered")
    WebElement medicalClaimCov;
    @FindBy(id = "deprived_from_training")
    WebElement deprivedFromTrainingE;
    @FindBy(id = "smoker")
    WebElement smokerE;
    @FindBy(id = "parking")
    WebElement parkingE;
    @FindBy(id = "is_mename_user")
    WebElement menaMEUserE;
    @FindBy(id = "is_excluded_from_ts")
    WebElement excludedFromE;
    @FindBy(name = "phone_directory_pic")
    WebElement showEmployeePhotoE;
    @FindBy(name = "phone_directory_phone")
    WebElement showEmployeeMobileE;
    @FindBy(id = "citizen")
    WebElement citizenE;
    @FindBy(id = "is_lecturer")
    WebElement lecturerCheckbox;
    @FindBy(xpath = "//span[contains(@id, 'select2-train_place')]")
    WebElement lecturerSiteE;
    @FindBy(xpath = "//span[contains(@id, 'select2-salary_slip_lang')]")
    WebElement salarySlipAndSmsLanguageE;
    @FindBy(id = "event_date")
    WebElement eventDateE;
    @FindBy(name = "event")
    WebElement eventEnglishE;
    @FindBy(name = "event_a")
    WebElement eventArabicE;
    @FindBy(xpath = "//span[contains(@id, 'select2-remind_days')]")
    WebElement remindBeforeE;
    @FindBy(name = "notes")
    WebElement notesEnglishE;
    @FindBy(name = "notes_a")
    WebElement notesArabicE;
    @FindBy(xpath = "//span[contains(@id, 'select2-medical_status')]")
    WebElement statusTypeE;
    @FindBy(id = "medical_date")
    WebElement statusDateE;
    @FindBy(id = "medical_attached_file")
    WebElement medicalAttachment;
    @FindBy(name = "status")
    WebElement statusE;
    @FindBy(name = "notes")
    WebElement notesE;
    @FindBy(id = "condition_date")
    WebElement caseDateE;
    @FindBy(id = "condition_end_date")
    WebElement caseEndDateE;
    @FindBy(id = "select2-condition_type-container")
    WebElement caseTypeE;
    @FindBy(id = "Support_documents")
    WebElement caseAttachment;
    @FindBy(name = "field_id")
    WebElement fieldNameE;
    @FindBy(id = "field_value_")
    WebElement fieldNumberE;
    @FindBy(id = "fields_value_e_")
    WebElement fieldTextEn;
    @FindBy(id = "field_value_")
    WebElement fieldTextAr;
    @FindBy(id = "date_")
    WebElement fieldDateE;
    @FindBy(id = "field_value_list_")
    WebElement fieldComboBoxE;
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
    @FindBy(xpath = "//label[contains(@style, 'font-size:20px')]")
    WebElement confirmText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    WebElement alertBox;
    @FindBy(xpath = "//label[contains(text(), 'Confirm')]")
    WebElement confirmBox;
    @FindBy(xpath = "//span[contains(@onclick, 'confirm_delete')]")
    WebElement deleteBtn;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement confirmOkBtn;
    @FindBy(id = "btok")
    WebElement okBtnAlert;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDelete;
    @FindBy(xpath = "//img[@alt='Attachment Thumbnail']")
    WebElement checkAttachment;
    @FindBy(xpath = "//div[@class='col-md-3']//a[1]")
    WebElement checkAttachmentURL;
    @FindBy(xpath = "//img[contains(@src, 'locked_attachment.png')]")
    WebElement checkAttachForUserDontHavePermission;
    @FindBy(xpath = "//img[@alt='Attachment Thumbnail']")
    List<WebElement> checkAttach;
    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'official_documents.php')]")
    WebElement otherTab;
    @FindBy(xpath = "//div[contains(@onclick, 'shift_details.php')]")
    WebElement shiftDetailsPage;
    @FindBy(xpath = "//div[contains(@onclick, 'extradates_Info.php')]")
    WebElement extraDatesAndInfoPage;
    @FindBy(xpath = "//div[contains(@onclick, 'miscellaneous.php')]")
    WebElement miscellaneousPage;
    @FindBy(xpath = "//div[contains(@onclick, 'Events.php')]")
    WebElement eventsPage;
    @FindBy(xpath = "//div[contains(@onclick, 'medical_profile.php')]")
    WebElement medicalProfilePage;
    @FindBy(xpath = "//div[contains(@onclick, 'special_conditions.php')]")
    WebElement specialCasesPage;
    @FindBy(xpath = "//div[contains(@onclick, 'extra_data.php')]")
    WebElement additionalInformationPage;
    SoftAssert softAssert = new SoftAssert();
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    AttachmentsSetup attachmentsSetup;
    PersonnelInformation personnelInformation;
    String random1 = String.valueOf(randomNumber());
    String random2 = String.valueOf(randomNumber2());
    String employeeCode = null;
    PersonalInformation_OCT personalInformationOct;

    /////// Official Documents ////////

    public void addOfficialDocuments(String documentType, String documentCode, String documentIssue, String documentExpiry, String placeOfIssue,
                                     String insuranceCode, String keyWord, String universalCode, String nationalCode, String socialSecurityGOSICode,
                                     String taxCode, String extNumber, String graduationYear, String motherName, String birthPlace, String marriageDate,
                                     String personalNumber){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            hold(500);
            elementWaitAdvanced(By.id("documrnt_code"));
            selectOption(documentTypeE, documentType);
            setText(documentCodeE, documentCode);
            setText(documentIssueE, documentIssue);
            setText(documentExpiryE, documentExpiry);
            setText(placeOfIssueE, placeOfIssue);
            setText(insuranceCodeE, insuranceCode);
            setText(keyWordE, keyWord);
            if(!liteGetter()){
                setText(universalCodeE, universalCode);
            }
            setText(nationalCodeE, nationalCode);
            setText(socialCodeGOSIE, socialSecurityGOSICode);
            setText(taxCodeE, taxCode);
            setText(extNumberE, extNumber);
            scrollToElement(motherNameE);
            setText(graduationYearE, graduationYear);
            setText(motherNameE, motherName);
            if(!marriageDate.isEmpty()){
                setText(marriageDateE, marriageDate);
            }
            selectOption(birthPlaceE, birthPlace);
            setText(personalNumberE, personalNumber);
            scrollToElement(empCode);
            clickOn(saveBtn);
            hold(300);

        }else {

            personalInformationOct = new PersonalInformation_OCT();
            personalInformationOct.otherInformation(documentType, documentCode, documentIssue, documentExpiry, placeOfIssue,
                    insuranceCode, keyWord, universalCode, nationalCode, socialSecurityGOSICode,
                    taxCode, extNumber, graduationYear, motherName, birthPlace, marriageDate,
                    personalNumber);

        }

    }

    public void goToOfficialDocuments(){
        if(!versionGetter().equalsIgnoreCase("OCT")){
            clickOn(otherTab);
            hold(500);
            elementWaitAdvanced(By.name("documrnt_code"));
            hold(300);
        }else {
            personalInformationOct = new PersonalInformation_OCT();
            clickOn(personalInformationOct.otherInformationTab);
            hold(500);
            elementWaitAdvanced(By.name("documrnt_code"));
        }
    }

    public void addOfficialDocumentsWithAssertion(String documentType, String documentCode, String documentIssue, String documentExpiry, String placeOfIssue,
                                                  String insuranceCode, String keyWord, String universalCode, String nationalCode, String socialSecurityGOSICode,
                                                  String taxCode, String extNumber, String graduationYear, String motherName, String birthPlace, String marriageDate,
                                                  String personalNumber){

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
        clickOn(otherTab);
        hold(500);
        addOfficialDocuments(documentType, documentCode, documentIssue, documentExpiry, placeOfIssue, insuranceCode,
                keyWord, universalCode, nationalCode, socialSecurityGOSICode, taxCode, extNumber, graduationYear,
                motherName, birthPlace, marriageDate, personalNumber);

        softAssert.assertEquals(documentTypeE.getText(), documentType);
        softAssert.assertEquals(documentCodeE.getDomAttribute("value"), documentCode);
        softAssert.assertEquals(documentIssueE.getDomAttribute("value"), documentIssue);
        softAssert.assertEquals(documentExpiryE.getDomAttribute("value"), documentExpiry);
        softAssert.assertEquals(placeOfIssueE.getDomAttribute("value"), placeOfIssue);
        softAssert.assertEquals(insuranceCodeE.getDomAttribute("value"), insuranceCode);
        softAssert.assertEquals(keyWordE.getDomAttribute("value"), keyWord);
        if(!liteGetter()){
            softAssert.assertEquals(universalCodeE.getDomAttribute("value"), universalCode);
        }
        softAssert.assertEquals(nationalCodeE.getDomAttribute("value"), nationalCode);
        softAssert.assertEquals(socialCodeGOSIE.getDomAttribute("value"), socialSecurityGOSICode);
        softAssert.assertEquals(taxCodeE.getDomAttribute("value"), taxCode);
        softAssert.assertEquals(extNumberE.getDomAttribute("value"), extNumber);
        softAssert.assertEquals(graduationYearE.getDomAttribute("value"), graduationYear);
        softAssert.assertEquals(motherNameE.getDomAttribute("value"), motherName);
        softAssert.assertEquals(birthPlaceE.getText(), birthPlace);
        if(personnelInformation.maritalStatus.equalsIgnoreCase("Single")){
            softAssert.assertEquals(marriageDateE.getDomAttribute("disabled"), "true", "- Marriage Date Field Should be Disabled when employee status is: Single!");
        }else{
            softAssert.assertEquals(marriageDateE.getDomAttribute("disabled"), null, "- Marriage Date Field Should be NOT Disabled when employee status NOT Single!");
        }
        softAssert.assertEquals(marriageDateE.getDomAttribute("value"), marriageDate);
        softAssert.assertEquals(personalNumberE.getDomAttribute("value"), personalNumber);
        softAssert.assertAll();

    }

    public void editOfficialDocuments(){

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
        clickOn(otherTab);
        hold(500);
        addOfficialDocuments("Passport", "", "11/11/2020", "12/12/2033",
                "Test Place", "", "", "", "", "",
                "", "", "2014", "Mother Name", "Birth Place 1",
                "", "");

        selectOption(documentTypeE, "Passport");
        documentCodeE.clear();
        hold(300);
        String rand = random2;
        setText(documentCodeE, rand);
        documentIssueE.clear();
        hold(300);
        setText(documentIssueE, "03/03/2019");
        insuranceCodeE.clear();
        hold(300);
        setText(insuranceCodeE, "3235845");
        clickOn(saveBtn);
        hold(300);
        softAssert.assertEquals(documentTypeE.getText(), "Passport");
        softAssert.assertEquals(documentCodeE.getDomAttribute("value"), rand, "Document Code!");
        softAssert.assertEquals(documentIssueE.getDomAttribute("value"), "03/03/2019");
        softAssert.assertEquals(insuranceCodeE.getDomAttribute("value"), "3235845");
        softAssert.assertAll();

    }

    public void deleteOfficialDocuments(){

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
        clickOn(otherTab);
        hold(500);
        addOfficialDocuments("Passport", random1, "11/11/2020", "12/12/2033",
                "Test Place", random2, random1, random2, random1, "1254"+random2,
                random1, "11", "2014", "Mother Name", "Birth Place 1",
                "", "451"+random2);

        selectOption(documentTypeE, "Choose");
        documentCodeE.clear();
        documentIssueE.clear();
        documentExpiryE.clear();
        placeOfIssueE.clear();
        insuranceCodeE.clear();
        keyWordE.clear();
        if(!liteGetter()){
            universalCodeE.clear();
        }
        nationalCodeE.clear();
        socialCodeGOSIE.clear();
        taxCodeE.clear();
        extNumberE.clear();
        scrollToElement(personalNumberE);
        graduationYearE.clear();
        motherNameE.clear();
        selectOption(birthPlaceE, "Choose");
        if(!personnelInformation.maritalStatus.equalsIgnoreCase("Single")){
            marriageDateE.clear();
        }
        personalNumberE.clear();
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertEquals(documentTypeE.getText(), "Choose");
        softAssert.assertTrue(documentCodeE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(documentIssueE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(documentExpiryE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(placeOfIssueE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(insuranceCodeE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(keyWordE.getDomAttribute("value").isEmpty());
        if(!liteGetter()){
            softAssert.assertTrue(universalCodeE.getDomAttribute("value").isEmpty());
        }
        softAssert.assertTrue(nationalCodeE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(socialCodeGOSIE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(taxCodeE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(extNumberE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(graduationYearE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(motherNameE.getDomAttribute("value").isEmpty());
        softAssert.assertEquals(birthPlaceE.getText(), "Choose");
        if(personnelInformation.maritalStatus.equalsIgnoreCase("Single")){
            softAssert.assertEquals(marriageDateE.getDomAttribute("disabled"), "true", "- Marriage Date Field Should be Disabled when employee status is: Single!");
        }else{
            softAssert.assertEquals(marriageDateE.getDomAttribute("disabled"), null, "- Marriage Date Field Should be NOT Disabled when employee status NOT Single!");
        }
        softAssert.assertTrue(marriageDateE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(personalNumberE.getDomAttribute("value").isEmpty());
        softAssert.assertAll();

    }

    public void validateTheDocumentExpireDate(){

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
        clickOn(otherTab);
        hold(500);
        addOfficialDocuments("Passport", "", "11/11/2020", "12/12/2021",
                "Test Place", "", "", "", "", "",
                "", "", "", "", "",
                "", "");

        softAssert.assertTrue(confirmBox.isDisplayed(), "- Confirm Box Not Appear!");
        softAssert.assertEquals(confirmText.getText().trim(), "The Document You Entered Has Expired, But Saving Will Complete!");
        hold(200);
        clickOn(confirmOkBtn);
        hold(1500);
        softAssert.assertEquals(documentExpiryE.getDomAttribute("value"), "12/12/2021");
        softAssert.assertAll();

    }

    ////////////// Shift Details ////////////

    public void addShiftDetails(String cardId, String rosterOrRegular, String shiftType, String shift){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            hold(500);
            elementWaitAdvanced(By.id("card_id"));
            if(cardId.isEmpty()){
                setText(cardIdE, empCode.getDomAttribute("value"));
            }else{
                setText(cardIdE, cardId);
            }
            if(rosterOrRegular.equalsIgnoreCase("Roster")){
                clickOn(rosterE);
            }else if(rosterOrRegular.equalsIgnoreCase("Regular")){
                clickOn(regularShiftE);
            }
            selectOption(shiftTypeE, shiftType);
            selectOption(shiftCode, shift);
            clickOn(saveBtn);
            hold(300);

        }else {

            personalInformationOct = new PersonalInformation_OCT();

            elementWaitAdvanced(By.id("card_id"));
            if(cardId.isEmpty()){
                setText(personalInformationOct.cardIdE, personalInformationOct.empCode.getDomAttribute("value"));
            }else{
                setText(personalInformationOct.cardIdE, cardId);
            }
            if(rosterOrRegular.equalsIgnoreCase("Roster")){
                clickOn(personalInformationOct.rosterE);
            }else if(rosterOrRegular.equalsIgnoreCase("Regular")){
                clickOn(personalInformationOct.regularShiftE);
            }
            normalSelect(personalInformationOct.shiftTypeE, shiftType);
            normalSelect(personalInformationOct.shiftCode, shift);
            hold(500);
            closeIFrame();
            goToFrame(personalInformationOct.menuFrame);
            hold(500);
            clickOn(personalInformationOct.menuSave);
            closeIFrame();
            hold(300);
            goToFrame(personalInformationOct.frame);
            hold(300);

        }

    }

    public void goToShiftDetails(){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            clickOn(otherTab);
            hold(500);
            elementWaitAdvanced(By.id("documrnt_code"));
            clickOn(shiftDetailsPage);
            hold(200);
            elementWaitAdvanced(By.id("card_id"));

        }else {

            personalInformationOct = new PersonalInformation_OCT();
            personalInformationOct.goToShiftDetails();
        }

    }

    public void addShiftDetailsWithAssertion(String cardId, String rosterOrRegular, String shiftType, String shift){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(shiftDetailsPage);
        hold(300);
        elementWaitAdvanced(By.id("card_id"));
        addShiftDetails(cardId, rosterOrRegular, shiftType, shift);
        elementWaitAdvanced(By.id("card_id"));
        if(cardId.isEmpty()){
            softAssert.assertEquals(cardIdE.getDomAttribute("value"), empCode.getDomAttribute("value"));
        }else{
            softAssert.assertEquals(cardIdE.getDomAttribute("value"), cardId);
        }
        if(rosterOrRegular.equalsIgnoreCase("Roster")){
            softAssert.assertTrue(rosterE.isSelected());
        }else if(rosterOrRegular.equalsIgnoreCase("Regular")){
            softAssert.assertTrue(regularShiftE.isSelected());
        }
        softAssert.assertEquals(shiftTypeE.getText(), shiftType);
        softAssert.assertEquals(shiftCode.getText(), shift);
        softAssert.assertAll();

    }

    public void editShiftDetails(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(shiftDetailsPage);
        hold(300);
        elementWaitAdvanced(By.id("card_id"));
        addShiftDetails("", "Regular", "Automation", "Automation 1");
        elementWaitAdvanced(By.id("card_id"));
        cardIdE.clear();
        hold(200);
        String rand = random2;
        setText(cardIdE, rand);
        hold(300);
        clickOn(rosterE);
        hold(300);
        clickOn(saveBtn);
        hold(300);
        elementWaitAdvanced(By.id("card_id"));

        softAssert.assertEquals(cardIdE.getDomAttribute("value"), rand, "- Card ID");
        softAssert.assertTrue(rosterE.isSelected(), "Roster NOT Selected");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--single'])[2]")).getDomAttribute("aria-disabled"), "true", "- Shift Type NOT Disabled");
        softAssert.assertEquals(driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--single'])[3]")).getDomAttribute("aria-disabled"), "true", "- Shift NOT Disabled");
        softAssert.assertAll();

    }

    public void deleteShiftDetails(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(shiftDetailsPage);
        hold(300);
        elementWaitAdvanced(By.id("card_id"));
        addShiftDetails("", "Regular", "Automation", "Automation 1");
        elementWaitAdvanced(By.id("card_id"));
        cardIdE.clear();
        selectOption(shiftTypeE, "Choose");
        clickOn(saveBtn);
        hold(300);
        elementWaitAdvanced(By.id("card_id"));
        softAssert.assertTrue(cardIdE.getDomAttribute("value").isEmpty());
        softAssert.assertEquals(shiftTypeE.getText(), "Choose");
        softAssert.assertEquals(shiftCode.getText(), "Choose");
        softAssert.assertAll();

    }

    /////////// Extra Dates and info ////////////


    public void addExtraDatesAndInfo(String extraDate1, String extraDate2, String extraDate3, String classificationDate,
                                     String militaryServiceClassifiedPeriod, String militaryServiceUnclassifiedPeriod, String civilServiceNumber){

        hold(500);
        elementWaitAdvanced(By.id("extra_date1"));
        setText(extraDate1E, extraDate1);
        setText(extraDate2E, extraDate2);
        setText(extraDate3E, extraDate3);
        //setText(upgradeDateE, upgradeDate);
        setText(classificationDateE, classificationDate);
        if(!militaryServiceClassifiedPeriod.isEmpty()){
            militaryServiceClassifiedPeriodE.clear();
            hold(300);
            setText(militaryServiceClassifiedPeriodE, militaryServiceClassifiedPeriod);
        }
        if(!militaryServiceUnclassifiedPeriod.isEmpty()){
            militaryServiceUnclassifiedPeriodE.clear();
            hold(300);
            setText(militaryServiceUnclassifiedPeriodE, militaryServiceUnclassifiedPeriod);
        }
        setText(civilServiceNumberE, civilServiceNumber);
        clickOn(saveBtn);
        hold(300);
        elementWaitAdvanced(By.id("extra_date1"));

    }

    public void addExtraDatesAndInfoWithAssertion(String extraDate1, String extraDate2, String extraDate3, String upgradeDate, String classificationDate,
                                                  String militaryServiceClassifiedPeriod, String militaryServiceUnclassifiedPeriod, String civilServiceNumber){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(extraDatesAndInfoPage);
        hold(500);
        addExtraDatesAndInfo(extraDate1, extraDate2, extraDate3, classificationDate, militaryServiceClassifiedPeriod, militaryServiceUnclassifiedPeriod, civilServiceNumber);
        softAssert.assertEquals(extraDate1E.getDomAttribute("value"), extraDate1);
        softAssert.assertEquals(extraDate2E.getDomAttribute("value"), extraDate2);
        softAssert.assertEquals(extraDate3E.getDomAttribute("value"), extraDate3);
        //softAssert.assertEquals(upgradeDateE.getDomAttribute("value"), upgradeDate);
        softAssert.assertEquals(classificationDateE.getDomAttribute("value"), classificationDate);
        if(militaryServiceClassifiedPeriod.isEmpty()){
            softAssert.assertEquals(militaryServiceClassifiedPeriodE.getDomAttribute("value"), "0.000");
        }else{
            softAssert.assertEquals(militaryServiceClassifiedPeriodE.getDomAttribute("value"), militaryServiceClassifiedPeriod);
        }
        if(militaryServiceUnclassifiedPeriod.isEmpty()){
            softAssert.assertEquals(militaryServiceUnclassifiedPeriodE.getDomAttribute("value"), "0.000");
        }else{
            softAssert.assertEquals(militaryServiceUnclassifiedPeriodE.getDomAttribute("value"), militaryServiceUnclassifiedPeriod);
        }
        softAssert.assertAll();

    }

    public void editExtraDatesAndInfo(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(extraDatesAndInfoPage);
        hold(500);
        addExtraDatesAndInfo("01/01/2018", "01/01/2019", "01/01/2020",
                "01/01/2022", "1.000", "0.500", random1);
        extraDate1E.clear();
        hold(300);
        setText(extraDate1E, "02/02/2018");
        extraDate2E.clear();
        hold(300);
        setText(extraDate2E, "02/02/2019");
        extraDate3E.clear();
        hold(300);
        setText(extraDate3E, "02/02/2020");
//        upgradeDateE.clear();
//        hold(300);
//        setText(upgradeDateE, "02/02/2021");
        classificationDateE.clear();
        hold(300);
        setText(classificationDateE, "02/02/2022");
        militaryServiceClassifiedPeriodE.clear();
        hold(300);
        setText(militaryServiceClassifiedPeriodE, "1.500");
        militaryServiceUnclassifiedPeriodE.clear();
        hold(300);
        setText(militaryServiceUnclassifiedPeriodE, "1.100");
        civilServiceNumberE.clear();
        hold(300);
        setText(civilServiceNumberE, "121200");
        clickOn(saveBtn);
        hold(300);
        elementWaitAdvanced(By.id("extra_date1"));
        clickOn(extraDatesAndInfoPage);
        hold(300);
        elementWaitAdvanced(By.id("extra_date1"));
        softAssert.assertEquals(extraDate1E.getDomAttribute("value"), "02/02/2018");
        softAssert.assertEquals(extraDate2E.getDomAttribute("value"), "02/02/2019");
        softAssert.assertEquals(extraDate3E.getDomAttribute("value"), "02/02/2020");
        //softAssert.assertEquals(upgradeDateE.getDomAttribute("value"), "02/02/2021");
        softAssert.assertEquals(militaryServiceClassifiedPeriodE.getDomAttribute("value"), "1.500");
        softAssert.assertEquals(militaryServiceUnclassifiedPeriodE.getDomAttribute("value"), "1.100");
        softAssert.assertEquals(civilServiceNumberE.getDomAttribute("value"), "121200");
        softAssert.assertAll();

    }

    public void deleteExtraDatesAndInfo(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(extraDatesAndInfoPage);
        hold(500);
        addExtraDatesAndInfo("01/01/2018", "01/01/2019", "01/01/2020",
                "01/01/2022", "1.000", "0.500", random1);
        extraDate1E.clear();
        extraDate2E.clear();
        extraDate3E.clear();
        upgradeDateE.clear();
        classificationDateE.clear();
        militaryServiceClassifiedPeriodE.clear();
        militaryServiceUnclassifiedPeriodE.clear();
        civilServiceNumberE.clear();
        clickOn(saveBtn);
        hold(300);
        elementWaitAdvanced(By.id("extra_date1"));
        clickOn(extraDatesAndInfoPage);
        hold(300);
        elementWaitAdvanced(By.id("extra_date1"));
        softAssert.assertTrue(extraDate1E.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(extraDate2E.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(extraDate3E.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(upgradeDateE.getDomAttribute("value").isEmpty());
        softAssert.assertEquals(militaryServiceClassifiedPeriodE.getDomAttribute("value"), "0.000");
        softAssert.assertEquals(militaryServiceUnclassifiedPeriodE.getDomAttribute("value"), "0.000");
        softAssert.assertTrue(civilServiceNumberE.getDomAttribute("value").isEmpty());
        softAssert.assertAll();

    }

    public void saveMiscellaneousOptions(boolean medicalClaim, boolean deprivedFrom, boolean smoker, boolean parking,
                                         boolean menaMEUser, boolean excludedFromTimeSheet, boolean showEmployeePhoto,
                                         boolean showEmployeeMobile, boolean citizen, boolean lecturer, String lecturerSite,
                                         String salarySlipAndSmsLanguage){

        hold(500);
        elementWaitAdvanced(By.name("is_MC_covered"));
        if(medicalClaim){
            if(!medicalClaimCov.isSelected()){
                clickOn(medicalClaimCov);
            }
        }else{
            if(medicalClaimCov.isSelected()){
                clickOn(medicalClaimCov);
            }
        }
        if(deprivedFrom){
            if(!deprivedFromTrainingE.isSelected()){
                clickOn(deprivedFromTrainingE);
            }
        }else{
            if(deprivedFromTrainingE.isSelected()){
                clickOn(deprivedFromTrainingE);
            }
        }
        if(smoker){
            if(!smokerE.isSelected()){
                clickOn(smokerE);
            }
        }else{
            if(smokerE.isSelected()){
                clickOn(smokerE);
            }
        }
        if(parking){
            if(!parkingE.isSelected()){
                clickOn(parkingE);
            }
        }else{
            if(parkingE.isSelected()){
                clickOn(parkingE);
            }
        }
        if(menaMEUser){
            if(!menaMEUserE.isSelected()){
                clickOn(menaMEUserE);
            }
        }else{
            if(menaMEUserE.isSelected()){
                clickOn(menaMEUserE);
            }
        }
        if(excludedFromTimeSheet){
            if(!excludedFromE.isSelected()){
                clickOn(excludedFromE);
            }
        }else{
            if(excludedFromE.isSelected()){
                clickOn(excludedFromE);
            }
        }
        if(showEmployeePhoto){
            if(!showEmployeePhotoE.isSelected()){
                clickOn(showEmployeePhotoE);
            }
        }else{
            if(showEmployeePhotoE.isSelected()){
                clickOn(showEmployeePhotoE);
            }
        }
        if(showEmployeeMobile){
            if(!showEmployeeMobileE.isSelected()){
                clickOn(showEmployeeMobileE);
            }
        }else{
            if(showEmployeeMobileE.isSelected()){
                clickOn(showEmployeeMobileE);
            }
        }
        if(citizen){
            if(!citizenE.isSelected()){
                clickOn(citizenE);
            }
        }else{
            if(citizenE.isSelected()){
                clickOn(citizenE);
            }
        }
        if(lecturer){
            if(!lecturerCheckbox.isSelected()){
                clickOn(lecturerCheckbox);
            }
        }else{
            if(lecturerCheckbox.isSelected()){
                clickOn(lecturerCheckbox);
            }
        }
        if(lecturerCheckbox.isSelected()){
            selectOption(lecturerSiteE, lecturerSite);
        }
        selectOption(salarySlipAndSmsLanguageE, salarySlipAndSmsLanguage);
        clickOn(saveBtn);
        hold(300);

    }

    public void saveMiscellaneousOptionsWithAssertion(boolean medicalClaim, boolean deprivedFrom, boolean smoker, boolean parking,
                                                      boolean menaMEUser, boolean excludedFromTimeSheet, boolean showEmployeePhoto,
                                                      boolean showEmployeeMobile, boolean citizen, boolean lecturer, String lecturerSite,
                                                      String salarySlipAndSmsLanguage){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(miscellaneousPage);
        saveMiscellaneousOptions(medicalClaim, deprivedFrom, smoker, parking, menaMEUser, excludedFromTimeSheet, showEmployeePhoto,
                showEmployeeMobile, citizen, lecturer, lecturerSite, salarySlipAndSmsLanguage);
        elementWaitAdvanced(By.name("is_MC_covered"));

        softAssert.assertEquals(medicalClaimCov.isSelected(), medicalClaim, "Medical Claim");
        softAssert.assertEquals(deprivedFromTrainingE.isSelected(), deprivedFrom, "Deprived From New Training Courses");
        softAssert.assertEquals(smokerE.isSelected(), smoker, "Smoker");
        softAssert.assertEquals(parkingE.isSelected(), parking, "Parking");
        softAssert.assertEquals(menaMEUserE.isSelected(), menaMEUser, "MenaME User");
        softAssert.assertEquals(excludedFromE.isSelected(), excludedFromTimeSheet, "Excluded From Time Sheet");
        softAssert.assertEquals(showEmployeePhotoE.isSelected(), showEmployeePhoto, "Show Employee Photo In Phone Directory And Mobile Application");
        softAssert.assertEquals(showEmployeeMobileE.isSelected(), showEmployeeMobile, "Show Employee Mobile In Phone Directory");
        softAssert.assertEquals(citizenE.isSelected(), citizen, "Citizen");
        softAssert.assertEquals(lecturerCheckbox.isSelected(), lecturer, "Lecturer Checkbox");
        softAssert.assertEquals(lecturerSiteE.getText(), lecturerSite, "Lecturer Site");
        softAssert.assertEquals(salarySlipAndSmsLanguageE.getText(), salarySlipAndSmsLanguage, "Salary Slip and SMS Sending Language");
        softAssert.assertAll();

    }

    public void editMiscellaneousAfterSave(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(miscellaneousPage);
        saveMiscellaneousOptions(true, true, true, true, true, true,
                true, true, true, true, "Off Site Training",
                "English");

        saveMiscellaneousOptions(false, false, false, false, false, false,
                false, false, false, false, "",
                "System Language");
        elementWaitAdvanced(By.name("is_MC_covered"));
        clickOn(miscellaneousPage);
        hold(300);
        elementWaitAdvanced(By.name("is_MC_covered"));

        softAssert.assertEquals(medicalClaimCov.isSelected(), false, "Medical Claim");
        softAssert.assertEquals(deprivedFromTrainingE.isSelected(), false, "Deprived From New Training Courses");
        softAssert.assertEquals(smokerE.isSelected(), false, "Smoker");
        softAssert.assertEquals(parkingE.isSelected(), false, "Parking");
        softAssert.assertEquals(menaMEUserE.isSelected(), false, "MenaME User");
        softAssert.assertEquals(excludedFromE.isSelected(), false, "Excluded From Time Sheet");
        softAssert.assertEquals(showEmployeePhotoE.isSelected(), false, "Show Employee Photo In Phone Directory And Mobile Application");
        softAssert.assertEquals(showEmployeeMobileE.isSelected(), false, "Show Employee Mobile In Phone Directory");
        softAssert.assertEquals(citizenE.isSelected(), false, "Citizen");
        softAssert.assertEquals(lecturerCheckbox.isSelected(), false, "Lecturer Checkbox");
        softAssert.assertTrue(driver.findElement(By.xpath("//span[contains(@aria-labelledby, 'select2-train_place')]")).isDisplayed() , "Lecturer Site NOT Disabled!");
        softAssert.assertEquals(salarySlipAndSmsLanguageE.getText(), "System Language", "Salary Slip and SMS Sending Language");
        softAssert.assertAll();

    }

    //////////// Events ///////////

    public void addEvents(String eventDate, String eventEnglish, String eventArabic, String remindBefore,
                          String notesEnglish, String notesArabic){

        hold(500);
        elementWaitAdvanced(By.id("event_date"));
        setText(eventDateE ,eventDate);
        setText(eventEnglishE, eventEnglish);
        setText(eventArabicE, eventArabic);
        selectOption(remindBeforeE, remindBefore);
        setText(notesEnglishE, notesEnglish);
        setText(notesArabicE, notesArabic);
        clickOn(saveBtn);
        hold(300);

    }

    public void addEventsWithAssertion(String eventDate, String eventEnglish, String eventArabic, String remindBefore,
                                       String notesEnglish, String notesArabic){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(eventsPage);
        addEvents(eventDate, eventEnglish, eventArabic, remindBefore, notesEnglish, notesArabic);
        elementWaitAdvanced(By.id("event_date"));
        softAssert.assertEquals(eventDateE.getDomAttribute("value"), eventDate);
        softAssert.assertEquals(eventEnglishE.getDomAttribute("value"), eventEnglish);
        softAssert.assertEquals(eventArabicE.getDomAttribute("value"), eventArabic);
        softAssert.assertEquals(remindBeforeE.getText(), remindBefore);
        softAssert.assertEquals(notesEnglishE.getDomAttribute("value"), notesEnglish);
        softAssert.assertEquals(notesArabicE.getDomAttribute("value"), notesArabic);
        softAssert.assertAll();

    }

    public void editEvents(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(eventsPage);
        elementWaitAdvanced(By.id("event_date"));
        addEvents("01/01/2029", "Event English Test", "Event Arabic Test",
                "5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque porttitor sem pretium nisl dictum, in aliquet tortor tempor. Aenean congue risus sit amet vehicula vestibulum. Phasellus id semper nunc, quis pulvinar ipsum. Aenean erat nulla, fringilla non ultrices vitae, vehicula quis tortor. Nunc massa tortor, ornare ac ligula vel, scelerisque tincidunt tortor. Integer vulputate purus vitae semper aliquet. Pellentesque nec molestie tellus, ac tempus nunc. Curabitur nunc leo, tincidunt eu nisi et, condimentum volutpat nisi.",
                "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق. إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع.");

        clickOn(item);
        hold(300);
        elementWaitAdvanced(By.id("event_date"));

        eventDateE.clear();
        hold(300);
        setText(eventDateE, "05/05/2027");
        eventEnglishE.clear();
        hold(300);
        setText(eventEnglishE, "Event English Edited");
        eventArabicE.clear();
        hold(300);
        setText(eventArabicE, "Event Arabic Edited");
        selectOption(remindBeforeE, "3");
        notesEnglishE.clear();
        notesArabicE.clear();
        clickOn(saveBtn);
        hold(300);
        elementWaitAdvanced(By.id("event_date"));
        clickOn(item);
        hold(300);
        elementWaitAdvanced(By.id("event_date"));

        softAssert.assertEquals(eventDateE.getDomAttribute("value"), "05/05/2027");
        softAssert.assertEquals(eventEnglishE.getDomAttribute("value"), "Event English Edited");
        softAssert.assertEquals(eventArabicE.getDomAttribute("value"), "Event Arabic Edited");
        softAssert.assertEquals(remindBeforeE.getText(), "3");
        softAssert.assertTrue(notesEnglishE.getDomAttribute("value").isEmpty());
        softAssert.assertTrue(notesArabicE.getDomAttribute("value").isEmpty());
        softAssert.assertAll();

    }

    public void deleteEvents(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(eventsPage);
        elementWaitAdvanced(By.id("event_date"));
        addEvents("01/01/2029", "Event English Test", "Event Arabic Test",
                "5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque porttitor sem pretium nisl dictum, in aliquet tortor tempor. Aenean congue risus sit amet vehicula vestibulum. Phasellus id semper nunc, quis pulvinar ipsum. Aenean erat nulla, fringilla non ultrices vitae, vehicula quis tortor. Nunc massa tortor, ornare ac ligula vel, scelerisque tincidunt tortor. Integer vulputate purus vitae semper aliquet. Pellentesque nec molestie tellus, ac tempus nunc. Curabitur nunc leo, tincidunt eu nisi et, condimentum volutpat nisi.",
                "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق. إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع.");

        clickOn(item);
        hold(300);
        elementWaitAdvanced(By.id("event_date"));
        clickOn(deleteBtn);
        hold(300);
        clickOn(alertButtonOkDelete);
        hold(300);
        elementWaitAdvanced(By.id("event_date"));
        clickOn(eventsPage);
        hold(300);
        elementWaitAdvanced(By.id("event_date"));
        Assert.assertTrue(checkElementIfNotAppear(items), "Item NOT Deleted!");

    }

    public void addMoreThanOneRecordEvents(int eventCount){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(eventsPage);
        elementWaitAdvanced(By.id("event_date"));

        for (int i = 1; i <= eventCount; i++){

            addEvents("01/0"+i+"/2029", "Event English Test "+i, "Event Arabic Test "+i,
                    "5", "Test "+i,
                    "Test A "+i);

            clickOn(addBtn);
            hold(500);

        }

        softAssert.assertEquals(items.size(), eventCount, "Issue in the number of Experience!");
        softAssert.assertAll();

    }

    public void validateEventDateBeforeTodayDate(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(eventsPage);
        elementWaitAdvanced(By.id("event_date"));
        addEvents("01/01/2019", "Event English Test", "Event Arabic Test",
                "5", "",
                "");

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Event Date Cannot Be Before Today`s Date!");
        softAssert.assertAll();

    }

    /////////// Medical Profile ///////////

    public void addMedicalProfile(String statusType, String statusDate, String status, String notes){

        hold(500);
        elementWaitAdvanced(By.id("medical_date"));
        selectOption(statusTypeE, statusType);
        statusDateE.clear();
        hold(300);
        setText(statusDateE, statusDate);
        medicalAttachment.sendKeys(uploadRandomImage());
        setText(statusE, status);
        setText(notesE, notes);
        clickOn(saveBtn);
        hold(300);

    }

    public void addMedicalProfileWithAssertion(String statusType, String statusDate, String status, String notes){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(medicalProfilePage);
        elementWaitAdvanced(By.id("medical_date"));
        addMedicalProfile(statusType, statusDate, status, notes);
        elementWaitAdvanced(By.id("medical_date"));
        clickOn(item);
        hold(300);
        elementWaitAdvanced(By.id("medical_date"));
        softAssert.assertEquals(statusTypeE.getText(), statusType);
        softAssert.assertEquals(statusDateE.getDomAttribute("value"), statusDate);
        softAssert.assertEquals(VerifyImage(checkAttachment), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentURL.getDomAttribute("href").isEmpty(), "- Attachment File");
        softAssert.assertEquals(statusE.getDomAttribute("value"), status);
        softAssert.assertEquals(notesE.getDomAttribute("value"), notes);
        softAssert.assertAll();

    }

    public void editMedicalProfile(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(medicalProfilePage);
        elementWaitAdvanced(By.id("medical_date"));
        addMedicalProfile("Medical Status 1", "01/01/2022",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus non egestas turpis. Maecenas sagittis ornare turpis eu tempor. Cras porta ornare leo vitae hendrerit. Morbi nec massa vel augue blandit molestie vitae non justo. In a volutpat enim, vitae elementum nibh. Suspendisse tincidunt faucibus ultricies. Morbi at interdum massa. Morbi eu consectetur arcu. Cras nibh erat, feugiat sed sapien vel, mattis fringilla urna. Sed in justo et quam posuere scelerisque. In tempor scelerisque suscipit. Nulla a odio felis. Proin nisl ligula, venenatis non laoreet vitae, pretium eget dui. Aliquam efficitur pharetra leo non porta.",
                "Integer at porta justo. Suspendisse convallis eget ante eget consequat. Vestibulum placerat orci ex. Fusce molestie auctor felis at pretium. Nam consectetur lacinia volutpat. Duis tempor odio velit, quis scelerisque mi tristique at. Suspendisse sit amet orci viverra, finibus ante in, euismod libero. Sed a tempus sapien. Fusce vitae gravida urna. Mauris et lorem sed neque scelerisque venenatis. Morbi molestie nibh sed nunc finibus, nec euismod dui lobortis. Phasellus vehicula eleifend orci, sit amet interdum leo varius a. Duis malesuada libero non neque rhoncus eleifend. In convallis malesuada tincidunt. Nam nec facilisis ipsum.");

        elementWaitAdvanced(By.id("medical_date"));
        clickOn(item);
        hold(300);
        elementWaitAdvanced(By.id("medical_date"));
        statusDateE.clear();
        hold(300);
        setText(statusDateE, "05/05/2022");
        statusE.clear();
        hold(300);
        setText(statusE, "Test Edited Status");
        notesE.clear();
        hold(300);
        setText(notesE, "Test Edited Notes");
        clickOn(saveBtn);
        hold(300);
        elementWaitAdvanced(By.id("medical_date"));
        clickOn(item);
        hold(300);
        elementWaitAdvanced(By.id("medical_date"));

        softAssert.assertEquals(statusDateE.getDomAttribute("value"), "05/05/2022");
        softAssert.assertEquals(statusE.getDomAttribute("value"), "Test Edited Status");
        softAssert.assertEquals(notesE.getDomAttribute("value"), "Test Edited Notes");
        softAssert.assertAll();

    }

    public void deleteMedicalProfile(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(medicalProfilePage);
        elementWaitAdvanced(By.id("medical_date"));
        addMedicalProfile("Medical Status 1", "01/01/2022",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus non egestas turpis. Maecenas sagittis ornare turpis eu tempor. Cras porta ornare leo vitae hendrerit. Morbi nec massa vel augue blandit molestie vitae non justo. In a volutpat enim, vitae elementum nibh. Suspendisse tincidunt faucibus ultricies. Morbi at interdum massa. Morbi eu consectetur arcu. Cras nibh erat, feugiat sed sapien vel, mattis fringilla urna. Sed in justo et quam posuere scelerisque. In tempor scelerisque suscipit. Nulla a odio felis. Proin nisl ligula, venenatis non laoreet vitae, pretium eget dui. Aliquam efficitur pharetra leo non porta.",
                "Integer at porta justo. Suspendisse convallis eget ante eget consequat. Vestibulum placerat orci ex. Fusce molestie auctor felis at pretium. Nam consectetur lacinia volutpat. Duis tempor odio velit, quis scelerisque mi tristique at. Suspendisse sit amet orci viverra, finibus ante in, euismod libero. Sed a tempus sapien. Fusce vitae gravida urna. Mauris et lorem sed neque scelerisque venenatis. Morbi molestie nibh sed nunc finibus, nec euismod dui lobortis. Phasellus vehicula eleifend orci, sit amet interdum leo varius a. Duis malesuada libero non neque rhoncus eleifend. In convallis malesuada tincidunt. Nam nec facilisis ipsum.");

        elementWaitAdvanced(By.id("medical_date"));
        clickOn(item);
        hold(300);
        elementWaitAdvanced(By.id("medical_date"));
        clickOn(deleteBtn);
        hold(300);
        clickOn(alertButtonOkDelete);
        hold(300);
        elementWaitAdvanced(By.id("medical_date"));
        Assert.assertTrue(checkElementIfNotAppear(items), "Item Still Appear!");

    }

    public void addMoreThanOneRecordMedicalProfile(int medicalCount){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(medicalProfilePage);
        elementWaitAdvanced(By.id("medical_date"));

        for (int i = 1; i <= medicalCount; i++){

            addMedicalProfile("Medical Status 1", "01/0"+i+"/2022",
                    "Test "+i,
                    "Test Note "+i);

            clickOn(addBtn);
            hold(500);

        }

        softAssert.assertEquals(items.size(), medicalCount, "Issue in the number of Experience!");
        softAssert.assertAll();

    }

    public void addAttachmentWithAllowUpperLimit_MedicalProfile(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(medicalProfilePage);
        elementWaitAdvanced(By.id("medical_date"));
        selectOption(statusTypeE, "Medical Status 1");
        medicalAttachment.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertEquals(VerifyImage(checkAttachment), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentURL.getDomAttribute("href").isEmpty(), "- Attachment File");

        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void addAttachmentWithAlertMessageUpperLimit_MedicalProfile(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(medicalProfilePage);
        elementWaitAdvanced(By.id("medical_date"));
        selectOption(statusTypeE, "Medical Status 1");
        medicalAttachment.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "Please Note The Maximum Size To Upload Here Is 2 MB");
        softAssert.assertEquals(VerifyImage(checkAttachment), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentURL.getDomAttribute("href").isEmpty(), "- Attachment File");

        clickOn(okBtnAlert);
        hold(200);
        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void addAttachmentWithDontAllowUpperLimit_MedicalProfile(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(medicalProfilePage);
        elementWaitAdvanced(By.id("medical_date"));
        selectOption(statusTypeE, "Medical Status 1");
        medicalAttachment.sendKeys(uploadBigSizeImg5MB());
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

    public void checkUserWithOptionDontAllowDownloadFile_MedicalProfile(){

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

        hold(300);
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(medicalProfilePage);
        addMedicalProfile("Medical Status 1", "01/01/2022", "", "");

        clickOn(item);
        hold(300);

        softAssert.assertTrue(checkAttachForUserDontHavePermission.isDisplayed(), "- LOCKED Attachment NOT appear");
        softAssert.assertEquals(checkAttachForUserDontHavePermission.getDomAttribute("alt"), "Sorry You Do Not Have Permission To Access Uploaded Files !");
        softAssert.assertAll();

    }

    public void checkUserWithOptionDontAllowUploadFile_MedicalProfile(){

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

        hold(300);
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(medicalProfilePage);
        elementWaitAdvanced(By.id("medical_date"));
        selectOption(statusTypeE, "Medical Status 1");
        medicalAttachment.sendKeys(uploadRandomImage());
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

    public void uploadAttachmentWithWrongExtension_MedicalProfile(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(medicalProfilePage);
        elementWaitAdvanced(By.id("medical_date"));
        selectOption(statusTypeE, "Medical Status 1");
        medicalAttachment.sendKeys(uploadDocFile());
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

    /////////// Special Cases ///////////

    public void addSpecialCases(String caseDate, String endDate, String caseType, String notes){

        hold(500);
        elementWaitAdvanced(By.id("condition_date"));
        setText(caseDateE, caseDate);
        setText(caseEndDateE, endDate);
        selectOption(caseTypeE, caseType);
        caseAttachment.sendKeys(uploadRandomImage());
        setText(notesE, notes);
        clickOn(saveBtn);
        hold(300);

    }

    public void addSpecialCasesWithAssertion(String caseDate, String endDate, String caseType, String notes){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(specialCasesPage);
        addSpecialCases(caseDate, endDate, caseType, notes);
        elementWaitAdvanced(By.id("condition_date"));
        clickOn(item);
        hold(300);
        elementWaitAdvanced(By.id("condition_date"));

        softAssert.assertEquals(caseDateE.getDomAttribute("value"), caseDate);
        softAssert.assertEquals(caseEndDateE.getDomAttribute("value"), endDate);
        softAssert.assertEquals(caseTypeE.getText(), caseType);
        softAssert.assertEquals(VerifyImage(checkAttachment), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentURL.getDomAttribute("href").isEmpty(), "- Attachment File");
        softAssert.assertEquals(notesE.getDomAttribute("value"), notes);
        softAssert.assertAll();

    }

    public void editSpecialCases(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(specialCasesPage);
        addSpecialCases("03/03/2021", "12/12/2021", "Special Cases 1",
                "Test Special Cases");
        elementWaitAdvanced(By.id("condition_date"));
        clickOn(item);
        hold(300);
        elementWaitAdvanced(By.id("condition_date"));

        caseDateE.clear();
        hold(300);
        setText(caseDateE, "06/06/2021");
        caseEndDateE.clear();
        notesE.clear();
        hold(300);
        setText(notesE, "Edited Notes");
        clickOn(saveBtn);
        hold(300);
        elementWaitAdvanced(By.id("condition_date"));
        clickOn(item);
        hold(300);
        softAssert.assertEquals(caseDateE.getDomAttribute("value"), "06/06/2021");
        softAssert.assertTrue(caseEndDateE.getDomAttribute("value").isEmpty(), "End Date NOT Empty");
        softAssert.assertEquals(notesE.getDomAttribute("value"), "Edited Notes");
        softAssert.assertAll();

    }

    public void deleteSpecialCases(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(specialCasesPage);
        addSpecialCases("03/03/2021", "12/12/2021", "Special Cases 1",
                "Test Special Cases");
        elementWaitAdvanced(By.id("condition_date"));
        clickOn(item);
        hold(300);
        elementWaitAdvanced(By.id("condition_date"));

        clickOn(deleteBtn);
        hold(300);
        clickOn(alertButtonOkDelete);
        hold(300);
        elementWaitAdvanced(By.id("condition_date"));
        Assert.assertTrue(checkElementIfNotAppear(items), "Item still appear!");

    }

    public void addMoreThanOneRecordSpecialCases(int specialCount){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(specialCasesPage);

        for (int i = 1; i <= specialCount; i++){

            addSpecialCases("01/0"+i+"/2021", "12/12/2021", "Special Cases 1",
                    "Test Special Cases "+i);

            clickOn(addBtn);
            hold(500);

        }

        softAssert.assertEquals(items.size(), specialCount, "Issue in the number of Experience!");
        softAssert.assertAll();

    }

    public void caseDateAfterEndDateSpecialCases(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(specialCasesPage);
        addSpecialCases("03/03/2021", "01/01/2021", "Special Cases 1",
                "Test Special Cases");

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The End Date Can Not Be Before The Start Date! Please Re-enter The End Date");
        softAssert.assertAll();

    }

    public void addAttachmentWithAllowUpperLimit_SpecialCases(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(specialCasesPage);
        hold(500);
        elementWaitAdvanced(By.id("condition_date"));
        selectOption(caseTypeE, "Special Cases 1");
        caseAttachment.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertEquals(VerifyImage(checkAttachment), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentURL.getDomAttribute("href").isEmpty(), "- Attachment File");

        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void addAttachmentWithAlertMessageUpperLimit_SpecialCases(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(specialCasesPage);
        hold(500);
        elementWaitAdvanced(By.id("condition_date"));
        selectOption(caseTypeE, "Special Cases 1");
        caseAttachment.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "Please Note The Maximum Size To Upload Here Is 2 MB");
        softAssert.assertEquals(VerifyImage(checkAttachment), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentURL.getDomAttribute("href").isEmpty(), "- Attachment File");

        clickOn(okBtnAlert);
        hold(200);
        clickOn(deleteBtn);
        hold(200);
        clickOn(alertButtonOkDelete);

        softAssert.assertAll();

    }

    public void addAttachmentWithDontAllowUpperLimit_SpecialCases(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(specialCasesPage);
        hold(500);
        elementWaitAdvanced(By.id("condition_date"));
        selectOption(caseTypeE, "Special Cases 1");
        caseAttachment.sendKeys(uploadBigSizeImg5MB());
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

    public void checkUserWithOptionDontAllowDownloadFile_SpecialCases(){

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

        hold(300);
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(specialCasesPage);
        addSpecialCases("03/03/2021", "", "Special Cases 1", "");
        clickOn(item);
        hold(300);

        softAssert.assertTrue(checkAttachForUserDontHavePermission.isDisplayed(), "- LOCKED Attachment NOT appear");
        softAssert.assertEquals(checkAttachForUserDontHavePermission.getDomAttribute("alt"), "Sorry You Do Not Have Permission To Access Uploaded Files !");
        softAssert.assertAll();

    }

    public void checkUserWithOptionDontAllowUploadFile_SpecialCases(){

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

        hold(300);
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(specialCasesPage);
        hold(500);
        elementWaitAdvanced(By.id("condition_date"));
        selectOption(caseTypeE, "Special Cases 1");
        caseAttachment.sendKeys(uploadRandomImage());
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

    public void uploadAttachmentWithWrongExtension_SpecialCases(){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(specialCasesPage);
        hold(500);
        elementWaitAdvanced(By.id("condition_date"));
        selectOption(caseTypeE, "Special Cases 1");
        caseAttachment.sendKeys(uploadDocFile());
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

    ///////////// Additional Information /////////////

    public void addAdditionalInformation(String fieldName, String englishDescription, String arabicDescription){

        hold(500);
        elementWaitAdvanced(By.name("field_id"));
        clickOn(addBtn);
        hold(300);
        elementWaitAdvanced(By.name("field_id"));
        new Select(fieldNameE).selectByVisibleText(fieldName);
        hold(500);
        if(fieldName.equalsIgnoreCase("Additional Number")){
            setText(fieldNumberE, englishDescription);
        }else if(fieldName.equalsIgnoreCase("Additional Text")){
            setText(fieldTextEn, englishDescription);
            setText(fieldTextAr, arabicDescription);
        }else if(fieldName.equalsIgnoreCase("Additional Date")){
            setText(fieldDateE, englishDescription);
        }else if(fieldName.equalsIgnoreCase("Additional Combo Box")){
            new Select(fieldComboBoxE).selectByVisibleText(englishDescription);
        }
        hold(500);
        clickOn(saveBtn);
        hold(300);

    }

    public void addAdditionalInformationWithAssertion(String fieldName, String englishDescription, String arabicDescription){

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
        clickOn(otherTab);
        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        clickOn(additionalInformationPage);
        hold(500);
        elementWaitAdvanced(By.name("field_id"));
        addAdditionalInformation(fieldName, englishDescription, arabicDescription);
        elementWaitAdvanced(By.name("field_id"));
        clickOn(item);
        hold(300);
        elementWaitAdvanced(By.name("field_id"));

        Select fieldType = new Select(fieldNameE);
        WebElement optionSelected = fieldType.getFirstSelectedOption();
        if(fieldName.equalsIgnoreCase("Additional Number")){
            softAssert.assertEquals(optionSelected.getText(), fieldName);
            softAssert.assertEquals(fieldNumberE.getDomAttribute("value"), englishDescription);
            softAssert.assertTrue(fieldNumberE.getDomAttribute("validation").contains("decimal"), "Validation NOT Contain 'decimal'");
        }else if(fieldName.equalsIgnoreCase("Additional Text")){
            softAssert.assertEquals(optionSelected.getText(), fieldName);
            softAssert.assertEquals(fieldTextEn.getDomAttribute("value"), englishDescription);
            softAssert.assertEquals(fieldTextAr.getDomAttribute("value"), arabicDescription);
        }else if(fieldName.equalsIgnoreCase("Additional Date")){
            softAssert.assertEquals(optionSelected.getText(), fieldName);
            softAssert.assertEquals(fieldDateE.getDomAttribute("value"), englishDescription);
            softAssert.assertTrue(fieldDateE.getDomAttribute("validation").contains("valid_date"), "Validation NOT Contain 'valid_date'");
        }else if(fieldName.equalsIgnoreCase("Additional Combo Box")){
            softAssert.assertEquals(optionSelected.getText(), fieldName);
            Select fieldCombo = new Select(fieldComboBoxE);
            WebElement comboSelected = fieldCombo.getFirstSelectedOption();
            softAssert.assertEquals(comboSelected.getText(), englishDescription);
        }
        softAssert.assertAll();

    }

}
