package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class WorkSuspension extends WebBase {

    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "MenuNewButton")
    WebElement menuNew;
    @FindBy(id = "MenuPostButton")
    WebElement menuPost;
    @FindBy(name = "checkall")
    WebElement checkAll;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(id = "start_date")
    WebElement start_date;
    @FindBy(id = "end_date")
    WebElement end_date;
    @FindBy(xpath = "//input[@name='stopped_flag' and @value='0']")
    WebElement employeeIsInactive_No;
    @FindBy(xpath = "//input[@name='stopped_flag' and @value='1']")
    WebElement employeeIsInactive_Yes;
    @FindBy(name = "transaction_internal_type")
    WebElement workSuspensionTypeE;

    public void workSuspension(String employeeCode, String startDate, String endDate,boolean employeeIsInactive, String workSuspensionType){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        if(!startDate.isEmpty()){
            start_date.clear();
            hold(200);
            setText(start_date, startDate);
        }
        if(!endDate.isEmpty()){
            end_date.clear();
            hold(200);
            setText(end_date, endDate);
        }
        if(employeeIsInactive){
            employeeIsInactive_Yes.click();
        }else{
            employeeIsInactive_No.click();
        }
        if(!workSuspensionType.isEmpty()){
            Select select = new Select(workSuspensionTypeE);
            select.selectByVisibleText(workSuspensionType);
        }
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(300);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = getDriver().switchTo().alert();
        hold(500);
        alert.accept();
        hold(500);
        closeIFrame();

        setLog("Work Suspension"
        +" - Employee Code: "+employeeCode
        +" - Start Date: "+startDate
        +" - End Date: "+endDate
        +" - Employee Is Inactive: "+employeeIsInactive
        +" - Work Suspension Type: "+workSuspensionType);
    }

}
