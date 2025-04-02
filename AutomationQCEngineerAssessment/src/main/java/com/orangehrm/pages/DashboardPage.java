package com.orangehrm.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By dashboardIcon = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
    private final By AdminTab = By.xpath("//span[text()='Admin']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public boolean checkDashboardIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardIcon));
        return driver.findElement(dashboardIcon).isDisplayed();
    }
    public void handleAlertPopup() {
        Alert alert;
        alert = driver.switchTo().alert();
        alert.accept();
    }
    public AdminPage clickOnAdminTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdminTab));
        driver.findElement(AdminTab).click();
        return new AdminPage(driver);
    }

}


