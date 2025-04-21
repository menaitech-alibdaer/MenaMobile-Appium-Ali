package newVersion;

import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import apiBackend.Settings;
import bases.BaseTest;
import mobileBackend.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.general.*;
import webBackend.personnelInformation.Other;
import webBackend.personnelInformation.PersonnelInformation;

import static utilities.MssqlConnect.menaMeRestPassword;
import static utilities.MssqlConnect.setMenaMePassword;
import static utilities.WebHelper.currentDateMinusDays;

public class OvertimeRequest extends BaseTest {

    PersonnelInformation personnel;
    FinancialPackage financial;
    Other other;
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    EmployeesTransactions transactions;
    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;
    MyRequests myRequests;
    MyTransactions myTransactions;

    CompanyAndBranch companyAndBranch;
    Employees employees;
    Settings settings;

//    @Test(priority = 1, groups = "Overtime", enabled = false)
//    public void option_OvertimeHourIsCalculatedAsFixedRateValue(){
//
//        /////////////// Web Initialize //////////////
//        systemInitialize();
//
//        login = new Login();
//        login.auto_mob1();
//
//        menaModules = new MenaModules();
//        menaModules.menaPAY();
//
//        mainMenu = new MainMenu();
//        mainMenu.mainMenu("Employees","Personnel Information");
//        personnel = new PersonnelInformation();
//        personnel.personalInformation("Single", "Male", "Jordanian",
//                "", "", "", "", "01/01/1990");
//        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
//                "", "", "", "", "", "", "", "",
//                "", "", "", "", "", "Software Test Engineer",
//                "01/01/2020", "01/01/2020", "", "", "", "");
//        employeeCode = personnel.employeeCodeGetter();
//        menaMeRestPassword(employeeCode);
//
//        mainMenu.mainMenu("Employees","Financial Information");
//        financial = new FinancialPackage();
//        financial.setEmployeeCode(employeeCode);
//        financial.setBasicSalary("1000");
//
//        /////////////// Mobile Initialize //////////////
//        mobileInitialize();
//
//        loginMob = new MobileLogin();
//        loginMob.login(employeeCode, "sa", "automobile", false);
//
//        mainScreen = new MainScreen();
//        mainScreen.myRequests();
//
//        myRequests = new MyRequests();
//        myRequests.openOvertime();
//        myRequests.overtimeRequest("01/10/2024", "Overtime Hour Is Calculated As Fixed Rate Value", "", "", "",
//                "5:30 PM", "8:30 PM", true, "Test Overtime Reason", true, true);
//
//        softAssert.assertTrue(myRequests.checkAlertPopup("Your Overtime Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Overtime Request Has Been Submitted Successfully");
//
//        myRequests.closeAlert();
//
//        mainScreen.myTransactions();
//        myTransactions = new MyTransactions();
//        myTransactions.openTransactionInMyTransactions("Financial Transactions", "All", "Overtime Hour Is Calculated As Fixed Rate Value", "01.10.2024");
//
//        softAssert.assertEquals(myTransactions.transactionDetails("Period"), "3.000 Hours", "Issue in period");
//        softAssert.assertEquals(myTransactions.transactionDetails("From"), "5:30 PM", "Issue in From Time!");
//        softAssert.assertEquals(myTransactions.transactionDetails("To"), "8:30 PM", "Issue in To Time!");
//        softAssert.assertEquals(myTransactions.getTransactionReason(), "Test Overtime Reason", "- Reason Issue!");
//        softAssert.assertTrue(myTransactions.attachmentIconInDetails.isDisplayed(), "Attachment Icon NOT appear!");
//        //softAssert.assertTrue(myTransactions.checkOpenAttachment(), "Attachment NOT Opened!");
//        softAssert.assertAll();
//
//    }
//
//    @Test(priority = 2, groups = "Overtime", enabled = false)
//    public void option_CalculateTransactionAmountBasedOnSocialSecuritySalary(){
//
//        /////////////// Web Initialize //////////////
//        systemInitialize();
//
//        login = new Login();
//        login.login("sa", "0795798860", "automation", "auto_mob1", false, false);
//
//        menaModules = new MenaModules();
//        menaModules.menaPAY();
//
//        mainMenu = new MainMenu();
//        mainMenu.mainMenu("Employees","Personnel Information");
//        personnel = new PersonnelInformation();
//        personnel.personalInformation("Single", "Male", "Jordanian",
//                "", "", "", "", "01/01/1990");
//        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
//                "", "", "", "", "", "", "", "",
//                "", "", "", "", "", "Software Test Engineer",
//                "01/01/2020", "01/01/2020", "", "", "", "");
//        employeeCode = personnel.employeeCodeGetter();
//        menaMeRestPassword(employeeCode);
//
//        mainMenu.mainMenu("Employees","Financial Information");
//        financial = new FinancialPackage();
//        financial.setEmployeeCode(employeeCode);
//        financial.setBasicSalary("1000");
//        financial.addAllowances("Fixed Allowance", "100", "", "", "", "");
//        financial.addAllowances("Allowance Cannot Change", "100", "", "", "", "");
//
//        insurance = new Insurance();
//        insurance.socialSecurity(true, false, false, "Social Security",
//                "", "", true, false);
//
//
//        /////////////// Mobile Initialize //////////////
//        mobileInitialize();
//
//        loginMob = new MobileLogin();
//        loginMob.login(employeeCode, "sa", "automobile", false);
//
//        mainScreen = new MainScreen();
//        mainScreen.myRequests();
//
//        myRequests = new MyRequests();
//        myRequests.openOvertime();
//        myRequests.overtimeRequest("01/10/2024", "Calculate Transaction Amount Based on Social Security Salary", "", "", "",
//                "5:30 PM", "8:30 PM", false, "", true, false);
//
//        ///////////////////
//
//        mainMenu.mainMenu("Workforce Management","Employees Transactions");
//
//        transactions = new EmployeesTransactions();
//        transactions.setEmployeeCode(employeeCode);
//        transactions.goToOvertime();
//
//        Assert.assertEquals(transactions.getAmount(1), "26.613", "- Overtime Amount Issue");
//
//    }
//
//    @Test(priority = 3, groups = "Overtime", enabled = false)
//    public void option_RelatedToShifts(){
//
//        /////////////// Web Initialize //////////////
//        systemInitialize();
//
//        login = new Login();
//        login.login("sa", "0795798860", "automation", "auto_mob1", false, false);
//
//        menaModules = new MenaModules();
//        menaModules.menaPAY();
//
//        mainMenu = new MainMenu();
//        mainMenu.mainMenu("Employees","Personnel Information");
//        personnel = new PersonnelInformation();
//        personnel.personalInformation("Single", "Male", "Jordanian",
//                "", "", "", "", "01/01/1990");
//        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
//                "", "", "", "", "", "", "", "",
//                "", "", "", "", "", "Software Test Engineer",
//                "01/01/2020", "01/01/2020", "", "", "", "");
//        employeeCode = personnel.employeeCodeGetter();
//        menaMeRestPassword(employeeCode);
//
//        other = new Other();
//        other.goToShiftDetails();
//        other.addShiftDetails(employeeCode, "Regular", "Automation", "With Number H");
//
//        mainMenu.mainMenu("Employees","Financial Information");
//        financial = new FinancialPackage();
//        financial.setEmployeeCode(employeeCode);
//        financial.setBasicSalary("1000");
//
//        /////////////// Mobile Initialize //////////////
//        mobileInitialize();
//
//        loginMob = new MobileLogin();
//        loginMob.login(employeeCode, "sa", "automobile", false);
//
//        mainScreen = new MainScreen();
//        mainScreen.myRequests();
//
//        myRequests = new MyRequests();
//        myRequests.openOvertime();
//        myRequests.overtimeRequest("01/10/2024", "Related To Shifts", "", "", "",
//                "5:30 PM", "8:30 PM", false, "", true, false);
//
//        ///////////////////
//
//        mainMenu.mainMenu("Workforce Management","Employees Transactions");
//
//        transactions = new EmployeesTransactions();
//        transactions.setEmployeeCode(employeeCode);
//        transactions.goToOvertime();
//
//        Assert.assertEquals(transactions.getAmount(1), "22.222", "- Overtime Amount Issue");
//
//    }

    @Test(priority = 4, groups = "Overtime")
    public void checkOption_OvertimeCannotBeEnteredInMenaMe(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        setMenaMePassword("auto_mobile1", "Revamp");
        loginMob.login("auto_mobile1", "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();

        Assert.assertFalse(myRequests.checkLeaveType("Overtime Cannot Be Entered in MenaMe"), "This type should be NOT appear: Overtime Cannot Be Entered in MenaMe");

    }

    @Test(priority = 5, groups = "Overtime")
    public void option_IncludeExtraSalariesInTransactionAmountCalculation(){

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
        employees.addExtraSalary(employeeCode, "Extra Salary 14");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Include Extra Salaries In Transaction", "", "", "",
                "5:30 PM", "8:30 PM", false, "", true, false);

        mainScreen = new MainScreen();
        mainScreen.myTransactions();

        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "All", "Include Extra Salaries In Transaction", "01.10.2024");

        Assert.assertEquals(myTransactions.getTransactionDetails("Amount"), "21.17 JOD", "- Amount Issue");

    }

    @Test(priority = 6, groups = "Overtime")
    public void option_AllowMoreThanOneTransactionInTheSameDay(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Allow More Than One Transaction In The Same Day", "", "", "",
                "1:30 PM", "3:30 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
                myRequests.overtimeRequest("01/10/2024", "Allow More Than One Transaction In The Same Day", "", "", "",
                "5:30 PM", "8:30 PM", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "Alert Issue: Shoud be alert appear--> Done Successfully");

    }

    @Test(priority = 7, groups = "Overtime")
    public void option_AllowOvertimeRequestsWithinShiftsPeriods(){

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
                true, "Regular", "1", "1", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.entitledToOvertime(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Allow Overtime Requests Within Shifts Periods", "", "", "",
                "12:30 PM", "2:30 PM", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "Alert Issue: Shoud be alert appear--> Done Successfully");

    }

    @Test(priority = 8, groups = "Overtime")
    public void requestOvertimeWithinShiftAndCheckTheValidation(){

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
                true, "Regular", "1", "1", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.entitledToOvertime(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Regular Overtime", "", "", "",
                "12:30 PM", "2:30 PM", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Overtime is not allowed during the shift"), "Alert Issue: Shoud be alert appear--> Overtime is not allowed during the shift");

    }

    @Test(priority = 8, groups = "Overtime")
    public void option_DontAllowPreviousDateMenaMERequestMoreThan_3_DaysFromEffectiveDate(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest(currentDateMinusDays(5), "Dont Allow Previous Date MenaME Request More Than", "", "", "",
                "12:30 PM", "2:30 PM", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Passed Allowed Period To Request Overtime"), "Alert Issue: Shoud be alert contain--> Passed Allowed Period To Request Overtime");

    }

    @Test(priority = 2, groups = "Overtime")
    public void option_RequestedOvertimeTransactionsWillBePaidAsNonpayroll(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
//        myRequests.overtimeRequest("01/10/2024", "Requested Overtime Transactions will be paid as Non-payroll", "", "", "",
//                "9:00 AM", "11:00 AM", false, "", true, false);
        myRequests.overtimeRequest("01/10/2024", "Overtime Transactions will be paid as Non-payroll", "", "", "",
                "9:00 AM", "11:00 AM", false, "", true, false); //// For New System Revamp

        Assert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "Alert Issue: Shoud be alert appear--> Done Successfully");

    }

    @Test(priority = 8, groups = "Overtime")
    public void option_OvertimeCanBeRequestedOnlyOn_WorkingDays(){

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
                true, "Regular", "1", "1", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.entitledToOvertime(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        softAssert.assertFalse(myRequests.checkOvertimeTypeIfAppear("04/10/2024", "Overtime Can Be Requested Only On - Working Days"), "This Type 'Overtime Can Be Requested Only On - Working Days' Should Be NOT appear, because the date in Days-Off");
        myRequests.closeList();

        softAssert.assertFalse(myRequests.checkOvertimeTypeIfAppear("25/12/2024", "Overtime Can Be Requested Only On - Working Days"), "This Type 'Overtime Can Be Requested Only On - Working Days' Should Be NOT appear, because the date in Holiday");
        myRequests.closeList();

        softAssert.assertTrue(myRequests.checkOvertimeTypeIfAppear("15/10/2024", "Overtime Can Be Requested Only On - Working Days"), "This Type 'Overtime Can Be Requested Only On - Working Days' Should Be appear");

        softAssert.assertAll();

    }

    @Test(priority = 8, groups = "Overtime")
    public void option_OvertimeCanBeRequestedOnlyOn_Holidays(){

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
                true, "Regular", "1", "1", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.entitledToOvertime(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        softAssert.assertFalse(myRequests.checkOvertimeTypeIfAppear("04/10/2024", "Overtime Can Be Requested Only On - Holidays"), "This Type 'Overtime Can Be Requested Only On - Holidays' Should Be NOT appear, because the date in Days-Off");
        myRequests.closeList();

        softAssert.assertFalse(myRequests.checkOvertimeTypeIfAppear("15/10/2024", "Overtime Can Be Requested Only On - Holidays"), "This Type 'Overtime Can Be Requested Only On - Holidays' Should Be NOT appear, because the date in Working Days");
        myRequests.closeList();

        softAssert.assertTrue(myRequests.checkOvertimeTypeIfAppear("25/12/2024", "Overtime Can Be Requested Only On - Holidays"), "This Type 'Overtime Can Be Requested Only On - Holidays' Should Be appear");

        softAssert.assertAll();

    }

    @Test(priority = 8, groups = "Overtime")
    public void option_OvertimeCanBeRequestedOnlyOn_DaysOff(){

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
                true, "Regular", "1", "1", 0, true, false);
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.entitledToOvertime(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        softAssert.assertFalse(myRequests.checkOvertimeTypeIfAppear("25/12/2024", "Overtime Can Be Requested Only On - Days-Off"), "This Type 'Overtime Can Be Requested Only On - Days-Off' Should Be NOT appear, because the date in Holiday");
        myRequests.closeList();

        softAssert.assertFalse(myRequests.checkOvertimeTypeIfAppear("15/10/2024", "Overtime Can Be Requested Only On - Days-Off"), "This Type 'Overtime Can Be Requested Only On - Days-Off' Should Be NOT appear, because the date in Working Days");
        myRequests.closeList();

        softAssert.assertTrue(myRequests.checkOvertimeTypeIfAppear("04/10/2024", "Overtime Can Be Requested Only On - Days-Off"), "This Type 'Overtime Can Be Requested Only On - Days-Off' Should Be appear");

        softAssert.assertAll();

    }

    @Test(priority = 8, groups = "Overtime")
    public void overtimeHoursPerMonthShouldNotExceed_20_Hours(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Hours Per Month Should Not Exceed 20", "", "", "",
                "8:00 AM", "1:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("02/10/2024", "Hours Per Month Should Not Exceed 20", "", "", "",
                "8:00 AM", "1:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("15/10/2024", "Hours Per Month Should Not Exceed 20", "", "", "",
                "8:00 AM", "1:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("17/10/2024", "Hours Per Month Should Not Exceed 20", "", "", "",
                "8:00 AM", "3:00 PM", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

    }

    @Test(priority = 8, groups = "Overtime")
    public void hoursPerDayShouldNotExceed_6_Hours(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("17/10/2024", "Hours Per Day Should Not Exceed 6", "", "", "",
                "8:00 AM", "3:00 PM", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

    }

    @Test(priority = 8, groups = "Overtime")
    public void overtimeHoursPerWeekShouldNotExceed_10_Hours(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("29/09/2024", "Hours Per Week Should Not Exceed 10", "", "", "",
                "8:00 AM", "1:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("30/09/2024", "Hours Per Week Should Not Exceed 10", "", "", "",
                "8:00 AM", "11:00 AM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Hours Per Week Should Not Exceed 10", "", "", "",
                "8:00 AM", "12:00 PM", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

    }

    @Test(priority = 8, groups = "Overtime")
    public void overtimeAmountPerMonthShouldNotExceed_10_Percent(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Amount Per Month Should Not Exceed 10%", "", "", "",
                "8:00 AM", "4:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("10/10/2024", "Amount Per Month Should Not Exceed 10%", "", "", "",
                "8:00 AM", "12:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("20/10/2024", "Amount Per Month Should Not Exceed 10%", "", "", "",
                "8:00 AM", "11:00 AM", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

    }

    @Test(priority = 8, groups = "Overtime")
    public void overtimeAmountPerDayShouldNotExceed_2_Percent(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Amount Per Day Should Not Exceed 2%", "", "", "",
                "8:00 AM", "8:30 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("20/10/2024", "Amount Per Day Should Not Exceed 2%", "", "", "",
                "8:00 AM", "10:00 AM", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

    }

    @Test(priority = 8, groups = "Overtime")
    public void overtimeAmountPerWeekShouldNotExceed_10_Percent(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("07/10/2024", "Amount Per Week Should Not Exceed 10%", "", "", "",
                "8:00 AM", "4:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("08/10/2024", "Amount Per Week Should Not Exceed 10%", "", "", "",
                "8:00 AM", "12:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("09/10/2024", "Amount Per Week Should Not Exceed 10%", "", "", "",
                "8:00 AM", "11:00 AM", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

    }

    @Test(priority = 1, groups = "Overtime")
    public void checkAttachmentAndReasonIsMandatoryInOvertimeRequest(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
//        myRequests.overtimeRequest("01/10/2024", "Attachment and Reason Is Mandatory In Overtime Request", "", "", "",
//                "5:30 PM", "8:30 PM", false, "", true, true);
        myRequests.overtimeRequest("01/10/2024", "Attachment and Reason Is Mandatory In Overtime", "", "", "",
                "5:30 PM", "8:30 PM", false, "", true, true); /// For new system Revamp

        softAssert.assertTrue(myRequests.checkToastAlert("Please Choose Attachment"), "Alert Issue - shoud be appear: Please Choose Attachment - But the alert appear is --> "+myRequests.getToastAlert());

        mainScreen.goBack(5000);
        mainScreen.myRequests();
        myRequests.openOvertime();
//        myRequests.overtimeRequest("01/10/2024", "Attachment and Reason Is Mandatory In Overtime Request", "", "", "",
//                "5:30 PM", "8:30 PM", true, "", true, true);
        myRequests.overtimeRequest("01/10/2024", "Attachment and Reason Is Mandatory In Overtime", "", "", "",
                "5:30 PM", "8:30 PM", true, "", true, true); /// For new system Revamp

        softAssert.assertTrue(myRequests.checkToastAlert("Please Fill The Reason"), "Alert Issue - shoud be appear: Please Fill The Reason! - But the alert appear is --> "+myRequests.getToastAlert());
        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "Overtime")
    public void checkOvertimeHoursPerMonthShouldNotExceed_FromSystemParameters_OvertimeRule(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        settings = new Settings();
        settings.overtimeBudget(false, "", "", "20");

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "1:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("02/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "1:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("15/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "1:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("17/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "3:00 PM", false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

        settings.overtimeBudget(false, "", "", "");

        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "Overtime")
    public void checkOvertimeHoursPerWeekShouldNotExceed_FromSystemParameters_OvertimeRule(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        settings = new Settings();
        settings.overtimeBudget(false, "", "10", "20");

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("06/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "1:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("09/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "3:00 PM", false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

        settings.overtimeBudget(false, "", "", "");

        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "Overtime")
    public void checkOvertimeHoursPerDayShouldNotExceed_FromSystemParameters_OvertimeRule(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        settings = new Settings();
        settings.overtimeBudget(false, "5", "20", "40");

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("17/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "2:00 PM", false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

        settings.overtimeBudget(false, "", "", "");
        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "Overtime")
    public void checkOvertimeAmountPerMonthShouldNotExceed_Percent_FromSystemParameters_OvertimeRule(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        settings = new Settings();
        settings.overtimeBudget(true, "", "", "10");

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "4:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("10/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "12:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("20/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "2:00 PM", false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

        settings.overtimeBudget(false, "", "", "");

        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "Overtime")
    public void checkOvertimeAmountPerWeekShouldNotExceed_Percent_FromSystemParameters_OvertimeRule(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        settings = new Settings();
        settings.overtimeBudget(true, "", "10", "50");

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("06/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "4:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("07/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "12:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("08/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "2:00 PM", false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

        settings.overtimeBudget(false, "", "", "");

        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "Overtime")
    public void checkOvertimeAmountPerDayShouldNotExceed_Percent_FromSystemParameters_OvertimeRule(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        settings = new Settings();
        settings.overtimeBudget(true, "4", "10", "20");

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "12:00 PM", false, "", true, false);

        mainScreen.myRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("20/10/2024", "Holiday Overtime", "", "", "",
                "8:00 AM", "3:00 PM", false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Overtime Amount Can Not Exceed The Upper Limit"), "Alert Issue: Shoud be alert contain--> Overtime Amount Can Not Exceed The Upper Limit");

        settings.overtimeBudget(false, "", "", "");

        softAssert.assertAll();

    }

}
