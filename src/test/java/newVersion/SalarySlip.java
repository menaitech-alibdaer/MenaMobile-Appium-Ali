package newVersion;

import apiBackend.AllEmployeeTransactions;
import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import apiBackend.Settings;
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

import static utilities.MssqlConnect.menaMeRestPassword;
import static utilities.MssqlConnect.setMenaMePassword;
import static utilities.WebHelper.*;

public class SalarySlip extends BaseTest {


    String employeeCode = null;
    MobileLogin loginMob;
    MainScreen mainScreen;
    Manager manager;
    SalarySlipBE salarySlip;

    CompanyAndBranch companyAndBranch;
    Employees employees;
    apiBackend.SalaryCalculation salaryCalculation;
    AllEmployeeTransactions allEmployeeTransactions;

    @Test(priority = 1, groups = "Salary Slip")
    public void checkAlertValidationInSalarySlipWhenSalaryCalculationWithoutReleaseToMenaME(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1980-01-01", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.entitledToOvertime(employeeCode);

        salaryCalculation = new apiBackend.SalaryCalculation();
        salaryCalculation.salaryCalculation(employeeCode, "2024", "1", false);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Financial");

        salarySlip = new SalarySlipBE();
        salarySlip.openSalarySlip();
//        salarySlip.openRecentSalarySlip();

        Assert.assertTrue(salarySlip.checkAlertPopup("Salary Has Not Been Released Yet"), "Alert Issue - shoud be appear: Salary Has Not Been Released Yet!");

    }

    @Test(priority = 2, groups = "Salary Slip")
    public void calculateTwoMonthAndCheckTheRecentMonthCalculatedViewInSalarySlip(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1980-01-01", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.entitledToOvertime(employeeCode);

        salaryCalculation = new apiBackend.SalaryCalculation();
        salaryCalculation.salaryCalculation(employeeCode, "2024", "1", true);
        salaryCalculation.salaryCalculation(employeeCode, "2024", "2", true);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Financial");

        salarySlip = new SalarySlipBE();
        salarySlip.openSalarySlip();

        Assert.assertEquals(salarySlip.getRecentSalarySlip(), "February (2) - 2024");

    }

    @Test(priority = 3, groups = "Salary Slip")
    public void checkSalarySlipTabIfNotHavePermissionFromMenameSecuritySetup(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        setMenaMePassword("auto_mobile2", "Revamp");
        loginMob.login("auto_mobile2", "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Financial");

        Assert.assertFalse(mainScreen.checkSalarySlipIfAppear(), "Salary Slip Tab should be NOT appear!");

    }

    @Test(priority = 4, groups = "Salary Slip")
    public void checkLastSalaryInMainScreen(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1980-01-01", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.entitledToOvertime(employeeCode);
        employees.addAllowance("Fixed Allowance", "200", "", "", "", true);

        salaryCalculation = new apiBackend.SalaryCalculation();
        salaryCalculation.salaryCalculation(employeeCode, "2024", "1", true);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        Assert.assertEquals(mainScreen.lastSalaryAmount(), "1200.000", "Issue in Last Salary appeared in Main Screen!");

    }

    @Test(priority = 5, groups = "Salary Slip")
    public void checkAllFieldsInSalarySlip(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1980-01-01", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.entitledToOvertime(employeeCode);
        employees.addAllowance("Fixed Allowance", "200", "", "", "", true);
        employees.addAllowance("Percent Allowance", "10", "", "", "", true);
        employees.addSocialSecurity("Social Security", "", "", false);

        salaryCalculation = new apiBackend.SalaryCalculation();
        salaryCalculation.salaryCalculation(employeeCode, "2024", "1", true);
//        salaryCalculation.getSalarySlip(employeeCode, 2024, 1);
//
//        String worthSalary = salaryCalculation.worthSalaryMonth();
//        String fixedAllowance = salaryCalculation.fixedAllowanceMonth();
//        String percentAllowance = salaryCalculation.percentAllowanceMonth();
//        String totalIncome = salaryCalculation.totalIncomeMonth();
//        String totalDeduction = salaryCalculation.totalDeductionsMonth();
//        String netSalary = salaryCalculation.netSalaryMonth();
//        String overtime = salaryCalculation.overtimeMonth();
//        String otherIncome = salaryCalculation.otherIncomeMonth();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Financial");

        salarySlip = new SalarySlipBE();
        salarySlip.openSalarySlip();

        softAssert.assertEquals(salarySlip.getRecentSalarySlip(), "January (1) - 2024", "Recent Salary Month!");
        softAssert.assertEquals(salarySlip.netSalary(), "1225.000", "Net Salary!");
        softAssert.assertEquals(salarySlip.income(), "1300.000", "Income!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Worth Salary"), "1000.000", "Worth Salary!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Overtime"), "0.000", "Overtime!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Other Income"), "0.000", "Other Income!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Fixed Allowance"), "200.000", "Fixed Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Percent Allowance"), "100.000", "Percent Allowance!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Paid Vacations"), "0.000", "Paid Vacations!");
        softAssert.assertEquals(salarySlip.deduction_Amount(), "75.000", "Deduction Amount!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Tax"), "0.000", "Tax!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Insurance"), "0.000", "Insurance!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Other Deductions"), "0.000", "Other Deductions!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Loan"), "0.000", "Loan!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Provident Fund"), "0.000", "Provident Fund!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Social Security"), "75.000", "Social Security!");
        //softAssert.assertEquals(salarySlip.deduction_Period(), "0", "Deduction Period!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Leave"), "0", "Leave!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Vacation"), "0", "Vacation!");
        //softAssert.assertEquals(salarySlip.PF_Balance(), "0.000", "PF Balance!");

//        salarySlip.downloadSalarySlip();
//        salarySlip.savePdfInDevice(employeeCode);
//        getPDF("/sdcard/Download/", employeeCode+".pdf");
//        mainScreen.android_Back();
//
//        softAssert.assertEquals(worthSalary, PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Worth Salary"), "- Worth Salary!");
//        softAssert.assertEquals(fixedAllowance, PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Fixed Allowance"), "- Fixed Allowance!");
//        softAssert.assertEquals(percentAllowance, PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Percent Allowance"), "- Percent Allowance!");
//        softAssert.assertEquals(overtime, PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Overtime"), "- Overtime!");
//        softAssert.assertEquals(otherIncome, PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Other Income"), "- Other Income!");
//        softAssert.assertEquals(totalIncome, PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Total Income"), "- Total Income!");
//        softAssert.assertEquals(totalDeduction, PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Total Deductions"), "- Total Deductions!");
//        softAssert.assertEquals(netSalary, PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Net Salary")+" JOD", "- Net Salary!");

        softAssert.assertAll();

    }

    @Test(priority = 5, groups = "Salary Slip")
    public void addAllTransactionToEmployeeAndCheckAllFieldsInSalarySlip(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1980-01-01", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("2000");
        employees.entitledToOvertime(employeeCode);
        employees.addAllowance("Fixed Allowance", "200", "", "", "", true);
        employees.addAllowance("Percent Allowance", "10", "", "", "", true);
        employees.addAllowance("Transportation Allowance", "100", "", "", "", true);
        employees.addSocialSecurity("Social Security", "", "", false);
        employees.healthInsurance("Health insurance - Fixed", "", "");

        salaryCalculation = new apiBackend.SalaryCalculation();
        salaryCalculation.taxable(true, "Tax", true, false);

        allEmployeeTransactions = new AllEmployeeTransactions();
        allEmployeeTransactions.vacation(employeeCode, "2024-06-01", "2024-06-01", "Unpaid Vacation", true);
        allEmployeeTransactions.leave(employeeCode, "2024-06-06", "2024-06-06", "Unpaid Leave", "5", true);
        allEmployeeTransactions.overtime(employeeCode, "2024-06-08", "2024-06-08", "Holiday Overtime", "2", true);
        allEmployeeTransactions.overtime(employeeCode, "2024-06-09", "2024-06-09", "Holiday Overtime", "2", true);
        allEmployeeTransactions.loans(employeeCode, "2024-06-01", "2024-06-01", "Car Loan", "1200", "12", true);
        allEmployeeTransactions.otherIncome(employeeCode, "2024-06-10", false, "", "Other Income 1", "100", true);
        allEmployeeTransactions.otherDeductions(employeeCode, "2024-06-12", "Other Deduction 1", "50", false, "", true);

        salaryCalculation = new apiBackend.SalaryCalculation();
        salaryCalculation.salaryCalculation(employeeCode, "2024", "6", true);
        salaryCalculation.getSalarySlip(employeeCode, 2024, 6);

        String worthSalary = salaryCalculation.worthSalaryMonth();
        String fixedAllowance = salaryCalculation.fixedAllowanceMonth();
        String percentAllowance = salaryCalculation.percentAllowanceMonth();
        String transportationAllowance = salaryCalculation.TransportationAllowanceMonth();
        String totalIncome = salaryCalculation.totalIncomeMonth();
        String totalDeduction = salaryCalculation.totalDeductionsMonth();
        String netSalary = salaryCalculation.netSalaryMonth();
        String overtime = salaryCalculation.overtimeMonth();
        String otherIncome = salaryCalculation.otherIncomeMonth();
        String socialSecurity = salaryCalculation.socialSecurityMonth();
        String healthInsurance = salaryCalculation.healthInsuranceMonth();
        String monthlyLoans = salaryCalculation.monthlyLoans();
        String otherDeductions = salaryCalculation.otherDeductionsMonth();
        //String otherAllowances = salaryCalculation.otherAllowances();
        //String paidVacations = salaryCalculation.paidVacations();
        //String absence = salaryCalculation.absenceMonth();
        //String basicSalary = salaryCalculation.basicSalary();
        //String incomeTax = salaryCalculation.incomeTax();
        //String nationalContribution = salaryCalculation.nationalContribution();
        //String serviceTax = salaryCalculation.serviceTax();
        //String providentFund = salaryCalculation.providentFund();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Financial");

        salarySlip = new SalarySlipBE();
        salarySlip.openSalarySlip();

        softAssert.assertEquals(salarySlip.getRecentSalarySlip(), "June (6) - 2024", "Recent Salary Month!");
        //softAssert.assertEquals(salarySlip.netSalary()+" JOD", netSalary, "Net Salary!");
        softAssert.assertEquals(salarySlip.netSalary(), netSalary, "Net Salary!");
        softAssert.assertEquals(salarySlip.income(), totalIncome, "Income!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Worth Salary"), worthSalary, "Worth Salary!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Fixed Allowance"), fixedAllowance, "Fixed Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Percent Allowance"), percentAllowance, "Percent Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Transportation Allowance"), transportationAllowance, "Transportation Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Other Income 1"), otherIncome, "Other Income 1!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Holiday Overtime"), overtime, "Holiday Overtime!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Transportation Allowance"), otherAllowances, "Transportation Allowance!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Paid Vacations"), paidVacations, "Paid Vacations!");
        softAssert.assertEquals(salarySlip.deduction_Amount(), totalDeduction, "Deduction Amount!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Tax"), incomeTax, "Tax!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Other Deduction 1"), otherDeductions, "Other Deduction 1!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Car Loan"), monthlyLoans, "Car Loan!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Health insurance - Fixed"), healthInsurance, "Health insurance - Fixed!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Social Security"), socialSecurity, "Social Security!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Provident Fund"), providentFund, "Provident Fund!");
        //softAssert.assertEquals(salarySlip.deduction_Period(), "6", "Deduction Period!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Leave"), "5", "Leave!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Vacation"), "1", "Vacation!");
        //softAssert.assertEquals(salarySlip.PF_Balance(), "0.000", "PF Balance!");

//        salarySlip.downloadSalarySlip();
//        salarySlip.savePdfInDevice(employeeCode);
//        getPDF("/sdcard/Download/", employeeCode+".pdf");
//        mainScreen.android_Back();
//
//        softAssert.assertEquals(employeeCode, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Employee Code"), "- Employee Code!");
//        softAssert.assertEquals(basicSalary, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Basic Salary"), "- Basic Salary!");
//        //softAssert.assertEquals(otherAllowances, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Other Allowances"), "- Other Allowances!");
//        softAssert.assertEquals(overtime, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Overtime"), "- Overtime!");
//        //softAssert.assertEquals(paidVacations, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Paid Vacations"), "- Paid Vacations!");
//        softAssert.assertEquals(otherIncome, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Other Income"), "- Other Income!");
//        softAssert.assertEquals(totalIncome, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Total Income"), "- Total Income!");
//        //softAssert.assertEquals(incomeTax, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Income Tax"), "- Income Tax!");
//        softAssert.assertEquals(nationalContribution, PDFReader.getDataFromSalarySlipPdf(employeeCode, "National Contribution"), "- National Contribution!");
//        //softAssert.assertEquals(serviceTax, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Service Tax"), "- Service Tax!");
//        softAssert.assertEquals(socialSecurity, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Social Security"), "- Social Security!");
//        softAssert.assertEquals(healthInsurance, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Health Insurance"), "- Health Insurance!");
//        //softAssert.assertEquals(providentFund, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Provident Fund"), "- Provident Fund!");
//        softAssert.assertEquals(monthlyLoans, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Monthly Loans"), "- Monthly Loans!");
//        softAssert.assertEquals(otherDeductions, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Other Deductions"), "- Other Deductions!");
//        softAssert.assertEquals(totalDeduction, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Total Deductions"), "- Total Deductions!");
//        softAssert.assertEquals(netSalary, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Net Salary (Month Jun)")+" JOD", "- Net Salary!");
//        softAssert.assertEquals(fixedAllowance, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Fixed Allowance"), "- Fixed Allowance!");
//        softAssert.assertEquals(percentAllowance, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Percent Allowance"), "- Percent Allowance!");
//        //softAssert.assertEquals(otherAllowances, PDFReader.getDataFromSalarySlipPdf(employeeCode, "Transportation Allowance"), "- Transportation Allowance!");

        softAssert.assertAll();

    }

    @Test(priority = 5, groups = "Salary Slip")
    public void addAllTransactionToEmployeeAndCheckAllFieldsInSalarySlip_checkSalarySlipIn_MSS(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1980-01-01", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String directManager = employees.getEmployeeCode();

        employees.createNewEmployee("1980-01-01", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        String employeeName = employees.getFirstAndLastNameEmployee();
        String employeeFullName = employees.getFullNameEmployee();

        employees.setBasicSalary("2000");
        employees.entitledToOvertime(employee);
        employees.addAllowance("Fixed Allowance", "200", "", "", "", true);
        employees.addAllowance("Percent Allowance", "10", "", "", "", true);
        employees.addAllowance("Transportation Allowance", "100", "", "", "", true);
        employees.addSocialSecurity("Social Security", "", "", false);
        employees.healthInsurance("Health insurance - Fixed", "", "");

        salaryCalculation = new apiBackend.SalaryCalculation();
        salaryCalculation.taxable(true, "Tax", true, false);

        allEmployeeTransactions = new AllEmployeeTransactions();
        allEmployeeTransactions.vacation(employee, "2024-06-01", "2024-06-01", "Unpaid Vacation", true);
        allEmployeeTransactions.leave(employee, "2024-06-06", "2024-06-06", "Unpaid Leave", "5", true);
        allEmployeeTransactions.overtime(employee, "2024-06-08", "2024-06-08", "Holiday Overtime", "2", true);
        allEmployeeTransactions.overtime(employee, "2024-06-09", "2024-06-09", "Holiday Overtime", "2", true);
        allEmployeeTransactions.loans(employee, "2024-06-01", "2024-06-01", "Car Loan", "1200", "12", true);
        allEmployeeTransactions.otherIncome(employee, "2024-06-10", false, "", "Other Income 1", "100", true);
        allEmployeeTransactions.otherDeductions(employee, "2024-06-12", "Other Deduction 1", "50", false, "", true);

        salaryCalculation = new apiBackend.SalaryCalculation();
        salaryCalculation.salaryCalculation(employee, "2024", "6", true);
        salaryCalculation.getSalarySlip(employee, 2024, 6);

        String worthSalary = salaryCalculation.worthSalaryMonth();
        String fixedAllowance = salaryCalculation.fixedAllowanceMonth();
        String percentAllowance = salaryCalculation.percentAllowanceMonth();
        String transportationAllowance = salaryCalculation.TransportationAllowanceMonth();
        String totalIncome = salaryCalculation.totalIncomeMonth();
        String totalDeduction = salaryCalculation.totalDeductionsMonth();
        String netSalary = salaryCalculation.netSalaryMonth();
        String overtime = salaryCalculation.overtimeMonth();
        String otherIncome = salaryCalculation.otherIncomeMonth();
        String socialSecurity = salaryCalculation.socialSecurityMonth();
        String healthInsurance = salaryCalculation.healthInsuranceMonth();
        String monthlyLoans = salaryCalculation.monthlyLoans();
        String otherDeductions = salaryCalculation.otherDeductionsMonth();
        //String otherAllowances = salaryCalculation.otherAllowances();
        //String paidVacations = salaryCalculation.paidVacations();
        //String absence = salaryCalculation.absenceMonth();
        //String basicSalary = salaryCalculation.basicSalary();
        //String incomeTax = salaryCalculation.incomeTax();
        //String nationalContribution = salaryCalculation.nationalContribution();
        //String serviceTax = salaryCalculation.serviceTax();
        //String providentFund = salaryCalculation.providentFund();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(directManager, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.myTeam(employeeName);
        manager.openSalarySlip();

        salarySlip = new SalarySlipBE();
        softAssert.assertEquals(salarySlip.getRecentSalarySlip(), "June (6) - 2024", "Recent Salary Month!");
        //softAssert.assertEquals(salarySlip.netSalary()+" JOD", netSalary, "Net Salary!");
        softAssert.assertEquals(salarySlip.netSalary(), netSalary, "Net Salary!");
        softAssert.assertEquals(salarySlip.income(), totalIncome, "Income!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Worth Salary"), worthSalary, "Worth Salary!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Fixed Allowance"), fixedAllowance, "Fixed Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Percent Allowance"), percentAllowance, "Percent Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Transportation Allowance"), transportationAllowance, "Transportation Allowance!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Other Income 1"), otherIncome, "Other Income 1!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Holiday Overtime"), overtime, "Holiday Overtime!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Transportation Allowance"), otherAllowances, "Transportation Allowance!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Income", "Paid Vacations"), paidVacations, "Paid Vacations!");
        softAssert.assertEquals(salarySlip.deduction_Amount(), totalDeduction, "Deduction Amount!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Tax"), incomeTax, "Tax!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Other Deduction 1"), otherDeductions, "Other Deduction 1!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Car Loan"), monthlyLoans, "Car Loan!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Health insurance - Fixed"), healthInsurance, "Health insurance - Fixed!");
        softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Social Security"), socialSecurity, "Social Security!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Provident Fund"), providentFund, "Provident Fund!");
        //softAssert.assertEquals(salarySlip.deduction_Period(), "6", "Deduction Period!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Leave"), "5", "Leave!");
        //softAssert.assertEquals(salarySlip.salarySlip_GetAmount("Deduction", "Vacation"), "1", "Vacation!");
        //softAssert.assertEquals(salarySlip.PF_Balance(), "0.000", "PF Balance!");

        softAssert.assertAll();

    }

}
