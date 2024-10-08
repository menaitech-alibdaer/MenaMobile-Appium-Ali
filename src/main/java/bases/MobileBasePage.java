package bases;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bases.BaseTest.iniPlatform;
import static java.time.Duration.ofMillis;

public class MobileBasePage {

    protected AppiumDriver appiumDriver;
    int second = 20;

    public MobileBasePage() {
        this.appiumDriver = BaseTest.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void waitForElementToBeVisible(By locator){
        new WebDriverWait(appiumDriver, Duration.ofSeconds(second))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeVisible(WebElement element){
        new WebDriverWait(appiumDriver, Duration.ofSeconds(second))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeInvisible(By locator){
        new WebDriverWait(appiumDriver, Duration.ofSeconds(second))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementToBeVisible(By locator, int timeoutInSeconds){
        new WebDriverWait(appiumDriver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator){
        new WebDriverWait(appiumDriver, Duration.ofSeconds(second))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBeClickable(WebElement element){
        new WebDriverWait(appiumDriver, Duration.ofSeconds(second))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void simpleClick(WebElement element){
        element.click();
        hold(100);
    }

    public void clickOn(WebElement element){
        try{

            element.click();
            hold(100);

        }catch (Exception excep){

            boolean isElementFound = false;
            int counter = 1;
            Dimension screenSize = appiumDriver.manage().window().getSize();
            int screenWidth = screenSize.getWidth();
            int screenHeight = screenSize.getHeight();

            // Calculate the center of the screen
            int centerX = screenWidth / 2;
            int centerY = screenHeight / 2;

            while (!isElementFound) {

                if(counter <= 3){

                    try {
                        isElementFound = element.isDisplayed();

                        element.click();
                        hold(100);

                    } catch (Exception e) {
                        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                        Sequence scroll = new Sequence(finger, 1);

                        scroll.addAction(finger.createPointerMove(ofMillis(0),
                                PointerInput.Origin.viewport(), centerX, centerY)); // Start point
                        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                        scroll.addAction(finger.createPointerMove(ofMillis(300), // Finger scrolling speed
                                PointerInput.Origin.viewport(), centerX, centerY - 600)); // End point

                        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                        appiumDriver.perform(List.of(scroll));
                    }

                }else if(counter <= 7){

                    try {
                        isElementFound = element.isDisplayed();

                        element.click();
                        hold(100);

                    } catch (Exception e) {
                        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                        Sequence scroll = new Sequence(finger, 1);

                        scroll.addAction(finger.createPointerMove(ofMillis(0),
                                PointerInput.Origin.viewport(), centerX, centerY)); // Start point
                        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                        scroll.addAction(finger.createPointerMove(ofMillis(300), // Finger scrolling speed
                                PointerInput.Origin.viewport(), centerX, centerY + 600)); // End point

                        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                        appiumDriver.perform(List.of(scroll));
                    }

                }else{
                    excep.printStackTrace();
                    break;
                }

                counter++;
            }

        }
    }

    public void clickOn(WebElement element, boolean waitElement){
        try {
            element.click();
        }catch (Exception e){
            try {
                if(waitElement){
                    waitForElementToBeClickable(element);
                    element.click();
                }
            }catch (Exception ex){
                scrollToElement(element, true);
                element.click();
            }
        }
    }

    public void clickOn(By locator){
        try{

            appiumDriver.findElement(locator).click();
            hold(100);

        }catch (Exception excep){

            boolean isElementFound = false;
            int counter = 1;
            Dimension screenSize = appiumDriver.manage().window().getSize();
            int screenWidth = screenSize.getWidth();
            int screenHeight = screenSize.getHeight();

            // Calculate the center of the screen
            int centerX = screenWidth / 2;
            int centerY = screenHeight / 2;

            while (!isElementFound) {

                if(counter <= 10){

                    try {
                        isElementFound =  appiumDriver.findElement(locator).isDisplayed();

                        appiumDriver.findElement(locator).click();
                        hold(100);

                    } catch (Exception e) {
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

                }else if(counter <= 18){

                    try {
                        isElementFound =  appiumDriver.findElement(locator).isDisplayed();

                        appiumDriver.findElement(locator).click();
                        hold(100);

                    } catch (Exception e) {
                        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                        Sequence scroll = new Sequence(finger, 1);

                        scroll.addAction(finger.createPointerMove(ofMillis(0),
                                PointerInput.Origin.viewport(), centerX, centerY)); // Start point
                        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                        scroll.addAction(finger.createPointerMove(ofMillis(300), // Finger scrolling speed
                                PointerInput.Origin.viewport(), centerX, centerY + 200)); // End point

                        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                        appiumDriver.perform(List.of(scroll));
                    }

                }else{
                    Assert.fail("The Element Not Found after trying to find it: "+ appiumDriver.findElement(locator));
                    break;
                }

                counter++;
            }

        }
    }

    public void clickByLocation(int targetX ,int targetY) {

        Actions actions = new Actions(appiumDriver);
        actions.moveByOffset(targetX, targetY).click().perform();
    }

    public void clickByLocationElement(WebElement element, int xOffset ,int yOffset) {

        Actions actions = new Actions(appiumDriver);
        // Move to the center of the element, then offset the click by xOffset and yOffset
        actions.moveToElement(element, xOffset, yOffset).click().perform();

        // Example 1: Click 10 pixels to the right and 5 pixels down from the center
        // clickByLocationElement(element, 10, 5);

        // Example 2: Click 15 pixels to the left and 20 pixels up from the center
        // clickByLocationElement(element, -15, -20);

    }

    public void setText(WebElement element, String text){
        try {
            element.sendKeys(text);
            hold(100);
        }catch (Exception e){
            waitForElementToBeVisible(element);
            element.sendKeys(text);
            hold(100);
        }
    }

    public void hold(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickIfElementPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10)); // Timeout of 10 seconds

        try {
            // Wait until the element is visible and clickable
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.click(); // Click on the element if it appears
        } catch (Exception e) {
            // Element not found within the timeout, continue with the test
            System.out.println("Element not found or not visible, continuing with the test.");
        }
    }

    public boolean checkIfUpdateAvailable() {
        boolean check = false;
        try {
            new WebDriverWait(appiumDriver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Update")));
            check = true;
        } catch (Exception e) {
            System.out.println("After wait 5 second, there is NO update popup!");
        }
        return check;
    }

    public void ignoreUpdatePopup(){
        waitLoadingElement();
        if(checkIfUpdateAvailable()){
            clickOn(appiumDriver.findElement(AppiumBy.accessibilityId("Later")));
            hold(500);
        }
    }

//    public void scrollToElement(WebElement element, boolean toDown) {
//        boolean isElementFound = false;
//        while (!isElementFound) {
//            try {
//                isElementFound = element.isDisplayed();
//            } catch (Exception e) {
//                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//                Sequence scroll = new Sequence(finger, 1);
//                if(toDown){
//                    scroll.addAction(finger.createPointerMove(ofMillis(0),
//                            PointerInput.Origin.viewport(), 500, 1700)); // Start point
//                    scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//                    scroll.addAction(finger.createPointerMove(ofMillis(400), // Finger scrolling speed
//                            PointerInput.Origin.viewport(), 500, 400)); // End point
//                }else{
//                    scroll.addAction(finger.createPointerMove(ofMillis(0),
//                            PointerInput.Origin.viewport(), 500, 900)); // Start point
//                    scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//                    scroll.addAction(finger.createPointerMove(ofMillis(400), // Finger scrolling speed
//                            PointerInput.Origin.viewport(), 500, 1700)); // End point
//                }
//                scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//                appiumDriver.perform(List.of(scroll));
//            }
//        }
//    }

    public void scrollToElement(WebElement element, boolean toDown) {
        boolean isElementFound = false;
        Dimension screenSize = appiumDriver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();

        // Calculate the center of the screen
        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;
        while (!isElementFound) {
            try {
                isElementFound = element.isDisplayed();
            } catch (Exception e) {
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence scroll = new Sequence(finger, 1);
                if(toDown){
                    scroll.addAction(finger.createPointerMove(ofMillis(0),
                            PointerInput.Origin.viewport(), centerX, centerY)); // Start point
                    scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                    scroll.addAction(finger.createPointerMove(ofMillis(300), // Finger scrolling speed
                            PointerInput.Origin.viewport(), centerX, centerY - 600)); // End point
                }else{
                    scroll.addAction(finger.createPointerMove(ofMillis(0),
                            PointerInput.Origin.viewport(), centerX, centerY)); // Start point
                    scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                    scroll.addAction(finger.createPointerMove(ofMillis(300), // Finger scrolling speed
                            PointerInput.Origin.viewport(), centerX, centerY + 600)); // End point
                }
                scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                appiumDriver.perform(List.of(scroll));
            }
        }
    }

    public boolean scrollToElement(WebElement element, boolean toDown, int times) {

        boolean isElementFound = false;
        Dimension screenSize = appiumDriver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();

        // Calculate the center of the screen
        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;

        int counter = 1;

        while (!isElementFound) {

            if(counter <= times){
                try {
                    isElementFound = element.isDisplayed();
                } catch (Exception e) {
                    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                    Sequence scroll = new Sequence(finger, 1);
                    if(toDown){
                        scroll.addAction(finger.createPointerMove(ofMillis(0),
                                PointerInput.Origin.viewport(), centerX, centerY)); // Start point
                        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                        scroll.addAction(finger.createPointerMove(ofMillis(300), // Finger scrolling speed
                                PointerInput.Origin.viewport(), centerX, centerY - 200)); // End point
                    }else{
                        scroll.addAction(finger.createPointerMove(ofMillis(0),
                                PointerInput.Origin.viewport(), centerX, centerY)); // Start point
                        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                        scroll.addAction(finger.createPointerMove(ofMillis(300), // Finger scrolling speed
                                PointerInput.Origin.viewport(), centerX, centerY + 200)); // End point
                    }
                    scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                    appiumDriver.perform(List.of(scroll));
                }
            }else{
                break;
            }

            counter++;

        }

        return isElementFound;
    }

    // Scroll vertically by percentages
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = appiumDriver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage) / 100;
        int startPoint = (int) (size.height * startPercentage) / 100;
        int endPoint = (int) (size.height * endPercentage) / 100;
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);
        scroll.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), anchor, startPoint)); // Start point
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(ofMillis(400), // Finger scrolling speed
                PointerInput.Origin.viewport(), anchor, endPoint)); // End point
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        appiumDriver.perform(List.of(scroll));
    }

    // Scroll horizontally by percentages
    public void horizontalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = appiumDriver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage) / 100;
        int startPoint = (int) (size.width * startPercentage) / 100;
        int endPoint = (int) (size.width * endPercentage) / 100;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);
        scroll.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), startPoint, anchor)); // Start point
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(ofMillis(400), // Finger scrolling speed
                PointerInput.Origin.viewport(), endPoint, anchor)); // End point
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        appiumDriver.perform(List.of(scroll));

    }

    // Method to scroll horizontally by element location using W3C Actions
    public void horizontalScrollStartedFromElement(WebElement targetElement, boolean toRight) {
        Point location = targetElement.getLocation();
        int startX = location.getX();
        int startY = location.getY();
        int endX = !toRight ? startX + 1000 : startX - 1000; // Adjust the offset as needed

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), endX, startY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        appiumDriver.perform(Arrays.asList(scroll));
    }

    // Method to scroll vertically by element location using W3C Actions
    public void verticalScrollStartedFromElement(WebElement targetElement, boolean toDown) {
        Point location = targetElement.getLocation();
        int startX = location.getX();
        int startY = location.getY();
        int endY = !toDown ? startY + 1200 : startY - 1200; // Adjust the offset as needed

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        appiumDriver.perform(Arrays.asList(scroll));
    }

    public void doubleClick(WebElement element){

        Actions actions = new Actions(appiumDriver);

        if (element.isDisplayed() && element.isEnabled()) {
            actions.moveToElement(element)
                    .click()
                    .pause(Duration.ofMillis(100))  // Short pause between clicks
                    .click()
                    .build()
                    .perform();
        } else {
            System.out.println("Element is not interactable.");
        }

    }

    public void datePicker(String date){

        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        waitForElementToBeClickable(AppiumBy.accessibilityId("OK"));

        WebElement yearBtn = appiumDriver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '20')])[1]"));

        int currentYear = Integer.parseInt(yearBtn.getAttribute("content-desc").trim());

        if(currentYear != year){

            clickOn(yearBtn);
            hold(200);

            boolean isElementFound = false;
            Dimension screenSize = appiumDriver.manage().window().getSize();
            int screenWidth = screenSize.getWidth();
            int screenHeight = screenSize.getHeight();

            // Calculate the center of the screen
            int centerX = screenWidth / 2;
            int centerY = screenHeight / 2;
            while (!isElementFound) {
                try {
                    isElementFound = appiumDriver.findElement(AppiumBy.accessibilityId(String.valueOf(year))).isDisplayed();
                } catch (Exception e) {
                    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                    Sequence scroll = new Sequence(finger, 1);
                    scroll.addAction(finger.createPointerMove(ofMillis(0),
                            PointerInput.Origin.viewport(), centerX, centerY)); // Start point
                    scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                    scroll.addAction(finger.createPointerMove(ofMillis(400), // Finger scrolling speed
                            PointerInput.Origin.viewport(), centerX, centerY + 500)); // End point
                    scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                    appiumDriver.perform(List.of(scroll));
                }
            }

            clickOn(appiumDriver.findElement(AppiumBy.accessibilityId(String.valueOf(year))));
            hold(200);

        }

        WebElement leftRow = appiumDriver.findElement(AppiumBy.xpath("//android.widget.Button[1]"));
        WebElement rightRow = appiumDriver.findElement(AppiumBy.xpath("//android.widget.Button[2]"));

        String getCurrentMonth = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, ', ')]")).getAttribute("content-desc");

        int currentMonth = 1;

        if(getCurrentMonth.contains("Dec")){
            currentMonth = 12;
        }else if(getCurrentMonth.contains("Nov")){
            currentMonth = 11;
        }else if(getCurrentMonth.contains("Oct")){
            currentMonth = 10;
        }else if(getCurrentMonth.contains("Sep")){
            currentMonth = 9;
        }else if(getCurrentMonth.contains("Aug")){
            currentMonth = 8;
        }else if(getCurrentMonth.contains("Jul")){
            currentMonth = 7;
        }else if(getCurrentMonth.contains("Jun")){
            currentMonth = 6;
        }else if(getCurrentMonth.contains("May")){
            currentMonth = 5;
        }else if(getCurrentMonth.contains("Apr")){
            currentMonth = 4;
        }else if(getCurrentMonth.contains("Mar")){
            currentMonth = 3;
        }else if(getCurrentMonth.contains("Feb")){
            currentMonth = 2;
        }

        int between = currentMonth - month;

        if (between > 0) {
            for(int i = 0; i < between; i++){
                clickOn(leftRow, true);
            }

        }else if(between < 0){
            int backMonth = Math.abs(between);
            for(int i = 0; i < backMonth; i++){
                clickOn(rightRow, true);
            }
        }

        hold(300);
        clickOn(appiumDriver.findElement(AppiumBy.accessibilityId(String.valueOf(day))), true);
        hold(200);
        clickOn(appiumDriver.findElement(AppiumBy.accessibilityId("OK")), true);
        hold(500);

    }

    public void timePicker(String time){

        // Split the time and period
        String[] parts = time.split(" ");
        String timePart = parts[0];
        String period = parts[1];

        // Split the time part into hours and minutes
        String[] timeComponents = timePart.split(":");
        int hour = Integer.parseInt(timeComponents[0]);
        int minute = Integer.parseInt(timeComponents[1]);

        try{
            doubleClick(appiumDriver.findElement(AppiumBy.xpath("//android.widget.SeekBar[contains(@content-desc, 'Select hours')]")));
            hold(100);
            WebElement textHour = appiumDriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]"));
            WebElement textMinutes = appiumDriver.findElement(AppiumBy.xpath("//android.widget.EditText[2]"));
            textHour.clear();
            hold(100);
            setText(textHour, String.valueOf(hour));
            clickOn(textMinutes);
            textMinutes.clear();
            hold(100);
            setText(textMinutes, String.valueOf(minute));
        }catch (Exception e){
            System.out.println("Double Click Failure!... trying click on keyboard button");

            try{
                if(appiumDriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).isDisplayed()){
                    System.out.println("Keyboard is open, i will continue");

                    WebElement textHour = appiumDriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]"));
                    WebElement textMinutes = appiumDriver.findElement(AppiumBy.xpath("//android.widget.EditText[2]"));
                    clickOn(textHour);
                    textHour.clear();
                    hold(100);
                    setText(textHour, String.valueOf(hour));
                    clickOn(textMinutes);
                    textMinutes.clear();
                    hold(100);
                    setText(textMinutes, String.valueOf(minute));

                }
            }catch (Exception ex){
                System.out.println("Keyboard NOT open, i will open now");

                WebElement keyboardBtn = appiumDriver.findElement(AppiumBy.xpath("//android.view.View//android.widget.Button[1]"));
                clickOn(keyboardBtn);
                hold(100);
                WebElement textHour = appiumDriver.findElement(AppiumBy.xpath("//android.widget.EditText[1]"));
                WebElement textMinutes = appiumDriver.findElement(AppiumBy.xpath("//android.widget.EditText[2]"));
                clickOn(textHour);
                textHour.clear();
                hold(100);
                setText(textHour, String.valueOf(hour));
                clickOn(textMinutes);
                textMinutes.clear();
                hold(100);
                setText(textMinutes, String.valueOf(minute));
            }

        }

        clickOn(appiumDriver.findElement(AppiumBy.accessibilityId(period)));
        clickOn(appiumDriver.findElement(AppiumBy.accessibilityId("OK")));

    }

    public void waitLoadingElement(){
        new WebDriverWait(appiumDriver, Duration.ofSeconds(60))
                .until(ExpectedConditions.invisibilityOfElementLocated(AppiumBy.accessibilityId("LoadingElement")));
    }

    public void setClipboard(String text){
        Map<String, Object> params = new HashMap<>();
        params.put("content", text);
        appiumDriver.executeScript("mobile: setClipboard", params);
    }

    public String getClipboard(){
        return (String) appiumDriver.executeScript("mobile: getClipboard");
    }

    public void android_Back(){
        ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    public WebElement getBy(By locator){
        return appiumDriver.findElement(locator);
    }

    public boolean checkElementIfVisible(WebElement element){
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void closeKeyboard(){
        hold(200);
        if(iniPlatform.equalsIgnoreCase("Android")){
            try{
                ((AndroidDriver) appiumDriver).hideKeyboard();
            }catch (Exception ignored){
                ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
            }
        }else{
            try{
                ((IOSDriver) appiumDriver).hideKeyboard();
            }catch (Exception ignored){
                ((IOSDriver) appiumDriver).hideKeyboard("Done");
            }
        }
        hold(200);
    }

}
