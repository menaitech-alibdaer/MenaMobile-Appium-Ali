package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class ChangeTransactions extends WebBase {

    @FindBy(xpath = "//a[contains(@href, 'Transaction_classification.php')]")
    WebElement classificationTab;
    @FindBy(xpath = "//a[contains(@href, 'Transaction_manager.php')]")
    WebElement directManagerTab;
    @FindBy(xpath = "//a[contains(@href, 'Transaction_contract.php')]")
    WebElement jobContractTab;
    @FindBy(xpath = "//a[contains(@href, 'Transaction_card_id.php')]")
    WebElement cardIdTab;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(id = "site_1")
    WebElement siteE;
    @FindBy(id = "department_1")
    WebElement departmentE;
    @FindBy(id = "section_1")
    WebElement sectionE;
    @FindBy(id = "division_1")
    WebElement divisionE;
    @FindBy(id = "units_1")
    WebElement unitsE;
    @FindBy(id = "sub_section_1")
    WebElement subSectionE;
    @FindBy(id = "sub_division_1")
    WebElement subDivisionE;
    @FindBy(id = "sub_unit_1")
    WebElement subUnitE;
    @FindBy(id = "office_1")
    WebElement officeE;
    @FindBy(id = "team_1")
    WebElement teamE;
    @FindBy(id = "position_1")
    WebElement positionE;
    @FindBy(name = "classification")
    WebElement classificationE;
    @FindBy(name = "degree")
    WebElement degreeE;
    @FindBy(id = "year_count")
    WebElement stepE;
    @FindBy(name = "FDimension")
    WebElement category1E;
    @FindBy(name = "SDimension")
    WebElement category2E;
    @FindBy(xpath = "//table[@class='collapsetable']//tr[1]//td[4]")
    WebElement checkPostedInTable;
    @FindBy(id = "transaction_date")
    WebElement transactionDateE;
    @FindBy(id = "New_Value_Roster")
    WebElement rosterOpt;
    @FindBy(id = "New_Value_Regular")
    WebElement regularOpt;
    @FindBy(id = "transaction_reference")
    WebElement transactionReferenceE;
    @FindBy(name = "manager_code")
    WebElement directManagerE;
    @FindBy(id = "contract_type")
    WebElement contractTypeE;
    @FindBy(id = "New_Value_1")
    WebElement contractTransactionType;
    @FindBy(id = "startDate")
    WebElement startDateContract;
    @FindBy(id = "body_frame")
    WebElement frame;
    @FindBy(name = "iframes")
    WebElement iframeItems;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "MenuNewButton")
    WebElement menuNew;
    @FindBy(name = "post")
    WebElement menuPost;
    @FindBy(id = "MenuUnpostButton")
    WebElement menuUnpost;
    public String getTransactionDate;

    public void location(String employeeCode, String transactionReference, String transactionDate, String site, String department, String section,
                                          String division, String unit, String subSection, String subDivision, String subUnit, String office, String team, String position){

        hold(500);
        goToFrame(frame);
        elementWaitAdvanced(By.id("site_1"));
        if(empCode.getDomAttribute("value").isEmpty()){
            setText(empCode, employeeCode);
            hold(300);
            setText(empCode, Keys.TAB);
        }
        driver.switchTo().defaultContent();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuNew);
        hold(300);
        driver.switchTo().defaultContent();
        goToFrame(frame);
        hold(200);
        elementWaitAdvanced(By.xpath("//font[@color='maroon']"));
        getTransactionDate = transactionDateE.getDomAttribute("value");
        if(!transactionReference.isEmpty()){
            setText(transactionReferenceE, transactionReference);
            setText(transactionReferenceE, Keys.TAB);
            hold(300);
        }
        if(!transactionDate.isEmpty()){
            getTransactionDate = transactionDate;
            transactionDateE.clear();
            hold(300);
            setText(transactionDateE, transactionDate);
            hold(300);
        }
        if(!site.isEmpty()){
            new Select(siteE).selectByVisibleText(site);
            hold(300);
        }
        if(!department.isEmpty()){
            new Select(departmentE).selectByVisibleText(department);
            hold(300);
        }
        if(!section.isEmpty()){
            new Select(sectionE).selectByVisibleText(section);
            hold(300);
        }
        if(!division.isEmpty()){
            new Select(divisionE).selectByVisibleText(division);
            hold(300);
        }
        if(!unit.isEmpty()){
            new Select(unitsE).selectByVisibleText(unit);
            hold(300);
        }
        if(!subSection.isEmpty()){
            new Select(subSectionE).selectByVisibleText(subSection);
            hold(300);
        }
        if(!subDivision.isEmpty()){
            new Select(subDivisionE).selectByVisibleText(subDivision);
            hold(300);
        }
        if(!subUnit.isEmpty()){
            new Select(subUnitE).selectByVisibleText(subUnit);
            hold(300);
        }
        if(!office.isEmpty()){
            new Select(officeE).selectByVisibleText(office);
            hold(300);
        }
        if(!team.isEmpty()){
            new Select(teamE).selectByVisibleText(team);
            hold(300);
        }
        if(!position.isEmpty()){
            new Select(positionE).selectByVisibleText(position);
            hold(300);
        }

        driver.switchTo().defaultContent();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(1000);
        clickOn(menuPost);
        hold(300);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        driver.switchTo().defaultContent();
        goToFrame(frame);
        hold(200);
        goToFrame(iframeItems);
        hold(300);
        Assert.assertEquals(checkPostedInTable.getText().trim(), "Yes", "- Transaction NOT Posted");
        driver.switchTo().defaultContent();

        setLog("change location - "+"Employee Code: "+employeeCode);

    }

    public void classification(String employeeCode, String transactionReference, String transactionDate,
                               String classification, String degree, String step, String category1, String category2){

        hold(500);
        goToFrame(frame);
        clickOn(classificationTab);
        hold(500);
        elementWaitAdvanced(By.name("classification"));
        if(empCode.getDomAttribute("value").isEmpty()){
            setText(empCode, employeeCode);
            hold(300);
            setText(empCode, Keys.TAB);
        }
        driver.switchTo().defaultContent();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuNew);
        hold(300);
        driver.switchTo().defaultContent();
        goToFrame(frame);
        hold(300);
        elementWaitAdvanced(By.xpath("//font[@color='maroon']"));
        getTransactionDate = transactionDateE.getDomAttribute("value");
        if(!transactionReference.isEmpty()){
            setText(transactionReferenceE, transactionReference);
            setText(transactionReferenceE, Keys.TAB);
            hold(300);
        }
        if(!transactionDate.isEmpty()){
            getTransactionDate = transactionDate;
            transactionDateE.clear();
            hold(300);
            setText(transactionDateE, transactionDate);
            hold(300);
        }
        if(!classification.isEmpty()){
            new Select(classificationE).selectByVisibleText(classification);
            hold(300);
        }
        if(!degree.isEmpty()){
            new Select(degreeE).selectByVisibleText(degree);
            hold(300);
        }
        if(!step.isEmpty()){
            stepE.clear();
            hold(300);
            setText(stepE, step);
            hold(300);
        }
        if(!category1.isEmpty()){
            new Select(category1E).selectByVisibleText(category1);
            hold(300);
        }
        if(!category2.isEmpty()){
            new Select(category2E).selectByVisibleText(category2);
            hold(300);
        }

        driver.switchTo().defaultContent();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(300);
        clickOn(menuPost);
        hold(500);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        driver.switchTo().defaultContent();
        goToFrame(frame);
        hold(200);
        goToFrame(iframeItems);
        hold(300);
        Assert.assertEquals(checkPostedInTable.getText().trim(), "Yes", "- Transaction NOT Posted");
        driver.switchTo().defaultContent();

        setLog("change classification - "+"Employee Code: "+employeeCode);

    }

    public void directManager(String employeeCode, String transactionReference, String transactionDate,
                               String directManager){

        hold(500);
        goToFrame(frame);
        clickOn(directManagerTab);
        hold(500);
        elementWaitAdvanced(By.name("manager_code"));
        if(empCode.getDomAttribute("value").isEmpty()){
            setText(empCode, employeeCode);
            hold(300);
            setText(empCode, Keys.TAB);
        }
        driver.switchTo().defaultContent();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuNew);
        hold(300);
        driver.switchTo().defaultContent();
        goToFrame(frame);
        hold(300);
        elementWaitAdvanced(By.xpath("//font[@color='maroon']"));
        getTransactionDate = transactionDateE.getDomAttribute("value");
        if(!transactionReference.isEmpty()){
            setText(transactionReferenceE, transactionReference);
            setText(transactionReferenceE, Keys.TAB);
            hold(300);
        }
        if(!transactionDate.isEmpty()){
            getTransactionDate = transactionDate;
            transactionDateE.clear();
            hold(300);
            setText(transactionDateE, transactionDate);
            hold(200);
        }

        directManagerE.clear();
        hold(300);
        setText(directManagerE, directManager);
        hold(200);
        setText(directManagerE, Keys.TAB);
        hold(500);

        driver.switchTo().defaultContent();
        goToFrame(menuFrame);
        hold(300);
        clickOn(menuSave);
        hold(300);
        clickOn(menuPost);
        hold(300);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        driver.switchTo().defaultContent();
        goToFrame(frame);
        hold(200);
        goToFrame(iframeItems);
        hold(300);
        Assert.assertEquals(checkPostedInTable.getText().trim(), "Yes", "- Transaction NOT Posted");
        driver.switchTo().defaultContent();

        setLog("change Direct Manager - "+"Employee Code: "+employeeCode);

    }

    public void jobContract(String employeeCode, String transactionReference, String transactionDate,
                              String contractType){

        hold(500);
        goToFrame(frame);
        clickOn(jobContractTab);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date"));
        if(empCode.getDomAttribute("value").isEmpty()){
            setText(empCode, employeeCode);
            hold(300);
            setText(empCode, Keys.TAB);
        }
        driver.switchTo().defaultContent();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuNew);
        hold(300);
        driver.switchTo().defaultContent();
        goToFrame(frame);
        hold(300);
        elementWaitAdvanced(By.xpath("//font[@color='maroon']"));
        getTransactionDate = transactionDateE.getDomAttribute("value");
        if(!transactionReference.isEmpty()){
            setText(transactionReferenceE, transactionReference);
            setText(transactionReferenceE, Keys.TAB);
            hold(300);
        }
        if(!transactionDate.isEmpty()){
            getTransactionDate = transactionDate;
            transactionDateE.clear();
            hold(300);
            setText(transactionDateE, transactionDate);
            hold(200);
        }
        new Select(contractTransactionType).selectByVisibleText("Change");
        hold(300);
        if(!contractType.isEmpty() && contractTypeE.isEnabled()){
            new Select(contractTypeE).selectByVisibleText(contractType);
        }
        hold(1000);
        setText(contractTypeE, Keys.TAB);
        hold(3000);
        selectAllText(startDateContract);
        hold(500);
        setText(startDateContract, getTransactionDate);
        setText(startDateContract, Keys.TAB);
        hold(500);
        driver.switchTo().defaultContent();
        goToFrame(menuFrame);
        hold(300);
        clickOn(menuSave);
        hold(300);
        clickOn(menuPost);
        hold(300);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        driver.switchTo().defaultContent();
        goToFrame(frame);
        hold(200);
        goToFrame(iframeItems);
        hold(300);
        Assert.assertEquals(checkPostedInTable.getText().trim(), "Yes", "- Transaction NOT Posted");
        driver.switchTo().defaultContent();

        setLog("change Job Contract - "+"Employee Code: "+employeeCode);

    }

    public void cardId(String employeeCode, String transactionDate, String attendanceTypeNew){

        hold(500);
        goToFrame(frame);
        clickOn(cardIdTab);
        hold(500);
        elementWaitAdvanced(By.id("transaction_date"));
        if(empCode.getDomAttribute("value").isEmpty()){
            setText(empCode, employeeCode);
            hold(300);
            setText(empCode, Keys.TAB);
        }
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuNew);
        hold(300);
        closeIFrame();
        goToFrame(frame);
        hold(300);
        if(!transactionDate.isEmpty()){
            transactionDateE.clear();
            hold(200);
            setText(transactionDateE, transactionDate);
        }
        if(!attendanceTypeNew.isEmpty()){
            if(attendanceTypeNew.equalsIgnoreCase("Roster")){
                clickOn(rosterOpt);
            }else if(attendanceTypeNew.equalsIgnoreCase("Regular Shift") || attendanceTypeNew.equalsIgnoreCase("Regular")){
                clickOn(regularOpt);
            }
        }
        hold(200);
        closeIFrame();
        goToFrame(menuFrame);
        hold(300);
        clickOn(menuSave);
        hold(300);
        closeIFrame();
        goToFrame(frame);
        goToFrame(iframeItems);
        waitElementClickable(checkPostedInTable);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuPost);
        hold(300);
        alertWait();
        Alert alert = driver.switchTo().alert();
        hold(500);
        alert.accept();
        driver.switchTo().defaultContent();
        goToFrame(frame);
        hold(200);
        goToFrame(iframeItems);
        hold(300);
        Assert.assertEquals(checkPostedInTable.getText().trim(), "Yes", "- Transaction NOT Posted");
        closeIFrame();

        setLog("change Card Id - "+"Employee Code: "+employeeCode);

    }

}
