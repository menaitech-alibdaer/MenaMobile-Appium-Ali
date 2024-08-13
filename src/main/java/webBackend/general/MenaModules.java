package webBackend.general;

import bases.WebBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.ExtentReport;

import static utilities.ExtentReport.setLog;
import static utilities.VersionGetter.versionGetter;

public class MenaModules extends WebBase {

    @FindBy(id = "menapay_btn")
    WebElement menaPay;

    @FindBy(id = "menahr_btn")
    WebElement menaHR;

    @FindBy(id = "mena360_btn")
    WebElement mena360;

    @FindBy(id = "menaExplorer_btn")
    WebElement menaExplorer;

    @FindBy(id = "menaTa_btn")
    WebElement menaTa;

    @FindBy(id = "system_r1_c1")
    public WebElement logo;
    @FindBy(id = "Main_menu")
    WebElement menu;

//    @FindBy(id = "LoadingElement")
//    WebElement loadingElement;

    @FindBy(xpath = "//p[text()='MenaTA']")
    WebElement checkTA;

    @FindBy(id = "PageHeader1_lblHome")
    WebElement checkExplorer;
    @FindBy(id = "area_menapay")
    WebElement menaPay_oct;
    @FindBy(id = "area_menahr")
    WebElement menaHR_oct;


    public void menaModules(String module){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            elementWaitAdvanced(By.id("menahr_btn"));
            if(module.equalsIgnoreCase("MenaPAY")){
                clickOn(menaPay);
                elementWait(menu);
            } else if (module.equalsIgnoreCase("MenaHR")) {
                clickOn(menaHR);
                elementWait(menu);
            } else if (module.equalsIgnoreCase("Mena360")) {
                clickOn(mena360);
                elementWait(logo);
            } else if (module.equalsIgnoreCase("MenaExplorer")) {
                clickOn(menaExplorer);
                elementWait(checkExplorer);
            } else if (module.equalsIgnoreCase("MenaTA")) {
                clickOn(menaTa);
                elementWait(checkTA);
            } else {
                Assert.fail("This Module: " + module + " is not exist");
            }

        }else {

            elementWaitAdvanced(By.id("area_menapay"));

            if(module.equalsIgnoreCase("MenaPAY")){
                clickOn(menaPay_oct);
                elementWait(logo);
                Assert.assertTrue(driver.getTitle().contains("Payroll & Personnel"),"Can't access to MenaPAY");
            } else if (module.equalsIgnoreCase("MenaHR")) {
                clickOn(menaHR_oct);
                elementWait(logo);
                Assert.assertTrue(driver.getTitle().contains("Human Resources"),"Can't access to MenaHR");
            }

        }

        setLog("Enter to: "+module);

    }

    public void menaPAY() {
        menaModules("MenaPAY");
    }

    public void menaHR() {
        menaModules("MenaHR");
    }

}
