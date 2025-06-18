package utilities;

import io.appium.java_client.android.AndroidDriver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static bases.BaseTest.getAppiumDriver;
import static bases.BaseTest.iniPlatform;
import static utilities.Devices.*;
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

    public static void terminateAppAndroid(){
        try {
            ((AndroidDriver) getAppiumDriver()).terminateApp(appActivity_MenaMEPro);
        }catch (Exception e){
            ((AndroidDriver) getAppiumDriver()).terminateApp(appActivity_MenaME);
        }
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

    public static String encryptSHA1(String input) {
        try {
            // Get an instance of the SHA-1 MessageDigest
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Update the MessageDigest with the input byte array
            md.update(input.getBytes());

            // Get the hash's byte array
            byte[] byteData = md.digest();

            // Convert the byte array into hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : byteData) {
                sb.append(String.format("%02x", b));
            }

            // Return the resulting hash as a hex string
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String currentDate_mobile(){
        DateTimeFormatter currentDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.now();
        return date.format(currentDateFormatter);
    }

    public static String currentDate_mobile_new(){
        DateTimeFormatter currentDateFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.now();
        return date.format(currentDateFormatter);
    }

    public static String currentTime(){
        LocalTime currentTime = LocalTime.now();
        // Define a formatter to format the time as "h:mm a"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        // Format the time
        return currentTime.format(formatter);
    }

    public static String backTime(String currentTime, int numberOfBackHour){

        // Define a formatter for parsing and formatting the time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

        // Parse the time string to a LocalTime object
        LocalTime time = LocalTime.parse(currentTime, formatter);

        // Subtract one hour from the parsed time
        LocalTime timeMinusHour = time.minusHours(numberOfBackHour);

        // Format the new time back to a string
        return timeMinusHour.format(formatter);
    }

    public static String PlusTime(String currentTime, int numberOfPlusHour){

        // Define a formatter for parsing and formatting the time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

        // Parse the time string to a LocalTime object
        LocalTime time = LocalTime.parse(currentTime, formatter);

        // Subtract one hour from the parsed time
        LocalTime timePlusHour = time.plusHours(numberOfPlusHour);

        // Format the new time back to a string
        return timePlusHour.format(formatter);
    }

}
