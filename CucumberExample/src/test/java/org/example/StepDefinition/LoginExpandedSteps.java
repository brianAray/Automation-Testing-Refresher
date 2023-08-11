package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginExpandedSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    @When("I navigate to {string}")
    public void i_navigate_to(String string) {
        driver = WebDriverManager.chromedriver().create();
        loginPage = new LoginPage(driver, string);
    }
    @And("I login with the username {string} and password {string}")
    public void i_login_with_the_username_and_password(String string, String string2) {
        loginPage.inputUsername(string);
        loginPage.inputPassword(string2);
    }
    @And("I click Submit")
    public void i_click_submit() {
        loginPage.clickLoginButton();
    }
    @Then("I should be able to see the message {string}")
    public void i_should_be_able_to_see_the_message(String string) {
        try{
            driver.findElement(By.xpath("//*[contains(text(), '" + string + "')]"));
        }catch(NoSuchElementException e){
            throw new AssertionError(string + "is not found");
        }finally {
            driver.quit();
        }
    }
}
