import bases.BaseTest;
import mobileBackend.MainScreen;
import mobileBackend.MobileLogin;
import mobileBackend.MyRequests;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import webBackend.personnelInformation.PersonnelInformation;

import static utilities.MssqlConnect.menaMeRestPassword;
import static utilities.WebHelper.*;

public class FullTest2 extends BaseTest {

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
    public void newEmployee2(){

//        /////////////// Web Initialize //////////////
        webInitialize();

        login = new Login();
        //login.staticLogin();
        login.login("sa", "1", "mena", "auto_a1", false, false);

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

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");
        financial.addAllowances("Fixed Allowance", "100", "", "", "", "");
        financial.addAllowances("Percent Allowance", "5", "", "", "", "");

        menaMeRestPassword(employeeCode);

        softAssert.assertEquals(employeeCode+"55555", employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.skipPage();
        loginMob.connectivity("mena", "auto_a1", "https://qc.menaitech.com/menas01_07_2024/application/hrms/");
        loginMob.login(employeeCode, "1");

        mainScreen = new MainScreen();
        mainScreen.ignoreUpdatePopup();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();

        softAssert.assertFalse(myRequests.vacationsRequestBtn.isDisplayed());

        myRequests.vacationRequest("Annual Vacation", "25/11/2023", "01/01/2024", true);

//        mainScreen.myRequests();
//
//        myRequests.openOvertime();
//        myRequests.overtimeRequest("20/06/2022", "Regular Overtime", "1:30 PM", "3:00 PM", true);

        softAssert.assertAll();


    }

}
