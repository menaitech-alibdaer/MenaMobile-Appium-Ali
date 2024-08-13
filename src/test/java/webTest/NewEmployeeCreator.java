package webTest;

import bases.WebBase;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.financialInformation.Insurance;
import webBackend.financialInformation.Payment;
import webBackend.financialInformation.TaxAndDeduction;
import webBackend.general.*;
import webBackend.salaryCalculation.SalaryCalculation;
import webBackend.personnelInformation.AddressAndContacts;
import webBackend.personnelInformation.Education;
import webBackend.personnelInformation.Other;
import webBackend.personnelInformation.PersonnelInformation;

import static utilities.MssqlConnect.menaMeRestPassword;
import static utilities.WebHelper.employeeCodeSetter;

public class NewEmployeeCreator extends WebBase {

    PersonnelInformation personnel;
    FinancialPackage financial;
    Payment payment;
    Insurance insurance;
    TaxAndDeduction tax;
    SalaryCalculation calculation;
    Other other;
    AddressAndContacts address;
    Education education;
    EmployeesTransactions transactions;
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    ExtraSalary extraSalary;
    EmployeeTermination employeeTermination;
    PF_Balances pfBalance;
    NonPayrollBenefitCalculation nonPayrollBenefitCalculation;
    NonPayrollTransactions nonPayrollTransactions;
    SpecialSalaryReport specialSalaryReport;
    String employeeCode = null;
    String emp1;
    String emp2;
    String emp3;
    String OT_amount1 = null;
    String OT_amount2 = null;
    String vacationCompensation = null;
    double value = 0.000;
    String totalOvertime = null;

    @Test(priority = 1)
    public void newEmployee(){

        login = new Login();
        //login.staticLogin();
        login.login("sa", "1", "mena", "auto_a1", false, false);

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

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");
        financial.addAllowances("Fixed Allowance", "100", "", "", "", "");
        financial.addAllowances("Percent Allowance", "5", "", "", "", "");

        employeeCodeSetter(employeeCode);

        menaMeRestPassword(employeeCode);

    }

    @Test(priority = 4)
    public void newEmployee1(){

        login = new Login();
        //login.staticLogin();
        login.login("sa", "1", "mena", "auto_a1", false, false);

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

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");
        financial.addAllowances("Fixed Allowance", "100", "", "", "", "");
        financial.addAllowances("Percent Allowance", "5", "", "", "", "");

        employeeCodeSetter(employeeCode);

        menaMeRestPassword(employeeCode);

    }

    @Test(priority = 4)
    public void newEmployee2(){

        login = new Login();
        //login.staticLogin();
        login.login("sa", "1", "mena", "auto_a1", false, false);

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

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");
        financial.addAllowances("Fixed Allowance", "100", "", "", "", "");
        financial.addAllowances("Percent Allowance", "5", "", "", "", "");

        employeeCodeSetter(employeeCode);

        menaMeRestPassword(employeeCode);

    }

    @Test(priority = 4)
    public void newEmployee3(){

        login = new Login();
        //login.staticLogin();
        login.login("sa", "1", "mena", "auto_a1", false, false);

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

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");
        financial.addAllowances("Fixed Allowance", "100", "", "", "", "");
        financial.addAllowances("Percent Allowance", "5", "", "", "", "");

        employeeCodeSetter(employeeCode);

        menaMeRestPassword(employeeCode);

    }

}
