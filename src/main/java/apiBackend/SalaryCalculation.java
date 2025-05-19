package apiBackend;

import bases.ApiBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.*;

import static apiBackend.CompanyAndBranch.getBranchId;
import static io.restassured.RestAssured.given;
import static utilities.MssqlConnect.selectQuery;
import static utilities.MssqlConnect.sqlQuery;

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
    String TransportationAllowance = null;

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

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
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

            if(releaseToMenaME){

                int empId = getIdByEmployeeCode(employeeCode);
                List<Integer> requestBody = Collections.singletonList(empId);

                int yearInt = Integer.parseInt(year);
                int monthInt = Integer.parseInt(month);

                Response responsePosted = given()
                        //.contentType(ContentType.JSON)
                        .spec(SpecBuilder())
                        .queryParam("year", yearInt)
                        .queryParam("month", monthInt)
                        .queryParam("actionType", 1)
                        .queryParam("isExtraSalary", false)
                        .body(requestBody) // Sending an array in body
                        .when()
                        .post("/SalaryCalculation/UpdateSalaryCalculation")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

                System.out.println("Response Status Code: " + responsePosted.getStatusCode());
                System.out.println("Response Body: " + responsePosted.getBody().asString());

                    if(responsePosted.statusCode() == 200 || responsePosted.statusCode() == 201){
                        System.out.println("Successfully Salary Posted - Response Status Code: " + responsePosted.statusCode());
                    }

                    Response responseReleased = given()
                            //.contentType(ContentType.JSON)
                            .spec(SpecBuilder())
                            .queryParam("year", yearInt) // Example query parameters
                            .queryParam("month", monthInt)
                            .queryParam("actionType", 8)
                            .queryParam("isExtraSalary", false)
                            .body(requestBody) // Sending an array in body
                            .when()
                            .post("/SalaryCalculation/UpdateSalaryCalculationRelease")
                            .then()
                            .statusCode(200)
                            .extract()
                            .response();

                    if(responseReleased.statusCode() == 200 || responseReleased.statusCode() == 201){
                        System.out.println("Successfully Salary Released - Response Status Code: " + responseReleased.statusCode());
                    }

//                    int empId = getIdByEmployeeCode(employeeCode);
//                    sqlQuery("update SalaryCalculations set IsRelease = 1 where EmployeeId = "+empId+" and Year = '"+year+"' and Month = '"+month+"'");
//                    System.out.println("Salary Released Successfully");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getSalarySlip(String employeeCode, int year, int month){

        RestAssured.baseURI = baseUrlApiGetter();

        Response response = given()
                .spec(SpecBuilder())
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
        }catch (Exception ignored){}try{
            TransportationAllowance = response.jsonPath().get("allowanceDetails.find { it.typeEn == 'Transportation Allowance' }.transactionAmount").toString();
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
    public String TransportationAllowanceMonth(){
        return formatToThreeFractionDigits(TransportationAllowance.trim());
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

    public void taxable(boolean taxable, String taxProfile, boolean personalExemption, boolean familyExemption){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        // Add primary keys dynamically
        payload.put("EmployeeId", employeeIdGetter());
        payload.put("taxable", taxable);
        int taxId = Integer.parseInt(selectQuery("select Id from TaxProfiles where NameEn = '"+taxProfile+"' and BranchId = "+getBranchId()).trim());
        payload.put("taxProgramId", taxId);
        payload.put("personalExemption", personalExemption);
        payload.put("familyExemption", familyExemption);

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        try {
            // Convert the map to a JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(payload);

            Response response = given()
                    //.header("Content-Type", "application/json")
                    .spec(SpecBuilder())
                    .body(jsonPayload)
                    .when()
                    .post("/Employee/save-employee-tax-info") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Tax added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
