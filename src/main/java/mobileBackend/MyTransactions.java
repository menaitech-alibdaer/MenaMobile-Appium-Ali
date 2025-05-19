package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static utilities.VersionGetter.versionGetter;

public class MyTransactions extends MobileBasePage {

    @AndroidFindBy(accessibility = "Approval Committee")
    WebElement approvalCommitteeText;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Attachments']/following::android.widget.ImageView)[1]")
    public WebElement attachmentInVacationDetails;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Attachments']/following::android.widget.ImageView)[1]")
    public WebElement attachmentIconInDetails;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Requested Item']/following::android.widget.ImageView)[1]")
    public WebElement requestedItem_icon;
    @AndroidFindBy(accessibility = "Attachments")
    WebElement attachments_title;
    @AndroidFindBy(accessibility = "Alright!")
    WebElement alrightBtn;
    @AndroidFindBy(accessibility = "Got it!")
    WebElement gotItBtn;
    @AndroidFindBy(accessibility = "OK")
    WebElement okBtn;
    @AndroidFindBy(accessibility = "Try Again")
    WebElement tryAgainBtn;
    @AndroidFindBy(accessibility = "Cancel")
    WebElement cancelBtn;
    @AndroidFindBy(accessibility = "Workflow Details")
    WebElement workflowDetailsText;
    @AndroidFindBy(accessibility = "Additional Information")
    WebElement additionalInformationText;
    @AndroidFindBy(accessibility = "Requested Item")
    WebElement requestedItem_title;
    @AndroidFindBy(accessibility = "Withdraw")
    WebElement withdrawBtn;
    @AndroidFindBy(accessibility = "Financial Transactions")
    WebElement financialTransactionsBtn;
    @AndroidFindBy(accessibility = "HR Transactions")
    WebElement HRTransactionsBtn;


    public String transactionDetails(String type){
        String textAfterNewline = null;
        try{
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+type+"')]")).getDomAttribute("content-desc");
            if (det != null) {
                textAfterNewline = det.substring(det.indexOf("\n") + 1);
            }
            return textAfterNewline.trim();

        }catch (Exception e){
            try {
                scrollToElement(attachments_title, true);
            }catch (Exception ee){
                scrollToElement(approvalCommitteeText, true);
            }
            hold(200);
            String det = appiumDriver.findElement(AppiumBy.xpath("//*[contains(@content-desc, '"+type+"')]")).getDomAttribute("content-desc");
            if (det != null) {
                textAfterNewline = det.substring(det.indexOf("\n") + 1);
            }
            return textAfterNewline.trim();
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
                verticalSwipeByPercentages(70, 60, 50);
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
            try {
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getDomAttribute("content-desc");
                if (det != null) {
                    int firstNewline = det.indexOf("\n");
                    int secondNewline = det.indexOf("\n", firstNewline + 1);
                    textAfterSecondNewline = det.substring(secondNewline + 1, det.indexOf("\n", secondNewline + 1));
                }
                return textAfterSecondNewline;
            }catch (Exception ee){
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getDomAttribute("content-desc");
                if (det != null) {
                    int firstNewline = det.indexOf("\n");
                    int secondNewline = det.indexOf("\n", firstNewline + 1);
                    textAfterSecondNewline = det.substring(secondNewline + 1, det.indexOf("\n", secondNewline + 1));
                }
                return textAfterSecondNewline;
            }
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

    public void openLastVacationRequest(){
        waitForElementToBeVisible(accessibilityId("My Recent Transactions"));
        clickOn(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='My Recent Transactions']/following::android.view.View[contains(@content-desc, 'Vacation Request')]")));
        hold(1000);
        waitForElementToBeVisible(accessibilityId("Requested on"));

    }

    public boolean checkCancelButtonIfVisible(){
        scrollToElement(approvalCommitteeText, true);
        verticalSwipeByPercentages(70, 40, 50);
        return checkElementIfVisible(cancelBtn);
    }

//    public void openTransactionInMyTransactions(String transactionType, String transactionName, String transactionDate){
//
//        clickOn(accessibilityId(transactionType));
//        hold(4000);
//        verticalSwipeByPercentages(70, 10, 50);
//
//        if(!transactionDate.isEmpty()){
//            scrollToElement(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]")), true);
//            clickOn(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]")));
//        }else{
//            scrollToElement(appiumDriver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]")), true);
//            clickOn(appiumDriver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]")));
//        }
//
//        waitForElementToBeVisible(accessibilityId("Requested on"));
//
//    }

    public void openTransactionInMyTransactions(String generalType, String transactionType, String transactionName, String transactionDate){

        hold(1000);

        try {
            financialTransactionsBtn.isDisplayed();

            simpleClick(AppiumBy.accessibilityId(generalType));
            hold(500);
            if(!transactionType.equalsIgnoreCase("All")){
                simpleClick(AppiumBy.accessibilityId("All"));
                hold(500);
                simpleClick(AppiumBy.accessibilityId("All"));
                hold(200);
                clickOn(AppiumBy.accessibilityId(transactionType));
                hold(200);
                simpleClick(AppiumBy.accessibilityId("Choose"));
                hold(200);
            }
            simpleClick(AppiumBy.accessibilityId("View"));
            hold(4000);
            if(!transactionDate.isEmpty()){
                //scrollToElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]"), true, 10);
                verticalSwipeByPercentages(70, 10, 50);
                clickOn(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]"));
            }else{
                scrollToElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]"), true, 10);
                clickOn(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]"));
            }

            waitForElementToBeVisible(accessibilityId("Requested on"));


        }catch (Exception e){

            clickOn(accessibilityId(transactionType));
            hold(4000);
            verticalSwipeByPercentages(70, 10, 50);

            if(!transactionDate.isEmpty()){
                scrollToElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]"), true, 10);
                clickOn(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]"));
            }else{
                scrollToElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]"), true, 10);
                clickOn(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]"));
            }

            waitForElementToBeVisible(accessibilityId("Requested on"));

        }

    }

    public boolean checkTransactionInMyTransactions(String generalType, String transactionType, String transactionName, String transactionDate){

        hold(1000);

        try {
            financialTransactionsBtn.isDisplayed();

            simpleClick(AppiumBy.accessibilityId(generalType));
            hold(500);
            if(!transactionType.equalsIgnoreCase("All")){
                simpleClick(AppiumBy.accessibilityId("All"));
                hold(500);
                simpleClick(AppiumBy.accessibilityId("All"));
                hold(200);
                clickOn(AppiumBy.accessibilityId(transactionType));
                hold(200);
                simpleClick(AppiumBy.accessibilityId("Choose"));
                hold(200);
            }
            simpleClick(AppiumBy.accessibilityId("View"));
            hold(4000);
            verticalSwipeByPercentages(70, 50, 50);

        }catch (Exception e){

            clickOn(accessibilityId(transactionType));
            hold(4000);
            verticalSwipeByPercentages(70, 10, 50);

        }

        try{
            return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]")).isDisplayed();
        }catch (Exception e){
            return false;
        }

    }

    public void withdraw(){
        waitForElementToBeVisible(accessibilityId("Requested on"));
        //scrollToElement(withdrawBtn, true);
        verticalSwipeByPercentages(65, 10, 50);
        clickOn(withdrawBtn);
        waitLoadingElement();
        waitForElementToBeVisible(accessibilityId("Alright!"));
        clickOn(alrightBtn);
        waitForElementToBeVisible(accessibilityId("Requested on"));
    }

    public void withdraw(boolean closeAlert){
        waitForElementToBeVisible(accessibilityId("Requested on"));
        //scrollToElement(withdrawBtn, true);
        verticalSwipeByPercentages(65, 10, 50);
        clickOn(withdrawBtn);
        waitLoadingElement();
        hold(4000);
        if(closeAlert){
            closeAlert();
        }
    }

    public void cancel(){
        waitForElementToBeVisible(accessibilityId("Requested on"));
        //scrollToElement(cancelBtn, true);
        verticalSwipeByPercentages(65, 10, 50);
        clickOn(cancelBtn);
        waitLoadingElement();
        waitForElementToBeVisible(accessibilityId("Alright!"));
        clickOn(alrightBtn);
        waitForElementToBeVisible(accessibilityId("Requested on"));
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

//    public boolean checkAttachmentInVacationDetails(){
//        hold(1000);
//
//        scrollToElement(workflowDetailsText, true);
//        clickOn(attachmentInVacationDetails);
//        waitLoadingElement();
//        hold(2000);
//        waitForElementToBeVisible(AppiumBy.id("com.android.gallery3d:id/gallery_root"));
//        return appiumDriver.findElement(AppiumBy.id("com.android.gallery3d:id/gl_root_view")).isDisplayed();
//    }
//
//    public boolean checkAttachmentInLeaveDetails(){
//        hold(1000);
//        scrollToElement(additionalInformationText, true);
//        clickOn(attachmentIconInDetails);
//        waitLoadingElement();
//        hold(2000);
//        waitForElementToBeVisible(AppiumBy.id("com.android.gallery3d:id/gallery_root"));
//        return appiumDriver.findElement(AppiumBy.id("com.android.gallery3d:id/gl_root_view")).isDisplayed();
//    }
//
//    public boolean checkAttachmentInOvertimeDetails(){
//        hold(1000);
//        scrollToElement(additionalInformationText, true);
//        clickOn(attachmentIconInDetails);
//        waitLoadingElement();
//        hold(2000);
//        waitForElementToBeVisible(AppiumBy.id("com.android.gallery3d:id/gallery_root"));
//        return appiumDriver.findElement(AppiumBy.id("com.android.gallery3d:id/gl_root_view")).isDisplayed();
//    }

    public boolean checkOpenAttachment(){
        boolean check = false;
        hold(1000);
        try {
            verticalSwipeByPercentages(70, 30, 50);
            simpleClick(attachmentIconInDetails);
        }catch (Exception e){
            scrollToElement(attachmentIconInDetails, true);
            simpleClick(attachmentIconInDetails);
        }
        waitLoadingElement();
        hold(3000);

        //waitForElementToBeVisible(AppiumBy.className("android.widget.ImageView"));

        try {
            appiumDriver.findElement(AppiumBy.xpath("//*[contains(@resource-id, 'com.android.gallery')]")).isDisplayed();
            check = true;
        }catch (Exception ee){
            try {
                appiumDriver.findElement(AppiumBy.xpath("//*[contains(@resource-id, 'gallery_root')]")).isDisplayed();
                check = true;
            }catch (Exception eee){
                try {
                    appiumDriver.findElement(AppiumBy.xpath("//*[contains(@resource-id, 'gl_root_view')]")).isDisplayed();
                    check = true;
                }catch (Exception ignored){}
            }
        }

        return check;

    }

    public String getTransactionDetails(String type){

        String str = null;
        try{
            str = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+type+"')]")).getDomAttribute("content-desc");
        }catch (Exception e){
            scrollToElement(approvalCommitteeText, true);
            str = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+type+"')]")).getDomAttribute("content-desc");
        }

        if(str != null && !str.isEmpty()){
            // Find the position of the newline character
            int index = str.indexOf('\n');

            return str.substring(index + 1).trim();
        }else{
            return null;
        }

    }

    public String getTransactionReason(){

        String getReason = null;
        int startIndex = 0;
        int endIndex = 0;
        String reason = null;

        try {
            try {
                getReason = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Reason')]")).getDomAttribute("content-desc");
            }catch (Exception e){
                verticalSwipeByPercentages(70, 10, 50);
                getReason = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Reason')]")).getDomAttribute("content-desc");
            }
        }catch (Exception ee){
            try{
                getReason = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Reason')]")).getDomAttribute("content-desc");
            }catch (Exception eee){
                verticalSwipeByPercentages(70, 10, 50);
                getReason = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Reason')]")).getDomAttribute("content-desc");
            }
        }

        if(versionGetter().equalsIgnoreCase("Revamp")){
            // Find the index of the newline character
            int newlineIndex = getReason.indexOf("\n");
            // Extract the substring after the newline character
            reason = getReason.substring(newlineIndex + 1);
        }else{
            startIndex = getReason.indexOf('\n') + 1;
            endIndex = getReason.indexOf('-');

            reason = getReason.substring(startIndex, endIndex);
        }

        return reason.trim();

    }

    public void openRequestedItem(){
        scrollToElement(requestedItem_title, true);
        clickOn(requestedItem_icon);
        hold(500);
        waitForElementToBeVisible(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Status')]"));
    }

    public boolean checkInRequestedItemIfAppear(String item, String status){
        try{
            return appiumDriver.findElement(accessibilityId(item+"\n"+status)).isDisplayed();
        }catch (Exception e){
            return false;
        }

    }

    public boolean checkAttachmentIcon(){
        boolean check = false;
        try {
            if(attachmentIconInDetails.isDisplayed()){
                check = true;
            }
        }catch (Exception e){
            scrollToElement(approvalCommitteeText, true, 6);

            try {
                if(attachmentIconInDetails.isDisplayed()){
                    check = true;
                }
            }catch (Exception ignored){}

        }
        return check;
    }

}
