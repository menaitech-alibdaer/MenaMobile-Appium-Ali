package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class UpdateSocialSecuritySalary extends WebBase {

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
    @FindBy(name = "employee_code")
    WebElement empCode;
    @FindBy(name = "select_year")
    WebElement select_year;
    @FindBy(name = "social_security_code")
    WebElement socialSecurityTypeE;
    @FindBy(name = "open_new_b")
    WebElement updateBtn;

    public void updateSocialSecuritySalary(String employeeCode, String year, String socialSecurityType){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.name("select_year"));
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        if(!year.isEmpty()){
            Select selectYear = new Select(select_year);
            selectYear.selectByVisibleText(year);
        }
        if(!socialSecurityType.isEmpty()){
            Select selectType = new Select(socialSecurityTypeE);
            selectType.selectByVisibleText(socialSecurityType);
        }
        hold(500);
        clickOn(updateBtn);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(500);
        closeIFrame();

        setLog("Update Social Security Salary"
        +" - Employee Code: "+employeeCode
        +" - Year: "+year
        +" - Social Security Type: "+socialSecurityType);

    }

}
