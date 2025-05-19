package oldVersion;

import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import bases.BaseTest;
import mobileBackend.*;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.general.*;
import webBackend.personnelInformation.Other;
import webBackend.personnelInformation.PersonnelInformation;

import static utilities.MssqlConnect.menaMeRestPassword;
import static utilities.WebHelper.emailAddress;
import static utilities.WebHelper.mobile;

public class MyProfilePersonalTest_old extends BaseTest {

    String employeeCode = null;
    MobileLogin loginMob;
    MainScreen mainScreen;
    Manager manager;
    CompanyAndBranch companyAndBranch;
    Employees employees;
    MyProfilePersonal personal;
    PersonnelInformation personnel;
    MyRequests myRequests;
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;

    @Test(priority = 1, groups = "MyProfilePersonal")
    public void myProfile_Personal_AddContactInformationAndRecheck(){

        /////////////// Web Initialize //////////////
        systemInitialize();

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
        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1","automation", false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openContactInformation();
        String mobile = mobile();
        String emailAddress = emailAddress();

        personal.addContactInformation();
        myRequests = new MyRequests();
        myRequests.chnagePersonalData("Change Personal Data", false, "", "", "", "", "",
                "", "", "", "", "", "", mobile, emailAddress, "", "", "",
                true, false);

        mainScreen.myProfile("Personal");
        personal.openContactInformation();

        softAssert.assertEquals(personal.getContactInformation("Mobile"), mobile, "- Mobile!");
        softAssert.assertEquals(personal.getContactInformation("Email"), emailAddress, "- Email!");
        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "MyProfilePersonal")
    public void myProfile_Personal_CheckContactInformation(){

        /////////////// Web Initialize //////////////
        systemInitialize();

        login = new Login();
        login.auto_mob1();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        String mobile = mobile();
        String email = emailAddress();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", mobile, email, "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = personnel.employeeCodeGetter();
        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1","automation", false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openContactInformation();

        softAssert.assertEquals(personal.getContactInformation("Mobile"), mobile, "- Mobile!");
        softAssert.assertEquals(personal.getContactInformation("Email"), email, "- Email!");
        softAssert.assertEquals(personal.getContactInformation("Site"), "New Zarqa", "- Site!");
        softAssert.assertEquals(personal.getContactInformation("Departments"), "Quality", "- Department!");
        softAssert.assertEquals(personal.getContactInformation("Hiring Date"), "01.01.2020", "- Hiring Date!");
        softAssert.assertEquals(personal.getContactInformation("Marital Status"), "Single", "- Marital Status!");
        softAssert.assertAll();

    }


}
