package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;

import static bases.BaseTest.iniPlatform;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class MyRequests extends MobileBasePage {

    @AndroidFindBy(accessibility = "Vacations")
    public WebElement vacationsRequestBtn;
    @AndroidFindBy(accessibility = "Leaves")
    public WebElement leavesRequestBtn;
    @AndroidFindBy(accessibility = "Overtime")
    WebElement overtimeRequestBtn;
    @AndroidFindBy(accessibility = "Choose")
    WebElement vacationsTypeBtn;
    @AndroidFindBy(accessibility = "Choose")
    WebElement sickVacationReasonBtn;
    @AndroidFindBy(accessibility = "Sick Vacation Reasons")
    public WebElement sickVacationReasons_title;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Sick Vacation Reasons']/following::android.view.View[@content-desc='*'])[1]")
    public WebElement sickVacationReasons_mandatory;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Reason')]")
    public List<WebElement> sickVacationReasonsList;
    @AndroidFindBy(accessibility = "Choose")
    WebElement typeF;
    @AndroidFindBy(accessibility = "Choose")
    WebElement chooseBtn;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Overtime Type']/following::android.view.View[@content-desc='Choose'])[1]")
    WebElement overtimeTypeF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Project']/following::android.view.View[@content-desc='Choose'])[1]")
    WebElement projectF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Activity']/following::android.view.View[@content-desc='Choose'])[1]")
    WebElement activityF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Job Card']/following::android.view.View[@content-desc='Choose'])[1]")
    WebElement jobCardF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Leave Date']/following::android.widget.ImageView)[1]")
    WebElement leaveDateF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='From Date']/following::android.widget.ImageView)[1]")
    WebElement fromDateF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='To Date']/following::android.widget.ImageView)[1]")
    WebElement toDateF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Date']/following::android.widget.ImageView)[1]")
    WebElement overtimeDateF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='From Time']/following::android.widget.Button)[1]")
    WebElement fromTimeF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='To Time']/following::android.widget.Button)[1]")
    WebElement toTimeF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Reason']/following::android.widget.EditText)[1]")
    WebElement reasonF;
    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'Vacation Attachment')]/following::android.widget.ImageView)[1]")
    WebElement vacationAttachmentIconBtn;
    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'To Time')]/following::android.widget.ImageView)[1]")
    WebElement leaveAttachmentIconBtn;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Attachment']/following::android.widget.ImageView)[1]")
    WebElement vacationAttachmentF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Request Attachment']/following::android.widget.ImageView)[1]")
    WebElement leaveAttachmentF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Delegate']/following::android.widget.Button)[1]")
    WebElement delegateF;
    @AndroidFindBy(xpath = "(//android.widget.RadioButton)[1]")
    WebElement halfMorningDay_option;
    @AndroidFindBy(xpath = "(//android.widget.RadioButton)[2]")
    WebElement halfEveningDay_option;
    @AndroidFindBy(accessibility = "Document")
    WebElement documentBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='test.png']")
    WebElement imgUploaded;
    @AndroidFindBy(accessibility = "OK")
    WebElement okBtn;
    @AndroidFindBy(accessibility = "Try Again")
    WebElement tryAgainBtn;
    @AndroidFindBy(accessibility = "Submit")
    WebElement submitBtn;
    @AndroidFindBy(accessibility = "Not Required")
    WebElement notRequired_checkbox;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@hint='Search by Name...']")
    WebElement search_delegatePopup;
    @AndroidFindBy(accessibility = "Got it!")
    WebElement gotItBtn;
    @AndroidFindBy(accessibility = "Alright!")
    WebElement alrightBtn;
    @AndroidFindBy(accessibility = "Please Fill The Reason")
    public WebElement pleaseFillTheReason_Alert;
    @AndroidFindBy(accessibility = "Please Insert Phone Number")
    public WebElement pleaseInsertPhoneNumber_Alert;
    @AndroidFindBy(accessibility = "The maximum number of attachment is : 2")
    public WebElement theMaximumNumberOfAttachmentIs2_Alert;
    @AndroidFindBy(accessibility = "Maximum Allowed Attachments Is 2 And Minimum Allowed Attachments Is 1")
    public WebElement maximumAllowedAttachmentsIs2AndMinimumAllowedAttachmentsIs1;
    @AndroidFindBy(accessibility = "Auto Delegation Is Mandatory Before Vacation Request")
    public WebElement autoDelegationIsMandatoryBeforeVacationRequest_Alert;
    @AndroidFindBy(accessibility = "You Must Fill Sick Vacation Reason")
    public WebElement youMustFillSickVacationReason_Alert;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'results found')]")
    public WebElement resultFound;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Code:')]")
    public List<WebElement> listOfEmployees;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Successfully')]")
    public WebElement successAlertPopup;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Attention')]")
    public WebElement attentionAlertPopup;
    @AndroidFindBy(accessibility = "Vacation Cannot Be Entered in MenaMe")
    WebElement vacationCannotBeEnteredInMenaMe_type;


//    public void datePicker(String date){
//
//        String[] parts = date.split("/");
//        int day = Integer.parseInt(parts[0]);
//        int month = Integer.parseInt(parts[1]);
//        int year = Integer.parseInt(parts[2]);
//
//        waitForElementToBeClickable(AppiumBy.accessibilityId("OK"));
//
//        int currentYear = Integer.parseInt(datePicker_yearBtn.getAttribute("content-desc").trim());
//
//        if(currentYear != year){
//
//            clickOn(datePicker_yearBtn);
//            hold(300);
//
//            //scrollToElement_2(appiumDriver.findElement(AppiumBy.accessibilityId(String.valueOf(year))), false);
//
//            boolean isElementFound = false;
//            Dimension screenSize = appiumDriver.manage().window().getSize();
//            int screenWidth = screenSize.getWidth();
//            int screenHeight = screenSize.getHeight();
//
//            // Calculate the center of the screen
//            int centerX = screenWidth / 2;
//            int centerY = screenHeight / 2;
//            while (!isElementFound) {
//                try {
//                    isElementFound = appiumDriver.findElement(AppiumBy.accessibilityId(String.valueOf(year))).isDisplayed();
//                } catch (Exception e) {
//                    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//                    Sequence scroll = new Sequence(finger, 1);
//                    scroll.addAction(finger.createPointerMove(ofMillis(0),
//                            PointerInput.Origin.viewport(), centerX, centerY)); // Start point
//                    scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//                    scroll.addAction(finger.createPointerMove(ofMillis(400), // Finger scrolling speed
//                            PointerInput.Origin.viewport(), centerX, centerY + 500)); // End point
//                    scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//                    appiumDriver.perform(List.of(scroll));
//                }
//            }
//
//            clickOn(appiumDriver.findElement(AppiumBy.accessibilityId(String.valueOf(year))));
//            hold(300);
//
//        }
//
////        if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Dec")){
////            for(int i = 1; i < 12; i++){
////                datePicker_PreviousBtn.click();
////            }
////        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Nov")){
////            for(int i = 1; i < 11; i++){
////                datePicker_PreviousBtn.click();
////            }
////        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Oct")){
////            for(int i = 1; i < 10; i++){
////                datePicker_PreviousBtn.click();
////            }
////        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Sep")){
////            for(int i = 1; i < 9; i++){
////                datePicker_PreviousBtn.click();
////            }
////        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Aug")){
////            for(int i = 1; i < 8; i++){
////                datePicker_PreviousBtn.click();
////            }
////        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Jul")){
////            for(int i = 1; i < 7; i++){
////                datePicker_PreviousBtn.click();
////            }
////        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Jun")){
////            for(int i = 1; i < 6; i++){
////                datePicker_PreviousBtn.click();
////            }
////        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("May")){
////            for(int i = 1; i < 5; i++){
////                datePicker_PreviousBtn.click();
////            }
////        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Apr")){
////            for(int i = 1; i < 4; i++){
////                datePicker_PreviousBtn.click();
////            }
////        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Mar")){
////            for(int i = 1; i < 3; i++){
////                datePicker_PreviousBtn.click();
////            }
////        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Feb")){
////            for(int i = 1; i < 2; i++){
////                datePicker_PreviousBtn.click();
////            }
////        }
//
//        int currentMonth = 1;
//
//        if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Dec")){
//            currentMonth = 12;
//        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Nov")){
//            currentMonth = 11;
//        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Oct")){
//            currentMonth = 10;
//        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Sep")){
//            currentMonth = 9;
//        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Aug")){
//            currentMonth = 8;
//        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Jul")){
//            currentMonth = 7;
//        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Jun")){
//            currentMonth = 6;
//        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("May")){
//            currentMonth = 5;
//        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Apr")){
//            currentMonth = 4;
//        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Mar")){
//            currentMonth = 3;
//        }else if(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc").contains("Feb")){
//            currentMonth = 2;
//        }
//
//        int between = currentMonth - month;
//
//        if (between > 0) {
//            for(int i = 0; i < between; i++){
//                datePicker_PreviousBtn.click();
//            }
//
//        }else if(between < 0){
//            int backMonth = Math.abs(between);
//            for(int i = 0; i < backMonth; i++){
//                datePicker_NextBtn.click();
//            }
//        }
//
////        int i = 1;
////        while (month > i) {
////            datePicker_NextBtn.click();
////            i++;
////        }
//
//        hold(300);
//        clickOn(appiumDriver.findElement(AppiumBy.accessibilityId(String.valueOf(day))));
//        hold(200);
//        clickOn(okBtn);
//        hold(500);
//
//    }

    public void openVacations(){
        waitForElementToBeClickable(accessibilityId("Vacations"));
        clickOn(vacationsRequestBtn);
        waitLoadingElement();
    }

    public void openLeaves(){
        waitForElementToBeClickable(accessibilityId("Leaves"));
        clickOn(leavesRequestBtn);
        waitLoadingElement();
    }

    public void openOvertime(){
        waitForElementToBeClickable(accessibilityId("Overtime"));
        clickOn(overtimeRequestBtn);
        waitLoadingElement();
    }

    public boolean checkVacationType(String vacationType){
        waitLoadingElement();
        waitForElementToBeClickable(accessibilityId("Choose"));
        clickOn(vacationsTypeBtn);
        hold(200);
        return scrollToElement(AppiumBy.accessibilityId(vacationType) , true, 12);
    }

    public boolean checkLeaveType(String leaveType){
        waitLoadingElement();
        waitForElementToBeClickable(accessibilityId("Choose"));
        clickOn(chooseBtn);
        hold(200);
        return scrollToElement(AppiumBy.accessibilityId(leaveType) , true, 12);
    }

    public boolean checkOvertimeTypeIfAppear(String  date, String type){
        waitLoadingElement();
        waitLoadingElement();
        waitForElementToBeClickable(accessibilityId("Choose"));
        clickOn(overtimeDateF);
        hold(500);
        datePicker(date);
        waitLoadingElement();
        hold(500);
        clickOn(overtimeTypeF);
        hold(200);
        return scrollToElement(AppiumBy.accessibilityId(type) , true, 15);
    }

    public void closeList(){
        simpleClick(AppiumBy.className("android.widget.Button"));
    }

    public void vacationRequest(String vacationType, String sickVacationReason, String fromDate, String toDate, boolean attachment, int numberOfAttachment, String reason, String delegateTo, boolean submit, boolean checkAlert){

        waitLoadingElement();
        waitForElementToBeClickable(accessibilityId("Choose"));
        clickOn(vacationsTypeBtn);
        hold(200);
        clickOn(accessibilityId(vacationType));
        waitLoadingElement();
        if(!sickVacationReason.isEmpty()){
            waitLoadingElement();
            waitForElementToBeVisible(accessibilityId("Sick Vacation Reasons"));
            clickOn(sickVacationReasonBtn);
            hold(200);
            clickOn(accessibilityId(sickVacationReason));
            hold(500);
        }
        if(!fromDate.isEmpty()){
            clickOn(fromDateF);
            hold(500);
            datePicker(fromDate);
            waitLoadingElement();
        }
        if(!toDate.isEmpty()){
            clickOn(toDateF);
            hold(500);
            datePicker(toDate);
            waitLoadingElement();
        }

        scrollToElement(submitBtn, true);

        if(attachment){

            uploadAttachment(numberOfAttachment);
            verticalSwipeByPercentages(70, 30, 50);

        }

        if(!reason.isEmpty()){
            clickOn(reasonF);
            setText(reasonF, reason);

            if(iniPlatform.equalsIgnoreCase("Android")){
                try{
                    ((AndroidDriver) appiumDriver).hideKeyboard();
                }catch (Exception ignored){}
            }else{
                try{
                    ((IOSDriver) appiumDriver).hideKeyboard();
                }catch (Exception ignored){
                    ((IOSDriver) appiumDriver).hideKeyboard("Done");
                }
            }

        }

        if(!delegateTo.isEmpty()){
            clickOn(delegateF);
            hold(100);
            if(delegateTo.equalsIgnoreCase("Not Required")){
                simpleClick(notRequired_checkbox);
                hold(300);
            }else{
                simpleClick(search_delegatePopup);
                hold(100);
                setText(search_delegatePopup, delegateTo);
                hold(200);
                try {
                    waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Code:')]"));
                    hold(300);
                    clickOn(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+delegateTo+"')]")));

                }catch (Exception e){
                    hold(1000);
                    clickOn(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+delegateTo+"')]")), true);

                }
                hold(300);
                simpleClick(chooseBtn);
                hold(500);
            }
        }

        if(submit){
            clickOn(submitBtn);
            waitLoadingElement();
            hold(500);

            if(!checkAlert){
                closeAlert();
                hold(500);

                back();

            }

        }

    }

    public void vacationRequest_checkSickVacationReasonsField(String vacationType, boolean checkListReasonsTypes){
        waitLoadingElement();
        waitForElementToBeClickable(accessibilityId("Choose"));
        clickOn(vacationsTypeBtn);
        hold(200);
        clickOn(accessibilityId(vacationType));
        waitLoadingElement();
        waitLoadingElement();
        hold(2000);

        if(checkListReasonsTypes){
            waitLoadingElement();
            waitForElementToBeVisible(accessibilityId("Sick Vacation Reasons"));
            clickOn(sickVacationReasonBtn);
            hold(200);
        }

    }

    public void openDelegatePopup(){
        scrollToElement(submitBtn, true);
        clickOn(delegateF);
        hold(100);
    }

    public void vacationRequest_checkAlertAfterUploadAttachment(String vacationType, String fromDate, String toDate, boolean attachment, int numberOfAttachment){

        waitLoadingElement();
        waitForElementToBeClickable(accessibilityId("Choose"));
        clickOn(vacationsTypeBtn);
        hold(200);
        clickOn(accessibilityId(vacationType));
        waitLoadingElement();
        clickOn(fromDateF);
        hold(500);
        datePicker(fromDate);
        waitLoadingElement();
        clickOn(toDateF);
        hold(500);
        datePicker(toDate);
        waitLoadingElement();
        scrollToElement(submitBtn, true);

        if(attachment){
            uploadAttachment(numberOfAttachment);
        }

        try {
            simpleClick(AppiumBy.xpath("(//android.view.View[@content-desc='Attachment']/following::android.widget.ImageView)[1]"));
        }catch (Exception e){
            simpleClick(AppiumBy.xpath("(//android.view.View[@content-desc='Request Attachment']/following::android.widget.ImageView)[1]"));
        }

        hold(500);

    }

    public void leaveRequest(String leaveType, String leaveDate, String fromTime, String toTime, boolean attachment, String reason, boolean submit, boolean checkAlert){

        waitLoadingElement();
        waitForElementToBeClickable(accessibilityId("Choose"));
        clickOn(chooseBtn);
        hold(200);
        clickOn(accessibilityId(leaveType));
        waitLoadingElement();
        hold(600);
        if(!leaveDate.isEmpty()){
            clickOn(leaveDateF);
            hold(500);
            datePicker(leaveDate);
            waitLoadingElement();
            hold(500);
        }
        if(!fromTime.isEmpty()){
            clickOn(fromTimeF);
            hold(500);
            timePicker(fromTime);
            waitLoadingElement();
            hold(500);
        }
        if(!toTime.isEmpty()){
            clickOn(toTimeF);
            hold(500);
            timePicker(toTime);
            waitLoadingElement();
            hold(500);
        }

        scrollToElement(submitBtn, true);

        if(attachment){

            uploadAttachment(1);

            verticalSwipeByPercentages(70, 30, 50);

        }

        if(!reason.isEmpty()){
            clickOn(reasonF);
            setText(reasonF, reason);

            if(iniPlatform.equalsIgnoreCase("Android")){
                try{
                    ((AndroidDriver) appiumDriver).hideKeyboard();
                }catch (Exception ignored){}
            }else{
                try{
                    ((IOSDriver) appiumDriver).hideKeyboard();
                }catch (Exception ignored){
                    ((IOSDriver) appiumDriver).hideKeyboard("Done");
                }
            }

        }

        if(submit){
            verticalSwipeByPercentages(70, 30, 50);
            clickOn(submitBtn);
            waitLoadingElement();
            hold(500);

            if(!checkAlert){
                closeAlert();
                hold(500);

//                if(iniPlatform.equalsIgnoreCase("Android")){
//                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//                }

            }

        }


    }

    public void leaveRequest_HoursSetting(String leaveType, String leaveDate, String timeSetting, boolean attachment, String reason, boolean submit, boolean checkAlert){

        waitLoadingElement();
        waitForElementToBeClickable(accessibilityId("Choose"));
        clickOn(chooseBtn);
        hold(200);
        clickOn(accessibilityId(leaveType));
        waitLoadingElement();
        hold(600);
        if(!leaveDate.isEmpty()){
            clickOn(leaveDateF);
            hold(500);
            datePicker(leaveDate);
            waitLoadingElement();
            hold(500);
        }
        if(timeSetting.equalsIgnoreCase("Half Morning Day")){
            clickOn(halfMorningDay_option);
        }else if(timeSetting.equalsIgnoreCase("Half Evening Day")){
            clickOn(halfEveningDay_option);
        }

        //scrollToElement(submitBtn, true);
        verticalSwipeByPercentages(70, 30, 50);

        if(attachment){

            uploadAttachment(1);
            verticalSwipeByPercentages(70, 30, 50);

        }

        if(!reason.isEmpty()){
            clickOn(reasonF);
            setText(reasonF, reason);

            if(iniPlatform.equalsIgnoreCase("Android")){
                try{
                    ((AndroidDriver) appiumDriver).hideKeyboard();
                }catch (Exception ignored){}
            }else{
                try{
                    ((IOSDriver) appiumDriver).hideKeyboard();
                }catch (Exception ignored){
                    ((IOSDriver) appiumDriver).hideKeyboard("Done");
                }
            }

        }

        if(submit){
            clickOn(submitBtn);
            waitLoadingElement();
            hold(500);

            if(!checkAlert){
                closeAlert();
                hold(500);

//                if(iniPlatform.equalsIgnoreCase("Android")){
//                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//                }

            }

        }


    }

    public void overtimeRequest(String date, String overtimeType, String project, String activity, String jobCard, String fromTime, String toTime, boolean attachment, String reason, boolean submit, boolean checkAlert){

        waitLoadingElement();
        waitLoadingElement();
        waitForElementToBeClickable(accessibilityId("Choose"));
        if(!date.isEmpty()){
            clickOn(overtimeDateF);
            hold(500);
            datePicker(date);
            waitLoadingElement();
            hold(500);
        }
        if(!overtimeType.isEmpty()){
            clickOn(overtimeTypeF);
            hold(200);
            clickOn(accessibilityId(overtimeType));
            waitLoadingElement();
            hold(500);
        }
        if(!project.isEmpty()){
            clickOn(projectF);
            hold(200);
            clickOn(accessibilityId(project));
            waitLoadingElement();
            hold(500);
        }
        if(!activity.isEmpty()){
            clickOn(activityF);
            hold(200);
            clickOn(accessibilityId(activity));
            waitLoadingElement();
            hold(500);
        }
        if(!jobCard.isEmpty()){
            clickOn(jobCardF);
            hold(200);
            clickOn(accessibilityId(jobCard));
            waitLoadingElement();
            hold(500);
        }
        scrollToElement(submitBtn, true);
        if(!fromTime.isEmpty()){
            clickOn(fromTimeF);
            hold(500);
            timePicker(fromTime);
            waitLoadingElement();
            hold(500);
        }
        if(!toTime.isEmpty()){
            clickOn(toTimeF);
            hold(500);
            timePicker(toTime);
            waitLoadingElement();
            hold(500);
        }

        if(attachment){

            uploadAttachment(1);
            verticalSwipeByPercentages(70, 30, 50);

        }

        if(!reason.isEmpty()){
            clickOn(reasonF);
            setText(reasonF, reason);

            if(iniPlatform.equalsIgnoreCase("Android")){
                try{
                    ((AndroidDriver) appiumDriver).hideKeyboard();
                }catch (Exception ignored){}
            }else{
                try{
                    ((IOSDriver) appiumDriver).hideKeyboard();
                }catch (Exception ignored){
                    ((IOSDriver) appiumDriver).hideKeyboard("Done");
                }
            }

        }

        if(submit){
            verticalSwipeByPercentages(70, 30, 50);
            clickOn(submitBtn);
            waitLoadingElement();
            hold(500);

            if(!checkAlert){
                closeAlert();
                hold(500);

                back();

            }

        }


    }

    public void closeAlert(){
        try{
            simpleClick(alrightBtn);
        }catch (Exception exce){
            try {
                simpleClick(gotItBtn);
            }catch (Exception exc){
                try {
                    simpleClick(okBtn);
                }catch (Exception ex){
                    try {
                        simpleClick(tryAgainBtn);
                    }catch (Exception e){
                        System.out.println("I can't click on the suggested buttons!");
                        e.printStackTrace();
                    }
                }
            }
        }
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

    public boolean checkToastAlert(String alertText){
        hold(800);
        try {
            return appiumDriver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[last()]")).getAttribute("content-desc").contains(alertText);
        }catch (Exception e){
            return false;
        }
    }

    public String getToastAlert(){
        try {
            return appiumDriver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[last()]")).getAttribute("content-desc");
        }catch (Exception e){
            return null;
        }
    }

    public void uploadAttachment(int numberOfAttachment){

        if(iniPlatform.equalsIgnoreCase("Android")){

            // The file to be uploaded
            File file = new File("src/main/resources/testUpload.jpg");
            // Specify the remote path where you want to push the file on the device
            String remotePath = "/sdcard/Download/test.png";
            // Convert the file to Base64 format
            byte[] fileContent = null;
            try {
                fileContent = Files.readAllBytes(Path.of(file.getAbsolutePath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String encodedFile = Base64.getEncoder().encodeToString(fileContent);
            // Upload the file to the device
            ((AndroidDriver) appiumDriver).pushFile(remotePath, encodedFile.getBytes());

            try {
                simpleClick(AppiumBy.xpath("(//android.view.View[contains(@content-desc, 'Vacation Attachment')]/following::android.widget.ImageView)[1]"));
            }catch (Exception e){
                try {
                    simpleClick(AppiumBy.xpath("(//android.view.View[contains(@content-desc, 'Reason')]/preceding-sibling::android.view.View[1])//android.widget.ImageView[1]"));
                }catch (Exception ex){
                    simpleClick(AppiumBy.xpath("(//android.view.View[contains(@content-desc, 'To Time')]/following::android.widget.ImageView)[1]"));
                }
            }

            for(int i = 0; i < numberOfAttachment; i++){

                try {
                    simpleClick(AppiumBy.xpath("(//android.view.View[@content-desc='Attachment']/following::android.widget.ImageView)[1]"));
                }catch (Exception e){
                    simpleClick(AppiumBy.xpath("(//android.view.View[@content-desc='Request Attachment']/following::android.widget.ImageView)[1]"));
                }
                waitForElementToBeVisible(accessibilityId("Document"));
                clickOn(documentBtn);
                hold(1500);
                try{
                    appiumDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']")).isDisplayed();
                }catch (Exception e){
                    waitForElementToBeVisible(AppiumBy.accessibilityId("Show roots"));
                    simpleClick(AppiumBy.accessibilityId("Show roots"));
                    hold(1500);
                    waitForElementToBeVisible(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']"));
                    simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']"));
                    hold(1500);
                }
                waitForElementToBeClickable(imgUploaded);
                simpleClick(imgUploaded);
                hold(1000);
                waitLoadingElement();
                waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, '.png')]"));
            }

        }else{

            // The file to be uploaded
            File file = new File("src/main/resources/testUpload.jpg");

            // Specify the remote path where you want to push the file on the iOS device
            String remotePath = "@com.example.YourApp:documents/test.png";

            // Convert the file to Base64 format
            byte[] fileContent = null;
            try {
                fileContent = Files.readAllBytes(Path.of(file.getAbsolutePath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String encodedFile = Base64.getEncoder().encodeToString(fileContent);

            // Upload the file to the device
            ((IOSDriver) appiumDriver).pushFile(remotePath, encodedFile.getBytes());

            clickOn(vacationAttachmentIconBtn);
            clickOn(vacationAttachmentF);
            waitForElementToBeVisible(accessibilityId("Document"));
            clickOn(documentBtn);
//                waitForElementToBeVisible(AppiumBy.id("com.android.documentsui:id/dir_list"));
//                clickOn(appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[@resource-id='com.android.documentsui:id/icon_thumb']")));
//                hold(1000);
//                waitLoadingElement();
//                waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, '.png')]"));


        }

    }

}
