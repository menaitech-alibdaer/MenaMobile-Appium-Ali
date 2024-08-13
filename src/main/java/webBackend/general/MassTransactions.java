package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class MassTransactions extends WebBase {

    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(id = "MenaBox_iframe")
    WebElement MenaBox_iframe;
    @FindBy(id = "employee_code_1")
    WebElement empCode;
    @FindBy(id = "calc_from_date")
    WebElement startDateE;
    @FindBy(id = "calc_to_date")
    WebElement endDateE;
    @FindBy(name = "go_update_b")
    WebElement updateBtn;
    @FindBy(id = "transaction_code")
    WebElement transactionTypeGeneral;
    @FindBy(name = "dynamic_list")
    WebElement dynamicListE;
    @FindBy(xpath = "(//td[contains(@onclick, 'colapss_setup')])[2]")
    WebElement otherOptionsE;
    @FindBy(id = "transaction_internal_type")
    WebElement otherOptions_TransactionTypeE;
    @FindBy(id = "transaction_date")
    WebElement transactionDateE;
    @FindBy(id = "Values")
    WebElement transactionValueE;
    @FindBy(id = "allowance_trans_type")
    WebElement allowanceTransactionE;
    @FindBy(id = "Button22")
    WebElement calculateBtn;
    @FindBy(name = "Button22")
    WebElement closeBtn;
    @FindBy(name = "trans_allowraise")
    WebElement allowanceRaise_posting;
    @FindBy(name = "allowance_transaction")
    WebElement allowanceTransaction_posting;
    @FindBy(name = "trans_overtime")
    WebElement overtime_posting;
    @FindBy(name = "trans_salaryraise")
    WebElement salaryRaise_posting;
    @FindBy(id = "first_date")
    WebElement firstDateE;
    @FindBy(id = "second_date")
    WebElement secondDateE;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "MenuNewButton")
    WebElement menuNew;
    @FindBy(id = "MenuPostButton")
    WebElement menuPost;
    @FindBy(id = "MenuUnpostButton")
    WebElement menuUnpost;
    @FindBy(name = "close")
    WebElement postUnpost_Ok_btn;
    @FindBy(name = "btn_a[]")
    WebElement importTransactionsBtn;
    @FindBy(id = "transaction_internal_type")
    WebElement transactionType_importTran;
    @FindBy(id = "file_import")
    WebElement file_import;
    @FindBy(id = "save")
    WebElement save_importTran;
    @FindBy(id = "saveTransaction")
    WebElement saveTransaction_afterImport;
    @FindBy(name = "close")
    WebElement close_AfterSaveImport;
    @FindBy(className = "lineHeaderText")
    WebElement batchNumber_afterSaveImport;
    @FindBy(id = "batch_no")
    WebElement batchNumberE;


    public void updateFamilyAllowance(String employeeCode, String startDate, String endDate){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("site_1"));
        setText(empCode, employeeCode);
        hold(200);
        setText(empCode, Keys.TAB);
        hold(500);
        startDateE.clear();
        hold(200);
        setText(startDateE, startDate);
        endDateE.clear();
        hold(200);
        setText(endDateE, endDate);
        hold(500);
        clickOn(updateBtn);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        if(alert.getText().contains("No Transactions Have Been Calculated")){
            Assert.fail("No Transactions Have Been Calculated!");
        }
        alert.accept();
        driver.switchTo().defaultContent();

        setLog("Mass Transactions - Update Family Allowance - Employee Code: "+employeeCode+" - Start Date: "+startDate+" - End Date: "+endDate);

    }

    public void massTransactionsByDynamicList_AllowanceRaise(String dynamicList, String otherOptions_TransactionType,
                                                             String transactionDate, String transactionValue){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("transaction_code"));
        Select topTran = new Select(transactionTypeGeneral);
        topTran.selectByVisibleText("Allowances Raise");

        Select dyList = new Select(dynamicListE);
        dyList.selectByVisibleText(dynamicList);
        scrollToElement(driver.findElement(By.id("Rang_from")));
        clickOn(otherOptionsE);

        Select tranType = new Select(otherOptions_TransactionTypeE);
        tranType.selectByVisibleText(otherOptions_TransactionType);

        if(!transactionDate.isEmpty()){
            transactionDateE.clear();
            hold(200);
            setText(transactionDateE, transactionDate);
        }

        hold(300);
        transactionValueE.clear();
        hold(200);
        setText(transactionValueE, transactionValue);
        hold(300);
        clickOn(calculateBtn);

        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(300);
        alertWait();
        hold(500);
        alert.accept();
        hold(300);
        closeIFrame();
        goToFrame(MenaBox_iframe);
        hold(300);
        clickOn(closeBtn);
        closeIFrame();

        setLog("Mass Transactions By Dynamic List - AllowanceRaise - dynamic List: "+dynamicList+" - otherOptions_TransactionType: "+otherOptions_TransactionType+" - transactionDate: "+transactionDate+" - transactionValue: "+transactionValue);

    }

    public void massTransactionsByDynamicList_AllowanceTransaction(String dynamicList, String otherOptions_TransactionType,
                                                             String transactionDate, String allowanceTransaction){

        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("transaction_code"));
        Select topTran = new Select(transactionTypeGeneral);
        topTran.selectByVisibleText("Allowance Transaction");

        Select dyList = new Select(dynamicListE);
        dyList.selectByVisibleText(dynamicList);
        scrollToElement(driver.findElement(By.id("Rang_from")));
        clickOn(otherOptionsE);

        Select tranType = new Select(otherOptions_TransactionTypeE);
        tranType.selectByVisibleText(otherOptions_TransactionType);

        if(!transactionDate.isEmpty()){
            transactionDateE.clear();
            hold(200);
            setText(transactionDateE, transactionDate);
        }

        hold(300);
        Select at = new Select(allowanceTransactionE);
        at.selectByVisibleText(allowanceTransaction);
        hold(300);
        clickOn(calculateBtn);

        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        hold(300);
        alertWait();
        hold(500);
        alert.accept();
        hold(300);
        closeIFrame();
        goToFrame(MenaBox_iframe);
        hold(300);
        clickOn(closeBtn);
        closeIFrame();

        setLog("Mass Transactions By Dynamic List - Allowance Transaction - dynamic List: "+dynamicList+" - otherOptions_TransactionType: "+otherOptions_TransactionType+" - transactionDate: "+transactionDate+" - allowanceTransaction: "+allowanceTransaction);

    }

    public void postingAndUnposting(String transaction, String firstDate, String secondDate, String PostOrUnpost){

        goToFrame(bodyFrame);
        elementWaitAdvanced(By.name("trans_overtime"));
        if(transaction.equalsIgnoreCase("Overtime")){
            clickOn(overtime_posting);
        }else if(transaction.equalsIgnoreCase("Salary Scale")){
            clickOn(salaryRaise_posting);
        }else if(transaction.equalsIgnoreCase("Allowance Raise")){
            clickOn(allowanceRaise_posting);
        }else if(transaction.equalsIgnoreCase("Allowance Transaction")){
            clickOn(allowanceTransaction_posting);
        }

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

        if(PostOrUnpost.equalsIgnoreCase("Post")){
            closeIFrame();
            goToFrame(menuFrame);
            clickOn(menuPost);
            hold(300);
            closeIFrame();
            goToFrame(MenaBox_iframe);
            elementWaitAdvanced(By.name("close"));
            clickOn(postUnpost_Ok_btn);
        }else if(PostOrUnpost.equalsIgnoreCase("Unpost")){
            closeIFrame();
            goToFrame(menuFrame);
            clickOn(menuUnpost);
            hold(300);
            closeIFrame();
            goToFrame(MenaBox_iframe);
            elementWaitAdvanced(By.name("close"));
            clickOn(postUnpost_Ok_btn);
        }

        closeIFrame();

        setLog("Posting And Unposting - transaction: "+transaction+" - firstDate: "+firstDate+" - secondDate: "+secondDate+" - PostOrUnpost: "+PostOrUnpost);

    }

    public void importTransactions(String transactionType, String transactionType_internal, String csvFile){

        goToFrame(bodyFrame);
        elementWaitAdvanced(By.id("transaction_code"));
        Select type = new Select(transactionTypeGeneral);
        type.selectByVisibleText(transactionType);
        hold(300);
        clickOn(importTransactionsBtn);
        hold(500);
        closeIFrame();
        goToFrame(MenaBox_iframe);
        Select typeInternal = new Select(transactionType_importTran);
        typeInternal.selectByVisibleText(transactionType_internal);
        hold(200);
        file_import.sendKeys(csvFile);
        hold(200);
        clickOn(save_importTran);
        hold(300);
        elementWaitAdvanced(By.id("saveTransaction"));
        clickOn(saveTransaction_afterImport);
        elementWait(batchNumber_afterSaveImport);
        hold(3000);
        String getBatchNumber = batchNumber_afterSaveImport.getText().trim();
        clickOn(close_AfterSaveImport);
        closeIFrame();
        goToFrame(bodyFrame);
        System.out.println("Num: "+getBatchNumber);
        setText(batchNumberE, getBatchNumber, Keys.TAB);
        hold(1500);
        closeIFrame();
        goToFrame(menuFrame);
        clickOn(menuPost);
        hold(300);
        closeIFrame();
        goToFrame(MenaBox_iframe);
        elementWaitAdvanced(By.name("close"));
        clickOn(postUnpost_Ok_btn);
        closeIFrame();

        setLog("Import Transactions - transaction Type: "+transactionType+" - transactionType_internal: "+transactionType_internal+" - csvFile: "+csvFile);

    }

}
