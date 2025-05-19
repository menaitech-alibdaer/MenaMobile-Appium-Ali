package bases;

import apiBackend.CompanyAndBranch;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static apiBackend.CompanyAndBranch.getBranchId;
import static apiBackend.CompanyAndBranch.getCompanyId;
import static io.restassured.RestAssured.given;
import static utilities.MssqlConnect.selectQuery;

public class ApiBase {

    private static final String baseUrl = "https://pay-dev.menaitech.com/payrollapi/api";

    protected static String employeeCode;
    protected static String firstName;
    protected static String secondName;
    protected static String thirdName;
    protected static String lastName;
    protected static int employeeId = 0;
    protected static int insuranceId = 0;

    protected static RequestSpecification spec;
    static CompanyAndBranch companyAndBranch;
    private static String token;

    public static String baseUrlApiGetter(){
        return baseUrl;
    }

    public static String employeeCodeGenerator(){
        return RandomStringUtils.random(4, true, false).toLowerCase() + RandomStringUtils.random(5, false, true);
    }

    public static void employeeCodeSetter(String empCode){
        employeeCode = empCode;
    }

    public static String employeeCodeGetter(){
        return employeeCode;
    }

    public static int getIdByEmployeeCode(String employeeCode){
        return Integer.parseInt(selectQuery("select EmployeeId from EmployeeGeneralInfo where EmployeeCode = '"+employeeCode+"'").trim());
    }

    public static void employeeIdSetter(String empCode){
        employeeId = Integer.parseInt(selectQuery("select EmployeeId from EmployeeGeneralInfo where EmployeeCode = '"+empCode+"' and BranchId = "+getBranchId()).trim());
    }

    public static int employeeIdGetter(){
        return employeeId;
    }

    public static void employeeInsuranceIdSetter(int employeeId){
        insuranceId = Integer.parseInt(selectQuery("select InsuranceId from EmployeeFinancialInsurances where employeeId = '"+employeeId+"'").trim());
    }

    public static int employeeInsuranceIdGetter(){
        return insuranceId;
    }

    public static void setFirstName(String name){
        firstName = name;
    }
    public static void setSecondName(String name){
        secondName = name;
    }
    public static void setThirdName(String name){
        thirdName = name;
    }
    public static void setLastName(String name){
        lastName = name;
    }
    public static String getFirstName(){
        return firstName;
    }
    public static String getSecondName(){
        return secondName;
    }
    public static String getThirdName(){
        return thirdName;
    }
    public static String getLastName(){
        return lastName;
    }

    public static String formatToThreeFractionDigits(String numberStr) {
        double number = Double.parseDouble(numberStr);
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        return decimalFormat.format(number);
    }

    //////////////// TOKEN ////////////////

    public static RequestSpecification SpecBuilder(){
        return spec = new RequestSpecBuilder()
                .setBaseUri(baseUrlApiGetter())
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + tokenGetter())
                .build();
    }

    public static void fastTokenCreator() {
        // Create the login payload
        Map<String, Object> loginPayload = new HashMap<>();
        loginPayload.put("userLogin", "sa");
        loginPayload.put("password", "sa");
        loginPayload.put("companyId", 10);
        loginPayload.put("companyCode", "automobile");
        loginPayload.put("branchId", 646);
        loginPayload.put("branchCode", "auto_mob1");
        loginPayload.put("reCAPTCHAResponse", "");

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        // Send the login request
        Response response = given()
                .baseUri(baseUrlApiGetter()) // or just set it globally
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/User/Login");

        // Extract token from the response
        token = response.jsonPath().getString("token.userToken");
    }

    public static String tokenCreator(String username, String password, String companyCode, String branchCode) {

        companyAndBranch = new CompanyAndBranch();
        companyAndBranch.setCompanyId("automobile");
        companyAndBranch.setBranchId("auto_mob1");

        // Create the login payload
        Map<String, Object> loginPayload = new HashMap<>();
        loginPayload.put("userLogin", username);
        loginPayload.put("password", password);
        loginPayload.put("companyId", getCompanyId());
        loginPayload.put("companyCode", companyCode);
        loginPayload.put("branchId", getBranchId());
        loginPayload.put("branchCode", branchCode);
        loginPayload.put("reCAPTCHAResponse", "");

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        // Send the login request
        Response response = given()
                .baseUri(baseUrlApiGetter()) // or just set it globally
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/User/Login");

        // Extract token from the response
        return response.jsonPath().getString("token.userToken");
    }

    public static String tokenGetter(){
        return token;
    }

}
