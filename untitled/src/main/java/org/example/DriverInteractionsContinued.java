package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class DriverInteractionsContinued {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();

        // Upload File
        /*
            Lets you autoamte the file uploads by interacting with the file input element
            You can use sendKeys() method to provide the file path to the file input element
         */
//        WebElement fileInput = driver.findElement(By.id("fileInput"));
//        fileInput.sendKeys("/path/to/file.txt");

        // The web driver will automatically populate the file input elements with the specified file path

        // Get snapshot
        // You can capture screenshots of the browser window to aid in debugging and logging of defects
        driver.get("https://www.saucedemo.com");
//        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
//        File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(screenshotFile, new File("FULL_PAGE_SCREENSHOT.png"));

        // Resize Browser
        // For testing different screen resolutions or test the responsiveness of a web application
        Dimension dimension = new Dimension(800, 600);
        driver.manage().window().setSize(dimension);

        // Handle popups
        /*
            Popups are a common element while automating web applications, like alert dialogs or confirmation dialogs
         */
//        Alert alert = driver.switchTo().alert();
//        String alertText = alert.getText();
//        alert.accept();

        // Change tabs
        /*
            Web applications some times opens a new tab or window during interactions
            Selenium provides methods to handle switching between different tabs or windows
         */
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);
        // Perform action to open a new tab or window
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.google.com");

        // perform an action on the new tab or window
        System.out.println(driver.getTitle());

        driver.close(); // close the new tab or window
        driver.switchTo().window(currentWindowHandle); // switch back to the original window
    }

}
