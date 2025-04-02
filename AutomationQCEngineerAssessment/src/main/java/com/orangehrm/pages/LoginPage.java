package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage{

private WebDriver driver;
private WebDriverWait wait;

    //WebElements
    private By usernameField = By.cssSelector("input[name='username']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By loginButton = By.cssSelector(".oxd-button.orangehrm-login-button");


    public LoginPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    //Methods

    public void addUsername(String username){

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void addPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }


}
