package bases;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentReport;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.screenshotAsBase64;
import static utilities.MssqlConnect.*;
import static utilities.VersionGetter.*;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart");
        ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
                .assignCategory(result.getMethod().getGroups())
                .assignAuthor("MenaITech")
                .assignDevice(browserGetter());

        setLog("System Version: "+versionGetter());
        if(!versionGetter().equalsIgnoreCase("Revamp")){
            setLog("Lite Version: "+liteGetter());
        }
        setLog("URL: "+urlGetter());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //WebBase base = new WebBase();
        MobileBasePage base = new MobileBasePage();
        if(result.getThrowable() instanceof Exception){
            ExtentReport.getTest().log(Status.FAIL, result.getThrowable());
        }else{
            ExtentReport.getTest().log(Status.FAIL, result.getThrowable().getMessage());
        }

        try {
            ExtentReport.getTest().addScreenCaptureFromBase64String(screenshotAsBase64(base.appiumDriver));
        }catch (Exception ignored){
            System.out.println("Screenshot Ignored!");
        }
    }



    @Override
    public void onTestSkipped(ITestResult result) {

        //WebBase base = new WebBase();
        MobileBasePage base = new MobileBasePage();
        if(result.getThrowable() instanceof Exception){
            ExtentReport.getTest().log(Status.SKIP, result.getThrowable());
        }else{
            ExtentReport.getTest().log(Status.SKIP, result.getThrowable().getMessage());
        }

        try {
            ExtentReport.getTest().addScreenCaptureFromBase64String(screenshotAsBase64(base.appiumDriver));
        }catch (Exception ignored){
            System.out.println("Screenshot Ignored!");
        }

        System.out.println("Rest Queries When test ignored");

        if(!versionGetter().equalsIgnoreCase("Revamp")){
            restFamilySetup();
            sqlQuery("update adm_company set Client_id=NULL where company_code = 'automation';" +
                    "update adm_branch set country_profile = 1, tax_profile = 1, is_gulf = 1, Employee_Auto_Serial = 0 where branch_code = 'auto_a1' and company_code = 'automation';" +
                    "update pay_setup set max_upload_type = 0 where company_code = 'automation';" +
                    "update pay_setup set english_arabic_man = 2 where branch_code = 'auto_a1' and company_code = 'automation';" +
                    "update pay_setup set is_setup_overtime_hours = 0 where branch_code = 'auto_a1' and company_code = 'automation';" +
                    "update pay_setup set is_calendar_days = 2, day_hours = 8 where company_code = 'automation' and branch_code = 'auto_a1';" +
                    "update pay_setup set cut_off_date = 0 where company_code = 'automation' and branch_code = 'auto_a1';" +
                    "update pay_setup set cost_distribution_scope = 3 where company_code = 'automation' and branch_code = 'auto_a1';" +
                    "update pay_setup set no_edit_familly_allow = 0 where company_code = 'automation' and branch_code = 'auto_a1';" +
                    "update pay_setup set allow_age = '30.000', allow_girl_age = '30.000' where company_code = 'automation' and branch_code = 'auto_a1';" +
                    "update pay_setup set min_age_marry = 0 where company_code = 'automation';" +
                    "update adm_company set is_retroactive_salaries = 0 where company_code='automation';" +
                    "update adm_branch set is_calc_with_previous = 0 where company_code = 'automation';");

            restChildSort();
            allowancesCalculatedAccordingToDate(true, "auto_a1");
            automaticallySubmitEmployeeToSocialSecurity(false);
            automaticallySubmitEmployeeToHealthInsurance(false);
            socialSecurityStartMonth("0");
            insuranceStartMonth("0");
            if(liteGetter()){
                liteVersion("1");
            }else{
                liteVersion("0");
            }

            sqlQuery("update adm_company set reports_max_records = 2000 where company_code = 'automation'");
            sqlQuery("update adm_branch set is_gulf = 0 where company_code = 'automation' and branch_code = 'auto_a9'");

            sqlQuery("update users_password_admin set me_security_management = 0, is_mfa_enabled = 0, mfa_timeout = 60 where branch_code='auto_mob1'");
            sqlQuery("update pay_setup set auto_delegate_before_vacation = 0 where branch_code = 'auto_mob1'");
        }else{
            setMenaMePassword("auto_mobile1", "Revamp");
            setMenaMePassword("auto_mobile2", "Revamp");
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.getReporter().flush();
        System.out.println("onFinish");
    }

}
