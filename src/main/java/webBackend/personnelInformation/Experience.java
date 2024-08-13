package webBackend.personnelInformation;

import bases.WebBase;
import webBackend.general.ChangeTransactions;
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

public class Experience extends WebBase {

    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'Job_History.php')]")
    WebElement experiencesTab;
    @FindBy(xpath = "//div[contains(@onclick, 'employment_information.php')]")
    WebElement employmentInformationPage;
    @FindBy(xpath = "//div[contains(@onclick, 'Previous_Employer.php')]")
    WebElement experiencesPage;
    @FindBy(xpath = "//div[contains(@onclick, 'employee_practical_exp.php')]")
    WebElement practicalExperiencePage;
    @FindBy(id = "exp_date")
    WebElement practicalExperienceDateE;
    @FindBy(xpath = "//span[contains(@id, 'select2-show_in_CV')]")
    WebElement practicalExperienceShowInE;
    @FindBy(name = "practical_Experiance_text")
    WebElement practicalExperienceEnglishE;
    @FindBy(name = "practical_Experiance_text_a")
    WebElement practicalExperienceArabicE;
    @FindBy(name = "start_date")
    WebElement fromDate;
    @FindBy(name = "end_date")
    WebElement toDate;
    @FindBy(name = "site")
    WebElement siteJob;
    @FindBy(name = "department")
    WebElement departmentJob;
    @FindBy(name = "section")
    WebElement sectionJob;
    @FindBy(name = "position")
    WebElement positionJob;
    @FindBy(name = "class")
    WebElement classJob;
    @FindBy(name = "degree")
    WebElement degreeJob;
    @FindBy(name = "year_count")
    WebElement stepJob;
    @FindBy(name = "fdimension")
    WebElement category1Job;
    @FindBy(name = "sdimension")
    WebElement category2Job;
    @FindBy(name = "manager")
    WebElement managerJob;
    @FindBy(name = "contract")
    WebElement contractJob;
    @FindBy(id = "start_date")
    WebElement startDateE;
    @FindBy(id = "end_date")
    WebElement endDateE;
    @FindBy(id = "till_present")
    WebElement untilNowE;
    @FindBy(name = "employer")
    WebElement previousEmployerE;
    @FindBy(name = "title")
    WebElement previousPositionE;
    @FindBy(name = "salary_currency")
    WebElement salaryE;
    @FindBy(xpath = "//span[contains(@id, 'select2-currency')]")
    WebElement salaryCurrencyE;
    @FindBy(name = "manager")
    WebElement contactPersonE;
    @FindBy(name = "contact_phone")
    WebElement contactPhoneE;
    @FindBy(name = "contact_position")
    WebElement contactPositionE;
    @FindBy(xpath = "//span[contains(@id, 'select2-country_code')]")
    WebElement countryE;
    @FindBy(name = "job_address")
    WebElement jobPlaceE;
    @FindBy(name = "quit")
    WebElement quitReasonE;
    @FindBy(xpath = "//span[contains(@id, 'select2-Experience_Type')]")
    WebElement experiencePlaceE;
    @FindBy(xpath = "//span[contains(@id, 'select2-Experience_place')]")
    WebElement experienceTypeE;
    @FindBy(xpath = "//span[contains(@id, 'select2-Nature_Of_Work')]")
    WebElement natureOfWorkE;
    @FindBy(xpath = "//span[contains(@id, 'select2-Job_Classification')]")
    WebElement jobClassificationE;
    @FindBy(xpath = "//span[contains(@id, 'select2-experience_relevance')]")
    WebElement relevanceE;
    @FindBy(name = "resp")
    WebElement responsibilitiesE;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    WebElement item;
    @FindBy(xpath =  "//ul[contains(@class, 'bg-icon')]//li[@class='nav-item']")
    List<WebElement> items;
    @FindBy(id = "employee_code")
    WebElement empCode;
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
    @FindBy(id = "btok")
    WebElement okBtnAlert;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDelete;
    SoftAssert softAssert = new SoftAssert();
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    PersonnelInformation personnelInformation;
    ChangeTransactions changeTransactions;
    String employeeCode = null;
    String empHiringDate;

    public void addChangeLocation(String transactionDate, String newSite, String newDepartment, String newSection,
                                  String newDivision, String newUnit, String newSubSection, String newSubDivision,
                                  String newSubUnit, String newOffice, String newTeam, String newPosition){

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

        empHiringDate = personnelInformation.hiring_dateE.getAttribute("value");
        String lastSite = personnelInformation.siteE.getText();
        String lastDepartment = personnelInformation.departmentE.getText();
        String lastSection = personnelInformation.sectionE.getText();
        String lastPosition = personnelInformation.positionE.getText();
        employeeCode = empCode.getAttribute("value");

        hold(500);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Workforce Management","Change Transactions");
        hold(500);

        changeTransactions = new ChangeTransactions();
        changeTransactions.location(employeeCode, "", transactionDate , newSite, newDepartment, newSection, newDivision, newUnit,
                newSubSection, newSubDivision, newSubUnit, newOffice, newTeam, newPosition);

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        clickOn(employmentInformationPage);
        hold(500);
        elementWaitAdvanced(By.id("select2-site_1-container"));

        if(!newSite.isEmpty()){
            softAssert.assertEquals(personnelInformation.siteE.getText(), newSite, "- Site");
        }
        if(!newDepartment.isEmpty()){
            softAssert.assertEquals(personnelInformation.departmentE.getText(), newDepartment, "- Department");
        }
        if(!newSection.isEmpty()){
            softAssert.assertEquals(personnelInformation.sectionE.getText(), newSection, "- section");
        }
        if(!newDivision.isEmpty()){
            softAssert.assertEquals(personnelInformation.divisionE.getText(), newDivision, "- division");
        }
        if(!newUnit.isEmpty()){
            softAssert.assertEquals(personnelInformation.unitsE.getText(), newUnit, "- unit");
        }
        if(!newSubSection.isEmpty()){
            softAssert.assertEquals(personnelInformation.sub_sectionE.getText(), newSubSection, "- subSection");
        }
        if(!newSubDivision.isEmpty()){
            softAssert.assertEquals(personnelInformation.sub_divisionE.getText(), newSubDivision, "- subDivision");
        }
        if(!newSubUnit.isEmpty()){
            softAssert.assertEquals(personnelInformation.sub_unitE.getText(), newSubUnit, "- subUnit");
        }
        if(!newOffice.isEmpty()){
            softAssert.assertEquals(personnelInformation.officeE.getText(), newOffice, "- office");
        }
        if(!newTeam.isEmpty()){
            softAssert.assertEquals(personnelInformation.teamE.getText(), newTeam, "- team");
        }
        if(!newPosition.isEmpty()){
            softAssert.assertEquals(personnelInformation.positionE.getText(), newPosition, "- position");
        }
        hold(500);
        clickOn(experiencesTab);
        hold(300);
        elementWaitAdvanced(By.name("start_date"));
        clickOn(item);
        hold(300);

        softAssert.assertEquals(fromDate.getAttribute("value"), empHiringDate, "- Not Same Hiring Date");
        softAssert.assertEquals(toDate.getAttribute("value"), changeTransactions.getTransactionDate, "Not Same Transaction Date");

        if(!newSite.isEmpty()){
            softAssert.assertEquals(siteJob.getAttribute("value"), lastSite, "- Site");
        }
        if(!newDepartment.isEmpty()){
            softAssert.assertEquals(departmentJob.getAttribute("value"), lastDepartment, "- Department");
        }
        if(!newSection.isEmpty()){
            softAssert.assertEquals(sectionJob.getAttribute("value"), lastSection, "- section");
        }
        if(!newPosition.isEmpty()){
            softAssert.assertEquals(positionJob.getAttribute("value"), lastPosition, "- position");
        }

        softAssert.assertAll();

    }

    public void addChangeLocationTwoTransaction(){

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

        employeeCode = empCode.getAttribute("value");

        hold(500);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Workforce Management","Change Transactions");
        hold(500);

        changeTransactions = new ChangeTransactions();
        changeTransactions.location(employeeCode, "", "01/01/2021" , "Amman", "Development", "Mobile Development", "",
                "", "", "", "", "", "", "Flutter Developer");
        changeTransactions.location(employeeCode, "", "01/01/2022" , "Amman", "Technical Support", "Technical Support Section", "",
                "", "", "", "", "", "", "Technical Support Position");

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        clickOn(employmentInformationPage);
        hold(500);
        elementWaitAdvanced(By.id("select2-site_1-container"));

        softAssert.assertEquals(personnelInformation.siteE.getText(), "Amman", "- Site");
        softAssert.assertEquals(personnelInformation.departmentE.getText(), "Technical Support", "- Department");
        softAssert.assertEquals(personnelInformation.sectionE.getText(), "Technical Support Section", "- section");
        softAssert.assertEquals(personnelInformation.positionE.getText(), "Technical Support Position", "- position");

        hold(500);
        clickOn(experiencesTab);
        hold(300);
        elementWaitAdvanced(By.name("start_date"));
        clickOn(items.get(0));
        hold(300);

        softAssert.assertEquals(fromDate.getAttribute("value"), "01/01/2021");
        softAssert.assertEquals(toDate.getAttribute("value"), "01/01/2022");
        softAssert.assertEquals(siteJob.getAttribute("value"), "Amman");
        softAssert.assertEquals(departmentJob.getAttribute("value"), "Development");
        softAssert.assertEquals(sectionJob.getAttribute("value"), "Mobile Development");
        softAssert.assertEquals(positionJob.getAttribute("value"), "Flutter Developer");

        clickOn(items.get(1));
        hold(300);

        softAssert.assertEquals(fromDate.getAttribute("value"), "01/01/2020");
        softAssert.assertEquals(toDate.getAttribute("value"), "01/01/2021");
        softAssert.assertEquals(siteJob.getAttribute("value"), "Amman");
        softAssert.assertEquals(departmentJob.getAttribute("value"), "Development");
        softAssert.assertEquals(sectionJob.getAttribute("value"), "PHP Development");
        softAssert.assertEquals(positionJob.getAttribute("value"), "PHP Developer");

        softAssert.assertAll();

    }

    public void addChangeClassification(String transactionDate, String newClass, String newDegree, String newStep,
                                  String newCategory1, String newCategory2){

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

        empHiringDate = personnelInformation.hiring_dateE.getAttribute("value");
        String lastClass = "";
        String lastDegree = "";
        String lastStep = personnelInformation.stepE.getAttribute("value");
        String lastCategory1 = "";
        String lastCategory2 = "";

        if(!personnelInformation.classificationE.getText().equals("Choose")){
            lastClass = personnelInformation.classificationE.getText();
        }
        if(!personnelInformation.degreeE.getText().equals("Choose")){
            lastDegree = personnelInformation.degreeE.getText();
        }
        if(!personnelInformation.category1E.getText().equals("Choose")){
            lastCategory1 = personnelInformation.category1E.getText();
        }
        if(!personnelInformation.category2E.getText().equals("Choose")){
            lastCategory2 = personnelInformation.category2E.getText();
        }

        employeeCode = empCode.getAttribute("value");
        hold(500);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Workforce Management","Change Transactions");
        hold(500);

        changeTransactions = new ChangeTransactions();
        changeTransactions.classification(employeeCode, "", transactionDate , newClass, newDegree, newStep, newCategory1, newCategory2);

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        clickOn(employmentInformationPage);
        hold(500);
        elementWaitAdvanced(By.id("select2-site_1-container"));

        if(!newClass.isEmpty()){
            softAssert.assertEquals(personnelInformation.classificationE.getText(), newClass, "- Class");
        }
        if(!newDegree.isEmpty()){
            softAssert.assertEquals(personnelInformation.degreeE.getText(), newDegree, "- Degree");
        }
        if(!newStep.isEmpty()){
            softAssert.assertEquals(personnelInformation.stepE.getAttribute("value"), newStep, "- Step");
        }
        if(!newCategory1.isEmpty()){
            softAssert.assertEquals(personnelInformation.category1E.getText(), newCategory1, "- Category 1");
        }
        if(!newCategory2.isEmpty()){
            softAssert.assertEquals(personnelInformation.category2E.getText(), newCategory2, "- Category 2");
        }

        hold(500);
        clickOn(experiencesTab);
        hold(300);
        elementWaitAdvanced(By.name("start_date"));
        clickOn(item);
        hold(300);

        softAssert.assertEquals(fromDate.getAttribute("value"), empHiringDate, "- Not Same Hiring Date");
        softAssert.assertEquals(toDate.getAttribute("value"), changeTransactions.getTransactionDate, "Not Same Transaction Date");

        if(!newClass.isEmpty()){
            softAssert.assertEquals(classJob.getAttribute("value").replace("\u00a0",""), lastClass, "- last Class");
        }
        if(!newDegree.isEmpty()){
            softAssert.assertEquals(degreeJob.getAttribute("value").replace("\u00a0",""), lastDegree, "- last Degree");
        }
        if(!newStep.isEmpty()){
            softAssert.assertEquals(stepJob.getAttribute("value").replace("\u00a0",""), lastStep, "- last Step");
        }
        if(!newCategory1.isEmpty()){
            softAssert.assertEquals(category1Job.getAttribute("value").replace("\u00a0",""), lastCategory1, "- last Category1");
        }
        if(!newCategory2.isEmpty()){
            softAssert.assertEquals(category2Job.getAttribute("value").replace("\u00a0",""), lastCategory2, "- last Category2");
        }

        softAssert.assertAll();

    }

    public void addChangeClassificationTwoTransaction(){

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

        employeeCode = empCode.getAttribute("value");

        hold(500);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Workforce Management","Change Transactions");
        hold(500);

        changeTransactions = new ChangeTransactions();
        changeTransactions.classification(employeeCode, "", "05/05/2021", "Class 2", "Degree 2", "2",
                "Category 1", "Category 2");
        changeTransactions.classification(employeeCode, "", "03/03/2022", "Class 1", "Degree 1", "1",
                "Category 1", "Category 2");

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        clickOn(employmentInformationPage);
        hold(500);
        elementWaitAdvanced(By.id("select2-site_1-container"));

        softAssert.assertEquals(personnelInformation.classificationE.getText(), "Class 1", "- New Class");
        softAssert.assertEquals(personnelInformation.degreeE.getText(), "Degree 1", "- New Degree");
        softAssert.assertEquals(personnelInformation.stepE.getAttribute("value"), "1", "- New Step");
        softAssert.assertEquals(personnelInformation.category1E.getText(), "Category 1", "- New Category 1");
        softAssert.assertEquals(personnelInformation.category2E.getText(), "Category 2", "- New Category 2");

        hold(500);
        clickOn(experiencesTab);
        hold(300);
        elementWaitAdvanced(By.name("start_date"));
        clickOn(items.get(0));
        hold(300);

        softAssert.assertEquals(fromDate.getAttribute("value"), "05/05/2021");
        softAssert.assertEquals(toDate.getAttribute("value"), "03/03/2022");
        softAssert.assertEquals(classJob.getAttribute("value").replace("\u00a0",""), "Class 2");
        softAssert.assertEquals(degreeJob.getAttribute("value").replace("\u00a0",""), "Degree 2");
        softAssert.assertEquals(stepJob.getAttribute("value").replace("\u00a0",""), "2");
        softAssert.assertEquals(category1Job.getAttribute("value").replace("\u00a0",""), "Category 1");
        softAssert.assertEquals(category2Job.getAttribute("value").replace("\u00a0",""), "Category 2");

        clickOn(items.get(1));
        hold(300);

        softAssert.assertEquals(fromDate.getAttribute("value"), "01/01/2020");
        softAssert.assertEquals(toDate.getAttribute("value"), "05/05/2021");
        softAssert.assertEquals(classJob.getAttribute("value").replace("\u00a0",""), "");
        softAssert.assertEquals(degreeJob.getAttribute("value").replace("\u00a0",""), "");
        softAssert.assertEquals(stepJob.getAttribute("value").replace("\u00a0",""), "0");
        softAssert.assertEquals(category1Job.getAttribute("value").replace("\u00a0",""), "");
        softAssert.assertEquals(category2Job.getAttribute("value").replace("\u00a0",""), "");

        softAssert.assertAll();

    }

    public void addChangeDirectManager(String transactionDate, String newDirectManager){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "auto000001", "01/01/1990");
        personnelInformation.employmentInformation("Amman", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        empHiringDate = personnelInformation.hiring_dateE.getAttribute("value");
        hold(300);
        clickOn(personnelInformation.backToPersonalInformationTab);
        hold(500);
        String lastDirectManager = personnelInformation.directManagerName.getAttribute("value").trim();

        employeeCode = empCode.getAttribute("value");
        hold(500);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Workforce Management","Change Transactions");
        hold(500);

        changeTransactions = new ChangeTransactions();
        changeTransactions.directManager(employeeCode, "", transactionDate, newDirectManager);

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        elementWaitAdvanced(By.id("first_name_e"));

        if(!newDirectManager.isEmpty()){
            softAssert.assertEquals(personnelInformation.manager_code.getAttribute("value"), newDirectManager, "- Direct Manager");
        }

        hold(500);
        clickOn(experiencesTab);
        hold(300);
        elementWaitAdvanced(By.name("start_date"));
        clickOn(item);
        hold(300);

        softAssert.assertEquals(fromDate.getAttribute("value"), empHiringDate, "- Not Same Hiring Date");
        softAssert.assertEquals(toDate.getAttribute("value"), changeTransactions.getTransactionDate, "Not Same Transaction Date");

        if(!newDirectManager.isEmpty()){
            softAssert.assertEquals(managerJob.getAttribute("value").trim(), lastDirectManager, "- last Direct Manager");
        }
        softAssert.assertAll();

    }

    public void addChangeDirectManagerTwoTransaction(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "",
                "", "", "", "auto000001", "01/01/1990");
        personnelInformation.employmentInformation("Amman", "Development", "PHP Development",
                "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");

        empHiringDate = personnelInformation.hiring_dateE.getAttribute("value");
        hold(300);
        clickOn(personnelInformation.backToPersonalInformationTab);
        hold(500);
        employeeCode = empCode.getAttribute("value");
        hold(500);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Workforce Management","Change Transactions");
        hold(500);

        changeTransactions = new ChangeTransactions();
        changeTransactions.directManager(employeeCode, "", "04/04/2021", "auto000000");
        changeTransactions.directManager(employeeCode, "", "07/07/2022", "auto000002");

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        elementWaitAdvanced(By.id("first_name_e"));

        softAssert.assertEquals(personnelInformation.manager_code.getAttribute("value"), "auto000002", "- New Direct Manager");

        hold(500);
        clickOn(experiencesTab);
        hold(300);
        elementWaitAdvanced(By.name("start_date"));
        clickOn(items.get(0));
        hold(300);

        softAssert.assertEquals(fromDate.getAttribute("value"), "04/04/2021");
        softAssert.assertEquals(toDate.getAttribute("value"), "07/07/2022");
        softAssert.assertEquals(managerJob.getAttribute("value").trim(), "auto000000 auto000000");

        clickOn(items.get(1));
        hold(300);

        softAssert.assertEquals(fromDate.getAttribute("value"), "01/01/2020");
        softAssert.assertEquals(toDate.getAttribute("value"), "04/04/2021");
        softAssert.assertEquals(managerJob.getAttribute("value").trim(), "auto000001 auto000001");

        softAssert.assertAll();

    }

    public void addChangeContract(String transactionDate, String newContractType){

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

        empHiringDate = personnelInformation.hiring_dateE.getAttribute("value");
        String lastContract = "";

        if(!personnelInformation.classificationE.getText().equals("Choose")){
            lastContract = personnelInformation.contract_typeE.getText();
        }

        employeeCode = empCode.getAttribute("value");
        hold(500);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Workforce Management","Change Transactions");
        hold(500);

        changeTransactions = new ChangeTransactions();
        changeTransactions.jobContract(employeeCode, "", transactionDate , newContractType);

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        clickOn(employmentInformationPage);
        hold(500);
        elementWaitAdvanced(By.id("select2-site_1-container"));

        if(!newContractType.isEmpty()){
            softAssert.assertEquals(personnelInformation.contract_typeE.getText(), newContractType, "- Contract Type");
        }

        hold(500);
        clickOn(experiencesTab);
        hold(300);
        elementWaitAdvanced(By.name("start_date"));
        clickOn(item);
        hold(300);

        if(!newContractType.isEmpty()){
            softAssert.assertEquals(contractJob.getAttribute("value").replace("\u00a0",""), lastContract, "- last Contract");
        }

        softAssert.assertAll();

    }

    public void addChangeContractTwoTransaction(){

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
                "", "", "", "", "", "Contract Type 2",
                "", "", "", "PHP Developer", "01/01/2020",
                "01/01/2020", "", "", "", "");


        employeeCode = empCode.getAttribute("value");
        hold(500);
        driver.switchTo().defaultContent();
        mainMenu.mainMenu("Workforce Management","Change Transactions");
        hold(500);

        changeTransactions = new ChangeTransactions();
        changeTransactions.jobContract(employeeCode, "", "01/01/2021" , "Contract Type 1");
        changeTransactions.jobContract(employeeCode, "", "06/06/2022" , "Contract Type 1");

        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);
        clickOn(employmentInformationPage);
        hold(500);
        elementWaitAdvanced(By.id("select2-site_1-container"));

        softAssert.assertEquals(personnelInformation.contract_typeE.getText(), "Contract Type 1", "- New Contract Type");
        softAssert.assertEquals(personnelInformation.contract_start_dateE.getAttribute("value"), "06/06/2022", "- New Contract Start Date");

        hold(500);
        clickOn(experiencesTab);
        hold(300);
        elementWaitAdvanced(By.name("start_date"));
        clickOn(items.get(0));
        hold(300);

        softAssert.assertEquals(fromDate.getAttribute("value"), "01/01/2021");
        softAssert.assertEquals(toDate.getAttribute("value"), "");
        softAssert.assertEquals(contractJob.getAttribute("value").replace("\u00a0",""), "Contract Type 1");

        clickOn(items.get(1));
        hold(300);

        softAssert.assertEquals(fromDate.getAttribute("value"), "01/01/2020");
        softAssert.assertEquals(toDate.getAttribute("value"), "31/12/2020");
        softAssert.assertEquals(contractJob.getAttribute("value").replace("\u00a0",""), "Contract Type 2");

        softAssert.assertAll();

    }

    ///////////// Experiences Page //////////////

    public void addExperience(String startDate, String endDate, boolean untilNow, String previousEmployer, String previousPosition, String salary,
                              String salaryCurrency, String contactPerson, String contactPhone, String contactPosition, String country, String jobPlace,
                              String quitReason, String experiencePlace, String experienceType, String natureOfWork, String jobClassification, String relevance,
                              String responsibilities){

        hold(500);
        elementWaitAdvanced(By.id("start_date"));
        setText(startDateE, startDate);
        setText(endDateE, endDate);
        if (untilNow){
            clickOn(untilNowE);
        }
        setText(previousEmployerE, previousEmployer);
        setText(previousPositionE, previousPosition);
        setText(salaryE, salary);
        selectOption(salaryCurrencyE, salaryCurrency);
        setText(contactPersonE, contactPerson);
        setText(contactPhoneE, contactPhone);
        setText(contactPositionE, contactPosition);
        selectOption(countryE, country);
        scrollToElement(responsibilitiesE);
        setText(jobPlaceE, jobPlace);
        setText(quitReasonE, quitReason);
        selectOption(experiencePlaceE, experiencePlace);
        selectOption(experienceTypeE, experienceType);
        selectOption(natureOfWorkE, natureOfWork);
        selectOption(jobClassificationE, jobClassification);
        selectOption(relevanceE, relevance);
        setText(responsibilitiesE, responsibilities);
        scrollToElement(empCode);
        hold(200);
        clickOn(saveBtn);
        hold(300);

    }

    public void addExperienceWithAssertion(String startDate, String endDate, boolean untilNow, String previousEmployer, String previousPosition, String salary,
                                           String salaryCurrency, String contactPerson, String contactPhone, String contactPosition, String country, String jobPlace,
                                           String quitReason, String experiencePlace, String experienceType, String natureOfWork, String jobClassification, String relevance,
                                           String responsibilities){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(experiencesPage);
        hold(300);
        addExperience(startDate, endDate, untilNow, previousEmployer, previousPosition, salary, salaryCurrency,
                contactPerson, contactPhone, contactPosition, country, jobPlace, quitReason, experiencePlace,
                experienceType, natureOfWork, jobClassification, relevance, responsibilities);

        Assert.assertTrue(item.isDisplayed(), "-Issue, Experience Button Not Appear!");
        clickOn(item);
        hold(300);

        softAssert.assertEquals(startDateE.getAttribute("value"), startDate, "- Start Date!");
        softAssert.assertEquals(endDateE.getAttribute("value"), endDate, "- End Date");
        softAssert.assertEquals(untilNowE.isSelected(), untilNow, "- Until Now");
        softAssert.assertEquals(previousEmployerE.getAttribute("value"), previousEmployer, "- Previous Employer");
        softAssert.assertEquals(previousPositionE.getAttribute("value"), previousPosition, "- Previous Position");
        softAssert.assertEquals(salaryE.getAttribute("value"), salary, "- Salary");
        softAssert.assertEquals(salaryCurrencyE.getText(), salaryCurrency, "- Salary Currency");
        softAssert.assertEquals(contactPersonE.getAttribute("value"), contactPerson, "- Contact Person");
        softAssert.assertEquals(contactPhoneE.getAttribute("value"), contactPhone, "- Contact Phone");
        softAssert.assertEquals(contactPositionE.getAttribute("value"), contactPosition, "- Contact Position");
        softAssert.assertEquals(countryE.getText(), country, "- Country");
        softAssert.assertEquals(jobPlaceE.getAttribute("value"), jobPlace, "- Job Place");
        softAssert.assertEquals(quitReasonE.getAttribute("value"), quitReason, "- Quit Reason");
        softAssert.assertEquals(experiencePlaceE.getText(), experiencePlace, "- Experience Place");
        softAssert.assertEquals(experienceTypeE.getText(), experienceType, "- Experience Type");
        softAssert.assertEquals(natureOfWorkE.getText(), natureOfWork, "- Nature Of Work");
        softAssert.assertEquals(jobClassificationE.getText(), jobClassification, "- Job Classification");
        softAssert.assertEquals(relevanceE.getText(), relevance, "- Relevance");
        softAssert.assertEquals(responsibilitiesE.getAttribute("value"), responsibilities, "- Responsibilities");

        softAssert.assertAll();

    }

    public void editExperience(){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(experiencesPage);
        hold(300);
        addExperience("01/01/2017", "02/02/2019", false, "Employer"+ randomNumber(),
                "Previous Position Test", "1000.000", "Jordanian Dinar", "Person 1",
                "07999"+randomNumber2(), "Contact Position Test", "Jordan", "Amman",
                "Reason Test 1", "Experience Place 1", "Experience Type 1", "Nature Of Work 1",
                "Job Classification 1", "Relevant", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nunc tellus, feugiat ut facilisis in, aliquam nec dui. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas consectetur felis id mollis. Aliquam eu ipsum sit amet ex dictum eleifend. Cras consequat tincidunt purus, vel lobortis lectus rhoncus sed. Sed elit ipsum, accumsan nec mollis eget, imperdiet et massa. Maecenas tempor ante vitae nibh semper, et cursus dui egestas. Quisque facilisis lorem et lacus eleifend vehicula. Morbi mollis eu dolor eu lacinia. Donec id dolor a sapien consequat interdum. Etiam quis tincidunt augue, id congue turpis. Maecenas tincidunt mi tempus, maximus est ac, aliquam lectus. In porttitor lacus at pulvinar ornare. Vestibulum blandit diam quis sapien euismod venenatis. Mauris semper vestibulum sollicitudin.");

        Assert.assertTrue(item.isDisplayed(), "-Issue, Language Button Not Appear!");
        clickOn(item);
        hold(300);

        startDateE.clear();
        hold(300);
        setText(startDateE, "05/05/2018");
        endDateE.clear();
        hold(300);
        clickOn(untilNowE);
        hold(300);
        previousEmployerE.clear();
        hold(300);
        setText(previousEmployerE, "Employer Edited");
        previousPositionE.clear();
        hold(300);
        setText(previousPositionE, "Position Edited");
        hold(300);
        salaryE.clear();
        hold(300);
        setText(salaryE, "1500.000");
        scrollToElement(responsibilitiesE);
        jobPlaceE.clear();
        hold(300);
        setText(jobPlaceE, "Zarqa Edited");
        selectOption(relevanceE, "Choose");
        responsibilitiesE.clear();
        hold(300);
        setText(responsibilitiesE, "Test Edited");
        scrollToElement(empCode);
        clickOn(saveBtn);

        hold(500);
        clickOn(item);
        hold(500);

        softAssert.assertEquals(startDateE.getAttribute("value"), "05/05/2018", "- Start Date!");
        softAssert.assertEquals(untilNowE.isSelected(), true, "- Until Now");
        softAssert.assertEquals(previousEmployerE.getAttribute("value"), "Employer Edited", "- Previous Employer");
        softAssert.assertEquals(previousPositionE.getAttribute("value"), "Position Edited", "- Previous Position");
        softAssert.assertEquals(salaryE.getAttribute("value"), "1500.000", "- Salary");
        softAssert.assertEquals(jobPlaceE.getAttribute("value"), "Zarqa Edited", "- Job Place");
        softAssert.assertEquals(relevanceE.getText(), "Choose", "- Relevance");
        softAssert.assertEquals(responsibilitiesE.getAttribute("value"), "Test Edited", "- Responsibilities");

        softAssert.assertAll();

    }

    public void deleteExperience(){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(experiencesPage);
        hold(300);
        addExperience("01/01/2017", "02/02/2019", false, "Employer"+ randomNumber(),
                "Previous Position Test", "1000.000", "Jordanian Dinar", "Person 1",
                "07999"+randomNumber2(), "Contact Position Test", "Jordan", "Amman",
                "Reason Test 1", "Experience Place 1", "Experience Type 1", "Nature Of Work 1",
                "Job Classification 1", "Relevant", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nunc tellus, feugiat ut facilisis in, aliquam nec dui. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas consectetur felis id mollis. Aliquam eu ipsum sit amet ex dictum eleifend. Cras consequat tincidunt purus, vel lobortis lectus rhoncus sed. Sed elit ipsum, accumsan nec mollis eget, imperdiet et massa. Maecenas tempor ante vitae nibh semper, et cursus dui egestas. Quisque facilisis lorem et lacus eleifend vehicula. Morbi mollis eu dolor eu lacinia. Donec id dolor a sapien consequat interdum. Etiam quis tincidunt augue, id congue turpis. Maecenas tincidunt mi tempus, maximus est ac, aliquam lectus. In porttitor lacus at pulvinar ornare. Vestibulum blandit diam quis sapien euismod venenatis. Mauris semper vestibulum sollicitudin.");

        Assert.assertTrue(item.isDisplayed(), "-Issue, Language Button Not Appear!");
        clickOn(item);
        hold(300);
        clickOn(deleteBtn);
        hold(500);
        clickOn(alertButtonOkDelete);
        hold(300);
        Assert.assertTrue(checkElementIfNotAppear(items), "item still appear");

    }

    public void addExperienceAfterHiringDate(){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(experiencesPage);
        hold(300);
        addExperience("01/01/2021", "02/02/2021", false, "Employer"+ randomNumber(),
                "Previous Position Test", "1000.000", "Jordanian Dinar", "Person 1",
                "07999"+randomNumber2(), "Contact Position Test", "Jordan", "Amman",
                "Reason Test 1", "Experience Place 1", "Experience Type 1", "Nature Of Work 1",
                "Job Classification 1", "Relevant", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nunc tellus, feugiat ut facilisis in, aliquam nec dui. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas consectetur felis id mollis. Aliquam eu ipsum sit amet ex dictum eleifend. Cras consequat tincidunt purus, vel lobortis lectus rhoncus sed. Sed elit ipsum, accumsan nec mollis eget, imperdiet et massa. Maecenas tempor ante vitae nibh semper, et cursus dui egestas. Quisque facilisis lorem et lacus eleifend vehicula. Morbi mollis eu dolor eu lacinia. Donec id dolor a sapien consequat interdum. Etiam quis tincidunt augue, id congue turpis. Maecenas tincidunt mi tempus, maximus est ac, aliquam lectus. In porttitor lacus at pulvinar ornare. Vestibulum blandit diam quis sapien euismod venenatis. Mauris semper vestibulum sollicitudin.");

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The Previous Experience Start Date Can Not Be After The Hiring Date!");
        softAssert.assertAll();


    }

    public void experienceValidateMandatoryFields(){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(experiencesPage);
        hold(300);
        addExperience("", "", true, "",
                "", "", "", "",
                "", "", "", "",
                "", "", "", "",
                "", "", "");

        softAssert.assertTrue(alertBox.isDisplayed(), "- Start Date Validation!");
        softAssert.assertTrue(startDateE.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");

        clickOn(okBtnAlert);
        hold(500);
        setText(startDateE, "01/01/2019");
        hold(300);
        clickOn(saveBtn);
        hold(300);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Salary Validation!");
        softAssert.assertTrue(salaryE.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");

        softAssert.assertAll();
    }

    public void addExperienceSpecialCharactersInSalaryField(){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(experiencesPage);
        hold(300);
        addExperience("01/01/2016", "", false, "",
                "", "test", "", "",
                "", "", "", "",
                "", "", "", "",
                "", "", "");

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Should Only Contain Decimal Values.");
        softAssert.assertTrue(salaryE.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void addExperienceEndDateBeforeStartDate(){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(experiencesPage);
        hold(300);
        addExperience("05/05/2016", "01/01/2016", false, "",
                "", "1000.000", "", "",
                "", "", "", "",
                "", "", "", "",
                "", "", "");

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "The End Date Can Not Be Before The Start Date! Please Re-enter The End Date");
        softAssert.assertTrue(endDateE.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void experienceAddMoreThanOneRecord(int experienceCount){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(experiencesPage);
        hold(300);

        for (int i = 1; i <= experienceCount; i++){

            addExperience("01/0"+i+"/2016", "", false, "Employer "+i,
                    "Position "+i, "1000.000", "", "",
                    "", "", "", "",
                    "", "", "", "",
                    "", "", "");

            clickOn(addBtn);
            hold(500);

        }

        softAssert.assertEquals(items.size(), experienceCount, "Issue in the number of Experience!");
        softAssert.assertAll();

    }

    /////////// Practical Experience ///////////

    public void addPracticalExperience(String date, String showIn, String english, String arabic){

        hold(500);
        elementWaitAdvanced(By.id("exp_date"));
        practicalExperienceDateE.clear();
        hold(300);
        setText(practicalExperienceDateE, date);
        selectOption(practicalExperienceShowInE, showIn);
        setText(practicalExperienceEnglishE, english);
        setText(practicalExperienceArabicE, arabic);
        hold(500);
        clickOn(saveBtn);
        hold(300);

    }

    public void addPracticalExperienceWithAssertion(String date, String showIn, String english, String arabic){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(practicalExperiencePage);
        hold(300);
        addPracticalExperience(date, showIn, english, arabic);

        Assert.assertTrue(item.isDisplayed(), "-Issue, Practical Experience Item Not Appear!");
        clickOn(item);
        hold(300);

        softAssert.assertEquals(practicalExperienceDateE.getAttribute("value"), date, "- Date");
        softAssert.assertEquals(practicalExperienceShowInE.getText(), showIn, "- Show In");
        softAssert.assertEquals(practicalExperienceEnglishE.getAttribute("value").trim(), english, "- English");
        softAssert.assertEquals(practicalExperienceArabicE.getAttribute("value").trim(), arabic, "- Arabic");
        softAssert.assertAll();

    }

    public void editPracticalExperience(){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(practicalExperiencePage);
        hold(300);
        addPracticalExperience("01/01/2019", "Detailed Resume",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent pharetra ligula at neque blandit, ac tempor turpis egestas. Vivamus posuere odio a egestas tempor. Quisque nec rutrum odio. Phasellus fermentum vestibulum rutrum. Phasellus vel urna eleifend, mattis urna quis, porttitor purus. Donec tincidunt nulla sit amet justo fringilla commodo. Suspendisse ac orci gravida, dictum ex sed, tempor massa. Sed fermentum elementum lorem in lobortis. Nunc et venenatis est, nec tincidunt leo. Integer eu diam tempus, pellentesque felis ut, faucibus justo. Fusce quis libero vitae erat vehicula varius. Proin ac nisi id dui porta posuere sit amet eu ipsum. Nam urna dui, rhoncus id turpis sit amet, hendrerit dictum lacus. Nunc et tortor vel dolor suscipit maximus eget ut sem. Nullam ut tortor faucibus, imperdiet mauris quis, viverra lacus.",
                "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق. إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع.");

        Assert.assertTrue(item.isDisplayed(), "-Issue, Practical Experience Item Not Appear!");
        clickOn(item);
        hold(300);
        practicalExperienceDateE.clear();
        hold(300);
        setText(practicalExperienceDateE, "05/05/2018");
        selectOption(practicalExperienceShowInE, "Brief Resume");
        practicalExperienceEnglishE.clear();
        hold(500);
        setText(practicalExperienceEnglishE, "English Edit");
        practicalExperienceArabicE.clear();
        hold(500);
        setText(practicalExperienceArabicE, "تعديل عربي");
        hold(200);
        clickOn(saveBtn);
        hold(300);

        softAssert.assertEquals(practicalExperienceDateE.getAttribute("value"), "05/05/2018", "- Date");
        softAssert.assertEquals(practicalExperienceShowInE.getText(), "Brief Resume", "- Show In");
        softAssert.assertEquals(practicalExperienceEnglishE.getAttribute("value").trim(), "English Edit", "- English");
        softAssert.assertEquals(practicalExperienceArabicE.getAttribute("value").trim(), "تعديل عربي", "- Arabic");
        softAssert.assertAll();

    }

    public void deletePracticalExperience(){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(practicalExperiencePage);
        hold(300);
        addPracticalExperience("01/01/2019", "Detailed Resume",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent pharetra ligula at neque blandit, ac tempor turpis egestas. Vivamus posuere odio a egestas tempor. Quisque nec rutrum odio. Phasellus fermentum vestibulum rutrum. Phasellus vel urna eleifend, mattis urna quis, porttitor purus. Donec tincidunt nulla sit amet justo fringilla commodo. Suspendisse ac orci gravida, dictum ex sed, tempor massa. Sed fermentum elementum lorem in lobortis. Nunc et venenatis est, nec tincidunt leo. Integer eu diam tempus, pellentesque felis ut, faucibus justo. Fusce quis libero vitae erat vehicula varius. Proin ac nisi id dui porta posuere sit amet eu ipsum. Nam urna dui, rhoncus id turpis sit amet, hendrerit dictum lacus. Nunc et tortor vel dolor suscipit maximus eget ut sem. Nullam ut tortor faucibus, imperdiet mauris quis, viverra lacus.",
                "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق. إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع.");

        Assert.assertTrue(item.isDisplayed(), "-Issue, Practical Experience Item Not Appear!");
        clickOn(item);
        hold(300);
        clickOn(deleteBtn);
        hold(500);
        clickOn(alertButtonOkDelete);
        hold(300);
        Assert.assertTrue(checkElementIfNotAppear(items), "item still appear");

    }

    public void practicalExperienceValidateMandatoryFields(){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(practicalExperiencePage);
        hold(300);
        addPracticalExperience("", "",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent pharetra ligula at neque blandit, ac tempor turpis egestas. Vivamus posuere odio a egestas tempor. Quisque nec rutrum odio. Phasellus fermentum vestibulum rutrum. Phasellus vel urna eleifend, mattis urna quis, porttitor purus. Donec tincidunt nulla sit amet justo fringilla commodo. Suspendisse ac orci gravida, dictum ex sed, tempor massa. Sed fermentum elementum lorem in lobortis. Nunc et venenatis est, nec tincidunt leo. Integer eu diam tempus, pellentesque felis ut, faucibus justo. Fusce quis libero vitae erat vehicula varius. Proin ac nisi id dui porta posuere sit amet eu ipsum. Nam urna dui, rhoncus id turpis sit amet, hendrerit dictum lacus. Nunc et tortor vel dolor suscipit maximus eget ut sem. Nullam ut tortor faucibus, imperdiet mauris quis, viverra lacus.",
                "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق. إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع.");

        softAssert.assertTrue(alertBox.isDisplayed(), "- Practical Experience Date");
        softAssert.assertTrue(practicalExperienceDateE.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");

        softAssert.assertAll();

    }

    public void practicalExperienceAddMoreThanOneRecord(int practicalCount){

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

        clickOn(experiencesTab);
        hold(300);
        clickOn(practicalExperiencePage);
        hold(300);

        for (int i = 1; i <= practicalCount; i++){
            addPracticalExperience("01/0"+i+"/2019", "Detailed Resume",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent pharetra ligula at neque blandit, ac tempor turpis egestas. Vivamus posuere odio a egestas tempor. Quisque nec rutrum odio. Phasellus fermentum vestibulum rutrum. Phasellus vel urna eleifend, mattis urna quis, porttitor purus. Donec tincidunt nulla sit amet justo fringilla commodo. Suspendisse ac orci gravida, dictum ex sed, tempor massa. Sed fermentum elementum lorem in lobortis. Nunc et venenatis est, nec tincidunt leo. Integer eu diam tempus, pellentesque felis ut, faucibus justo. Fusce quis libero vitae erat vehicula varius. Proin ac nisi id dui porta posuere sit amet eu ipsum. Nam urna dui, rhoncus id turpis sit amet, hendrerit dictum lacus. Nunc et tortor vel dolor suscipit maximus eget ut sem. Nullam ut tortor faucibus, imperdiet mauris quis, viverra lacus.",
                    "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق. إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع.");

            clickOn(addBtn);
            hold(500);
        }

        softAssert.assertEquals(items.size(), practicalCount, "Issue in the number of Practical Experience!");
        softAssert.assertAll();

    }

}
