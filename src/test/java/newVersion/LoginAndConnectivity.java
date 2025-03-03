package newVersion;

import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
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
import static utilities.WebHelper.hold;

public class LoginAndConnectivity extends BaseTest {

    PersonnelInformation personnel;
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;

    CompanyAndBranch companyAndBranch;
    Employees employees;

    @Test(priority = 1, groups = "Login_Mobile")
    public void invalidLogin(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1111", "automobile", false);

        Assert.assertTrue(loginMob.checkErrorLoginAlert().contains("Wrong Username Or Password"), "Error Alert Not contains: Wrong Username Or Password, The alert that appears is: "+loginMob.checkErrorLoginAlert());

    }

    @Test(priority = 2, groups = "Login_Mobile")
    public void validLoginWithRememberMeAndCheckRememberMe(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "sa", "automobile", true);

        hold(7000);

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
        loginMob.login("auto_mobile1", "sa", "automobile", true);

        mainScreen = new MainScreen();
        mainScreen.logout();

        hold(7000);

        terminateApp();
        launchApp();

        Assert.assertTrue(loginMob.loginBtn.isDisplayed(), "Login Button NOT appear after logout!");

    }

    @Test(priority = 4, groups = "Login_Mobile", enabled = false)
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

    @Test(priority = 5, groups = "Login_Mobile", enabled = false)
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

    @Test(priority = 6, groups = "Login_Mobile", enabled = false)
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

    @Test(priority = 7, groups = "Login_Mobile", enabled = false)
    public void checkForgetPassword(){

        /////////////// Web Initialize //////////////
        systemInitialize();

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
        loginMob.connectivity("auto1112", versionURL);

        Assert.assertTrue(loginMob.checkErrorLoginAlert().contains("Wrong Company Code"), "Issue In Alert when company code is wrong!");

    }

    @Test(priority = 9, groups = "Login_Mobile", enabled = false)
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
        loginMob.connectivity("automation", "https://qc.menaitech.com/qqwweerr1/");

        Assert.assertTrue(loginMob.alertPopup.getAttribute("content-desc").contains("Invalid URL"), "Issue In Alert popup when URL is wrong!");

    }

    @Test(priority = 11, groups = "Login_Mobile")
    public void changePassword_WrongOldPassword(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openChangePassword();
        mainScreen.changePassword("55555", "222", "222");

        Assert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("The old password you entered is incorrect"), "Attention Alert Issue, should be contain: Wrong Old Password!");

    }

    @Test(priority = 12, groups = "Login_Mobile")
    public void changePassword_NewPasswordNotSameRetypePassword(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openChangePassword();
        mainScreen.changePassword("1", "222", "333");

        Assert.assertTrue(mainScreen.passwordDoesntMatchTheNewPasswordAlert.isDisplayed(), "This Alert should be appear: Password doesn't match the new password!");

    }

    @Test(priority = 13, groups = "Login_Mobile")
    public void changePassword_Success(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1990-05-20", "", "Male", "Single", "", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openChangePassword();
        mainScreen.changePassword("sa", "0799999999", "0799999999");

        Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Password has been changed successfully"), "Successfully Alert Issue, should be contain: Password has been changed successfully");

    }

    @Test(priority = 14, groups = "Login_Mobile")
    public void checkPasswordContainSpecialCharacter(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1990-05-20", "", "Male", "Single", "", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openChangePassword();
        mainScreen.changePassword("sa", "Ali&$%#@*3658", "Ali&$%#@*3658");
        mainScreen.closeAlert();
        mainScreen.logout();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "Ali&$%#@*3658", "automobile", false);

        mainScreen = new MainScreen();

        Assert.assertTrue(mainScreen.checkIfLoginSuccessfully(), "NOT login Successfully! - The Request Button should be appear after login in main screen!");

    }

    @Test(priority = 15, groups = "Login_Mobile")
    public void checkNotMenaMeUser(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1990-05-20", "", "Male", "Single", "", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                false, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        Assert.assertTrue(loginMob.checkErrorLoginAlert().contains("You Do Not Have Permissions to Use The Employee"), "Issue In Alert: should be appear : You Are Not Authorized To Login!");

    }

}
