package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.WebHelper.hold;

public class Substitutes extends WebBase {

    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(name = "alternatives_list.php")
    WebElement listFrame;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "MenuNewButton")
    WebElement menuNew;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(name = "alternative_code")
    WebElement substituteCodeE;

    public void substitutes(String employeeCode, String substituteCode){
        goToFrame(bodyFrame);
        hold(300);
        elementWaitAdvanced(By.id("employee_code"));
        setText(empCode, employeeCode, Keys.TAB);
        hold(500);
        elementWait(substituteCodeE);
        setText(substituteCodeE, substituteCode, Keys.TAB);
        hold(1000);
        closeIFrame();
        goToFrame(menuFrame);
        elementWait(menuSave);
        clickOn(menuSave);
        hold(500);
        closeIFrame();
        goToFrame(bodyFrame);
        hold(300);
        goToFrame(listFrame);
        elementWaitAdvanced(By.xpath("(//table[@class='collapsetable']//a[contains(@href, 'alternatives.php')])[1]"));
    }

}
