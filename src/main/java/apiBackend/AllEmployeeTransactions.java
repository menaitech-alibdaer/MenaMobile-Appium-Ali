package apiBackend;

import bases.ApiBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

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

}
