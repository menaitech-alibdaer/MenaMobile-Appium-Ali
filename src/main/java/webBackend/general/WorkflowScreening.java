package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class WorkflowScreening extends WebBase {

    @FindBy(id = "wf_ref_filter")
    WebElement workflowIdE;
    @FindBy(id = "date1")
    WebElement dateFrom;
    @FindBy(id = "date2")
    WebElement dateTo;
    @FindBy(name = "go_filter")
    WebElement retrieveBtn;
    @FindBy(id = "body_frame")
    WebElement frame;
    @FindBy(id = "WF_screening_list")
    WebElement listFrame;
    @FindBy(xpath = "(//table[@class='reportTableNoBorder']//td[@class='td']//b[text()='Workflow ID']/following::span)[1]")
    WebElement WorkflowID_Details;
    @FindBy(xpath = "(//table[@class='reportTableNoBorder']//td[@class='td']//b[text()='Employee Code']/following::span)[1]")
    WebElement EmployeeCode_Details;
    @FindBy(xpath = "(//table[@class='reportTableNoBorder']//td[@class='td']//b[text()='Type']/following::span)[1]")
    WebElement Type_Details;
    @FindBy(xpath = "(//table[@class='reportTableNoBorder']//td[@class='td']//b[text()='Transaction Type']/following::span)[1]")
    WebElement TransactionType_Details;
    @FindBy(xpath = "(//table[@class='reportTableNoBorder']//td[@class='td']//b[text()='Requested for']/following::span)[1]")
    WebElement RequestedFor_Details;
    @FindBy(xpath = "(//table[@class='reportTableNoBorder']//td[@class='td']//b[text()='From']/following::span)[1]")
    WebElement From_Details;
    @FindBy(xpath = "(//table[@class='reportTableNoBorder']//td[@class='td']//b[text()='To']/following::span)[1]")
    WebElement To_Details;
    @FindBy(xpath = "(//table[@class='reportTableNoBorder']//td[@class='td']//b[text()='Amount']/following::span)[1]")
    WebElement Amount_Details;
    @FindBy(xpath = "(//table[@class='reportTableNoBorder']//td[@class='td']//b[text()='Request Date']/following::span)[1]")
    WebElement RequestDate_Details;
    @FindBy(xpath = "(//table[@class='reportTableNoBorder']//td[@class='td']//b[text()='Notes']/following::span)[1]")
    WebElement Notes_Details;
    @FindBy(xpath = "(//table[@class='collapsetable']//td//a)[3]")
    WebElement transactionRows;
    @FindBy(xpath = "//table[@class='collapsetable']//td[2]//a")
    WebElement requestDate_Table;
    @FindBy(xpath = "//table[@class='collapsetable']//td[3]//a")
    WebElement effectiveDate_Table;
    @FindBy(xpath = "//table[@class='collapsetable']//td[4]//a")
    WebElement empCode_Table;
    @FindBy(xpath = "//table[@class='collapsetable']//td[6]//a")
    WebElement transaction_Table;
    @FindBy(xpath = "//table[@class='collapsetable']//td[7]//a")
    WebElement transactionType_Table;
    @FindBy(xpath = "//table[@class='collapsetable']//td[9]//a")
    WebElement status_Table;
    @FindBy(linkText = "Workflow Status")
    WebElement workflowStatusTab;
    @FindBy(linkText = "Workflow Details")
    WebElement WorkflowDetailsTab;
    @FindBy(xpath = "//table[@class='CollapseScreen']//td[1]")
    WebElement code_Status;
    @FindBy(xpath = "//table[@class='CollapseScreen']//td[6]")
    WebElement status_Status;

    public void getTransactionByWorkflowId(String workflowID){

        goToFrame(frame);
        elementWaitAdvanced(By.id("wf_ref_filter"));
        setText(workflowIdE, workflowID);
        hold(200);
        dateFrom.clear();
        dateTo.clear();
        clickOn(retrieveBtn);
        hold(300);
        goToFrame(listFrame);
        hold(500);

        setLog("Workflow Screening");
        setLog("Get Transaction By Workflow ID: "+workflowID);

    }

    public void clickIOnTransaction(){

        clickOn(transactionRows);
        hold(300);
        setLog("click On Transaction");

    }

    public String getRequestDate(){
        return requestDate_Table.getText().trim();
    }
    public String getEffectiveDate(){
        return effectiveDate_Table.getText().trim();
    }
    public String getEmpCode(){
        return empCode_Table.getText().trim();
    }
    public String getTransaction(){
        return transaction_Table.getText().trim();
    }
    public String getTransactionType(){
        return transactionType_Table.getText().trim();
    }
    public String getStatus(){
        return status_Table.getText().trim();
    }
    public void goToWorkflowDetails(){
        closeIFrame();
        goToFrame(frame);
        clickOn(WorkflowDetailsTab);
    }

    public String details_WorkflowID(){
        return WorkflowID_Details.getText().trim();
    }
    public String details_EmployeeCode(){
        return EmployeeCode_Details.getText().trim();
    }
    public String details_TransactionType(){
        return TransactionType_Details.getText().trim();
    }
    public String details_RequestedFor(){
        return RequestedFor_Details.getText().trim();
    }
    public String details_Type(){
        return Type_Details.getText().trim();
    }
    public String details_From(){
        return From_Details.getText().trim();
    }
    public String details_To(){
        return To_Details.getText().trim();
    }
    public String details_RequestDate(){
        return RequestDate_Details.getText().trim();
    }
    public String details_Note(){
        return Notes_Details.getText().trim();
    }
    public String details_Amount(){
        return Amount_Details.getText().trim();
    }

    public void goToWorkflowStatus(){
        closeIFrame();
        goToFrame(frame);
        clickOn(workflowStatusTab);
    }

    public String status_Code(){
        return code_Status.getText().trim();
    }
    public String status_Status(){
        return status_Status.getText().trim();
    }


}
