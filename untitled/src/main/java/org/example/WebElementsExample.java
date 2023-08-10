package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");

        // locating elements

        WebElement elementById = driver.findElement(By.id("root"));
        WebElement elementByClass = driver.findElement(By.className("login_container"));

        System.out.println(elementById);
        System.out.println(elementByClass);
        // ...etc

        // Interacting with elements
        WebElement usernameField = driver.findElement(By.name("user-name"));
        usernameField.sendKeys("standard_user"); // types in the username

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce"); // Types in the password

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Once logged in, we need to validate it programmatically
        System.out.println(driver.getTitle());

        driver.quit();



    }
}
