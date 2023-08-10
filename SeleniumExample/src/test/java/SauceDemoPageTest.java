import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.POMExample;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SauceDemoPageTest {

    private WebDriver driver;
    private POMExample loginPage;

    @BeforeAll
    static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest(){
        driver = new ChromeDriver();
        loginPage = new POMExample(driver);
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }

    @Test
    public void validLoginTest(){
        // valid login test
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        WebElement linkText = driver.findElement(By.linkText("Sauce Labs Backpack"));

        assertNotNull(linkText);
    }

    @Test
    public void invalidLoginTest(){
        loginPage.enterUsername("wrong");
        loginPage.enterPassword("wrong");
        loginPage.clickLoginButton();

        WebElement invalidLoginText = driver.findElement(By.tagName("h3"));

        assertTrue(invalidLoginText.getText().contains("Epic sadface"));
    }
}
