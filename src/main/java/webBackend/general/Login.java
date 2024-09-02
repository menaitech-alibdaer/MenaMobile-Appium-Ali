package webBackend.general;

import bases.WebBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExtentReport;


import static utilities.MssqlConnect.queryRestSetup;

public class Login extends WebBase {

    @FindBy(id = "userid")
    WebElement user;
    @FindBy(id = "password64")
    WebElement pass;
    @FindBy(id = "company_code")
    WebElement company;
    @FindBy(id = "branch_code")
    WebElement branch;
    @FindBy(xpath = "//span[contains(text(), 'عربي')][@value='2']")
    WebElement arabicLang;
    @FindBy(name = "myaccount")
    WebElement rememberLogin;
    @FindBy(name = "login")
    WebElement signIn;

    public void login(String username, String password, String companyCode, String branchCode, boolean arabicLanguage, boolean rememberMe){

        setText(user, username);
        setText(pass, password);
        setText(company, companyCode);
        setText(branch, branchCode);

        if(arabicLanguage){
            clickOn(arabicLang);
        }

        if(rememberMe){
            clickOn(rememberLogin);
        }

        clickOn(signIn);

        if (ExtentReport.getTest()!=null) {
            ExtentReport.getTest().log(Status.INFO, "HRMS MobileLogin Credentials - Username: " + username +" - Password: "+password+
                    " - Company Code: " + companyCode + " - Branch Code: " + branchCode);  }

    }

    public void staticLogin(){
        setBranch("auto_a1");
        queryRestSetup();
        login("ali","0795798860","automation","auto_a1",false,false);
    }
    public void auto_a3_SocialSecurity_Calendar(){
        setBranch("auto_a3");
        queryRestSetup();
        login("ali","0795798860","automation","auto_a3",false,false);
    }
    public void auto_a4_SocialSecurity_30Days(){
        setBranch("auto_a4");
        queryRestSetup();
        login("ali","0795798860","automation","auto_a4",false,false);
    }
    public void auto_a5_HealthInsurance_Calendar(){
        setBranch("auto_a5");
        queryRestSetup();
        login("ali","0795798860","automation","auto_a5",false,false);
    }
    public void auto_a6_HealthInsurance_30Days(){
        setBranch("auto_a6");
        queryRestSetup();
        login("ali","0795798860","automation","auto_a6",false,false);
    }
    public void auto_a7_HealthInsurance_Calendar_Prorate(){
        setBranch("auto_a7");
        queryRestSetup();
        login("ali","0795798860","automation","auto_a7",false,false);
    }
    public void auto_a8_HealthInsurance_30Days_Prorate(){
        setBranch("auto_a8");
        queryRestSetup();
        login("ali","0795798860","automation","auto_a8",false,false);
    }
    public void auto_a9_SalaryReportSetup(){
        setBranch("auto_a9");
        login("ali","0795798860","automation","auto_a9",false,false);
    }
    public void auto_a10_SalaryReportSetup_separator(){
        setBranch("auto_a10");
        login("ali","0795798860","automation","auto_a10",false,false);
    }
    public void auto_a11_Allowances_30Days(){
        setBranch("auto_a11");
        login("ali","0795798860","automation","auto_a11",false,false);
    }
    public void auto_a12_Allowances_Calendar(){
        setBranch("auto_a12");
        login("ali","0795798860","automation","auto_a12",false,false);
    }
    public void auto_a13_Loans(){
        setBranch("auto_a13");
        login("ali","0795798860","automation","auto_a13",false,false);
    }
    public void auto_a14_Vacation_In_Advance_KSA(){
        setBranch("auto_a14");
        login("ali","0795798860","automation","auto_a14",false,false);
    }
    public void auto_a15_Vacation_In_Advance_KSA_VacNeverExceed(){
        setBranch("auto_a15");
        login("ali","0795798860","automation","auto_a15",false,false);
    }
    public void auto_a16_Vacation_In_Advance_KSA_CutOffDate(){
        setBranch("auto_a16");
        queryRestSetup();
        login("ali","0795798860","automation","auto_a16",false,false);
    }
    public void auto_a18_Vacation_In_Advance_KSA_30Days(){
        setBranch("auto_a18");
        queryRestSetup();
        login("ali","0795798860","automation","auto_a18",false,false);
    }
    public void auto_a19_Vacation_In_Advance_KSA_30Days_CutOffDate(){
        setBranch("auto_a19");
        queryRestSetup();
        login("ali","0795798860","automation","auto_a19",false,false);
    }
    public void auto_a20_EmployeeTermination_KSA(){
        setBranch("auto_a20");
        queryRestSetup();
        login("ali","0795798860","automation","auto_a20",false,false);
    }
    public void saLogin(String branch){
        setBranch(branch);
        login("sa","0795798860","automation",branch,false,false);
    }
    public void ali1User(){
        setBranch("auto_a1");
        ///// Zarqa Site Executive Payroll
        login("ali1","0795798860","automation","auto_a1",false,false);
    }

    public void ali2User(){
        setBranch("auto_a1");
        ///// Main Category Executive Payroll
        login("ali2","0795798860","automation","auto_a1",false,false);
    }

    public void ali3User(){
        setBranch("auto_a1");
        ///// All Without Executive Payroll
        login("ali3","0795798860","automation","auto_a1",false,false);
    }

    public void ali4User(){
        setBranch("auto_a1");
        ///// Executive Payroll Position
        login("ali4","0795798860","automation","auto_a1",false,false);
    }
    public void ali5User(){
        setBranch("auto_a1");
        ///// Do Not Allow User To Upload Files
        login("ali5","0795798860","automation","auto_a1",false,false);
    }
    public void ali6User(){
        setBranch("auto_a1");
        ///// Do Not Allow User To View/Download Files
        login("ali6","0795798860","automation","auto_a1",false,false);
    }
    public void auto_mob1(){
        setBranch("auto_mob1");
        queryRestSetup();
        login("ali","0795798860","automation","auto_mob1",false,false);
    }

}
