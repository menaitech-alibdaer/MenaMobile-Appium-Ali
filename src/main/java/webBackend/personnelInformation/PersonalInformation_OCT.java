package webBackend.personnelInformation;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utilities.WebHelper.*;
import static utilities.WebHelper.hold;
import static utilities.VersionGetter.liteGetter;

public class PersonalInformation_OCT extends WebBase {

    @FindBy(id = "first_name_e")
    WebElement fNameEng;
    @FindBy(id = "second_name_e")
    WebElement sNameEng;
    @FindBy(id = "third_name_e")
    WebElement tNameEng;
    @FindBy(id = "family_name_e")
    WebElement familyNameEng;
    @FindBy(id = "first_name_a")
    WebElement fNameAr;
    @FindBy(id = "second_name_a")
    WebElement sNameAr;
    @FindBy(id = "third_name_a")
    WebElement tNameAr;
    @FindBy(id = "family_name_a")
    WebElement familyNameAr;
    @FindBy(name = "social_status")
    WebElement marital_StatusE;
    @FindBy(name = "sex")
    WebElement sexE;
    @FindBy(name = "nationality")
    WebElement nationalityE;
    @FindBy(id = "relegion_1")
    WebElement relegionE;
    @FindBy(name = "relegion")
    WebElement relegionDepE;
    @FindBy(id = "mobile")
    WebElement mobileE;
    @FindBy(id = "Email")
    WebElement emailE;
    @FindBy(id = "manager_code")
    WebElement manager_code;
    @FindBy(id = "birth_date")
    WebElement birth_date;
    @FindBy(id = "site_1")
    WebElement siteE;
    @FindBy(id = "department_1")
    WebElement departmentE;
    @FindBy(id = "section_1")
    WebElement sectionE;
    @FindBy(id = "division_1")
    WebElement divisionE;
    @FindBy(id = "units_1")
    WebElement unitsE;
    @FindBy(id = "sub_section_1")
    WebElement sub_sectionE;
    @FindBy(id = "sub_division_1")
    WebElement sub_divisionE;
    @FindBy(id = "sub_unit_1")
    WebElement sub_unitE;
    @FindBy(id = "office_1")
    WebElement officeE;
    @FindBy(id = "team_1")
    WebElement teamE;
    @FindBy(id = "FDimension_1")
    WebElement category1E;
    @FindBy(id = "SDimension_1")
    WebElement category2E;
    @FindBy(id = "TDimension_1")
    WebElement category3E;
    @FindBy(id = "contract_type_1")
    WebElement contract_typeE;
    @FindBy(id = "classification_1")
    WebElement classificationE;
    @FindBy(id = "degree_1")
    WebElement degreeE;
    @FindBy(id = "year_count")
    WebElement stepE;
    @FindBy(id = "position_1")
    WebElement positionE;
    @FindBy(id = "hiring_date")
    WebElement hiring_dateE;
    @FindBy(id = "moving_date")
    WebElement moving_dateE;
    @FindBy(id = "work_type")
    WebElement work_typeE;
    @FindBy(id = "Project_1")
    WebElement projectE;
    @FindBy(id = "emp_currency")
    WebElement currencyE;
    @FindBy(id = "contract_start_date")
    WebElement contract_start_dateE;
    @FindBy(id = "contract_end_date")
    WebElement contract_end_dateE;
    @FindBy(id = "employee_picture")
    WebElement employeePicture;
    @FindBy(xpath = "(//label[@class='empNameAndStatus'])[1]")
    public WebElement FirstAndLastName;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;


    ///////// Spouse /////////


    @FindBy(xpath = "//a[contains(@href, 'Wives.php')]")
    WebElement spousePage;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(name = "wife_name_man1")
    WebElement firstNameSpouse;
    @FindBy(name = "wife_name_man2")
    WebElement secondNameSpouse;
    @FindBy(name = "wife_name_man3")
    WebElement thirdNameSpouse;
    @FindBy(name = "wife_name_man4")
    WebElement familyNameSpouse;
    @FindBy(name = "wife_name_other1")
    WebElement firstNameArSpouse;
    @FindBy(name = "wife_name_other2")
    WebElement secondNameArSpouse;
    @FindBy(name = "wife_name_other3")
    WebElement thirdNameArSpouse;
    @FindBy(name = "wife_name_other4")
    WebElement familyNameArSpouse;
    @FindBy(id = "birth_date")
    WebElement birthDateSpouseE;
    @FindBy(id = "marry_date")
    WebElement marryDateSpouseE;
    @FindBy(name = "birth_place")
    WebElement birthPlaceSpouseE;
    @FindBy(name = "nationality")
    WebElement nationalitySpouseE;
    @FindBy(id = "national_code")
    WebElement nationalCodeSpouseE;
    @FindBy(id = "insured")
    WebElement insuredSpouseE;
    @FindBy(id = "insurance_date")
    WebElement insuranceDateSpouseE;
    @FindBy(id = "insurance_number")
    WebElement insuranceCodeSpouseE;
    @FindBy(id = "wife_end_ins_date")
    WebElement insuranceCardExpirySpouseE;
    @FindBy(id = "worker")
    WebElement workerSpouseE;
    @FindBy(name = "work")
    WebElement workerText;
    @FindBy(name = "is_MC_covered")
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
    @FindBy(id = "All_popup")
    WebElement iframePopup;
    @FindBy(id = "body_frame")
    WebElement frame;


    ////////// Children //////////


    @FindBy(name = "son_name_man1")
    WebElement firstNameChildren;
    @FindBy(name = "son_name_man2")
    WebElement secondNameChildren;
    @FindBy(name = "son_name_man3")
    WebElement thirdNameChildren;
    @FindBy(name = "son_name_man4")
    WebElement familyNameChildren;
    @FindBy(name = "son_name_other1")
    WebElement firstArNameChildren;
    @FindBy(name = "son_name_other2")
    WebElement secondArNameChildren;
    @FindBy(name = "son_name_other3")
    WebElement thirdArNameChildren;
    @FindBy(name = "son_name_other4")
    WebElement familyArNameChildren;
    @FindBy(id = "birth_date")
    WebElement birthDateE;
    @FindBy(id = "sex")
    WebElement genderE;
    @FindBy(id = "marital_status_flag")
    WebElement maritalStatusChildren;
    @FindBy(id = "birth_place")
    WebElement birthPlaceChildren;
    @FindBy(id = "nationality")
    WebElement nationalityChildE;
    @FindBy(id = "national_code")
    WebElement nationalCodeE;
    @FindBy(name = "national_code")
    WebElement nationalCodeDepE;
    @FindBy(name = "home_phone")
    WebElement homePhoneE;
    @FindBy(name = "street")
    WebElement streetE;
    @FindBy(name = "zip_code")
    WebElement zipCodeE;
    @FindBy(name = "city")
    WebElement cityE;
    @FindBy(name = "city_code")
    WebElement cityEduE;
    @FindBy(name = "comments")
    WebElement commentsE;
    @FindBy(name = "nationality")
    WebElement nationalityDep;
    @FindBy(name = "ssn")
    WebElement ssn;
    @FindBy(id = "national_expire_date")
    WebElement nationalCodeExpireDateE;
    @FindBy(id = "child_picture")
    WebElement pictureE;
    @FindBy(xpath = "//div[@tap_name = 'other_info_page']")
    WebElement otherInformationList;
    @FindBy(name = "alowance_amount")
    public WebElement alowanceAmountE;
    @FindBy(id = "start_date")
    WebElement alowanceStartingFrom;
    @FindBy(id = "end_date")
    WebElement alowanceToDate;
    @FindBy(name = "student")
    WebElement studentCheckbox;
    @FindBy(name = "education_level")
    WebElement educationLevelE;
    @FindBy(name = "school")
    WebElement schoolE;
    @FindBy(id = "other_school")
    WebElement otherSchoolE;
    @FindBy(name = "faculty")
    WebElement facultyE;
    @FindBy(id = "other_fac")
    WebElement otherFacultyE;
    @FindBy(name = "degree")
    WebElement qualificationE;
    @FindBy(id = "other_degree")
    WebElement otherQualificationE;
    @FindBy(name = "major")
    WebElement majorE;
    @FindBy(id = "other_major")
    WebElement otherMajorE;
    @FindBy(name = "university_average")
    WebElement universityAverageE;
    @FindBy(name = "grade_text")
    WebElement gradeE;
    @FindBy(name = "Year")
    WebElement graduationYearEduE;
    @FindBy(name = "notes")
    WebElement educationNotesE;
    @FindBy(id = "certificate_path")
    WebElement attachmentFile;
    @FindBy(xpath = "//input[@name='Education_Minor'][@value='1']")
    WebElement educationMinorYes;
    @FindBy(xpath = "//input[@name='Education_Minor'][@value='2']")
    WebElement educationMinorNo;
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
    @FindBy(id = "dep_end_ins_date")
    WebElement insuranceCardExpiryDepE;
    @FindBy(name = "is_MC_covered")
    WebElement medicalClaimCoverageCheckbox;
    @FindBy(name = "sa_sector")
    List<WebElement> sa_sector;
    @FindBy(name = "sa_level")
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
    @FindBy(xpath = "//a[contains(@href, 'Sons.php')]")
    WebElement childrenPage;
    @FindBy(xpath = "//a[contains(@href, 'Wives.php')]")
    WebElement spousePageTab;
    @FindBy(xpath = "//a[contains(@href, 'emp_extra_dates.php')]")
    WebElement otherInformationTab;
    @FindBy(xpath = "//a[contains(@href, 'Addresses.php')]")
    WebElement addressTab;
    @FindBy(id = "card_id")
    WebElement cardIdE;
    @FindBy(id = "shift_or_roster_1")
    WebElement rosterE;
    @FindBy(id = "shift_or_roster_2")
    WebElement regularShiftE;
    @FindBy(id = "shift_code_type")
    WebElement shiftTypeE;
    @FindBy(id = "shift_code")
    WebElement shiftCode;
    @FindBy(xpath = "//a[contains(@href, 'Dependencies.php')]")
    WebElement dependentsPage;
    @FindBy(name = "dep_name_man1")
    WebElement firstNameDependents;
    @FindBy(name = "dep_name_man2")
    WebElement secondNameDependents;
    @FindBy(name = "dep_name_man3")
    WebElement thirdNameDependents;
    @FindBy(name = "dep_name_man4")
    WebElement familyNameDependents;
    @FindBy(name = "dep_name_other1")
    WebElement firstArNameDependents;
    @FindBy(name = "dep_name_other2")
    WebElement secondArNameDependents;
    @FindBy(name = "dep_name_other3")
    WebElement thirdArNameDependents;
    @FindBy(name = "dep_name_other4")
    WebElement familyArNameDependents;
    @FindBy(name = "relationship")
    WebElement relationship;
    @FindBy(name = "Gender")
    WebElement genderDepE;
    @FindBy(id = "document_type")
    WebElement documentTypeE;
    @FindBy(id = "documrnt_code")
    WebElement documentCodeE;
    @FindBy(id = "document_issue_date")
    WebElement documentIssueE;
    @FindBy(id = "document_expiry_date")
    WebElement documentExpiryE;
    @FindBy(id = "release_place")
    WebElement placeOfIssueE;
    @FindBy(id = "search_word")
    WebElement keyWordE;
    @FindBy(id = "universal_code")
    WebElement universalCodeE;
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
    @FindBy(id = "birth_place")
    WebElement birthPlaceE;
    @FindBy(id = "marry_date")
    WebElement marriageDateE;
    @FindBy(id = "personal_number")
    WebElement personalNumberE;
    @FindBy(id = "start_date")
    WebElement startDateE;
    @FindBy(id = "end_date")
    WebElement endDateE;
    @FindBy(id = "Until_Now")
    WebElement untilNowE;
    @FindBy(name = "country_code")
    WebElement countryE;
    @FindBy(name = "city")
    WebElement cityReferences;
    @FindBy(xpath = "//a[contains(@href, 'Education.php')]")
    WebElement educationTab;
    @FindBy(name = "province")
    WebElement provinceE;
    @FindBy(name = "district")
    WebElement districtE;
    @FindBy(name = "area_no")
    WebElement landNumberE;
    @FindBy(name = "slip_no")
    WebElement partNumberE;
    @FindBy(name = "small_city")
    WebElement neighborhoodE;
    @FindBy(name = "building_type")
    WebElement buildingTypeE;
    @FindBy(name = "building_name")
    WebElement buildingNameE;
    @FindBy(name = "gate")
    WebElement entranceE;
    @FindBy(name = "floor")
    WebElement floorE;
    @FindBy(name = "apartment")
    WebElement apartmentE;
    @FindBy(name = "town")
    WebElement townE;
    @FindBy(name = "real_estate_area")
    WebElement realEstateAreaE;
    @FindBy(name = "real_estate_number")
    WebElement realEstateNumberE;
    @FindBy(name = "telephone1")
    WebElement telephone1E;
    @FindBy(name = "telephone2")
    WebElement telephone2E;
    @FindBy(name = "poBox")
    WebElement poBoxE;
    @FindBy(name = "fax")
    WebElement faxE;
    @FindBy(name = "distance_to_company")
    WebElement distanceToCompanyE;
    @FindBy(id = "Support_documents")
    WebElement attachmentDocumentFile;
    @FindBy(name = "detail_address")
    WebElement addressE;


    public String maritalStatus;
    public String empName;
    public String empFirstName;
    public String employeeCode = null;


    public void personalInformation(String MaritalStatus, String Gender, String Nationality,
                                    String Religion, String Mobile, String Email,
                                    String DirectManager, String BirthDate){

        goToFrame(frame);
        hold(500);
        elementWaitAdvanced(By.id("employee_code"));
        hold(300);
        employeeCode = empCode.getDomAttribute("value");

        empFirstName = firstName();
        setText(fNameEng, empFirstName);
        setText(sNameEng, secondName());
        setText(tNameEng, thirdName());
        setText(familyNameEng, lastName());
        setText(fNameAr, firstName());
        setText(sNameAr, secondName());
        setText(tNameAr, thirdName());
        setText(familyNameAr, lastName());

        normalSelect(marital_StatusE, MaritalStatus);
        maritalStatus = MaritalStatus;
        normalSelect(sexE,Gender);
        if(!Nationality.isEmpty()){
            normalSelect(nationalityE, Nationality);
        }
        if(!Religion.isEmpty()){
            normalSelect(relegionE, Religion);
        }
        if(!Mobile.isEmpty()){
            setText(mobileE, Mobile);
        }
        if(!Email.isEmpty()){
            setText(emailE, Email);
        }
        if(!DirectManager.isEmpty()){
            setText(manager_code, DirectManager);
            manager_code.sendKeys(Keys.TAB);
            hold(500);
        }
        //employeePicture.sendKeys(uploadRandomImage());

        setText(birth_date, BirthDate);

    }

    public void employmentInformation(String site, String department, String section, String division, String unit,
                                      String subSection, String subDivision, String subUnit, String office, String team,
                                      String category1, String category2, String category3, String contractType, String classification,
                                      String degree, String step, String position, String hiringDate, String employmentDate,
                                      String workType, String project, String currency, String contractStartDate){

        elementWaitAdvanced(By.id("site_1"));
        normalSelect(siteE, site);
        normalSelect(departmentE, department);
        normalSelect(sectionE, section);
        if(!division.isEmpty()){
            normalSelect(divisionE, division);
        }
        if(!unit.isEmpty()){
            normalSelect(unitsE, unit);
        }
        if(!subSection.isEmpty()){
            normalSelect(sub_sectionE, subSection);
        }
        if(!subDivision.isEmpty()){
            normalSelect(sub_divisionE, subDivision);
        }
        if(!subUnit.isEmpty()){
            normalSelect(sub_unitE, subUnit);
        }
        if(!office.isEmpty()){
            normalSelect(officeE, office);
        }
        if(!team.isEmpty()){
            normalSelect(teamE, team);
        }
        if(!classification.isEmpty()){
            normalSelect(classificationE, classification);
        }
        if(!degree.isEmpty()){
            normalSelect(degreeE, degree);
        }
        if(!step.isEmpty()){
            setText(stepE, step);
        }
        normalSelect(positionE, position);
        if(!hiringDate.isEmpty()){
            hiring_dateE.clear();
            hold(300);
            setText(hiring_dateE, hiringDate);
            hiring_dateE.sendKeys(Keys.TAB);
        }
        if(!employmentDate.isEmpty()){
            setText(moving_dateE, employmentDate);
        }
        if(!workType.isEmpty()){
            normalSelect(work_typeE, workType);
        }
        if(!project.isEmpty()){
            normalSelect(projectE, project);
        }
        if(!currency.isEmpty()){
            normalSelect(currencyE, currency);
        }
        if(!category1.isEmpty()){
            normalSelect(category1E, category1);
        }
        if(!category2.isEmpty()){
            normalSelect(category2E, category2);
        }
        if(!category3.isEmpty()){
            normalSelect(category3E, category3);
        }
        if(!contractType.isEmpty()){
            normalSelect(contract_typeE, contractType);
            hold(300);
        }

        //// check if 'Contract Start Date' is not empty
        if(!contractStartDate.isEmpty()){
            hold(1500);
            contract_start_dateE.clear();
            hold(300);
            contract_start_dateE.clear();
            hold(500);
            setText(contract_start_dateE, contractStartDate);
        }

        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.xpath("(//label[@class = 'empNameAndStatus'])[2]"));
        empName = FirstAndLastName.getText().trim();

    }

    public void justAddSpouse( String firstName, String secondName, String thirdName, String familyName, String firstArabicName, String secondArabicName, String thirdArabicName, String familyArabicName,
                               String birthDate, String marriageDate, String deathDate, String divorceDate, String birthPlace, String nationality, String nationalCode,
                               String nationalCodeExpireDate, String passportNumber, String passportExpireDate, String residenceNumber, String residenceExpiryDate, boolean insured,
                               String insuranceDate, String insuranceCode, String insuranceCardExpiry, boolean workerSpouse, String workText, boolean medicalClaimCoverage,
                               String medicalClaimStartDate, String allowanceAmount, String startDateAllowance, String toDateAllowance, String notes, boolean uploadPicture){

        hold(300);
        clickOn(spousePage);
        elementWaitAdvanced(By.name("wife_name_man1"));
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
        normalSelect(birthPlaceSpouseE, birthPlace);
        normalSelect(nationalitySpouseE, nationality);
        setText(nationalCodeSpouseE, nationalCode);
        setText(nationalExpireDateE, nationalCodeExpireDate);
        setText(passportNumberE, passportNumber);
        setText(passportExpireDateE, passportExpireDate);
        setText(residenceNumberE, residenceNumber);
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
            }else{
                if (medicalClaimCoverageSpouseE.isSelected()){
                    clickOn(medicalClaimCoverageSpouseE);
                }
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
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(frame);
        hold(300);

    }

    public void addChildrenAfterSpouse(String birthDate, String deathDate, String gender, String maritalStatus, String birthPlace, String residenceNumber, String residenceExpiryDate, String nationality,
                                       String nationalCode, String nationalCodeExpiryDate, String passportNumber, String passportExpiryDate, String allowanceAmount, String allowanceStartingFrom,
                                       String allowanceToDate, boolean student, String educationLevel, String school, boolean educationSystemBeneficiary, boolean insured, String insuranceStartDate,
                                       String insuranceCode, String insuranceCardExpiry, boolean medicalClaimCoverage, String medicalClaimStartDate, boolean permanentDisability){

        hold(500);
        clickOn(childrenPage);
        elementWaitAdvanced(By.name("son_name_man1"));
        hold(500);
        employeeCode = empCode.getDomAttribute("value");
        setText(birthDateE, birthDate);
        normalSelect(genderE, gender);
        setText(firstNameChildren, firstName());
        setText(secondNameChildren, "");
        setText(thirdNameChildren, "");
        setText(familyNameChildren, lastName());
        setText(firstArNameChildren, firstName());
        setText(secondArNameChildren, "");
        setText(thirdArNameChildren, "");
        setText(familyArNameChildren, lastName());
        setText(nationalCodeE, nationalCode);
        setText(passportNumberE, passportNumber);
        setText(residenceNumberE, residenceNumber);
        setText(deathDateE, deathDate);
        normalSelect(maritalStatusChildren, maritalStatus);
        normalSelect(birthPlaceChildren, birthPlace);
        normalSelect(nationalityE, nationality);
        setText(nationalCodeExpireDateE, nationalCodeExpiryDate);
        setText(passportExpireDateE, passportExpiryDate);
        setText(residenceExpiryDateE, residenceExpiryDate);
        clickOn(otherInformationList);
        hold(300);
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
            if(!liteGetter()){
                selectOption(educationLevelE, educationLevel);
                selectOption(schoolE, school);
            }
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
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(frame);
        hold(300);

    }

    public void goToShiftDetails(){

        clickOn(otherInformationTab);
        hold(500);
        elementWaitAdvanced(By.id("card_id"));

    }

    public void addDependent(String relationships, String gender, String nationalCode, String socialSecurityNumber, String birthDate,
                             String religion, String nationality, boolean medicalClaimCoverage, String medicalClaimStartDate,
                             boolean insured, String insuranceStartDate, String insuranceCardExpiry, String homePhone,
                             String street, String zipCode, String city, String comments){

        hold(500);
        clickOn(dependentsPage);
        elementWaitAdvanced(By.name("dep_name_man1"));
        employeeCode = empCode.getDomAttribute("value");
        setText(firstNameDependents, firstName());
        setText(secondNameDependents, "");
        setText(thirdNameDependents, "");
        setText(familyNameDependents, lastName());
        setText(firstArNameDependents, firstName());
        setText(secondArNameDependents, "");
        setText(thirdArNameDependents, "");
        setText(familyArNameDependents, lastName());
        normalSelect(relationship, relationships);
        normalSelect(genderDepE, gender);
        setText(birthDateE, birthDate);
        normalSelect(nationalityE, nationality);
        setText(ssn, socialSecurityNumber);
        normalSelect(relegionDepE, religion);
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
            if(!insuredCheckbox.isSelected()){
                clickOn(insuredCheckbox);
                hold(400);
                setText(insuranceStartDateE, insuranceStartDate);
                setText(insuranceCardExpiryDepE, insuranceCardExpiry);
            }
        }else{
            if(insuredCheckbox.isSelected()){
                clickOn(insuredCheckbox);
                hold(400);
                setText(insuranceStartDateE, insuranceStartDate);
                setText(insuranceCardExpiryDepE, insuranceCardExpiry);
            }
        }
        hold(400);
        setText(nationalCodeDepE, nationalCode);
        setText(homePhoneE, homePhone);
        setText(streetE, street);
        setText(zipCodeE, zipCode);
        setText(cityE, city);
        setText(commentsE, comments);
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(frame);
        hold(300);

    }

    public void otherInformation(String documentType, String documentCode, String documentIssue, String documentExpiry, String placeOfIssue,
                                     String insuranceCode, String keyWord, String universalCode, String nationalCode, String socialSecurityGOSICode,
                                     String taxCode, String extNumber, String graduationYear, String motherName, String birthPlace, String marriageDate,
                                     String personalNumber){

        hold(500);
        elementWaitAdvanced(By.id("documrnt_code"));
        normalSelect(documentTypeE, documentType);
        setText(documentCodeE, documentCode);
        setText(documentIssueE, documentIssue);
        setText(documentExpiryE, documentExpiry);
        setText(placeOfIssueE, placeOfIssue);
        setText(insuranceCodeE, insuranceCode);
        setText(keyWordE, keyWord);
        setText(universalCodeE, universalCode);
        setText(nationalCodeE, nationalCode);
        setText(socialCodeGOSIE, socialSecurityGOSICode);
        setText(taxCodeE, taxCode);
        setText(extNumberE, extNumber);
        setText(graduationYearE, graduationYear);
        setText(motherNameE, motherName);
        if(!marriageDate.isEmpty()){
            setText(marriageDateE, marriageDate);
        }
        normalSelect(birthPlaceE, birthPlace);
        setText(personalNumberE, personalNumber);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(frame);
        hold(300);

    }

    public void addAddress(String fromDate, String toDate, String country, String city, String province,
                           String district, String landNumber, String partNumber, String neighborhood,
                           String street, String buildingType, String buildingName, String entrance,
                           String floor, String apartment, String town, String realEstateArea,
                           String realEstateNumber, String telephone1, String telephone2, String poBOX,
                           String zipCode, String fax, String distanceToCompany, String address){

        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        setText(startDateE, fromDate);
        setText(endDateE, toDate);
        normalSelect(countryE, country);
        normalSelect(cityE, city);
        setText(provinceE, province);
        setText(districtE, district);
        setText(landNumberE, landNumber);
        setText(partNumberE, partNumber);
        setText(neighborhoodE, neighborhood);
        setText(streetE, street);
        setText(buildingTypeE, buildingType);
        setText(buildingNameE, buildingName);
        setText(entranceE, entrance);
        setText(floorE, floor);
        setText(apartmentE, apartment);
        setText(townE, town);
        setText(realEstateAreaE, realEstateArea);
        setText(realEstateNumberE, realEstateNumber);
        setText(telephone1E, telephone1);
        setText(telephone2E, telephone2);
        setText(poBoxE, poBOX);
        setText(zipCodeE, zipCode);
        setText(faxE, fax);
        setText(distanceToCompanyE, distanceToCompany);
        //attachmentDocumentFile.sendKeys(uploadRandomImage());
        addressE.clear();
        hold(300);
        setText(addressE, address);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(frame);
        hold(300);

    }

    public void addEducation(String startDate, String endDate, boolean untilNow, String country, String city, String school,
                             String otherSchool, String faculty, String otherFaculty, String qualification, String otherQualification,
                             String major, String otherMajor, String universityAverage, String grade, String graduationYear, String educationNotes,
                             String educationMinor){

        clickOn(educationTab);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        setText(startDateE, startDate);
        setText(endDateE, endDate);
        if(untilNow){
            clickOn(untilNowE);
        }
        normalSelect(countryE, country);
        normalSelect(cityEduE, city);
        normalSelect(schoolE, school);
        if(school.equalsIgnoreCase("Other")){
            setText(otherSchoolE, otherSchool);
        }
        normalSelect(facultyE, faculty);
        if(faculty.equalsIgnoreCase("Other")){
            setText(otherFacultyE, otherFaculty);
        }
        normalSelect(qualificationE, qualification);
        if(qualification.equalsIgnoreCase("Other")){
            setText(otherQualificationE, otherQualification);
        }
        normalSelect(majorE, major);
        if(major.equalsIgnoreCase("Other")){
            setText(otherMajorE, otherMajor);
        }
        normalSelect(universityAverageE, universityAverage);
        setText(gradeE, grade);
        normalSelect(graduationYearEduE, graduationYear);
        setText(educationNotesE, educationNotes);
//        attachmentFile.sendKeys(uploadRandomImage());
        if(educationMinor.equalsIgnoreCase("Yes")){
            clickOn(educationMinorYes);
        }else{
            clickOn(educationMinorNo);
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(frame);
        hold(300);

    }

}
