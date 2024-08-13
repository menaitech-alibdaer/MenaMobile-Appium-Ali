package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class SalaryScale extends WebBase {

    @FindBy(name = "basic_salary")
    WebElement packageSalaryLowerLimitE;
    @FindBy(xpath = "//a[contains(@href, 'Salary_Scale_package_D.php')]")
    WebElement salaryScalePackageAllowancesTab;
    @FindBy(xpath = "(//input[@value='Fixed Allowance']/following::input)[1]")
    WebElement fixedAllowanceAmountE;
    @FindBy(xpath = "(//input[@value='Percent Allowance']/following::input)[1]")
    WebElement percentAllowanceAmountE;
    @FindBy(name = "Salary_Scale_package_M_list")
    WebElement salaryScalePackageListFrame;
    @FindBy(name = "salary_scale_d_list")
    WebElement salaryScaleAllowanceFrame;
    @FindBy(name = "package_code")
    WebElement packageCodeE;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "body_frame")
    WebElement frame;

    public void editPackage_ChangeableRandomly(String salary, String fixedAllowance, String percentAllowance){

        hold(300);
        goToFrame(frame);
        elementWaitAdvanced(By.name("package_code"));
        setText(packageCodeE, "1", Keys.TAB);
        hold(1000);
        if(!salary.isEmpty()){
            packageSalaryLowerLimitE.clear();
            hold(300);
            setText(packageSalaryLowerLimitE, salary);
            hold(500);
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            hold(500);
            closeIFrame();
            goToFrame(frame);
            clickOn(salaryScalePackageAllowancesTab);
            hold(500);
            elementWaitAdvanced(By.name("package_code"));
            goToFrame(salaryScaleAllowanceFrame);
            if(!fixedAllowance.isEmpty()){
                fixedAllowanceAmountE.clear();
                hold(300);
                setText(fixedAllowanceAmountE, fixedAllowance);
            }
            if(!percentAllowance.isEmpty()){
                percentAllowanceAmountE.clear();
                hold(300);
                setText(percentAllowanceAmountE, percentAllowance);
            }
            hold(500);
            closeIFrame();
            goToFrame(menuFrame);
            hold(500);
            clickOn(menuSave);
            hold(500);
            closeIFrame();

            setLog("Salary Scale - Edit Package - Salary: "+salary+" - Fixed Allowance: "+fixedAllowance+" - Percent Allowance: "+percentAllowance);

        }

    }

}
