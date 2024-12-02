package webBackend.salaryCalculation;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class SalaryCalculation extends WebBase {

    @FindBy(id = "employee_code")
    public WebElement empCode;
    @FindBy(id = "body_frame")
    WebElement body_frame;
    @FindBy(name = "select_year")
    public WebElement select_year;
    @FindBy(name = "select_month")
    public WebElement select_month;
    @FindBy(name = "dynamic_list")
    WebElement dynamic_list;
    @FindBy(name = "site")
    WebElement siteE;
    @FindBy(id = "calculate_button")
    public WebElement calculate_button;
    @FindBy(id = "MenaBox_iframe")
    WebElement MenaBox_iframe;
    @FindBy(name = "close")
    WebElement closeBtn;
    @FindBy(name = "salary_released_button")
    WebElement releaseToMenaMEBtn;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuShowButton")
    WebElement MenuShowButton;
    @FindBy(id = "MenuDeleteButton")
    WebElement menuDelete;
    @FindBy(id = "month")
    public WebElement monthE;
    @FindBy(id = "Basic_Salary")
    public WebElement Basic_Salary;
    @FindBy(id = "Days_Paid")
    public WebElement Days_Paid;
    @FindBy(id = "Other_Allowances_month")
    public WebElement Other_Allowances_month;
    @FindBy(id = "Worth_Salary_month")
    public WebElement Worth_Salary_month;
    @FindBy(id = "Overtime_month")
    public WebElement Overtime_month;
    @FindBy(id = "Overtime_Details_type")
    public WebElement Overtime_Details_type;
    @FindBy(id = "Overtime_Hours_Details")
    public WebElement Overtime_Hours_Details;
    @FindBy(id = "Overtime_Details_amount")
    public WebElement Overtime_Details_amount;
    @FindBy(id = "allowance_amount")
    public WebElement first_allowance_amount;
    @FindBy(id = "allowance_type")
    public WebElement first_allowance_type;
    @FindBy(id = "Other_Deductions_month")
    public WebElement Other_Deductions_month;
    @FindBy(id = "Other_Income_month")
    public WebElement Other_Income_month;
    @FindBy(id = "Absence_month")
    public WebElement Absence_month;
    @FindBy(id = "Paid_Vacations_month")
    WebElement Paid_Vacations_month;
    @FindBy(id = "In_Advance_Vacation_month")
    public WebElement In_Advance_Vacation_month;
    @FindBy(id = "Fixed_Allowance_month")
    public WebElement Fixed_Allowance_month;
    @FindBy(id = "Percent_Allowance_month")
    public WebElement Percent_Allowance_month;
    @FindBy(id = "Site_Allowance_month")
    public WebElement Site_Allowance_month;
    @FindBy(id = "Site_Allowance_Amount")
    public WebElement Site_Allowance_Amount;
    @FindBy(id = "Site_Allowance_Type")
    public WebElement Site_Allowance_Type;
    @FindBy(xpath = "(//td[@id='Percent_Allowance_month']/preceding-sibling::td)[1]")
    public WebElement percentAllowanceName;
    @FindBy(id = "Total_Income_month")
    public WebElement Total_Income_month;
    @FindBy(id = "Social_Security_month")
    public WebElement Social_Security_month;
    @FindBy(id = "Health_Insurance_month")
    public WebElement Health_Insurance_month;
    @FindBy(id = "Net_Salary_month")
    public WebElement Net_Salary_month;
    @FindBy(id = "total_deductions_month")
    public WebElement total_deductions_month;
    @FindBy(id = "net_salary_YTD")
    public WebElement net_salary_YTD;
    @FindBy(id = "Monthly_Loans_month")
    public WebElement Monthly_Loans_month;
    @FindBy(id = "Provident_Fund_month")
    WebElement Provident_Fund_month;
    @FindBy(id = "Accumulated_Balance")
    WebElement Accumulated_Balance;
    @FindBy(xpath = "(//td[contains(text(),'Child Allowance')]/following::td)[1]")
    public WebElement childAllowanceAmount;
    @FindBy(xpath = "//td[contains(text(),'Child Allowance')]")
    public WebElement childAllowanceType;
    @FindBy(id = "RSIFrame")
    WebElement reportIFrame;
    @FindBy(className = "rgClose")
    WebElement closeReport;
    @FindBy(name = "loading")
    public WebElement loadingImg;
    @FindBy(name = "close")
    WebElement closePopup;
    @FindBy(id = "operation")
    public WebElement operation;
    String parentWindow;


    public void salaryCalculation(String employeeCode, String year, String month){

        goToFrame(body_frame);
        elementWaitAdvanced(By.id("employee_code"));
        empCode.clear();
        hold(100);
        setText(empCode, employeeCode, Keys.TAB);
        hold(500);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(500);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        hold(500);
        ifElementClickable(By.id("calculate_button"));
        clickOn(calculate_button);
        hold(300);
        closeIFrame();
        goToFrame(MenaBox_iframe);
        hold(500);
        elementWaitDisappear(loadingImg);
        elementWaitAdvanced(By.name("close"));
        clickOn(closeBtn);
        hold(200);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = driver.getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);
        elementWaitAdvanced(By.id("Basic_Salary"));

        setLog("Salary Calculation - Employee Code: "+employeeCode+" - Year: "+year+" - Month: "+month);

    }

    public void salaryCalculation_WithoutViewReport(String employeeCode, String year, String month, boolean releaseToMenaME){

        goToFrame(body_frame);
        elementWaitAdvanced(By.id("employee_code"));
        empCode.clear();
        hold(100);
        setText(empCode, employeeCode, Keys.TAB);
        hold(500);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(500);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        hold(500);
        ifElementClickable(By.id("calculate_button"));
        clickOn(calculate_button);
        hold(300);
        closeIFrame();
        goToFrame(MenaBox_iframe);
        hold(500);
        elementWaitDisappear(loadingImg);
        elementWaitAdvanced(By.name("close"));
        clickOn(closeBtn);
        hold(200);
        if(releaseToMenaME){
            closeIFrame();
            goToFrame(body_frame);
            hold(800);
            clickOn(releaseToMenaMEBtn);
            alertWait();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            hold(1000);
            alertWait();
            Alert alert2 = driver.switchTo().alert();
            alert2.accept();
            closeIFrame();
            goToFrame(body_frame);
        }
        closeIFrame();

        setLog("Salary Calculation - Employee Code: "+employeeCode+" - Year: "+year+" - Month: "+month);

    }

    public void salaryCalculationBySite_WithoutViewReport(String site, String year, String month){

        goToFrame(body_frame);
        elementWaitAdvanced(By.id("employee_code"));
        setText(siteE, site, Keys.TAB);
        hold(500);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(500);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        hold(500);
        ifElementClickable(By.id("calculate_button"));
        clickOn(calculate_button);
        hold(300);
        closeIFrame();
        goToFrame(MenaBox_iframe);
        hold(500);
        elementWaitDisappear(loadingImg);
        elementWaitAdvanced(By.name("close"));
        clickOn(closeBtn);
        hold(200);
        closeIFrame();

        setLog("Salary Calculation - Site: "+site+" - Year: "+year+" - Month: "+month);

    }

    public void salaryCalculation_DynamicList(String year, String month, String dynamicList){

        goToFrame(body_frame);
        elementWaitAdvanced(By.id("employee_code"));
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(500);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        hold(500);
        Select dynamic = new Select(dynamic_list);
        dynamic.selectByVisibleText(dynamicList);
        hold(500);
        ifElementClickable(By.id("calculate_button"));
        clickOn(calculate_button);
        hold(300);
        closeIFrame();
        goToFrame(MenaBox_iframe);
        hold(500);
        elementWaitDisappear(loadingImg);
        elementWaitAdvanced(By.name("close"));
        clickOn(closeBtn);
        hold(200);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = driver.getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);
        //elementWaitAdvanced(By.id("Basic_Salary"));

        setLog("Salary Calculation - Dynamic List: "+dynamicList+" - Year: "+year+" - Month: "+month);

    }

    public void salaryCalculationByDynamicList_WithoutViewReport(String year, String month, String dynamicList){

        goToFrame(body_frame);
        elementWaitAdvanced(By.id("employee_code"));
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(500);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        hold(500);
        Select dynamic = new Select(dynamic_list);
        dynamic.selectByVisibleText(dynamicList);
        hold(500);
        ifElementClickable(By.id("calculate_button"));
        clickOn(calculate_button);
        hold(300);
        closeIFrame();
        goToFrame(MenaBox_iframe);
        hold(500);
        elementWaitDisappear(loadingImg);
        elementWaitAdvanced(By.name("close"));
        clickOn(closeBtn);
        hold(200);
        closeIFrame();

        setLog("Salary Calculation - Dynamic List: "+dynamicList+" - Year: "+year+" - Month: "+month);

    }

    public void salaryCalculation(String employeeCode, String year, String month, boolean closePopup){

        goToFrame(body_frame);
        elementWaitAdvanced(By.id("employee_code"));
        empCode.clear();
        hold(100);
        setText(empCode, employeeCode, Keys.TAB);
        hold(500);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(500);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        hold(500);
        ifElementClickable(By.id("calculate_button"));
        clickOn(calculate_button);
        hold(300);
        closeIFrame();
        goToFrame(MenaBox_iframe);
        hold(500);
        elementWaitDisappear(loadingImg);
        elementWaitAdvanced(By.name("close"));
        if(closePopup){
            clickOn(closeBtn);
            hold(200);
            closeIFrame();
        }

        setLog("Salary Calculation - Employee Code: "+employeeCode+" - Year: "+year+" - Month: "+month);

    }

    public void closePopup(){
        elementWaitAdvanced(By.name("close"));
        clickOn(closeBtn);
        hold(200);
        closeIFrame();
    }

    public void viewReport(){
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = driver.getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);
        //elementWaitAdvanced(By.id("Basic_Salary"));
    }

    public void closeSalaryReport(){

        closeIFrame();
        clickOn(closeReport);
        hold(200);
        backToParentWindow(parentWindow);

    }

    public void deleteCalculation(){
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuDelete);
        alertWait();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        hold(300);
        closeIFrame();
        goToFrame(MenaBox_iframe);
        elementWait(closePopup);
        clickOn(closePopup);
        closeIFrame();

        setLog("Delete Calculation");
    }

    public String month(){
        return monthE.getText().trim();
    }
    public String basicSalary(){
        return Basic_Salary.getText().trim();
    }
    public String daysPaid(){
        return Days_Paid.getText().trim();
    }
    public String worthSalaryMonth(){
        return Worth_Salary_month.getText().trim();
    }
    public String fixedAllowanceMonth(){
        return Fixed_Allowance_month.getText().trim();
    }
    public String totalIncomeMonth(){
        return Total_Income_month.getText().trim();
    }
    public String netSalaryMonth(){
        return Net_Salary_month.getText().trim();
    }
    public String monthlyLoans(){
        return Monthly_Loans_month.getText().trim();
    }
    public String providentFund(){
        return Provident_Fund_month.getText().trim();
    }
    public String accumulatedBalanceNextMonth(){
        return Accumulated_Balance.getText().trim();
    }
    public String netSalaryYTD(){
        return net_salary_YTD.getText().trim();
    }
    public String overtimeMonth(){
        return Overtime_month.getText().trim();
    }
    public String overtimeDetailsType(){
        return Overtime_Details_type.getText().trim();
    }
    public String firstAllowanceAmount(){
        return first_allowance_amount.getText().trim();
    }
    public String firstAllowanceType(){
        return first_allowance_type.getText().trim();
    }
    public String absenceMonth(){
        return Absence_month.getText().trim();
    }
    public String inAdvanceVacationMonth(){
        return In_Advance_Vacation_month.getText().trim();
    }
    public String percentAllowanceMonth(){
        return Percent_Allowance_month.getText().trim();
    }
    public String siteAllowance(){
        return Site_Allowance_month.getText().trim();
    }
    public String siteAllowanceAmount(){
        return Site_Allowance_Amount.getText().trim();
    }
    public String siteAllowanceType(){
        return Site_Allowance_Type.getText().trim();
    }
    public String percentAllowanceName(){
        return percentAllowanceName.getText().trim();
    }
    public String otherAllowances(){
        return Other_Allowances_month.getText().trim();
    }
    public String otherDeductionsMonth(){
        return Other_Deductions_month.getText().trim();
    }
    public String otherIncomeMonth(){
        return Other_Income_month.getText().trim();
    }
    public String childAllowanceAmount(){
        return childAllowanceAmount.getText().trim();
    }
    public String childAllowanceType(){
        return childAllowanceType.getText().trim();
    }
    public String overtimeHoursDetails(){
        return Overtime_Hours_Details.getText().trim();
    }
    public String overtimeDetailsAmount(){
        return Overtime_Details_amount.getText().trim();
    }
    public String socialSecurityMonth(){
        return Social_Security_month.getText().trim();
    }
    public String healthInsuranceMonth(){
        return Health_Insurance_month.getText().trim();
    }
    public String totalDeductionsMonth(){
        return total_deductions_month.getText().trim();
    }
    public String paidVacations(){
        return Paid_Vacations_month.getText().trim();
    }

    public String fixedAllowanceByEmpName(String employeeName){
        ////// use this method when retrieve salary slip for multiple employees
        return driver.findElement(By.xpath("//td[contains(text(), '"+employeeName+"')]/following::td[5]")).getText().trim();
    }
    public String percentAllowanceByEmpName(String employeeName){
        ////// use this method when retrieve salary slip for multiple employees
        return driver.findElement(By.xpath("//td[contains(text(), '"+employeeName+"')]/following::td[6]")).getText().trim();
    }

    public String reasonByEmpCode(String employeeCode){
        return driver.findElement(By.xpath("//font[text()='"+employeeCode+"']/following::font[1]")).getText().trim();
    }

    public boolean checkReportTableIfAppear(){
        return checkElementIfPresent(By.className("reportTable"));
    }
    public String getValue(String name){
        return driver.findElement(By.xpath("//td[contains(text(), '"+name+"')]/following::td[1]")).getText().trim();
    }

}
