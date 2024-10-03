package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.AppiumBy.accessibilityId;

public class MyTransactions extends MobileBasePage {

    @AndroidFindBy(accessibility = "Approval Committee")
    WebElement approvalCommitteeText;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Attachments']/following::android.widget.ImageView)[1]")
    public WebElement attachmentInVacationDetails;
    @AndroidFindBy(accessibility = "Attachments")
    WebElement attachments_title;
    @AndroidFindBy(accessibility = "Alright!")
    WebElement alrightBtn;
    @AndroidFindBy(accessibility = "Cancel")
    WebElement cancelBtn;
    @AndroidFindBy(accessibility = "Workflow Details")
    WebElement workflowDetailsText;
    @AndroidFindBy(accessibility = "Withdraw")
    WebElement withdrawBtn;


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
        String textBetweenNewlines = null;
        try{
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
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
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
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
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
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
            String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
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
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
                if (det != null) {
                    int lastNewline = det.lastIndexOf("\n");
                    String textAfterLastNewline = det.substring(lastNewline + 1).trim();
                    date = textAfterLastNewline.substring(0, 10);
                }
                return date;
            }catch (Exception ex){
                scrollToElement(approvalCommitteeText, true);
                hold(200);
                String det = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+managerName+"')]")).getAttribute("content-desc");
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

    public void openTransactionInMyTransactions(String transactionType, String transactionName, String transactionDate){

        clickOn(AppiumBy.accessibilityId(transactionType));
        hold(4000);
        verticalSwipeByPercentages(70, 10, 50);

        if(!transactionDate.isEmpty()){
            scrollToElement(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]")), true);
            clickOn(appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+transactionName+"') and contains(@content-desc, '"+transactionDate+"')]")));
        }else{
            scrollToElement(appiumDriver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]")), true);
            clickOn(appiumDriver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+transactionName+"')])[1]")));
        }

        waitForElementToBeVisible(AppiumBy.accessibilityId("Requested on"));

    }

    public void withdraw(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("Requested on"));
        scrollToElement(withdrawBtn, true);
        clickOn(withdrawBtn);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("Alright!"));
        clickOn(alrightBtn);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Requested on"));
    }

    public void cancel(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("Requested on"));
        scrollToElement(cancelBtn, true);
        clickOn(cancelBtn);
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("Alright!"));
        clickOn(alrightBtn);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Requested on"));
    }

    public boolean checkAttachmentInVacationDetails(){
        hold(1000);

        scrollToElement(workflowDetailsText, true);
        clickOn(attachmentInVacationDetails);
        waitLoadingElement();
        hold(2000);
        waitForElementToBeVisible(AppiumBy.id("com.android.gallery3d:id/gallery_root"));
        return appiumDriver.findElement(AppiumBy.id("com.android.gallery3d:id/gl_root_view")).isDisplayed();
    }

    public String getTransactionDetails(String type){

        String str = null;
        try{
            str = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+type+"')]")).getAttribute("content-desc");
        }catch (Exception e){
            scrollToElement(approvalCommitteeText, true);
            str = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+type+"')]")).getAttribute("content-desc");
        }

        if(str != null && !str.isEmpty()){
            // Find the position of the newline character
            int index = str.indexOf('\n');

            return str.substring(index + 1);
        }else{
            return null;
        }

    }

    public String getTransactionReason(){

        String getReason = null;

        try{
            getReason = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Reason')]")).getAttribute("content-desc");
        }catch (Exception e){
            scrollToElement(workflowDetailsText, true);
            getReason = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Reason')]")).getAttribute("content-desc");
        }

        int startIndex = getReason.indexOf('\n') + 1;
        int endIndex = getReason.indexOf('-');

        return getReason.substring(startIndex, endIndex);

    }

}
