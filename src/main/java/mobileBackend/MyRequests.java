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
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='From Date']/following::android.widget.ImageView)[1]")
    WebElement fromDateF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='To Date']/following::android.widget.ImageView)[1]")
    WebElement toDateF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Date']/following::android.widget.ImageView)[1]")
    WebElement dateF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='From Time']/following::android.widget.Button)[1]")
    WebElement fromTimeF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='To Time']/following::android.widget.Button)[1]")
    WebElement toTimeF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Reason']/following::android.widget.EditText)[1]")
    WebElement reasonF;
    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'Vacation Attachment')]/following::android.widget.ImageView)[1]")
    WebElement attachmentIconBtn;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Attachment']/following::android.widget.ImageView)[1]")
    WebElement attachmentF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Delegate']/following::android.widget.Button)[1]")
    WebElement delegateF;
    @AndroidFindBy(accessibility = "Document")
    WebElement documentBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='test.png']")
    WebElement imgUploaded;
    @AndroidFindBy(xpath = "//android.widget.SeekBar[contains(@content-desc, 'Select hours')]")
    WebElement hourF;
    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    WebElement setHour;
    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    WebElement setMinutes;
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
    @AndroidFindBy(accessibility = "Approval Committee")
    WebElement approvalCommitteeText;
    @AndroidFindBy(accessibility = "Cancel")
    WebElement cancelBtn;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Attachments']/following::android.widget.ImageView)[1]")
    public WebElement attachmentInVacationDetails;
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
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Attention')]")
    public WebElement attentionAlertPopup;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Successfully')]")
    public WebElement successAlertPopup;
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
        return scrollToElement(vacationCannotBeEnteredInMenaMe_type , true, 7);
    }

    public boolean checkElementIfVisible(WebElement element){
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkCancelButtonIfVisible(){
        scrollToElement(approvalCommitteeText, true);
        verticalSwipeByPercentages(70, 40, 50);
        return checkElementIfVisible(cancelBtn);
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

                clickOn(attachmentIconBtn);

                for(int i = 0; i < numberOfAttachment; i++){

                    clickOn(attachmentF);
                    waitForElementToBeVisible(accessibilityId("Document"));
                    clickOn(documentBtn);
                    waitForElementToBeVisible(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']"));
                    clickOn(imgUploaded);
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

                clickOn(attachmentIconBtn);
                clickOn(attachmentF);
                waitForElementToBeVisible(accessibilityId("Document"));
                clickOn(documentBtn);
//                waitForElementToBeVisible(AppiumBy.id("com.android.documentsui:id/dir_list"));
//                clickOn(appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[@resource-id='com.android.documentsui:id/icon_thumb']")));
//                hold(1000);
//                waitLoadingElement();
//                waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, '.png')]"));


            }

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
                waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Code:')]"));
                hold(300);
                clickOn(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+delegateTo+"')]")));
                hold(100);
                simpleClick(chooseBtn);
                hold(500);
            }
        }

        if(submit){
            clickOn(submitBtn);
            waitLoadingElement();
            hold(500);

            if(!checkAlert){
                clickOn(alrightBtn);
                hold(500);

                if(iniPlatform.equalsIgnoreCase("Android")){
                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
                }

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

    public void vacationRequest_checkAlertAfterUploadAttachment(String vacationType, String fromDate, String toDate, boolean attachment, int numberOfAttachment, int checkAlertAfterNumber){

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

                clickOn(attachmentIconBtn);

                for(int i = 1; i <= numberOfAttachment; i++){

                    if(i == checkAlertAfterNumber){
                        clickOn(attachmentF);
                        hold(150);
                        }else{
                        clickOn(attachmentF);
                        waitForElementToBeVisible(accessibilityId("Document"));
                        clickOn(documentBtn);
                        waitForElementToBeVisible(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']"));
                        clickOn(imgUploaded);
                        hold(1000);
                        waitLoadingElement();
                        waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, '.png')]"));
                    }

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

                clickOn(attachmentIconBtn);
                clickOn(attachmentF);
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

    public void openLastVacationRequest(){
        waitForElementToBeVisible(accessibilityId("My Recent Transactions"));
        clickOn(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='My Recent Transactions']/following::android.view.View[contains(@content-desc, 'Vacation Request')]")));
        hold(1000);
        waitForElementToBeVisible(accessibilityId("Requested on"));

    }

    public boolean checkAttachmentInVacationDetails(){
        waitForElementToBeVisible(accessibilityId("Requested on"));
        scrollToElement(approvalCommitteeText, true);
        clickOn(attachmentInVacationDetails);
        waitLoadingElement();
        hold(5000);
        return appiumDriver.findElement(AppiumBy.id("com.android.gallery3d:id/gl_root_view")).isDisplayed();
    }

    public void overtimeRequest(String date, String overtimeType, String fromTime, String toTime, boolean submit){

        waitLoadingElement();
        waitForElementToBeClickable(accessibilityId("Choose"));
        clickOn(dateF);
        hold(500);
        datePicker(date);
        waitLoadingElement();
        clickOn(typeF);
        hold(200);
        clickOn(appiumDriver.findElement(accessibilityId(overtimeType)));
        waitLoadingElement();
        scrollToElement(submitBtn, true);

        clickOn(fromTimeF);
        hold(500);
        timePicker(fromTime);
        hold(300);
        clickOn(toTimeF);
        hold(500);
        timePicker(toTime);

        hold(500);
        if(submit){
            clickOn(submitBtn);
            waitLoadingElement();
            hold(500);
            //waitForElementToBeVisible(AppiumBy.accessibilityId("Got it!"));
            //clickOn(gotItBtn);
            hold(500);
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

    public String getApprovalCommittee(String managerName){
        String textBetweenNewlines = null;
        try{
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
            boolean containsMoreThanOneNewline = det.indexOf("\n") != -1 && det.indexOf("\n", det.indexOf("\n") + 1) != -1;

            if(containsMoreThanOneNewline){
                textBetweenNewlines = det.substring(det.indexOf("\n") + 1, det.indexOf("\n", det.indexOf("\n") + 1));
            }else{
                textBetweenNewlines = det.substring(det.indexOf("\n") + 1);
            }

            return textBetweenNewlines;

        }catch (Exception e){
            try {
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
                boolean containsMoreThanOneNewline = det.indexOf("\n") != -1 && det.indexOf("\n", det.indexOf("\n") + 1) != -1;

                if(containsMoreThanOneNewline){
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1, det.indexOf("\n", det.indexOf("\n") + 1));
                }else{
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1);
                }

                return textBetweenNewlines;

            }catch (Exception ex){
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
                boolean containsMoreThanOneNewline = det.indexOf("\n") != -1 && det.indexOf("\n", det.indexOf("\n") + 1) != -1;

                if(containsMoreThanOneNewline){
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1, det.indexOf("\n", det.indexOf("\n") + 1));
                }else{
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1);
                }

                return textBetweenNewlines;

            }
        }
    }

    public String getApprovalComments(String managerName){
        String textAfterSecondNewline = null;
        try{
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
            if (det != null) {
                int firstNewline = det.indexOf("\n");
                int secondNewline = det.indexOf("\n", firstNewline + 1);
                textAfterSecondNewline = det.substring(secondNewline + 1, det.indexOf("\n", secondNewline + 1));
            }
            return textAfterSecondNewline;
        }catch (Exception e){
            scrollToElement(approvalCommitteeText, true);
            hold(200);
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
            if (det != null) {
                int firstNewline = det.indexOf("\n");
                int secondNewline = det.indexOf("\n", firstNewline + 1);
                textAfterSecondNewline = det.substring(secondNewline + 1, det.indexOf("\n", secondNewline + 1));
            }
            return textAfterSecondNewline;
        }
    }

    public String getApprovalDate(String managerName){
        String date = null;
        try {
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
            if (det != null) {
                int lastNewline = det.lastIndexOf("\n");
                String textAfterLastNewline = det.substring(lastNewline + 1).trim();
                date = textAfterLastNewline.substring(0, 10);
            }
            return date;
        }catch (Exception e){
            try {
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
                if (det != null) {
                    int lastNewline = det.lastIndexOf("\n");
                    String textAfterLastNewline = det.substring(lastNewline + 1).trim();
                    date = textAfterLastNewline.substring(0, 10);
                }
                return date;
            }catch (Exception ex){
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
                if (det != null) {
                    int lastNewline = det.lastIndexOf("\n");
                    String textAfterLastNewline = det.substring(lastNewline + 1).trim();
                    date = textAfterLastNewline.substring(0, 10);
                }
                return date;
            }
        }
    }

}
