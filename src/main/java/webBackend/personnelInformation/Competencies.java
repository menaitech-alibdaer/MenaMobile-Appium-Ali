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

public class Competencies extends WebBase {

    @FindBy(id = "select2-skills_classification-container")
    WebElement skillClassificationE;
    @FindBy(id = "other_skills_class")
    WebElement otherSkillClassificationE;
    @FindBy(id = "select2-skills_classification_type-container")
    WebElement skillTypeE;
    @FindBy(id = "other_skills_type")
    WebElement otherSkillTypeE;
    @FindBy(id = "select2-skill_type-container")
    WebElement competenciesE;
    @FindBy(id = "other_skill_only")
    WebElement otherCompetenciesE;
    @FindBy(xpath = "//span[contains(@id, 'select2-experience_years')]")
    WebElement experienceYearsE;
    @FindBy(id = "select2-skill_level-container")
    WebElement levelE;
    @FindBy(name = "class")
    WebElement classE;
    @FindBy(xpath = "//span[contains(@id, 'select2-skill_source')]")
    WebElement skillSourceE;
    @FindBy(xpath = "//span[contains(@id, 'select2-show_in_CV')]")
    WebElement showInE;
    @FindBy(name = "comments")
    WebElement commentsE;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    WebElement item;
    @FindBy(xpath =  "//ul[contains(@class, 'bg-icon')]//li[@class='nav-item']")
    List<WebElement> items;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addBtn;
    @FindBy(xpath = "//div[@class='textAlign']//label[contains(@style, 'font-size:20px')]")
    WebElement alertText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    WebElement alertBox;
    @FindBy(xpath = "//span[contains(@onclick, 'confirm_delete')]")
    WebElement deleteBtn;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDelete;
    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'Education.php')]")
    WebElement learningAndDevelopmentTab;
    @FindBy(xpath = "//div[contains(@onclick, 'Skills.php')]")
    WebElement competenciesPage;
    SoftAssert softAssert = new SoftAssert();
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    PersonnelInformation personnelInformation;


    public void addCompetencies(String skillClassification, String otherSkillClassification, String skillType, String otherSkillType,
                                String competencies, String otherCompetencies, String experienceYears, String level, String Class,
                                String skillSource, String showIn, String comments){

        hold(500);
        elementWaitAdvanced(By.id("other_skills_class"));
        selectOption(skillClassificationE, skillClassification);
        if(skillClassification.equalsIgnoreCase("Other"))
            setText(otherSkillClassificationE, otherSkillClassification);
        selectOption(skillTypeE, skillType);
        if(skillType.equalsIgnoreCase("Other"))
            setText(otherSkillTypeE, otherSkillType);
        selectOption(competenciesE, competencies);
        if(competencies.equalsIgnoreCase("Other"))
            setText(otherCompetenciesE, otherCompetencies);
        selectOption(experienceYearsE, experienceYears);
        selectOption(levelE, level);
        setText(classE, Class);
        selectOption(skillSourceE, skillSource);
        selectOption(showInE, showIn);
        setText(commentsE, comments);
        hold(500);
        clickOn(saveBtn);
        hold(300);

    }

    public void addCompetenciesWithAssertion(String skillClassification, String otherSkillClassification, String skillType, String otherSkillType,
                                             String competencies, String otherCompetencies, String experienceYears, String level, String Class,
                                             String skillSource, String showIn, String comments){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(learningAndDevelopmentTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(competenciesPage);
        hold(500);
        addCompetencies(skillClassification, otherSkillClassification, skillType, otherSkillType, competencies, otherCompetencies,
                experienceYears, level, Class, skillSource, showIn, comments);

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);

        softAssert.assertEquals(skillClassificationE.getText(), skillClassification, "- Skill Classification");
        softAssert.assertEquals(otherSkillClassificationE.getDomAttribute("value"), otherSkillClassification, "- Other Skill Classification");
        softAssert.assertEquals(skillTypeE.getText(), skillType, "- Skill Type");
        softAssert.assertEquals(otherSkillTypeE.getDomAttribute("value"), otherSkillType, "- Other Skill Type");
        softAssert.assertEquals(competenciesE.getText(), competencies, "- Competencies");
        softAssert.assertEquals(otherCompetenciesE.getDomAttribute("value"), otherCompetencies, "- Other Competencies");
        softAssert.assertEquals(experienceYearsE.getText(), experienceYears, "- Experience Years");
        softAssert.assertEquals(levelE.getText(), level, "- Level");
        softAssert.assertEquals(classE.getDomAttribute("value"), Class, "- Class");
        softAssert.assertEquals(skillSourceE.getText(), skillSource, "- Skill Source");
        softAssert.assertEquals(showInE.getText(), showIn, "- Show In");
        softAssert.assertEquals(commentsE.getDomAttribute("value"), comments, "- Comments");
        if(!skillClassification.equalsIgnoreCase("Other"))
            softAssert.assertEquals(otherSkillClassificationE.getDomAttribute("disabled"), "true");
        if(!skillType.equalsIgnoreCase("Other"))
            softAssert.assertEquals(otherSkillTypeE.getDomAttribute("disabled"), "true");
        if(!competencies.equalsIgnoreCase("Other"))
            softAssert.assertEquals(otherCompetenciesE.getDomAttribute("disabled"), "true");
        softAssert.assertAll();

    }

    public void editCompetencies(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(learningAndDevelopmentTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(competenciesPage);
        hold(500);

        addCompetencies("Competencies Classification 1", "", "Competency type 1", "",
                "Competency 1", "", "2", "8", "Test Class 1", "Self", "Generic Resume", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras a sagittis eros. Suspendisse consectetur gravida erat eu pulvinar. Cras id sapien sem. Proin a cursus nulla. Sed consectetur sodales dui non laoreet. Quisque a nisi vehicula, condimentum nisl vel, dictum elit. Ut mattis arcu vel congue hendrerit. Etiam consectetur ut sem in pellentesque. Maecenas semper risus ex, sed auctor ex porttitor et. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nam imperdiet neque eu tortor eleifend sollicitudin. Donec finibus lacus vitae odio vestibulum aliquet.");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);

        selectOption(skillClassificationE, "Other");
        hold(200);
        setText(otherSkillClassificationE, "Other Skill Classification");
        selectOption(skillTypeE, "Other");
        hold(200);
        setText(otherSkillTypeE, "Other Skill Type");
        selectOption(competenciesE, "Other");
        hold(200);
        setText(otherCompetenciesE, "Other Competencies");
        selectOption(experienceYearsE, "10");
        selectOption(levelE, "3");
        classE.clear();
        hold(300);
        setText(classE, "Class Edited");
        selectOption(skillSourceE, "Training");
        selectOption(showInE, "Not Shown");
        commentsE.clear();
        hold(300);
        setText(commentsE, "Comments Edited");
        clickOn(saveBtn);
        hold(300);
        clickOn(item);
        hold(300);

        softAssert.assertEquals(skillClassificationE.getText(), "Other", "- skillClassification");
        softAssert.assertEquals(otherSkillClassificationE.getDomAttribute("value"), "Other Skill Classification", "Other Skill Classification");
        softAssert.assertEquals(skillTypeE.getText(), "Other", "- Skill Type");
        softAssert.assertEquals(otherSkillTypeE.getDomAttribute("value"), "Other Skill Type", "Other Skill Type");
        softAssert.assertEquals(competenciesE.getText(), "Other", "- competencies");
        softAssert.assertEquals(otherCompetenciesE.getDomAttribute("value"), "Other Competencies", "- Other Competencies");
        softAssert.assertEquals(experienceYearsE.getText(), "10", "- experienceYears");
        softAssert.assertEquals(levelE.getText(), "3", "");
        softAssert.assertEquals(classE.getDomAttribute("value"), "Class Edited", "- Class");
        softAssert.assertEquals(skillSourceE.getText(), "Training", "- skillSource");
        softAssert.assertEquals(showInE.getText(), "Not Shown", "showIn");
        softAssert.assertEquals(commentsE.getDomAttribute("value"), "Comments Edited", "- Comments");
        softAssert.assertAll();

    }

    public void deleteCompetencies(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(learningAndDevelopmentTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(competenciesPage);
        hold(500);

        addCompetencies("Competencies Classification 1", "", "Competency type 1", "",
                "Competency 1", "", "2", "8", "Test Class 1", "Self", "Generic Resume", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras a sagittis eros. Suspendisse consectetur gravida erat eu pulvinar. Cras id sapien sem. Proin a cursus nulla. Sed consectetur sodales dui non laoreet. Quisque a nisi vehicula, condimentum nisl vel, dictum elit. Ut mattis arcu vel congue hendrerit. Etiam consectetur ut sem in pellentesque. Maecenas semper risus ex, sed auctor ex porttitor et. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nam imperdiet neque eu tortor eleifend sollicitudin. Donec finibus lacus vitae odio vestibulum aliquet.");

        softAssert.assertTrue(item.isDisplayed(), "- item not appear");
        clickOn(item);
        hold(300);
        clickOn(deleteBtn);
        hold(500);
        clickOn(alertButtonOkDelete);
        hold(300);
        Assert.assertTrue(checkElementIfNotAppear(items), "- Item Still Appear - NOT deleted!");

    }

    public void addMoreThanOneRecord(int competenciesCount){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(learningAndDevelopmentTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(competenciesPage);
        hold(500);

        for (int i = 1; i <= competenciesCount; i++) {

            String randNum = String.valueOf(randomNumber2());
            addCompetencies("Other", "Skill Classification Test "+i, "Other", "Skill Type Test "+i,
                    "Other", "Competencies Test "+i, ""+i, ""+i, "Test Class "+randNum, "Self", "Generic Resume",
                    "Comment Test Add more than record "+randNum);

            hold(300);
            clickOn(addBtn);
            hold(1500);

        }

        Assert.assertEquals(items.size(), competenciesCount, "- issue in item counter");

    }

    public void validateAddDuplicateDate(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(learningAndDevelopmentTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(competenciesPage);
        hold(500);


        addCompetencies("Competencies Classification 1", "", "Competency type 1", "",
                "Competency 1", "", "2", "8", "Test Class 1", "Self", "Generic Resume", "Test Comment");

        hold(300);
        clickOn(addBtn);
        hold(300);

        addCompetencies("Competencies Classification 1", "", "Competency type 1", "",
                "Competency 1", "", "2", "8", "Test Class 1", "Self", "Generic Resume", "Test Comment");

        hold(500);
        elementWaitAdvanced(By.xpath("//label[contains(text(), 'Alert!')]"));
        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Can Not Add Duplicate Data!");
        softAssert.assertAll();

    }

    public void validateMandatoryField(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees", "Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "", "01/01/1990");
        personnelInformation.employmentInformation("New Zarqa", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");
        hold(300);
        clickOn(learningAndDevelopmentTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));
        clickOn(competenciesPage);
        hold(500);

        addCompetencies("Competencies Classification 1", "", "Competency type 1", "",
                "", "", "2", "8", "Test Class 1", "Self", "Generic Resume", "Test Comment");

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Must Be Filled!");
        softAssert.assertAll();

    }

}
