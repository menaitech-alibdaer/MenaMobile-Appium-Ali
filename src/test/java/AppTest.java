import bases.BaseTest;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {

    Login login;
    MainScreen mainScreen;
    MyRequests myRequests;

    @Test
    public void simpleLogin() {

        login = new Login();
        login.skipPage();
        login.connectivity("mena", "auto_a1", "https://qc.menaitech.com/MenaS01_07_2024/application/hrms/");
        login.login("appiumtest", "1");

        mainScreen = new MainScreen();
        //mainScreen.ignoreUpdatePopup();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Annual Vacation", "25/11/2023", "01/01/2024", true);

        mainScreen.myRequests();

        myRequests.openOvertime();
        myRequests.overtimeRequest("20/06/2022", "Regular Overtime", "1:30 PM", "3:00 PM", true);

    }

}
