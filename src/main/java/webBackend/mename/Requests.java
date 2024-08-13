package webBackend.mename;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;
import static utilities.MssqlConnect.liteVersion;
import static utilities.VersionGetter.liteGetter;

public class Requests extends WebBase {

    @FindBy(xpath = "//div[contains(@class, 'icon-right-arrow')]")
    WebElement rightArrow;
    @FindBy(xpath = "//div[contains(@class, 'icon-left-arrow')]")
    WebElement leftArrow;
    @FindBy(xpath = "//a[contains(@href, 'overtime_requests_all.php')]")
    WebElement overtime;
    @FindBy(xpath = "//a[contains(@href, 'loan_requests_all.php')]")
    WebElement loans;
    @FindBy(xpath = "//a[contains(@href, 'allowance_requests_all.php')]")
    WebElement allowance;
    @FindBy(id = "add-request")
    WebElement newRequest;
    @FindBy(xpath = "//div[@id='modalRequest']//button[@class='close' and @aria-label='Close']")
    WebElement closeModalRequest;
    @FindBy(id = "overtime_date")
    WebElement overtimeDate;
    @FindBy(name = "loan_date")
    public WebElement loanDate;
    @FindBy(name = "trans_internal_type")
    WebElement transactionType;
    @FindBy(name = "Transaction_period")
    WebElement noOfPaymentsE;
    @FindBy(name = "Transaction_amount")
    WebElement amountE;
    @FindBy(id = "trans_internal_type")
    public WebElement overtimeType;
    @FindBy(id = "status_1")
    WebElement status_1;
    @FindBy(name = "f_hour")
    WebElement fromH;
    @FindBy(name = "f_AmPm")
    WebElement f_AmPm;
    @FindBy(name = "t_AmPm")
    WebElement t_AmPm;
    @FindBy(name = "t_hour")
    WebElement toH;
    @FindBy(id = "send_request")
    WebElement send_request;
    @FindBy(xpath = "(//p[text() = 'Workflow ID']/following::p)[1]")
    WebElement workflowID;
    @FindBy(xpath = "(//p[text() = 'Attachment']/following::p)[1]")
    WebElement attachmentName;
    @FindBy(id = "request_iframe")
    WebElement requestFrame;
    @FindBy(id = "start_date")
    WebElement startDateE;
    @FindBy(id = "end_date")
    WebElement endDateE;
    @FindBy(name = "trans_internal_type")
    WebElement allowanceType;
    @FindBy(id = "Transaction_amount")
    public WebElement trans_Amount;
    @FindBy(id = "Support_documents")
    WebElement attachmentE;
    @FindBy(id = "rollback")
    WebElement withdrawBtn;
    @FindBy(id = "notes")
    WebElement reasonE;
    @FindBy(id = "row_1")
    WebElement row1;
    @FindBy(id = "profile-buttom-dropdown")
    WebElement profile_buttom_dropdown;


    public void goToOvertime(){

        elementWaitAdvanced(By.xpath("//div[contains(@class, 'icon-right-arrow')]"));

        if(!liteGetter()){
            clickOn(rightArrow);
            hold(300);
            clickOn(overtime);
        }else{
            hold(300);
            clickOn(overtime);
        }

        elementWaitAdvanced(By.xpath("//form[@action='overtime_requests_all.php']"));

        setLog("Go To Overtime");

    }

    public void goToLoans(){

        elementWaitAdvanced(By.xpath("//div[contains(@class, 'icon-right-arrow')]"));

        hold(300);
        clickOn(loans);

        elementWaitAdvanced(By.xpath("//form[@action='loan_requests_all.php']"));

        setLog("Go To Loans");

    }

    public void overtimeRequest(String date, String type, String from, String fromAmPm, String to, String toAmPm){

        clickOn(newRequest);
        hold(300);
        goToFrame(requestFrame);
        hold(500);
        elementWaitAdvanced(By.id("overtime_date"));
        if(!date.isEmpty()){
            overtimeDate.clear();
            hold(200);
            setText(overtimeDate, date);
        }
        Select selectType = new Select(overtimeType);
        selectType.selectByVisibleText(type);
        Select selectFrom = new Select(fromH);
        selectFrom.selectByVisibleText(from);
        Select selectFromAmPm = new Select(f_AmPm);
        selectFromAmPm.selectByVisibleText(fromAmPm);
        Select selectTo = new Select(toH);
        selectTo.selectByVisibleText(to);
        Select selectToAmPm = new Select(t_AmPm);
        selectToAmPm.selectByVisibleText(toAmPm);
        hold(300);
        clickOn(send_request);
        hold(300);

        setLog("Overtime Request"
        +" - date: "+date
        +" - type: "+type
        +" - from: "+from
        +" - from Am Pm"+fromAmPm
        +" - to: "+to
        +" - to Am Pm: "+toAmPm);

    }

    public void overtimeRequest(String date, String type, String from, String fromAmPm, String to, String toAmPm, boolean withoutSend){

        clickOn(newRequest);
        hold(300);
        goToFrame(requestFrame);
        hold(500);
        elementWaitAdvanced(By.id("overtime_date"));
        if(!date.isEmpty()){
            overtimeDate.clear();
            hold(200);
            setText(overtimeDate, date, Keys.TAB);
        }
        if(!type.isEmpty()){
            Select selectType = new Select(overtimeType);
            selectType.selectByVisibleText(type);
        }
        if(!from.isEmpty()){
            Select selectFrom = new Select(fromH);
            selectFrom.selectByVisibleText(from);
        }
        if(!fromAmPm.isEmpty()){
            Select selectFromAmPm = new Select(f_AmPm);
            selectFromAmPm.selectByVisibleText(fromAmPm);
        }
        if(!to.isEmpty()){
            Select selectTo = new Select(toH);
            selectTo.selectByVisibleText(to);
        }
        if(!toAmPm.isEmpty()){
            Select selectToAmPm = new Select(t_AmPm);
            selectToAmPm.selectByVisibleText(toAmPm);
        }
        if(!withoutSend){
            hold(300);
            clickOn(send_request);
            hold(300);
        }

        hold(500);

        setLog("Overtime Request"
                +" - date: "+date
                +" - type: "+type
                +" - from: "+from
                +" - from Am Pm"+fromAmPm
                +" - to: "+to
                +" - to Am Pm: "+toAmPm);

    }

    public void loanRequest(String type, String date, String noOfPayments, String amount, boolean sendForApproval){

        clickOn(newRequest);
        hold(300);
        goToFrame(requestFrame);
        hold(500);
        elementWaitAdvanced(By.name("loan_date"));
        if(!type.isEmpty()){
            Select selectType = new Select(transactionType);
            selectType.selectByVisibleText(type);
            hold(1000);
        }
        if(!date.isEmpty()){
            loanDate.clear();
            hold(200);
            setText(loanDate, date, Keys.TAB);
        }
        if(!noOfPayments.isEmpty()){
            setText(noOfPaymentsE, noOfPayments);
            hold(200);
        }
        if(!amount.isEmpty()){
            setText(amountE, amount);
            hold(200);
        }
        if(sendForApproval){
            hold(300);
            clickOn(send_request);
            hold(300);
        }

        hold(500);

        setLog("Loans Request"
                +" - date: "+date
                +" - type: "+type
                +" - NO. Of Payments: "+noOfPayments
                +" - Amount"+amount
                +" - Send For Approval: "+sendForApproval);

    }

    public void newRequest(){

        clickOn(newRequest);
        hold(1500);
        goToFrame(requestFrame);

        setLog("click on new Request (+)");

    }

    public boolean checkOvertimeType(String type){

        hold(300);
        Select selectType = new Select(overtimeType);
        List<WebElement> options = selectType.getOptions();
        boolean check = false;
        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(type)) {
                check = true;
            }
        }
        return check;

    }

    public boolean checkType(String type){

        hold(300);
        Select selectType = new Select(transactionType);
        List<WebElement> options = selectType.getOptions();
        boolean check = false;
        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(type)) {
                check = true;
            }
        }
        return check;

    }

    public String getRequestStatus(){
        closeIFrame();
        hold(300);
        elementWaitAdvanced(By.id("status_1"));
        return status_1.getText().trim();
    }
    public void closeModalRequest(){
        closeIFrame();
        clickOn(closeModalRequest);
    }

    public void goToAllowance(){
        elementWaitAdvanced(By.xpath("//div[contains(@class, 'icon-right-arrow')]"));

        clickOn(rightArrow);
        hold(300);
        clickOn(allowance);

        setLog("go To Allowance");

        elementWaitAdvanced(By.xpath("//form[@action='allowance_requests_all.php']"));
    }
    public void allowanceRequest(String startDate, String endDate, String type, String amount, boolean attachment, String reason){

        clickOn(newRequest);
        hold(300);
        goToFrame(requestFrame);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        if(!startDate.isEmpty()){
            startDateE.clear();
            hold(100);
            setText(startDateE, startDate, Keys.ENTER);
        }
        if(!endDate.isEmpty()){
            endDateE.clear();
            hold(100);
            setText(endDateE, endDate, Keys.ENTER);
        }
        if(!type.isEmpty()){
            hold(200);
           Select select = new Select(allowanceType);
           select.selectByVisibleText(type);
        }
        if(!amount.isEmpty()){
            hold(500);
            waitElementClickable(trans_Amount);
            trans_Amount.clear();
            hold(100);
            setText(trans_Amount, amount);
        }
        if(attachment){
            attachmentE.sendKeys(uploadRandomImage());
        }
        if(!reason.isEmpty()){
            reasonE.clear();
            hold(100);
            setText(reasonE, reason);
        }

        clickOn(send_request);
        closeIFrame();
        hold(300);

        setLog("Allowance Request"
        +" - startDate: "+startDate
        +" - endDate: "+endDate
        +" - type: "+type
        +" - amount: "+amount
        +" - with attachment: "+attachment
        +" - reason: "+reason);

    }

    public void allowanceRequest(String startDate, String endDate, String type, String amount, boolean attachment, String reason, boolean NotSend){

        clickOn(newRequest);
        hold(300);
        goToFrame(requestFrame);
        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        if(!startDate.isEmpty()){
            startDateE.clear();
            hold(100);
            setText(startDateE, startDate);
        }
        if(!endDate.isEmpty()){
            endDateE.clear();
            hold(100);
            setText(endDateE, endDate);
        }
        if(!type.isEmpty()){
            hold(200);
            Select select = new Select(allowanceType);
            select.selectByVisibleText(type);
        }
        if(!amount.isEmpty()){
            trans_Amount.clear();
            hold(100);
            setText(trans_Amount, amount);
        }
        if(attachment){
            attachmentE.sendKeys(uploadRandomImage());
        }
        if(!reason.isEmpty()){
            reasonE.clear();
            hold(100);
            setText(reasonE, reason);
        }

        if(!NotSend){
            clickOn(send_request);
            closeIFrame();
            hold(300);
        }

        setLog("Allowance Request"
                +" - startDate: "+startDate
                +" - endDate: "+endDate
                +" - type: "+type
                +" - amount: "+amount
                +" - with attachment: "+attachment
                +" - reason: "+reason);

    }

    public boolean checkAllowanceType(String type){

        hold(300);
        Select selectType = new Select(allowanceType);
        List<WebElement> options = selectType.getOptions();
        boolean check = false;
        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(type)) {
                check = true;
            }
        }
        return check;

    }

    public void openRequestDetails(String rowNumber){
        hold(500);
        elementWaitAdvanced(By.id("row_1"));
        clickOn(getDriver().findElement(By.xpath("//tr[contains(@id, 'row_"+rowNumber+"')]")));
        hold(300);

        setLog("open Request Details");
    }

    public String getWorkflowID(){

        hold(200);
        elementWaitAdvanced(By.id("close-request"));
        return workflowID.getText().trim();

    }

    public String getAttachmentFileName(){

        hold(200);
        elementWaitAdvanced(By.id("close-request"));
        scrollToElement(withdrawBtn);
        String att = attachmentName.getText().trim();
        scrollToElement(profile_buttom_dropdown);
        return att;

    }



}
