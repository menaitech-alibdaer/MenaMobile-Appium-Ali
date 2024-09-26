package webBackend.personnelInformation;

import bases.WebBase;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import webBackend.general.SystemParameters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.HijrahEra;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;
import static utilities.MssqlConnect.sqlQuery;
import static utilities.VersionGetter.versionGetter;

public class PersonnelInformation extends WebBase {

    @FindBy(id = "body_frame")
    WebElement frame;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(name = "frame")
    WebElement searchEmployeePopupFrame;
    @FindBy(id = "MenuPostButton")
    WebElement menuPostButton;
    @FindBy(id = "MenuUnpostButton")
    WebElement menuUnPostButton;
    @FindBy(id = "employee_code")
    public WebElement empCode;
    @FindBy(id = "basic_salary_amount")
    WebElement basicSalaryAmount;
    @FindBy(name = "employee_code")
    WebElement empCodeByName;
    @FindBy(name = "lock_employment")
    WebElement lockEmployment;
    @FindBy(name = "lock_financial")
    WebElement lockFinancial;
    @FindBy(id = "logout")
    WebElement logout;
    protected String employeeCode = null;
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
    @FindBy(xpath = "//*[contains(@id,'select2-social_status')]")
    WebElement marital_StatusE;
    @FindBy(xpath = "//*[contains(@id,'select2-sex')]")
    WebElement sexE;
    @FindBy(xpath = "//*[@id=\"select2-nationality_1-container\"]")
    WebElement nationalityE;
    @FindBy(xpath = "//*[contains(@id,'select2-relegion')]")
    WebElement relegionE;
    @FindBy(id = "mobile")
    WebElement mobileE;
    @FindBy(id = "Email")
    WebElement emailE;
    @FindBy(id = "manager_code")
    public WebElement manager_code;
    @FindBy(id = "birth_date")
    WebElement birth_date;
    @FindBy(xpath = "//*[contains(@src, 'WhiteClose.svg')]")
    WebElement deletePhoto;
    @FindBy(xpath = "//*[contains(@src, 'WhiteClose.svg')]")
    List <WebElement> checkImgDeleteBtn;
    @FindBy(id = "blah")
    WebElement imgPath;
    @FindBy(xpath = "(//label[@class = 'empNameAndStatus'])[2]")
    WebElement activeEmployee_oct;
    @FindBy(xpath = "//label[contains(@class, 'active-label') and not(contains(@class, 'active-label-blue'))][1]")
    WebElement activeEmployee_aug;
    @FindBy(xpath = "//button[@class='semibold']")
    WebElement okBtnDeletePhoto;
    @FindBy(xpath = "//button[@type='button' and contains(text(), 'Next')]")
    WebElement nextButton;
    @FindBy(xpath = "//button[contains(text(),'Previous')]")
    WebElement previousButton;
    @FindBy(xpath = "//div[@class='textAlign']//label[contains(@style, 'font-size:20px')]")
    WebElement alertText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    WebElement alertBox;
    @FindBy(id = "select2-site_1-container")
    public WebElement siteE;
    @FindBy(id = "select2-department_1-container")
    public WebElement departmentE;
    @FindBy(id = "select2-section_1-container")
    public WebElement sectionE;
    @FindBy(id = "select2-division_1-container")
    public WebElement divisionE;
    @FindBy(id = "select2-units_1-container")
    public WebElement unitsE;
    @FindBy(id = "select2-sub_section_1-container")
    public WebElement sub_sectionE;
    @FindBy(id = "select2-sub_division_1-container")
    public WebElement sub_divisionE;
    @FindBy(id = "select2-sub_unit_1-container")
    public WebElement sub_unitE;
    @FindBy(id = "select2-office_1-container")
    public WebElement officeE;
    @FindBy(id = "select2-team_1-container")
    public WebElement teamE;
    @FindBy(id = "select2-FDimension_1-container")
    public WebElement category1E;
    @FindBy(id = "select2-SDimension_1-container")
    public WebElement category2E;
    @FindBy(id = "select2-TDimension_1-container")
    public WebElement category3E;
    @FindBy(id = "select2-contract_type_1-container")
    WebElement contract_typeE;
    @FindBy(id = "select2-classification_1-container")
    public WebElement classificationE;
    @FindBy(id = "select2-degree_1-container")
    public WebElement degreeE;
    @FindBy(id = "year_count")
    public WebElement stepE;
    @FindBy(id = "select2-position_1-container")
    public WebElement positionE;
    @FindBy(name = "position")
    WebElement positionSelect;
    @FindBy(id = "hiring_date")
    public WebElement hiring_dateE;
    @FindBy(id = "moving_date")
    WebElement moving_dateE;
    @FindBy(id = "select2-work_type-container")
    WebElement work_typeE;
    @FindBy(id = "select2-Project_1-container")
    WebElement projectE;
    @FindBy(id = "select2-emp_currency-container")
    WebElement currencyE;
    @FindBy(id = "contract_start_date")
    WebElement contract_start_dateE;
    @FindBy(id = "employee_picture")
    WebElement employeePicture;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//label[contains(text(),'Active Employee')]")
    WebElement CheckActiveEmployee;
    @FindBy(xpath = "(//div[contains(@onclick,'employees.php')])[2]")
    WebElement backToPersonalInformationTab;
    @FindBy(xpath = "//div[contains(@onclick,'employment_information.php')]")
    WebElement backToEmploymentInformationTab;
    @FindBy(id = "blah")
    WebElement checkPicture;
    @FindBy(xpath = "(//label[@class='font-size-11'])[2]")
    public WebElement FirstAndLastName;
    @FindBy(id = "picture_ajax")
    WebElement TopLeftImg;
    @FindBy(xpath = "//div[contains(@onclick, 'Sons.php')]")
    WebElement childrenPage;
    @FindBy(xpath = "//div[contains(@onclick, 'Dependencies.php')]")
    WebElement dependentsPage;
    @FindBy(xpath = "//div[contains(@onclick, 'Skills.php')]")
    WebElement competenciesPage;
    @FindBy(xpath = "//div[contains(@onclick, 'employee_certificates.php')]")
    WebElement certificatePage;
    @FindBy(xpath = "(//div[contains(@onclick, 'Job_History.php')])[2]")
    WebElement jobHistoryPage;
    @FindBy(xpath = "//div[contains(@onclick, 'Emergency_Contacts.php')]")
    WebElement referencesPage;
    @FindBy(xpath = "//div[contains(@onclick, 'extra_data.php')]")
    WebElement AdditionalInfoPage;
    @FindBy(xpath = "//div[contains(@onclick, 'employee_notes.php')]")
    WebElement notesPage;
    @FindBy(xpath = "//div[contains(@onclick, 'Emp_Contacts.php')]")
    WebElement contactsPage;
    @FindBy(xpath = "//span[contains(@id, 'select2-contact_types')]")
    WebElement contactsTypes;
    @FindBy(name = "contact_value")
    WebElement contactValue;
    @FindBy(xpath = "//div[contains(@onclick, 'Previous_Employer.php')]")
    WebElement experiencesPage;
    @FindBy(xpath = "//div[contains(@onclick, 'employee_practical_exp.php')]")
    WebElement practicalExperiencesPage;
    @FindBy(xpath = "//div[contains(@onclick, 'medical_profile.php')]")
    WebElement medicalProfilePage;
    @FindBy(id = "son_name_man1")
    WebElement firstNameChildEn;
    @FindBy(name = "wife_id")
    WebElement checkSpouseList;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    List<WebElement> checkSaveButtonInChildren;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    List<WebElement> checkSaveButton;
    @FindBy(xpath = "//div[contains(@onclick, 'Wives.php')]")
    WebElement spousePage;
    @FindBy(id = "d1-qx")
    WebElement searchBoxEmployees;
    @FindBy(className = "height-56")
    List<WebElement> employeePictureInSearchBox;
    @FindBy(xpath = "//div[contains(@onclick, 'parent.go_selected_user')]")
    List<WebElement> employeeNameInSearchBox;
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
    @FindBy(id = "son_name_man1")
    WebElement firstNameChildren;
    @FindBy(id = "son_name_man2")
    WebElement secondNameChildren;
    @FindBy(id = "son_name_man3")
    WebElement thirdNameChildren;
    @FindBy(id = "son_name_man4")
    WebElement familyNameChildren;
    @FindBy(id = "son_name_other1")
    WebElement firstNameArChildren;
    @FindBy(id = "son_name_other2")
    WebElement secondNameArChildren;
    @FindBy(id = "son_name_other3")
    WebElement thirdNameArChildren;
    @FindBy(id = "son_name_other4")
    WebElement familyNameArChildren;
    @FindBy(id = "birth_date")
    WebElement birthDateChildren;
    @FindBy(id = "select2-sex-container")
    WebElement genderChildren;
    @FindBy(id = "select2-marital_status_flag-container")
    WebElement maritalStatusChildren;
    @FindBy(id = "select2-birth_place-container")
    WebElement birthPlaceChildren;
    @FindBy(name = "alowance_amount")
    WebElement allowanceAmountChildren;
    @FindBy(id = "start_date")
    WebElement allowanceStartDateChildren;
    @FindBy(name = "student")
    WebElement studentChildren;
    @FindBy(xpath = "//span[contains(@id, 'select2-education_level')]")
    WebElement educationLevelChildren;
    @FindBy(xpath = "//span[contains(@id, 'select2-school')]")
    WebElement schoolChildren;
    @FindBy(id = "flexSwitchCheckChecked1")
    WebElement insuredChildren;
    @FindBy(id = "insurance_date")
    WebElement insuranceDateChildren;
    @FindBy(id = "insurance_number")
    WebElement insuranceCodeChildren;
    @FindBy(id = "flexSwitchCheckCheckedx")
    WebElement medicalClaimCoverageChildren;
    @FindBy(id = "permanentDisability")
    WebElement permanentDisabilityChildren;
    @FindBy(id = "select2-nationality-container")
    WebElement nationalityChildren;
    @FindBy(id = "national_code")
    WebElement nationalCodeChildren;
    @FindBy(id = "dep_name_man1")
    WebElement firstNameDependents;
    @FindBy(id = "dep_name_man2")
    WebElement secondNameDependents;
    @FindBy(id = "dep_name_man3")
    WebElement thirdNameDependents;
    @FindBy(id = "dep_name_man4")
    WebElement familyNameDependents;
    @FindBy(id = "dep_name_other1")
    WebElement firstNameArDependents;
    @FindBy(id = "dep_name_other2")
    WebElement secondNameArDependents;
    @FindBy(id = "dep_name_other3")
    WebElement thirdNameArDependents;
    @FindBy(id = "dep_name_other4")
    WebElement familyNameArDependents;
    @FindBy(xpath = "//span[contains(@id, 'select2-relationship')]")
    WebElement relationshipsDependents;
    @FindBy(xpath = "//span[contains(@id, 'select2-Gender')]")
    WebElement genderDependents;
    @FindBy(name = "national_code")
    WebElement nationalCodeDependents;
    @FindBy(name = "ssn")
    WebElement GOSISecurityNumberDependents;
    @FindBy(id = "birth_date")
    WebElement birthDateDependents;
    @FindBy(xpath = "//span[contains(@id, 'select2-relegion')]")
    WebElement religionDependents;
    @FindBy(xpath = "//span[contains(@id, 'select2-nationality')]")
    WebElement nationalityDependents;
    @FindBy(id = "flexSwitchCheckCheckedx")
    WebElement medicalClaimCoverageDependents;
    @FindBy(id = "insuredx")
    WebElement insuredDependents;
    @FindBy(id = "insurance_date")
    WebElement insuranceDateDependents;
    @FindBy(id = "dep_end_ins_date")
    WebElement insuranceCardExpiryDependents;
    @FindBy(name = "home_phone")
    WebElement homePhoneDependents;
    @FindBy(name = "street")
    WebElement streetDependents;
    @FindBy(name = "zip_code")
    WebElement zipCodeDependents;
    @FindBy(name = "city")
    WebElement cityDependents;
    @FindBy(name = "comments")
    WebElement commentsDependents;
    @FindBy(id = "note_date")
    WebElement noteDateNotes;
    @FindBy(name = "note_text")
    WebElement noteTextNotes;
    @FindBy(name = "employee_comment")
    WebElement employeeCommentNotes;
    @FindBy(name = "start_date")
    WebElement startDateEducation;
    @FindBy(id = "end_date")
    WebElement endDateEducation;
    @FindBy(xpath = "//span[contains(@id, 'select2-country_code')]")
    WebElement countryEducation;
    @FindBy(xpath = "//span[contains(@id, 'select2-school-container')]")
    WebElement schoolEducation;
    @FindBy(xpath = "//span[contains(@id, 'select2-faculty-container')]")
    WebElement facultyEducation;
    @FindBy(xpath = "//span[contains(@id, 'select2-degree-container')]")
    WebElement qualificationEducation;
    @FindBy(id = "other_degree")
    WebElement otherQualificationEducation;
    @FindBy(xpath = "//span[contains(@id, 'select2-major-container')]")
    WebElement majorEducation;
    @FindBy(id = "other_major")
    WebElement otherMajorEducation;
    @FindBy(xpath = "//span[contains(@id, 'select2-university_average')]")
    WebElement universityAverageEducation;
    @FindBy(name = "grade_text")
    WebElement gradeEducation;
    @FindBy(xpath = "//span[contains(@id, 'select2-Year')]")
    WebElement graduationYearEducation;
    @FindBy(name = "notes")
    WebElement notesEducation;
    @FindBy(name = "certificate_path1")
    WebElement attachFileEdu;
    @FindBy(name = "Education_Minor")
    WebElement educationMinor;
    @FindBy(xpath = "//span[contains(@id, 'select2-skills_classification')]")
    WebElement skillClassification;
    @FindBy(xpath = "//span[contains(@id, 'select2-skills_classification_type')]")
    WebElement skillType;
    @FindBy(xpath = "//span[contains(@id, 'select2-skill_type')]")
    WebElement competencies;
    @FindBy(xpath = "//span[contains(@id, 'select2-experience_years')]")
    WebElement experienceYears;
    @FindBy(xpath = "//span[contains(@id, 'select2-skill_level')]")
    WebElement levelSkill;
    @FindBy(name = "class")
    WebElement clasSkill;
    @FindBy(xpath = "//span[contains(@id, 'select2-skill_source')]")
    WebElement skillSource;
    @FindBy(xpath = "//span[contains(@id, 'select2-show_in_CV')]")
    WebElement showInSkill;
    @FindBy(name = "comments")
    WebElement commentSkill;
    @FindBy(id = "other_skills_class")
    WebElement otherSkillClassification;
    @FindBy(id = "start_date")
    WebElement startDateCertificate;
    @FindBy(id = "end_date")
    WebElement endDateCertificate;
    @FindBy(xpath = "//span[contains(@id, 'select2-certificate_type_code')]")
    WebElement certificateType;
    @FindBy(id = "certificate_type_other")
    WebElement certificateTypeOther;
    @FindBy(id = "select2-certificate-container")
    WebElement certificateName;
    @FindBy(id = "certificate_name_other")
    WebElement certificateNameOther;
    @FindBy(id = "issue_date")
    WebElement issueDateCertificate;
    @FindBy(name = "repair_man")
    WebElement certificateSerial;
    @FindBy(name = "grade")
    WebElement gradeCertificate;
    @FindBy(name = "certificate_Ref")
    WebElement certificateNumber;
    @FindBy(xpath = "//span[contains(@id, 'select2-show_in_CV')]")
    WebElement certificateShowIn;
    @FindBy(name = "certificate_path1")
    WebElement certificateAttached;
    @FindBy(css = "[name='status'][value='1']")
    WebElement statusCertificate;
    @FindBy(name = "notes")
    WebElement notesCertificate;
    @FindBy(name = "start_date")
    WebElement startDateJobHistory;
    @FindBy(name = "end_date")
    WebElement endDateJobHistory;
    @FindBy(name = "site")
    WebElement siteJobHistory;
    @FindBy(name = "department")
    WebElement departmentJobHistory;
    @FindBy(name = "section")
    WebElement sectionJobHistory;
    @FindBy(name = "position")
    WebElement positionJobHistory;
    @FindBy(name = "name")
    WebElement contactNameReferences;
    @FindBy(xpath = "//span[contains(@id, 'select2-relationship')]")
    WebElement relationshipsReferences;
    @FindBy(name = "city")
    WebElement cityReferences;
    @FindBy(name = "field_id")
    WebElement fieldNameAdditionalInfo;
    @FindBy(name = "field_value")
    WebElement englishDescriptionAdditionalInfo;
    @FindBy(id = "start_date")
    WebElement startDateExperiences;
    @FindBy(id = "end_date")
    WebElement endDateExperiences;
    @FindBy(name = "employer")
    WebElement previousEmployerExperiences;
    @FindBy(name = "title")
    WebElement previousPositionExperiences;
    @FindBy(name = "salary_currency")
    WebElement salaryExperiences;
    @FindBy(xpath = "//span[contains(@id, 'select2-currency')]")
    WebElement salaryCurrencyExperiences;
    @FindBy(name = "manager")
    WebElement contactPersonExperiences;
    @FindBy(name = "contact_phone")
    WebElement contactPhoneExperiences;
    @FindBy(name = "contact_position")
    WebElement contactPositionExperiences;
    @FindBy(xpath = "//span[contains(@id, 'select2-country_code')]")
    WebElement countryExperiences;
    @FindBy(name = "job_address")
    WebElement jobPlaceExperiences;
    @FindBy(name = "quit")
    WebElement quitReasonExperiences;
    @FindBy(xpath = "//span[contains(@id, 'select2-Experience_Type')]")
    WebElement experiencePlaceExperiences;
    @FindBy(xpath = "//span[contains(@id, 'select2-Experience_place')]")
    WebElement experienceTypeExperiences;
    @FindBy(xpath = "//span[contains(@id, 'select2-Nature_Of_Work')]")
    WebElement natureOfWorkExperiences;
    @FindBy(xpath = "//span[contains(@id, 'select2-Job_Classification')]")
    WebElement jobClassificationExperiences;
    @FindBy(xpath = "//span[contains(@id, 'select2-experience_relevance')]")
    WebElement relevanceExperiences;
    @FindBy(name = "resp")
    WebElement responsibilitiesExperiences;
    @FindBy(id = "exp_date")
    WebElement datePracticalExperience;
    @FindBy(xpath = "//span[contains(@id, 'select2-show_in_CV')]")
    WebElement showInPracticalExperience;
    @FindBy(name = "practical_Experiance_text")
    WebElement englishPracticalExperience;
    @FindBy(name = "practical_Experiance_text_a")
    WebElement arabicPracticalExperience;
    @FindBy(id = "start_date")
    WebElement fromDateAddresses;
    @FindBy(id = "end_date")
    WebElement toDateAddresses;
    @FindBy(xpath = "//span[contains(@id, 'select2-country_code')]")
    WebElement countryAddresses;
    @FindBy(name = "town")
    WebElement townAddresses;
    @FindBy(xpath = "//span[contains(@id, 'select2-type')]")
    WebElement attachmentTypeAttachments;
    @FindBy(id = "date")
    WebElement attachmentDateAttachments;
    @FindBy(id = "document_number")
    WebElement documentNumberAttachments;
    @FindBy(id = "expiry_date")
    WebElement expiresOnAttachments;
    @FindBy(xpath = "//span[contains(@id, 'select2-related_to')]")
    WebElement relatedToAttachments;
    @FindBy(xpath = "//div[@class='d-flex']//a[1]")
    WebElement attachedFileAttachments;
    @FindBy(id = "description")
    WebElement descriptionAttachments;
    @FindBy(xpath = "//span[contains(@id, 'select2-medical_status')]")
    WebElement statusTypeMedicalProfile;
    @FindBy(id = "medical_date")
    WebElement statusDateMedicalProfile;
    @FindBy(xpath = "//div[@class='mar-left-5']//a[1]")
    WebElement medicalFileMedicalProfile;
    @FindBy(name = "status")
    WebElement statusMedicalProfile;
    @FindBy(name = "notes")
    WebElement notesMedicalProfile;
    @FindBy(name = "details")
    WebElement projectManagerBtn;
    @FindBy(xpath = "//label[contains(text(),'Project Manager')]")
    WebElement checkProjectManagerBox;
    @FindBy(id = "select2-overtime_cost_center_1-container")
    WebElement firstProject;
    @FindBy(id = "select2-overtime_cost_center_2-container")
    WebElement secondProject;
    @FindBy(id = "select2-overtime_cost_center_3-container")
    WebElement thirdProject;
    @FindBy(id = "select2-activity_1-container")
    WebElement firstActivity;
    @FindBy(id = "select2-activity_2-container")
    WebElement secondActivity;
    @FindBy(id = "select2-job_card_1-container")
    WebElement firstJobCard;
    @FindBy(id = "select2-job_card_2-container")
    WebElement secondJobCard;
    @FindBy(name = "save")
    WebElement projectManagerSave;
    @FindBy(name = "add")
    WebElement projectManagerNew;
    @FindBy(name = "remove")
    WebElement projectManagerDelete;
    @FindBy(xpath = "//button[@data-bs-dismiss='modal']//img")
    WebElement projectManagerCloseBtn;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkboxFirstProjectManager;
    @FindBy(id = "All_popup")
    WebElement iframePopup;
//    @FindAll({
//            @FindBy(xpath = "//button[contains(@class,'button-save-style cursor-pointer')]"),
//            @FindBy(xpath = "(//button[contains(@class,'button-save-style cursor-pointer')])[2]")
//    })
//    List<WebElement> checkSpouseButtons;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    List<WebElement> checkAddButtonInSpouse;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    List<WebElement> checkSaveButtonInSpouse;
    @FindBy(xpath = "//label[contains(text(),'This Field Should Only Contain A Valid Email Address')]")
    WebElement ValidateWrongEmail;
    @FindBy(name = "direct_manager")
    WebElement directManagerName;
    @FindBy(id = "chnage_manager_code")
    WebElement searchBtnDirectManager;
    @FindBy(xpath = "//div[@class='textAlign']//label[1]")
    WebElement checkExtension;
    @FindBy(id = "btok")
    WebElement alertOkBtn;
    @FindBy(name = "conv2")
    WebElement hijriConvertBtn;
    @FindBy(id = "date")
    WebElement hijriDateE;
    @FindBy(xpath = "//input[@value='Convert']")
    WebElement convertHijriBtn;
    @FindBy(xpath = "//label[contains(text(), 'The Specified Classification')]")
    public WebElement alertClassifications;
    @FindBy(id = "contract_end_date")
    WebElement contract_end_dateE;
    @FindBy(id = "synch_button")
    WebElement synchronizeDataBtn;
    @FindBy(id = "employee_code_1")
    WebElement employeeCodeSync;
    @FindBy(xpath = "//label[contains(text(), 'Please Choose A Terminated Employee')]")
    WebElement alertActiveEmployeeSync;
    @FindBy(xpath = "//label[contains(text(), 'Employee Is Undefined')]")
    WebElement alertUndefinedEmployeeSync;
    @FindBy(id = "employee_name_1")
    WebElement employeeNameSync;
    @FindBy(id = "employee_search_img_1")
    WebElement searchBoxBtn;
//    @FindAll({
//                    @FindBy(id = "search-box")
//            })
//    List<WebElement> searchBoxInSync;
    @FindBy(id = "xl")
    WebElement filterInSearchBox;
    @FindBy(id = "emp_status_search")
    WebElement employeeStatusInSearchBox;
    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchBtnInSearchBox;
    @FindBy(id = "save")
    WebElement saveBtnSyncData;
    @FindBy(xpath = "//div[contains(@onclick,'employees.php')]")
    WebElement personalAndEmploymentTab;
    @FindBy(xpath = "//div[contains(@onclick,'Addresses.php')]")
    WebElement addressAndContactsTab;
    @FindBy(xpath = "//div[contains(@onclick,'Job_History.php')]")
    WebElement experiencesTab;
    @FindBy(xpath = "//div[contains(@onclick,'Education.php')]")
    WebElement learningAndDevelopmentTab;
    @FindBy(xpath = "//div[contains(@onclick,'Attachments.php')]")
    WebElement assetsAndDocumentsTab;
    @FindBy(xpath = "//div[contains(@onclick,'official_documents.php')]")
    WebElement otherTab;
    @FindBy(xpath = "//label[contains(text(),'Miscellaneous')]")
    WebElement miscellaneousPage;
    @FindBy(xpath = "//div[contains(@onclick,'payment_method.php')]")
    WebElement paymentTab;
    @FindBy(xpath = "//div[contains(@onclick,'financial_data.php')]")
    WebElement insuranceTab;
    @FindBy(xpath = "//div[contains(@onclick,'other_banks.php')]")
    WebElement otherBankPayment;
    @FindBy(xpath = "//div[contains(@onclick,'sys_tab_selector(2)')]")
    WebElement socialSecurityInsurance;
    @FindBy(xpath = "//div[contains(@onclick,'sys_tab_selector(3)')]")
    WebElement EOSInsurance;
    @FindBy(xpath = "//div[contains(@onclick,'sys_tab_selector(4)')]")
    WebElement GLAccountInsurance;
    @FindBy(xpath = "//div[contains(@onclick,'sys_tab_selector(5)')]")
    WebElement otherInsurance;
    @FindBy(xpath = "//a[text()='Residence']")
    WebElement residenceTab;
    @FindBy(id = "residence_code")
    WebElement residenceNumber;
    @FindBy(id = "residence_issue_date")
    WebElement dateOfIssueDateResidences;
    @FindBy(id = "residence_period")
    WebElement periodResidences;
    @FindBy(id = "residence_salary")
    WebElement salaryInIqamaResidences;
    @FindBy(id = "residence_cancelation_date")
    WebElement cancellationDateResidences;
    @FindBy(xpath = "//a[contains(@href, 'javascript:download_page')]")
    WebElement attachedFileResidences;
    @FindBy(id = "residence_issue_place")
    WebElement placeOfIssueResidences;
    @FindBy(id = "residence_expiry_date")
    WebElement endDateDateResidences;
    @FindBy(id = "period_request")
    WebElement requestedWorkPeriodResidences;
    @FindBy(name = "permit_number")
    WebElement permitNumberResidences;
    @FindBy(id = "birth_date")
    WebElement birthDateSpouse;
    @FindBy(id = "marry_date")
    WebElement marryDateSpouse;
    @FindBy(xpath = "//span[contains(@id, 'select2-birth_place')]")
    WebElement birthPlaceSpouse;
    @FindBy(xpath = "//span[contains(@id, 'select2-nationality')]")
    WebElement nationalitySpouse;
    @FindBy(id = "national_code")
    WebElement nationalCodeSpouse;
    @FindBy(id = "flexSwitchCheckCheckexd")
    WebElement insuredSpouse;
    @FindBy(id = "insurance_date")
    WebElement insuranceDateSpouse;
    @FindBy(id = "insurance_number")
    WebElement insuranceCodeSpouse;
    @FindBy(id = "wife_end_ins_date")
    WebElement insuranceCardExpirySpouse;
    @FindBy(id = "flexSwitchCheckCheckedz")
    WebElement workerSpouse;
    @FindBy(id = "flexSwitchCheckCheckedx")
    WebElement medicalClaimCoverageSpouse;
    @FindBy(name = "allowance_amount")
    WebElement allowanceAmountSpouse;
    @FindBy(name = "notes")
    WebElement notesSpouse;
    @FindBy(id = "termination_type")
    WebElement terminationType;
    @FindBy(name = "Button2")
    WebElement calculateSalaryTermination;
    @FindBy(xpath = "//a[@href='end_services.php']")
    WebElement employeeTerminationTab;
    @FindBy(id = "citizen")
    WebElement citizenCheck;
    @FindBy(id = "employee_search_input")
    WebElement smartSearchFiled;
    @FindBy(xpath = "(//div[contains(@class,'display-flex-align-items-center justify-content-center')]//img)[1]")
    WebElement smartSearchStatusImg;
    @FindBy(id = "cleare_btn")
    WebElement smartSearchClearBtn;
    @FindBy(id = "d1-qx")
    WebElement advanceSearchBtn;
    @FindBy(id = "textSearchInput")
    WebElement advanceSearch_searchField;
    @FindBy(className = "mar-top-5-minus")
    List <WebElement> advanceSearch_clickOnEmployee;
    @FindBy(xpath = "//input[contains(@class,'advance_search ic3-image input2-style width-291 form-control')]")
    WebElement smartSearchPlace;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    WebElement item;
    @FindBy(xpath = "(//*[local-name()='svg' and @class='arrow'])[1]")
    public WebElement previousEmp;
    @FindBy(xpath = "(//*[local-name()='svg' and @class='arrow'])[2]")
    public WebElement nextEmp;

    SoftAssert softAssert = new SoftAssert();
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    SystemParameters systemParameters;
    PersonalInformation_OCT personalInformationOct;
    public String maritalStatus;
    String firstName = firstName();
    String secondName = secondName();
    String thirdName = thirdName();
    String lastName = lastName();
    public String empName;
    public String empFirstName;

    public void employeeCodeSetter(String empCode){
        employeeCode = empCode;
    }

    public String employeeCodeGetter(){
        return employeeCode;
    }

    public void personalInformation(String MaritalStatus, String Gender, String Nationality,
                                    String Religion, String Mobile, String Email,
                                    String DirectManager, String BirthDate){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            //employeeCode = employeeCodeGenerator();
            employeeCodeSetter(employeeCodeGenerator());
            System.out.println("Employee Code: "+employeeCode);
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            setText(empCode, employeeCode, Keys.TAB);

            empFirstName = firstName();
            setText(fNameEng, empFirstName);
            setText(sNameEng, secondName());
            setText(tNameEng, thirdName());
            setText(familyNameEng, lastName());
            setText(fNameAr, firstName());
            setText(sNameAr, secondName());
            setText(tNameAr, thirdName());
            setText(familyNameAr, lastName());

            selectOption(marital_StatusE, MaritalStatus);
            maritalStatus = MaritalStatus;
            selectOption(sexE,Gender);
            if(!Nationality.isEmpty()){
                selectOption(nationalityE, Nationality);
            }
            if(!Religion.isEmpty()){
                selectOption(relegionE, Religion);
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
            setText(birth_date, BirthDate);
            //employeePicture.sendKeys(uploadRandomImage());
            hold(300);
            scrollToElement(empCode);
            clickOn(nextButton);

        }else {

            personalInformationOct = new PersonalInformation_OCT();
            //employeeCode = employeeCodeGenerator();
            employeeCodeSetter(employeeCodeGenerator());
            System.out.println("Employee Code: "+employeeCode);
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            setText(empCode, employeeCode, Keys.TAB);

            empFirstName = firstName();
            setText(fNameEng, empFirstName);
            setText(sNameEng, secondName());
            setText(tNameEng, thirdName());
            setText(familyNameEng, lastName());
            setText(fNameAr, firstName());
            setText(sNameAr, secondName());
            setText(tNameAr, thirdName());
            setText(familyNameAr, lastName());

            normalSelect(personalInformationOct.marital_StatusE, MaritalStatus);
            personalInformationOct.maritalStatus = MaritalStatus;
            normalSelect(personalInformationOct.sexE,Gender);
            if(!Nationality.isEmpty()){
                normalSelect(personalInformationOct.nationalityE, Nationality);
            }
            if(!Religion.isEmpty()){
                normalSelect(personalInformationOct.relegionE, Religion);
            }
            if(!Mobile.isEmpty()){
                setText(personalInformationOct.mobileE, Mobile);
            }
            if(!Email.isEmpty()){
                setText(personalInformationOct.emailE, Email);
            }
            if(!DirectManager.isEmpty()){
                setText(personalInformationOct.manager_code, DirectManager);
                personalInformationOct.manager_code.sendKeys(Keys.TAB);
                hold(500);
            }
            personalInformationOct.employeePicture.sendKeys(uploadRandomImage());

            setText(personalInformationOct.birth_date, BirthDate);

        }

        setLog("Personal Information"
            +" - Employee Code: "+employeeCode
            +" - Marital Status: "+MaritalStatus
            +" - Gender: "+Gender
            +" - Nationality: "+Nationality
            +" - Religion: "+Religion
            +" - Mobile: "+Mobile
            +" - Email: "+Email
            +" - Direct Manager: "+DirectManager
            +" - Birth Date: "+BirthDate);

    }

    public void personalInformation(String firstName, String secondName, String thirdName, String lastName, String MaritalStatus, String Gender, String Nationality,
                                    String Religion, String Mobile, String Email,
                                    String DirectManager, String BirthDate){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            //employeeCode = employeeCodeGenerator();
            employeeCodeSetter(employeeCodeGenerator());
            System.out.println("Employee Code: "+employeeCode);
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            setText(empCode, employeeCode, Keys.TAB);

            setText(fNameEng, firstName);
            setText(sNameEng, secondName);
            setText(tNameEng, thirdName);
            setText(familyNameEng, lastName);
            setText(fNameAr, firstName);
            setText(sNameAr, secondName);
            setText(tNameAr, thirdName);
            setText(familyNameAr, lastName);

            selectOption(marital_StatusE, MaritalStatus);
            maritalStatus = MaritalStatus;
            selectOption(sexE,Gender);
            if(!Nationality.isEmpty()){
                selectOption(nationalityE, Nationality);
            }
            if(!Religion.isEmpty()){
                selectOption(relegionE, Religion);
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
            setText(birth_date, BirthDate);
            //employeePicture.sendKeys(uploadRandomImage());
            hold(300);
            scrollToElement(empCode);
            clickOn(nextButton);

        }else {

            personalInformationOct = new PersonalInformation_OCT();
            //employeeCode = employeeCodeGenerator();
            employeeCodeSetter(employeeCodeGenerator());
            System.out.println("Employee Code: "+employeeCode);
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            setText(empCode, employeeCode, Keys.TAB);

            empFirstName = firstName();
            setText(fNameEng, empFirstName);
            setText(sNameEng, secondName());
            setText(tNameEng, thirdName());
            setText(familyNameEng, lastName());
            setText(fNameAr, firstName());
            setText(sNameAr, secondName());
            setText(tNameAr, thirdName());
            setText(familyNameAr, lastName());

            normalSelect(personalInformationOct.marital_StatusE, MaritalStatus);
            personalInformationOct.maritalStatus = MaritalStatus;
            normalSelect(personalInformationOct.sexE,Gender);
            if(!Nationality.isEmpty()){
                normalSelect(personalInformationOct.nationalityE, Nationality);
            }
            if(!Religion.isEmpty()){
                normalSelect(personalInformationOct.relegionE, Religion);
            }
            if(!Mobile.isEmpty()){
                setText(personalInformationOct.mobileE, Mobile);
            }
            if(!Email.isEmpty()){
                setText(personalInformationOct.emailE, Email);
            }
            if(!DirectManager.isEmpty()){
                setText(personalInformationOct.manager_code, DirectManager);
                personalInformationOct.manager_code.sendKeys(Keys.TAB);
                hold(500);
            }
            personalInformationOct.employeePicture.sendKeys(uploadRandomImage());

            setText(personalInformationOct.birth_date, BirthDate);

        }

        setLog("Personal Information"
                +" - Employee Code: "+employeeCode
                +" - Marital Status: "+MaritalStatus
                +" - Gender: "+Gender
                +" - Nationality: "+Nationality
                +" - Religion: "+Religion
                +" - Mobile: "+Mobile
                +" - Email: "+Email
                +" - Direct Manager: "+DirectManager
                +" - Birth Date: "+BirthDate);

    }

    public void personalInformationWithoutNext(String MaritalStatus, String Gender, String Nationality,
                                    String Religion, String Mobile, String Email,
                                    String DirectManager, String BirthDate){

        //employeeCode = employeeCodeGenerator();
        employeeCodeSetter(employeeCodeGenerator());
        goToFrame(frame);
        elementWaitAdvanced(By.id("employee_code"));
        empCode.clear();
        hold(200);
        setText(empCode, employeeCode, Keys.TAB);
        hold(200);

        setText(fNameEng, firstName);
        setText(sNameEng, secondName);
        setText(tNameEng, thirdName);
        setText(familyNameEng, lastName);
        setText(fNameAr, firstName);
        setText(sNameAr, secondName);
        setText(tNameAr, thirdName);
        setText(familyNameAr, lastName);

        selectOption(marital_StatusE, MaritalStatus);
        selectOption(sexE,Gender);
        if(!Nationality.isEmpty()){
            selectOption(nationalityE, Nationality);
        }
        if(!Religion.isEmpty()){
            selectOption(relegionE, Religion);
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
        setText(birth_date, BirthDate);
        employeePicture.sendKeys(uploadRandomImage());
        hold(300);

        setLog("Personal Information"
                +" - Marital Status: "+MaritalStatus
                +" - Gender: "+Gender
                +" - Nationality: "+Nationality
                +" - Religion: "+Religion
                +" - Mobile: "+Mobile
                +" - Email: "+Email
                +" - Direct Manager: "+DirectManager
                +" - Birth Date: "+BirthDate);

    }

    public void selectEmployeeFromAdvanceSearch(String employeeCode){

        hold(300);
        goToFrame(searchEmployeePopupFrame);
        hold(300);
        elementWaitAdvanced(By.id("textSearchInput"));
        hold(200);
        StringSelection stringSelection = new StringSelection(employeeCode);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        hold(500);
        advanceSearch_searchField.sendKeys(Keys.chord(Keys.CONTROL, "v"));
        hold(1000);
        clickOn(advanceSearch_clickOnEmployee.get(0));
        hold(300);

        setLog("select Employee From Advance Search");

    }

    public void personalInformationAddDirectManagerFromSearch(String MaritalStatus, String Gender, String Nationality,
                                               String Religion, String Mobile, String Email,
                                               String DirectManager, String BirthDate){

        goToFrame(frame);
        elementWaitAdvanced(By.id("employee_code"));
        employeeCode = empCode.getAttribute("value");

        setText(fNameEng, firstName);
        setText(sNameEng, secondName);
        setText(tNameEng, thirdName);
        setText(familyNameEng, lastName);
        setText(fNameAr, firstName);
        setText(sNameAr, secondName);
        setText(tNameAr, thirdName);
        setText(familyNameAr, lastName);

        selectOption(marital_StatusE, MaritalStatus);
        selectOption(sexE,Gender);
        if(!Nationality.isEmpty()){
            selectOption(nationalityE, Nationality);
        }
        if(!Religion.isEmpty()){
            selectOption(relegionE, Religion);
        }
        if(!Mobile.isEmpty()){
            setText(mobileE, Mobile);
        }
        if(!Email.isEmpty()){
            setText(emailE, Email);
        }
        clickOn(searchBtnDirectManager);
        hold(500);
        selectEmployeeFromAdvanceSearch(DirectManager);
        hold(500);
        driver.switchTo().parentFrame();
        hold(400);
        setText(birth_date, BirthDate);
        employeePicture.sendKeys(uploadRandomImage());
        hold(300);

        setLog("Personal Information"
                +" - Marital Status: "+MaritalStatus
                +" - Gender: "+Gender
                +" - Nationality: "+Nationality
                +" - Religion: "+Religion
                +" - Mobile: "+Mobile
                +" - Email: "+Email
                +" - Direct Manager: "+DirectManager
                +" - Birth Date: "+BirthDate);

    }

    public void employmentInformation(String site, String department, String section, String division, String unit,
                                      String subSection, String subDivision, String subUnit, String office, String team,
                                      String category1, String category2, String category3, String contractType, String classification,
                                      String degree, String step, String position, String hiringDate, String employmentDate,
                                      String workType, String project, String currency, String contractStartDate){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            elementWaitAdvanced(By.id("select2-site_1-container"));
            if(site.equalsIgnoreCase("Zarqa")){
                selectOption(siteE, site, Keys.ARROW_DOWN);
            }else{
                selectOption(siteE, site);
            }
            selectOption(departmentE, department);
            selectOption(sectionE, section);
            if(!division.isEmpty()){
                selectOption(divisionE, division);
            }
            if(!unit.isEmpty()){
                selectOption(unitsE, unit);
            }
            if(!subSection.isEmpty()){
                selectOption(sub_sectionE, subSection);
            }
            if(!subDivision.isEmpty()){
                selectOption(sub_divisionE, subDivision);
            }
            if(!subUnit.isEmpty()){
                selectOption(sub_unitE, subUnit);
            }
            if(!office.isEmpty()){
                selectOption(officeE, office);
            }
            if(!team.isEmpty()){
                selectOption(teamE, team);
            }
            if(!classification.isEmpty()){
                selectOption(classificationE, classification);
            }
            if(!degree.isEmpty()){
                selectOption(degreeE, degree);
            }
            if(!step.isEmpty()){
                setText(stepE, step);
            }
            scrollToElement(hiring_dateE);
            selectOption(positionE, position);
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
                selectOption(work_typeE, workType);
            }
            if(!project.isEmpty()){
                selectOption(projectE, project);
            }
            if(!currency.isEmpty()){
                selectOption(currencyE, currency);
            }
            if(!category1.isEmpty()){
                selectOption(category1E, category1);
            }
            if(!category2.isEmpty()){
                selectOption(category2E, category2);
            }
            if(!category3.isEmpty()){
                selectOption(category3E, category3);
            }
            if(!contractType.isEmpty()){
                selectOption(contract_typeE, contractType);
                if(contractType.contains("Employment")){
                    waitTextPresentInElementValue(contract_start_dateE, employmentDate);
                }else{
                    waitTextPresentInElementValue(contract_start_dateE, hiringDate);
                }
            }

            //// check if 'Contract Start Date' is not empty
            if(!contractStartDate.isEmpty()){
                hold(1000);
                contract_start_dateE.clear();
                hold(300);
                setText(contract_start_dateE, contractStartDate);
            }

            scrollToElement(empCode); /// Scroll up to the 'Employee Code' element to see the 'Save' button in the screen
            clickOn(saveBtn);
            waitTextAppear(activeEmployee_aug, "Active Employee");
            empName = FirstAndLastName.getText().trim();
            employeeCode = empCode.getAttribute("value");

        }else {

            personalInformationOct = new PersonalInformation_OCT();

            elementWaitAdvanced(By.id("site_1"));
            normalSelect(personalInformationOct.siteE, site);
            normalSelect(personalInformationOct.departmentE, department);
            normalSelect(personalInformationOct.sectionE, section);
            if(!division.isEmpty()){
                normalSelect(personalInformationOct.divisionE, division);
            }
            if(!unit.isEmpty()){
                normalSelect(personalInformationOct.unitsE, unit);
            }
            if(!subSection.isEmpty()){
                normalSelect(personalInformationOct.sub_sectionE, subSection);
            }
            if(!subDivision.isEmpty()){
                normalSelect(personalInformationOct.sub_divisionE, subDivision);
            }
            if(!subUnit.isEmpty()){
                normalSelect(personalInformationOct.sub_unitE, subUnit);
            }
            if(!office.isEmpty()){
                normalSelect(personalInformationOct.officeE, office);
            }
            if(!team.isEmpty()){
                normalSelect(personalInformationOct.teamE, team);
            }
            if(!classification.isEmpty()){
                normalSelect(personalInformationOct.classificationE, classification);
            }
            if(!degree.isEmpty()){
                normalSelect(personalInformationOct.degreeE, degree);
            }
            if(!step.isEmpty()){
                setText(personalInformationOct.stepE, step);
            }
            normalSelect(personalInformationOct.positionE, position);
            if(!hiringDate.isEmpty()){
                personalInformationOct.hiring_dateE.clear();
                hold(300);
                setText(personalInformationOct.hiring_dateE, hiringDate);
                personalInformationOct.hiring_dateE.sendKeys(Keys.TAB);
            }
            if(!employmentDate.isEmpty()){
                setText(personalInformationOct.moving_dateE, employmentDate);
            }
            if(!workType.isEmpty()){
                normalSelect(personalInformationOct.work_typeE, workType);
            }
            if(!project.isEmpty()){
                normalSelect(personalInformationOct.projectE, project);
            }
            if(!currency.isEmpty()){
                normalSelect(personalInformationOct.currencyE, currency);
            }
            if(!category1.isEmpty()){
                normalSelect(personalInformationOct.category1E, category1);
            }
            if(!category2.isEmpty()){
                normalSelect(personalInformationOct.category2E, category2);
            }
            if(!category3.isEmpty()){
                normalSelect(personalInformationOct.category3E, category3);
            }
            if(!contractType.isEmpty()){
                normalSelect(personalInformationOct.contract_typeE, contractType);
                hold(300);
            }

            //// check if 'Contract Start Date' is not empty
            if(!contractStartDate.isEmpty()){
                hold(1500);
                personalInformationOct.contract_start_dateE.clear();
                hold(300);
                personalInformationOct.contract_start_dateE.clear();
                hold(500);
                setText(personalInformationOct.contract_start_dateE, contractStartDate);
            }

            hold(500);
            closeIFrame();
            goToFrame(personalInformationOct.menuFrame);
            hold(500);
            clickOn(personalInformationOct.menuSave);
            closeIFrame();
            goToFrame(frame);
            hold(300);
            elementWait(familyNameEng);
            waitTextAppear(activeEmployee_oct, "Active Employee");

            try {
                empName = personalInformationOct.fNameEng.getAttribute("value") + " " + personalInformationOct.sNameEng.getAttribute("value") + " " + personalInformationOct.tNameEng.getAttribute("value") + " " + personalInformationOct.familyNameEng.getAttribute("value");
            }catch (Exception e){
                empName = driver.findElement(By.xpath("(//label[@class = 'empNameAndStatus'])[1]")).getText().trim();
            }

            employeeCode = empCode.getAttribute("value");

        }

        setLog("Employment Information"
        +" - Site: "+site
        +" - Department: "+department
        +" - Section: "+section
        +" - Division: "+division
        +" - Unit: "+unit
        +" - Sub Section: "+subSection
        +" - Sub Division: "+subDivision
        +" - Sub Unit: "+subUnit
        +" - Office: "+office
        +" - Team: "+team
        +" - Category1: "+category1
        +" - Category2: "+category2
        +" - Category3: "+category3
        +" - Contract Type: "+contractType
        +" - Classification: "+classification
        +" - Degree: "+degree
        +" - Step: "+step
        +" - Position: "+position
        +" - Hiring Date: "+hiringDate
        +" - Employment Date: "+employmentDate
        +" - Work Type: "+workType
        +" - Project: "+project
        +" - Currency: "+currency
        +" - Contract Start Date: "+contractStartDate);

    }

    public void employmentInformationWithoutSave(String site, String department, String section, String division, String unit,
                                      String subSection, String subDivision, String subUnit, String office, String team,
                                      String category1, String category2, String category3, String contractType, String classification,
                                      String degree, String step, String position, String hiringDate, String employmentDate,
                                      String workType, String project, String currency, String contractStartDate){

        elementWaitAdvanced(By.id("select2-site_1-container"));
        selectOption(siteE, site);
        selectOption(departmentE, department);
        selectOption(sectionE, section);
        if(!division.isEmpty()){
            selectOption(divisionE, division);
        }
        if(!unit.isEmpty()){
            selectOption(unitsE, unit);
        }
        if(!subSection.isEmpty()){
            selectOption(sub_sectionE, subSection);
        }
        if(!subDivision.isEmpty()){
            selectOption(sub_divisionE, subDivision);
        }
        if(!subUnit.isEmpty()){
            selectOption(sub_unitE, subUnit);
        }
        if(!office.isEmpty()){
            selectOption(officeE, office);
        }
        if(!team.isEmpty()){
            selectOption(teamE, team);
        }
        if(!classification.isEmpty()){
            selectOption(classificationE, classification);
        }
        if(!degree.isEmpty()){
            selectOption(degreeE, degree);
        }
        if(!step.isEmpty()){
            setText(stepE, step);
        }
        selectOption(positionE, position);
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
            selectOption(work_typeE, workType);
        }
        if(!project.isEmpty()){
            selectOption(projectE, project);
        }
        if(!currency.isEmpty()){
            selectOption(currencyE, currency);
        }
        if(!category1.isEmpty()){
            selectOption(category1E, category1);
        }
        if(!category2.isEmpty()){
            selectOption(category2E, category2);
        }
        if(!category3.isEmpty()){
            selectOption(category3E, category3);
        }
        if(!contractType.isEmpty()){
            selectOption(contract_typeE, contractType);
            hold(1500);
        }

        //// check if 'Contract Start Date' is not empty
        if(!contractStartDate.isEmpty()){
            hold(1000);
            contract_start_dateE.clear();
            hold(500);
            setText(contract_start_dateE, contractStartDate);
        }

        setLog("Employment Information"
                +" - Site: "+site
                +" - Department: "+department
                +" - Section: "+section
                +" - Division: "+division
                +" - Unit: "+unit
                +" - Sub Section: "+subSection
                +" - Sub Division: "+subDivision
                +" - Sub Unit: "+subUnit
                +" - Office: "+office
                +" - Team: "+team
                +" - Category1: "+category1
                +" - Category2: "+category2
                +" - Category3: "+category3
                +" - Contract Type: "+contractType
                +" - Classification: "+classification
                +" - Degree: "+degree
                +" - Step: "+step
                +" - Position: "+position
                +" - Hiring Date: "+hiringDate
                +" - Employment Date: "+employmentDate
                +" - Work Type: "+workType
                +" - Project: "+project
                +" - Currency: "+currency
                +" - Contract Start Date: "+contractStartDate);

    }

    public void goToPersonal(){
        hold(500);
        clickOn(backToPersonalInformationTab);
        elementWaitAdvanced(By.id("first_name_e"));
        hold(300);

        setLog("Go To Personal");
    }
    public void goToEmployment(){
        hold(500);
        clickOn(backToEmploymentInformationTab);
        elementWaitAdvanced(By.id("select2-site_1-container"));
        hold(300);

        setLog("Go To Employment");
    }

    public void goToNextEmployee(){
        hold(500);
        clickOn(nextEmp);
        hold(300);

        setLog("Go To Next Employee");
    }

    public void goToPreviousEmployee(){
        hold(500);
        clickOn(previousEmp);
        hold(300);

        setLog("Go To Previous Employee");
    }

    public void personalAndEmploymentInfo(String MaritalStatus, String Gender, String Nationality,
                                          String Religion, String Mobile, String Email, String DirectManager, String BirthDate,
                                          String site, String department, String section, String division, String unit,
                                          String subSection, String subDivision, String subUnit, String office, String team,
                                          String category1, String category2, String category3, String contractType, String classification,
                                          String degree, String step, String position, String hiringDate, String employmentDate,
                                          String workType, String project, String currency, String contractStartDate){

        ///////// Fill Personal Page //////////
        personalInformation(MaritalStatus, Gender, Nationality,
                Religion, Mobile, Email, DirectManager, BirthDate);

        elementWaitAdvanced(By.id("select2-site_1-container"));

        ///////// Fill Employment Page //////////
        employmentInformation(site, department, section, division, unit, subSection, subDivision, subUnit, office,
                team, category1, category2, category3, contractType, classification, degree, step, position, hiringDate,
                employmentDate, workType, project, currency, contractStartDate);

    }

    public void createNewEmployee(String MaritalStatus, String Gender, String Nationality,
                                  String Religion, String Mobile, String Email, String DirectManager, String BirthDate,
                                  String site, String department, String section, String division, String unit,
                                  String subSection, String subDivision, String subUnit, String office, String team,
                                  String category1, String category2, String category3, String contractType, String classification,
                                  String degree, String step, String position, String hiringDate, String employmentDate,
                                  String workType, String project, String currency, String contractStartDate){

        personalInformation(MaritalStatus, Gender, Nationality,
                Religion, Mobile, Email, DirectManager, BirthDate);

        employmentInformation(site, department, section, division, unit, subSection, subDivision, subUnit, office,
                team, category1, category2, category3, contractType, classification, degree, step, position, hiringDate,
                employmentDate, workType, project, currency, contractStartDate);

        closeIFrame();

    }

    public void goToEmployeeByCode(String employeeCode){

        elementWaitAdvanced(By.id("body_frame"));
        goToFrame(frame);
        hold(500);
        elementWaitAdvanced(By.id("employee_code"));
        hold(300);
        empCode.clear();
        hold(500);
        setText(empCode, employeeCode);
        hold(300);
        setText(empCode, Keys.TAB);
        hold(300);

        setLog("Go To Employee By Code: "+employeeCode);

    }

    public void goToEmployeeByCode_autoSerial(String employeeCode){

        elementWaitAdvanced(By.id("body_frame"));
        goToFrame(frame);
        hold(500);
        elementWaitAdvanced(By.id("employee_code"));
        hold(300);
        Actions actions = new Actions(driver);
        actions.doubleClick(empCode).build().perform();
        hold(100);
        setText(empCode, employeeCode);
        hold(300);
        setText(empCode, Keys.TAB);
        hold(500);

        setLog("Go To Employee By Code _autoSerial: "+employeeCode);

    }

    public void marriedEmployeeWithoutSpouse(){

        ///////// Fill Personal Page //////////
        personalInformation("Married", "Male", "",
                "", "", "", "", "01/01/1990");

        ///////// Fill Employment Page //////////
        employmentInformation("New Zarqa", "Quality", "Quality Control",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "Software Test Engineer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        hold(500);
        clickOn(childrenPage);
        elementWait(firstNameChildEn);

        Select spouse = new Select(checkSpouseList);
        List<WebElement> spouseList = spouse.getOptions();

        implicitWaitChanging(500);

        softAssert.assertEquals(spouseList.size(), 1, "- The spouse list contain more than one option");
        softAssert.assertEquals(checkSpouseList.getText(), "None", "- Issue In Spouse List, it should be retrieve 'None' option");
        softAssert.assertEquals(checkSaveButtonInChildren.size(),0, "- Save Button is appear, This is a BUG");

        softAssert.assertAll();

    }

    public void spousePageForSingleEmployee(){

        ///////// Fill Personal Page //////////
        personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");

        ///////// Fill Employment Page //////////
        employmentInformation("New Zarqa", "Quality", "Quality Control",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "Software Test Engineer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        hold(500);
        clickOn(spousePage);
        elementWait(firstNameSpouse);

        implicitWaitChanging(100);

        softAssert.assertEquals(checkAddButtonInSpouse.size(),0, "- Add Button is appear, This is a BUG");
        softAssert.assertEquals(checkSaveButtonInSpouse.size(),0, "- Save Button is appear, This is a BUG");

        softAssert.assertAll();
    }

    public void minimumAgeForHiringCitizenPass(){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        ///////////////// Citizen Setup ////////////////
        systemParameters = new SystemParameters();
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "22", "25",
                "40", "35");
        hold(300);
        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1996");

        hold(300);
        softAssert.assertTrue(siteE.isDisplayed(), "- There is Issue, should be continue to employment page");

        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "No Constraint", "No Constraint",
                "No Constraint", "No Constraint");
        softAssert.assertAll();

    }

    public void minimumAgeForHiringNotCitizenPass(){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        ///////////////// Citizen Setup ////////////////
        systemParameters = new SystemParameters();
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "22", "25",
                "40", "35");
        hold(300);
        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformation("Single", "Male", "Egyptian",
                "", "", "", "", "01/01/1993");

        hold(300);
        softAssert.assertTrue(siteE.isDisplayed(), "- There is Issue, should be continue to employment page");

        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "No Constraint", "No Constraint",
                "No Constraint", "No Constraint");
        softAssert.assertAll();
    }

    public void minimumAgeForHiringCitizenValidation(){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        ///////////////// Citizen Setup ////////////////
        systemParameters = new SystemParameters();
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "22", "25",
                "40", "35");
        hold(300);
        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/2007");

        hold(300);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Birth Date Can Not Be After The Minimum Age For Hiring!");
        clickOn(alertOkBtn);
        hold(200);
        clickOn(personalAndEmploymentTab);
        hold(300);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "No Constraint", "No Constraint",
                "No Constraint", "No Constraint");
        softAssert.assertAll();
    }

    public void minimumAgeForHiringNotCitizenValidation(){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        ///////////////// Citizen Setup ////////////////
        systemParameters = new SystemParameters();
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "22", "25",
                "40", "35");
        hold(300);
        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformation("Single", "Male", "Egyptian",
                "", "", "", "", "01/01/2007");

        hold(300);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Birth Date Can Not Be After The Minimum Age For Hiring!");
        clickOn(alertOkBtn);
        hold(200);
        clickOn(personalAndEmploymentTab);
        hold(300);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "No Constraint", "No Constraint",
                "No Constraint", "No Constraint");
        softAssert.assertAll();
    }

    public void maximumAgeForHiringCitizenPass(){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        ///////////////// Citizen Setup ////////////////
        systemParameters = new SystemParameters();
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "22", "25",
                "40", "35");
        hold(300);
        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1996");

        hold(300);
        softAssert.assertTrue(siteE.isDisplayed(), "- There is Issue, should be continue to employment page");

        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "No Constraint", "No Constraint",
                "No Constraint", "No Constraint");
        softAssert.assertAll();
    }

    public void maximumAgeForHiringCitizenValidation(){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        ///////////////// Citizen Setup ////////////////
        systemParameters = new SystemParameters();
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "22", "25",
                "40", "35");
        hold(300);
        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1960");

        hold(300);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Birth Date Can Not Be Before The Maximum Age For Hiring!");
        softAssert.assertTrue(birth_date.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        clickOn(alertOkBtn);
        hold(200);
        clickOn(personalAndEmploymentTab);
        hold(300);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "No Constraint", "No Constraint",
                "No Constraint", "No Constraint");
        softAssert.assertAll();
    }

    public void maximumAgeForHiringNotCitizenPass(){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        ///////////////// Citizen Setup ////////////////
        systemParameters = new SystemParameters();
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "22", "25",
                "40", "35");
        hold(300);
        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformation("Single", "Male", "Egyptian",
                "", "", "", "", "01/01/1991");

        hold(300);
        softAssert.assertTrue(siteE.isDisplayed(), "- There is Issue, should be continue to employment page");

        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "No Constraint", "No Constraint",
                "No Constraint", "No Constraint");
        softAssert.assertAll();
    }

    public void maximumAgeForHiringNotCitizenValidation(){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        ///////////////// Citizen Setup ////////////////
        systemParameters = new SystemParameters();
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "22", "25",
                "40", "35");
        hold(300);
        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformation("Single", "Male", "Egyptian",
                "", "", "", "", "01/01/1960");

        hold(500);
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Birth Date Can Not Be Before The Maximum Age For Hiring!");
        softAssert.assertTrue(birth_date.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        clickOn(alertOkBtn);
        hold(200);
        clickOn(personalAndEmploymentTab);
        hold(300);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters.minimumAgeForHiringCitizenSetup("Jordanian", "No Constraint", "No Constraint",
                "No Constraint", "No Constraint");
        softAssert.assertAll();
    }

    public void validateEmailWrongFormat(String wrongEmail){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformation("Single", "Male", "Jordanian",
                "", "", wrongEmail, "", "01/01/2007");

        hold(300);
        Assert.assertTrue(ValidateWrongEmail.isDisplayed(), "- There is Issue, should be this alert appear 'This Field Should Only Contain A Valid Email Address'");

    }

    public void validateEmailCorrectFormat(String correctEmail){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformation("Single", "Male", "Jordanian",
                "", "", correctEmail, "", "01/01/2007");

        hold(300);
        Assert.assertTrue(siteE.isDisplayed(), "- There is Issue, should be SAVE and continue to employment page");

    }

    public void addDirectManagerFromSearchIcon(String directManager){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformationAddDirectManagerFromSearch("Single", "Male", "Jordanian",
                "", "", "", directManager, "01/01/1989");

        hold(300);
        //softAssert.assertEquals(directManagerName.getAttribute("value").trim(),"ab00000092first ab00000092last", "-Issue - Direct Manager Name Not Appear");
        Assert.assertFalse(directManagerName.getAttribute("value").trim().isEmpty(), "-Issue - Direct Manager Name Not Appear");

    }

    public void addInactiveDirectManager(String directManager){

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformationWithoutNext("Single", "Male", "Jordanian",
                "", "", "", directManager, "01/01/1989");

        hold(300);
        Assert.assertEquals(directManagerName.getAttribute("value").trim(),"", "-Issue - Direct Manager Name Appear, Should be NOT appear because the manager is terminated");

    }

    public void addDirectManagerFromOtherBranch(String directManager, int dataBaseFlag){

        if(dataBaseFlag > 1 || dataBaseFlag < 0){
            dataBaseFlag = 1;
        }

        sqlQuery("update adm_company set is_inter_branch="+dataBaseFlag);

        ////////////////// login Page //////////////////
        login = new Login();
        login.staticLogin();

        ////////////////// Enter Module name, such as "MenaPAY" OR "MenaHR" //////////////////
        menaModules = new MenaModules();
        menaModules.menaPAY();

        ////////////////// Enter Tab and Sub Tab Name from MENU //////////////////
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformationWithoutNext("Single", "Male", "Jordanian",
                "", "", "", directManager, "01/01/1989");

        hold(300);

        if(dataBaseFlag == 0){
            Assert.assertEquals(directManagerName.getAttribute("value").trim(),"", "-Issue - Direct Manager Name Appear, Should be NOT appear because the manager from another branch and DB flag = "+dataBaseFlag);
        }else{
            Assert.assertFalse(directManagerName.getAttribute("value").trim().isEmpty(), "-Issue - Direct Manager Name Not Appear, Should be appear normally because the DB flag = "+dataBaseFlag);
        }

    }

    public void addProjectManagerAndIsDeterminedAccordingTo(String projectManagerTypes, boolean deleteAfterSave){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        systemParameters = new SystemParameters();
        systemParameters.changeProjectManagerIsDeterminedAccordingTo(projectManagerTypes);
        hold(500);
        mainMenu.mainMenu("Employees", "Personnel Information");

        ///////// Fill Personal Page with Nationality PASS 'Jordanian' //////////
        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        Assert.assertTrue(siteE.isDisplayed(), "Failed go to Employment Information");

        ///////// Fill Employment Page //////////

        employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(backToPersonalInformationTab);
        elementWait(fNameEng);
        hold(300);
        clickOn(projectManagerBtn);
        hold(500);
        goToFrame(iframePopup);
        //softAssert.assertTrue(checkProjectManagerBox.isDisplayed(), "- Issue, Project Manager Box Not Appear");

        if(projectManagerTypes.equals("Project")){
            clickOn(projectManagerNew);
            hold(500);
            softAssert.assertTrue(firstProject.isDisplayed(), "- Issue, First dropdown list not appear");
            selectOption(firstProject, "Project 1");
            clickOn(projectManagerSave);
            hold(300);
            clickOn(projectManagerNew);
            hold(300);
            softAssert.assertTrue(secondProject.isDisplayed(), "- Issue, Second dropdown list not appear");
            selectOption(secondProject, "Project 2");
            clickOn(projectManagerSave);
            hold(300);
            clickOn(projectManagerNew);
            hold(300);
            softAssert.assertTrue(thirdProject.isDisplayed(), "- Issue, Third dropdown list not appear");
            selectOption(thirdProject, "Project 3");
            clickOn(projectManagerSave);
            hold(300);
            clickOn(projectManagerCloseBtn);
            driver.switchTo().defaultContent();

            mainMenu.mainMenu("Settings", "System Parameters");
            systemParameters.checkProjectManagerIsDisabled();
            hold(300);
            mainMenu.mainMenu("Employees", "Personnel Information");
            goToFrame(frame);
            elementWait(empCode);
            empCode.clear();
            hold(300);
            setText(empCode, employeeCode);
            hold(300);
            empCode.sendKeys(Keys.TAB);
            elementWait(CheckActiveEmployee);

            if(deleteAfterSave){
                clickOn(projectManagerBtn);
                hold(500);
                goToFrame(iframePopup);

                for(int i = 0 ; i <= 2 ; i++){
                    elementWait(checkProjectManagerBox);
                    clickOn(checkboxFirstProjectManager);
                    hold(300);
                    clickOn(projectManagerDelete);
                    hold(300);
                }

                clickOn(projectManagerCloseBtn);
                driver.switchTo().defaultContent();
                goToFrame(frame);
                clickOn(projectManagerBtn);
                hold(300);
                goToFrame(iframePopup);
                softAssert.assertEquals(driver.findElement(By.id("oDiv")).getText().trim(),"", "- There is still a record that has not been deleted!");
            }

            driver.switchTo().defaultContent();
            goToFrame(frame);

            softAssert.assertAll();
        } else if (projectManagerTypes.equals("Activity")) {
            clickOn(projectManagerNew);
            hold(500);
            softAssert.assertTrue(firstProject.isDisplayed(), "- Issue, First dropdown list not appear");
            selectOption(firstProject, "Project 1");
            selectOption(firstActivity, "Activity 1");
            clickOn(projectManagerSave);
            hold(300);
            clickOn(projectManagerNew);
            hold(500);
            softAssert.assertTrue(secondProject.isDisplayed(), "- Issue, Second dropdown list not appear");
            selectOption(secondProject, "Project 2");
            selectOption(secondActivity, "Activity 2");
            clickOn(projectManagerSave);
            hold(300);
            clickOn(projectManagerCloseBtn);
            driver.switchTo().defaultContent();

            mainMenu.mainMenu("Settings", "System Parameters");
            systemParameters.checkProjectManagerIsDisabled();
            hold(300);
            mainMenu.mainMenu("Employees", "Personnel Information");
            goToFrame(frame);
            elementWait(empCode);
            empCode.clear();
            hold(300);
            setText(empCode, employeeCode);
            hold(200);
            empCode.sendKeys(Keys.TAB);
            elementWait(CheckActiveEmployee);

            if(deleteAfterSave){
                clickOn(projectManagerBtn);
                hold(500);
                goToFrame(iframePopup);

                for(int i = 0 ; i <= 1 ; i++){
                    elementWait(checkProjectManagerBox);
                    clickOn(checkboxFirstProjectManager);
                    hold(300);
                    clickOn(projectManagerDelete);
                    hold(500);
                }

                clickOn(projectManagerCloseBtn);
                driver.switchTo().defaultContent();
                goToFrame(frame);
                clickOn(projectManagerBtn);
                hold(500);
                goToFrame(iframePopup);
                softAssert.assertEquals(driver.findElement(By.id("oDiv")).getText().trim(),"", "- There is still a record that has not been deleted!");
            }

            driver.switchTo().defaultContent();
            goToFrame(frame);

            softAssert.assertAll();

        } else if (projectManagerTypes.equals("Job Card")) {
            clickOn(projectManagerNew);
            hold(500);
            softAssert.assertTrue(firstProject.isDisplayed(), "- Issue, First dropdown list not appear");
            selectOption(firstProject, "Project 1");
            selectOption(firstActivity, "Activity 1");
            selectOption(firstJobCard, "Job Card 1");
            clickOn(projectManagerSave);
            hold(300);
            clickOn(projectManagerNew);
            hold(500);
            softAssert.assertTrue(secondProject.isDisplayed(), "- Issue, Second dropdown list not appear");
            selectOption(secondProject, "Project 2");
            selectOption(secondActivity, "Activity 2");
            selectOption(secondJobCard, "Job Card 2");
            clickOn(projectManagerSave);
            hold(300);
            clickOn(projectManagerCloseBtn);
            driver.switchTo().defaultContent();

            mainMenu.mainMenu("Settings", "System Parameters");
            systemParameters.checkProjectManagerIsDisabled();
            hold(300);
            mainMenu.mainMenu("Employees", "Personnel Information");
            goToFrame(frame);
            elementWait(empCode);
            empCode.clear();
            hold(300);
            setText(empCode, employeeCode);
            hold(200);
            empCode.sendKeys(Keys.TAB);
            elementWait(CheckActiveEmployee);

            if(deleteAfterSave){
                clickOn(projectManagerBtn);
                hold(500);
                goToFrame(iframePopup);

                for(int i = 0 ; i <= 1 ; i++){
                    elementWait(checkProjectManagerBox);
                    clickOn(checkboxFirstProjectManager);
                    hold(300);
                    clickOn(projectManagerDelete);
                    hold(500);
                }

                clickOn(projectManagerCloseBtn);
                driver.switchTo().defaultContent();
                goToFrame(frame);
                clickOn(projectManagerBtn);
                hold(500);
                goToFrame(iframePopup);
                softAssert.assertEquals(driver.findElement(By.id("oDiv")).getText().trim(),"", "- There is still a record that has not been deleted!");
            }

            driver.switchTo().defaultContent();
            goToFrame(frame);

            softAssert.assertAll();
        }

    }

    public void uploadPhotoNotAllowedUser(){

        login = new Login();
        login.ali5User();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        //employeeCode = employeeCodeGenerator();
        employeeCodeSetter(employeeCodeGenerator());
        System.out.println("Employee Code: "+employeeCode);
        goToFrame(frame);
        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employeeCode, Keys.TAB);

        setText(fNameEng, employeeCode+"first");
        setText(sNameEng, employeeCode);
        setText(tNameEng, employeeCode);
        setText(familyNameEng, employeeCode+"last");
        setText(fNameAr, employeeCode+"firstAr");
        setText(sNameAr, employeeCode);
        setText(tNameAr, employeeCode);
        setText(familyNameAr, employeeCode+"lastAr");

        selectOption(marital_StatusE, "Single");
        selectOption(sexE,"Male");
        setText(birth_date, "01/01/1990");
        employeePicture.sendKeys(uploadRandomImage());
        hold(300);
        scrollToElement(empCode);
        clickOn(nextButton);
        hold(300);
        elementWaitAdvanced(By.id("select2-site_1-container"));
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Do Not Have Permission To Upload Files!");
        hold(300);
        elementWaitAdvanced(By.id("btok"));
        Actions action = new Actions(driver);
        action.moveToElement(alertOkBtn).click().perform();
        hold(300);
        action.moveToElement(alertOkBtn).click().perform();
        hold(300);
        clickOn(previousButton);
        hold(300);
        elementWaitAdvanced(By.id("first_name_e"));
        softAssert.assertTrue(imgPath.getAttribute("src").contains("Image/import.svg"));
        softAssert.assertTrue(checkElementIfNotAppear(checkImgDeleteBtn), "- Delete Button is still appear");
        softAssert.assertAll();
    }

    public void changePhotoPersonalInformation(String wrongExtinction){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getAttribute("value");

        closeIFrame();
        mainMenu.mainMenu("Employees","Personnel Information");
        goToEmployeeByCode(employeeCode);

        scrollToElement(imgPath);

        if(imgPath.getAttribute("src").contains("Image/import.svg")){
            softAssert.assertTrue(checkElementIfNotAppear(checkImgDeleteBtn), "- Delete Button is still appear");
        }else{
            hold(300);
            clickOn(deletePhoto);
            hold(300);
            clickOn(okBtnDeletePhoto);
        }

        if(wrongExtinction.equals("doc")){
            employeePicture.sendKeys(uploadDocFile());
            hold(300);
            scrollToElement(empCode);
            clickOn(saveBtn);
            implicitWaitChanging(10000);
            hold(500);
            elementWait(checkExtension);
            Assert.assertTrue(checkExtension.isDisplayed(), "- Issue, the validation NOT Appear");
            hold(500);
            clickOn(alertOkBtn);
        } else if (wrongExtinction.equals("waf")) {
            employeePicture.sendKeys(uploadFileToTestWaf());
        } else {
            employeePicture.sendKeys(uploadRandomImage());
            hold(300);
            scrollToElement(empCode);
            clickOn(saveBtn);
            hold(300);
            softAssert.assertEquals(VerifyImage(checkPicture), 200, "Issue, the image is broken");
        }
        softAssert.assertAll();
    }

    public void firstAndLastNameCheckSpaces(String firstOrLast){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        //employeeCode = employeeCodeGenerator();
        employeeCodeSetter(employeeCodeGenerator());
        System.out.println("Employee Code: "+employeeCode);
        goToFrame(frame);
        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employeeCode, Keys.TAB);

        if(firstOrLast.equalsIgnoreCase("first")){
            setText(fNameEng, employeeCode+" first");
            setText(familyNameEng, employeeCode+"last");
            setText(fNameAr, employeeCode+" firstAr");
            setText(familyNameAr, employeeCode+"lastAr");
        } else if (firstOrLast.equalsIgnoreCase("last")) {
            setText(fNameEng, employeeCode+"first");
            setText(familyNameEng, employeeCode+" last");
            setText(fNameAr, employeeCode+"firstAr");
            setText(familyNameAr, employeeCode+" lastAr");
        } else {
            setText(fNameEng, employeeCode+" first");
            setText(familyNameEng, employeeCode+" last");
            setText(fNameAr, employeeCode+" firstAr");
            setText(familyNameAr, employeeCode+" lastAr");
        }

        selectOption(marital_StatusE, "Single");
        selectOption(sexE,"Male");
        selectOption(nationalityE, "Jordanian");
        selectOption(relegionE, "Islam");
        setText(birth_date, "01/01/1994");
        hold(300);
        scrollToElement(empCode);
        clickOn(nextButton);
        hold(500);
        elementWait(siteE);

        if(firstOrLast.equalsIgnoreCase("first")){
            Assert.assertTrue(siteE.isDisplayed(), "- Issue when add First name with spaces");
        } else if (firstOrLast.equalsIgnoreCase("last")) {
            Assert.assertTrue(siteE.isDisplayed(), "- Issue when add Last name with spaces");
        } else {
            Assert.assertTrue(siteE.isDisplayed(), "- Issue when add first or last name with spaces");
        }

    }

    public void validateHijriDateToBirthDate(String hijriDate){
        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        goToFrame(frame);
        hold(500);
        elementWait(empCode);
        hold(300);
        scrollToElement(birth_date);
        clickOn(hijriConvertBtn);
        hold(500);
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
        scrollToElement(birth_date);

            int day = Integer.parseInt(hijriDate.substring(0,2));
            int month = Integer.parseInt(hijriDate.substring(3,5));
            int year = Integer.parseInt(hijriDate.substring(6,10));

            HijrahDate hd = HijrahChronology.INSTANCE.date(HijrahEra.AH, year, month, day);
            LocalDate ld = LocalDate.from(hd);
            //ld = ld.minusDays(1); //// To minus 1 Day, This is how the MenaITech system works
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String afterConvert = ld.format(formatters);
            //System.out.println(afterConvert);
            softAssert.assertEquals(birth_date.getAttribute("value"), afterConvert, "- Incorrect Date after convert!");

            softAssert.assertAll();
    }

    public void classificationFilters(String classification, String degree, String step){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getAttribute("value");
        closeIFrame();

        mainMenu.mainMenu("Employees","Personnel Information");
        goToEmployeeByCode(employeeCode);

        clickOn(backToEmploymentInformationTab);
        hold(500);
        elementWait(siteE);
        scrollToElement(hiring_dateE);
        selectOption(classificationE, classification);
        selectOption(degreeE, degree);
        hold(100);
        stepE.clear();
        hold(200);
        setText(stepE, step);
        hold(300);
        scrollToElement(empCode); /// Scroll up to the 'Employee Code' element to see the 'Save' button in the screen
        clickOn(saveBtn);
        hold(300);
    }

    public void hiringDateBeforeBirthDate(String hiringDate){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getAttribute("value");
        closeIFrame();

        mainMenu.mainMenu("Employees","Personnel Information");
        goToEmployeeByCode(employeeCode);

        clickOn(backToEmploymentInformationTab);
        hold(500);
        elementWait(siteE);
        scrollToElement(hiring_dateE);
        hold(300);
        hiring_dateE.clear();
        hold(300);
        setText(hiring_dateE, hiringDate);
        hold(300);
        moving_dateE.clear();
        hold(400);
        scrollToElement(empCode); /// Scroll up to the 'Employee Code' element to see the 'Save' button in the screen
        clickOn(saveBtn);
        hold(300);

    }

    public void employmentDateBeforeHiringDate(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        ///////// Fill Personal Page //////////
        personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");

        ///////// Fill Employment Page //////////
        employmentInformationWithoutSave("New Zarqa", "Quality", "Quality Control",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "Software Test Engineer", "01/01/2020",
                "10/02/2020", "", "", "", "");

        scrollToElement(empCode);
        hold(300);
        clickOn(saveBtn);
        hold(300);

    }

    public void contractTypeDate(String contractType, String hiringDate, String employmentDate){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        ///////// Fill Personal Page //////////
        personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");

        ///////// Fill Employment Page //////////
        employmentInformationWithoutSave("", "", "",
                "", "", "", "", "",
                "", "", "", "",  "",contractType,
                "", "", "", "", hiringDate,
                employmentDate, "", "", "", "");

        hold(500);

        DateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

        if(contractType.contains("5 Years") || contractType.equalsIgnoreCase("Contract Date - 5 Years Based On Hiring Date")){

            try {
                cal.setTime(newDate.parse(hiringDate));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            cal.add(Calendar.YEAR, 5); // to get previous year add -1
            cal.add(Calendar.DAY_OF_YEAR, -1);
            String contractDate = newDate.format(cal.getTime());

            hold(500);
            softAssert.assertEquals(contract_end_dateE.getAttribute("value"), contractDate, "- Incorrect Contract End Date - Type: "+contractType);

        } else if (contractType.contains("3 Years") || contractType.equalsIgnoreCase("Contract Date - 3 Years Based On Employment Date")) {

            try {
                cal.setTime(newDate.parse(employmentDate));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            cal.add(Calendar.YEAR, 3); // to get previous year add -1
            cal.add(Calendar.DAY_OF_YEAR, -1);
            String contractDate = newDate.format(cal.getTime());

            hold(500);
            softAssert.assertEquals(contract_end_dateE.getAttribute("value"), contractDate, "- Incorrect Contract End Date - Type: "+contractType);

        } else if (contractType.contains("Permanent Based On Hiring Date") || contractType.equalsIgnoreCase("Contract Date - Permanent Based On Hiring Date")) {

            hold(500);
            softAssert.assertEquals(contract_start_dateE.getAttribute("value"), hiringDate, "- Contract Start Date NOT Same Hiring Date");

        } else if (contractType.contains("Permanent Based On Employment Date") || contractType.equalsIgnoreCase("Contract Date - Permanent Based On Employment Date")) {

            hold(500);
            softAssert.assertEquals(contract_start_dateE.getAttribute("value"), employmentDate, "- Contract Start Date NOT Same Employment Date");

        }

        softAssert.assertAll();

    }

    public void positionRelatedToHierarchy(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        systemParameters = new SystemParameters();
        systemParameters.positionsAreRelatedToHierarchy(true);
        hold(300);

        mainMenu.mainMenu("Employees","Personnel Information");

        ///////// Fill Personal Page //////////
        personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");

        elementWait(siteE);
        hold(500);

        sqlQuery("update pay_setup set positions_related_department = 0 where branch_code='auto_a1' and company_code = 'automation'");

        selectOption(siteE, "New Zarqa");
        selectOption(departmentE, "Technical Support");
        selectOption(sectionE, "Technical Support Section");
        selectOption(divisionE, "Technical Support Division");
        selectOption(unitsE, "Technical Support Unit");
        selectOption(sub_sectionE, "Technical Support Sub Section");
        selectOption(sub_divisionE, "Technical Support Sub Division");
        selectOption(sub_unitE, "Technical Support Sub Unit");
        selectOption(officeE, "Technical Support Office");
        selectOption(teamE, "Technical Support Team");
        Select position = new Select(positionSelect);
        hold(300);

        softAssert.assertEquals(position.getOptions().size(), 2, "Issue in select options size");
        softAssert.assertEquals(position.getOptions().get(1).getText(), "Technical Support Position");
        softAssert.assertAll();


    }

    public void hierarchyFilters(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");

        elementWait(siteE);
        hold(500);
        selectOption(departmentE, "Quality");
        selectOption(sectionE, "Quality Control");
        selectOption(divisionE, "Quality Division");
        selectOption(unitsE, "Quality Unit");
        selectOption(sub_sectionE, "Quality Sub Section");
        selectOption(sub_divisionE, "Quality Sub Division");
        selectOption(sub_unitE, "Quality Sub Unit");
        selectOption(officeE, "Quality Office");
        selectOption(teamE, "Quality Team");

        hold(500);
        softAssert.assertEquals(teamE.getText(), "Quality Team", "There is a problem, 'Team' NOT retrieve data, it should be retrieve: 'Quality Team'");
        hold(300);

        selectOption(departmentE, "Development");
        hold(300);
        softAssert.assertEquals(sectionE.getText(), "Choose", "After change department, it should be reset to choose");
        softAssert.assertEquals(teamE.getText(), "Choose", "After change department, it should be reset to choose");
        softAssert.assertAll();

    }

    public void currencyPerEmployee(int flag){

        if(flag > 1 || flag < 0){
            flag = 1;
        }

        sqlQuery("update adm_branch set currency_per_employee="+flag);

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");

        elementWait(siteE);
        hold(500);

        scrollToElement(hiring_dateE);
        hold(300);

        ///// reduce implicit time to find list if empty faster
        implicitWaitChanging(200);
        List<WebElement> currencyElement = driver.findElements(By.id("select2-emp_currency-container"));
        if(flag == 1){
            Assert.assertFalse(currencyElement.isEmpty(), "- Currency Element NOT Appear when the FLAG = "+flag);
        }else{
            Assert.assertTrue(currencyElement.isEmpty(), "- Currency Element Still Appear when the FLAG = "+flag);
        }

        //// reset to default branch setup
        sqlQuery("update adm_branch set currency_per_employee=1");

    }

    public void jobRotationPerEmployee(int flag){

        if(flag > 1 || flag < 0){
            flag = 1;
        }

        sqlQuery("update adm_company set is_job_rotation="+flag);

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");

        elementWait(siteE);
        hold(500);

        scrollToElement(hiring_dateE);
        hold(300);

        ///// reduce implicit time to find list if empty faster
        implicitWaitChanging(200);
        List<WebElement> currencyElement = driver.findElements(By.id("select2-emp_rotation_type_1-container"));
        if(flag == 1){
            Assert.assertFalse(currencyElement.isEmpty(), "- Job Rotation Element NOT Appear when the FLAG = "+flag);
        }else{
            Assert.assertTrue(currencyElement.isEmpty(), "- Job Rotation Element Still Appear when the FLAG = "+flag);
        }

        //// reset to default branch setup
        sqlQuery("update adm_company set is_job_rotation=0");

    }

    public void searchFieldSynchronize(String employeeStatus){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        if(employeeStatus.equalsIgnoreCase("inactive")){
            closeIFrame();
            mainMenu.mainMenu("Workforce Management", "Employee Termination");
            goToFrame(frame);
            elementWaitAdvanced(By.name("employee_code"));
            hold(500);
            clickOn(employeeTerminationTab);
            hold(300);
            elementWaitAdvanced(By.id("employee_code"));
            setText(empCode, employeeCode);
            setText(empCode, Keys.TAB);
            hold(300);
            clickOn(calculateSalaryTermination);
            hold(300);
            closeIFrame();
            goToFrame(menuFrame);
            clickOn(menuPostButton);
            hold(300);
            alertWait();
            Alert alert = driver.switchTo().alert();
            hold(500);
            alert.accept();
        }

        closeIFrame();
        hold(300);
        mainMenu.mainMenu("Employees","Personnel Information");
        goToFrame(frame);
        clickOn(synchronizeDataBtn);
        hold(300);
        goToFrame(iframePopup);
        clickOn(employeeCodeSync);
        hold(200);

        if(employeeStatus.equalsIgnoreCase("active")){
            setText(employeeCodeSync, employeeCode);
            hold(100);
            employeeCodeSync.sendKeys(Keys.TAB);
            driver.switchTo().parentFrame();
            hold(500);
            Assert.assertTrue(alertActiveEmployeeSync.isDisplayed(), "- Alert 'Please Choose A Terminated Employee' NOT Appear");
        }else if(employeeStatus.equalsIgnoreCase("undefined")){
            setText(employeeCodeSync, "undefinedemp");
            hold(100);
            employeeCodeSync.sendKeys(Keys.TAB);
            driver.switchTo().parentFrame();
            hold(500);
            Assert.assertTrue(alertUndefinedEmployeeSync.isDisplayed(), "- Alert 'Employee Is Undefined!' NOT Appear");
        } else if (employeeStatus.equalsIgnoreCase("inactive")) {
            setText(employeeCodeSync, employeeCode);
            hold(100);
            employeeCodeSync.sendKeys(Keys.TAB);
            hold(300);
            Assert.assertTrue(employeeNameSync.getText().isEmpty(), "- Employee Name NOT Appear");
        }


    }

    public void searchBoxEmployeeSynchronizeData(String employeeStatus){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        if(employeeStatus.equalsIgnoreCase("inactive")){

            personalInformation("Single", "Male", "Jordanian",
                    "", "", "", "", "01/10/1990");

            employmentInformation("Amman", "Quality", "Quality Control", "",
                    "", "", "", "", "", "", "", "",
                    "", "", "", "", "", "Software Test Engineer",
                    "01/01/2020", "01/01/2020", "", "", "", "");

            closeIFrame();
            mainMenu.mainMenu("Workforce Management", "Employee Termination");
            goToFrame(frame);
            elementWaitAdvanced(By.name("employee_code"));
            hold(500);
            clickOn(employeeTerminationTab);
            hold(300);
            elementWaitAdvanced(By.id("employee_code"));
            setText(empCode, employeeCode);
            setText(empCode, Keys.TAB);
            hold(300);
            clickOn(calculateSalaryTermination);
            hold(300);
            closeIFrame();
            goToFrame(menuFrame);
            clickOn(menuPostButton);
            hold(300);
            alertWait();
            Alert alert = driver.switchTo().alert();
            hold(500);
            alert.accept();
            hold(300);
            closeIFrame();
            mainMenu.mainMenu("Employees","Personnel Information");

        }

        hold(500);
        goToFrame(frame);
        hold(300);
        elementWait(empCode);
        hold(300);
        clickOn(synchronizeDataBtn);
        hold(300);
        goToFrame(iframePopup);
        clickOn(searchBoxBtn);
        hold(300);
        driver.switchTo().parentFrame();
        goToFrame(searchEmployeePopupFrame);
        hold(300);
        clickOn(filterInSearchBox);
        hold(300);

        if(employeeStatus.equalsIgnoreCase("Active")){
            Select empStatus = new Select(employeeStatusInSearchBox);
            empStatus.selectByVisibleText("Active Employee");
            hold(500);
            scrollToElement(searchBtnInSearchBox);
            clickOn(searchBtnInSearchBox);
            hold(500);
            clickOn(filterInSearchBox);
            hold(500);
            clickOn(driver.findElement(By.xpath("//div[contains(@onclick, 'go_selected_user')][1]")));
            hold(300);
            backToParentIFrame();
            Assert.assertTrue(alertActiveEmployeeSync.isDisplayed(), "- Alert 'Please Choose A Terminated Employee' NOT Appear");
        } else if (employeeStatus.equalsIgnoreCase("Inactive")) {
            Select empStatus = new Select(employeeStatusInSearchBox);
            empStatus.selectByVisibleText("Inactive");
            hold(500);
            scrollToElement(searchBtnInSearchBox);
            clickOn(searchBtnInSearchBox);
            hold(500);
            clickOn(filterInSearchBox);
            hold(500);
            clickOn(driver.findElement(By.xpath("//div[contains(@onclick, 'go_selected_user')][1]")));
            hold(300);
            driver.switchTo().parentFrame();
            goToFrame(iframePopup);
            hold(300);
            Assert.assertTrue(employeeNameSync.getText().isEmpty(), "- Employee Name NOT Appear");
        }


    }

    public void SynchronizeDataAllData(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        hold(500);
        goToFrame(frame);
        hold(300);
        elementWait(empCode);
        hold(300);
        clickOn(synchronizeDataBtn);
        hold(300);
        goToFrame(iframePopup);
        clickOn(employeeCodeSync);
        hold(200);
        setText(employeeCodeSync, "emptotestsync");
        hold(100);
        employeeCodeSync.sendKeys(Keys.TAB);
        hold(300);
        clickOn(saveBtnSyncData);
        hold(200);
        driver.switchTo().parentFrame();
        hold(500);
        clickOn(nextButton);
        hold(300);
        elementWait(siteE);
        employmentInformation("New Zarqa", "Quality", "Quality Control",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "Software Test Engineer", "01/01/2019",
                "01/01/2019", "", "", "", "");

        employeeCode = empCode.getAttribute("value");
        hold(300);
        clickOn(alertOkBtn);
        hold(300);

        synchronizeDataGeneralInfo();
        synchronizeDataSpouses();
        synchronizeDataChildren();
        synchronizeDataDependents();
        synchronizeDataNotes();
        synchronizeDataEducation();
        synchronizeDataCompetencies();
        synchronizeDataCertificate();
        synchronizeDataJobHistory();
        synchronizeDataReferences();
        synchronizeDataAdditionalInfo();
        synchronizeDataExperiences();
        synchronizeDataPracticalExperience();
        synchronizeDataAddresses();
        synchronizeDataAttachments();
        synchronizeDataMedicalProfile();
        synchronizeDataResidences();
        softAssert.assertAll();

    }

    public void synchronizeDataGeneralInfo(){

        try {
            implicitWaitChanging(100);
            clickOn(personalAndEmploymentTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        clickOn(backToPersonalInformationTab);
        hold(300);
        elementWait(fNameEng);

        softAssert.assertEquals(fNameEng.getAttribute("value"), "emptotestsyncF1", " - GeneralInfo");
        softAssert.assertEquals(sNameEng.getAttribute("value"), "emptotestsyncS1", " - GeneralInfo");
        softAssert.assertEquals(tNameEng.getAttribute("value"), "emptotestsyncT1", " - GeneralInfo");
        softAssert.assertEquals(familyNameEng.getAttribute("value"), "emptotestsyncL1", " - GeneralInfo");
        softAssert.assertEquals(fNameAr.getAttribute("value"), "emptotestsyncFA1", " - GeneralInfo");
        softAssert.assertEquals(sNameAr.getAttribute("value"), "emptotestsyncSA1", " - GeneralInfo");
        softAssert.assertEquals(tNameAr.getAttribute("value"), "emptotestsyncTA1", " - GeneralInfo");
        softAssert.assertEquals(familyNameAr.getAttribute("value"), "emptotestsyncLA1", " - GeneralInfo");
        softAssert.assertEquals(marital_StatusE.getText(), "Married", " - GeneralInfo");
        softAssert.assertEquals(sexE.getText(), "Male", " - GeneralInfo");
        softAssert.assertEquals(nationalityE.getText(), "American", " - GeneralInfo");
        softAssert.assertEquals(relegionE.getText(), "Islam", " - GeneralInfo");
        softAssert.assertTrue(mobileE.getAttribute("value").isEmpty(), " - GeneralInfo");
        softAssert.assertEquals(birth_date.getAttribute("value"), "01/10/1993", " - GeneralInfo");
        softAssert.assertTrue(emailE.getAttribute("value").isEmpty(), " - GeneralInfo");
        softAssert.assertTrue(manager_code.getAttribute("value").isEmpty(), " - GeneralInfo");
        softAssert.assertTrue(checkPicture.getAttribute("src").contains(".jpg"), " - GeneralInfo");

    }

    public void synchronizeDataSpouses() {

        try {
            implicitWaitChanging(100);
            clickOn(personalAndEmploymentTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        clickOn(spousePage);
        hold(300);
        elementWait(firstNameSpouse);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(firstNameSpouse.getAttribute("value"), "testSyncSpouseF1", " - Spouses");
        softAssert.assertEquals(secondNameSpouse.getAttribute("value"), "testSyncSpouseS1", " - Spouses");
        softAssert.assertEquals(thirdNameSpouse.getAttribute("value"), "testSyncSpouseT1", " - Spouses");
        softAssert.assertEquals(familyNameSpouse.getAttribute("value"), "testSyncSpouseL1", " - Spouses");
        softAssert.assertEquals(firstNameArSpouse.getAttribute("value"), "testSyncSpouseLA1", " - Spouses");
        softAssert.assertEquals(secondNameArSpouse.getAttribute("value"), "testSyncSpouseTA1", " - Spouses");
        softAssert.assertEquals(thirdNameArSpouse.getAttribute("value"), "testSyncSpouseSA1", " - Spouses");
        softAssert.assertEquals(familyNameArSpouse.getAttribute("value"), "testSyncSpouseFA1", " - Spouses");
        softAssert.assertEquals(birthDateSpouse.getAttribute("value"), "01/01/1989", " - Spouses");
        softAssert.assertEquals(marryDateSpouse.getAttribute("value"), "20/03/2020", " - Spouses");
        softAssert.assertEquals(birthPlaceSpouse.getText(), "Birth Place 1", " - Spouses");
        softAssert.assertEquals(nationalitySpouse.getText(), "American", " - Spouses");
        softAssert.assertTrue(insuredSpouse.isEnabled(), " - Spouses");
        softAssert.assertTrue(workerSpouse.isEnabled(), " - Spouses");
        softAssert.assertEquals(allowanceAmountSpouse.getAttribute("value"), "10.000", " - Spouses");
        softAssert.assertEquals(notesSpouse.getText(), "testSyncSpouse", " - Spouses");
        softAssert.assertEquals(driver.findElement(By.xpath("//label[contains(@class,'font-size-19 bold mar-left-20px')]")).getText().trim(), "10.000", " - Spouses");

    }

    public void synchronizeDataChildren() {

        try {
            implicitWaitChanging(100);
            clickOn(personalAndEmploymentTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        clickOn(childrenPage);
        hold(300);
        elementWait(firstNameChildEn);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(firstNameChildren.getAttribute("value"), "ChildrenSyncF1", " - Children");
        softAssert.assertEquals(secondNameChildren.getAttribute("value"), "ChildrenSyncS1", " - Children");
        softAssert.assertEquals(thirdNameChildren.getAttribute("value"), "ChildrenSyncT1", " - Children");
        softAssert.assertEquals(familyNameChildren.getAttribute("value"), "ChildrenSyncL1", " - Children");
        softAssert.assertEquals(firstNameArChildren.getAttribute("value"), "ChildrenSyncLA1", " - Children");
        softAssert.assertEquals(secondNameArChildren.getAttribute("value"), "ChildrenSyncTA1", " - Children");
        softAssert.assertEquals(thirdNameArChildren.getAttribute("value"), "ChildrenSyncSA1", " - Children");
        softAssert.assertEquals(familyNameArChildren.getAttribute("value"), "ChildrenSyncFA1", " - Children");
        softAssert.assertEquals(birthDateChildren.getAttribute("value"), "04/04/2022", " - Children");
        softAssert.assertEquals(genderChildren.getText(), "Male", " - Children");
        softAssert.assertEquals(maritalStatusChildren.getText(), "Single", " - Children");
        softAssert.assertEquals(birthPlaceChildren.getText(), "Birth Place 1", " - Children");
        softAssert.assertEquals(nationalityChildren.getText(), "American", " - Children");
        softAssert.assertEquals(allowanceAmountChildren.getAttribute("value"), "20.000", " - Children");
        softAssert.assertTrue(studentChildren.isEnabled(), " - Children");
        softAssert.assertEquals(educationLevelChildren.getAttribute("title").trim(), "School Student", " - Children");
        softAssert.assertEquals(schoolChildren.getAttribute("title").trim(), "Schools 1", " - Children");
        softAssert.assertTrue(insuredChildren.isEnabled(), " - Children");

    }

    public void synchronizeDataDependents() {

        try {
            implicitWaitChanging(100);
            clickOn(personalAndEmploymentTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        clickOn(dependentsPage);
        hold(300);
        elementWait(firstNameDependents);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(firstNameDependents.getAttribute("value"), "DependentsSyncF1", " - Dependents");
        softAssert.assertEquals(secondNameDependents.getAttribute("value"), "DependentsSyncS1", " - Dependents");
        softAssert.assertEquals(thirdNameDependents.getAttribute("value"), "DependentsSyncT1", " - Dependents");
        softAssert.assertEquals(familyNameDependents.getAttribute("value"), "DependentsSyncL1", " - Dependents");
        softAssert.assertEquals(firstNameArDependents.getAttribute("value"), "DependentsSyncLA1", " - Dependents");
        softAssert.assertEquals(secondNameArDependents.getAttribute("value"), "DependentsSyncTA1", " - Dependents");
        softAssert.assertEquals(thirdNameArDependents.getAttribute("value"), "DependentsSyncSA1", " - Dependents");
        softAssert.assertEquals(familyNameArDependents.getAttribute("value"), "DependentsSyncFA1", " - Dependents");
        softAssert.assertEquals(relationshipsDependents.getText(), "Father", " - Dependents");
        softAssert.assertEquals(birthDateDependents.getAttribute("value"), "07/07/1970", " - Dependents");
        softAssert.assertEquals(genderDependents.getText(), "Male", " - Dependents");
        softAssert.assertEquals(nationalityDependents.getText(), "American", " - Dependents");
        softAssert.assertEquals(religionDependents.getText(), "Islam", " - Dependents");
        softAssert.assertTrue(medicalClaimCoverageDependents.isEnabled(), " - Dependents");
        softAssert.assertTrue(insuredDependents.isEnabled(), " - Dependents");
        softAssert.assertEquals(streetDependents.getAttribute("value"), "amman amman", " - Dependents");
        softAssert.assertEquals(zipCodeDependents.getAttribute("value"), "00962", " - Dependents");
        softAssert.assertEquals(cityDependents.getAttribute("value"), "khalda", " - Dependents");
        softAssert.assertEquals(commentsDependents.getText(), "Comment Dependents", " - Dependents");

    }

    public void synchronizeDataContacts() {

        try {
            implicitWaitChanging(100);
            clickOn(addressAndContactsTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        clickOn(contactsPage);
        hold(300);
        elementWait(contactsTypes);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(contactsTypes.getText(), "Contacts 1", " - Contacts");
        softAssert.assertEquals(contactValue.getAttribute("value"), "ContactSync555", " - Contacts");

    }

    public void synchronizeDataNotes() {

        try {
            implicitWaitChanging(100);
            clickOn(assetsAndDocumentsTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        clickOn(notesPage);
        hold(300);
        elementWait(noteDateNotes);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(noteDateNotes.getAttribute("value"), "05/10/2022", " - Notes");
        softAssert.assertEquals(noteTextNotes.getText(), "Note Note Note Note Note", " - Notes");
        softAssert.assertEquals(employeeCommentNotes.getText(), "Employee Comment Employee Comment Employee Comment", " - Notes");

    }

    public void synchronizeDataEducation() {

        try {
            implicitWaitChanging(100);
            clickOn(learningAndDevelopmentTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        elementWait(startDateEducation);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(startDateEducation.getAttribute("value"), "01/01/2013", " - Education");
        softAssert.assertEquals(endDateEducation.getAttribute("value"), "01/01/2015", " - Education");
        softAssert.assertEquals(countryEducation.getText(), "Jordan", " - Education");
        softAssert.assertEquals(schoolEducation.getText(), "Schools 2", " - Education");
        softAssert.assertEquals(facultyEducation.getText(), "Faculties 1", " - Education");
        softAssert.assertEquals(qualificationEducation.getText(), "Other", "-Issue in Qualification, - Education");
        softAssert.assertEquals(otherQualificationEducation.getAttribute("value"), "Qualification", "-Issue in Other Qualification, - Education");
        softAssert.assertEquals(majorEducation.getText(), "Other", "-Issue in Major, - Education");
        softAssert.assertEquals(otherMajorEducation.getAttribute("value"), "Major", "-Issue in Other Major, - Education");
        softAssert.assertEquals(universityAverageEducation.getText(), "Very Good", " - Education");
        softAssert.assertEquals(gradeEducation.getAttribute("value"), "90.000", "-Issue in Grade, - Education");
        softAssert.assertEquals(graduationYearEducation.getText(), "2015", " - Education");
        softAssert.assertEquals(notesEducation.getAttribute("value"), "Education Notes", " - Education");
        softAssert.assertTrue(attachFileEdu.getAttribute("src").contains(".jpg"), "-Attached File NOT Found, - Education");
        softAssert.assertEquals(educationMinor.getAttribute("value"), "2", "-Issue in Education Minor - Education");

    }

    public void synchronizeDataCompetencies() {

        try {
            implicitWaitChanging(100);
            clickOn(learningAndDevelopmentTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }
        hold(300);
        clickOn(competenciesPage);
        hold(300);
        elementWait(otherSkillClassification);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(skillClassification.getText(), "Competencies Classification 1", "- Competencies");
        softAssert.assertEquals(skillType.getText(), "Competency type 1", "- Competencies");
        softAssert.assertEquals(competencies.getText(), "Competency 1", "- Competencies");
        softAssert.assertEquals(experienceYears.getText(), "4", "- Competencies");
        softAssert.assertEquals(levelSkill.getText(), "2", "- Competencies");
        softAssert.assertEquals(clasSkill.getAttribute("value"), "Class", "- Competencies");
        softAssert.assertEquals(skillSource.getText(), "Education", "- Competencies");
        softAssert.assertEquals(showInSkill.getText(), "Generic Resume", "- Competencies");
        softAssert.assertEquals(commentSkill.getText(), "Comments", "- Competencies");

    }

    public void synchronizeDataCertificate(){

        try {
            implicitWaitChanging(100);
            clickOn(learningAndDevelopmentTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        clickOn(certificatePage);
        hold(300);
        elementWait(startDateCertificate);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(startDateCertificate.getAttribute("value"), "25/07/2022", "- Certificate");
        softAssert.assertEquals(endDateCertificate.getAttribute("value"), "25/09/2022", "- Certificate");
        softAssert.assertEquals(certificateType.getText(), "Other", "- Certificate");
        softAssert.assertEquals(certificateTypeOther.getAttribute("value"), "Certificate Type", "- Certificate");
        softAssert.assertEquals(certificateName.getText(), "Other", "- Certificate");
        softAssert.assertEquals(certificateNameOther.getAttribute("value"), "Certificate Name", "- Certificate");
        softAssert.assertEquals(issueDateCertificate.getAttribute("value"), "25/06/2022", "- Certificate");
        softAssert.assertEquals(certificateSerial.getAttribute("value"), "Certificate Serial", "- Certificate");
        softAssert.assertEquals(gradeCertificate.getAttribute("value"), "80.000", "- Certificate");
        softAssert.assertEquals(certificateNumber.getAttribute("value"), "Certificate Number", "- Certificate");
        softAssert.assertEquals(certificateShowIn.getText(), "Detailed Resume", "- Certificate");
        softAssert.assertTrue(certificateAttached.getAttribute("value").contains(".jpg"), "- Certificate");
        softAssert.assertTrue(statusCertificate.isSelected(), "- Certificate");
        softAssert.assertEquals(notesCertificate.getText(), "Notes", "- Certificate");

    }

    public void synchronizeDataJobHistory() {

        try {
            implicitWaitChanging(100);
            clickOn(experiencesTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        clickOn(jobHistoryPage);
        hold(300);
        elementWait(startDateJobHistory);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(startDateJobHistory.getAttribute("value"), "10/01/2018", "- Job History");
        softAssert.assertEquals(endDateJobHistory.getAttribute("value"), "20/10/2022", "- Job History");
        softAssert.assertEquals(siteJobHistory.getAttribute("value"), "Amman", "- JobHistory");
        softAssert.assertEquals(departmentJobHistory.getAttribute("value"), "Development", "- Job History");
        softAssert.assertEquals(sectionJobHistory.getAttribute("value"), "PHP Development", "- Job History");
        softAssert.assertEquals(positionJobHistory.getAttribute("value"), "PHP Developer", "- Job History");

    }

    public void synchronizeDataReferences() {

        try {
            implicitWaitChanging(100);
            clickOn(addressAndContactsTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        clickOn(referencesPage);
        hold(300);
        elementWait(contactNameReferences);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(contactNameReferences.getAttribute("value"), "ReferencesSync", "- References");
        softAssert.assertEquals(relationshipsReferences.getText(), "Brother", "- References");
        softAssert.assertEquals(cityReferences.getAttribute("value"), "zarqa", "- References");

    }

    public void synchronizeDataAdditionalInfo() {

        try {
            implicitWaitChanging(100);
            clickOn(otherTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        scrollToElement(AdditionalInfoPage);
        clickOn(AdditionalInfoPage);
        hold(300);
        elementWait(fieldNameAdditionalInfo);
        clickOn(item);
        hold(500);
        Select field = new Select(fieldNameAdditionalInfo);
        WebElement fieldOption = field.getFirstSelectedOption();
        softAssert.assertEquals(fieldOption.getText().trim(), "Additional Number", "- Additional Info");
        softAssert.assertEquals(englishDescriptionAdditionalInfo.getAttribute("value"), "1122112211", "- Additional Info");

    }

    public void synchronizeDataExperiences() {

        try {
            implicitWaitChanging(100);
            clickOn(experiencesTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        clickOn(experiencesPage);
        hold(300);
        elementWait(startDateExperiences);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(startDateExperiences.getAttribute("value"), "01/01/2016", "- Experiences");
        softAssert.assertEquals(endDateExperiences.getAttribute("value"), "01/01/2017", "- Experiences");
        softAssert.assertEquals(previousEmployerExperiences.getAttribute("value"), "Previous Employer", "- Experiences");
        softAssert.assertEquals(previousPositionExperiences.getAttribute("value"), "Previous Position", "- Experiences");
        softAssert.assertEquals(salaryExperiences.getAttribute("value"), "2000.000", "- Experiences");
        softAssert.assertEquals(salaryCurrencyExperiences.getText(), "Jordanian Dinar", "- Experiences");
        softAssert.assertEquals(contactPersonExperiences.getAttribute("value"), "Contact Person", "- Experiences");
        softAssert.assertEquals(contactPhoneExperiences.getAttribute("value"), "Contact Phone", "- Experiences");
        softAssert.assertEquals(contactPositionExperiences.getAttribute("value"), "Contact Position", "- Experiences");
        softAssert.assertEquals(countryExperiences.getText(), "Jordan", "- Experiences");
        softAssert.assertEquals(jobPlaceExperiences.getAttribute("value"), "Job Place", "- Experiences");
        softAssert.assertEquals(quitReasonExperiences.getAttribute("value"), "Quit Reason", "- Experiences");
        softAssert.assertEquals(experiencePlaceExperiences.getText(), "Experience Place 1", "- Experiences");
        softAssert.assertEquals(experienceTypeExperiences.getText(), "Experience Type 1", "- Experiences");
        softAssert.assertEquals(natureOfWorkExperiences.getText(), "Nature Of Work 1", "- Experiences");
        softAssert.assertEquals(jobClassificationExperiences.getText(), "Job Classification 1", "- Experiences");
        softAssert.assertEquals(relevanceExperiences.getText(), "Relevant", "- Experiences");
        softAssert.assertEquals(responsibilitiesExperiences.getText(), "Responsibilities", "- Experiences");

    }

    public void synchronizeDataPracticalExperience() {

        try {
            implicitWaitChanging(100);
            clickOn(experiencesTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        clickOn(practicalExperiencesPage);
        hold(300);
        elementWait(datePracticalExperience);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(datePracticalExperience.getAttribute("value"), "25/10/2022", "- Practical Experiences");
        softAssert.assertEquals(showInPracticalExperience.getText(), "Both", "- Practical Experiences");
        softAssert.assertEquals(englishPracticalExperience.getText().trim(), "Practical Experience - English", "- Practical Experiences");
        softAssert.assertEquals(arabicPracticalExperience.getText().trim(), "Practical Experience - Arabic", "- Practical Experiences");

    }

    public void synchronizeDataAddresses() {

        try {
            implicitWaitChanging(100);
            clickOn(addressAndContactsTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        elementWait(fromDateAddresses);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(fromDateAddresses.getAttribute("value"), "01/01/2022", "- Addresses");
        softAssert.assertEquals(toDateAddresses.getAttribute("value"), "01/10/2022", "- Addresses");
        softAssert.assertEquals(countryAddresses.getText(), "Jordan", "- Addresses");
        softAssert.assertEquals(townAddresses.getAttribute("value"), "Amman City", "- Addresses");

    }

    public void synchronizeDataAttachments() {

        try {
            implicitWaitChanging(100);
            clickOn(assetsAndDocumentsTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        elementWait(attachmentTypeAttachments);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(attachmentTypeAttachments.getText(), "Personal Identification", "- Attachments");
        softAssert.assertEquals(attachmentDateAttachments.getAttribute("value"), "01/02/2022", "- Attachments");
        softAssert.assertEquals(documentNumberAttachments.getAttribute("value"), "4545", "- Attachments");
        softAssert.assertEquals(expiresOnAttachments.getAttribute("value"), "25/10/2032", "- Attachments");
        softAssert.assertEquals(relatedToAttachments.getText(), "Employee", "- Attachments");
        softAssert.assertTrue(attachedFileAttachments.getAttribute("href").contains("download_page_direct"), "- Attachments");
        softAssert.assertEquals(descriptionAttachments.getText().trim(), "Description", "- Attachments");

    }

    public void synchronizeDataMedicalProfile() {

        try {
            implicitWaitChanging(100);
            clickOn(otherTab);
            implicitWaitChanging(10000);
        }catch (Exception e){
            driver.switchTo().parentFrame();
            mainMenu = new MainMenu();
            mainMenu.mainMenu("Employees","Personnel Information");
            hold(500);
            goToFrame(frame);
            hold(200);
        }

        hold(300);
        scrollToElement(medicalProfilePage);
        clickOn(medicalProfilePage);
        hold(300);
        elementWait(statusTypeMedicalProfile);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(statusTypeMedicalProfile.getText(), "Medical Status 1", "- Medical Profile");
        softAssert.assertEquals(statusDateMedicalProfile.getAttribute("value"), "08/10/2022", "- Medical Profile");
        softAssert.assertTrue(medicalFileMedicalProfile.getAttribute("href").contains(".jpg"), "- Medical Profile");
        softAssert.assertEquals(statusMedicalProfile.getText().trim(), "Status", "- Medical Profile");
        softAssert.assertEquals(notesMedicalProfile.getText().trim(), "Notes", "- Medical Profile");

    }

    public void synchronizeDataResidences() {

        driver.switchTo().parentFrame();
        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Employees Residences");
        hold(300);
        goToFrame(frame);
        hold(500);
        elementWaitAdvanced(By.name("sponsorship_deduct_code"));
        clickOn(residenceTab);
        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employeeCode);
        setText(empCode, Keys.TAB);
        hold(500);

        softAssert.assertEquals(residenceNumber.getAttribute("value"), "123456", "- Residences");
        softAssert.assertEquals(dateOfIssueDateResidences.getAttribute("value"), "01/09/2022", "- Residences");
        softAssert.assertEquals(periodResidences.getAttribute("value"), "53.000", "- Residences");
        softAssert.assertEquals(salaryInIqamaResidences.getAttribute("value"), ".500", "- Residences");
        softAssert.assertEquals(cancellationDateResidences.getAttribute("value"), "01/09/2022", "- Residences");
        try {
            implicitWaitChanging(200);
            softAssert.assertTrue(attachedFileResidences.getAttribute("value").contains(".jpg"), "- Residences");
        }catch (Exception e){
            softAssert.fail("Attached File NOT Found!,- Residences");
            implicitWaitChanging(10000);
        }
        softAssert.assertEquals(placeOfIssueResidences.getAttribute("value"), "Place Of Issue", "- Residences");
        softAssert.assertEquals(endDateDateResidences.getAttribute("value"), "23/10/2022", "- Residences");
        softAssert.assertEquals(requestedWorkPeriodResidences.getAttribute("value"), "2", "- Residences");
        softAssert.assertEquals(permitNumberResidences.getAttribute("value"), "231658", "- Residences");

    }

    public void synchronizeDataRandomChooses(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        hold(500);
        goToFrame(frame);
        hold(300);
        elementWait(empCode);
        hold(300);
        clickOn(synchronizeDataBtn);
        hold(300);
        goToFrame(iframePopup);
        clickOn(employeeCodeSync);
        hold(200);
        setText(employeeCodeSync, "emptotestsync");
        hold(100);
        employeeCodeSync.sendKeys(Keys.TAB);
        hold(300);

        elementWaitAdvanced(By.name("general_info"));
        //clickOn(driver.findElement(By.name("general_info")));
        //clickOn(driver.findElement(By.name("spouses")));
        clickOn(driver.findElement(By.name("children")));
        clickOn(driver.findElement(By.name("dependents")));
        clickOn(driver.findElement(By.name("contacts")));
        clickOn(driver.findElement(By.name("notes")));
        clickOn(driver.findElement(By.name("education")));
        clickOn(driver.findElement(By.name("skills")));
        clickOn(driver.findElement(By.name("certificates")));
        clickOn(driver.findElement(By.name("job_history")));
        clickOn(driver.findElement(By.name("references")));
        clickOn(driver.findElement(By.name("additional_info")));
        clickOn(driver.findElement(By.name("experiences")));
        clickOn(driver.findElement(By.name("practical_experiences")));
        clickOn(driver.findElement(By.name("addresses")));
        clickOn(driver.findElement(By.name("Attachments")));
        clickOn(driver.findElement(By.name("medical_profile")));
        clickOn(driver.findElement(By.name("residence_details")));

        String[] randomOption = new String[4];
        String[] sync = {"children", "dependents", "contacts", "notes", "education",
                "skills", "certificates", "job_history", "references", "additional_info", "experiences",
                "practical_experiences", "addresses", "Attachments", "medical_profile", "residence_details"};
        Random numberGenerator = new Random();
        /* Generate A Random Number */
        int nextRandom = numberGenerator.nextInt(16);
        Set<Integer> validate = new HashSet<>();
        /* Add First Randomly Generated Number To Set */
        validate.add(nextRandom);
        for (int i = 0; i < 4; i++) {
            /* Generate Randoms Till You Find A Unique Random Number */
            while(validate.contains(nextRandom)) {
                nextRandom = numberGenerator.nextInt(16);
            }
            /* Add Newly Found Random Number To Validate */
            validate.add(nextRandom);
            System.out.println(sync[nextRandom]);
            randomOption[i] = sync[nextRandom];
            clickOn(driver.findElement(By.name(randomOption[i])));
        }

        hold(300);
        clickOn(saveBtnSyncData);
        hold(200);
        driver.switchTo().parentFrame();
        hold(500);
        clickOn(nextButton);
        hold(300);
        elementWait(siteE);
        employmentInformation("New Zarqa", "Quality", "Quality Control",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "Software Test Engineer", "01/01/2019",
                "01/01/2019", "", "", "", "");

        employeeCode = empCode.getAttribute("value");
        hold(300);
        clickOn(alertOkBtn);
        hold(300);

        synchronizeDataGeneralInfo();
        hold(300);
        synchronizeDataSpouses();
        hold(300);

        for (String s : randomOption) {
            if (s.equals("children")) {
                synchronizeDataChildren();
                hold(300);
            } else if (s.equals("dependents")) {
                synchronizeDataDependents();
                hold(300);
            } else if (s.equals("contacts")) {
                synchronizeDataContacts();
                hold(300);
            } else if (s.equals("notes")) {
                synchronizeDataNotes();
                hold(300);
            } else if (s.equals("education")) {
                synchronizeDataEducation();
                hold(300);
            } else if (s.equals("skills")) {
                synchronizeDataCompetencies();
                hold(300);
            } else if (s.equals("certificates")) {
                synchronizeDataCertificate();
                hold(300);
            } else if (s.equals("job_history")) {
                synchronizeDataJobHistory();
                hold(300);
            } else if (s.equals("references")) {
                synchronizeDataReferences();
                hold(300);
            } else if (s.equals("additional_info")) {
                synchronizeDataAdditionalInfo();
                hold(300);
            } else if (s.equals("experiences")) {
                synchronizeDataExperiences();
                hold(300);
            } else if (s.equals("practical_experiences")) {
                synchronizeDataPracticalExperience();
                hold(300);
            } else if (s.equals("addresses")) {
                synchronizeDataAddresses();
                hold(300);
            } else if (s.equals("Attachments")) {
                synchronizeDataAttachments();
                hold(300);
            } else if (s.equals("medical_profile")) {
                synchronizeDataMedicalProfile();
                hold(300);
            } else if (s.equals("residence_details")) {
                synchronizeDataResidences();
                hold(300);
            }
        }
        softAssert.assertAll();

    }

    public void lockEmployeePersonnelAndEmploymentInfo(String personalOrFinancial){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getAttribute("value");
        closeIFrame();

        mainMenu.mainMenu("Employees", "Lock Employees Data");
        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.name("employee_code"));
        hold(300);
        setText(empCodeByName, employeeCode);
        setText(empCodeByName, Keys.TAB);
        hold(300);
        if(personalOrFinancial.equalsIgnoreCase("Personal")){
            lockFinancial.click();
        }else if (personalOrFinancial.equalsIgnoreCase("Financial")){
            lockEmployment.click();
        }
        hold(300);
        driver.switchTo().parentFrame();
        goToFrame(menuFrame);
        hold(300);
        clickOn(menuPostButton);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(300);
        alert.accept();
        hold(300);
        alertWait();
        hold(300);
        alert.accept();
        driver.switchTo().defaultContent();
        if(personalOrFinancial.equalsIgnoreCase("Personal")){
            mainMenu.mainMenu("Employees", "Personnel Information");
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            empCode.clear();
            hold(300);
            setText(empCode, employeeCode);
            setText(empCode, Keys.TAB);
            hold(300);
            elementWait(fNameEng);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear!");
            implicitWaitChanging(10000);
            hold(300);
            clickOn(backToEmploymentInformationTab);
            elementWaitAdvanced(By.id("site"));
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Employment Information!");
            implicitWaitChanging(10000);
            hold(300);
        }else if (personalOrFinancial.equalsIgnoreCase("Financial")){
            mainMenu.mainMenu("Employees", "Financial Information");
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            setText(empCode, employeeCode);
            setText(empCode, Keys.TAB);
            hold(500);
            elementWait(basicSalaryAmount);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Financial Data Page!");
            implicitWaitChanging(10000);
            hold(300);
            clickOn(paymentTab);
            elementWaitAdvanced(By.name("iban_number"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Payment Method!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(otherBankPayment);
            elementWaitAdvanced(By.id("uls_parent"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Other Banks!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(insuranceTab);
            elementWaitAdvanced(By.id("begin_ins_date"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Health Insurance!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(socialSecurityInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Social Security!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(EOSInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in EOS!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(GLAccountInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in GL Account!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(otherInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Other Page Insurance!");
            implicitWaitChanging(10000);
        }else{
            mainMenu.mainMenu("Employees", "Personnel Information");
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            empCode.clear();
            hold(300);
            setText(empCode, employeeCode);
            setText(empCode, Keys.TAB);
            hold(300);
            elementWait(fNameEng);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear!");
            implicitWaitChanging(10000);
            hold(300);
            clickOn(backToEmploymentInformationTab);
            elementWaitAdvanced(By.id("site"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Employment Information!");
            implicitWaitChanging(10000);
            hold(500);
            driver.switchTo().defaultContent();
            mainMenu.mainMenu("Employees", "Financial Information");
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            setText(empCode, employeeCode);
            setText(empCode, Keys.TAB);
            hold(300);
            elementWait(basicSalaryAmount);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Financial Data Page!");
            implicitWaitChanging(10000);
            hold(300);
            clickOn(paymentTab);
            elementWaitAdvanced(By.name("iban_number"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Payment Method!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(otherBankPayment);
            elementWaitAdvanced(By.id("uls_parent"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Other Banks!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(insuranceTab);
            elementWaitAdvanced(By.id("begin_ins_date"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Health Insurance!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(socialSecurityInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Social Security!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(EOSInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in EOS!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(GLAccountInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in GL Account!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(otherInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertEquals(checkSaveButton.size(), 0, "- Issue, The Save Button Still Appear in Other Page Insurance!");
            implicitWaitChanging(10000);
        }
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Employees", "Lock Employees Data");
        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.name("employee_code"));
        hold(300);
        setText(empCodeByName, employeeCode);
        setText(empCodeByName, Keys.TAB);
        hold(300);
        driver.switchTo().parentFrame();
        goToFrame(menuFrame);
        hold(300);
        clickOn(menuUnPostButton);
        alertWait();
        hold(300);
        alert.accept();
        hold(300);
        alertWait();
        softAssert.assertEquals(alert.getText(), "Transactions Were Correctly Unlocked", "- Issue, maybe already Unlocked");
        hold(300);
        alert.accept();
        driver.switchTo().defaultContent();
        if(personalOrFinancial.equalsIgnoreCase("Personal")){
            mainMenu.mainMenu("Employees", "Personnel Information");
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            empCode.clear();
            hold(300);
            setText(empCode, employeeCode);
            setText(empCode, Keys.TAB);
            hold(300);
            elementWait(fNameEng);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(backToEmploymentInformationTab);
            elementWaitAdvanced(By.id("select2-site_1-container"));
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Employment Information!");
            implicitWaitChanging(10000);
            hold(500);
        }else if (personalOrFinancial.equalsIgnoreCase("Financial")){
            driver.switchTo().defaultContent();
            mainMenu.mainMenu("Employees", "Financial Information");
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            setText(empCode, employeeCode);
            setText(empCode, Keys.TAB);
            hold(300);
            elementWait(basicSalaryAmount);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Financial Data Page!");
            implicitWaitChanging(10000);
            hold(300);
            clickOn(paymentTab);
            elementWaitAdvanced(By.name("iban_number"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Payment Method!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(otherBankPayment);
            elementWaitAdvanced(By.id("uls_parent"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Other Banks!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(insuranceTab);
            elementWaitAdvanced(By.id("begin_ins_date"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Health Insurance!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(socialSecurityInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Social Security!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(EOSInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in EOS!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(GLAccountInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in GL Account!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(otherInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Other Page Insurance!");
            implicitWaitChanging(10000);
        }else{
            mainMenu.mainMenu("Employees", "Personnel Information");
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            empCode.clear();
            hold(500);
            setText(empCode, employeeCode);
            setText(empCode, Keys.TAB);
            hold(300);
            elementWait(fNameEng);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(backToEmploymentInformationTab);
            elementWaitAdvanced(By.id("select2-site_1-container"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Employment Information!");
            implicitWaitChanging(10000);
            hold(500);
            driver.switchTo().defaultContent();
            mainMenu.mainMenu("Employees", "Financial Information");
            goToFrame(frame);
            elementWaitAdvanced(By.id("employee_code"));
            setText(empCode, employeeCode);
            setText(empCode, Keys.TAB);
            hold(300);
            elementWait(basicSalaryAmount);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Financial Data Page!");
            implicitWaitChanging(10000);
            hold(300);
            clickOn(paymentTab);
            elementWaitAdvanced(By.name("iban_number"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Payment Method!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(otherBankPayment);
            elementWaitAdvanced(By.id("uls_parent"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Other Banks!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(insuranceTab);
            elementWaitAdvanced(By.id("begin_ins_date"));
            hold(500);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Health Insurance!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(socialSecurityInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Social Security!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(EOSInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in EOS!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(GLAccountInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in GL Account!");
            implicitWaitChanging(10000);
            hold(500);
            clickOn(otherInsurance);
            hold(300);
            implicitWaitChanging(1000);
            softAssert.assertFalse(checkSaveButton.isEmpty(), "- Issue, The Save Button NOT Appear in Other Page Insurance!");
            implicitWaitChanging(10000);
        }
        softAssert.assertAll();
    }

    public void hideEmployeesPicturesInEmployeeSearchPage(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");

        systemParameters = new SystemParameters();
        systemParameters.hideEmployeesPicturesInEmployeeSearchPage(true);
        hold(500);
        mainMenu.mainMenu("Employees", "Personnel Information");
        hold(500);
        goToFrame(frame);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(searchBoxEmployees);
        hold(300);
        goToFrame(searchEmployeePopupFrame);
        hold(300);
        elementWaitAdvanced(By.id("textSearchInput"));
        implicitWaitChanging(200);
        softAssert.assertEquals(employeePictureInSearchBox.size(), 0, "There is Pictures Still Appear");
        implicitWaitChanging(10000);

        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters.hideEmployeesPicturesInEmployeeSearchPage(false);
        hold(500);
        mainMenu.mainMenu("Employees", "Personnel Information");
        hold(500);
        goToFrame(frame);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(searchBoxEmployees);
        hold(300);
        goToFrame(searchEmployeePopupFrame);
        hold(300);
        elementWaitAdvanced(By.id("textSearchInput"));
        implicitWaitChanging(200);
        softAssert.assertFalse(employeePictureInSearchBox.isEmpty(), " - Employee Pictures NOT Appear!");
        implicitWaitChanging(10000);
        softAssert.assertAll();

    }

    public void lockHiringDateAndEmploymentDateForTransferredEmployees(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters = new SystemParameters();
        systemParameters.lockBothHiringDateAndEmploymentDateForTransferredEmployees(true);
        hold(500);
        mainMenu.mainMenu("Employees", "Personnel Information");

        personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");

        employmentInformation("New Zarqa", "Quality", "Quality Control",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "Software Test Engineer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        driver.switchTo().defaultContent();
        hold(300);
        mainMenu.mainMenu("Workforce Management", "Employee Termination");
        goToFrame(frame);
        elementWaitAdvanced(By.name("employee_code"));
        hold(500);
        clickOn(employeeTerminationTab);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employeeCode);
        setText(empCode, Keys.TAB);
        hold(300);
        String endDate = driver.findElement(By.id("first_date")).getAttribute("value");
        clickOn(terminationType);
        hold(500);
        clickOn(driver.findElement(By.xpath("//*[@id=\"termination_type\"]/option[4]")));
        hold(500);
        clickOn(calculateSalaryTermination);
        hold(300);
        driver.switchTo().defaultContent();
        goToFrame(menuFrame);
        clickOn(menuPostButton);
        hold(300);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        driver.switchTo().defaultContent();
        goToFrame(frame);
        hold(1000);
        clickOn(driver.findElement(By.xpath("//a[contains(@href, 'end_settlements.php')]")));
        hold(300);
        clickOn(driver.findElement(By.name("is_settled")));
        hold(500);
        setText(driver.findElement(By.id("settled_date")), endDate);
        driver.switchTo().defaultContent();
        goToFrame(menuFrame);
        clickOn(menuPostButton);
        hold(500);
        alertWait();
        hold(500);
        alert.accept();
        driver.switchTo().defaultContent();
        goToFrame(frame);
        hold(1000);
        clickOn(driver.findElement(By.xpath("//div[@class='tabdiv']//a[contains(@href, 'end_services.php')]")));
        hold(300);
        clickOn(driver.findElement(By.name("Button3")));
        hold(300);
        driver.switchTo().defaultContent();
        String CurrectWindow = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
            System.out.println(driver.switchTo().window(winHandle).getTitle());
        }

        new Select(driver.findElement(By.id("new_branch_code"))).selectByVisibleText("Auto_a2");
        setText(driver.findElement(By.id("site_1")), Keys.TAB);
        hold(500);
        setText(driver.findElement(By.name("new_employee_code")), employeeCode+"a2");
        hold(300);
        setText(driver.findElement(By.name("universal_code")), employeeCode+"a2");
        clickOn(driver.findElement(By.name("button_save")));
        hold(300);
        clickOn(driver.findElement(By.name("button_move")));
        hold(300);
        alertWait();
        hold(500);
        alert.accept();
        hold(500);
        clickOn(driver.findElement(By.name("button_next")));
        hold(500);
        clickOn(driver.findElement(By.name("button_cancel")));
        driver.switchTo().window(CurrectWindow);
        hold(500);
        mainMenu.mainMenu("Employees", "Personnel Information");
        hold(300);
        goToFrame(frame);
        empCode.clear();
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(500);
        elementWaitAdvanced(By.id("btok"));
        clickOn(alertOkBtn);
        hold(200);
        clickOn(backToEmploymentInformationTab);
        hold(500);
        elementWaitAdvanced(By.id("btok"));
        clickOn(alertOkBtn);
        softAssert.assertEquals(hiring_dateE.getAttribute("readonly"), "true", "- Hiring Date is NOT Disabled");
        softAssert.assertEquals(moving_dateE.getAttribute("readonly"), "true", "- Employment Date is NOT Disabled");
        softAssert.assertAll();

    }

    public void clickableFields(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        //employeeCode = employeeCodeGenerator();
        employeeCodeSetter(employeeCodeGenerator());
        System.out.println("Employee Code: "+employeeCode);
        hold(300);
        goToFrame(frame);
        hold(500);
        elementWait(empCode);
        hold(300);
        setText(empCode, employeeCode, Keys.TAB);
        hold(700);

        if(!sNameEng.getAttribute("validation").contains("required")){
            new Actions(driver).doubleClick(sNameEng).perform();
            hold(1200);
        }
        if (!tNameEng.getAttribute("validation").contains("required")) {
            new Actions(driver).doubleClick(tNameEng).perform();
            hold(1200);
        }
        if (!familyNameEng.getAttribute("validation").contains("required")) {
            new Actions(driver).doubleClick(familyNameEng).perform();
            hold(1200);
        }
        if(!fNameAr.getAttribute("validation").contains("required")){
            new Actions(driver).doubleClick(fNameAr).perform();
            hold(1200);
        }
        if (!sNameAr.getAttribute("validation").contains("required")) {
            new Actions(driver).doubleClick(sNameAr).perform();
            hold(1200);
        }
        if (!tNameAr.getAttribute("validation").contains("required")) {
            new Actions(driver).doubleClick(tNameAr).perform();
            hold(1200);
        }
        if (!familyNameAr.getAttribute("validation").contains("required")) {
            new Actions(driver).doubleClick(familyNameAr).perform();
            hold(1200);
        }

        hold(500);
        softAssert.assertTrue(sNameEng.getAttribute("validation").contains("required"), "- Validation In 'Second Name' NOT required");
        softAssert.assertTrue(tNameEng.getAttribute("validation").contains("required"), "- Validation In 'Third Name' NOT required");
        softAssert.assertTrue(familyNameEng.getAttribute("validation").contains("required"), "- Validation In 'Family Name' NOT required");
        softAssert.assertTrue(sNameAr.getAttribute("validation").contains("required"), "- Validation In 'Second Name Arabic' NOT required");
        softAssert.assertTrue(tNameAr.getAttribute("validation").contains("required"), "- Validation In 'Third Name Arabic' NOT required");
        softAssert.assertTrue(familyNameAr.getAttribute("validation").contains("required"), "- Validation In 'Family Name Arabic' NOT required");

        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        softAssert.assertTrue(fNameEng.getAttribute("class").contains("validationErrorCSS"), "- 'First Name' Border Color should be 'RED'");
        hold(200);
        setText(fNameEng, employeeCode+"first");
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        softAssert.assertTrue(sNameEng.getAttribute("class").contains("validationErrorCSS"), "- 'Second Name' Border Color should be 'RED'");
        hold(200);
        setText(sNameEng, employeeCode);
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        softAssert.assertTrue(tNameEng.getAttribute("class").contains("validationErrorCSS"), "- 'Third Name' Border Color should be 'RED'");
        hold(200);
        setText(tNameEng, employeeCode);
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        softAssert.assertTrue(familyNameEng.getAttribute("class").contains("validationErrorCSS"), "- 'Family Name' Border Color should be 'RED'");
        hold(200);
        setText(familyNameEng, employeeCode+"last");
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        softAssert.assertTrue(fNameAr.getAttribute("class").contains("validationErrorCSS"), "- 'First Name Arabic' Border Color should be 'RED'");
        hold(200);
        setText(fNameAr, employeeCode+"firstAr");
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        softAssert.assertTrue(sNameAr.getAttribute("class").contains("validationErrorCSS"), "- 'Second Name Arabic' Border Color should be 'RED'");
        hold(200);
        setText(sNameAr, employeeCode);
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        softAssert.assertTrue(tNameAr.getAttribute("class").contains("validationErrorCSS"), "- 'Third Name Arabic' Border Color should be 'RED'");
        hold(200);
        setText(tNameAr, employeeCode);
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        softAssert.assertTrue(familyNameAr.getAttribute("class").contains("validationErrorCSS"), "- 'Family Name Arabic' Border Color should be 'RED'");
        hold(200);
        setText(familyNameAr, employeeCode+"lastAr");

        softAssert.assertTrue(driver.findElement(By.name("social_status")).getAttribute("validation").equals("required"), "- Validation In 'Marital Status' NOT required");
        softAssert.assertTrue(driver.findElement(By.name("sex")).getAttribute("validation").equals("required"), "- Validation In 'Gender' NOT required");
        softAssert.assertTrue(birth_date.getAttribute("validation").contains("required"), "- Validation In 'Birth Date' NOT required");

        scrollToElement(birth_date);

        if(!driver.findElement(By.name("nationality")).getAttribute("validation").contains("required")){
            new Actions(driver).doubleClick(driver.findElement(By.id("pay_employees_nationality"))).perform();
            hold(1200);
        }
        if (!driver.findElement(By.name("relegion")).getAttribute("validation").contains("required")) {
            new Actions(driver).doubleClick(driver.findElement(By.id("pay_employees_relegion"))).perform();
            hold(1200);
        }
        if (!mobileE.getAttribute("validation").contains("required")) {
            new Actions(driver).doubleClick(driver.findElement(By.id("pay_employees_mobile"))).perform();
            hold(1200);
        }
        if (!emailE.getAttribute("validation").contains("required")) {
            new Actions(driver).doubleClick(driver.findElement(By.id("pay_employees_Email"))).perform();
            hold(1200);
        }

        scrollToElement(empCode);
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        hold(200);
        selectOption(marital_StatusE, "Single");
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        hold(200);
        selectOption(sexE,"Male");
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        hold(200);
        selectOption(nationalityE, "Jordanian");
        hold(200);

        softAssert.assertTrue(driver.findElement(By.name("nationality")).getAttribute("validation").contains("required"), "- Validation In 'Nationality' NOT required");
        softAssert.assertTrue(driver.findElement(By.name("relegion")).getAttribute("validation").contains("required"), "- Validation In 'Religion' NOT required");
        softAssert.assertTrue(mobileE.getAttribute("validation").contains("required"), "- Validation In 'Mobile' NOT required");
        softAssert.assertTrue(emailE.getAttribute("validation").contains("required"), "- Validation In 'Email' NOT required");

        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        hold(200);
        selectOption(relegionE, "Islam");
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        hold(200);
        setText(mobileE, "0798"+randomNumber());
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        hold(200);
        setText(emailE, "test"+randomNumber()+"@gmail.com");
        clickOn(nextButton);
        hold(300);
        clickOn(alertOkBtn);
        hold(200);
        setText(birth_date, "01/01/1990");
        hold(300);
        scrollToElement(empCode);
        clickOn(nextButton);

        hold(300);
        elementWait(siteE);
        softAssert.assertTrue(siteE.isDisplayed(), "There is a problem after click next, should be go to Employment Information");
        hold(500);
        clickOn(driver.findElement(By.xpath("//button[contains(text(), 'Previous')]")));
        hold(300);

        scrollToElement(birth_date);
        new Actions(driver).doubleClick(driver.findElement(By.id("pay_employees_Email"))).perform();
        hold(300);
        new Actions(driver).doubleClick(driver.findElement(By.id("pay_employees_mobile"))).perform();
        hold(300);
        new Actions(driver).doubleClick(driver.findElement(By.id("pay_employees_relegion"))).perform();
        hold(300);
        new Actions(driver).doubleClick(driver.findElement(By.id("pay_employees_nationality"))).perform();
        hold(300);
        scrollToElement(empCode);
        new Actions(driver).doubleClick(familyNameAr).perform();
        hold(300);
        new Actions(driver).doubleClick(tNameAr).perform();
        hold(300);
        new Actions(driver).doubleClick(sNameAr).perform();
        hold(300);
        new Actions(driver).doubleClick(fNameAr).perform();
        hold(300);
        new Actions(driver).doubleClick(familyNameEng).perform();
        hold(300);
        new Actions(driver).doubleClick(tNameEng).perform();
        hold(300);
        new Actions(driver).doubleClick(sNameEng).perform();
        hold(300);

        softAssert.assertAll();

    }

    public void languageDescriptionIsMandatory(String englishOrArabic){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings", "System Parameters");
        systemParameters = new SystemParameters();
        if(englishOrArabic.equalsIgnoreCase("Arabic") || englishOrArabic.equalsIgnoreCase("English") || englishOrArabic.equalsIgnoreCase("Both")){
            systemParameters.mandatoryFields(englishOrArabic);
        }else{
            systemParameters.mandatoryFields("English");
        }
        hold(500);
        mainMenu.mainMenu("Employees", "Personnel Information");

        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(backToPersonalInformationTab);

        if(englishOrArabic.equalsIgnoreCase("English")){

            softAssert.assertTrue(fNameEng.getAttribute("validation").contains("required"), "- The English First Name is NOT Mandatory!");
            clickOn(spousePage);
            hold(300);
            elementWait(firstNameSpouse);
            softAssert.assertTrue(firstNameSpouse.getAttribute("validation").contains("required"), "- The English First Name Spouse is NOT Mandatory!");
            clickOn(childrenPage);
            hold(300);
            elementWait(firstNameChildren);
            softAssert.assertTrue(firstNameChildren.getAttribute("validation").contains("required"), "- The English First Name Children is NOT Mandatory!");
            clickOn(dependentsPage);
            hold(300);
            elementWait(firstNameDependents);
            softAssert.assertTrue(firstNameDependents.getAttribute("validation").contains("required"), "- The English First Name Dependents is NOT Mandatory!");
            clickOn(experiencesTab);
            hold(300);
            clickOn(practicalExperiencesPage);
            hold(500);
            elementWait(englishPracticalExperience);
            softAssert.assertTrue(englishPracticalExperience.getAttribute("validation").contains("required"), "- The English Practical Experience in 'Experience - Practical Experience' is NOT Mandatory!");
            clickOn(otherTab);
            hold(300);
            clickOn(AdditionalInfoPage);
            hold(500);
            elementWait(englishDescriptionAdditionalInfo);
            softAssert.assertTrue(englishDescriptionAdditionalInfo.getAttribute("validation").contains("required"), "- The English Description in 'Other - Additional Information' is NOT Mandatory!");

        } else if (englishOrArabic.equalsIgnoreCase("Arabic")) {

            softAssert.assertTrue(fNameAr.getAttribute("validation").contains("required"), "- The Arabic First Name is NOT Mandatory!");
            clickOn(spousePage);
            hold(300);
            elementWait(firstNameArSpouse);
            softAssert.assertTrue(firstNameArSpouse.getAttribute("validation").contains("required"), "- The Arabic First Name Spouse is NOT Mandatory!");
            clickOn(childrenPage);
            hold(300);
            elementWait(firstNameArChildren);
            softAssert.assertTrue(firstNameArChildren.getAttribute("validation").contains("required"), "- The Arabic First Name Children is NOT Mandatory!");
            clickOn(dependentsPage);
            hold(300);
            elementWait(firstNameArDependents);
            softAssert.assertTrue(firstNameArDependents.getAttribute("validation").contains("required"), "- The Arabic First Name Dependents is NOT Mandatory!");
            clickOn(experiencesTab);
            hold(300);
            clickOn(practicalExperiencesPage);
            hold(500);
            elementWait(arabicPracticalExperience);
            softAssert.assertTrue(arabicPracticalExperience.getAttribute("validation").contains("required"), "- The Arabic Practical Experience in 'Experience - Practical Experience' is NOT Mandatory!");

        } else if(englishOrArabic.equalsIgnoreCase("Both")){

            softAssert.assertTrue(fNameEng.getAttribute("validation").contains("required"), "- The English First Name is NOT Mandatory!");
            softAssert.assertTrue(fNameAr.getAttribute("validation").contains("required"), "- The Arabic First Name is NOT Mandatory!");
            clickOn(spousePage);
            hold(300);
            elementWait(firstNameSpouse);
            softAssert.assertTrue(firstNameSpouse.getAttribute("validation").contains("required"), "- The English First Name Spouse is NOT Mandatory!");
            softAssert.assertTrue(firstNameArSpouse.getAttribute("validation").contains("required"), "- The Arabic First Name Spouse is NOT Mandatory!");
            clickOn(childrenPage);
            hold(300);
            elementWait(firstNameChildren);
            softAssert.assertTrue(firstNameChildren.getAttribute("validation").contains("required"), "- The English First Name Children is NOT Mandatory!");
            softAssert.assertTrue(firstNameArChildren.getAttribute("validation").contains("required"), "- The Arabic First Name Children is NOT Mandatory!");
            clickOn(dependentsPage);
            hold(300);
            elementWait(firstNameDependents);
            softAssert.assertTrue(firstNameDependents.getAttribute("validation").contains("required"), "- The English First Name Dependents is NOT Mandatory!");
            softAssert.assertTrue(firstNameArDependents.getAttribute("validation").contains("required"), "- The Arabic First Name Dependents is NOT Mandatory!");
            clickOn(experiencesTab);
            hold(300);
            clickOn(practicalExperiencesPage);
            hold(500);
            elementWait(englishPracticalExperience);
            softAssert.assertTrue(englishPracticalExperience.getAttribute("validation").contains("required"), "- The English Practical Experience in 'Experience - Practical Experience' is NOT Mandatory!");
            softAssert.assertTrue(arabicPracticalExperience.getAttribute("validation").contains("required"), "- The Arabic Practical Experience in 'Experience - Practical Experience' is NOT Mandatory!");
            clickOn(otherTab);
            hold(300);
            clickOn(AdditionalInfoPage);
            hold(500);
            elementWait(englishDescriptionAdditionalInfo);
            softAssert.assertTrue(englishDescriptionAdditionalInfo.getAttribute("validation").contains("required"), "- The English Description in 'Other - Additional Information' is NOT Mandatory!");

        }

        softAssert.assertAll();

    }

    public void citizenNationality(boolean citizenOrNot){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        if(citizenOrNot){
            personalInformation("Single", "Male", "Jordanian",
                    "", "", "", "", "01/10/1992");
        } else {
            personalInformation("Single", "Male", "Egyptian",
                    "", "", "", "", "01/10/1992");
        }

        Assert.assertTrue(siteE.isDisplayed(), "Failed go to Employment Information");

        employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        hold(300);
        clickOn(otherTab);
        hold(300);
        clickOn(miscellaneousPage);
        hold(500);
        elementWaitAdvanced(By.id("citizen"));

        if(citizenOrNot){
            Assert.assertTrue(citizenCheck.isSelected(), "- The Citizen is NOT Checked in 'Other - Miscellaneous', it should be Checked because the employee is Citizen");
        }else {
            Assert.assertFalse(citizenCheck.isSelected(), "- The Citizen is Checked in 'Other - Miscellaneous', it should be NOT Checked because the employee is NOT Citizen");
        }

    }

    public void validateSalaryScaleWithPosition(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        employmentInformationWithoutSave("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "", "",
                "", "", "", "", "Full Stack Developer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        hold(1000);

        softAssert.assertEquals(classificationE.getText(), "Class 1", "- Issue in Class, NOT same Position details");
        softAssert.assertEquals(degreeE.getText(), "Degree 1", "- Issue in Degree, NOT same Position details");
        softAssert.assertEquals(stepE.getAttribute("value"), "1", "- Issue in Step, NOT same Position details");

        softAssert.assertAll();

    }

    public void validateCategoryWithPosition(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1992");

        employmentInformationWithoutSave("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "", "",
                "", "", "", "", "Customer Support Officer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        hold(1000);

        softAssert.assertEquals(category1E.getText(), "Category 1", "- Issue in Category 1, NOT same Position details");
        softAssert.assertEquals(category2E.getText(), "Category 2", "- Issue in Category 2, NOT same Position details");

        softAssert.assertAll();

    }

    public void smartSearch(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        hold(300);
        goToFrame(frame);
        hold(300);
        clickOn(smartSearchPlace);
        hold(500);
        clickOn(smartSearchClearBtn);
        clickOn(smartSearchFiled);
        setText(smartSearchFiled, "auto000000");
        hold(1000);
        softAssert.assertEquals(smartSearchStatusImg.getAttribute("title").trim(), "Active Employee", "- Title NOT Contain 'Active Employee'");
        softAssert.assertTrue(smartSearchStatusImg.getAttribute("src").contains("drop-down-image-1.svg"), "- Incorrect status Icon for Active Employee");
        hold(500);
        clickOn(smartSearchClearBtn);
        hold(300);
        clickOn(smartSearchFiled);
        setText(smartSearchFiled, "auto000145");
        hold(1000);
        softAssert.assertEquals(smartSearchStatusImg.getAttribute("title").trim(), "Employee Transfer", "- Title NOT Contain 'Employee Transfer'");
        softAssert.assertTrue(smartSearchStatusImg.getAttribute("src").contains("transferd.svg"), "- Incorrect status Icon for Employee Transfer");
        hold(500);
        clickOn(smartSearchClearBtn);
        hold(300);
        clickOn(smartSearchFiled);
        setText(smartSearchFiled, "auto000003");
        hold(1000);
        softAssert.assertEquals(smartSearchStatusImg.getAttribute("title").trim(), "Terminated", "- Title NOT Contain 'Terminated'");
        softAssert.assertTrue(smartSearchStatusImg.getAttribute("src").contains("drop-down-image-4.svg"), "- Incorrect status Icon for Employee Terminated");
        hold(500);
        clickOn(smartSearchClearBtn);
        hold(300);
        clickOn(smartSearchFiled);
        setText(smartSearchFiled, "auto000146");
        hold(1000);
        softAssert.assertEquals(smartSearchStatusImg.getAttribute("title").trim(), "Stopped", "- Title NOT Contain 'Stopped'");
        softAssert.assertTrue(smartSearchStatusImg.getAttribute("src").contains("drop-down-img-2.svg"), "- Incorrect status Icon for Employee Stopped");
        hold(500);
        clickOn(smartSearchClearBtn);
        hold(300);
        clickOn(smartSearchFiled);
        setText(smartSearchFiled, "auto000148");
        hold(1000);
        softAssert.assertEquals(smartSearchStatusImg.getAttribute("title").trim(), "In Business Trip", "- Title NOT Contain 'In Business Trip'");
        softAssert.assertTrue(smartSearchStatusImg.getAttribute("src").contains("drop-down-image-3.svg"), "- Incorrect status Icon for Employee In Business Trip");
        hold(500);
        clickOn(smartSearchClearBtn);
        hold(300);
        clickOn(smartSearchFiled);
        setText(smartSearchFiled, "auto000149");
        hold(1000);
        softAssert.assertEquals(smartSearchStatusImg.getAttribute("title").trim(), "Vacation", "- Title NOT Contain 'Vacation'");
        softAssert.assertTrue(smartSearchStatusImg.getAttribute("src").contains("drop-down-image-3.svg"), "- Incorrect status Icon for Employee In Vacation");
        hold(500);
        clickOn(smartSearchClearBtn);
        hold(300);
        clickOn(smartSearchFiled);
        setText(smartSearchFiled, "auto000147");
        hold(1000);
        softAssert.assertEquals(smartSearchStatusImg.getAttribute("title").trim(), "In Notice Period", "- Title NOT Contain 'In Notice Period'");
        softAssert.assertTrue(smartSearchStatusImg.getAttribute("src").contains("drop-down-img-2.svg"), "- Incorrect status Icon for Employee In Notice Period");
        hold(500);
        clickOn(smartSearchClearBtn);
        hold(300);
        clickOn(smartSearchFiled);
        setText(smartSearchFiled, "auto000150");
        hold(1000);
        softAssert.assertEquals(smartSearchStatusImg.getAttribute("title").trim(), "Suspended", "- Title NOT Contain 'Suspended'");
        softAssert.assertTrue(smartSearchStatusImg.getAttribute("src").contains("drop-down-img-2.svg"), "- Incorrect status Icon for Employee Suspended");

        softAssert.assertAll();

    }

    public void advanceSearch(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        hold(300);
        goToFrame(frame);
        hold(300);
        clickOn(advanceSearchBtn);
        hold(300);
        goToFrame(searchEmployeePopupFrame);
        hold(300);
        elementWaitAdvanced(By.id("xl"));
        clickOn(filterInSearchBox);
        hold(300);
        elementWaitAdvanced(By.id("site_1"));
        Select Site = new Select(driver.findElement(By.id("site_1")));
        Select Project = new Select(driver.findElement(By.id("Project_1")));
        Select Department = new Select(driver.findElement(By.id("department_1")));
        Select Section = new Select(driver.findElement(By.id("section_1")));
        Select Division = new Select(driver.findElement(By.id("division_1")));
        Select Unit = new Select(driver.findElement(By.id("units_1")));
        Select Sub_Section = new Select(driver.findElement(By.id("sub_section_1")));
        Select Sub_Division = new Select(driver.findElement(By.id("sub_division_1")));
        Select Sub_Unit = new Select(driver.findElement(By.id("sub_unit_1")));
        Select Office = new Select(driver.findElement(By.id("office_1")));
        Select Team = new Select(driver.findElement(By.id("team_1")));
        Select Position = new Select(driver.findElement(By.id("position_1")));
        Select Main_Category = new Select(driver.findElement(By.name("FDimension")));
        Select Sub_Category = new Select(driver.findElement(By.name("SDimension")));
        Select Classification = new Select(driver.findElement(By.name("classification")));
        Select Degree = new Select(driver.findElement(By.name("degree")));
        Select Gender = new Select(driver.findElement(By.name("sex_2")));
        Select Employee_Status = new Select(driver.findElement(By.id("emp_status_search")));
        Select Nationality = new Select(driver.findElement(By.name("nationalityx")));
        Select Citizen = new Select(driver.findElement(By.name("citizen")));

        Site.selectByVisibleText("Amman");
        hold(300);
        Project.selectByVisibleText("Project 1");
        hold(300);
        Department.selectByVisibleText("Development");
        hold(300);
        Section.selectByVisibleText("Mobile Development");
        hold(300);
        Division.selectByVisibleText("Mobile Division");
        hold(300);
        Unit.selectByVisibleText("Mobile Unit");
        hold(300);
        Sub_Section.selectByVisibleText("Mobile Sub Section");
        hold(300);
        Sub_Division.selectByVisibleText("Mobile Sub Division");
        hold(300);
        Sub_Unit.selectByVisibleText("Mobile Sub Unit");
        hold(300);
        Office.selectByVisibleText("Mobile Office");
        hold(300);
        Team.selectByVisibleText("Mobile Team");
        hold(300);
        Position.selectByVisibleText("Flutter Developer");
        hold(300);
        Main_Category.selectByVisibleText("Advance Search Main Category");
        hold(300);
        Sub_Category.selectByVisibleText("Advance Search Sub Category");
        hold(300);
        Classification.selectByVisibleText("Class 1");
        hold(300);
        Degree.selectByVisibleText("Degree 1");
        hold(300);
        scrollToElement(driver.findElement(By.id("sub_division_1")));
        hold(300);
        Gender.selectByVisibleText("Male");
        hold(300);
        Employee_Status.selectByVisibleText("Active Employee");
        hold(300);
        Nationality.selectByVisibleText("American");
        hold(300);
        Citizen.selectByVisibleText("Not Citizen");
        hold(500);
        clickOn(searchBtnInSearchBox);
        hold(500);
        scrollToElement(filterInSearchBox);
        hold(200);
        clickOn(filterInSearchBox);
        hold(300);
        softAssert.assertTrue(checkElementIfPresent(By.xpath("//div[contains(@onclick, 'auto000155')]")), "- Search Should be retrieve this Emp: auto000155");
        hold(300);
        backToParentIFrame();
        ////// To Close Advance Search POPUP by Javascript /////
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.closeModal()", "");
        hold(300);
        closeIFrame();
        mainMenu.mainMenu("Employees", "Personnel Information");

        hold(300);
        goToFrame(frame);
        hold(300);
        clickOn(advanceSearchBtn);
        hold(300);
        goToFrame(searchEmployeePopupFrame);
        hold(300);
        elementWaitAdvanced(By.id("xl"));
        clickOn(filterInSearchBox);
        hold(300);
        elementWaitAdvanced(By.id("site_1"));

        Select Site2 = new Select(driver.findElement(By.id("site_1")));
        Select Department2 = new Select(driver.findElement(By.id("department_1")));
        Select Section2 = new Select(driver.findElement(By.id("section_1")));
        Select Division2 = new Select(driver.findElement(By.id("division_1")));
        Select Position2 = new Select(driver.findElement(By.id("position_1")));
        Select Employee_Status2 = new Select(driver.findElement(By.id("emp_status_search")));
        Site2.selectByVisibleText("Amman");
        hold(300);
        Department2.selectByVisibleText("Advance Search Department");
        hold(300);
        Section2.selectByVisibleText("Advance Search Section");
        hold(300);
        Division2.selectByVisibleText("Advance Search Division");
        hold(300);
        Position2.selectByVisibleText("Advance Search Position");
        hold(300);
        scrollToElement(driver.findElement(By.id("sub_division_1")));
        hold(300);
        Employee_Status2.selectByVisibleText("Active Employee");
        hold(500);
        clickOn(searchBtnInSearchBox);
        hold(500);
        scrollToElement(filterInSearchBox);
        hold(200);
        clickOn(filterInSearchBox);
        hold(300);
        softAssert.assertTrue(longWaitElementAdvance(By.xpath("//div[contains(@onclick, 'auto000152')]")), "- Search Should be retrieve this Emp: auto000152");
        softAssert.assertAll();

    }

    public void executivePayrollAdvanceSearch(){

        login = new Login();
        login.ali3User();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        hold(300);
        goToFrame(frame);
        hold(300);
        clickOn(advanceSearchBtn);
        hold(300);
        goToFrame(searchEmployeePopupFrame);
        hold(1000);
        elementWaitAdvanced(By.xpath("//div[contains(@onclick, 'parent.go_selected_user')]"));
        hold(300);
        elementWaitAdvanced(By.id("xl"));
        clickOn(filterInSearchBox);
        hold(300);
        elementWaitAdvanced(By.id("site_1"));
        Select Site = new Select(driver.findElement(By.id("site_1")));
        hold(500);
        Site.selectByVisibleText("Zarqa");
        hold(500);
        scrollToElement(driver.findElement(By.id("sub_division_1")));
        hold(300);
        clickOn(searchBtnInSearchBox);
        hold(500);
        scrollToElement(filterInSearchBox);
        clickOn(filterInSearchBox);
        hold(8000);
        implicitWaitChanging(1000);
        softAssert.assertEquals(employeeNameInSearchBox.size(), 0, "- There is an employees in Site 'Zarqa' is appear is search.");
        implicitWaitChanging(10000);

        clickOn(driver.findElement(By.id("btn-closex")));
        hold(300);
        driver.switchTo().defaultContent();
        hold(200);
        goToFrame(frame);
        hold(300);
        clickOn(personalAndEmploymentTab);
        hold(500);
        elementWaitDisappear(By.id("LoadingElement"));
        hold(300);
        clickOn(advanceSearchBtn);
        hold(300);
        goToFrame(searchEmployeePopupFrame);
        hold(1000);
        elementWaitAdvanced(By.xpath("//div[contains(@onclick, 'parent.go_selected_user')]"));
        hold(300);
        elementWaitAdvanced(By.id("xl"));
        clickOn(filterInSearchBox);
        hold(300);
        elementWaitAdvanced(By.id("site_1"));
        hold(500);
        scrollToElement(driver.findElement(By.id("sub_division_1")));
        hold(300);
        new Select(driver.findElement(By.name("FDimension"))).selectByVisibleText("Execitive Payroll Main Category");
        hold(500);
        clickOn(searchBtnInSearchBox);
        hold(500);
        scrollToElement(filterInSearchBox);
        clickOn(filterInSearchBox);
        hold(8000);
        implicitWaitChanging(1000);
        softAssert.assertEquals(employeeNameInSearchBox.size(), 0, "- There is an employees in 'Execitive Payroll Main Category' is appear is search.");
        implicitWaitChanging(10000);

        clickOn(driver.findElement(By.id("btn-closex")));
        hold(300);
        driver.switchTo().defaultContent();
        hold(200);
        goToFrame(frame);
        hold(300);
        clickOn(personalAndEmploymentTab);
        hold(500);
        elementWaitDisappear(By.id("LoadingElement"));
        hold(300);
        clickOn(advanceSearchBtn);
        hold(300);
        goToFrame(searchEmployeePopupFrame);
        hold(1000);
        elementWaitAdvanced(By.xpath("//div[contains(@onclick, 'parent.go_selected_user')]"));
        hold(300);
        elementWaitAdvanced(By.id("xl"));
        clickOn(filterInSearchBox);
        hold(300);
        elementWaitAdvanced(By.id("site_1"));
        hold(500);
        scrollToElement(driver.findElement(By.id("sub_division_1")));
        hold(300);
        new Select(driver.findElement(By.id("position_1"))).selectByVisibleText("Executive Payroll Position");
        hold(500);
        clickOn(searchBtnInSearchBox);
        hold(500);
        scrollToElement(filterInSearchBox);
        clickOn(filterInSearchBox);
        hold(8000);
        implicitWaitChanging(1000);
        softAssert.assertEquals(employeeNameInSearchBox.size(), 0, "- There is an employees in 'Executive Payroll Position' is appear is search.");
        implicitWaitChanging(10000);

        softAssert.assertAll();

    }

    public void executivePayrollAddNewEmployee(){

        login = new Login();
        login.ali3User();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");

        selectOption(siteE, "Zarqa", Keys.ARROW_DOWN);
        selectOption(departmentE, "Quality");
        selectOption(sectionE, "Quality Control");
        selectOption(positionE, "Software Test Engineer");
        hiring_dateE.clear();
        hold(300);
        setText(hiring_dateE, "01/01/2020");

        scrollToElement(empCode);
        hold(300);
        clickOn(saveBtn);
        hold(500);
        elementWaitDisappear(By.id("LoadingElement"));
        hold(500);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Employees", "Personnel Information");
        hold(500);
        goToFrame(frame);
        hold(500);
        elementWait(empCode);
        hold(300);
        empCode.clear();
        hold(400);
        setText(empCode, employeeCode);
        hold(300);
        setText(empCode, Keys.TAB);
        hold(500);
        softAssert.assertTrue(driver.findElement(By.xpath("//label[contains(text(), 'You Are Not Authorized To View This Employee')]")).isDisplayed(), "This Alert: 'You Are Not Authorized To View This Employee' should be Appear");
        hold(300);
        driver.switchTo().defaultContent();

        clickOn(logout);
        hold(300);
        elementWaitAdvanced(By.id("userid"));
        hold(200);
        login.ali1User();
        menaModules.menaPAY();
        mainMenu.mainMenu("Employees", "Personnel Information");
        hold(500);
        goToFrame(frame);
        hold(500);
        elementWait(empCode);
        hold(300);
        empCode.clear();
        hold(400);
        setText(empCode, employeeCode);
        hold(300);
        setText(empCode, Keys.TAB);
        hold(500);
        softAssert.assertTrue(CheckActiveEmployee.isDisplayed(), "- Issue 'employee NOT Appear data', the employee should be appear data to this user: ali1");

        softAssert.assertAll();

    }

    public void logout(){

        closeIFrame();
        clickOn(logout);
        hold(500);

    }

    public void createNewEmployeeByAutoSerial(String MaritalStatus, String Gender, String Nationality, String Religion, String Mobile, String Email,
                                              String DirectManager, String BirthDate, String site, String department, String section, String division, String unit,
                                              String subSection, String subDivision, String subUnit, String office, String team,
                                              String category1, String category2, String category3, String contractType, String classification,
                                              String degree, String step, String position, String hiringDate, String employmentDate,
                                              String workType, String project, String currency, String contractStartDate){

        goToFrame(frame);
        hold(500);
        elementWaitAdvanced(By.id("employee_code"));
        hold(300);
        employeeCode = empCode.getAttribute("value");

        setText(fNameEng, employeeCode);
        setText(sNameEng, employeeCode);
        setText(tNameEng, employeeCode);
        setText(familyNameEng, employeeCode);
        setText(fNameAr, employeeCode);
        setText(sNameAr, employeeCode);
        setText(tNameAr, employeeCode);
        setText(familyNameAr, employeeCode);

        selectOption(marital_StatusE, MaritalStatus);
        maritalStatus = MaritalStatus;
        selectOption(sexE,Gender);
        if(!Nationality.isEmpty()){
            selectOption(nationalityE, Nationality);
        }
        if(!Religion.isEmpty()){
            selectOption(relegionE, Religion);
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
        setText(birth_date, BirthDate);
        employeePicture.sendKeys(uploadRandomImage());
        hold(300);
        scrollToElement(empCode);
        clickOn(nextButton);

        elementWaitAdvanced(By.id("select2-site_1-container"));
        if(site.equalsIgnoreCase("Zarqa")){
            selectOption(siteE, site, Keys.ARROW_DOWN);
        }else{
            selectOption(siteE, site);
        }
        selectOption(departmentE, department);
        selectOption(sectionE, section);
        if(!division.isEmpty()){
            selectOption(divisionE, division);
        }
        if(!unit.isEmpty()){
            selectOption(unitsE, unit);
        }
        if(!subSection.isEmpty()){
            selectOption(sub_sectionE, subSection);
        }
        if(!subDivision.isEmpty()){
            selectOption(sub_divisionE, subDivision);
        }
        if(!subUnit.isEmpty()){
            selectOption(sub_unitE, subUnit);
        }
        if(!office.isEmpty()){
            selectOption(officeE, office);
        }
        if(!team.isEmpty()){
            selectOption(teamE, team);
        }
        if(!classification.isEmpty()){
            selectOption(classificationE, classification);
        }
        if(!degree.isEmpty()){
            selectOption(degreeE, degree);
        }
        if(!step.isEmpty()){
            setText(stepE, step);
        }
        selectOption(positionE, position);
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
            selectOption(work_typeE, workType);
        }
        if(!project.isEmpty()){
            selectOption(projectE, project);
        }
        if(!currency.isEmpty()){
            selectOption(currencyE, currency);
        }
        if(!category1.isEmpty()){
            selectOption(category1E, category1);
        }
        if(!category2.isEmpty()){
            selectOption(category2E, category2);
        }
        if(!category3.isEmpty()){
            selectOption(category3E, category3);
        }
        if(!contractType.isEmpty()){
            selectOption(contract_typeE, contractType);
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

        scrollToElement(empCode); /// Scroll up to the 'Employee Code' element to see the 'Save' button in the screen
        clickOn(saveBtn);
        elementWaitAdvanced(By.xpath("//label[contains(text(),'Active Employee')]"));
        empName = FirstAndLastName.getText().trim();

        setLog("Personal Information"
                +" - Marital Status: "+MaritalStatus
                +" - Gender: "+Gender
                +" - Nationality: "+Nationality
                +" - Religion: "+Religion
                +" - Mobile: "+Mobile
                +" - Email: "+Email
                +" - Direct Manager: "+DirectManager
                +" - Birth Date: "+BirthDate);

        setLog("Employment Information"
                +" - Site: "+site
                +" - Department: "+department
                +" - Section: "+section
                +" - Division: "+division
                +" - Unit: "+unit
                +" - Sub Section: "+subSection
                +" - Sub Division: "+subDivision
                +" - Sub Unit: "+subUnit
                +" - Office: "+office
                +" - Team: "+team
                +" - Category1: "+category1
                +" - Category2: "+category2
                +" - Category3: "+category3
                +" - Contract Type: "+contractType
                +" - Classification: "+classification
                +" - Degree: "+degree
                +" - Step: "+step
                +" - Position: "+position
                +" - Hiring Date: "+hiringDate
                +" - Employment Date: "+employmentDate
                +" - Work Type: "+workType
                +" - Project: "+project
                +" - Currency: "+currency
                +" - Contract Start Date: "+contractStartDate);

    }

}
