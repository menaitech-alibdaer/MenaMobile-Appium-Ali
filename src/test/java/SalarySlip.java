import bases.BaseTest;
import mobileBackend.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.financialInformation.Insurance;
import webBackend.financialInformation.TaxAndDeduction;
import webBackend.general.*;
import webBackend.personnelInformation.Other;
import webBackend.personnelInformation.PersonnelInformation;
import webBackend.salaryCalculation.SalaryCalculation;

import static utilities.FindAndTransferPdf.getPDF;
import static utilities.MssqlConnect.menaMeRestPassword;
import static utilities.PDFReader.getDataFromPdf;
import static utilities.WebHelper.*;

public class SalarySlip extends BaseTest {

    PersonnelInformation personnel;
    FinancialPackage financial;
    Insurance insurance;
    TaxAndDeduction tax;
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

    @Test(priority = 1, groups = "Salary Slip")
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

    @Test(priority = 2, groups = "Salary Slip")
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

    @Test(priority = 3, groups = "Salary Slip")
    public void checkSalarySlipTabIfNotHavePermissionFromMenameSecuritySetup(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Financial");

        Assert.assertFalse(mainScreen.checkSalarySlipIfAppear(), "Salary Slip Tab should be NOT appear!");

    }

    @Test(priority = 4, groups = "Salary Slip")
    public void checkLastSalaryInMainScreen(){

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
        financial.addAllowances("Fixed Allowance", "200", "", "", "", "");

        mainMenu.mainMenu("Workforce Management", "Salary Calculation");
        calculation = new SalaryCalculation();
        calculation.salaryCalculation_WithoutViewReport(employeeCode, "2024", "01", true);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();

        Assert.assertEquals(mainScreen.getLastSalary(), "1200.000", "Issue in Last Salary appeared in Main Screen!");

    }

    @Test(priority = 5, groups = "Salary Slip")
    public void checkAllFieldsInSalarySlip(){

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
        financial.addAllowances("Fixed Allowance", "200", "", "", "", "");
        financial.addAllowances("Percent Allowance", "10", "", "", "", "");

        insurance = new Insurance();
        insurance.socialSecurity(true, false, false, "Social Security",
                "", "", true, false);

        mainMenu.mainMenu("Workforce Management", "Salary Calculation");
        calculation = new SalaryCalculation();
        calculation.salaryCalculation(employeeCode, "2024", "01");

        String worthSalary = calculation.worthSalaryMonth();
        String fixedAllowance = calculation.fixedAllowanceMonth();
        String percentAllowance = calculation.percentAllowanceMonth();
        String totalIncome = calculation.totalIncomeMonth();
        String totalDeduction = calculation.totalDeductionsMonth();
        String netSalary = calculation.netSalaryMonth();
        String overtime = calculation.overtimeMonth();
        String otherIncome = calculation.otherIncomeMonth();

        calculation.closeSalaryReport();
        calculation.releaseToMenaME();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Financial");

        salarySlip = new SalarySlipBE();
        salarySlip.openSalarySlip();

        softAssert.assertEquals(salarySlip.getRecentSalarySlip(), "January (01) - 2024", "Recent Salary Month!");
        softAssert.assertEquals(salarySlip.netSalary(), "1202.500", "Net Salary!");
        softAssert.assertEquals(salarySlip.income(), "1300.000", "Income!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Worth Salary"), "1000.000", "Worth Salary!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Overtime"), "0.000", "Overtime!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Other Income"), "0.000", "Other Income!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Fixed Allowance"), "200.000", "Fixed Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Percent Allowance"), "100.000", "Percent Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Paid Vacations"), "0.000", "Paid Vacations!");
        softAssert.assertEquals(salarySlip.deduction_Amount(), "97.500", "Deduction Amount!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Tax"), "0.000", "Tax!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Insurance"), "0.000", "Insurance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Other Deductions"), "0.000", "Other Deductions!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Loan"), "0.000", "Loan!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Provident Fund"), "0.000", "Provident Fund!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Social Security"), "97.500", "Social Security!");
        softAssert.assertEquals(salarySlip.deduction_Period(), "0", "Deduction Period!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Leave"), "0", "Leave!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Vacation"), "0", "Vacation!");
        softAssert.assertEquals(salarySlip.PF_Balance(), "0.000", "PF Balance!");

        salarySlip.downloadSalarySlip();
        salarySlip.savePdfInDevice(employeeCode);
        getPDF("/sdcard/Download/", employeeCode+".pdf");
        mainScreen.android_Back();

        softAssert.assertEquals(worthSalary, getDataFromPdf(employeeCode, "Worth Salary"), "- Worth Salary!");
        softAssert.assertEquals(fixedAllowance, getDataFromPdf(employeeCode, "Fixed Allowance"), "- Fixed Allowance!");
        softAssert.assertEquals(percentAllowance, getDataFromPdf(employeeCode, "Percent Allowance"), "- Percent Allowance!");
        softAssert.assertEquals(overtime, getDataFromPdf(employeeCode, "Overtime"), "- Overtime!");
        softAssert.assertEquals(otherIncome, getDataFromPdf(employeeCode, "Other Income"), "- Other Income!");
        softAssert.assertEquals(totalIncome, getDataFromPdf(employeeCode, "Total Income"), "- Total Income!");
        softAssert.assertEquals(totalDeduction, getDataFromPdf(employeeCode, "Total Deductions"), "- Total Deductions!");
        softAssert.assertEquals(netSalary, getDataFromPdf(employeeCode, "Net Salary (Month Jan)")+" JOD", "- Net Salary!");

        softAssert.assertAll();

    }

    @Test(priority = 5, groups = "Salary Slip")
    public void addAllTransactionToEmployeeAndCheckAllFieldsInSalarySlip(){

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
        financial.setBasicSalary("2000");
        financial.addAllowances("Fixed Allowance", "200", "", "", "", "");
        financial.addAllowances("Percent Allowance", "10", "", "", "", "");
        financial.addAllowances("Transportation Allowance", "100", "", "", "", "");

        insurance = new Insurance();
        insurance.healthInsurance(true, "Health insurance - Fixed", "", "", "", false);
        insurance.socialSecurity(true, false, false, "Social Security",
                "", "", true, false);

        tax = new TaxAndDeduction();
        tax.taxable(true, true);
        //tax.permanentDeductions("Permanent Deduction 1", "", "", "");

        mainMenu.mainMenu("Workforce Management","Employees Transactions Leave");
        transactions = new EmployeesTransactions();
        transactions.vacation(employeeCode, "01/06/2024", "01/06/2024", "Unpaid Vacation", true);
        transactions.leave(employeeCode, "06/06/2024", "Unpaid Leave", "5");

        mainMenu.mainMenu("Workforce Management","Employees Transactions");
        transactions.overtime(employeeCode, "08/06/2024", "Holiday Overtime", "2", true);
        transactions.overtime(employeeCode, "09/06/2024", "Holiday Overtime", "2", true);
        transactions.loans(employeeCode, "01/06/2024", "Car Loan", "1200", "12", "");
        transactions.otherIncome(employeeCode, "10/06/2024", "Choose", "Other Income 1", "100", "");
        transactions.otherDeductions(employeeCode, "12/06/2024", "Choose", "", "Other Deduction 1", "50", "", "", true);

        mainMenu.mainMenu("Workforce Management", "Salary Calculation");
        calculation = new SalaryCalculation();
        calculation.salaryCalculation(employeeCode, "2024", "06");

        String worthSalary = calculation.worthSalaryMonth();
        String fixedAllowance = calculation.fixedAllowanceMonth();
        String percentAllowance = calculation.percentAllowanceMonth();
        String otherAllowances = calculation.otherAllowances();
        String totalIncome = calculation.totalIncomeMonth();
        String totalDeduction = calculation.totalDeductionsMonth();
        String netSalary = calculation.netSalaryMonth();
        String overtime = calculation.overtimeMonth();
        String otherIncome = calculation.otherIncomeMonth();
        String paidVacations = calculation.paidVacations();
        String absence = calculation.absenceMonth();
        String basicSalary = calculation.basicSalary();
        String incomeTax = calculation.incomeTax();
        String nationalContribution = calculation.nationalContribution();
        String serviceTax = calculation.serviceTax();
        String providentFund = calculation.providentFund();
        String socialSecurity = calculation.socialSecurityMonth();
        String healthInsurance = calculation.healthInsuranceMonth();
        String monthlyLoans = calculation.monthlyLoans();
        String otherDeductions = calculation.otherDeductionsMonth();

        calculation.closeSalaryReport();
        calculation.releaseToMenaME();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Financial");

        salarySlip = new SalarySlipBE();
        salarySlip.openSalarySlip();

        softAssert.assertEquals(salarySlip.getRecentSalarySlip(), "June (06) - 2024", "Recent Salary Month!");
        softAssert.assertEquals(salarySlip.netSalary()+" JOD", netSalary, "Net Salary!");
        softAssert.assertEquals(salarySlip.income(), totalIncome, "Income!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Worth Salary"), worthSalary, "Worth Salary!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Overtime"), overtime, "Overtime!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Other Income"), otherIncome, "Other Income!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Fixed Allowance"), fixedAllowance, "Fixed Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Percent Allowance"), percentAllowance, "Percent Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Transportation Allowance"), otherAllowances, "Transportation Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Paid Vacations"), paidVacations, "Paid Vacations!");
        softAssert.assertEquals(salarySlip.deduction_Amount(), totalDeduction, "Deduction Amount!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Tax"), incomeTax, "Tax!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Insurance"), healthInsurance, "Insurance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Other Deductions"), otherDeductions, "Other Deductions!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Loan"), monthlyLoans, "Loan!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Provident Fund"), providentFund, "Provident Fund!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Social Security"), socialSecurity, "Social Security!");
        softAssert.assertEquals(salarySlip.deduction_Period(), "6", "Deduction Period!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Leave"), "5", "Leave!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Vacation"), "1", "Vacation!");
        softAssert.assertEquals(salarySlip.PF_Balance(), "0.000", "PF Balance!");

        salarySlip.downloadSalarySlip();
        salarySlip.savePdfInDevice(employeeCode);
        getPDF("/sdcard/Download/", employeeCode+".pdf");
        mainScreen.android_Back();

        softAssert.assertEquals(employeeCode, getDataFromPdf(employeeCode, "Employee Code"), "- Employee Code!");
        softAssert.assertEquals(basicSalary, getDataFromPdf(employeeCode, "Basic Salary"), "- Basic Salary!");
        softAssert.assertEquals(otherAllowances, getDataFromPdf(employeeCode, "Other Allowances"), "- Other Allowances!");
        softAssert.assertEquals(overtime, getDataFromPdf(employeeCode, "Overtime"), "- Overtime!");
        softAssert.assertEquals(paidVacations, getDataFromPdf(employeeCode, "Paid Vacations"), "- Paid Vacations!");
        softAssert.assertEquals(otherIncome, getDataFromPdf(employeeCode, "Other Income"), "- Other Income!");
        softAssert.assertEquals(totalIncome, getDataFromPdf(employeeCode, "Total Income"), "- Total Income!");
        softAssert.assertEquals(incomeTax, getDataFromPdf(employeeCode, "Income Tax"), "- Income Tax!");
        softAssert.assertEquals(nationalContribution, getDataFromPdf(employeeCode, "National Contribution"), "- National Contribution!");
        softAssert.assertEquals(serviceTax, getDataFromPdf(employeeCode, "Service Tax"), "- Service Tax!");
        softAssert.assertEquals(socialSecurity, getDataFromPdf(employeeCode, "Social Security"), "- Social Security!");
        softAssert.assertEquals(healthInsurance, getDataFromPdf(employeeCode, "Health Insurance"), "- Health Insurance!");
        softAssert.assertEquals(providentFund, getDataFromPdf(employeeCode, "Provident Fund"), "- Provident Fund!");
        softAssert.assertEquals(monthlyLoans, getDataFromPdf(employeeCode, "Monthly Loans"), "- Monthly Loans!");
        softAssert.assertEquals(otherDeductions, getDataFromPdf(employeeCode, "Other Deductions"), "- Other Deductions!");
        softAssert.assertEquals(totalDeduction, getDataFromPdf(employeeCode, "Total Deductions"), "- Total Deductions!");
        softAssert.assertEquals(netSalary, getDataFromPdf(employeeCode, "Net Salary (Month Jun)")+" JOD", "- Net Salary!");
        softAssert.assertEquals(fixedAllowance, getDataFromPdf(employeeCode, "Fixed Allowance"), "- Fixed Allowance!");
        softAssert.assertEquals(percentAllowance, getDataFromPdf(employeeCode, "Percent Allowance"), "- Percent Allowance!");
        softAssert.assertEquals(otherAllowances, getDataFromPdf(employeeCode, "Transportation Allowance"), "- Transportation Allowance!");

        softAssert.assertAll();

    }

    @Test(priority = 5, groups = "Salary Slip")
    public void addAllTransactionToEmployeeAndCheckAllFieldsInSalarySlip_checkSalarySlipIn_MSS(){

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
        String directManager = personnel.employeeCodeGetter();
        menaMeRestPassword(directManager);

        mainMenu.mainMenu("Employees","Personnel Information");
        String fn = firstName();
        String sn = secondName();
        String tn = thirdName();
        String ln = lastName();
        personnel.personalInformation(fn, sn, tn, ln, "Single", "Male", "Jordanian",
                "", "", "", directManager, "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        String employee = personnel.employeeCodeGetter();
        menaMeRestPassword(employee);

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employee);
        financial.setBasicSalary("2000");
        financial.addAllowances("Fixed Allowance", "200", "", "", "", "");
        financial.addAllowances("Percent Allowance", "10", "", "", "", "");
        financial.addAllowances("Transportation Allowance", "100", "", "", "", "");

        insurance = new Insurance();
        insurance.healthInsurance(true, "Health insurance - Fixed", "", "", "", false);
        insurance.socialSecurity(true, false, false, "Social Security",
                "", "", true, false);

        tax = new TaxAndDeduction();
        tax.taxable(true, true);
        //tax.permanentDeductions("Permanent Deduction 1", "", "", "");

        mainMenu.mainMenu("Workforce Management","Employees Transactions Leave");
        transactions = new EmployeesTransactions();
        transactions.vacation(employee, "01/06/2024", "01/06/2024", "Unpaid Vacation", true);
        transactions.leave(employee, "06/06/2024", "Unpaid Leave", "5");

        mainMenu.mainMenu("Workforce Management","Employees Transactions");
        transactions.overtime(employee, "08/06/2024", "Holiday Overtime", "2", true);
        transactions.overtime(employee, "09/06/2024", "Holiday Overtime", "2", true);
        transactions.loans(employee, "01/06/2024", "Car Loan", "1200", "12", "");
        transactions.otherIncome(employee, "10/06/2024", "Choose", "Other Income 1", "100", "");
        transactions.otherDeductions(employee, "12/06/2024", "Choose", "", "Other Deduction 1", "50", "", "", true);

        mainMenu.mainMenu("Workforce Management", "Salary Calculation");
        calculation = new SalaryCalculation();
        calculation.salaryCalculation(employee, "2024", "06");

        String worthSalary = calculation.worthSalaryMonth();
        String fixedAllowance = calculation.fixedAllowanceMonth();
        String percentAllowance = calculation.percentAllowanceMonth();
        String otherAllowances = calculation.otherAllowances();
        String totalIncome = calculation.totalIncomeMonth();
        String totalDeduction = calculation.totalDeductionsMonth();
        String netSalary = calculation.netSalaryMonth();
        String overtime = calculation.overtimeMonth();
        String otherIncome = calculation.otherIncomeMonth();
        String paidVacations = calculation.paidVacations();
        String absence = calculation.absenceMonth();
        String basicSalary = calculation.basicSalary();
        String incomeTax = calculation.incomeTax();
        String nationalContribution = calculation.nationalContribution();
        String serviceTax = calculation.serviceTax();
        String providentFund = calculation.providentFund();
        String socialSecurity = calculation.socialSecurityMonth();
        String healthInsurance = calculation.healthInsuranceMonth();
        String monthlyLoans = calculation.monthlyLoans();
        String otherDeductions = calculation.otherDeductionsMonth();

        calculation.closeSalaryReport();
        calculation.releaseToMenaME();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(directManager, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.myTeam(fn + " " + ln);
        manager.openSalarySlip();

        salarySlip = new SalarySlipBE();
        softAssert.assertEquals(salarySlip.getRecentSalarySlip(), "June (06) - 2024", "Recent Salary Month!");
        softAssert.assertEquals(salarySlip.netSalary()+" JOD", netSalary, "Net Salary!");
        softAssert.assertEquals(salarySlip.income(), totalIncome, "Income!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Worth Salary"), worthSalary, "Worth Salary!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Overtime"), overtime, "Overtime!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Other Income"), otherIncome, "Other Income!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Fixed Allowance"), fixedAllowance, "Fixed Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Percent Allowance"), percentAllowance, "Percent Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Transportation Allowance"), otherAllowances, "Transportation Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Paid Vacations"), paidVacations, "Paid Vacations!");
        softAssert.assertEquals(salarySlip.deduction_Amount(), totalDeduction, "Deduction Amount!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Tax"), incomeTax, "Tax!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Insurance"), healthInsurance, "Insurance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Other Deductions"), otherDeductions, "Other Deductions!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Loan"), monthlyLoans, "Loan!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Provident Fund"), providentFund, "Provident Fund!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Social Security"), socialSecurity, "Social Security!");
        softAssert.assertEquals(salarySlip.deduction_Period(), "6", "Deduction Period!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Leave"), "5", "Leave!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Vacation"), "1", "Vacation!");

        softAssert.assertAll();

    }

    @Test
    public void test(){

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
