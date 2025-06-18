package bases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.asserts.SoftAssert;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;

import static bases.ApiBase.fastTokenCreator;
import static utilities.Colors.*;
import static utilities.Devices.*;
import static utilities.VersionGetter.*;

public class BaseTest {

    private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver.get();
    }

    public void setDriver(WebDriver drivers) {
        driver.set(drivers);
    }
    public static WebDriver getDriver() {
        return driver.get();
    }

    public SoftAssert softAssert = null;
    public String menaMeURL = null;
    public String versionURL = null;
    //public boolean api = false;

    public  static String iniBrowser = null;
    public static String iniPlatform = null;
    public TestType testType = null;
    public static MobileVersion mobileVersion = null;

    //protected TestDataReader data;

    @BeforeClass(alwaysRun = true)
    @Parameters({"version", "appVersion", "lite"})
    public void setVersion(@Optional("Revamp") String version, @Optional("MenaMEPro") String appVersion, @Optional("false") boolean lite){

        if(version.equalsIgnoreCase("AUG")){
            versionSetter("AUG");
        }else if(version.equalsIgnoreCase("OCT")){
            versionSetter("OCT");
        }else if(version.equalsIgnoreCase("JUL")){
            versionSetter("JUL");
        }else if(version.equalsIgnoreCase("Revamp")){
            versionSetter("Revamp");
        }

        if(version.equalsIgnoreCase("Revamp")){
            testType = TestType.API;
        }else{
            testType = TestType.WEB;
            urlSetter(versionGetter());
            versionURL = urlGetter();
            menaMeURL = urlMenaMeGetter();
            liteSetter(lite);
        }

        if(appVersion.equalsIgnoreCase("MenaMEPro")){
            mobileVersion = MobileVersion.MenaMEPro;
        }else{
            mobileVersion = MobileVersion.MenaME;
        }

    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"platform", "browser"})
    public void setPlatform(@Optional("Android") String platform, @Optional("chrome") String browser){

        //data = new TestDataReader("data.json");
        iniBrowser = browser;
        iniPlatform = platform;

        if(testType == TestType.API){
            fastTokenCreator();
        }

        softAssert = null;
        softAssert = new SoftAssert();

    }

    @AfterMethod(alwaysRun = true)
    public void driverQuit(){

        try{
            softAssert = null;
            if(appiumDriver.get() != null) {
                System.gc();
                appiumDriver.get().quit();
            }
            appiumDriver.remove();
        }catch (Exception e){
            softAssert = null;
            e.printStackTrace();
        }

        if(testType == TestType.WEB){
            try {
                softAssert = null;
                if(getDriver() != null) {
                    getDriver().quit();
                }
                driver.remove();
            }catch (Exception e){
                softAssert = null; //// optional ///
                e.printStackTrace();
            }
        }

    }

    public enum TestType{
        WEB,
        API,
    }

    public enum MobileVersion{
        MenaME,
        MenaMEPro
    }

    ////////////////////////////////////////////////////

    public void initializeAppiumDriver(String platform){

        DesiredCapabilities caps = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("Android")) {

            //File app = new File("src/main/apps/app.apk");

//            caps.setCapability("deviceName", huaweiY7a_name);
//            caps.setCapability("udid", huaweiY7a_udid);
//            caps.setCapability("platformVersion", huaweiY7a_AndroidVersion);

//            caps.setCapability("deviceName", galaxyA23_name);
//            caps.setCapability("udid", galaxyA23_udid);
//            caps.setCapability("platformVersion", galaxyA23_AndroidVersion);

            caps.setCapability("deviceName", emulator_1);
            caps.setCapability("udid", emulator_1_udid);
            caps.setCapability("platformVersion", emulator_1_AndroidVersion);

            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            //caps.setCapability("app", "app.apk");
            caps.setCapability("appPackage", appPackage_MenaMEPro);
            caps.setCapability("appActivity", appActivity_MenaMEPro);
            caps.setCapability("noReset", false);
            caps.setCapability("newCommandTimeout", 300);
            caps.setCapability("enforceXPath1", true);
            caps.setCapability("autoGrantPermissions", true);
            caps.setCapability("disableWindowAnimation", true);
            caps.setCapability("ignoreUnimportantViews", true);
            caps.setCapability("adbShell", true);
            caps.setCapability("adb_shell", true);
            caps.setCapability("appium:allowInsecure", "adb_shell");
            //caps.setCapability("fullReset", true);
            //caps.setCapability("skipDeviceInitialization", true);
            //caps.setCapability("skipServerInstallation", true);

            URL url = null;
            try {
                url = new URL("http://127.0.0.1:4723");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            AppiumDriver driverInstance = new AndroidDriver(url, caps);
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
            AppiumDriver driverInstance = new IOSDriver(url, caps);
            appiumDriver.set(driverInstance);

        }
    }

    public void systemInitialize(){

        if(testType == TestType.API){
            System.out.println(ANSI_GREEN + "API Work Now!" + ANSI_RESET);
        }else{
            System.out.println(ANSI_GREEN + "Web Driver Work Now!" + ANSI_RESET);

            setDriver(getDriver());
            ChromeOptions options = new ChromeOptions();
            EdgeOptions options_e = new EdgeOptions();
            FirefoxOptions  options_f = new FirefoxOptions();

            if (iniBrowser.equalsIgnoreCase("chrome")){

                WebDriverManager.chromedriver().setup();
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("--start-maximized");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--remote-allow-origins=*");

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                setDriver(new ChromeDriver(options));

            } else if (iniBrowser.equalsIgnoreCase("chrome_headless")){

                WebDriverManager.chromedriver().setup();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-maximized");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--headless", "--window-size=1920,1080");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                setDriver(new ChromeDriver(options));

            } else if (iniBrowser.equalsIgnoreCase("edge")) {

                WebDriverManager.edgedriver().setup();
                options_e.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options_e.setExperimentalOption("useAutomationExtension", false);
                options_e.addArguments("--start-maximized");

                // Set preferences similar to Chrome if applicable (optional, Edge has different preferences APIs)
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options_e.setExperimentalOption("prefs", prefs);
                options_e.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                setDriver(new EdgeDriver(options_e));

            } else if (iniBrowser.equalsIgnoreCase("edge_headless")) {

                WebDriverManager.edgedriver().setup();
                options_e.addArguments("--start-maximized");
                options_e.addArguments("--headless", "--window-size=1920,1080");

                // Set preferences (optional)
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options_e.setExperimentalOption("prefs", prefs);
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                setDriver(new EdgeDriver(options_e));

            } else if (iniBrowser.equalsIgnoreCase("firefox")) {

                WebDriverManager.firefoxdriver().setup();
                options_f.addPreference("dom.webnotifications.enabled", false);  // Disable notifications
                options_f.addPreference("geo.enabled", false);  // Disable geolocation
                options_f.addPreference("geo.prompt.testing", false);
                options_f.addPreference("geo.prompt.testing.allow", false);
                options_f.addPreference("privacy.trackingprotection.enabled", false);
                options_f.addArguments("-private");
                options_f.addPreference("dom.popup_maximum", 0);
                options_f.addPreference("dom.disable_open_during_load", false);
                setDriver(new FirefoxDriver(options_f));
                getDriver().manage().window().maximize();

            }

            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

            browserSetter(iniBrowser);
            urlSetter(versionGetter());
            versionURL = urlGetter();
            menaMeURL = urlMenaMeGetter();
            getDriver().get(urlGetter());
            //getDriver().get("https://qc.menaitech.com/MenaS01_07_2024/application/hrms/");

        }

    }

    public void mobileInitialize(){

        urlSetter(versionGetter());
        versionURL = urlGetter();
        menaMeURL = urlMenaMeGetter();

        System.out.println(ANSI_BLUE + "Mobile Driver Work Now!" + ANSI_RESET);

//        startEmulatorIfNotRunning();
//        startAppiumIfNotRunning();

        if(iniPlatform.equalsIgnoreCase("Android")){
            initializeAppiumDriver("Android");
        }else{
            initializeAppiumDriver("IOS");
        }

    }

    public WebElement getBy(By locator){
        return getAppiumDriver().findElement(locator);
    }


    /////////////////// Multi-thread Method ////////////////////

//    public void initializeAppiumDriver(String platform){
//        DesiredCapabilities caps = new DesiredCapabilities();
//
//        if (platform.equalsIgnoreCase("Android")) {
//
//            if (Thread.currentThread().getId() % 2 == 0) {
//
//                //File app = new File("src/main/apps/app-release.apk");
//
//                //caps.setCapability("deviceName", "Ali");
//                //caps.setCapability("udid", "emulator-5554");
//                caps.setCapability("deviceName", "Galaxy S23");
//                caps.setCapability("udid", "192.168.56.101:5555");
//                caps.setCapability("platformName", "Android");
//                caps.setCapability("platformVersion", "13");
//                caps.setCapability("automationName", "UiAutomator2");
//                //caps.setCapability("app", app.getAbsoluteFile());
//                caps.setCapability("appPackage", "com.menaitech.mename");
//                caps.setCapability("appActivity", "com.menaitech.mename.MainActivity");
//                //caps.setCapability("noReset", "true");
//                //caps.setCapability("newCommandTimeout", 2);
//                caps.setCapability("enforceXPath1", true);
//                caps.setCapability("autoGrantPermissions", true);
////            caps.setCapability("disableWindowAnimation", true);
////            caps.setCapability("skipDeviceInitialization", true);
////            caps.setCapability("skipServerInstallation", true);
////            caps.setCapability("ignoreUnimportantViews", true);
//
//                URL url = null;
//                try {
//                    url = new URL("http://127.0.0.1:4723");
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }
//                AppiumDriver driverInstance = new AppiumDriver(url, caps);
//                appiumDriver.set(driverInstance);
//
//            } else {
//
//                caps.setCapability("deviceName", "Second Device");
//                caps.setCapability("udid", "192.168.56.103:5555");
//                caps.setCapability("platformName", "Android");
//                caps.setCapability("platformVersion", "13");
//                caps.setCapability("automationName", "UiAutomator2");
//                caps.setCapability("appPackage", "com.menaitech.mename");
//                caps.setCapability("appActivity", "com.menaitech.mename.MainActivity");
//                caps.setCapability("enforceXPath1", true);
//                caps.setCapability("autoGrantPermissions", true);
//
//                URL url = null;
//                try {
//                    url = new URL("http://127.0.0.1:4725");
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }
//                AppiumDriver driverInstance = new AppiumDriver(url, caps);
//                appiumDriver.set(driverInstance);
//
//            }
//
//        } else if (platform.equalsIgnoreCase("iOS")) {
//
//            caps.setCapability("deviceName", "Ali-IOS");
//            caps.setCapability("platformName", "iOS");
//            caps.setCapability("automationName", "UiAutomator2");
//            caps.setCapability("app", "/path/to/your/app.app");
//            URL url = null;
//            try {
//                url = new URL("http://127.0.0.1:4723/wd/hub");
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }
//            AppiumDriver driverInstance = new AppiumDriver(url, caps);
//            appiumDriver.set(driverInstance);
//
//        }
//    }

    /////////////////// Multi-thread Method ////////////////////

    //// to RUN Server Multi Threading /// run in the CMD
    //// appium -p 4723
    //// appium -p 4725

}
