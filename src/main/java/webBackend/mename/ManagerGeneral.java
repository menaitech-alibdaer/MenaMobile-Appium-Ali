package webBackend.mename;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class ManagerGeneral extends WebBase {

    @FindBy(id = "overtime_entry")
    WebElement overtime_entry;
    @FindBy(id = "request_iframe")
    WebElement request_iframe;
    @FindBy(name = "checkall")
    WebElement helperToClickEnter;
    @FindBy(xpath = "(//input[contains(@id, 'code_')])[last()]")
    WebElement setEmployeeCode;
    @FindBy(xpath = "(//input[contains(@id, 'transaction_date_')])[last()]")
    WebElement transactionDateE;
    @FindBy(xpath = "//a[contains(@href, 'wf_mass_transactions.php')]")
    WebElement massApproval;
    @FindBy(id = "WF_serial")
    WebElement workflowIdE;
    @FindBy(id = "manager_code_filter")
    WebElement employeeNameE;
    @FindBy(id = "display")
    WebElement displayBtn;
    @FindBy(id = "approve")
    WebElement approveBtn;
    @FindBy(id = "disapprove")
    WebElement declineBtn;
    @FindBy(id = "attach_document")
    WebElement attach_document;
    @FindBy(id = "transaction_internal_type_0")
    WebElement workTypeE;
    @FindBy(id = "workflow_iframe")
    WebElement workflow_iframe;
    @FindBy(xpath = "(//div[@class='col-md-4']//p[text()='Transaction Type']/following::p)[1]")
    public WebElement transactionTypeE;
    @FindBy(xpath = "(//div[@class='col-md-4']//p[text()='Type']/following::p)[1]")
    public WebElement allowanceTypeE;
    @FindBy(xpath = "(//div[@class='col-md-4']//p[text()='Request Date']/following::p)[1]")
    public WebElement requestDateE;
    @FindBy(xpath = "(//div[@class='col-md-4']//p[text()='Employee Code']/following::p)[1]")
    public WebElement employeeCodeE;
    @FindBy(xpath = "(//div[@class='col-md-4']//p[text()='Workflow ID']/following::p)[1]")
    public WebElement workflowNum;
    @FindBy(xpath = "(//div[@class='col-md-4']//p[text()='From']/following::p)[1]")
    public WebElement fromE;
    @FindBy(xpath = "(//div[@class='col-md-4']//p[text()='To']/following::p)[1]")
    public WebElement toE;
    @FindBy(xpath = "(//div[@class='col-md-4']//p[text()='Notes']/following::p)[1]")
    public WebElement reasonE;
    @FindBy(xpath = "(//div[contains(@class, 'col-md-2')]//p[text()='Attachment']/following::p)[1]")
    public WebElement attachmentE;
    @FindBy(xpath = "(//div[@class='col-md-7']//p[text()='Amount']/following::p)[1]")
    public WebElement amountE;
    @FindBy(className = "icon-approval")
    WebElement workflowDetailsIcon;

    public boolean checkOvertimeType(String type){

        elementWaitAdvanced(By.id("overtime_entry"));
        clickOn(overtime_entry);
        hold(500);
        goToFrame(request_iframe);
        elementWaitAdvanced(By.id("display_button"));
        hold(500);
        helperToClickEnter.sendKeys(Keys.ENTER);
        hold(300);
        Select select = new Select(workTypeE);
        return select.getOptions().contains(type);

    }

    public void goToMassApproval(){

        elementWaitAdvanced(By.className("icon-approval"));
        hold(500);
        clickOn(massApproval);
        hold(300);

        setLog("go To Mass Approval");

    }

    public void goToTransactionByWorkflowID(String workflowID){

        hold(400);
        elementWaitAdvanced(By.id("WF_serial"));
        setText(workflowIdE, workflowID);
        hold(100);
        clickOn(displayBtn);
        hold(500);
        clickOn(getDriver().findElement(By.xpath("(//table[@id = 'requests-table']//tbody//td[text()='"+workflowID+"'])[1]")));
        hold(300);
        goToFrame(workflow_iframe);

        setLog("go To Transaction By Workflow ID: "+workflowID);

    }

    public void goToTransactionByEmployeeName(String employeeName){

        hold(400);
        elementWaitAdvanced(By.id("WF_serial"));
        setText(employeeNameE, employeeName);
        hold(100);
        clickOn(displayBtn);
        hold(500);
        clickOn(getDriver().findElement(By.xpath("(//table[@id = 'requests-table']//tbody//tr//td[2])[1]")));
        hold(300);
        goToFrame(workflow_iframe);

        setLog("go To Transaction By Employee Name: "+employeeName);

    }

    public void approveTransaction(){

        closeIFrame();
        goToFrame(workflow_iframe);
        clickOn(approveBtn);
        hold(500);
        alertWait();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        hold(1000);
        closeIFrame();

        setLog("approve Transaction");

    }

    public void declineTransaction(){

        closeIFrame();
        goToFrame(workflow_iframe);
        clickOn(declineBtn);
        hold(500);
        alertWait();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        hold(500);
        closeIFrame();

        setLog("decline Transaction");

    }
    public String getTransactionType(){
        return transactionTypeE.getText().trim();
    }
    public String getAllowanceType(){
        return allowanceTypeE.getText().trim();
    }
    public String getRequestDate(){
        return requestDateE.getText().trim();
    }
    public String getEmployeeCode(){
        return employeeCodeE.getText().trim();
    }
    public String getWorkflowID(){
        return workflowNum.getText().trim();
    }
    public String getFromDate(){
        return fromE.getText().trim();
    }
    public String getToDate(){
        return toE.getText().trim();
    }
    public String getAmount(){
        return amountE.getText().trim();
    }
    public String getReason(){
        return reasonE.getText().trim();
    }
    public String getAttachment(){
        scrollToElement(workflowDetailsIcon);
        return attachmentE.getText().trim();
    }

}
