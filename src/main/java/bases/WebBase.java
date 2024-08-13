package bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;

import static utilities.MssqlConnect.*;

import static utilities.WebHelper.hold;
import static utilities.VersionGetter.*;

public class WebBase {

    public SoftAssert softAssert = null;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public void setDriver(WebDriver drivers) {
        driver.set(drivers);
    }
    public WebDriver getDriver() {
        return driver.get();
    }
    public WebBase() {
        PageFactory.initElements(getDriver(), this);
    }
    int secondWait = 50;
    @FindBy(className = "select2-search__field")
    WebElement selectSearchField;
    public String menaMeURL = null;
    public String versionURL = null;
    private static String checkBranch = "branch";

    @BeforeClass(alwaysRun = true)
    @Parameters({"version", "lite"})
    public void setVersion(@Optional("JUL") String version, @Optional("false") boolean lite){

        if(version.equalsIgnoreCase("AUG")){
            versionSetter("AUG");
        }else if(version.equalsIgnoreCase("OCT")){
            versionSetter("OCT");
        }else if(version.equalsIgnoreCase("JUL")){
            versionSetter("JUL");
        }

        liteSetter(lite);

    }
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"}) //// to check value sent from xml file ///
    public void startDriver(@Optional("chrome") String browser){ /// @Optional if the @Parameters not found, like else ///

        setDriver(driver.get());
        //////// To solve the cache problem for the assertion /////////
        softAssert = null;
        softAssert = new SoftAssert();
        ChromeOptions options = new ChromeOptions();
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        EdgeOptions edgeOptions = new EdgeOptions();

        if(browser.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();
            setDriver(new FirefoxDriver());

        } else if (browser.equalsIgnoreCase("edge")){

            WebDriverManager.edgedriver().setup();
            setDriver(new EdgeDriver());

        } else if (browser.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--start-maximized");
            //options.addArguments("--incognito");
            options.addArguments("--remote-allow-origins=*");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
//            DesiredCapabilities dc = new DesiredCapabilities();
//            dc.setCapability(ChromeOptions.CAPABILITY, options);
//            options.merge(dc);
            setDriver(new ChromeDriver(options));

        } else if (browser.equalsIgnoreCase("chrome_headless")){

            WebDriverManager.chromedriver().setup();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");
            options.addArguments("--headless", "--window-size=1920,1080");
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            setDriver(new ChromeDriver(options));

        } else if (browser.equalsIgnoreCase("firefox_headless")){

            WebDriverManager.firefoxdriver().setup();

            firefoxBinary.addCommandLineOptions("--headless");
            firefoxBinary.addCommandLineOptions("--start-maximized");
            firefoxOptions.setBinary(firefoxBinary);
            setDriver(new FirefoxDriver(firefoxOptions));

        } else if (browser.equalsIgnoreCase("edge_headless")){

            WebDriverManager.edgedriver().setup();
            edgeOptions.addArguments("--headless", "--window-size=1920,1080");
            setDriver(new EdgeDriver(edgeOptions));

        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        browserSetter(browser);
        urlSetter(versionGetter());
        versionURL = urlGetter();
        menaMeURL = urlMenaMeGetter();
        //getDriver().get(urlGetter());
        getDriver().get("https://qc.menaitech.com/MenaS01_07_2024/application/hrms/");
        //getDriver().get("https://qc.menaitech.com/MenaS01_08_2022_Patch4/application/hrms/");

    }
    @AfterMethod(alwaysRun = true)
    public void endTestCase(){

        ////////// To Rest Setup By Queries //////////
        queryRestSetup();
        ////////// To Rest Setup By Queries //////////

        try {
            softAssert = null;
            if(getDriver() != null) {
                getDriver().quit();
            }
        }catch (Exception e){
            softAssert = null; //// optional ///
            e.printStackTrace();
        }finally {
            softAssert = null; //// optional ///
        }
    }

    protected void clickOn(WebElement element){

        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
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
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitFrameAndWindow(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("body_frame")));
    }

    protected void elementWaitAdvanced(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected void ifElementClickable(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    protected void waitElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void waitTextAppear(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(180));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
    protected void waitTextPresentInElementValue(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    protected void alertWait(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    protected boolean checkAlertIfPresent(){
        boolean foundAlert;
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }

    protected void implicitWaitChanging(int millis){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(millis));
    }

    protected void selectOption(WebElement element, String text){

        if(!text.isEmpty()){
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
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
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
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
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].focus();arguments[0].select();", element);
    }

    protected void scrollToElement(WebElement element){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
        hold(500);
    }

    protected void scrollToTopPage(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,-5000)", "");
        hold(300);
    }

    protected void scrollToBottomPage(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,5000)", "");
        hold(300);
    }

    public void goToFrame(WebElement element){

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));

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
        HttpGet request = new HttpGet(element.getAttribute("src"));

        try {
            HttpResponse response = client.execute(request);
            return response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    protected void elementWaitDisappear(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    protected void elementWaitDisappear(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(secondWait));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void goToWindow(){
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
            System.out.println(getDriver().switchTo().window(winHandle).getTitle());
        }
    }

    protected void backToParentWindow(String parentWindow){
        getDriver().switchTo().window(parentWindow);
    }

    protected void setTextByJavascript(WebElement element, String text){
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='"+text+"';", element);
        }catch (JavascriptException e){
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].innerHTML='"+text+"';", element);
        }catch (Exception ignored){
            System.out.println("This String: '"+text+"' NOT set correctly!");
        }
    }

    public boolean longWaitElementAdvance(By by){
        WebDriverWait waitLong = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        try {
            waitLong.until(ExpectedConditions.visibilityOfElementLocated(by));
            return waitLong.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        }catch (TimeoutException e){
            System.out.println("There is a problem, the element NOT Appear after wait 1 minute!" + " - "+e);
        }
        return false;
    }
    public void refreshPage(){
        getDriver().navigate().refresh();
    }
    public void refreshBodyFrame(){
        try {
            ((JavascriptExecutor) getDriver()).executeScript("parent.document.getElementById('body_frame').contentWindow.location.reload();");
        }catch (JavascriptException e){
            ((JavascriptExecutor) getDriver()).executeScript("parent.parent.parent.parent.parent.document.getElementById('body_frame').contentWindow.location.reload();");
        }
    }

    public void closeIFrame(){
        getDriver().switchTo().defaultContent();
    }
    public void backToParentIFrame(){
        getDriver().switchTo().parentFrame();
    }

    public boolean checkElementIfPresent(By locatorKey){
        try {
            implicitWaitChanging(3000);
            getDriver().findElement(locatorKey);
            implicitWaitChanging(10000);
            return true;
        }catch(NoSuchElementException e){
            implicitWaitChanging(10000);
            return false;
        }
    }

    public boolean checkElementIfPresent(By locatorKey, boolean inFrame){
        if(inFrame){
            goToFrame(getDriver().findElement(By.id("body_frame")));
        }
        try {
            implicitWaitChanging(3000);
            getDriver().findElement(locatorKey);
            implicitWaitChanging(10000);
            return true;
        }catch(NoSuchElementException e){
            implicitWaitChanging(10000);
            return false;
        }
    }

    public boolean checkElementIfPresent(WebElement element, boolean inFrame){
        if(inFrame){
            goToFrame(getDriver().findElement(By.id("body_frame")));
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
        getDriver().navigate().to(url);
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
        getDriver().manage().window().setSize(dimension);
    }

    public void maximizeWindow(){
        getDriver().manage().window().maximize();
    }

}
