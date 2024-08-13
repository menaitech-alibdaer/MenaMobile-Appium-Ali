package webBackend.financialInformation;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;
import static utilities.VersionGetter.versionGetter;

import java.text.DecimalFormat;
import java.util.List;

public class FinancialPackage extends WebBase {

    @FindBy(id = "body_frame")
    public WebElement bodyFrame;
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
    @FindBy(id = "select2-allownce_codex1-container")
    public WebElement allowanceCodeE1;
    @FindBy(xpath = "//span[contains(@id, 'select2-allownce_')]")
    List<WebElement> checkAllowances;
    @FindBy(id = "select2-allownce_codex2-container")
    public WebElement allowanceCodeE2;
    @FindBy(id = "select2-allownce_codex3-container")
    public WebElement allowanceCodeE3;
    @FindBy(name = "allownce_amnt[1]")
    public WebElement allowanceAmountE1;
    @FindBy(xpath = "(//input[contains(@name, 'allownce_amnt')])[last()]")
    public WebElement allowanceAmount_last;
    @FindBy(xpath = "(//span[contains(@id, 'select2-allownce_codex')])[last()]")
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
    @FindBy(xpath = "(//img[contains(@onclick, 'open_allowance_trans_history')])[1]")
    public WebElement transactionHistoryFirstAllowance;
    @FindBy(name = "checkbox[1]")
    public WebElement selectFirstAllowance;
    @FindBy(name = "checkbox[2]")
    public WebElement selectSecondAllowance;
    @FindBy(name = "checkbox[3]")
    public WebElement selectThirdAllowance;
    @FindBy(xpath = "(//span[text()='Formula Allowance With Child']/following::input)[1]")
    public WebElement formulaAllowanceWithChildAmount;
    @FindBy(xpath = "(//span[text()='Child Allowance']/following::input)[1]")
    public WebElement childAllowanceAmount;
    @FindBy(xpath = "(//span[text()='Spouse Allowance']/following::input)[1]")
    public WebElement spouseAllowanceAmount;
    @FindBy(xpath = "//span[text()='Formula Allowance With Child']")
    public WebElement formulaAllowanceWithChild;
    @FindBy(xpath = "//span[text()='Fixed Allowance']")
    public WebElement checkFixedAllowanceType;
    @FindBy(xpath = "(//span[text()='Fixed Allowance']/following::input)[1]")
    public WebElement checkFixedAllowanceAmount;
    @FindBy(xpath = "(//span[text()='Percent Allowance']/following::input)[1]")
    public WebElement checkPercentAllowanceAmount;
    @FindBy(xpath = "//span[text()='Classification Allowance 1']")
    public WebElement checkClassificationAllowance1Type;
    @FindBy(xpath = "(//span[text()='Classification Allowance 1']/following::input)[1]")
    public WebElement checkClassificationAllowance1Amount;
    @FindBy(xpath = "//span[text()='Classification Allowance 2']")
    public WebElement checkClassificationAllowance2Type;
    @FindBy(xpath = "(//span[text()='Classification Allowance 2']/following::input)[1]")
    public WebElement checkClassificationAllowance2Amount;
    @FindBy(xpath = "//span[text()='Classification Allowance 3']")
    public WebElement checkClassificationAllowance3Type;
    @FindBy(xpath = "(//span[text()='Classification Allowance 3']/following::input)[1]")
    public WebElement checkClassificationAllowance3Amount;
    @FindBy(id = "field_id[1]")
    public WebElement benefitOptions;
    @FindBy(xpath = "//span[@class='icon-rows cursor-pointer']")
    public WebElement annualPackageBtn;
    @FindBy(xpath = "//input[@onclick='on_save(form);']")
    public WebElement annualPackageConvertBtn;
    @FindBy(xpath = "//select[@name='field_id[1]']//option")
    public List<WebElement> allBenefitsOptions;
    @FindBy(xpath = "//span[contains(@id, 'select2-field_id1')]")
    public WebElement benefitTypeE1;
    @FindBy(id = "field_value1_1")
    public WebElement benefitAmountE1;
    @FindBy(id = "from_date_1")
    public WebElement fromDateE1;
    @FindBy(id = "to_date_1")
    public WebElement toDateE1;
    @FindBy(name = "notes[1]")
    public WebElement noteE1;
    @FindBy(xpath = "//div[@class='textAlign']//label[contains(@style, 'font-size:20px')]")
    public WebElement alertText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    public WebElement alertBox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    public WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    public WebElement addBtn;
    @FindBy(xpath = "//button[@onclick = \"menu_action('3')\"]")
    public WebElement deleteBtn;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    public WebElement alertButtonOkDelete;
    @FindBy(id = "employee_code")
    public WebElement empCode;
    @FindBy(id = "salary_code")
    public WebElement packageCodeE;
    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'allownce.php')]")
    public WebElement financialPackageTab;
    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'financial_data.php')]")
    public WebElement insuranceTab;
    @FindBy(xpath = "//div[contains(@onclick, 'employee_housing.php')]")
    public WebElement housingPage;
    @FindBy(xpath = "//div[contains(@onclick, 'other_benefits.php')]")
    public WebElement nonPayrollBenefitsPage;
    @FindBy(xpath = "//div[contains(@onclick, 'sys_tab_selector(5)')]")
    public WebElement otherPage;
    @FindBy(xpath = "//span[contains(@id, 'select2-extra_salary')]")
    public WebElement noOfYearlySalariesE;
    @FindBy(xpath = "//div[contains(@onclick, 'schooling_aid.php')]")
    public WebElement schoolingAidPage;
    @FindBy(xpath = "//div[contains(@onclick, 'furniture.php')]")
    public WebElement furniturePage;
    @FindBy(xpath = "//div[contains(@onclick, 'employee_tickets.php')]")
    public WebElement ticketsPage;
    @FindBy(name = "eligible_check")
    public WebElement employeesEligibleToSchoolingAidsCheckbox;
    @FindBy(id = "SA_start_date")
    public WebElement schoolAidStartDate;
    @FindBy(xpath = "//span[contains(@id, 'select2-min_child_age')]")
    public WebElement minimumChildAgeE;
    @FindBy(xpath = "//span[contains(@id, 'select2-max_child_age')]")
    public WebElement maximumChildAgeE;
    @FindBy(name = "emp_annual_upper_limit")
    public WebElement schoolingAnnualUpperLimitPerEmployeeE;
    @FindBy(xpath = "//span[contains(@id, 'select2-max_number_child')]")
    public WebElement maximumNumberOfChildrenE;
    @FindBy(name = "transaction_covere_percent")
    public WebElement transactionCoverPercentE;
    @FindBy(name = "housing_eligible")
    public WebElement employeeIsEligibleToHousingAccrualsCheckbox;
    @FindBy(id = "housing_value")
    public WebElement housingAllowanceAmount;
    @FindBy(id = "housing_start_date")
    public WebElement housingStartDate;
    @FindBy(id = "housing_stop_date")
    public WebElement housingStopDate;
    @FindBy(xpath = "//input[@name='housing_type'][@value='1']")
    public WebElement transactionCalculatedAsFixed;
    @FindBy(xpath = "//input[@name='housing_type'][@value='2']")
    public WebElement transactionCalculatedAsPercentage;
    @FindBy(xpath = "//span[contains(@id, 'select2-housing_repeat')]")
    public WebElement repeatHousingAllowanceEvery;
    @FindBy(xpath = "//img[contains(@src, 'history_icon.svg')]")
    public List<WebElement> historyDetailsBtn;
    @FindBy(xpath = "//label[@class='  font-size-11']")
    public List<WebElement> historyDetailsElements;
    @FindBy(xpath = "//a[contains(text(), 'Single')]")
    public WebElement furnitureSingle;
    @FindBy(xpath = "//a[contains(text(), 'Married')]")
    public WebElement furnitureMarried;
    @FindBy(name = "furniture_flag")
    public WebElement furnitureCompensationIsPaidToEmployeeE;
    @FindBy(id = "furniture_date")
    public WebElement furnitureWorthDateE;
    @FindBy(id = "furniture_spending_date")
    public WebElement furnitureDateE;
    @FindBy(id = "housing_loans")
    public WebElement furnitureAmountE;
    @FindBy(id = "count_of_children")
    public WebElement nonRefundAmountE;
    @FindBy(name = "furniture_desc")
    public WebElement furnitureDescriptionE;
    @FindBy(name = "notes")
    public WebElement noteE;
    @FindBy(id = "is_emp_tickets")
    public WebElement employeeIsEligibleForTicketsCheckbox;
    @FindBy(id = "is_spouse_tickets")
    public WebElement spouseIsEligibleForTicketsCheckbox;
    @FindBy(id = "is_child_tickets")
    public WebElement childrenAreEligibleForTicketsCheckbox;
    @FindBy(xpath = "//span[contains(@id, 'select2-tickets_annual_count')]")
    public WebElement minimumMonthsSpanBetweenEachTicketTransactionE;
    @FindBy(id = "child_rule_type")
    public WebElement childrenTicketsSetupIsBasedOnChildrenAgesCheckbox;
    @FindBy(xpath = "//span[contains(@id, 'select2-tickets_sons_count')]")
    public WebElement maximumNumberOfChildrenEligibleForTicketsE;
    @FindBy(xpath = "//span[contains(@id, 'select2-tickets_sons_age')]")
    public WebElement maximumAgeOfChildrenEligibleForTicketsE;
    @FindBy(name = "tickets_annual_sum")
    public WebElement upperLimitForTicketsAmountPerTripE;
    @FindBy(name = "emp_ticket_percent")
    public WebElement employeeTicketPercentageE;
    @FindBy(name = "spouse_ticket_percent")
    public WebElement spouseTicketPercentageE;
    @FindBy(name = "child_ticket_percent")
    public WebElement childrenTicketPercentageE;
    @FindBy(xpath = "(//table[@class='CollapseScreen']//tr)//td")
    public List<WebElement> getAllowancesByIndex;
    FinancialData_OCT financialDataOct;

    public void setEmployeeCode(String employeeCode){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            closeIFrame();
            goToFrame(bodyFrame);
            elementWaitAdvanced(By.id("employee_code"));
            hold(300);
            empCode.clear();
            hold(100);
            setText(empCode, employeeCode, Keys.TAB);
            hold(300);
            elementWaitAdvanced(By.xpath("//label[contains(text(),'Active Employee')]"));

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.setEmployeeCode(employeeCode);

        }

        setLog("Set Employee Code: "+employeeCode);

    }
    public void financialData(String basicSalary, String firstAllowance, String amountFirstAllowance, String fromDateFirstAllowance,
                              String toDateFirstAllowance, String withholdFirstAllowance, String noteFirstAllowance,
                              String secondAllowance, String amountSecondAllowance, String fromDateSecondAllowance,
                              String toDateSecondAllowance, String withholdSecondAllowance, String noteSecondAllowance,
                              String thirdAllowance, String amountThirdAllowance, String fromDateThirdAllowance,
                              String toDateThirdAllowance, String withholdThirdAllowance, String noteThirdAllowance){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            elementWaitAdvanced(By.id("basic_salary_amount"));
            if(!basicSalary.isEmpty()){
                basicSalaryE.clear();
                hold(300);
                setText(basicSalaryE, basicSalary);
            }
            hold(300);
            clickOn(saveBtn);
            hold(500);

            if(!firstAllowance.isEmpty()){
                clickOn(addBtn);
                hold(1500);
                selectOption(allowanceCodeE1, firstAllowance);
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
                clickOn(saveBtn);
                hold(1500);
            }

            if(!secondAllowance.isEmpty()){
                clickOn(addBtn);
                hold(1500);
                selectOption(allowanceCodeE2, secondAllowance);
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
                clickOn(saveBtn);
                hold(1500);
            }

            if(!thirdAllowance.isEmpty()){
                clickOn(addBtn);
                hold(1500);
                selectOption(allowanceCodeE3, thirdAllowance);
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
                clickOn(saveBtn);
                hold(1500);
            }

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.financialData(basicSalary, firstAllowance, amountFirstAllowance, fromDateFirstAllowance,
                    toDateFirstAllowance, withholdFirstAllowance, noteFirstAllowance,
                    secondAllowance, amountSecondAllowance, fromDateSecondAllowance,
                    toDateSecondAllowance, withholdSecondAllowance, noteSecondAllowance,
                    thirdAllowance, amountThirdAllowance, fromDateThirdAllowance,
                    toDateThirdAllowance, withholdThirdAllowance, noteThirdAllowance);

        }

        setLog("Financial Data"
                +" - basic Salary: "+basicSalary
                +" - first Allowance: "+firstAllowance
                +" - amount First Allowance: "+amountFirstAllowance
                +" - from Date First Allowance: "+fromDateFirstAllowance
                +" - to Date First Allowance: "+toDateFirstAllowance
                +" - withhold First Allowance: "+withholdFirstAllowance
                +" - note First Allowance: "+noteFirstAllowance
                +" - second Allowance: "+secondAllowance
                +" - amount Second Allowance: "+amountSecondAllowance
                +" - from Date Second Allowance: "+fromDateSecondAllowance
                +" - to Date Second Allowance: "+toDateSecondAllowance
                +" - withhold Second Allowance: "+withholdSecondAllowance
                +" - note Second Allowance: "+noteSecondAllowance
                +" - third Allowance: "+thirdAllowance
                +" - amount Third Allowance: "+amountThirdAllowance
                +" - from Date Third Allowance: "+fromDateThirdAllowance
                +" - to Date Third Allowance: "+toDateThirdAllowance
                +" - withhold Third Allowance: "+withholdThirdAllowance
                +" - note Third Allowance: "+noteThirdAllowance);

    }

    public void addAllowances(String allowanceCode, String allowanceAmount, String fromDate,
                              String toDate, String withhold, String note){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            elementWaitAdvanced(By.id("basic_salary_amount"));

            if(!allowanceCode.isEmpty()){
                clickOn(addBtn);
                hold(300);
                selectOption(allowanceCode_last, allowanceCode);
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
                scrollToElement(empCode);
                clickOn(saveBtn);
                hold(300);
            }

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.addAllowances(allowanceCode, allowanceAmount, fromDate,
                    toDate, withhold, note);

        }

        setLog("Add New Allowances"
                +" - Allowance Code: "+allowanceCode
                +" - Allowance Amount: "+allowanceAmount
                +" - From Date: "+fromDate
                +" - To Date: "+toDate
                +" - Withhold: "+withhold
                +" - note: "+note);

    }

    public void setBasicSalary(String basicSalary){

        if(!versionGetter().equalsIgnoreCase("OCT")){
            elementWaitAdvanced(By.id("basic_salary_amount"));
            if(!basicSalary.isEmpty()){
                basicSalaryE.clear();
                hold(300);
                setText(basicSalaryE, basicSalary);
            }
            hold(300);
            clickOn(saveBtn);
            hold(300);
        }else {
            financialDataOct = new FinancialData_OCT();
            financialDataOct.setBasicSalary(basicSalary);
        }

        setLog("Set Basic Salary: "+basicSalary);

    }

    public void deleteAllowances(int numberOfAllowances){

        clickOn(financialPackageTab);
        hold(300);
        elementWaitAdvanced(By.name("checkbox[1]"));
        for (int i = 0; i < numberOfAllowances; i++){
            if(checkAllowances.size() != 0){
                clickOn(selectFirstAllowance);
                hold(300);
                clickOn(deleteBtn);
                hold(400);
                clickOn(alertButtonOkDelete);
                hold(300);
            }
        }

        setLog("delete Allowances");

    }

    public void convertCurrencyForBasicSalary(String salary){

        hold(300);
        clickOn(currencyConverterBesideBS);
        hold(500);
        goToFrame(popupFrame);
        elementWaitAdvanced(By.name("value"));
        setText(convertCurrencyValue, salary);
        hold(500);
        clickOn(convertButton);
        hold(300);
        driver.switchTo().parentFrame();

        setLog("convert Currency For Basic Salary: "+salary);

    }

    public void convertCurrencyForFirstAllowance(String amount){

        hold(300);
        clickOn(currencyConverterInsideFirstAllowance);
        hold(500);
        goToFrame(popupFrame);
        elementWaitAdvanced(By.name("value"));
        setText(convertCurrencyValue, amount);
        hold(500);
        clickOn(convertButton);
        hold(300);
        driver.switchTo().parentFrame();

        setLog("convert Currency For First Allowance: "+amount);

    }
    
    public String converterCalculate(double value, String currency){
    
        double val = 0.00;
        if(currency.equalsIgnoreCase("USD")){
            val = value * 1.41;
        } else if (currency.equalsIgnoreCase("EUR")) {
            val = value * 1.30;
        }
        DecimalFormat df = new DecimalFormat("####0.00"); /// to return with TWO decimal Digits
        return df.format(val);

    }

    public void financialData_ClientId_USJ(String basicSalary, String originalSalary, String currentSalary, String workSchedule,
                                           String firstAllowance, String originalAmountFirstAllowance, String amountFirstAllowance,
                                           String currentAmountFirstAllowance, String fromDateFirstAllowance,
                                           String toDateFirstAllowance, String withholdFirstAllowance, String noteFirstAllowance,
                                           String secondAllowance, String originalAmountSecondAllowance, String amountSecondAllowance,
                                           String currentAmountSecondAllowance, String fromDateSecondAllowance,
                                           String toDateSecondAllowance, String withholdSecondAllowance, String noteSecondAllowance){

        elementWaitAdvanced(By.id("basic_salary_amount"));
        if(!basicSalary.isEmpty()){
            basicSalaryE.clear();
            hold(300);
            setText(basicSalaryE, basicSalary);
        }
        if(!originalSalary.isEmpty()){
            originalSalaryE.clear();
            hold(300);
            setText(originalSalaryE, originalSalary);
        }
        if(!currentSalary.isEmpty()){
            currentSalaryE.clear();
            hold(300);
            setText(currentSalaryE, currentSalary);
        }
        if(!workSchedule.isEmpty()){
            hold(300);
            selectOption(workScheduleE, workSchedule);
        }
        hold(400);
        clickOn(saveBtn);
        hold(500);

        if(!firstAllowance.isEmpty()){
            clickOn(addBtn);
            hold(1500);
            selectOption(allowanceCodeE1, firstAllowance);
            hold(200);
            if(!originalAmountFirstAllowance.isEmpty()){
                originalAmountE1.clear();
                hold(300);
                setText(originalAmountE1, originalAmountFirstAllowance);
            }
            if(!amountFirstAllowance.isEmpty()){
                allowanceAmountE1.clear();
                hold(300);
                setText(allowanceAmountE1, amountFirstAllowance);
            }
            if(!currentAmountFirstAllowance.isEmpty()){
                currentAmountE1.clear();
                hold(300);
                setText(currentAmountE1, currentAmountFirstAllowance);
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
            clickOn(saveBtn);
            hold(1500);
        }

        if(!secondAllowance.isEmpty()){
            clickOn(addBtn);
            hold(1500);
            selectOption(allowanceCodeE2, secondAllowance);
            hold(200);
            if(!originalAmountSecondAllowance.isEmpty()){
                originalAmountE2.clear();
                hold(300);
                setText(originalAmountE2, originalAmountSecondAllowance);
            }
            if(!amountSecondAllowance.isEmpty()){
                allowanceAmountE2.clear();
                hold(300);
                setText(allowanceAmountE2, amountSecondAllowance);
            }
            if(!currentAmountSecondAllowance.isEmpty()){
                currentAmountE2.clear();
                hold(300);
                setText(currentAmountE2, currentAmountSecondAllowance);
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
            clickOn(saveBtn);
            hold(1500);
        }

        setLog("financialData_ClientId_USJ"
                +" - basic Salary: "+basicSalary
                +" - original Salary: "+originalSalary
                +" - current Salary: "+currentSalary
                +" - work Schedule: "+workSchedule
                +" - first Allowance: "+firstAllowance
                +" - original Amount First Allowance: "+originalAmountFirstAllowance
                +" - amount First Allowance: "+amountFirstAllowance
                +" - currentAmountFirstAllowance: "+currentAmountFirstAllowance
                +" - from Date First Allowance: "+fromDateFirstAllowance
                +" - to Date First Allowance: "+toDateFirstAllowance
                +" - withhold First Allowance: "+withholdFirstAllowance
                +" - note First Allowance: "+noteFirstAllowance
                +" - second Allowance: "+secondAllowance
                +" - original Amount Second Allowance: "+originalAmountSecondAllowance
                +" - amount Second Allowance: "+amountSecondAllowance
                +" - current Amount Second Allowance: "+currentAmountSecondAllowance
                +" - from Date Second Allowance: "+fromDateSecondAllowance
                +" - to Date Second Allowance: "+toDateSecondAllowance
                +" - withhold Second Allowance: "+withholdSecondAllowance
                +" - note Second Allowance: "+noteSecondAllowance);

    }

    public void transactionHistory(int transactionNumber){

        if(!versionGetter().equalsIgnoreCase("OCT")){
            hold(500);
            clickOn(historyDetailsBtn.get(transactionNumber));
            hold(300);
            elementWaitAdvanced(By.id("All_popup"));
            goToFrame(popupFrame);
            hold(300);
        }else {
            financialDataOct = new FinancialData_OCT();
            hold(500);
            clickOn(financialDataOct.historyDetailsBtn.get(transactionNumber));
            hold(500);
            String parentWindow;
            closeIFrame();
            parentWindow = driver.getWindowHandle();
            goToWindow();
            hold(300);
            historyDetailsElements = financialDataOct.historyDetailsElements;
        }

        setLog("Transaction History: "+transactionNumber);

    }

    public void nonPayrollBenefits(String benefitType, String benefitAmount, String fromDate, String toDate, String note){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            clickOn(nonPayrollBenefitsPage);
            hold(500);
            clickOn(addBtn);
            hold(300);
            elementWaitAdvanced(By.id("field_value1_1"));
            selectOption(benefitTypeE1, benefitType);
            hold(500);
            if(!benefitAmount.isEmpty()){
                benefitAmountE1.clear();
                hold(300);
                setText(benefitAmountE1, benefitAmount);
            }
            if(!fromDate.isEmpty()){
                fromDateE1.clear();
                hold(300);
                setText(fromDateE1, fromDate);
            }
            if(!toDate.isEmpty()){
                toDateE1.clear();
                hold(300);
                setText(toDateE1, toDate);
            }
            if(!note.isEmpty()){
                noteE1.clear();
                hold(300);
                setText(noteE1, note);
            }

            hold(300);
            clickOn(saveBtn);
            hold(1500);

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.nonPayrollBenefits(benefitType, benefitAmount);

        }

        setLog("non Payroll Benefits"
                +" - benefit Type: "+benefitType
                +" - benefit Amount: "+benefitAmount);

    }

    public boolean findInAllBenefitType(String type){
        clickOn(nonPayrollBenefitsPage);
        hold(500);
        clickOn(addBtn);
        hold(300);
        elementWaitAdvanced(By.id("field_value1_1"));

        boolean check = false;
        for (WebElement allBenefitsOption : allBenefitsOptions) {
            if (allBenefitsOption.getText().equalsIgnoreCase(type)) {
                check = true;
            }
        }
        return check;
    }

    public void goToNonPayrollBenefits(){
        clickOn(nonPayrollBenefitsPage);
        hold(1500);

        setLog("go To Non Payroll Benefits");
    }

    public void housingAccruals(boolean employeeIsEligibleToHousingAccruals, String allowanceAmount, String startDate, String stopDate,
                                String transactionCalculatedAs, String automaticallyRepeatHousingAllowanceEvery){

        clickOn(housingPage);
        hold(300);
        elementWaitAdvanced(By.id("housing_value"));
        if(employeeIsEligibleToHousingAccruals){
            if(!employeeIsEligibleToHousingAccrualsCheckbox.isSelected()){
                hold(200);
                clickOn(employeeIsEligibleToHousingAccrualsCheckbox);
                hold(500);
            }
            if(transactionCalculatedAs.equalsIgnoreCase("Fixed")){
                clickOn(transactionCalculatedAsFixed);
            } else if (transactionCalculatedAs.equalsIgnoreCase("Percentage")) {
                clickOn(transactionCalculatedAsPercentage);
            }
            if(!allowanceAmount.isEmpty()){
                housingAllowanceAmount.clear();
                hold(300);
                setText(housingAllowanceAmount, allowanceAmount);
            }
            if(!startDate.isEmpty()){
                if(startDate.equalsIgnoreCase("empty")){
                    housingStartDate.clear();
                    hold(300);
                }else{
                    housingStartDate.clear();
                    hold(300);
                    setText(housingStartDate, startDate);
                }
            }
            if(!stopDate.isEmpty()){
                housingStopDate.clear();
                hold(300);
                setText(housingStopDate, stopDate);
            }
            selectOption(repeatHousingAllowanceEvery, automaticallyRepeatHousingAllowanceEvery);
            hold(500);
        }else{
            if(employeeIsEligibleToHousingAccrualsCheckbox.isSelected()){
                hold(200);
                clickOn(employeeIsEligibleToHousingAccrualsCheckbox);
                hold(500);
            }
        }
        clickOn(saveBtn);
        hold(500);

        setLog("Added Housing Accruals");

    }

    public void goToHousingAccruals(){
        clickOn(housingPage);
        hold(1500);
        setLog("go To Housing Accruals");
    }

    public void schoolingAid(boolean employeesEligibleToSchoolingAids, String startDate, String minimumChildAge, String maximumChildAge,
                             String schoolingAnnualUpperLimitPerEmployee, String maximumNumberOfChildren, String transactionCoverPercent){

        clickOn(schoolingAidPage);
        hold(300);
        elementWaitAdvanced(By.id("SA_start_date"));
        if(employeesEligibleToSchoolingAids){
            if(!employeesEligibleToSchoolingAidsCheckbox.isSelected()){
                hold(200);
                clickOn(employeesEligibleToSchoolingAidsCheckbox);
                hold(500);
            }
            if(!startDate.isEmpty()){
                schoolAidStartDate.clear();
                hold(300);
                setText(schoolAidStartDate, startDate);
                hold(300);
            }
            if(!minimumChildAge.isEmpty()){
                selectOption(minimumChildAgeE, minimumChildAge);
            }
            if(!maximumChildAge.isEmpty()){
                selectOption(maximumChildAgeE, maximumChildAge);
            }
            if(!schoolingAnnualUpperLimitPerEmployee.isEmpty()){
                schoolingAnnualUpperLimitPerEmployeeE.clear();
                hold(300);
                setText(schoolingAnnualUpperLimitPerEmployeeE, schoolingAnnualUpperLimitPerEmployee);
            }
            if(!maximumNumberOfChildren.isEmpty()){
                selectOption(maximumNumberOfChildrenE, maximumNumberOfChildren);
            }
            if(!transactionCoverPercent.isEmpty()){
                transactionCoverPercentE.clear();
                hold(300);
                setText(transactionCoverPercentE, transactionCoverPercent);
            }
        }else{
            if(employeesEligibleToSchoolingAidsCheckbox.isSelected()){
                hold(200);
                clickOn(employeesEligibleToSchoolingAidsCheckbox);
                hold(500);
            }
        }
        clickOn(saveBtn);
        hold(500);

        setLog("Added schooling Aid");

    }

    public void goToSchoolingAid(){
        clickOn(schoolingAidPage);
        hold(1500);
        setLog("go To Schooling Aid");
    }

    public void furniture(String singleOrMarried, boolean furnitureCompensationIsPaidToEmployee, String furnitureWorthDate,
                          String furnitureDate, String furnitureAmount, String nonRefundAmount, String furnitureDescription,
                          String notes){

        clickOn(furniturePage);
        hold(1500);
        elementWaitAdvanced(By.id("furniture_date"));
        if(singleOrMarried.equalsIgnoreCase("Single")){
            clickOn(furnitureSingle);
            hold(300);
        } else if (singleOrMarried.equalsIgnoreCase("Married")){
            clickOn(furnitureMarried);
            hold(300);
        }
        if(furnitureCompensationIsPaidToEmployee){
            if(!furnitureCompensationIsPaidToEmployeeE.isSelected()){
                clickOn(furnitureCompensationIsPaidToEmployeeE);
                hold(500);
            }
            if(!furnitureWorthDate.isEmpty()){
                furnitureWorthDateE.clear();
                hold(300);
                setText(furnitureWorthDateE, furnitureWorthDate);
            }
            if(!furnitureDate.isEmpty()){
                furnitureDateE.clear();
                hold(300);
                setText(furnitureDateE, furnitureDate);
            }
            if(!furnitureAmount.isEmpty()){
                furnitureAmountE.clear();
                hold(300);
                setText(furnitureAmountE, furnitureAmount);
            }
            if(!nonRefundAmount.isEmpty()){
                nonRefundAmountE.clear();
                hold(300);
                setText(nonRefundAmountE, nonRefundAmount);
            }
            hold(300);
            setText(furnitureDescriptionE, furnitureDescription);
            hold(300);
            setText(noteE, notes);
        }else{
            if(furnitureCompensationIsPaidToEmployeeE.isSelected()){
                hold(200);
                clickOn(furnitureCompensationIsPaidToEmployeeE);
                hold(500);
            }
        }
        clickOn(saveBtn);
        hold(500);

        setLog("Added furniture");

    }

    public void goToFurniture(String singleOrMarried){
        clickOn(furniturePage);
        hold(1500);
        if(singleOrMarried.equalsIgnoreCase("Single")){
            clickOn(furnitureSingle);
            hold(300);
        } else if (singleOrMarried.equalsIgnoreCase("Married")){
            clickOn(furnitureMarried);
            hold(300);
        }
        setLog("go To Furniture");
    }

    public void goToFurniture(){
        clickOn(furniturePage);
        hold(1500);
        setLog("go To Furniture");
    }

    public void tickets(boolean employeeIsEligibleForTickets, boolean spouseIsEligibleForTickets, boolean childrenAreEligibleForTickets,
                        String minimumMonthsSpanBetweenEachTicketTransaction, boolean childrenTicketsSetupIsBasedOnChildrenAges,
                        String maximumNumberOfChildrenEligibleForTickets, String maximumAgeOfChildrenEligibleForTickets, String upperLimitForTicketsAmountPerTrip,
                        String employeeTicketPercentage, String spouseTicketPercentage, String childrenTicketPercentage, String note){

        clickOn(ticketsPage);
        hold(1500);
        elementWaitAdvanced(By.id("is_emp_tickets"));
        if(employeeIsEligibleForTickets){
            if(!employeeIsEligibleForTicketsCheckbox.isSelected()){
                clickOn(employeeIsEligibleForTicketsCheckbox);
                hold(500);
            }
            if(spouseIsEligibleForTickets){
                if(!spouseIsEligibleForTicketsCheckbox.isSelected()){
                    clickOn(spouseIsEligibleForTicketsCheckbox);
                    hold(500);
                }
            }
            if(childrenAreEligibleForTickets){
                if(!childrenAreEligibleForTicketsCheckbox.isSelected()){
                    clickOn(childrenAreEligibleForTicketsCheckbox);
                    hold(500);
                }
            }
            if(!minimumMonthsSpanBetweenEachTicketTransaction.isEmpty()){
                selectOption(minimumMonthsSpanBetweenEachTicketTransactionE, minimumMonthsSpanBetweenEachTicketTransaction);
                hold(300);
            }
            if(childrenAreEligibleForTickets){
                if(childrenTicketsSetupIsBasedOnChildrenAges){
                    if(!childrenTicketsSetupIsBasedOnChildrenAgesCheckbox.isSelected()){
                        clickOn(childrenTicketsSetupIsBasedOnChildrenAgesCheckbox);
                        hold(500);
                    }
                }
                if(!childrenTicketsSetupIsBasedOnChildrenAges){
                    if(!maximumNumberOfChildrenEligibleForTickets.isEmpty()){
                        selectOption(maximumNumberOfChildrenEligibleForTicketsE, maximumNumberOfChildrenEligibleForTickets);
                        hold(500);
                    }
                    if(!maximumAgeOfChildrenEligibleForTickets.isEmpty()){
                        selectOption(maximumAgeOfChildrenEligibleForTicketsE, maximumAgeOfChildrenEligibleForTickets);
                        hold(500);
                    }
                }
            }
            scrollToElement(noteE);
            if(!upperLimitForTicketsAmountPerTrip.isEmpty()){
                upperLimitForTicketsAmountPerTripE.clear();
                hold(300);
                setText(upperLimitForTicketsAmountPerTripE, upperLimitForTicketsAmountPerTrip);
            }
            if(!employeeTicketPercentage.isEmpty()){
                employeeTicketPercentageE.clear();
                hold(300);
                setText(employeeTicketPercentageE, employeeTicketPercentage);
            }
            if(spouseIsEligibleForTickets){
                if(!spouseTicketPercentage.isEmpty()){
                    spouseTicketPercentageE.clear();
                    hold(300);
                    setText(spouseTicketPercentageE, spouseTicketPercentage);
                }
            }
            if(childrenAreEligibleForTickets){
                if(!childrenTicketPercentage.isEmpty()){
                    childrenTicketPercentageE.clear();
                    hold(300);
                    setText(childrenTicketPercentageE, childrenTicketPercentage);
                }
            }
            hold(300);
        }else{
            if(employeeIsEligibleForTicketsCheckbox.isEnabled()){
                clickOn(employeeIsEligibleForTicketsCheckbox);
                hold(500);
            }
        }
        setTextByJavascript(noteE, note);
        hold(300);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(500);

        setLog("Added tickets");

    }

    public void goToTickets(){
        clickOn(ticketsPage);
        hold(1500);
        setLog("go To Tickets");
    }

    public void annualPackage(String basicSalary, String firstAllowanceAmount, String secondAllowanceAmount){

        elementWaitAdvanced(By.xpath("//span[@class='icon-rows cursor-pointer']"));
        clickOn(annualPackageBtn);
        hold(500);
        goToFrame(popupFrame);
        elementWaitAdvanced(By.name("basic_salary_amount"));
        hold(500);
        if(!basicSalary.isEmpty()){
            basicSalaryE.clear();
            hold(300);
            setText(basicSalaryE, basicSalary);
            hold(300);
        }
        if(!firstAllowanceAmount.isEmpty()){
            allowanceAmountAnnualPackageE1.clear();
            hold(300);
            setText(allowanceAmountAnnualPackageE1, firstAllowanceAmount);
            hold(300);
        }
        if(!secondAllowanceAmount.isEmpty()){
            allowanceAmountAnnualPackageE2.clear();
            hold(300);
            setText(allowanceAmountAnnualPackageE2, secondAllowanceAmount);
            hold(300);
        }
        clickOn(annualPackageConvertBtn);
        hold(500);
        driver.switchTo().parentFrame();
        hold(500);

        setLog("annual Package - basicSalary: "+basicSalary+" - firstAllowanceAmount: "+firstAllowanceAmount+" - secondAllowanceAmount: "+secondAllowanceAmount);

    }

    public void editNumberOfSalary(String numberOfSalaries){

        clickOn(insuranceTab);
        hold(300);
        elementWaitAdvanced(By.name("insurance_flag"));
        clickOn(otherPage);
        hold(500);
        selectOption(noOfYearlySalariesE, numberOfSalaries);
        hold(500);
        clickOn(saveBtn);
        hold(1500);
        clickOn(financialPackageTab);
        hold(300);
        elementWaitAdvanced(By.id("basic_salary_amount"));

        setLog("edit Number Of Salary: "+numberOfSalaries);

    }

    public String allowanceCodeE1(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = allowanceCodeE1.getText().trim();
        }else {
            financialDataOct = new FinancialData_OCT();
            Select select = new Select(financialDataOct.allowanceCodeE1);
            WebElement option = select.getFirstSelectedOption();
            str = option.getText().trim();
        }
        return str;
    }

    public String allowanceCodeE2(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = allowanceCodeE2.getText().trim();
        }else {
            financialDataOct = new FinancialData_OCT();
            Select select = new Select(financialDataOct.allowanceCodeE2);
            WebElement option = select.getFirstSelectedOption();
            str = option.getText().trim();
        }
        return str;
    }

    public String allowanceAmountE1(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = allowanceAmountE1.getAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            str = financialDataOct.allowanceAmountE1.getAttribute("value");
        }
        return str;
    }

    public String allowanceAmountE2(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = allowanceAmountE2.getAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            str = financialDataOct.allowanceAmountE2.getAttribute("value");
        }
        return str;
    }

    public String allowanceFromDateE1(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = allowanceFromDateE1.getAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            str = financialDataOct.allowanceFromDateE1.getAttribute("value");
        }
        return str;
    }

    public String allowanceFromDateE2(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = allowanceFromDateE2.getAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            str = financialDataOct.allowanceFromDateE2.getAttribute("value");
        }
        return str;
    }

    public String allowanceToDateE1(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = allowanceToDateE1.getAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            str = financialDataOct.allowanceToDateE1.getAttribute("value");
        }
        return str;
    }

    public String allowanceToDateE2(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = allowanceToDateE2.getAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            str = financialDataOct.allowanceToDateE2.getAttribute("value");
        }
        return str;
    }

    public String childAllowanceAmount(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = childAllowanceAmount.getAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            str = financialDataOct.childAllowanceAmount.getAttribute("value");
        }
        return str;
    }

    public String spouseAllowanceAmount(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = spouseAllowanceAmount.getAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            str = financialDataOct.spouseAllowanceAmount.getAttribute("value");
        }
        return str;
    }

    public String allowanceNoteE1(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = allowanceNoteE1.getAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            str = financialDataOct.allowanceNoteE1.getAttribute("value");
        }
        return str;
    }

    public String allowanceWithholdE1(){
        String str = null;
        if(!versionGetter().equalsIgnoreCase("OCT")){
            str = allowanceWithholdE1.getAttribute("value");
        }else {
            financialDataOct = new FinancialData_OCT();
            str = financialDataOct.allowanceWithholdE1.getAttribute("value");
        }
        return str;
    }

}
