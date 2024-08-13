package webBackend.personnelInformation;

import bases.WebBase;
import webBackend.general.AttachmentsSetup;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static utilities.WebHelper.*;
import static utilities.VersionGetter.versionGetter;

import utilities.MssqlConnect;

import java.util.List;

public class AddressAndContacts extends WebBase {

    @FindBy(id = "start_date")
    WebElement startDateE;
    @FindBy(id = "end_date")
    WebElement endDateE;
    @FindBy(xpath = "//span[contains(@id, 'select2-country_code')]")
    WebElement countryE;
    @FindBy(xpath = "//span[contains(@id, 'select2-city_code')]")
    WebElement cityE;
    @FindBy(name = "city")
    WebElement cityReferences;
    @FindBy(name = "province")
    WebElement provinceE;
    @FindBy(name = "district")
    WebElement districtE;
    @FindBy(name = "area_no")
    WebElement landNumberE;
    @FindBy(name = "slip_no")
    WebElement partNumberE;
    @FindBy(name = "small_city")
    WebElement neighborhoodE;
    @FindBy(name = "street")
    WebElement streetE;
    @FindBy(name = "building_type")
    WebElement buildingTypeE;
    @FindBy(name = "building_name")
    WebElement buildingNameE;
    @FindBy(name = "gate")
    WebElement entranceE;
    @FindBy(name = "floor")
    WebElement floorE;
    @FindBy(name = "apartment")
    WebElement apartmentE;
    @FindBy(name = "town")
    WebElement townE;
    @FindBy(name = "real_estate_area")
    WebElement realEstateAreaE;
    @FindBy(name = "real_estate_number")
    WebElement realEstateNumberE;
    @FindBy(name = "telephone1")
    WebElement telephone1E;
    @FindBy(name = "telephone2")
    WebElement telephone2E;
    @FindBy(name = "poBox")
    WebElement poBoxE;
    @FindBy(name = "zip_code")
    WebElement zipCodeE;
    @FindBy(name = "fax")
    WebElement faxE;
    @FindBy(name = "distance_to_company")
    WebElement distanceToCompanyE;
    @FindBy(id = "Support_documents")
    WebElement attachmentDocumentFile;
    @FindBy(xpath = "//img[@alt='Attachment Thumbnail']")
    WebElement checkAttachmentImg;
    @FindBy(xpath = "//a[@class='mar-left-5']")
    WebElement checkAttachmentFile;
    @FindBy(name = "detail_address")
    WebElement addressE;
    @FindBy(xpath = "//div[@class='textAlign']//label[contains(@style, 'font-size:20px')]")
    WebElement alertText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    WebElement alertBox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addBtn;
    @FindBy(xpath = "//span[contains(@onclick, 'confirm_delete')]")
    WebElement deleteBtn;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDelete;
    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'Addresses.php')]")
    WebElement addressAndContactsTab;
    @FindBy(xpath = "//div[contains(@onclick, 'Emp_Contacts.php')]")
    WebElement contactsPage;
    @FindBy(xpath = "//div[contains(@onclick, 'Emergency_Contacts.php')]")
    WebElement referencesPage;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    WebElement item;
    @FindBy(xpath =  "//ul[contains(@class, 'bg-icon')]//li[@class='nav-item']")
    List<WebElement> items;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    List<WebElement> checkItem;
    @FindBy (xpath = "//div[@class='div-delete-employee']")
    WebElement deleteAttachment;
    @FindBy(xpath = "//img[@alt='Attachment Thumbnail']")
    List<WebElement> checkAttach;
    @FindBy(xpath = "//img[contains(@src, 'locked_attachment.png')]")
    WebElement checkAttachForUserDontHavePermission;
    @FindBy(xpath = "//div[@class='div-delete-employee']")
    List<WebElement> checkDeleteAttachment;
    @FindBy(xpath = "//span[contains(@id, 'select2-contact_types')]")
    WebElement contactsTypes;
    @FindBy(name = "contact_value")
    WebElement contactValueE;
    @FindBy(name = "name")
    WebElement contactNameReference;
    @FindBy(xpath = "//span[contains(@id, 'select2-relationship')]")
    WebElement relationshipsE;
    @FindBy(id = "relationship_other")
    WebElement relationshipOtherE;
    @FindBy(name = "contact_position")
    WebElement contactPositionE;
    @FindBy(name = "company_name")
    WebElement companyNameE;
    @FindBy(name = "work_phone")
    WebElement workPhoneE;
    @FindBy(name = "home_phone")
    WebElement homePhoneE;
    @FindBy(name = "email")
    WebElement emailE;
    @FindBy(id = "employee_code")
    WebElement empCode;
    SoftAssert softAssert = new SoftAssert();
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    AttachmentsSetup attachmentsSetup;
    PersonnelInformation personnelInformation;
    String employeeCode = null;
    PersonalInformation_OCT personalInformationOct;

    public void addAddress(String fromDate, String toDate, String country, String city, String province,
                           String district, String landNumber, String partNumber, String neighborhood,
                           String street, String buildingType, String buildingName, String entrance,
                           String floor, String apartment, String town, String realEstateArea,
                           String realEstateNumber, String telephone1, String telephone2, String poBOX,
                           String zipCode, String fax, String distanceToCompany, String address){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            hold(500);
            elementWaitAdvanced(By.id("start_date"));
            setText(startDateE, fromDate);
            setText(endDateE, toDate);
            selectOption(countryE, country);
            selectOption(cityE, city);
            setText(provinceE, province);
            setText(districtE, district);
            setText(landNumberE, landNumber);
            setText(partNumberE, partNumber);
            setText(neighborhoodE, neighborhood);
            setText(streetE, street);
            setText(buildingTypeE, buildingType);
            setText(buildingNameE, buildingName);
            setText(entranceE, entrance);
            setText(floorE, floor);
            setText(apartmentE, apartment);
            setText(townE, town);
            setText(realEstateAreaE, realEstateArea);
            setText(realEstateNumberE, realEstateNumber);
            setText(telephone1E, telephone1);
            setText(telephone2E, telephone2);
            setText(poBoxE, poBOX);
            setText(zipCodeE, zipCode);
            setText(faxE, fax);
            setText(distanceToCompanyE, distanceToCompany);
            attachmentDocumentFile.sendKeys(uploadRandomImage());
            addressE.clear();
            hold(300);
            setText(addressE, address);
            scrollToElement(empCode);
            clickOn(saveBtn);
            hold(300);

        }else {

            personalInformationOct = new PersonalInformation_OCT();
            personalInformationOct.addAddress(fromDate, toDate, country, city, province,
                    district, landNumber, partNumber, neighborhood,
                    street, buildingType, buildingName, entrance,
                    floor, apartment, town, realEstateArea,
                    realEstateNumber, telephone1, telephone2, poBOX,
                    zipCode, fax, distanceToCompany, address);

        }

    }

    public void goToAddress(){
        if(!versionGetter().equalsIgnoreCase("OCT")){
            clickOn(addressAndContactsTab);
            hold(500);
            elementWaitAdvanced(By.name("start_date"));
        }else {
            personalInformationOct = new PersonalInformation_OCT();
            clickOn(personalInformationOct.addressTab);
            hold(500);
            elementWaitAdvanced(By.name("start_date"));
        }
    }

    public void addAddressWithAssertion(String fromDate, String toDate, String country, String city, String province,
                                        String district, String landNumber, String partNumber, String neighborhood,
                                        String street, String buildingType, String buildingName, String entrance,
                                        String floor, String apartment, String town, String realEstateArea,
                                        String realEstateNumber, String telephone1, String telephone2, String poBOX,
                                        String zipCode, String fax, String distanceToCompany, String address){

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

        clickOn(addressAndContactsTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));

        addAddress(fromDate, toDate, country, city, province, district, landNumber, partNumber,
                neighborhood, street, buildingType, buildingName, entrance, floor, apartment, town,
                realEstateArea, realEstateNumber, telephone1, telephone2, poBOX, zipCode, fax,
                distanceToCompany, address);

        softAssert.assertEquals(startDateE.getAttribute("value"), fromDate, "- From Date");
        softAssert.assertEquals(endDateE.getAttribute("value"), toDate, "- To Date");
        softAssert.assertEquals(countryE.getText(), country, "- Country");
        softAssert.assertEquals(cityE.getText(), city, "- City");
        softAssert.assertEquals(provinceE.getAttribute("value"), province, "- Province");
        softAssert.assertEquals(districtE.getAttribute("value"), district, "- District");
        softAssert.assertEquals(landNumberE.getAttribute("value"), landNumber, "- Land Number");
        softAssert.assertEquals(partNumberE.getAttribute("value"), partNumber, "- Part Number");
        softAssert.assertEquals(neighborhoodE.getAttribute("value"), neighborhood, "- Neighborhood");
        softAssert.assertEquals(streetE.getAttribute("value"), street, "- Street");
        softAssert.assertEquals(buildingTypeE.getAttribute("value"), buildingType, "- Building Type");
        softAssert.assertEquals(buildingNameE.getAttribute("value"), buildingName, "- Building Name");
        softAssert.assertEquals(entranceE.getAttribute("value"), entrance, "- Entrance");
        softAssert.assertEquals(floorE.getAttribute("value"), floor, "- Floor");
        softAssert.assertEquals(apartmentE.getAttribute("value"), apartment, "- Apartment");
        softAssert.assertEquals(townE.getAttribute("value"), town, "- Town");
        softAssert.assertEquals(realEstateAreaE.getAttribute("value"), realEstateArea, "- Real Estate Area");
        softAssert.assertEquals(realEstateNumberE.getAttribute("value"), realEstateNumber, "- Real Estate Number");
        softAssert.assertEquals(telephone1E.getAttribute("value"), telephone1, "- Telephone 1");
        softAssert.assertEquals(telephone2E.getAttribute("value"), telephone2, "- Telephone 2");
        softAssert.assertEquals(poBoxE.getAttribute("value"), poBOX, "- P.O Box");
        softAssert.assertEquals(zipCodeE.getAttribute("value"), zipCode, "- Zip Code");
        softAssert.assertEquals(faxE.getAttribute("value"), fax, "- Fax");
        softAssert.assertEquals(distanceToCompanyE.getAttribute("value"), distanceToCompany, "- Distance To Company");
        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile.getAttribute("href").isEmpty(), "- Attachment File");
        softAssert.assertEquals(addressE.getAttribute("value").trim(), address, "- Address");
        softAssert.assertAll();

    }

    public void editAddress(){

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

        clickOn(addressAndContactsTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));

        addAddress("01/01/2020", "02/02/2021", "Jordan", "Zarqa",
                "Zarqa Province", "Zarqa District", randomNumber()+"1", randomNumber2()+"3",
                "Alhashimeyeh", "36", "House", "BN"+randomNumber(), "33",
                "1", "1", "Zarqa Town", "Zarqa Real Estate Area", "25"+randomNumber2(),
                "0799999999", "0788888888", "66"+randomNumber(), "23584", "fax548",
                "20.000", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent maximus convallis turpis ac luctus. In condimentum sapien risus, in pharetra metus rhoncus nec.");

        clickOn(item);
        hold(300);
        clickOn(deleteAttachment);
        hold(500);
        clickOn(alertButtonOkDelete);
        hold(500);
        startDateE.clear();
        hold(300);
        setText(startDateE, "05/05/2020");
        endDateE.clear();
        hold(300);
        setText(endDateE, "03/11/2021");
        provinceE.clear();
        hold(300);
        setText(provinceE, "Zarqa Province Edited");
        landNumberE.clear();
        hold(300);
        setText(landNumberE, "11111");
        streetE.clear();
        hold(300);
        setText(streetE, "ST2222");
        floorE.clear();
        hold(300);
        setText(floorE, "0");
        telephone1E.clear();
        hold(300);
        setText(telephone1E, "0777777777");
        hold(300);
        addressE.clear();
        hold(300);
        setText(addressE, "Zarqa");
        hold(300);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(300);

        softAssert.assertEquals(startDateE.getAttribute("value"), "05/05/2020", "- From Date");
        softAssert.assertEquals(endDateE.getAttribute("value"), "03/11/2021", "- To Date");
        softAssert.assertEquals(provinceE.getAttribute("value"), "Zarqa Province Edited", "- Province");
        softAssert.assertEquals(landNumberE.getAttribute("value"), "11111", "- Land Number");
        softAssert.assertEquals(streetE.getAttribute("value"), "ST2222", "- Street");
        softAssert.assertEquals(floorE.getAttribute("value"), "0", "- Floor");
        softAssert.assertEquals(telephone1E.getAttribute("value"), "0777777777", "- Telephone 1");
        softAssert.assertTrue(checkElementIfNotAppear(checkAttach), "- Attached ICON still appear");
        softAssert.assertTrue(checkElementIfNotAppear(checkDeleteAttachment), "- Delete Attachment ICON still appear");
        softAssert.assertEquals(addressE.getAttribute("value").trim(), "Zarqa", "- Address");
        softAssert.assertAll();

    }

    public void deleteAddress(){

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

        clickOn(addressAndContactsTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));

        addAddress("01/01/2020", "02/02/2021", "Jordan", "Zarqa",
                "Zarqa Province", "Zarqa District", randomNumber()+"1", randomNumber2()+"3",
                "", "", "", "", "",
                "", "", "", "", "",
                "", "", "", "", "",
                "", "");

        clickOn(item);
        hold(300);
        clickOn(deleteBtn);
        hold(500);
        clickOn(alertButtonOkDelete);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));
        Assert.assertTrue(checkElementIfNotAppear(checkItem));

    }

    public void addMoreThanOneAddress(int addressCount){

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

        clickOn(addressAndContactsTab);
        hold(300);
        elementWaitAdvanced(By.id("start_date"));

        for (int i = 1; i <= addressCount; i++){

            addAddress("01/01/2020", "02/02/2021", "Jordan", "Zarqa",
                    "Zarqa Province "+i, "Zarqa District "+i, i+randomNumber()+"1", i+randomNumber2()+"3",
                    "", "", "", "", "",
                    ""+i, "", "", "", "",
                    "", "", "", "", "",
                    "", "");

            hold(300);
            clickOn(addBtn);
            hold(300);

        }

        Assert.assertEquals(items.size(), addressCount, "Issue in the number of Address!");


    }

    public void fromDateAfterToDate(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(addressAndContactsTab);
        elementWaitAdvanced(By.id("start_date"));

        addAddress("05/05/2021", "02/02/2021", "", "",
                "", "", "", "",
                "", "", "", "", "",
                "", "", "", "", "",
                "", "", "", "", "",
                "", "");

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Date Can Not Be Before Transaction Date!");
        softAssert.assertAll();

    }

    public void addNotAllowedAttachment(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(addressAndContactsTab);
        elementWaitAdvanced(By.id("start_date"));

        setText(startDateE, "01/01/2020");
        attachmentDocumentFile.sendKeys(uploadDocFile());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Can Not Upload Any File With The Extension: docx");
        softAssert.assertAll();

    }

    public void addAttachmentWithAllowUpperLimit(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings","Attachments Setup");

        attachmentsSetup = new AttachmentsSetup();
        attachmentsSetup.maximumUploadSizeAndSetType("2", "Do Not Check Maximum Upload Size");

        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(addressAndContactsTab);
        elementWaitAdvanced(By.id("start_date"));

        setText(startDateE, "01/01/2020");
        attachmentDocumentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertEquals(VerifyImage(checkAttachmentImg), 200, "- Attachment Thumbnail");
        softAssert.assertFalse(checkAttachmentFile.getAttribute("href").isEmpty(), "- Attachment File");
        softAssert.assertAll();

    }

    public void addAttachmentWithAlertMessageUpperLimit(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings","Attachments Setup");

        attachmentsSetup = new AttachmentsSetup();
        attachmentsSetup.maximumUploadSizeAndSetType("2", "Alert When Exceeding Maximum Upload Size");

        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(addressAndContactsTab);
        elementWaitAdvanced(By.id("start_date"));

        setText(startDateE, "01/01/2020");
        attachmentDocumentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "Please Note The Maximum Size To Upload Here Is 2 MB");
        softAssert.assertAll();

    }

    public void addAttachmentWithDontAllowUpperLimit(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Settings","Attachments Setup");

        attachmentsSetup = new AttachmentsSetup();
        attachmentsSetup.maximumUploadSizeAndSetType("2", "Never Exceed Maximum Upload Size");

        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(addressAndContactsTab);
        elementWaitAdvanced(By.id("start_date"));

        setText(startDateE, "01/01/2020");
        attachmentDocumentFile.sendKeys(uploadBigSizeImg5MB());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "File Size Exceed The Maximum Upload Size");
        softAssert.assertTrue(checkElementIfNotAppear(checkAttach), "- Attached ICON still appear");
        softAssert.assertTrue(checkElementIfNotAppear(checkDeleteAttachment), "- Delete Attachment ICON still appear");
        softAssert.assertAll();

    }

    public void checkUserWithOptionDontAllowDownloadFile(){

        login = new Login();
        login.ali6User();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(addressAndContactsTab);
        elementWaitAdvanced(By.id("start_date"));

        addAddress("05/05/2021", "", "", "",
                "", "", "", "",
                "", "", "", "", "",
                "", "", "", "", "",
                "", "", "", "", "",
                "", "");
        clickOn(item);
        hold(300);

        softAssert.assertTrue(checkAttachForUserDontHavePermission.isDisplayed(), "- LOCKED Attachment NOT appear");
        softAssert.assertEquals(checkAttachForUserDontHavePermission.getAttribute("alt"), "Sorry You Do Not Have Permission To Access Uploaded Files !");
        softAssert.assertAll();

    }

    public void checkUserWithOptionDontAllowUploadFile(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");
        employeeCode = empCode.getAttribute("value");

        closeIFrame();
        clickOn(personnelInformation.logout);
        hold(500);
        login.ali5User();
        menaModules.menaPAY();
        mainMenu.mainMenu("Employees","Personnel Information");
        personnelInformation.goToEmployeeByCode(employeeCode);

        clickOn(addressAndContactsTab);
        elementWaitAdvanced(By.id("start_date"));
        hold(300);

        setText(startDateE, "01/01/2020");
        attachmentDocumentFile.sendKeys(uploadRandomImage());
        hold(500);
        clickOn(saveBtn);
        hold(500);

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "You Do Not Have Permission To Upload Files!");
        softAssert.assertAll();

    }

    public void addBigTextArea(boolean lengthUpperThan200Character){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(addressAndContactsTab);
        elementWaitAdvanced(By.id("start_date"));

        setText(startDateE, "01/01/2020");
        addressE.clear();
        hold(300);
        if(lengthUpperThan200Character){
            String textUpperThan200 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis lacus varius, vulputate sapien sed, pellentesque risus. Cras fermentum nisl quis mauris semper mollis vel nec lectus. Fusce fermentum volutpat libero posuere vulputate massa nunc.";
            setText(addressE, textUpperThan200);
            hold(500);
            scrollToElement(empCode);
            clickOn(saveBtn);
            hold(300);

            softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
            softAssert.assertEquals(alertText.getText().trim(), "Entered Length Can Not Be More Than 200.");
            softAssert.assertAll();
        }else{
            String textLessThan200 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam molestie pulvinar viverra. Phasellus dignissim tortor at ipsum vehicula egestas. Sed mauris nisi, rhoncus ac tristique sit donec.";
            setText(addressE, textLessThan200);
            hold(500);
            scrollToElement(empCode);
            clickOn(saveBtn);
            hold(500);

            softAssert.assertEquals(addressE.getAttribute("value").trim(), textLessThan200);
            softAssert.assertAll();
        }

    }

    //////////// Contact ///////////

    public void addContact(String contactType, String contactValue){

        hold(500);
        elementWaitAdvanced(By.name("contact_value"));
        selectOption(contactsTypes, contactType);
        setText(contactValueE, contactValue);
        hold(500);
        clickOn(saveBtn);
        hold(300);

    }

    public void addContactWithAssertion(String contactType, String contactValue){

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

        clickOn(addressAndContactsTab);
        hold(300);
        clickOn(contactsPage);
        hold(300);

        addContact(contactType, contactValue);
        clickOn(item);
        hold(300);
        softAssert.assertEquals(contactsTypes.getText(), contactType, "- Contact Type");
        softAssert.assertEquals(contactValueE.getAttribute("value"), contactValue, "- Contact Value");
        softAssert.assertAll();

    }

    public void editContact(){

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

        clickOn(addressAndContactsTab);
        hold(300);
        clickOn(contactsPage);
        hold(300);

        addContact("Contacts 1", "Automation Test");
        clickOn(item);
        hold(300);
        selectOption(contactsTypes, "Contacts 2");
        contactValueE.clear();
        hold(300);
        setText(contactValueE, "Automation Test Edited Value");
        hold(300);
        clickOn(saveBtn);
        clickOn(item);
        hold(300);

        softAssert.assertEquals(contactsTypes.getText(), "Contacts 2", "- Contact Type");
        softAssert.assertEquals(contactValueE.getAttribute("value"), "Automation Test Edited Value", "- Contact Value");
        softAssert.assertAll();

    }

    public void deleteContact(){

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

        clickOn(addressAndContactsTab);
        hold(300);
        clickOn(contactsPage);
        hold(300);

        addContact("Contacts 1", "Automation Test");
        clickOn(item);
        hold(300);
        clickOn(deleteBtn);
        hold(300);
        clickOn(alertButtonOkDelete);
        hold(300);
        elementWaitAdvanced(By.name("contact_value"));
        Assert.assertTrue(checkElementIfNotAppear(checkItem), "item still appear");

    }

    public void addMoreThanOneContact(int contactCount){

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

        clickOn(addressAndContactsTab);
        hold(300);
        clickOn(contactsPage);
        hold(300);

        for (int i = 1; i <= contactCount; i++){

            addContact("Contacts 1", "Automation "+randomNumber()+i);

            hold(300);
            clickOn(addBtn);
            hold(300);

        }

        Assert.assertEquals(items.size(), contactCount, "Issue in the number of Address!");

    }

    //////////// References ///////////

    public void addReference(String contactName, String relationship, String otherRelationship, String contactPosition,
                             String companyName, String workPhone, String homePhone, String city, String street,
                             String  zipCode, String email){

        hold(500);
        elementWaitAdvanced(By.name("name"));
        setText(contactNameReference, contactName);
        selectOption(relationshipsE, relationship, Keys.ARROW_DOWN); //// I use 'Keys.ARROW_DOWN' to scroll to 'other' option because it same character in 'Other' - 'BrOther'
        if(relationship.equalsIgnoreCase("Other")){
            setText(relationshipOtherE, otherRelationship);
        }
        setText(contactPositionE, contactPosition);
        setText(companyNameE, companyName);
        setText(workPhoneE, workPhone);
        setText(homePhoneE, homePhone);
        setText(cityReferences, city);
        setText(streetE, street);
        setText(zipCodeE, zipCode);
        setText(emailE, email);
        hold(300);
        clickOn(saveBtn);
        hold(300);

    }

    public void addReferenceWithAssertion(String contactName, String relationship, String otherRelationship, String contactPosition,
                                          String companyName, String workPhone, String homePhone, String city, String street,
                                          String  zipCode, String email){

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

        clickOn(addressAndContactsTab);
        hold(300);
        clickOn(referencesPage);
        hold(300);
        addReference(contactName, relationship, otherRelationship, contactPosition, companyName, workPhone,
                homePhone, city, street, zipCode, email);

        softAssert.assertEquals(contactNameReference.getAttribute("value"), contactName, "- Contact Name");
        softAssert.assertEquals(relationshipsE.getText(), relationship, " - Relationship");
        softAssert.assertEquals(relationshipOtherE.getAttribute("value"), otherRelationship, "- Other Relationship");
        softAssert.assertEquals(contactPositionE.getAttribute("value"), contactPosition, "- Contact Position");
        softAssert.assertEquals(companyNameE.getAttribute("value"), companyName, "- Company Name");
        softAssert.assertEquals(workPhoneE.getAttribute("value"), workPhone, "- Work Phone");
        softAssert.assertEquals(homePhoneE.getAttribute("value"), homePhone, "- Home Phone");
        softAssert.assertEquals(cityReferences.getAttribute("value"), city, "- City");
        softAssert.assertEquals(streetE.getAttribute("value"), street, "- Street");
        softAssert.assertEquals(zipCodeE.getAttribute("value"), zipCode, "- Zip Code");
        softAssert.assertEquals(emailE.getAttribute("value"), email, "- Email");
        softAssert.assertAll();

    }

    public void editReference(){

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

        clickOn(addressAndContactsTab);
        hold(300);
        clickOn(referencesPage);
        hold(300);
        addReference("Contact "+randomNumber(), "Other", "Test Other", "Position "+randomNumber2(),
                "Company "+randomNumber2(), "06888"+randomNumber(), "0755"+randomNumber(), "Amman",
                "Street "+randomNumber(), "02541", randomNumber()+"test@test.com");

        clickOn(item);
        contactNameReference.clear();
        hold(300);
        setText(contactNameReference, "Contact Edited");
        selectOption(relationshipsE, "Brother");
        companyNameE.clear();
        hold(300);
        setText(companyNameE, "Edited Company");
        workPhoneE.clear();
        hold(300);
        setText(workPhoneE, "079999999");
        emailE.clear();
        hold(300);
        setText(emailE, "edited@gmail.com");
        hold(300);
        clickOn(saveBtn);
        hold(300);
        clickOn(item);
        hold(300);

        softAssert.assertEquals(contactNameReference.getAttribute("value"), "Contact Edited", "- Contact Name");
        softAssert.assertEquals(relationshipsE.getText(), "Brother", " - Relationship");
        softAssert.assertEquals(companyNameE.getAttribute("value"), "Edited Company", "- Company Name");
        softAssert.assertEquals(workPhoneE.getAttribute("value"), "079999999", "- Work Phone");
        softAssert.assertEquals(emailE.getAttribute("value"), "edited@gmail.com", "- Email");
        softAssert.assertAll();

    }

    public void deleteReference(){

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

        clickOn(addressAndContactsTab);
        hold(300);
        clickOn(referencesPage);
        hold(300);
        addReference("Contact "+randomNumber(), "Other", "Test Other", "Position "+randomNumber2(),
                "Company "+randomNumber2(), "06888"+randomNumber(), "0755"+randomNumber(), "Amman",
                "Street "+randomNumber(), "02541", randomNumber()+"test@test.com");

        clickOn(item);
        hold(300);
        clickOn(deleteBtn);
        hold(500);
        clickOn(alertButtonOkDelete);
        hold(300);

        Assert.assertTrue(checkElementIfNotAppear(checkItem), "item still appear");

    }

    public void addMoreThanOneReference(int referenceCount){

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

        clickOn(addressAndContactsTab);
        hold(300);
        clickOn(referencesPage);
        hold(300);

        for (int i = 1; i <= referenceCount; i++){

            addReference("Contact "+i, "Other", "Test Other "+i, "Position "+i,
                    "Company "+randomNumber2(), "06888"+randomNumber(), "0755"+randomNumber(), "Amman",
                    "Street "+i, "02541", i+"test@test.com");

            hold(300);
            clickOn(addBtn);
            hold(300);

        }

        Assert.assertEquals(items.size(), referenceCount, "Issue in the number of Address!");

    }

    public void addWrongEmail(){

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

        clickOn(addressAndContactsTab);
        hold(300);
        clickOn(referencesPage);
        hold(300);
        addReference("Contact Test", "Brother", "", "",
                "", "", "", "",
                "", "", "testWrongEmail#test.com");

        softAssert.assertTrue(alertBox.isDisplayed(), "- Alert Box Not Appear!");
        softAssert.assertEquals(alertText.getText().trim(), "This Field Should Only Contain A Valid Email Address.");
        softAssert.assertTrue(emailE.getAttribute("class").contains("validationErrorCSS"), "- The Field Should be RED Border Appear!");
        softAssert.assertAll();

    }

    public void flag_country_profile_lebanon_5(){

        MssqlConnect.sqlQuery("update adm_branch set country_profile = 5 where branch_code = 'auto_a1'");

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(addressAndContactsTab);
        hold(4000);

        implicitWaitChanging(1000);
        softAssert.assertTrue(driver.findElement(By.id("province_prefix")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("select2-town-container")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("town_prefix")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("select2-real_estate_number-container")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("real_estate_prefix")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("select2-telephone1-container")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.id("telephone1_prefix")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.name("birth_place_address")).isDisplayed());

        MssqlConnect.sqlQuery("update adm_branch set country_profile = 1 where branch_code = 'auto_a1'");
        softAssert.assertAll();

    }

}
