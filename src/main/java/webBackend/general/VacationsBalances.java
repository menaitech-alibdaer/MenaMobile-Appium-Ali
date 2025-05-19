package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.WebHelper.hold;

public class VacationsBalances extends WebBase {

    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(name = "vacation_code[1]")
    WebElement vacationCode1;
    @FindBy(name = "vacation_code[2]")
    WebElement vacationCode2;
    @FindBy(name = "net_balance_current[1]")
    WebElement currentBalance1;
    @FindBy(name = "net_balance_current[2]")
    WebElement currentBalance2;
    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuNewButton")
    WebElement menuNew;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(xpath = "(//select[contains(@name, 'vacation_code')])[last()]")
    WebElement vacationCodeE;
    @FindBy(xpath = "(//input[contains(@name, 'prevous_year_balance')])[last()]")
    WebElement previousBalanceE;
    @FindBy(xpath = "(//input[contains(@name, 'new_year_balance')])[last()]")
    WebElement newBalanceE;
    @FindBy(xpath = "(//input[contains(@name, 'year')])[last()]")
    WebElement yearE;
    @FindBy(xpath = "(//input[contains(@name, 'start_date')])[last()]")
    WebElement fromDateE;
    @FindBy(xpath = "(//input[contains(@name, 'end_date')])[last()]")
    WebElement toDateE;
    @FindBy(xpath = "(//input[contains(@name, 'fixed')])[last()]")
    WebElement fixedE;



    public void addBalance(String employeeCode, String vacationCode, String  previousBalance, String newBalance,
                           String year, String fromDate, String toDate, boolean fixed){


        closeIFrame();
        goToFrame(bodyFrame);
        elementWaitAdvanced(By.id("employee_code"));
        hold(500);
        empCode.clear();
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        elementWaitAdvanced(By.id("MenuNewButton"));
        clickOn(menuNew);
        closeIFrame();
        goToFrame(bodyFrame);
        normalSelect(vacationCodeE, vacationCode);
        setText(previousBalanceE, previousBalance);
        setText(newBalanceE, newBalance);
        if(!year.isEmpty()){
            yearE.clear();
            hold(200);
            setText(yearE, year);
        }
        if(!fromDate.isEmpty()){
            fromDateE.clear();
            setText(fromDateE, fromDate);
        }
        if(!toDate.isEmpty()){
            toDateE.clear();
            setText(toDateE, toDate);
        }
        if(fixed){
            if(!fixedE.isSelected()){
                clickOn(fixedE);
            }
        }else{
            if(fixedE.isSelected()){
                clickOn(fixedE);
            }
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(500);

    }

    public String getCurrentBalance(String employeeCode, String vacationCode){

        closeIFrame();
        goToFrame(bodyFrame);
        elementWaitAdvanced(By.id("employee_code"));
        hold(500);
        empCode.clear();
        hold(500);
        setText(empCode, employeeCode, Keys.TAB);
        hold(500);
        elementWaitAdvanced(By.name("vacation_code[1]"));
        return driver.findElement(By.xpath("(//option[text()='"+vacationCode+"' and @selected]/following::input)[3]")).getDomAttribute("value");

    }

}
