import bases.BaseTest;
import mobileBackend.MainScreen;
import mobileBackend.Manager;
import mobileBackend.MobileLogin;
import mobileBackend.MyRequests;
import org.testng.Assert;
import org.testng.annotations.Test;
import webBackend.financialInformation.FinancialPackage;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import webBackend.general.Substitutes;
import webBackend.personnelInformation.PersonnelInformation;

import static utilities.MobileHelper.currentDate_mobile;
import static utilities.MssqlConnect.menaMeRestPassword;
import static utilities.MssqlConnect.sqlQuery;
import static utilities.WebHelper.*;

public class VacationTest extends BaseTest {

    PersonnelInformation personnel;
    FinancialPackage financial;
    Login login;
    MenaModules menaModules;
    Substitutes substitutes;
    MainMenu mainMenu;
    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;
    MyRequests myRequests;
    Manager manager;

    @Test(priority = 1, groups = "Vacations")
    public void requestUnpaidVacationWithAttachmentAndReason(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "10/01/2023", "10/01/2023",
                true, 1, "Test Appium Reason", "", true, false);

        mainScreen.myTransactions("Vacations");
        mainScreen.openTransactionInMyTransactions("Vacations", "Unpaid Vacation", "10.01.2023");

        softAssert.assertEquals(mainScreen.getTransactionReason(), "Test Appium Reason", "- Reason Issue!");
        softAssert.assertTrue(mainScreen.attachmentInVacationDetails.isDisplayed(), "Attachment Icon NOT appear!");
        softAssert.assertTrue(mainScreen.checkAttachmentInVacationDetails(), "Attachment NOT Opened!");
        softAssert.assertAll();

    }

    @Test(priority = 2, groups = "Vacations")
    public void requestUnpaidVacationAndWithdraw(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "11/01/2023", "11/01/2023",
                false, 1, "", "", true, false);

        mainScreen.myTransactions("Vacations");
        mainScreen.openTransactionInMyTransactions("Vacations", "Unpaid Vacation",
                "11.01.2023", true);

        Assert.assertTrue(mainScreen.checkTransactionIfDropped(), "The Transaction NOT Dropped!");

    }

    @Test(priority = 3, groups = "Vacations")
    public void checkValidationForEmployeeWithoutVacationBalance(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Balance - Never Exceed Annual Balance", "05/05/2023", "05/05/2023",
                false, 1, "", "", true, true);

        Assert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("Exceeded The End Of Year Remaining Balance"), "The alert NOT contain: Exceeded The Remaining Balance!");

    }

    @Test(priority = 4, groups = "Vacations")
    public void checkRequestTwoVacationInTheSameDate(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "05/05/2023", "05/05/2023",
                false, 1, "", "", true, false);

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "05/05/2023", "05/05/2023",
                false, 1, "", "", true, true);

        softAssert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("You Can Not Add This Vacation"), "The alert NOT contain: You Can Not Add This Vacation!");
        softAssert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("in Same Day"), "The alert NOT contain: in Same Day");
        softAssert.assertAll();

    }

    @Test(priority = 5, groups = "Vacations")
    public void checkReasonIsMandatory(){

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Reason Is Mandatory", "05/05/2023", "05/05/2023",
                false, 1, "", "", true, true);

        Assert.assertTrue(myRequests.pleaseFillTheReason_Alert.isDisplayed(), "Alert Issue - shoud lbe appear: Please Fill The Reason!");

    }

    @Test(priority = 6, groups = "Vacations")
    public void checkPhoneNumberIsMandatory(){

        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login("auto_mobile1", "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Phone Number Is Mandatory", "05/05/2023", "05/05/2023",
                false, 1, "", "", true, true);

        Assert.assertTrue(myRequests.pleaseInsertPhoneNumber_Alert.isDisplayed(), "Alert Issue - shoud lbe appear: Please Insert Phone Number!");

    }

    @Test(priority = 7, groups = "Vacations")
    public void checkTheDocumentIsMandatoryContinuousDays_UploadExceedTheAllowedNumberOfAttachments(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest_checkAlertAfterUploadAttachment("Document Is Mandatory After 2 Days - Allowed Number = 2", "10/10/2023", "11/10/2023",
                true, 3, 3);

        Assert.assertTrue(myRequests.theMaximumNumberOfAttachmentIs2_Alert.isDisplayed(), "Alert Issue: Shoud be alert appear--> The maximum number of attachment is : 2");

    }

    @Test(priority = 8, groups = "Vacations")
    public void checkTheDocumentIsMandatoryContinuousDays_ForTwoDaysValidation_withoutUploadAttachment(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory After 2 Days - Allowed Number = 2", "10/10/2023", "11/10/2023",
                false, 0, "", "", true, true);

        Assert.assertTrue(myRequests.maximumAllowedAttachmentsIs2AndMinimumAllowedAttachmentsIs1.isDisplayed(), "Alert Issue: Shoud be alert appear--> Maximum Allowed Attachments Is 2 And Minimum Allowed Attachments Is 1");

    }

    @Test(priority = 8, groups = "Vacations")
    public void checkTheDocumentIsMandatoryContinuousDays_SuccessValidation_Upload2Attachment(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory After 2 Days - Allowed Number = 2", "10/10/2023", "11/10/2023",
                true, 2, "", "", true, true);

        Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");

    }

    @Test(priority = 8, groups = "Vacations")
    public void checkTheDocumentIsMandatoryContinuousDays_RequestOneDayOfVacation(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory After 2 Days - Allowed Number = 2", "10/10/2023", "10/10/2023",
                false, 0, "", "", true, true);

        Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");

    }

    @Test(priority = 9, groups = "Vacations")
    public void checkTheDocumentIsMandatory_AccumulativeDays_UploadExceedTheAllowedNumberOfAttachments(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();

        myRequests.vacationRequest("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "10/10/2023", "10/10/2023",
                false, 0, "", "", true, false);

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest_checkAlertAfterUploadAttachment("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "11/10/2023", "11/10/2023",
                true, 3, 3);

        Assert.assertTrue(myRequests.theMaximumNumberOfAttachmentIs2_Alert.isDisplayed(), "Alert Issue: Shoud be alert appear--> The maximum number of attachment is : 2");

    }

    @Test(priority = 10, groups = "Vacations")
    public void checkTheDocumentIsMandatory_AccumulativeDays_ForTwoDaysValidation_withoutUploadAttachment(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();

        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "05/05/2023", "05/05/2023",
                false, 0, "", "", true, false);

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "06/05/2023", "06/05/2023",
                false, 0, "", "", true, true);

        softAssert.assertTrue(mainScreen.attentionAlertPopup.isDisplayed(), "Attention Please Alert NOT Appear!");
        softAssert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("Minimum Number Of Allowed Attachments Is(1)"), "Alert Issue: Shoud be alert appear--> Minimum Number Of Allowed Attachments Is(1)]");
        softAssert.assertAll();

    }

    @Test(priority = 11, groups = "Vacations")
    public void checkTheDocumentIsMandatory_AccumulativeDays_SuccessValidation_Upload2Attachment(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "05/05/2023", "05/05/2023",
                false, 0, "", "", true, false);

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Document Is Mandatory - Accumulative - After 2 Days - Allowed Number = 2", "06/05/2023", "06/05/2023",
                true, 2, "", "", true, true);

        Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");

    }

    @Test(priority = 12, groups = "Vacations")
    public void checkAlertWhenRequestVacationsInPreviousDateAndFutureDate_WhenOptionsChecked(){

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
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Can Not Be Requested In Future Date", "05/05/2030", "05/05/2030",
                false, 0, "", "", true, true);

        softAssert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("You Can Not Request This Vacation In A Future Date"), "Alert Issue: Shoud be alert appear--> You Can Not Request This Vacation In A Future Date");

        myRequests.closeAlert();

        mainScreen.myRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Can Not Be Requested In Previous Date", "06/05/2023", "06/05/2023",
                false, 0, "", "", true, true);

        softAssert.assertTrue(mainScreen.attentionAlertPopup.getAttribute("content-desc").contains("before the current date"), "Alert Issue: Shoud be alert appear--> Transaction Date can`t be before the current date");
        softAssert.assertAll();

    }

    @Test(priority = 13, groups = "Vacations")
    public void checkRequestAlertWhenDelegateIsMandatory(){

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
                "", "", "", "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = personnel.employeeCodeGetter();
        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        sqlQuery("update pay_setup set auto_delegate_before_vacation = 2 where branch_code = 'auto_mob1'");

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("To Test Delegate", "", "",
                false, 0, "", "", true, true);

        sqlQuery("update pay_setup set auto_delegate_before_vacation = 0 where branch_code = 'auto_mob1'");

        Assert.assertTrue(myRequests.autoDelegationIsMandatoryBeforeVacationRequest_Alert.isDisplayed(), "Alert Issue : it should be appear this alert: Auto Delegation Is Mandatory Before Vacation Request!");

    }

    @Test(priority = 14, groups = "Vacations")
    public void checkRequestVacationWhenSelectDelegateIsNotRequired(){

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
                "", "", "", "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = personnel.employeeCodeGetter();
        menaMeRestPassword(employeeCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        sqlQuery("update pay_setup set auto_delegate_before_vacation = 2 where branch_code = 'auto_mob1'");

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("To Test Delegate", "", "",
                false, 0, "", "Not Required", true, true);

        sqlQuery("update pay_setup set auto_delegate_before_vacation = 0 where branch_code = 'auto_mob1'");

        Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");

    }

    @Test(priority = 15, groups = "Vacations")
    public void checkRequestVacationWhenSelectDelegateIs_AllEmployees(){

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
                "", "", "", "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        String emp1 = personnel.employeeCodeGetter();
        menaMeRestPassword(emp1);

        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        String emp2 = personnel.employeeCodeGetter();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        sqlQuery("update pay_setup set auto_delegate_before_vacation = 2 where branch_code = 'auto_mob1'");

        loginMob = new MobileLogin();
        loginMob.login(emp1, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("To Test Delegate", "", "",
                false, 0, "", emp2, true, true);

        sqlQuery("update pay_setup set auto_delegate_before_vacation = 0 where branch_code = 'auto_mob1'");

        Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");

    }

    @Test(priority = 15, groups = "Vacations")
    public void checkRequestVacationWhenSelectDelegateIs_EmployeeSubstitutes(){

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
                "", "", "", "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        String employeeCode = personnel.employeeCodeGetter();
        menaMeRestPassword(employeeCode);

        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        String substituteCode = personnel.employeeCodeGetter();

        mainMenu.mainMenu("Employees","Substitutes");
        substitutes = new Substitutes();
        substitutes.substitutes(employeeCode, substituteCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        sqlQuery("update pay_setup set auto_delegate_before_vacation = 1 where branch_code = 'auto_mob1'");

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("To Test Delegate", "", "",
                false, 0, "", substituteCode, true, true);

        sqlQuery("update pay_setup set auto_delegate_before_vacation = 0 where branch_code = 'auto_mob1'");

        Assert.assertTrue(mainScreen.successAlertPopup.getAttribute("content-desc").contains("Your Vacation Request Has Been Submitted Successfully"), "Alert Issue: Shoud be alert appear--> Your Vacation Request Has Been Submitted Successfully");

    }

    @Test(priority = 15, groups = "Vacations")
    public void checkDelegatePopupAndCheckTheResultWhenType_EmployeeSubstitutes(){

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
                "", "", "", "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        String employeeCode = personnel.employeeCodeGetter();
        menaMeRestPassword(employeeCode);

        mainMenu.mainMenu("Employees","Personnel Information");
        personnel = new PersonnelInformation();
        personnel.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/01/1980");
        personnel.employmentInformation("New Zarqa", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        String substituteCode = personnel.employeeCodeGetter();

        mainMenu.mainMenu("Employees","Substitutes");
        substitutes = new Substitutes();
        substitutes.substitutes(employeeCode, substituteCode);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        sqlQuery("update pay_setup set auto_delegate_before_vacation = 1 where branch_code = 'auto_mob1'");

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.openDelegatePopup();

        sqlQuery("update pay_setup set auto_delegate_before_vacation = 0 where branch_code = 'auto_mob1'");

        softAssert.assertTrue(myRequests.resultFound.getAttribute("content-desc").contains("1 results found"), "The Result found shoud be = 1");
        softAssert.assertEquals(myRequests.listOfEmployees.size(), 1, "The list shoud be contain 1 employee");
        softAssert.assertTrue(myRequests.listOfEmployees.get(0).getAttribute("content-desc").contains(substituteCode), "the employee code in the list shoud be: "+substituteCode);
        softAssert.assertAll();

    }

    @Test(priority = 16, groups = "Vacations")
    public void requestUnpaidVacationWithAttachmentAndReason_And_Approve_ByDirectManager(){

        /////////////// Web Initialize //////////////
        webInitialize();

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

        String directManagerName = d_fn + " " + d_ln;

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
        loginMob.login(employee, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "10/01/2023", "10/01/2023",
                true, 1, "Test Appium Reason", "", true, false);

        mainScreen.myTransactions("Vacations");
        mainScreen.openTransactionInMyTransactions("Vacations", "Unpaid Vacation", "10.01.2023");

        softAssert.assertEquals(myRequests.getApprovalCommittee(directManagerName), "Pending", "Approval Committee status issue - should be is: Pending");

        mainScreen.logout();

        loginMob.login(directManager, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();

        softAssert.assertTrue(manager.transaction(employee).contains("COD: "+employee), "Issue COD!");
        softAssert.assertTrue(manager.transaction(employee).contains(fn+" "+sn+" "+tn+" "+ln), "Employee Name Issue! Should be: "+fn+" "+sn+" "+tn+" "+ln);
        softAssert.assertTrue(manager.transaction(employee).contains("Unpaid Vacation"), "Transaction Type! should be : Unpaid Vacation");
        softAssert.assertTrue(manager.transaction(employee).contains("10.01.2023"), "Transaction Date! should be : 10.01.2023");
        softAssert.assertTrue(manager.transaction(employee).contains("1.000"), "Transaction Period! should be : 1.000");

        manager.openTransaction(employee, "Unpaid Vacation");

        softAssert.assertEquals(manager.transactionDetails("Site"), "New Zarqa", "Site!");
        softAssert.assertEquals(manager.transactionDetails("Employee Code"), employee, "Employee Code!");
        softAssert.assertEquals(manager.transactionDetails("Direct Manager"), d_fn+" "+d_sn+" "+d_tn+" "+d_ln, "Direct Manager Name!");
        softAssert.assertEquals(manager.transactionDetails("Transaction Type"), "Vacation Request", "Transaction Type!");
        softAssert.assertEquals(manager.transactionDetails("Request Date"), currentDate_mobile(), "Request Date!");
        softAssert.assertEquals(manager.transactionDetails("From"), "Tuesday, 10.01.2023", "From!");
        softAssert.assertEquals(manager.transactionDetails("To"), "Tuesday, 10.01.2023", "To!");
        softAssert.assertEquals(manager.transactionDetails("Resume Date"), "Wednesday, 11.01.2023", "Resume Date!");
        softAssert.assertEquals(manager.transactionDetails("Branch Code"), "auto_mob1", "Branch Code!");
        softAssert.assertEquals(manager.transactionDetails("Period"), "1.000", "Period!");
        //softAssert.assertEquals(mainScreen.getTransactionReason(), "Test Appium Reason", "- Reason Issue!");
        softAssert.assertTrue(manager.checkAttachmentIcon(), "Attachment Icon NOT appear!");
        softAssert.assertTrue(manager.checkAttachmentInVacationDetails(), "Attachment NOT Opened!");

        manager.approve("Appium Comment - Approve");

        mainScreen.logout();

        loginMob.login(employee, "1", "auto_mob1", false);
        mainScreen = new MainScreen();
        mainScreen.myTransactions("Vacations");
        mainScreen.openTransactionInMyTransactions("Vacations", "Unpaid Vacation", "10.01.2023");

        softAssert.assertEquals(myRequests.getApprovalCommittee(directManagerName), "Approved", "Approval Committee status issue - should be is: Approved");
        softAssert.assertEquals(myRequests.getApprovalComments(directManagerName), "Appium Comment - Approve", "Approval Comment issue - should be is: Appium Comment - Approve");
        softAssert.assertEquals(myRequests.getApprovalDate(directManagerName), currentDate_mobile(), "Approval Date issue - should be is: "+currentDate_mobile());

        softAssert.assertAll();

    }

    @Test(priority = 16, groups = "Vacations")
    public void requestUnpaidVacationWithAttachmentAndReason_And_Reject_ByDirectManager(){

        /////////////// Web Initialize //////////////
        webInitialize();

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

        String directManagerName = d_fn + " " + d_ln;

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
        loginMob.login(employee, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.myRequests();

        myRequests = new MyRequests();
        myRequests.openVacations();
        myRequests.vacationRequest("Unpaid Vacation", "10/01/2023", "10/01/2023",
                true, 1, "Test Appium Reason", "", true, false);

        mainScreen.myTransactions("Vacations");
        mainScreen.openTransactionInMyTransactions("Vacations", "Unpaid Vacation", "10.01.2023");

        softAssert.assertEquals(myRequests.getApprovalCommittee(directManagerName), "Pending", "Approval Committee status issue - should be is: Pending");

        mainScreen.logout();

        loginMob.login(directManager, "1", "auto_mob1", false);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();

        softAssert.assertTrue(manager.transaction(employee).contains("COD: "+employee), "Issue COD!");
        softAssert.assertTrue(manager.transaction(employee).contains(fn+" "+sn+" "+tn+" "+ln), "Employee Name Issue! Should be: "+fn+" "+sn+" "+tn+" "+ln);
        softAssert.assertTrue(manager.transaction(employee).contains("Unpaid Vacation"), "Transaction Type! should be : Unpaid Vacation");
        softAssert.assertTrue(manager.transaction(employee).contains("10.01.2023"), "Transaction Date! should be : 10.01.2023");
        softAssert.assertTrue(manager.transaction(employee).contains("1.000"), "Transaction Period! should be : 1.000");

        manager.openTransaction(employee, "Unpaid Vacation");

        softAssert.assertEquals(manager.transactionDetails("Site"), "New Zarqa", "Site!");
        softAssert.assertEquals(manager.transactionDetails("Employee Code"), employee, "Employee Code!");
        softAssert.assertEquals(manager.transactionDetails("Direct Manager"), d_fn+" "+d_sn+" "+d_tn+" "+d_ln, "Direct Manager Name!");
        softAssert.assertEquals(manager.transactionDetails("Transaction Type"), "Vacation Request", "Transaction Type!");
        softAssert.assertEquals(manager.transactionDetails("Request Date"), currentDate_mobile(), "Request Date!");
        softAssert.assertEquals(manager.transactionDetails("From"), "Tuesday, 10.01.2023", "From!");
        softAssert.assertEquals(manager.transactionDetails("To"), "Tuesday, 10.01.2023", "To!");
        softAssert.assertEquals(manager.transactionDetails("Resume Date"), "Wednesday, 11.01.2023", "Resume Date!");
        softAssert.assertEquals(manager.transactionDetails("Branch Code"), "auto_mob1", "Branch Code!");
        softAssert.assertEquals(manager.transactionDetails("Period"), "1.000", "Period!");
        //softAssert.assertEquals(mainScreen.getTransactionReason(), "Test Appium Reason", "- Reason Issue!");
        softAssert.assertTrue(manager.checkAttachmentIcon(), "Attachment Icon NOT appear!");
        softAssert.assertTrue(manager.checkAttachmentInVacationDetails(), "Attachment NOT Opened!");

        manager.reject("Appium Comment - Reject");

        mainScreen.logout();

        loginMob.login(employee, "1", "auto_mob1", false);
        mainScreen = new MainScreen();
        mainScreen.myTransactions("Vacations");
        mainScreen.openTransactionInMyTransactions("Vacations", "Unpaid Vacation", "10.01.2023");

        softAssert.assertEquals(myRequests.getApprovalCommittee(directManagerName), "Rejected", "Approval Committee status issue - should be is: Rejected");
        softAssert.assertEquals(myRequests.getApprovalComments(directManagerName), "Appium Comment - Reject", "Approval Comment issue - should be is: Appium Comment - Reject");
        softAssert.assertEquals(myRequests.getApprovalDate(directManagerName), currentDate_mobile(), "Approval Date issue - should be is: "+currentDate_mobile());

        softAssert.assertAll();

    }

}
