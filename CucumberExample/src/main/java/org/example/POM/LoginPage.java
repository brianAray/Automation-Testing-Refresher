package org.example.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(tagName = "button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
        PageFactory.initElements(driver, this);
    }

    public LoginPage(WebDriver driver, String url){
        this.driver = driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    public void inputUsername(String username){
        usernameField.sendKeys(username);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }


}
