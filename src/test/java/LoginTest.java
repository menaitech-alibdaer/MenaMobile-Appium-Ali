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

import static utilities.MssqlConnect.selectQuery;
import static utilities.MssqlConnect.sqlQuery;

public class LoginTest extends BaseTest {

    PersonnelInformation personnel;
    FinancialPackage financial;
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;
    MyRequests myRequests;

    @Test(priority = 1, groups = "Login_Mobile")
    public void invalidLogin(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile", "1111", "auto_a1", false);

        Assert.assertTrue(loginMob.errorAlert.getAttribute("content-desc").contains("Wrong Username Or Password"));

    }

    @Test(priority = 2, groups = "Login_Mobile")
    public void validLoginWithRememberMeAndCheckRememberMe(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile", "1", "auto_a1", true);

        terminateApp();
        launchApp();

        mainScreen = new MainScreen();
        softAssert.assertTrue(loginMob.requestMenu.isDisplayed(), "Request Button should be appear after launch app!");
        mainScreen.logout();

        softAssert.assertAll();

    }

    @Test(priority = 3, groups = "Login_Mobile")
    public void validLoginWithRememberMeAndLogout(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile", "1", "auto_a1", true);

        mainScreen = new MainScreen();
        mainScreen.logout();

        terminateApp();
        launchApp();

        Assert.assertTrue(loginMob.loginBtn.isDisplayed(), "Login Button NOT appear after logout!");

    }

    @Test(priority = 4, groups = "Login_Mobile")
    public void loginWithOTP_ValidCode(){

        sqlQuery("update users_password_admin set me_security_management = 1, is_mfa_enabled = 1, mfa_timeout = 60 where branch_code='auto_a1'");

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile", "1", "auto_a1", false);

        String code = loginMob.getAuthenticationCode("auto_mobile");
        loginMob.setAuthenticationCode(code);

        mainScreen = new MainScreen();

        sqlQuery("update users_password_admin set me_security_management = 0, is_mfa_enabled = 0, mfa_timeout = 0 where branch_code='auto_a1'");

        Assert.assertTrue(mainScreen.requestMenuBtn.isDisplayed(), "Login Issue, Main Screen Not Appear!");

    }

    @Test(priority = 5, groups = "Login_Mobile")
    public void loginWithOTP_InvalidCode(){

        sqlQuery("update users_password_admin set me_security_management = 1, is_mfa_enabled = 1, mfa_timeout = 60 where branch_code='auto_a1'");

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile", "1", "auto_a1", false);

        String code = "000000";
        loginMob.setAuthenticationCode(code);

        mainScreen = new MainScreen();

        sqlQuery("update users_password_admin set me_security_management = 0, is_mfa_enabled = 0, mfa_timeout = 0 where branch_code='auto_a1'");

        Assert.assertTrue(loginMob.errorAlert.getAttribute("content-desc").contains("Wrong Authentication Code"), "Issue in Authentication Error Alert!");

    }

}
