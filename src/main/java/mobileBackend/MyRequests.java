package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MyRequests extends MobileBasePage {

    @AndroidFindBy(accessibility = "Vacations")
    public WebElement vacationsRequestBtn;
    @AndroidFindBy(accessibility = "Overtime")
    WebElement overtimeRequestBtn;
    @AndroidFindBy(accessibility = "Choose")
    WebElement vacationsTypeBtn;
    @AndroidFindBy(accessibility = "Choose")
    WebElement typeF;
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
    @AndroidFindBy(xpath = "//android.widget.SeekBar[contains(@content-desc, 'Select hours')]")
    WebElement hourF;
    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    WebElement setHour;
    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    WebElement setMinutes;
    @AndroidFindBy(accessibility = "OK")
    WebElement okBtn;
    @AndroidFindBy(accessibility = "Submit")
    WebElement submitBtn;
    @AndroidFindBy(accessibility = "Got it!")
    WebElement gotItBtn;

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
        waitForElementToBeClickable(AppiumBy.accessibilityId("Vacations"));
        clickOn(vacationsRequestBtn);
        waitLoadingElement();
    }

    public void openOvertime(){
        waitForElementToBeClickable(AppiumBy.accessibilityId("Overtime"));
        clickOn(overtimeRequestBtn);
        waitLoadingElement();
    }

    public void vacationRequest(String vacationType, String fromDate, String toDate, boolean submit){

        waitLoadingElement();
        waitForElementToBeClickable(AppiumBy.accessibilityId("Choose"));
        clickOn(vacationsTypeBtn);
        hold(200);
        clickOn(appiumDriver.findElement(AppiumBy.accessibilityId(vacationType)));
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
        hold(500);
        if(submit){
            clickOn(submitBtn);
            waitLoadingElement();
            hold(500);
            clickOn(gotItBtn);
            hold(500);
        }

    }

    public void overtimeRequest(String date, String overtimeType, String fromTime, String toTime, boolean submit){

        waitLoadingElement();
        waitForElementToBeClickable(AppiumBy.accessibilityId("Choose"));
        clickOn(dateF);
        hold(500);
        datePicker(date);
        waitLoadingElement();
        clickOn(typeF);
        hold(200);
        clickOn(appiumDriver.findElement(AppiumBy.accessibilityId(overtimeType)));
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

}
