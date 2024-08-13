package webBackend.financialInformation;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import static utilities.WebHelper.hold;

public class FinancialData_OCT extends WebBase {

    @FindBy(id = "body_frame")
    public WebElement bodyFrame;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "MenuNewButton")
    WebElement menuNew;
    @FindBy(id = "basic_salary_amount")
    public WebElement basicSalaryE;
    @FindBy(id = "total_salary_amount")
    public WebElement totalSalary;
    @FindBy(xpath = "//div[@class='row']//label[contains(@style, 'font-size: 19px;')]")
    public WebElement totalAllowances;
    @FindBy(xpath = "(//img[contains(@src, 'currency.jpg')])[1]")
    public WebElement currencyConverterBesideBS;
    @FindBy(name = "value")
    public WebElement convertCurrencyValue;
    @FindBy(name = "All_popup")
    public WebElement popupFrame;
    @FindBy(xpath = "//input[contains(@onclick, 'convert()')]")
    public WebElement convertButton;
    @FindBy(xpath = "(//font[contains(text(), '$')])[1]")
    public WebElement dollarSignBesideBS;
    @FindBy(xpath = "(//font[contains(text(), '€')])[1]")
    public WebElement euroSignBesideBS;
    @FindBy(xpath = "(//font[contains(text(), '$')])[2]")
    public WebElement dollarSignBesideAmount;
    @FindBy(xpath = "(//font[contains(text(), '€')])[2]")
    public WebElement euroSignBesideAmount;
    @FindBy(id = "original_salary")
    public WebElement originalSalaryE;
    @FindBy(id = "current_salary_x")
    public WebElement currentSalaryE;
    @FindBy(id = "select2-work_schedule_x-container")
    public WebElement workScheduleE;
    @FindBy(xpath = "(//img[contains(@src, 'currency.jpg')])[2]")
    public WebElement currencyConverterInsideFirstAllowance;
    @FindBy(name = "allownce_code[1]")
    public WebElement allowanceCodeE1;
    @FindBy(name = "allownce_code[2]")
    public WebElement allowanceCodeE2;
    @FindBy(name = "allownce_code[3]")
    public WebElement allowanceCodeE3;
    @FindBy(name = "allownce_amnt[1]")
    public WebElement allowanceAmountE1;
    @FindBy(xpath = "(//input[contains(@name, 'allownce_amnt')])[last()]")
    public WebElement allowanceAmount_last;
    @FindBy(xpath = "(//select[contains(@id, 'allownce_codex')])[last()]")
    public WebElement allowanceCode_last;
    @FindBy(xpath = "(//input[contains(@id, 'initial_date')])[last()]")
    public WebElement allowanceFromDate_last;
    @FindBy(xpath = "(//input[contains(@id, 'final_date')])[last()]")
    public WebElement allowanceToDate_last;
    @FindBy(xpath = "(//input[contains(@name, 'allowance_hold_percent')])[last()]")
    public WebElement allowanceWithhold_last;
    @FindBy(xpath = "(//input[contains(@name, 'notes')])[last()]")
    public WebElement allowanceNote_last;
    @FindBy(name = "allownce_amnt[2]")
    public WebElement allowanceAmountE2;
    @FindBy(name = "allownce_amount[1]")
    public WebElement allowanceAmountAnnualPackageE1;
    @FindBy(name = "allownce_amount[2]")
    public WebElement allowanceAmountAnnualPackageE2;
    @FindBy(name = "allownce_amnt[3]")
    public WebElement allowanceAmountE3;
    @FindBy(name = "original_amnt[1]")
    public WebElement originalAmountE1;
    @FindBy(name = "original_amnt[2]")
    public WebElement originalAmountE2;
    @FindBy(name = "original_amnt[3]")
    public WebElement originalAmountE3;
    @FindBy(name = "current_amnt[1]")
    public WebElement currentAmountE1;
    @FindBy(name = "current_amnt[2]")
    public WebElement currentAmountE2;
    @FindBy(name = "current_amnt[3]")
    public WebElement currentAmountE3;
    @FindBy(name = "initial_date[1]")
    public WebElement allowanceFromDateE1;
    @FindBy(name = "initial_date[2]")
    public WebElement allowanceFromDateE2;
    @FindBy(name = "initial_date[3]")
    public WebElement allowanceFromDateE3;
    @FindBy(name = "final_date[1]")
    public WebElement allowanceToDateE1;
    @FindBy(name = "final_date[2]")
    public WebElement allowanceToDateE2;
    @FindBy(name = "final_date[3]")
    public WebElement allowanceToDateE3;
    @FindBy(name = "allowance_hold_percent[1]")
    public WebElement allowanceWithholdE1;
    @FindBy(name = "allowance_hold_percent[2]")
    public WebElement allowanceWithholdE2;
    @FindBy(name = "allowance_hold_percent[3]")
    public WebElement allowanceWithholdE3;
    @FindBy(name = "notes[1]")
    public WebElement allowanceNoteE1;
    @FindBy(name = "notes[2]")
    public WebElement allowanceNoteE2;
    @FindBy(name = "notes[3]")
    public WebElement allowanceNoteE3;
    @FindBy(xpath = "(//input[contains(@onclick, 'open_allowance_trans_history')])[1]")
    public WebElement transactionHistoryFirstAllowance;
    @FindBy(name = "checkbox[1]")
    public WebElement selectFirstAllowance;
    @FindBy(name = "checkbox[2]")
    public WebElement selectSecondAllowance;
    @FindBy(name = "checkbox[3]")
    public WebElement selectThirdAllowance;
    @FindBy(xpath = "(//option[text()='Child Allowance']/following::input)[1]")
    public WebElement childAllowanceAmount;
    @FindBy(xpath = "(//option[text()='Spouse Allowance']/following::input)[1]")
    public WebElement spouseAllowanceAmount;
    @FindBy(id = "employee_code")
    public WebElement empCode;
    @FindBy(id = "salary_code")
    public WebElement packageCodeE;
    @FindBy(xpath = "//a[contains(@href, 'go_allownce()')]")
    public WebElement financialPackageTab;
    @FindBy(xpath = "//a[contains(@href, 'go_financial_data()')]")
    public WebElement insuranceTab;
    @FindBy(name = "gl_account")
    WebElement glAccount1E;
    @FindBy(name = "gl_account2")
    WebElement glAccount2E;
    @FindBy(name = "notes")
    WebElement noteE;
    @FindBy(name = "insurance_flag")
    public WebElement insuredCheckbox;
    @FindBy(name = "insurance_code")
    public WebElement insuredTypeE;
    @FindBy(name = "begin_ins_date")
    public WebElement insuranceStartDateE;
    @FindBy(name = "end_ins_date")
    public WebElement insuranceEndDateE;
    @FindBy(name = "parent_insurance")
    public WebElement parent_insurance;
    @FindBy(xpath = "//img[contains(@onclick, 'show_salary_changed')]")
    public WebElement calculateSSBtn;
    @FindBy(id = "social_flag")
    public WebElement underGOSISecurityE;
    @FindBy(name = "allow_exceed_social")
    WebElement extendSSDeductionE;
    @FindBy(name = "retirement_flag")
    WebElement retirementE;
    @FindBy(id = "social_security_code")
    WebElement GOSISecurityTypeE;
    @FindBy(id = "social_security_start_date")
    public WebElement GOSISecurityStartDateE;
    @FindBy(id = "social_amnont")
    WebElement GOSISecuritySalaryE;
    @FindBy(xpath = "//a[contains(@href, 'employee_housing.php')]")
    public WebElement housingPage;
    @FindBy(xpath = "//a[contains(@href, 'other_benefits.php')]")
    public WebElement nonPayrollBenefitsPage;
    @FindBy(xpath = "(//select[contains(@name, 'field_id')])[last()]")
    public WebElement benefitTypeE;
    @FindBy(xpath = "(//input[contains(@name, 'field_value')])[last()]")
    public WebElement benefitAmountE;
    @FindBy(xpath = "//div[contains(@onclick, 'sys_tab_selector(5)')]")
    public WebElement otherPage;
    @FindBy(name = "extra_salary")
    public WebElement noOfYearlySalariesE;
    @FindBy(xpath = "//input[contains(@name, 'btn')]")
    public List<WebElement> historyDetailsBtn;
    @FindBy(xpath = "//tr[position()>1]//td")
    public List<WebElement> historyDetailsElements;
    @FindBy(xpath = "//a[contains(@href, 'tax_data.php')]")
    WebElement taxDataTab;
    @FindBy(id = "taxable_flag")
    WebElement taxableCheckbox;
    @FindBy(id = "resident")
    WebElement personalExemptionCheckbox;
    @FindBy(id = "other_help")
    WebElement familyExemptionCheckbox;
    @FindBy(name = "expected_tax")
    WebElement expectedTaxE;
    @FindBy(name = "expected_tax_type")
    WebElement taxTypeE;
    @FindBy(id = "housing_loans")
    WebElement otherExemptionsE;
    @FindBy(name = "national_tax")
    WebElement nationalTaxE;
    @FindBy(xpath = "//a[contains(@href, 'endless_deduction_data.php')]")
    WebElement permanentDeductionsTab;
    @FindBy(xpath = "(//select[contains(@name, 'endless_ded')])[last()]")
    WebElement permanentDeductionTypeE;
    @FindBy(xpath = "(//input[contains(@name, 'transaction_date')])[last()]")
    WebElement PD_FromDate;
    @FindBy(xpath = "(//input[contains(@name, 'final_date')])[last()]")
    WebElement PD_ToDate;
    @FindBy(xpath = "(//input[contains(@name, 'notes')])[last()]")
    WebElement PD_Note;
    @FindBy(name = "paymeny_method")
    WebElement paymentMethodE;
    @FindBy(name = "bank_code")
    WebElement bankE;
    @FindBy(name = "bank_branch")
    WebElement bankBranchE;
    @FindBy(id = "account_code")
    WebElement accountNumberE;
    @FindBy(id = "iban_number")
    WebElement ibanNumberE;
    @FindBy(name = "bank_commitment")
    WebElement bankCommitmentCheckbox;
    @FindBy(className = "three-dots")
    WebElement accountBeneficiaryE;
    @FindBy(name = "beneficiary_name_eng")
    WebElement beneficiaryNameEnglishE;
    @FindBy(name = "beneficiary_name_a")
    WebElement beneficiaryNameArabicE;
    @FindBy(name = "saveit")
    WebElement accountBeneficiarySave;

    public void setEmployeeCode(String employeeCode){

        closeIFrame();
        goToFrame(bodyFrame);
        elementWaitAdvanced(By.id("employee_code"));
        hold(300);
        empCode.clear();
        hold(100);
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);

    }

    public void setBasicSalary(String basicSalary){

        elementWaitAdvanced(By.id("basic_salary_amount"));
        if(!basicSalary.isEmpty()){
            basicSalaryE.clear();
            hold(300);
            setText(basicSalaryE, basicSalary);
        }
        hold(200);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(bodyFrame);

    }

    public void addAllowances(String allowanceCode, String allowanceAmount, String fromDate,
                              String toDate, String withhold, String note){

        elementWaitAdvanced(By.id("basic_salary_amount"));

        if(!allowanceCode.isEmpty()){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuNew);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
            normalSelect(allowanceCode_last, allowanceCode);
            hold(200);
            if(!allowanceAmount.isEmpty()){
                allowanceAmount_last.clear();
                hold(300);
                setText(allowanceAmount_last, allowanceAmount);
            }
            if(!fromDate.isEmpty()){
                allowanceFromDate_last.clear();
                hold(300);
                setText(allowanceFromDate_last, fromDate);
            }
            if(!toDate.isEmpty()){
                allowanceToDate_last.clear();
                hold(300);
                setText(allowanceToDate_last, toDate);
            }
            if(!withhold.isEmpty()){
                allowanceWithhold_last.clear();
                hold(300);
                setText(allowanceWithhold_last, withhold);
            }
            if(!note.isEmpty()){
                allowanceNote_last.clear();
                hold(300);
                setText(allowanceNote_last, note);
            }
            hold(300);
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
        }

    }

    public void financialData(String basicSalary, String firstAllowance, String amountFirstAllowance, String fromDateFirstAllowance,
                              String toDateFirstAllowance, String withholdFirstAllowance, String noteFirstAllowance,
                              String secondAllowance, String amountSecondAllowance, String fromDateSecondAllowance,
                              String toDateSecondAllowance, String withholdSecondAllowance, String noteSecondAllowance,
                              String thirdAllowance, String amountThirdAllowance, String fromDateThirdAllowance,
                              String toDateThirdAllowance, String withholdThirdAllowance, String noteThirdAllowance){

        elementWaitAdvanced(By.id("basic_salary_amount"));
        if(!basicSalary.isEmpty()){
            basicSalaryE.clear();
            hold(300);
            setText(basicSalaryE, basicSalary);
        }
        hold(300);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(bodyFrame);

        if(!firstAllowance.isEmpty()){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuNew);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
            normalSelect(allowanceCodeE1, firstAllowance);
            hold(200);
            if(!amountFirstAllowance.isEmpty()){
                allowanceAmountE1.clear();
                hold(300);
                setText(allowanceAmountE1, amountFirstAllowance);
            }
            if(!fromDateFirstAllowance.isEmpty()){
                allowanceFromDateE1.clear();
                hold(300);
                setText(allowanceFromDateE1, fromDateFirstAllowance);
            }
            if(!toDateFirstAllowance.isEmpty()){
                allowanceToDateE1.clear();
                hold(300);
                setText(allowanceToDateE1, toDateFirstAllowance);
            }
            if(!withholdFirstAllowance.isEmpty()){
                allowanceWithholdE1.clear();
                hold(300);
                setText(allowanceWithholdE1, withholdFirstAllowance);
            }
            if(!noteFirstAllowance.isEmpty()){
                allowanceNoteE1.clear();
                hold(300);
                setText(allowanceNoteE1, noteFirstAllowance);
            }
            scrollToElement(empCode);
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
        }

        if(!secondAllowance.isEmpty()){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuNew);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
            hold(300);
            normalSelect(allowanceCodeE2, secondAllowance);
            hold(200);
            if(!amountSecondAllowance.isEmpty()){
                allowanceAmountE2.clear();
                hold(300);
                setText(allowanceAmountE2, amountSecondAllowance);
            }
            if(!fromDateSecondAllowance.isEmpty()){
                allowanceFromDateE2.clear();
                hold(300);
                setText(allowanceFromDateE2, fromDateSecondAllowance);
            }
            if(!toDateSecondAllowance.isEmpty()){
                allowanceToDateE2.clear();
                hold(300);
                setText(allowanceToDateE2, toDateSecondAllowance);
            }
            if(!withholdSecondAllowance.isEmpty()){
                allowanceWithholdE2.clear();
                hold(300);
                setText(allowanceWithholdE2, withholdSecondAllowance);
            }
            if(!noteSecondAllowance.isEmpty()){
                allowanceNoteE2.clear();
                hold(300);
                setText(allowanceNoteE2, noteSecondAllowance);
            }
            scrollToElement(empCode);
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
        }

        if(!thirdAllowance.isEmpty()){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuNew);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
            hold(300);
            normalSelect(allowanceCodeE3, thirdAllowance);
            hold(200);
            if(!amountThirdAllowance.isEmpty()){
                allowanceAmountE3.clear();
                hold(300);
                setText(allowanceAmountE3, amountThirdAllowance);
            }
            if(!fromDateThirdAllowance.isEmpty()){
                allowanceFromDateE3.clear();
                hold(300);
                setText(allowanceFromDateE3, fromDateThirdAllowance);
            }
            if(!toDateThirdAllowance.isEmpty()){
                allowanceToDateE3.clear();
                hold(300);
                setText(allowanceToDateE3, toDateThirdAllowance);
            }
            if(!withholdThirdAllowance.isEmpty()){
                allowanceWithholdE3.clear();
                hold(300);
                setText(allowanceWithholdE3, withholdThirdAllowance);
            }
            if(!noteThirdAllowance.isEmpty()){
                allowanceNoteE3.clear();
                hold(300);
                setText(allowanceNoteE3, noteThirdAllowance);
            }
            scrollToElement(empCode);
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);

        }

    }

    public void addExtraSalary(String noOfYearlySalaries){

        clickOn(insuranceTab);
        hold(300);
        elementWait(noOfYearlySalariesE);
        normalSelect(noOfYearlySalariesE, noOfYearlySalaries);
        hold(200);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(bodyFrame);

    }

    public void socialSecurity(boolean underGOSISecurity, boolean extendSSDeduction, boolean retirement, String GOSISecurityType,
                               String GOSISecurityStartDate, String GOSISecuritySalary, boolean calculateGOSISecuritySalary,
                               boolean withoutSave){

        clickOn(insuranceTab);
        hold(300);
        elementWaitAdvanced(By.name("insurance_flag"));
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
            normalSelect(GOSISecurityTypeE, GOSISecurityType);
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
            clickOn(calculateSSBtn);
            hold(300);
        }

        if(!withoutSave){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
        }

    }

    public void addExtraSalaryAndSocialSecurity(String noOfYearlySalaries, boolean underGOSISecurity, boolean extendSSDeduction, boolean retirement, String GOSISecurityType,
                               String GOSISecurityStartDate, String GOSISecuritySalary, boolean calculateGOSISecuritySalary,
                               boolean withoutSave){

        clickOn(insuranceTab);
        hold(300);
        elementWait(noOfYearlySalariesE);
        normalSelect(noOfYearlySalariesE, noOfYearlySalaries);
        hold(200);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(bodyFrame);
        elementWaitAdvanced(By.name("insurance_flag"));
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
            normalSelect(GOSISecurityTypeE, GOSISecurityType);
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
            clickOn(calculateSSBtn);
            hold(300);
        }

        if(!withoutSave){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
        }

    }

    public void calculateSS(){
        clickOn(calculateSSBtn);
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(bodyFrame);
    }

    public void calculateAndCheckLowerLimitAlert(String lowerLimitValue){

        clickOn(calculateSSBtn);
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(400);
        alertWait();
        Alert alert = getDriver().switchTo().alert();
        hold(500);
        if(alert.getText().contains(lowerLimitValue)){
            alert.accept();
            hold(500);
            closeIFrame();
            goToFrame(bodyFrame);
            hold(500);
            GOSISecuritySalaryE.clear();
            hold(200);
            setText(GOSISecuritySalaryE, lowerLimitValue);
            hold(200);
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);

        }else{
            Assert.fail("Lower Limit Value Incorrect! - should be = "+lowerLimitValue);
        }
        closeIFrame();
        hold(300);
        goToFrame(bodyFrame);

    }

    public void healthInsurance(boolean insured, String insuranceType, String startDate, String cardExpiry, String parentsInsurance, boolean withoutSave){

        clickOn(insuranceTab);
        hold(300);
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
            normalSelect(insuredTypeE, insuranceType);
            hold(300);
        }
        if(!startDate.isEmpty()){
            setText(insuranceStartDateE, startDate);
            hold(300);
        }
        if(!cardExpiry.isEmpty()){
            setText(insuranceEndDateE, cardExpiry);
            hold(300);
        }
        if(!parentsInsurance.isEmpty()){
            normalSelect(parent_insurance, parentsInsurance);
            hold(300);
        }
        if(!withoutSave){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
        }

    }

    public void nonPayrollBenefits(String benefitType, String benefitAmount){

        clickOn(nonPayrollBenefitsPage);
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        hold(300);
        goToFrame(bodyFrame);
        if(!benefitType.isEmpty()){
            normalSelect(benefitTypeE, benefitType);
            hold(200);
        }
        if(!benefitAmount.isEmpty()){
            benefitAmountE.clear();
            hold(200);
            setText(benefitAmountE, benefitAmount);
            hold(200);
        }

        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(bodyFrame);

    }

    public void jordanTax(boolean taxable, boolean personalExemption, boolean familyExemption, String expectedTax, String expectedTaxType,
                          String otherExemptions, String nationalTax, boolean withoutSave){

        clickOn(taxDataTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(personalExemption){
            if(!personalExemptionCheckbox.isSelected()){
                clickOn(personalExemptionCheckbox);
                hold(200);
            }
        }else{
            if(personalExemptionCheckbox.isSelected()){
                clickOn(personalExemptionCheckbox);
                hold(200);
            }
        }
        if(familyExemption){
            if(!familyExemptionCheckbox.isSelected()){
                clickOn(familyExemptionCheckbox);
                hold(200);
            }
        }else{
            if(familyExemptionCheckbox.isSelected()){
                clickOn(familyExemptionCheckbox);
                hold(200);
            }
        }
        if(taxable){
            if(!expectedTax.isEmpty()){
                expectedTaxE.clear();
                hold(200);
                setText(expectedTaxE, expectedTax);
            }
            if(!expectedTaxType.isEmpty()){
                normalSelect(taxTypeE, expectedTaxType);
            }
            if(!nationalTax.isEmpty()){
                nationalTaxE.clear();
                hold(200);
                setText(nationalTaxE, nationalTax);
            }
        }
        if(!otherExemptions.isEmpty()){
            otherExemptionsE.clear();
            hold(200);
            setText(otherExemptionsE, otherExemptions);
        }

        if(!withoutSave){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
        }

    }

    public void permanentDeductions(String type, String fromDate, String toDate, String notes){

        clickOn(permanentDeductionsTab);
        hold(300);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        hold(300);
        goToFrame(bodyFrame);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!type.isEmpty()){
            normalSelect(permanentDeductionTypeE, type);
        }
        if(!fromDate.isEmpty()){
            PD_FromDate.clear();
            hold(200);
            setText(PD_FromDate, fromDate);
        }
        if(!toDate.isEmpty()){
            PD_ToDate.clear();
            hold(200);
            setText(PD_ToDate, toDate);
        }
        if(!notes.isEmpty()){
            PD_Note.clear();
            hold(200);
            setText(PD_Note, notes);
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        hold(300);
        goToFrame(bodyFrame);

    }

    public void paymentMethod(String paymentMethod, String bank, String bankBranch, String accountNumber, String ibanNumber, boolean bankCommitment, boolean withoutSave){

        clickOn(insuranceTab);
        hold(1500);
        elementWaitAdvanced(By.name("paymeny_method"));
        normalSelect(paymentMethodE, paymentMethod);
        hold(300);
        if(!bank.isEmpty()){
            normalSelect(bankE, bank);
            hold(300);
        }
        if(!bankBranch.isEmpty()){
            normalSelect(bankBranchE, bankBranch);
            hold(300);
        }
        if(!accountNumber.isEmpty()){
            accountNumberE.clear();
            hold(200);
            setText(accountNumberE, accountNumber);
            hold(300);
        }
        if(!ibanNumber.isEmpty()){
            ibanNumberE.clear();
            hold(200);
            setText(ibanNumberE, ibanNumber);
            hold(300);
        }
        if(bankCommitment){
            if(!bankCommitmentCheckbox.isSelected()){
                clickOn(bankCommitmentCheckbox);
                hold(300);
            }
        }
        if(!withoutSave){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
        }
    }

    public void glAccount(String glAccount1, String glAccount2, String note, boolean withoutSave){

        clickOn(insuranceTab);
        hold(300);
        elementWaitAdvanced(By.name("insurance_flag"));
        hold(300);
        if(!glAccount1.isEmpty()){
            setText(glAccount1E, glAccount1);
            hold(200);
        }
        if(!glAccount2.isEmpty()){
            setText(glAccount2E, glAccount2);
            hold(200);
        }
        if(!note.isEmpty()){
            setText(noteE, note);
            hold(200);
        }

        if(!withoutSave){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            closeIFrame();
            hold(300);
            goToFrame(bodyFrame);
        }

    }

}
