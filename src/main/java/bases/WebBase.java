package bases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
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
    @FindBy(className = "select2-search__field")
    WebElement selectSearchField;
    private static String checkBranch = "branch";


    protected void clickOn(WebElement element){

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (ElementNotInteractableException | MoveTargetOutOfBoundsException e){
            try {
                System.out.println("Try Again by scrolling to element");
                scrollToElement(element);
                element.click();
            } catch (ElementClickInterceptedException ee){
                System.out.println(ee);
            }
        }

    }

    protected void setText(WebElement element,String text){
        if(!text.isEmpty()){
            try {
                elementWait(element);
                element.sendKeys(text);
            }catch (ElementNotInteractableException | MoveTargetOutOfBoundsException e){
                scrollToElement(element);
                element.sendKeys(text);
            }
        }
    }

    protected void setText(WebElement element,Keys key){
        try {
            elementWait(element);
            element.sendKeys(key);
        }catch (ElementNotInteractableException | MoveTargetOutOfBoundsException e){
            scrollToElement(element);
            element.sendKeys(key);
        }
    }

    protected void setText(WebElement element,String text,Keys key){
        if(!text.isEmpty()){
            try {
                elementWait(element);
                element.sendKeys(text);
                hold(200);
                element.sendKeys(key);
            }catch (ElementNotInteractableException | MoveTargetOutOfBoundsException e){
                scrollToElement(element);
                element.sendKeys(text);
                hold(200);
                element.sendKeys(key);
            }
        }
    }

    protected void elementWait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitFrameAndWindow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("body_frame")));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.elementToBeClickable(element));
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

    protected void selectOption(WebElement element, String text){

        if(!text.isEmpty()){
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                hold(100);
                selectSearchField.sendKeys(text);
                hold(100);
                selectSearchField.sendKeys(Keys.ENTER);
            } catch (ElementNotInteractableException | MoveTargetOutOfBoundsException e){
                //e.printStackTrace();
                scrollToElement(element);
                hold(500);
                element.click();
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
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                hold(100);
                selectSearchField.sendKeys(text);
                hold(100);
                selectSearchField.sendKeys(key);
                hold(100);
                selectSearchField.sendKeys(Keys.ENTER);
            }catch(ElementNotInteractableException | MoveTargetOutOfBoundsException e){
                //e.printStackTrace();
                scrollToElement(element);
                hold(500);
                element.click();
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
            elementWait(element);
            Select select = new Select(element);
            select.selectByVisibleText(text);
            hold(100);
        }

    }

    protected void selectAllText(WebElement element){
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));

        //elementWait(element);
        //driver.switchTo().frame(element);
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
        HttpGet request = new HttpGet(element.getAttribute("src"));

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

}
