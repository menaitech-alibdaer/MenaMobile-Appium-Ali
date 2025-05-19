package webBackend.personnelInformation;

import bases.WebBase;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import webBackend.general.SystemParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;
import static utilities.VersionGetter.liteGetter;
import static utilities.VersionGetter.versionGetter;

import utilities.MssqlConnect;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.HijrahEra;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Spouse extends WebBase {

    @FindBy(xpath = "//div[contains(@onclick, 'Wives.php')]")
    WebElement spousePage;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(id = "wife_name_man1")
    WebElement firstNameSpouse;
    @FindBy(id = "wife_name_man2")
    WebElement secondNameSpouse;
    @FindBy(id = "wife_name_man3")
    WebElement thirdNameSpouse;
    @FindBy(id = "wife_name_man4")
    WebElement familyNameSpouse;
    @FindBy(id = "wife_name_other1")
    WebElement firstNameArSpouse;
    @FindBy(id = "wife_name_other2")
    WebElement secondNameArSpouse;
    @FindBy(id = "wife_name_other3")
    WebElement thirdNameArSpouse;
    @FindBy(id = "wife_name_other4")
    WebElement familyNameArSpouse;
    @FindBy(id = "birth_date")
    WebElement birthDateSpouseE;
    @FindBy(id = "marry_date")
    WebElement marryDateSpouseE;
    @FindBy(xpath = "//span[contains(@id, 'select2-birth_place')]")
    WebElement birthPlaceSpouseE;
    @FindBy(xpath = "//span[contains(@id, 'select2-nationality')]")
    WebElement nationalitySpouseE;
    @FindBy(id = "national_code")
    WebElement nationalCodeSpouseE;
    @FindBy(id = "flexSwitchCheckCheckexd")
    WebElement insuredSpouseE;
    @FindBy(id = "insurance_date")
    WebElement insuranceDateSpouseE;
    @FindBy(id = "insurance_number")
    WebElement insuranceCodeSpouseE;
    @FindBy(id = "wife_end_ins_date")
    WebElement insuranceCardExpirySpouseE;
    @FindBy(id = "flexSwitchCheckCheckedz")
    WebElement workerSpouseE;
    @FindBy(name = "work")
    WebElement workerText;
    @FindBy(id = "flexSwitchCheckCheckedx")
    WebElement medicalClaimCoverageSpouseE;
    @FindBy(name = "allowance_amount")
    public WebElement allowanceAmountSpouseE;
    @FindBy(xpath = "//div[contains(@onclick, 'employment_information.php')]")
    WebElement employmentInformationPage;
    @FindBy(name = "notes")
    WebElement notesSpouseE;
    @FindBy(id = "passport_number")
    WebElement passportNumberE;
    @FindBy(id = "residence_number")
    WebElement residenceNumberE;
    @FindBy(id = "passport_expire_date")
    WebElement passportExpireDateE;
    @FindBy(id = "residence_expiry_date")
    WebElement residenceExpiryDateE;
    @FindBy(id = "claim_start_date")
    WebElement claimStartDateE;
    @FindBy(id = "start_date")
    WebElement startDateAllowanceE;
    @FindBy(id = "end_date")
    WebElement endDateAllowanceE;
    @FindBy(id = "spouse_picture")
    WebElement spousePictureE;
    @FindBy(id = "deathDate")
    WebElement deathDateE;
    @FindBy(id = "divorceDate")
    WebElement divorceDateE;
    @FindBy(id = "national_expire_date")
    WebElement nationalExpireDateE;
    @FindBy(id = "blah")
    WebElement checkPicture;
    @FindBy(xpath = "//div[contains(@class, 'mar-left-36-minus')]//label[2]")
    WebElement totalAllowances;
    @FindBy(name = "conv2")
    WebElement hijriConverter;
    @FindBy(id = "date")
    WebElement hijriDateE;
    @FindBy(id = "flexhandicappedCheckCheckedx")
    WebElement handicappedE;
    @FindBy(xpath = "//input[@value='Convert']")
    WebElement convertHijriBtn;
    @FindBy(id = "All_popup")
    WebElement iframePopup;
    @FindBy(id = "body_frame")
    WebElement frame;
    @FindBy(xpath = "//span[contains(@onclick, 'confirm_delete')]")
    WebElement deleteSpouseBtn;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDeleteSpouse;
    @FindBy(xpath = "//div[@class='textAlign']//label[contains(@style, 'font-size:20px')]")
    WebElement alertText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    WebElement alertBox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addBtn;
    @FindBy(id = "btok")
    WebElement okBtn;
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
    SystemParameters systemParameters;
    String employeeCode = null;

    public void addSpouse( String birthDate, String marriageDate, String deathDate, String divorceDate, String birthPlace, String nationality, String nationalCode,
                           String nationalCodeExpireDate, String passportNumber, String passportExpireDate, String residenceNumber, String residenceExpiryDate, boolean insured,
                           String insuranceDate, String insuranceCode, String insuranceCardExpiry, boolean workerSpouse, String workText, boolean medicalClaimCoverage,
                           String medicalClaimStartDate, String allowanceAmount, String startDateAllowance, String toDateAllowance, String notes, boolean uploadPicture){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(spousePage);
        elementWaitAdvanced(By.id("wife_name_man1"));
        setText(firstNameSpouse, randomNumber()+"FS");
        setText(secondNameSpouse, randomNumber()+"SS");
        setText(thirdNameSpouse, randomNumber()+"TS");
        setText(familyNameSpouse, randomNumber()+"LS");
        setText(firstNameArSpouse, randomNumber()+"FAS");
        setText(secondNameArSpouse, randomNumber()+"SAS");
        setText(thirdNameArSpouse, randomNumber()+"TAS");
        setText(familyNameArSpouse, randomNumber()+"LAS");
        birthDateSpouseE.clear();
        hold(200);
        setText(birthDateSpouseE, birthDate);
        setText(marryDateSpouseE, marriageDate);
        setText(deathDateE, deathDate);
        setText(divorceDateE, divorceDate);
        selectOption(birthPlaceSpouseE, birthPlace);
        selectOption(nationalitySpouseE, nationality);
        setText(nationalCodeSpouseE, nationalCode);
        setText(nationalExpireDateE, nationalCodeExpireDate);
        setText(passportNumberE, passportNumber);
        setText(passportExpireDateE, passportExpireDate);
        setText(residenceNumberE, residenceNumber);
        scrollToElement(notesSpouseE);
        setText(residenceExpiryDateE, residenceExpiryDate);
        if (insured){
            clickOn(insuredSpouseE);
            hold(500);
            setText(insuranceDateSpouseE, insuranceDate);
            setText(insuranceCodeSpouseE, insuranceCode);
            setText(insuranceCardExpirySpouseE, insuranceCardExpiry);
        }
        if(workerSpouse){
            clickOn(workerSpouseE);
            hold(300);
            setText(workerText, workText);
        }
        if(!liteGetter()){
            if(medicalClaimCoverage){
                if(!medicalClaimCoverageSpouseE.isSelected()){
                    clickOn(medicalClaimCoverageSpouseE);
                }
                hold(400);
                setText(claimStartDateE, medicalClaimStartDate);
            }else{
                if(medicalClaimCoverageSpouseE.isSelected()){
                    clickOn(medicalClaimCoverageSpouseE);
                }
            }
        }
        allowanceAmountSpouseE.clear();
        hold(500);
        setText(allowanceAmountSpouseE, allowanceAmount);
        setText(startDateAllowanceE, startDateAllowance);
        setText(endDateAllowanceE, toDateAllowance);
        if(uploadPicture){
            spousePictureE.sendKeys(uploadRandomImage());
        }
        setText(notesSpouseE, notes);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(300);

        setLog("Add Spouse"
        +" - birth Date: "+birthDate
        +" - marriage Date: "+marriageDate
        +" - death Date: "+deathDate
        +" - divorce Date: "+divorceDate
        +" - birth Place: "+birthPlace
        +" - nationality: "+nationality
        +" - national Code: "+nationalCode
        +" - national Code Expire Date: "+nationalCodeExpireDate
        +" - passport Number: "+passportNumber
        +" - passport Expire Date: "+passportExpireDate
        +" - residence Number: "+residenceNumber
        +" - residence Expiry Date: "+residenceExpiryDate
        +" - insured: "+insured
        +" - insurance Date: "+insuranceDate
        +" - insurance Code: "+insuranceCode
        +" - insurance Card Expiry: "+insuranceCardExpiry
        +" - worker Spouse: "+workerSpouse
        +" - work Text: "+workText
        +" - medical Claim Coverage: "+medicalClaimCoverage
        +" - medical Claim Start Date: "+medicalClaimStartDate
        +" - allowance Amount: "+allowanceAmount
        +" - start Date Allowance: "+startDateAllowance
        +" - to Date Allowance: "+toDateAllowance
        +" - notes: "+notes
        +" - upload Picture: "+uploadPicture);

    }

    public void justAddSpouse( String firstName, String secondName, String thirdName, String familyName, String firstArabicName, String secondArabicName, String thirdArabicName, String familyArabicName,
                           String birthDate, String marriageDate, String deathDate, String divorceDate, String birthPlace, String nationality, String nationalCode,
                           String nationalCodeExpireDate, String passportNumber, String passportExpireDate, String residenceNumber, String residenceExpiryDate, boolean insured,
                           String insuranceDate, String insuranceCode, String insuranceCardExpiry, boolean workerSpouse, String workText, boolean medicalClaimCoverage,
                           String medicalClaimStartDate, String allowanceAmount, String startDateAllowance, String toDateAllowance, String notes, boolean uploadPicture){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            hold(300);
            clickOn(spousePage);
            elementWaitAdvanced(By.id("wife_name_man1"));
            setText(firstNameSpouse, firstName);
            setText(secondNameSpouse, secondName);
            setText(thirdNameSpouse, thirdName);
            setText(familyNameSpouse, familyName);
            setText(firstNameArSpouse, firstArabicName);
            setText(secondNameArSpouse, secondArabicName);
            setText(thirdNameArSpouse, thirdArabicName);
            setText(familyNameArSpouse, familyArabicName);
            birthDateSpouseE.clear();
            hold(200);
            setText(birthDateSpouseE, birthDate);
            setText(marryDateSpouseE, marriageDate);
            setText(deathDateE, deathDate);
            setText(divorceDateE, divorceDate);
            selectOption(birthPlaceSpouseE, birthPlace);
            selectOption(nationalitySpouseE, nationality);
            setText(nationalCodeSpouseE, nationalCode);
            setText(nationalExpireDateE, nationalCodeExpireDate);
            setText(passportNumberE, passportNumber);
            setText(passportExpireDateE, passportExpireDate);
            setText(residenceNumberE, residenceNumber);
            scrollToElement(notesSpouseE);
            setText(residenceExpiryDateE, residenceExpiryDate);
            if (insured){
                clickOn(insuredSpouseE);
                hold(500);
                insuranceDateSpouseE.clear();
                hold(100);
                setText(insuranceDateSpouseE, insuranceDate);
                setText(insuranceCodeSpouseE, insuranceCode);
                setText(insuranceCardExpirySpouseE, insuranceCardExpiry);
            }
            if(workerSpouse){
                clickOn(workerSpouseE);
                hold(300);
                setText(workerText, workText);
            }
            if(!liteGetter()){
                if(medicalClaimCoverage){
                    if (!medicalClaimCoverageSpouseE.isSelected()){
                        clickOn(medicalClaimCoverageSpouseE);
                    }
                    hold(400);
                    setText(claimStartDateE, medicalClaimStartDate);
                }
            }
            if(!allowanceAmount.isEmpty()){
                allowanceAmountSpouseE.clear();
                hold(500);
                setText(allowanceAmountSpouseE, allowanceAmount);
            }
            setText(startDateAllowanceE, startDateAllowance);
            setText(endDateAllowanceE, toDateAllowance);
            if(uploadPicture){
                spousePictureE.sendKeys(uploadRandomImage());
            }
            setText(notesSpouseE, notes);
            scrollToElement(empCode);
            clickOn(saveBtn);
            hold(300);

        }else {

            personalInformationOct = new PersonalInformation_OCT();
            personalInformationOct.justAddSpouse(firstName, secondName, thirdName, familyName, firstArabicName, secondArabicName, thirdArabicName, familyArabicName,
                    birthDate, marriageDate, deathDate, divorceDate, birthPlace, nationality, nationalCode,
                    nationalCodeExpireDate, passportNumber, passportExpireDate, residenceNumber, residenceExpiryDate, insured,
                    insuranceDate, insuranceCode, insuranceCardExpiry, workerSpouse, workText, medicalClaimCoverage,
                    medicalClaimStartDate, allowanceAmount, startDateAllowance, toDateAllowance, notes, uploadPicture);

        }

        setLog("Add Spouse"
                +" - birth Date: "+birthDate
                +" - marriage Date: "+marriageDate
                +" - death Date: "+deathDate
                +" - divorce Date: "+divorceDate
                +" - birth Place: "+birthPlace
                +" - nationality: "+nationality
                +" - national Code: "+nationalCode
                +" - national Code Expire Date: "+nationalCodeExpireDate
                +" - passport Number: "+passportNumber
                +" - passport Expire Date: "+passportExpireDate
                +" - residence Number: "+residenceNumber
                +" - residence Expiry Date: "+residenceExpiryDate
                +" - insured: "+insured
                +" - insurance Date: "+insuranceDate
                +" - insurance Code: "+insuranceCode
                +" - insurance Card Expiry: "+insuranceCardExpiry
                +" - worker Spouse: "+workerSpouse
                +" - work Text: "+workText
                +" - medical Claim Coverage: "+medicalClaimCoverage
                +" - medical Claim Start Date: "+medicalClaimStartDate
                +" - allowance Amount: "+allowanceAmount
                +" - start Date Allowance: "+startDateAllowance
                +" - to Date Allowance: "+toDateAllowance
                +" - notes: "+notes
                +" - upload Picture: "+uploadPicture);

    }

    public void clickAdd(){
        hold(300);
        clickOn(addBtn);
        hold(300);
    }

    public void addSpouseWithAssertAllFields( String birthDate, String marriageDate, String deathDate, String divorceDate, String birthPlace, String nationality, String nationalCode,
                                              String nationalCodeExpireDate, String passportNumber, String passportExpireDate, String residenceNumber, String residenceExpiryDate, boolean insured,
                                              String insuranceDate, String insuranceCode, String insuranceCardExpiry, boolean workerSpouse, String workText, boolean medicalClaimCoverage,
                                              String medicalClaimStartDate, String allowanceAmount, String startDateAllowance, String toDateAllowance, String notes, boolean uploadPicture){

        addSpouse(birthDate, marriageDate, deathDate, divorceDate, birthPlace, nationality, nationalCode,
                nationalCodeExpireDate, passportNumber, passportExpireDate, residenceNumber, residenceExpiryDate,
                insured, insuranceDate, insuranceCode, insuranceCardExpiry, workerSpouse,workText, medicalClaimCoverage,
                medicalClaimStartDate, allowanceAmount, startDateAllowance, toDateAllowance, notes, uploadPicture);

        softAssert.assertTrue(item.isDisplayed(), "-Issue, Spouse Button Not Appear!");
        clickOn(item);
        hold(300);
        softAssert.assertEquals(birthDateSpouseE.getDomAttribute("value"), birthDate);
        softAssert.assertEquals(marryDateSpouseE.getDomAttribute("value"), marriageDate);
        softAssert.assertEquals(deathDateE.getDomAttribute("value"), deathDate);
        softAssert.assertEquals(divorceDateE.getDomAttribute("value"), divorceDate);
        softAssert.assertEquals(birthPlaceSpouseE.getText(), birthPlace);
        softAssert.assertEquals(nationalitySpouseE.getText(), nationality);
        softAssert.assertEquals(nationalCodeSpouseE.getDomAttribute("value"), nationalCode);
        softAssert.assertEquals(nationalExpireDateE.getDomAttribute("value"), nationalCodeExpireDate);
        softAssert.assertEquals(passportNumberE.getDomAttribute("value"), passportNumber);
        softAssert.assertEquals(passportExpireDateE.getDomAttribute("value"), passportExpireDate);
        if(!nationality.equals("Jordanian")){ //// Because the 'Jordanian' is Citizen ////
            softAssert.assertEquals(residenceNumberE.getDomAttribute("value"), residenceNumber);
            softAssert.assertEquals(residenceExpiryDateE.getDomAttribute("value"), residenceExpiryDate);
        }
        softAssert.assertEquals(insuredSpouseE.isSelected(), insured);
        if(insured){
            softAssert.assertEquals(insuranceDateSpouseE.getDomAttribute("value"), insuranceDate);
            softAssert.assertEquals(insuranceCodeSpouseE.getDomAttribute("value"), insuranceCode);
            softAssert.assertEquals(insuranceCardExpirySpouseE.getDomAttribute("value"), insuranceCardExpiry);
        }
        softAssert.assertEquals(workerSpouseE.isSelected(), workerSpouse);
        if(workerSpouse){
            softAssert.assertEquals(workerText.getDomAttribute("value"), workText);
        }
        if(!liteGetter()){
            softAssert.assertEquals(medicalClaimCoverageSpouseE.isSelected(), medicalClaimCoverage);
            if(medicalClaimCoverage){
                softAssert.assertEquals(claimStartDateE.getDomAttribute("value"), medicalClaimStartDate);
            }
        }
        softAssert.assertEquals(allowanceAmountSpouseE.getDomAttribute("value"), allowanceAmount);
        softAssert.assertEquals(startDateAllowanceE.getDomAttribute("value"), startDateAllowance);
        softAssert.assertEquals(endDateAllowanceE.getDomAttribute("value"), toDateAllowance);
        softAssert.assertEquals(notesSpouseE.getDomAttribute("value"), notes);
//        if(checkPicture.getDomAttribute("src").contains("Image/import.svg")){
//            softAssert.fail("The Photo Not Uploaded");
//        }else{
//            softAssert.assertEquals(VerifyImage(checkPicture), 200,"This image is broken : "+checkPicture.getDomAttribute("src"));
//        }
        softAssert.assertAll();

    }

    public void addSpouseWithoutSave( String birthDate, String marriageDate, String deathDate, String divorceDate, String birthPlace, String nationality, String nationalCode,
                           String nationalCodeExpireDate, String passportNumber, String passportExpireDate, String residenceNumber, String residenceExpiryDate, boolean insured,
                           String insuranceDate, String insuranceCode, String insuranceCardExpiry, boolean workerSpouse, String workText, boolean medicalClaimCoverage,
                           String medicalClaimStartDate, String allowanceAmount, String startDateAllowance, String toDateAllowance, String notes, boolean uploadPicture){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(spousePage);
        elementWaitAdvanced(By.id("wife_name_man1"));
        setText(firstNameSpouse, randomNumber()+"FS");
        setText(secondNameSpouse, randomNumber()+"SS");
        setText(thirdNameSpouse, randomNumber()+"TS");
        setText(familyNameSpouse, randomNumber()+"LS");
        setText(firstNameArSpouse, randomNumber()+"FAS");
        setText(secondNameArSpouse, randomNumber()+"SAS");
        setText(thirdNameArSpouse, randomNumber()+"TAS");
        setText(familyNameArSpouse, randomNumber()+"LAS");
        birthDateSpouseE.clear();
        hold(200);
        setText(birthDateSpouseE, birthDate);
        setText(marryDateSpouseE, marriageDate);
        setText(deathDateE, deathDate);
        setText(divorceDateE, divorceDate);
        selectOption(birthPlaceSpouseE, birthPlace);
        selectOption(nationalitySpouseE, nationality);
        setText(nationalCodeSpouseE, nationalCode);
        setText(nationalExpireDateE, nationalCodeExpireDate);
        setText(passportNumberE, passportNumber);
        setText(passportExpireDateE, passportExpireDate);
        setText(residenceNumberE, residenceNumber);
        scrollToElement(notesSpouseE);
        setText(residenceExpiryDateE, residenceExpiryDate);
        if (insured){
            clickOn(insuredSpouseE);
            hold(500);
            setText(insuranceDateSpouseE, insuranceDate);
            setText(insuranceCodeSpouseE, insuranceCode);
            setText(insuranceCardExpirySpouseE, insuranceCardExpiry);
        }
        if(workerSpouse){
            clickOn(workerSpouseE);
            hold(300);
            setText(workerText, workText);
        }

        if(!liteGetter()){
            if(medicalClaimCoverage){
                if (!medicalClaimCoverageSpouseE.isSelected()){
                    clickOn(medicalClaimCoverageSpouseE);
                }
                hold(400);
                setText(claimStartDateE, medicalClaimStartDate);
            }
        }

        allowanceAmountSpouseE.clear();
        hold(500);
        setText(allowanceAmountSpouseE, allowanceAmount);
        setText(startDateAllowanceE, startDateAllowance);
        setText(endDateAllowanceE, toDateAllowance);
        if(uploadPicture){
            spousePictureE.sendKeys(uploadRandomImage());
        }
        setText(notesSpouseE, notes);
        scrollToElement(empCode);

        setLog("Add Spouse"
                +" - birth Date: "+birthDate
                +" - marriage Date: "+marriageDate
                +" - death Date: "+deathDate
                +" - divorce Date: "+divorceDate
                +" - birth Place: "+birthPlace
                +" - nationality: "+nationality
                +" - national Code: "+nationalCode
                +" - national Code Expire Date: "+nationalCodeExpireDate
                +" - passport Number: "+passportNumber
                +" - passport Expire Date: "+passportExpireDate
                +" - residence Number: "+residenceNumber
                +" - residence Expiry Date: "+residenceExpiryDate
                +" - insured: "+insured
                +" - insurance Date: "+insuranceDate
                +" - insurance Code: "+insuranceCode
                +" - insurance Card Expiry: "+insuranceCardExpiry
                +" - worker Spouse: "+workerSpouse
                +" - work Text: "+workText
                +" - medical Claim Coverage: "+medicalClaimCoverage
                +" - medical Claim Start Date: "+medicalClaimStartDate
                +" - allowance Amount: "+allowanceAmount
                +" - start Date Allowance: "+startDateAllowance
                +" - to Date Allowance: "+toDateAllowance
                +" - notes: "+notes
                +" - upload Picture: "+uploadPicture);

    }

    public void justAddSpouseWithoutSave( String birthDate, String marriageDate, String deathDate, String divorceDate, String birthPlace, String nationality, String nationalCode,
                                      String nationalCodeExpireDate, String passportNumber, String passportExpireDate, String residenceNumber, String residenceExpiryDate, boolean insured,
                                      String insuranceDate, String insuranceCode, String insuranceCardExpiry, boolean workerSpouse, String workText, boolean medicalClaimCoverage,
                                      String medicalClaimStartDate, String allowanceAmount, String startDateAllowance, String toDateAllowance, String notes, boolean uploadPicture){


        hold(300);
        clickOn(spousePage);
        elementWaitAdvanced(By.id("wife_name_man1"));
        setText(firstNameSpouse, randomNumber()+"FS");
        setText(secondNameSpouse, randomNumber()+"SS");
        setText(thirdNameSpouse, randomNumber()+"TS");
        setText(familyNameSpouse, randomNumber()+"LS");
        setText(firstNameArSpouse, randomNumber()+"FAS");
        setText(secondNameArSpouse, randomNumber()+"SAS");
        setText(thirdNameArSpouse, randomNumber()+"TAS");
        setText(familyNameArSpouse, randomNumber()+"LAS");
        birthDateSpouseE.clear();
        hold(200);
        setText(birthDateSpouseE, birthDate);
        setText(marryDateSpouseE, marriageDate);
        setText(deathDateE, deathDate);
        setText(divorceDateE, divorceDate);
        selectOption(birthPlaceSpouseE, birthPlace);
        selectOption(nationalitySpouseE, nationality);
        setText(nationalCodeSpouseE, nationalCode);
        setText(nationalExpireDateE, nationalCodeExpireDate);
        setText(passportNumberE, passportNumber);
        setText(passportExpireDateE, passportExpireDate);
        setText(residenceNumberE, residenceNumber);
        scrollToElement(notesSpouseE);
        setText(residenceExpiryDateE, residenceExpiryDate);
        if (insured){
            clickOn(insuredSpouseE);
            hold(500);
            setText(insuranceDateSpouseE, insuranceDate);
            setText(insuranceCodeSpouseE, insuranceCode);
            setText(insuranceCardExpirySpouseE, insuranceCardExpiry);
        }
        if(workerSpouse){
            clickOn(workerSpouseE);
            hold(300);
            setText(workerText, workText);
        }

        if(!liteGetter()){
            if(medicalClaimCoverage){
                if (!medicalClaimCoverageSpouseE.isSelected()){
                    clickOn(medicalClaimCoverageSpouseE);
                }
                hold(400);
                setText(claimStartDateE, medicalClaimStartDate);
            }
        }

        allowanceAmountSpouseE.clear();
        hold(500);
        setText(allowanceAmountSpouseE, allowanceAmount);
        setText(startDateAllowanceE, startDateAllowance);
        setText(endDateAllowanceE, toDateAllowance);
        if(uploadPicture){
            spousePictureE.sendKeys(uploadRandomImage());
        }
        setText(notesSpouseE, notes);
        scrollToElement(empCode);

        setLog("Add Spouse"
                +" - birth Date: "+birthDate
                +" - marriage Date: "+marriageDate
                +" - death Date: "+deathDate
                +" - divorce Date: "+divorceDate
                +" - birth Place: "+birthPlace
                +" - nationality: "+nationality
                +" - national Code: "+nationalCode
                +" - national Code Expire Date: "+nationalCodeExpireDate
                +" - passport Number: "+passportNumber
                +" - passport Expire Date: "+passportExpireDate
                +" - residence Number: "+residenceNumber
                +" - residence Expiry Date: "+residenceExpiryDate
                +" - insured: "+insured
                +" - insurance Date: "+insuranceDate
                +" - insurance Code: "+insuranceCode
                +" - insurance Card Expiry: "+insuranceCardExpiry
                +" - worker Spouse: "+workerSpouse
                +" - work Text: "+workText
                +" - medical Claim Coverage: "+medicalClaimCoverage
                +" - medical Claim Start Date: "+medicalClaimStartDate
                +" - allowance Amount: "+allowanceAmount
                +" - start Date Allowance: "+startDateAllowance
                +" - to Date Allowance: "+toDateAllowance
                +" - notes: "+notes
                +" - upload Picture: "+uploadPicture);

    }

    public void editSpouse(boolean insured, boolean worker){

        addSpouse("01/01/1992", "01/01/2005", "", "", "Birth Place 1", "Jordanian", "1"+ randomNumber(),
                "01/01/2030", "PAS"+randomNumber(), "01/01/2032", "15"+randomNumber(), "01/02/2032",
                true, "01/02/2020", "32"+randomNumber(), "01/05/2030", true, "Worker Text", false,
                "01/03/2020", "10.000", "03/03/2021", "03/03/2027", "Spouse Note Test", false);

        elementWaitAdvanced(By.xpath("//li[@class='nav-item']//button[1]"));
        clickOn(employmentInformationPage);
        hold(300);
        elementWaitAdvanced(By.id("select2-site_1-container"));
        clickOn(spousePage);
        hold(500);
        elementWaitAdvanced(By.id("wife_name_man1"));
        clickOn(item);
        hold(300);
        firstNameSpouse.clear();
        hold(200);
        setText(firstNameSpouse, personnelInformation.employeeCode+"Edited");
        familyNameSpouse.clear();
        hold(200);
        setText(familyNameSpouse, personnelInformation.employeeCode+"Edited");
        birthDateSpouseE.clear();
        hold(200);
        setText(birthDateSpouseE, "01/01/1995");
        marryDateSpouseE.clear();
        hold(200);
        setText(marryDateSpouseE, "10/10/2004");
        selectOption(nationalitySpouseE, "Egyptian");
        nationalCodeSpouseE.clear();
        hold(200);
        String nationalCodeEdited = "111"+randomNumber();
        setText(nationalCodeSpouseE, nationalCodeEdited);
        scrollToElement(notesSpouseE);
        String insuranceCodeEdited = "555"+randomNumber();
        if(insured){
            if(insuredSpouseE.isSelected()){
                insuranceDateSpouseE.clear();
                hold(200);
                setText(insuranceDateSpouseE, "12/12/2020");
                insuranceCodeSpouseE.clear();
                hold(200);
                setText(insuranceCodeSpouseE, insuranceCodeEdited);
            }
        }else{
            insuredSpouseE.click();
        }
        if(worker){
            if(workerSpouseE.isSelected()){
                workerText.clear();
                hold(200);
                setText(workerText, "Worker Text Edited");
            }
        }else{
            workerSpouseE.click();
        }
        allowanceAmountSpouseE.clear();
        hold(200);
        setText(allowanceAmountSpouseE, "20.000");
        startDateAllowanceE.clear();
        hold(200);
        setText(startDateAllowanceE, "06/06/2021");
        endDateAllowanceE.clear();
        hold(200);
        setText(endDateAllowanceE, "04/04/2028");
        notesSpouseE.clear();
        hold(200);
        setText(notesSpouseE, "Spouse Note Edited");
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertEquals(firstNameSpouse.getDomAttribute("value"), personnelInformation.employeeCode+"Edited", "-First Name NOT Edited Correctly!");
        softAssert.assertEquals(familyNameSpouse.getDomAttribute("value"), personnelInformation.employeeCode+"Edited", "-Family Name NOT Edited Correctly!");
        softAssert.assertEquals(birthDateSpouseE.getDomAttribute("value"), "01/01/1995", "-Birth Date NOT Edited Correctly!");
        softAssert.assertEquals(marryDateSpouseE.getDomAttribute("value"), "10/10/2004", "-Marriage Date NOT Edited Correctly!");
        softAssert.assertEquals(nationalitySpouseE.getText(), "Egyptian", "-Nationality NOT Edited Correctly!");
        softAssert.assertEquals(nationalCodeSpouseE.getDomAttribute("value"), nationalCodeEdited, "-National Code NOT Edited Correctly!");
        softAssert.assertEquals(insuredSpouseE.isSelected(), insured, "-Insured");
        softAssert.assertEquals(workerSpouseE.isSelected(), worker, "-Worker");
        softAssert.assertEquals(allowanceAmountSpouseE.getDomAttribute("value"), "20.000", "-Allowance Amount NOT Edited Correctly!");
        softAssert.assertEquals(startDateAllowanceE.getDomAttribute("value"), "06/06/2021", "-Start Date Allowance NOT Edited Correctly!");
        softAssert.assertEquals(endDateAllowanceE.getDomAttribute("value"), "04/04/2028", "-To Date Allowance NOT Edited Correctly!");
        if(insured){
            softAssert.assertEquals(insuranceDateSpouseE.getDomAttribute("value"), "12/12/2020", "-Insurance Date NOT Edited Correctly!");
            softAssert.assertEquals(insuranceCodeSpouseE.getDomAttribute("value"), insuranceCodeEdited, "-Insurance Code NOT Edited Correctly!");
        }
        if(worker){
            softAssert.assertEquals(workerText.getDomAttribute("value"), "Worker Text Edited", "-Worker NOT Edited Correctly!");
        }
        softAssert.assertEquals(notesSpouseE.getText(), "Spouse Note Edited", "-Notes NOT Edited Correctly!");
        softAssert.assertAll();

    }

    public void deleteSpouse(){

        addSpouse("01/01/1992", "01/01/2005", "", "", "Birth Place 1", "Jordanian", "1"+ randomNumber(),
                "01/01/2030", "PAS"+randomNumber(), "01/01/2032", "15"+randomNumber(), "01/02/2032",
                true, "01/02/2020", "32"+randomNumber(), "01/05/2030", true, "Worker Text", true,
                "01/03/2020", "10.000", "03/03/2021", "03/03/2027", "Spouse Note Test", true);

        elementWaitAdvanced(By.xpath("//li[@class='nav-item']//button[1]"));
        clickOn(deleteSpouseBtn);
        hold(500);
        clickOn(alertButtonOkDeleteSpouse);
        hold(500);
        clickOn(spousePage);
        hold(300);
        elementWaitAdvanced(By.id("wife_name_man1"));
        Assert.assertTrue(checkElementIfNotAppear(checkItem));

        setLog("Delete Spouse");

    }

    public void deathDateBeforeTheMarriageDate(){

        addSpouseWithoutSave("01/01/1992", "01/01/2005", "01/01/2004", "", "", "", "",
                "", "", "", "", "", false, "", "",
                "", false, "", true, "", "", "", "", "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Death Date Can Not Be Before The Marriage Date!");
        softAssert.assertTrue(deathDateE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void divorceDateBeforeTheMarriageDate(){

        addSpouseWithoutSave("01/01/1992", "01/01/2005", "", "01/01/2004", "", "", "",
                "", "", "", "", "", false, "", "",
                "", false, "", true, "", "", "", "", "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Divorce Date Can Not Be Before The Birth Date/Marriage Date!");
        softAssert.assertTrue(divorceDateE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void divorceDateAfterDeathDate(){

        addSpouseWithoutSave("01/01/1992", "", "01/01/2004", "01/01/2005", "", "", "",
                "", "", "", "", "", false, "", "",
                "", false, "", true, "", "", "", "", "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Divorce Date Can Not Be after The Death Date!");
        softAssert.assertTrue(deathDateE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void deathDateBeforeBirthDate(){

        addSpouseWithoutSave("01/01/2002", "", "01/01/2001", "", "", "", "",
                "", "", "", "", "", false, "", "",
                "", false, "", true, "", "", "", "", "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Death Date Can Not Be Before The Birth Date!");
        softAssert.assertTrue(deathDateE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void marriageDateBeforeEmployeeBirthDate(){

        addSpouseWithoutSave("", "01/01/1989", "", "", "", "", "",
                "", "", "", "", "", false, "", "",
                "", false, "", true, "", "", "", "", "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Marriage Date Can Not Be Before The Employee`s Birth Date!");
        softAssert.assertTrue(marryDateSpouseE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void marriageDateBeforeBirthDate(){

        addSpouseWithoutSave("01/01/2002", "01/01/1995", "", "", "", "", "",
                "", "", "", "", "", false, "", "",
                "", false, "", true, "", "", "", "", "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Marriage Date Can Not Be Before The Birth Date!");
        softAssert.assertTrue(marryDateSpouseE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void minimumAgeForMarriage(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        systemParameters = new SystemParameters();
        systemParameters.minimumAgeForMarriage("30");
        hold(300);
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "",
                "", "", "", "", "01/01/2000");
        personnelInformation.employmentInformation("Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        justAddSpouseWithoutSave("01/01/2002", "01/01/2020", "", "", "", "", "",
                "", "", "", "", "", false, "", "",
                "", false, "", true, "", "", "", "", "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Can Not Define This Employee As Married Or Add A Spouse Record For This Employee! Employee`s Age Is Less Than 30Years As You Setup In The System Parameters Page!");

        clickOn(okBtn);
        hold(300);
        clickOn(spousePage);
        hold(300);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters = new SystemParameters();
        systemParameters.minimumAgeForMarriage("0");

        softAssert.assertAll();

    }

    public void uploadPhotoWithWrongExtension(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getDomAttribute("value");

        justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        closeIFrame();

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        elementWaitAdvanced(By.xpath("//label[contains(text(),'Active Employee')]"));
        clickOn(spousePage);
        elementWaitAdvanced(By.id("wife_name_man1"));
        hold(500);
        clickOn(item);
        hold(300);
        scrollToElement(notesSpouseE);
        spousePictureE.sendKeys(uploadDocFile());
        hold(500);
        scrollToElement(empCode);
        hold(200);
        clickOn(saveBtn);
        hold(300);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Can Not Upload Any File With The Extension: docx");
        softAssert.assertAll();

    }

    public void uploadPhotoNotAllowed(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getDomAttribute("value");


        justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        closeIFrame();

        clickOn(personnelInformation.logout);
        hold(300);

        login.ali5User();
        menaModules.menaPAY();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation.goToEmployeeByCode(employeeCode);
        elementWaitAdvanced(By.xpath("//label[contains(text(),'Active Employee')]"));
        clickOn(spousePage);
        elementWaitAdvanced(By.id("wife_name_man1"));
        hold(500);
        clickOn(item);
        hold(300);
        scrollToElement(notesSpouseE);
        spousePictureE.sendKeys(uploadRandomImage());
        hold(500);
        scrollToElement(empCode);
        hold(100);
        clickOn(saveBtn);
        hold(300);
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
        personnelInformation.personalInformation("Married", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getDomAttribute("value");


        justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        closeIFrame();

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        elementWaitAdvanced(By.xpath("//label[contains(text(),'Active Employee')]"));
        clickOn(spousePage);
        elementWaitAdvanced(By.id("wife_name_man1"));
        hold(500);
        clickOn(item);
        hold(300);
        scrollToElement(notesSpouseE);
        spousePictureE.sendKeys(uploadRandomImage());
        hold(500);
        scrollToElement(empCode);
        hold(200);
        clickOn(saveBtn);
        hold(300);
        Assert.assertEquals(VerifyImage(checkPicture), 200,"This image is broken : "+checkPicture.getDomAttribute("src"));

    }

    public void validateDefaultAllowanceAmount(String spouseAllowanceAmount){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        systemParameters = new SystemParameters();
        systemParameters.spouseAllowanceAmount(spouseAllowanceAmount);
        hold(300);
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getDomAttribute("value");


        justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        closeIFrame();

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        clickOn(spousePage);
        elementWaitAdvanced(By.id("wife_name_man1"));
        hold(500);
        Assert.assertEquals(allowanceAmountSpouseE.getDomAttribute("value"), spouseAllowanceAmount, "Allowance Amount NOT Same System Parameters!");

    }

    public void addWrongAllowanceAmount(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getDomAttribute("value");


        justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        closeIFrame();

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);

        clickOn(spousePage);
        elementWaitAdvanced(By.id("wife_name_man1"));
        hold(500);
        clickOn(item);
        hold(300);
        scrollToElement(notesSpouseE);
        allowanceAmountSpouseE.clear();
        hold(300);
        setText(allowanceAmountSpouseE, "10ab");
        hold(300);
        scrollToElement(empCode);
        hold(200);
        clickOn(saveBtn);
        hold(300);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Should Only Contain Decimal Values.");
        softAssert.assertAll();

    }

    public void allowanceAmountStartDateAfterEndDate(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getDomAttribute("value");


        justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        closeIFrame();

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        clickOn(spousePage);
        elementWaitAdvanced(By.id("wife_name_man1"));
        hold(500);
        clickOn(item);
        hold(300);
        scrollToElement(notesSpouseE);
        allowanceAmountSpouseE.clear();
        hold(300);
        setText(allowanceAmountSpouseE, "10.000");
        hold(300);
        startDateAllowanceE.clear();
        hold(200);
        setText(startDateAllowanceE, "01/05/2022");
        hold(200);
        endDateAllowanceE.clear();
        hold(200);
        setText(endDateAllowanceE, "01/03/2022");
        scrollToElement(empCode);
        hold(200);
        clickOn(saveBtn);
        hold(300);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The End Date Can Not Be Before The Start Date! Please Re-enter The End Date");
        softAssert.assertAll();

    }

    public void insurancePeriodStartDateAfterEndDate(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getDomAttribute("value");


        justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        closeIFrame();

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        clickOn(spousePage);
        elementWaitAdvanced(By.id("wife_name_man1"));
        hold(500);
        clickOn(item);
        hold(300);
        scrollToElement(notesSpouseE);
        clickOn(insuredSpouseE);
        hold(500);
        insuranceDateSpouseE.clear();
        hold(300);
        setText(insuranceDateSpouseE, "01/02/2020");
        hold(300);
        insuranceCardExpirySpouseE.clear();
        hold(200);
        setText(insuranceCardExpirySpouseE, "01/01/2020");
        hold(200);
        scrollToElement(empCode);
        hold(200);
        clickOn(saveBtn);
        hold(300);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "Insurance Start Date Can Not Be After The Insurance Card End Date!");
        softAssert.assertAll();

    }

    public void validateHijriConverterForSpouseBirthDate(String hijriDate){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getDomAttribute("value");


        justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","", "", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        hold(500);
        clickOn(hijriConverter);
        hold(300);
        goToFrame(iframePopup);
        hold(300);
        softAssert.assertTrue(hijriDateE.isDisplayed(), "- Issue, Hijri Conversion Box Not Appear");
        elementWait(hijriDateE);
        setText(hijriDateE, hijriDate);
        hold(500);
        clickOn(convertHijriBtn);
        hold(300);
        driver.switchTo().defaultContent();
        goToFrame(frame);
        clickOn(saveBtn);

        int day = Integer.parseInt(hijriDate.substring(0,2));
        int month = Integer.parseInt(hijriDate.substring(3,5));
        int year = Integer.parseInt(hijriDate.substring(6,10));

        HijrahDate hd = HijrahChronology.INSTANCE.date(HijrahEra.AH, year, month, day);
        LocalDate ld = LocalDate.from(hd);
        ld = ld.minusDays(1); //// To minus 1 Day, This is how the MenaITech system works
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String afterConvert = ld.format(formatters);
        //System.out.println(afterConvert);
        Assert.assertEquals(birthDateSpouseE.getDomAttribute("value"), afterConvert, "- Incorrect Date after convert!");


    }

    public void addMoreThanOneSpouse( int spouseCount, String birthDate, String marriageDate, String deathDate, String divorceDate, String birthPlace, String nationality, String nationalCode,
                                      String nationalCodeExpireDate, String passportNumber, String passportExpireDate, String residenceNumber, String residenceExpiryDate, boolean insured,
                                      String insuranceDate, String insuranceCode, String insuranceCardExpiry, boolean workerSpouse, String workText, boolean medicalClaimCoverage,
                                      String medicalClaimStartDate, String allowanceAmount, String startDateAllowance, String toDateAllowance, String notes, boolean uploadPicture ){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        hold(300);
        clickOn(spousePage);
        elementWaitAdvanced(By.id("wife_name_man1"));
        double allowancesCounter = 0.000;
        DecimalFormat dec = new DecimalFormat("#.000"); //// To print decimal Zeros like 30.000

        for (int i = 1; i <= spouseCount; i++){

            justAddSpouse(randomNumber()+" Spouse "+i,"", "",
                    randomNumber()+"L Spouse "+i, randomNumber()+"A Spouse "+i,
                    "", "", randomNumber()+"AL Spouse "+i, birthDate, marriageDate,
                    deathDate, divorceDate, birthPlace, nationality, nationalCode+i,nationalCodeExpireDate, passportNumber+i,
                    passportExpireDate, residenceNumber+i, residenceExpiryDate,insured, insuranceDate, insuranceCode+i,
                    insuranceCardExpiry, workerSpouse,workText+i, medicalClaimCoverage,medicalClaimStartDate, allowanceAmount, startDateAllowance,
                    toDateAllowance, notes+i, uploadPicture);

            allowancesCounter = allowancesCounter+Double.parseDouble(allowanceAmount);

            hold(300);
            clickOn(addBtn);
            hold(500);


        }

        softAssert.assertEquals(items.size(), spouseCount, "Issue in the number of Spouse!");
        softAssert.assertEquals(totalAllowances.getText().trim(), dec.format(allowancesCounter),"- Issue in Total Allowances Amount");
        softAssert.assertAll();

    }

    public void flag_is_gulf(String flag){

        MssqlConnect.sqlQuery("update adm_branch set is_gulf = "+flag+" where branch_code = 'auto_a1'");

        addSpouseWithoutSave("01/01/1992", "01/01/2005", "", "", "", "", "",
                "", "", "", "", "", false, "", "",
                "", false, "", true, "", "", "", "", "", false);

        if(flag.equals("0")){
            softAssert.assertTrue(checkElementIfNotAppear(driver.findElements(By.id("national_expire_date"))));
            softAssert.assertTrue(checkElementIfNotAppear(driver.findElements(By.id("passport_number"))));
            softAssert.assertTrue(checkElementIfNotAppear(driver.findElements(By.id("residence_expiry_date"))));
            softAssert.assertTrue(checkElementIfNotAppear(driver.findElements(By.id("residence_number"))));
            MssqlConnect.sqlQuery("update adm_branch set is_gulf = 1 where branch_code = 'auto_a1'");
        } else if (flag.equals("1")) {
            softAssert.assertFalse(driver.findElements(By.id("national_expire_date")).isEmpty());
            softAssert.assertFalse(driver.findElements(By.id("passport_number")).isEmpty());
            softAssert.assertFalse(driver.findElements(By.id("residence_expiry_date")).isEmpty());
            softAssert.assertFalse(driver.findElements(By.id("residence_number")).isEmpty());
        }
        softAssert.assertAll();
    }

    public void flag_country_profile_admin(String flag){

        MssqlConnect.sqlQuery("update adm_branch set country_profile = "+flag+" where branch_code = 'auto_a1'");

        addSpouseWithoutSave("01/01/1992", "01/01/2005", "", "", "", "", "",
                "", "", "", "", "", false, "", "",
                "", false, "", true, "", "", "", "", "", false);

        if(flag.equals("5")){
            softAssert.assertFalse(driver.findElements(By.id("flexhandicappedCheckCheckedx")).isEmpty());
            if(!handicappedE.isSelected()){
                clickOn(handicappedE);
                hold(300);
                scrollToElement(empCode);
                clickOn(saveBtn);
                hold(300);
                scrollToElement(handicappedE);
                softAssert.assertTrue(handicappedE.isSelected(), "-handicapped NOT Selected, it shoud be selected");
            }

        }else{
            softAssert.assertTrue(checkElementIfNotAppear(driver.findElements(By.id("flexhandicappedCheckCheckedx"))));
        }
        MssqlConnect.sqlQuery("update adm_branch set country_profile = 1 where branch_code = 'auto_a1'");
        softAssert.assertAll();

    }

    public void flag_is_claim(String flag){

        MssqlConnect.sqlQuery("update adm_company set is_claim = "+flag+" where company_code = 'automation'");

        addSpouseWithoutSave("01/01/1992", "01/01/2005", "", "", "", "", "",
                "", "", "", "", "", false, "", "",
                "", false, "", false, "", "", "", "", "", false);

        if(flag.equals("0")){
            softAssert.assertEquals(medicalClaimCoverageSpouseE.getDomAttribute("disabled"), "true", "- Medical Claim Coverage Should be Hidden");
        }else{
            softAssert.assertEquals(medicalClaimCoverageSpouseE.getDomAttribute("disabled"), null, "- Medical Claim Coverage Should be Appear");
        }
        MssqlConnect.sqlQuery("update adm_company set is_claim = 1 where company_code = 'automation'");
        softAssert.assertAll();

    }

    public String allowanceAmountSpouseE(String attribute){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = allowanceAmountSpouseE.getDomAttribute(attribute);
        }else {
            personalInformationOct = new PersonalInformation_OCT();
            str = personalInformationOct.allowanceAmountSpouseE.getDomAttribute(attribute);
        }
        return str;
    }

}
