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

public class TransactionsInquiry extends WebBase {

    @FindBy(id = "from_date")
    public WebElement fromDateE;
    @FindBy(id = "to_date")
    public WebElement toDateE;
    @FindBy(id = "selected_transaction_code")
    public WebElement typeE;
    @FindBy(id = "trans_type")
    public WebElement m_typeE;
    @FindBy(xpath = "//button[contains(text(), 'Display')]")
    WebElement m_displayBtn;
    @FindBy(xpath = "(//button[@class = 'close'])[last()]")
    WebElement closeX;
    @FindBy(id = "display_btn")
    public WebElement displayBtn;
    @FindBy(xpath = "//table[@id='requests-table']//td")
    public List<WebElement> inquiryColumns;
    @FindBy(xpath = "//table[@id='requests-table']//tbody//tr")
    public List<WebElement> inquiryRows;


    public void getTransactionInquiry(String from, String to, String type){

        elementWaitAdvanced(By.id("from_date"));
        if(!from.isEmpty()){
            fromDateE.clear();
            hold(200);
            setText(fromDateE, from, Keys.TAB);
        }
        if(!to.isEmpty()){
            toDateE.clear();
            hold(200);
            setText(toDateE, to, Keys.TAB);
        }
        if(!type.isEmpty()){
            Select select = new Select(typeE);
            select.selectByVisibleText(type);
            hold(200);
        }
        clickOn(displayBtn);
        hold(500);

        setLog("Transactions Inquiry - Get Transaction Inquiry"
        +" - From: "+from
        +" - To: "+to
        +" - Type: "+type);

    }

    public void getFinancialTransactions_Manager(String from, String to, String type){

        elementWaitAdvanced(By.id("from_date"));
        if(!from.isEmpty()){
            fromDateE.clear();
            hold(200);
            setText(fromDateE, from, Keys.TAB);
        }
        if(!to.isEmpty()){
            toDateE.clear();
            hold(200);
            setText(toDateE, to, Keys.TAB);
        }
        if(!type.isEmpty()){
            Select select = new Select(m_typeE);
            select.selectByVisibleText(type);
            hold(200);
        }
        clickOn(m_displayBtn);
        hold(300);

        setLog("Transactions Inquiry - Get Financial Transactions_Manager"
        +" - From: "+from
        +" - To: "+to
        +" - Type: "+type);

    }

    public void closePopup(){
        clickOn(closeX);
        hold(500);
    }

}
