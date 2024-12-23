package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;

import java.util.List;

import static java.time.Duration.ofMillis;

public class SalarySlipBE extends MobileBasePage {

    @AndroidFindBy(accessibility = "ProfileIcon")
    public WebElement myProfileBtn;

    public void myProfile(String tab){
        waitForElementToBeVisible(AppiumBy.accessibilityId("MainButtonSemantics"));
        clickOn(myProfileBtn);
        hold(500);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Personal"));

        if(tab.equalsIgnoreCase("Personal")){
            clickOn(AppiumBy.accessibilityId("Personal"));
        }else if(tab.equalsIgnoreCase("Financial")){
            clickOn(AppiumBy.accessibilityId("Financial"));
        }else if(tab.equalsIgnoreCase("Other")){
            clickOn(AppiumBy.accessibilityId("Other"));
        }
        hold(700);
    }

    public void openSalarySlip(){

        try {
            hold(500);
            clickOn(AppiumBy.accessibilityId("Salary Slip"));
            waitLoadingElement();
            waitLoadingElement();
            waitForElementToBeVisible(AppiumBy.accessibilityId("Recent Slip"));
        }catch (Exception e){
            myProfile("Financial");
            hold(500);
            clickOn(AppiumBy.accessibilityId("Salary Slip"));
            waitLoadingElement();
            waitLoadingElement();
            waitForElementToBeVisible(AppiumBy.accessibilityId("Recent Slip"));
        }

    }

    public void openRecentSalarySlip(){
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("Recent Slip"));
        clickOn(AppiumBy.accessibilityId("Recent Slip"));
        waitLoadingElement();
        waitLoadingElement();
    }

    public void getSalarySlip(String year, String month){
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("Recent Slip"));
        clickOn(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Change M/Y')]"));
        waitForElementToBeVisible(AppiumBy.accessibilityId("Change Date"));
        clickOn(AppiumBy.xpath("//android.widget.Button[contains(@content-desc, '20')]"));
        hold(200);
        clickOn(AppiumBy.accessibilityId(year));
        hold(100);
        clickOn(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+month+"')]"));
        hold(200);
        clickOn(AppiumBy.accessibilityId("View Salary Slip"));
        hold(300);
        waitLoadingElement();
        waitLoadingElement();
    }

    public String salarySlip_GetAmount(String type, String fieldName){

        String getField = null;
        boolean isElementFound = false;
        int counter = 1;
        Dimension screenSize = appiumDriver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();

        // Calculate the center of the screen
        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;

        while (!isElementFound) {

            if(counter <= 7){

                try {
                    isElementFound =  appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[contains(@content-desc, '"+fieldName+"')]")).isDisplayed();
                    String field = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[contains(@content-desc, '"+fieldName+"')]")).getAttribute("content-desc");

                    if (field != null) {
                        getField = field.split("\n")[1];
                    }

                } catch (Exception e){
                    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                    Sequence scroll = new Sequence(finger, 1);

                    scroll.addAction(finger.createPointerMove(ofMillis(0),
                            PointerInput.Origin.viewport(), centerX, centerY)); // Start point
                    scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                    scroll.addAction(finger.createPointerMove(ofMillis(300), // Finger scrolling speed
                            PointerInput.Origin.viewport(), centerX, centerY - 200)); // End point

                    scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                    appiumDriver.perform(List.of(scroll));
                }

            }else{
                Assert.fail("The Element Not Found after trying to find it: "+ fieldName);
                break;
            }

            counter++;
        }

        return getField;
    }

    public String getRecentSalarySlip(){
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("Recent Slip"));
        clickOn(AppiumBy.accessibilityId("Recent Slip"));
        waitLoadingElement();
        waitLoadingElement();
        String date = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Change M/Y')]")).getAttribute("content-desc");
        String getDate = null;
        if (date != null) {
            getDate = date.split("\n")[0];
        }
        return getDate;
    }

    public String netSalary(){
        return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Net Salary']/following::android.view.View[1]")).getAttribute("content-desc");
    }
    public String income(){
        return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Income']/following::android.view.View[1]")).getAttribute("content-desc");
    }
    public String deduction_Amount(){
        scrollToElement(AppiumBy.xpath("//android.view.View[@content-desc='Deduction']"), true, 4);
        if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Deduction']/following::android.view.View[1]")).getAttribute("content-desc").contains("Amount")){
            return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Deduction']/following::android.view.View[contains(@content-desc, 'Amount')]/following::android.view.View[1]")).getAttribute("content-desc");
        }else{
            return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Deduction']/following::android.view.View[1]")).getAttribute("content-desc");
        }
    }
    public String deduction_Period(){
        scrollToElement(AppiumBy.xpath("//android.view.View[@content-desc='Deduction']/following::android.view.View[contains(@content-desc, 'Period')]"), true, 4);
        return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Deduction']/following::android.view.View[contains(@content-desc, 'Period')]/following::android.view.View[1]")).getAttribute("content-desc");
    }
    public String PF_Balance(){
        scrollToElement(AppiumBy.xpath("//android.view.View[@content-desc='PF Balance']"), true, 6);
        return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='PF Balance']/following::android.view.View[1]")).getAttribute("content-desc");
    }

    public boolean checkToastAlert(String alertText){
        hold(800);
        try {
            return appiumDriver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[last()]")).getAttribute("content-desc").contains(alertText);
        }catch (Exception e){
            return false;
        }
    }

    public void downloadSalarySlip(){

        if(!checkAppIfInstalled("com.adobe.reader")){
            Assert.fail("The 'Adobe Acrobat Reader: Edit PDF' App NOT Installed In Mobile, Please install this app and try again!");
        }

        verticalSwipeByPercentages(80, 5, 50);
        clickOn(AppiumBy.accessibilityId("Download Salary Slip"));
        hold(1000);
        waitLoadingElement();
        waitLoadingElement();
        hold(2000);
    }

    public void openPdfAfterDownload(){
        try {
            hold(5000);
            appiumDriver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text, 'ALWAYS')]")).isDisplayed();
            simpleClick(appiumDriver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text, 'ALWAYS')]")));
        }catch (Exception ignored){}

        try {
            waitForElementToBeVisible(AppiumBy.accessibilityId("Cross Button"), 6);
            simpleClick(AppiumBy.accessibilityId("Cross Button"));

            hold(1000);
            waitForElementToBeClickable(AppiumBy.accessibilityId("More options"));

        }catch (Exception e){
            try{
                hold(1000);
                waitForElementToBeClickable(AppiumBy.accessibilityId("More options"));
            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
    }

    public void savePdfInDevice(String fileName){

        try {
            hold(5000);
            appiumDriver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text, 'ALWAYS')]")).isDisplayed();
            simpleClick(appiumDriver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text, 'ALWAYS')]")));
        }catch (Exception ignored){}

        try {
            waitForElementToBeVisible(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Sign in')]"), 6);
            try {
                simpleClick(AppiumBy.accessibilityId("Cancel"));
            }catch (Exception cancel){
                simpleClick(AppiumBy.accessibilityId("Cross Button"));
            }

            hold(1000);
            waitForElementToBeClickable(AppiumBy.accessibilityId("More options"));
            clickOn(AppiumBy.accessibilityId("More options"));
            hold(2000);
            verticalSwipeByPercentages(70, 20, 50);
            verticalSwipeByPercentages(70, 20, 50);
            doubleClick(AppiumBy.xpath("//android.widget.TextView[@text='Save a copy']"));
            hold(1500);
            try {
                simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On this device']"));
            }catch (Exception device){
                simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On This Device']"));
            }
            hold(500);
            appiumDriver.findElement(AppiumBy.className("android.widget.EditText")).clear();
            hold(200);
            setText(appiumDriver.findElement(AppiumBy.className("android.widget.EditText")), fileName);
            hold(200);
            clickOn(AppiumBy.xpath("//android.widget.Button[@text='Done']"));
            hold(500);

        }catch (Exception cross){
            try{
                hold(1000);
                waitForElementToBeClickable(AppiumBy.accessibilityId("More options"));
                clickOn(AppiumBy.accessibilityId("More options"));
                hold(2000);
                verticalSwipeByPercentages(70, 20, 50);
                verticalSwipeByPercentages(70, 20, 50);
                doubleClick(AppiumBy.xpath("//android.widget.TextView[@text='Save a copy']"));
                hold(1500);
                try {
                    simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On this device']"));
                }catch (Exception device){
                    simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On This Device']"));
                }
                hold(500);
                appiumDriver.findElement(AppiumBy.className("android.widget.EditText")).clear();
                hold(200);
                setText(appiumDriver.findElement(AppiumBy.className("android.widget.EditText")), fileName);
                hold(200);
                clickOn(AppiumBy.xpath("//android.widget.Button[@text='Done']"));
                hold(500);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }

}
