package mobileBackend;

import bases.BaseTest;
import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static bases.BaseTest.mobileVersion;
import static java.time.Duration.ofMillis;

public class MainScreen extends MobileBasePage {


    @AndroidFindBy(accessibility = "MainButtonSemantics")
    public WebElement requestMenuBtn;
    @AndroidFindBy(accessibility = "ProfileIcon")
    public WebElement myProfileBtn;
    @AndroidFindBy(accessibility = "MenuIcon")
    WebElement sideBarMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='MenuIcon']")
    WebElement sideBarMenu_xpath;
    @AndroidFindBy(accessibility = "MenuMSS")
    WebElement sideBarMenuManager;
    @AndroidFindBy(accessibility = "Manager")
    WebElement managerBtn;
    @AndroidFindBy(accessibility = "MSS")
    WebElement managerBtn_pro;
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
    @AndroidFindBy(xpath = "(//android.widget.ScrollView//android.view.View)[2]")
    WebElement boxesSection;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Annual Vacation')]")
    WebElement annualVacationBox;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Annual Vacation') and contains(@content-desc, 'Current Balance')]")
    WebElement annualVacation_CurrentBalanceBox;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Annual Vacation') and contains(@content-desc, 'Up To End Of Year')]")
    WebElement annualVacation_UpToEndOfYearBox;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Sick Vacation') and contains(@content-desc, 'Current Balance')]")
    WebElement sickVacation_CurrentBalanceBox;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Sick Vacation') and contains(@content-desc, 'Up To End Of Year')]")
    WebElement sickVacation_UpToEndOfYearBox;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Loan') and contains(@content-desc, 'Balance')]")
    WebElement loanBalanceAmount;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Last') and contains(@content-desc, 'Salary')]")
    WebElement lastSalaryAmount;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'STB') and contains(@content-desc, 'Balance')]")
    WebElement stbBalanceAmount;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Sick Vacation')]")
    WebElement sickVacationBox;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Loan') and contains(@content-desc, 'Balance')]")
    WebElement loanBalanceBox;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'STB') and contains(@content-desc, 'Balance')]")
    WebElement stbBalanceBox;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Last') and contains(@content-desc, 'Salary')]")
    WebElement lastSalaryBox;
    @AndroidFindBy(accessibility = "There Is No Data")
    WebElement thereIsNoDataE;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Workflow Approvals')]")
    WebElement workflowApprovals_notification;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Attention')]")
    public WebElement attentionAlertPopup;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Successfully')]")
    public WebElement successAlertPopup;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Breakdown']/following::android.view.View//android.view.View//android.widget.ImageView[1]")
    WebElement breakdownElements;


    public MainScreen(){
        ignoreUpdatePopup();
    }

    public void myRequests(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("ProfileIcon"));
        clickOn(requestMenuBtn);
        hold(200);
    }

    public void myProfile(String tab){
        waitForElementToBeVisible(AppiumBy.accessibilityId("MainButtonSemantics"));
        clickOn(myProfileBtn);
        hold(500);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Personal"));

        if(tab.equalsIgnoreCase("Personal")){
            clickOn(AppiumBy.accessibilityId("Personal"));
        }else if(tab.equalsIgnoreCase("Financial")){
            clickOn(AppiumBy.accessibilityId("Financial"));
        }else if(tab.equalsIgnoreCase("Other")){
            clickOn(AppiumBy.accessibilityId("Other"));
        }
        hold(700);
    }

    public void logout(){
        openSideMenu();
        hold(1000);
        simpleClick(logOutBtn, true);
        hold(700);
        waitLoadingElement();
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("Login"));
    }

    public void openSideMenu(){
        hold(1000);
        try {
            waitLoadingElement();
            waitLoadingElement();
            waitLoadingElement();
            waitForElementToBeClickable(sideBarMenu);
            simpleClick(sideBarMenu);
            hold(500);
        }catch (Exception e){
            try {
                simpleClick(sideBarMenu_xpath);
            }catch (Exception ee){
                try {
                    verticalSwipeByPercentages(60, 10, 50);
                    simpleClick(sideBarMenu_xpath);
                }catch (Exception eee){
                    try {
                        simpleClick(sideBarMenuManager);
                    }catch (Exception eeee){
                        try {
                            verticalSwipeByPercentages(60, 10, 50);
                            simpleClick(sideBarMenuManager);
                        }catch (Exception eeeee){
                            horizontalSwipeByPercentages(10, 90, 30);
                        }
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
        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){
            clickOn(managerBtn_pro);
        }else{
            clickOn(managerBtn);
        }
        waitLoadingElement();
        waitForElementToBeVisible(AppiumBy.accessibilityId("My Team"));
    }

    public void openNotifications(){
        waitForElementToBeVisible(AppiumBy.accessibilityId("NotificationIcon"));
        simpleClick(notification);
        waitForElementToBeVisible(AppiumBy.accessibilityId("Campaigns"));
    }

    public void goBack(int after){
        hold(after);
        back();
    }

    public boolean checkSalarySlipIfAppear() {
        boolean check = false;
        try {
            new WebDriverWait(appiumDriver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Salary Slip")));
            check = true;
        } catch (Exception ignored) {}
        return check;
    }

    public String getLastSalary(){
        try {
            String text = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Last Salary')]")).getDomAttribute("content-desc");
            String[] parts = text.split("\n");
            // The first part will be the text before the newline
            return parts[0];
        }catch (Exception e){
            WebElement scrollView = appiumDriver.findElement(AppiumBy.xpath("(//android.widget.ScrollView//android.view.View[1])[1]"));
            horizontalScrollStartedFromElement(scrollView, true, 1000);
            hold(800);
            String text = appiumDriver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Last Salary')]")).getText();
            String[] parts = text.split("\n");
            // The first part will be the text before the newline
            return parts[0];
        }
    }

    public boolean annualVacationBox(){
        hold(1000);
//        verticalSwipeByPercentages(70, 10, 50);
//        hold(500);
        boolean check = false;
        try {
            if(annualVacationBox.isDisplayed()){
                check = true;
            }
            return check;
        }catch (Exception ignored){
            return check;
        }
    }

    public boolean sickVacationBox(){
        hold(1000);
//        verticalSwipeByPercentages(70, 10, 50);
//        hold(500);
        boolean check = false;
        try {
            if(sickVacationBox.isDisplayed()){
                check = true;
            }
            return check;
        }catch (Exception ignored){
            return check;
        }
    }

    public String getCurrentBalance_AnnualVacation(){

        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){

            String input = annualVacation_CurrentBalanceBox.getDomAttribute("content-desc");
            String regex = "\\d+(\\.\\d+)?";
            String result = null;

            // Find the match
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String extractedNumber = matcher.group();
                result = extractedNumber;
            } else {
                result = "No number found!";
            }

            return result;

        }else{

            String input = annualVacation_CurrentBalanceBox.getDomAttribute("content-desc");
            String regex = "\\d+(\\.\\d+)?";
            String result = null;

            // Find the match
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String extractedNumber = matcher.group();
                result = extractedNumber;
            } else {
                result = "No number found!";
            }

            return result;
        }

    }

    public String getUpToEndOfYear_AnnualVacation(){

        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){

            String input = annualVacation_UpToEndOfYearBox.getDomAttribute("content-desc");
            String regex = "\\d+(\\.\\d+)?";
            String result = null;

            // Find the match
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                matcher.find(); /// to get the second number in the string
                String extractedNumber = matcher.group();
                result = extractedNumber;
            } else {
                result = "No number found!";
            }

            return result;

        }else{

            horizontalScrollStartedFromElement(annualVacationBox, false, 250);
            hold(700);

            try {
                annualVacation_UpToEndOfYearBox.isDisplayed();
            }catch (Exception e){
                horizontalScrollStartedFromElement(annualVacationBox, true, 250);
            }

            String input = annualVacation_UpToEndOfYearBox.getDomAttribute("content-desc");
            String regex = "\\d+(\\.\\d+)?";
            String result = null;

            // Find the match
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String extractedNumber = matcher.group();
                result = extractedNumber;
            } else {
                result = "No number found!";
            }

            return result;

        }

    }

    public String getCurrentBalance_SickVacation(){

        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){

            String input = sickVacation_CurrentBalanceBox.getDomAttribute("content-desc");
            String regex = "\\d+(\\.\\d+)?";
            String result = null;

            // Find the match
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String extractedNumber = matcher.group();
                result = extractedNumber;
            } else {
                result = "No number found!";
            }

            return result;

        }else{

            String input = sickVacation_CurrentBalanceBox.getDomAttribute("content-desc");
            String regex = "\\d+(\\.\\d+)?";
            String result = null;

            // Find the match
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String extractedNumber = matcher.group();
                result = extractedNumber;
            } else {
                result = "No number found!";
            }

            return result;

        }

    }

    public String getUpToEndOfYear_SickVacation(){

        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){

            String input = sickVacation_UpToEndOfYearBox.getDomAttribute("content-desc");
            String regex = "\\d+(\\.\\d+)?";
            String result = null;

            // Find the match
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                matcher.find();
                String extractedNumber = matcher.group();
                result = extractedNumber;
            } else {
                result = "No number found!";
            }

            return result;

        }else{

            horizontalScrollStartedFromElement(sickVacationBox, false, 250);
            hold(700);

            try {
                sickVacation_UpToEndOfYearBox.isDisplayed();
            }catch (Exception e){
                horizontalScrollStartedFromElement(sickVacationBox, true, 250);
            }

            String input = sickVacation_UpToEndOfYearBox.getDomAttribute("content-desc");
            String regex = "\\d+(\\.\\d+)?";
            String result = null;

            // Find the match
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String extractedNumber = matcher.group();
                result = extractedNumber;
            } else {
                result = "No number found!";
            }

            return result;

        }

    }

    public boolean loanBalanceBox(){

        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){

            //hold(1000);
            boolean check = false;
            try {
                if(loanBalanceBox.isDisplayed()){
                    check = true;
                }
                return check;
            }catch (Exception e){
                try {
                    horizontalScrollStartedFromElement(annualVacationBox, true, 700);
                    hold(700);
                    if(loanBalanceBox.isDisplayed()){
                        check = true;
                    }
                    return check;
                }catch (Exception ignored){
                    return check;
                }
            }

        }else{

            hold(1000);
            boolean check = false;
            try {
                if(loanBalanceBox.isDisplayed()){
                    check = true;
                }
                return check;
            }catch (Exception e){
                try {
                    horizontalScrollStartedFromElement(annualVacationBox, true);
                    hold(700);
                    if(loanBalanceBox.isDisplayed()){
                        check = true;
                    }
                    return check;
                }catch (Exception ignored){
                    return check;
                }
            }

        }

    }

    public String loanBalanceAmount(){

        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){

            if(loanBalanceBox()){

                String input = loanBalanceAmount.getDomAttribute("content-desc");
                String regex = "\\d+(\\.\\d+)?";
                String result = null;

                // Find the match
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
                java.util.regex.Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    String extractedNumber = matcher.group();
                    result = extractedNumber;
                } else {
                    result = "No number found!";
                }

                return result;
            }else{
                return "Loan box not appear to find the amount!";
            }

        }else{

            if(loanBalanceBox()){

                String input = loanBalanceAmount.getDomAttribute("content-desc");
                String regex = "\\d+(\\.\\d+)?";
                String result = null;

                // Find the match
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
                java.util.regex.Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    String extractedNumber = matcher.group();
                    result = extractedNumber;
                } else {
                    result = "No number found!";
                }

                return result;
            }else{
                return "Loan box not appear to find the amount!";
            }

        }

    }

    public boolean stbBalanceBox(){

        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){

            //hold(1000);
            boolean check = false;
            try {
                if(stbBalanceBox.isDisplayed()){
                    check = true;
                }
                return check;
            }catch (Exception e){
                try {
                    horizontalScrollStartedFromElement(annualVacationBox, true, 700);
                    hold(700);
                    if(stbBalanceBox.isDisplayed()){
                        check = true;
                    }
                    return check;
                }catch (Exception ex){
                    try {
                        horizontalScrollStartedFromElement(loanBalanceBox, true, 400);
                        hold(700);
                        if(stbBalanceBox.isDisplayed()){
                            check = true;
                        }
                        return check;
                    }catch (Exception ignored){
                        return check;
                    }
                }
            }

        }else{

            hold(1000);
            boolean check = false;
            try {
                if(stbBalanceBox.isDisplayed()){
                    check = true;
                }
                return check;
            }catch (Exception e){
                try {
                    horizontalScrollStartedFromElement(annualVacationBox, true);
                    hold(700);
                    if(stbBalanceBox.isDisplayed()){
                        check = true;
                    }
                    return check;
                }catch (Exception ex){
                    try {
                        horizontalScrollStartedFromElement(loanBalanceBox, true, 400);
                        hold(700);
                        if(stbBalanceBox.isDisplayed()){
                            check = true;
                        }
                        return check;
                    }catch (Exception ignored){
                        return check;
                    }
                }
            }

        }

    }

    public void openSTBBalanceBox(){

        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){

            //hold(1000);
            try {
                if(stbBalanceBox.isDisplayed()){
                    simpleClick(stbBalanceBox);
                }
            }catch (Exception e){
                try {
                    horizontalScrollStartedFromElement(annualVacationBox, true, 700);
                    hold(700);
                    if(stbBalanceBox.isDisplayed()){
                        simpleClick(stbBalanceBox);
                    }
                }catch (Exception ex){
                    try {
                        horizontalScrollStartedFromElement(loanBalanceBox, true, 400);
                        hold(700);
                        if(stbBalanceBox.isDisplayed()){
                            simpleClick(stbBalanceBox);
                        }
                    }catch (Exception exc){
                        exc.printStackTrace();
                    }
                }
            }

        }else{

            hold(1000);
            try {
                if(stbBalanceBox.isDisplayed()){
                    simpleClick(stbBalanceBox);
                }
            }catch (Exception e){
                try {
                    horizontalScrollStartedFromElement(annualVacationBox, true);
                    hold(700);
                    if(stbBalanceBox.isDisplayed()){
                        simpleClick(stbBalanceBox);
                    }
                }catch (Exception ex){
                    try {
                        horizontalScrollStartedFromElement(loanBalanceBox, true, 400);
                        hold(700);
                        if(stbBalanceBox.isDisplayed()){
                            simpleClick(stbBalanceBox);
                        }
                    }catch (Exception exc){
                        exc.printStackTrace();
                    }
                }
            }

        }

    }

    public boolean stbBalanceIsEmpty(){
        waitLoadingElement();
        hold(1000);
        try {
            return thereIsNoDataE.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public String getSTBBalance(String key) {

        String input = null;

        try {
            input = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'STB Amount')]")).getDomAttribute("content-desc").trim();
        }catch (Exception e){
            try {
                waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'STB Amount')]"));
                input = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'STB Amount')]")).getDomAttribute("content-desc").trim();
            }catch (Exception ee){
                ee.printStackTrace();
            }
        }

        String[] lines = input.split("\\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();

            // Special case: "Up-to-date-Balance" — value comes before
            if (key.equalsIgnoreCase("STB Amount") && line.equalsIgnoreCase(key) && i > 0) {
                return lines[i - 1].trim();
            }
            // Default case — value comes after
            if (line.equalsIgnoreCase(key) && i < lines.length - 1) {
                return lines[i + 1].trim();
            }
        }
        return null;
    }

    public String stbBalanceAmount(){

        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){

            if(stbBalanceBox()){

                String input = stbBalanceAmount.getDomAttribute("content-desc");
                String regex = "\\d+(\\.\\d+)?";
                String result = null;

                // Find the match
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
                java.util.regex.Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    String extractedNumber = matcher.group();
                    result = extractedNumber;
                } else {
                    result = "No number found!";
                }

                return result;
            }else{
                return "STB box not appear to find the amount!";
            }

        }else{

            if(stbBalanceBox()){

                String input = stbBalanceAmount.getDomAttribute("content-desc");
                String regex = "\\d+(\\.\\d+)?";
                String result = null;

                // Find the match
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
                java.util.regex.Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    String extractedNumber = matcher.group();
                    result = extractedNumber;
                } else {
                    result = "No number found!";
                }

                return result;
            }else{
                return "STB box not appear to find the amount!";
            }

        }

    }

    public boolean lastSalaryBox(){

        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){

            //hold(1000);
            boolean check = false;
            try {
                horizontalScrollStartedFromElement(breakdownElements, true, 2000);
                hold(700);
                if(lastSalaryBox.isDisplayed()){
                    check = true;
                }
                return check;
            }catch (Exception ee){
                return check;
            }

        }else{

            hold(1000);
            boolean check = false;
            try {
                if(lastSalaryBox.isDisplayed()){
                    check = true;
                }
                return check;
            }catch (Exception e){
                try {
                    horizontalScrollStartedFromElement(annualVacationBox, true);
                    hold(700);
                    if(lastSalaryBox.isDisplayed()){
                        check = true;
                    }
                    return check;
                }catch (Exception ee){
                    try {
                        horizontalScrollStartedFromElement(loanBalanceBox, true);
                        hold(700);
                        if(lastSalaryBox.isDisplayed()){
                            check = true;
                        }
                        return check;
                    }catch (Exception ignored){
                        return check;
                    }
                }
            }

        }

    }

    public String lastSalaryAmount(){

        if(mobileVersion == BaseTest.MobileVersion.MenaMEPro){

            if(lastSalaryBox()){

                String input = lastSalaryAmount.getDomAttribute("content-desc");
                String regex = "\\d+(\\.\\d+)?";
                String result = null;

                // Find the match
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
                java.util.regex.Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    String extractedNumber = matcher.group();
                    result = extractedNumber;
                } else {
                    result = "No number found!";
                }

                return result;

            }else{
                return "Last Salary box not appear to find the amount!";
            }

        }else{

            if(lastSalaryBox()){
                try {
                    lastSalaryBox.isDisplayed();
                }catch (Exception e){
                    horizontalScrollStartedFromElement(annualVacationBox, true);
                    hold(700);
                }

                String input = lastSalaryAmount.getDomAttribute("content-desc");
                String regex = "\\d+(\\.\\d+)?";
                String result = null;

                // Find the match
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
                java.util.regex.Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    String extractedNumber = matcher.group();
                    result = extractedNumber;
                } else {
                    result = "No number found!";
                }

                return result;

            }else{
                return "Last Salary box not appear to find the amount!";
            }

        }

    }

}
