package bases;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static bases.AppiumAndEmulatorControl.*;

public class BaseTest{

    private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    //AppiumServerControl appiumServerControl;

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver.get();
    }

    @BeforeSuite
    public void runEmulator() {

        // Start Appium server
        //startAppium();

        // Start Emulator
        //startEmulator();

    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"platform"})
    public void setPlatform(@Optional("Android") String platform){

//        appiumServerControl = new AppiumServerControl();
//        appiumServerControl.runAppium();

        //getAppiumDriver().setSetting("enforceXPath1",true);

        if(platform.equalsIgnoreCase("Android")){
            initializeDriver("Android");
        }else{
            initializeDriver("IOS");
        }

        // Setting timeouts
        //getAppiumDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        try{
            if(appiumDriver.get() != null) {
                //appiumDriver.get().quit();
                //appiumDriver.remove();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
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


}
