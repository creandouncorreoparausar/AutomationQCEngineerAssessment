package Steps;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import java.io.IOException;
import static org.testng.Assert.assertTrue;


public class Steps extends BaseSteps {
    DashboardPage dashboardPage;
    private AdminPage adminPage;
    private LoginPage loginPage;



    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws IOException {
        System.out.println("Executing setUp before steps...");

        if (driver == null) { System.out.println("Driver is null! Initializing now...");
            setUp();
        } else {
            System.out.println("Driver is already initialized.");
            }
    }


        @When("I enter username and password and I click Login Button")
    public void i_enter_username_and_password_and_i_click_login_button() {
        loginPage = new LoginPage(driver);
        loginPage.addUsername("Admin");
        loginPage.addPassword("admin123");
        dashboardPage = loginPage.clickLoginButton();

    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        assertTrue(dashboardPage.checkDashboardIcon());
    }
    
    @And("I handle the alert popup")
    public void i_handle_the_alert_popup() {
        try {
            // Check if an alert is present
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert found: " + alert.getText()); // Optionally print the alert text
            alert.accept(); // Click "OK" on the alert
            System.out.println("Alert handled successfully.");
        } catch (NoAlertPresentException e) {
            // Handle case where no alert is present
            System.out.println("No alert is present at this time.");
        } catch (Exception ex) {
            // Handle other unexpected exceptions
            System.out.println("An error occurred while handling the alert: " + ex.getMessage());
        }
    }

    @When("I click on the Admin tab on the left side menu")
    public AdminPage i_click_on_the_admin_tab_on_the_left_side_menu() {
        adminPage = dashboardPage.clickOnAdminTab();
        return adminPage;

    }

    @Then("I should see the number of records displayed")
    public void i_should_see_the_number_of_records_displayed() {
        adminPage.getNumberOfRecordsFound();
        System.out.println("number of records displayed");
    }

    @When("I click the Add button")
    public void iClickTheAddButton() {
        adminPage.isAddUserVisible();
        adminPage.clickOnAddButton();
    }

    @And("I fill in the required data")
    public void iFillInTheRequiredData() {
        adminPage.addRequiredDataAndSave();
    }

    @Then("the number of records should increase by one")
    public void theNumberOfRecordsShouldIncreaseByOne() {
        adminPage.isNumberOfRecordsIncreasedByOne();
    }

    @When
            ("I search for the username of the new user and I find them")
    public void iSearchForTheUsernameOfTheNewUserAndIFindThem() {
        adminPage.searchByNewUsername();
    }

    @Then("I delete the user")
    public void iDeleteTheUser() {
        adminPage.deleteNewUsername();
    }

    @And("the number of records should decrease by one")
    public void theNumberOfRecordsShouldDecreaseByOne() {
        adminPage.isNumberOfRecordsDecreasedByOne();
    }



    }






