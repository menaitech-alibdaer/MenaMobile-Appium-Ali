package newVersion;

import apiBackend.AllEmployeeTransactions;
import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import bases.BaseTest;
import mobileBackend.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.general.*;
import webBackend.personnelInformation.Other;
import webBackend.personnelInformation.PersonnelInformation;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static utilities.MobileHelper.currentDate_mobile;
import static utilities.MobileHelper.currentDate_mobile_new;
import static utilities.MssqlConnect.menaMeRestPassword;
import static utilities.MssqlConnect.setMenaMePassword;
import static utilities.WebHelper.*;

public class VacationRequest extends BaseTest {

    PersonnelInformation personnel;
    FinancialPackage financial;
    VacationsBalances vacationsBalances;
    Other other;
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;
    Notifications notifications;
    MyTransactions myTransactions;
    MyRequests myRequests;
    Manager manager;
    AllEmployeeTransactions allTransactions;
    CompanyAndBranch companyAndBranch;
    Employees employees;


    @Test(priority = 1, groups = "Vacations")
    public void requestUnpaidVacationWithAttachmentAndReason(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "", "10/01/2023", "10/01/2023",
                true, 1, "Test Appium Reason", "", true, false);

        mainScreen.myTransactions();

        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Unpaid Vacation", "10.01.2023");

        softAssert.assertEquals(myTransactions.getTransactionReason(), "Test Appium Reason", "- Reason Issue!");
        softAssert.assertTrue(myTransactions.checkAttachmentIcon(), "Attachment Icon NOT appear!");
        //softAssert.assertTrue(myTransactions.checkOpenAttachment(), "Attachment NOT Opened!");
        softAssert.assertAll();

    }

    @Test(priority = 2, groups = "Vacations")
    public void requestUnpaidVacationAndWithdraw(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("To Test Withdraw", "", "11/01/2023", "11/01/2023",
                false, 1, "", "", true, false);

        mainScreen.myTransactions();

        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "To Test Withdraw", "11.01.2023");
        myTransactions.withdraw();

        Assert.assertEquals(myTransactions.getApprovalCommittee("HR Manager"), "Dropped", "The Transaction NOT Dropped!");

    }

    @Test(priority = 3, groups = "Vacations")
    public void checkValidationForEmployeeWithoutVacationBalance(){

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
        employees.addVacationBalance("Do Not Allow To Exceed Vacation End Of Year Balance", "0", "14", currentYear(), currentYear()+"-01-01", currentYear()+"-12-31", true);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
//        myRequests.vacationRequest("Balance - Never Exceed Annual Balance", "", "05/05/2023", "05/05/2023",
//                false, 1, "", "", true, true);
        myRequests.vacationRequest("Do Not Allow To Exceed Vacation End Of Year Balance", "", "01/03/"+currentYear(), "20/03/"+currentYear(),
                false, 1, "", "", true, true); /// for new system revamp

        //Assert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("Exceeded The End Of Year Remaining Balance"), "The alert NOT contain: Exceeded The Remaining Balance!");
        Assert.assertTrue(myRequests.checkAlertPopup("Cannot Exceed the Up To End Of Year"), "The alert NOT contain: Exceeded The Remaining Balance!");

    }

    @Test(priority = 4, groups = "Vacations")
    public void checkRequestTwoVacationInTheSameDate(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "", "05/05/2023", "05/05/2023",
                false, 1, "", "", true, false);

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "", "05/05/2023", "05/05/2023",
                false, 1, "", "", true, true);

        //softAssert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("You Can Not Add This Vacation"), "The alert NOT contain: You Can Not Add This Vacation!");
        //softAssert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("in Same Day"), "The alert NOT contain: in Same Day");
        //softAssert.assertTrue(myRequests.checkAlertPopup("You Can Not Add This Vacation"), "The alert NOT contain: You Can Not Add This Vacation!");
        softAssert.assertTrue(myRequests.checkAlertPopup("overlap detected"), "The alert NOT contain: Vacation overlap detected!");
        softAssert.assertAll();

    }

    @Test(priority = 5, groups = "Vacations")
    public void checkReasonIsMandatory(){

        mobileInitialize();

        loginMob = new MobileLogin();
        setMenaMePassword("auto_mobile1", "Revamp");
        loginMob.login("auto_mobile1", "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Reason Is Mandatory", "", "05/05/2023", "05/05/2023",
                false, 1, "", "", true, true);

        //Assert.assertTrue(myRequests.pleaseFillTheReason_Alert.isDisplayed(), "Alert Issue - shoud lbe appear: Please Fill The Reason!");
        Assert.assertTrue(myRequests.checkToastAlert("Reason Is Required"), "Alert Issue - shoud be appear: Reason Is Required! - But the alert appear is --> "+myRequests.getToastAlert());

    }

    @Test(priority = 6, groups = "Vacations")
    public void checkPhoneNumberIsMandatory(){

        mobileInitialize();

        loginMob = new MobileLogin();
        setMenaMePassword("auto_mobile1", "Revamp");
        loginMob.login("auto_mobile1", "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Phone Number Is Mandatory", "", "05/05/2023", "05/05/2023",
                false, 1, "", "", true, true);

        //Assert.assertTrue(myRequests.pleaseInsertPhoneNumber_Alert.isDisplayed(), "Alert Issue - shoud lbe appear: Please Insert Phone Number!");
        Assert.assertTrue(myRequests.checkToastAlert("Please Insert Phone Number"), "Alert Issue - shoud lbe appear: Please Insert Phone Number! - But the alert appear is --> "+myRequests.getToastAlert());

    }

    @Test(priority = 7, groups = "Vacations", enabled = false)
    public void checkTheDocumentIsMandatoryContinuousDays_UploadExceedTheAllowedNumberOfAttachments(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        setMenaMePassword("auto_mobile1", "Revamp");
        loginMob.login("auto_mobile1", "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest_checkAlertAfterUploadAttachment("Document Is Mandatory After 2 Days - Allowed Number = 2", "10/10/2023", "11/10/2023",
                true, 2);

        //Assert.assertTrue(myRequests.theMaximumNumberOfAttachmentIs2_Alert.isDisplayed(), "Alert Issue: Shoud be alert appear--> The maximum number of attachment is : 2");
        Assert.assertTrue(myRequests.checkToastAlert("The maximum number of attachment is : 2"), "Alert Issue: Shoud be alert appear--> The maximum number of attachment is : 2 - But the alert appear is --> "+myRequests.getToastAlert());

    }

    @Test(priority = 8, groups = "Vacations", enabled = false)
    public void checkTheDocumentIsMandatoryContinuousDays_ForTwoDaysValidation_withoutUploadAttachment(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory After 2 Days - Allowed Number = 2", "", "10/10/2023", "11/10/2023",
                false, 0, "", "", true, true);

        //Assert.assertTrue(myRequests.maximumAllowedAttachmentsIs2AndMinimumAllowedAttachmentsIs1.isDisplayed(), "Alert Issue: Shoud be alert appear--> Maximum Allowed Attachments Is 2 And Minimum Allowed Attachments Is 1");
        softAssert.assertTrue(myRequests.checkToastAlert("Maximum Allowed Attachments Is 2 And Minimum Allowed Attachments Is"), "Alert Issue: Shoud be alert appear--> Maximum Allowed Attachments Is 2 And Minimum Allowed Attachments Is 1 - But the alert appear is --> "+myRequests.getToastAlert());
        softAssert.assertTrue(myRequests.checkToastAlert("1"));
        softAssert.assertAll();

    }

    @Test(priority = 9, groups = "Vacations", enabled = false)
    public void checkTheDocumentIsMandatoryContinuousDays_SuccessValidation_Upload2Attachment(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory After 2 Days - Allowed Number = 2", "", "10/10/2023", "11/10/2023",
                true, 2, "", "", true, true);

        //Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");
        Assert.assertTrue(myRequests.checkAlertPopup("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");

    }

    @Test(priority = 10, groups = "Vacations", enabled = false)
    public void checkTheDocumentIsMandatoryContinuousDays_RequestOneDayOfVacation(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory After 2 Days - Allowed Number = 2", "", "10/10/2023", "10/10/2023",
                false, 0, "", "", true, true);

        //Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");
        Assert.assertTrue(myRequests.checkAlertPopup("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");

    }

    @Test(priority = 11, groups = "Vacations", enabled = false)
    public void checkTheDocumentIsMandatory_AccumulativeDays_UploadExceedTheAllowedNumberOfAttachments(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();

        myRequests.vacationRequest("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "", "10/10/2023", "10/10/2023",
                false, 0, "", "", true, false);

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest_checkAlertAfterUploadAttachment("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "11/10/2023", "11/10/2023",
                true, 2);

        //Assert.assertTrue(myRequests.theMaximumNumberOfAttachmentIs2_Alert.isDisplayed(), "Alert Issue: Shoud be alert appear--> The maximum number of attachment is : 2");
        Assert.assertTrue(myRequests.checkToastAlert("The maximum number of attachment is : 2"), "Alert Issue: Shoud be alert appear--> The maximum number of attachment is : 2 - But the alert appear is --> "+myRequests.getToastAlert());

    }

    @Test(priority = 12, groups = "Vacations", enabled = false)
    public void checkTheDocumentIsMandatory_AccumulativeDays_ForTwoDaysValidation_withoutUploadAttachment(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();

        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "", "05/05/2023", "05/05/2023",
                false, 0, "", "", true, false);

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "", "06/05/2023", "06/05/2023",
                false, 0, "", "", true, true);

        //softAssert.assertTrue(mainScreen.attentionAlertPopup.isDisplayed(), "Attention Please Alert NOT Appear!");
        //softAssert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("Minimum Number Of Allowed Attachments Is(1)"), "Alert Issue: Shoud be alert appear--> Minimum Number Of Allowed Attachments Is(1)]");
        softAssert.assertTrue(myRequests.checkAlertPopup("Minimum Number Of Allowed Attachments Is(1)"), "Alert Issue: Shoud be alert appear--> Minimum Number Of Allowed Attachments Is(1)]");
        softAssert.assertAll();

    }

    @Test(priority = 13, groups = "Vacations", enabled = false)
    public void checkTheDocumentIsMandatory_AccumulativeDays_SuccessValidation_Upload2Attachment(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "", "05/05/2023", "05/05/2023",
                false, 0, "", "", true, false);

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "", "06/05/2023", "06/05/2023",
                true, 2, "", "", true, true);

        //Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");
        Assert.assertTrue(myRequests.checkAlertPopup("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");

    }

    @Test(priority = 14, groups = "Vacations")
    public void checkAlertWhenRequestVacationsInPreviousDateAndFutureDate_WhenOptionsChecked(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Can Not Be Requested In Future Date", "", "05/05/2030", "05/05/2030",
                false, 0, "", "", true, true);

        //softAssert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("You Can Not Request This Vacation In A Future Date"), "Alert Issue: Shoud be alert appear--> You Can Not Request This Vacation In A Future Date");
        softAssert.assertTrue(myRequests.checkAlertPopup("Cannot Request Vacation With Future Date"), "Alert Issue: Shoud be alert appear--> Cannot Request Vacation With Future Date");

        myRequests.closeAlert();

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Can Not Be Requested In Previous Date", "", "06/05/2023", "06/05/2023",
                false, 0, "", "", true, true);

        //softAssert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("before the current date"), "Alert Issue: Shoud be alert appear--> Transaction Date can`t be before the current date");
        softAssert.assertTrue(myRequests.checkAlertPopup("Cannot Request Vacation With Previous Date"), "Alert Issue: Shoud be alert appear--> Cannot Request Vacation With Previous Date");
        softAssert.assertAll();

    }

    ///////// Recheck ////////////
    @Test(priority = 15, groups = "Vacations", enabled = false)
    public void checkRequestAlertWhenDelegateIsMandatory(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("To Test Delegate", "", "", "",
                false, 0, "", "", true, true);

        //Assert.assertTrue(myRequests.autoDelegationIsMandatoryBeforeVacationRequest_Alert.isDisplayed(), "Alert Issue : it should be appear this alert: Auto Delegation Is Mandatory Before Vacation Request!");
        Assert.assertTrue(myRequests.checkToastAlert("Auto Delegation Is Mandatory Before Vacation Request"), "Alert Issue : it should be appear this alert: Auto Delegation Is Mandatory Before Vacation Request! - But the alert appear is --> "+myRequests.getToastAlert());

    }

    @Test(priority = 16, groups = "Vacations")
    public void checkRequestVacationWhenSelectDelegateIsNotRequired(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("To Test Delegate", "", "", "",
                false, 0, "", "Not Required", true, true);

        //Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");
        Assert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "Alert Issue: Shoud be alert appear--> Done Successfully");

    }

    ///////// Recheck ////////////
    @Test(priority = 17, groups = "Vacations", enabled = false)
    public void checkRequestVacationWhenSelectDelegateIs_AllEmployees(){

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
        String emp1 = employees.getEmployeeCode();

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        //String emp2 = employees.getEmployeeCode();
        String emp2_Name = employees.getFullNameEmployee();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(emp1, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("To Test Delegate", "", "", "",
                false, 0, "", emp2_Name, true, true);

        //Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");
        Assert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "Alert Issue: Shoud be alert appear--> Done Successfully");

    }

    ///////// Recheck ////////////
    @Test(priority = 18, groups = "Vacations", enabled = false)
    public void checkRequestVacationWhenSelectDelegateIs_EmployeeSubstitutes(){

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
                true, "Regular", "", "", 0, true, true);
        String directManager = employees.getEmployeeCode();
        String substituteCode = directManager;

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        employees.addSubstitute(employee, substituteCode, false);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("To Test Delegate - Substitutes", "", "", "",
                false, 0, "", substituteCode, true, true);

        //Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");
        Assert.assertTrue(myRequests.checkAlertPopup("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");

    }

    ///////// Recheck ////////////
    @Test(priority = 19, groups = "Vacations", enabled = false)
    public void checkDelegatePopupAndCheckTheResultWhenType_EmployeeSubstitutes(){

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
                true, "Regular", "", "", 0, true, true);
        String directManager = employees.getEmployeeCode();
        String substituteCode = directManager;

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        employees.addSubstitute(employee, substituteCode, false);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.selectVacationType("To Test Delegate - Substitutes");
        myRequests.openDelegatePopup();

        softAssert.assertTrue(myRequests.resultFound.getAttribute("content-desc").contains("1 results found"), "The Result found shoud be = 1");
        softAssert.assertEquals(myRequests.listOfEmployees.size(), 1, "The list shoud be contain 1 employee");
        softAssert.assertTrue(myRequests.listOfEmployees.get(0).getAttribute("content-desc").contains(substituteCode), "the employee code in the list shoud be: "+substituteCode);
        softAssert.assertAll();

    }

    @Test(priority = 20, groups = "Vacations")
    public void requestUnpaidVacationWithAttachmentAndReason_And_Approve_ByDirectManager(){

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
                true, "Regular", "", "", 0, true, true);
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
        String employeeName = employees.getFullNameEmployee();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "", "10/01/2023", "10/01/2023",
                true, 1, "Test Appium Reason", "", true, false);

        mainScreen.myTransactions();

        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Unpaid Vacation", "10.01.2023");

        softAssert.assertEquals(myTransactions.getApprovalCommittee(directManagerName), "Pending", "Approval Committee status issue - should be is: Pending");

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();

        softAssert.assertTrue(manager.transaction(employee).contains("COD: "+employee), "Issue COD!");
        softAssert.assertTrue(manager.transaction(employee).contains(employeeName), "Employee Name Issue! Should be: "+employeeName);
        //softAssert.assertTrue(manager.transaction(employee).contains("Unpaid Vacation"), "Transaction Type! should be : Unpaid Vacation");
        softAssert.assertTrue(manager.transaction(employee).contains("Vacation Request"), "Transaction Type! should be : Vacation Request");
        //softAssert.assertTrue(manager.transaction(employee).contains("10.01.2023"), "Transaction Date! should be : 10.01.2023");
        softAssert.assertTrue(manager.transaction(employee).contains(currentDate_mobile()), "Transaction Date! should be : "+currentDate_mobile());
        //softAssert.assertTrue(manager.transaction(employee).contains("1.000"), "Transaction Period! should be : 1.000");

        manager.openTransaction(employee, "Unpaid Vacation");

        softAssert.assertEquals(manager.transactionDetails("Site"), "New Zarqa", "Site!");
        softAssert.assertEquals(manager.transactionDetails("Department"), "Quality", "Department!");
        softAssert.assertEquals(manager.transactionDetails("Job Title"), "Software Test Engineer", "Job Title!");
        softAssert.assertEquals(manager.transactionDetails("Section"), "Quality Control", "Section!");
        softAssert.assertEquals(manager.transactionDetails("Nationality"), "Jordanian", "Nationality!");
        softAssert.assertEquals(manager.transactionDetails("Transaction Type"), "Unpaid Vacation", "Transaction Type!");
        softAssert.assertEquals(manager.transactionDetails("Request Date").contains(currentDate_mobile_new()), "Request Date!");
        softAssert.assertEquals(manager.transactionDetails("From Date"), "10/01/2023", "From Date!");
        softAssert.assertEquals(manager.transactionDetails("To Date"), "10/01/2023", "To Date!");
        softAssert.assertEquals(manager.transactionDetails("Amount"), "32.26 JOD", "Amount!");
        //softAssert.assertEquals(manager.transactionDetails("Resume Date"), "Wednesday, 11.01.2023", "Resume Date!");
        //softAssert.assertEquals(manager.transactionDetails("Branch Code"), "auto_mob1", "Branch Code!");
        softAssert.assertEquals(manager.transactionDetails("Period"), "1 Day", "Period!");
        //softAssert.assertEquals(mainScreen.getTransactionReason(), "Test Appium Reason", "- Reason Issue!");
        softAssert.assertTrue(manager.checkAttachmentIcon(), "Attachment Icon NOT appear!");
        //softAssert.assertTrue(manager.checkAttachmentInVacationDetails(), "Attachment NOT Opened!");

        manager.approve("Appium Comment - Approve");

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false);
        mainScreen = new MainScreen();

        mainScreen.myTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Unpaid Vacation", "10.01.2023");

        softAssert.assertEquals(myTransactions.getApprovalCommittee(directManagerName), "Approved", "Approval Committee status issue - should be is: Approved");
        softAssert.assertEquals(myTransactions.getApprovalComments(directManagerName), "Appium Comment - Approve", "Approval Comment issue - should be is: Appium Comment - Approve");
        //softAssert.assertEquals(myTransactions.getApprovalDate(directManagerName), currentDate_mobile(), "Approval Date issue - should be is: "+currentDate_mobile());

        softAssert.assertAll();

    }

    @Test(priority = 21, groups = "Vacations")
    public void requestUnpaidVacationWithAttachmentAndReason_And_Reject_ByDirectManager(){

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
                true, "Regular", "", "", 0, true, true);
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

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "", "10/01/2023", "10/01/2023",
                true, 1, "Test Appium Reason", "", true, false);

        mainScreen.myTransactions();

        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Unpaid Vacation", "10.01.2023");

        softAssert.assertEquals(myTransactions.getApprovalCommittee(directManagerName), "Pending", "Approval Committee status issue - should be is: Pending");

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();

        softAssert.assertTrue(manager.transaction(employee).contains("COD: "+employee), "Issue COD!");
        softAssert.assertTrue(manager.transaction(employee).contains(employeeFullName), "Employee Name Issue! Should be: "+employeeFullName);
        //softAssert.assertTrue(manager.transaction(employee).contains("Unpaid Vacation"), "Transaction Type! should be : Unpaid Vacation");
        softAssert.assertTrue(manager.transaction(employee).contains("Vacation Request"), "Transaction Type! should be : Vacation Request");
        //softAssert.assertTrue(manager.transaction(employee).contains("10.01.2023"), "Transaction Date! should be : 10.01.2023");
        softAssert.assertTrue(manager.transaction(employee).contains(currentDate_mobile()), "Transaction Date! should be : "+currentDate_mobile());
        //softAssert.assertTrue(manager.transaction(employee).contains("1.000"), "Transaction Period! should be : 1.000");

        manager.openTransaction(employee, "Unpaid Vacation");

        softAssert.assertEquals(manager.transactionDetails("Site"), "New Zarqa", "Site!");
        softAssert.assertEquals(manager.transactionDetails("Department"), "Quality", "Department!");
        softAssert.assertEquals(manager.transactionDetails("Job Title"), "Software Test Engineer", "Job Title!");
        softAssert.assertEquals(manager.transactionDetails("Section"), "Quality Control", "Section!");
        softAssert.assertEquals(manager.transactionDetails("Nationality"), "Jordanian", "Nationality!");
        softAssert.assertEquals(manager.transactionDetails("Transaction Type"), "Unpaid Vacation", "Transaction Type!");
        softAssert.assertEquals(manager.transactionDetails("Request Date").contains(currentDate_mobile_new()), "Request Date!");
        softAssert.assertEquals(manager.transactionDetails("From Date"), "10/01/2023", "From Date!");
        softAssert.assertEquals(manager.transactionDetails("To Date"), "10/01/2023", "To Date!");
        softAssert.assertEquals(manager.transactionDetails("Amount"), "32.26 JOD", "Amount!");
        //softAssert.assertEquals(manager.transactionDetails("Resume Date"), "Wednesday, 11.01.2023", "Resume Date!");
        //softAssert.assertEquals(manager.transactionDetails("Branch Code"), "auto_mob1", "Branch Code!");
        softAssert.assertEquals(manager.transactionDetails("Period"), "1 Day", "Period!");
        //softAssert.assertEquals(mainScreen.getTransactionReason(), "Test Appium Reason", "- Reason Issue!");
        softAssert.assertTrue(manager.checkAttachmentIcon(), "Attachment Icon NOT appear!");
        //softAssert.assertTrue(manager.checkAttachmentInVacationDetails(), "Attachment NOT Opened!");

        manager.reject("Appium Comment - Reject");

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false);
        mainScreen = new MainScreen();
        mainScreen.myTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Unpaid Vacation", "10.01.2023");

        softAssert.assertEquals(myTransactions.getApprovalCommittee(directManagerName), "Rejected", "Approval Committee status issue - should be is: Rejected");
        softAssert.assertEquals(myTransactions.getApprovalComments(directManagerName), "Appium Comment - Reject", "Approval Comment issue - should be is: Appium Comment - Reject");
        //softAssert.assertEquals(myTransactions.getApprovalDate(directManagerName), currentDate_mobile(), "Approval Date issue - should be is: "+currentDate_mobile());

        softAssert.assertAll();

    }

    @Test(priority = 22, groups = "Vacations", enabled = false)
    public void checkSickVacationReasonsFieldIfAppearWhenSelectSickVacation(){

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

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");
        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest_checkSickVacationReasonsField("Sick Vacation", false);

        softAssert.assertTrue(myRequests.sickVacationReasons_title.isDisplayed(), "Sick Vacation Reasons title NOT appear!");
        softAssert.assertTrue(myRequests.sickVacationReasons_mandatory.isDisplayed(), "Sick Vacation Reasons title NOT Mandatory ( * ) not appear!");
        softAssert.assertAll();

    }

    @Test(priority = 23, groups = "Vacations", enabled = false)
    public void checkItemsInSickVacationReasonsFieldIfAllAppear(){

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

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");
        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest_checkSickVacationReasonsField("Sick Vacation", true);

        softAssert.assertEquals(myRequests.sickVacationReasonsList.size(), 4, "Sick Vacation Reasons List NOT Retrieve All Items!");
        softAssert.assertTrue(getBy(accessibilityId("Reason 1")).isDisplayed(), "Sick Vacation Reasons type = 'Reason 1' NOT appear!");
        softAssert.assertTrue(getBy(accessibilityId("Reason 2")).isDisplayed(), "Sick Vacation Reasons type = 'Reason 2' NOT appear!");
        softAssert.assertTrue(getBy(accessibilityId("Reason 3")).isDisplayed(), "Sick Vacation Reasons type = 'Reason 3' NOT appear!");
        softAssert.assertTrue(getBy(accessibilityId("Reason 4")).isDisplayed(), "Sick Vacation Reasons type = 'Reason 4' NOT appear!");
        softAssert.assertAll();

    }

    @Test(priority = 24, groups = "Vacations", enabled = false)
    public void checkValidationWhenRequestSickVacationWithoutChooseSickVacationReason(){

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

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");
        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Sick Vacation", "", "", "",
                false, 0, "", "", true, true);

        //Assert.assertTrue(myRequests.youMustFillSickVacationReason_Alert.isDisplayed(), "Alert Issue : it should be appear this alert: You Must Fill Sick Vacation Reason");
        Assert.assertTrue(myRequests.checkToastAlert("You Must Fill Sick Vacation Reason"), "Alert Issue : it should be appear this alert: You Must Fill Sick Vacation Reason - But the alert appear is --> "+myRequests.getToastAlert());

    }

    @Test(priority = 25, groups = "Vacations", enabled = false)
    public void requestSickVacationWithChooseSickVacationReason_Successfully(){

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

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employeeCode);
        financial.setBasicSalary("1000");
        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Sick Vacation", "Reason 2", "", "",
                false, 0, "", "", true, true);

        //Assert.assertTrue(myRequests.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");
        Assert.assertTrue(myRequests.checkAlertPopup("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");

    }

    @Test(priority = 26, groups = "Vacations")
    public void checkOptionVacationCannotBeEnteredInMenaMe(){

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        setMenaMePassword("auto_mobile1", "Revamp");
        loginMob.login("auto_mobile1", "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();

        Assert.assertFalse(myRequests.checkVacationType("Vacation Cannot Be Entered in MenaMe"), "This type should be NOT appear: Vacation Cannot Be Entered in MenaMe");

    }

    @Test(priority = 27, groups = "Vacations")
    public void requestVacationAndApprovedByManagerAndPostTransactionFromSystem(){

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
                true, "Regular", "", "", 0, true, true);
        String directManager = employees.getEmployeeCode();

        employees.createNewEmployee("1980-01-01", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "", "10/05/2024", "10/05/2024",
                false, 0, "", "", true, false);

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Unpaid Vacation");
        manager.approve();

        /////////// API - Rest Assured ////////////
        allTransactions = new AllEmployeeTransactions();

        softAssert.assertEquals(allTransactions.getVacationFromDate(employee, 0), "2024-05-10");
        softAssert.assertEquals(allTransactions.getVacationToDate(employee, 0), "2024-05-10");
        softAssert.assertEquals(allTransactions.getVacationType(employee, 0), "Unpaid Vacation");

        softAssert.assertAll();

    }

    ///////// Recheck ////////////
    @Test(priority = 28, groups = "Vacations", enabled = false)
    public void checkRequestToCancelAfterApprovedTransaction_request_approveByManager_RecheckStatusInEmployeeSide(){

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
                true, "Regular", "", "", 0, true, true);
        String directManager = employees.getEmployeeCode();
        String directManagerName = employees.getFirstAndLastNameEmployee();

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "", "10/03/2024", "10/03/2024",
                false, 0, "", "", true, false);

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Unpaid Vacation");
        manager.approve();

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false);
        mainScreen = new MainScreen();
        mainScreen.myTransactions();

        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Unpaid Vacation", "10.03.2024");
        myTransactions.cancel();

        softAssert.assertFalse(myTransactions.checkCancelButtonIfVisible(), "Cancel Button Should be NOT Appear After Request To Cancel!!");

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Unpaid Vacation");
        manager.approve();

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false);
        mainScreen = new MainScreen();
        mainScreen.myTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Unpaid Vacation", "10.03.2024");

        softAssert.assertEquals(myTransactions.getApprovalCommittee(directManagerName), "Cancel", "Approval Committee status issue - should be is: Rejected");
        softAssert.assertEquals(myTransactions.getApprovalDate(directManagerName), currentDate_mobile(), "Approval Date issue - should be is: "+currentDate_mobile());

        softAssert.assertAll();

    }

    ///////// Recheck ////////////
    @Test(priority = 29, groups = "Vacations", enabled = false)
    public void checkRequestToCancelAfterRejectedTransaction_request_approveByManager_RecheckStatusInEmployeeSide(){

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
                true, "Regular", "", "", 0, true, true);
        String directManager = employees.getEmployeeCode();
        String directManagerName = employees.getFirstAndLastNameEmployee();

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "", "10/03/2024", "10/03/2024",
                false, 0, "", "", true, false);

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Unpaid Vacation");
        manager.approve();

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false);
        mainScreen = new MainScreen();
        mainScreen.myTransactions();

        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Unpaid Vacation", "10.03.2024");
        myTransactions.cancel();

        softAssert.assertFalse(myTransactions.checkCancelButtonIfVisible(), "Cancel Button Should be NOT Appear After Request To Cancel!!");

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Unpaid Vacation");
        manager.reject();

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false);
        mainScreen = new MainScreen();
        mainScreen.myTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Unpaid Vacation", "10.03.2024");

        softAssert.assertEquals(myTransactions.getApprovalCommittee(directManagerName), "Approved", "Approval Committee status issue - should be is: Approved");
        softAssert.assertEquals(myTransactions.getApprovalDate(directManagerName), currentDate_mobile(), "Approval Date issue - should be is: "+currentDate_mobile());

        softAssert.assertAll();

    }

    ///////// Recheck ////////////
    @Test(priority = 30, groups = "Vacations", enabled = false)
    public void requestVacationAndConsultToOtherEmployee(){

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
                true, "Regular", "", "", 0, true, true);
        String directManager = employees.getEmployeeCode();
        String directManagerName = employees.getFirstAndLastNameEmployee();
        //String directManagerFullName = employees.getFullNameEmployee();

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        String employeeName = employees.getFullNameEmployee();

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String thirdEmployee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        String thirdEmployeeFullName = employees.getFullNameEmployee();
        String thirdEmployeeName = employees.getFirstAndLastNameEmployee();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Test Delegate and Consult", "", "10/01/2023", "10/01/2023",
                false, 0, "", "", true, false);

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Test Delegate and Consult");

        manager.consult(thirdEmployeeFullName, "Appium Comment - Consult");

        mainScreen.logout();

        loginMob.login(thirdEmployee, "sa", "automobile", false);
        mainScreen = new MainScreen();
        mainScreen.openNotifications();

        notifications = new Notifications();
        notifications.openWorkflowApprovals();
        notifications.openTransaction("Vacation Request", employeeName);
        notifications.sendFeedback("Consult Comment By Third Employee");

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Test Delegate and Consult");
        manager.openConsultationHistory();

        softAssert.assertEquals(manager.getConsultComment(directManagerName), "Appium Comment - Consult");
        softAssert.assertEquals(manager.getConsultComment(thirdEmployeeName), "Consult Comment By Third Employee");
        softAssert.assertAll();

    }

    ///////// Recheck ////////////
    @Test(priority = 31, groups = "Vacations", enabled = false)
    public void requestVacationAndDelegateToOtherEmployee(){

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
                true, "Regular", "", "", 0, true, true);
        String directManager = employees.getEmployeeCode();
        //String directManagerName = employees.getFirstAndLastNameEmployee();
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

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String thirdEmployee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        String thirdEmployeeFullName = employees.getFullNameEmployee();
        String thirdEmployeeName = employees.getFirstAndLastNameEmployee();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Test Delegate and Consult", "", "10/01/2023", "10/01/2023",
                false, 0, "", "", true, false);

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Test Delegate and Consult");

        manager.delegate(thirdEmployeeFullName, "Delegate By Appium");

        mainScreen.logout();

        loginMob.login(thirdEmployee, "sa", "automobile", false);
        mainScreen = new MainScreen();
        mainScreen.openNotifications();

        notifications = new Notifications();
        notifications.openWorkflowApprovals();
        notifications.openTransaction("Vacation Request", employeeFullName);

        manager = new Manager();

        softAssert.assertEquals(manager.getManagerCommentDelegate(directManagerFullName), "Delegate By Appium", " - Issue in delegate comment!");

        manager.approve();

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false);
        mainScreen = new MainScreen();

        mainScreen.myTransactions();
        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Test Delegate and Consult", "10.01.2023");

        softAssert.assertEquals(myTransactions.getApprovalCommittee(thirdEmployeeName), "Approved", "Approval Committee status issue - should be is: Approved");
        softAssert.assertEquals(myTransactions.getApprovalDate(thirdEmployeeName), currentDate_mobile(), "Approval Date issue - should be is: "+currentDate_mobile());

        softAssert.assertAll();

    }

    @Test(priority = 32, groups = "Vacations")
    public void checkValidationForThisOption_AnnualUpperLimit(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Annual Upper Limit 14", "", "01/05/2023", "10/05/2023",
                false, 0, "", "", true, false);

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Annual Upper Limit 14", "", "01/07/2023", "01/07/2023",
                false, 0, "", "", true, false);

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Annual Upper Limit 14", "", "20/08/2023", "25/08/2023",
                false, 0, "", "", true, true);

        //Assert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("The Employee Has Exceeded The Upper Limit For The Vacation"), "Alert Issue!!! - The alert NOT contain: The Employee Has Exceeded The Upper Limit For The Vacation!");
        Assert.assertTrue(myRequests.checkAlertPopup("Exceeded The maximum days per year"), "Alert Issue!!! - The alert NOT contain: The Employee Has Exceeded The Upper Limit For The Vacation!");

    }

    @Test(priority = 33, groups = "Vacations", enabled = false)
    public void checkValidationForThisOption_MonthlyUpperLimit(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Monthly Upper Limit 3", "", "01/05/2023", "02/05/2023",
                false, 0, "", "", true, false);

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Monthly Upper Limit 3", "", "15/05/2023", "19/05/2023",
                false, 0, "", "", true, true);

        //Assert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("The Employee Has Exceeded The Monthly Upper Limit For The Vacation"), "Alert Issue!!! - The alert NOT contain: The Employee Has Exceeded The Upper Limit For The Vacation!");
        Assert.assertTrue(myRequests.checkAlertPopup("The Employee Has Exceeded The Monthly Upper Limit For The Vacation"), "Alert Issue!!! - The alert NOT contain: The Employee Has Exceeded The Upper Limit For The Vacation!");

    }

    @Test(priority = 34, groups = "Vacations")
    public void checkValidation_EarnedAfter_HiringDate(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Earned After - 3 Month", "", "01/02/2020", "02/02/2020",
                false, 0, "", "", true, true);

        //softAssert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("These Vacations Were Not Earned Yet"), "Alert Issue!!! - The alert NOT contain: These Vacations Were Not Earned Yet!");
        softAssert.assertTrue(myRequests.checkAlertPopup("not earned for this vacation"), "Alert Issue!!! - The alert NOT contain: These Vacations Were Not Earned Yet!");

        myRequests.closeAlert();

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Earned After - 3 Month", "", "01/05/2020", "02/05/2020",
                false, 0, "", "", true, true);

        //softAssert.assertTrue(myRequests.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");
        softAssert.assertTrue(myRequests.checkAlertPopup("Done Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");
        softAssert.assertAll();

    }

    @Test(priority = 35, groups = "Vacations")
    public void checkValidation_NeverExceedVacationSuggestedBalance(){

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
        employees.addVacationBalance("Do Not Allow To Exceed Current Vacation Balance", "0", "14", currentYear(), currentYear()+"-01-01", currentYear()+"-12-31", true);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
//        myRequests.vacationRequest("Balance - Never Exceed Suggested Balance", "", "01/02/2024", "02/02/2024",
//                false, 0, "", "", true, true);
        myRequests.vacationRequest("Do Not Allow To Exceed Current Vacation Balance", "", "05/01/"+currentYear(), "08/01/"+currentYear(),
                false, 0, "", "", true, true); /// for new system revamp

        //Assert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("Exceeded The Remaining Balance For The Vacation"), "Alert Issue!!! - The alert NOT contain: Exceeded The Remaining Balance For This Vacation!");
        Assert.assertTrue(myRequests.checkAlertPopup("Cannot Exceed the Current Balance"), "Alert Issue!!! - The alert NOT contain: Exceeded The Remaining Balance For This Vacation!");

    }

    @Test(priority = 36, groups = "Vacations", enabled = false)
    public void checkDelegateAndConsultButtonsWhenOptionsNotCheckedInWorkflowSetup(){

        /////////////// Web Initialize //////////////
        systemInitialize();

        login = new Login();
        login.auto_mob1();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        String d_fn = firstName();
        String d_sn = secondName();
        String d_tn = thirdName();
        String d_ln = lastName();
        personnel.personalInformation(d_fn, d_sn, d_tn, d_ln, "Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        String directManager = personnel.employeeCodeGetter();
        menaMeRestPassword(directManager);

        //String directManagerName = d_fn + " " + d_ln;

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

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employee);
        financial.setBasicSalary("1000");
        menaMeRestPassword(employee);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "", "10/01/2023", "10/01/2023",
                false, 0, "", "", true, false);

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Unpaid Vacation");
        manager.scrollToElement(manager.approveBtn, true);
        softAssert.assertFalse(manager.checkElementIfVisible(manager.delegateBtn), "Delegate Button Should be Not Appear!");
        softAssert.assertFalse(manager.checkElementIfVisible(manager.consultBtn), "Consult Button Should be Not Appear!");

        softAssert.assertAll();

    }

    @Test(priority = 37, groups = "Vacations", enabled = false)
    public void checkOption_preventWithdrawTransactionAfterFirstApproval(){

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
        String directManager = personnel.employeeCodeGetter();
        menaMeRestPassword(directManager);

        mainMenu.mainMenu("Employees","Personnel Information");
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", "", directManager, "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        String employee = personnel.employeeCodeGetter();

        mainMenu.mainMenu("Employees","Financial Information");
        financial = new FinancialPackage();
        financial.setEmployeeCode(employee);
        financial.setBasicSalary("1000");
        menaMeRestPassword(employee);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Prevent Withdraw Transaction After First Approval", "", "10/01/2023", "10/01/2023",
                false, 0, "", "", true, false);

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();

        manager.openTransaction(employee, "Prevent Withdraw Transaction After First Approval", "10.01.2023");

        manager.approve();

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false);
        mainScreen = new MainScreen();
        mainScreen.myTransactions();

        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Prevent Withdraw Transaction After First Approval", "10.01.2023");
        myTransactions.withdraw(false);

        //Assert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("This Action Can Not Be Done Since At Least One Approval Action Has Been Taken On It"), "The alert NOT contain: This Action Can Not Be Done Since At Least One Approval Action Has Been Taken On It!");
        Assert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("This Action Can Not Be Done Since At Least One Approval Action Has Been Taken On It"), "The alert NOT contain: This Action Can Not Be Done Since At Least One Approval Action Has Been Taken On It!");

    }

    @Test(priority = 38, groups = "Vacations", enabled = false)
    public void requestVacationContainsDaysOffWithOption_CutDaysOff(){

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
        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Test Cut Daysoff", "", "05/09/2024", "08/09/2024",
                false, 0, "", "", true, false);

        mainScreen = new MainScreen();
        mainScreen.myTransactions();

        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Test Cut Daysoff", "05.09.2024");

        Assert.assertEquals(myTransactions.getTransactionDetails("Period"), "2 Day", "Period Issue!");

    }

    @Test(priority = 39, groups = "Vacations", enabled = false)
    public void requestVacationContainsHolidayWithOption_CutHolidays(){

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
        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Test Cut Daysoff", "", "24/12/2024", "25/12/2024",
                false, 0, "", "", true, false);

        mainScreen = new MainScreen();
        mainScreen.myTransactions();

        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Test Cut Daysoff", "24.12.2024");

        Assert.assertEquals(myTransactions.getTransactionDetails("Period"), "1 Day", "Period Issue!");

    }

    @Test(priority = 40, groups = "Vacations", enabled = false)
    public void checkOption_AbilityToRequestInAdvanceVacationSettlementAndNotifyHROfficerAboutAutomaticallyCalculatedInAdvanceVacationSettlement(){

        /////////////// Web Initialize //////////////
        systemInitialize();

        login = new Login();
        login.auto_a14_Vacation_In_Advance_KSA();

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
        menaMeRestPassword(employeeCode);

        mainMenu.mainMenu("Workforce Management","Vacations Balances");
        vacationsBalances = new VacationsBalances();
        vacationsBalances.addBalance(employeeCode, "Ability to request in advance vacation", "0.000", "35", "2024", "", "", false);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_a14", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Ability to request in advance vacation", "", "02/05/2024", "29/05/2024",
                false, 0, "", "", true, false);

        mainScreen = new MainScreen();
        mainScreen.myTransactions();

        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Ability to request in advance vacation", "02.05.2024");

        Assert.assertEquals(myTransactions.getTransactionDetails("Period"), "28.000", "Period Issue!");

    }

    @Test(priority = 41, groups = "Vacations")
    public void checkOption_PreventTakingVacationsInSpecificPeriods(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Prevent Taking Vacations In Specific Periods", "", "01/10/2024", "02/10/2024",
                false, 0, "", "", true, true);

        //Assert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("Vacations Are Not Permitted In That Period"), "The alert NOT contain: Vacations Are Not Permitted In That Period!");
        Assert.assertTrue(myRequests.checkAlertPopup("Vacations Are Not Permitted In That Period"), "The alert NOT contain: Vacations Are Not Permitted In That Period!");

    }

    @Test(priority = 42, groups = "Vacations", enabled = false)
    public void checkOption_PreventSubmitVacationOfThisTypeIfEmployeeVacation(){

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

        mainMenu.mainMenu("Workforce Management","Vacations Balances");
        vacationsBalances = new VacationsBalances();
        vacationsBalances.addBalance(employeeCode, "Annual Vacation", "0.000", "10", "2023", "", "", false);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Prevent Submit Vacation Of This Type If Employee Vacation", "", "01/10/2024", "01/10/2024",
                false, 0, "", "", true, true);

        //Assert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("Vacations Are Not Permitted In That Period"), "The alert NOT contain: Vacations Are Not Permitted In That Period!");
        Assert.assertTrue(myRequests.checkAlertPopup("Vacations Are Not Permitted In That Period"), "The alert NOT contain: Vacations Are Not Permitted In That Period!");

    }

    @Test(priority = 43, groups = "Vacations", enabled = false)
    public void checkOption_AlertEmployeesToRequestFollowingItemsWhenSubmitVacation(){

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
        loginMob.login(employeeCode, "sa", "automobile", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Alert Employees To Request Following Items When Submit Vacation", "", "01/10/2024", "01/10/2024",
                false, 0, "", "", true, true);

        //softAssert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("OR 1"), "The alert NOT contain: OR 1 (this is type of 'Miscellaneous')!");
        softAssert.assertTrue(myRequests.checkAlertPopup("OR 1"), "The alert NOT contain: OR 1 (this is type of 'Miscellaneous')!");

        myRequests.closeAlert();

        mainScreen.myTransactions();
        myTransactions = new MyTransactions();
        myTransactions.openTransactionInMyTransactions("Financial Transactions", "Vacations", "Alert Employees To Request Following Items When Submit Vacation", "01.10.2024");
        myTransactions.openRequestedItem();

        softAssert.assertTrue(myTransactions.checkInRequestedItemIfAppear("OR 1", "Pending"), "Requested Item Issue! - should be appear the item name 'OR 1' and status 'Pending'");
        softAssert.assertAll();

    }

}
