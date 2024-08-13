package bases;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static utilities.VersionGetter.*;

public class BaseTest {

    private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    //AppiumServerControl appiumServerControl;

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver.get();
    }

    public SoftAssert softAssert = null;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public void setDriver(WebDriver drivers) {
        driver.set(drivers);
    }
    public WebDriver getDriver() {
        return driver.get();
    }
    public BaseTest() {
        PageFactory.initElements(getDriver(), this);
    }
    int secondWait = 50;
    @FindBy(className = "select2-search__field")
    WebElement selectSearchField;
    public String menaMeURL = null;
    public String versionURL = null;
    private static String checkBranch = "branch";

    private String iniBrowser = null;
    private String iniPlatform = null;
    private TestType testType = null;


    @BeforeMethod(alwaysRun = true)
    @Parameters({"platform", "iniBrowser"})
    public void setPlatform(@Optional("Android") String platform, @Optional("chrome") String browser){

        iniBrowser = browser;
        iniPlatform = platform;

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

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

        try{
            if(appiumDriver.get() != null) {
                appiumDriver.get().quit();
                appiumDriver.remove();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private enum TestType{
        WEB,
        MOBILE,
    }

    ////////////////////////////////////////////////////

    public void initializeDriver(String platform){
        DesiredCapabilities caps = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("Android")) {

            //File app = new File("src/main/apps/app-release.apk");

            caps.setCapability("deviceName", "Ali");
            caps.setCapability("udid", "emulator-5554");
            //caps.setCapability("deviceName", "Galaxy S23");
            //caps.setCapability("udid", "192.168.56.101:5555");
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "14");
            caps.setCapability("automationName", "UiAutomator2");
            //caps.setCapability("app", app.getAbsoluteFile());
            caps.setCapability("appPackage", "com.menaitech.mename");
            caps.setCapability("appActivity", "com.menaitech.mename.MainActivity");
            //caps.setCapability("noReset", "true");
            //caps.setCapability("newCommandTimeout", 2);
            caps.setCapability("enforceXPath1", true);
            caps.setCapability("autoGrantPermissions", true);
//            caps.setCapability("disableWindowAnimation", true);
//            caps.setCapability("skipDeviceInitialization", true);
//            caps.setCapability("skipServerInstallation", true);
//            caps.setCapability("ignoreUnimportantViews", true);

            URL url = null;
            try {
                url = new URL("http://127.0.0.1:4723");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            AppiumDriver driverInstance = new AppiumDriver(url, caps);
            appiumDriver.set(driverInstance);

        } else if (platform.equalsIgnoreCase("iOS")) {

            caps.setCapability("deviceName", "Ali-IOS");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("app", "/path/to/your/app.app");
            URL url = null;
            try {
                url = new URL("http://127.0.0.1:4723");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            AppiumDriver driverInstance = new AppiumDriver(url, caps);
            appiumDriver.set(driverInstance);

        }
    }

    public void webDriverRunner(){

        testType = TestType.WEB;

        setDriver(driver.get());
        ChromeOptions options = new ChromeOptions();

        if (iniBrowser.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            setDriver(new ChromeDriver(options));

        } else if (iniBrowser.equalsIgnoreCase("chrome_headless")){

            WebDriverManager.chromedriver().setup();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");
            options.addArguments("--headless", "--window-size=1920,1080");
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            setDriver(new ChromeDriver(options));

        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        browserSetter(iniBrowser);
        urlSetter(versionGetter());
        versionURL = urlGetter();
        menaMeURL = urlMenaMeGetter();
        //getDriver().get(urlGetter());
        getDriver().get("https://qc.menaitech.com/MenaS01_07_2024/application/hrms/");

    }

    public void mobileDriverRunner(){

        testType = TestType.MOBILE;

        if(iniPlatform.equalsIgnoreCase("Android")){
            initializeDriver("Android");
        }else{
            initializeDriver("IOS");
        }

    }

}
