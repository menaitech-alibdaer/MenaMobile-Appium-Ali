package oldVersion;

import bases.BaseTest;
import mobileBackend.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.general.*;
import webBackend.personnelInformation.Other;
import webBackend.personnelInformation.PersonnelInformation;

import static utilities.MobileHelper.backTime;
import static utilities.MobileHelper.currentTime;
import static utilities.MssqlConnect.*;
import static utilities.WebHelper.currentDate;

public class LeaveRequest_old extends BaseTest {

    PersonnelInformation personnel;
    FinancialPackage financial;
    Other other;
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;
    MyTransactions myTransactions;
    MyRequests myRequests;

    @Test(priority = 1, groups = "Leaves")
    public void linkEmployeeOnShiftAndRequestLeaveWithinShift(){

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

        other = new Other();
        other.goToShiftDetails();
        other.addShiftDetails(employeeCode, "Regular", "Automation", "WSS");

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Unpaid Leave", "01/10/2024", "10:00 AM", "11:00 AM",
                true, "Test Leave Reason", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Your Leave Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Leave Request Has Been Submitted Successfully");

        myRequests.closeAlert();

        mainScreen.myTransactions();
        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Leaves", "Unpaid Leave", "01.10.2024");

        softAssert.assertEquals(myTransactions.getTransactionReason(), "Test Leave Reason", "- Reason Issue!");
        softAssert.assertTrue(myTransactions.attachmentIconInDetails.isDisplayed(), "Attachment Icon NOT appear!");
        //softAssert.assertTrue(myTransactions.checkOpenAttachment(), "Attachment NOT Opened!");
        softAssert.assertAll();

    }

    @Test(priority = 2, groups = "Leaves")
    public void checkValidationWhenRequestLeaveOutOfShift(){

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

        other = new Other();
        other.goToShiftDetails();
        other.addShiftDetails(employeeCode, "Regular", "Automation", "WSS");

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Unpaid Leave", "01/10/2024", "7:00 PM", "8:00 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Start Time And End Time Should Be Within Shift Start Time"), "Alert Issue: Shoud be alert appear--> Start Time And End Time Should Be Within Shift Start Time And End Time");

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_AlertIfEmployeeLeaveTransactionsFromThisTypeExceeds(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

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

        softAssert.assertTrue(myRequests.checkAlertPopup("You Have Exceeded The Upper Limit Of Leave Transactions Of This Type For This Month"), "Alert Issue: Shoud be alert appear--> You Have Exceeded The Upper Limit Of Leave Transactions Of This Type For This Month");
        myRequests.closeAlert();

        mainScreen.myTransactions();
        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Leaves", "Alert After 2 Leave Per Month", "03.10.2024");

        softAssert.assertEquals(myTransactions.transactionDetails("Date"), "03/10/2024", " - Transaction Date!");
        softAssert.assertEquals(myTransactions.transactionDetails("From Time"), "9:00 AM", " - From Time!");
        softAssert.assertEquals(myTransactions.transactionDetails("To Time"), "10:00 AM", " - To Time!");
        softAssert.assertAll();

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_PreventIfEmployeeLeaveTransactionsFromThisTypeExceeds(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

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

        softAssert.assertTrue(myRequests.checkAlertPopup("You Have Exceeded The Upper Limit Of Leave Transactions Of This Type For This Month"), "Alert Issue: Shoud be alert appear--> You Have Exceeded The Upper Limit Of Leave Transactions Of This Type For This Month");
        myRequests.closeAlert();

        mainScreen.myTransactions();
        myTransactions = new MyTransactions();

        softAssert.assertFalse(myTransactions.checkTransactionInMyTransactions("Financial Transactions", "All", "Prevent After 2 Leave Per Month", "03.10.2024"), " - The Transaction Should be NOT appear in My Transactions!");
        softAssert.assertAll();

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_LeaveHoursUpperLimitHoursPerDay(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Upper And Lower Limit per Day", "01/10/2024", "9:00 AM", "1:00 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Leave Hours Per Day Exceeded The Upper Limit! 03:00 Hours"), "Alert Issue: Shoud be alert appear--> Leave Hours Per Day Exceeded The Upper Limit! 03:00 Hours");

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_LeaveHoursLowerLimitHoursPerDay(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Upper And Lower Limit per Day", "01/10/2024", "9:00 AM", "9:30 AM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Leave Period Is Less Than Leave Lower Limit! 01:00 Hours"), "Alert Issue: Shoud be alert appear--> Leave Period Is Less Than Leave Lower Limit! 01:00 Hours");

    }


    @Test(priority = 3, groups = "Leaves")
    public void checkOption_LeaveHoursUpperLimitHoursPerMonth(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

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

        Assert.assertTrue(myRequests.checkAlertPopup("Leave Hours Per Month Exceeded The Upper Limit"), "Alert Issue: Shoud be alert appear--> Leave Hours Per Month Exceeded The Upper Limit");

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_LeaveHoursUpperLimitHoursPerYear(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

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

        Assert.assertTrue(myRequests.checkAlertPopup("Leave Hours Per Year Exceeded The Upper Limit"), "Alert Issue: Shoud be alert appear--> Leave Hours Per Year Exceeded The Upper Limit");

    }

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_EarnedAfter_2Month_FromHiringDate_checkValidationWhenRequestBeforeThat(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Earned After 2 Month From Hiring Date", "20/01/2020", "9:00 AM", "1:00 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("These Leaves Were Not Earned Yet"), "Alert Issue: Shoud be alert appear--> Leave Hours Per Year Exceeded The Upper Limit");

    }

    @Test(priority = 26, groups = "Leaves")
    public void checkOption_LeaveCannotBeEnteredInMenaME(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1", "auto_mob1", "automation", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();

        Assert.assertFalse(myRequests.checkLeaveType("Leave Cannot Be Entered in MenaME"), "This type should be NOT appear: Leave Cannot Be Entered in MenaME");

    }

    @Test(priority = 7, groups = "Leaves")
    public void checkOption_TheSupportDocumentIsMandatory(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("The Support Document Is Mandatory - With Day and Time", "08/10/2024", "11:30 AM", "1:30 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Your Leave Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Leave Request Has Been Submitted Successfully");

    }

    @Test(priority = 7, groups = "Leaves")
    public void checkOption_LeaveRequestReasonIsMandatory(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Leave Request Reason Is Mandatory", "", "9:30 AM", "11:30 PM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkToastAlert("Please Fill The Reason"), "Alert Issue: Shoud be alert appear--> Please Fill The Reason");

    }

    @Test(priority = 1, groups = "Leaves")
    public void option_AllowOutOfShiftLeave(){

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

        other = new Other();
        other.goToShiftDetails();
        other.addShiftDetails(employeeCode, "Regular", "Automation", "WSS");

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Dont Allow Previous Date MenaME Request", "01/10/2024", "10:00 AM", "11:00 AM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Leave Transaction Can Not Be Before Current Date"), "Alert Issue: Shoud be alert contain--> Leave Transaction Can Not Be Before Current Date");

    }

    @Test(priority = 1, groups = "Leaves")
    public void option_DontAllowPreviousTimeMenaMERequest(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Dont Allow Previous Time MenaME Request", currentDate(), backTime(currentTime(), 3), backTime(currentTime(), 1),
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Leave Transaction Can Not Be Before Current Time"), "Alert Issue: Shoud be alert contain--> Leave Transaction Can Not Be Before Current Time");

    }

    @Test(priority = 1, groups = "Leaves")
    public void option_PreventThisLeaveRequestIn_Sunday(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openLeaves();
        myRequests.leaveRequest("Prevent This Leave Request In Sunday", "06/10/2024", "9:00 AM", "10:00 AM",
                false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("You Can Not Request A Leave On Sunday"), "Alert Issue: Shoud be alert contain--> You Can Not Request A Leave On Sunday");

    }

    @Test(priority = 1, groups = "Leaves")
    public void option_LeaveHoursSettingForMenaMERequestsOnly_HalfEveningDay(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

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

    @Test(priority = 1, groups = "Leaves")
    public void option_LeaveHoursSettingForMenaMERequestsOnly_HalfMorningDay(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

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

    @Test(priority = 3, groups = "Leaves")
    public void checkOption_ValidateLeaveUpperLimitsOnRequestLevel(){

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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", "automation", false);

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
