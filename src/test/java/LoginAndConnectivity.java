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
import static utilities.MssqlConnect.*;
import static utilities.WebHelper.emailAddress;

public class LoginAndConnectivity extends BaseTest {

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

        Assert.assertTrue(loginMob.checkErrorLoginAlert().contains("Wrong Username Or Password"), "Error Alert Not contains: Wrong Username Or Password, The alert that appears is: "+loginMob.checkErrorLoginAlert());

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
        softAssert.assertTrue(mainScreen.checkIfLoginSuccessfully(), "Request Button should be appear after launch app!");
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

        Assert.assertTrue(mainScreen.checkIfLoginSuccessfully(), "Login Issue, Main Screen Not Appear!");

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

        Assert.assertTrue(loginMob.checkErrorLoginAlert().contains("Wrong Authentication Code"), "Issue in Authentication Error Alert!");

    }

    @Test(priority = 6, groups = "Login_Mobile")
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

        Assert.assertTrue(mainScreen.checkIfLoginSuccessfully(), "Login Issue, Main Screen Not Appear!");

    }

    @Test(priority = 7, groups = "Login_Mobile")
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

    @Test(priority = 8, groups = "Login_Mobile")
    public void connectivity_TestWrongCompany(){

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.skipPage();
        loginMob.connectivity("auto1112", "auto_mob1", versionURL);

        Assert.assertTrue(loginMob.checkErrorLoginAlert().contains("Wrong Company Code Or Branch Code"), "Issue In Alert when company code is wrong!");

    }

    @Test(priority = 9, groups = "Login_Mobile")
    public void connectivity_TestWrongBranch(){

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.skipPage();
        loginMob.connectivity("automation", "auto_auto", versionURL);

        Assert.assertTrue(loginMob.checkErrorLoginAlert().contains("Wrong Company Code Or Branch Code"), "Issue In Alert when branch code is wrong!");

    }

    @Test(priority = 10, groups = "Login_Mobile")
    public void connectivity_TestWrongURL(){

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.skipPage();
        loginMob.connectivity("automation", "auto_auto", "https://qc.menaitech.com/menas01_08_2022_sql2016666/");

        Assert.assertTrue(loginMob.alertPopup.getAttribute("content-desc").contains("Invalid URL"), "Issue In Alert popup when URL is wrong!");

    }

    @Test(priority = 11, groups = "Login_Mobile")
    public void changePassword_WrongOldPassword(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.openChangePassword();
        mainScreen.changePassword("55555", "222", "222");

        Assert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("Wrong Old Password"), "Attention Alert Issue, should be contain: Wrong Old Password!");

    }

    @Test(priority = 12, groups = "Login_Mobile")
    public void changePassword_NewPasswordNotSameRetypePassword(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.openChangePassword();
        mainScreen.changePassword("1", "222", "333");

        Assert.assertTrue(mainScreen.passwordDoesntMatchTheNewPasswordAlert.isDisplayed(), "This Alert should be appear: Password doesn't match the new password!");

    }

    @Test(priority = 13, groups = "Login_Mobile")
    public void changePassword_Success(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.openChangePassword();
        mainScreen.changePassword("1", "55555", "55555");

        Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Password has been changed successfully"), "Successfully Alert Issue, should be contain: Password has been changed successfully");

    }

    @Test(priority = 14, groups = "Login_Mobile")
    public void checkPasswordContainSpecialCharacter(){

        /////////////// Web Initialize //////////////
        webInitialize();

        login = new Login();
        login.auto_mob1();

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

        menaMeSetPassword(employeeCode, "Ali&$%#@*3658");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "Ali&$%#@*3658", "auto_mob1", false);

        mainScreen = new MainScreen();

        Assert.assertTrue(mainScreen.checkIfLoginSuccessfully(), "NOT login Successfully! - The Request Button should be appear after login in main screen!");

    }

    @Test(priority = 15, groups = "Login_Mobile")
    public void checkNotMenaMeUser(){

        sqlQuery("update pay_employees set is_MenaME_user = 0 where employee_code = 'auto_mobile1'");

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1", "auto_mob1", false);

        sqlQuery("update pay_employees set is_MenaME_user = 1 where employee_code = 'auto_mobile1'");

        Assert.assertTrue(loginMob.checkErrorLoginAlert().contains("You Are Not Authorized To Login"), "Issue In Alert: should be appear : You Are Not Authorized To Login!");

    }

}
