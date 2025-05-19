package apiBackend;

import bases.ApiBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static apiBackend.CompanyAndBranch.getBranchId;
import static io.restassured.RestAssured.given;
import static utilities.MssqlConnect.selectQuery;

public class Settings extends ApiBase {

    public void overtimeBudget(boolean maxPercentage, String valuePerDay, String valuePerWeek, String valuePerMonth){

//        int overtimeBudgetId = Integer.parseInt(
//                selectQuery("select Id from OvertimeBudgets where BranchId = "+getBranchId()).trim()
//        );

        // Dynamically create a JSON payload
        Map<String, Object> payload = new HashMap<>();

        payload.put("id", 0);
        payload.put("branchId", getBranchId());

        if(maxPercentage){
            payload.put("maxPercentage", true);
            payload.put("formula", "{BasicSalary}");
            if(!valuePerDay.isEmpty()){
                payload.put("isMaxOvertimePercentagePerDayFAE", true);
                payload.put("maxOvertimePercentagePerDayFAE", valuePerDay);
            }else{
                payload.put("isMaxOvertimePercentagePerDayFAE", false);
                payload.put("maxOvertimePercentagePerDayFAE", "0");
            }
            if(!valuePerWeek.isEmpty()){
                payload.put("isMaxOvertimePercentagePerWeekFAE", true);
                payload.put("maxOvertimePercentagePerWeekFAE", valuePerWeek);
            }else{
                payload.put("isMaxOvertimePercentagePerWeekFAE", false);
                payload.put("maxOvertimePercentagePerWeekFAE", "0");
            }
            if(!valuePerMonth.isEmpty()){
                payload.put("isMaxOvertimePercentagePerMonthFAE", true);
                payload.put("maxOvertimePercentagePerMonthFAE", valuePerMonth);
            }else{
                payload.put("isMaxOvertimePercentagePerMonthFAE", false);
                payload.put("maxOvertimePercentagePerMonthFAE", "0");
            }
        }else{
            payload.put("maxPercentage", false);
            if(!valuePerDay.isEmpty()){
                payload.put("isMaxOvertimeHoursPerDayFAE", true);
                payload.put("maxOvertimeHoursPerDayFAE", valuePerDay);
            }else{
                payload.put("isMaxOvertimeHoursPerDayFAE", false);
                payload.put("maxOvertimeHoursPerDayFAE", "0");
            }
            if(!valuePerWeek.isEmpty()){
                payload.put("isMaxOvertimeHoursPerWeekFAE", true);
                payload.put("maxOvertimeHoursPerWeekFAE", valuePerWeek);
            }else{
                payload.put("isMaxOvertimeHoursPerWeekFAE", false);
                payload.put("maxOvertimeHoursPerWeekFAE", "0");
            }
            if(!valuePerMonth.isEmpty()){
                payload.put("isMaxOvertimeHoursPerMonthFAE", true);
                payload.put("maxOvertimeHoursPerMonthFAE", valuePerMonth);
            }else{
                payload.put("isMaxOvertimeHoursPerMonthFAE", false);
                payload.put("maxOvertimeHoursPerMonthFAE", "0");
            }
        }

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
                    .post("/OvertimeBuilder/UpdateBudget/id") // Replace with your endpoint like that -> /Employee/get-max-employee-code
                    .then()
                    .extract()
                    .response();

//            System.out.println("Response Status Code: " + response.getStatusCode());
//            System.out.println("Response Body: " + response.getBody().asString());

            if(response.statusCode() == 200 || response.statusCode() == 201){
                System.out.println("Overtime Budget Edited successfully - Response Status Code: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
