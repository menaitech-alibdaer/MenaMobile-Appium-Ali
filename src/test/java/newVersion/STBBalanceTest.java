package newVersion;

import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import bases.BaseTest;
import mobileBackend.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class STBBalanceTest extends BaseTest {

    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;
    CompanyAndBranch companyAndBranch;
    Employees employees;


    @Test(priority = 1, groups = "STB_Balance")
    public void checkSTBBalance_CheckFieldsAmounts(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.addSTB("STB 1", "");

        String stbAmount = employees.getSTBAmount(employeeCode, "STB 1", "");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.openSTBBalanceBox();

        softAssert.assertEquals(mainScreen.getSTBBalance("STB Amount"), stbAmount, "- STB Amount!");
        softAssert.assertEquals(mainScreen.getSTBBalance("STB Start Date"), "01/01/2020", "- STB Start Date!");
        softAssert.assertEquals(mainScreen.getSTBBalance("STB Salary"), stbAmount, "- STB Salary!");
        softAssert.assertEquals(mainScreen.getSTBBalance("STB Withdrawal"), "0.00", "- STB Withdrawal!");
        softAssert.assertEquals(mainScreen.getSTBBalance("Total STB Amount"), stbAmount, "- Total STB Amount!");
        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "STB_Balance")
    public void checkSTBBalanceScreenWithoutAddSTBToEmployee(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.openSTBBalanceBox();

        Assert.assertTrue(mainScreen.stbBalanceIsEmpty(), "- The Screen Should be contain: There Is No Date!");

    }

}
