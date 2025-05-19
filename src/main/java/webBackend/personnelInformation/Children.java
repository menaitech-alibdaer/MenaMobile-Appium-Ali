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

public class Children extends WebBase {

    @FindBy(xpath = "//span[contains(@id, 'select2-wife_id')]")
    WebElement spouseList;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(xpath = "//div[contains(@onclick, 'employment_information.php')]")
    WebElement employmentInformationPage;
    @FindBy(id = "son_name_man1")
    WebElement firstNameChildren;
    @FindBy(id = "son_name_man2")
    WebElement secondNameChildren;
    @FindBy(id = "son_name_man3")
    WebElement thirdNameChildren;
    @FindBy(id = "son_name_man4")
    WebElement familyNameChildren;
    @FindBy(id = "son_name_other1")
    WebElement firstArNameChildren;
    @FindBy(id = "son_name_other2")
    WebElement secondArNameChildren;
    @FindBy(id = "son_name_other3")
    WebElement thirdArNameChildren;
    @FindBy(id = "son_name_other4")
    WebElement familyArNameChildren;
    @FindBy(id = "birth_date")
    WebElement birthDateE;
    @FindBy(id = "deathDate")
    WebElement deathDateE;
    @FindBy(id = "select2-sex-container")
    WebElement genderE;
    @FindBy(id = "select2-marital_status_flag-container")
    WebElement maritalStatusChildren;
    @FindBy(id = "select2-birth_place-container")
    WebElement birthPlaceChildren;
    @FindBy(id = "residence_number")
    WebElement residenceNumberE;
    @FindBy(id = "residence_expiry_date")
    WebElement residenceExpiryDateE;
    @FindBy(id = "select2-nationality-container")
    WebElement nationalityE;
    @FindBy(id = "national_code")
    WebElement nationalCodeE;
    @FindBy(id = "national_expire_date")
    WebElement nationalCodeExpireDateE;
    @FindBy(id = "passport_number")
    WebElement passportNumberE;
    @FindBy(id = "passport_expire_date")
    WebElement passportExpireDateE;
    @FindBy(id = "child_picture")
    WebElement pictureE;
    @FindBy(xpath = "//button[@data-bs-toggle='collapse'][contains(text(),'Other Information')]")
    WebElement otherInformationList;
    @FindBy(name = "alowance_amount")
    public WebElement alowanceAmountE;
    @FindBy(id = "start_date")
    WebElement alowanceStartingFrom;
    @FindBy(id = "end_date")
    WebElement alowanceToDate;
    @FindBy(name = "student")
    WebElement studentCheckbox;
    @FindBy(xpath = "//span[contains(@id, 'select2-education_level')]")
    WebElement educationLevelE;
    @FindBy(xpath = "//span[contains(@id, 'select2-school')]")
    WebElement schoolE;
    @FindBy(name = "in_edu_system")
    WebElement educationSystemBeneficiaryCheckbox;
    @FindBy(id = "IS_Under_CNSS")
    List<WebElement> underCNSS;
    @FindBy(name = "insured")
    WebElement insuredCheckbox;
    @FindBy(id = "insurance_date")
    WebElement insuranceStartDateE;
    @FindBy(id = "insurance_number")
    WebElement insuranceCodeE;
    @FindBy(id = "son_end_ins_date")
    WebElement insuranceCardExpiryE;
    @FindBy(name = "is_MC_covered")
    WebElement medicalClaimCoverageCheckbox;
    @FindBy(xpath = "//span[contains(@id, 'select2-sa_sector')]")
    List<WebElement> sa_sector;
    @FindBy(xpath = "//span[contains(@id, 'select2-sa_level')]")
    List<WebElement> sa_level;
    @FindBy(id = "spouse_has_SA")
    List<WebElement> spouse_has_SA;
    @FindBy(id = "spouse_has_SA_type_1")
    List<WebElement> spouse_has_SA_type_1;
    @FindBy(id = "spouse_has_SA_type_2")
    List<WebElement> spouse_has_SA_type_2;
    @FindBy(id = "claim_start_date")
    WebElement medicalClaimStartDateE;
    @FindBy(id = "permanentDisability")
    WebElement permanentDisabilityCheckbox;
    @FindBy(xpath = "//div[contains(@class, 'mar-left-36-minus')]//label[2]")
    WebElement totalAllowances;
    @FindBy(xpath = "//div[@class='textAlign']//label[contains(@style, 'font-size:20px')]")
    WebElement alertText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    WebElement alertBox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addBtn;
    @FindBy(name = "conv2")
    WebElement hijriConverter;
    @FindBy(id = "date")
    WebElement hijriDateE;
    @FindBy(xpath = "//input[@value='Convert']")
    WebElement convertHijriBtn;
    @FindBy(id = "All_popup")
    WebElement iframePopup;
    @FindBy(id = "body_frame")
    WebElement frame;
    @FindBy(id = "blah")
    WebElement checkPicture;
    @FindBy(xpath = "//div[contains(@onclick, 'Sons.php')]")
    WebElement childrenPage;
    @FindBy(xpath = "//div[contains(@onclick, 'Wives.php')]")
    WebElement spousePageTab;
    @FindBy(xpath = "//span[contains(@onclick, 'confirm_delete')]")
    WebElement deleteChildrenBtn;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDeleteChildren;
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
    Spouse spouse;
    String employeeCode = null;
    String firstNC = firstName();
    String secondNC = secondName();
    String thirdNC = thirdName();
    String lastNC = lastName();

    public void addChildren(String birthDate, String deathDate, String gender, String maritalStatus, String birthPlace, String residenceNumber, String residenceExpiryDate, String nationality,
                            String nationalCode, String nationalCodeExpiryDate, String passportNumber, String passportExpiryDate, String allowanceAmount, String allowanceStartingFrom,
                            String allowanceToDate, boolean student, String educationLevel, String school, boolean educationSystemBeneficiary, boolean insured, String insuranceStartDate,
                            String insuranceCode, String insuranceCardExpiry, boolean medicalClaimCoverage, String medicalClaimStartDate, boolean permanentDisability){

        hold(500);
        elementWaitAdvanced(By.id("son_name_man1"));
        employeeCode = empCode.getDomAttribute("value");
        setText(firstNameChildren, firstNC);
        setText(secondNameChildren, secondNC);
        setText(thirdNameChildren, thirdNC);
        setText(familyNameChildren, lastNC);
        setText(firstArNameChildren, firstNC);
        setText(secondArNameChildren, secondNC);
        setText(thirdArNameChildren, thirdNC);
        setText(familyArNameChildren, lastNC);
        setText(birthDateE, birthDate);
        setText(deathDateE, deathDate);
        selectOption(genderE, gender);
        selectOption(maritalStatusChildren, maritalStatus);
        selectOption(birthPlaceChildren, birthPlace);
        setText(residenceNumberE, residenceNumber);
        setText(residenceExpiryDateE, residenceExpiryDate);
        selectOption(nationalityE, nationality);
        scrollToElement(checkPicture);
        setText(nationalCodeE, nationalCode);
        setText(nationalCodeExpireDateE, nationalCodeExpiryDate);
        setText(passportNumberE, passportNumber);
        setText(passportExpireDateE, passportExpiryDate);
        pictureE.sendKeys(uploadRandomImage());
        clickOn(otherInformationList);
        hold(300);
        scrollToElement(permanentDisabilityCheckbox);
        if(!allowanceAmount.isEmpty()){
            alowanceAmountE.clear();
            hold(400);
            setText(alowanceAmountE, allowanceAmount);
        }
        alowanceStartingFrom.clear();
        hold(400);
        setText(alowanceStartingFrom, allowanceStartingFrom);
        setText(alowanceToDate, allowanceToDate);
        hold(800);
        if(student){
            clickOn(studentCheckbox);
            hold(500);
            if(!liteGetter()){
                selectOption(educationLevelE, educationLevel);
                selectOption(schoolE, school);
            }
        }
        hold(400);
        if(!liteGetter()){
            if(!educationSystemBeneficiaryCheckbox.isDisplayed()){
                if(educationSystemBeneficiary){
                    clickOn(educationSystemBeneficiaryCheckbox);
                }
            }
        }
        hold(400);
        if(insured){
            clickOn(insuredCheckbox);
            hold(400);
            setText(insuranceStartDateE, insuranceStartDate);
            setText(insuranceCodeE, insuranceCode);
            setText(insuranceCardExpiryE, insuranceCardExpiry);
        }
        hold(400);

        if(!liteGetter()){
            if(medicalClaimCoverage){
                if(!medicalClaimCoverageCheckbox.isSelected()){
                    clickOn(medicalClaimCoverageCheckbox);
                }
                hold(400);
                setText(medicalClaimStartDateE, medicalClaimStartDate);
            }
        }

        hold(400);
        if(permanentDisability){
            clickOn(permanentDisabilityCheckbox);
        }
        hold(500);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(300);

        setLog("Add Children"
        +" - birth Date: "+birthDate
        +" - death Date: "+deathDate
        +" - gender: "+gender
        +" - marital Status: "+maritalStatus
        +" - birth Place: "+birthPlace
        +" - residence Number: "+residenceNumber
        +" - residence Expiry Date: "+residenceExpiryDate
        +" - nationality: "+nationality
        +" - national Code: "+nationalCode
        +" - national Code Expiry Date: "+nationalCodeExpiryDate
        +" - passport Number: "+passportNumber
        +" - passport Expiry Date: "+passportExpiryDate
        +" - allowance Amount: "+allowanceAmount
        +" - allowance Starting From: "+allowanceStartingFrom
        +" - allowance To Date: "+allowanceToDate
        +" - student: "+student
        +" - education Level: "+educationLevel
        +" - school: "+school
        +" - education System Beneficiary: "+educationSystemBeneficiary
        +" - insured: "+insured
        +" - insurance Start Date: "+insuranceStartDate
        +" - insurance Code: "+insuranceCode
        +" - insurance Card Expiry: "+insuranceCardExpiry
        +" - medical Claim Coverage: "+medicalClaimCoverage
        +" - medical Claim Start Date: "+medicalClaimStartDate
        +" - permanent Disability: "+permanentDisability);

    }

    public void addChildrenAfterSpouse(String birthDate, String deathDate, String gender, String maritalStatus, String birthPlace, String residenceNumber, String residenceExpiryDate, String nationality,
                            String nationalCode, String nationalCodeExpiryDate, String passportNumber, String passportExpiryDate, String allowanceAmount, String allowanceStartingFrom,
                            String allowanceToDate, boolean student, String educationLevel, String school, boolean educationSystemBeneficiary, boolean insured, String insuranceStartDate,
                            String insuranceCode, String insuranceCardExpiry, boolean medicalClaimCoverage, String medicalClaimStartDate, boolean permanentDisability){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            hold(500);
            clickOn(childrenPage);
            elementWaitAdvanced(By.id("son_name_man1"));
            hold(500);
            employeeCode = empCode.getDomAttribute("value");
            setText(firstNameChildren, firstName());
            setText(secondNameChildren, secondName());
            setText(thirdNameChildren, thirdName());
            setText(familyNameChildren, lastName());
            setText(firstArNameChildren, firstName());
            setText(secondArNameChildren, secondName());
            setText(thirdArNameChildren, thirdName());
            setText(familyArNameChildren, lastName());
            birthDateE.clear();
            hold(200);
            setText(birthDateE, birthDate);
            setText(deathDateE, deathDate);
            selectOption(genderE, gender);
            selectOption(maritalStatusChildren, maritalStatus);
            selectOption(birthPlaceChildren, birthPlace);
            setText(residenceNumberE, residenceNumber);
            setText(residenceExpiryDateE, residenceExpiryDate);
            selectOption(nationalityE, nationality);
            scrollToElement(checkPicture);
            setText(nationalCodeE, nationalCode);
            setText(nationalCodeExpireDateE, nationalCodeExpiryDate);
            setText(passportNumberE, passportNumber);
            setText(passportExpireDateE, passportExpiryDate);
            pictureE.sendKeys(uploadRandomImage());
            clickOn(otherInformationList);
            hold(300);
            scrollToElement(insuredCheckbox);
            if(!allowanceAmount.isEmpty()){
                alowanceAmountE.clear();
                hold(400);
                setText(alowanceAmountE, allowanceAmount);
            }
            if(!allowanceStartingFrom.isEmpty()){
                alowanceStartingFrom.clear();
                hold(400);
                setText(alowanceStartingFrom, allowanceStartingFrom);
            }
            if(!allowanceToDate.isEmpty()){
                alowanceToDate.clear();
                hold(400);
                setText(alowanceToDate, allowanceToDate);
            }

            if(student){
                hold(400);
                clickOn(studentCheckbox);
                hold(400);
                selectOption(educationLevelE, educationLevel);
                selectOption(schoolE, school);
            }

            if(!liteGetter()){
                if(!educationSystemBeneficiaryCheckbox.isDisplayed()){
                    if(educationSystemBeneficiary){
                        hold(400);
                        clickOn(educationSystemBeneficiaryCheckbox);
                    }
                }
            }

            if(insured){
                if(!insuredCheckbox.isSelected()){
                    hold(400);
                    clickOn(insuredCheckbox);
                    hold(400);
                    setText(insuranceStartDateE, insuranceStartDate);
                    setText(insuranceCodeE, insuranceCode);
                    setText(insuranceCardExpiryE, insuranceCardExpiry);
                }
            }else{
                if(insuredCheckbox.isSelected()){
                    hold(400);
                    clickOn(insuredCheckbox);
                    hold(400);
                    setText(insuranceStartDateE, insuranceStartDate);
                    setText(insuranceCodeE, insuranceCode);
                    setText(insuranceCardExpiryE, insuranceCardExpiry);
                }
            }

            if(!liteGetter()){
                if(medicalClaimCoverage){
                    hold(400);
                    if(!medicalClaimCoverageCheckbox.isSelected()){
                        clickOn(medicalClaimCoverageCheckbox);
                    }
                    hold(400);
                    setText(medicalClaimStartDateE, medicalClaimStartDate);
                }else{
                    if(medicalClaimCoverageCheckbox.isSelected()){
                        hold(400);
                        clickOn(medicalClaimCoverageCheckbox);
                    }
                }
            }

            if(permanentDisability){
                hold(400);
                clickOn(permanentDisabilityCheckbox);
            }
            hold(200);
            scrollToElement(empCode);
            clickOn(saveBtn);
            hold(300);

        }else {

            personalInformationOct = new PersonalInformation_OCT();
            personalInformationOct.addChildrenAfterSpouse(birthDate, deathDate, gender, maritalStatus, birthPlace, residenceNumber, residenceExpiryDate, nationality,
                    nationalCode, nationalCodeExpiryDate, passportNumber, passportExpiryDate, allowanceAmount, allowanceStartingFrom,
                    allowanceToDate, student, educationLevel, school, educationSystemBeneficiary, insured, insuranceStartDate,
                    insuranceCode, insuranceCardExpiry, medicalClaimCoverage, medicalClaimStartDate, permanentDisability);

        }

        setLog("Add Children"
                +" - birth Date: "+birthDate
                +" - death Date: "+deathDate
                +" - gender: "+gender
                +" - marital Status: "+maritalStatus
                +" - birth Place: "+birthPlace
                +" - residence Number: "+residenceNumber
                +" - residence Expiry Date: "+residenceExpiryDate
                +" - nationality: "+nationality
                +" - national Code: "+nationalCode
                +" - national Code Expiry Date: "+nationalCodeExpiryDate
                +" - passport Number: "+passportNumber
                +" - passport Expiry Date: "+passportExpiryDate
                +" - allowance Amount: "+allowanceAmount
                +" - allowance Starting From: "+allowanceStartingFrom
                +" - allowance To Date: "+allowanceToDate
                +" - student: "+student
                +" - education Level: "+educationLevel
                +" - school: "+school
                +" - education System Beneficiary: "+educationSystemBeneficiary
                +" - insured: "+insured
                +" - insurance Start Date: "+insuranceStartDate
                +" - insurance Code: "+insuranceCode
                +" - insurance Card Expiry: "+insuranceCardExpiry
                +" - medical Claim Coverage: "+medicalClaimCoverage
                +" - medical Claim Start Date: "+medicalClaimStartDate
                +" - permanent Disability: "+permanentDisability);

    }

    public void checkAllowanceField(){

        if(!versionGetter().equalsIgnoreCase("OCT")){
            scrollToElement(checkPicture);
            clickOn(otherInformationList);
            hold(300);
            scrollToElement(alowanceAmountE);
        }else {
            clickOn(personalInformationOct.otherInformationList);
            hold(300);
        }

    }

    public void addChildrenWithFirstAndLast(String firstName, String lastName, String birthDate, String deathDate, String gender, String maritalStatus, String birthPlace, String residenceNumber,
                                           String residenceExpiryDate, String nationality, String nationalCode, String nationalCodeExpiryDate, String passportNumber, String passportExpiryDate,
                                           String allowanceAmount, String allowanceStartingFrom,String allowanceToDate, boolean student, String educationLevel, String school,
                                           boolean educationSystemBeneficiary, boolean insured, String insuranceStartDate, String insuranceCode, String insuranceCardExpiry, boolean medicalClaimCoverage,
                                           String medicalClaimStartDate, boolean permanentDisability){

        hold(500);
        elementWaitAdvanced(By.id("son_name_man1"));
        employeeCode = empCode.getDomAttribute("value");
        setText(firstNameChildren, firstName);
        setText(familyNameChildren, lastName);
        setText(firstArNameChildren, lastName);
        setText(familyArNameChildren, lastName);
        setText(birthDateE, birthDate);
        setText(deathDateE, deathDate);
        selectOption(genderE, gender);
        selectOption(maritalStatusChildren, maritalStatus);
        selectOption(birthPlaceChildren, birthPlace);
        setText(residenceNumberE, residenceNumber);
        setText(residenceExpiryDateE, residenceExpiryDate);
        selectOption(nationalityE, nationality);
        scrollToElement(checkPicture);
        setText(nationalCodeE, nationalCode);
        setText(nationalCodeExpireDateE, nationalCodeExpiryDate);
        setText(passportNumberE, passportNumber);
        setText(passportExpireDateE, passportExpiryDate);
        pictureE.sendKeys(uploadRandomImage());
        clickOn(otherInformationList);
        hold(300);
        scrollToElement(insuredCheckbox);
        if(!allowanceAmount.isEmpty()){
            alowanceAmountE.clear();
            hold(400);
            setText(alowanceAmountE, allowanceAmount);
        }
        alowanceStartingFrom.clear();
        hold(400);
        setText(alowanceStartingFrom, allowanceStartingFrom);
        setText(alowanceToDate, allowanceToDate);
        hold(400);
        if(student){
            clickOn(studentCheckbox);
            hold(400);
            selectOption(educationLevelE, educationLevel);
            selectOption(schoolE, school);
        }
        hold(400);
        if(!educationSystemBeneficiaryCheckbox.isDisplayed()){
            if(educationSystemBeneficiary){
                clickOn(educationSystemBeneficiaryCheckbox);
            }
        }
        hold(400);
        if(insured){
            clickOn(insuredCheckbox);
            hold(400);
            setText(insuranceStartDateE, insuranceStartDate);
            setText(insuranceCodeE, insuranceCode);
            setText(insuranceCardExpiryE, insuranceCardExpiry);
        }
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
        if(permanentDisability){
            clickOn(permanentDisabilityCheckbox);
        }
        hold(500);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(300);

        setLog("Add Children"
                +" - birth Date: "+birthDate
                +" - death Date: "+deathDate
                +" - gender: "+gender
                +" - marital Status: "+maritalStatus
                +" - birth Place: "+birthPlace
                +" - residence Number: "+residenceNumber
                +" - residence Expiry Date: "+residenceExpiryDate
                +" - nationality: "+nationality
                +" - national Code: "+nationalCode
                +" - national Code Expiry Date: "+nationalCodeExpiryDate
                +" - passport Number: "+passportNumber
                +" - passport Expiry Date: "+passportExpiryDate
                +" - allowance Amount: "+allowanceAmount
                +" - allowance Starting From: "+allowanceStartingFrom
                +" - allowance To Date: "+allowanceToDate
                +" - student: "+student
                +" - education Level: "+educationLevel
                +" - school: "+school
                +" - education System Beneficiary: "+educationSystemBeneficiary
                +" - insured: "+insured
                +" - insurance Start Date: "+insuranceStartDate
                +" - insurance Code: "+insuranceCode
                +" - insurance Card Expiry: "+insuranceCardExpiry
                +" - medical Claim Coverage: "+medicalClaimCoverage
                +" - medical Claim Start Date: "+medicalClaimStartDate
                +" - permanent Disability: "+permanentDisability);

    }

    public void addChildrenWithoutSave(String birthDate, String deathDate, String gender, String maritalStatus, String birthPlace, String residenceNumber, String residenceExpiryDate, String nationality,
                            String nationalCode, String nationalCodeExpiryDate, String passportNumber, String passportExpiryDate, String allowanceAmount, String allowanceStartingFrom,
                            String allowanceToDate, boolean student, String educationLevel, String school, boolean educationSystemBeneficiary, boolean insured, String insuranceStartDate,
                            String insuranceCode, String insuranceCardExpiry, boolean medicalClaimCoverage, String medicalClaimStartDate, boolean permanentDisability){

        hold(500);
        elementWaitAdvanced(By.id("son_name_man1"));
        employeeCode = empCode.getDomAttribute("value");
        setText(firstNameChildren, employeeCode+"FC");
        setText(secondNameChildren, employeeCode+"SC");
        setText(thirdNameChildren, employeeCode+"TC");
        setText(familyNameChildren, employeeCode+"LC");
        setText(firstArNameChildren, employeeCode+"FAC");
        setText(secondArNameChildren, employeeCode+"SAC");
        setText(thirdArNameChildren, employeeCode+"TAC");
        setText(familyArNameChildren, employeeCode+"LAC");
        setText(birthDateE, birthDate);
        setText(deathDateE, deathDate);
        selectOption(genderE, gender);
        selectOption(maritalStatusChildren, maritalStatus);
        selectOption(birthPlaceChildren, birthPlace);
        setText(residenceNumberE, residenceNumber);
        setText(residenceExpiryDateE, residenceExpiryDate);
        selectOption(nationalityE, nationality);
        scrollToElement(checkPicture);
        setText(nationalCodeE, nationalCode);
        setText(nationalCodeExpireDateE, nationalCodeExpiryDate);
        setText(passportNumberE, passportNumber);
        setText(passportExpireDateE, passportExpiryDate);
        pictureE.sendKeys(uploadRandomImage());
        clickOn(otherInformationList);
        hold(300);
        scrollToElement(insuredCheckbox);
        if(!allowanceAmount.isEmpty()){
            alowanceAmountE.clear();
            hold(400);
            setText(alowanceAmountE, allowanceAmount);
        }
        alowanceStartingFrom.clear();
        hold(400);
        setText(alowanceStartingFrom, allowanceStartingFrom);
        setText(alowanceToDate, allowanceToDate);
        hold(400);
        if(student){
            clickOn(studentCheckbox);
            hold(400);
            selectOption(educationLevelE, educationLevel);
            selectOption(schoolE, school);
        }
        hold(400);
        if(!educationSystemBeneficiaryCheckbox.isDisplayed()){
            if(educationSystemBeneficiary){
                clickOn(educationSystemBeneficiaryCheckbox);
            }
        }
        hold(400);
        if(insured){
            clickOn(insuredCheckbox);
            hold(400);
            setText(insuranceStartDateE, insuranceStartDate);
            setText(insuranceCodeE, insuranceCode);
            setText(insuranceCardExpiryE, insuranceCardExpiry);
        }
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
        if(permanentDisability){
            clickOn(permanentDisabilityCheckbox);
        }
        hold(500);
        scrollToElement(empCode);

        setLog("Add Children"
                +" - birth Date: "+birthDate
                +" - death Date: "+deathDate
                +" - gender: "+gender
                +" - marital Status: "+maritalStatus
                +" - birth Place: "+birthPlace
                +" - residence Number: "+residenceNumber
                +" - residence Expiry Date: "+residenceExpiryDate
                +" - nationality: "+nationality
                +" - national Code: "+nationalCode
                +" - national Code Expiry Date: "+nationalCodeExpiryDate
                +" - passport Number: "+passportNumber
                +" - passport Expiry Date: "+passportExpiryDate
                +" - allowance Amount: "+allowanceAmount
                +" - allowance Starting From: "+allowanceStartingFrom
                +" - allowance To Date: "+allowanceToDate
                +" - student: "+student
                +" - education Level: "+educationLevel
                +" - school: "+school
                +" - education System Beneficiary: "+educationSystemBeneficiary
                +" - insured: "+insured
                +" - insurance Start Date: "+insuranceStartDate
                +" - insurance Code: "+insuranceCode
                +" - insurance Card Expiry: "+insuranceCardExpiry
                +" - medical Claim Coverage: "+medicalClaimCoverage
                +" - medical Claim Start Date: "+medicalClaimStartDate
                +" - permanent Disability: "+permanentDisability);

    }

    public void addChildrenWithEmployeeAndSpouse(String birthDate, String deathDate, String gender, String maritalStatus, String birthPlace, String residenceNumber, String residenceExpiryDate, String nationality,
                                                 String nationalCode, String nationalCodeExpiryDate, String passportNumber, String passportExpiryDate, String allowanceAmount, String allowanceStartingFrom,
                                                 String allowanceToDate, boolean student, String educationLevel, String school, boolean educationSystemBeneficiary, boolean insured, String insuranceStartDate,
                                                 String insuranceCode, String insuranceCardExpiry, boolean medicalClaimCoverage, String medicalClaimStartDate, boolean permanentDisability){

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

        String spouseName = String.valueOf(randomNumber());

        spouse = new Spouse();
        spouse.justAddSpouse(spouseName+" F Spouse","", "", spouseName+" L Spouse", spouseName+" A Spouse",
                "", "", spouseName+" AL Spouse","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "10.000", "", "", "", true);

        clickOn(childrenPage);
        hold(300);
        selectOption(spouseList, spouseName);
        hold(300);

        addChildren(birthDate, deathDate, gender, maritalStatus, birthPlace, residenceNumber, residenceExpiryDate, nationality,
                nationalCode, nationalCodeExpiryDate, passportNumber, passportExpiryDate, allowanceAmount, allowanceStartingFrom,
                allowanceToDate, student, educationLevel, school, educationSystemBeneficiary, insured, insuranceStartDate, insuranceCode,
                insuranceCardExpiry, medicalClaimCoverage, medicalClaimStartDate, permanentDisability);

        softAssert.assertTrue(item.isDisplayed(), "-Issue, Children Button Not Appear!");
        clickOn(item);
        hold(300);

        softAssert.assertEquals(firstNameChildren.getDomAttribute("value"), firstNC);
        softAssert.assertEquals(secondNameChildren.getDomAttribute("value"), secondNC);
        softAssert.assertEquals(thirdNameChildren.getDomAttribute("value"), thirdNC);
        softAssert.assertEquals(familyNameChildren.getDomAttribute("value"), lastNC);
        softAssert.assertEquals(firstArNameChildren.getDomAttribute("value"), firstNC);
        softAssert.assertEquals(secondArNameChildren.getDomAttribute("value"), secondNC);
        softAssert.assertEquals(thirdArNameChildren.getDomAttribute("value"), thirdNC);
        softAssert.assertEquals(familyArNameChildren.getDomAttribute("value"), lastNC);
        softAssert.assertEquals(birthDateE.getDomAttribute("value"), birthDate);
        softAssert.assertEquals(deathDateE.getDomAttribute("value"), deathDate);
        softAssert.assertEquals(genderE.getText(), gender);
        softAssert.assertEquals(maritalStatusChildren.getText(), maritalStatus);
        softAssert.assertEquals(birthPlaceChildren.getText(), birthPlace);
        if(!nationality.equals("Jordanian")){ //// Because the 'Jordanian' is Citizen ////
            softAssert.assertEquals(residenceNumberE.getDomAttribute("value"), residenceNumber);
            softAssert.assertEquals(residenceExpiryDateE.getDomAttribute("value"), residenceExpiryDate);
        }
        softAssert.assertEquals(nationalityE.getText(), nationality);
        scrollToElement(checkPicture);
        softAssert.assertEquals(nationalCodeE.getDomAttribute("value"), nationalCode);
        softAssert.assertEquals(nationalCodeExpireDateE.getDomAttribute("value"), nationalCodeExpiryDate);
        softAssert.assertEquals(passportNumberE.getDomAttribute("value"), passportNumber);
        softAssert.assertEquals(passportExpireDateE.getDomAttribute("value"), passportExpiryDate);

        hold(500);
        clickOn(otherInformationList);
        hold(300);
        scrollToElement(permanentDisabilityCheckbox);
        hold(200);

        softAssert.assertEquals(alowanceAmountE.getDomAttribute("value"), allowanceAmount);
        softAssert.assertEquals(alowanceStartingFrom.getDomAttribute("value"), allowanceStartingFrom);
        softAssert.assertEquals(alowanceToDate.getDomAttribute("value"), allowanceToDate);
        softAssert.assertEquals(studentCheckbox.isSelected(), student);
        if(!liteGetter()){
            if(student){
                softAssert.assertEquals(educationLevelE.getText().trim(), educationLevel);
                softAssert.assertEquals(schoolE.getText().trim(), school);
            }
            softAssert.assertEquals(educationSystemBeneficiaryCheckbox.isSelected(), educationSystemBeneficiary);
        }
        softAssert.assertEquals(insuredCheckbox.isSelected(), insured);
        if(insured){
            softAssert.assertEquals(insuranceStartDateE.getDomAttribute("value"), insuranceStartDate);
            softAssert.assertEquals(insuranceCodeE.getDomAttribute("value"), insuranceCode);
            softAssert.assertEquals(insuranceCardExpiryE.getDomAttribute("value"), insuranceCardExpiry);
        }
        if(!liteGetter()){
            softAssert.assertEquals(medicalClaimCoverageCheckbox.isSelected(), medicalClaimCoverage);
            if(medicalClaimCoverage){
                softAssert.assertEquals(medicalClaimStartDateE.getDomAttribute("value"), medicalClaimStartDate);
            }
        }
        softAssert.assertEquals(permanentDisabilityCheckbox.isSelected(), permanentDisability);
        if(checkPicture.getDomAttribute("src").contains("Image/import.svg")){
            softAssert.fail("The Photo Not Uploaded");
        }else{
            softAssert.assertEquals(VerifyImage(checkPicture), 200,"This image is broken : "+checkPicture.getDomAttribute("src"));
        }
        softAssert.assertAll();

    }

    public void editChildren(boolean student, boolean insured, boolean permanentDisability){

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

        String spouseName = String.valueOf(randomNumber());

        spouse = new Spouse();
        spouse.justAddSpouse(spouseName+" F Spouse","", "", spouseName+" L Spouse", spouseName+" A Spouse",
                "", "", spouseName+" AL Spouse","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "10.000", "", "", "", true);

        clickOn(childrenPage);
        hold(300);
        selectOption(spouseList, spouseName);
        hold(300);

        addChildren("01/05/2021", "", "Male", "Single", "Birth Place 1", ""+ randomNumber2(), "01/01/2028", "Jordanian",
                "32"+randomNumber2(), "07/07/2026", "16"+randomNumber2(), "03/03/2025", "10.000", "01/06/2021",
                "01/06/2035", true, "School Student", "Schools 1", false, true, "10/05/2021", "22"+randomNumber2(),
                "09/05/2029", true, "11/05/2021", true);

        softAssert.assertTrue(item.isDisplayed(), "-Issue, Children Button Not Appear!");
        clickOn(item);
        hold(300);

        elementWaitAdvanced(By.xpath("//li[@class='nav-item']//button[1]"));
        clickOn(employmentInformationPage);
        hold(300);
        elementWaitAdvanced(By.id("select2-site_1-container"));
        clickOn(childrenPage);
        hold(500);
        elementWaitAdvanced(By.id("son_name_man1"));
        clickOn(item);
        hold(300);

        firstNameChildren.clear();
        hold(200);
        setText(firstNameChildren, employeeCode+"Edited");
        familyNameChildren.clear();
        hold(200);
        setText(familyNameChildren, employeeCode+"Edited");
        birthDateE.clear();
        hold(200);
        setText(birthDateE, "10/10/2021");
        selectOption(nationalityE, "Egyptian");
        scrollToElement(checkPicture);
        String nationalCodeEdit = randomNumber()+"11";
        nationalCodeE.clear();
        hold(200);
        setText(nationalCodeE, nationalCodeEdit);
        nationalCodeExpireDateE.clear();
        hold(200);
        setText(nationalCodeExpireDateE, "06/06/2026");
        String passportNumberEdit = randomNumber()+"44";
        passportNumberE.clear();
        hold(200);
        setText(passportNumberE, passportNumberEdit);
        passportExpireDateE.clear();
        hold(200);
        setText(passportExpireDateE, "10/05/2025");
        clickOn(otherInformationList);
        hold(300);
        scrollToElement(insuredCheckbox);
        alowanceAmountE.clear();
        hold(400);
        setText(alowanceAmountE, "13.000");
        alowanceStartingFrom.clear();
        hold(400);
        setText(alowanceStartingFrom, "01/01/2022");
        hold(400);
        if(student){
            if(studentCheckbox.isSelected()){
                selectOption(educationLevelE, "College Student");
                selectOption(schoolE, "Schools 2");
            }
        }else {
            clickOn(studentCheckbox);
        }
        hold(400);
        String insuranceCodeEdit = "555"+randomNumber();
        if(insured){
            if(insuredCheckbox.isSelected()){
                insuranceStartDateE.clear();
                hold(200);
                setText(insuranceStartDateE, "02/02/2022");
                insuranceCodeE.clear();
                hold(200);
                setText(insuranceCodeE, insuranceCodeEdit);
            }
        }else{
            if(insuredCheckbox.isSelected()){
                insuredCheckbox.click();
            }
        }
        hold(400);
        if(permanentDisability){
            if(!permanentDisabilityCheckbox.isSelected()){
                clickOn(permanentDisabilityCheckbox);
            }
        }else{
            if(permanentDisabilityCheckbox.isSelected()){
                clickOn(permanentDisabilityCheckbox);
            }
        }
        hold(500);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertEquals(firstNameChildren.getDomAttribute("value"), employeeCode+"Edited");
        softAssert.assertEquals(familyNameChildren.getDomAttribute("value"), employeeCode+"Edited");
        softAssert.assertEquals(birthDateE.getDomAttribute("value"), "10/10/2021");
        softAssert.assertEquals(nationalityE.getText(), "Egyptian");
        softAssert.assertEquals(nationalCodeE.getDomAttribute("value"), nationalCodeEdit);
        softAssert.assertEquals(nationalCodeExpireDateE.getDomAttribute("value"), "06/06/2026");
        softAssert.assertEquals(passportNumberE.getDomAttribute("value"), passportNumberEdit);
        softAssert.assertEquals(passportExpireDateE.getDomAttribute("value"), "10/05/2025");
        softAssert.assertEquals(alowanceAmountE.getDomAttribute("value"), "13.000");
        softAssert.assertEquals(alowanceStartingFrom.getDomAttribute("value"), "01/01/2022");
        softAssert.assertEquals(studentCheckbox.isSelected(), student);
        softAssert.assertEquals(insuredCheckbox.isSelected(), insured);
        softAssert.assertEquals(permanentDisabilityCheckbox.isSelected(), permanentDisability);
        if(student){
            softAssert.assertEquals(educationLevelE.getText(), "College Student");
            softAssert.assertEquals(schoolE.getText(), "Schools 2");
        }
        if(insured){
            softAssert.assertEquals(insuranceStartDateE.getDomAttribute("value"), "02/02/2022");
            softAssert.assertEquals(insuranceCodeE.getDomAttribute("value"), insuranceCodeEdit);
        }
        softAssert.assertAll();

    }

    public void deleteChildren(){

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

        String spouseName = String.valueOf(randomNumber());

        spouse = new Spouse();
        spouse.justAddSpouse(spouseName+" F Spouse","", "", spouseName+" L Spouse", spouseName+" A Spouse",
                "", "", spouseName+" AL Spouse","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", true, "01/03/2020", "10.000", "", "", "", true);

        clickOn(childrenPage);
        hold(300);
        selectOption(spouseList, spouseName);
        hold(300);

        addChildren("01/05/2021", "", "Male", "", "", "", "", "",
                "", "", "", "", "", "",
                "", false, "", "", false, false, "", "",
                "", false, "", false);

        elementWaitAdvanced(By.xpath("//li[@class='nav-item']//button[1]"));
        clickOn(deleteChildrenBtn);
        hold(500);
        clickOn(alertButtonOkDeleteChildren);
        hold(500);
        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));
        selectOption(spouseList, spouseName);
        hold(300);
        Assert.assertTrue(checkElementIfNotAppear(checkItem));

    }

    public void deathDateBeforeBirthDate(){

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));

        addChildrenWithoutSave("01/05/2021", "01/03/2021", "", "", "", "", "", "",
                "", "", "", "", "", "", "", false,
                "", "", false, false, "", "", "", true,
                "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Death Date Can Not Be Before The Birth Date!");
        softAssert.assertTrue(deathDateE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void birthDateBeforeMarriageDate(){

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));

        addChildrenWithoutSave("01/01/2000", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", false,
                "", "", false, false, "", "", "", true,
                "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Child Birth Date Can Not Be Before The Marriage Date!");
        softAssert.assertTrue(birthDateE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void birthDateAfterSpouseDeathDate(){

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

        String spouseName = String.valueOf(randomNumber());

        spouse = new Spouse();
        spouse.justAddSpouse(spouseName+" F Spouse","", "", spouseName+" L Spouse", spouseName+" A Spouse",
                "", "", spouseName+" AL Spouse","01/01/1992", "01/01/2005", "01/01/2013", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", true, "01/03/2020", "10.000", "", "", "", true);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));

        addChildrenWithoutSave("01/01/2018", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", false,
                "", "", false, false, "", "", "", true,
                "", false);

        clickOn(saveBtn);
        hold(300);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Child Birth Date Can Not Be After The Spouse Death Date!");
        softAssert.assertTrue(deathDateE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");

        ///// Back To Spouse te remove spouse death date ///// just optional /////
        clickOn(spousePageTab);
        hold(300);
        elementWaitAdvanced(By.id("wife_name_man1"));
        clickOn(item);
        hold(300);
        deathDateE.clear();
        hold(300);
        clickOn(saveBtn);

        softAssert.assertAll();

    }

    public void allowancesStartDateBeforeBirthDate(){

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));

        addChildrenWithoutSave("01/03/2022", "", "", "", "", "", "", "",
                "", "", "", "", "", "01/01/2022", "", false,
                "", "", false, false, "", "", "", true,
                "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Allowance Start Date Can Not Be Before The Birth Date!");
        softAssert.assertTrue(alowanceStartingFrom.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void allowanceStartDateAfterEndDate(){

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));

        addChildrenWithoutSave("01/03/2022", "", "", "", "", "", "", "",
                "", "", "", "", "", "01/03/2022", "01/01/2022", false,
                "", "", false, false, "", "", "", true,
                "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The End Date Can Not Be Before The Start Date! Please Re-enter The End Date");
        softAssert.assertTrue(alowanceToDate.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void insuranceDateBeforeBirthDate(){

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));

        addChildrenWithoutSave("01/03/2022", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", false,
                "", "", false, true, "01/01/2022", "", "", true,
                "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Insurance Date Can Not Be Before The Birth Date!");
        softAssert.assertTrue(insuranceStartDateE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void insuranceStartDateAfterInsuranceCardEndDate(){

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));

        addChildrenWithoutSave("01/01/2022", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", false,
                "", "", false, true, "01/05/2022", "", "01/03/2022", true,
                "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "Insurance Start Date Can Not Be After The Insurance Card End Date!");
        softAssert.assertTrue(insuranceCardExpiryE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void medicalClaimStartDateBeforeHiringDate(){

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));

        addChildrenWithoutSave("01/01/2022", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", false,
                "", "", false, false, "", "", "", true,
                "10/01/2000", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "Medical Claim Start Date Can Not Be Before Hiring Date!");
        softAssert.assertTrue(medicalClaimStartDateE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void validateDefaultAllowanceAmount(String childrenAllowanceAmount){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        systemParameters = new SystemParameters();
        systemParameters.childrenAllowanceAmount(childrenAllowanceAmount);
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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));
        scrollToElement(checkPicture);
        hold(200);
        clickOn(otherInformationList);
        hold(200);
        scrollToElement(insuredCheckbox);
        Assert.assertEquals(alowanceAmountE.getDomAttribute("value"), childrenAllowanceAmount, "Allowance Amount NOT Same System Parameters!");

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));

        addChildrenWithoutSave("01/01/2022", "", "", "", "", "", "", "",
                "", "", "", "", "10Aa", "", "", false,
                "", "", false, false, "", "", "", true,
                "", false);

        clickOn(saveBtn);
        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Should Only Contain Decimal Values.");
        softAssert.assertTrue(alowanceAmountE.getDomAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));

        addChildrenAfterSpouse("01/05/2022", "", "Male", "Single", "Birth Place 1", "", "", "Jordanian",
                random(6), "", random(6), "", "", "",
                "", false, "", "", false, false, "", "",
                "", true, "11/05/2021", false);

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

    public void ChangePhoto(){

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));

        addChildrenAfterSpouse("01/05/2022", "", "Male", "Single", "Birth Place 1", "", "", "Jordanian",
                random(6), "", random(6), "", "", "",
                "", false, "", "", false, false, "", "",
                "", true, "11/05/2021", false);
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
        Assert.assertEquals(VerifyImage(checkPicture), 200,"This image is broken : "+checkPicture.getDomAttribute("src"));

    }

    public void addMoreThanOneChildren(int childrenCount){

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

        String spouseName = String.valueOf(randomNumber());

        spouse = new Spouse();
        spouse.justAddSpouse(firstName(),"", "", lastName(), firstName(),
                "", "", lastName(),"01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", true, "01/03/2020", "10.000", "", "", "", true);

        clickOn(childrenPage);
        hold(300);
        selectOption(spouseList, spouseName);
        hold(300);

        String randNum = String.valueOf(randomNumber2());
        String allowanceAmount = "13.710";
        double allowancesCounter = 0.000;
        DecimalFormat dec = new DecimalFormat("#.000"); //// To print decimal Zeros like 30.000

        for (int i = 1; i <= childrenCount; i++){

            addChildrenWithFirstAndLast(firstName(), lastName(), "01/01/2022", "", "Male", "Single",
                    "", "", "", "Jordanian", randNum+i, "", randNum+i, "", allowanceAmount,
                    "", "", false, "", "", false, true, "", randNum+i,
                    "", true, "", false);

            allowancesCounter = allowancesCounter+Double.parseDouble(allowanceAmount);

            hold(300);
            clickOn(addBtn);
            hold(500);

        }

        softAssert.assertEquals(items.size(), childrenCount, "Issue in the number of Children!");
        scrollToElement(checkPicture);
        clickOn(otherInformationList);
        hold(500);
        scrollToElement(insuredCheckbox);
        softAssert.assertEquals(totalAllowances.getText().trim(), dec.format(allowancesCounter),"- Issue in Total Allowances Amount");
        softAssert.assertAll();

    }

    public void validateHijriConverterForChildrenBirthDate(String hijriDate){

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        elementWaitAdvanced(By.id("son_name_man1"));
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

        int day = Integer.parseInt(hijriDate.substring(0,2));
        int month = Integer.parseInt(hijriDate.substring(3,5));
        int year = Integer.parseInt(hijriDate.substring(6,10));

        HijrahDate hd = HijrahChronology.INSTANCE.date(HijrahEra.AH, year, month, day);
        LocalDate ld = LocalDate.from(hd);
        ld = ld.minusDays(1); //// To minus 1 Day, This is how the MenaITech system works
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String afterConvert = ld.format(formatters);
        //System.out.println(afterConvert);
        Assert.assertEquals(birthDateE.getDomAttribute("value"), afterConvert, "- Incorrect Date after convert!");

    }

    public void validateAllowancesAmountByTypeChildSort(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        systemParameters = new SystemParameters();
        systemParameters.childrenAllowanceType("ChildSort");
        hold(300);
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Married", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        String spouseName = String.valueOf(randomNumber());

        spouse = new Spouse();
        spouse.justAddSpouse(firstName(),"", "", lastName(), firstName(),
                "", "", lastName(),"01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", true, "01/03/2020", "10.000", "", "", "", true);

        clickOn(childrenPage);
        hold(300);
        selectOption(spouseList, spouseName);
        hold(300);

        String randNum = String.valueOf(randomNumber2());

        for (int i = 1; i <= 4; i++){

            if(i == 1){
                softAssert.assertEquals(alowanceAmountE.getDomAttribute("value"), "20.000", "- Allowance Amount For First Children Should be: 20.000");
            }else if(i == 2){
                softAssert.assertEquals(alowanceAmountE.getDomAttribute("value"), "15.000", "- Allowance Amount For Second Children Should be: 15.000");
            }else if(i == 3){
                softAssert.assertEquals(alowanceAmountE.getDomAttribute("value"), "10.000", "- Allowance Amount For Third Children Should be: 10.000");
            }else{
                softAssert.assertEquals(alowanceAmountE.getDomAttribute("value"), "0.000", "- Allowance Amount For any Children after third Children Should be: 0.000");
            }

            addChildrenWithFirstAndLast(firstName(), lastName(), "01/01/2022", "", "Male", "Single",
                    "", "", "", "Jordanian", randNum+i, "", randNum+i, "", "",
                    "", "", false, "", "", false, true, "", randNum+i,
                    "", true, "", false);

            hold(300);
            clickOn(addBtn);
            hold(500);

        }

        softAssert.assertAll();

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
        personnelInformation.personalInformation("Married", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getDomAttribute("value");


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        addChildrenWithoutSave("01/05/2021", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", false,
                "", "", false, false, "", "", "", false,
                "", false);

        if(flag.equals("0")){
            softAssert.assertEquals(medicalClaimCoverageCheckbox.getDomAttribute("disabled"), "true", "- Medical Claim Coverage Should be NOT Active");
        }else{
            softAssert.assertEquals(medicalClaimCoverageCheckbox.getDomAttribute("disabled"), null, "- Medical Claim Coverage Should be Active");
        }
        MssqlConnect.sqlQuery("update adm_company set is_claim = 1 where company_code = 'automation'");
        softAssert.assertAll();

    }

    public void flag_is_schoolAid(String flag){

        MssqlConnect.sqlQuery("update adm_company set is_schoolAid = "+flag+" where company_code = 'automation'");

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        scrollToElement(checkPicture);
        clickOn(otherInformationList);
        hold(300);
        scrollToElement(medicalClaimStartDateE);

        if(flag.equals("1")){
            softAssert.assertTrue(sa_sector.get(0).isDisplayed());
            softAssert.assertTrue(sa_level.get(0).isDisplayed());
        }else{
            softAssert.assertTrue(checkElementIfNotAppear(sa_sector));
            softAssert.assertTrue(checkElementIfNotAppear(sa_level));
        }
        MssqlConnect.sqlQuery("update adm_company set is_schoolAid = 0 where company_code = 'automation'");
        softAssert.assertAll();

    }

    public void changeClientId(String flag){

        MssqlConnect.sqlQuery("update adm_company set Client_id = '"+flag+"' where company_code = 'automation'");

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


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
        hold(300);
        scrollToElement(checkPicture);
        clickOn(otherInformationList);
        hold(300);
        scrollToElement(medicalClaimStartDateE);

        if(flag.equals("USJ")){
            softAssert.assertFalse(underCNSS.isEmpty(), "- Under CNSS still appear in client id USJ");
        }else{
            softAssert.assertTrue(checkElementIfNotAppear(underCNSS), "- When NO client id should be the CNSS NOT appear");
        }
        MssqlConnect.sqlQuery("update adm_company set Client_id = NULL where company_code = 'automation'");
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
        personnelInformation.personalInformation("Married", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getDomAttribute("value");


        spouse = new Spouse();
        spouse.justAddSpouse("F Spouse","", "", "L Spouse", "",
                "", "", "","01/01/1992", "01/01/2005", "", "", "",
                "Jordanian", "", "", "", "", "", "", false, "", "",
                "", false,"", false, "", "", "", "", "", false);

        clickOn(childrenPage);
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

    public String alowanceAmountE(String attribute){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = alowanceAmountE.getDomAttribute(attribute);
        }else {
            personalInformationOct = new PersonalInformation_OCT();
            str = personalInformationOct.alowanceAmountE.getDomAttribute(attribute);
        }
        return str;
    }

}
