package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class SalaryCalculation_old extends WebBase {

    @FindBy(id = "select_month")
    WebElement monthE;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(id = "calculate_button")
    WebElement calculateBtn;
    @FindBy(id = "MenaBox_iframe")
    WebElement boxIframe;
    @FindBy(name = "loading")
    WebElement loadingImg;
    @FindBy(id = "close")
    WebElement okBtnIframe;
    @FindBy(id = "body_frame")
    WebElement frame;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;

    public void salaryCalculation(String employeeCode, String month){

        hold(500);
        goToFrame(frame);
        elementWaitAdvanced(By.id("site_1"));
        Select monthOptions = new Select(monthE);
        monthOptions.selectByVisibleText(month);
        hold(200);
        setText(empCode, employeeCode);
        hold(100);
        setText(empCode, Keys.TAB);
        hold(300);
        clickOn(calculateBtn);
        closeIFrame();
        goToFrame(boxIframe);
        hold(300);
        elementWaitDisappear(loadingImg);
        elementWaitAdvanced(By.xpath("//label[contains(text(), 'Operation Was Successfully Completed')]"));
        hold(500);
        clickOn(okBtnIframe);
        hold(500);
        closeIFrame();

        setLog("Salary Calculation - Employee Code: "+employeeCode+" - Month: "+month+" - Year: "+currentYear());

    }

}
