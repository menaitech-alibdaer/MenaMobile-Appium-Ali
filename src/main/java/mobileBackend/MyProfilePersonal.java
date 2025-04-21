package mobileBackend;

import bases.MobileBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static io.appium.java_client.AppiumBy.accessibilityId;

public class MyProfilePersonal extends MobileBasePage {

    @AndroidFindBy(accessibility = "Personal")
    WebElement personalTab;
    @AndroidFindBy(accessibility = "Contact Information")
    WebElement contactInformationTab;
    @AndroidFindBy(accessibility = "Address")
    WebElement addressTab;
    @AndroidFindBy(accessibility = "Bank Information")
    WebElement bankInformationTab;
    @AndroidFindBy(accessibility = "Education")
    WebElement educationTab;
    @AndroidFindBy(accessibility = "Certificates")
    WebElement certificatesTab;
    @AndroidFindBy(accessibility = "Attachments")
    WebElement attachmentsTab;
    @AndroidFindBy(accessibility = "HR Letters")
    WebElement hrLettersTab;
    @AndroidFindBy(accessibility = "Disciplinary Actions")
    WebElement disciplinaryActionsTab;
    @AndroidFindBy(accessibility = "QR Code")
    WebElement qrCodeTab;
    @AndroidFindBy(accessibility = "Incidents Log")
    WebElement incidentsLogTab;

    ////// Contact Information ///////
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Mobile']/following::android.view.View[1]")
    WebElement mobileValue;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Email']/following::android.view.View[1]")
    WebElement emailValue;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Site']/following::android.view.View[1]")
    WebElement siteValue;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Departments']/following::android.view.View[1]")
    WebElement departmentsValue;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Sections']/following::android.view.View[1]")
    WebElement sectionsValue;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Position']/following::android.view.View[1]")
    WebElement positionValue;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Hiring Date']/following::android.view.View[1]")
    WebElement hiringDateValue;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Marital Status']/following::android.view.View[1]")
    WebElement maritalStatusValue;
    @AndroidFindBy(accessibility = "AddButton")
    WebElement contactInformation_AddBtn;
    @AndroidFindBy(accessibility = "AddButton")
    WebElement address_AddBtn;
    @AndroidFindBy(accessibility = "AddButton")
    WebElement bankInformation_EditBtn;
    @AndroidFindBy(accessibility = "AddButton")
    WebElement certificates_AddBtn;
    @AndroidFindBy(accessibility = "AddButton")
    WebElement attachment_AddBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Validity']/following::android.widget.ImageView[1]")
    WebElement validity_firstDate;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Validity']/following::android.widget.ImageView[2]")
    WebElement validity_secondDate;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Certificate Type']/following::android.view.View[@content-desc='Choose'][1]")
    WebElement certificateTypeList;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Document Type']/following::android.view.View[@content-desc='Choose'][1]")
    WebElement DocumentTypeList;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Certificate Type']/following::android.widget.EditText[1]")
    WebElement certificateType_otherFiled;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Certificate Name']/following::android.view.View[@content-desc='Choose'][1]")
    WebElement certificateNameList;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Certificate Name']/following::android.widget.EditText[1]")
    WebElement certificateName_otherFiled;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Grade']/following::android.widget.EditText[1]")
    WebElement gradeF;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Document Number']/following::android.widget.EditText[1]")
    WebElement documentNumberF;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Status']/following::android.view.View[@content-desc='Passed' or @content-desc='Failed'][1]")
    WebElement statusList;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Certificate No.']/following::android.widget.EditText[1]")
    WebElement certificateNoF;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Certificate File']/following::android.widget.ImageView[1]")
    WebElement certificateFileF;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Document File']/following::android.widget.ImageView[1]")
    WebElement documentFileF;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Notes']/following::android.widget.EditText[1]")
    WebElement certificateNoteF;
    @AndroidFindBy(accessibility = "Add Certificate")
    WebElement addCertificateBtn;
    @AndroidFindBy(accessibility = "Save")
    WebElement saveBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Mobile']/following::android.widget.EditText[1]")
    WebElement mobileField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Email']/following::android.widget.EditText[1]")
    WebElement emailField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='P.O.Box']/following::android.widget.EditText[1]")
    WebElement p_o_BoxField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Floor No.']/following::android.widget.EditText[2]")
    WebElement floorNoField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Bldg NO.']/following::android.widget.EditText[3]")
    WebElement bldgNoField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Street Name']/following::android.widget.EditText[1]")
    WebElement streetNameField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Neighborhood']/following::android.widget.EditText[1]")
    WebElement neighborhoodField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='From Country']/following::android.view.View[1]")
    WebElement fromCountryList;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'From City')]/following::android.view.View[1]")
    WebElement fromCityList;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Zip Code']/following::android.widget.EditText[1]")
    WebElement zipCodeField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='State']/following::android.widget.EditText[2]")
    WebElement stateField;
    @AndroidFindBy(accessibility = "Update info")
    WebElement updateInfoBtn;
    @AndroidFindBy(accessibility = "Add Address")
    WebElement addAddressBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Bank Name']/following::android.view.View[1]")
    WebElement bankNameList;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Bank Branch']/following::android.view.View[1]")
    WebElement bankBranchList;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Account Number']/following::android.widget.EditText[1]")
    WebElement accountNumberField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='IBAN Number']/following::android.widget.EditText[1]")
    WebElement IBANNumberField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Notes']/preceding::android.view.View[1]//android.widget.ImageView[1]")
    WebElement bankInformationAttachment;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Notes']/following::android.widget.EditText[1]")
    WebElement bankInformationNotes;
    @AndroidFindBy(accessibility = "Document")
    WebElement documentBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='test.png']")
    WebElement imgUploaded;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='From Date']/following::android.widget.ImageView[1]")
    WebElement fromDate_incidentsLog;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='To Date']/following::android.widget.ImageView[2]")
    WebElement toDate_incidentsLog;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Category']/following::android.view.View[1]")
    WebElement category_incidentsLog;
    @AndroidFindBy(accessibility = "View")
    WebElement viewBtn;

    public void openContactInformation(){
        clickOn(personalTab);
        hold(800);
        clickOn(contactInformationTab);
        waitLoadingElement();
        waitLoadingElement();
    }
    public void openAddress(){
        clickOn(personalTab);
        hold(800);
        clickOn(addressTab);
        waitLoadingElement();
    }
    public void openBankInformation(){
        clickOn(personalTab);
        hold(800);
        clickOn(bankInformationTab);
        waitLoadingElement();
    }
    public void openEducation(){
        clickOn(personalTab);
        hold(800);
        clickOn(educationTab);
        waitLoadingElement();
    }
    public void openCertificates(){
        clickOn(personalTab);
        hold(800);
        clickOn(certificatesTab);
        waitLoadingElement();
    }
    public void openAttachments(){
        clickOn(personalTab);
        hold(800);
        clickOn(attachmentsTab);
        waitLoadingElement();
    }
    public void openHrLetters(){
        clickOn(personalTab);
        hold(800);
        clickOn(hrLettersTab);
        waitLoadingElement();
    }
    public void openDisciplinaryActions(){
        clickOn(personalTab);
        hold(800);
        clickOn(disciplinaryActionsTab);
        waitLoadingElement();
    }
    public void openQrCode(){
        clickOn(personalTab);
        hold(800);
        clickOn(qrCodeTab);
        waitLoadingElement();
        hold(2000);
    }
    public void openIncidentsLog(){
        clickOn(personalTab);
        hold(800);
        clickOn(incidentsLogTab);
        waitLoadingElement();
    }

    public String getContactInformation(String type){
        waitLoadingElement();
        try {
            return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[1]")).getAttribute("content-desc").trim();
        }catch (Exception e){
            try {
                scrollToElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[1]"), true, 6);
                return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[1]")).getAttribute("content-desc").trim();
            }catch (Exception ignored){
                verticalSwipeByPercentages(45, 85, 50);
                return "Not Found!";
            }
        }
    }

    public void addContactInformation(String mobile, String email, boolean checkAlert){
        waitLoadingElement();
        waitLoadingElement();
        try {
            simpleClick(contactInformation_AddBtn, 2);
        }catch (Exception e){
            simpleClick(AppiumBy.xpath("//android.view.View[@content-desc='Contact Information']/following::android.widget.ImageView[1]"), 2);
        }
        waitLoadingElement();
        hold(800);
        if(!mobile.isEmpty()){
            simpleClick(mobileField);
            mobileField.clear();
            setText(mobileField, mobile);
        }
        if(!email.isEmpty()){
            simpleClick(emailField);
            emailField.clear();
            setText(emailField, email);
        }

        verticalSwipeByPercentages(70, 10, 50);
        clickOn(updateInfoBtn);
        hold(500);
        waitLoadingElement();

        if(!checkAlert){
            closeAlert();
            hold(500);
            back();
        }
    }

    ///////// Address ////////

    public String getAddress(String type){
        waitLoadingElement();
        try {
            if(type.equalsIgnoreCase("P.O.Box") || type.equalsIgnoreCase("Floor No.") || type.equalsIgnoreCase("Bldg NO.")){
                return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[3]")).getAttribute("content-desc").trim();
            }else if(type.equalsIgnoreCase("Zip Code") || type.equalsIgnoreCase("State")){
                return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[2]")).getAttribute("content-desc").trim();
            }else{
                return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[1]")).getAttribute("content-desc").trim();
            }
        }catch (Exception e){
            try {
                scrollToElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[1]"), true, 6);
                if(type.equalsIgnoreCase("P.O.Box") || type.equalsIgnoreCase("Floor No.") || type.equalsIgnoreCase("Bldg NO.")){
                    return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[3]")).getAttribute("content-desc").trim();
                }else if(type.equalsIgnoreCase("Zip Code") || type.equalsIgnoreCase("State")){
                    return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[2]")).getAttribute("content-desc").trim();
                }else{
                    return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[1]")).getAttribute("content-desc").trim();
                }
            }catch (Exception ignored){
                verticalSwipeByPercentages(45, 85, 50);
                return "Not Found!";
            }
        }
    }

    public void addAddress(String p_o_Box, String floorNo, String bldgNo, String streetName, String neighborhood, String fromCountry, String  fromCity, String zipCode, String state, boolean checkAlert){
        waitLoadingElement();
        waitLoadingElement();
        clickOn(address_AddBtn, true);
        waitLoadingElement();
        hold(800);

        if(!p_o_Box.isEmpty()){
            setText(p_o_BoxField, p_o_Box);
        }
        if(!p_o_Box.isEmpty()){
            setText(floorNoField, floorNo);
        }
        if(!p_o_Box.isEmpty()){
            setText(bldgNoField, bldgNo);
        }
        if(!p_o_Box.isEmpty()){
            setText(streetNameField, streetName);
        }
        if(!p_o_Box.isEmpty()){
            setText(neighborhoodField, neighborhood);
        }
        if(!fromCountry.isEmpty()){
            clickOn(fromCountryList);
            hold(200);
            clickOn(accessibilityId(fromCountry));
            hold(700);
        }
        if(!fromCity.isEmpty()){
            clickOn(fromCityList);
            hold(200);
            clickOn(accessibilityId(fromCity));
            hold(700);
        }
        if(!zipCode.isEmpty()){
            setText(zipCodeField, zipCode);
        }
        if(!state.isEmpty()){
            setText(stateField, state);
        }

        verticalSwipeByPercentages(70, 10, 50);
        clickOn(addAddressBtn);
        hold(500);
        waitLoadingElement();

        if(!checkAlert){
            closeAlert();
            hold(500);
        }
    }

    public String getBankInformation(String type){
        waitLoadingElement();
        try {
            return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[1]")).getAttribute("content-desc").trim();
        }catch (Exception e){
            try {
                scrollToElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[1]"), true, 6);
                return appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='"+type+"']/following::android.view.View[1]")).getAttribute("content-desc").trim();
            }catch (Exception ignored){
                verticalSwipeByPercentages(45, 85, 50);
                return "Not Found!";
            }
        }
    }

    public void editBankInformation(String bankName, String bankBranch, String accountNumber, String ibanNumber, boolean attachment, String notes, boolean checkAlert){
        waitLoadingElement();
        waitLoadingElement();
        clickOn(bankInformation_EditBtn, true);
        waitLoadingElement();
        hold(800);
        if(!bankName.isEmpty()){
            if(bankNameList.getAttribute("content-desc").equalsIgnoreCase("*")){
                bankNameList = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Bank Name']/following::android.view.View[2]"));
            }
            clickOn(bankNameList);
            hold(200);
            clickOn(accessibilityId(bankName));
            hold(700);
        }
        if(!bankBranch.isEmpty()){
            if(bankBranchList.getAttribute("content-desc").equalsIgnoreCase("*")){
                bankBranchList = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Bank Branch']/following::android.view.View[2]"));
            }
            clickOn(bankBranchList);
            hold(200);
            clickOn(accessibilityId(bankBranch));
            hold(700);
        }
        if(!accountNumber.isEmpty()){
            try {
                setText(accountNumberField, accountNumber);
            }catch (Exception e){
                scrollToElement(accountNumberField, true);
                setText(accountNumberField, accountNumber);
            }
        }
        if(!ibanNumber.isEmpty()){
            try {
                setText(IBANNumberField, ibanNumber);
            }catch (Exception e){
                scrollToElement(IBANNumberField, true);
                setText(IBANNumberField, ibanNumber);
            }
        }

        if(attachment){

            verticalSwipeByPercentages(70, 30, 50);

            // The file to be uploaded
            File file = new File("src/main/resources/testUpload.jpg");
            // Specify the remote path where you want to push the file on the device
            String remotePath = "/sdcard/Download/test.png";
            // Convert the file to Base64 format
            byte[] fileContent = null;
            try {
                fileContent = Files.readAllBytes(Path.of(file.getAbsolutePath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String encodedFile = Base64.getEncoder().encodeToString(fileContent);
            // Upload the file to the device
            ((AndroidDriver) appiumDriver).pushFile(remotePath, encodedFile.getBytes());

            simpleClick(bankInformationAttachment);
            hold(500);
            simpleClick(AppiumBy.xpath("(//android.view.View[contains(@content-desc, 'Document')]/following::android.widget.ImageView)[1]"));
            waitForElementToBeVisible(accessibilityId("Document"));
            clickOn(documentBtn);
            hold(1500);
            try{
                appiumDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']")).isDisplayed();
            }catch (Exception e){
                waitForElementToBeVisible(AppiumBy.accessibilityId("Show roots"));
                simpleClick(AppiumBy.accessibilityId("Show roots"));
                hold(1500);
                waitForElementToBeVisible(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']"));
                simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']"));
                hold(1500);
            }
            waitForElementToBeClickable(imgUploaded);
            simpleClick(imgUploaded);
            hold(1000);
            waitLoadingElement();
            waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, '.png')]"));

        }

        if(!notes.isEmpty()){
            try {
                setText(bankInformationNotes, notes);
            }catch (Exception e){
                scrollToElement(bankInformationNotes, true);
                setText(bankInformationNotes, notes);
            }
        }

        verticalSwipeByPercentages(70, 10, 50);
        clickOn(updateInfoBtn);
        hold(500);
        waitLoadingElement();

        if(!checkAlert){
            closeAlert();
            hold(500);
            back();
        }
    }

    public String getEducation(int major){
        waitLoadingElement();
        return appiumDriver.findElement(AppiumBy.xpath("(//*[contains(@content-desc, 'Major')])["+major+"]")).getAttribute("content-desc").trim();
    }
    public String getCertificates(int certificate){
        waitLoadingElement();
        return appiumDriver.findElement(AppiumBy.xpath("(//*[contains(@content-desc, 'Certificate Name')])["+certificate+"]")).getAttribute("content-desc").trim();
    }
    public void addCertificate(String validityDate1, String validityDate2, String certificateType, String certificateTypeOther, String certificateName, String certificateNameOther,
                               String grade, String status, String certificateNo, boolean certificateFile, String notes){
        waitLoadingElement();
        clickOn(certificates_AddBtn);
        hold(500);
        waitLoadingElement();
        waitLoadingElement();
        setText(validity_firstDate, validityDate1);
        hold(800);
        setText(validity_secondDate, validityDate2);
        hold(800);
        clickOn(certificateTypeList);
        hold(1000);
        clickOn(AppiumBy.accessibilityId(certificateType));
        hold(700);
        waitLoadingElement();
        if(certificateType.equalsIgnoreCase("Other") && !certificateTypeOther.isEmpty()){
            setText(certificateType_otherFiled, certificateTypeOther);
        }
        clickOn(certificateNameList);
        hold(1000);
        clickOn(AppiumBy.accessibilityId(certificateName));
        hold(700);
        waitLoadingElement();
        if(certificateName.equalsIgnoreCase("Other") && !certificateNameOther.isEmpty()){
            setText(certificateName_otherFiled, certificateNameOther);
        }

        verticalSwipeByPercentages(70, 10, 50);

        if(!grade.isEmpty()){
            setText(gradeF, grade);
        }
        if(!status.isEmpty()){
            clickOn(statusList);
            hold(1000);
            clickOn(AppiumBy.accessibilityId(status));
            hold(700);
        }
        if(!certificateNo.isEmpty()){
            setText(certificateNoF, certificateNo);
        }
        if(certificateFile){

            // The file to be uploaded
            File file = new File("src/main/resources/testUpload.jpg");
            // Specify the remote path where you want to push the file on the device
            String remotePath = "/sdcard/Download/test.png";
            // Convert the file to Base64 format
            byte[] fileContent = null;
            try {
                fileContent = Files.readAllBytes(Path.of(file.getAbsolutePath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String encodedFile = Base64.getEncoder().encodeToString(fileContent);
            // Upload the file to the device
            ((AndroidDriver) appiumDriver).pushFile(remotePath, encodedFile.getBytes());

            simpleClick(certificateFileF);
            hold(500);
            waitForElementToBeVisible(accessibilityId("Document"));
            clickOn(documentBtn);
            hold(1500);
            try{
                appiumDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']")).isDisplayed();
            }catch (Exception e){
                waitForElementToBeVisible(AppiumBy.accessibilityId("Show roots"));
                simpleClick(AppiumBy.accessibilityId("Show roots"));
                hold(1500);
                waitForElementToBeVisible(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']"));
                simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']"));
                hold(1500);
            }
            waitForElementToBeClickable(imgUploaded);
            simpleClick(imgUploaded);
            hold(1000);
            waitLoadingElement();
            waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, '.png')]"));
            waitLoadingElement();
            waitLoadingElement();

        }
        if(!notes.isEmpty()){
            setText(certificateNoteF, notes);
        }

        hold(1000);
        clickOn(addCertificateBtn);

    }

    public String getAttachments(int attachment){
        waitLoadingElement();
        return appiumDriver.findElement(AppiumBy.xpath("(//*[contains(@content-desc, 'Document name')])["+attachment+"]")).getAttribute("content-desc").trim();
    }

    public boolean checkAttachmentFileFromAttachment(int attachment){
        waitLoadingElement();
        boolean check = false;
        try {
            hold(1000);
            appiumDriver.findElement(AppiumBy.xpath("(//*[contains(@content-desc, 'Document name')])["+attachment+"]//android.widget.ImageView[last()]")).isDisplayed();
            check = true;
            return check;
        }catch (Exception ignored){
            return check;
        }
    }

    public void addAttachment(String validityDate1, String validityDate2, String documentType, String documentNumber, boolean documentFile){

        waitLoadingElement();
        clickOn(attachment_AddBtn);
        hold(500);
        waitLoadingElement();
        waitLoadingElement();
        setText(validity_firstDate, validityDate1);
        hold(800);
        setText(validity_secondDate, validityDate2);
        hold(800);
        clickOn(DocumentTypeList);
        hold(1000);
        clickOn(AppiumBy.accessibilityId(documentType));
        hold(1000);
        if(!documentNumber.isEmpty()){
            setText(documentNumberF, documentNumber);
        }
        verticalSwipeByPercentages(70, 10, 50);

        if(documentFile){

            // The file to be uploaded
            File file = new File("src/main/resources/testUpload.jpg");
            // Specify the remote path where you want to push the file on the device
            String remotePath = "/sdcard/Download/test.png";
            // Convert the file to Base64 format
            byte[] fileContent = null;
            try {
                fileContent = Files.readAllBytes(Path.of(file.getAbsolutePath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String encodedFile = Base64.getEncoder().encodeToString(fileContent);
            // Upload the file to the device
            ((AndroidDriver) appiumDriver).pushFile(remotePath, encodedFile.getBytes());

            simpleClick(documentFileF);
            hold(500);
            waitForElementToBeVisible(accessibilityId("Document"));
            clickOn(documentBtn);
            hold(1500);
            try{
                appiumDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']")).isDisplayed();
            }catch (Exception e){
                waitForElementToBeVisible(AppiumBy.accessibilityId("Show roots"));
                simpleClick(AppiumBy.accessibilityId("Show roots"));
                hold(1500);
                waitForElementToBeVisible(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']"));
                simpleClick(AppiumBy.xpath("//android.widget.TextView[@text='Downloads']"));
                hold(1500);
            }
            waitForElementToBeClickable(imgUploaded);
            simpleClick(imgUploaded);
            hold(1000);
            waitLoadingElement();
            waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, '.png')]"));
            waitLoadingElement();
            waitLoadingElement();

        }

        hold(1000);
        clickOn(saveBtn);

    }

    public String getHrLetters(int hrLetter){
        waitLoadingElement();
        return appiumDriver.findElement(AppiumBy.xpath("(//*[contains(@content-desc, 'Letter Name')])["+hrLetter+"]")).getAttribute("content-desc").trim();
    }

    public boolean checkHrLetterAttachment(int hrLetter){
        waitLoadingElement();
        boolean check = false;
        try {
            hold(1000);
            appiumDriver.findElement(AppiumBy.xpath("(//android.widget.Button[contains(@content-desc, 'View HR Letter')]/preceding::android.widget.ImageView[1])["+hrLetter+"]")).isDisplayed();
            check = true;
            return check;
        }catch (Exception ignored){
            return check;
        }
    }

    public void viewIncidentsLog(String fromDate, String toDate, String category){
        hold(1000);
        if(!fromDate.isEmpty()){
            clickOn(fromDate_incidentsLog);
            hold(500);
            datePicker(fromDate);
            waitLoadingElement();
        }
        hold(800);
        if(!toDate.isEmpty()){
            clickOn(toDate_incidentsLog);
            hold(500);
            datePicker(toDate);
            waitLoadingElement();
        }
        hold(800);
        clickOn(category_incidentsLog);
        hold(1000);
        clickOn(AppiumBy.accessibilityId(category));
        hold(1000);
        clickOn(viewBtn);
        hold(1000);
        waitLoadingElement();
        waitLoadingElement();
    }

    public String getIncidentsLogViewed(String date ,String item){

        // Send date like this = 30.12.2024
        // Send item like this = Category

        waitForElementToBeVisible(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Date') and contains(@content-desc, 'Category')]"));
        verticalSwipeByPercentages(70, 20, 50);
        //scrollToElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Date') and contains(@content-desc, 'Category') and contains(@content-desc, '"+date+"')]"), true, 5);
        String input = appiumDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Date') and contains(@content-desc, 'Category') and contains(@content-desc, '"+date+"')]")).getAttribute("content-desc");
        // Split the string into lines
        String[] lines = input.split("\n");
        // Create a map to store key-value pairs
        Map<String, String> keyValueMap = new HashMap<>();
        // Parse the input lines
        for (int i = 1; i < lines.length; i += 2) {
            if (i < lines.length - 1) {
                keyValueMap.put(lines[i], lines[i + 1]);
            }
        }
        // Return the value for the given key, or null if not found
        return keyValueMap.get(item);
    }


}
