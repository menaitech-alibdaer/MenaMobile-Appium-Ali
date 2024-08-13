package webBackend.general;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.hold;

public class MenaMeGeneralSettings extends WebBase {

    @FindBy(id = "body_frame")
    WebElement frame;
    @FindBy(name = "menu")
    WebElement menuFrame;
    @FindBy(id = "MenuSaveButton")
    WebElement menuSave;
    @FindBy(id = "isMePermissionsOnDM")
    WebElement directManagerHasPermissionsOnHisSubordinatesOfHisBranchInMenaME;
    @FindBy(xpath = "//input[@name = 'ME_permissions_on_DM' and @id = 'fin']")
    WebElement viewFinancialDataOpt;
    @FindBy(xpath = "//input[@name = 'ME_permissions_on_DM' and @id = 'hr']")
    WebElement viewPersonnelAndHRDataOpt;
    @FindBy(xpath = "//input[@name = 'ME_permissions_on_DM' and @id = 'both']")
    WebElement bothOpt;

    public void directManagerPermissionsOfHisBranch(boolean active, String views){

        goToFrame(frame);
        elementWaitAdvanced(By.name("hide_from_mename"));
        if(active){
            if(!directManagerHasPermissionsOnHisSubordinatesOfHisBranchInMenaME.isSelected()){
                clickOn(directManagerHasPermissionsOnHisSubordinatesOfHisBranchInMenaME);
            }
            hold(200);
            if(views.equalsIgnoreCase("View Financial Data")){
                clickOn(viewFinancialDataOpt);
            }else if(views.equalsIgnoreCase("View Personnel & HR Data") || views.equalsIgnoreCase("HR Data")){
                clickOn(viewPersonnelAndHRDataOpt);
            }else{
                clickOn(bothOpt);
            }
        }else{
            if(directManagerHasPermissionsOnHisSubordinatesOfHisBranchInMenaME.isSelected()){
                clickOn(directManagerHasPermissionsOnHisSubordinatesOfHisBranchInMenaME);
            }
        }

        hold(500);
        closeIFrame();
        goToFrame(menuFrame);
        hold(500);
        clickOn(menuSave);
        hold(1000);
        closeIFrame();
        elementWait(frame);

        setLog("direct Manager Permissions Of His Branch: "+active+" - views: "+views);

    }
}
