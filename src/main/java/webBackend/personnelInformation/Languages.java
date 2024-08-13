package webBackend.personnelInformation;

import bases.WebBase;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static utilities.WebHelper.*;

import java.util.List;

public class Languages extends WebBase {

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addBtn;
    @FindBy(xpath = "//div[contains(@onclick, 'languages.php')]")
    WebElement languagesPage;
    @FindBy(xpath = "//div[contains(@onclick, 'Dependencies.php')]")
    WebElement dependentsPage;
    @FindBy(xpath = "//span[contains(@onclick, 'confirm_delete')]")
    WebElement deleteLanguageBtn;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDeleteLanguage;
    @FindBy(xpath = "//span[contains(@id, 'select2-Lang')]")
    WebElement languageE;
    @FindBy(xpath = "//span[contains(@id, 'select2-read_level')]")
    WebElement readE;
    @FindBy(xpath = "//span[contains(@id, 'select2-write_level')]")
    WebElement writtenE;
    @FindBy(xpath = "//span[contains(@id, 'select2-speak_level')]")
    WebElement spokenE;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    WebElement item;
    @FindBy(xpath =  "//ul[contains(@class, 'bg-icon')]//li[@class='nav-item']")
    List<WebElement> items;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    List<WebElement> checkItem;
    SoftAssert softAssert = new SoftAssert();
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    PersonnelInformation personnelInformation;
    public void addLanguage(String language, String read, String written, String spoken){

        hold(500);
        elementWaitAdvanced(By.name("read_level"));
        selectOption(languageE, language);
        selectOption(readE, read);
        selectOption(writtenE, written);
        selectOption(spokenE, spoken);
        hold(300);
        clickOn(saveBtn);
        hold(500);

    }

    public void addLanguageWithAssertion(String language, String read, String written, String spoken){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("Amman", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        clickOn(languagesPage);
        hold(500);
        addLanguage(language, read, written, spoken);
        hold(300);
        clickOn(dependentsPage);
        hold(500);
        clickOn(languagesPage);
        hold(300);

        Assert.assertTrue(item.isDisplayed(), "-Issue, Language Button Not Appear!");
        clickOn(item);
        hold(300);

        softAssert.assertEquals(driver.findElement(By.name("Langxxx")).getAttribute("value"), language, "-Issue Language");
        softAssert.assertEquals(readE.getText(), read, "-Issue Read");
        softAssert.assertEquals(writtenE.getText(), written, "-Issue Written");
        softAssert.assertEquals(spokenE.getText(), spoken, "-Issue Spoken");
        softAssert.assertAll();

    }

    public void editLanguage(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("Amman", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        clickOn(languagesPage);
        hold(500);
        addLanguage("English", "Excellent", "Very Good", "Accepted");
        hold(300);
        clickOn(dependentsPage);
        hold(500);
        clickOn(languagesPage);
        hold(300);

        Assert.assertTrue(item.isDisplayed(), "-Issue, Language Button Not Appear!");
        clickOn(item);
        hold(500);
        addLanguage("", "Very Good", "Accepted", "Excellent");
        hold(300);
        clickOn(dependentsPage);
        hold(500);
        clickOn(languagesPage);
        hold(300);

        Assert.assertTrue(item.isDisplayed(), "-Issue, Language Button Not Appear!");
        clickOn(item);
        hold(500);

        softAssert.assertEquals(driver.findElement(By.name("Langxxx")).getAttribute("value"), "English", "-Issue Language");
        softAssert.assertEquals(readE.getText(), "Very Good", "-Issue Read");
        softAssert.assertEquals(writtenE.getText(), "Accepted", "-Issue Written");
        softAssert.assertEquals(spokenE.getText(), "Excellent", "-Issue Spoken");
        softAssert.assertAll();

    }

    public void deleteLanguage(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("Amman", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        clickOn(languagesPage);
        hold(500);
        addLanguage("English", "Excellent", "Very Good", "Accepted");
        hold(300);
        clickOn(dependentsPage);
        hold(500);
        clickOn(languagesPage);
        hold(300);

        Assert.assertTrue(item.isDisplayed(), "-Issue, Language Button Not Appear!");
        clickOn(item);
        hold(300);
        clickOn(deleteLanguageBtn);
        hold(500);
        clickOn(alertButtonOkDeleteLanguage);
        hold(500);
        clickOn(dependentsPage);
        hold(500);
        clickOn(languagesPage);
        hold(300);
        elementWaitAdvanced(By.name("read_level"));
        Assert.assertTrue(checkElementIfNotAppear(checkItem));

    }

    public void addMoreThanOneLanguage(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("Amman", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        clickOn(languagesPage);
        hold(500);
        addLanguage("English", "Excellent", "Very Good", "Accepted");
        hold(300);
        clickOn(addBtn);
        hold(500);
        addLanguage("Arabic", "Very Good", "Very Good", "Excellent");
        hold(300);
        clickOn(dependentsPage);
        hold(500);
        clickOn(languagesPage);
        hold(300);

        Assert.assertEquals(items.size(), 2, "Issue in the number of Languages!");

    }

}
