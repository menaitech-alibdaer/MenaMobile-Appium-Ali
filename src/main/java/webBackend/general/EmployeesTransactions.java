package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class EmployeesTransactions extends WebBase {

    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "MenuNewButton")
    WebElement menuNew;
    @FindBy(name = "new")
    WebElement addBtn;
    @FindBy(name = "save")
    WebElement saveBtn;
    @FindBy(name = "exit")
    WebElement exitBtn;
    @FindBy(id = "employee_code_0")
    WebElement guarantor_employeeCode;
    @FindBy(name = "guarantor_code[0]")
    WebElement guarantorEmployee1;
    @FindBy(id = "MenuPostButton")
    WebElement menuPost;
    @FindBy(id = "MenuDeleteButton")
    WebElement menuDelete;
    @FindBy(name = "checkbox[1]")
    WebElement checkboxSalaryRaise;
    @FindBy(name = "checkbox[1]")
    public WebElement checkboxE1;
    @FindBy(name = "Button2")
    WebElement Button2;
    @FindBy(name = "guarantor")
    public WebElement guarantorBtn;
    @FindBy(name = "rschedual")
    public WebElement rescheduleLoanBtn;
    @FindBy(name = "not_paid_dues")
    WebElement numberOfRemainingInstallmentsE;
    @FindBy(name = "due_resume_date")
    WebElement installmentsRescheduleStartDateE;
    @FindBy(name = "months_between_installments")
    WebElement installmentsMonthsSpan_rescheduleLoan;
    @FindBy(xpath = "//input[contains(@name, 'due_date')]")
    List<WebElement> dueDate_list;
    @FindBy(xpath = "//input[contains(@name, 'due_amount')]")
    List<WebElement> dueAmount_list;
    @FindBy(name = "amount_all")
    WebElement totalAmount_loan;
    @FindBy(name = "checkall")
    WebElement checkAll;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(xpath = "(//input[contains(@id, 'transaction_date')])[last()]")
    WebElement dateE;
    @FindBy(xpath = "(//input[contains(@name, 'btn_a')])[last()]")
    WebElement vacationInAdvanceBtn;
    @FindBy(name = "calc")
    WebElement vacationInAdvanceCalculateBtn;
    @FindBy(xpath = "(//input[contains(@id, 'transaction_end_date')])[last()]")
    WebElement toDateE;
    @FindBy(xpath = "(//select[contains(@name, 'transaction_internal_type')])[last()]")
    public WebElement typeE;
    @FindBy(xpath = "(//select[contains(@name, 'income_extra_salary')])[last()]")
    public WebElement incomeExtraE;
    @FindBy(xpath = "(//select[contains(@name, 'deduction_extra_salary')])[last()]")
    public WebElement deductionExtraE;
    @FindBy(xpath = "(//select[contains(@name, 'repeted_flag')])[last()]")
    public WebElement repeted_flagE;
    @FindBy(xpath = "(//input[contains(@name, 'transaction_amount[')])[last()]")
    public WebElement amountE;
    @FindBy(xpath = "(//input[contains(@name, 'transaction_period[')])[last()]")
    WebElement installmentsE;
    @FindBy(name = "benifit_trans_type[1]")
    WebElement benefitTransactionE1;
    @FindBy(name = "transaction_amount[1]")
    WebElement raiseAmountE1;
    @FindBy(xpath = "(//select[contains(@name, 'allowance_trans_type')])[last()]")
    WebElement allowanceTransactionE;
    @FindBy(xpath = "(//input[contains(@name, 'trans_descreption')])[last()]")
    WebElement noteE;
    @FindBy(xpath = "(//img[contains(@name, 'details')])[last()]")
    WebElement allowancesAttachmentE;
    @FindBy(id = "MenaBox_iframe")
    WebElement boxFrame;
    @FindBy(id = "attachment_type")
    WebElement attachment_typeE;
    @FindBy(id = "Support_documents")
    WebElement uploadAttachmentE;
    @FindBy(name = "submitsave")
    WebElement submitSave;
    @FindBy(name = "exit")
    WebElement exitBox;
    @FindBy(id = "menaSalarySelected")
    WebElement salaryRaiseTab;
    @FindBy(id = "menaAllowancesTransSelected")
    WebElement allowancesTransactionsTab;
    @FindBy(xpath = "//a[contains(@href, 'go_trans_leaves_vacation')]")
    WebElement vacationTab;
    @FindBy(xpath = "//a[contains(@href, 'go_trans_leaves_compensation')]")
    WebElement vacationsCompensationTab;
    @FindBy(xpath = "//a[contains(@href, 'go_non_pay_benifits_trans()')]")
    WebElement nonPayrollBenefitTransactionsTab;
    @FindBy(id = "menaAllowanceSelected")
    WebElement allowanceRaiseTab;
    @FindBy(xpath = "//a[contains(@href, 'go_trans_hourlyleaves()')]")
    WebElement leaveTab;
    @FindBy(xpath = "//a[contains(@href, 'go_trans_otherdeductions()')]")
    WebElement otherDeductionsTab;
    @FindBy(xpath = "//a[contains(@href, 'go_trans_loans()')]")
    WebElement loans;
    @FindBy(xpath = "//a[contains(@href, 'go_trans_otherincomes()')]")
    WebElement otherIncomeTab;
    @FindBy(xpath = "//a[contains(@href, 'go_trans_overtime()')]")
    WebElement overtimeTab;
    @FindBy(xpath = "(//input[contains(@id, 'transaction_period_')])[last()]")
    WebElement hourE;
    @FindBy(xpath = "(//input[contains(@id, 'transaction_period_')])[last()]")
    WebElement daysE;
    @FindBy(name = "transaction_amount[1]")
    public WebElement transactionAmount;
    @FindBy(name = "transaction_amount[2]")
    public WebElement transactionAmount2;
    @FindBy(name = "transaction_amount[3]")
    public WebElement transactionAmount3;
    @FindBy(xpath = "//input[contains(@name, 'checkbox')]")
    public List <WebElement> numberOfRecords;
    public String checkAttachment;
    public Alert checkAlert = null;
    String parentWindow;


    public void salaryRaise(String employeeCode, String raiseDate, String raiseType, String raiseAmount, String raiseNote){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(salaryRaiseTab);
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!raiseDate.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, raiseDate);
        }
        Select select = new Select(typeE);
        select.selectByVisibleText(raiseType);
        raiseAmountE1.clear();
        hold(300);
        setText(raiseAmountE1, raiseAmount);
        setText(noteE, raiseNote);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);
        elementWaitAdvanced(By.name("checkbox[1]"));
        clickOn(checkboxSalaryRaise);
        hold(400);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(3500);
        closeIFrame();

        setLog("Salary Raise Transaction"+" - Employee Code: "+ employeeCode+" - Raise Type: "+raiseType+" - Raise Amount: "+raiseAmount);

    }

    public void allowanceRaise(String employeeCode, String raiseDate, String allowanceType, String raiseAmount, String raiseNote){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(allowanceRaiseTab);
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!raiseDate.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, raiseDate);
        }
        Select select = new Select(typeE);
        select.selectByVisibleText(allowanceType);
        raiseAmountE1.clear();
        hold(300);
        setText(raiseAmountE1, raiseAmount);
        setText(noteE, raiseNote);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);
        elementWaitAdvanced(By.name("checkall"));
        clickOn(checkAll);
        hold(400);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(3500);
        closeIFrame();

        setLog("Allowance Raise Transaction"+" - Employee Code: "+ employeeCode+" - Allowance Type: "+allowanceType+" - Raise Amount: "+raiseAmount);


    }

    public void allowancesTransactions(String employeeCode, String date, String allowanceType, String allowanceTransaction, String note, boolean attachment){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(allowancesTransactionsTab);
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!date.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, date);
        }
        Select type = new Select(typeE);
        type.selectByVisibleText(allowanceType);
        Select transaction = new Select(allowanceTransactionE);
        transaction.selectByVisibleText(allowanceTransaction);
        if(!note.isEmpty()){
            setText(noteE, note);
        }
        if(attachment){
            clickOn(allowancesAttachmentE);
            hold(500);
            closeIFrame();
            goToFrame(boxFrame);
            Select attach = new Select(attachment_typeE);
            attach.selectByVisibleText("Other");
            hold(500);
            uploadAttachmentE.sendKeys(uploadRandomImage());
            hold(200);
            clickOn(submitSave);
            hold(500);
            clickOn(exitBox);
            backToParentIFrame();
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);
        elementWaitAdvanced(By.name("checkbox[1]"));
        clickOn(checkboxE1);
        hold(400);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(3500);
        closeIFrame();

        setLog("Allowance Transaction"+" - Employee Code: "+ employeeCode+" - Allowance Type: "+allowanceType+" - allowance Transaction: "+allowanceTransaction);

    }

    public void allowancesTransactions(String employeeCode, String date, String allowanceType, String allowanceTransaction, String note, boolean attachment, boolean checkValidation){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(allowancesTransactionsTab);
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!date.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, date);
        }
        Select type = new Select(typeE);
        type.selectByVisibleText(allowanceType);
        Select transaction = new Select(allowanceTransactionE);
        transaction.selectByVisibleText(allowanceTransaction);
        if(!note.isEmpty()){
            setText(noteE, note);
        }
        if(attachment){
            clickOn(allowancesAttachmentE);
            hold(500);
            closeIFrame();
            goToFrame(boxFrame);
            Select attach = new Select(attachment_typeE);
            attach.selectByVisibleText("Other");
            hold(500);
            uploadAttachmentE.sendKeys(uploadRandomImage());
            hold(200);
            clickOn(submitSave);
            hold(500);
            clickOn(exitBox);
            backToParentIFrame();
        }
        closeIFrame();
        if(checkValidation){

            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            hold(300);
            checkAlert = driver.switchTo().alert();

        }else{

            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            closeIFrame();
            goToFrame(bodyFrame);
            hold(1500);
            elementWaitAdvanced(By.name("checkbox[1]"));
            clickOn(checkboxE1);
            hold(400);
            closeIFrame();
            goToFrame(menuFrame);
            clickOn(menuPost);
            hold(500);
            alertWait();
            Alert alert = driver.switchTo().alert();
            hold(500);
            alert.accept();
            hold(3500);
            closeIFrame();

            setLog("Allowance Transaction"+" - Employee Code: "+ employeeCode+" - Allowance Type: "+allowanceType+" - allowance Transaction: "+allowanceTransaction);

        }

    }

    public void nonPayrollBenefitTransactions(String employeeCode, String date, String benefitType, String benefitTransaction, String note){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(nonPayrollBenefitTransactionsTab);
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!date.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, date);
        }
        Select type = new Select(typeE);
        type.selectByVisibleText(benefitType);
        Select transaction = new Select(benefitTransactionE1);
        transaction.selectByVisibleText(benefitTransaction);
        if(!note.isEmpty()){
            setText(noteE, note);
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);
        elementWaitAdvanced(By.name("checkbox[1]"));
        clickOn(checkboxE1);
        hold(400);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(3500);
        closeIFrame();

        setLog("non Payroll Benefit Transactions"+" - Employee Code: "+ employeeCode+" - benefit Type: "+benefitType+" - benefit Transaction: "+benefitTransaction);

    }

    public void otherIncome(String employeeCode, String date,String extra, String TransactionType, String amount, String note){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(otherIncomeTab);
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!date.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, date);
        }
        if(!extra.isEmpty()){
            Select type = new Select(incomeExtraE);
            type.selectByVisibleText(extra);
        }
        Select type = new Select(typeE);
        type.selectByVisibleText(TransactionType);
        if(!amount.isEmpty()){
            amountE.clear();
            hold(200);
            setText(amountE, amount);
        }
        if(!note.isEmpty()){
            setText(noteE, note);
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);
        elementWaitAdvanced(By.name("checkbox[1]"));
        clickOn(checkAll);
        hold(400);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(3500);
        closeIFrame();

        setLog("other Income"+" - Employee Code: "+ employeeCode+" - Date: "+date+" - Transaction Type: "+TransactionType+" - amount: "+amount);

    }

    public void otherDeductions(String employeeCode, String date, String extra, String toDate, String TransactionType, String amount, String deductionType, String note, boolean post){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(otherDeductionsTab);
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!date.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, date);
        }
        if(!toDate.isEmpty()){
            toDateE.clear();
            hold(300);
            setText(toDateE, toDate);
        }
        if(!extra.isEmpty()){
            Select type = new Select(deductionExtraE);
            type.selectByVisibleText(extra);
        }
        Select type = new Select(typeE);
        type.selectByVisibleText(TransactionType);
        if(!amount.isEmpty()){
            amountE.clear();
            hold(200);
            setText(amountE, amount);
        }
        if(!deductionType.isEmpty()){
            Select dedType = new Select(repeted_flagE);
            dedType.selectByVisibleText(deductionType);
        }
        if(!note.isEmpty()){
            setText(noteE, note);
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);

        if(post){
            closeIFrame();
            goToFrame(bodyFrame);
            hold(1500);
            elementWaitAdvanced(By.name("checkbox[1]"));
            clickOn(checkAll);
            hold(400);
            closeIFrame();
            goToFrame(menuFrame);
            clickOn(menuPost);
            hold(500);
            alertWait();
            Alert alert = driver.switchTo().alert();
            hold(500);
            alert.accept();
            hold(3500);
            closeIFrame();
        }

        setLog("other Deductions"+" - Employee Code: "+ employeeCode+" - Date: "+date+" - Transaction Type: "+TransactionType+" - amount: "+amount+" - deduction Type: "+deductionType);

    }

    public void loans(String employeeCode, String date, String loanType, String amount, String installments, String note){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(loans);
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!date.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, date);
        }

        Select type = new Select(typeE);
        type.selectByVisibleText(loanType);
        setText(typeE, Keys.TAB);
        hold(3000);

        if(!amount.isEmpty()){
            amountE.clear();
            hold(500);
            amountE.clear();
            hold(200);
            setText(amountE, amount, Keys.TAB);
            hold(300);
        }
        if(!installments.isEmpty()){
            installmentsE.clear();
            hold(200);
            setText(installmentsE, installments, Keys.TAB);
            hold(300);
        }
        if(!note.isEmpty()){
            setText(noteE, note);
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);
        elementWaitAdvanced(By.name("checkbox[1]"));
        clickOn(checkAll);
        hold(400);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(3500);
        closeIFrame();

        setLog("Loans Transaction"+" - Employee Code: "+ employeeCode+" - Date: "+date+" - Loan Type: "+loanType+" - amount: "+amount+" - installments: "+installments+" - Note: "+note);

    }

    public void loans(String employeeCode, String date, String loanType, String amount, String installments, String note, boolean post){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(loans);
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!date.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, date);
        }

        Select type = new Select(typeE);
        type.selectByVisibleText(loanType);
        setText(typeE, Keys.TAB);
        hold(3000);

        if(!amount.isEmpty()){
            amountE.clear();
            hold(500);
            amountE.clear();
            hold(200);
            setText(amountE, amount, Keys.TAB);
            hold(300);
        }
        if(!installments.isEmpty()){
            installmentsE.clear();
            hold(200);
            setText(installmentsE, installments, Keys.TAB);
            hold(300);
        }
        if(!note.isEmpty()){
            setText(noteE, note);
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);
        if(post){
            elementWaitAdvanced(By.name("checkbox[1]"));
            clickOn(checkAll);
            hold(400);
            closeIFrame();
            goToFrame(menuFrame);
            clickOn(menuPost);
            hold(500);
            alertWait();
            Alert alert = driver.switchTo().alert();
            hold(500);
            alert.accept();
            hold(3500);
            closeIFrame();
        }

        setLog("Loans Transaction"+" - Employee Code: "+ employeeCode+" - Date: "+date+" - Loan Type: "+loanType+" - amount: "+amount+" - installments: "+installments+" - Note: "+note+" - Post"+post);

    }

    public void loanGuarantors(String employeeCode){

        elementWaitAdvanced(By.name("guarantor"));
        clickOn(guarantorBtn);
        hold(500);
        closeIFrame();
        parentWindow = driver.getWindowHandle();
        goToWindow();
        hold(500);
        elementWait(addBtn);
        clickOn(addBtn);
        hold(300);
        setText(guarantor_employeeCode, employeeCode, Keys.TAB);
        hold(3000);
        clickOn(saveBtn);
        hold(500);
        elementWaitAdvanced(By.name("checkbox[0]"));
        clickOn(exitBtn);
        hold(200);
        backToParentWindow(parentWindow);
        goToFrame(bodyFrame);

    }

    public String getGuarantorEmployeeCode(){
        return guarantorEmployee1.getAttribute("value");
    }

    public String getTotalAmountLoan(){
        return totalAmount_loan.getAttribute("value");
    }

    public void openLoanGuarantors(){
        clickOn(guarantorBtn);
        hold(500);
        closeIFrame();
        parentWindow = driver.getWindowHandle();
        goToWindow();
        hold(500);
    }

    public void openLoanSettings(){
        clickOn(Button2);
        hold(500);
    }

    public void rescheduleLoan(String numberOfRemainingInstallments, String installmentsRescheduleStartDate,
                               String installmentsMonthsSpan){
        clickOn(rescheduleLoanBtn);
        hold(500);
        closeIFrame();
        goToFrame(boxFrame);
        elementWait(numberOfRemainingInstallmentsE);
        if(!numberOfRemainingInstallments.isEmpty()){
            numberOfRemainingInstallmentsE.clear();
            hold(200);
            setText(numberOfRemainingInstallmentsE, numberOfRemainingInstallments);
        }
        if(!installmentsRescheduleStartDate.isEmpty()){
            installmentsRescheduleStartDateE.clear();
            hold(200);
            setText(installmentsRescheduleStartDateE, installmentsRescheduleStartDate);
        }
        if(!installmentsMonthsSpan.isEmpty()){
            normalSelect(installmentsMonthsSpan_rescheduleLoan, installmentsMonthsSpan);
            hold(200);
        }
        clickOn(saveBtn);
        hold(1000);
        clickOn(exitBtn);
        closeIFrame();
        goToFrame(bodyFrame);

    }

    public String getNumberOfInstallmentsRecord(){
        return String.valueOf(dueDate_list.size());
    }
    public String getNumberOfInstallments(){
        return installmentsE.getAttribute("value");
    }

    public String dueDate_loan(int index){
        return dueDate_list.get(index).getAttribute("value");
    }
    public String dueAmount_loan(int index){
        return dueAmount_list.get(index).getAttribute("value");
    }

    public void goToOtherDeductions(String employeeCode){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(otherDeductionsTab);
        hold(300);
        empCode.clear();
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);

        setLog("Go To Other Deductions");

    }

    public void goToOtherIncome(String employeeCode){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(otherIncomeTab);
        hold(300);
        empCode.clear();
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);

        setLog("Go To Other Income");

    }

    public void goToVacation(){
        goToFrame(bodyFrame);
        hold(300);
        clickOn(vacationTab);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
    }

    ///////////////// Leave Transactions ////////////////

    public void leave(String employeeCode, String date, String leaveType, String hours){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(leaveTab);
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!date.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, date);
        }
        Select select = new Select(typeE);
        select.selectByVisibleText(leaveType);
        hourE.clear();
        hold(300);
        setText(hourE, hours);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);
        elementWaitAdvanced(By.name("checkbox[1]"));
        clickOn(checkboxSalaryRaise);
        hold(400);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(3500);
        closeIFrame();

        setLog("Leave Transaction"+" - Employee Code: "+ employeeCode+" - Date: "+date+" - Leave Type: "+leaveType+" - hours: "+hours);

    }

    public void overtime(String employeeCode, String date, String overtimeType, String hours){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!date.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, date);
        }
        Select select = new Select(typeE);
        select.selectByVisibleText(overtimeType);
        hourE.clear();
        hold(300);
        setText(hourE, hours);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);
        elementWaitAdvanced(By.name("checkbox[1]"));
        clickOn(checkboxSalaryRaise);
        hold(400);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(3500);
        closeIFrame();

        setLog("Overtime Transaction"+" - Employee Code: "+ employeeCode+" - Date: "+date+" - Overtime Type: "+overtimeType+" - hours: "+hours);

    }

    public void overtime(String employeeCode, String date, String overtimeType, String hours, boolean post){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        empCode.clear();
        hold(200);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!date.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, date);
        }
        Select select = new Select(typeE);
        select.selectByVisibleText(overtimeType);
        hourE.clear();
        hold(300);
        setText(hourE, hours);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);

        if(post){
            elementWaitAdvanced(By.name("checkbox[1]"));
            clickOn(checkboxE1);
            hold(400);
            closeIFrame();
            goToFrame(menuFrame);
            clickOn(menuPost);
            hold(500);
            alertWait();
            Alert alert = driver.switchTo().alert();
            hold(500);
            alert.accept();
            hold(3500);
            closeIFrame();
        }

        setLog("Overtime Transaction"+" - Employee Code: "+ employeeCode+" - Date: "+date+" - Overtime Type: "+overtimeType+" - hours: "+hours);

    }

    public void overtime(String date, String overtimeType, String hours, boolean post){

        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        if(!date.isEmpty()){
            dateE.clear();
            hold(300);
            setText(dateE, date);
        }
        Select select = new Select(typeE);
        select.selectByVisibleText(overtimeType);
        hourE.clear();
        hold(300);
        setText(hourE, hours, Keys.TAB);
        hold(300);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);

        if(post){
            elementWaitAdvanced(By.name("checkbox[1]"));
            clickOn(checkAll);
            hold(400);
            closeIFrame();
            goToFrame(menuFrame);
            clickOn(menuPost);
            hold(500);
            alertWait();
            Alert alert = driver.switchTo().alert();
            hold(500);
            alert.accept();
            hold(3500);
            closeIFrame();
        }

        setLog("Overtime Transaction"+" - Date: "+date+" - Overtime Type: "+overtimeType+" - hours: "+hours);
    }

    public boolean checkAlert(String textAlert){

        boolean check = false;
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        if(textAlert.equalsIgnoreCase(alert.getText().trim())){
            check = true;
        }
        alert.accept();
        hold(1500);
        return check;

    }

    public void postTransactions(String employeeCode){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        elementWaitAdvanced(By.name("checkbox[1]"));
        clickOn(checkAll);
        hold(400);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(3500);
        closeIFrame();

        setLog("Post the Transactions"+" - Employee Code: "+ employeeCode);

    }

    public void post(){

        hold(500);
        elementWaitAdvanced(By.name("checkbox[1]"));
        clickOn(checkAll);
        hold(400);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(3500);
        closeIFrame();

        setLog("Post the Transactions");

    }

    public void setEmployeeCode(String employeeCode){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        empCode.clear();
        hold(200);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();

        setLog("Set Employee Code: "+employeeCode);

    }

    public void goToLoans(){
        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(loans);
        hold(300);
    }

    public void goToOvertime(){
        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(overtimeTab);
        hold(300);
    }

    public void vacation(String employeeCode, String fromDate, String toDate, String vacationType, boolean post){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(vacationTab);
        hold(300);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWait(dateE);
        dateE.clear();
        hold(200);
        setText(dateE, fromDate);
        toDateE.clear();
        hold(200);
        setText(toDateE, toDate);
        hold(300);
        Select select = new Select(typeE);
        select.selectByVisibleText(vacationType);
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);

        if(post){
            elementWaitAdvanced(By.name("checkbox[1]"));
            clickOn(checkAll);
            hold(400);
            closeIFrame();
            goToFrame(menuFrame);
            clickOn(menuPost);
            hold(500);
            alertWait();
            Alert alert = driver.switchTo().alert();
            hold(500);
            alert.accept();
            hold(3500);
            closeIFrame();
        }

        setLog("Vacation Transaction"+" - Employee Code: "+ employeeCode+" - From Date: "+fromDate+" - To Date: "+toDate+" - Vacation Type: "+vacationType);

    }

    public void vacationsCompensation(String employeeCode, String date, String vacationType, String days, boolean post){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        clickOn(vacationsCompensationTab);
        hold(300);
        setText(empCode, employeeCode, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        hold(500);
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);
        elementWait(dateE);
        dateE.clear();
        hold(200);
        setText(dateE, date);
        hold(300);
        Select select = new Select(typeE);
        select.selectByVisibleText(vacationType);
        hold(300);
        daysE.clear();
        hold(200);
        setText(daysE, days, Keys.TAB);
        hold(300);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(1500);

        if(post){
            elementWaitAdvanced(By.name("checkbox[1]"));
            clickOn(checkAll);
            hold(400);
            closeIFrame();
            goToFrame(menuFrame);
            clickOn(menuPost);
            hold(500);
            alertWait();
            Alert alert = driver.switchTo().alert();
            hold(500);
            alert.accept();
            hold(3500);
            closeIFrame();
        }

        setLog("Vacations Compensation Transaction"+" - Employee Code: "+ employeeCode+" - Date: "+date+" - Vacation Type: "+vacationType+" - Days: "+days);

    }

    public void calculateVacationInAdvance(){

        elementWait(vacationInAdvanceBtn);
        hold(1000);
        clickOn(vacationInAdvanceBtn);
        hold(500);
        closeIFrame();
        parentWindow = driver.getWindowHandle();
        goToWindow();
        hold(500);
        elementWait(vacationInAdvanceCalculateBtn);
        clickOn(vacationInAdvanceCalculateBtn);
        waitElementClickable(exitBox);
        clickOn(exitBox);
        hold(200);
        backToParentWindow(parentWindow);
        goToFrame(bodyFrame);

        setLog("Calculate Vacation In Advance");

    }

    public String OI_CheckAmountByTransactionType(String transactionType){
        return driver.findElement(By.xpath("(//option[text()='"+transactionType+"' and @selected]/../../..)[1]//input[contains(@name, 'transaction_amount')]")).getAttribute("value");
    }
    public String OI_CheckDateByTransactionType(String transactionType){
        return driver.findElement(By.xpath("(//option[text()='"+transactionType+"' and @selected]/../../..)[1]//input[contains(@name, 'transaction_date')]")).getAttribute("value");
    }

    public String getFromDate(int transactionOrder){
        return driver.findElement(By.xpath("(//input[contains(@id, 'transaction_date')])["+transactionOrder+"]")).getAttribute("value");
    }
    public String getToDate(int transactionOrder){
        return driver.findElement(By.xpath("(//input[contains(@id, 'transaction_end_date')])["+transactionOrder+"]")).getAttribute("value");
    }
    public String getAmount(int transactionOrder){
        return driver.findElement(By.xpath("(//input[contains(@name, 'transaction_amount')])["+transactionOrder+"]")).getAttribute("value");
    }
    public String getVacationType(int transactionOrder){
        WebElement selectElement = driver.findElement(By.xpath("(//select[contains(@id, 'transaction_internal_type')])["+transactionOrder+"]"));
        Select select = new Select(selectElement);
        return select.getFirstSelectedOption().getText();
    }

}
