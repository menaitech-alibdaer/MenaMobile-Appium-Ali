package apiBackend;

import bases.ApiBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static apiBackend.CompanyAndBranch.getBranchId;
import static io.restassured.RestAssured.given;

public class SalaryCalculation extends ApiBase {

    String BasicSalary = null;
    String WorthSalary = null;
    String Allowances = null;
    String OtherIncomes = null;
    String Overtime = null;
    String VacationCompensation = null;
    String TotalIncome = null;
    String AccumulativeBalance = null;
    String OtherDeduction = null;
    String SocialSecurity = null;
    String Loan = null;
    String HealthInsurance = null;
    String Tax = null;
    String NationalContribution = null;
    String TotalDeductions = null;
    String NetSalary = null;
    String DaysPaid = null;
    String FixedAllowance = null;
    String PercentAllowance = null;

    public void salaryCalculation(String employeeCode, String year, String month, boolean releaseToMenaME){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        List<Integer> empIds = Arrays.asList(getIdByEmployeeCode(employeeCode));

        // Add primary keys dynamically
        payload.put("empIds", empIds);
        payload.put("year", year);
        payload.put("month", month);
        payload.put("branchId", getBranchId());
        payload.put("isTerminationSalary", false);
        if(releaseToMenaME){
            payload.put("isRelease", true);
        }

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    .header("Content-Type", "application/json")
                    .body(jsonPayload)
                    .when()
                    .post("/SalaryCalculation/CalculateSalary") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200){
                System.out.println("Successfully Salary Calculation - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getSalarySlip(String employeeCode, int year, int month){

        RestAssured.baseURI = baseUrlApiGetter();

        Response response = given()
                .queryParam("employeeId", getIdByEmployeeCode(employeeCode)) // Pass integer as query param
                .queryParam("month", month)
                .queryParam("year", year)
                .queryParam("isTerminationSalary", false)
                .when()
                .get("/SalaryCalculation/GetByEmployeeId")
                .then()
                .statusCode(200) // Validate response
                .extract()
                .response();

        BasicSalary = response.jsonPath().get("basicSalary").toString();
        WorthSalary = response.jsonPath().get("worthSalary").toString();
        Allowances = response.jsonPath().get("totalAllowances").toString();
        OtherIncomes = response.jsonPath().get("totalOtherIncomes").toString();
        Overtime = response.jsonPath().get("totalOvertimes").toString();
        VacationCompensation = response.jsonPath().get("totalVacationCompensations").toString();
        TotalIncome = response.jsonPath().get("totalNetIncome").toString();
        TotalDeductions = response.jsonPath().get("totalNetDeduction").toString();
        AccumulativeBalance = response.jsonPath().get("accumulativeBalance").toString();
        OtherDeduction = response.jsonPath().get("totalDeductions").toString();
        SocialSecurity = response.jsonPath().get("totalSocialSecurities").toString();
        Loan = response.jsonPath().get("totalLoans").toString();
        HealthInsurance = response.jsonPath().get("totalHealthInsurances").toString();
        Tax = response.jsonPath().get("taxAmount").toString();
        NationalContribution = response.jsonPath().get("nationalContributionAmount").toString();
        NetSalary = response.jsonPath().get("netSalaryAmount").toString();
        DaysPaid = response.jsonPath().get("actualWorkingDays").toString();
        try{
            FixedAllowance = response.jsonPath().get("allowanceDetails.find { it.typeEn == 'Fixed Allowance' }.transactionAmount").toString();
        }catch (Exception ignored){}
        try{
            PercentAllowance = response.jsonPath().get("allowanceDetails.find { it.typeEn == 'Percent Allowance' }.transactionAmount").toString();
        }catch (Exception ignored){}

    }

    public String basicSalary(){
        return formatToThreeFractionDigits(BasicSalary.trim());
    }
    public String daysPaid(){
        return formatToThreeFractionDigits(DaysPaid.trim());
    }
    public String worthSalaryMonth(){
        return formatToThreeFractionDigits(WorthSalary.trim());
    }
    public String fixedAllowanceMonth(){
        return formatToThreeFractionDigits(FixedAllowance.trim());
    }
    public String totalIncomeMonth(){
        return formatToThreeFractionDigits(TotalIncome.trim());
    }
    public String netSalaryMonth(){
        return formatToThreeFractionDigits(NetSalary.trim());
    }
    public String monthlyLoans(){
        return formatToThreeFractionDigits(Loan.trim());
    }
    public String accumulatedBalanceNextMonth(){
        return formatToThreeFractionDigits(AccumulativeBalance.trim());
    }
    public String overtimeMonth(){
        return formatToThreeFractionDigits(Overtime.trim());
    }
    public String percentAllowanceMonth(){
        return formatToThreeFractionDigits(PercentAllowance.trim());
    }
    public String allowances(){
        return formatToThreeFractionDigits(Allowances.trim());
    }
    public String otherDeductionsMonth(){
        return formatToThreeFractionDigits(OtherDeduction.trim());
    }
    public String otherIncomeMonth(){
        return formatToThreeFractionDigits(OtherIncomes.trim());
    }
    public String socialSecurityMonth(){
        return formatToThreeFractionDigits(SocialSecurity.trim());
    }
    public String healthInsuranceMonth(){
        return formatToThreeFractionDigits(HealthInsurance.trim());
    }
    public String totalDeductionsMonth(){
        return formatToThreeFractionDigits(TotalDeductions.trim());
    }
    public String tax(){
        return formatToThreeFractionDigits(Tax.trim());
    }
    public String nationalContribution(){
        return formatToThreeFractionDigits(NationalContribution.trim());
    }
    public String vacationCompensation(){
        return formatToThreeFractionDigits(VacationCompensation.trim());
    }

}
