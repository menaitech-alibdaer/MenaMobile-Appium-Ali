package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class RoundOvertime extends WebBase {

    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(id = "select_month")
    WebElement select_month;
    @FindBy(id = "select_year")
    WebElement select_year;
    @FindBy(id = "employee_code_1")
    WebElement empCode;
    @FindBy(name = "round_leave_b")
    WebElement roundOvertimeBtn;
    @FindBy(id = "transaction_date")
    WebElement transaction_date;

    public void roundOvertime(String employeeCode, String year, String month, String transactionDate){

        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("select_month"));
        if(!year.isEmpty()){
            Select monthS = new Select(select_year);
            monthS.selectByVisibleText(year);
            hold(500);
        }
        if(!month.isEmpty()){
            Select monthS = new Select(select_month);
            monthS.selectByVisibleText(month);
            hold(500);
        }
        if(!transactionDate.isEmpty()){
            transaction_date.clear();
            hold(200);
            setText(transaction_date, transactionDate);
            hold(200);
        }
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        clickOn(roundOvertimeBtn);
        hold(500);
        alertWait();
        Alert alert = getDriver().switchTo().alert();
        hold(300);
        Assert.assertTrue(alert.getText().contains("Overtime Were Rounded Successfully"), "Issue in Round Overtime!");
        alert.accept();
        closeIFrame();
        hold(300);

        setLog("Round Overtime - Employee Code: "+employeeCode+" - Month: "+month+" - Transaction Date: "+transactionDate);

    }

}
