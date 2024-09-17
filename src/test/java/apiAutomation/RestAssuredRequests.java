package apiAutomation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredRequests {

    private static String requestBody =
            """
            {
              "name": "Peter",
              "job": "Engineer"
            }
            """;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void postRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .extract().response();

        //  Assertions
        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("Peter", response.jsonPath().getString("name"));
        Assertions.assertEquals("Engineer", response.jsonPath().getString("job"));
        Assertions.assertFalse(response.jsonPath().getString("id").isEmpty());

        //  For debugging purposes
        System.out.println(response.getStatusCode());
        System.out.println(requestBody);
        System.out.println(response.getBody().asString());
    }
}
