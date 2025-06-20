package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyProfileOther extends MobileBasePage {

    @AndroidFindBy(accessibility = "Other")
    WebElement otherTab;
    @AndroidFindBy(accessibility = "Vacation Balance")
    WebElement vacationBalanceTab;
    @AndroidFindBy(accessibility = "Company Documents")
    WebElement companyDocumentsTab;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='To Date']//android.widget.ImageView[1]")
    WebElement toDate_vb;
    @AndroidFindBy(accessibility = "View")
    WebElement viewBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Search']/following::android.widget.EditText[1]")
    WebElement searchF;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Type']/following::android.view.View[1]")
    WebElement typeF;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Classification']/following::android.view.View[1]")
    WebElement classificationF;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Level']/following::android.view.View[1]")
    WebElement levelF;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='From Date']/following::android.widget.ImageView[1]")
    WebElement fromDate_cd;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='To Date']/following::android.widget.ImageView[2]")
    WebElement toDate_cd;
    @AndroidFindBy(accessibility = "Display")
    WebElement displayBtn;


    public void openVacationBalance(){
        clickOn(otherTab);
        hold(800);
        clickOn(vacationBalanceTab);
        waitLoadingElement();
    }
    public void openCompanyDocuments(){
        clickOn(otherTab);
        hold(800);
        clickOn(companyDocumentsTab);
        waitLoadingElement();
    }

    public void viewVacationBalance(String toDate){
        hold(1000);
        if(!toDate.isEmpty()){
            clickOn(toDate_vb);
            hold(500);
            datePicker(toDate);
            waitLoadingElement();
        }
        hold(800);
        clickOn(viewBtn);
        waitLoadingElement();
        waitLoadingElement();
        hold(1000);
    }

    public String getVacationBalance(String vacationType, String key) {

        String input = null;

        try {
            appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+vacationType+"')]")).isDisplayed();
            input = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+vacationType+"')]")).getDomAttribute("content-desc").trim();
        }catch (Exception e){
            try {
                scrollToElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+vacationType+"')]"), true, 5);
                appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+vacationType+"')]")).isDisplayed();
                input = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+vacationType+"')]")).getDomAttribute("content-desc").trim();
            }catch (Exception ee){
                verticalSwipeByPercentages(70, 10, 50);
                appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+vacationType+"')]")).isDisplayed();
                input = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, '"+vacationType+"')]")).getDomAttribute("content-desc").trim();
            }
        }

        String[] lines = input.split("\\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();

            // Special case: "Up-to-date-Balance" — value comes before
            if (key.equalsIgnoreCase("Up-to-date-Balance") && line.equalsIgnoreCase(key) && i > 0) {
                return lines[i - 1].trim();
            }

            // Special case: "Year" — return the line number 2 - after Vacation Name
            if (key.equalsIgnoreCase("Year")) {
                return lines[1].trim();
            }

            // Default case — value comes after
            if (line.equalsIgnoreCase(key) && i < lines.length - 1) {
                return lines[i + 1].trim();
            }
        }
        return null;
    }

    public void viewCompanyDocuments(String search, String type, String classification, String level, String fromDate, String toDate){

        waitLoadingElement();
        waitLoadingElement();
        hold(800);
        if(!search.isEmpty()){
            setText(searchF, search);
        }
        if(!type.isEmpty()){
            clickOn(typeF);
            hold(800);
            clickOn(AppiumBy.accessibilityId(type));
            hold(500);
            waitLoadingElement();
        }
        if(!classification.isEmpty()){
            clickOn(classificationF);
            hold(800);
            clickOn(AppiumBy.accessibilityId(classification));
            hold(500);
            waitLoadingElement();
        }
        if(!classification.isEmpty()){
            clickOn(classificationF);
            hold(800);
            clickOn(AppiumBy.accessibilityId(classification));
            hold(500);
            waitLoadingElement();
        }
        if(!level.isEmpty()){
            clickOn(levelF);
            hold(800);
            clickOn(AppiumBy.accessibilityId(level));
            hold(500);
            waitLoadingElement();
        }
        if(!fromDate.isEmpty()){
            clickOn(fromDate_cd);
            hold(500);
            datePicker(fromDate);
            waitLoadingElement();
        }
        if(!toDate.isEmpty()){
            clickOn(toDate_cd);
            hold(500);
            datePicker(toDate);
            waitLoadingElement();
        }

        clickOn(displayBtn);
        hold(500);
        waitLoadingElement();

    }

    public boolean checkCompanyDocumentIfExist(String documentName){
        return scrollToElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, '"+documentName+"')]"), true, 5);
    }



}
