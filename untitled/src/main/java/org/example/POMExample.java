package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMExample {

    /*
        The POM (Page Object Model) is a design pattern in Selenium to create an OOP representation of the page
        It is used to separate the Page Specfic code from the testing code
        This makes the test cases more maintainable, reusable, and readable

        Each web page is represented as a separate class, and the web elements and actions on the page are encapsulated within the class
     */

    /*
        Page Factory

        The PageFactory class is provided by Selenium that helps in initializing the elements defined in the POM
        It allows you to annotate the Web Elements in your POM classes and initializes them for you
     */

    // Website: https://www.saucedemo.com

    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    // The name of the POM should the name of the page
    // for this example I have chosen to not do that to make it clear it is an example
    public POMExample(WebDriver driver){
        this.driver = driver;
        driver.get("https://www.saucedemo.com");
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
