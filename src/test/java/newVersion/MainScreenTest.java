package newVersion;

import bases.BaseTest;
import mobileBackend.MainScreen;
import mobileBackend.MobileLogin;
import org.testng.annotations.Test;

public class MainScreenTest extends BaseTest {

    MobileLogin loginMob;
    MainScreen mainScreen;

    @Test
    public void testBoxesInHomeScreen(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("vuxn60250", "sa", "auto_mob1", "automobile", false);

        mainScreen = new MainScreen();

        softAssert.assertTrue(mainScreen.annualVacationBox(), "Annual Vacation!");
        softAssert.assertTrue(mainScreen.sickVacationBox(), "Sick Vacation!");
        softAssert.assertEquals(mainScreen.getCurrentBalance_AnnualVacation(), "13.540");
        softAssert.assertEquals(mainScreen.getUpToEndOfYear_AnnualVacation(), "14.000");
        softAssert.assertEquals(mainScreen.getCurrentBalance_SickVacation(), "14.000");
        softAssert.assertEquals(mainScreen.getUpToEndOfYear_SickVacation(), "14.000");
        softAssert.assertTrue(mainScreen.loanBalanceBox(), "Loan Balance!");
        softAssert.assertEquals(mainScreen.loanBalanceAmount(), "1100");
        softAssert.assertTrue(mainScreen.stbBalanceBox(), "STB Balance!");
        softAssert.assertEquals(mainScreen.stbBalanceAmount(), "0.000");
        softAssert.assertTrue(mainScreen.lastSalaryBox(), "Last Salary!");
        softAssert.assertEquals(mainScreen.lastSalaryAmount(), "1946.666");
        softAssert.assertAll();

    }

}
