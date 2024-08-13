package webBackend.mename;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class MenaMeMenu extends WebBase {

    @FindBy(xpath = "//a[contains(@href, 'index2.php') and contains(@class, 'side-nav-img')]")
    WebElement homePage;
    @FindBy(xpath = "//a[contains(@href, 'vacation_requests_all.php')]")
    WebElement requestsManagement;
    @FindBy(xpath = "//a[contains(@href, 'attendance_history_all.php')]")
    WebElement timeManagement;
    @FindBy(xpath = "//a[contains(@href, 'MyPerformanceIFrame.php')]")
    WebElement myPerformance;
    @FindBy(xpath = "//a[contains(@href, 'transactions_inquiry_all.php')]")
    WebElement transactionsInquiry;
    @FindBy(xpath = "//a[contains(@href, 'transactions_approvals.php')]")
    WebElement requestsAndApprovals;
    @FindBy(xpath = "//a[contains(@href, 'ar3.php')]")
    WebElement financialSheets;
    @FindBy(id = "profile-buttom-dropdown")
    WebElement profileDropdown;
    @FindBy(className = "icon-manager-menu")
    WebElement managerBtn;
    @FindBy(className = "icon-logout")
    WebElement logoutBtn;

    public void menaMeMenu(String tabName){

        elementWaitAdvanced(By.className("side-nav-icons"));

        if(tabName.equalsIgnoreCase("Home Page") || tabName.equalsIgnoreCase("Home")){
            clickOn(homePage);
        } else if (tabName.equalsIgnoreCase("Requests Management") || tabName.equalsIgnoreCase("Requests")) {
            clickOn(requestsManagement);
        } else if (tabName.equalsIgnoreCase("Time Management") || tabName.equalsIgnoreCase("Time")) {
            clickOn(timeManagement);
        } else if (tabName.equalsIgnoreCase("My Performance") || tabName.equalsIgnoreCase("Performance")) {
            clickOn(myPerformance);
        } else if (tabName.equalsIgnoreCase("Transactions Inquiry") || tabName.equalsIgnoreCase("Inquiry")) {
            clickOn(transactionsInquiry);
        } else if (tabName.equalsIgnoreCase("Financial Sheets") || tabName.equalsIgnoreCase("Financial")) {
            clickOn(financialSheets);
        }else if(tabName.equalsIgnoreCase("Requests And Approvals")){
            clickOn(requestsAndApprovals);
        }

        setLog("MenaME Menu: "+tabName);

    }

    public void openManager(){

        clickOn(profileDropdown);
        hold(400);
        clickOn(managerBtn);
        hold(500);
        elementWaitAdvanced(By.className("icon-approval"));

        setLog("Open Manager");

    }

    public void logout(){

        clickOn(profileDropdown);
        hold(400);
        clickOn(logoutBtn);
        hold(500);
        elementWaitAdvanced(By.id("employee_code"));

        setLog("Logout from MenaME");

    }

}
