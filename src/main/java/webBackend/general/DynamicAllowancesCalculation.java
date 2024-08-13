package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class DynamicAllowancesCalculation extends WebBase {

    @FindBy(id = "select_month")
    WebElement monthE;
    @FindBy(id = "select_year")
    WebElement select_year;
    @FindBy(name = "employee_code")
    WebElement empCode;
    @FindBy(id = "calculate_button")
    WebElement calculateBtn;
    @FindBy(id = "MenaBox_iframe")
    WebElement boxIframe;
    @FindBy(id = "body_frame")
    WebElement frame;
    @FindBy(name = "close")
    WebElement okBtn;

    public void dynamicAllowancesCalculation(String employeeCode, String year, String month){

        goToFrame(frame);
        elementWaitAdvanced(By.name("employee_code"));
        empCode.clear();
        hold(100);
        setText(empCode, employeeCode, Keys.TAB);
        hold(500);
        Select yearSelect = new Select(select_year);
        yearSelect.selectByVisibleText(year);
        hold(500);
        Select monthSelect = new Select(monthE);
        monthSelect.selectByVisibleText(month);
        hold(500);
        ifElementClickable(By.id("calculate_button"));
        clickOn(calculateBtn);
        hold(300);
        closeIFrame();
        goToFrame(boxIframe);
        hold(500);
        elementWait(okBtn);
        clickOn(okBtn);
        hold(200);
        closeIFrame();

        setLog("Dynamic Allowances Calculation - "+"Employee Code: "+employeeCode+" - Year:"+year+" - Month: "+month);

    }

}
