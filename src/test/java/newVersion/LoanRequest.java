package newVersion;

import apiBackend.AllEmployeeTransactions;
import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import bases.BaseTest;
import mobileBackend.MainScreen;
import mobileBackend.MobileLogin;
import mobileBackend.MyRequests;
import mobileBackend.MyTransactions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.MssqlConnect.setMenaMePassword;

public class LoanRequest extends BaseTest {

    String employeeCode = null;
    MobileLogin loginMob;
    MainScreen mainScreen;
    MyTransactions myTransactions;
    MyRequests myRequests;
    CompanyAndBranch companyAndBranch;
    Employees employees;
    AllEmployeeTransactions allEmployeeTransactions;

    @Test(priority = 1, groups = "Loans")
    public void fastLoanRequestWithAttachmentAndReason(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLoans();
        myRequests.loanRequest("Car Loan", "01/01/2025", "1000", "10", false, "", "",
                "", true, "Test Reason Loan", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "The alert should be contain: Done Successfully!");
        softAssert.assertAll();

    }

    @Test(priority = 2, groups = "Loans")
    public void employeeCannotRequestLoanFromMenaME(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        setMenaMePassword("auto_mobile1", "Revamp");
        loginMob.login("auto_mobile1", "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLoans();

        Assert.assertFalse(myRequests.checkLoanType("Employee Cannot Request Loan"), "This type should be NOT appear: Employee Cannot Request Loan");

    }

    @Test(priority = 3, groups = "Loans")
    public void checkMaxInstallmentsNumber(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLoans();
        myRequests.loanRequest("Check Max Installments Number", "01/01/2025", "1000", "6", false, "", "",
                "", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("The number of installments should meet the required maximum installments"), "The alert NOT contain: The number of installments should meet the required maximum installments!");

    }

    @Test(priority = 4, groups = "Loans")
    public void checkMaxInstallmentLoanAmount(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLoans();
        myRequests.loanRequest("Check Max Installment Loan Amount", "01/01/2025", "1000", "9", false, "", "",
                "", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("The installment amount is greater than the maximum allowed amount"), "The alert NOT contain: The installment amount is greater than the maximum allowed amount!");

    }

    @Test(priority = 5, groups = "Loans")
    public void checkMaxLoanAmount(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLoans();
        myRequests.loanRequest("Check Max Loan Amount", "01/01/2025", "2200", "10", false, "", "",
                "", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("The transaction amount exceeds the maximum limit"), "The alert NOT contain: The transaction amount exceeds the maximum limit!");

    }

    @Test(priority = 6, groups = "Loans")
    public void checkAllowSupportingDocuments(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLoans();
        myRequests.loanRequest("Check Allow Supporting Documents", "", "1000", "10", false, "", "",
                "", false, "", true, true);

        Assert.assertTrue(myRequests.checkToastAlert("Please upload attachment"), "The alert NOT contain: Please upload attachment!");

    }

    @Test(priority = 7, groups = "Loans")
    public void checkMaximumEmployeeAge(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1990-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLoans();
        myRequests.loanRequest("Check Maximum Employee Age", "", "1000", "10", false, "", "",
                "", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("age exceeds the valid age for this loan"), "The alert NOT contain: age exceeds the valid age for this loan!");

    }

    @Test(priority = 8, groups = "Loans")
    public void checkGuarantorsAreRequiredForThisLoanType(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1990-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLoans();
        myRequests.loanRequest("Check Guarantors are required for this loan type", "", "1000", "10", false, "", "",
                "", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("The number of guarantors should be equal to 1"), "The alert NOT contain: The number of guarantors should be equal to 1!");

    }

    @Test(priority = 9, groups = "Loans", enabled = false)
    public void checkAllowAGuarantorToGuaranteeTheLoanIfTheyHaveAPreviousActiveGuarantee(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1990-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee1 = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        employees = new Employees();
        employees.createNewEmployee("1990-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee2 = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        employees = new Employees();
        employees.createNewEmployee("1990-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String guarantor = employees.getEmployeeCode();
        employees.setBasicSalary("1000");


        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee1, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLoans();
        myRequests.loanRequest("Check Allow a guarantor to guarantee the loan", "", "1000", "10", false, "", "",
                guarantor, false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "The alert should be contain: Done Successfully!");
        myRequests.closeAlert();

        mainScreen.logout();

        loginMob.login(employee2, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLoans();
        myRequests.loanRequest("Check Allow a guarantor to guarantee the loan", "", "1000", "10", false, "", "",
                guarantor, false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "The alert should be contain: Done Successfully!");
        softAssert.assertAll();

    }

    @Test(priority = 10, groups = "Loans")
    public void checkAllowOverlappingOption(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        employees = new Employees();
        employees.createNewEmployee("1990-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLoans();
        myRequests.loanRequest("Check Allow Overlapping", "01/01/2025", "1000", "10", false, "", "",
                "", false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "The alert should be contain: Done Successfully!");

        myRequests.closeAlert();
        mainScreen.myRequests();
        myRequests.openLoans();
        myRequests.loanRequest("Check Allow Overlapping", "01/05/2025", "1000", "10", false, "", "",
                "", false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "The alert should be contain: Done Successfully!");
        softAssert.assertAll();

    }

}
