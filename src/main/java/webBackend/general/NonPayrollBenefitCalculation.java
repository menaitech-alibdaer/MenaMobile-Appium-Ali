package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class NonPayrollBenefitCalculation extends WebBase {

    @FindBy(id = "employee_code")
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
    @FindBy(name = "loading")
    public WebElement loadingImg;


    public void calculation(String employeeCode, String year, String month){

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

        setLog("Non Payroll Benefit Calculation - Employee Code: "+employeeCode+" - Year: "+year+" - Month: "+month);

    }

}
