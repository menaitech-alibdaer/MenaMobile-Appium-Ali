package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import static utilities.WebHelper.hold;

public class TempMail extends WebBase {

    @FindBy(id = "email")
    WebElement emailE;
    @FindBy(id = "odpocet")
    WebElement refreshBtn;
    @FindBy(xpath = "//a[contains(@href, '86400')]")
    WebElement plusDayBtn;
    @FindBy(xpath = "//td[contains(text(), 'Children Allowance Notification')")
    public WebElement checkEmailChildrenAllowanceNotification;
    String parentWindow;

    public String getEmail(){

        String email;
        hold(300);
        parentWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        goToURL("https://www.minuteinbox.com/");
        hold(300);
        elementWaitAdvanced(By.id("email"));
        email = emailE.getText().trim();
        clickOn(plusDayBtn);
        hold(500);
        elementWaitAdvanced(By.id("email"));
        driver.close();
        backToParentWindow(parentWindow);
        return email;

    }

    public void goToEmail(){

        hold(300);
        parentWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        goToURL("https://www.minuteinbox.com/");
        hold(300);
        elementWaitAdvanced(By.id("email"));

    }

}
