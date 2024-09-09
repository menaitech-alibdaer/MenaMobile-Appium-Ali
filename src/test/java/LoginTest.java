import bases.BaseTest;
import mobileBackend.MainScreen;
import mobileBackend.MobileLogin;
import org.testng.Assert;
import org.testng.annotations.Test;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import webBackend.personnelInformation.PersonnelInformation;

import static utilities.MobileHelper.launchApp;
import static utilities.MobileHelper.terminateApp;
import static utilities.MssqlConnect.menaMeRestPassword;
import static utilities.MssqlConnect.sqlQuery;
import static utilities.WebHelper.emailAddress;

public class LoginTest extends BaseTest {

    PersonnelInformation personnel;
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;

    @Test(priority = 1, groups = "Login_Mobile")
    public void invalidLogin(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1111", "auto_mob1", false);

        Assert.assertTrue(loginMob.errorAlert.getAttribute("content-desc").contains("Wrong Username Or Password"), "Error Alert Not contains: Wrong Username Or Password, The alert that appears is: "+loginMob.errorAlert.getAttribute("content-desc"));

    }

    @Test(priority = 2, groups = "Login_Mobile")
    public void validLoginWithRememberMeAndCheckRememberMe(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1", "auto_mob1", true);

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
        loginMob.login("auto_mobile1", "1", "auto_mob1", true);

        mainScreen = new MainScreen();
        mainScreen.logout();

        terminateApp();
        launchApp();

        Assert.assertTrue(loginMob.loginBtn.isDisplayed(), "Login Button NOT appear after logout!");

    }

    @Test(priority = 4, groups = "Login_Mobile")
    public void loginWithOTP_ValidCode(){

        sqlQuery("update users_password_admin set me_security_management = 1, is_mfa_enabled = 1, mfa_timeout = 60 where branch_code='auto_mob1'");

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.auto_mobile1();

        String code = loginMob.getAuthenticationCode("auto_mobile1");
        loginMob.setAuthenticationCode(code);

        sqlQuery("update users_password_admin set me_security_management = 0, is_mfa_enabled = 0, mfa_timeout = 0 where branch_code='auto_mob1'");

        mainScreen = new MainScreen();

        Assert.assertTrue(mainScreen.requestMenuBtn.isDisplayed(), "Login Issue, Main Screen Not Appear!");

    }

    @Test(priority = 5, groups = "Login_Mobile")
    public void loginWithOTP_InvalidCode(){

        sqlQuery("update users_password_admin set me_security_management = 1, is_mfa_enabled = 1, mfa_timeout = 60 where branch_code='auto_mob1'");

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.auto_mobile1();

        String code = "000000";
        loginMob.setAuthenticationCode(code);

        sqlQuery("update users_password_admin set me_security_management = 0, is_mfa_enabled = 0, mfa_timeout = 0 where branch_code='auto_mob1'");

        Assert.assertTrue(loginMob.errorAlert.getAttribute("content-desc").contains("Wrong Authentication Code"), "Issue in Authentication Error Alert!");

    }

    @Test(priority = 4, groups = "Login_Mobile")
    public void loginWithOTP_ResendCode(){

        sqlQuery("update users_password_admin set me_security_management = 1, is_mfa_enabled = 1, mfa_timeout = 20 where branch_code='auto_mob1'");

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.auto_mobile1();

        loginMob.resendCodeOTP();
        String code = loginMob.getAuthenticationCode("auto_mobile1");
        loginMob.setAuthenticationCode(code);

        sqlQuery("update users_password_admin set me_security_management = 0, is_mfa_enabled = 0, mfa_timeout = 0 where branch_code='auto_mob1'");

        mainScreen = new MainScreen();

        Assert.assertTrue(mainScreen.requestMenuBtn.isDisplayed(), "Login Issue, Main Screen Not Appear!");

    }

    @Test(priority = 6, groups = "Login_Mobile")
    public void checkForgetPassword(){

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
        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.skipPage();
        loginMob.connectivity("automation", "auto_mob1", versionURL);
        loginMob.forgetPassword(employeeCode, "automation");

    }

}
