package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class EmployeesUpgrade extends WebBase {

    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(name = "salary_code")
    WebElement packageCodeE;
    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "MenuPostButton")
    WebElement menuPost;
    @FindBy(xpath = "//input[contains(@onclick, 'go_upgrade()')]")
    WebElement okBtnWindow;

    public void employeeUpgrade(String employeeCode, String packageCode){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employeeCode);
        hold(300);
        setText(empCode, Keys.TAB);
        hold(500);
        packageCodeE.clear();
        hold(400);
        setText(packageCodeE, packageCode);
        hold(300);
        setText(packageCodeE, Keys.TAB);
        hold(300);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        clickOn(menuPost);
        hold(300);
        closeIFrame();
        String parentWindow = driver.getWindowHandle();
        goToWindow();
        hold(300);
        elementWaitAdvanced(By.id("oDiv"));
        clickOn(okBtnWindow);
        hold(500);
        backToParentWindow(parentWindow);
        hold(500);
        goToFrame(menuFrame);
        hold(1500);
        elementWaitAdvanced(By.id("MenuUnpostButton"));
        closeIFrame();

        setLog("Employee Upgrade - Employee Code: "+employeeCode+" - Package Code: "+packageCode);

    }

}
