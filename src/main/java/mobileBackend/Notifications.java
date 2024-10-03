package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class Notifications extends MobileBasePage {

    @AndroidFindBy(accessibility = "MainButtonSemantics")
    public WebElement requestMenuBtn;
    @AndroidFindBy(accessibility = "MenuIcon")
    WebElement sideBarMenu;
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
    @AndroidFindBy(accessibility = "Send Feedback")
    WebElement sendFeedbackBtn;
    @AndroidFindBy(className = "android.widget.EditText")
    WebElement commentF;
    @AndroidFindBy(accessibility = "Send")
    WebElement sendBtn;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Attention')]")
    public WebElement attentionAlertPopup;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Successfully')]")
    public WebElement successAlertPopup;

    public void openNotifications(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("NotificationIcon"));
        simpleClick(notification);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Campaigns"));
    }

    public void openWorkflowApprovals(){

        clickOn(workflowApprovals_notification, true);
        hold(1000);

    }

    public void openTransaction(String transactionType, String employeeName){

        waitForElementToBeVisible(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+transactionType+"') and contains(@content-desc, '"+employeeName+"')]"));
        hold(500);
        clickOn(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+transactionType+"') and contains(@content-desc, '"+employeeName+"')]"));
        waitForElementToBeVisible(AppiumBy.accessibilityId("Requested on"));

    }

    public void sendFeedback(String comment){
        scrollToElement(sendFeedbackBtn, true);
        clickOn(sendFeedbackBtn);
        hold(200);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Consultation History"));
        simpleClick(commentF);
        setText(commentF, comment);
        simpleClick(sendBtn);
        hold(3000);
    }

}
