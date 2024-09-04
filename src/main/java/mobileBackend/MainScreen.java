package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainScreen extends MobileBasePage {


    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    WebElement locationPermission;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[2]")
    WebElement TA_Options;
    @AndroidFindBy(accessibility = "Sign In")
    WebElement TA_signInBtn;
    @AndroidFindBy(accessibility = "MainButtonSemantics")
    public WebElement requestMenuBtn;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds = '[74,275][206,407]']")
    WebElement backBtn;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds = '[874,275][1006,407]']")
    WebElement homeBtn;
    @AndroidFindBy(accessibility = "MenuIcon")
    WebElement sideBarMenu;
    @AndroidFindBy(accessibility = "Log Out")
    WebElement logOutBtn;
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
    WebElement myTransactionBtn;
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
    @AndroidFindBy(accessibility = "Workflow Details")
    WebElement workflowDetailsText;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Attachments']/following::android.widget.ImageView)[1]")
    public WebElement attachmentInVacationDetails;
    @AndroidFindBy(accessibility = "Withdraw")
    WebElement withdrawBtn;
    @AndroidFindBy(accessibility = "Alright!")
    WebElement alrightBtn;
    @AndroidFindBy(accessibility = "Approval Committee")
    WebElement approvalCommitteeText;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[contains(@content-desc, 'Current')])[2]")
    WebElement toTestScroll111111;

    public MainScreen(){
        ignoreUpdatePopup();
    }

    public void locationPermission(boolean perm){
        waitForElementToBeVisible(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
        if(perm){
            clickOn(locationPermission);
            hold(1000);
        }
    }

    public void myRequests(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("MainButtonSemantics"));
        clickOn(requestMenuBtn);
        hold(200);
    }

    public void logout(){
        clickOn(sideBarMenu);
        hold(100);
        clickOn(logOutBtn);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("Login"));
    }

    public void myTransactions(String type){
        clickOn(myTransactionBtn);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Vacations"));
    }

    public void openTransactionInMyTransactions(String transactionType, String transactionName, String transactionDate){

        clickOn(appiumDriver.findElement(AppiumBy.accessibilityId(transactionType)));
        hold(3000);
        verticalSwipeByPercentages(70, 10, 50);

        if(!transactionDate.isEmpty()){
            scrollToElement(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]")), true);
            clickOn(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]")));
        }else{
            scrollToElement(appiumDriver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]")), true);
            clickOn(appiumDriver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]")));
        }

        waitForElementToBeVisible(AppiumBy.accessibilityId("Requested on"));

    }

    public void openTransactionInMyTransactions(String transactionType, String transactionName, String transactionDate, boolean withdraw){

        clickOn(appiumDriver.findElement(AppiumBy.accessibilityId(transactionType)));
        hold(3000);
        verticalSwipeByPercentages(70, 10, 50);

        if(!transactionDate.isEmpty()){
            scrollToElement(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]")), true);
            clickOn(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]")));
        }else{
            scrollToElement(appiumDriver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]")), true);
            clickOn(appiumDriver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]")));
        }

        waitForElementToBeVisible(AppiumBy.accessibilityId("Requested on"));

        if(withdraw){
            scrollToElement(withdrawBtn, true);
            clickOn(withdrawBtn);
            waitLoadingElement();
            waitForElementToBeVisible(AppiumBy.accessibilityId("Alright!"));
            clickOn(alrightBtn);
            waitForElementToBeVisible(AppiumBy.accessibilityId("Requested on"));
        }

    }

    public boolean checkTransactionIfDropped(){
        try{
            scrollToElement(workflowDetailsText, true);
            return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Approval Committee')]/following::android.view.View[contains(@content-desc, 'Dropped')]")).isDisplayed();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkAttachmentInVacationDetails(){
        hold(1000);

        scrollToElement(workflowDetailsText, true);
        clickOn(attachmentInVacationDetails);
        waitLoadingElement();
        hold(2000);
        waitForElementToBeVisible(AppiumBy.id("com.android.gallery3d:id/gallery_root"));
        return appiumDriver.findElement(AppiumBy.id("com.android.gallery3d:id/gl_root_view")).isDisplayed();
    }

    public String getTransactionDetails(String type){

        String str = null;
        try{
            str = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+type+"')]")).getAttribute("content-desc");
        }catch (Exception e){
            scrollToElement(approvalCommitteeText, true);
            str = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+type+"')]")).getAttribute("content-desc");
        }

        if(str != null && !str.isEmpty()){
            // Find the position of the newline character
            int index = str.indexOf('\n');

            return str.substring(index + 1);
        }else{
            return null;
        }

    }

    public String getTransactionReason(){

        String getReason = null;

        try{
            getReason = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Reason')]")).getAttribute("content-desc");
        }catch (Exception e){
            scrollToElement(workflowDetailsText, true);
            getReason = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Reason')]")).getAttribute("content-desc");
        }

        int startIndex = getReason.indexOf('\n') + 1;
        int endIndex = getReason.indexOf('-');

        return getReason.substring(startIndex, endIndex);

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

}
