package newVersion;

import apiBackend.AllEmployeeTransactions;
import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import apiBackend.SalaryCalculation;
import bases.BaseTest;
import mobileBackend.SalarySlipBE;
import org.testng.annotations.Test;
import utilities.PDFReader;

import static utilities.MssqlConnect.setMenaMePassword;
import static utilities.PDFReader.pdfFileReader;
import static utilities.WebHelper.currentYear;
import static utilities.WebHelper.mobile;

public class NewClass extends BaseTest {

    CompanyAndBranch companyAndBranch;
    Employees employees;
    AllEmployeeTransactions allEmployeeTransactions;
    SalaryCalculation salaryCalculation;
    SalarySlipBE salarySlip;

    protected String employeeCode = null;

    @Test
    public void testNewVersionWithApi(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1990-05-20", "", "Male", "Single", "", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "Monthly", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, false, false);
        employeeCode = employees.getEmployeeCode();
        employees.entitledToOvertime(employeeCode);
        employees.setBasicSalary("1000");
//        employees.addVacationBalance("Annual Vacation", "0", "14", "2025", "2025-01-01", "2025-12-31", true);
//        allEmployeeTransactions = new AllEmployeeTransactions();
//        allEmployeeTransactions.loans(employeeCode, "2025-04-01", "2025-04-01", "Car Loan", "1200", "12", true);

//        employees.addAllowance("Fixed Allowance", "250", "", "", "", true);
//        employees.addSocialSecurity("Social Security", "", "", false);
//        employees.healthInsurance("Health insurance - Fixed", "", "");
//        employees.addVacationBalance("Annual Vacation", "0", "14", "2024", "2024-01-01", "2024-12-31", true);
//        employees.addExtraSalary(employeeCode, "Extra Salary 14");

//        salaryCalculation = new SalaryCalculation();
//        salaryCalculation.salaryCalculation(employeeCode, "2025", "1", true);
//        salaryCalculation.getSalarySlip(employeeCode, 2025, 1);
//        salaryCalculation.taxable(true, "Tax", true, false);
//
//        System.out.println("Basic Salary = "+salaryCalculation.basicSalary());
//        System.out.println("Worth Salary = "+salaryCalculation.worthSalaryMonth());
//        System.out.println("Total Income = "+salaryCalculation.totalIncomeMonth());
//        System.out.println("Net Salary = "+salaryCalculation.netSalaryMonth());
//        System.out.println("Fixed Allowance = "+salaryCalculation.fixedAllowanceMonth());


    }

    @Test
    public void employeeWithDirectManager(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String directManager = employees.getEmployeeCode();
        String directManagerName = employees.getFirstAndLastNameEmployee();
        String directManagerFullName = employees.getFullNameEmployee();

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        String employeeFullName = employees.getFullNameEmployee();

        employees.addSubstitute(employee, directManager, false);

    }

    @Test
    public void dddd(){

        setMenaMePassword("sa29", "Revamp");

    }

    @Test
    public void dddddd(){

        String content = pdfFileReader("pdfFiles/znuf90344.pdf");
        System.out.println(content); // Check for exact matches of your keys

//        String employeeCode = "znuf90344";
//
//        softAssert.assertEquals("1000.00", PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Basic Salary"), "- Basic Salary!");
//        softAssert.assertEquals("1000.00", PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Worth Salary"), "- Worth Salary!");
//        softAssert.assertEquals("200.00", PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Fixed Allowance"), "- Fixed Allowance!");
//        softAssert.assertEquals("100.00", PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Percent Allowance"), "- Percent Allowance!");
//        softAssert.assertEquals("0.00", PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Overtime"), "- Overtime!");
//        softAssert.assertEquals("0.00", PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Other Income"), "- Other Income!");
//        softAssert.assertEquals("1300.00", PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Total Income"), "- Total Income!");
//        softAssert.assertEquals("75.00", PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Total Deductions"), "- Total Deductions!");
//        softAssert.assertEquals("180.00", PDFReader.getDataFromSalarySlipPdf_NEW(employeeCode, "Net Salary")+" JOD", "- Net Salary!");
//        softAssert.assertAll();

    }

    @Test
    public void zzzzzzzzz(){

        ////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        allEmployeeTransactions = new AllEmployeeTransactions();
        //allEmployeeTransactions.vacation("hxpx95368", "2025-03-24", "2025-03-24", "Unpaid Vacation", true);
        //allEmployeeTransactions.leave("hxpx95368", "2025-04-01", "2025-04-01", "Unpaid Leave", "5", true);
        //allEmployeeTransactions.overtime("hxpx95368", "2025-05-01", "2025-05-01", "Holiday Overtime", "3", true);
        //allEmployeeTransactions.loans("hxpx95368", "2025-07-01", "2025-07-01", "Car Loan", "1200", "12", true);
        //allEmployeeTransactions.otherIncome("hxpx95368", "2025-08-01", false, "", "Other Income 1", "100", true);
        allEmployeeTransactions.otherDeductions("hxpx95368", "2025-09-01", "Other Deduction 1", "200", false, "", true);


    }


}
