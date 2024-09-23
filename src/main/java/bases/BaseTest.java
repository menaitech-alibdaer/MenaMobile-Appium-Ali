package bases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.TestDataReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static utilities.Colors.*;
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

    public  static String iniBrowser = null;
    public static String iniPlatform = null;
    public TestType testType = null;

    protected TestDataReader data;

    @BeforeClass(alwaysRun = true)
    @Parameters({"version", "lite"})
    public void setVersion(@Optional("AUG") String version, @Optional("false") boolean lite){

        if(version.equalsIgnoreCase("AUG")){
            versionSetter("AUG");
        }else if(version.equalsIgnoreCase("OCT")){
            versionSetter("OCT");
        }else if(version.equalsIgnoreCase("JUL")){
            versionSetter("JUL");
        }

        urlSetter(versionGetter());
        versionURL = urlGetter();
        menaMeURL = urlMenaMeGetter();

        liteSetter(lite);

    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"platform", "iniBrowser"})
    public void setPlatform(@Optional("Android") String platform, @Optional("chrome") String browser){

        data = new TestDataReader("data.json");

        iniBrowser = browser;
        iniPlatform = platform;

        softAssert = null;
        softAssert = new SoftAssert();

    }

    @AfterMethod(alwaysRun = true)
    public void driverQuit(){

        try{
            if(appiumDriver.get() != null) {
                appiumDriver.get().quit();
                appiumDriver.remove();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            softAssert = null;
            if(getDriver() != null) {
                getDriver().quit();
                driver.remove();
            }
        }catch (Exception e){
            softAssert = null; //// optional ///
            e.printStackTrace();
        }finally{
            softAssert = null; //// optional ///
        }

    }

    public enum TestType{
        WEB,
        MOBILE,
    }

    ////////////////////////////////////////////////////

    public void initializeAppiumDriver(String platform){
        DesiredCapabilities caps = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("Android")) {

            //File app = new File("src/main/apps/app.apk");

            //caps.setCapability("deviceName", "Ali");
            //caps.setCapability("udid", "emulator-5554");
            caps.setCapability("deviceName", "Appium Device 1");
            caps.setCapability("udid", "192.168.56.104:5555");
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "13");
            caps.setCapability("automationName", "UiAutomator2");
            //caps.setCapability("app", "app.apk");
            caps.setCapability("appPackage", "com.menaitech.mename");
            caps.setCapability("appActivity", "com.menaitech.mename.MainActivity");
            caps.setCapability("noReset", false);
            //caps.setCapability("fullReset", true);
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

    public void webInitialize(){

        testType = TestType.WEB;

        System.out.println(ANSI_GREEN + "Web Driver Work Now!" + ANSI_RESET);

        setDriver(getDriver());
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
        getDriver().get(urlGetter());
        //getDriver().get("https://qc.menaitech.com/MenaS01_07_2024/application/hrms/");

    }

    public void mobileInitialize(){

        testType = TestType.MOBILE;

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
