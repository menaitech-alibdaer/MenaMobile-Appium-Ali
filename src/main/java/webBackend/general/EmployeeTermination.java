package webBackend.general;

import bases.WebBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class EmployeeTermination extends WebBase {

    @FindBy(xpath = "(//a[contains(@href, 'end_services.php')])[1]")
    WebElement employeeTerminationTab;
    @FindBy(id = "body_frame")
    WebElement frame;
    @FindBy(name = "RSIFrame")
    WebElement RSIFrame;
    @FindBy(className = "rgClose")
    WebElement closeReport;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(id = "first_date")
    WebElement endDateE;
    @FindBy(name = "Button2")
    WebElement calculateSalaryBtn;
    @FindBy(name = "Button2")
    WebElement calculateSettlementsBtn;
    @FindBy(name = "calc_social_checkbox")
    WebElement calculateSocialSecurityE;
    @FindBy(name = "calc_insurance_checkbox")
    WebElement calculateInsuranceE;
    @FindBy(name = "move_check")
    WebElement startSettlementCycle;

    @FindBy(id = "termination_type")
    WebElement terminationTypeE;
    @FindBy(id = "resignation_reasons")
    WebElement reasonsForResignationE;
    @FindBy(id = "termination_category")
    WebElement terminationCategoryE;
    @FindBy(id = "termination_reason")
    WebElement terminationReasonE;
    @FindBy(name = "termination_salary_scope")
    WebElement terminationSalaryE;
    @FindBy(name = "calc_fund_checkbox")
    WebElement calculateProvidentFundE;
    @FindBy(name = "calc_extra_checkbox")
    WebElement calculateExtraSalaryE;
    @FindBy(name = "calc_assets_deduction_amount_checkbox")
    WebElement calculateAssetDeductionAmountE;
    @FindBy(name = "calc_enddate_checkbox")
    WebElement calculateEndDayE;
    @FindBy(name = "calc_permanent_deduct_checkbox")
    WebElement calculatePermanentDeductionsE;
    @FindBy(name = "calc_other_deduct_checkbox")
    WebElement calculateOtherDeductionsE;
    @FindBy(id = "calc_vac_compens_checkbox")
    WebElement 	calculateRemainingVacationsAmountE;
    @FindBy(name = "use_stb_in_leave_compensation")
    WebElement calculateVacationCompensationBasedOnSTBSalaryE;
    @FindBy(name = "include_housing")
    WebElement calculateHousingDuesDeductionE;

    @FindBy(id = "pay_perviousSalary")
    WebElement payPreviousMonthSalaryE;

    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "MenuPostButton")
    WebElement menuPost;
    @FindBy(id = "MenuDeleteButton")
    WebElement menuDelete;
    @FindBy(id = "MenuUnpostButton")
    WebElement menuUnpost;
    @FindBy(id = "MenuShowButton")
    WebElement viewReport;
    @FindBy(id = "1")
    WebElement settlementViewTab;
    @FindBy(id = "2")
    WebElement summaryReportOptionsTab;
    @FindBy(id = "3")
    WebElement settlementItemsTab;
    @FindBy(id = "4")
    WebElement checklistItemTab;
    @FindBy(id = "5")
    WebElement otherOptionsTab;
    @FindBy(xpath = "//input[@name='reportView' and @value='1']")
    WebElement settlementView_Detailed;
    @FindBy(xpath = "//input[@name='reportView' and @value='2']")
    WebElement settlementView_Summary;
    @FindBy(name = "show_header")
    WebElement summaryReportOptions_ShowHeader;
    @FindBy(name = "show_service_period")
    WebElement summaryReportOptions_ShowServicePeriod;
    @FindBy(name = "show_IBAN")
    WebElement summaryReportOptions_ShowIBAN;
    @FindBy(name = "show_bank_commitment_summary")
    WebElement summaryReportOptions_ShowBankCommitment;
    @FindBy(name = "show_t_salary_details")
    WebElement settlementItems_ShowTerminationSalaryDetails;
    @FindBy(name = "show_previous_salary_details")
    WebElement settlementItems_ShowDetailsOfUnpaidPreviousSalaries;
    @FindBy(name = "show_monthly_income_details")
    WebElement settlementItems_ShowMonthlyIncomeDetails;
    @FindBy(name = "show_monthly_ded_details")
    WebElement settlementItems_ShowMonthlyDeductionDetails;
    @FindBy(name = "show_t_settlement_details")
    WebElement settlementItems_ShowTerminationSettlementsDetails;
    @FindBy(name = "show_extra_salary_days")
    WebElement settlementItems_ShowExtraSalaryDetails;
    @FindBy(name = "show_termination_option")
    WebElement settlementItems_ShowTheServicePeriodDetails;
    @FindBy(name = "show_bank_commitment")
    WebElement settlementItems_BankCommitment;
    @FindBy(name = "show_bank_details")
    WebElement settlementItems_BankInformation;
    @FindBy(name = "show_cost_center")
    WebElement settlementItems_ShowProject;
    @FindBy(name = "show_stb_breakdown")
    WebElement settlementItems_ShowSTBBreakdown;
    @FindBy(name = "show_stb_salary_breakdown")
    WebElement settlementItems_ShowSTBSalaryBreakdown;
    @FindBy(name = "show_resignation_reasons")
    WebElement settlementItems_ShowReasonsForResignation;
    @FindBy(name = "show_assets")
    WebElement settlementItems_ShowAssets;
    @FindBy(name = "ALL")
    WebElement checklistItem_All;
    @FindBy(name = "adm_items")
    WebElement checklistItem_Administration;
    @FindBy(name = "it_items")
    WebElement checklistItem_IT;
    @FindBy(name = "dir_man_items")
    WebElement checklistItem_DirectManager;
    @FindBy(name = "sales_items")
    WebElement checklistItem_Sales;
    @FindBy(name = "Audit_items")
    WebElement checklistItem_InternalAudit;
    @FindBy(name = "quality_items")
    WebElement checklistItem_Quality;
    @FindBy(name = "other_items")
    WebElement checklistItem_Other;
    @FindBy(name = "repeat_emp_name")
    WebElement checklistItem_RepeatEmployeeNameAndEmployeeCodeInAllSettlementPages;
    @FindBy(name = "hr_items")
    WebElement checklistItem_HR;
    @FindBy(name = "fin_items")
    WebElement checklistItem_Financial;
    @FindBy(name = "emp_items")
    WebElement checklistItem_Employee;
    @FindBy(name = "markiting_items")
    WebElement checklistItem_Marketing;
    @FindBy(name = "commercial_items")
    WebElement checklistItem_Commercial;
    @FindBy(name = "Operation_items")
    WebElement checklistItem_Operation;
    @FindBy(name = "signature_template")
    WebElement otherOptions_ShowSignatures;
    @FindBy(name = "repeate_signatures")
    WebElement otherOptions_RepeatSignatures;
    @FindBy(name = "show_national_code")
    WebElement otherOptions_ShowNationalCode;
    @FindBy(name = "show_sub_category")
    WebElement otherOptions_ShowSubCategory;
    @FindBy(name = "show_contract_type")
    WebElement otherOptions_ShowContractType;
    @FindBy(name = "hide_the_dropped_assets")
    WebElement otherOptions_HideTheDroppedAssets;
    @FindBy(name = "show_employee_site_logo")
    WebElement otherOptions_ViewReportLogoBasedOnEmployeeSite;
    @FindBy(name = "option_page_break")
    WebElement otherOptions_PageBreaks;
    @FindBy(name = "notice_period_start_date")
    WebElement otherOptions_NoticePeriodStartDate;
    @FindBy(name = "Employee_Picture")
    WebElement otherOptions_EmployeePicture;
    @FindBy(name = "save_option")
    WebElement saveBtn;
    @FindBy(name = "save")
    WebElement printSettlementBtn;
    @FindBy(name = "exit")
    WebElement exitBtn;
    @FindBy(xpath = "//input[@name='calculate_month' and @value='1']")
    WebElement previousMonthE;
    @FindBy(xpath = "//input[@name='calculate_month' and @value='2']")
    WebElement allPreviousMonthsE;
    @FindBy(xpath = "//input[@name='calculate_month' and @value='3']")
    WebElement last_previousMonthE;
    @FindBy(name = "lastmonth")
    WebElement lastMonthE;
    @FindBy(name = "calculate")
    WebElement previousCalculateBtn;
    @FindBy(name = "delete")
    WebElement previousDeleteBtn;
    @FindBy(name = "print")
    WebElement previousPrintBtn;
    @FindBy(name = "exit_calc")
    WebElement previousCloseBtn;


    @FindBy(xpath = "//table//td[text()='Name']/following::td[1]")
    WebElement report_name;
    @FindBy(xpath = "//table//td[contains(text(), 'Termination Date')]/following::td[1]")
    WebElement report_terminationDate;

    @FindBy(id = "Over_Time")
    public WebElement overtime;
    @FindBy(id = "Worth_Salary")
    public WebElement worthSalary;
    @FindBy(id = "vacations_leaves")
    WebElement absenceE;
    @FindBy(name = "Al_Amnt_1")
    WebElement fixedAllowanceE;
    @FindBy(name = "Al_Amnt_2")
    WebElement percentAllowanceE;
    @FindBy(id = "Al_Amnt_3")
    WebElement siteAllowanceE;
    @FindBy(id = "Alt_Vac")
    WebElement vacationsCompensationE;
    @FindBy(id = "Other_Income")
    WebElement monthlyIncomeE;
    @FindBy(id = "Tax_Val")
    WebElement incomeTaxE;
    @FindBy(name = "national_contribution")
    WebElement nationalContributionE;
    @FindBy(id = "Tax_Services")
    WebElement serviceTaxE;
    @FindBy(id = "saving_Amnt")
    WebElement providentFundE;
    @FindBy(name = "Rep_Deductions")
    WebElement loansInstallmentsE;
    @FindBy(id = "other_ded")
    WebElement monthlyDeductionsE;
    @FindBy(name = "hiring_date")
    WebElement hiringDateE;
    @FindBy(name = "company_social2")
    WebElement companySocialE;
    @FindBy(name = "Insurance_Amnt_comp")
    WebElement companyInsuranceE;
    @FindBy(name = "saving_Amnt_comp")
    WebElement companyPF_E;
    @FindBy(name = "endless_deduct_comp")
    WebElement permanentDeductionCompanyE;

    @FindBy(name = "salary_net_amount")
    WebElement TSC_TerminationSalary;
    @FindBy(id = "extra_salaries_amount")
    WebElement TSC_ExtraSalaries;
    @FindBy(name = "PF_Balance_emp")
    WebElement TSC_PFCurrentBalancePersonal;
    @FindBy(name = "PF_Balance_comp")
    WebElement TSC_PFCurrentBalanceCompany;
    @FindBy(name = "PF_Balance_profit")
    WebElement TSC_PFCurrentBalanceProfit;
    @FindBy(name = "STB_Amount")
    WebElement TSC_ServiceTerminationBenefit;
    @FindBy(name = "loan_interests_refund")
    WebElement TSC_LoanInterestsRefund;
    @FindBy(name = "dues_vacation_amount")
    WebElement TSC_VacationsCompensation;
    @FindBy(name = "dues_other_income")
    WebElement TSC_OtherDues;
    @FindBy(name = "indemnityArticle77")
    WebElement TSC_IndemnityBasedOnArticle77;
    @FindBy(id = "Loans_Balance")
    WebElement TSC_UnpaidLoansInstallments;
    @FindBy(name = "settlement_tax")
    WebElement TSC_SettlementAmountTax;
    @FindBy(name = "dues_furniture_refund")
    WebElement TSC_FurnitureCompensationRefund;
    @FindBy(name = "dues_other_deductions")
    WebElement TSC_OtherDeductions;
    @FindBy(name = "calculation_differences")
    WebElement TSC_NetSalaryDifferences;
    @FindBy(id = "school_aids_diff")
    WebElement TSC_SchoolingAidsDifferences;
    @FindBy(name = "STB_taxable_amount")
    WebElement TSC_STBTaxableAmount;
    @FindBy(name = "STB_exempted_amount")
    WebElement TSC_STBExemptionAmount;
    @FindBy(name = "STB_tax_amount")
    WebElement TSC_STBTax;
    @FindBy(name = "dues_housing_amount")
    WebElement TSC_HousingDuesDeduction;
    @FindBy(id = "hiring_date")
    WebElement TSC_HiringDate;
    @FindBy(name = "SP_total_days")
    WebElement TSC_WorkedServiceDays;
    @FindBy(name = "SP_suspension_days")
    WebElement TSC_ServiceSuspensionDays;
    @FindBy(name = "SP_service_period_days")
    WebElement TSC_ServicePeriod;
    @FindBy(name = "extra_salaries_days")
    WebElement TSC_ExtraSalaryDays;
    @FindBy(name = "STB_days")
    WebElement TSC_WorkedSTBDays;
    @FindBy(name = "STB_suspension_days")
    WebElement TSC_STBSuspensionDays;
    @FindBy(name = "STB_effect_vacation_days")
    WebElement TSC_STBVacationDays;
    @FindBy(name = "STB_vac_compensation_days")
    WebElement TSC_STBPaidVacationsDays;
    @FindBy(name = "STB_total_days")
    WebElement TSC_STBDays;
    @FindBy(name = "dues_vacation_amount_days")
    WebElement TSC_VacationCompensationDays;
    @FindBy(name = "reversal_STB_amount")
    WebElement TSC_STBReversalAmount;
    @FindBy(name = "dues_total_income")
    WebElement TSC_TotalDues;
    @FindBy(name = "dues_total_deductions")
    WebElement TSC_TotalDeductions;
    @FindBy(name = "dues_net")
    WebElement TSC_NetDues;
    @FindBy(name = "is_settled")
    WebElement TSC_AllEmployeesDuesWereSettledOnDate_Checkbox;
    @FindBy(name = "settled_date")
    WebElement TSC_AllEmployeesDuesWereSettledOnDate_date;
    @FindBy(xpath = "//a[contains(@href, 'end_settlements.php')]")
    WebElement terminationSettlementCalculationTab;
    @FindBy(xpath = "(//a[contains(@href, 'end_services.php')])[2]")
    WebElement terminationSalaryCalculationTab;

    @FindBy(name = "Net_Salary")
    public WebElement netSalary;
    @FindBy(name = "Worked_Days_hours")
    public WebElement daysPaid;
    @FindBy(name = "Tot_Salary")
    public WebElement totalIncome;
    @FindBy(id = "Social_Amnt")
    public WebElement socialSecurity;
    @FindBy(id = "Insurance_Amnt")
    public WebElement healthInsurance;
    @FindBy(name = "Tot_Deductions")
    public WebElement totalDeductions;
    @FindBy(id = "Other_All")
    public WebElement otherAllowanceE;
    String parentWindow;
    String parentWindow2;


    public void employeeTermination(String employeeCode, String endDate, boolean post){

        hold(500);
        goToFrame(frame);
        elementWaitAdvanced(By.name("employee_code"));
        clickOn(employeeTerminationTab);
        hold(500);
        elementWaitAdvanced(By.id("employee_code"));
        empCode.clear();
        hold(200);
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        if(!endDate.isEmpty()){
            endDateE.clear();
            hold(200);
            setText(endDateE, endDate);
        }
        hold(300);
        waitElementClickable(calculateSalaryBtn);
        clickOn(calculateSalaryBtn);
        hold(300);
        waitElementClickable(startSettlementCycle);

        if(post){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            waitElementClickable(menuPost);
            clickOn(menuPost);
            hold(300);
            alertWait();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            closeIFrame();
            hold(300);
            goToFrame(menuFrame);
            waitElementClickable(menuUnpost);
            closeIFrame();
        }

        setLog("Employee Termination - Employee Code: "+employeeCode+" - End Date: "+endDate);

    }

    public void employeeTermination(String employeeCode, String endDate, boolean calculateSocialSecurity, boolean calculateInsurance, boolean post){

        hold(500);
        goToFrame(frame);
        elementWaitAdvanced(By.name("employee_code"));
        clickOn(employeeTerminationTab);
        hold(500);
        elementWaitAdvanced(By.id("employee_code"));
        empCode.clear();
        hold(200);
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        if(!endDate.isEmpty()){
            endDateE.clear();
            hold(200);
            setText(endDateE, endDate);
        }
        hold(300);
        waitElementClickable(calculateSalaryBtn);
        if(calculateSocialSecurity){
            if(!calculateSocialSecurityE.isSelected()){
                calculateSocialSecurityE.click();
            }
        }else{
            if(calculateSocialSecurityE.isSelected()){
                calculateSocialSecurityE.click();
            }
        }
        if(calculateInsurance){
            if(!calculateInsuranceE.isSelected()){
                calculateInsuranceE.click();
            }
        }else{
            if(calculateInsuranceE.isSelected()){
                calculateInsuranceE.click();
            }
        }
        clickOn(calculateSalaryBtn);
        hold(300);
        waitElementClickable(startSettlementCycle);

        if(post){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            waitElementClickable(menuPost);
            clickOn(menuPost);
            hold(300);
            alertWait();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            closeIFrame();
            hold(300);
            goToFrame(menuFrame);
            waitElementClickable(menuUnpost);
            closeIFrame();
        }

        setLog("Employee Termination - Employee Code: "+employeeCode
                +" - End Date: "+endDate
                +" - Calculate Social Security: "+calculateSocialSecurity
                +" - Calculate Insurance: "+calculateInsurance
                +" - Post?: "+post);

    }

    public void employeeTermination(String employeeCode, String endDate, String terminationType, String reasonsForResignation, String terminationCategory,
            String terminationReason, String terminationSalary, boolean calculateSocialSecurity, boolean calculateProvidentFund, boolean calculateInsurance,
            boolean calculateExtraSalary, boolean calculateAssetDeductionAmount, boolean calculateEndDay, boolean calculatePermanentDeductions,
            boolean calculateOtherDeductions, boolean calculateRemainingVacationsAmount, boolean post){

        hold(500);
        goToFrame(frame);
        elementWaitAdvanced(By.name("employee_code"));
        clickOn(employeeTerminationTab);
        hold(500);
        elementWaitAdvanced(By.id("employee_code"));
        empCode.clear();
        hold(200);
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        if(!endDate.isEmpty()){
            endDateE.clear();
            hold(200);
            setText(endDateE, endDate);
        }
        hold(300);
        waitElementClickable(calculateSalaryBtn);
        if(!terminationType.isEmpty()){
            normalSelect(terminationTypeE, terminationType);
            hold(200);
        }
        if(!reasonsForResignation.isEmpty()){
            normalSelect(reasonsForResignationE, reasonsForResignation);
            hold(200);
        }
        if(!terminationCategory.isEmpty()){
            normalSelect(terminationCategoryE, terminationCategory);
            hold(200);
        }
        if(!terminationReason.isEmpty()){
            normalSelect(terminationReasonE, terminationReason);
            hold(200);
        }
        if(!terminationSalary.isEmpty()){
            normalSelect(terminationSalaryE, terminationSalary);
            hold(200);
        }

        if(calculateSocialSecurity){
            if(!calculateSocialSecurityE.isSelected()){
                calculateSocialSecurityE.click();
            }
        }else{
            if(calculateSocialSecurityE.isSelected()){
                calculateSocialSecurityE.click();
            }
        }

        if(calculateProvidentFund){
            if(!calculateProvidentFundE.isSelected()){
                calculateProvidentFundE.click();
            }
        }else{
            if(calculateProvidentFundE.isSelected()){
                calculateProvidentFundE.click();
            }
        }

        if(calculateInsurance){
            if(!calculateInsuranceE.isSelected()){
                calculateInsuranceE.click();
            }
        }else{
            if(calculateInsuranceE.isSelected()){
                calculateInsuranceE.click();
            }
        }

        if(calculateInsurance){
            if(!calculateInsuranceE.isSelected()){
                calculateInsuranceE.click();
            }
        }else{
            if(calculateInsuranceE.isSelected()){
                calculateInsuranceE.click();
            }
        }

        if(calculateExtraSalary){
            if(!calculateExtraSalaryE.isSelected()){
                calculateExtraSalaryE.click();
            }
        }else{
            if(calculateExtraSalaryE.isSelected()){
                calculateExtraSalaryE.click();
            }
        }

        if(calculateAssetDeductionAmount){
            if(!calculateAssetDeductionAmountE.isSelected()){
                calculateAssetDeductionAmountE.click();
            }
        }else{
            if(calculateAssetDeductionAmountE.isSelected()){
                calculateAssetDeductionAmountE.click();
            }
        }

        if(calculateEndDay){
            if(!calculateEndDayE.isSelected()){
                calculateEndDayE.click();
            }
        }else{
            if(calculateEndDayE.isSelected()){
                calculateEndDayE.click();
            }
        }

        if(calculatePermanentDeductions){
            if(!calculatePermanentDeductionsE.isSelected()){
                calculatePermanentDeductionsE.click();
            }
        }else{
            if(calculatePermanentDeductionsE.isSelected()){
                calculatePermanentDeductionsE.click();
            }
        }

        if(calculateOtherDeductions){
            if(!calculateOtherDeductionsE.isSelected()){
                calculateOtherDeductionsE.click();
            }
        }else{
            if(calculateOtherDeductionsE.isSelected()){
                calculateOtherDeductionsE.click();
            }
        }

        if(calculateRemainingVacationsAmount){
            if(!calculateRemainingVacationsAmountE.isSelected()){
                calculateRemainingVacationsAmountE.click();
            }
        }else{
            if(calculateRemainingVacationsAmountE.isSelected()){
                calculateRemainingVacationsAmountE.click();
            }
        }

        clickOn(calculateSalaryBtn);
        hold(300);
        waitElementClickable(startSettlementCycle);

        if(post){
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            waitElementClickable(menuPost);
            clickOn(menuPost);
            hold(300);
            alertWait();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            closeIFrame();
            hold(300);
            goToFrame(menuFrame);
            waitElementClickable(menuUnpost);
            closeIFrame();
        }

        setLog("Employee Termination - Employee Code: "+employeeCode
                +" - End Date: "+endDate
                +" - Termination Type: "+terminationType
                +" - Reasons For Resignation: "+reasonsForResignation
                +" - Termination Category: "+terminationCategory
                +" - Termination Reason: "+terminationReason
                +" - Termination Salary: "+terminationSalary
                +" - Calculate Social Security: "+calculateSocialSecurity
                +" - Calculate Provident Fund: "+calculateProvidentFund
                +" - Calculate Insurance: "+calculateInsurance
                +" - Calculate Extra Salary: "+calculateExtraSalary
                +" - Calculate Asset Deduction Amount: "+calculateAssetDeductionAmount
                +" - Calculate End Day: "+calculateEndDay
                +" - Calculate Permanent Deductions: "+calculatePermanentDeductions
                +" - Calculate Other Deductions: "+calculateOtherDeductions
                +" - Calculate Remaining Vacations Amount: "+calculateRemainingVacationsAmount
                +" - Post?: "+post);

    }

    public void calculateSettlements(String terminationSalary, boolean calculateEndDay, boolean calculateExtraSalary, boolean calculateRemainingVacationsAmount,
                                     boolean calculateVacationCompensationBasedOnSTBSalary, boolean calculateHousingDuesDeduction, boolean calculateAssetDeductionAmount){

        clickOn(terminationSettlementCalculationTab);
        hold(500);
        waitElementClickable(calculateSettlementsBtn);

        if(!terminationSalary.isEmpty()){
            normalSelect(terminationSalaryE, terminationSalary);
            hold(200);
        }

        if(calculateEndDay){
            if(!calculateEndDayE.isSelected()){
                calculateEndDayE.click();
            }
        }else{
            if(calculateEndDayE.isSelected()){
                calculateEndDayE.click();
            }
        }

        if(calculateExtraSalary){
            if(!calculateExtraSalaryE.isSelected()){
                calculateExtraSalaryE.click();
            }
        }else{
            if(calculateExtraSalaryE.isSelected()){
                calculateExtraSalaryE.click();
            }
        }

        if(calculateRemainingVacationsAmount){
            if(!calculateRemainingVacationsAmountE.isSelected()){
                calculateRemainingVacationsAmountE.click();
            }
        }else{
            if(calculateRemainingVacationsAmountE.isSelected()){
                calculateRemainingVacationsAmountE.click();
            }
        }

        if(calculateVacationCompensationBasedOnSTBSalary){
            if(!calculateVacationCompensationBasedOnSTBSalaryE.isSelected()){
                calculateVacationCompensationBasedOnSTBSalaryE.click();
            }
        }else{
            if(calculateVacationCompensationBasedOnSTBSalaryE.isSelected()){
                calculateVacationCompensationBasedOnSTBSalaryE.click();
            }
        }

        if(calculateHousingDuesDeduction){
            if(!calculateHousingDuesDeductionE.isSelected()){
                calculateHousingDuesDeductionE.click();
            }
        }else{
            if(calculateHousingDuesDeductionE.isSelected()){
                calculateHousingDuesDeductionE.click();
            }
        }

        if(calculateAssetDeductionAmount){
            if(!calculateAssetDeductionAmountE.isSelected()){
                calculateAssetDeductionAmountE.click();
            }
        }else{
            if(calculateAssetDeductionAmountE.isSelected()){
                calculateAssetDeductionAmountE.click();
            }
        }

        clickOn(calculateSettlementsBtn);
        hold(800);

    }

    public void deleteCalculate(){

        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        waitElementClickable(menuPost);
        clickOn(menuDelete);
        hold(300);
        alertWait();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        closeIFrame();
        hold(300);

        setLog("Employee Termination - Delete Calculate");


    }

    public void reCalculate(){

        waitElementClickable(calculateSalaryBtn);
        clickOn(calculateSalaryBtn);
        hold(800);
        waitElementClickable(calculateSalaryBtn);

        setLog("Employee Termination - reCalculate");

    }

    public void save(){

        closeIFrame();
        goToFrame(menuFrame);
        elementWait(menuSave);
        waitElementClickable(menuSave);
        clickOn(menuSave);
        hold(700);
        closeIFrame();
        goToFrame(frame);

        setLog("Click on: Save");

    }

    public void viewReport(){
        closeIFrame();
        goToFrame(menuFrame);
        waitElementClickable(viewReport);
        clickOn(viewReport);
        hold(800);
        closeIFrame();
        parentWindow = driver.getWindowHandle();
        goToWindow();
        hold(500);

        setLog("View Report");
    }

    public void settlementView(String view){
        clickOn(settlementViewTab);
        hold(300);
        if(view.equalsIgnoreCase("Detailed")){
            clickOn(settlementView_Detailed);
        }else if(view.equalsIgnoreCase("Summary")){
            clickOn(settlementView_Summary);
        }

        setLog("Settlement View: "+view);
    }

    public void summaryReportOptions(boolean showHeader, boolean showServicePeriod, boolean showBankCommitment){
        clickOn(summaryReportOptionsTab);
        hold(300);

        if(showHeader){
            if(!summaryReportOptions_ShowHeader.isSelected()){
                clickOn(summaryReportOptions_ShowHeader);
            }
        }else{
            if(summaryReportOptions_ShowHeader.isSelected()){
                clickOn(summaryReportOptions_ShowHeader);
            }
        }

        if(showServicePeriod){
            if(!summaryReportOptions_ShowServicePeriod.isSelected()){
                clickOn(summaryReportOptions_ShowServicePeriod);
            }
        }else{
            if(summaryReportOptions_ShowServicePeriod.isSelected()){
                clickOn(summaryReportOptions_ShowServicePeriod);
            }
        }

        if(showBankCommitment){
            if(!summaryReportOptions_ShowBankCommitment.isSelected()){
                clickOn(summaryReportOptions_ShowBankCommitment);
            }
        }else{
            if(summaryReportOptions_ShowBankCommitment.isSelected()){
                clickOn(summaryReportOptions_ShowBankCommitment);
            }
        }

        setLog("+ Summary Report Options --> "
        + " - Show Header: "+showHeader
        + " - Show Service Period: "+showServicePeriod
        + " - Show Bank Commitment: "+showBankCommitment
        );

    }

    public void settlementItems(boolean showTerminationSalaryDetails, boolean showDetailsOfUnpaidPreviousSalaries, boolean showMonthlyIncomeDetails, boolean showMonthlyDeductionDetails,
                                boolean showTerminationSettlementsDetails, boolean showExtraSalaryDetails, boolean showTheServicePeriodDetails, boolean bankCommitment, boolean bankInformation,
                                boolean showProject, boolean showSTBBreakdown, boolean showSTBSalaryBreakdown, boolean showReasonsForResignation, boolean showAssets){

        clickOn(settlementItemsTab);
        hold(300);

        if(showTerminationSalaryDetails){
            if(!settlementItems_ShowTerminationSalaryDetails.isSelected()){
                clickOn(settlementItems_ShowTerminationSalaryDetails);
            }
        }else{
            if(settlementItems_ShowTerminationSalaryDetails.isSelected()){
                clickOn(settlementItems_ShowTerminationSalaryDetails);
            }
        }
        if(showDetailsOfUnpaidPreviousSalaries){
            if(!settlementItems_ShowDetailsOfUnpaidPreviousSalaries.isSelected()){
                clickOn(settlementItems_ShowDetailsOfUnpaidPreviousSalaries);
            }
        }else{
            if(settlementItems_ShowDetailsOfUnpaidPreviousSalaries.isSelected()){
                clickOn(settlementItems_ShowDetailsOfUnpaidPreviousSalaries);
            }
        }
        if(showMonthlyIncomeDetails){
            if(!settlementItems_ShowMonthlyIncomeDetails.isSelected()){
                clickOn(settlementItems_ShowMonthlyIncomeDetails);
            }
        }else{
            if(settlementItems_ShowMonthlyIncomeDetails.isSelected()){
                clickOn(settlementItems_ShowMonthlyIncomeDetails);
            }
        }
        if(showMonthlyDeductionDetails){
            if(!settlementItems_ShowMonthlyDeductionDetails.isSelected()){
                clickOn(settlementItems_ShowMonthlyDeductionDetails);
            }
        }else{
            if(settlementItems_ShowMonthlyDeductionDetails.isSelected()){
                clickOn(settlementItems_ShowMonthlyDeductionDetails);
            }
        }
        if(showTerminationSettlementsDetails){
            if(!settlementItems_ShowTerminationSettlementsDetails.isSelected()){
                clickOn(settlementItems_ShowTerminationSettlementsDetails);
            }
        }else{
            if(settlementItems_ShowTerminationSettlementsDetails.isSelected()){
                clickOn(settlementItems_ShowTerminationSettlementsDetails);
            }
        }
        if(showExtraSalaryDetails){
            if(!settlementItems_ShowExtraSalaryDetails.isSelected()){
                clickOn(settlementItems_ShowExtraSalaryDetails);
            }
        }else{
            if(settlementItems_ShowExtraSalaryDetails.isSelected()){
                clickOn(settlementItems_ShowExtraSalaryDetails);
            }
        }
        if(showTheServicePeriodDetails){
            if(!settlementItems_ShowTheServicePeriodDetails.isSelected()){
                clickOn(settlementItems_ShowTheServicePeriodDetails);
            }
        }else{
            if(settlementItems_ShowTheServicePeriodDetails.isSelected()){
                clickOn(settlementItems_ShowTheServicePeriodDetails);
            }
        }
        if(bankCommitment){
            if(!settlementItems_BankCommitment.isSelected()){
                clickOn(settlementItems_BankCommitment);
            }
        }else{
            if(settlementItems_BankCommitment.isSelected()){
                clickOn(settlementItems_BankCommitment);
            }
        }
        if(bankInformation){
            if(!settlementItems_BankInformation.isSelected()){
                clickOn(settlementItems_BankInformation);
            }
        }else{
            if(settlementItems_BankInformation.isSelected()){
                clickOn(settlementItems_BankInformation);
            }
        }
        if(showProject){
            if(!settlementItems_ShowProject.isSelected()){
                clickOn(settlementItems_ShowProject);
            }
        }else{
            if(settlementItems_ShowProject.isSelected()){
                clickOn(settlementItems_ShowProject);
            }
        }
        if(showSTBBreakdown){
            if(!settlementItems_ShowSTBBreakdown.isSelected()){
                clickOn(settlementItems_ShowSTBBreakdown);
            }
        }else{
            if(settlementItems_ShowSTBBreakdown.isSelected()){
                clickOn(settlementItems_ShowSTBBreakdown);
            }
        }
        if(showSTBSalaryBreakdown){
            if(!settlementItems_ShowSTBSalaryBreakdown.isSelected()){
                clickOn(settlementItems_ShowSTBSalaryBreakdown);
            }
        }else{
            if(settlementItems_ShowSTBSalaryBreakdown.isSelected()){
                clickOn(settlementItems_ShowSTBSalaryBreakdown);
            }
        }
        if(showReasonsForResignation){
            if(!settlementItems_ShowReasonsForResignation.isSelected()){
                clickOn(settlementItems_ShowReasonsForResignation);
            }
        }else{
            if(settlementItems_ShowReasonsForResignation.isSelected()){
                clickOn(settlementItems_ShowReasonsForResignation);
            }
        }
        if(showAssets){
            if(!settlementItems_ShowAssets.isSelected()){
                clickOn(settlementItems_ShowAssets);
            }
        }else{
            if(settlementItems_ShowAssets.isSelected()){
                clickOn(settlementItems_ShowAssets);
            }
        }

        setLog("+ Settlement Items --> "
                + " - Show Termination Salary Details: "+showTerminationSalaryDetails
                + " - Show Details Of Unpaid Previous Salaries: "+showDetailsOfUnpaidPreviousSalaries
                + " - Show Monthly Income Details: "+showMonthlyIncomeDetails
                + " - Show Monthly Deduction Details: "+showMonthlyDeductionDetails
                + " - Show Termination Settlements Details: "+ showTerminationSettlementsDetails
                + " - Show Extra Salary Details: "+showExtraSalaryDetails
                + " - Show The Service Period Details: "+showTheServicePeriodDetails
                + " - Bank Commitment: "+bankCommitment
                + " - Bank Information: "+bankInformation
                + " - Show Project: "+showProject
                + " - Show STB Breakdown: "+showSTBBreakdown
                + " - Show STB Salary Breakdown: "+showSTBSalaryBreakdown
                + " - Show Reasons For Resignation: "+showReasonsForResignation
                + " - Show Assets: "+showAssets
        );

    }

    public void checklistItem(boolean all, boolean administration, boolean HR, boolean IT, boolean financial, boolean directManager, boolean employee, boolean sales,
                              boolean marketing, boolean internalAudit, boolean commercial, boolean quality, boolean operation, boolean other, boolean repeatEmployeeNameAndEmployeeCodeInAllSettlementPages){

        clickOn(checklistItemTab);
        hold(300);

        if(all){
            if(!checklistItem_All.isSelected()){
                clickOn(checklistItem_All);
            }
        }else{
            if(checklistItem_All.isSelected()){
                clickOn(checklistItem_All);
            }
            hold(300);

            if(administration){
                if(!checklistItem_Administration.isSelected()){
                    clickOn(checklistItem_Administration);
                }
            }else{
                if(checklistItem_Administration.isSelected()){
                    clickOn(checklistItem_Administration);
                }
            }
            if(HR){
                if(!checklistItem_HR.isSelected()){
                    clickOn(checklistItem_HR);
                }
            }else{
                if(checklistItem_HR.isSelected()){
                    clickOn(checklistItem_HR);
                }
            }
            if(IT){
                if(!checklistItem_IT.isSelected()){
                    clickOn(checklistItem_IT);
                }
            }else{
                if(checklistItem_IT.isSelected()){
                    clickOn(checklistItem_IT);
                }
            }
            if(financial){
                if(!checklistItem_Financial.isSelected()){
                    clickOn(checklistItem_Financial);
                }
            }else{
                if(checklistItem_Financial.isSelected()){
                    clickOn(checklistItem_Financial);
                }
            }
            if(directManager){
                if(!checklistItem_DirectManager.isSelected()){
                    clickOn(checklistItem_DirectManager);
                }
            }else{
                if(checklistItem_DirectManager.isSelected()){
                    clickOn(checklistItem_DirectManager);
                }
            }
            if(employee){
                if(!checklistItem_Employee.isSelected()){
                    clickOn(checklistItem_Employee);
                }
            }else{
                if(checklistItem_Employee.isSelected()){
                    clickOn(checklistItem_Employee);
                }
            }
            if(sales){
                if(!checklistItem_Sales.isSelected()){
                    clickOn(checklistItem_Sales);
                }
            }else{
                if(checklistItem_Sales.isSelected()){
                    clickOn(checklistItem_Sales);
                }
            }
            if(marketing){
                if(!checklistItem_Marketing.isSelected()){
                    clickOn(checklistItem_Marketing);
                }
            }else{
                if(checklistItem_Marketing.isSelected()){
                    clickOn(checklistItem_Marketing);
                }
            }
            if(internalAudit){
                if(!checklistItem_InternalAudit.isSelected()){
                    clickOn(checklistItem_InternalAudit);
                }
            }else{
                if(checklistItem_InternalAudit.isSelected()){
                    clickOn(checklistItem_InternalAudit);
                }
            }
            if(commercial){
                if(!checklistItem_Commercial.isSelected()){
                    clickOn(checklistItem_Commercial);
                }
            }else{
                if(checklistItem_Commercial.isSelected()){
                    clickOn(checklistItem_Commercial);
                }
            }
            if(quality){
                if(!checklistItem_Quality.isSelected()){
                    clickOn(checklistItem_Quality);
                }
            }else{
                if(checklistItem_Quality.isSelected()){
                    clickOn(checklistItem_Quality);
                }
            }
            if(operation){
                if(!checklistItem_Operation.isSelected()){
                    clickOn(checklistItem_Operation);
                }
            }else{
                if(checklistItem_Operation.isSelected()){
                    clickOn(checklistItem_Operation);
                }
            }
            if(other){
                if(!checklistItem_Other.isSelected()){
                    clickOn(checklistItem_Other);
                }
            }else{
                if(checklistItem_Other.isSelected()){
                    clickOn(checklistItem_Other);
                }
            }

            if(checklistItem_RepeatEmployeeNameAndEmployeeCodeInAllSettlementPages.isEnabled()){
                if(repeatEmployeeNameAndEmployeeCodeInAllSettlementPages){
                    if(!checklistItem_RepeatEmployeeNameAndEmployeeCodeInAllSettlementPages.isSelected()){
                        clickOn(checklistItem_RepeatEmployeeNameAndEmployeeCodeInAllSettlementPages);
                    }
                }else{
                    if(checklistItem_RepeatEmployeeNameAndEmployeeCodeInAllSettlementPages.isSelected()){
                        clickOn(checklistItem_RepeatEmployeeNameAndEmployeeCodeInAllSettlementPages);
                    }
                }
            }

        }

        setLog("+ Checklist Item --> "
                + " - All: "+all
                + " - Administration: "+administration
                + " - HR: "+HR
                + " - IT: "+IT
                + " - Financial: "+ financial
                + " - Direct Manager: "+directManager
                + " - Employee: "+employee
                + " - Sales: "+sales
                + " - Marketing: "+marketing
                + " - Internal Audit: "+internalAudit
                + " - Commercial: "+commercial
                + " - Quality: "+quality
                + " - Operation: "+operation
                + " - Other: "+other
                + " - Repeat Employee Name & Employee Code in All Settlement Pages: "+repeatEmployeeNameAndEmployeeCodeInAllSettlementPages
        );

    }

    public void otherOptions(String showSignatures, boolean repeatSignatures, boolean showNationalCode, boolean showSubCategory, boolean showContractType, boolean hideTheDroppedAssets,
                             boolean viewReportLogoBasedOnEmployeeSite, boolean pageBreaks, boolean noticePeriodStartDate, boolean employeePicture){

        clickOn(otherOptionsTab);
        hold(300);

        if(!showSignatures.isEmpty()){
            normalSelect(otherOptions_ShowSignatures, showSignatures);
            hold(200);
        }
        if(repeatSignatures){
            if(!otherOptions_RepeatSignatures.isSelected()){
                clickOn(otherOptions_RepeatSignatures);
            }
        }else{
            if(otherOptions_RepeatSignatures.isSelected()){
                clickOn(otherOptions_RepeatSignatures);
            }
        }
        if(showNationalCode){
            if(!otherOptions_ShowNationalCode.isSelected()){
                clickOn(otherOptions_ShowNationalCode);
            }
        }else{
            if(otherOptions_ShowNationalCode.isSelected()){
                clickOn(otherOptions_ShowNationalCode);
            }
        }
        if(showSubCategory){
            if(!otherOptions_ShowSubCategory.isSelected()){
                clickOn(otherOptions_ShowSubCategory);
            }
        }else{
            if(otherOptions_ShowSubCategory.isSelected()){
                clickOn(otherOptions_ShowSubCategory);
            }
        }
        if(showContractType){
            if(!otherOptions_ShowContractType.isSelected()){
                clickOn(otherOptions_ShowContractType);
            }
        }else{
            if(otherOptions_ShowContractType.isSelected()){
                clickOn(otherOptions_ShowContractType);
            }
        }
        if(hideTheDroppedAssets){
            if(!otherOptions_HideTheDroppedAssets.isSelected()){
                clickOn(otherOptions_HideTheDroppedAssets);
            }
        }else{
            if(otherOptions_HideTheDroppedAssets.isSelected()){
                clickOn(otherOptions_HideTheDroppedAssets);
            }
        }
        if(viewReportLogoBasedOnEmployeeSite){
            if(!otherOptions_ViewReportLogoBasedOnEmployeeSite.isSelected()){
                clickOn(otherOptions_ViewReportLogoBasedOnEmployeeSite);
            }
        }else{
            if(otherOptions_ViewReportLogoBasedOnEmployeeSite.isSelected()){
                clickOn(otherOptions_ViewReportLogoBasedOnEmployeeSite);
            }
        }
        if(pageBreaks){
            if(!otherOptions_PageBreaks.isSelected()){
                clickOn(otherOptions_PageBreaks);
            }
        }else{
            if(otherOptions_PageBreaks.isSelected()){
                clickOn(otherOptions_PageBreaks);
            }
        }
        if(noticePeriodStartDate){
            if(!otherOptions_NoticePeriodStartDate.isSelected()){
                clickOn(otherOptions_NoticePeriodStartDate);
            }
        }else{
            if(otherOptions_NoticePeriodStartDate.isSelected()){
                clickOn(otherOptions_NoticePeriodStartDate);
            }
        }
        if(employeePicture){
            if(!otherOptions_EmployeePicture.isSelected()){
                clickOn(otherOptions_EmployeePicture);
            }
        }else{
            if(otherOptions_EmployeePicture.isSelected()){
                clickOn(otherOptions_EmployeePicture);
            }
        }

        setLog("+ Other Options --> "
                + " - Show Signatures: "+showSignatures
                + " - Repeat Signatures: "+repeatSignatures
                + " - Show National Code: "+showNationalCode
                + " - Show Sub Category: "+showSubCategory
                + " - Show Contract Type: "+ showContractType
                + " - Hide The Dropped Assets: "+hideTheDroppedAssets
                + " - View Report Logo Based on Employee Site: "+viewReportLogoBasedOnEmployeeSite
                + " - Page Breaks: "+pageBreaks
                + " - Notice Period Start Date: "+noticePeriodStartDate
                + " - Employee Picture: "+employeePicture
        );

    }

    public void saveReport(){
        clickOn(saveBtn);
        hold(500);

        setLog("Save View Report");
    }

    public void exitReport(){
        clickOn(exitBtn);
        hold(500);
        backToParentWindow(parentWindow);
        goToFrame(frame);

        setLog("Exit view report");
    }

    public void printSettlement(){
        clickOn(printSettlementBtn);
        hold(1000);
        goToWindow();
        goToFrame(RSIFrame);
        hold(200);

        setLog("Open Print Settlement");
    }

    public void closePrintReport(){

        closeIFrame();
        clickOn(closeReport);
        hold(200);
        backToParentWindow(parentWindow);
        goToFrame(frame);

        setLog("Close Print Settlement");

    }

    public void payPreviousMonthSalary(boolean previousMonth, boolean allPreviousMonths, boolean last, String month){

        clickOn(payPreviousMonthSalaryE);
        hold(500);
        closeIFrame();
        parentWindow = driver.getWindowHandle();
        goToWindow();
        hold(500);

        setLog("Click on --> Pay Previous Month Salary");

        if(previousMonth){
            clickOn(previousMonthE);
            waitElementClickable(previousCalculateBtn);
            clickOn(previousCalculateBtn);

            setLog("Select --> Previous Month");

        }else if(allPreviousMonths){

            clickOn(allPreviousMonthsE);
            waitElementClickable(previousCalculateBtn);
            clickOn(previousCalculateBtn);

            setLog("Select --> All Previous Months");

        }else if(last){
            clickOn(last_previousMonthE);
            hold(500);
            waitElementClickable(lastMonthE);
            normalSelect(lastMonthE, month);
            hold(500);
            waitElementClickable(previousCalculateBtn);
            clickOn(previousCalculateBtn);

            setLog("Select --> last: "+month+" Month");

        }

        maximizeWindow();
        hold(1000);
        waitElementClickable(previousDeleteBtn);
        //resizeWindow(1300, 630);

    }

    public void openPrintPreviousSalariesDetails(){
        waitElementClickable(previousPrintBtn);
        clickOn(previousPrintBtn);
        hold(700);
        parentWindow2 = driver.getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(RSIFrame);
        hold(200);

        setLog("Open Print Previous Salaries Details");

    }

    public void closePrint(){
        closeIFrame();
        clickOn(closeReport);
        hold(200);
        backToParentWindow(parentWindow2);

        setLog("Close Previous Salaries Details (Print Sheet)");
    }

    public void closePayPreviousMonthSalary(){
        closeIFrame();
        clickOn(previousCloseBtn);
        hold(200);
        backToParentWindow(parentWindow);

        setLog("Close Pay Previous Month Salary");
    }

    ////////// Termination Salary Calculation ////////////

    public String absence(){
        return absenceE.getAttribute("value").trim();
    }
    public String fixedAllowance(){
        return fixedAllowanceE.getAttribute("value").trim();
    }
    public String percentAllowance(){
        return percentAllowanceE.getAttribute("value").trim();
    }
    public String siteAllowance(){
        return siteAllowanceE.getAttribute("value").trim();
    }
    public String overtime(){
        return overtime.getAttribute("value").trim();
    }
    public String vacationsCompensation(){
        return vacationsCompensationE.getAttribute("value").trim();
    }
    public String monthlyIncome(){
        return monthlyIncomeE.getAttribute("value").trim();
    }
    public String incomeTax(){
        return incomeTaxE.getAttribute("value").trim();
    }
    public String nationalContribution(){
        return nationalContributionE.getAttribute("value").trim();
    }
    public String serviceTax(){
        return serviceTaxE.getAttribute("value").trim();
    }
    public String providentFund(){
        return providentFundE.getAttribute("value").trim();
    }
    public String loansInstallments(){
        return loansInstallmentsE.getAttribute("value").trim();
    }
    public String monthlyDeductions(){
        return monthlyDeductionsE.getAttribute("value").trim();
    }
    public String hiringDate(){
        return hiringDateE.getAttribute("value").trim();
    }
    public String companySocial(){
        return companySocialE.getAttribute("value").trim();
    }
    public String companyInsurance(){
        return companyInsuranceE.getAttribute("value").trim();
    }
    public String companyPF(){
        return companyPF_E.getAttribute("value").trim();
    }
    public String permanentDeductionCompany(){
        return permanentDeductionCompanyE.getAttribute("value").trim();
    }
    public String otherAllowances(){
        return otherAllowanceE.getAttribute("value").trim();
    }
    public String netSalary(){
        return netSalary.getAttribute("value").trim();
    }
    public String totalIncome(){
        return totalIncome.getAttribute("value").trim();
    }
    public String daysPaid(){
        return daysPaid.getAttribute("value").trim();
    }
    public String worthSalary(){
        return worthSalary.getAttribute("value").trim();
    }
    public String socialSecurity(){
        return socialSecurity.getAttribute("value").trim();
    }
    public String healthInsurance(){
        return healthInsurance.getAttribute("value").trim();
    }
    public String totalDeductions(){
        return totalDeductions.getAttribute("value").trim();
    }

    public void goToTerminationSettlementCalculation(){
        clickOn(terminationSettlementCalculationTab);
        hold(500);
    }
    public void goToTerminationSalaryCalculation(){
        clickOn(terminationSalaryCalculationTab);
        hold(500);
    }

    /////////// Termination Settlement Calculation ///////////

    public String TSC_Dues_TerminationSalary(){
        return TSC_TerminationSalary.getAttribute("value").trim();
    }
    public String TSC_Dues_ExtraSalaries(){
        return TSC_ExtraSalaries.getAttribute("value").trim();
    }
    public String TSC_Dues_PFCurrentBalancePersonal(){
        return TSC_PFCurrentBalancePersonal.getAttribute("value").trim();
    }
    public String TSC_Dues_PFCurrentBalanceCompany(){
        return TSC_PFCurrentBalanceCompany.getAttribute("value").trim();
    }
    public String TSC_Dues_PFCurrentBalanceProfit(){
        return TSC_PFCurrentBalanceProfit.getAttribute("value").trim();
    }
    public String TSC_Dues_ServiceTerminationBenefit(){
        return TSC_ServiceTerminationBenefit.getAttribute("value").trim();
    }
    public String TSC_Dues_LoanInterestsRefund(){
        return TSC_LoanInterestsRefund.getAttribute("value").trim();
    }
    public String TSC_Dues_VacationsCompensation(){
        return TSC_VacationsCompensation.getAttribute("value").trim();
    }
    public String TSC_Dues_OtherDues(){
        return TSC_OtherDues.getAttribute("value").trim();
    }
    public String TSC_Dues_IndemnityBasedOnArticle77(){
        return TSC_IndemnityBasedOnArticle77.getAttribute("value").trim();
    }
    public String TSC_Dues_TotalDues(){
        return TSC_TotalDues.getAttribute("value").trim();
    }

    public String TSC_Deductions_UnpaidLoansInstallments(){
        return TSC_UnpaidLoansInstallments.getAttribute("value").trim();
    }
    public String TSC_Deductions_SettlementAmountTax(){
        return TSC_SettlementAmountTax.getAttribute("value").trim();
    }
    public String TSC_Deductions_FurnitureCompensationRefund(){
        return TSC_FurnitureCompensationRefund.getAttribute("value").trim();
    }
    public String TSC_Deductions_OtherDeductions(){
        return TSC_OtherDeductions.getAttribute("value").trim();
    }
    public String TSC_Deductions_NetSalaryDifferences(){
        return TSC_NetSalaryDifferences.getAttribute("value").trim();
    }
    public String TSC_Deductions_SchoolingAidsDifferences(){
        return TSC_SchoolingAidsDifferences.getAttribute("value").trim();
    }
    public String TSC_Deductions_STBTaxableAmount(){
        return TSC_STBTaxableAmount.getAttribute("value").trim();
    }
    public String TSC_Deductions_STBExemptionAmount(){
        return TSC_STBExemptionAmount.getAttribute("value").trim();
    }
    public String TSC_Deductions_STBTax(){
        return TSC_STBTax.getAttribute("value").trim();
    }
    public String TSC_Deductions_HousingDuesDeduction(){
        return TSC_HousingDuesDeduction.getAttribute("value").trim();
    }
    public String TSC_Deductions_TotalDeductions(){
        return TSC_TotalDeductions.getAttribute("value").trim();
    }

    public String TSC_HiringDate(){
        return TSC_HiringDate.getAttribute("value").trim();
    }
    public String TSC_WorkedServiceDays(){
        return TSC_WorkedServiceDays.getAttribute("value").trim();
    }
    public String TSC_ServiceSuspensionDays(){
        return TSC_ServiceSuspensionDays.getAttribute("value").trim();
    }
    public String TSC_ServicePeriod(){
        return TSC_ServicePeriod.getAttribute("value").trim();
    }
    public String TSC_ExtraSalaryDays(){
        return TSC_ExtraSalaryDays.getAttribute("value").trim();
    }
    public String TSC_WorkedSTBDays(){
        return TSC_WorkedSTBDays.getAttribute("value").trim();
    }
    public String TSC_STBSuspensionDays(){
        return TSC_STBSuspensionDays.getAttribute("value").trim();
    }
    public String TSC_STBVacationDays(){
        return TSC_STBVacationDays.getAttribute("value").trim();
    }
    public String TSC_STBPaidVacationsDays(){
        return TSC_STBPaidVacationsDays.getAttribute("value").trim();
    }
    public String TSC_STBDays(){
        return TSC_STBDays.getAttribute("value").trim();
    }
    public String TSC_VacationCompensationDays(){
        return TSC_VacationCompensationDays.getAttribute("value").trim();
    }
    public String TSC_STBReversalAmount(){
        return TSC_STBReversalAmount.getAttribute("value").trim();
    }
    public String TSC_NetDues(){
        return TSC_NetDues.getAttribute("value").trim();
    }

    public void allEmployeesDuesWereSettledOnDate(boolean checkbox, String date){
        if(checkbox){
            if(!TSC_AllEmployeesDuesWereSettledOnDate_Checkbox.isSelected()){
                clickOn(TSC_AllEmployeesDuesWereSettledOnDate_Checkbox);
            }
            hold(200);
            setText(TSC_AllEmployeesDuesWereSettledOnDate_date, date);
        }else{
            if(TSC_AllEmployeesDuesWereSettledOnDate_Checkbox.isSelected()){
                clickOn(TSC_AllEmployeesDuesWereSettledOnDate_Checkbox);
            }
        }
    }


    ///////////// Detailed Report Functions ///////////

    public String detailed_employeeCode(){
        String str = driver.findElement(By.xpath("(//td[contains(text(), 'Name')])[1]/following-sibling::td[1]")).getText().trim();
        String getCode = StringUtils.substringBefore(str, "/");
        return getCode.trim();
    }
    public String detailed_hiringDate(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Hiring Date')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_nationality(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Nationality')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_directManagerName(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Direct Manager Name')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_departments(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Departments')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_nationalCode(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'National Code')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_division(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Division')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_position(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Position')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_terminationCategory(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Termination Category')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_reasonsForResignation(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Reasons For Resignation')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_date(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Date') and @width='20%'])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_noticePeriodStartDate(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Notice Period Start Date')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_unit(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Unit')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_terminationDate(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Termination Date')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_sections(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Sections')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_sponsorship_SubCategory(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Sponsorship(Sub Category)')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_site(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Site')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_project(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Project')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_terminationReason(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Termination Reason')])[1]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_contractType(){
        return driver.findElement(By.xpath("(//td[contains(text(), 'Contract Type')])[1]/following-sibling::td[1]")).getText().trim();
    }


    public String detailed_salaryDetails(String item){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Salary Details')]/../../..//strong[contains(text(), '"+item+"')]/following::td[1]")).getText().trim();
    }

    public String detailed_salaryDetails_types(String item){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Salary Details')]/../../..//td[contains(text(), '"+item+"')]/following::td[1]")).getText().trim();
    }

    public String detailed_bankInformation(String item){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Bank Information')]/../../..//td[contains(text(), '"+item+"')]/following-sibling::td[1]")).getText().trim();
    }

    public String detailed_salarySlip(String item){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Salary Slip')]/../../..//td[contains(text(), '"+item+"')]/following-sibling::td[1]")).getText().trim();
    }

    public String detailed_salarySlip_DaysPaid(){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Salary Slip')]/../../..//strong[contains(text(), 'Days Paid')]/following::td[1]")).getText().trim();
    }

    public String detailed_salarySlip_TotalIncome(){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Salary Slip')]/../../..//strong[contains(text(), 'Total Income')]/following::td[1]")).getText().trim();
    }

    public String detailed_salarySlip_TotalDeductions(){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Salary Slip')]/../../..//strong[contains(text(), 'Total Deductions')]/following::td[1]")).getText().trim();
    }

    public String detailed_salarySlip_NetSalary(){
        String net = driver.findElement(By.xpath("//td//strong[contains(text(), 'Net Salary')]")).getText();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String detailed_salarySlip_Absence_Days(){
        String net = driver.findElement(By.xpath("//td//strong[contains(text(), 'Salary Slip')]/../../..//td[contains(text(), 'Absence')]")).getText();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String detailed_salarySlip_VacationsCompensation_Days(){
        String net = driver.findElement(By.xpath("//td//strong[contains(text(), 'Salary Slip')]/../../..//td[contains(text(), 'Vacations Compensation')]")).getText();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String detailed_otherDues(String item){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Other Dues')]/../../..//td[contains(text(), '"+item+"')]/following-sibling::td[1]")).getText().trim();
    }

    public String detailed_otherDues_TotalDues(){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Other Dues')]/../../..//strong[contains(text(), 'Total Dues')]/following::td[1]")).getText().trim();
    }

    public String detailed_otherDues_TotalDeductions(){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Other Dues')]/../../..//strong[contains(text(), 'Total Deductions')]/following::td[1]")).getText().trim();
    }

    public String detailed_otherDues_IndemnityBasedOnArticle77(){
        return driver.findElement(By.xpath("(//td//strong[contains(text(), 'Other Dues')]/../../..//td[contains(text(), 'Indemnity Based On Article 77')]/following::td[1])[1]")).getText().trim();
    }

    public String detailed_otherDues_IndemnityBasedOnArticle77_deduction(){
        return driver.findElement(By.xpath("(//td//strong[contains(text(), 'Other Dues')]/../../..//td[contains(text(), 'Indemnity Based On Article 77')]/following::td[1])[2]")).getText().trim();
    }

    public String detailed_otherDues_NetOtherDues(){
        String net = driver.findElement(By.xpath("//td//strong[contains(text(), 'Net Other Dues')]")).getText();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String detailed_Total(){
        return driver.findElement(By.xpath("(//td//strong[contains(text(), 'Other Dues')]/../../..//td//strong[contains(text(), 'Total')])[last()]")).getText();
//        String net = driver.findElement(By.xpath("(//td//strong[contains(text(), 'Other Dues')]/../../..//td//strong[contains(text(), 'Total')])[last()]")).getText();
//        return net.replaceAll("[^0-9\\.]", "");
    }


    public String detailed_MonthlyIncome(String item){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Monthly Income')]/../../..//td[contains(text(), '"+item+"')]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_MonthlyIncome_Total(){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Monthly Income')]/../../..//td//strong[text()='Total']/following::td[1]")).getText().trim();
    }

    public String detailed_MonthlyDeductions(String item){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Monthly Deductions')]/../../..//td[contains(text(), '"+item+"')]/following-sibling::td[1]")).getText().trim();
    }
    public String detailed_MonthlyDeductions_Total(){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Monthly Deductions')]/../../..//td//strong[text()='Total']/following::td[1]")).getText().trim();
    }


    public String detailed_extraSalaries(String item){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Extra Salaries - Details')]/../../..//td[contains(text(), '"+item+"')]/following::td[1]")).getText().trim();
    }

    public String detailed_extraSalaries_DaysPaid(){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Extra Salaries - Details')]/../../..//strong[contains(text(), 'Days Paid')]/following::td[1]")).getText().trim();
    }

    public String detailed_extraSalaries_Month(){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Extra Salaries - Details')]/../../..//strong[contains(text(), 'Month')]/following::td[1]")).getText().trim();
    }

    public String detailed_servicePeriodDetails(String item){
        return driver.findElement(By.xpath("//td//strong[contains(text(), 'Service Period Details')]/../../..//td[contains(text(), '"+item+"')]/following::td[1]")).getText().trim();
    }

    public String detailed_servicePeriodDetails_Total(){
        return driver.findElement(By.xpath("(//td//strong[contains(text(), 'Service Period Details')]/../../..//strong[contains(text(), 'Service Period')])[2]/following::td[1]")).getText().trim();
    }

    /////////////  Summary Report Functions ///////////

    public String summary_employeeInformation(String item){
        return driver.findElement(By.xpath("//td[@class='leftToRight' and text()='"+item+"']/following-sibling::td[2]")).getText().trim();
    }

    public String summary_employeeInformation_ar(String item){
        if(item.equalsIgnoreCase("تاريخ الإنهاء") || item.equalsIgnoreCase("الرقم الوطني")){
            return driver.findElement(By.xpath("//td[@class='RightToleft' and contains(text(), '"+item+"')]/following-sibling::td[2]")).getText().trim();
        }else{
            return driver.findElement(By.xpath("//td[contains(@style, 'text-align:right') and contains(text(), '"+item+"')]/following-sibling::td[2]")).getText().trim();
        }
    }

    public String summary_SalaryDetails(String item){
        if(item.equalsIgnoreCase("Total")){
            return driver.findElement(By.xpath("//td[@class='leftToRight']//strong[text()='Salary Details']/..//table//strong[text()='Total']/following::td[1]")).getText().trim();
        }else{
            return driver.findElement(By.xpath("//td[@class='leftToRight']//strong[text()='Salary Details']/..//table//td[text()='"+item+"']/following-sibling::td[1]")).getText().trim();
        }
    }

    public String summary_SalaryDetails_ar(String item){
        if(item.equalsIgnoreCase("الإجمالي")){
            return driver.findElement(By.xpath("//td[contains(@style, 'text-align:right')]//strong[text()='تفاصيل الراتب']/..//table//strong[text()='الإجمالي']/following::td[1]")).getText().trim();
        }else{
            return driver.findElement(By.xpath("//td[contains(@style, 'text-align:right')]//strong[text()='تفاصيل الراتب']/..//table//td[text()='"+item+"']/following-sibling::td[1]")).getText().trim();
        }
    }

    public String summary_Salary_Amount(){
        return driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Salary']/following-sibling::td)[1]")).getText().trim();
    }
    public String summary_Salary_From(){
        return driver.findElement(By.xpath("//table[@dir='ltr']//td[@class='leftToRight' and text()='Salary']/..//td[text()='From']/following-sibling::td[1]")).getText().trim();
    }
    public String summary_Salary_To(){
        return driver.findElement(By.xpath("//table[@dir='ltr']//td[@class='leftToRight' and text()='Salary']/..//td[text()='To']/following-sibling::td[1]")).getText().trim();
    }
    public String summary_Salary_Days(){
        String net = driver.findElement(By.xpath("//table[@dir='ltr']//td[@class='leftToRight' and text()='Salary']/..//td[text()='To']/following-sibling::td[2]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_Salary_Amount_ar(){
        return driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='الراتب']/following-sibling::td)[1]")).getText().trim();
    }
    public String summary_Salary_From_ar(){
        return driver.findElement(By.xpath("//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='الراتب']/..//td[text()='من']/following-sibling::td[1]")).getText().trim();
    }
    public String summary_Salary_To_ar(){
        return driver.findElement(By.xpath("//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='الراتب']/..//td[text()='إلى']/following-sibling::td[1]")).getText().trim();
    }

    public String summary_LeaveDays_Amount(){
        return driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Leave Days']/following-sibling::td)[1]")).getText().trim();
    }
    public String summary_LeaveDays_From(){
        return driver.findElement(By.xpath("//table[@dir='ltr']//td[@class='leftToRight' and text()='Leave Days']/..//td[text()='From']/following-sibling::td[1]")).getText().trim();
    }
    public String summary_LeaveDays_To(){
        return driver.findElement(By.xpath("//table[@dir='ltr']//td[@class='leftToRight' and text()='Leave Days']/..//td[text()='To']/following-sibling::td[1]")).getText().trim();
    }
    public String summary_LeaveDays_Days(){
        String net = driver.findElement(By.xpath("//table[@dir='ltr']//td[@class='leftToRight' and text()='Leave Days']/..//td[text()='To']/following-sibling::td[2]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_LeaveDays_Amount_ar(){
        return driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='بدل أجازة']/following-sibling::td)[1]")).getText().trim();
    }
    public String summary_LeaveDays_From_ar(){
        return driver.findElement(By.xpath("//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='بدل أجازة']/..//td[text()='من']/following-sibling::td[1]")).getText().trim();
    }
    public String summary_LeaveDays_To_ar(){
        return driver.findElement(By.xpath("//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='بدل أجازة']/..//td[text()='إلى']/following-sibling::td[1]")).getText().trim();
    }

    public String summary_IndemnityDate_Amount(){
        return driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Indemnity Date']/following-sibling::td)[1]")).getText().trim();
    }
    public String summary_IndemnityDate_From(){
        return driver.findElement(By.xpath("//table[@dir='ltr']//td[@class='leftToRight' and text()='Indemnity Date']/..//td[text()='From']/following-sibling::td[1]")).getText().trim();
    }
    public String summary_IndemnityDate_To(){
        return driver.findElement(By.xpath("//table[@dir='ltr']//td[@class='leftToRight' and text()='Indemnity Date']/..//td[text()='To']/following-sibling::td[1]")).getText().trim();
    }
    public String summary_IndemnityDate_Days(){
        String net = driver.findElement(By.xpath("//table[@dir='ltr']//td[@class='leftToRight' and text()='Indemnity Date']/..//td[text()='To']/following-sibling::td[2]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_IndemnityDate_Amount_ar(){
        return driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='مكافأة نهاية الخدمة']/following-sibling::td)[1]")).getText().trim();
    }
    public String summary_IndemnityDate_From_ar(){
        return driver.findElement(By.xpath("//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='مكافأة نهاية الخدمة']/..//td[text()='من']/following-sibling::td[1]")).getText().trim();
    }
    public String summary_IndemnityDate_To_ar(){
        return driver.findElement(By.xpath("//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='مكافأة نهاية الخدمة']/..//td[text()='إلى']/following-sibling::td[1]")).getText().trim();
    }

    public String summary_OtherIndemnity(){
        return driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Other Indemnity']/following-sibling::td)[1]")).getText().trim();
    }
    public String summary_OtherIndemnity_ar(){
        return driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='مستحقات أخرى']/following-sibling::td)[1]")).getText().trim();
    }

    public String summary_IndemnityBasedOnArticle77(){
        return driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Indemnity Based On Article 77']/following-sibling::td)[1]")).getText().trim();
    }
    public String summary_IndemnityBasedOnArticle77_ar(){
        return driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and contains(text(), 'المادة 77')]/following-sibling::td)[1]")).getText().trim();
    }

    public String summary_Overtime(){
        return driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Overtime']/following-sibling::td)[1]")).getText().trim();
    }
    public String summary_Overtime_ar(){
        return driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='العمل الإضافي']/following-sibling::td)[1]")).getText().trim();
    }

    public String summary_TotalOtherIndemnity(){
        return driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight']//strong[text()='Total Other Indemnity']/following::td)[1]")).getText().trim();
    }
    public String summary_TotalOtherIndemnity_ar(){
        return driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right')]//strong[contains(text(), 'اجمالي المستحقات')]/following::td)[1]")).getText().trim();
    }

    public String summary_GOSI(){
        String net = driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='GOSI']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_GOSI_ar(){
        String net = driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='التامينات الاجتماعية']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String summary_Loans(){
        String net = driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Loans']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_Loans_ar(){
        String net = driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='السلفيات']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String summary_LoansUnpaidInstallment(){
        String net = driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Loans Unpaid Installment']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_LoansUnpaidInstallment_ar(){
        String net = driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='اقساط السلف المتبقية']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String summary_AbsentDays_Days(){
        String net = driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and contains(text(), 'Absent Days')])[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_AbsentDays_Days_ar(){
        String net = driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and contains(text(), 'أيام الغياب')])[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String summary_AbsentDays_Amount(){
        String net = driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and contains(text(), 'Absent Days')]/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_AbsentDays_Amount_ar(){
        String net = driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and contains(text(), 'أيام الغياب')]/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String summary_IndemnityBasedOnArticle77_deduction(){
        String net = driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Indemnity Based On Article 77']/following-sibling::td)[2]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_IndemnityBasedOnArticle77_deduction_ar(){
        String net = driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and contains(text(), 'المادة 77')]/following-sibling::td)[2]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String summary_HousingDuesDeduction(){
        String net = driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Housing Dues Deduction']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_HousingDuesDeduction_ar(){
        String net = driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='اقتطاع مستحقات السكن']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String summary_OtherDeductions(){
        String net = driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Other Deductions']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_OtherDeductions_ar(){
        String net = driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='استقطاعات']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String summary_TotalDeductions(){
        String net = driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight']//strong[text()='Total Deductions']/following::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_TotalDeductions_ar(){
        String net = driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right')]//strong[text()='اجمالي الاستقطاعات']/following::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String summary_findByType(String type){
        String net = driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='"+type+"']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_findByType_ar(String type){
        String net = driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='"+type+"']/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String summary_Total(){
        return driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and text()='Total']/following-sibling::td)[1]")).getText().trim();
    }
    public String summary_Total_ar(){
        return driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and text()='الصافي']/following-sibling::td)[1]")).getText().trim();
    }

    public String summary_Cash(){
        String net = driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and contains(text(), 'Cash / Cheque No')]/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }
    public String summary_Cash_ar(){
        String net = driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and contains(text(), 'الصافي نقدا')]/following-sibling::td)[1]")).getText().trim();
        return net.replaceAll("[^0-9\\.]", "");
    }

    public String summary_BankName(){
        return driver.findElement(By.xpath("(//table[@dir='ltr']//td[@class='leftToRight' and contains(text(), 'Bank Name')]/following-sibling::td)[1]")).getText().trim();
    }
    public String summary_BankName_ar(){
        return driver.findElement(By.xpath("(//table[@dir='rtl']//td[contains(@style, 'text-align:right') and contains(text(), 'اسم البنك')]/following-sibling::td)[1]")).getText().trim();
    }

    public String summary_Date(){
        return driver.findElement(By.xpath("//table[@dir='ltr']//td[@class='leftToRight' and text()='Total']/../..//td[contains(text(), 'Date')]/following-sibling::td[1]")).getText().trim();
    }
    public String summary_Date_ar(){
        return driver.findElement(By.xpath("//table[@dir='rtl']//td[contains(@style, 'text-align:right') and contains(text(), 'بتاريخ')]/following-sibling::td[1]")).getText().trim();
    }

    ////////// previous month locator ///////////

    public String previousSalariesDetails(String year, String month, String item){
        return driver.findElement(By.xpath("//table//td//strong[text()='Year']/following::strong[text()='"+year+"']/following::strong[text()='"+month+"']/../../..//td[contains(text(), '"+item+"')]/following-sibling::td[1]")).getText().trim();
    }
    public String previousSalariesDetails_DaysPaid(String year, String month){
        return driver.findElement(By.xpath("//table//td//strong[text()='Year']/following::strong[text()='"+year+"']/following::strong[text()='"+month+"']/../../..//strong[contains(text(), 'Days Paid')]/following::td[1]")).getText().trim();
    }
    public String previousSalariesDetails_TotalIncome(String year, String month){
        return driver.findElement(By.xpath("//table//td//strong[text()='Year']/following::strong[text()='"+year+"']/following::strong[text()='"+month+"']/../../..//strong[contains(text(), 'Total Income')]/following::td[1]")).getText().trim();
    }
    public String previousSalariesDetails_TotalDeductions(String year, String month){
        return driver.findElement(By.xpath("//table//td//strong[text()='Year']/following::strong[text()='"+year+"']/following::strong[text()='"+month+"']/../../..//strong[contains(text(), 'Total Deductions')]/following::td[1]")).getText().trim();
    }
    public String previousSalariesDetails_NetSalary(String year, String month){
        return driver.findElement(By.xpath("//table//td//strong[text()='Year']/following::strong[text()='"+year+"']/following::strong[text()='"+month+"']/../../..//strong[contains(text(), 'Net Salary')]/following::td[1]")).getText().trim();
    }

    ///////// previous month - print table locator /////

    public String previousSalariesDetails_Print(String year, String month, String item){
        return driver.findElement(By.xpath("(//td//strong[text()='Year']/following::strong[text()='"+year+"']/following::strong[text()='"+month+"']/../../following-sibling::tr//td[contains(text(), '"+item+"')]/following-sibling::td)[1]")).getText().trim();
    }
    public String previousSalariesDetails_Print_TotalIncome(String year, String month){
        return driver.findElement(By.xpath("(//td//strong[text()='Year']/following::strong[text()='"+year+"']/following::strong[text()='"+month+"']/../../following-sibling::tr//strong[contains(text(), 'Total Income')]/../following-sibling::td)[1]")).getText().trim();
    }
    public String previousSalariesDetails_Print_TotalDeductions(String year, String month){
        return driver.findElement(By.xpath("(//td//strong[text()='Year']/following::strong[text()='"+year+"']/following::strong[text()='"+month+"']/../../following-sibling::tr//strong[contains(text(), 'Total Deductions')]/../following-sibling::td)[1]")).getText().trim();
    }
    public String previousSalariesDetails_Print_NetSalary(String year, String month){
        return driver.findElement(By.xpath("(//td//strong[text()='Year']/following::strong[text()='"+year+"']/following::strong[text()='"+month+"']/../../following-sibling::tr//strong[contains(text(), 'Net Salary')]/../following-sibling::td)[1]")).getText().trim();
    }
    public String previousSalariesDetails_Print_DaysPaid(String year, String month){
        return driver.findElement(By.xpath("(//td//strong[text()='Year']/following::strong[text()='"+year+"']/following::strong[text()='"+month+"']/../../following-sibling::tr//strong[contains(text(), 'Days Paid')]/../following::strong)[1]")).getText().trim();
    }



}
