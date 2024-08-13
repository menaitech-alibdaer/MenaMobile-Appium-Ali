package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class Monthly_KPI_Import extends WebBase {

    @FindBy(id = "body_frame")
    WebElement body_frame;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuShowButton")
    WebElement MenuShowButton;
    @FindBy(id = "MenuDeleteButton")
    WebElement menuDelete;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "MenaBox_iframe")
    WebElement MenaBox_iframe;
    @FindBy(name = "btn_a[]")
    WebElement importTransactionsBtn;
    @FindBy(name = "allowance_code")
    WebElement allowanceTypeE;
    @FindBy(name = "file_import")
    WebElement file_import;
    @FindBy(id = "save")
    WebElement popUp_importTransactionsBtn;
    @FindBy(name = "exit")
    WebElement exitBtn;
    @FindBy(id = "save")
    WebElement save_AfterImport;
    @FindBy(name = "loading")
    WebElement doneImg;
    @FindBy(className = "batch_num")
    WebElement getBatchNumberE;
    @FindBy(id = "batch_no")
    WebElement batchNumberE;
    String parentWindow;
    MainMenu mainMenu;

    public void importTransactions(String transactionType_internal, String csvFile){

        goToFrame(body_frame);
        elementWaitAdvanced(By.id("batch_no"));
        clickOn(importTransactionsBtn);
        hold(500);
        closeIFrame();
        parentWindow = driver.getWindowHandle();
        goToWindow();
        hold(500);
        elementWait(allowanceTypeE);
        Select typeInternal = new Select(allowanceTypeE);
        typeInternal.selectByVisibleText(transactionType_internal);
        hold(200);
        file_import.sendKeys(csvFile);
        hold(200);
        clickOn(save_AfterImport);
        hold(300);
        elementWaitAdvanced(By.id("save"));
        clickOn(save_AfterImport);
        hold(300);
        elementWait(doneImg);
        hold(500);
        String getBatchNumber = getBatchNumberE.getText().trim();
        driver.close();
        hold(300);
        backToParentWindow(parentWindow);

        setLog("Monthly KPI Import - importTransactions: "+transactionType_internal+" - csvFile: "+csvFile);

    }



}
