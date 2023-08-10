import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebDriverManagerExample {

    WebDriver driver;

    @BeforeAll
    static void setupClass(){
        WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    void setupTest(){
        driver = new EdgeDriver();
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }

    @Test
    void test(){
        // Setup the test

        // rudimentary example
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();

        // Verify
        assertTrue(title.contains("Selenium WebDriver"));
    }
}
