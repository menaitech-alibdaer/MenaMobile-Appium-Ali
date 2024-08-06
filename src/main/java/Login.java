import bases.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login extends BasePage {

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
    WebElement loginBtn;

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

    public void login(String employeeCode, String password){

//        if(checkIfUpdateAvailable()){
//            ignoreUpdatePopup();
//        }

        waitLoadingElement();
        waitForElementToBeVisible(By.xpath("//android.widget.EditText[@hint = 'Employee Code']"));
        clickOn(employeeCodeF);
        setText(employeeCodeF, employeeCode);
        clickOn(passwordF);
        setText(passwordF, password);
        clickOn(loginBtn);
        waitLoadingElement();

    }

    public void ignoreUpdatePopup(){
        waitForElementToBeClickable(AppiumBy.accessibilityId("Later"));
        hold(500);
        clickOn(laterBtn);
        hold(500);
    }

    public boolean checkIfUpdateAvailable(){
        boolean check = false;
        try {
            waitForElementToBeVisible(AppiumBy.accessibilityId("Update"));
            if(updateBtn.isDisplayed()){
                check = true;
            }
        }catch (Exception ignored){
        }
        return check;
    }



}
