package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static utilities.PDFReader.pdfFileReader;

public class MyProfileFinancial extends MobileBasePage {

    @AndroidFindBy(accessibility = "Financial")
    WebElement financialTab;
    @AndroidFindBy(accessibility = "Salary Slip")
    WebElement salarySlipTap;
    @AndroidFindBy(accessibility = "Tax Sheet")
    WebElement taxSheetTab;
    @AndroidFindBy(accessibility = "PF Balance")
    WebElement pfBalanceTab;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='From']//android.widget.ImageView[1]")
    WebElement from_pfBalance;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='To']//android.widget.ImageView[1]")
    WebElement to_pfBalance;
    @AndroidFindBy(accessibility = "Download")
    WebElement downloadBtn;

    public void openSalarySlip(){
        clickOn(financialTab);
        hold(800);
        clickOn(salarySlipTap);
        waitLoadingElement();
    }
    public void openTaxSheet(){
        clickOn(financialTab);
        hold(800);
        clickOn(taxSheetTab);
        waitLoadingElement();
    }
    public void openPfBalance(){
        clickOn(financialTab);
        hold(800);
        clickOn(pfBalanceTab);
        waitLoadingElement();
    }

    public void getTaxSheet(String year){
        hold(1000);
        clickOn(AppiumBy.accessibilityId(year));
        hold(500);
        waitLoadingElement();
        waitLoadingElement();
    }

    public String getAmountFromTaxSheetPdf(String employeeCode, String keyword){

        // Search for the keyword and extract the amount
        String[] lines = pdfFileReader("pdfFiles/"+employeeCode+"TAX"+".pdf").split("\\n");
        for (String line : lines) {
            if (line.contains(keyword)) {
                // Split the line and extract Dinar and Fils
                String[] parts = line.split("\\s+");
                if (parts.length > 2) {
                    String dinar = parts[parts.length - 2]; // Second last part
                    String fils = parts[parts.length - 1];  // Last part
                    return dinar + "." + fils;
                }
            }
        }
        // Return null if the keyword is not found
        return null;

    }

    public void saveTaxPdfInDevice(String fileName){

        try {
            hold(5000);
            appiumDriver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text, 'ALWAYS')]")).isDisplayed();
            simpleClick(appiumDriver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text, 'ALWAYS')]")));
        }catch (Exception ignored){}

        try {
            waitForElementToBeVisible(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Sign in')]"), 6);
            try {
                simpleClick(AppiumBy.accessibilityId("Cancel"));
            }catch (Exception cancel){
                simpleClick(AppiumBy.accessibilityId("Cross Button"));
            }

            hold(1000);
            waitForElementToBeClickable(AppiumBy.accessibilityId("More options"));
            clickOn(AppiumBy.accessibilityId("More options"));
            hold(2000);
            verticalSwipeByPercentages(70, 20, 50);
            verticalSwipeByPercentages(70, 20, 50);
            doubleClick(AppiumBy.xpath("//android.widget.TextView[@text='Save a copy']"));
            hold(1500);
            try {
                simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On this device']"));
            }catch (Exception device){
                simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On This Device']"));
            }
            hold(500);
            appiumDriver.findElement(AppiumBy.className("android.widget.EditText")).clear();
            hold(200);
            setText(appiumDriver.findElement(AppiumBy.className("android.widget.EditText")), fileName+"TAX");
            hold(200);
            clickOn(AppiumBy.xpath("//android.widget.Button[@text='Done']"));
            hold(500);

        }catch (Exception cross){
            try{
                hold(1000);
                waitForElementToBeClickable(AppiumBy.accessibilityId("More options"));
                clickOn(AppiumBy.accessibilityId("More options"));
                hold(2000);
                verticalSwipeByPercentages(70, 20, 50);
                verticalSwipeByPercentages(70, 20, 50);
                doubleClick(AppiumBy.xpath("//android.widget.TextView[@text='Save a copy']"));
                hold(1500);
                try {
                    simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On this device']"));
                }catch (Exception device){
                    simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On This Device']"));
                }
                hold(500);
                appiumDriver.findElement(AppiumBy.className("android.widget.EditText")).clear();
                hold(200);
                setText(appiumDriver.findElement(AppiumBy.className("android.widget.EditText")), fileName);
                hold(200);
                clickOn(AppiumBy.xpath("//android.widget.Button[@text='Done']"));
                hold(500);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }

    public void downloadPfBalance(String from, String to){
        hold(1000);
        if(!from.isEmpty()){
            clickOn(from_pfBalance);
            hold(500);
            datePicker(from);
            waitLoadingElement();
        }
        hold(800);
        if(!to.isEmpty()){
            clickOn(to_pfBalance);
            hold(500);
            datePicker(to);
            waitLoadingElement();
        }
        hold(800);
        clickOn(downloadBtn);
        waitLoadingElement();
        waitLoadingElement();
    }

    public void savePfBalancePdfInDevice(String fileName){

        try {
            hold(5000);
            appiumDriver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text, 'ALWAYS')]")).isDisplayed();
            simpleClick(appiumDriver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text, 'ALWAYS')]")));
        }catch (Exception ignored){}

        try {
            waitForElementToBeVisible(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Sign in')]"), 6);
            try {
                simpleClick(AppiumBy.accessibilityId("Cancel"));
            }catch (Exception cancel){
                simpleClick(AppiumBy.accessibilityId("Cross Button"));
            }

            hold(1000);
            waitForElementToBeClickable(AppiumBy.accessibilityId("More options"));
            clickOn(AppiumBy.accessibilityId("More options"));
            hold(2000);
            verticalSwipeByPercentages(70, 20, 50);
            verticalSwipeByPercentages(70, 20, 50);
            doubleClick(AppiumBy.xpath("//android.widget.TextView[@text='Save a copy']"));
            hold(1500);
            try {
                simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On this device']"));
            }catch (Exception device){
                simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On This Device']"));
            }
            hold(500);
            appiumDriver.findElement(AppiumBy.className("android.widget.EditText")).clear();
            hold(200);
            setText(appiumDriver.findElement(AppiumBy.className("android.widget.EditText")), fileName+"PF");
            hold(200);
            clickOn(AppiumBy.xpath("//android.widget.Button[@text='Done']"));
            hold(500);

        }catch (Exception cross){
            try{
                hold(1000);
                waitForElementToBeClickable(AppiumBy.accessibilityId("More options"));
                clickOn(AppiumBy.accessibilityId("More options"));
                hold(2000);
                verticalSwipeByPercentages(70, 20, 50);
                verticalSwipeByPercentages(70, 20, 50);
                doubleClick(AppiumBy.xpath("//android.widget.TextView[@text='Save a copy']"));
                hold(1500);
                try {
                    simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On this device']"));
                }catch (Exception device){
                    simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='On This Device']"));
                }
                hold(500);
                appiumDriver.findElement(AppiumBy.className("android.widget.EditText")).clear();
                hold(200);
                setText(appiumDriver.findElement(AppiumBy.className("android.widget.EditText")), fileName);
                hold(200);
                clickOn(AppiumBy.xpath("//android.widget.Button[@text='Done']"));
                hold(500);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }

    public String getValueFromPfBalancePdf(String employeeCode, String description, String date, String fieldName) {
        String[] lines = pdfFileReader("pdfFiles/"+employeeCode+"PF"+".pdf").split("\n");
        for (String line : lines) {
            if (line.contains(description) && line.contains(date)) {
                String[] columns = line.split("\\s+"); // Adjust split logic based on table structure
                String debit = columns[columns.length - 4];
                String credit = columns[columns.length - 3];
                String pfCurrentBalance = columns[columns.length - 2];
                String balance = columns[columns.length - 1];

                // Return the value based on the requested field name
                switch (fieldName.toLowerCase()) {
                    case "debit":
                        return debit;
                    case "credit":
                        return credit;
                    case "pf current balance":
                        return pfCurrentBalance;
                    case "balance":
                        return balance;
                    default:
                        return "Invalid field name.";
                }
            }
        }
        return "No matching transaction found.";
    }


}
