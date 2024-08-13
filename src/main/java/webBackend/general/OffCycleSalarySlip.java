package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class OffCycleSalarySlip extends WebBase {

    @FindBy(name = "employee_code")
    public WebElement empCode;
    @FindBy(id = "body_frame")
    WebElement body_frame;
    @FindBy(name = "select_year")
    public WebElement select_year;
    @FindBy(name = "select_month")
    public WebElement select_month;
    @FindBy(name = "report_form")
    WebElement reportFormE;
    @FindBy(name = "show_employee_code")
    WebElement show_employee_code;
    @FindBy(name = "hide_zero_val")
    WebElement hideAnyColumnHasZeroValueE;
    @FindBy(name = "hide_record_with_zero_values")
    WebElement hideAnyRecordWithZeroValuesE;
    @FindBy(name = "is_employee_currency")
    WebElement useTheEmployeeCurrencyE;
    @FindBy(xpath = "//input[@name='onservice' and @value='1']")
    WebElement currentEmployeesE;
    @FindBy(xpath = "//input[@name='onservice' and @value='2']")
    WebElement terminatedE;
    @FindBy(xpath = "//input[@name='onservice' and @value='3']")
    WebElement bothE;
    @FindBy(xpath = "//input[@name='yearly_deatils' and @value='1']")
    WebElement yearlyDetails;
    @FindBy(xpath = "//input[@name='yearly_deatils' and @value='2']")
    WebElement yearlyTotal;
    @FindBy(name = "dynamic_lists")
    WebElement dynamic_list;
    @FindBy(name = "site")
    WebElement siteE;
    @FindBy(name = "currency")
    WebElement reportCurrencyE;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuShowButton")
    WebElement MenuShowButton;
    @FindBy(id = "show_emp_offcycle_vac_with_no_resumption")
    WebElement show_emp_offcycle_vac_with_no_resumption;
    @FindBy(xpath = "//font[text()='Month']/following::font[2]")
    public WebElement monthE;
    @FindBy(id = "RSIFrame")
    WebElement reportIFrame;
    @FindBy(xpath = "//img[contains(@src, 'loadingAnimation.gif')]")
    WebElement loadingElement;
    @FindBy(className = "rgClose")
    WebElement closeReport;
    @FindBy(xpath = "//tr[@class='reportGroupHeader']//td[contains(text(), 'American Dollar')]")
    WebElement findAmericanDollar;
    @FindBy(xpath = "//tr[@class='reportGroupHeader']//td[contains(text(), 'Jordanian Dinar')]")
    WebElement findJordanianDinar;
    @FindBy(xpath = "//td[@colspan='1']")
    List<WebElement> reportHeader;
    @FindBy(xpath = "//table[@class='reportTable']//td[1]")
    List<WebElement> listOfAllEmployeesCodeInReportWithHeaderAndFooter;
    @FindBy(xpath = "//table[@class='reportTable']//td[@class='textToExcel']")
    public List<WebElement> allEmployeeInReport;
    String parentWindow;

    public void viewReport(String employeeCode, String year, String month){

        goToFrame(body_frame);
        elementWaitAdvanced(By.name("employee_code"));
        empCode.clear();
        hold(100);
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(100);
        Select monthSelect = new Select(select_month);
        monthSelect.selectByVisibleText(month);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(MenuShowButton);
        hold(300);
        closeIFrame();
        parentWindow = getDriver().getWindowHandle();
        goToWindow();
        hold(500);
        goToFrame(reportIFrame);

        setLog("Off-Cycle Salary Slip - View Report - Employee Code: "+employeeCode+" - Year: "+year+" - Month: "+month);

    }

    public void closeSalaryReport(){

        closeIFrame();
        clickOn(closeReport);
        hold(200);
        backToParentWindow(parentWindow);

        setLog("Close Slip Report");

    }

    public String getValue(String name){
        return getDriver().findElement(By.xpath("//font[contains(text(), '"+name+"')]/following::font[1]")).getText().trim();
    }
    public String basicSalary(){
        return getDriver().findElement(By.xpath("//font[contains(text(), 'Basic Salary')]/following::font[2]")).getText().trim();
    }
    public String daysPaid(){
        return getDriver().findElement(By.xpath("//font[contains(text(), 'Days Paid')]/following::font[2]")).getText().trim();
    }
    public String netSalary(){
        return getDriver().findElement(By.xpath("(//font[contains(text(), 'Net Salary')])[1]/following::font[1]")).getText().trim();
    }

}
