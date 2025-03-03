package newVersion;

import apiBackend.AllEmployeeTransactions;
import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import apiBackend.SalaryCalculation;
import bases.BaseTest;
import org.testng.annotations.Test;

public class NewClass extends BaseTest {

    CompanyAndBranch companyAndBranch;
    Employees employees;
    AllEmployeeTransactions allEmployeeTransactions;
    SalaryCalculation salaryCalculation;

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
                "", "", 0, "Jordan CP", "Jordanian Dinar", "",
                "", "Software Test Engineer", "", "Monthly", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, false, false);
        employeeCode = employees.getEmployeeCode();

        System.exit(0);

        employees.setBasicSalary("1500");
        employees.addAllowance("Fixed Allowance", "250", "", "", "", true);
        employees.addSocialSecurity("Social Security", "", "", false);
        employees.healthInsurance("Health insurance - Fixed", "", "");
        employees.addVacationBalance("Annual Vacation", "0", "14", "2024", "2024-01-01", "2024-12-31", true);
        employees.addExtraSalary(employeeCode, "Extra Salary 14");

        salaryCalculation = new SalaryCalculation();
        salaryCalculation.salaryCalculation(employeeCode, "2025", "1", true);
        salaryCalculation.getSalarySlip(employeeCode, 2025, 1);

        System.out.println("Basic Salary = "+salaryCalculation.basicSalary());
        System.out.println("Worth Salary = "+salaryCalculation.worthSalaryMonth());
        System.out.println("Total Income = "+salaryCalculation.totalIncomeMonth());
        System.out.println("Net Salary = "+salaryCalculation.netSalaryMonth());
        System.out.println("Fixed Allowance = "+salaryCalculation.fixedAllowanceMonth());


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

        allEmployeeTransactions = new AllEmployeeTransactions();

        //System.out.println(allEmployeeTransactions.getVacationId(45548, 0));
        System.out.println(allEmployeeTransactions.getVacationPeriod("jstr22011", 0));


        //System.out.println(allEmployeeTransactions.getVacationTransactionValueByKey(9469, "posted"));

//        List<Map<String, String>> data = selectQueryAll("select * from VacationTransactions where EmployeeId = 45548");
//
//        System.out.println("Amount = " + data.);

//        for (Map<String, String> row : data) {
//            String amount = row.get("Amount");  // Get the 'amount' column by name
//            System.out.println("Amount: " + amount);
//        }

    }


}
