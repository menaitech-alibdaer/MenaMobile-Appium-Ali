package webBackend.financialInformation;

import bases.WebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.ExtentReport.setLog;
import static utilities.WebHelper.*;
import static utilities.VersionGetter.versionGetter;

public class TaxAndDeduction extends WebBase {

    @FindBy(id = "body_frame")
    WebElement bodyFrame;
    @FindBy(id = "All_popup")
    WebElement popupFrame;
    @FindBy(id = "employee_code")
    WebElement empCode;
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
    @FindBy(xpath = "//div[@class='col-2']//div[contains(@onclick, 'tax_data.php')]")
    WebElement taxAndDeductionTab;
    @FindBy(xpath = "//div[contains(@onclick, 'endless_deduction_data.php')]")
    WebElement permanentDeductionsPage;
    @FindBy(id = "taxable_flag")
    WebElement taxableCheckbox;
    @FindBy(id = "resident")
    WebElement personalExemptionCheckbox;
    @FindBy(id = "other_help")
    WebElement familyExemptionCheckbox;
    @FindBy(name = "MR_professional_exempt")
    WebElement professionalExemptionCheckbox;
    @FindBy(id = "MR_seniority_eligible")
    WebElement eligibleToSeniorityAllowanceCheckbox;
    @FindBy(name = "expected_tax")
    WebElement expectedTaxE;
    @FindBy(xpath = "//span[contains(@id, 'select2-expected_tax_type')]")
    WebElement taxTypeE;
    @FindBy(id = "housing_loans")
    WebElement otherExemptionsE;
    @FindBy(name = "national_tax")
    WebElement nationalTaxE;
    @FindBy(id = "resident")
    WebElement residentCheckbox;
    @FindBy(id = "is_no_children_exempt")
    WebElement childrenAreNotExemptedCheckbox;
    @FindBy(xpath = "//span[contains(@id, 'select2-parent_help')]")
    WebElement supportedParentsE;
    @FindBy(id = "parent_help_form_date")
    WebElement supportedParentsFromDateE;
    @FindBy(id = "parent_help_to_date")
    WebElement supportedParentsToDateE;
    @FindBy(id = "other_help")
    WebElement otherSupportsE;
    @FindBy(id = "other_help_form_date")
    WebElement otherSupportsFromDateE;
    @FindBy(id = "other_help_to_date")
    WebElement otherSupportsToDateE;
    @FindBy(id = "university_count")
    WebElement universitySupportsE;
    @FindBy(id = "university_count_form_date")
    WebElement universitySupportsFromDateE;
    @FindBy(id = "university_count_to_date")
    WebElement universitySupportsToDateE;
    @FindBy(id = "college_count")
    WebElement collegeSupportsE;
    @FindBy(id = "college_count_form_date")
    WebElement collegeSupportsFromDateE;
    @FindBy(id = "college_count_to_date")
    WebElement collegeSupportsToDateE;
    @FindBy(id = "yearly_renting_house")
    WebElement yearlyHouseRentalE;
    @FindBy(id = "yearly_renting_house_form_date")
    WebElement yearlyHouseFromDateE;
    @FindBy(id = "yearly_renting_house_to_date")
    WebElement yearlyHouseToDateE;
    @FindBy(id = "housing_loans")
    WebElement exemptedLoansE;
    @FindBy(id = "housing_loans_form_date")
    WebElement exemptedLoansFromDateE;
    @FindBy(id = "housing_loans_to_date")
    WebElement exemptedLoansToDateE;
    @FindBy(id = "transportation_all")
    WebElement fixedTransportationE;
    @FindBy(id = "transportation_all_form_date")
    WebElement fixedTransportationFromDateE;
    @FindBy(id = "transportation_all_to_date")
    WebElement fixedTransportationToDateE;
    @FindBy(id = "count_of_children")
    WebElement numberOfChildrenE;
    @FindBy(id = "spouse_exempt_flag")
    WebElement spouseIsExemptedCheckbox;
    @FindBy(id = "lebanon_rep_exempt_flag")
    WebElement submissiveToRepresentativeExemptionCheckbox;
    @FindBy(id = "start_date")
    WebElement startingDateE;
    @FindBy(id = "end_date")
    WebElement toDateE;
    @FindBy(id = "select2-spouse_exempt_flag-container")
    WebElement spouseYearlyExemptionE;
    @FindBy(id = "leb_representative_exemption")
    WebElement representativeExemptionE;
    @FindBy(id = "first_date")
    WebElement representativeExemptionStartingDateE;
    @FindBy(id = "second_date")
    WebElement representativeExemptionToDateE;
    @FindBy(id = "first_date")
    WebElement spouseYearlyExemptionStartingDateE;
    @FindBy(id = "second_date")
    WebElement spouseYearlyExemptionToDateE;
    @FindBy(xpath = "//span[contains(@id, 'select2-spouse_exempt_flag')]")
    WebElement taxExemptionE;
    @FindBy(name = "life_insurance")
    WebElement lifeInsuranceExemptionE;
    @FindBy(name = "fire_insurance")
    WebElement fireInsuranceExemptionE;
    @FindBy(id = "sudanese_age_exemption_flag")
    WebElement notEntitledToAgeExemptionCheckbox;
    @FindBy(id = "alg_HandicappedExemptEligible")
    WebElement handicappedExemptionCheckbox;
    @FindBy(id = "life_insurance")
    WebElement lifeInsuranceCheckbox;
    @FindBy(id = "is_gross_salary_calc")
    WebElement grossSalaryCalculationPackageCheckbox;
    @FindBy(id = "max_life_insurance_exemp_amt")
    WebElement maximumLifeInsuranceExemptionAmountE;
    @FindBy(name = "other_help")
    WebElement familyHeadCheckbox;
    @FindBy(name = "parent_help")
    WebElement supportedParentsCheckbox;
    @FindBy(id = "TN_additionalTaxEligible")
    WebElement eligibleToAdditionalTaxCheckbox;
    @FindBy(name = "MR_family_exempt")
    WebElement familyExemptionCheckbox_MoroccanTax;
    @FindBy(id = "MR_compl_fund_saving")
    WebElement complementarySavingFundE;
    @FindBy(id = "other_help_form_date")
    WebElement fromDateE_mt;
    @FindBy(id = "other_help_to_date")
    WebElement toDateE_mt;
    @FindBy(id = "personal_exempt_flag")
    WebElement personalExemptionCheckbox_IraqTax;
    @FindBy(id = "children_exempt_flag")
    WebElement childrenExemptionCheckbox;
    @FindBy(id = "Extra_Exemptions_flag")
    WebElement extraExemptionsCheckbox;
    @FindBy(name = "Extra_Exemptions")
    WebElement extraExemptionsE;
    @FindBy(xpath = "(//span[contains(@id, 'select2-endless_ded')])[1]")
    WebElement permanentDeductionTypeE1;
    @FindBy(xpath = "(//span[contains(@id, 'select2-endless_ded')])[2]")
    WebElement permanentDeductionTypeE2;
    @FindBy(name = "checkbox[1]")
    WebElement permanentDeductionCheckbox1;
    @FindBy(name = "checkbox[2]")
    WebElement permanentDeductionCheckbox2;
    @FindBy(id = "transaction_date_1")
    WebElement PD_FromDate1;
    @FindBy(id = "final_date_1")
    WebElement PD_ToDate1;
    @FindBy(name = "notes[1]")
    WebElement PD_Note1;
    @FindBy(id = "transaction_date_2")
    WebElement PD_FromDate2;
    @FindBy(id = "final_date_2")
    WebElement PD_ToDate2;
    @FindBy(name = "notes[2]")
    WebElement PD_Note2;
    @FindBy(name = "saveit")
    WebElement saveBtnInPopup;
    @FindBy(className = "btn-close")
    WebElement closePopup;
    @FindBy(xpath = "(//div[contains(@onclick, 'open_window')])[1]")
    WebElement deductionAmountPopupBtn1;
    @FindBy(xpath = "(//div[contains(@onclick, 'open_window')])[2]")
    WebElement deductionAmountPopupBtn2;
    @FindBy(name = "use_origional_amounts")
    WebElement useDeductionOriginalAmountsForEmployeeCheckbox;
    @FindBy(name = "employee_contribution")
    WebElement deductionAmountEmployeeE;
    @FindBy(name = "company_contribution")
    WebElement deductionAmountCompanyE;

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

    public void taxable(boolean taxable, boolean personalExemption){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(personalExemption){
            if(!personalExemptionCheckbox.isSelected()){
                clickOn(personalExemptionCheckbox);
                hold(200);
            }
        }else{
            if(personalExemptionCheckbox.isSelected()){
                clickOn(personalExemptionCheckbox);
                hold(200);
            }
        }
        clickOn(saveBtn);
        hold(500);

        setLog("Jordan Tax"
                +" - taxable: "+taxable);

    }

    public void jordanTax(boolean taxable, boolean personalExemption, boolean familyExemption, String expectedTax, String expectedTaxType,
                          String otherExemptions, String nationalTax, boolean withoutSave){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            clickOn(taxAndDeductionTab);
            hold(300);
            elementWaitAdvanced(By.name("taxable_flag"));
            if(taxable){
                if(!taxableCheckbox.isSelected()){
                    clickOn(taxableCheckbox);
                    hold(200);
                }
            }else{
                if(taxableCheckbox.isSelected()){
                    clickOn(taxableCheckbox);
                    hold(200);
                }
            }
            if(personalExemption){
                if(!personalExemptionCheckbox.isSelected()){
                    clickOn(personalExemptionCheckbox);
                    hold(200);
                }
            }else{
                if(personalExemptionCheckbox.isSelected()){
                    clickOn(personalExemptionCheckbox);
                    hold(200);
                }
            }
            if(familyExemption){
                if(!familyExemptionCheckbox.isSelected()){
                    clickOn(familyExemptionCheckbox);
                    hold(200);
                }
            }else{
                if(familyExemptionCheckbox.isSelected()){
                    clickOn(familyExemptionCheckbox);
                    hold(200);
                }
            }
            if(taxable){
                if(!expectedTax.isEmpty()){
                    expectedTaxE.clear();
                    hold(200);
                    setText(expectedTaxE, expectedTax);
                }
                if(!expectedTaxType.isEmpty()){
                    selectOption(taxTypeE, expectedTaxType);
                }
                if(!nationalTax.isEmpty()){
                    nationalTaxE.clear();
                    hold(200);
                    setText(nationalTaxE, nationalTax);
                }
            }
            if(!otherExemptions.isEmpty()){
                otherExemptionsE.clear();
                hold(200);
                setText(otherExemptionsE, otherExemptions);
            }

            if(!withoutSave){
                clickOn(saveBtn);
                hold(500);
            }

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.jordanTax(taxable, personalExemption, familyExemption, expectedTax,
                    expectedTaxType, otherExemptions, nationalTax, withoutSave);

        }

        setLog("Jordan Tax"
                +" - taxable: "+taxable
                +" - personal Exemption: "+personalExemption
                +" - family Exemption: "+familyExemption
                +" - expected Tax: "+expectedTax
                +" - expected Tax Type: "+expectedTaxType
                +" - other Exemptions: "+otherExemptions
                +" - national Tax: "+nationalTax);

    }

    public void westBankTax(boolean taxable, boolean resident, boolean childrenAreNotExempted, boolean spouseIsExempted,
                            String expectedTax, String expectedTaxType, String supportedParents, String supportedParentsFromDate,
                            String supportedParentsToDate, String otherSupports, String otherSupportsFromDate, String otherSupportsToDate,
                            String universitySupports, String universitySupportsFromDate, String universitySupportsToDate,
                            String collegeSupports, String collegeSupportsFromDate, String collegeSupportsToDate, String yearlyHouseRental,
                            String yearlyHouseRentalFromDate, String yearlyHouseRentalToDate, String exemptedLoans, String exemptedLoansFromDate,
                            String exemptedLoansToDate, String fixedTransportation, String fixedTransportationFromDate, String fixedTransportationToDate,
                            String numberOfChildren, String nationalTax, boolean withoutSave){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(resident){
            if(!residentCheckbox.isSelected()){
                clickOn(residentCheckbox);
                hold(200);
            }
        }else{
            if(residentCheckbox.isSelected()){
                clickOn(residentCheckbox);
                hold(200);
            }
        }
        if(childrenAreNotExempted){
            if(!childrenAreNotExemptedCheckbox.isSelected()){
                clickOn(childrenAreNotExemptedCheckbox);
                hold(200);
            }
        }else{
            if(childrenAreNotExemptedCheckbox.isSelected()){
                clickOn(childrenAreNotExemptedCheckbox);
                hold(200);
            }
        }
        if(spouseIsExempted){
            if(!spouseIsExemptedCheckbox.isSelected()){
                clickOn(spouseIsExemptedCheckbox);
                hold(200);
            }
        }else{
            if(spouseIsExemptedCheckbox.isSelected()){
                clickOn(spouseIsExemptedCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(!supportedParents.isEmpty()){
            selectOption(supportedParentsE, supportedParents);
        }
        if(!supportedParentsFromDate.isEmpty()){
            setText(supportedParentsFromDateE, supportedParentsFromDate);
        }
        if(!supportedParentsToDate.isEmpty()){
            setText(supportedParentsToDateE, supportedParentsToDate);
        }
        if(!otherSupports.isEmpty()){
            otherSupportsE.clear();
            hold(200);
            setText(otherSupportsE, otherSupports);
        }
        if(!otherSupportsFromDate.isEmpty()){
            setText(otherSupportsFromDateE, otherSupportsFromDate);
        }
        if(!otherSupportsToDate.isEmpty()){
            setText(otherSupportsToDateE, otherSupportsToDate);
        }
        if(!universitySupports.isEmpty()){
            universitySupportsE.clear();
            hold(200);
            setText(universitySupportsE, universitySupports);
        }
        if(!universitySupportsFromDate.isEmpty()){
            setText(universitySupportsFromDateE, universitySupportsFromDate);
        }
        if(!universitySupportsToDate.isEmpty()){
            setText(universitySupportsToDateE, universitySupportsToDate);
        }
        if(!collegeSupports.isEmpty()){
            collegeSupportsE.clear();
            hold(200);
            setText(collegeSupportsE, collegeSupports);
        }
        if(!collegeSupportsFromDate.isEmpty()){
            setText(collegeSupportsFromDateE, collegeSupportsFromDate);
        }
        if(!collegeSupportsToDate.isEmpty()){
            setText(collegeSupportsToDateE, collegeSupportsToDate);
        }
        if(!yearlyHouseRental.isEmpty()){
            yearlyHouseRentalE.clear();
            hold(200);
            setText(yearlyHouseRentalE, yearlyHouseRental);
        }
        if(!yearlyHouseRentalFromDate.isEmpty()){
            setText(yearlyHouseFromDateE, yearlyHouseRentalFromDate);
        }
        if(!yearlyHouseRentalToDate.isEmpty()){
            setText(yearlyHouseToDateE, yearlyHouseRentalToDate);
        }
        if(!exemptedLoans.isEmpty()){
            exemptedLoansE.clear();
            hold(200);
            setText(exemptedLoansE, exemptedLoans);
        }
        if(!exemptedLoansFromDate.isEmpty()){
            setText(exemptedLoansFromDateE, exemptedLoansFromDate);
        }
        if(!exemptedLoansToDate.isEmpty()){
            setText(exemptedLoansToDateE, exemptedLoansToDate);
        }
        if(!fixedTransportation.isEmpty()){
            fixedTransportationE.clear();
            hold(200);
            setText(fixedTransportationE, fixedTransportation);
        }
        if(!fixedTransportationFromDate.isEmpty()){
            setText(fixedTransportationFromDateE, fixedTransportationFromDate);
        }
        if(!fixedTransportationToDate.isEmpty()){
            setText(fixedTransportationToDateE, fixedTransportationToDate);
        }
        if(!numberOfChildren.isEmpty()){
            numberOfChildrenE.clear();
            hold(200);
            setText(numberOfChildrenE, numberOfChildren);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }
        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

    }

    public void jerusalemTax(boolean taxable, boolean resident, String expectedTax, String expectedTaxType, String supportedParents, String supportedParentsFromDate,
                            String supportedParentsToDate, String otherSupports, String otherSupportsFromDate, String otherSupportsToDate,
                            String universitySupports, String universitySupportsFromDate, String universitySupportsToDate,
                            String collegeSupports, String collegeSupportsFromDate, String collegeSupportsToDate, String yearlyHouseRental,
                            String yearlyHouseRentalFromDate, String yearlyHouseRentalToDate, String exemptedLoans, String exemptedLoansFromDate,
                            String exemptedLoansToDate, String numberOfChildren, String nationalTax, boolean withoutSave){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(resident){
            if(!residentCheckbox.isSelected()){
                clickOn(residentCheckbox);
                hold(200);
            }
        }else{
            if(residentCheckbox.isSelected()){
                clickOn(residentCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(!supportedParents.isEmpty()){
            selectOption(supportedParentsE, supportedParents);
        }
        if(!supportedParentsFromDate.isEmpty()){
            setText(supportedParentsFromDateE, supportedParentsFromDate);
        }
        if(!supportedParentsToDate.isEmpty()){
            setText(supportedParentsToDateE, supportedParentsToDate);
        }
        if(!otherSupports.isEmpty()){
            otherSupportsE.clear();
            hold(200);
            setText(otherSupportsE, otherSupports);
        }
        if(!otherSupportsFromDate.isEmpty()){
            setText(otherSupportsFromDateE, otherSupportsFromDate);
        }
        if(!otherSupportsToDate.isEmpty()){
            setText(otherSupportsToDateE, otherSupportsToDate);
        }
        if(!universitySupports.isEmpty()){
            universitySupportsE.clear();
            hold(200);
            setText(universitySupportsE, universitySupports);
        }
        if(!universitySupportsFromDate.isEmpty()){
            setText(universitySupportsFromDateE, universitySupportsFromDate);
        }
        if(!universitySupportsToDate.isEmpty()){
            setText(universitySupportsToDateE, universitySupportsToDate);
        }
        if(!collegeSupports.isEmpty()){
            collegeSupportsE.clear();
            hold(200);
            setText(collegeSupportsE, collegeSupports);
        }
        if(!collegeSupportsFromDate.isEmpty()){
            setText(collegeSupportsFromDateE, collegeSupportsFromDate);
        }
        if(!collegeSupportsToDate.isEmpty()){
            setText(collegeSupportsToDateE, collegeSupportsToDate);
        }
        if(!yearlyHouseRental.isEmpty()){
            yearlyHouseRentalE.clear();
            hold(200);
            setText(yearlyHouseRentalE, yearlyHouseRental);
        }
        if(!yearlyHouseRentalFromDate.isEmpty()){
            setText(yearlyHouseFromDateE, yearlyHouseRentalFromDate);
        }
        if(!yearlyHouseRentalToDate.isEmpty()){
            setText(yearlyHouseToDateE, yearlyHouseRentalToDate);
        }
        if(!exemptedLoans.isEmpty()){
            exemptedLoansE.clear();
            hold(200);
            setText(exemptedLoansE, exemptedLoans);
        }
        if(!exemptedLoansFromDate.isEmpty()){
            setText(exemptedLoansFromDateE, exemptedLoansFromDate);
        }
        if(!exemptedLoansToDate.isEmpty()){
            setText(exemptedLoansToDateE, exemptedLoansToDate);
        }
        if(!numberOfChildren.isEmpty()){
            numberOfChildrenE.clear();
            hold(200);
            setText(numberOfChildrenE, numberOfChildren);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }
        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

    }

    public void lebaneseTax(boolean taxable, boolean personalExemption, boolean submissiveToRepresentativeExemption, String expectedTax,
                            String expectedTaxType, String startingDate, String toDate, String spouseYearlyExemption,
                            String spouseYearlyExemptionStartingDate, String spouseYearlyExemptionToDate, String representativeExemption,
                            String nationalTax, boolean withoutSave){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(personalExemption){
            if(!personalExemptionCheckbox.isSelected()){
                clickOn(personalExemptionCheckbox);
                hold(200);
            }
        }else{
            if(personalExemptionCheckbox.isSelected()){
                clickOn(personalExemptionCheckbox);
                hold(200);
            }
        }
        if(submissiveToRepresentativeExemption){
            if(!submissiveToRepresentativeExemptionCheckbox.isSelected()){
                clickOn(submissiveToRepresentativeExemptionCheckbox);
                hold(200);
            }
        }else{
            if(submissiveToRepresentativeExemptionCheckbox.isSelected()){
                clickOn(submissiveToRepresentativeExemptionCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(!startingDate.isEmpty()){
            setText(startingDateE, startingDate);
        }
        if(!toDate.isEmpty()){
            setText(toDateE, toDate);
        }
        if(!spouseYearlyExemption.isEmpty()){
            selectOption(spouseYearlyExemptionE, spouseYearlyExemption);
            hold(300);
        }
        if(!spouseYearlyExemptionStartingDate.isEmpty()){
            setText(spouseYearlyExemptionStartingDateE, spouseYearlyExemptionStartingDate);
        }
        if(!spouseYearlyExemptionToDate.isEmpty()){
            setText(spouseYearlyExemptionToDateE, spouseYearlyExemptionToDate);
        }
        if(!representativeExemption.isEmpty()){
            representativeExemptionE.clear();
            hold(200);
            setText(representativeExemptionE, representativeExemption);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }
        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

    }

    public void libyanTax(boolean taxable, String expectedTax, String expectedTaxType, String nationalTax, String taxExemption,
                          String lifeInsuranceExemption, String fireInsuranceExemption, boolean withoutSave){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }
        if(!taxExemption.isEmpty()){
            selectOption(taxExemptionE, taxExemption);
        }
        if(!lifeInsuranceExemption.isEmpty()){
            lifeInsuranceExemptionE.clear();
            setText(lifeInsuranceExemptionE, lifeInsuranceExemption);
        }
        if(!fireInsuranceExemption.isEmpty()){
            fireInsuranceExemptionE.clear();
            setText(fireInsuranceExemptionE, fireInsuranceExemption);
        }

        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

    }

    public void syrianTax(boolean taxable, boolean personalExemption, String expectedTax, String expectedTaxType, String nationalTax){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(personalExemption){
            if(!personalExemptionCheckbox.isSelected()){
                clickOn(personalExemptionCheckbox);
                hold(200);
            }
        }else{
            if(personalExemptionCheckbox.isSelected()){
                clickOn(personalExemptionCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }

        clickOn(saveBtn);
        hold(500);

    }

    public void sudanTax(boolean taxable, boolean notEntitledToAgeExemption, String expectedTax, String expectedTaxType, String supportedParents, String supportedParentsFromDate,
    String supportedParentsToDate, String otherSupports, String otherSupportsFromDate, String otherSupportsToDate,
    String universitySupports, String universitySupportsFromDate, String universitySupportsToDate,
    String collegeSupports, String collegeSupportsFromDate, String collegeSupportsToDate, String yearlyHouseRental,
    String yearlyHouseRentalFromDate, String yearlyHouseRentalToDate, String exemptedLoans, String exemptedLoansFromDate,
    String exemptedLoansToDate, String numberOfChildren, String nationalTax, boolean withoutSave){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(notEntitledToAgeExemption){
            if(!notEntitledToAgeExemptionCheckbox.isSelected()){
                clickOn(notEntitledToAgeExemptionCheckbox);
                hold(200);
            }
        }else{
            if(notEntitledToAgeExemptionCheckbox.isSelected()){
                clickOn(notEntitledToAgeExemptionCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(!supportedParents.isEmpty()){
            selectOption(supportedParentsE, supportedParents);
        }
        if(!supportedParentsFromDate.isEmpty()){
            setText(supportedParentsFromDateE, supportedParentsFromDate);
        }
        if(!supportedParentsToDate.isEmpty()){
            setText(supportedParentsToDateE, supportedParentsToDate);
        }
        if(!otherSupports.isEmpty()){
            otherSupportsE.clear();
            hold(200);
            setText(otherSupportsE, otherSupports);
        }
        if(!otherSupportsFromDate.isEmpty()){
            setText(otherSupportsFromDateE, otherSupportsFromDate);
        }
        if(!otherSupportsToDate.isEmpty()){
            setText(otherSupportsToDateE, otherSupportsToDate);
        }
        if(!universitySupports.isEmpty()){
            universitySupportsE.clear();
            hold(200);
            setText(universitySupportsE, universitySupports);
        }
        if(!universitySupportsFromDate.isEmpty()){
            setText(universitySupportsFromDateE, universitySupportsFromDate);
        }
        if(!universitySupportsToDate.isEmpty()){
            setText(universitySupportsToDateE, universitySupportsToDate);
        }
        if(!collegeSupports.isEmpty()){
            collegeSupportsE.clear();
            hold(200);
            setText(collegeSupportsE, collegeSupports);
        }
        if(!collegeSupportsFromDate.isEmpty()){
            setText(collegeSupportsFromDateE, collegeSupportsFromDate);
        }
        if(!collegeSupportsToDate.isEmpty()){
            setText(collegeSupportsToDateE, collegeSupportsToDate);
        }
        if(!yearlyHouseRental.isEmpty()){
            yearlyHouseRentalE.clear();
            hold(200);
            setText(yearlyHouseRentalE, yearlyHouseRental);
        }
        if(!yearlyHouseRentalFromDate.isEmpty()){
            setText(yearlyHouseFromDateE, yearlyHouseRentalFromDate);
        }
        if(!yearlyHouseRentalToDate.isEmpty()){
            setText(yearlyHouseToDateE, yearlyHouseRentalToDate);
        }
        if(!exemptedLoans.isEmpty()){
            exemptedLoansE.clear();
            hold(200);
            setText(exemptedLoansE, exemptedLoans);
        }
        if(!exemptedLoansFromDate.isEmpty()){
            setText(exemptedLoansFromDateE, exemptedLoansFromDate);
        }
        if(!exemptedLoansToDate.isEmpty()){
            setText(exemptedLoansToDateE, exemptedLoansToDate);
        }
        if(!numberOfChildren.isEmpty()){
            numberOfChildrenE.clear();
            hold(200);
            setText(numberOfChildrenE, numberOfChildren);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }
        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

    }

    public void algerianTax(boolean taxable, boolean handicappedExemption, String expectedTax, String expectedTaxType, String nationalTax){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(handicappedExemption){
            if(!handicappedExemptionCheckbox.isSelected()){
                clickOn(handicappedExemptionCheckbox);
                hold(200);
            }
        }else{
            if(handicappedExemptionCheckbox.isSelected()){
                clickOn(handicappedExemptionCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }

        clickOn(saveBtn);
        hold(500);

    }

    public void egyptianTax(boolean taxable, boolean resident, boolean lifeInsurance, boolean childrenAreNotExempted, boolean grossSalaryCalculationPackage,
                            boolean spouseIsExempted, String expectedTax, String expectedTaxType, String supportedParents, String supportedParentsFromDate,
                            String supportedParentsToDate, String otherSupports, String otherSupportsFromDate, String otherSupportsToDate,
                            String universitySupports, String universitySupportsFromDate, String universitySupportsToDate,
                            String collegeSupports, String collegeSupportsFromDate, String collegeSupportsToDate, String yearlyHouseRental,
                            String yearlyHouseRentalFromDate, String yearlyHouseRentalToDate, String exemptedLoans, String exemptedLoansFromDate,
                            String exemptedLoansToDate, String numberOfChildren, String maximumLifeInsuranceExemptionAmount, String nationalTax, boolean withoutSave){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(resident){
            if(!residentCheckbox.isSelected()){
                clickOn(residentCheckbox);
                hold(200);
            }
        }else{
            if(residentCheckbox.isSelected()){
                clickOn(residentCheckbox);
                hold(200);
            }
        }
        if(lifeInsurance){
            if(!lifeInsuranceCheckbox.isSelected()){
                clickOn(lifeInsuranceCheckbox);
                hold(200);
            }
        }else{
            if(lifeInsuranceCheckbox.isSelected()){
                clickOn(lifeInsuranceCheckbox);
                hold(200);
            }
        }
        if(childrenAreNotExempted){
            if(!childrenAreNotExemptedCheckbox.isSelected()){
                clickOn(childrenAreNotExemptedCheckbox);
                hold(200);
            }
        }else{
            if(childrenAreNotExemptedCheckbox.isSelected()){
                clickOn(childrenAreNotExemptedCheckbox);
                hold(200);
            }
        }
        if(grossSalaryCalculationPackage){
            if(!grossSalaryCalculationPackageCheckbox.isSelected()){
                clickOn(grossSalaryCalculationPackageCheckbox);
                hold(200);
            }
        }else{
            if(grossSalaryCalculationPackageCheckbox.isSelected()){
                clickOn(grossSalaryCalculationPackageCheckbox);
                hold(200);
            }
        }
        if(spouseIsExempted){
            if(!spouseIsExemptedCheckbox.isSelected()){
                clickOn(spouseIsExemptedCheckbox);
                hold(200);
            }
        }else{
            if(spouseIsExemptedCheckbox.isSelected()){
                clickOn(spouseIsExemptedCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(!supportedParents.isEmpty()){
            selectOption(supportedParentsE, supportedParents);
        }
        if(!supportedParentsFromDate.isEmpty()){
            setText(supportedParentsFromDateE, supportedParentsFromDate);
        }
        if(!supportedParentsToDate.isEmpty()){
            setText(supportedParentsToDateE, supportedParentsToDate);
        }
        if(!otherSupports.isEmpty()){
            otherSupportsE.clear();
            hold(200);
            setText(otherSupportsE, otherSupports);
        }
        if(!otherSupportsFromDate.isEmpty()){
            setText(otherSupportsFromDateE, otherSupportsFromDate);
        }
        if(!otherSupportsToDate.isEmpty()){
            setText(otherSupportsToDateE, otherSupportsToDate);
        }
        if(!universitySupports.isEmpty()){
            universitySupportsE.clear();
            hold(200);
            setText(universitySupportsE, universitySupports);
        }
        if(!universitySupportsFromDate.isEmpty()){
            setText(universitySupportsFromDateE, universitySupportsFromDate);
        }
        if(!universitySupportsToDate.isEmpty()){
            setText(universitySupportsToDateE, universitySupportsToDate);
        }
        if(!collegeSupports.isEmpty()){
            collegeSupportsE.clear();
            hold(200);
            setText(collegeSupportsE, collegeSupports);
        }
        if(!collegeSupportsFromDate.isEmpty()){
            setText(collegeSupportsFromDateE, collegeSupportsFromDate);
        }
        if(!collegeSupportsToDate.isEmpty()){
            setText(collegeSupportsToDateE, collegeSupportsToDate);
        }
        if(!yearlyHouseRental.isEmpty()){
            yearlyHouseRentalE.clear();
            hold(200);
            setText(yearlyHouseRentalE, yearlyHouseRental);
        }
        if(!yearlyHouseRentalFromDate.isEmpty()){
            setText(yearlyHouseFromDateE, yearlyHouseRentalFromDate);
        }
        if(!yearlyHouseRentalToDate.isEmpty()){
            setText(yearlyHouseToDateE, yearlyHouseRentalToDate);
        }
        if(!exemptedLoans.isEmpty()){
            exemptedLoansE.clear();
            hold(200);
            setText(exemptedLoansE, exemptedLoans);
        }
        if(!exemptedLoansFromDate.isEmpty()){
            setText(exemptedLoansFromDateE, exemptedLoansFromDate);
        }
        if(!exemptedLoansToDate.isEmpty()){
            setText(exemptedLoansToDateE, exemptedLoansToDate);
        }
        if(!numberOfChildren.isEmpty()){
            numberOfChildrenE.clear();
            hold(200);
            setText(numberOfChildrenE, numberOfChildren);
        }
        if(!maximumLifeInsuranceExemptionAmount.isEmpty()){
            maximumLifeInsuranceExemptionAmountE.clear();
            hold(200);
            setText(maximumLifeInsuranceExemptionAmountE, maximumLifeInsuranceExemptionAmount);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }
        if(!withoutSave){
            clickOn(saveBtn);
            hold(500);
        }

    }

    public void tunisianTax(boolean taxable, boolean familyHead, boolean supportedParents, boolean eligibleToAdditionalTax,
                            String expectedTax, String expectedTaxType, String lifeInsuranceExemption, String nationalTax){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(familyHead){
            if(!familyHeadCheckbox.isSelected()){
                clickOn(familyHeadCheckbox);
                hold(200);
            }
        }else{
            if(familyHeadCheckbox.isSelected()){
                clickOn(familyHeadCheckbox);
                hold(200);
            }
        }
        if(supportedParents){
            if(!supportedParentsCheckbox.isSelected()){
                clickOn(supportedParentsCheckbox);
                hold(200);
            }
        }else{
            if(supportedParentsCheckbox.isSelected()){
                clickOn(supportedParentsCheckbox);
                hold(200);
            }
        }
        if(eligibleToAdditionalTax){
            if(!eligibleToAdditionalTaxCheckbox.isSelected()){
                clickOn(eligibleToAdditionalTaxCheckbox);
                hold(200);
            }
        }else{
            if(eligibleToAdditionalTaxCheckbox.isSelected()){
                clickOn(eligibleToAdditionalTaxCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(!lifeInsuranceExemption.isEmpty()){
            lifeInsuranceExemptionE.clear();
            hold(200);
            setText(lifeInsuranceExemptionE, lifeInsuranceExemption);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }

        clickOn(saveBtn);
        hold(500);

    }

    public void moroccanTax(boolean taxable, boolean familyExemption, boolean professionalExemption, boolean eligibleToSeniorityAllowance,
                            String expectedTax, String expectedTaxType, String exemptedLoans, String complementarySavingFund,
                            String fromDate, String toDate, String nationalTax){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(familyExemption){
            if(!familyExemptionCheckbox_MoroccanTax.isSelected()){
                clickOn(familyExemptionCheckbox_MoroccanTax);
                hold(200);
            }
        }else{
            if(familyExemptionCheckbox_MoroccanTax.isSelected()){
                clickOn(familyExemptionCheckbox_MoroccanTax);
                hold(200);
            }
        }
        if(professionalExemption){
            if(!professionalExemptionCheckbox.isSelected()){
                clickOn(professionalExemptionCheckbox);
                hold(200);
            }
        }else{
            if(professionalExemptionCheckbox.isSelected()){
                clickOn(professionalExemptionCheckbox);
                hold(200);
            }
        }
        if(eligibleToSeniorityAllowance){
            if(!eligibleToSeniorityAllowanceCheckbox.isSelected()){
                clickOn(eligibleToSeniorityAllowanceCheckbox);
                hold(200);
            }
        }else{
            if(eligibleToSeniorityAllowanceCheckbox.isSelected()){
                clickOn(eligibleToSeniorityAllowanceCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(!exemptedLoans.isEmpty()){
            exemptedLoansE.clear();
            hold(200);
            setText(exemptedLoansE, exemptedLoans);
        }
        if(!complementarySavingFund.isEmpty()){
            complementarySavingFundE.clear();
            hold(200);
            setText(complementarySavingFundE, complementarySavingFund);
        }
        if(!fromDate.isEmpty()){
            setText(fromDateE_mt, fromDate);
        }
        if(!toDate.isEmpty()){
            setText(toDateE_mt, toDate);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }

        clickOn(saveBtn);
        hold(500);

    }

    public void iraqTax(boolean taxable, boolean personalExemption, boolean spouseExemption, boolean childrenExemption,
                        String expectedTax, String expectedTaxType, boolean extraExemptions, String extraExemptionsMonthly,
                        String nationalTax){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(personalExemption){
            if(!personalExemptionCheckbox_IraqTax.isSelected()){
                clickOn(personalExemptionCheckbox_IraqTax);
                hold(200);
            }
        }else{
            if(personalExemptionCheckbox_IraqTax.isSelected()){
                clickOn(personalExemptionCheckbox_IraqTax);
                hold(200);
            }
        }
        if(spouseExemption){
            if(!spouseIsExemptedCheckbox.isSelected()){
                clickOn(spouseIsExemptedCheckbox);
                hold(200);
            }
        }else{
            if(spouseIsExemptedCheckbox.isSelected()){
                clickOn(spouseIsExemptedCheckbox);
                hold(200);
            }
        }
        if(childrenExemption){
            if(!childrenExemptionCheckbox.isSelected()){
                clickOn(childrenExemptionCheckbox);
                hold(200);
            }
        }else{
            if(childrenExemptionCheckbox.isSelected()){
                clickOn(childrenExemptionCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(extraExemptions){
            if(!extraExemptionsCheckbox.isSelected()){
                clickOn(extraExemptionsCheckbox);
                hold(200);
            }
        }else{
            if(extraExemptionsCheckbox.isSelected()){
                clickOn(extraExemptionsCheckbox);
                hold(200);
            }
        }
        if(!extraExemptionsMonthly.isEmpty()){
            extraExemptionsE.clear();
            hold(200);
            setText(extraExemptionsE, extraExemptionsMonthly);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }

        clickOn(saveBtn);
        hold(500);

    }

    public void yemeniTax(boolean taxable, boolean personalExemption, String expectedTax, String expectedTaxType, String nationalTax){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        if(taxable){
            if(!taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }else{
            if(taxableCheckbox.isSelected()){
                clickOn(taxableCheckbox);
                hold(200);
            }
        }
        if(personalExemption){
            if(!personalExemptionCheckbox.isSelected()){
                clickOn(personalExemptionCheckbox);
                hold(200);
            }
        }else{
            if(personalExemptionCheckbox.isSelected()){
                clickOn(personalExemptionCheckbox);
                hold(200);
            }
        }
        if(!expectedTax.isEmpty()){
            expectedTaxE.clear();
            hold(200);
            setText(expectedTaxE, expectedTax);
        }
        if(!expectedTaxType.isEmpty()){
            selectOption(taxTypeE, expectedTaxType);
        }
        if(!nationalTax.isEmpty()){
            nationalTaxE.clear();
            hold(200);
            setText(nationalTaxE, nationalTax);
        }

        clickOn(saveBtn);
        hold(500);

    }

    public void permanentDeductions(String type1, String fromDate1, String toDate1, String notes1, boolean useDeductionOriginalAmountsForEmployee1,
                                    String deductionAmountEmployee1, String deductionAmountCompany1, String type2, String fromDate2, String toDate2,
                                    String notes2, boolean useDeductionOriginalAmountsForEmployee2, String deductionAmountEmployee2,
                                    String deductionAmountCompany2, boolean deleteAfterAdd){

        clickOn(taxAndDeductionTab);
        hold(300);
        elementWaitAdvanced(By.name("taxable_flag"));
        clickOn(permanentDeductionsPage);
        hold(300);
        elementWaitAdvanced(By.xpath("//button[contains(text(),'Add')]"));
        clickOn(addBtn);
        hold(300);
        elementWaitAdvanced(By.id("transaction_date_1"));
        if(!type1.isEmpty()){
            selectOption(permanentDeductionTypeE1, type1);
        }
        if(!fromDate1.isEmpty()){
            PD_FromDate1.clear();
            hold(200);
            setText(PD_FromDate1, fromDate1);
        }
        if(!toDate1.isEmpty()){
            PD_ToDate1.clear();
            hold(200);
            setText(PD_ToDate1, toDate1);
        }
        if(!notes1.isEmpty()){
            PD_Note1.clear();
            hold(200);
            setText(PD_Note1, notes1);
        }
        hold(300);
        clickOn(saveBtn);
        hold(500);
        elementWaitAdvanced(By.xpath("(//div[contains(@onclick, 'open_window')])[1]"));
        clickOn(deductionAmountPopupBtn1);
        hold(300);
        goToFrame(popupFrame);
        hold(300);
        elementWaitAdvanced(By.name("use_origional_amounts"));
        if(useDeductionOriginalAmountsForEmployee1){
            if(!useDeductionOriginalAmountsForEmployeeCheckbox.isSelected()){
                clickOn(useDeductionOriginalAmountsForEmployeeCheckbox);
                hold(200);
            }
        }else{
            if(useDeductionOriginalAmountsForEmployeeCheckbox.isSelected()){
                clickOn(useDeductionOriginalAmountsForEmployeeCheckbox);
                hold(200);
            }
            if(!deductionAmountEmployee1.isEmpty()){
                deductionAmountEmployeeE.clear();
                hold(200);
                setText(deductionAmountEmployeeE, deductionAmountEmployee1);
            }
            if(!deductionAmountCompany1.isEmpty()){
                deductionAmountCompanyE.clear();
                hold(200);
                setText(deductionAmountCompanyE, deductionAmountCompany1);
            }
        }
        hold(300);
        clickOn(saveBtnInPopup);
        hold(1500);
        clickOn(closePopup);
        driver.switchTo().parentFrame();
        hold(500);

        if(!type2.isEmpty()){
            clickOn(addBtn);
            hold(300);
            elementWaitAdvanced(By.id("transaction_date_2"));
            selectOption(permanentDeductionTypeE2, type2);
            if(!fromDate2.isEmpty()){
                PD_FromDate2.clear();
                hold(200);
                setText(PD_FromDate2, fromDate2);
            }
            if(!toDate2.isEmpty()){
                PD_ToDate2.clear();
                hold(200);
                setText(PD_ToDate2, toDate2);
            }
            if(!notes2.isEmpty()){
                PD_Note2.clear();
                hold(200);
                setText(PD_Note2, notes2);
            }
            hold(300);
            clickOn(saveBtn);
            hold(500);
            elementWaitAdvanced(By.xpath("(//div[contains(@onclick, 'open_window')])[2]"));
            clickOn(deductionAmountPopupBtn2);
            hold(300);
            goToFrame(popupFrame);
            hold(300);
            elementWaitAdvanced(By.name("use_origional_amounts"));
            if(useDeductionOriginalAmountsForEmployee2){
                if(!useDeductionOriginalAmountsForEmployeeCheckbox.isSelected()){
                    clickOn(useDeductionOriginalAmountsForEmployeeCheckbox);
                    hold(200);
                }
            }else{
                if(useDeductionOriginalAmountsForEmployeeCheckbox.isSelected()){
                    clickOn(useDeductionOriginalAmountsForEmployeeCheckbox);
                    hold(200);
                }
                if(!deductionAmountEmployee2.isEmpty()){
                    deductionAmountEmployeeE.clear();
                    hold(200);
                    setText(deductionAmountEmployeeE, deductionAmountEmployee2);
                }
                if(!deductionAmountCompany2.isEmpty()){
                    deductionAmountCompanyE.clear();
                    hold(200);
                    setText(deductionAmountCompanyE, deductionAmountCompany2);
                }
            }
            hold(300);
            clickOn(saveBtnInPopup);
            hold(1500);
            clickOn(closePopup);
            driver.switchTo().parentFrame();
            hold(500);
        }

        if(deleteAfterAdd){
            if(!type1.isEmpty()){
                clickOn(permanentDeductionCheckbox1);
            }
            if(!type2.isEmpty()){
                clickOn(permanentDeductionCheckbox2);
            }
            hold(200);
            clickOn(deleteBtn);
            hold(500);
            clickOn(alertButtonOkDelete);
            hold(500);
        }

        setLog("Added Permanent Deductions");

    }

    public void permanentDeductions(String type, String fromDate, String toDate, String notes){

        if(!versionGetter().equalsIgnoreCase("OCT")){

            clickOn(taxAndDeductionTab);
            hold(300);
            elementWaitAdvanced(By.name("taxable_flag"));
            clickOn(permanentDeductionsPage);
            hold(300);
            elementWaitAdvanced(By.xpath("//button[contains(text(),'Add')]"));
            clickOn(addBtn);
            hold(300);
            elementWaitAdvanced(By.id("transaction_date_1"));
            if(!type.isEmpty()){
                selectOption(permanentDeductionTypeE1, type);
            }
            if(!fromDate.isEmpty()){
                PD_FromDate1.clear();
                hold(200);
                setText(PD_FromDate1, fromDate);
            }
            if(!toDate.isEmpty()){
                PD_ToDate1.clear();
                hold(200);
                setText(PD_ToDate1, toDate);
            }
            if(!notes.isEmpty()){
                PD_Note1.clear();
                hold(200);
                setText(PD_Note1, notes);
            }
            hold(300);
            clickOn(saveBtn);
            hold(500);

        }else {

            financialDataOct = new FinancialData_OCT();
            financialDataOct.permanentDeductions(type, fromDate, toDate, notes);

        }

        setLog("Permanent Deductions"
                +" - type: "+type
                +" - From Date: "+fromDate
                +" - To Date: "+toDate
                +" - notes: "+notes);

    }

    public void openPermanentDeductionPopup(String firstOrSecond){
        if(firstOrSecond.equalsIgnoreCase("First")){
            clickOn(deductionAmountPopupBtn1);
            hold(300);
            goToFrame(popupFrame);
            hold(300);
            elementWaitAdvanced(By.name("use_origional_amounts"));
        } else if (firstOrSecond.equalsIgnoreCase("Second")) {
            clickOn(deductionAmountPopupBtn2);
            hold(300);
            goToFrame(popupFrame);
            hold(300);
            elementWaitAdvanced(By.name("use_origional_amounts"));
        }
    }

}
