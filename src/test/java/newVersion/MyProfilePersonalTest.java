package newVersion;

import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import bases.BaseTest;
import mobileBackend.*;
import org.testng.annotations.Test;

import static utilities.WebHelper.*;

public class MyProfilePersonalTest extends BaseTest {

    String employeeCode = null;
    MobileLogin loginMob;
    MainScreen mainScreen;
    Manager manager;
    CompanyAndBranch companyAndBranch;
    Employees employees;
    MyProfilePersonal personal;

    //////////// Contact Information //////////////

    @Test(priority = 1, groups = "MyProfilePersonal")
    public void myProfile_Personal_AddContactInformationWithApproveByManagerAndRecheck(){

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

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        //String employeeName = employees.getFullNameEmployee();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openContactInformation();
        String mobile = mobile();
        String emailAddress = emailAddress();
        personal.addContactInformation(mobile, emailAddress, false);

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false, true);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Change Personal Data");
        manager.approve();

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false, true);
        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal.openContactInformation();

        softAssert.assertEquals(personal.getContactInformation("Mobile"), mobile, "- Mobile!");
        softAssert.assertEquals(personal.getContactInformation("Email"), emailAddress, "- Email!");
        softAssert.assertAll();

    }

    @Test(priority = 2, groups = "MyProfilePersonal")
    public void myProfile_Personal_CheckContactInformation(){

        /////////// API - Rest Assured ////////////
        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        String mobile = mobile();
        String email = emailAddress();

        employees = new Employees();
        employees.createNewEmployee("1980-05-20", email, "Male", "Single", "Jordanian", "",
                mobile, "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", "auto_manager",
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, true);
        employeeCode = employees.getEmployeeCode();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openContactInformation();

        softAssert.assertEquals(personal.getContactInformation("Mobile"), mobile, "- Mobile!");
        softAssert.assertEquals(personal.getContactInformation("Email"), email, "- Email!");
        softAssert.assertEquals(personal.getContactInformation("Site"), "New Zarqa", "- Site!");
        softAssert.assertEquals(personal.getContactInformation("Department"), "Quality", "- Department!");
        softAssert.assertEquals(personal.getContactInformation("Hiring Date"), "2020-01-01", "- Hiring Date!");
        softAssert.assertEquals(personal.getContactInformation("Marital Status"), "Single", "- Marital Status!");
        softAssert.assertAll();

    }

    //////////// Address //////////////

    @Test(priority = 3, groups = "MyProfilePersonal")
    public void myProfile_Personal_AddNewAddressWithApproveByManagerAndRecheck(){

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

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        //String employeeName = employees.getFullNameEmployee();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openAddress();
        String poBox = random(4);
        String floorNo = random(1);
        String bldgNo = random(2);
        String streetName = "Street " + random(3);
        String neighborhood = "NGB " + random(3);
        String zipCode = random(4);
        String state = "State " + random(4);
        personal.addAddress(poBox, floorNo, bldgNo, streetName, neighborhood, "Jordan", "Madaba", zipCode, state, false);

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false, true);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Change Personal Data");
        manager.approve();

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false, true);
        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal.openAddress();

        softAssert.assertEquals(personal.getAddress("P.O.Box"), poBox, "- P.O.Box!");
        softAssert.assertEquals(personal.getAddress("Floor No."), floorNo, "- Floor No.!");
        softAssert.assertEquals(personal.getAddress("Bldg NO."), bldgNo, "- Bldg NO.!");
        softAssert.assertEquals(personal.getAddress("Street Name"), streetName, "- Street Name!");
        softAssert.assertEquals(personal.getAddress("Neighborhood"), neighborhood, "- Neighborhood!");
        softAssert.assertEquals(personal.getAddress("Country"), "Jordan", "- Country!");
        softAssert.assertEquals(personal.getAddress("City"), "Madaba", "- City!");
        softAssert.assertEquals(personal.getAddress("Zip Code"), zipCode, "- Zip Code!");
        softAssert.assertEquals(personal.getAddress("State"), state, "- State!");
        softAssert.assertAll();

    }

    @Test(priority = 4, groups = "MyProfilePersonal")
    public void myProfile_Personal_CheckAddressDataWhenAddedFromSystem(){

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
        employeeCode = employees.getEmployeeCode();
        employees.addAddress(employeeCode, "2025-01-01", "2025-01-01", "Jordan", "Amman", "NGB100", "ST111", "BN20",
                "F3", "254", "2658");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openAddress();

        softAssert.assertEquals(personal.getAddress("P.O.Box"), "254", "- P.O.Box!");
        softAssert.assertEquals(personal.getAddress("Floor No."), "F3", "- Floor No.!");
        softAssert.assertEquals(personal.getAddress("Bldg NO."), "BN20", "- Bldg NO.!");
        softAssert.assertEquals(personal.getAddress("Street Name"), "ST111", "- Street Name!");
        softAssert.assertEquals(personal.getAddress("Neighborhood"), "NGB100", "- Neighborhood!");
        softAssert.assertEquals(personal.getAddress("Country"), "Jordan", "- Country!");
        softAssert.assertEquals(personal.getAddress("City"), "Amman", "- City!");
        softAssert.assertEquals(personal.getAddress("Zip Code"), "2658", "- Zip Code!");
        //softAssert.assertEquals(personal.getAddress("State"), "", "- State!");
        softAssert.assertAll();

    }

    //////////// Bank Information //////////////

    @Test(priority = 5, groups = "MyProfilePersonal")
    public void myProfile_Personal_AddNewBankInformationWithApproveByManagerAndRecheck(){

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

        employees.createNewEmployee("1980-05-20", "", "Male", "Single", "Jordanian", "",
                "", "New Zarqa", "Quality", "Quality Control", "", "", "",
                "", "", "", "", "2020-01-01", "2020-01-01", "",
                "", "", 0, "Jordan CP", "Jordanian Dinar", directManager,
                "", "Software Test Engineer", "", "", "", "",
                "", "", "", "", "",
                true, "Regular", "", "", 0, true, false);
        String employee = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        //String employeeName = employees.getFullNameEmployee();

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employee, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openBankInformation();
        String accountNumber = random(5);
        String IBAN = random(10);

        personal.editBankInformation("Arab Bank", "City Mall", accountNumber, IBAN, false, "Add Bank Information By Automation", false);

        mainScreen.logout();

        loginMob.login(directManager, "sa", "automobile", false, true);

        mainScreen = new MainScreen();
        mainScreen.openManager();

        manager = new Manager();
        manager.openMyTeamTransaction();
        manager.openTransaction(employee, "Change Personal Data");
        manager.approve();

        mainScreen.logout();

        loginMob.login(employee, "sa", "automobile", false, true);
        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal.openAddress();

        softAssert.assertEquals(personal.getBankInformation("Bank Name"), "Arab Bank", "- Bank Name!");
        softAssert.assertEquals(personal.getBankInformation("Bank Branch"), "City Mall", "- Bank Branch!");
        softAssert.assertEquals(personal.getBankInformation("Account Number"), accountNumber, "- Account Number!");
        softAssert.assertEquals(personal.getBankInformation("IBAN Number"), IBAN, "- IBAN Number!");
        softAssert.assertAll();

    }

    @Test(priority = 5, groups = "MyProfilePersonal")
    public void myProfile_Personal_CheckBankInformationWhenAddedFromSystem(){

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
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        String accountNumber = random(5);
        String IBAN = random(10);
        employees.addPaymentMethod(employeeCode, "Bank", "Arab Bank", "City Mall", accountNumber, IBAN);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openBankInformation();

        softAssert.assertEquals(personal.getBankInformation("Bank Name"), "Arab Bank", "- Bank Name!");
        softAssert.assertEquals(personal.getBankInformation("Bank Branch"), "City Mall", "- Bank Branch!");
        softAssert.assertEquals(personal.getBankInformation("Account Number"), accountNumber, "- Account Number!");
        softAssert.assertEquals(personal.getBankInformation("IBAN Number"), IBAN, "- IBAN Number!");
        softAssert.assertAll();

    }

    ////////// Education ////////////

    @Test(priority = 5, groups = "MyProfilePersonal")
    public void myProfile_Personal_CheckEducationWhenAddedFromSystem(){

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
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        employees.addEducation(employeeCode, "2022-01-01", "2025-01-01", false, "Jordan", "Amman", "Institute 1", "Faculties 1",
                "Major 1", "Academic Degree 1", "Excellent", "5", "2025", "Education Note Test", false);

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openEducation();

        softAssert.assertEquals(personal.getEducation(1), "Major 1", "- Major!");
        softAssert.assertAll();

    }


    ///////////// Certificates //////////////

    @Test(priority = 5, groups = "MyProfilePersonal")
    public void myProfile_Personal_CheckCertificateWhenAddedFromSystem(){

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
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");
        String certificateSerial = random(10);
        String certificateNumber = random(10);
        employees.addCertificate(employeeCode, "2025-01-01", "2025-05-01", "Certificate Type 1", "Certificate 1",
                certificateSerial, "Both", "Passed", "", "90", certificateNumber, "Certificate Note Test");
        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openCertificates();

        softAssert.assertTrue(personal.getCertificates(1).contains("01/01/2025 - 01/05/2025"), "- Validity!");
        softAssert.assertTrue(personal.getCertificates(1).contains("Certificate 1"), "- Certificate Name!");
        softAssert.assertAll();

    }

    @Test(priority = 5, groups = "MyProfilePersonal")
    public void myProfile_Personal_AddCertificate(){

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
        employeeCode = employees.getEmployeeCode();
        employees.setBasicSalary("1000");

        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Personal");
        personal = new MyProfilePersonal();
        personal.openCertificates();
        String certificateNumber = random(10);
        personal.addCertificate("01/01/2025", "01/06/2025", "PHP", "",
                "PHP", "", "90", "Passed", certificateNumber, true, "Test Note");

        softAssert.assertTrue(personal.getCertificates(1).contains("01/01/2025 - 01/05/2025"), "- Validity!");
        softAssert.assertTrue(personal.getCertificates(1).contains("Certificate 1"), "- Certificate Name!");
        softAssert.assertAll();

    }


}
