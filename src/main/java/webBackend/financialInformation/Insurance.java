package webBackend.financialInformation;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;
import static utilities.VersionGetter.liteGetter;
import static utilities.VersionGetter.versionGetter;

public class Insurance extends WebBase {

    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'financial_data.php')]")
    WebElement insuranceTab;
    @FindBy(xpath = "//div[contains(@onclick, 'sys_tab_selector(1)')]")
    WebElement healthInsurancePage;
    @FindBy(xpath = "//div[contains(@onclick, 'sys_tab_selector(2)')]")
    WebElement socialSecurityPage;
    @FindBy(xpath = "//div[contains(@onclick, 'sys_tab_selector(3)')]")
    WebElement EOSPage;
    @FindBy(xpath = "//div[contains(@onclick, 'sys_tab_selector(4)')]")
    WebElement GLAccountPage;
    @FindBy(xpath = "//div[contains(@onclick, 'sys_tab_selector(5)')]")
    WebElement otherPage;
    @FindBy(id = "fixed_flag")
    WebElement permanentOnDateCheckboxE;
    @FindBy(id = "fixed_date")
    WebElement permanentOnDateE;
    @FindBy(name = "stop_val_flag")
    WebElement terminatedOnDateCheckboxE;
    @FindBy(id = "emp_end_date")
    WebElement terminatedOnDateE;
    @FindBy(xpath = "//label[contains(@class, 'font-size-10 semibold active-label mar-left-4-minus')]")
    WebElement employeeStatus;
    @FindBy(name = "deny_overtime_add")
    WebElement notEntitledToOvertimeCheckbox;
    @FindBy(id = "overtime_expenses")
    WebElement overtimeExpensesBatchSelect;
    @FindBy(id = "salary_stop_date")
    WebElement salaryStopDateE;
    @FindBy(id = "select2-overtime_expenses-container")
    WebElement overtimeExpensesBatchE;
    @FindBy(xpath = "//span[contains(@id, 'select2-extra_salary')]")
    WebElement noOfYearlySalariesE;
    @FindBy(name = "gl_account")
    WebElement glAccount1E;
    @FindBy(name = "gl_account2")
    WebElement glAccount2E;
    @FindBy(name = "notes")
    WebElement noteE;
    @FindBy(xpath = "//input[contains(@onclick, 'open_extra_gl_accounts')]")
    WebElement extraGLAccountBtn;
    @FindBy(name = "gl_account[3]")
    WebElement glAccount3E;
    @FindBy(name = "gl_account[4]")
    WebElement glAccount4E;
    @FindBy(name = "gl_account[5]")
    WebElement glAccount5E;
    @FindBy(name = "gl_account[6]")
    WebElement glAccount6E;
    @FindBy(name = "gl_account[7]")
    WebElement glAccount7E;
    @FindBy(name = "gl_account[8]")
    WebElement glAccount8E;
    @FindBy(name = "gl_account[9]")
    WebElement glAccount9E;
    @FindBy(name = "gl_account[10]")
    WebElement glAccount10E;
    @FindBy(id = "save")
    WebElement extraGL_SaveBtn;
    @FindBy(className = "btn-close")
    WebElement closePopup;
    @FindBy(id = "select2-STB_code_1-container")
    WebElement eosTypeE1;
    @FindBy(name = "STB_start_date")
    WebElement eosDateE1;
    @FindBy(id = "select2-STB_code2_1-container")
    WebElement eosTypeE2;
    @FindBy(name = "STB_start_date2")
    WebElement eosDateE2;
    @FindBy(name = "stb_flag")
    WebElement eosCheckbox;
    @FindBy(id = "social_flag")
    public WebElement underGOSISecurityE;
    @FindBy(name = "allow_exceed_social")
    WebElement extendSSDeductionE;
    @FindBy(name = "retirement_flag")
    WebElement retirementE;
    @FindBy(id = "select2-social_security_code-container")
    WebElement GOSISecurityTypeE;
    @FindBy(name = "social_security_code")
    WebElement GOSISecurityTypeSelect;
    @FindBy(id = "social_security_start_date")
    public WebElement GOSISecurityStartDateE;
    @FindBy(id = "social_amnont")
    WebElement GOSISecuritySalaryE;
    @FindBy(xpath = "//img[contains(@onclick, 'show_salary_changed(0)')]")
    WebElement calculateSSSalaryBtn;
    @FindBy(id = "additional_social_amount")
    WebElement additionalSocialSecurityE;
    @FindBy(xpath = "//img[contains(@onclick, 'show_salary_changed(1)')]")
    WebElement calculateAdditionalSalaryBtn;
    @FindBy(name = "insurance_flag")
    WebElement insuredCheckbox;
    @FindBy(name = "insurance_code")
    WebElement insuranceTypeSelect;
    @FindBy(id = "select2-insurance_code-container")
    WebElement insuredTypeE;
    @FindBy(id = "begin_ins_date")
    WebElement insuranceStartDateE;
    @FindBy(id = "end_ins_date")
    WebElement insuranceCardExpiryE;
    @FindBy(xpath = "//span[contains(@id, 'select2-parent_insurance')]")
    WebElement parentsInsuranceE;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(xpath = "//div[@class='textAlign']//label[contains(@style, 'font-size:20px')]")
    WebElement alertText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    WebElement alertBox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(id = "btok")
    WebElement okBtn;
    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(id = "All_popup")
    WebElement popupFrame;
    FinancialData_OCT financialDataOct;

    public void setEmployeeCode(String employeeCode){

        goToFrame(bodyFrame);
        elementWaitAdvanced(By.id("employee_code"));
        hold(300);
        setText(empCode, employeeCode);
        hold(300);
        setText(empCode, Keys.TAB);
        hold(300);
        elementWaitAdvanced(By.xpath("//label[contains(text(),'Active Employee')]"));

        setLog("Set Employee Code: "+employeeCode);

    }

    public void healthInsurance(boolean insured, String insuranceType, String startDate, String cardExpiry, String parentsInsurance, boolean withoutSave){

        ////// This Flag For 'Parents Insurance'
        ////// update adm_company set is_parent_insurance = 1

        if(!versionGetter().equalsIgnoreCase("OCT")){

            clickOn(insuranceTab);
            hold(1500);
            elementWaitAdvanced(By.name("insurance_flag"));
            if(insured){
                if(!insuredCheckbox.isSelected()){
                    clickOn(insuredCheckbox);
                    hold(300);
                }
            }else{
                if(insuredCheckbox.isSelected()){
                    clickOn(insuredCheckbox);
                    hold(300);
                }
            }
            if(!insuranceType.isEmpty()){
                selectOption(insuredTypeE, insuranceType);
                hold(300);
            }
            if(!startDate.isEmpty()){
                insuranceStartDateE.clear();
                setText(insuranceStartDateE, startDate);
                hold(300);
            }
            if(!cardExpiry.isEmpty()){
                setText(insuranceCardExpiryE, cardExpiry);
                hold(300);
            }
            if(!parentsInsurance.isEmpty()){
                selectOption(parentsInsuranceE, parentsInsurance);
                hold(300);
            }
            if(!withoutSave){
                clickOn(saveBtn);
                hold(500);
            }

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.healthInsurance(insured, insuranceType, startDate, cardExpiry, parentsInsurance, withoutSave);

        }

        setLog("Health Insurance"
                +" - insured: "+insured
                +" - insurance Type: "+insuranceType
                +" - start Date: "+startDate
                +" - card Expiry: "+cardExpiry
                +" - parents Insurance: "+parentsInsurance);

    }

    public void goToHealthInsurance(){
        if(!versionGetter().equalsIgnoreCase("OCT")){
            clickOn(insuranceTab);
            hold(1500);
            elementWaitAdvanced(By.name("insurance_flag"));
            hold(300);
        }else {
            financialDataOct = new FinancialData_OCT();
            clickOn(financialDataOct.insuranceTab);
            hold(300);
        }

        setLog("go To Health Insurance");
    }

    public void socialSecurity(boolean underGOSISecurity, boolean extendSSDeduction, boolean retirement, String GOSISecurityType,
                               String GOSISecurityStartDate, String GOSISecuritySalary, boolean calculateGOSISecuritySalary,
                               boolean withoutSave){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            clickOn(insuranceTab);
            hold(300);
            elementWaitAdvanced(By.name("insurance_flag"));
            clickOn(socialSecurityPage);
            hold(300);
            if(underGOSISecurity){
                if(!underGOSISecurityE.isSelected()){
                    clickOn(underGOSISecurityE);
                    hold(300);
                }
            }else{
                if(underGOSISecurityE.isSelected()){
                    clickOn(underGOSISecurityE);
                    hold(300);
                }
            }
            if(!liteGetter()){
                if(extendSSDeduction){
                    clickOn(extendSSDeductionE);
                    hold(300);
                }
            }
            if(retirement){
                clickOn(retirementE);
                hold(300);
            }
            if(!GOSISecurityType.isEmpty()){
                selectOption(GOSISecurityTypeE, GOSISecurityType);
                hold(300);
            }
            if(!GOSISecurityStartDate.isEmpty()){
                GOSISecurityStartDateE.clear();
                hold(200);
                setText(GOSISecurityStartDateE, GOSISecurityStartDate);
                hold(300);
            }
            if(!GOSISecuritySalary.isEmpty()){
                GOSISecuritySalaryE.clear();
                hold(200);
                setText(GOSISecuritySalaryE, GOSISecuritySalary);
                hold(300);
            }
            if(calculateGOSISecuritySalary){
                clickOn(calculateSSSalaryBtn);
                hold(300);
            }

            if(!withoutSave){
                clickOn(saveBtn);
                hold(300);
            }

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.socialSecurity(underGOSISecurity, extendSSDeduction, retirement, GOSISecurityType,
                    GOSISecurityStartDate, GOSISecuritySalary, calculateGOSISecuritySalary, withoutSave);

        }

        setLog("Social Security"
                +" - Under Social Security: "+underGOSISecurity
                +" - extend SS Deduction: "+extendSSDeduction
                +" - retirement: "+retirement
                +" - Social Security Type: "+GOSISecurityType
                +" - Social Security Start Date: "+GOSISecurityStartDate
                +" - Social Security Salary: "+GOSISecuritySalary
                +" - calculate Social Security Salary: "+calculateGOSISecuritySalary);

    }

    public void addExtraSalaryAndSocialSecurity(String noOfYearlySalaries, boolean underGOSISecurity, boolean extendSSDeduction, boolean retirement, String GOSISecurityType,
                               String GOSISecurityStartDate, String GOSISecuritySalary, boolean calculateGOSISecuritySalary,
                               boolean withoutSave){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            clickOn(insuranceTab);
            hold(300);
            elementWaitAdvanced(By.name("insurance_flag"));
            clickOn(otherPage);
            hold(500);
            elementWait(noOfYearlySalariesE);
            selectOption(noOfYearlySalariesE, noOfYearlySalaries);
            hold(200);
            clickOn(saveBtn);
            hold(300);
            clickOn(socialSecurityPage);
            hold(300);
            if(underGOSISecurity){
                if(!underGOSISecurityE.isSelected()){
                    clickOn(underGOSISecurityE);
                    hold(300);
                }
            }else{
                if(underGOSISecurityE.isSelected()){
                    clickOn(underGOSISecurityE);
                    hold(300);
                }
            }
            if(extendSSDeduction){
                clickOn(extendSSDeductionE);
                hold(300);
            }
            if(retirement){
                clickOn(retirementE);
                hold(300);
            }
            if(!GOSISecurityType.isEmpty()){
                selectOption(GOSISecurityTypeE, GOSISecurityType);
                hold(300);
            }
            if(!GOSISecurityStartDate.isEmpty()){
                GOSISecurityStartDateE.clear();
                hold(200);
                setText(GOSISecurityStartDateE, GOSISecurityStartDate);
                hold(300);
            }
            if(!GOSISecuritySalary.isEmpty()){
                GOSISecuritySalaryE.clear();
                hold(200);
                setText(GOSISecuritySalaryE, GOSISecuritySalary);
                hold(300);
            }
            if(calculateGOSISecuritySalary){
                clickOn(calculateSSSalaryBtn);
                hold(300);
            }

            if(!withoutSave){
                clickOn(saveBtn);
                hold(300);
            }

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.addExtraSalaryAndSocialSecurity(noOfYearlySalaries, underGOSISecurity, extendSSDeduction, retirement, GOSISecurityType,
                    GOSISecurityStartDate, GOSISecuritySalary, calculateGOSISecuritySalary, withoutSave);

        }

        setLog("Add Extra Salary And Social Security"
                +" - No Of Yearly Salaries: "+noOfYearlySalaries
                +" - Under Social Security: "+underGOSISecurity
                +" - extend SS Deduction: "+extendSSDeduction
                +" - retirement: "+retirement
                +" - Social Security Type: "+GOSISecurityType
                +" - Social Security Start Date: "+GOSISecurityStartDate
                +" - Social Security Salary: "+GOSISecuritySalary
                +" - calculate Social Security Salary: "+calculateGOSISecuritySalary);

    }

    public void socialSecurityCountryProfileKSA(boolean underGOSISecurity, boolean extendSSDeduction, boolean retirement, String GOSISecurityType,
                               String GOSISecurityStartDate, String GOSISecuritySalary, boolean calculateGOSISecuritySalary,
                               String additionalSSSalary, boolean calculateAdditionalSSSalary, boolean withoutSave){

        clickOn(insuranceTab);
        hold(300);
        elementWaitAdvanced(By.name("insurance_flag"));
        clickOn(socialSecurityPage);
        hold(300);
        if(underGOSISecurity){
            if(!underGOSISecurityE.isSelected()){
                clickOn(underGOSISecurityE);
                hold(300);
            }
        }else{
            if(underGOSISecurityE.isSelected()){
                clickOn(underGOSISecurityE);
                hold(300);
            }
        }
        if(extendSSDeduction){
            clickOn(extendSSDeductionE);
            hold(300);
        }
        if(retirement){
            clickOn(retirementE);
            hold(300);
        }
        if(!retirement){
            if(!GOSISecurityType.isEmpty()){
                selectOption(GOSISecurityTypeE, GOSISecurityType);
                hold(300);
            }
            if(!GOSISecurityStartDate.isEmpty()){
                GOSISecurityStartDateE.clear();
                hold(200);
                setText(GOSISecurityStartDateE, GOSISecurityStartDate);
                hold(300);
            }
            if(!GOSISecuritySalary.isEmpty()){
                GOSISecuritySalaryE.clear();
                hold(200);
                setText(GOSISecuritySalaryE, GOSISecuritySalary);
                hold(300);
            }
            if(calculateGOSISecuritySalary){
                clickOn(calculateSSSalaryBtn);
                hold(300);
            }
            if(!additionalSSSalary.isEmpty()){
                additionalSocialSecurityE.clear();
                hold(200);
                setText(additionalSocialSecurityE, additionalSSSalary);
                hold(300);
            }
            if(calculateAdditionalSSSalary){
                clickOn(calculateAdditionalSalaryBtn);
                hold(300);
            }
        }

        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

        setLog("Social Security"
                +" - Under Social Security: "+underGOSISecurity
                +" - extend SS Deduction: "+extendSSDeduction
                +" - retirement: "+retirement
                +" - Social Security Type: "+GOSISecurityType
                +" - Social Security Start Date: "+GOSISecurityStartDate
                +" - Social Security Salary: "+GOSISecuritySalary
                +" - additional SS Salary: "+additionalSSSalary
                +" - calculate Additional SS Salary: "+calculateAdditionalSSSalary
                +" - calculate Social Security Salary: "+calculateGOSISecuritySalary);

    }

    public void goToSocialSecurity(){
        if(!versionGetter().equalsIgnoreCase("OCT")){
            clickOn(insuranceTab);
            hold(300);
            elementWaitAdvanced(By.name("insurance_flag"));
            clickOn(socialSecurityPage);
            hold(300);
        }else {
            financialDataOct = new FinancialData_OCT();
            clickOn(financialDataOct.insuranceTab);
            hold(300);
        }
        setLog("go To Social Security");
    }

    public void calculateSS(){
        if(!versionGetter().equalsIgnoreCase("OCT")){
            clickOn(socialSecurityPage);
            elementWaitAdvanced(By.id("social_flag"));
            clickOn(calculateSSSalaryBtn);
            hold(400);
            clickOn(saveBtn);
            hold(300);
        }else {
            financialDataOct = new FinancialData_OCT();
            financialDataOct.calculateSS();
        }
        setLog("Click on calculate Security Salary");
    }

    public void calculateAndCheckLowerLimitAlert(String lowerLimitValue){
        if(!versionGetter().equalsIgnoreCase("OCT")){
            clickOn(socialSecurityPage);
            elementWaitAdvanced(By.id("social_flag"));
            clickOn(calculateSSSalaryBtn);
            hold(500);
            clickOn(saveBtn);
            hold(500);
            if(alertText.getText().trim().contains(lowerLimitValue)){
                clickOn(okBtn);
                hold(500);
                GOSISecuritySalaryE.clear();
                hold(200);
                setText(GOSISecuritySalaryE, lowerLimitValue);
                hold(200);
                clickOn(saveBtn);
                hold(300);
            }else{
                Assert.fail("Lower Limit Value Incorrect! - should be = "+lowerLimitValue);
            }

        }else {
            financialDataOct = new FinancialData_OCT();
            financialDataOct.calculateAndCheckLowerLimitAlert(lowerLimitValue);
        }

        setLog("calculate And Check Lower Limit Alert");
    }

    public void addEOS(boolean endOfService, String eosType1, String eosDate1, String eosType2, String eosDate2, boolean withoutSave){

        clickOn(insuranceTab);
        hold(300);
        elementWaitAdvanced(By.name("insurance_flag"));
        clickOn(EOSPage);
        hold(300);
        if(endOfService){
            if(!eosCheckbox.isSelected()){
                clickOn(eosCheckbox);
            }
            if(!eosType1.isEmpty()){
                selectOption(eosTypeE1, eosType1);
            }
            if(!eosDate1.isEmpty()){
                eosDateE1.clear();
                hold(200);
                setText(eosDateE1, eosDate1);
            }
            if(!eosType2.isEmpty()){
                selectOption(eosTypeE2, eosType2);
            }
            if(!eosDate2.isEmpty()){
                eosDateE2.clear();
                hold(200);
                setText(eosDateE2, eosDate2);
            }
        }else{
            if(eosCheckbox.isSelected()){
                clickOn(eosCheckbox);
            }
        }
        hold(500);

        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

        setLog("added EOS");

    }

    public void glAccount(String glAccount1, String glAccount2, String note, String glAccount3, String glAccount4,
                          String glAccount5, String glAccount6, String glAccount7, String glAccount8,
                          String glAccount9, String glAccount10, boolean withoutSave){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            clickOn(insuranceTab);
            hold(300);
            elementWaitAdvanced(By.name("insurance_flag"));
            clickOn(GLAccountPage);
            hold(300);
            if(!glAccount1.isEmpty()){
                glAccount1E.clear();
                hold(200);
                setText(glAccount1E, glAccount1);
                hold(200);
            }
            if(!glAccount2.isEmpty()){
                glAccount2E.clear();
                hold(200);
                setText(glAccount2E, glAccount2);
                hold(200);
            }
            if(!note.isEmpty()){
                setText(noteE, note);
                hold(200);
            }

            if(!glAccount3.isEmpty() || !glAccount4.isEmpty() || !glAccount5.isEmpty() || !glAccount6.isEmpty() ||
                    !glAccount7.isEmpty() || !glAccount8.isEmpty() || !glAccount9.isEmpty() || !glAccount10.isEmpty() ){

                clickOn(extraGLAccountBtn);
                hold(300);
                goToFrame(popupFrame);
                hold(500);

                if(!glAccount3.isEmpty()){
                    setText(glAccount3E, glAccount3);
                    hold(200);
                }
                if(!glAccount4.isEmpty()){
                    setText(glAccount4E, glAccount4);
                    hold(200);
                }
                if(!glAccount5.isEmpty()){
                    setText(glAccount5E, glAccount5);
                    hold(200);
                }
                if(!glAccount6.isEmpty()){
                    setText(glAccount6E, glAccount6);
                    hold(200);
                }
                if(!glAccount7.isEmpty()){
                    setText(glAccount7E, glAccount7);
                    hold(200);
                }
                if(!glAccount8.isEmpty()){
                    setText(glAccount8E, glAccount8);
                    hold(200);
                }
                if(!glAccount9.isEmpty()){
                    setText(glAccount9E, glAccount9);
                    hold(200);
                }
                if(!glAccount10.isEmpty()){
                    setText(glAccount10E, glAccount10);
                    hold(200);
                }

                clickOn(extraGL_SaveBtn);
                hold(300);
                clickOn(closePopup);
                driver.switchTo().parentFrame();
                hold(500);

            }

            if(!withoutSave){
                clickOn(saveBtn);
                hold(500);
            }

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.glAccount(glAccount1, glAccount2, note, withoutSave);

        }

        setLog("GL Account"
                +" - GL Account 1: "+glAccount1
                +" - GL Account 2: "+glAccount2
                +" - GL Account 3: "+glAccount3
                +" - GL Account 4: "+glAccount4
                +" - GL Account 5: "+glAccount5
                +" - GL Account 6: "+glAccount6
                +" - GL Account 7: "+glAccount7
                +" - GL Account 8: "+glAccount8
                +" - GL Account 9: "+glAccount9
                +" - GL Account 10: "+glAccount10
                +" - note: "+note);

    }

    public void goToGLAccount(){
        clickOn(insuranceTab);
        hold(300);
        elementWaitAdvanced(By.name("insurance_flag"));
        clickOn(GLAccountPage);
        hold(300);
        setLog("go To GL Account");
    }

    public void clickOnExtraGLAccount(){
        hold(500);
        clickOn(extraGLAccountBtn);
        hold(500);
        goToFrame(popupFrame);
        setLog("click On Extra GL Account");

    }

    public void other(boolean permanentOnDateCheckbox, String permanentOnDate, boolean terminatedOnDateCheckbox, String terminatedOnDate,
                      boolean notEntitledToOvertime, String salaryStopDate, String overtimeExpensesBatch, String noOfYearlySalaries, boolean withoutSave){

        clickOn(insuranceTab);
        hold(300);
        elementWaitAdvanced(By.name("insurance_flag"));
        clickOn(otherPage);
        hold(300);
        if(permanentOnDateCheckbox){
            if(!permanentOnDateCheckboxE.isSelected()){
                clickOn(permanentOnDateCheckboxE);
            }
        }else{
            if(permanentOnDateCheckboxE.isSelected()){
                clickOn(permanentOnDateCheckboxE);
            }
        }
        if(!permanentOnDate.isEmpty()){
            permanentOnDateE.clear();
            hold(200);
            setText(permanentOnDateE, permanentOnDate);
        }
        if(terminatedOnDateCheckbox){
            if(!terminatedOnDateCheckboxE.isSelected()){
                clickOn(terminatedOnDateCheckboxE);
                hold(300);
                if(!terminatedOnDate.isEmpty()){
                    setText(terminatedOnDateE, terminatedOnDate);
                    hold(200);
                }
            }
        }else{
            if(terminatedOnDateCheckboxE.isSelected()){
                clickOn(terminatedOnDateCheckboxE);
                hold(200);
            }
        }
        if(notEntitledToOvertime){
            if(!notEntitledToOvertimeCheckbox.isSelected()){
                clickOn(notEntitledToOvertimeCheckbox);
                hold(200);
            }
        }else{
            if(notEntitledToOvertimeCheckbox.isSelected()){
                clickOn(notEntitledToOvertimeCheckbox);
                hold(200);
            }
        }
        if(!salaryStopDate.isEmpty()){
            setText(salaryStopDateE, salaryStopDate);
            hold(200);
        }
        if(!overtimeExpensesBatch.isEmpty()){
            selectOption(overtimeExpensesBatchE, overtimeExpensesBatch);
            hold(200);
        }
        if(!noOfYearlySalaries.isEmpty()){
            selectOption(noOfYearlySalariesE, noOfYearlySalaries);
            hold(200);
        }

        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

        setLog("Other Tab added data");

    }

    public void addExtraSalary(String noOfYearlySalaries){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            clickOn(insuranceTab);
            hold(300);
            elementWaitAdvanced(By.name("insurance_flag"));
            clickOn(otherPage);
            hold(500);
            elementWait(noOfYearlySalariesE);
            selectOption(noOfYearlySalariesE, noOfYearlySalaries);
            hold(200);
            clickOn(saveBtn);
            hold(300);

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.addExtraSalary(noOfYearlySalaries);

        }

        setLog("Add Extra Salary - no Of Yearly Salaries: "+noOfYearlySalaries);

    }

    public boolean getUnderSocialSecurity(){

        boolean check = false;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            check = underGOSISecurityE.isSelected();
        }else {
            financialDataOct = new FinancialData_OCT();
            check = financialDataOct.underGOSISecurityE.isSelected();
        }
        return check;

    }

    public boolean getInsured(){

        boolean check = false;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            check = insuredCheckbox.isSelected();
        }else {
            financialDataOct = new FinancialData_OCT();
            check = financialDataOct.insuredCheckbox.isSelected();
        }
        return check;

    }

    public String getInsuredType(){

        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = insuredTypeE.getText().trim();
        }else {
            financialDataOct = new FinancialData_OCT();
            Select select = new Select(financialDataOct.insuredTypeE);
            str = select.getFirstSelectedOption().getText().trim();
        }
        return str;

    }

    public String insuranceStartDate(){

        String value = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            value = insuranceStartDateE.getDomAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            value = financialDataOct.insuranceStartDateE.getDomAttribute("value");
        }
        return value;

    }

    public String socialSecurityStartDate(){

        String value = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            value = GOSISecurityStartDateE.getDomAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            value = financialDataOct.GOSISecurityStartDateE.getDomAttribute("value");
        }
        return value;

    }

    public String socialSecuritySalary(){

        String value = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            value = GOSISecuritySalaryE.getDomAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            value = financialDataOct.GOSISecuritySalaryE.getDomAttribute("value");
        }
        return value;

    }

}
