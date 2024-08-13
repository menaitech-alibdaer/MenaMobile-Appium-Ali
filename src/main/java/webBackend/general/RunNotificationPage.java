package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;
import static utilities.MssqlConnect.sqlQuery;
import static utilities.VersionGetter.versionGetter;

public class RunNotificationPage extends WebBase {

    @FindBy(xpath = "//form[@action='notifications.php']//strong")
    WebElement notfPageE;
    String parentWindow;

    public void runNotificationPage(){
        sqlQuery("delete from Notification_Page_Exec_Log where company_code = 'automation'");
        hold(300);
        parentWindow = getDriver().getWindowHandle();
        getDriver().switchTo().newWindow(WindowType.TAB);
        if(!versionGetter().equalsIgnoreCase("OCT")){
            goToURL(versionURL+"notifications/notifications.php?company_code_text=automation");
        }else {
            goToURL(versionURL+"notifications/notifications.php?company_code_text=automation");
        }
        waitTextAppear(notfPageE, "Please Keep This Page Open All The Time");
        getDriver().close();
        backToParentWindow(parentWindow);

        setLog("Run Notification Page");

    }

}
