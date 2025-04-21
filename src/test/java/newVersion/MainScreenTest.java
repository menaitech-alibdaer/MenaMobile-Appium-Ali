package newVersion;

import apiBackend.AllEmployeeTransactions;
import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import bases.BaseTest;
import mobileBackend.*;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import webBackend.general.VacationsBalances;
import webBackend.personnelInformation.Other;
import webBackend.personnelInformation.PersonnelInformation;

import static utilities.WebHelper.currentYear;

public class MainScreenTest extends BaseTest {

    MobileLogin loginMob;
    MainScreen mainScreen;
    CompanyAndBranch companyAndBranch;
    Employees employees;
    apiBackend.SalaryCalculation salaryCalculation;
    String employeeCode = null;

    @Test
    public void checkAllTheBoxInHomeScreen(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.addAllowance("Fixed Allowance", "200", "", "", "", true);
        employees.addAllowance("Percent Allowance", "10", "", "", "", true);
        employees.addAllowance("Transportation Allowance", "100", "", "", "", true);

        employees.addVacationBalance("Annual Vacation", "0", "14", currentYear(), currentYear()+"-01-01", currentYear()+"-12-31", true);
        employees.addVacationBalance("Sick Vacation", "0", "14", currentYear(), currentYear()+"-01-01", currentYear()+"-12-31", false);

        salaryCalculation = new apiBackend.SalaryCalculation();
        salaryCalculation.salaryCalculation(employeeCode, "2025", "3", true);
        salaryCalculation.getSalarySlip(employeeCode, 2025, 3);

        String annualCurrentBalance = employees.getVacationCurrentBalance(employeeCode, "Annual Vacation", Integer.parseInt(currentYear()));
        String SickCurrentBalance = employees.getVacationCurrentBalance(employeeCode, "Sick Vacation", Integer.parseInt(currentYear()));

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();

        softAssert.assertTrue(mainScreen.annualVacationBox(), "Annual Vacation!");
        softAssert.assertTrue(mainScreen.sickVacationBox(), "Sick Vacation!");
        softAssert.assertEquals(mainScreen.getCurrentBalance_AnnualVacation(), annualCurrentBalance, "Annual Vacation - Current Balance!");
        softAssert.assertEquals(mainScreen.getUpToEndOfYear_AnnualVacation(), "14.000", "Annual Vacation - Up To End Of Year!");
        softAssert.assertEquals(mainScreen.getCurrentBalance_SickVacation(), SickCurrentBalance, "Sick Vacation - Current Balance!");
        softAssert.assertEquals(mainScreen.getUpToEndOfYear_SickVacation(), "14.000", "Sick Vacation - Up To End Of Year!");
        softAssert.assertTrue(mainScreen.loanBalanceBox(), "Loan Balance!");
        softAssert.assertEquals(mainScreen.loanBalanceAmount(), "0.000", "Loan Balance Amount!");
        softAssert.assertTrue(mainScreen.stbBalanceBox(), "STB Balance!");
        softAssert.assertEquals(mainScreen.stbBalanceAmount(), "0.000", "STB Balance Amount!");
        softAssert.assertTrue(mainScreen.lastSalaryBox(), "Last Salary!");
        softAssert.assertEquals(mainScreen.lastSalaryAmount(), "1400.000", "Last Salary Amount!");
        softAssert.assertAll();

    }

}
