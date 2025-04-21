package apiBackend;

import bases.ApiBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static apiBackend.CompanyAndBranch.getBranchId;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.fail;
import static utilities.MssqlConnect.selectQuery;
import static utilities.MssqlConnect.selectQueryAll;

public class AllEmployeeTransactions extends ApiBase {

    public Response getVacationTransactionById(int id){
        RestAssured.baseURI = baseUrlApiGetter();

        Response response = given()
                .pathParam("id", id) // Pass integer as query param
                .when()
                .get("/VacationTransaction/{id}")
                .then()
                .statusCode(200) // Validate response
                .extract()
                .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

        return response;

    }

    public String getVacationTransactionValueByKey(int id, String key){

        return getVacationTransactionById(id).jsonPath().getString(key);

    }

    public static int getVacationId(String employeeCode, int row){
        int employeeId = getIdByEmployeeCode(employeeCode);
        String vacId = selectQueryAll("select id from VacationTransactions where EmployeeId = "+employeeId + " ORDER BY id").get(row)[0];
        int vacationId = 0;
        if(!vacId.isEmpty()){
            vacationId = Integer.parseInt(vacId);
        }else{
            fail("There is no vacation for this employee: "+employeeCode + " by this row: "+row);
        }
        return vacationId;
    }

    public String getVacationFromDate(String employeeCode, int row){
        int employeeId = getIdByEmployeeCode(employeeCode);
        String vacFromDate = selectQueryAll("select FromDate from VacationTransactions where EmployeeId = "+employeeId + " ORDER BY id").get(row)[0];
        try{
            LocalDateTime dateTime = LocalDateTime.parse(vacFromDate);
            return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch (Exception e){
            // Remove the time part (just keep the date)
            return vacFromDate.split(" ")[0].trim();
        }
    }
    public String getVacationToDate(String employeeCode, int row){
        int employeeId = getIdByEmployeeCode(employeeCode);
        String vacToDate = selectQueryAll("select ToDate from VacationTransactions where EmployeeId = "+employeeId + " ORDER BY id").get(row)[0];
        try{
            LocalDateTime dateTime = LocalDateTime.parse(vacToDate);
            return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch (Exception e){
            // Remove the time part (just keep the date)
            return vacToDate.split(" ")[0].trim();
        }
    }
    public String getVacationType(String employeeCode, int row){
        int employeeId = getIdByEmployeeCode(employeeCode);
        String vacationProfileId = selectQueryAll("select VacationProfileId from VacationTransactions where EmployeeId = "+employeeId + " ORDER BY id").get(row)[0];
        return selectQuery("select NameEn from VacationProfiles where Id = '"+vacationProfileId+"' and BranchId = "+getBranchId()).trim();
    }
    public String getVacationPeriod(String employeeCode, int row){
        int employeeId = getIdByEmployeeCode(employeeCode);
        return selectQueryAll("select Period from VacationTransactions where EmployeeId = "+employeeId + " ORDER BY id").get(row)[0].trim();
    }
    public String getVacationAmount(String employeeCode, int row){
        int employeeId = getIdByEmployeeCode(employeeCode);
        return selectQueryAll("select Amount from VacationTransactions where EmployeeId = "+employeeId + " ORDER BY id").get(row)[0].trim();
    }
    public boolean getVacationStatus(String employeeCode, int row){
        boolean status = false;
        int employeeId = getIdByEmployeeCode(employeeCode);
        int vacPosted = Integer.parseInt(selectQueryAll("select Posted from VacationTransactions where EmployeeId = "+employeeId + " ORDER BY id").get(row)[0]);
        if(vacPosted == 1){
            status = true;
        }
        return status;
    }

    public String getVacationFromDate(int vacationId){
        String fromDate = getVacationTransactionById(vacationId).jsonPath().getString("fromDate");
        LocalDateTime dateTime = LocalDateTime.parse(fromDate);
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public String getVacationToDate(int vacationId){
        String toDate = getVacationTransactionById(vacationId).jsonPath().getString("toDate");
        LocalDateTime dateTime = LocalDateTime.parse(toDate);
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public String getVacationType(int vacationId){
        String vacationProfileId = getVacationTransactionById(vacationId).jsonPath().getString("vacationProfileId").trim();
        return selectQuery("select NameEn from VacationProfiles where Id = '"+vacationProfileId+"' and BranchId = "+getBranchId()).trim();
    }
    public String getVacationPeriod(int vacationId){
        return getVacationTransactionById(vacationId).jsonPath().getString("period").trim();
    }
    public String getVacationAmount(int vacationId){
        return getVacationTransactionById(vacationId).jsonPath().getString("amount").trim();
    }
    public String getVacationStatus(int vacationId){
        return getVacationTransactionById(vacationId).jsonPath().getString("posted").trim();
    }

    public void vacation(String employeeCode, String fromDate, String toDate, String vacationType, boolean post){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        int vacationProfileId = Integer.parseInt(selectQuery("select Id from VacationProfiles where NameEn = '"+vacationType+"' and BranchId = "+getBranchId()).trim());

        // Add primary keys dynamically
        payload.put("fromDate", fromDate);
        payload.put("toDate", toDate);
        payload.put("vacationProfileId", vacationProfileId);
        payload.put("branchId", getBranchId());
        payload.put("employeeId", getIdByEmployeeCode(employeeCode));
        payload.put("posted", post);

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
                    .post("/VacationTransaction/Create") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

            if(response.statusCode() == 200){
                System.out.println("Vacation Transaction added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void leave(String employeeCode, String date, String effectiveDate, String leaveType, String hours, boolean post){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        int leaveProfileId = Integer.parseInt(selectQuery("select Id from LeaveProfiles where NameEn = '"+leaveType+"' and BranchId = "+getBranchId()).trim());

        // Add primary keys dynamically
        payload.put("transactionDateTime", date);
        payload.put("effectiveDate", effectiveDate);
        payload.put("profileId", leaveProfileId);
        payload.put("hours", hours);
        payload.put("branchId", getBranchId());
        payload.put("employeeId", getIdByEmployeeCode(employeeCode));
        payload.put("posted", post);

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
                    .post("/LeaveTransaction/SaveTransaction") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

            if(response.statusCode() == 200){
                System.out.println("Leave Transaction added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void overtime(String employeeCode, String date, String effectiveDate, String overtimeType, String hours, boolean post){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        int overtimeProfileId = Integer.parseInt(selectQuery("select Id from OvertimeProfiles where NameEn = '"+overtimeType+"' and BranchId = "+getBranchId()).trim());
        int currencyId = Integer.parseInt(selectQuery("select Id from Currencies where NameEn = 'Jordanian Dinar' and BranchId = "+getBranchId()).trim());

        // Add primary keys dynamically
        payload.put("transactionDateTime", date);
        payload.put("effectiveDate", effectiveDate);
        payload.put("profileId", overtimeProfileId);
        payload.put("hours", hours);
        payload.put("PaymentType", 1);
        //payload.put("currencyId", currencyId);
        payload.put("branchId", getBranchId());
        payload.put("employeeId", getIdByEmployeeCode(employeeCode));
        payload.put("posted", post);

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
                    .post("/OvertimeTransaction/OvertimeTransactionsSave") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

            if(response.statusCode() == 200){
                System.out.println("Overtime Transaction added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loans(String employeeCode, String date, String effectiveDate, String loanType, String amount, String installments, boolean post){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        int loanProfileId = Integer.parseInt(selectQuery("select Id from LoanProfiles where NameEn = '"+loanType+"' and BranchId = "+getBranchId()).trim());
        int currencyId = Integer.parseInt(selectQuery("select Id from Currencies where NameEn = 'Jordanian Dinar' and BranchId = "+getBranchId()).trim());

        // Add primary keys dynamically
        payload.put("transactionDateTime", date);
        payload.put("effectiveDate", effectiveDate);
        payload.put("profileId", loanProfileId);
        payload.put("numberOfInstallment", installments);
        payload.put("currencyId", currencyId);
        payload.put("transactionAmount", amount);
        payload.put("branchId", getBranchId());
        payload.put("employeeId", getIdByEmployeeCode(employeeCode));
        payload.put("posted", post);

//        List<Map<String, Object>> loanCashPayments = new ArrayList<>();
//
//        for(int i = 0; i > Integer.parseInt(installments); i++){
//            Map<String, Object> loanCashPayment = new HashMap<>();
//
//
//        }

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
                    .post("/LoanTransaction/Create") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

            if(response.statusCode() == 200){
                System.out.println("Loan Transaction added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void otherIncome(String employeeCode, String date, boolean exempted, String exemptedAmount, String TransactionType, String amount, boolean post){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        int otherIncomeProfileId = Integer.parseInt(selectQuery("select Id from OtherIncomeProfiles where NameEn = '"+TransactionType+"' and BranchId = "+getBranchId()).trim());

        // Add primary keys dynamically
        payload.put("transactionDateTime", date);
        payload.put("profileId", otherIncomeProfileId);
        payload.put("transactionAmount", amount);
        if(exempted){
            payload.put("isExempted", true);
            payload.put("exemptedAmount", exemptedAmount);
        }
        payload.put("branchId", getBranchId());
        payload.put("employeeId", getIdByEmployeeCode(employeeCode));
        payload.put("posted", post);

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
                    .post("/OtherIncomeTransaction/Create") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

            if(response.statusCode() == 200){
                System.out.println("Other Income Transaction added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void otherDeductions(String employeeCode, String date, String TransactionType, String amount, boolean exempted, String exemptedAmount, boolean post){

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        int deductionProfilesProfileId = Integer.parseInt(selectQuery("select Id from DeductionProfiles where NameEn = '"+TransactionType+"' and BranchId = "+getBranchId()).trim());

        // Add primary keys dynamically
        payload.put("transactionDateTime", date);
        payload.put("profileId", deductionProfilesProfileId);
        payload.put("transactionAmount", amount);
        payload.put("deductionAmount", amount);
        if(exempted){
            payload.put("isExempted", true);
            payload.put("exemptedAmount", exemptedAmount);
        }
        payload.put("branchId", getBranchId());
        payload.put("employeeId", getIdByEmployeeCode(employeeCode));
        payload.put("posted", post);

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
                    .post("/DeductionTransaction/DeductionTransactionsSave") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .statusCode(200) // Assert status code
                    .extract()
                    .response();

            if(response.statusCode() == 200){
                System.out.println("Other Deduction Transaction added successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
