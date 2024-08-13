package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class NonPayrollTransactions extends WebBase {

    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuPostButton")
    WebElement menuPost;
    @FindBy(name = "checkall")
    WebElement checkAll;
    @FindBy(id = "employee_code")
    WebElement empCode;

    public void postTransactions(String employeeCode){

        goToFrame(bodyFrame);
        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        clickOn(checkAll);
        hold(200);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = getDriver().switchTo().alert();
        hold(500);
        alert.accept();
        hold(3500);
        closeIFrame();

        setLog("Non Payroll Transactions - Post Transactions - Employee Code: "+employeeCode);

    }

}
