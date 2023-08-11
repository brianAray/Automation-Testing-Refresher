package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginSteps {

    private WebDriver driver;
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions

        driver = WebDriverManager.chromedriver().create();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }
    @When("I enter my username and password")
    public void i_enter_my_username_and_password() {
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("user");
    }
    @And("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.tagName("button")).click();
    }
    @Then("I should be logged into the system")
    public void i_should_be_logged_into_the_system() {
        WebElement loginBox = driver.findElement(By.id("success"));
        assertNotNull(loginBox);
        driver.quit();
    }

}
