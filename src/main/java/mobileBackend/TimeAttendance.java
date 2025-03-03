package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.AppiumBy.accessibilityId;

public class TimeAttendance extends MobileBasePage {

    @AndroidFindBy(accessibility = "Open TA Type")
    WebElement openTaType;
    @AndroidFindBy(accessibility = "Sign In")
    WebElement signInBtn;
    @AndroidFindBy(accessibility = "Sign Out")
    WebElement signOutBtn;
    @AndroidFindBy(accessibility = "Break In")
    WebElement breakInBtn;
    @AndroidFindBy(accessibility = "Break Out")
    WebElement breakOutBtn;
    @AndroidFindBy(accessibility = "Smoke In")
    WebElement smokeInBtn;
    @AndroidFindBy(accessibility = "Smoke Out")
    WebElement smokeOutBtn;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Successfully')]")
    public WebElement successAlertPopup;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Attention')]")
    public WebElement attentionAlertPopup;
    @AndroidFindBy(accessibility = "TimeManagementIcon")
    WebElement timeAttendanceTab;
    @AndroidFindBy(accessibility = "Missing Punches")
    WebElement missingPunchesBtn;
    @AndroidFindBy(accessibility = "Attendance History")
    WebElement attendanceHistoryBtn;
    @AndroidFindBy(accessibility = "Missing Punches Request")
    WebElement missingPunchesRequestBtn;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='NotificationIcon']/preceding::android.widget.ImageView[1]")
    WebElement missingPunchTopDateF;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Entry Time')]//android.widget.ImageView[2]")
    WebElement entryTime_timeF;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Entry Time')]//android.widget.ImageView[3]")
    WebElement exitTime_dateF;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Entry Time')]//android.widget.ImageView[4]")
    WebElement exitTime_timeF;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Entry Time')]//android.view.View[1]")
    WebElement reasonMenu;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Entry Time')]//android.widget.EditText[1]")
    WebElement otherF;
    @AndroidFindBy(accessibility = "Submit")
    WebElement submitBtn;
    @AndroidFindBy(accessibility = "Approval Committee")
    WebElement approvalCommitteeText;
    @AndroidFindBy(accessibility = "Withdraw")
    WebElement withdrawBtn;
    @AndroidFindBy(accessibility = "Alright!")
    WebElement alrightBtn;

    public String getTimeAttendanceButtonTitle(){
        try {
            return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='TimeAttendanceButton']//android.widget.Button[1]")).getAttribute("content-desc");
        }catch (Exception e){
            return "Not Found Button!";
        }
    }

    public void signIn(boolean checkAlert){
        waitForElementToBeClickable(openTaType);
        clickOn(openTaType);
        hold(1000);
        clickOn(signInBtn);
        hold(200);
        clickOn(signInBtn);
        hold(200);
        waitLoadingButtonTA();
        hold(4000);
    }

    public void signOut(boolean checkAlert){
        waitForElementToBeClickable(openTaType);
        clickOn(openTaType);
        hold(1000);
        clickOn(signOutBtn);
        hold(200);
        clickOn(signOutBtn);
        hold(200);
        waitLoadingButtonTA();
        hold(4000);
    }

    public void waitLoadingButtonTA(){
        /// this function to wait the loading button appear after click on sign in or sign out until to invisible
        new WebDriverWait(appiumDriver, Duration.ofSeconds(60))
                .until(ExpectedConditions.invisibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc='TimeAttendanceButton']//android.widget.ImageView[contains(@content-desc, 'Loading')]")));
    }

    public boolean checkAlertPopup(String alertText){
        hold(500);
        try{
            return successAlertPopup.getAttribute("content-desc").contains(alertText);
        }catch (Exception e){
            try {
                return attentionAlertPopup.getAttribute("content-desc").contains(alertText);
            }catch (Exception ex){
                return false;
            }
        }
    }


    //////////////////////////////////////////////////////////////////////

    public void openTimeAttendanceTab(){
        waitForElementToBeClickable(timeAttendanceTab);
        clickOn(timeAttendanceTab);
        hold(1000);
    }

    public void openMissingPunch(){
        waitForElementToBeClickable(missingPunchesBtn);
        clickOn(missingPunchesBtn);
        hold(1000);
    }

    public void missingPunchesRequest(String date, String entryTime, String exitDate, String exitTime, String reason, String ifOther, boolean checkAlert){
        waitForElementToBeVisible(missingPunchesRequestBtn);
        clickOn(missingPunchesRequestBtn);
        waitLoadingElement();
        waitLoadingElement();
        hold(700);
        if(!date.isEmpty()){
            clickOn(missingPunchTopDateF);
            hold(500);
            datePicker(date);
            waitLoadingElement();
            waitLoadingElement();
            hold(500);
        }
        if(!entryTime.isEmpty()){
            clickOn(entryTime_timeF);
            hold(500);
            timePicker(entryTime);
            waitLoadingElement();
            hold(500);
        }
        if(!exitDate.isEmpty()){
            clickOn(exitTime_dateF);
            hold(500);
            datePicker(exitDate);
            waitLoadingElement();
            hold(500);
        }
        if(!exitTime.isEmpty()){
            clickOn(exitTime_timeF);
            hold(500);
            timePicker(exitTime);
            waitLoadingElement();
            hold(500);
        }
        if(!reason.isEmpty()){
            clickOn(reasonMenu);
            hold(1000);
            clickOn(AppiumBy.accessibilityId(reason));
            hold(1500);
        }
        if(ifOther.equalsIgnoreCase("Other")){
            setText(otherF, ifOther);
            hold(500);
        }
        clickOn(submitBtn);
        waitLoadingElement();
        hold(800);

        if(!checkAlert){
            closeAlert();
            hold(500);
        }
    }

    public void openMissingPunchesDetails(String date){
        ////// send date argument like this format --> 30.10.2024
        hold(1500);
        waitForElementToBeVisible(AppiumBy.accessibilityId("My Missing Punches"));
        clickOn(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+date+"')][1]"));
        hold(1000);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Requested on"));
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

            return str.substring(index + 1).trim();
        }else{
            return null;
        }

    }

    public void withdraw(){
        waitForElementToBeVisible(accessibilityId("Requested on"));
        scrollToElement(withdrawBtn, true);
        clickOn(withdrawBtn);
        waitLoadingElement();
        waitForElementToBeVisible(accessibilityId("Alright!"));
        clickOn(alrightBtn);
        waitForElementToBeVisible(accessibilityId("Requested on"));
    }

    public void withdraw(boolean closeAlert){
        waitForElementToBeVisible(accessibilityId("Requested on"));
        scrollToElement(withdrawBtn, true);
        clickOn(withdrawBtn);
        waitLoadingElement();
        hold(4000);
        if(closeAlert){
            closeAlert();
        }
    }


}
