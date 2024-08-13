package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class ExtraSalary extends WebBase {

    @FindBy(name = "employee_code")
    public WebElement empCode;
    @FindBy(id = "body_frame")
    WebElement body_frame;
    @FindBy(id = "select_year")
    public WebElement select_year;
    @FindBy(id = "select_month")
    public WebElement select_month;
    @FindBy(id = "calculate_button")
    public WebElement calculate_button;
    @FindBy(id = "MenaBox_iframe")
    WebElement MenaBox_iframe;
    @FindBy(name = "close")
    WebElement closeBtn;
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
    @FindBy(id = "Site_Allowance_Amount")
    public WebElement Site_Allowance_Amount;
    @FindBy(id = "Site_Allowance_Type")
    public WebElement Site_Allowance_Type;
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
    @FindBy(id = "Absence_month")
    public WebElement Absence_month;
    @FindBy(id = "Fixed_Allowance_month")
    public WebElement Fixed_Allowance_month;
    @FindBy(id = "Percent_Allowance_month")
    public WebElement Percent_Allowance_month;
    @FindBy(xpath = "(//td[@id='Percent_Allowance_month']/preceding-sibling::td)[1]")
    public WebElement percentAllowanceName;
    @FindBy(id = "Monthly_Loans_month")
    public WebElement Monthly_Loans_month;
    @FindBy(id = "Total_Income_month")
    public WebElement Total_Income_month;
    @FindBy(id = "Net_Salary_month")
    public WebElement Net_Salary_month;
    @FindBy(id = "net_salary_YTD")
    public WebElement net_salary_YTD;
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


    public void calculate(String employeeCode, String year, String month){

        goToFrame(body_frame);
        elementWaitAdvanced(By.name("employee_code"));
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
        parentWindow = getDriver().getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);
        elementWaitAdvanced(By.id("Basic_Salary"));

        setLog("Extra Salary Calculate - Employee Code: "+employeeCode+" - Year: "+year+" - Month: "+month);

    }

    public void closeSalaryReport(){

        closeIFrame();
        clickOn(closeReport);
        hold(200);
        backToParentWindow(parentWindow);

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
    public String percentAllowanceMonth(){
        return Percent_Allowance_month.getText().trim();
    }
    public String percentAllowanceName(){
        return percentAllowanceName.getText().trim();
    }
    public String monthlyLoans(){
        return Monthly_Loans_month.getText().trim();
    }
    public String otherAllowances(){
        return Other_Allowances_month.getText().trim();
    }
    public String siteAllowance(){
        return Site_Allowance_Amount.getText().trim();
    }
    public String siteAllowanceType(){
        return Site_Allowance_Type.getText().trim();
    }
    public String otherDeductionsMonth(){
        return Other_Deductions_month.getText().trim();
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

    public String fixedAllowanceByEmpName(String employeeName){
        return getDriver().findElement(By.xpath("//td[contains(text(), '"+employeeName+"')]/following::td[5]")).getText().trim();
    }

}
