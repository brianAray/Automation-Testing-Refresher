# Selenium Java

Selenium WebDriver is a popular open-source framework for automating web browsers. It provides a programming interface that allows you to write automated tests in various programming languages, including Java. WebDriver allows you to control web browsers programmatically and simulate user interactions such as clicking buttons, filling out forms, and navigating through web pages. It supports multiple browsers like Chrome, Firefox, Safari, and Internet Explorer.

## Setting up Selenium

1. Make sure you have the JDK installed
2. Create a Maven project
3. Inside the Maven POM.xml, add the Selenium dependency and WebDriverManager dependency
    - The WebDriverManager is used to control the different web browsers

```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.10.0</version>
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.4.1</version>
        <scope>test</scope>
    </dependency>
</dependencies
```

4. Verify that Selenium is working as expected

```java
WebDriver driver = new ChromeDriver(); // Instantiate the driver
driver.get("https://www.google.com"); // Open a website
System.out.println(driver.getTitle()); // Print the page title
driver.quit(); // Close the browser
```

## WebElement

A web element represents an individual element on a web page, like a button, text field, link, or dropdown.
You can interact with them using methods inside the WebDriver.

### Locating Elements

You need to locate elements on a web page before interacting with them. WebDriver provides various methods to locate them.

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

WebElement elementById = driver.findElement(By.id("elementId"));
WebElement elementByClass = driver.findElement(By.className("elementClass"));
WebElement elementByName = driver.findElement(By.name("elementName"));
// ...and so on
```

### Interacting with Elements

Once you have an element, you can perform various actions on it.

```java
WebElement button = driver.findElement(By.id("submitButton"));
button.click(); // Click on the button

WebElement textField = driver.findElement(By.name("username"));
textField.sendKeys("john@example.com"); // Enter text in the text field

WebElement dropdown = driver.findElement(By.id("dropdown"));
Select select = new Select(dropdown);
select.selectByVisibleText("Option 1"); // Select an option from a dropdown
```

### Validating Element Properties

You can also retrieve information about elements, like their text, attributes, or visibility

```java
WebElement header = driver.findElement(By.tagName("h1"));
String text = header.getText(); // Get the text of the header element
System.out.println("Header text: " + text);
```

## WebDriverManager

WebDriverManager is a convenient library that simplifies the management of WebDriver binaries. It automatically downloads the required WebDriver binary for the desired browser and sets up the configuration for you.
To use it, we need to include these in the dependencies:

```xml
<dependency>
  <groupId>io.github.bonigarcia</groupId>
  <artifactId>webdrivermanager</artifactId>
  <version>5.4.1</version>
  <scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter-api</artifactId>
  <version>5.10.0</version>
  <scope>test</scope>
</dependency>
```

We include JUnit5 as Selenium is used in the context of testing, so we only need it for testing.

```java
package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManagerExample {

    WebDriver driver;

    @BeforeAll
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest(){
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }

    @Test
    void test(){
        //exercise
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();

        // Verify
        Assertions.assertTrue(title.contains("Selenium WebDriver"));
    }

}
```

## XPath

### Absolute XPath

XPath is used to navigate and select elements in an XML or HTML document. We can use this in test automation to locate web elements. Absolute XPath starts with the root element of the document and traverses through the hierarchy of elements to reach the target element. It specifies the complete path from the root element to the desired element. Absolute XPath begins with a forward slash /


```html
<html>
  <body>
    <div>
      <form id="loginForm">
        <input type="text" name="username" id="usernameInput">
      </form>
    </div>
  </body>
</html>
```

Absolute XPath to locate the "username" input element:
**`/html/body/div/form/input[@id='usernameInput']`**

Characteristics of Absolute XPath:

- Starts from the root element.
- The complete path is specified.
- Prone to breaking if the structure of the page changes.
- Generally not recommended unless there are no other options.

### Relative XPath

Relative XPath starts from the current element and provides a more flexible and concise way to locate elements. It uses various attributes, functions, and operators to construct XPath expressions. Relative XPath begins with a double forward slash ("//").
    
Using the same HTML structure as before, the Relative XPath to locate the "username" input element can be written as:
**`//input[@id='usernameInput']`**

Characteristics of Relative XPath:

- Starts from the current element or any element in the hierarchy.
- Shorter and more flexible than Absolute XPath.
- Uses attributes, functions, or operators to locate elements.
- Less likely to break when the structure of the page changes.


## Selenium Locators

Selenium Locators are methods provided by WebDriver to identify and locate web elements on a web page. Locators play a crucial role in automating web tests as they allow you to interact with specific elements based on their attributes or characteristics. Selenium WebDriver provides several types of locators to choose from, including:

1. ID Locator:
    - Locates elements based on their unique "id" attribute.
    - Example:
        
        ```java
        WebElement element = driver.findElement(By.id("elementId"));
        ```
        
2. Class Name Locator:
    - Locates elements based on their "class" attribute.
    - Example:
        
        ```java
        WebElement element = driver.findElement(By.className("elementClass"));
        ```
        
3. Name Locator:
    - Locates elements based on their "name" attribute.
    - Example:
        
        ```java
        WebElement element = driver.findElement(By.name("elementName"));
        ```
        
4. Tag Name Locator:
    - Locates elements based on their HTML tag name.
    - Example:
        
        ```java
        WebElement element = driver.findElement(By.tagName("h1"));
        ```
        
5. Link Text and Partial Link Text Locators:
    - Locates anchor elements (links) based on their visible text.
    - Example:
    or
        
        ```java
        WebElement element = driver.findElement(By.linkText("Click here"));
        ```
        
        ```java
        WebElement element = driver.findElement(By.partialLinkText("here"));
        ```
        
6. CSS Selector Locator:
    - Locates elements using CSS selectors.
    - Example:
        
        ```java
        WebElement element = driver.findElement(By.cssSelector("#elementId"));
        ```
        
7. XPath Locator:
    - Locates elements using XPath expressions.
    - Example:
        
        ```java
        WebElement element = driver.findElement(By.xpath("//input[@id='elementId']"));
        ```

## Driver Interactions

### Selenium: click()

The click() method in Selenium WebDriver is used to simulate a click action on a web element, such as a button, link, or checkbox. It triggers the default behavior associated with the element, such as navigating to a new page or submitting a form. The click() method does not require any arguments and returns void.

Example of using click() method:

```java
WebElement button = driver.findElement(By.id("submitButton"));
button.click();
```

### Selenium: sendKeys()

The sendKeys() method in Selenium WebDriver is used to simulate keyboard input on a web element, such as entering text into an input field or selecting options from a dropdown. It takes a CharSequence or a String argument representing the text to be entered.

Example of using sendKeys() method:

```java
WebElement textField = driver.findElement(By.name("username"));
textField.sendKeys("john@example.com");
```

### Selenium: Implicit Wait

Implicit Wait is a mechanism in Selenium WebDriver that instructs the WebDriver to wait for a certain amount of time before throwing a NoSuchElementException if the element is not immediately available. The Implicit Wait is set once for the entire duration of the WebDriver instance.

Example of using Implicit Wait:

```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
```

### Selenium: Explicit Wait

Explicit Wait is a more precise and flexible mechanism in Selenium WebDriver that allows you to wait for a specific condition to be satisfied before proceeding with the execution. It allows you to wait for a certain amount of time until an expected condition is met.

Example of using Explicit Wait:

```java
WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2));
WebElement elementToBeVisible = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
```

### Selenium: Fluent Wait

Fluent Wait is a more advanced form of Explicit Wait in Selenium WebDriver. It allows you to define custom polling intervals and ignore specific exceptions during the wait. Fluent Wait provides more flexibility and control over the waiting mechanism.

Example of using Fluent Wait:

```java
Wait<WebDriver> fluentWait = new FluentWait<>(driver)
  .withTimeout(Duration.ofSeconds(10))
  .pollingEvery(Duration.ofMillis(500))
  .ignoring(NoSuchElementException.class);

WebElement elementFluent = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
```

### Selenium: Upload File

Selenium WebDriver allows you to automate file uploads by interacting with the file input element. You can use the **`sendKeys()`** method to provide the file path to the file input element.

Example of uploading a file:

```java
WebElement fileInput = driver.findElement(By.id("fileInput"));
fileInput.sendKeys("/path/to/file.txt");
```

In this example, we locate the file input element on the page and use the **`sendKeys()`** method to provide the file path. WebDriver will automatically populate the file input element with the specified file path.

### Selenium: Get Snapshot

In Selenium WebDriver, you can capture screenshots (snapshots) of the browser window to aid in debugging or logging test results. WebDriver provides the **`getScreenshotAs()`** method to capture the screenshot as a file or as a base64-encoded string.

Example of capturing a screenshot:

```java
driver.get("https://www.saucedemo.com");
TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
FileHandler.copy(screenshotFile, new File("FULL_PAGE_SCREENSHOT.png"));
driver.quit();
```

In this example, we cast the WebDriver instance to the **`TakesScreenshot`** interface and call the **`getScreenshotAs()`** method to capture the screenshot as a File object.


### Selenium: Resize Browser

In Selenium WebDriver, you can resize the browser window to simulate different screen resolutions or test the responsiveness of a web application. WebDriver provides the **`manage().window().setSize()`** method to resize the browser window.

Example of resizing the browser:

```java
Dimension dimension = new Dimension(800, 600);
driver.manage().window().setSize(dimension);
```

In this example, we create a **`Dimension`** object with the desired width and height in pixels, and then use the **`setSize()`** method to resize the browser window accordingly.

### Selenium: Actions API

Selenium Actions API provides advanced interaction capabilities, such as mouse actions (e.g., moving, clicking) and keyboard actions (e.g., key presses, key releases). It allows you to simulate complex user interactions like drag-and-drop, double-clicks, and more.

Example of using Actions API:

```java
Actions actions = new Actions(driver);
WebElement element = driver.findElement(By.id("elementId"));
actions.moveToElement(element).click().build().perform();
```

In this example, we create an instance of the **`Actions`** class using the WebDriver instance. We then chain multiple actions using the methods provided by the Actions API, such as **`moveToElement()`** and **`click()`**. Finally, we call **`build().perform()`** to execute the action.

### Selenium: Handle popups

Popups are common elements encountered while automating web applications, such as alert dialogs, confirmation dialogs, or modal windows. Selenium WebDriver provides methods to handle these popups and interact with them.

Example of handling an alert dialog:

```java
Alert alert = driver.switchTo().alert();
String alertText = alert.getText();
alert.accept();
```

In this example, we use the **`switchTo().alert()`** method to switch the WebDriver's focus to the alert dialog. We can then use the **`getText()`** method to retrieve the text of the alert and the **`accept()`** method to accept the alert.


### Selenium: Change Tabs

Sometimes, web applications open new tabs or windows during interaction. Selenium WebDriver provides methods to handle switching between different tabs or windows.

Example of switching tabs:

```java
String currentWindowHandle = driver.getWindowHandle();

// perform action to open a new tab or window
driver.switchTo().newWindow(WindowType.TAB);
driver.switchTo().newWindow(WindowType.TAB);
driver.navigate().to("https://www.google.com");

// perform action on the new tab or window
System.out.println(driver.getTitle());

driver.close(); // close the new tab or window
driver.switchTo().window(currentWindowHandle); // switch back to the original tab or window
```


## Page Object Model (POM)

The Page Object Model (POM) is a design pattern used in Selenium WebDriver to create an object-oriented representation of the web pages in an application. It separates the test code from the page-specific code, making the test scripts more maintainable, reusable, and readable. Each web page is represented as a separate class, and the web elements and actions on the page are encapsulated within that class.

### PageFactory

PageFactory is a class provided by Selenium WebDriver that helps in initializing the elements defined in the Page Object Model (POM) classes. It allows you to annotate the web elements in your POM classes and initialize them automatically.

Example of using PageFactory:
In the LoginPage class example from the previous section, we used the **`PageFactory.initElements()`** method to initialize the elements defined in the class.

```java
public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}
```

The **`PageFactory.initElements()`** method initializes the elements with the corresponding annotations (e.g., **`@FindBy`**) using reflection.

#### Example of using POM and PageFactory
Let's assume we have a login page. We can create a LoginPage class that represents the login page and encapsulates the elements and actions on that page.

LoginPage.java:

```java
public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
```

With the POM, test scripts become simpler and more readable:

```java
LoginPage loginPage = new LoginPage(driver);
loginPage.enterUsername("john");
loginPage.enterPassword("password");
loginPage.clickLoginButton();
```