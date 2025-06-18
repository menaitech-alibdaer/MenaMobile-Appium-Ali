package newVersion;

import apiBackend.CompanyAndBranch;
import apiBackend.Employees;
import bases.BaseTest;
import mobileBackend.*;
import org.testng.annotations.Test;

import static utilities.WebHelper.currentYear;

public class VacationBalanceTest extends BaseTest {

    String employeeCode = null;

    MobileLogin loginMob;
    MainScreen mainScreen;
    MyProfileOther myProfileOther;
    CompanyAndBranch companyAndBranch;
    Employees employees;


    @Test(priority = 1, groups = "Vacations")
    public void checkVacationBalanceWithAnnualAndSickVacation_CheckAllFields(){

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
        employees.addVacationBalance("Annual Vacation", "2.5", "14", currentYear(), currentYear()+"-01-01", currentYear()+"-12-31", true);
        employees.addVacationBalance("Sick Vacation", "0", "14", currentYear(), currentYear()+"-01-01", currentYear()+"-12-31", false);

        String annual_Year = employees.getFromVacationBalance(employeeCode, "Annual Vacation", Integer.parseInt(currentYear()), "Year");
        String annual_CurrentBalance = employees.getFromVacationBalance(employeeCode, "Annual Vacation", Integer.parseInt(currentYear()), "Current Balance");
        String annual_PreviousBalance = employees.getFromVacationBalance(employeeCode, "Annual Vacation", Integer.parseInt(currentYear()), "Previous Balance");
        String annual_NewBalance = employees.getFromVacationBalance(employeeCode, "Annual Vacation", Integer.parseInt(currentYear()), "New Balance");
        String annual_DaysTaken = employees.getFromVacationBalance(employeeCode, "Annual Vacation", Integer.parseInt(currentYear()), "Days Taken");
        String annual_UpToEndOfYearBalance = employees.getFromVacationBalance(employeeCode, "Annual Vacation", Integer.parseInt(currentYear()), "Up To End Of Year Balance");
        String annual_RemainingPrevious = employees.getFromVacationBalance(employeeCode, "Annual Vacation", Integer.parseInt(currentYear()), "Remaining Previous");

        String sick_Year = employees.getFromVacationBalance(employeeCode, "Sick Vacation", Integer.parseInt(currentYear()), "Year");
        String sick_CurrentBalance = employees.getFromVacationBalance(employeeCode, "Sick Vacation", Integer.parseInt(currentYear()), "Current Balance");
        String sick_PreviousBalance = employees.getFromVacationBalance(employeeCode, "Sick Vacation", Integer.parseInt(currentYear()), "Previous Balance");
        String sick_NewBalance = employees.getFromVacationBalance(employeeCode, "Sick Vacation", Integer.parseInt(currentYear()), "New Balance");
        String sick_DaysTaken = employees.getFromVacationBalance(employeeCode, "Sick Vacation", Integer.parseInt(currentYear()), "Days Taken");
        String sick_UpToEndOfYearBalance = employees.getFromVacationBalance(employeeCode, "Sick Vacation", Integer.parseInt(currentYear()), "Up To End Of Year Balance");
        String sick_RemainingPrevious = employees.getFromVacationBalance(employeeCode, "Sick Vacation", Integer.parseInt(currentYear()), "Remaining Previous");


        /////////////// Mobile Initialize //////////////
        mobileInitialize();

        loginMob = new MobileLogin();
        loginMob.login(employeeCode, "sa", "automobile", false, false);

        mainScreen = new MainScreen();
        mainScreen.myProfile("Other");
        myProfileOther = new MyProfileOther();
        myProfileOther.openVacationBalance();
        myProfileOther.viewVacationBalance("");

        softAssert.assertEquals(myProfileOther.getVacationBalance("Annual Vacation", "Year"), annual_Year, "- Annual Vacation - Year!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Annual Vacation", "Up-to-date-Balance"), annual_CurrentBalance, "- Annual Vacation - Up-to-date-Balance!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Annual Vacation", "Previous Balance"), annual_PreviousBalance, "- Annual Vacation - Previous Balance!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Annual Vacation", "New Balance"), annual_NewBalance, "- Annual Vacation - New Balance!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Annual Vacation", "Days Taken"), annual_DaysTaken, "- Annual Vacation - Days Taken!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Annual Vacation", "Up To End Of Year Balance"), annual_UpToEndOfYearBalance, "- Annual Vacation - Up To End Of Year Balance!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Annual Vacation", "Remaining Previous"), annual_RemainingPrevious, "- Annual Vacation - Remaining Previous!");

        softAssert.assertEquals(myProfileOther.getVacationBalance("Sick Vacation", "Year"), sick_Year, "- Sick Vacation - Year!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Sick Vacation", "Up-to-date-Balance"), sick_CurrentBalance, "- Sick Vacation - Up-to-date-Balance!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Sick Vacation", "Previous Balance"), sick_PreviousBalance, "- Sick Vacation - Previous Balance!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Sick Vacation", "New Balance"), sick_NewBalance, "- Sick Vacation - New Balance!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Sick Vacation", "Days Taken"), sick_DaysTaken, "- Sick Vacation - Days Taken!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Sick Vacation", "Up To End Of Year Balance"), sick_UpToEndOfYearBalance, "- Sick Vacation - Up To End Of Year Balance!");
        softAssert.assertEquals(myProfileOther.getVacationBalance("Sick Vacation", "Remaining Previous"), sick_RemainingPrevious, "- Sick Vacation - Remaining Previous!");

        softAssert.assertAll();

    }

}
