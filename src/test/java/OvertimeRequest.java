import bases.BaseTest;
import mobileBackend.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.financialInformation.Insurance;
import webBackend.general.*;
import webBackend.personnelInformation.Other;
import webBackend.personnelInformation.PersonnelInformation;

import static utilities.MssqlConnect.menaMeRestPassword;

public class OvertimeRequest extends BaseTest {

    PersonnelInformation personnel;
    FinancialPackage financial;
    Insurance insurance;
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

    @Test(priority = 1, groups = "Overtime")
    public void option_OvertimeHourIsCalculatedAsFixedRateValue(){

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
                "", "", "", "", "01/01/1990");
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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Overtime Hour Is Calculated As Fixed Rate Value", "", "", "",
                "5:30 PM", "8:30 PM", true, "Test Overtime Reason", true, true);

        softAssert.assertTrue(myRequests.checkAlertPopup("Your Overtime Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Overtime Request Has Been Submitted Successfully");

        myRequests.closeAlert();

        mainScreen.myTransactions();
        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Overtime", "Overtime Hour Is Calculated As Fixed Rate Value", "01.10.2024");

        softAssert.assertEquals(myTransactions.transactionDetails("Period"), "3.000 Hours", "Issue in period");
        softAssert.assertEquals(myTransactions.transactionDetails("From"), "5:30 PM", "Issue in From Time!");
        softAssert.assertEquals(myTransactions.transactionDetails("To"), "8:30 PM", "Issue in To Time!");
        softAssert.assertEquals(myTransactions.getTransactionReason(), "Test Overtime Reason", "- Reason Issue!");
        softAssert.assertTrue(myTransactions.attachmentIconInDetails.isDisplayed(), "Attachment Icon NOT appear!");
        softAssert.assertTrue(myTransactions.checkOpenAttachment(), "Attachment NOT Opened!");
        softAssert.assertAll();

    }

    @Test(priority = 1, groups = "Overtime")
    public void option_CalculateTransactionAmountBasedOnSocialSecuritySalary(){

        /////////////// Web Initialize //////////////
        webInitialize();

        login = new Login();
        login.login("sa", "0795798860", "automation", "auto_mob1", false, false);

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1990");
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
        financial.addAllowances("Fixed Allowance", "100", "", "", "", "");
        financial.addAllowances("Allowance Cannot Change", "100", "", "", "", "");

        insurance = new Insurance();
        insurance.socialSecurity(true, false, false, "Social Security",
                "", "", true, false);


        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Calculate Transaction Amount Based on Social Security Salary", "", "", "",
                "5:30 PM", "8:30 PM", false, "", true, false);

        ///////////////////

        mainMenu.mainMenu("Workforce Management","Employees Transactions");

        transactions = new EmployeesTransactions();
        transactions.setEmployeeCode(employeeCode);
        transactions.goToOvertime();

        Assert.assertEquals(transactions.getAmount(1), "26.613", "- Overtime Amount Issue");

    }

    @Test(priority = 1, groups = "Overtime")
    public void option_RelatedToShifts(){

        /////////////// Web Initialize //////////////
        webInitialize();

        login = new Login();
        login.login("sa", "0795798860", "automation", "auto_mob1", false, false);

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1990");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = personnel.employeeCodeGetter();
        menaMeRestPassword(employeeCode);

        other = new Other();
        other.goToShiftDetails();
        other.addShiftDetails(employeeCode, "Regular", "Automation", "With Number H");

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Related To Shifts", "", "", "",
                "5:30 PM", "8:30 PM", false, "", true, false);

        ///////////////////

        mainMenu.mainMenu("Workforce Management","Employees Transactions");

        transactions = new EmployeesTransactions();
        transactions.setEmployeeCode(employeeCode);
        transactions.goToOvertime();

        Assert.assertEquals(transactions.getAmount(1), "22.222", "- Overtime Amount Issue");

    }

    @Test(priority = 26, groups = "Overtime")
    public void checkOption_OvertimeCannotBeEnteredInMenaMe(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();

        Assert.assertFalse(myRequests.checkLeaveType("Overtime Cannot Be Entered in MenaMe"), "This type should be NOT appear: Overtime Cannot Be Entered in MenaMe");

    }

    @Test(priority = 1, groups = "Overtime")
    public void option_IncludeExtraSalariesInTransactionAmountCalculation(){

        /////////////// Web Initialize //////////////
        webInitialize();

        login = new Login();
        login.login("sa", "0795798860", "automation", "auto_mob1", false, false);

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1990");
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

        insurance = new Insurance();
        insurance.addExtraSalary("14");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Include Extra Salaries In Transaction Amount Calculation", "", "", "",
                "5:30 PM", "8:30 PM", false, "", true, false);

        ///////////////////

        mainMenu.mainMenu("Workforce Management","Employees Transactions");

        transactions = new EmployeesTransactions();
        transactions.setEmployeeCode(employeeCode);
        transactions.goToOvertime();

        Assert.assertEquals(transactions.getAmount(1), "21.169", "- Overtime Amount Issue");

    }

    @Test(priority = 1, groups = "Overtime")
    public void option_AllowMoreThanOneTransactionInTheSameDay(){

        /////////////// Web Initialize //////////////
        webInitialize();

        login = new Login();
        login.login("sa", "0795798860", "automation", "auto_mob1", false, false);

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1990");
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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

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

        Assert.assertTrue(myRequests.checkAlertPopup("Your Overtime Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Overtime Request Has Been Submitted Successfully");

    }

    @Test(priority = 1, groups = "Overtime")
    public void option_AllowOvertimeRequestsWithinShiftsPeriods(){

        /////////////// Web Initialize //////////////
        webInitialize();

        login = new Login();
        login.login("sa", "0795798860", "automation", "auto_mob1", false, false);

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1990");
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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openOvertime();
        myRequests.overtimeRequest("01/10/2024", "Allow Overtime Requests Within Shifts Periods", "", "", "",
                "12:30 PM", "2:30 PM", false, "", true, true);

        Assert.assertTrue(myRequests.checkAlertPopup("Your Overtime Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Overtime Request Has Been Submitted Successfully");

    }

}
