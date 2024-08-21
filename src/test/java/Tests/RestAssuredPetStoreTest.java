package Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class RestAssuredPetStoreTest
{
    @Test
    public void testFindPetByStatus() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .queryParam("status", "available")
                        .when()
                        .get("/pet/findByStatus");

        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].status", equalTo("available"));
    }
}
