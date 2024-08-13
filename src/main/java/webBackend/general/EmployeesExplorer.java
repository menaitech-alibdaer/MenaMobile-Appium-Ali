package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class EmployeesExplorer extends WebBase {

    @FindBy(id = "body_frame")
    public WebElement bodyFrame;
    @FindBy(name = "employee_code")
    public WebElement empCode;
    @FindBy(name = "Button2")
    public WebElement retrieveBtn;
    @FindBy(name = "mywindow")
    public WebElement dataFrame;
    @FindBy(id = "first_date")
    public WebElement firstDateE;
    @FindBy(id = "second_date")
    public WebElement secondDateE;
    @FindBy(xpath = "//a[contains(@href, 'view_employees_non_pay.php')]")
    WebElement nonPayrollExplorerTab;
    @FindBy(xpath = "//a[contains(@href, 'enlarge_attachment')]")
    public WebElement attachmentBtn;
    @FindBy(xpath = "//input[@name='moved'][@value='3']")
    public WebElement transactionsStatus_Both;
    @FindBy(name = "allowance_trans")
    public WebElement allowanceTransactionType;
    @FindBy(xpath = "(//table[@class='collapsetable']//td[8])[1]")
    public WebElement transactionType1;
    @FindBy(xpath = "(//table[@class='collapsetable']//td[8])[2]")
    public WebElement transactionType2;
    @FindBy(xpath = "(//table[@class='collapsetable']//td[8])//a[2]")
    public List<WebElement> transactionAttachments;

    public void retrieve(String employeeCode, String firstDate, String secondDate){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.name("employee_code"));
        if(!firstDate.isEmpty()){
            firstDateE.clear();
            hold(200);
            setText(firstDateE, firstDate);
        }
        if(!secondDate.isEmpty()){
            secondDateE.clear();
            hold(200);
            setText(secondDateE, secondDate);
        }
        hold(300);
        setText(empCode, employeeCode, Keys.TAB);
        hold(500);
        clickOn(retrieveBtn);
        hold(300);
        goToFrame(dataFrame);
        hold(300);

        setLog("Employees Explorer - Retrieve to employee Code: "+employeeCode+" - First Date: "+firstDate+" - Second Date: "+secondDate);

    }

    public void goToNonPayrollExplorer(){
        goToFrame(bodyFrame);
        hold(300);
        elementWait(nonPayrollExplorerTab);
        clickOn(nonPayrollExplorerTab);
        closeIFrame();
    }

    public boolean checkDataByTransaction(String transaction, String columnValue){
        return checkElementIfPresent(By.xpath("(//td//font[contains(text(), '"+transaction+"')])/preceding::font[contains(text(), '"+columnValue+"')]"));
    }

    public boolean findRow(String transaction, String transactionType, String valueOrPeriod){
        return checkElementIfPresent(By.xpath("//td//font[contains(text(), '"+transaction+"')]/../../..//font[contains(text(), '"+transactionType+"')]/../../..//font[contains(text(), '"+valueOrPeriod+"')]"));
    }


}
