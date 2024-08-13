package webBackend.financialInformation;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;

public class CostCenter extends WebBase {

    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'pay_emp_cost_distribution.php')]")
    WebElement costCenterTab;
    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(xpath = "//div[@class='textAlign']//label[contains(@style, 'font-size:20px')]")
    WebElement alertText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    WebElement alertBox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addBtn;
    @FindBy(xpath = "//button[@onclick = \"menu_action('3')\"]")
    WebElement deleteBtn;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDelete;
    @FindBy(id = "btok")
    WebElement alertOkBtn;
    @FindBy(id = "project_1")
    WebElement projectE;
    @FindBy(name = "project_text")
    WebElement projectText;
    @FindBy(name = "activity_text")
    WebElement activityText;
    @FindBy(name = "job_card_text")
    WebElement jobCardText;
    @FindBy(id = "activity_1")
    WebElement activityE;
    @FindBy(id = "job_card_1")
    WebElement jobCardE;
    @FindBy(id = "project_share_1")
    WebElement valueE;
    @FindBy(name = "checkbox[1]")
    WebElement firstCheckbox;

    public void setEmployeeCode(String employeeCode){

        goToFrame(bodyFrame);
        elementWaitAdvanced(By.id("employee_code"));
        hold(300);
        setText(empCode, employeeCode);
        hold(300);
        setText(empCode, Keys.TAB);
        hold(300);
        elementWaitAdvanced(By.xpath("//label[contains(text(),'Active Employee')]"));

        setLog("Set Employee Code: "+employeeCode);

    }

    public void costDistribution(String project, String activity, String jobCard, String value){

        clickOn(costCenterTab);
        hold(300);
        elementWaitAdvanced(By.xpath("//button[contains(text(),'Add')]"));
        clickOn(addBtn);
        hold(300);
        elementWaitAdvanced(By.id("project_share_1"));
        if(!project.isEmpty()){
            Select projectO = new Select(projectE);
            projectO.selectByVisibleText(project);
            if(!activity.isEmpty()){
                Select activityO = new Select(activityE);
                activityO.selectByVisibleText(activity);
                if(!jobCard.isEmpty()){
                    Select jobCardO = new Select(jobCardE);
                    jobCardO.selectByVisibleText(jobCard);
                }
            }
        }
        if(!value.isEmpty()){
            setText(valueE, value);
        }
        hold(300);
        clickOn(saveBtn);
        hold(500);

        setLog("Cost Distribution"
        +" - project: "+project
        +" - activity: "+activity
        +" - jobCard: "+jobCard
        +" - value: "+value);

    }

    public void goToCostDistribution(){
        clickOn(costCenterTab);
        hold(500);
        elementWaitAdvanced(By.xpath("//button[contains(text(),'Add')]"));
    }

    public void deleteCostDistribution(){
        clickOn(firstCheckbox);
        hold(300);
        clickOn(deleteBtn);
        hold(500);
        clickOn(alertButtonOkDelete);
        hold(500);

        setLog("delete Cost Distribution");
    }

    public void passAlert(){
        clickOn(alertOkBtn);
        hold(500);
    }


}
