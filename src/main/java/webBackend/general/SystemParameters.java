package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;
import static utilities.MssqlConnect.clientIdChanger;
import static utilities.VersionGetter.liteGetter;

public class SystemParameters extends WebBase {

    @FindBy(id = "body_frame")
    WebElement frame;
    @FindBy(xpath = "//td[text()='When Adding a New Employee Record']")
    WebElement WhenAddingNewEmployeeRecord;
    @FindBy(xpath = "//td[text()='Work Year Setup']")
    WebElement workYearSetup;
    @FindBy(xpath = "//input[@name='is_calendar_days2' and @value='1']")
    WebElement workingDaysPerMonth;
    @FindBy(name = "day_hours")
    WebElement workingHoursPerDayE;
    @FindBy(name = "cut_off_da_te")
    WebElement cutOffDateE;
    @FindBy(name = "month_days2")
    WebElement workingHoursPerDayAmount;
    @FindBy(id = "calc_based_on_calendarInHiring")
    WebElement calc_based_on_calendarInHiring;
    @FindBy(id = "calc_based_on_calendarInTerm")
    WebElement calc_based_on_calendarInTerm;
    @FindBy(xpath = "//input[contains(@onclick, 'open_hours_setup') and @type='button']")
    WebElement hoursSetupBtn;
    @FindBy(xpath = "(//td[contains(@onclick, 'colapss_setup')])[6]")
    WebElement calculationOptionsTab;
    @FindBy(name = "is_setup_overtime_hours")
    WebElement is_setup_overtime_hours;
    @FindBy(id = "is_calendar_days_overtime2")
    WebElement is_calendar_days_overtime;
    @FindBy(id = "is_calendar_days_overtime1")
    WebElement is_30_days_overtime;
    @FindBy(name = "month_days_overtime")
    WebElement month_days_overtime;
    @FindBy(name = "day_hours_overtime")
    WebElement day_hours_overtime;
    @FindBy(name = "save")
    WebElement saveBtn;
    @FindBy(name = "exit")
    WebElement exitBtn;
    @FindBy(xpath = "//input[@name='is_calendar_days2' and @value='2']")
    WebElement calendarMethod;
    @FindBy(name = "stb_by_default")
    WebElement automaticallySubmitEmployeeToEOSCheckbox;
    @FindBy(id = "stb_type_by_default")
    WebElement automaticallySubmitEmployeeToEOSSelect;
    @FindBy(name = "insurance_by_default")
    WebElement automaticallySubmitEmployeeToHealthInsuranceCheckbox;
    @FindBy(id = "insurance_type_by_default")
    WebElement automaticallySubmitEmployeeToHealthInsuranceSelect;
    @FindBy(name = "social_by_default")
    WebElement automaticallySubmitCitizenEmployeeToGOSISecurityCheckbox;
    @FindBy(id = "social_type_by_default")
    WebElement automaticallySubmitCitizenEmployeeToGOSISecuritySelect;
    @FindBy(name = "non_citizen_social_by_default")
    WebElement automaticallySubmitNonCitizenEmployeeToGOSISecurityCheckbox;
    @FindBy(id = "non_citzen_social_type_default")
    WebElement automaticallySubmitNonCitizenEmployeeToGOSISecuritySelect;
    @FindBy(name = "tax_by_default")
    WebElement automaticallySubmitEmployeeToIncomeTaxCheckbox;
    @FindBy(name = "citizen_nationality")
    WebElement citizenNationalityE;
    @FindBy(xpath = "//td[text()='Configuration System']")
    WebElement configurationSystem;
    @FindBy(xpath = "//td[text()='Mandatory Fields']")
    WebElement mandatoryFields;
    @FindBy(xpath = "//a[@href='child_allowance.php']")
    WebElement familySetup;
    @FindBy(id = "allow_notify_hr")
    WebElement allow_notify_hr;
    @FindBy(id = "allow_remind_days")
    WebElement allow_remind_days_hr;
    @FindBy(id = "allow_automatic")
    WebElement allow_automatic;
    @FindBy(id = "allow_notify_emp")
    WebElement allow_notify_emp;
    @FindBy(id = "allow_remind_days_emp")
    WebElement allow_remind_days_emp;
    @FindBy(name = "no_edit_familly_allow")
    WebElement doNotAllowToChangeTheDefaultAmountE;
    @FindBy(name = "wife_allow_code")
    WebElement spouseAllowanceE;
    @FindBy(name = "child_allow_code")
    WebElement childAllowanceE;
    @FindBy(name = "family_allowance_fixed_amount")
    WebElement addFixedAmountE;
    @FindBy(xpath = "//td[text()='Reports Setup']")
    WebElement reportsSetupList;
    @FindBy(name = "wife_allow_amount")
    WebElement wifeAllowAmount;
    @FindBy(name = "wife_all_allow")
    WebElement spousesAllowancesUpperLimitE;
    @FindBy(name = "extra_month")
    WebElement numberOfYearlySalariesE;
    @FindBy(id = "child_allow_amount")
    WebElement childrenAllowAmount;
    @FindBy(name = "GLAccount_To_EmployeeCode")
    WebElement GLAccount1IsEqualToEmployeeCodeCheckbox;
    @FindBy(id = "duplicate_gl_acount")
    WebElement doNotAllowGLAccountsDuplicationsCheckbox;
    @FindBy(xpath = "//input[@name='child_allowance_type'][@value='0']")
    WebElement childrenAllowancesTypeDefault;
    @FindBy(xpath = "//input[@name='child_allowance_type'][@value='1']")
    WebElement childrenAllowancesTypeChildSort;
    @FindBy(id = "from_allow_age")
    WebElement maleChildStartingAgeE;
    @FindBy(id = "allow_age")
    WebElement maleUpToAgeE;
    @FindBy(name = "allow_student_age")
    WebElement maleAgeForCollegeStudentsE;
    @FindBy(id = "from_allow_girl_age")
    WebElement femaleChildStartingAgeE;
    @FindBy(id = "allow_girl_age")
    WebElement femaleUpToAgeE;
    @FindBy(name = "allow_girl_student_age")
    WebElement femaleAgeForCollegeStudentsE;
    @FindBy(id = "child_sort")
    WebElement childSortDetailsBtn;
    @FindBy(name = "new")
    WebElement newBtn;
    @FindBy(xpath = "(//input[contains(@name, 'amount')])[last()]")
    WebElement childSortAmount;
    @FindBy(name = "child_all_allow")
    WebElement childrenAllowancesUpperLimitE;
    @FindBy(css = "[name='english_arabic_man'][value='1']")
    WebElement arabicDescriptionIsMandatory;
    @FindBy(xpath = "//img[contains(@src, 'images/ed_color_fg.gif')]")
    WebElement colorSelector;
    @FindBy(css = "[name='english_arabic_man'][value='2']")
    WebElement englishDescriptionIsMandatory;
    @FindBy(css = "[name='english_arabic_man'][value='3']")
    WebElement bothLanguageIsMandatory;
    @FindBy(name = "show_mandatory")
    WebElement colorMandatory;
    @FindBy(name = "min_age_hire")
    WebElement min_age_hire;
    @FindBy(name = "min_age_marry")
    WebElement min_age_marry;
    @FindBy(name = "max_age_hire")
    WebElement max_age_hire;
    @FindBy(xpath = "//select[@name='min_age_hire']/following-sibling::input[1]")
    WebElement notCitizenOption;
    @FindBy(xpath = "//select[@name='max_age_hire']/following-sibling::input[1]")
    WebElement maxNotCitizenOption;
    @FindBy(name = "notcitizen_min_age_hire")
    WebElement notCitizen_min_age_hire;
    @FindBy(name = "notcitizen_max_age_hire")
    WebElement notCitizen_max_age_hire;
    @FindBy(name = "Hierarchy_Start")
    WebElement hierarchyStartE;
    @FindBy(name = "show_tax_reports")
    WebElement incomeTaxE;
    @FindBy(name = "show_tax_service_reports")
    WebElement servicesTaxE;
    @FindBy(name = "show_national_contribution")
    WebElement nationalContibutionE;
    @FindBy(name = "show_insurance_reports")
    WebElement healthInsuranceE;
    @FindBy(name = "show_other_info_r3Tax_report")
    WebElement otherInfoR3TaxReportE;
    @FindBy(name = "show_social_reports")
    WebElement GOSIReportsE;
    @FindBy(name = "show_minus_net_salary")
    WebElement minusNetSalaryE;
    @FindBy(name = "show_prev_slips")
    WebElement onlyLastReleasedSalaryE;
    @FindBy(name = "seperateHousingInSalaryReports")
    WebElement distinguishHousingAccrualsE;
    @FindBy(name = "allow_print_save")
    WebElement employeeCanPrintSaveE;
    @FindBy(id = "save_report_as_csv")
    WebElement exportReportsInCSVFormatE;
    @FindBy(name = "repeat_header")
    WebElement repeatHeaderE;
    @FindBy(name = "working_hours_in_reports")
    WebElement workingHoursInReportsE;
    @FindBy(name = "hide_financial_data_reports")
    WebElement hideFinancialDataReportsE;
    @FindBy(name = "hide_emp_info_in_train_rep")
    WebElement hideClassificationInformationE;
    @FindBy(name = "show_thousand_separate")
    WebElement showThousandsSeparatorE;
    @FindBy(name = "report_header_dir")
    WebElement logoPositionE;
    @FindBy(id = "customized_report_header")
    WebElement useCustomizedReportE;
    @FindBy(id = "adjust_columns_width")
    WebElement adjustColumnsWidthE;
    @FindBy(name = "deny_account_duplicate")
    WebElement doNotAllowBankAccountNumberDuplicationsCheckbox;
    @FindBy(name = "Allow_Bank_Batch_Generation")
    WebElement allowBankBatchGenerationE;
    @FindBy(xpath = "//input[@name='salary_scale_based'][@value='1']")
    WebElement salaryScaleBasedOn_SalaryScaleStandard;
    @FindBy(xpath = "//input[@name='salary_scale_based'][@value='2']")
    WebElement salaryScaleBasedOn_Packages;
    @FindBy(id = "package_automatic")
    WebElement updateEmployeeInformationUponPackageChangeCheckbox;
    @FindBy(id = "MenaBox_iframe")
    WebElement MenaBoxIframe;
    @FindBy(name = "save")
    WebElement saveNotCitizen;
    @FindBy(name = "exit")
    WebElement exitNotCitizen;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "project_manger_acc_to")
    WebElement projectManagerIsDeterminedAccordingTo;
    @FindBy(xpath = "//a[@href='setup_extra_data.php']")
    WebElement otherOptions;
    @FindBy(xpath = "//a[@href='overtime_rule.php']")
    WebElement overtimeRule;
    @FindBy(id = "overtime_upper_limit_type1")
    WebElement overtimePerHours;
    @FindBy(id = "overtime_upper_limit_type0")
    WebElement overtimePerPercent;
    @FindBy(name = "social_security_starts")
    WebElement social_security_starts;
    @FindBy(name = "insurance_start")
    WebElement insurance_starts;
    @FindBy(name = "insurance_according_to_date")
    WebElement insurance_according_to_date;
    @FindBy(id = "overtime_upper_percent1")
    WebElement overtimeMonthUpperLimitHours;
    @FindBy(id = "overtime_upper_percent_day1")
    WebElement overtimeDayUpperLimitHours;
    @FindBy(id = "OvertimeUpperPercentWeek1")
    WebElement OvertimeWeekUpperLimitHours;
    @FindBy(id = "OvertimeUpperPercentWeek0")
    WebElement OvertimeWeekUpperLimitPercent;
    @FindBy(id = "overtime_upper_percent0")
    WebElement overtimeMonthUpperLimitPercent;
    @FindBy(id = "overtime_upper_percent_day0")
    WebElement overtimeDayUpperLimitPercent;
    @FindBy(id = "Allownce")
    WebElement overtimeFollowingAllowancesOptions;
    @FindBy(xpath = "//td[text()='Budget Options']")
    WebElement budgetOptionsList;
    @FindBy(xpath = "//input[@name='exceed_budget'][@value='0']")
    WebElement doNotCheckBudgetExceedingE;
    @FindBy(xpath = "//input[@name='exceed_budget'][@value='1']")
    WebElement neverExceedBudgetE;
    @FindBy(xpath = "//input[@name='exceed_budget'][@value='2']")
    WebElement alertWhenExceedingBudgetE;
    @FindBy(name = "hide_emp_pic")
    WebElement hideEmployeePicture;
    @FindBy(name = "lock_hiring_employment_date")
    WebElement lockHiringEmploymentDate;
    @FindBy(name = "cost_distribution_scope")
    WebElement employeeCostIsDistributedOnE;
    @FindBy(name = "cost_distribution_method")
    WebElement projectsCostIsDistributedOverE;
    @FindBy(xpath = "//td[text()='Family Setup']")
    WebElement familySetup_lite;
    String parentWindow;

    public void minimumAgeForHiringCitizenSetup(String citizenNationality, String minimumAgeForHiring,
                                                String minimumAgeNotCitizen, String maximumAgeForHiring,
                                                String maximumAgeNotCitizen){

        hold(300);
        elementWait(frame);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(WhenAddingNewEmployeeRecord);
        hold(300);
        Select citizen = new Select(citizenNationalityE);
        citizen.selectByVisibleText(citizenNationality);
        hold(300);
        clickOn(configurationSystem);
        hold(300);
        Select minAge = new Select(min_age_hire);
        minAge.selectByVisibleText(minimumAgeForHiring);
        hold(300);
        clickOn(notCitizenOption);
        hold(300);
        closeIFrame();
        goToFrame(MenaBoxIframe);
        elementWaitAdvanced(By.name("notcitizen_min_age_hire"));
        Select notCitizen = new Select(notCitizen_min_age_hire);
        notCitizen.selectByVisibleText(minimumAgeNotCitizen);
        hold(300);
        clickOn(saveNotCitizen);
        hold(300);
        clickOn(exitNotCitizen);
        closeIFrame();
        goToFrame(frame);
        Select maxAge = new Select(max_age_hire);
        maxAge.selectByVisibleText(maximumAgeForHiring);
        hold(300);
        clickOn(maxNotCitizenOption);
        hold(300);
        closeIFrame();
        goToFrame(MenaBoxIframe);
        elementWaitAdvanced(By.name("notcitizen_max_age_hire"));
        Select maxNotCitizen = new Select(notCitizen_max_age_hire);
        maxNotCitizen.selectByVisibleText(maximumAgeNotCitizen);
        hold(300);
        clickOn(saveNotCitizen);
        hold(300);
        clickOn(exitNotCitizen);
        closeIFrame();
        goToFrame(menuFrame);
        hold(300);
        clickOn(menuSave);
        hold(300);
        closeIFrame();

        setLog("Minimum Age For Hiring Citizen Setup - citizen Nationality: "+citizenNationality+" - minimum AgeFor Hiring: "+minimumAgeForHiring
        +" - minimum Age Not Citizen: "+minimumAgeNotCitizen+" - maximum Age For Hiring: "+maximumAgeForHiring+" - maximum Age Not Citizen: "+maximumAgeNotCitizen);

    }

    public void minimumAgeForMarriage(String minimumAgeForMarriage){

        hold(300);
        elementWaitAdvanced(By.id("body_frame"));
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        hold(500);
        clickOn(configurationSystem);
        hold(300);
        Select minAgeMarry = new Select(min_age_marry);
        minAgeMarry.selectByValue(minimumAgeForMarriage);
        hold(300);
        closeIFrame();
        goToFrame(menuFrame);
        hold(300);
        clickOn(menuSave);
        hold(300);
        closeIFrame();

        setLog("minimum Age For Marriage: "+minimumAgeForMarriage);

    }

    public void positionsAreRelatedToHierarchy(boolean enableOrNot){

        hold(300);
        elementWaitAdvanced(By.id("body_frame"));
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        hold(500);
        clickOn(driver.findElement(By.xpath("//a[@href='setup_names.php']")));
        hold(300);
        elementWaitAdvanced(By.id("Site_Desp_e"));
        scrollToElement(driver.findElement(By.name("positions_related_department")));
        hold(300);
        if(enableOrNot){
            if(!driver.findElement(By.name("positions_related_department")).isSelected()){
                clickOn(driver.findElement(By.name("positions_related_department")));
            }
        }else{
            if(driver.findElement(By.name("positions_related_department")).isSelected()){
                clickOn(driver.findElement(By.name("positions_related_department")));
            }
        }
        hold(300);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("positions Are Related To Hierarchy: "+enableOrNot);

    }

    public void changeProjectManagerIsDeterminedAccordingTo(String ProjectManagerIsDeterminedAccordingTo){

        hold(300);
        elementWait(frame);
        goToFrame(frame);
        hold(300);
        clickOn(otherOptions);
        elementWait(projectManagerIsDeterminedAccordingTo);
        hold(300);
        if(projectManagerIsDeterminedAccordingTo.isEnabled()){
            Select PMDA = new Select(projectManagerIsDeterminedAccordingTo);
            PMDA.selectByVisibleText(ProjectManagerIsDeterminedAccordingTo);
        }else{
            Assert.fail("You cannot change this option 'Project Manager Is Determined According to' because it's disabled");
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(300);
        clickOn(menuSave);
        hold(500);
        closeIFrame();
        hold(300);

        setLog("change Project Manager Is Determined According To: "+ProjectManagerIsDeterminedAccordingTo);

    }

    public void checkProjectManagerIsDisabled(){

        hold(300);
        elementWait(frame);
        goToFrame(frame);
        hold(300);
        clickOn(otherOptions);
        elementWait(projectManagerIsDeterminedAccordingTo);
        hold(300);
        Assert.assertFalse(projectManagerIsDeterminedAccordingTo.isEnabled(), "- This Option 'Project Manager Is Determined According to' Should be Disabled");
        closeIFrame();
        hold(300);

    }

    public void hideEmployeesPicturesInEmployeeSearchPage(boolean hidePicture){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(configurationSystem);
        scrollToElement(hideEmployeePicture);
        if(hidePicture){
            if(!hideEmployeePicture.isSelected()){
                hideEmployeePicture.click();
            }
        }else{
            if(hideEmployeePicture.isSelected()){
                hideEmployeePicture.click();
            }
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("hide Employees Pictures In Employee Search Page: "+hidePicture);

    }

    public void lockBothHiringDateAndEmploymentDateForTransferredEmployees(boolean LockHiringAndEmployment){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(configurationSystem);
        if(LockHiringAndEmployment){
            if(!lockHiringEmploymentDate.isSelected()){
                lockHiringEmploymentDate.click();
            }
        }else{
            if(lockHiringEmploymentDate.isSelected()){
                lockHiringEmploymentDate.click();
            }
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("lock Both Hiring Date And Employment Date For Transferred Employees: "+LockHiringAndEmployment);

    }

    public void mandatoryFields(String arabicOrEnglish){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(mandatoryFields);
        hold(300);

        if(!colorMandatory.isSelected()){
            clickOn(colorMandatory);
        }
        if(arabicOrEnglish.equalsIgnoreCase("english")){
            clickOn(englishDescriptionIsMandatory);
        } else if (arabicOrEnglish.equalsIgnoreCase("arabic")) {
            clickOn(arabicDescriptionIsMandatory);
        } else if (arabicOrEnglish.equalsIgnoreCase("Both")) {
            clickOn(bothLanguageIsMandatory);
        }

        hold(500);
        clickOn(colorSelector);
        hold(300);
        clickOn(driver.findElement(By.xpath("//td[@bgcolor='#FF0000']")));
        hold(300);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("mandatory Fields: "+arabicOrEnglish);

    }

    public void spouseAllowanceAmount(String spouseAllowanceAmount){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(familySetup);
        setLog("Open Family Setup");
        hold(500);
        elementWaitAdvanced(By.name("wife_allow_amount"));
        hold(300);
        wifeAllowAmount.clear();
        hold(500);
        setText(wifeAllowAmount, spouseAllowanceAmount);
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("spouse Allowance Amount: "+spouseAllowanceAmount);

    }

    public void spouseAndChildAllowances(String spouseAllowance, String childAllowance){

        if(!liteGetter()){

            hold(300);
            goToFrame(frame);
            elementWaitAdvanced(By.className("TabsTableTag"));
            clickOn(familySetup);
            setLog("Open Family Setup");
            hold(500);
            elementWaitAdvanced(By.name("wife_allow_amount"));
            hold(100);
            if(!spouseAllowance.isEmpty()){
                Select spouse = new Select(spouseAllowanceE);
                spouse.selectByVisibleText(spouseAllowance);
            }
            if(!childAllowance.isEmpty()){
                Select spouse = new Select(childAllowanceE);
                spouse.selectByVisibleText(childAllowance);
            }
            hold(100);
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            hold(500);
            closeIFrame();

        }else{

            hold(300);
            goToFrame(frame);
            elementWaitAdvanced(By.className("TabsTableTag"));
            clickOn(familySetup_lite);
            hold(200);
            setLog("Open Family Setup");
            if(!spouseAllowance.isEmpty()){
                Select spouse = new Select(spouseAllowanceE);
                spouse.selectByVisibleText(spouseAllowance);
            }
            if(!childAllowance.isEmpty()){
                Select spouse = new Select(childAllowanceE);
                spouse.selectByVisibleText(childAllowance);
            }
            hold(100);
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            hold(500);
            closeIFrame();

        }

        setLog("spouse Allowance: "+spouseAllowance+" - child Allowance: "+childAllowance);

    }

    public void spouseAndChildAllowances(String spouseAllowance, String childAllowance, String spouseAllowanceAmount){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(familySetup);
        setLog("Open Family Setup");
        hold(500);
        elementWaitAdvanced(By.name("wife_allow_amount"));
        hold(100);
        if(!spouseAllowance.isEmpty()){
            Select spouse = new Select(spouseAllowanceE);
            spouse.selectByVisibleText(spouseAllowance);
        }
        if(!childAllowance.isEmpty()){
            Select spouse = new Select(childAllowanceE);
            spouse.selectByVisibleText(childAllowance);
        }
        hold(100);
        if(!spouseAllowanceAmount.isEmpty()){
            wifeAllowAmount.clear();
            hold(500);
            setText(wifeAllowAmount, spouseAllowanceAmount);
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("spouse Allowance: "+spouseAllowance+" - child Allowance: "+childAllowance+" - spouse Allowance Amount: "+spouseAllowanceAmount);

    }

    public void spouseAndChildAllowances(String spouseAllowance, String childAllowance, String spouseAllowanceAmount, String spousesAllowancesUpperLimit){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(familySetup);
        setLog("Open Family Setup");
        hold(500);
        elementWaitAdvanced(By.name("wife_allow_amount"));
        hold(100);
        if(!spouseAllowance.isEmpty()){
            Select spouse = new Select(spouseAllowanceE);
            spouse.selectByVisibleText(spouseAllowance);
        }
        if(!childAllowance.isEmpty()){
            Select spouse = new Select(childAllowanceE);
            spouse.selectByVisibleText(childAllowance);
        }
        hold(100);
        if(!spouseAllowanceAmount.isEmpty()){
            wifeAllowAmount.clear();
            hold(500);
            setText(wifeAllowAmount, spouseAllowanceAmount);
        }
        hold(100);
        if(!spousesAllowancesUpperLimit.isEmpty()){
            spousesAllowancesUpperLimitE.clear();
            hold(500);
            setText(spousesAllowancesUpperLimitE, spousesAllowancesUpperLimit);
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("spouse Allowance: "+spouseAllowance+" - child Allowance: "+childAllowance+" - spouse Allowance Amount: "+spouseAllowanceAmount+" - spouses Allowances Upper Limit: "+spousesAllowancesUpperLimit);

    }

    public void spouseAndChildAllowances(String spouseAllowance, String childAllowance, String spouseAllowanceAmount, String spousesAllowancesUpperLimit, String childAllowanceType, String childrenAllowanceAmount){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(familySetup);
        setLog("Open Family Setup");
        hold(500);
        elementWaitAdvanced(By.name("wife_allow_amount"));
        hold(100);
        if(!spouseAllowance.isEmpty()){
            Select spouse = new Select(spouseAllowanceE);
            spouse.selectByVisibleText(spouseAllowance);
        }
        if(!childAllowance.isEmpty()){
            Select spouse = new Select(childAllowanceE);
            spouse.selectByVisibleText(childAllowance);
        }
        hold(100);
        if(!spouseAllowanceAmount.isEmpty()){
            wifeAllowAmount.clear();
            hold(500);
            setText(wifeAllowAmount, spouseAllowanceAmount);
        }
        hold(100);
        if(!spousesAllowancesUpperLimit.isEmpty()){
            spousesAllowancesUpperLimitE.clear();
            hold(500);
            setText(spousesAllowancesUpperLimitE, spousesAllowancesUpperLimit);
        }
        hold(100);
        if(!childAllowanceType.isEmpty()){
            if(childAllowanceType.equalsIgnoreCase("Default")){
                clickOn(childrenAllowancesTypeDefault);
            } else if (childAllowanceType.equalsIgnoreCase("ChildSort")) {
                clickOn(childrenAllowancesTypeChildSort);
            } else if (childAllowanceType.equalsIgnoreCase("Sort")) {
                clickOn(childrenAllowancesTypeChildSort);
            }
        }
        hold(100);
        if(!childrenAllowanceAmount.isEmpty()){
            clickOn(childrenAllowancesTypeDefault);
            hold(500);
            childrenAllowAmount.clear();
            hold(300);
            setText(childrenAllowAmount, childrenAllowanceAmount);
        }
        closeIFrame();
        hold(200);
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("spouse Allowance: "+spouseAllowance+" - child Allowance: "+childAllowance
                +" - spouse Allowance Amount: "+spouseAllowanceAmount
                +" - spouses Allowances Upper Limit: "+spousesAllowancesUpperLimit
                +" - child Allowance Type: "+childAllowanceType
                +" - children Allowance Amount: "+childrenAllowanceAmount);

    }

    public void spouseAndChildAllowances(String spouseAllowance, String childAllowance, String spouseAllowanceAmount,
                                         String spousesAllowancesUpperLimit, String childAllowanceType, String childrenAllowanceAmount,
                                         String childrenAllowancesUpperLimit){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(familySetup);
        setLog("Open Family Setup");
        hold(500);
        elementWaitAdvanced(By.name("wife_allow_amount"));
        hold(100);
        if(!spouseAllowance.isEmpty()){
            Select spouse = new Select(spouseAllowanceE);
            spouse.selectByVisibleText(spouseAllowance);
        }
        if(!childAllowance.isEmpty()){
            Select spouse = new Select(childAllowanceE);
            spouse.selectByVisibleText(childAllowance);
        }
        hold(100);
        if(!spouseAllowanceAmount.isEmpty()){
            wifeAllowAmount.clear();
            hold(500);
            setText(wifeAllowAmount, spouseAllowanceAmount);
        }
        hold(100);
        if(!spousesAllowancesUpperLimit.isEmpty()){
            spousesAllowancesUpperLimitE.clear();
            hold(500);
            setText(spousesAllowancesUpperLimitE, spousesAllowancesUpperLimit);
        }
        hold(100);
        if(!childAllowanceType.isEmpty()){
            if(childAllowanceType.equalsIgnoreCase("Default")){
                clickOn(childrenAllowancesTypeDefault);
            } else if (childAllowanceType.equalsIgnoreCase("ChildSort")) {
                clickOn(childrenAllowancesTypeChildSort);
            } else if (childAllowanceType.equalsIgnoreCase("Sort")) {
                clickOn(childrenAllowancesTypeChildSort);
            }
        }
        hold(100);
        if(!childrenAllowanceAmount.isEmpty()){
            clickOn(childrenAllowancesTypeDefault);
            hold(500);
            childrenAllowAmount.clear();
            hold(300);
            setText(childrenAllowAmount, childrenAllowanceAmount);
        }
        if(!childrenAllowancesUpperLimit.isEmpty()){
            childrenAllowancesUpperLimitE.clear();
            hold(200);
            setText(childrenAllowancesUpperLimitE, childrenAllowancesUpperLimit);
        }
        closeIFrame();
        hold(200);
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("spouse Allowance: "+spouseAllowance+" - child Allowance: "+childAllowance
                +" - spouse Allowance Amount: "+spouseAllowanceAmount
                +" - spouses Allowances Upper Limit: "+spousesAllowancesUpperLimit
                +" - child Allowance Type: "+childAllowanceType
                +" - children Allowance Amount: "+childrenAllowanceAmount
                +" - children Allowances Upper Limit: "+childrenAllowancesUpperLimit);

    }

    public void childSortDetails(String amount1, String amount2, String amount3, String amount4
            , String amount5, String amount6, String amount7, String amount8, String amount9, String amount10){

        goToFrame(frame);
        hold(500);
        clickOn(childrenAllowancesTypeChildSort);
        hold(200);
        clickOn(childSortDetailsBtn);
        hold(500);
        closeIFrame();
        goToFrame(MenaBoxIframe);
        elementWaitAdvanced(By.name("new"));

        if(!amount1.isEmpty()){
            clickOn(newBtn);
            hold(300);
            childSortAmount.clear();
            hold(100);
            setText(childSortAmount, amount1);
            hold(100);
            clickOn(saveBtn);
            hold(300);
        }
        if(!amount2.isEmpty()){
            clickOn(newBtn);
            hold(300);
            childSortAmount.clear();
            hold(100);
            setText(childSortAmount, amount2);
            hold(100);
            clickOn(saveBtn);
            hold(300);
        }
        if(!amount3.isEmpty()){
            clickOn(newBtn);
            hold(300);
            childSortAmount.clear();
            hold(100);
            setText(childSortAmount, amount3);
            hold(100);
            clickOn(saveBtn);
            hold(300);
        }
        if(!amount4.isEmpty()){
            clickOn(newBtn);
            hold(300);
            childSortAmount.clear();
            hold(100);
            setText(childSortAmount, amount4);
            hold(100);
            clickOn(saveBtn);
            hold(300);
        }
        if(!amount5.isEmpty()){
            clickOn(newBtn);
            hold(300);
            childSortAmount.clear();
            hold(100);
            setText(childSortAmount, amount5);
            hold(100);
            clickOn(saveBtn);
            hold(300);
        }
        if(!amount6.isEmpty()){
            clickOn(newBtn);
            hold(300);
            childSortAmount.clear();
            hold(100);
            setText(childSortAmount, amount6);
            hold(100);
            clickOn(saveBtn);
            hold(300);
        }
        if(!amount7.isEmpty()){
            clickOn(newBtn);
            hold(300);
            childSortAmount.clear();
            hold(100);
            setText(childSortAmount, amount7);
            hold(100);
            clickOn(saveBtn);
            hold(300);
        }
        if(!amount8.isEmpty()){
            clickOn(newBtn);
            hold(300);
            childSortAmount.clear();
            hold(100);
            setText(childSortAmount, amount8);
            hold(100);
            clickOn(saveBtn);
            hold(300);
        }
        if(!amount9.isEmpty()){
            clickOn(newBtn);
            hold(300);
            childSortAmount.clear();
            hold(100);
            setText(childSortAmount, amount9);
            hold(100);
            clickOn(saveBtn);
            hold(300);
        }
        if(!amount10.isEmpty()){
            clickOn(newBtn);
            hold(300);
            childSortAmount.clear();
            hold(100);
            setText(childSortAmount, amount10);
            hold(100);
            clickOn(saveBtn);
            hold(300);
        }

        hold(200);
        clickOn(exitBtn);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(1200);
        closeIFrame();

    }

    public void childrenAllowanceAmount(String childrenAllowanceAmount){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(familySetup);
        setLog("Open Family Setup");
        hold(500);
        elementWaitAdvanced(By.name("child_allow_amount"));
        hold(300);
        clickOn(childrenAllowancesTypeDefault);
        hold(500);
        childrenAllowAmount.clear();
        hold(300);
        setText(childrenAllowAmount, childrenAllowanceAmount);
        hold(100);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("Children Allowance Amount: "+childrenAllowanceAmount);

    }

    public void childrenAllowanceType(String DefaultOrChildSort){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(familySetup);
        setLog("Open Family Setup");
        hold(500);
        elementWaitAdvanced(By.name("child_allow_amount"));
        hold(500);
        if(DefaultOrChildSort.equalsIgnoreCase("Default")){
            clickOn(childrenAllowancesTypeDefault);
        } else if (DefaultOrChildSort.equalsIgnoreCase("ChildSort")) {
            clickOn(childrenAllowancesTypeChildSort);
        }

        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("children Allowance Type: "+DefaultOrChildSort);

    }

    public void maleChildAllowanceGivenStartingAge(String maleChildAllowanceGivenStartingAge, String upToAge,
                                                   String orAgeYearsForCollegeStudents){

        goToFrame(frame);
        elementWaitAdvanced(By.id("from_allow_age"));
        if(!maleChildAllowanceGivenStartingAge.isEmpty()){
            maleChildStartingAgeE.clear();
            hold(200);
            setText(maleChildStartingAgeE, maleChildAllowanceGivenStartingAge);
        }
        if(!upToAge.isEmpty()){
            maleUpToAgeE.clear();
            hold(200);
            setText(maleUpToAgeE, upToAge);
        }
        if(!orAgeYearsForCollegeStudents.isEmpty()){
            maleAgeForCollegeStudentsE.clear();
            hold(200);
            setText(maleAgeForCollegeStudentsE, orAgeYearsForCollegeStudents);
        }

        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("male Child Allowance Given Starting Age: "+maleChildAllowanceGivenStartingAge
                +" - up To Age: "+upToAge
                +" - or Age Years For College Students: "+orAgeYearsForCollegeStudents);

    }

    public void femaleChildAllowanceGivenStartingAge(String femaleChildAllowanceGivenStartingAge, String upToAge,
                                                   String orAgeYearsForCollegeStudents){

        goToFrame(frame);
        elementWaitAdvanced(By.id("from_allow_age"));
        if(!femaleChildAllowanceGivenStartingAge.isEmpty()){
            femaleChildStartingAgeE.clear();
            hold(200);
            setText(femaleChildStartingAgeE, femaleChildAllowanceGivenStartingAge);
        }
        if(!upToAge.isEmpty()){
            femaleUpToAgeE.clear();
            hold(200);
            setText(femaleUpToAgeE, upToAge);
        }
        if(!orAgeYearsForCollegeStudents.isEmpty()){
            femaleAgeForCollegeStudentsE.clear();
            hold(200);
            setText(femaleAgeForCollegeStudentsE, orAgeYearsForCollegeStudents);
        }

        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("female Child Allowance Given Starting Age: "+femaleChildAllowanceGivenStartingAge
                +" - up To Age: "+upToAge
                +" - or Age Years For College Students: "+orAgeYearsForCollegeStudents);

    }

    public void familySetupOptions(boolean notifyHROfficer, String hrDays, boolean automaticallyStopStartChildAllowance,
                                   boolean notifyEmployee, String employeeDays, boolean doNotAllowToChangeTheDefaultAmount){

        goToFrame(frame);
        elementWaitAdvanced(By.id("from_allow_age"));
        if(notifyHROfficer){
           if(!allow_notify_hr.isSelected()){
               clickOn(allow_notify_hr);
           }
           if(!hrDays.isEmpty()){
               hold(200);
               Select select = new Select(allow_remind_days_hr);
               select.selectByVisibleText(hrDays);
           }
        }else{
            if(allow_notify_hr.isSelected()){
                clickOn(allow_notify_hr);
            }
        }
        if(automaticallyStopStartChildAllowance){
            if(!allow_automatic.isSelected()){
                clickOn(allow_automatic);
            }
        }else{
            if(allow_automatic.isSelected()){
                clickOn(allow_automatic);
            }
        }
        if(notifyEmployee){
            if(!allow_notify_emp.isSelected()){
                clickOn(allow_notify_emp);
            }
            if(!employeeDays.isEmpty()){
                hold(200);
                Select select = new Select(allow_remind_days_emp);
                select.selectByVisibleText(employeeDays);
            }
        }else{
            if(allow_notify_emp.isSelected()){
                clickOn(allow_notify_emp);
            }
        }
        if(doNotAllowToChangeTheDefaultAmount){
            if(!doNotAllowToChangeTheDefaultAmountE.isSelected()){
                clickOn(doNotAllowToChangeTheDefaultAmountE);
            }
        }else{
            if(doNotAllowToChangeTheDefaultAmountE.isSelected()){
                clickOn(doNotAllowToChangeTheDefaultAmountE);
            }
        }

        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("Family Setup Options"
                +" - notify HR Officer: "+notifyHROfficer
                +" - HR Days: "+hrDays
                +" - automatically Stop Start Child Allowance: "+automaticallyStopStartChildAllowance
                +" - notify Employee: "+notifyEmployee
                +" - employee Days: "+employeeDays
                +" - do Not Allow To Change The Default Amount: "+doNotAllowToChangeTheDefaultAmount);

    }

    public void goToFamilySetup(){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(familySetup);
        setLog("Open Family Setup");
        hold(500);
        elementWaitAdvanced(By.name("child_allow_amount"));
        closeIFrame();

        setLog("Open Family Setup");

    }

    public void reportsSetup(String hierarchyStart, boolean incomeTax, boolean servicesTax, boolean nationalContibution, boolean healthInsurance,
                             boolean extraInformationInARTaxReport, boolean GOSISecurity, boolean minusNetSalaries, boolean lastReleasedSalarySlipInMenaME,
                             boolean distinguishHousingAccrualsFromOtherIncome, boolean employeeCanPrintAndSaveTheSentSalarySlip, boolean exportReportsInCSV,
                             boolean repeatHeaderInSalaryReports, boolean workingHoursInsteadOfWorkingDays, boolean  hideFinancialData, boolean hideClassificationInformation,
                             boolean showThousandsSeparator, String logoPositionInTheReports, boolean useCustomizedReportHeader, boolean adjustColumnsWidth, boolean allowBankBatchGeneration){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(otherOptions);
        setLog("Open Other Options");
        hold(300);
        elementWaitAdvanced(By.name("hostelries_round"));
        clickOn(reportsSetupList);
        hold(500);

        if(!hierarchyStart.isEmpty()){
            Select opt = new Select(hierarchyStartE);
            opt.selectByVisibleText(hierarchyStart);
        }
        if(incomeTax){
            if(!incomeTaxE.isSelected()){
                clickOn(incomeTaxE);
            }
        }else{
            if(incomeTaxE.isSelected()){
                clickOn(incomeTaxE);
            }
        }
        if(servicesTax){
            if(!servicesTaxE.isSelected()){
                clickOn(servicesTaxE);
            }
        }else{
            if(servicesTaxE.isSelected()){
                clickOn(servicesTaxE);
            }
        }
        if(nationalContibution){
            if(!nationalContibutionE.isSelected()){
                clickOn(nationalContibutionE);
            }
        }else{
            if(nationalContibutionE.isSelected()){
                clickOn(nationalContibutionE);
            }
        }
        if(healthInsurance){
            if(!healthInsuranceE.isSelected()){
                clickOn(healthInsuranceE);
            }
        }else{
            if(healthInsuranceE.isSelected()){
                clickOn(healthInsuranceE);
            }
        }
        if(extraInformationInARTaxReport){
            if(!otherInfoR3TaxReportE.isSelected()){
                clickOn(otherInfoR3TaxReportE);
            }
        }else{
            if(otherInfoR3TaxReportE.isSelected()){
                clickOn(otherInfoR3TaxReportE);
            }
        }
        if(GOSISecurity){
            if(!GOSIReportsE.isSelected()){
                clickOn(GOSIReportsE);
            }
        }else{
            if(GOSIReportsE.isSelected()){
                clickOn(GOSIReportsE);
            }
        }
        if(minusNetSalaries){
            if(!minusNetSalaryE.isSelected()){
                clickOn(minusNetSalaryE);
            }
        }else{
            if(minusNetSalaryE.isSelected()){
                clickOn(minusNetSalaryE);
            }
        }
        if(lastReleasedSalarySlipInMenaME){
            if(!onlyLastReleasedSalaryE.isSelected()){
                clickOn(onlyLastReleasedSalaryE);
            }
        }else{
            if(onlyLastReleasedSalaryE.isSelected()){
                clickOn(onlyLastReleasedSalaryE);
            }
        }
        if(distinguishHousingAccrualsFromOtherIncome){
            if(!distinguishHousingAccrualsE.isSelected()){
                clickOn(distinguishHousingAccrualsE);
            }
        }else{
            if(distinguishHousingAccrualsE.isSelected()){
                clickOn(distinguishHousingAccrualsE);
            }
        }
        if(employeeCanPrintAndSaveTheSentSalarySlip){
            if(!employeeCanPrintSaveE.isSelected()){
                clickOn(employeeCanPrintSaveE);
            }
        }else{
            if(employeeCanPrintSaveE.isSelected()){
                clickOn(employeeCanPrintSaveE);
            }
        }
        if(exportReportsInCSV){
            if(!exportReportsInCSVFormatE.isSelected()){
                clickOn(exportReportsInCSVFormatE);
            }
        }else{
            if(exportReportsInCSVFormatE.isSelected()){
                clickOn(exportReportsInCSVFormatE);
            }
        }
        if(repeatHeaderInSalaryReports){
            if(!repeatHeaderE.isSelected()){
                clickOn(repeatHeaderE);
            }
        }else{
            if(repeatHeaderE.isSelected()){
                clickOn(repeatHeaderE);
            }
        }
        if(workingHoursInsteadOfWorkingDays){
            if(!workingHoursInReportsE.isSelected()){
                clickOn(workingHoursInReportsE);
            }
        }else{
            if(workingHoursInReportsE.isSelected()){
                clickOn(workingHoursInReportsE);
            }
        }
        if(hideFinancialData){
            if(!hideFinancialDataReportsE.isSelected()){
                clickOn(hideFinancialDataReportsE);
            }
        }else{
            if(hideFinancialDataReportsE.isSelected()){
                clickOn(hideFinancialDataReportsE);
            }
        }
        if(hideClassificationInformation){
            if(!hideClassificationInformationE.isSelected()){
                clickOn(hideClassificationInformationE);
            }
        }else{
            if(hideClassificationInformationE.isSelected()){
                clickOn(hideClassificationInformationE);
            }
        }
        if(showThousandsSeparator){
            if(!showThousandsSeparatorE.isSelected()){
                clickOn(showThousandsSeparatorE);
            }
        }else{
            if(showThousandsSeparatorE.isSelected()){
                clickOn(showThousandsSeparatorE);
            }
        }
        if(!logoPositionInTheReports.isEmpty()){
            Select opt = new Select(logoPositionE);
            opt.selectByVisibleText(logoPositionInTheReports);
        }
        if(useCustomizedReportHeader){
            if(!useCustomizedReportE.isSelected()){
                clickOn(useCustomizedReportE);
            }
        }else{
            if(useCustomizedReportE.isSelected()){
                clickOn(useCustomizedReportE);
            }
        }
        if(adjustColumnsWidth){
            if(!adjustColumnsWidthE.isSelected()){
                clickOn(adjustColumnsWidthE);
            }
        }else{
            if(adjustColumnsWidthE.isSelected()){
                clickOn(adjustColumnsWidthE);
            }
        }
        if(allowBankBatchGeneration){
            if(!allowBankBatchGenerationE.isSelected()){
                clickOn(allowBankBatchGenerationE);
            }
        }else{
            if(allowBankBatchGenerationE.isSelected()){
                clickOn(allowBankBatchGenerationE);
            }
        }

        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(300);
        closeIFrame();

        setLog("reports Setup"
        +" - hierarchy Start: "+hierarchyStart
        +" - income Tax: "+incomeTax
        +" - services Tax: "+servicesTax
        +" - national Contibution: "+nationalContibution
        +" - health Insurance: "+healthInsurance
        +" - extra Information In AR Tax Report: "+extraInformationInARTaxReport
        +" - Social Security: "+GOSISecurity
        +" - minus Net Salaries: "+minusNetSalaries
        +" - last Released Salary Slip In MenaME: "+lastReleasedSalarySlipInMenaME
        +" - distinguish Housing Accruals From Other Income: "+distinguishHousingAccrualsFromOtherIncome
        +" - employee Can Print And Save The Sent Salary Slip: "+employeeCanPrintAndSaveTheSentSalarySlip
        +" - export Reports In CSV: "+exportReportsInCSV
        +" - repeat Header In Salary Reports: "+repeatHeaderInSalaryReports
        +" - working Hours Instead Of Working Days: "+workingHoursInsteadOfWorkingDays
        +" - hide Financial Data: "+hideFinancialData
        +" - hide Classification Information: "+hideClassificationInformation
        +" - show Thousands Separator: "+showThousandsSeparator
        +" - logo Position In The Reports: "+logoPositionInTheReports
        +" - use Customized Report Header: "+useCustomizedReportHeader
        +" - adjust Columns Width: "+allowBankBatchGeneration);

    }

    public void childAllowanceAddFixedAmount(String amount){

        clientIdChanger("CBJ", "automation");
        
        hold(500);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(familySetup);
        setLog("Open Family Setup");
        hold(300);
        elementWaitAdvanced(By.name("child_allow_code"));
        addFixedAmountE.clear();
        hold(300);
        setText(addFixedAmountE, amount);
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(1700);
        closeIFrame();

        setLog("child Allowance Add Fixed Amount: "+amount);
        
    }

    public void budgetOptions(String budgetOptions){

        hold(500);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(otherOptions);
        hold(300);
        elementWaitAdvanced(By.name("hostelries_round"));
        clickOn(budgetOptionsList);
        hold(500);
        if(budgetOptions.equalsIgnoreCase("Do Not Check Budget Exceeding")){
            clickOn(doNotCheckBudgetExceedingE);
            hold(300);
        }else if(budgetOptions.equalsIgnoreCase("Alert When Exceeding Budget")){
            clickOn(alertWhenExceedingBudgetE);
            hold(300);
        }else if(budgetOptions.equalsIgnoreCase("Never Exceed Budget")){
            clickOn(neverExceedBudgetE);
            hold(300);
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("budgetOptions: "+budgetOptions);

    }

    public void updateEmployeeInformationUponPackageChange(boolean checkOrNot){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(configurationSystem);
        hold(300);
        if(checkOrNot){
            clickOn(salaryScaleBasedOn_Packages);
            hold(500);
            if(!updateEmployeeInformationUponPackageChangeCheckbox.isSelected()){
                clickOn(updateEmployeeInformationUponPackageChangeCheckbox);
            }
        }else{
            clickOn(salaryScaleBasedOn_SalaryScaleStandard);
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("updateEmployeeInformationUponPackageChange: "+checkOrNot);

    }

    public void doNotAllowBankAccountNumberDuplications(boolean check){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        if(check){
            if(!doNotAllowBankAccountNumberDuplicationsCheckbox.isSelected()){
                clickOn(doNotAllowBankAccountNumberDuplicationsCheckbox);
            }
        }else{
            if(doNotAllowBankAccountNumberDuplicationsCheckbox.isSelected()){
                clickOn(doNotAllowBankAccountNumberDuplicationsCheckbox);
            }
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("do Not Allow Bank Account Number Duplications: "+check);

    }

    public void WhenAddingNewEmployeeRecord(boolean automaticallySubmitEmployeeToEOS, String automaticallySubmitEmployeeToEOSOptions, boolean automaticallySubmitEmployeeToHealthInsurance,
                                            String automaticallySubmitEmployeeToHealthInsuranceOptions, boolean automaticallySubmitCitizenEmployeeToGOSISecurity, String automaticallySubmitCitizenEmployeeToGOSISecurityOptions,
                                            boolean automaticallySubmitNonCitizenEmployeeToGOSISecurity, String automaticallySubmitNonCitizenEmployeeToGOSISecurityOptions,
                                            boolean automaticallySubmitEmployeeToIncomeTax, String citizenNationality){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(WhenAddingNewEmployeeRecord);
        hold(500);
        if(automaticallySubmitEmployeeToEOS){
            if(!automaticallySubmitEmployeeToEOSCheckbox.isSelected()){
                clickOn(automaticallySubmitEmployeeToEOSCheckbox);
                hold(200);
                if(!automaticallySubmitEmployeeToEOSOptions.isEmpty()){
                    Select select = new Select(automaticallySubmitEmployeeToEOSSelect);
                    select.selectByVisibleText(automaticallySubmitEmployeeToEOSOptions);
                    hold(300);
                }
            }
        }else{
            if(automaticallySubmitEmployeeToEOSCheckbox.isSelected()){
                clickOn(automaticallySubmitEmployeeToEOSCheckbox);
                hold(200);
            }
        }
        if(automaticallySubmitEmployeeToHealthInsurance){
            if(!automaticallySubmitEmployeeToHealthInsuranceCheckbox.isSelected()){
                clickOn(automaticallySubmitEmployeeToHealthInsuranceCheckbox);
                hold(200);
                if(!automaticallySubmitEmployeeToHealthInsuranceOptions.isEmpty()){
                    Select select = new Select(automaticallySubmitEmployeeToHealthInsuranceSelect);
                    select.selectByVisibleText(automaticallySubmitEmployeeToHealthInsuranceOptions);
                    hold(300);
                }
            }
        }else{
            if(automaticallySubmitEmployeeToHealthInsuranceCheckbox.isSelected()){
                clickOn(automaticallySubmitEmployeeToHealthInsuranceCheckbox);
                hold(200);
            }
        }
        if(automaticallySubmitCitizenEmployeeToGOSISecurity){
            if(!automaticallySubmitCitizenEmployeeToGOSISecurityCheckbox.isSelected()){
                clickOn(automaticallySubmitCitizenEmployeeToGOSISecurityCheckbox);
                hold(200);
                if(!automaticallySubmitCitizenEmployeeToGOSISecurityOptions.isEmpty()){
                    Select select = new Select(automaticallySubmitCitizenEmployeeToGOSISecuritySelect);
                    select.selectByVisibleText(automaticallySubmitCitizenEmployeeToGOSISecurityOptions);
                    hold(300);
                }
            }
        }else{
            if(automaticallySubmitCitizenEmployeeToGOSISecurityCheckbox.isSelected()){
                clickOn(automaticallySubmitCitizenEmployeeToGOSISecurityCheckbox);
                hold(200);
            }
        }
        if(automaticallySubmitNonCitizenEmployeeToGOSISecurity){
            if(!automaticallySubmitNonCitizenEmployeeToGOSISecurityCheckbox.isSelected()){
                clickOn(automaticallySubmitNonCitizenEmployeeToGOSISecurityCheckbox);
                hold(200);
                if(!automaticallySubmitNonCitizenEmployeeToGOSISecurityOptions.isEmpty()){
                    Select select = new Select(automaticallySubmitNonCitizenEmployeeToGOSISecuritySelect);
                    select.selectByVisibleText(automaticallySubmitNonCitizenEmployeeToGOSISecurityOptions);
                    hold(300);
                }
            }
        }else{
            if(automaticallySubmitNonCitizenEmployeeToGOSISecurityCheckbox.isSelected()){
                clickOn(automaticallySubmitNonCitizenEmployeeToGOSISecurityCheckbox);
                hold(200);
            }
        }
        if(automaticallySubmitEmployeeToIncomeTax){
            if(!automaticallySubmitEmployeeToIncomeTaxCheckbox.isSelected()){
                clickOn(automaticallySubmitEmployeeToIncomeTaxCheckbox);
                hold(200);
            }
        }else{
            if(automaticallySubmitEmployeeToIncomeTaxCheckbox.isSelected()){
                clickOn(automaticallySubmitEmployeeToIncomeTaxCheckbox);
                hold(200);
            }
        }
        if(!citizenNationality.isEmpty()){
            Select select = new Select(citizenNationalityE);
            select.selectByVisibleText(citizenNationality);
            hold(300);
        }

        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("When Adding New Employee Record"
                +" - automaticallySubmitEmployeeToEOS: "+automaticallySubmitEmployeeToEOS
                +" - automaticallySubmitEmployeeToEOSOptions: "+automaticallySubmitEmployeeToEOSOptions
                +" - automaticallySubmitEmployeeToHealthInsurance: "+automaticallySubmitEmployeeToHealthInsurance
                +" - automaticallySubmitEmployeeToHealthInsuranceOptions: "+automaticallySubmitEmployeeToHealthInsuranceOptions
                +" - automaticallySubmitCitizenEmployeeToGOSISecurity: "+automaticallySubmitCitizenEmployeeToGOSISecurity
                +" - automaticallySubmitCitizenEmployeeToGOSISecurityOptions: "+automaticallySubmitCitizenEmployeeToGOSISecurityOptions
                +" - automaticallySubmitNonCitizenEmployeeToGOSISecurity: "+automaticallySubmitNonCitizenEmployeeToGOSISecurity
                +" - automaticallySubmitNonCitizenEmployeeToGOSISecurityOptions: "+automaticallySubmitNonCitizenEmployeeToGOSISecurityOptions
                +" - automaticallySubmitEmployeeToIncomeTax: "+automaticallySubmitEmployeeToIncomeTax
                +" - citizenNationality: "+citizenNationality);

    }

    public void glAccount1IsEqualToEmployeeCode(boolean checked){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        if(checked){
            if(!GLAccount1IsEqualToEmployeeCodeCheckbox.isSelected()){
                clickOn(GLAccount1IsEqualToEmployeeCodeCheckbox);
            }
        }else{
            if(GLAccount1IsEqualToEmployeeCodeCheckbox.isSelected()){
                clickOn(GLAccount1IsEqualToEmployeeCodeCheckbox);
            }
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("GL Account 1 Is Equal To Employee Code: "+checked);

    }

    public void doNotAllowGLAccountsDuplications(boolean checked){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(otherOptions);
        hold(300);
        elementWaitAdvanced(By.name("duplicate_gl_acount"));
        if(checked){
            if(!doNotAllowGLAccountsDuplicationsCheckbox.isSelected()){
                clickOn(doNotAllowGLAccountsDuplicationsCheckbox);
            }
        }else{
            if(doNotAllowGLAccountsDuplicationsCheckbox.isSelected()){
                clickOn(doNotAllowGLAccountsDuplicationsCheckbox);
            }
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("do Not Allow GL Accounts Duplications: "+checked);

    }

    public void numberOfYearlySalaries(String numberOfYearlySalaries){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(workYearSetup);
        hold(300);
        Select select = new Select(numberOfYearlySalariesE);
        if(!numberOfYearlySalaries.isEmpty()){
            select.selectByVisibleText(numberOfYearlySalaries);
            hold(200);
        }else{
            select.selectByVisibleText("12");
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("number Of Yearly Salaries: "+numberOfYearlySalaries);

    }

    public void workingDaysMethod(String method){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(workYearSetup);
        hold(300);
        if(method.equalsIgnoreCase("30")){
            clickOn(workingDaysPerMonth);
            workingHoursPerDayAmount.clear();
            hold(100);
            setText(workingHoursPerDayAmount, "30");
        }else if(method.equalsIgnoreCase("Calendar")){
            clickOn(calendarMethod);
        }else if(method.equalsIgnoreCase("30 Days Method")){
            clickOn(workingDaysPerMonth);
            workingHoursPerDayAmount.clear();
            hold(100);
            setText(workingHoursPerDayAmount, "30");
        }else{
            clickOn(calendarMethod);
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("working Days Method: "+method);

    }

    public void workingSetup(String method, String hours){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(workYearSetup);
        setLog("Open Working Setup");
        hold(300);
        if(method.equalsIgnoreCase("30")){
            clickOn(workingDaysPerMonth);
            workingHoursPerDayAmount.clear();
            hold(100);
            setText(workingHoursPerDayAmount, "30");
        }else if(method.equalsIgnoreCase("Calendar")){
            clickOn(calendarMethod);
        }else if(method.equalsIgnoreCase("30 Days Method")){
            clickOn(workingDaysPerMonth);
            workingHoursPerDayAmount.clear();
            hold(100);
            setText(workingHoursPerDayAmount, "30");
        }else{
            clickOn(calendarMethod);
        }
        hold(200);
        if(!hours.isEmpty()){
            hold(100);
            workingHoursPerDayE.clear();
            hold(200);
            setText(workingHoursPerDayE, hours);
        }else{
            hold(100);
            workingHoursPerDayE.clear();
            hold(200);
            setText(workingHoursPerDayE, "8");
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(300);
        closeIFrame();

        setLog("Working Setup - Method: "+method+" - Hours: "+hours);

    }

    public void overtimeHoursSetup(boolean overtimeHoursSetup, String method, String hours){

        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(workYearSetup);
        setLog("Open Working Setup");
        waitElementClickable(hoursSetupBtn);
        clickOn(hoursSetupBtn);
        hold(500);
        closeIFrame();

        if(!liteGetter()){

            goToFrame(MenaBoxIframe);
            elementWaitAdvanced(By.name("is_setup_overtime_hours"));
            if(overtimeHoursSetup){
                if(!is_setup_overtime_hours.isSelected()){
                    clickOn(is_setup_overtime_hours);
                }
                hold(200);
                if(method.equalsIgnoreCase("30")){
                    clickOn(is_30_days_overtime);
                    month_days_overtime.clear();
                    hold(100);
                    setText(month_days_overtime, "30");
                }else if(method.equalsIgnoreCase("Calendar")){
                    clickOn(is_calendar_days_overtime);
                }else if(method.equalsIgnoreCase("30 Days Method")){
                    clickOn(is_30_days_overtime);
                    month_days_overtime.clear();
                    hold(100);
                    setText(month_days_overtime, "30");
                }else{
                    clickOn(is_calendar_days_overtime);
                }
                hold(200);
                if(!hours.isEmpty()){
                    day_hours_overtime.clear();
                    hold(200);
                    setText(day_hours_overtime, hours);
                }else{
                    hold(100);
                    day_hours_overtime.clear();
                    hold(200);
                    setText(day_hours_overtime, "8");
                }
            }else{
                if(is_setup_overtime_hours.isSelected()){
                    clickOn(is_setup_overtime_hours);
                }
            }

            clickOn(saveBtn);
            hold(300);
            waitElementClickable(exitBtn);
            clickOn(exitBtn);
            closeIFrame();

        }else{

            parentWindow = driver.getWindowHandle();
            goToWindow();
            hold(500);
            elementWaitAdvanced(By.name("is_setup_overtime_hours"));
            if(overtimeHoursSetup){
                if(!is_setup_overtime_hours.isSelected()){
                    clickOn(is_setup_overtime_hours);
                }
                hold(200);
                if(method.equalsIgnoreCase("30")){
                    clickOn(is_30_days_overtime);
                    month_days_overtime.clear();
                    hold(100);
                    setText(month_days_overtime, "30");
                }else if(method.equalsIgnoreCase("Calendar")){
                    clickOn(is_calendar_days_overtime);
                }else if(method.equalsIgnoreCase("30 Days Method")){
                    clickOn(is_30_days_overtime);
                    month_days_overtime.clear();
                    hold(100);
                    setText(month_days_overtime, "30");
                }else{
                    clickOn(is_calendar_days_overtime);
                }
                hold(200);
                if(!hours.isEmpty()){
                    day_hours_overtime.clear();
                    hold(200);
                    setText(day_hours_overtime, hours);
                }else{
                    hold(100);
                    day_hours_overtime.clear();
                    hold(200);
                    setText(day_hours_overtime, "8");
                }
            }else{
                if(is_setup_overtime_hours.isSelected()){
                    clickOn(is_setup_overtime_hours);
                }
            }

            clickOn(saveBtn);
            hold(300);
            waitElementClickable(exitBtn);
            driver.close();
            backToParentWindow(parentWindow);
            closeIFrame();

        }

        setLog("Overtime Hours Setup: "+overtimeHoursSetup+" - Method: "+method+" - Hours: "+hours);

    }

    public void employeeCostIsDistributedOn(String distributedOn){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(otherOptions);
        setLog("Open Other Options");
        hold(300);
        elementWaitAdvanced(By.name("hostelries_round"));
        Select select = new Select(employeeCostIsDistributedOnE);
        if(employeeCostIsDistributedOnE.isEnabled()){
            select.selectByVisibleText(distributedOn);
        }else{
            ((JavascriptExecutor) driver).executeScript("arguments[0].disabled = false;", employeeCostIsDistributedOnE);
            hold(300);
            System.out.println("This Option Edited By Inspect javascript");
            select.selectByVisibleText(distributedOn);
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("Employee Cost Is Distributed On: "+distributedOn);

    }

    public void projectsCostIsDistributedOver(String distributedOver){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(otherOptions);
        setLog("Open Other Options");
        hold(300);
        elementWaitAdvanced(By.name("hostelries_round"));
        Select select = new Select(projectsCostIsDistributedOverE);
        select.selectByVisibleText(distributedOver);
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("Projects Cost Is Distributed Over: "+distributedOver);

    }

    public void overtimeRule(String perHoursOrPercent, String valuePerMonth,String valuePerWeek, String valuePerDay, String allowance){

        hold(300);
        goToFrame(frame);
        clickOn(overtimeRule);
        setLog("Open Overtime Rule");
        hold(500);
        elementWaitAdvanced(By.id("overtime_upper_limit_type1"));
        if(perHoursOrPercent.equalsIgnoreCase("Hours")){
            clickOn(overtimePerHours);
            hold(300);
            overtimeMonthUpperLimitHours.clear();
            hold(100);
            setText(overtimeMonthUpperLimitHours, valuePerMonth);
            hold(100);
            OvertimeWeekUpperLimitHours.clear();
            hold(100);
            setText(OvertimeWeekUpperLimitHours, valuePerWeek);
            hold(100);
            overtimeDayUpperLimitHours.clear();
            hold(100);
            setText(overtimeDayUpperLimitHours, valuePerDay);
            hold(500);
        }else if(perHoursOrPercent.equalsIgnoreCase("Percent")){
            clickOn(overtimePerPercent);
            hold(300);
            overtimeMonthUpperLimitPercent.clear();
            hold(100);
            setText(overtimeMonthUpperLimitPercent, valuePerMonth);
            hold(100);
            OvertimeWeekUpperLimitPercent.clear();
            hold(100);
            setText(OvertimeWeekUpperLimitPercent, valuePerWeek);
            hold(100);
            overtimeDayUpperLimitPercent.clear();
            hold(100);
            setText(overtimeDayUpperLimitPercent, valuePerDay);
            hold(500);
        }
        if(!allowance.isEmpty() && perHoursOrPercent.equalsIgnoreCase("Percent")){
            Select select = new Select(overtimeFollowingAllowancesOptions);
            select.selectByVisibleText(allowance);
            hold(500);
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();

        setLog("per Hours Or Percent: "+perHoursOrPercent
        +" - value Per Month: "+valuePerMonth
        +" - value Per Week: "+valuePerWeek
        +" - value Per Day: "+valuePerDay
        +" - allowance: "+allowance);

    }

    public void workingSetup(String method, String hours, String cutOffDate){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(workYearSetup);
        setLog("Working Setup");
        hold(300);
        if(method.equalsIgnoreCase("30")){
            clickOn(workingDaysPerMonth);
            workingHoursPerDayAmount.clear();
            hold(100);
            setText(workingHoursPerDayAmount, "30");
        }else if(method.equalsIgnoreCase("Calendar")){
            clickOn(calendarMethod);
        }else if(method.equalsIgnoreCase("30 Days Method")){
            clickOn(workingDaysPerMonth);
            workingHoursPerDayAmount.clear();
            hold(100);
            setText(workingHoursPerDayAmount, "30");
        }else{
            clickOn(calendarMethod);
        }
        hold(200);
        if(!hours.isEmpty()){
            hold(100);
            workingHoursPerDayE.clear();
            hold(200);
            setText(workingHoursPerDayE, hours);
        }else{
            hold(100);
            workingHoursPerDayE.clear();
            hold(200);
            setText(workingHoursPerDayE, "8");
        }
        hold(200);
        if(!cutOffDate.isEmpty()){
            Select cut = new Select(cutOffDateE);
            cut.selectByVisibleText(cutOffDate);
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(300);
        closeIFrame();

        setLog("Method: "+method+" - Hours: "+hours+" - Cut Off Date: "+cutOffDate);

    }

    public void workingDaysPerMonth(String days, boolean onlyWorkingDaysAreAccordingToCalendarInHiring, boolean onlyWorkingDaysAreAccordingToCalendarInTermination, String workingHoursPerDay, String cutOffDate){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(workYearSetup);
        setLog("Working Setup");
        hold(300);
        if(!days.isEmpty()){
            clickOn(workingDaysPerMonth);
            workingHoursPerDayAmount.clear();
            hold(100);
            setText(workingHoursPerDayAmount, days);
        }else{
            clickOn(workingDaysPerMonth);
            workingHoursPerDayAmount.clear();
            hold(100);
            setText(workingHoursPerDayAmount, "30");
        }

        if(onlyWorkingDaysAreAccordingToCalendarInHiring){
            if(!calc_based_on_calendarInHiring.isSelected()){
                clickOn(calc_based_on_calendarInHiring);
            }
        }else{
            if(calc_based_on_calendarInHiring.isSelected()){
                clickOn(calc_based_on_calendarInHiring);
            }
        }

        if(onlyWorkingDaysAreAccordingToCalendarInTermination){
            if(!calc_based_on_calendarInTerm.isSelected()){
                clickOn(calc_based_on_calendarInTerm);
            }
        }else{
            if(calc_based_on_calendarInTerm.isSelected()){
                clickOn(calc_based_on_calendarInTerm);
            }
        }

        hold(200);
        if(!workingHoursPerDay.isEmpty()){
            hold(100);
            workingHoursPerDayE.clear();
            hold(200);
            setText(workingHoursPerDayE, workingHoursPerDay);
        }else{
            hold(100);
            workingHoursPerDayE.clear();
            hold(200);
            setText(workingHoursPerDayE, "8");
        }
        hold(200);
        if(!cutOffDate.isEmpty()){
            Select cut = new Select(cutOffDateE);
            cut.selectByVisibleText(cutOffDate);
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(300);
        closeIFrame();

        setLog("Working Setup"
        +" - days: "+days
        +" - Only Working Days Are According To Calendar In Hiring: "+onlyWorkingDaysAreAccordingToCalendarInHiring
        +" - Only Working Days Are According To Calendar In Termination: "+onlyWorkingDaysAreAccordingToCalendarInTermination
        +" - Working Hours Per Day: "+workingHoursPerDay
        +" - Cut Off Date: "+cutOffDate);

    }

    public void socialSecurityStarts(String month){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(calculationOptionsTab);
        setLog("Calculation Option Tab");
        hold(500);
        Select select = new Select(social_security_starts);
        select.selectByVisibleText(month);
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(300);
        closeIFrame();

        setLog("Social Security Starts: "+month);

    }

    public void insuranceStarts(String month){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(calculationOptionsTab);
        setLog("Calculation Option Tab");
        hold(500);
        Select select = new Select(insurance_starts);
        select.selectByVisibleText(month);
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(300);
        closeIFrame();

        setLog("insurance Starts: "+month);

    }

    public void calculateHealthInsuranceAccordingToDate(boolean checkbox){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.className("TabsTableTag"));
        clickOn(calculationOptionsTab);
        setLog("Calculation Option Tab");
        hold(500);
        if(checkbox){
            if(!insurance_according_to_date.isSelected()){
                insurance_according_to_date.click();
            }
        }else{
            if(insurance_according_to_date.isSelected()){
                insurance_according_to_date.click();
            }
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(300);
        closeIFrame();

        setLog("Calculate Health Insurance According To Date: "+checkbox);

    }

}
