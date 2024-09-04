import bases.BaseTest;
import mobileBackend.MainScreen;
import mobileBackend.MobileLogin;
import mobileBackend.MyRequests;
import org.testng.Assert;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import webBackend.personnelInformation.PersonnelInformation;

import static utilities.MssqlConnect.menaMeRestPassword;
import static utilities.WebHelper.emailAddress;

public class VacationTest extends BaseTest {

    PersonnelInformation personnel;
    FinancialPackage financial;
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;
    MyRequests myRequests;

    @Test(priority = 1, groups = "Vacations")
    public void requestUnpaidVacationWithAttachmentAndReason(){

        /////////////// Web Initialize //////////////
        webInitialize();

        login = new Login();
        login.auto_mob1();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        String email = emailAddress();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", email, "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = personnel.employeeCodeGetter();

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");

        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "10/01/2023", "10/01/2023",
                true, "Test Appium Reason", true);

        mainScreen.myTransactions("Vacations");
        mainScreen.openTransactionInMyTransactions("Vacations", "Unpaid Vacation", "10.01.2023");

        softAssert.assertEquals(mainScreen.getTransactionReason(), "Test Appium Reason", "- Reason Issue!");
        softAssert.assertTrue(mainScreen.attachmentInVacationDetails.isDisplayed(), "Attachment Icon NOT appear!");
        softAssert.assertTrue(mainScreen.checkAttachmentInVacationDetails(), "Attachment NOT Opened!");
        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "Vacations")
    public void requestUnpaidVacationAndWithdraw(){

        /////////////// Web Initialize //////////////
        webInitialize();

        login = new Login();
        login.auto_mob1();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        String email = emailAddress();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", email, "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = personnel.employeeCodeGetter();

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");

        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "11/01/2023", "11/01/2023",
                false, "", true);

        mainScreen.myTransactions("Vacations");
        mainScreen.openTransactionInMyTransactions("Vacations", "Unpaid Vacation",
                "11.01.2023", true);

        Assert.assertTrue(mainScreen.checkTransactionIfDropped(), "The Transaction NOT Dropped!");

    }

}
