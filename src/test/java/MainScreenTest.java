import bases.BaseTest;
import mobileBackend.*;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.financialInformation.Insurance;
import webBackend.financialInformation.TaxAndDeduction;
import webBackend.general.*;
import webBackend.personnelInformation.Other;
import webBackend.personnelInformation.PersonnelInformation;
import webBackend.salaryCalculation.SalaryCalculation;

public class MainScreenTest extends BaseTest {

    MobileLogin loginMob;
    MainScreen mainScreen;

    @Test
    public void testBoxesInHomeScreen(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("vuxn60250", "1", "auto_mob1", false);

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
