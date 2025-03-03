package apiBackend;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static apiBackend.JsonReader.jsonDataGetter;
import static bases.ApiBase.baseUrlApiGetter;

public class ByJsonFile {

    public static void postRequest(String jsonFile, String key, String endpoint){

        // Set the base URI
        RestAssured.baseURI = baseUrlApiGetter();

        String requestBody = jsonDataGetter(jsonFile, key);

        // Send the POST request
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(endpoint) // Replace with your endpoint like that -> /Employee/get-max-employee-code
                .then()
                .statusCode(200) // Assert status code
                .extract()
                .response();

        // Print the response
        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body().asString());

    }

}
