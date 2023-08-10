package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumLocatorsExamples {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Selenium Locators

        // By ID
        // Locates elements based on their unique "id" attribute
        WebElement elementById = driver.findElement(By.id("id"));

        // By Class
        // locates elements based on their class name
        WebElement elementsByClass = driver.findElement(By.className("classname"));

        // By Name
        // locates elements based on their name
        WebElement elementByName = driver.findElement(By.name("Name"));

        // Tag name
        // locates elements based on their HTML tag name
        WebElement elementByTagName = driver.findElement(By.tagName("h1"));
        List<WebElement> elementsByTagName = driver.findElements(By.tagName("p"));

        // Link and Partial Link text
        // locates elements based on their anchor text whether fully or partially
        WebElement elementByLinkText = driver.findElement(By.linkText("click here"));

        WebElement elementByPartialLinkText = driver.findElement(By.partialLinkText("here"));

        // CSS Selectors
        // Locates elements using CSS selectors
        WebElement elementsByCSS = driver.findElement(By.cssSelector("#elementId"));


        // XPath Selectors
        // Locates by XPath Expressions
        // Absolute and Relative XPath
        // Xpath is used to navigate and select elements in an XML or HTML document

        // Absolute XPath
        /*
            This starts with the root element of the document and traverses through the hierarchy to reach the target element
            It specifies the complete path from the root element to the desired element
            It begins with a forward slash "/"
         */

        /*
        <html>
          <body>
            <div>
              <form id="loginForm">
                <input type="text" name="username" id="usernameInput">
              </form>
            </div>
          </body>
        </html>
         */

        // Absolute XPath to locate the "username" input element
        // /html/body/div/form/input[@id='usernameInput']

        // Characteristics of Absolute XPath
        /*
            - Starts from the root element
            - The complete path is specified
            - It is prone to breaking if the structure of the page changes
            - It is not recommended unless you have no other option
         */


        // Relative XPath
        /*
            Starts from the current element and provides a more flexible and concise way to find an element
            It uses various attributes, functions, and operators to construct an XPath expression
            Begins with a double forward slash "//"
         */

        // Example based on the HTML above
        // //input[@id='usernameInput']

        // Characteristics of Relative XPath
        /*
            - Starts from the current element or any element in the hierarchy
            - Shorter and more flexible than absolute Xpath
            - Uses attributes, functions, or operators to locate elements
            - Less likely to break when the structure of the page changes
         */

        WebElement elementByXpath = driver.findElement(By.xpath("//input[@id='elementId']"));
    }
}
