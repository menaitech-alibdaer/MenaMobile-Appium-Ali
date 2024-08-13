package webBackend.mename;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class RequestsAndApprovals extends WebBase {

    @FindBy(xpath = "//div[contains(@class, 'icon-right-arrow')]")
    WebElement rightArrow;
    @FindBy(xpath = "//div[contains(@class, 'icon-left-arrow')]")
    WebElement leftArrow;
    @FindBy(xpath = "//a[contains(@href, 'allowance_requests_all.php')]")
    WebElement requestAllowance;
    @FindBy(xpath = "//a[contains(@href, 'allowance_update_all.php')]")
    WebElement updateAllowance;
    @FindBy(id = "add-request")
    WebElement newRequest;
    @FindBy(id = "request_iframe")
    WebElement requestFrame;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(id = "start_date")
    WebElement startDateE;
    @FindBy(id = "end_date")
    WebElement endDateE;
    @FindBy(id = "trans_internal_type_1")
    WebElement typeE;
    @FindBy(id = "Transaction_amount")
    WebElement amountE;
    @FindBy(id = "Support_documents")
    WebElement attachmentE;
    @FindBy(name = "notes")
    WebElement notesE;
    @FindBy(id = "send_request")
    WebElement sendForApprovalBtn;
    @FindBy(id = "display_btn")
    WebElement displayBtn;
    @FindBy(xpath = "//a[contains(@href, 'open_allowance_details')]")
    WebElement editBtn;
    @FindBy(id = "from_date_calendar")
    WebElement fromDateUpdateAllowanceE;
    @FindBy(id = "to_date_calendar")
    WebElement toDateUpdateAllowanceE;
    @FindBy(id = "amount")
    WebElement amount_updateAllowanceE;
    @FindBy(id = "end_date")
    WebElement to_updateAllowanceE;
    @FindBy(id = "save")
    WebElement save_updateAllowanceE;
    @FindBy(id = "close")
    WebElement close_updateAllowanceE;
    @FindBy(xpath = "//tr[contains(@onclick, 'getDetails')]")
    List<WebElement> requestAllowance_transactionList;
    @FindBy(xpath = "//tr[contains(@onclick, 'getDetails')]//td")
    List<WebElement> requestAllowance_transactionDetails;
    @FindBy(xpath = "(//div//p[text()='Workflow ID']/following::p)[1]")
    WebElement workflowId_details;
    @FindBy(xpath = "(//div//p[text()='Employee Code']/following::p)[1]")
    WebElement employeeCode_details;
    @FindBy(xpath = "(//div//p[text()='Transaction Type']/following::p)[1]")
    WebElement transactionType_details;
    @FindBy(xpath = "(//div//p[text()='Requested for']/following::p)[1]")
    WebElement requestFor_details;
    @FindBy(xpath = "(//div//p[text()='Request Date']/following::p)[1]")
    WebElement requestDate_details;
    @FindBy(xpath = "(//div//p[text()='Type']/following::p)[1]")
    WebElement type_details;
    @FindBy(xpath = "(//div//p[text()='From']/following::p)[1]")
    WebElement from_details;
    @FindBy(xpath = "(//div//p[text()='Amount']/following::p)[1]")
    WebElement amount_details;
    @FindBy(xpath = "(//div[@class='row pt-2'])[2]//div[contains(@class, 'col-md-2')][1]")
    WebElement managerName_ManagerDetails;
    @FindBy(xpath = "(//div[@class='row pt-2'])[2]//div[contains(@class, 'col-md-2')][2]")
    WebElement status_ManagerDetails;
    @FindBy(xpath = "(//div[@class='row pt-2'])[2]//div[contains(@class, 'col-md-2')][3]")
    WebElement sentDate_ManagerDetails;
    @FindBy(id = "rollback")
    WebElement withdrawBtn;
    @FindBy(id = "close-request")
    WebElement closeDetails;
    String parentWindow;

    public void newRequest(){

        elementWaitAdvanced(By.id("add-request"));
        clickOn(newRequest);
        hold(1500);
        goToFrame(requestFrame);

        setLog("click on new Request (+)");

    }

    public void goToAllowanceRequest(){

        elementWaitAdvanced(By.xpath("//div[contains(@class, 'icon-right-arrow')]"));

        clickOn(rightArrow);
        hold(200);
        clickOn(rightArrow);
        hold(200);
        clickOn(rightArrow);
        hold(200);
        clickOn(requestAllowance);

        elementWaitAdvanced(By.id("from_date"));

        setLog("Requests And Approvals - go To Allowance Request");

    }

    public void goToUpdateAllowance(){

        elementWaitAdvanced(By.xpath("//div[contains(@class, 'icon-right-arrow')]"));

        clickOn(rightArrow);
        hold(200);
        clickOn(rightArrow);
        hold(200);
        clickOn(updateAllowance);

        elementWaitAdvanced(By.id("employee_code"));

        setLog("Requests And Approvals - go To Update Allowance");

    }

    public void allowanceRequest(String employeeName, String startDate, String endDate,
                                 String type, String amount, boolean attachment, String notes){

        Select select = new Select(empCode);
        select.selectByVisibleText(employeeName);

        if(!startDate.isEmpty()){
            startDateE.clear();
            setText(startDateE, startDate);
            hold(100);
            setText(startDateE, Keys.ENTER);
        }

        if(!endDate.isEmpty()){
            endDateE.clear();
            setText(endDateE, endDate);
            hold(100);
            setText(endDateE, Keys.ENTER);
        }

        Select typeO = new Select(typeE);
        typeO.selectByVisibleText(type);
        hold(500);

        if(!amount.isEmpty()){
            hold(2000);
            amountE.clear();
            hold(200);
            setText(amountE, amount);
        }
        if(attachment){
            attachmentE.sendKeys(uploadRandomImage());
        }
        if(!notes.isEmpty()){
            notesE.clear();
            setText(notesE, notes);
        }

        clickOn(sendForApprovalBtn);
        closeIFrame();
        hold(300);

        setLog("Requests And Approvals - Allowance Request"
                +" - Employee Name: "+employeeName
                +" - startDate: "+startDate
                +" - endDate: "+endDate
                +" - type: "+type
                +" - amount: "+amount
                +" - with attachment: "+attachment
                +" - notes: "+notes);

    }

    public void updateAllowance(String employeeName, String to, String amount){

        fromDateUpdateAllowanceE.clear();
        hold(200);
        toDateUpdateAllowanceE.clear();
        hold(200);
        clickOn(displayBtn);
        hold(300);

        parentWindow = driver.getWindowHandle();
        clickOn(editBtn);
        hold(300);
        goToWindow();
        elementWaitAdvanced(By.id("amount"));
        if(!to.isEmpty()){
            to_updateAllowanceE.clear();
            hold(200);
            setText(to_updateAllowanceE, to, Keys.ENTER);
        }
        amount_updateAllowanceE.clear();
        hold(200);
        setText(amount_updateAllowanceE, amount);
        clickOn(save_updateAllowanceE);
        hold(500);
        clickOn(close_updateAllowanceE);
        backToParentWindow(parentWindow);
        hold(300);

        setLog("Requests And Approvals - Update Allowance"
                +" - Employee Name: "+employeeName
                +" - To: "+to
                +" - amount: "+amount);

    }

    public void openTransactionDetailsAfterRequest(){

        clickOn(requestAllowance_transactionList.get(0));
        hold(300);
        elementWaitAdvanced(By.id("rollback"));
        scrollToElement(withdrawBtn);

    }

    public void closeTransactionDetails(){

        clickOn(closeDetails);
        hold(500);

    }

    public String details_WorkflowID(){
        return workflowId_details.getText().trim();
    }
    public String details_EmployeeCode(){
        return employeeCode_details.getText().trim();
    }
    public String details_TransactionType(){
        return transactionType_details.getText().trim();
    }
    public String details_RequestedFor(){
        return requestFor_details.getText().trim();
    }
    public String details_RequestDate(){
        return requestDate_details.getText().trim();
    }
    public String details_Type(){
        return type_details.getText().trim();
    }
    public String details_From(){
        return from_details.getText().trim();
    }
    public String details_Amount(){
        return amount_details.getText().trim();
    }
    public boolean details_WithdrawButton(){
        return withdrawBtn.isDisplayed();
    }
    public String details_ManagerName(){
        return managerName_ManagerDetails.getText().trim();
    }
    public String details_Status_Manager(){
        return status_ManagerDetails.getText().trim();
    }
    public String details_sentDate_Manager(){
        return sentDate_ManagerDetails.getText().trim();
    }

    public String getRequestDate(){
        return requestAllowance_transactionDetails.get(0).getText().trim();
    }
    public String getType(){
        return requestAllowance_transactionDetails.get(1).getText().trim();
    }
    public String getAmount(){
        return requestAllowance_transactionDetails.get(2).getText().trim();
    }
    public String getFrom(){
        return requestAllowance_transactionDetails.get(3).getText().trim();
    }
    public String getStatus(){
        return requestAllowance_transactionDetails.get(5).getText().trim();
    }
    public String getNote(){
        return requestAllowance_transactionDetails.get(6).getText().trim();
    }


}
