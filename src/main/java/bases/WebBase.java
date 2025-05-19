package bases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.WebDriver;
import static utilities.WebHelper.hold;

public class WebBase {

    protected WebDriver driver;
    
    public WebBase() {
        this.driver = BaseTest.getDriver();
        PageFactory.initElements(BaseTest.getDriver(), this);
    }

    int secondWait = 50;
    WebElement iframeMemory = null;
    @FindBy(className = "select2-search__field")
    WebElement selectSearchField;
    @FindBy(id = "LoadingElement")
    WebElement loadingElement;
    private static String checkBranch = "branch";

    protected void clickOn(WebElement element){

        try {
            waitLoad();
            elementWait(element);
            waitElementClickable(element);
            //moveToElement(element);
            element.click();
            //hold(500);
        } catch (Exception e){
            try {
                //hold(500);
                waitLoad();
                waitLoadingScreen();
                System.out.println("Try Again by scrolling to element");
                elementWait(element);
                scrollToElement(element);
                moveToElement(element);
                waitElementClickable(element);
                element.click();
            } catch (Exception ee){
                System.out.println(ee);
            }
        }

    }

    protected void setText(WebElement element,String text){
        if(!text.isEmpty()){
            try {
                waitLoad();
                elementWait(element);
                //moveToElement(element);
                element.sendKeys(text);
            }catch (Exception e){
                hold(500);
                waitLoad();
                waitLoadingScreen();
                scrollToElement(element);
                moveToElement(element);
                element.sendKeys(text);
            }
        }
    }

    protected void setText(WebElement element,Keys key){
        try {
            waitLoad();
            elementWait(element);
            //moveToElement(element);
            element.sendKeys(key);
        } catch (Exception ee){
            try {
                hold(600);
                waitLoad();
                elementWait(element);
                moveToElement(element);
                element.click();
            }catch (Exception eee){
                System.out.println(eee);
            }
        }
    }

    protected void setText(WebElement element,String text,Keys key){
        if(!text.isEmpty()){
            try {
                waitLoad();
                elementWait(element);
                //moveToElement(element);
                element.sendKeys(text);
                hold(200);
                element.sendKeys(key);
            } catch (Exception ee){
                try {
                    hold(600);
                    waitLoad();
                    elementWait(element);
                    moveToElement(element);
                    element.click();
                }catch (Exception eee){
                    System.out.println(eee);
                }
            }
        }
    }

    protected void elementWait(WebElement element){
        try {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(secondWait / 2));
            wait1.until(ExpectedConditions.visibilityOfAllElements(element));
        }catch (Exception e){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait / 2));
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }

    protected void waitFrameAndWindow(){
        waitLoad();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("body_frame")));
    }

    protected void waitFrameAndWindow(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void elementWaitAdvanced(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected void ifElementClickable(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    protected void waitElementClickable(WebElement element){
        try {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(secondWait / 2));
            wait1.until(ExpectedConditions.visibilityOfAllElements(element));
        }catch (Exception e){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait / 2));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }
    protected void waitTextAppear(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
    protected void waitTextPresentInElementValue(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    protected void alertWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    protected boolean checkAlertIfPresent(){
        boolean foundAlert;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }

    protected void implicitWaitChanging(int millis){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(millis));
    }

    protected void waitAllElementIn(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected void waitLoadingScreenToVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(driver -> loadingElement.getCssValue("display").equals("block"));
    }
    protected void waitLoadingScreenToInvisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(driver -> loadingElement.getCssValue("display").equals("none"));
    }

    protected void selectOption(WebElement element, String text){

        if(!text.isEmpty()){
            try {
                waitElementClickable(element);
                clickOn(element);
                hold(100);
                selectSearchField.sendKeys(text);
                hold(100);
                selectSearchField.sendKeys(Keys.ENTER);
            } catch (ElementNotInteractableException | MoveTargetOutOfBoundsException e){
                waitLoad();
                waitLoadingScreen();
                //e.printStackTrace();
                waitElementClickable(element);
                scrollToElement(element);
                hold(500);
                clickOn(element);
                hold(100);
                selectSearchField.sendKeys(text);
                hold(100);
                selectSearchField.sendKeys(Keys.ENTER);
            } catch (Exception ee){
                ee.printStackTrace();
            }
        }

    }

    protected void selectOption(WebElement element, String text, Keys key){

        if(!text.isEmpty()){
            try {
                waitElementClickable(element);
                clickOn(element);
                hold(100);
                selectSearchField.sendKeys(text);
                hold(100);
                selectSearchField.sendKeys(key);
                hold(100);
                selectSearchField.sendKeys(Keys.ENTER);
            }catch(ElementNotInteractableException | MoveTargetOutOfBoundsException e){
                waitLoad();
                waitLoadingScreen();
                //e.printStackTrace();
                waitElementClickable(element);
                scrollToElement(element);
                hold(500);
                clickOn(element);
                hold(100);
                selectSearchField.sendKeys(text);
                hold(100);
                selectSearchField.sendKeys(key);
                hold(100);
                selectSearchField.sendKeys(Keys.ENTER);
            } catch (Exception ee){
                ee.printStackTrace();
            }
        }

    }

    protected void normalSelect(WebElement element, String text){

        if(!text.isEmpty()){
            try {
                elementWait(element);
                //moveToElement(element);
                Select select = new Select(element);
                select.selectByVisibleText(text);
                hold(100);
            }catch (Exception e){
                waitLoad();
                hold(600);
                moveToElement(element);
                elementWait(element);
                Select select = new Select(element);
                select.selectByVisibleText(text);
                hold(100);
            }
        }

    }

    protected void selectAllText(WebElement element){
        try {
            waitLoad();
        }catch (Exception ignored){}
        moveToElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();arguments[0].select();", element);
    }

    protected void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        hold(500);
    }

    protected void scrollToTopPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-5000)", "");
        hold(300);
    }

    protected void scrollToBottomPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)", "");
        hold(300);
    }

    public void goToFrame(WebElement element){

        iframeMemory = element;
        waitLoad();
//        waitLoadingScreen();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        //waitLoad();
        hold(1000);

        //elementWait(element);
        //getDriver().switchTo().frame(element);
        //hold(500);

    }

    public String uploadRandomImage(){

        String defaultImg = String.valueOf(new File(System.getProperty("user.dir")+ File.separator +"images"));
        File dir = new File(System.getProperty("user.dir")+ File.separator +"images");
        File[] files = dir.listFiles();
        Random rand = new Random();
        if (files != null) {
            return String.valueOf(files[rand.nextInt(files.length)]);
        } else {
            return defaultImg;
        }

    }

    public String uploadDocFile(){

        return System.getProperty("user.dir")+ File.separator +"files"+ File.separator +"testFileDoc.docx";
    }

    public String uploadBigSizeImg5MB(){

        return System.getProperty("user.dir")+ File.separator +"files"+ File.separator +"5MB_IMG.jpg";
    }

    public String uploadFileToTestWaf(){

        return System.getProperty("user.dir")+ File.separator +"files"+ File.separator +"testWaf.jpg";
    }

    public boolean checkElementIfNotAppear(List<WebElement> elements){
        boolean check;
        implicitWaitChanging(300);
        check = elements.isEmpty();
        implicitWaitChanging(20000);
        return check;
    }

    public int VerifyImage(WebElement element){

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(element.getDomAttribute("src"));

        try {
            HttpResponse response = client.execute(request);
            return response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    protected void elementWaitDisappear(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    protected void elementWaitDisappear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void goToWindow(){
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
            System.out.println(driver.switchTo().window(winHandle).getTitle());
        }
    }

    protected void backToParentWindow(String parentWindow){
        driver.switchTo().window(parentWindow);
    }

    protected void setTextByJavascript(WebElement element, String text){
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+text+"';", element);
        }catch (JavascriptException e){
            ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML='"+text+"';", element);
        }catch (Exception ignored){
            System.out.println("This String: '"+text+"' NOT set correctly!");
        }
    }

    public boolean longWaitElementAdvance(By by){
        WebDriverWait waitLong = new WebDriverWait(driver, Duration.ofSeconds(60));
        try {
            waitLong.until(ExpectedConditions.visibilityOfElementLocated(by));
            return waitLong.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        }catch (TimeoutException e){
            System.out.println("There is a problem, the element NOT Appear after wait 1 minute!" + " - "+e);
        }
        return false;
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
    public void refreshBodyFrame(){
        try {
            ((JavascriptExecutor) driver).executeScript("parent.document.getElementById('body_frame').contentWindow.location.reload();");
        }catch (JavascriptException e){
            ((JavascriptExecutor) driver).executeScript("parent.parent.parent.parent.parent.document.getElementById('body_frame').contentWindow.location.reload();");
        }
    }

    public void closeIFrame(){
        driver.switchTo().defaultContent();
        iframeMemory = null;
    }
    public void backToParentIFrame(){
        driver.switchTo().parentFrame();
    }

    public boolean checkElementIfPresent(By locatorKey){
        try {
            implicitWaitChanging(3000);
            driver.findElement(locatorKey);
            implicitWaitChanging(10000);
            return true;
        }catch(NoSuchElementException e){
            implicitWaitChanging(10000);
            return false;
        }
    }

    public boolean checkElementIfPresent(By locatorKey, boolean inFrame){
        if(inFrame){
            goToFrame(driver.findElement(By.id("body_frame")));
            waitLoad();
        }
        try {
            implicitWaitChanging(3000);
            driver.findElement(locatorKey);
            implicitWaitChanging(10000);
            return true;
        }catch(NoSuchElementException e){
            implicitWaitChanging(10000);
            return false;
        }
    }

    public boolean checkElementIfPresent(WebElement element, boolean inFrame){
        if(inFrame){
            goToFrame(driver.findElement(By.id("body_frame")));
            waitLoad();
        }
        boolean check;
        try {
            implicitWaitChanging(3000);
            check =  element.isDisplayed();
            implicitWaitChanging(10000);
            return check;
        }catch(NoSuchElementException e){
            check = false;
            implicitWaitChanging(10000);
            return check;
        }
    }

    public boolean checkElementIfPresent(WebElement element){
        boolean check;
        try {
            implicitWaitChanging(3000);
            check =  element.isDisplayed();
            implicitWaitChanging(10000);
            return check;
        }catch(NoSuchElementException e){
            check = false;
            implicitWaitChanging(10000);
            return check;
        }
    }

    public void goToURL(String url){
        driver.navigate().to(url);
        hold(500);
    }

    public static String employeeCodeGenerator(){
        return RandomStringUtils.random(4, true, false).toLowerCase() + RandomStringUtils.random(5, false, true);
    }

    public static void setBranch(String branchCode){
        checkBranch = branchCode;
    }
    public static String getBranch(){
        return checkBranch;
    }

    public void resizeWindow(int width, int height){
        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(dimension);
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    protected void waitLoad(){
        new WebDriverWait(driver, Duration.ofSeconds(secondWait))
                .until(driver -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    protected void waitForElementToBeDisabled(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until((ExpectedCondition<Boolean>) d -> !element.isEnabled());
    }

    public void waitLoadingScreen() {

        try {
            String display = loadingElement.getCssValue("display");
            if ("none".equals(display)) {
            } else {
                System.out.println("Loading Element is visible (display: " + display + ").");
                hold(1000);
                waitLoadingScreenToInvisible();
            }
        } catch (Exception ignored) {
        }

    }

    protected void iframeReset(){
        //System.out.println("Reset iframe(close and reopen)!");
        if(iframeMemory == null){
            closeIFrame();
        }else{
            //closeIFrame();
            driver.switchTo().defaultContent();
            hold(500);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeMemory));
        }
    }

    protected void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }



}
