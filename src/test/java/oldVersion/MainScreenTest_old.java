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
import webBackend.salaryCalculation.SalaryCalculation;

import static utilities.MssqlConnect.menaMeRestPassword;
import static utilities.WebHelper.currentYear;

public class MainScreenTest_old extends BaseTest {

    MobileLogin loginMob;
    MainScreen mainScreen;
    PersonnelInformation personnel;
    FinancialPackage financial;
    VacationsBalances vacationsBalances;
    Other other;
    Login login;
    MenaModules menaModules;
    Substitutes substitutes;
    MainMenu mainMenu;
    SalaryCalculation calculation;
    EmployeesTransactions transactions;
    String employeeCode = null;
    Notifications notifications;
    MyTransactions myTransactions;
    MyRequests myRequests;
    Manager manager;

//    @Test
//    public void testBoxesInHomeScreen(){
//
//        /////////////// Mobile Initialize //////////////
//        mobileInitialize();
//
//        loginMob = new MobileLogin();
//        loginMob.login("vuxn60250", "1", "auto_mob1", "automation", false);
//
//        mainScreen = new MainScreen();
//
//        softAssert.assertTrue(mainScreen.annualVacationBox(), "Annual Vacation!");
//        softAssert.assertTrue(mainScreen.sickVacationBox(), "Sick Vacation!");
//        softAssert.assertEquals(mainScreen.getCurrentBalance_AnnualVacation(), "13.540");
//        softAssert.assertEquals(mainScreen.getUpToEndOfYear_AnnualVacation(), "14.000");
//        softAssert.assertEquals(mainScreen.getCurrentBalance_SickVacation(), "14.000");
//        softAssert.assertEquals(mainScreen.getUpToEndOfYear_SickVacation(), "14.000");
//        softAssert.assertTrue(mainScreen.loanBalanceBox(), "Loan Balance!");
//        softAssert.assertEquals(mainScreen.loanBalanceAmount(), "1100");
//        softAssert.assertTrue(mainScreen.stbBalanceBox(), "STB Balance!");
//        softAssert.assertEquals(mainScreen.stbBalanceAmount(), "0.000");
//        softAssert.assertTrue(mainScreen.lastSalaryBox(), "Last Salary!");
//        softAssert.assertEquals(mainScreen.lastSalaryAmount(), "1946.666");
//        softAssert.assertAll();
//
//    }

    @Test(priority = 1, groups = "MainScreen")
    public void checkAllTheBoxInHomeScreen(){

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

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");
        financial.addAllowances("Fixed Allowance", "200", "", "", "", "");
        financial.addAllowances("Percent Allowance", "10", "", "", "", "");
        financial.addAllowances("Transportation Allowance", "100", "", "", "", "");

        mainMenu.mainMenu("Workforce Management","Vacations Balances");
        vacationsBalances = new VacationsBalances();
        vacationsBalances.addBalance(employeeCode, "Annual Vacation", "0.000", "14", currentYear(), "01/01/"+currentYear(), "31/12/"+currentYear(), false);
        vacationsBalances.addBalance(employeeCode, "Sick Vacation", "0.000", "14", currentYear(), "01/01/"+currentYear(), "31/12/"+currentYear(), false);

        String annualCurrentBalance = vacationsBalances.getCurrentBalance(employeeCode, "Annual Vacation");
        String SickCurrentBalance = vacationsBalances.getCurrentBalance(employeeCode, "Sick Vacation");

        mainMenu.mainMenu("Workforce Management","Employees Transactions");
        transactions = new EmployeesTransactions();
        transactions.loans(employeeCode, "01/01/2025", "Car Loan", "1200", "12", "");

        mainMenu.mainMenu("Workforce Management", "Salary Calculation");
        calculation = new SalaryCalculation();
        calculation.salaryCalculation_WithoutViewReport(employeeCode, "2025", "03", true);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1","automation", false);

        mainScreen = new MainScreen();

        softAssert.assertTrue(mainScreen.annualVacationBox(), "Annual Vacation!");
        softAssert.assertTrue(mainScreen.sickVacationBox(), "Sick Vacation!");
        softAssert.assertEquals(mainScreen.getCurrentBalance_AnnualVacation(), annualCurrentBalance, "Annual Vacation - Current Balance!");
        softAssert.assertEquals(mainScreen.getUpToEndOfYear_AnnualVacation(), "14.000", "Annual Vacation - Up To End Of Year!");
        softAssert.assertEquals(mainScreen.getCurrentBalance_SickVacation(), SickCurrentBalance, "Sick Vacation - Current Balance!");
        softAssert.assertEquals(mainScreen.getUpToEndOfYear_SickVacation(), "14.000", "Sick Vacation - Up To End Of Year!");
        softAssert.assertTrue(mainScreen.loanBalanceBox(), "Loan Balance!");
        softAssert.assertEquals(mainScreen.loanBalanceAmount(), "1100", "Loan Balance Amount!");
        softAssert.assertFalse(mainScreen.stbBalanceBox(), "STB Balance!");
        //softAssert.assertEquals(mainScreen.stbBalanceAmount(), "0.000", "STB Balance Amount!");
        softAssert.assertTrue(mainScreen.lastSalaryBox(), "Last Salary!");
        softAssert.assertEquals(mainScreen.lastSalaryAmount(), "1400.000", "Last Salary Amount!");
        softAssert.assertAll();

    }

}
