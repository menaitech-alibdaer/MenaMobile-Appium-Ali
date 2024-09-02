package utilities;

import io.appium.java_client.android.AndroidDriver;

import java.util.HashMap;
import java.util.Map;

import static bases.BaseTest.getAppiumDriver;
import static bases.BaseTest.iniPlatform;
import static utilities.WebHelper.hold;

public class MobileHelper {

    public static void terminateApp(){

        if(iniPlatform.equalsIgnoreCase("Android")){

            try {
                ((AndroidDriver) getAppiumDriver()).terminateApp("com.menaitech.mename");
            }catch (Exception e){
                Map<String, Object> params = new HashMap<>();
                params.put("appId", "com.menaitech.mename");
                getAppiumDriver().executeScript("mobile: terminateApp", params);
            }

        }else{
            Map<String, Object> params = new HashMap<>();
            params.put("bundleId", "com.menaitech.mename"); // Use bundleId for iOS apps
            getAppiumDriver().executeScript("mobile: terminateApp", params);
        }

        hold(800);
    }

    public static void launchApp(){
        if(iniPlatform.equalsIgnoreCase("Android")){

            try {
                ((AndroidDriver) getAppiumDriver()).activateApp("com.menaitech.mename");
            }catch (Exception e){
                Map<String, Object> params = new HashMap<>();
                params.put("appId", "com.menaitech.mename");
                getAppiumDriver().executeScript("mobile: activateApp", params);
            }

        }else{
            Map<String, Object> params = new HashMap<>();
            params.put("bundleId", "com.menaitech.mename"); // Use bundleId for iOS apps
            getAppiumDriver().executeScript("mobile: activateApp", params);
        }
        hold(10000);
    }

}
