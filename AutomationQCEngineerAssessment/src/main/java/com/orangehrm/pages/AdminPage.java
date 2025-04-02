package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By addButton = By.xpath("//button[contains(., 'Add')]");
    private final By addUser = By.xpath("(//button[normalize-space()='Add'])[1]");

    private final By dropDownUserRole = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
    private final By userRoleAdmin = By.xpath("//div[@class='oxd-select-text-input' and @tabindex='0' and contains(text(), 'Admin')]");
    private final By dropDownEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By dropDownStatus = By.xpath("(//div[@class='oxd-select-text-input' and @tabindex1='0' and contains(text(), 'Select')])[2]");
    private final By newUsernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By newPasswordField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    private final By confirmNewPasswordField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By newUsernameSearchField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By searchNewUsernameButton = By.xpath("(//button[normalize-space()='Search'])[1]");
    private final By deleteIcon = By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space' and @type='button']//i)[1]");
    private final By yesDelete = By.xpath("//button[normalize-space()='Yes, Delete']");

    int noOriginal;// original number of records
    int noAfterAdd;// number of records after increase


    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void getNumberOfRecordsFound() {

        //WebElement e = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']"));

        WebElement e = driver.findElement(By.xpath("//span[contains(., 'Records Found')]"));
        String textValue = e.getText();
        //get the int from string
        String intValue = textValue.replaceAll("[^0-9]", "");
        //convert number to integer
        noOriginal = Integer.parseInt(intValue);

        System.out.println("The total records now is:" + noOriginal);
    }

    public boolean isAddUserVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        return driver.findElement(addButton).isDisplayed();
    }

    public void clickOnAddButton() {

        driver.findElement(addButton).click();
    }

    public void addRequiredDataAndSave() {
        wait.until(ExpectedConditions.elementToBeClickable(dropDownUserRole));
        driver.findElement(dropDownUserRole).click();
        wait.until(ExpectedConditions.elementToBeClickable(userRoleAdmin));
        driver.findElement(userRoleAdmin).click();

            //Locate the dropdown menu and Select the first option in the dropdown by index
            WebElement dropdown = driver.findElement(dropDownEmployeeName);
            Select select = new Select(dropdown);
            select.selectByIndex(0);

            //Drop down status//select Enabled
            WebElement dropdown2 = driver.findElement(dropDownStatus);
            Select selectStatus = new Select(dropdown2);
            selectStatus.selectByVisibleText("Enabled");

            //write new username - new password - confirm new password
            driver.findElement(newUsernameField).click();
            driver.findElement(newUsernameField).sendKeys("asmaa");

            driver.findElement(newPasswordField).click();
            driver.findElement(newPasswordField).sendKeys("Test@123");

            driver.findElement(confirmNewPasswordField).click();
            driver.findElement(confirmNewPasswordField).sendKeys("Test@123");

            //save
            driver.findElement(saveButton).click();
        }

        public void isNumberOfRecordsIncreasedByOne () {

            WebElement f = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']"));
            String textValue2 = f.getText();
            //get the int from string
            String intValue2 = textValue2.replaceAll("[^0-9]", "");
            //convert number to integer
            noAfterAdd = Integer.parseInt(intValue2);

            System.out.println("The total records now is:" + noAfterAdd);
            System.out.println("The total records was :" + noOriginal);
        }

        public void searchByNewUsername(){
            driver.findElement(newUsernameSearchField).click();
            driver.findElement(newUsernameSearchField).sendKeys("asmaa");
            driver.findElement(searchNewUsernameButton).click();

        }

        public void deleteNewUsername(){
            wait.until(ExpectedConditions.visibilityOfElementLocated(deleteIcon));
            driver.findElement(deleteIcon).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(yesDelete));
            driver.findElement(yesDelete).click();
        }

        public void isNumberOfRecordsDecreasedByOne () {

            WebElement NumberDecreased = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']"));
            int noAfterDelete = Integer.parseInt(NumberDecreased.getText());
            //verify that the number of records decreased by one
            System.out.println("The number after delete is " + noAfterDelete);
        }
    }

