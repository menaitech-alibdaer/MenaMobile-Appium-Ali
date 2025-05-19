package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends MobileBasePage {

    @AndroidFindBy(accessibility = "Approval Committee")
    WebElement approvalCommitteeText;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Attachments']/following::android.widget.ImageView)[1]")
    public WebElement attachmentInVacationDetails;
    @AndroidFindBy(accessibility = "Approve")
    public WebElement approveBtn;
    @AndroidFindBy(accessibility = "Send")
    WebElement SendBtn;
    @AndroidFindBy(accessibility = "Got it!")
    WebElement gotItBtn;
    @AndroidFindBy(accessibility = "OK")
    WebElement okBtn;
    @AndroidFindBy(accessibility = "Try Again")
    WebElement tryAgainBtn;
    @AndroidFindBy(accessibility = "Alright!")
    WebElement alrightBtn;
    @AndroidFindBy(className = "android.widget.EditText")
    WebElement commentF;
    @AndroidFindBy(accessibility = "Reject")
    WebElement rejectBtn;
    @AndroidFindBy(accessibility = "Consult")
    public WebElement consultBtn;
    @AndroidFindBy(accessibility = "Delegate")
    public WebElement delegateBtn;
    @AndroidFindBy(className = "android.widget.EditText")
    WebElement consult_searchF;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@hint, 'write here')]")
    WebElement consult_commentF;
    @AndroidFindBy(accessibility = "Delegate To")
    WebElement delegateTo_title;
    @AndroidFindBy(accessibility = "MenuIcon")
    WebElement sideBarMenu;
    @AndroidFindBy(accessibility = "Manager")
    WebElement managerBtn;
    @AndroidFindBy(accessibility = "All")
    WebElement myTeamTransactionAll;
    @AndroidFindBy(accessibility = "Approve All")
    WebElement approveAllBtn;
    @AndroidFindBy(accessibility = "Attachments")
    WebElement attachments_title;
    @AndroidFindBy(accessibility = "Consultation History")
    WebElement consultationHistoryBtn;
    @AndroidFindBy(accessibility = "See All")
    WebElement seeAllBtn;
    @AndroidFindBy(accessibility = "Other")
    WebElement otherTab;
    @AndroidFindBy(accessibility = "Salary Slip")
    WebElement salarySlipBtn;

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

    public void openTransaction(String employeeCode, String transactionType, String transactionDate){

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

        clickOn(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+employeeCode+"') and contains(@content-desc, '"+transactionType+"') and contains(@content-desc, '"+transactionDate+"')])[1]"));
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
        return appiumDriver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, 'COD:') and contains(@content-desc, '"+employeeCode+"')])[1]")).getDomAttribute("content-desc");
    }

    public String transactionDetails(String type){
        String textAfterNewline = null;
        try{
           String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+type+"')]")).getDomAttribute("content-desc");
            if (det != null) {
                textAfterNewline = det.substring(det.indexOf("\n") + 1);
            }
            return textAfterNewline;

        }catch (Exception e){
            try {
                scrollToElement(attachments_title, true, 6);
            }catch (Exception ee){
                scrollToElement(approvalCommitteeText, true, 6);
            }
            hold(200);
            try {
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+type+"')]")).getDomAttribute("content-desc");
                if (det != null) {
                    textAfterNewline = det.substring(det.indexOf("\n") + 1);
                }
                return textAfterNewline;
            }catch (Exception ee){
                try {
                    String det = appiumDriver.findElement(AppiumBy.xpath("//*[contains(@content-desc, '"+type+"')]")).getDomAttribute("content-desc");
                    if (det != null) {
                        textAfterNewline = det.substring(det.indexOf("\n") + 1);
                    }
                    return textAfterNewline;
                }catch (Exception eee){
                    return type+": NOT FOUND!";
                }
            }
        }
    }

    public String getApprovalCommittee(String managerName){
        String textBetweenNewlines = null;
        try{
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getDomAttribute("content-desc");
            boolean containsMoreThanOneNewline = det.indexOf("\n") != -1 && det.indexOf("\n", det.indexOf("\n") + 1) != -1;

            if(containsMoreThanOneNewline){
                textBetweenNewlines = det.substring(det.indexOf("\n") + 1, det.indexOf("\n", det.indexOf("\n") + 1));
            }else{
                textBetweenNewlines = det.substring(det.indexOf("\n") + 1);
            }

            return textBetweenNewlines;

        }catch (Exception e){
            try {
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getDomAttribute("content-desc");
                boolean containsMoreThanOneNewline = det.indexOf("\n") != -1 && det.indexOf("\n", det.indexOf("\n") + 1) != -1;

                if(containsMoreThanOneNewline){
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1, det.indexOf("\n", det.indexOf("\n") + 1));
                }else{
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1);
                }

                return textBetweenNewlines;

            }catch (Exception ex){
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getDomAttribute("content-desc");
                boolean containsMoreThanOneNewline = det.indexOf("\n") != -1 && det.indexOf("\n", det.indexOf("\n") + 1) != -1;

                if(containsMoreThanOneNewline){
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1, det.indexOf("\n", det.indexOf("\n") + 1));
                }else{
                    textBetweenNewlines = det.substring(det.indexOf("\n") + 1);
                }

                return textBetweenNewlines;

            }
        }
    }

    public String getApprovalComments(String managerName){
        String textAfterSecondNewline = null;
        try{
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getDomAttribute("content-desc");
            if (det != null) {
                int firstNewline = det.indexOf("\n");
                int secondNewline = det.indexOf("\n", firstNewline + 1);
                textAfterSecondNewline = det.substring(secondNewline + 1, det.indexOf("\n", secondNewline + 1));
            }
            return textAfterSecondNewline;
        }catch (Exception e){
            scrollToElement(approvalCommitteeText, true);
            hold(200);
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getDomAttribute("content-desc");
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
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getDomAttribute("content-desc");
            if (det != null) {
                int lastNewline = det.lastIndexOf("\n");
                String textAfterLastNewline = det.substring(lastNewline + 1).trim();
                date = textAfterLastNewline.substring(0, 10);
            }
            return date;
        }catch (Exception e){
            try {
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getDomAttribute("content-desc");
                if (det != null) {
                    int lastNewline = det.lastIndexOf("\n");
                    String textAfterLastNewline = det.substring(lastNewline + 1).trim();
                    date = textAfterLastNewline.substring(0, 10);
                }
                return date;
            }catch (Exception ex){
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getDomAttribute("content-desc");
                if (det != null) {
                    int lastNewline = det.lastIndexOf("\n");
                    String textAfterLastNewline = det.substring(lastNewline + 1).trim();
                    date = textAfterLastNewline.substring(0, 10);
                }
                return date;
            }
        }
    }

    public boolean checkAttachmentIcon(){
        boolean check = false;
        try {
            if(attachmentInVacationDetails.isDisplayed()){
                check = true;
            }
        }catch (Exception e){
            scrollToElement(approvalCommitteeText, true, 6);

            try {
                if(attachmentInVacationDetails.isDisplayed()){
                    check = true;
                }
            }catch (Exception ignored){}

        }
        return check;
    }

//    public boolean checkAttachmentInVacationDetails(){
//        hold(1000);
//        boolean check = false;
//
//        scrollToElement(approvalCommitteeText, true);
//        clickOn(attachmentInVacationDetails);
//        waitLoadingElement();
//        hold(2000);
//        waitForElementToBeVisible(AppiumBy.id("com.android.gallery3d:id/gallery_root"));
//
//        try {
//            appiumDriver.findElement(AppiumBy.id("com.android.gallery3d:id/gl_root_view")).isDisplayed();
//            check = true;
//        }catch (Exception ignored){}
//
//        android_Back();
//        hold(1000);
//
//        return check;
//    }

    public void approve(String comment){
        verticalSwipeByPercentages(70, 30, 50);
        clickOn(approveBtn);
        hold(200);
        simpleClick(commentF);
        setText(commentF, comment);
        simpleClick(SendBtn);
        hold(2000);
        waitLoadingElement();
        waitLoadingElement();
        hold(2000);
    }

    public void backHome(){
        waitLoadingElement();
        home();
    }

    public void approve(){
        verticalSwipeByPercentages(70, 30, 50);
        clickOn(approveBtn);
        hold(200);
        simpleClick(SendBtn);
        hold(2000);
        waitLoadingElement();
        waitLoadingElement();
        hold(2000);
    }

    public void reject(String reason){
        verticalSwipeByPercentages(70, 30, 50);
        clickOn(rejectBtn);
        hold(200);
        simpleClick(commentF);
        setText(commentF, reason);
        simpleClick(SendBtn);
        hold(2000);
        waitLoadingElement();
        waitLoadingElement();
        hold(2000);
    }

    public void reject(){
        verticalSwipeByPercentages(70, 30, 50);
        clickOn(rejectBtn);
        hold(200);
        simpleClick(SendBtn);
        hold(2000);
        waitLoadingElement();
        waitLoadingElement();
        hold(2000);
    }

    public void consult(String employeeName, String comment){
        verticalSwipeByPercentages(70, 20, 50);
        clickOn(consultBtn);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Consult With"));
        simpleClick(consult_searchF);
        setText(consult_searchF, employeeName);
        hold(1000);
        waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+employeeName+"')]"));
        simpleClick(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+employeeName+"')]")));
        hold(200);

        if(!comment.isEmpty()){
            simpleClick(consult_commentF);
            setText(consult_commentF, comment);
            closeKeyboard();
        }

        clickOn(consultBtn);
        waitLoadingElement();
        waitLoadingElement();
        closeAlert();
        hold(2000);

    }

    public void delegate(String employeeName, String comment){
        verticalSwipeByPercentages(70, 20, 50);
        clickOn(delegateBtn);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Delegate To"));
        simpleClick(consult_searchF);
        setText(consult_searchF, employeeName);
        hold(1000);
        waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+employeeName+"')]"));
        simpleClick(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+employeeName+"')]")));
        hold(200);
        //closeKeyboard();
        simpleClick(delegateTo_title);
        hold(200);

        if(!comment.isEmpty()){
            simpleClick(consult_commentF);
            setText(consult_commentF, comment);
            //closeKeyboard();
            simpleClick(delegateTo_title);
            hold(200);
        }

        clickOn(delegateBtn);
        waitLoadingElement();
        waitLoadingElement();
        closeAlert();
        hold(200);

    }

    public void closeAlert(){
        try{
            simpleClick(alrightBtn);
        }catch (Exception exce){
            try {
                simpleClick(gotItBtn);
            }catch (Exception exc){
                try {
                    simpleClick(okBtn);
                }catch (Exception ex){
                    try {
                        simpleClick(tryAgainBtn);
                    }catch (Exception e){
                        System.out.println("I can't click on the suggested buttons!");
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String getManagerCommentDelegate(String managerName){
        scrollToElement(approvalCommitteeText, true);
        String textAfterNewline = null;
        String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Manager Comment']/following::android.view.View[contains(@content-desc, '"+managerName+"')]")).getDomAttribute("content-desc");
        if (det != null) {
            textAfterNewline = det.substring(det.indexOf("\n") + 1);
        }
        return textAfterNewline;

    }

    public void openConsultationHistory(){
        clickOn(consultationHistoryBtn);
        hold(1000);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Consultation History"));
    }

    public String getConsultComment(String name) {
        String history = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Consultation History']//android.view.View//android.view.View//android.view.View")).getDomAttribute("content-desc");
        // Define regex pattern to capture the specified name and its associated comment
        String regex = "(?m)" + Pattern.quote(name) + "\\n\\d{2}/\\d{2}/\\d{4}.*?\\n(.*?)(?=\\n[A-Z]{2}|$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(history);

        // Find and return the comment associated with the specified name
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }

    public void myTeam(String employeeName){
        clickOn(seeAllBtn, true);
        hold(1000);
        clickOn(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+employeeName+"')]"), true);
        waitLoadingElement();
        hold(800);
    }

    public void openSalarySlip(){
        clickOn(otherTab, true);
        hold(500);
        clickOn(salarySlipBtn, true);
        hold(500);
        waitLoadingElement();
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("Recent Slip"));
    }

}
