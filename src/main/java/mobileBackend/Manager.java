package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Manager extends MobileBasePage {

    @AndroidFindBy(accessibility = "Vacations")
    public WebElement vacationsRequestBtn;
    @AndroidFindBy(accessibility = "Overtime")
    WebElement overtimeRequestBtn;
    @AndroidFindBy(accessibility = "Choose")
    WebElement vacationsTypeBtn;
    @AndroidFindBy(accessibility = "Choose")
    WebElement typeF;
    @AndroidFindBy(accessibility = "Choose")
    WebElement chooseBtn;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='From Date']/following::android.widget.ImageView)[1]")
    WebElement fromDateF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='To Date']/following::android.widget.ImageView)[1]")
    WebElement toDateF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Date']/following::android.widget.ImageView)[1]")
    WebElement dateF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='From Time']/following::android.widget.Button)[1]")
    WebElement fromTimeF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='To Time']/following::android.widget.Button)[1]")
    WebElement toTimeF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Reason']/following::android.widget.EditText)[1]")
    WebElement reasonF;
    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'Vacation Attachment')]/following::android.widget.ImageView)[1]")
    WebElement attachmentIconBtn;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Attachment']/following::android.widget.ImageView)[1]")
    WebElement attachmentF;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Delegate']/following::android.widget.Button)[1]")
    WebElement delegateF;
    @AndroidFindBy(accessibility = "Document")
    WebElement documentBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='test.png']")
    WebElement imgUploaded;
    @AndroidFindBy(xpath = "//android.widget.SeekBar[contains(@content-desc, 'Select hours')]")
    WebElement hourF;
    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    WebElement setHour;
    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    WebElement setMinutes;
    @AndroidFindBy(accessibility = "OK")
    WebElement okBtn;
    @AndroidFindBy(accessibility = "Try Again")
    WebElement tryAgainBtn;
    @AndroidFindBy(accessibility = "Submit")
    WebElement submitBtn;
    @AndroidFindBy(accessibility = "Not Required")
    WebElement notRequired_checkbox;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@hint='Search by Name...']")
    WebElement search_delegatePopup;
    @AndroidFindBy(accessibility = "Got it!")
    WebElement gotItBtn;
    @AndroidFindBy(accessibility = "Alright!")
    WebElement alrightBtn;
    @AndroidFindBy(accessibility = "Approval Committee")
    WebElement approvalCommitteeText;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Attachments']/following::android.widget.ImageView)[1]")
    public WebElement attachmentInVacationDetails;
    @AndroidFindBy(accessibility = "Approve")
    WebElement approveBtn;
    @AndroidFindBy(accessibility = "Send")
    WebElement SendBtn;
    @AndroidFindBy(className = "android.widget.EditText")
    WebElement commentF;
    @AndroidFindBy(accessibility = "Reject")
    WebElement rejectBtn;
    @AndroidFindBy(accessibility = "Please Fill The Reason")
    public WebElement pleaseFillTheReason_Alert;
    @AndroidFindBy(accessibility = "Please Insert Phone Number")
    public WebElement pleaseInsertPhoneNumber_Alert;
    @AndroidFindBy(accessibility = "The maximum number of attachment is : 2")
    public WebElement theMaximumNumberOfAttachmentIs2_Alert;
    @AndroidFindBy(accessibility = "Maximum Allowed Attachments Is 2 And Minimum Allowed Attachments Is 1")
    public WebElement maximumAllowedAttachmentsIs2AndMinimumAllowedAttachmentsIs1;
    @AndroidFindBy(accessibility = "Auto Delegation Is Mandatory Before Vacation Request")
    public WebElement autoDelegationIsMandatoryBeforeVacationRequest_Alert;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'results found')]")
    public WebElement resultFound;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Code:')]")
    public List<WebElement> listOfEmployees;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    WebElement locationPermission;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[2]")
    WebElement TA_Options;
    @AndroidFindBy(accessibility = "Sign In")
    WebElement TA_signInBtn;
    @AndroidFindBy(accessibility = "MainButtonSemantics")
    public WebElement requestMenuBtn;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds = '[74,275][206,407]']")
    WebElement backBtn;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds = '[874,275][1006,407]']")
    WebElement homeBtn;
    @AndroidFindBy(accessibility = "MenuIcon")
    WebElement sideBarMenu;
    @AndroidFindBy(accessibility = "Log Out")
    WebElement logOutBtn;
    @AndroidFindBy(accessibility = "Settings")
    WebElement settingsBtn;
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
    @AndroidFindBy(accessibility = "Annual Vacation")
    WebElement annualVacationType;
    @AndroidFindBy(accessibility = "OK")
    WebElement calendar_OkBtn;
    @AndroidFindBy(accessibility = "1")
    WebElement calendar_1;
    @AndroidFindBy(accessibility = "TransactionIcon")
    WebElement myTransactionBtn;
    @AndroidFindBy(accessibility = "ProfileIcon")
    WebElement profileBtn;
    @AndroidFindBy(accessibility = "Financial")
    WebElement financialBtn;
    @AndroidFindBy(accessibility = "Salary Slip")
    WebElement salarySlipBtn;
    @AndroidFindBy(accessibility = "This Month")
    WebElement thisMonthBtn;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Employee Contribution')]")
    WebElement employeeContributionF;
    @AndroidFindBy(accessibility = "Recent Slip")
    WebElement recentSlipE;
    @AndroidFindBy(accessibility = "Non Payroll")
    WebElement NonPayrollBtn;
    @AndroidFindBy(accessibility = "Later")
    WebElement laterBtn;
    @AndroidFindBy(accessibility = "Update")
    WebElement updateBtn;
    @AndroidFindBy(accessibility = "Workflow Details")
    WebElement workflowDetailsText;
    @AndroidFindBy(accessibility = "Withdraw")
    WebElement withdrawBtn;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Attention')]")
    public WebElement attentionAlertPopup;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Successfully')]")
    public WebElement successAlertPopup;
    @AndroidFindBy(accessibility = "Manager")
    WebElement managerBtn;
    @AndroidFindBy(accessibility = "All")
    WebElement myTeamTransactionAll;
    @AndroidFindBy(accessibility = "Approve All")
    WebElement approveAllBtn;
    @AndroidFindBy(accessibility = "Attachments")
    WebElement attachments_title;

    public void openManager(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("MenuIcon"));
        clickOn(sideBarMenu);
        hold(100);
        clickOn(managerBtn);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("My Team"));
    }

    public void openMyTeamTransaction(){
        clickOn(myTeamTransactionAll);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Approve All"));
        hold(300);
    }

    public void openTransaction(String employeeCode, String transactionType){

        try{
            approveAllBtn.isDisplayed();
        }catch (Exception ignored){
            clickOn(sideBarMenu);
            hold(100);
            clickOn(managerBtn);
            waitLoadingElement();
            waitForElementToBeVisible(AppiumBy.accessibilityId("My Team"));
            clickOn(myTeamTransactionAll);
            waitForElementToBeVisible(AppiumBy.accessibilityId("Approve All"));
            hold(300);
        }

        clickOn(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+employeeCode+"') and contains(@content-desc, '"+transactionType+"')])[1]"));
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId(transactionType));
    }

    public void openMyTeamTransaction(String employeeCode, String transactionType){
        clickOn(myTeamTransactionAll);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Approve All"));
        hold(300);
        clickOn(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+employeeCode+"') and contains(@content-desc, '"+transactionType+"')])[1]"));
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId(transactionType));
    }

    public String transaction(String employeeCode){
        return appiumDriver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, 'COD:') and contains(@content-desc, '"+employeeCode+"')])[1]")).getAttribute("content-desc");
    }

    public String transactionDetails(String type){
        String textAfterNewline = null;
        try{
           String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+type+"')]")).getAttribute("content-desc");
            if (det != null) {
                textAfterNewline = det.substring(det.indexOf("\n") + 1);
            }
            return textAfterNewline;

        }catch (Exception e){
            try {
                scrollToElement(attachments_title, true);
            }catch (Exception ee){
                scrollToElement(approvalCommitteeText, true);
            }
            hold(200);
            String det = appiumDriver.findElement(AppiumBy.xpath("//*[contains(@content-desc, '"+type+"')]")).getAttribute("content-desc");
            if (det != null) {
                textAfterNewline = det.substring(det.indexOf("\n") + 1);
            }
            return textAfterNewline;
        }
    }

    public String getApprovalCommittee(String managerName){
        String textAfterNewline = null;
        String textBetweenNewlines = null;
        try{
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
            if (det != null) {
                textAfterNewline = det.substring(det.indexOf("\n") + 1);
            }
            return textAfterNewline;

        }catch (Exception e){
            try {
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
                if (det != null) {
                    textAfterNewline = det.substring(det.indexOf("\n") + 1);
                }
                return textAfterNewline;
            }catch (Exception ex){
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
                if (det != null) {
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1, det.indexOf("\n", det.indexOf("\n") + 1));
                }
                return textBetweenNewlines;
            }
        }
    }

    public String getApprovalComments(String managerName){
        String textAfterSecondNewline = null;
        try{
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
            if (det != null) {
                int firstNewline = det.indexOf("\n");
                int secondNewline = det.indexOf("\n", firstNewline + 1);
                textAfterSecondNewline = det.substring(secondNewline + 1, det.indexOf("\n", secondNewline + 1));
            }
            return textAfterSecondNewline;
        }catch (Exception e){
            scrollToElement(approvalCommitteeText, true);
            hold(200);
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
            if (det != null) {
                int firstNewline = det.indexOf("\n");
                int secondNewline = det.indexOf("\n", firstNewline + 1);
                textAfterSecondNewline = det.substring(secondNewline + 1, det.indexOf("\n", secondNewline + 1));
            }
            return textAfterSecondNewline;
        }
    }

    public String getApprovalDate(String managerName){
        String date = null;
        try {
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
            if (det != null) {
                int secondNewline = det.indexOf("\n", det.indexOf("\n") + 1);
                int thirdNewline = det.indexOf("\n", secondNewline + 1);
                String textAfterThirdNewline = det.substring(thirdNewline + 1);
                date = textAfterThirdNewline.substring(0, 10);
            }
            return date;
        }catch (Exception e){
            scrollToElement(approvalCommitteeText, true);
            hold(200);
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
            if (det != null) {
                int secondNewline = det.indexOf("\n", det.indexOf("\n") + 1);
                int thirdNewline = det.indexOf("\n", secondNewline + 1);
                String textAfterThirdNewline = det.substring(thirdNewline + 1);
                date = textAfterThirdNewline.substring(0, 10);
            }
            return date;
        }
    }

    public boolean checkAttachmentIcon(){
        boolean check = false;
        try {
            if(attachmentInVacationDetails.isDisplayed()){
                check = true;
            }
        }catch (Exception e){
            scrollToElement(approvalCommitteeText, true);

            if(attachmentInVacationDetails.isDisplayed()){
                check = true;
            }

        }
        return check;
    }

    public boolean checkAttachmentInVacationDetails(){
        hold(1000);
        boolean check = false;

        scrollToElement(approvalCommitteeText, true);
        clickOn(attachmentInVacationDetails);
        waitLoadingElement();
        hold(2000);
        waitForElementToBeVisible(AppiumBy.id("com.android.gallery3d:id/gallery_root"));

        try {
            appiumDriver.findElement(AppiumBy.id("com.android.gallery3d:id/gl_root_view")).isDisplayed();
            check = true;
        }catch (Exception ignored){}

        android_Back();
        hold(1000);

        return check;
    }

    public void approve(String comment){
        clickOn(approveBtn);
        hold(200);
        simpleClick(commentF);
        setText(commentF, comment);
        simpleClick(SendBtn);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[@content-desc='My Transaction approvals']"));
    }

    public void approve(){
        clickOn(approveBtn);
        hold(200);
        simpleClick(SendBtn);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[@content-desc='My Transaction approvals']"));
    }

    public void reject(String reason){
        clickOn(rejectBtn);
        hold(200);
        simpleClick(commentF);
        setText(commentF, reason);
        simpleClick(SendBtn);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[@content-desc='My Transaction approvals']"));
    }

    public void reject(){
        clickOn(rejectBtn);
        hold(200);
        simpleClick(SendBtn);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[@content-desc='My Transaction approvals']"));
    }

}
