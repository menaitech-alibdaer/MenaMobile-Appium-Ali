import bases.BaseTest;
import mobileBackend.MainScreen;
import mobileBackend.MobileLogin;
import mobileBackend.MyRequests;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.general.*;
import webBackend.personnelInformation.PersonnelInformation;

import static utilities.MssqlConnect.*;

public class FullTest extends BaseTest {

    PersonnelInformation personnel;
    FinancialPackage financial;
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;
    MyRequests myRequests;

    @Test(priority = 1)
    public void newEmployee(){

        /////////////// Web Initialize //////////////
        webInitialize();

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = personnel.employeeCodeGetter();

//        mainMenu.mainMenu("Employees","Financial Information");
//        financial = new FinancialPackage();
//        financial.setEmployeeCode(employeeCode);
//        financial.setBasicSalary("1000");
//        financial.addAllowances("Fixed Allowance", "100", "", "", "", "");
//        financial.addAllowances("Percent Allowance", "5", "", "", "", "");

        menaMeRestPassword(employeeCode);

        softAssert.assertEquals(employeeCode+"55555", employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_a1", false);

        mainScreen = new MainScreen();
        mainScreen.ignoreUpdatePopup();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();

        softAssert.assertFalse(myRequests.vacationsRequestBtn.isDisplayed());

        myRequests.vacationRequest(data.getValue("vacations", "Annual Vacation"), "25/11/2023", "01/01/2024", true);

//        mainScreen.myRequests();
//
//        myRequests.openOvertime();
//        myRequests.overtimeRequest("20/06/2022", "Regular Overtime", "1:30 PM", "3:00 PM", true);

        softAssert.assertAll();


    }

}
