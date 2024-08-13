package webBackend.financialInformation;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;
import static utilities.VersionGetter.versionGetter;

public class Payment extends WebBase {

    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'allownce.php')]")
    WebElement financialPackageTab;
    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'payment_method.php')]")
    WebElement paymentTab;
    @FindBy(xpath = "//div[contains(@onclick, 'other_banks.php')]")
    WebElement otherBankPage;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(xpath = "//span[contains(@id, 'select2-paymeny_method')]")
    WebElement paymentMethodE;
    @FindBy(id = "select2-bank_code-container")
    WebElement bankE;
    @FindBy(name = "bank_code")
    WebElement bankSelect;
    @FindBy(name = "bank_branch")
    WebElement bankBranchSelect;
    @FindBy(id = "select2-bank_branch-container")
    WebElement bankBranchE;
    @FindBy(id = "account_code")
    WebElement accountNumberE;
    @FindBy(id = "iban_number")
    WebElement ibanNumberE;
    @FindBy(name = "bank_commitment")
    WebElement bankCommitmentCheckbox;
    @FindBy(className = "three-dots")
    WebElement accountBeneficiaryE;
    @FindBy(name = "beneficiary_name_eng")
    WebElement beneficiaryNameEnglishE;
    @FindBy(name = "beneficiary_name_a")
    WebElement beneficiaryNameArabicE;
    @FindBy(name = "saveit")
    WebElement accountBeneficiarySave;
    @FindBy(xpath = "//span[contains(@id, 'select2-bank_code1')]")
    WebElement otherBank_Bank;
    @FindBy(id = "select2-bank_branch_1-container")
    WebElement otherBank_BankBranch;
    @FindBy(id = "account_code_1")
    WebElement otherBank_AccountNumber;
    @FindBy(id = "iban_number_1")
    WebElement otherBank_IbanNumber;
    @FindBy(id = "select2-value_type1-container")
    WebElement otherBank_ValueType;
    @FindBy(id = "value_type[1]")
    WebElement valueTypeSelect;
    @FindBy(id = "bank_branch_1")
    WebElement getOtherBank_BankBranchSelect;
    @FindBy(name = "payment_method[1]")
    WebElement paymentMethodSelect;
    @FindBy(id = "amount_transferred_1")
    WebElement otherBank_Value;
    @FindBy(id = "select2-currency_type1-container")
    WebElement otherBank_Currency;
    @FindBy(xpath = "//span[contains(@id, 'select2-payment_method1')]")
    WebElement otherBank_PaymentMethod;
    @FindBy(id = "otherBankFromDate_1")
    WebElement otherBank_FromDate;
    @FindBy(id = "otherBankToDate_1")
    WebElement otherBank_ToDate;
    @FindBy(name = "notes[1]")
    WebElement otherBank_Notes;
    @FindBy(xpath = "//span[contains(@id, 'select2-bank_code2')]")
    WebElement otherBank_Bank2;
    @FindBy(id = "select2-bank_branch_2-container")
    WebElement otherBank_BankBranch2;
    @FindBy(id = "account_code_2")
    WebElement otherBank_AccountNumber2;
    @FindBy(id = "iban_number_2")
    WebElement otherBank_IbanNumber2;
    @FindBy(id = "select2-value_type2-container")
    WebElement otherBank_ValueType2;
    @FindBy(id = "amount_transferred_2")
    WebElement otherBank_Value2;
    @FindBy(id = "select2-currency_type2-container")
    WebElement otherBank_Currency2;
    @FindBy(xpath = "//span[contains(@id, 'select2-payment_method2')]")
    WebElement otherBank_PaymentMethod2;
    @FindBy(id = "otherBankFromDate_2")
    WebElement otherBank_FromDate2;
    @FindBy(id = "otherBankToDate_2")
    WebElement otherBank_ToDate2;
    @FindBy(name = "notes[2]")
    WebElement otherBank_Notes2;
    @FindBy(xpath = "//img[contains(@src, 'currency.jpg')]")
    WebElement convertBtn;
    @FindBy(name = "value")
    WebElement convertValue;
    @FindBy(xpath = "//input[@onclick='convert()']")
    WebElement convertValueBtn;
    @FindBy(xpath = "//li[@class='nav-item']//button[1]")
    WebElement item;
    @FindBy(xpath =  "//ul[contains(@class, 'bg-icon')]//li[@class='nav-item']")
    List<WebElement> items;
    @FindBy(xpath = "//div[@class='textAlign']//label[contains(@style, 'font-size:20px')]")
    WebElement alertText;
    @FindBy(xpath = "//label[contains(text(), 'Alert!')]")
    WebElement alertBox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    WebElement addBtn;
    @FindBy(xpath = "//button[@onclick = \"menu_action('3')\"]")
    WebElement deleteBtn;
    @FindBy(xpath = "//button[contains(@onclick, 'confirm_delete')]")
    WebElement alertButtonOkDelete;
    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(id = "All_popup")
    WebElement popupFrame;
    @FindBy(className = "btn-close")
    WebElement closePopup;
    FinancialData_OCT financialDataOct;

    public void setEmployeeCode(String employeeCode){

        goToFrame(bodyFrame);
        elementWaitAdvanced(By.id("employee_code"));
        hold(300);
        setText(empCode, employeeCode);
        hold(300);
        setText(empCode, Keys.TAB);
        hold(300);
        elementWaitAdvanced(By.xpath("//label[contains(text(),'Active Employee')]"));

        setLog("Set Employee Code: "+employeeCode);

    }

    public void paymentMethod(String paymentMethod, String bank, String bankBranch, String accountNumber, String ibanNumber,
                              String beneficiaryNameEnglish, String beneficiaryNameArabic, boolean bankCommitment, boolean withoutSave){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            clickOn(paymentTab);
            hold(1500);
            elementWaitAdvanced(By.id("select2-bank_code-container"));
            selectOption(paymentMethodE, paymentMethod);
            hold(300);
            if(!bank.isEmpty()){
                selectOption(bankE, bank);
                hold(300);
            }
            if(!bankBranch.isEmpty()){
                selectOption(bankBranchE, bankBranch);
                hold(300);
            }
            if(!accountNumber.isEmpty()){
                accountNumberE.clear();
                hold(200);
                setText(accountNumberE, accountNumber);
                hold(300);
            }
            if(!ibanNumber.isEmpty()){
                ibanNumberE.clear();
                hold(200);
                setText(ibanNumberE, ibanNumber);
                hold(300);
            }
            if(!beneficiaryNameEnglish.isEmpty() || !beneficiaryNameArabic.isEmpty()){
                clickOn(accountBeneficiaryE);
                goToFrame(popupFrame);
                hold(300);
                elementWaitAdvanced(By.name("beneficiary_name_eng"));
                if(!beneficiaryNameEnglish.isEmpty()){
                    beneficiaryNameEnglishE.clear();
                    hold(200);
                    setText(beneficiaryNameEnglishE, beneficiaryNameEnglish);
                    hold(200);
                }
                if(!beneficiaryNameArabic.isEmpty()){
                    beneficiaryNameArabicE.clear();
                    hold(200);
                    setText(beneficiaryNameArabicE, beneficiaryNameArabic);
                    hold(200);
                }
                clickOn(accountBeneficiarySave);
                hold(300);
                clickOn(closePopup);
                getDriver().switchTo().parentFrame();
            }
            if(bankCommitment){
                if(!bankCommitmentCheckbox.isSelected()){
                    clickOn(bankCommitmentCheckbox);
                    hold(300);
                }
            }
            if(!withoutSave){
                clickOn(saveBtn);
                hold(500);
            }

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.paymentMethod(paymentMethod, bank, bankBranch, accountNumber, ibanNumber, bankCommitment, withoutSave);

        }

        setLog("Payment Method: "+paymentMethod
                +" - bank: "+bank
                +" - bank Branch: "+bankBranch
                +" - account Number: "+accountNumber
                +" - iban Number: "+ibanNumber
                +" - beneficiary Name English: "+beneficiaryNameEnglish
                +" - beneficiary Name Arabic: "+beneficiaryNameArabic
                +" - bank Commitment: "+bankCommitment);

    }

    public void openAccountBeneficiary(){

        clickOn(accountBeneficiaryE);
        hold(500);
        goToFrame(popupFrame);
        elementWaitAdvanced(By.name("beneficiary_name_eng"));
        setLog("open Account Beneficiary");

    }

    public void otherBank(String bank, String bankBranch, String accountNumber, String ibanNumber, String valueType,
                          String value, String currency, String paymentMethod, String fromDate, String toDate,String notes, String beneficiaryNameEnglish, String beneficiaryNameArabic,
                          boolean convertCurrency, boolean withoutSave){

        clickOn(paymentTab);
        hold(300);
        elementWaitAdvanced(By.id("account_code"));
        clickOn(otherBankPage);
        hold(300);
        clickOn(addBtn);
        hold(300);
        if(checkElementIfNotAppear(items)){
            selectOption(otherBank_Bank, bank);
            hold(300);
            selectOption(otherBank_BankBranch, bankBranch);
            hold(300);
            otherBank_AccountNumber.clear();
            hold(100);
            setText(otherBank_AccountNumber, accountNumber);
            hold(300);
            otherBank_IbanNumber.clear();
            hold(100);
            setText(otherBank_IbanNumber, ibanNumber);
            hold(300);
            selectOption(otherBank_ValueType, valueType);
            hold(300);
            if(!convertCurrency){
                setText(otherBank_Value, value);
                hold(300);
            }else{
                clickOn(convertBtn);
                hold(300);
                goToFrame(popupFrame);
                elementWaitAdvanced(By.name("value"));
                setText(convertValue, value);
                hold(300);
                clickOn(convertValueBtn);
                hold(500);
                getDriver().switchTo().parentFrame();

            }
            if(!currency.isEmpty()){
                selectOption(otherBank_Currency, currency);
                hold(300);
            }
            if(!paymentMethod.isEmpty()){
                selectOption(otherBank_PaymentMethod, paymentMethod);
                hold(300);
            }
            if(!fromDate.isEmpty()){
                setText(otherBank_FromDate, fromDate);
                hold(300);
            }
            if(!toDate.isEmpty()){
                setText(otherBank_ToDate, toDate);
                hold(300);
            }
            if(!notes.isEmpty()){
                setText(otherBank_Notes, notes);
                hold(300);
            }
        }else{
            selectOption(otherBank_Bank2, bank);
            hold(300);
            selectOption(otherBank_BankBranch2, bankBranch);
            hold(300);
            otherBank_AccountNumber2.clear();
            hold(100);
            setText(otherBank_AccountNumber2, accountNumber);
            hold(300);
            otherBank_IbanNumber2.clear();
            hold(100);
            setText(otherBank_IbanNumber2, ibanNumber);
            hold(300);
            selectOption(otherBank_ValueType2, valueType);
            hold(300);
            setText(otherBank_Value2, value);
            hold(300);
            if(!currency.isEmpty()){
                selectOption(otherBank_Currency2, currency);
                hold(300);
            }
            if(!paymentMethod.isEmpty()){
                selectOption(otherBank_PaymentMethod2, paymentMethod);
                hold(300);
            }
            if(!fromDate.isEmpty()){
                setText(otherBank_FromDate2, fromDate);
                hold(300);
            }
            if(!toDate.isEmpty()){
                setText(otherBank_ToDate2, toDate);
                hold(300);
            }
            if(!notes.isEmpty()){
                setText(otherBank_Notes2, notes);
                hold(300);
            }
        }

        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);

            if(!beneficiaryNameEnglish.isEmpty() || !beneficiaryNameArabic.isEmpty()){
                clickOn(accountBeneficiaryE);
                goToFrame(popupFrame);
                hold(300);
                elementWaitAdvanced(By.name("beneficiary_name_eng"));
                if(!beneficiaryNameEnglish.isEmpty()){
                    beneficiaryNameEnglishE.clear();
                    hold(200);
                    setText(beneficiaryNameEnglishE, beneficiaryNameEnglish);
                    hold(200);
                }
                if(!beneficiaryNameArabic.isEmpty()){
                    beneficiaryNameArabicE.clear();
                    hold(200);
                    setText(beneficiaryNameArabicE, beneficiaryNameArabic);
                    hold(200);
                }
                clickOn(accountBeneficiarySave);
                hold(300);
                clickOn(closePopup);
                getDriver().switchTo().parentFrame();
            }
        }

        setLog("Added other Bank data");

    }

    public void goToOtherBank(){
        clickOn(paymentTab);
        hold(300);
        elementWaitAdvanced(By.id("account_code"));
        clickOn(otherBankPage);
        hold(300);
        setLog("go To Other Bank");
    }

    public void editOtherBank(String bank, String bankBranch, String accountNumber, String ibanNumber, String valueType,
                              String value, String currency, String paymentMethod, String fromDate, String toDate,String notes){

        clickOn(item);
        hold(1500);
        selectOption(otherBank_Bank, bank);
        hold(300);
        selectOption(otherBank_BankBranch, bankBranch);
        hold(300);
        otherBank_AccountNumber.clear();
        hold(100);
        setText(otherBank_AccountNumber, accountNumber);
        hold(300);
        otherBank_IbanNumber.clear();
        hold(100);
        setText(otherBank_IbanNumber, ibanNumber);
        hold(300);
        selectOption(otherBank_ValueType, valueType);
        hold(300);
        otherBank_Value.clear();
        hold(100);
        setText(otherBank_Value, value);
        hold(300);
        selectOption(otherBank_Currency, currency);
        hold(300);
        selectOption(otherBank_PaymentMethod, paymentMethod);
        hold(300);
        otherBank_FromDate.clear();
        hold(100);
        setText(otherBank_FromDate, fromDate);
        hold(300);
        otherBank_ToDate.clear();
        hold(100);
        setText(otherBank_ToDate, toDate);
        hold(300);
        otherBank_Notes.clear();
        hold(200);
        setText(otherBank_Notes, notes);
        hold(300);
        scrollToElement(empCode);
        clickOn(saveBtn);
        hold(500);
        clickOn(item);
        hold(500);

        setLog("edit Other Bank");

    }

}
