package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class PF_Balances extends WebBase {

    @FindBy(name = "employee_code")
    public WebElement empCode;
    @FindBy(id = "body_frame")
    WebElement body_frame;
    @FindBy(name = "saving_flag")
    WebElement underProvidentFundCheckbox;
    @FindBy(name = "saving_code")
    WebElement PF_typeE;
    @FindBy(xpath = "//img[@onclick='show_salary_changed()']")
    WebElement calculateBtn;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;

    public void PF_Balance(String employeeCode, boolean underProvidentFund, String pfType){

        goToFrame(body_frame);
        elementWaitAdvanced(By.name("employee_code"));
        empCode.clear();
        hold(100);
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        if(underProvidentFund){
           if(!underProvidentFundCheckbox.isSelected()){
               clickOn(underProvidentFundCheckbox);
           }
           if(!pfType.isEmpty()){
                Select select = new Select(PF_typeE);
                select.selectByVisibleText(pfType);
           }
        }else{
            if(underProvidentFundCheckbox.isSelected()){
                clickOn(underProvidentFundCheckbox);
            }
        }

        clickOn(calculateBtn);
        hold(300);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(1000);
        closeIFrame();
        elementWait(body_frame);
        hold(300);

        setLog("PF Balances - Employee Code: "+employeeCode+" - Under Provident Fund: "+underProvidentFund+" - PF Type: "+pfType);

    }


}
