package mobileBackend;

import bases.MobileBasePage;
import com.beust.ah.A;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static bases.WebBase.setBranch;
import static utilities.MssqlConnect.queryRestSetup;
import static utilities.MssqlConnect.selectQuery;
import static utilities.VersionGetter.urlGetter;

public class MobileLogin extends MobileBasePage {

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    @iOSXCUITFindBy()
    WebElement notifPermission;
    @AndroidFindBy(accessibility = "Skip")
    WebElement skipBtn;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint = 'Company Code']")
    WebElement companyCodeF;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint = 'Branch Code']")
    WebElement branchCodeF;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint = 'Connectivity URL']")
    WebElement connectivityURLF;
    @AndroidFindBy(accessibility = "Connect")
    WebElement connectBtn;
    @AndroidFindBy(accessibility = "Later")
    WebElement laterBtn;
    @AndroidFindBy(accessibility = "Update")
    WebElement updateBtn;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint = 'Employee Code']")
    WebElement employeeCodeF;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint = 'Password']")
    WebElement passwordF;
    @AndroidFindBy(accessibility = "Login")
    public WebElement loginBtn;
    @AndroidFindBy (xpath = "//android.widget.ImageView[2]")
    WebElement connectivityBtn;
    @AndroidFindBy(accessibility = "Back")
    WebElement backConnectivityBtn;
    @FindBy(xpath = "//android.view.View[contains(@content-desc, 'Error')]")
    public WebElement errorAlert;
    @AndroidFindBy(className = "android.widget.CheckBox")
    WebElement rememberMeCheckbox;
    @AndroidFindBy(accessibility = "MainButtonSemantics")
    public WebElement requestMenu;
    @AndroidFindBy(className = "android.widget.EditText")
    WebElement authenticationCodeF;
    @AndroidFindBy(accessibility = "Verify")
    WebElement verifyBtn;
    @AndroidFindBy(accessibility = "Resend Code")
    WebElement resendCodeBtn;
    @AndroidFindBy(accessibility = "Paste")
    WebElement pasteBtn;
    @AndroidFindBy(accessibility = "Forgot Password!")
    WebElement forgetPasswordBtn;
    @AndroidFindBy(accessibility = "Reset")
    WebElement resetBtn;
    @AndroidFindBy(accessibility = "Continue")
    WebElement continueBtn;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Attention')]")
    public WebElement alertPopup;

    public void notificationPermission(boolean perm){
        waitForElementToBeVisible(By.id("com.android.permissioncontroller:id/permission_allow_button"));
        if(perm){
            clickOn(notifPermission);
        }
    }

    public void skipPage(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("Skip"));
        clickOn(skipBtn);
    }

    public void connectivity(String companyCode, String branchCode, String connectivityURL){

        setBranch(branchCode);
        queryRestSetup();

        waitForElementToBeVisible(By.xpath("//android.widget.EditText[@hint = 'Company Code']"));
        clickOn(companyCodeF);
        setText(companyCodeF, companyCode);
        clickOn(branchCodeF);
        setText(branchCodeF, branchCode);
        clickOn(connectivityURLF);
        setText(connectivityURLF, connectivityURL);
        clickOn(connectBtn);
        waitLoadingElement();

    }

    public void login(String employeeCode, String password, String branchCode, boolean rememberMe){

        if(checkIfFirstRun()){
            skipPage();
            connectivity("automation", branchCode, urlGetter());
        }else{

            waitLoadingElement();

            clickOn(connectivityBtn);
            waitForElementToBeVisible(AppiumBy.accessibilityId("Connect"));

            if("automation".equalsIgnoreCase(companyCodeF.getText()) && branchCode.equalsIgnoreCase(branchCodeF.getText()) && urlGetter().equalsIgnoreCase(connectivityURLF.getText())){
                clickOn(backConnectivityBtn);
                waitForElementToBeVisible(AppiumBy.accessibilityId("Login"));
            }else{

                if(!"automation".equalsIgnoreCase(companyCodeF.getText())){
                    clickOn(companyCodeF);
                    companyCodeF.clear();
                    setText(companyCodeF, "automation");
                }

                if(!branchCode.equalsIgnoreCase(branchCodeF.getText())){
                    clickOn(branchCodeF);
                    branchCodeF.clear();
                    setText(branchCodeF, branchCode);
                }

                if(!urlGetter().equalsIgnoreCase(connectivityURLF.getText())){
                    clickOn(connectivityURLF);
                    connectivityURLF.clear();
                    setText(connectivityURLF, urlGetter());
                }

                clickOn(connectBtn);
                waitLoadingElement();
            }

        }

        waitForElementToBeVisible(By.xpath("//android.widget.EditText[@hint = 'Employee Code']"));
        clickOn(employeeCodeF);
        employeeCodeF.clear();
        setText(employeeCodeF, employeeCode);
        clickOn(passwordF);
        passwordF.clear();
        setText(passwordF, password);
        hold(100);
        if(rememberMe){
            clickOn(rememberMeCheckbox);
        }
        clickOn(loginBtn);
        waitLoadingElement();
        hold(200);

    }

    public String getAuthenticationCode(String employeeCode){
        String code = selectQuery("select mfa_authentication_code from pay_employees where employee_code ='"+employeeCode+"'");
        System.out.println("Code: "+code);
        return code;
    }

    public void setAuthenticationCode_executeScript(String code){
        waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Authentication')]/following::android.widget.EditText[1]"));
        waitForElementToBeInvisible(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Authentication Code Was Sent')]"));
        hold(1000);

        // Loop through each character in the string
        for (int i = 0; i < code.length(); i++) {
            // Get the character at index i
            String digitChar = String.valueOf(code.charAt(i));

            switch (digitChar) {
                case "0":
                    appiumDriver.executeScript("mobile: pressKey", ImmutableMap.of("keycode", "7"));
                    break;
                case "1":
                    appiumDriver.executeScript("mobile: pressKey", ImmutableMap.of("keycode", "8"));
                    break;
                case "2":
                    appiumDriver.executeScript("mobile: pressKey", ImmutableMap.of("keycode", "9"));
                    break;
                case "3":
                    appiumDriver.executeScript("mobile: pressKey", ImmutableMap.of("keycode", "10"));
                    break;
                case "4":
                    appiumDriver.executeScript("mobile: pressKey", ImmutableMap.of("keycode", "11"));
                    break;
                case "5":
                    appiumDriver.executeScript("mobile: pressKey", ImmutableMap.of("keycode", "12"));
                    break;
                case "6":
                    appiumDriver.executeScript("mobile: pressKey", ImmutableMap.of("keycode", "13"));
                    break;
                case "7":
                    appiumDriver.executeScript("mobile: pressKey", ImmutableMap.of("keycode", "14"));
                    break;
                case "8":
                    appiumDriver.executeScript("mobile: pressKey", ImmutableMap.of("keycode", "15"));
                    break;
                case "9":
                    appiumDriver.executeScript("mobile: pressKey", ImmutableMap.of("keycode", "16"));
                    break;
            }

        }

        hold(200);
        clickOn(verifyBtn);
        waitLoadingElement();
        waitLoadingElement();
    }

    public void setAuthenticationCode(String code){

        waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Authentication')]/following::android.widget.EditText[1]"));
        waitForElementToBeInvisible(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Authentication Code Was Sent')]"));
        hold(1000);

        ((AndroidDriver) appiumDriver).isKeyboardShown();

        // Loop through each character in the string
        for (int i = 0; i < code.length(); i++) {
            // Get the character at index i
            String digitChar = String.valueOf(code.charAt(i));

            switch (digitChar) {
                case "0":
                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_0));
                    break;
                case "1":
                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
                    break;
                case "2":
                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
                    break;
                case "3":
                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
                    break;
                case "4":
                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_4));
                    break;
                case "5":
                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_5));
                    break;
                case "6":
                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_6));
                    break;
                case "7":
                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_7));
                    break;
                case "8":
                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_8));
                    break;
                case "9":
                    ((AndroidDriver) appiumDriver).pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_9));
                    break;
            }

        }

        ((AndroidDriver) appiumDriver).hideKeyboard();

        hold(200);
        clickOn(verifyBtn);
        waitLoadingElement();
        waitLoadingElement();

    }

    public void resendCodeOTP(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("Resend Code"), 60);
        clickOn(resendCodeBtn);
        waitLoadingElement();
        hold(200);
        clickByLocationElement(authenticationCodeF, -100, 0);
    }

    public void loginAfterConnectivity(String employeeCode, String password){

//        if(checkIfUpdateAvailable()){
//            ignoreUpdatePopup();
//        }

        waitLoadingElement();
        waitForElementToBeVisible(By.xpath("//android.widget.EditText[@hint = 'Employee Code']"));
        clickOn(employeeCodeF);
        setText(employeeCodeF, employeeCode);
        clickOn(passwordF);
        setText(passwordF, password);
        hold(300);
        clickOn(loginBtn);
        waitLoadingElement();

    }

//    public boolean checkIfFirstRun() {
//        boolean check = false;
//        try {
//            new WebDriverWait(appiumDriver, Duration.ofSeconds(3))
//                    .until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Skip")));
//            check = true;
//        } catch (Exception e) {
//            System.out.println("After wait 5 second, this is NOT first run for app!");
//        }
//        return check;
//    }

    public boolean checkIfFirstRun() {
        boolean check = false;
        try {
            hold(1000);
            if(skipBtn.isDisplayed()){
                check = true;
            }
        } catch (Exception e) {
            System.out.println("this is NOT first run for app!");
        }
        return check;
    }

    public void forgetPassword(String employeeCode, String companyCode){
        waitForElementToBeVisible(AppiumBy.accessibilityId("Login"));
        clickOn(forgetPasswordBtn);
        waitForElementToBeVisible(By.xpath("//android.widget.EditText[@hint = 'Employee Code']"));
        clickOn(employeeCodeF);
        setText(employeeCodeF, employeeCode);
        clickOn(companyCodeF);
        setText(companyCodeF, companyCode);
        clickOn(resetBtn);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("Continue"));
        clickOn(continueBtn);
    }

    public void auto_mobile1(){
        login("auto_mobile1","1", "auto_mob1", false);
    }


}
