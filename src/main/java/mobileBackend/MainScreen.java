package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MainScreen extends MobileBasePage {


    @AndroidFindBy(accessibility = "MainButtonSemantics")
    public WebElement requestMenuBtn;
    @AndroidFindBy(accessibility = "MenuIcon")
    WebElement sideBarMenu;
    @AndroidFindBy(accessibility = "MenuMSS")
    WebElement sideBarMenuManager;
    @AndroidFindBy(accessibility = "Manager")
    WebElement managerBtn;
    @AndroidFindBy(accessibility = "Log Out")
    WebElement logOutBtn;
    @AndroidFindBy(accessibility = "Change Password")
    WebElement changePasswordBtn;
    @AndroidFindBy(accessibility = "Change")
    WebElement changeBtn;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint = 'Old Password']")
    WebElement oldPasswordF;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint = 'New Password']")
    WebElement newPasswordF;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint = 'Re-type New Password']")
    WebElement retypeNewPasswordF;
    @AndroidFindBy(accessibility = "Password doesn't match the new password")
    public WebElement passwordDoesntMatchTheNewPasswordAlert;
    @AndroidFindBy(accessibility = "Got it!")
    WebElement gotItBtn;
    @AndroidFindBy(accessibility = "TransactionIcon")
    WebElement myTransactionBtn;
    @AndroidFindBy(accessibility = "NotificationIcon")
    WebElement notification;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Workflow Approvals')]")
    WebElement workflowApprovals_notification;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Attention')]")
    public WebElement attentionAlertPopup;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Successfully')]")
    public WebElement successAlertPopup;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[contains(@content-desc, 'Current')])[2]")
    WebElement toTestScroll111111;

    public MainScreen(){
        ignoreUpdatePopup();
    }

    public void myRequests(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("MainButtonSemantics"));
        clickOn(requestMenuBtn);
        hold(200);
    }

    public void logout(){
        openSideMenu();
        hold(1000);
        simpleClick(logOutBtn, true);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("Login"));
    }

    public void openSideMenu(){
        hold(1000);
        try {
            waitLoadingElement();
            waitLoadingElement();
            waitLoadingElement();
            horizontalSwipeByPercentages(10, 90, 50);
            hold(500);
        }catch (Exception e){
            try {
                simpleClick(sideBarMenu);
            }catch (Exception ee){
                try {
                    verticalSwipeByPercentages(60, 10, 50);
                    simpleClick(sideBarMenu);
                }catch (Exception eee){
                    try {
                        simpleClick(sideBarMenuManager);
                    }catch (Exception eeee){
                        verticalSwipeByPercentages(60, 10, 50);
                        simpleClick(sideBarMenuManager);
                    }
                }
            }
        }
    }

    public void openChangePassword(){
        openSideMenu();
        hold(100);
        clickOn(changePasswordBtn);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("Change"));
    }

    public void changePassword(String oldPassword, String newPassword, String reTypeNewPassword){
        clickOn(oldPasswordF);
        setText(oldPasswordF, oldPassword);
        clickOn(newPasswordF);
        setText(newPasswordF, newPassword);
        clickOn(retypeNewPasswordF);
        setText(retypeNewPasswordF, reTypeNewPassword);
        clickOn(changeBtn);
        hold(2000);
        waitLoadingElement();
    }

    public void myTransactions(){
        clickOn(myTransactionBtn);
        hold(500);
    }

    public boolean checkIfLoginSuccessfully(){

        boolean check = false;

        waitLoadingElement();

        try{
            hold(2000);
            waitLoadingElement();
            if(requestMenuBtn.isDisplayed()){
                check = true;
            }
        }catch (Exception ignored){}

        return check;
    }

    public void openManager(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("MenuIcon"));
        openSideMenu();
        hold(100);
        clickOn(managerBtn);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("My Team"));
    }

    public void openNotifications(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("NotificationIcon"));
        simpleClick(notification);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Campaigns"));
    }

}
