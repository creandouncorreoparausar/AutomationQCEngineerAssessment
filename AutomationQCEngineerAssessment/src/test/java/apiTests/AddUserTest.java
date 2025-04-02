package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;

public class AddUserTest extends BaseAPITest {

    @Test
    public void addUser() {
        String requestBody = "{\n" +
                "  \"userRole\": \"Admin\",\n" +
                "  \"employeeName\": \"Ranga Akunuri\",\n" +
                "  \"status\": \"Enabled\",\n" +
                "  \"username\": \"asmaatask\",\n" +
                "  \"password\": \"asmaa123\",\n" +
                "  \"confirmPassword\": \"asmaa123\"\n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("admin/saveSystemUser");

        response.then()
                .statusCode(201) // Assuming success code is 201
                .body("message", equalTo("User added successfully"));
    }
}
