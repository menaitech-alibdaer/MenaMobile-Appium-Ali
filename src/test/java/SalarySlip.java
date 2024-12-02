import bases.BaseTest;
import mobileBackend.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.general.*;
import webBackend.personnelInformation.Other;
import webBackend.personnelInformation.PersonnelInformation;
import webBackend.salaryCalculation.SalaryCalculation;

import static utilities.MssqlConnect.menaMeRestPassword;

public class SalarySlip extends BaseTest {

    PersonnelInformation personnel;
    FinancialPackage financial;
    VacationsBalances vacationsBalances;
    Other other;
    Login login;
    MenaModules menaModules;
    Substitutes substitutes;
    MainMenu mainMenu;
    EmployeesTransactions transactions;
    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;
    Notifications notifications;
    MyTransactions myTransactions;
    MyRequests myRequests;
    Manager manager;
    SalaryCalculation calculation;
    SalarySlipBE salarySlip;

    @Test(priority = 1, groups = "Vacations")
    public void checkAlertValidationInSalarySlipWhenSalaryCalculationWithoutReleaseToMenaME(){

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
        menaMeRestPassword(employeeCode);

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");

        mainMenu.mainMenu("Workforce Management", "Salary Calculation");
        calculation = new SalaryCalculation();
        calculation.salaryCalculation_WithoutViewReport(employeeCode, "2024", "01", false);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Financial");

        salarySlip = new SalarySlipBE();
        salarySlip.openSalarySlip();
        salarySlip.openRecentSalarySlip();

        Assert.assertTrue(salarySlip.checkToastAlert("Invalid Data"), "Alert Issue - shoud be appear: Returned Invalid Data!");

    }

    @Test(priority = 1, groups = "Vacations")
    public void calculateTwoMonthAndCheckTheRecentMonthCalculatedViewInSalarySlip(){

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
        menaMeRestPassword(employeeCode);

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");

        mainMenu.mainMenu("Workforce Management", "Salary Calculation");
        calculation = new SalaryCalculation();
        calculation.salaryCalculation_WithoutViewReport(employeeCode, "2024", "01", true);
        calculation.salaryCalculation_WithoutViewReport(employeeCode, "2024", "02", true);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Financial");

        salarySlip = new SalarySlipBE();
        salarySlip.openSalarySlip();

        Assert.assertEquals(salarySlip.getRecentSalarySlip(), "February (02) - 2024");

    }

    @Test(priority = 1, groups = "Vacations")
    public void checkSalarySlipTabIfNotHavePermissionFromMenameSecuritySetup(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Financial");

        Assert.assertFalse(mainScreen.checkSalarySlipIfAppear(), "Salary Slip Tab should be NOT appear!");

    }

}
