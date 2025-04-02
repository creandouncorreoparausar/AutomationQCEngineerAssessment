package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserTest extends BaseAPITest {

    @Test
    public void deleteUser() {
        String username = "asmaatask";

        // Sending DELETE request using the username
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("username", username) // Passing the username as a query parameter
                .delete("admin/saveSystemUser");

        // Validating the response
        response.then()
                .statusCode(200) // Assuming success code is 200
                .body("message", equalTo("User deleted successfully"));
    }
}
