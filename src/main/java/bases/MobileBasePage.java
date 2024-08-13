package bases;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static java.time.Duration.ofMillis;

public class MobileBasePage {

    protected AppiumDriver appiumDriver;
    int second = 20;

    public MobileBasePage() {
        this.appiumDriver = MobileBaseTest.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void waitForElementToBeVisible(By locator){
        new WebDriverWait(appiumDriver, Duration.ofSeconds(second))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
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

    public void clickOn(WebElement element){
        element.click();
        hold(100);
    }

    public void setText(WebElement element, String text){
        element.sendKeys(text);
        hold(100);
    }

    public void hold(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
                leftRow.click();
            }

        }else if(between < 0){
            int backMonth = Math.abs(between);
            for(int i = 0; i < backMonth; i++){
                rightRow.click();
            }
        }

        hold(300);
        clickOn(appiumDriver.findElement(AppiumBy.accessibilityId(String.valueOf(day))));
        hold(200);
        clickOn(appiumDriver.findElement(AppiumBy.accessibilityId("OK")));
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

}
