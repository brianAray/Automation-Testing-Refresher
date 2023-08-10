package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class DriverInteractionsExamples {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // click()
        WebElement button = driver.findElement(By.id("submitButton"));
        button.click();

        // sendKeys()
        WebElement textField = driver.findElement(By.name("username"));
        textField.sendKeys("username1");

        // Implicit Wait
        /*
            This instructs the web driver to wait for a certain amount of time before throwing a NoSuchElementException if the element is not immediately available
            The implicit wait is set once for the entire duration of the WebDriver instance
         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Explicit wait
        /*
            Explicit wait is a more precise and flexible mechanism in Web Drivers that allows you to specifiy a condition to be satisified before proceeding
            It allows you to wait for a certain amount of time until an expected condition is met
         */

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement elementToBeVisible = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));

        // Fluent Wait
        /*
            Fluent Wait is a more advanced explicit wait
            It allows you to define custom polling intervals and ignore specific exceptions during checks
            Fluent wait allows more flexibility and control over the waiting mechanism
         */
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        WebElement elementFluent = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("elementName")));

    }
}
