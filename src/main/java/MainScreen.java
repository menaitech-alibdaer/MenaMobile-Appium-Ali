import bases.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainScreen extends BasePage {


    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    WebElement locationPermission;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[2]")
    WebElement TA_Options;
    @AndroidFindBy(accessibility = "Sign In")
    WebElement TA_signInBtn;
    @AndroidFindBy(accessibility = "MainButtonSemantics")
    WebElement requestMenuBtn;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds = '[74,275][206,407]']")
    WebElement backBtn;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds = '[874,275][1006,407]']")
    WebElement homeBtn;
    @AndroidFindBy(accessibility = "MenuIcon")
    WebElement sideBarMenu;
    @AndroidFindBy(accessibility = "Settings")
    WebElement settingsBtn;
    @AndroidFindBy(accessibility = "Change Password")
    WebElement changePasswordBtn;
    @AndroidFindBy(accessibility = "Vacations")
    WebElement vacationsRequestBtn;
    @AndroidFindBy(accessibility = "Choose")
    WebElement vacationsTypeBtn;
    @AndroidFindBy(accessibility = "Annual Vacation")
    WebElement annualVacationType;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='From Date']/following::android.widget.ImageView)[1]")
    WebElement fromDateF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='To Date']/following::android.widget.ImageView)[1]")
    WebElement toDateF;
    @AndroidFindBy(accessibility = "OK")
    WebElement calendar_OkBtn;
    @AndroidFindBy(accessibility = "1")
    WebElement calendar_1;
    @AndroidFindBy(accessibility = "Submit")
    WebElement submitBtn;
    @AndroidFindBy(accessibility = "Got it!")
    WebElement gotItBtn;
    @AndroidFindBy(accessibility = "TransactionIcon")
    WebElement transactionBtn;
    @AndroidFindBy(accessibility = "ProfileIcon")
    WebElement profileBtn;
    @AndroidFindBy(accessibility = "Financial")
    WebElement financialBtn;
    @AndroidFindBy(accessibility = "Salary Slip")
    WebElement salarySlipBtn;
    @AndroidFindBy(accessibility = "This Month")
    WebElement thisMonthBtn;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Employee Contribution')]")
    WebElement employeeContributionF;
    @AndroidFindBy(accessibility = "Recent Slip")
    WebElement recentSlipE;
    @AndroidFindBy(accessibility = "Non Payroll")
    WebElement NonPayrollBtn;
    @AndroidFindBy(accessibility = "Later")
    WebElement laterBtn;
    @AndroidFindBy(accessibility = "Update")
    WebElement updateBtn;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[contains(@content-desc, 'Current')])[2]")
    WebElement toTestScroll111111;



    public void locationPermission(boolean perm){
        waitForElementToBeVisible(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
        if(perm){
            clickOn(locationPermission);
            hold(1000);
        }
    }

//    public boolean checkIfUpdateAvailable(){
//        boolean check = false;
//        try {
//            new WebDriverWait(appiumDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Update")));
//            check = true;
//
//        }catch (Exception ignored){
//
//        }
//        return check;
//    }

    public void myRequests(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("MainButtonSemantics"));
        clickOn(requestMenuBtn);
        hold(200);
    }

//    public void cycle(){
//
//        //ignoreUpdatePopup();
//
//        clickOn(TA_Options);
//        hold(500);
//        clickOn(TA_signInBtn);
//        hold(300);
//        clickOn(TA_signInBtn);
//        waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Sign In')]/android.widget.ImageView[3]"));
//        horizontalScrollStartedFromElement(toTestScroll111111, true);
//        clickOn(requestMenuBtn);
//        hold(300);
//        clickOn(vacationsRequestBtn);
//        hold(1000);
//        clickOn(vacationsTypeBtn);
//        hold(100);
//        clickOn(annualVacationType);
//        waitForElementToBeVisible(AppiumBy.accessibilityId("Resume Date "));
//        clickOn(fromDateF);
//        hold(300);
//        clickOn(calendar_1);
//        clickOn(calendar_OkBtn);
//        hold(2000);
//        clickOn(toDateF);
//        hold(300);
//        clickOn(calendar_1);
//        clickOn(calendar_OkBtn);
//        hold(1000);
//        //verticalScrollStartedFromElement(vacationsTypeBtn, true);
//        scrollToElement(submitBtn, true);
//        ////////////verticalSwipeByPercentages(80, 10, 50);
//        hold(1000);
//        clickOn(submitBtn);
//        waitForElementToBeVisible(AppiumBy.accessibilityId("Got it!"));
//        clickOn(gotItBtn);
//        hold(500);
//        clickOn(backBtn);
//        hold(200);
//        clickOn(backBtn);
//        hold(500);
//        clickOn(transactionBtn);
//        hold(1000);
//        clickOn(thisMonthBtn);
//        hold(2000);
//        scrollToElement(NonPayrollBtn, true);
//        hold(2000);
//        clickOn(homeBtn);
//        hold(500);
//        clickOn(profileBtn);
//        hold(500);
//        clickOn(financialBtn);
//        hold(500);
//        clickOn(salarySlipBtn);
//        waitForElementToBeVisible(AppiumBy.accessibilityId("Recent Slip"));
//        scrollToElement(employeeContributionF, true);
//        hold(300);
//        scrollToElement(recentSlipE, false);
//        hold(3000);
//        clickOn(homeBtn);
//        hold(300);
//        clickOn(sideBarMenu);
//        hold(600);
//        clickOn(settingsBtn);
//        hold(1000);
//        clickOn(sideBarMenu);
//        hold(600);
//        clickOn(changePasswordBtn);
//
//    }

//    public void ignoreUpdatePopup(){
//        if(checkIfUpdateAvailable()){
//            clickOn(laterBtn);
//            hold(500);
//        }
//    }

}
