package webBackend.mename;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.ExtentReport.setLog;

public class MenaMeLogin extends WebBase {

    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(id = "password64")
    WebElement pass;
    @FindBy(id = "company_code")
    WebElement company;
    @FindBy(xpath = "//input[contains(@onclick, 'CheckLoginForm(document.form)')]")
    WebElement signIn;

    public void login(String employee, String password, String companyCode){

        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employee);
        setText(pass, password);
        setText(company, companyCode);
        clickOn(signIn);
        elementWaitAdvanced(By.className("welcome"));

        setLog("MenaME MobileLogin"
        +" - Employee Code: "+employee
        +" - Password: "+password
        +" - Company Code: "+companyCode);

    }

}
