package mobileTest;

import bases.MobileBaseTest;
import mobileBackend.MobileLogin;
import mobileBackend.MainScreen;
import mobileBackend.MyRequests;
import org.testng.annotations.Test;

import static utilities.WebHelper.employeeCodeGetter;

public class AppTest extends MobileBaseTest {

    MobileLogin login;
    MainScreen mainScreen;
    MyRequests myRequests;
    String employeeCode = null;

    @Test(priority = 2, dependsOnMethods = {"webTest.NewEmployeeCreator.newEmployee"})
    public void simpleLogin() {

        employeeCode = employeeCodeGetter();

        login = new MobileLogin();
        login.skipPage();
        login.connectivity("mena", "auto_a1", "https://qc.menaitech.com/menas01_07_2024/application/hrms/");
        login.login(employeeCode, "1");

        mainScreen = new MainScreen();
        //mainScreen.ignoreUpdatePopup();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
//        myRequests.vacationRequest("Annual Vacation", "25/11/2023", "01/01/2024", true);
//
//        mainScreen.myRequests();
//
//        myRequests.openOvertime();
//        myRequests.overtimeRequest("20/06/2022", "Regular Overtime", "1:30 PM", "3:00 PM", true);

    }

    @Test(priority = 3, dependsOnMethods = {"webTest.NewEmployeeCreator.newEmployee"})
    public void simpleLogin11() {

        employeeCode = employeeCodeGetter();

        login = new MobileLogin();
        login.skipPage();
        login.connectivity("mena", "auto_a1", "https://qc.menaitech.com/menas01_07_2024/application/hrms/");
        login.login(employeeCode, "1");

        mainScreen = new MainScreen();
        //mainScreen.ignoreUpdatePopup();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
//        myRequests.vacationRequest("Annual Vacation", "25/11/2023", "01/01/2024", true);
//
//        mainScreen.myRequests();
//
//        myRequests.openOvertime();
//        myRequests.overtimeRequest("20/06/2022", "Regular Overtime", "1:30 PM", "3:00 PM", true);

    }

}
