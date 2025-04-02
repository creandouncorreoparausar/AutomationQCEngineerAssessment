package Steps;

import com.orangehrm.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseSteps {
    protected static WebDriver driver;
    protected static LoginPage loginPage;
    public Properties props = new Properties();

    @Before
    public void setUp() throws IOException {

        class DriverManager {
            private static WebDriver driver;

            public static WebDriver getDriver() {
                if (driver == null) {
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
                return driver;
            }
        }

        File file = new File("src/main/java/com/orangehrm/properties/config/config.properties");
        FileInputStream fis = new FileInputStream(file);
        props.load(fis);

        driver = DriverManager.getDriver();

        //driver = new ChromeDriver();
        driver.get(props.getProperty("url"));
        driver.manage().window().maximize();
        //loginPage = new LoginPage(driver);

        if (loginPage == null) {
            loginPage = new LoginPage(driver); // Initialize loginPage if not already done
            System.out.println("loginPage initialized.");
        } else {
            System.out.println("loginPage already initialized.");
        }

}
    @After
    public void tearDown(){

        driver.quit();
        }

    }



