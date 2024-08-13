package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import static utilities.WebHelper.hold;

public class ManagersPermissions extends WebBase {

    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(name = "inquiry_authority")
    WebElement viewFinancialDataE;
    @FindBy(name = "inquiry_authority_hr")
    WebElement viewPersonnelHRDataE;
    @FindBy(name = "view_emp_attendance")
    WebElement viewEmployeesAttendanceHistoryE;
    @FindBy(name = "Executive_payroll")
    WebElement accessToExecutiveEmployeesE;
    @FindBy(id = "transactions_entry_array")
    WebElement transactionsEntry_Options;
    @FindBy(id = "transactions_approval_array")
    WebElement transactionsApproval_Options;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "body_frame")
    WebElement frame;


    public void transactionPermissions_All(String employeeCode){

        goToFrame(frame);
        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employeeCode, Keys.TAB);
        hold(300);
        if(!viewFinancialDataE.isSelected()){
            clickOn(viewFinancialDataE);
        }
        if(!viewPersonnelHRDataE.isSelected()){
            clickOn(viewPersonnelHRDataE);
        }
        if(!viewEmployeesAttendanceHistoryE.isSelected()){
            clickOn(viewEmployeesAttendanceHistoryE);
        }
        if(!accessToExecutiveEmployeesE.isSelected()){
            clickOn(accessToExecutiveEmployeesE);
        }

        Select tranEntry = new Select(transactionsEntry_Options);
        tranEntry.selectByIndex(0);
        tranEntry.selectByIndex(1);
        tranEntry.selectByIndex(2);
        tranEntry.selectByIndex(3);
        tranEntry.selectByIndex(4);
        tranEntry.selectByIndex(5);
        tranEntry.selectByIndex(6);
        tranEntry.selectByIndex(7);
        tranEntry.selectByIndex(8);
        tranEntry.selectByIndex(9);

        Select approval = new Select(transactionsApproval_Options);
        approval.selectByIndex(0);
        approval.selectByIndex(1);
        approval.selectByIndex(2);
        approval.selectByIndex(3);
        approval.selectByIndex(4);

        hold(200);
        closeIFrame();
        hold(200);
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(500);
        closeIFrame();
        hold(500);

    }

}
