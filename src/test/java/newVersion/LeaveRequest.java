package newVersion;

import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import bases.BaseTest;
import mobileBackend.MainScreen;
import mobileBackend.MobileLogin;
import mobileBackend.MyRequests;
import mobileBackend.MyTransactions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.MobileHelper.backTime;
import static utilities.MobileHelper.currentTime;
import static utilities.MssqlConnect.setMenaMePassword;
import static utilities.WebHelper.currentDate;

public class LeaveRequest extends BaseTest {

    String employeeCode = null;
    MobileLogin loginMob;
    MainScreen mainScreen;
    MyTransactions myTransactions;
    MyRequests myRequests;
    CompanyAndBranch companyAndBranch;
    Employees employees;

    @Test(priority = 1, groups = "Leaves")
    public void linkEmployeeOnShiftAndRequestLeaveWithinShift(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Unpaid Leave", "01/10/2024", "10:00 AM", "11:00 AM",
                true, "Test Leave Reason", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "Alert Issue: Shoud be alert appear--> Done Successfully");

        myRequests.closeAlert();

        mainScreen.myTransactions();
        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Leaves", "Unpaid Leave", "01.10.2024");

        softAssert.assertEquals(myTransactions.getTransactionReason(), "Test Leave Reason", "- Reason Issue!");
        softAssert.assertTrue(myTransactions.checkAttachmentIcon(), "Attachment Icon NOT appear!");
        //softAssert.assertTrue(myTransactions.checkOpenAttachment(), "Attachment NOT Opened!");
        softAssert.assertAll();

    }

    @Test(priority = 2, groups = "Leaves")
    public void checkValidationWhenRequestLeaveOutOfShift(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Unpaid Leave", "01/10/2024", "7:00 PM", "8:00 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Leave Out Of Employee Shift"), "Alert Issue: Shoud be alert appear--> Leave Out Of Employee ShiftTime");

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_AlertIfEmployeeLeaveTransactionsFromThisTypeExceeds(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Alert After 2 Leave Per Month", "01/10/2024", "9:00 AM", "10:00 AM",
                false, "", true, false);

        myRequests.openLeaves();
        myRequests.leaveRequest("Alert After 2 Leave Per Month", "02/10/2024", "9:00 AM", "10:00 AM",
                false, "", true, false);

        myRequests.openLeaves();
        myRequests.leaveRequest("Alert After 2 Leave Per Month", "03/10/2024", "9:00 AM", "10:00 AM",
                false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Employee Exceeded Leave Transactions Per Month"), "Alert Issue: Shoud be alert appear--> Employee Exceeded Leave Transactions Per Month");
        myRequests.closeAlert();

        mainScreen.myTransactions();
        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "All", "Alert After 2 Leave Per Month", "03.10.2024");

        softAssert.assertEquals(myTransactions.transactionDetails("Date"), "03/10/2024", " - Transaction Date!");
        softAssert.assertEquals(myTransactions.transactionDetails("From"), "9:00 AM", " - From Time!");
        softAssert.assertEquals(myTransactions.transactionDetails("To"), "10:00 AM", " - To Time!");
        softAssert.assertAll();

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_PreventIfEmployeeLeaveTransactionsFromThisTypeExceeds(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Prevent After 2 Leave Per Month", "01/10/2024", "9:00 AM", "10:00 AM",
                false, "", true, false);

        myRequests.openLeaves();
        myRequests.leaveRequest("Prevent After 2 Leave Per Month", "02/10/2024", "9:00 AM", "10:00 AM",
                false, "", true, false);

        myRequests.openLeaves();
        myRequests.leaveRequest("Prevent After 2 Leave Per Month", "03/10/2024", "9:00 AM", "10:00 AM",
                false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Employee Exceeded Leave Transactions Per Month"), "Alert Issue: Shoud be alert appear--> Employee Exceeded Leave Transactions Per Month");
        myRequests.closeAlert();

        mainScreen.myTransactions();
        myTransactions = new MyTransactions();

        softAssert.assertFalse(myTransactions.checkTransactionInMyTransactions("Financial Transactions", "All", "Prevent After 2 Leave Per Month", "03.10.2024"), " - The Transaction Should be NOT appear in My Transactions!");
        softAssert.assertAll();

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_LeaveHoursUpperLimitHoursPerDay(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Upper And Lower Limit per Day", "01/10/2024", "9:00 AM", "1:00 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Total Hours Per Day Exceed The Limit"), "Alert Issue: Shoud be alert appear--> Total Hours Per Day Exceed The Limit");

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_LeaveHoursLowerLimitHoursPerDay(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Upper And Lower Limit per Day", "01/10/2024", "9:00 AM", "9:30 AM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Leave Does Not Meet Lower Limit Per Day"), "Alert Issue: Shoud be alert appear--> Leave Period Is Less Than Leave Lower Limit! 01:00 Hours");

    }


    @Test(priority = 3, groups = "Leaves")
    public void checkOption_LeaveHoursUpperLimitHoursPerMonth(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Upper Limit per Month", "01/10/2024", "9:00 AM", "11:00 AM",
                false, "", true, false);

        myRequests.openLeaves();
        myRequests.leaveRequest("Upper Limit per Month", "10/10/2024", "9:00 AM", "11:00 AM",
                false, "", true, false);

        myRequests.openLeaves();
        myRequests.leaveRequest("Upper Limit per Month", "14/10/2024", "9:00 AM", "1:00 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Total Hours Per Month Exceed The Limit"), "Alert Issue: Shoud be alert appear--> Total Hours Per Month Exceed The Limit");

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_LeaveHoursUpperLimitHoursPerYear(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Upper Limit per Year", "01/03/2024", "9:00 AM", "1:00 PM",
                false, "", true, false);

        myRequests.openLeaves();
        myRequests.leaveRequest("Upper Limit per Year", "10/05/2024", "9:00 AM", "1:00 PM",
                false, "", true, false);

        myRequests.openLeaves();
        myRequests.leaveRequest("Upper Limit per Year", "14/10/2024", "9:00 AM", "1:00 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Total Hours Per Year Exceed The Limit"), "Alert Issue: Shoud be alert appear--> Total Hours Per Year Exceed The Limit");

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_EarnedAfter_2Month_FromHiringDate_checkValidationWhenRequestBeforeThat(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Earned After 2 Month From Hiring Date", "20/01/2020", "9:00 AM", "1:00 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Not Exceeded The Service Period"), "Alert Issue: Shoud be alert appear--> Not Exceeded The Service Period");

    }

    @Test(priority = 26, groups = "Leaves")
    public void checkOption_LeaveCannotBeEnteredInMenaME(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        setMenaMePassword("auto_mobile1", "Revamp");
        loginMob.login("auto_mobile1", "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();

        Assert.assertFalse(myRequests.checkLeaveType("Leave Cannot Be Entered in MenaME"), "This type should be NOT appear: Leave Cannot Be Entered in MenaME");

    }

    @Test(priority = 7, groups = "Leaves")
    public void checkOption_TheSupportDocumentIsMandatory(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("The Support Document Is Mandatory", "", "9:00 AM", "1:00 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkToastAlert("Please upload attachment"), "Alert Issue: Shoud be alert appear--> Please upload attachment");

    }

    @Test(priority = 7, groups = "Leaves")
    public void checkOption_TheSupportDocumentIsMandatoryWithDayAndTime_CheckWithinDayAndTime(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("The Support Document Is Mandatory - With Day and Time", "06/10/2024", "8:30 AM", "9:30 AM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkToastAlert("Please upload attachment"), "Alert Issue: Shoud be alert appear--> Please upload attachment");

    }

    @Test(priority = 7, groups = "Leaves")
    public void checkOption_TheSupportDocumentIsMandatoryWithDayAndTime_CheckOutOfDayAndTime(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("The Support Document Is Mandatory - With Day and Time", "08/10/2024", "11:30 AM", "1:30 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "Alert Issue: Shoud be alert appear--> Done Successfully");

    }

    @Test(priority = 7, groups = "Leaves")
    public void checkOption_LeaveRequestReasonIsMandatory(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Leave Request Reason Is Mandatory", "", "9:30 AM", "11:30 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkToastAlert("Please Fill The Reason"), "Alert Issue: Shoud be alert appear--> Please Fill The Reason");

    }

    @Test(priority = 1, groups = "Leaves", enabled = false)
    public void option_AllowOutOfShiftLeave(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Allow Out Of Shift Leave", "01/10/2024", "7:00 PM", "9:00 PM",
                false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("The Leave Is Out Of Shift Time"), "Alert Issue: Shoud be alert contain--> The Leave Is Out Of Shift Time");
        softAssert.assertTrue(myRequests.checkAlertPopup("The Request Has Been Saved Successfully"), "Alert Issue: Shoud be alert contain--> The Request Has Been Saved Successfully");
        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "Leaves")
    public void option_DontAllowPreviousDateMenaMERequest(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Dont Allow Previous Date MenaME Request", "01/10/2024", "10:00 AM", "11:00 AM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Leave Request Was Not Submitted"), "Alert Issue: Shoud be alert contain--> Leave Request Was Not Submitted! The leave date must be set in a later date");

    }

    @Test(priority = 1, groups = "Leaves")
    public void option_DontAllowPreviousTimeMenaMERequest(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Dont Allow Previous Time MenaME Request", currentDate(), backTime(currentTime(), 3), backTime(currentTime(), 1),
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Leave Request Was Not Submitted"), "Alert Issue: Shoud be alert contain--> Leave Request Was Not Submitted");

    }

    @Test(priority = 1, groups = "Leaves")
    public void option_PreventThisLeaveRequestIn_Sunday(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Prevent This Leave Request In Sunday", "06/10/2024", "9:00 AM", "10:00 AM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("The Leave In Prevented Day"), "Alert Issue: Shoud be alert contain--> The Leave In Prevented Day");

    }

    @Test(priority = 1, groups = "Leaves", enabled = false)
    public void option_LeaveHoursSettingForMenaMERequestsOnly_HalfEveningDay(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest_HoursSetting("Leave Hours Setting For MenaME Requests Only", "01/10/2024", "Half Evening Day",
                false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Your Leave Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Leave Request Has Been Submitted Successfully");

        myRequests.closeAlert();

        mainScreen.myTransactions();
        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Leaves", "Leave Hours Setting For MenaME Requests Only", "01.10.2024");

        softAssert.assertEquals(myTransactions.transactionDetails("Period"), "6:00", "Issue in period");
        softAssert.assertEquals(myTransactions.transactionDetails("From Time"), "5:00 PM", "Issue in From Time!");
        softAssert.assertEquals(myTransactions.transactionDetails("To Time"), "11:00 PM", "Issue in To Time!");
        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "Leaves", enabled = false)
    public void option_LeaveHoursSettingForMenaMERequestsOnly_HalfMorningDay(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest_HoursSetting("Leave Hours Setting For MenaME Requests Only", "01/10/2024", "Half Morning Day",
                false, "", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Your Leave Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Leave Request Has Been Submitted Successfully");

        myRequests.closeAlert();

        mainScreen.myTransactions();
        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Leaves", "Leave Hours Setting For MenaME Requests Only", "01.10.2024");

        softAssert.assertEquals(myTransactions.transactionDetails("Period"), "7:00", "Issue in period");
        softAssert.assertEquals(myTransactions.transactionDetails("From Time"), "9:00 AM", "Issue in From Time!");
        softAssert.assertEquals(myTransactions.transactionDetails("To Time"), "4:00 PM", "Issue in To Time!");
        softAssert.assertAll();

    }

    @Test(priority = 3, groups = "Leaves", enabled = false)
    public void checkOption_ValidateLeaveUpperLimitsOnRequestLevel(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Validate Leave Upper Limits On Request Level", "01/10/2024", "9:00 AM", "11:00 AM",
                false, "", true, false);

        myRequests.openLeaves();
        myRequests.leaveRequest("Validate Leave Upper Limits On Request Level", "10/10/2024", "9:00 AM", "11:00 AM",
                false, "", true, false);

        myRequests.openLeaves();
        myRequests.leaveRequest("Validate Leave Upper Limits On Request Level", "14/10/2024", "9:00 AM", "1:00 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Leave Hours Per Month Exceeded The Upper Limit"), "Alert Issue: Shoud be alert appear--> Leave Hours Per Month Exceeded The Upper Limit");

    }

}
