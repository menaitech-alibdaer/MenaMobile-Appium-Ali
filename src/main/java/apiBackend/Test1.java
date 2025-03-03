package apiBackend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static apiBackend.JsonReader.jsonDataGetter;

public class Test1 {
    public static void main(String[] args) {

        // Input date string
        String dateStr = "2020-01-01 00:00:00.000";

        // Define the input and output date format
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the input string to a LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(dateStr, inputFormatter);

        // Format the LocalDateTime to the desired format
        String formattedDate = dateTime.format(outputFormatter);

        // Output the result
        System.out.println(formattedDate);

//        // Set the base URI
//        RestAssured.baseURI = "https://pay-dev.menaitech.com/payrollapi/api";
//
//        String requestBody = jsonDataGetter("src/test/resources/newEmp.json", "newEmp");
//
//        // Send the POST request
//        Response response = RestAssured
//                .given()
//                .header("Content-Type", "application/json")
//                .body(requestBody)
//                .when()
//                .post("/Employee/save-employee-general-info") // Replace with your endpoint
//                .then()
//                //.statusCode(200) // Assert status code
//                .extract()
//                .response();
//
//        // Print the response
//        System.out.println("Response Status Code: " + response.statusCode());
//        System.out.println("Response Body: " + response.body().asString());

//        ObjectMapper mapper = new ObjectMapper();

//        Map<String, Object> requestBody = new HashMap<>();
//        requestBody.put("title", "foo");
//        requestBody.put("body", "bar");
//        requestBody.put("userId", 1);
//
//        String json = null;
//        try {
//            json = mapper.writeValueAsString(requestBody);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("JSON Request Body: " + json);
//
//        // Send a POST request and store the response
//        Response response = RestAssured
//                .given()
//                .header("Content-Type", "application/json")
//                .body(requestBody)
//                .when()
//                .post("/posts")
//                .then()
//                .statusCode(201) // Assert status code
//                .extract()
//                .response();
//
//        // Print response details
//        System.out.println("Response Status Code: " + response.statusCode());
//        System.out.println("Response Body: " + response.body().asString());
//
//        // Extract specific data from the response
//        int id = response.jsonPath().getInt("id");
//        System.out.println("Newly Created Post ID: " + id);


        //////////////////////////////////////////////////////////////////////////////////////////////


        // Send a GET request and store the response
//        Response responseGet = RestAssured
//                .given()
//                .when()
//                .get("/posts/1")
//                .then()
//                .statusCode(200) // Assert status code
//                .extract()
//                .response();
//
//        // Print response details
//        System.out.println("Response Status Code: " + responseGet.statusCode());
//        System.out.println("Response Body: " + responseGet.body().asString());
//
//        // Extract specific data from the response
//        String title = responseGet.jsonPath().getString("title");
//        System.out.println("Title from API Response: " + title);


    }

    public void token() {
        // Base URI
        RestAssured.baseURI = "https://pay-dev.menaitech.com/payrollapi";

        // Login credentials
        String loginBody = null;
        try {
            loginBody = new String(Files.readAllBytes(Paths.get("src/test/resources/test1.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Send POST request to /auth/login
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(loginBody)
                .post("/auth/login");

        // Extract token from response
        String token = response.jsonPath().getString("token");

        System.out.println("Authentication Token: " + token);
    }

}
