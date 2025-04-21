package newVersion;

import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import bases.BaseTest;
import mobileBackend.*;
import org.testng.annotations.Test;

import static utilities.WebHelper.emailAddress;
import static utilities.WebHelper.mobile;

public class MyProfilePersonalTest extends BaseTest {

    String employeeCode = null;
    MobileLogin loginMob;
    MainScreen mainScreen;
    Manager manager;
    CompanyAndBranch companyAndBranch;
    Employees employees;
    MyProfilePersonal personal;

    @Test(priority = 1, groups = "MyProfilePersonal")
    public void myProfile_Personal_AddContactInformation_ApproveByManager_AndRecheck(){

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
                true, "Regular", "", "", 0, true, true);
        String directManager = employees.getEmployeeCode();

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        //String employeeName = employees.getFullNameEmployee();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openContactInformation();
        String mobile = mobile();
        String emailAddress = emailAddress();
        personal.addContactInformation(mobile, emailAddress, false);

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Change Personal Data");
        manager.approve();

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false);
        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal.openContactInformation();

        softAssert.assertEquals(personal.getContactInformation("Mobile"), mobile, "- Mobile!");
        softAssert.assertEquals(personal.getContactInformation("Email"), emailAddress, "- Email!");
        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "MyProfilePersonal")
    public void myProfile_Personal_CheckContactInformation(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        String mobile = mobile();
        String email = emailAddress();

        employees = new Employees();
        employees.createNewEmployee("1980-05-20", email, "Male", "Single", "Jordanian", "",
                mobile, "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, true);
        employeeCode = employees.getEmployeeCode();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openContactInformation();

        softAssert.assertEquals(personal.getContactInformation("Mobile"), mobile, "- Mobile!");
        softAssert.assertEquals(personal.getContactInformation("Email"), email, "- Email!");
        softAssert.assertEquals(personal.getContactInformation("Site"), "New Zarqa", "- Site!");
        softAssert.assertEquals(personal.getContactInformation("Department"), "Quality", "- Department!");
        softAssert.assertEquals(personal.getContactInformation("Hiring Date"), "2020-01-01", "- Hiring Date!");
        softAssert.assertEquals(personal.getContactInformation("Marital Status"), "Single", "- Marital Status!");
        softAssert.assertAll();

    }


}
