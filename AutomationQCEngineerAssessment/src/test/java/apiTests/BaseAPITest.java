package apiTests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseAPITest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com/web/index.php/";
    }
}
