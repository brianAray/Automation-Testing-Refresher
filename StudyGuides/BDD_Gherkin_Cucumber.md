# BDD - Gherkin / Cucumber

## BDD

Behavior-Driven Development (BDD) is an Agile software development approach that focuses on enhancing collaboration among stakeholders (developers, testers, business analysts, etc.) by using a common language to describe the desired behaviors of a system. BDD aims to align the development process with business goals and requirements by emphasizing communication and shared understanding.

In BDD, tests are written in a human-readable format that can be easily understood by stakeholders. These tests serve as executable specifications and are often referred to as "feature files" or "scenarios." BDD encourages stakeholders to collaborate and define the expected behaviors of the system using a structured language called Gherkin.

BDD provides several benefits, such as:

- Improved collaboration and communication among stakeholders
- Increased focus on business goals and requirements
- Clear and concise documentation in the form of executable specifications
- Alignment of development efforts with business value

## Gherkin

Gherkin is a structured language used in BDD to define the expected behaviors of a system. It is designed to be easily readable and understandable by both technical and non-technical stakeholders. Gherkin uses a Given-When-Then structure to describe the preconditions, actions, and expected outcomes of a scenario.

Gherkin supports a set of keywords that serve as building blocks for writing executable specifications. The most commonly used keywords are:

- Feature: Describes a high-level feature or functionality of the system.
- Scenario: Represents a specific test scenario or case.
- Given: Describes the initial preconditions or setup for the scenario.
- When: Specifies the actions or events being performed in the scenario.
- Then: Defines the expected outcomes or assertions of the scenario.
- And, But: Used for adding additional steps or conditions to the scenario.

Extension for gherkin file is `.feature`

Example of a Gherkin scenario:

```gherkin
Feature: Login
  As a user
  I want to be able to log in to the system
  So that I can access my account

  Scenario: Successful login
    Given I am on the login page
    When I enter my username and password
    And I click the login button
    Then I should be logged in to the system
```

In this example, we define a feature named "Login" with a scenario named "Successful login." The scenario specifies the steps involved in logging in to the system and the expected outcome.

## Cucumber

Cucumber is a testing framework that enables Behavior-Driven Development (BDD) by providing a way to write executable specifications in a human-readable format. It allows stakeholders to define the expected behaviors of a system using the Gherkin language and provides tools for automating these specifications.

Cucumber supports various programming languages, including Java, and integrates well with Selenium WebDriver for automating web applications. It follows the principles of BDD, promoting collaboration among stakeholders and enabling the creation of executable specifications that can be used for both documentation and test automation.

### Feature File

A Feature File in Cucumber is a plain text file that contains a collection of scenarios written using the Gherkin language. Each feature file corresponds to a specific feature or functionality of the system being tested. Feature files serve as a bridge between the business requirements and the test automation code.

Feature file is saved in `src/test/resources/Features`

You need to create that folder

Example of a Feature File:
A feature file typically starts with a feature description and contains one or more scenarios.

```gherkin
Feature: Login
  As a user
  I want to be able to log in to the system
  So that I can access my account

  Scenario: Successful login
    Given I am on the login page
    When I enter my username and password
    And I click the login button
    Then I should be logged in to the system

  Scenario: Invalid login
    Given I am on the login page
    When I enter invalid username and password
    And I click the login button
    Then I should see an error message
```

In this example, we have a Feature File named "Login" that contains two scenarios: "Successful login" and "Invalid login." Each scenario describes a specific test case for the login functionality.

### Scenario

A Scenario in Cucumber represents a specific test case or test scenario. It describes a particular situation or set of conditions that should be tested. Scenarios are written using the Gherkin syntax and are part of a feature file.


### Given, When, Then

In Gherkin syntax, Given, When, and Then are keywords used to structure the steps within a scenario and describe the different stages of the test.

- Given: Represents the initial setup or preconditions of the scenario. It defines the starting state of the system.
- When: Represents the actions or events performed during the scenario. It describes the steps that trigger a change in the system.
- Then: Represents the expected outcomes or assertions of the scenario. It defines the expected result or behavior after the actions have been performed.

## Integration

### Glue Code

Glue code refers to the implementation of the step definitions or step implementations that map the Gherkin steps to the actual automation code. It acts as a bridge between the feature files written in Gherkin and the test automation code.

In Cucumber, the glue code is responsible for executing the actions defined in the Gherkin steps. It typically consists of Java methods annotated with Cucumber annotations, such as **`@Given`**, **`@When`**, **`@Then`**, etc. The glue code defines the actual automation logic that will be executed when the corresponding Gherkin steps are matched.

Example of Glue Code:

```java
public class LoginStepDefinitions {
    private WebDriver driver;

    // Constructor injection to get the WebDriver instance

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        driver.get("https://example.com/login");
    }

    @When("I enter my username and password")
    public void enterCredentials() {
        // Code to enter the username and password
    }

    @And("I click the login button")
    public void clickLoginButton() {
        // Code to click the login button
    }

    @Then("I should be logged in to the system")
    public void verifyLogin() {
        // Code to verify the login
    }
}
```

In this example, the glue code contains methods annotated with Cucumber annotations that correspond to the Given, When, And, and Then steps defined in the feature file. These methods define the automation logic to be executed when the steps are matched.

### Step Implementations

Step implementations refer to the individual methods within the glue code that define the actions to be performed for each Gherkin step. Each Gherkin step is mapped to a corresponding step implementation, where the actual automation code is written.

Step implementations contain the code to perform actions such as navigating to a page, interacting with elements, making assertions, and more. They are responsible for executing the automation logic defined in the glue code.

Example of Step Implementations:

```java
@Given("I am on the login page")
public void navigateToLoginPage() {
    driver.get("https://example.com/login");
}

@When("I enter my username and password")
public void enterCredentials() {
    WebElement usernameInput = driver.findElement(By.id("username"));
    usernameInput.sendKeys("john");

    WebElement passwordInput = driver.findElement(By.id("password"));
    passwordInput.sendKeys("password");
}

@And("I click the login button")
public void clickLoginButton() {
    WebElement loginButton = driver.findElement(By.id("loginButton"));
    loginButton.click();
}

@Then("I should be logged in to the system")
public void verifyLogin() {
    // Code to verify login
}
```

In this example, each step implementation method contains the code to perform the corresponding action, such as navigating to the login page, entering the credentials, clicking the login button, and verifying the login.

### JUnit Runner

JUnit5 Runner is a test runner used to execute Cucumber scenarios written using Gherkin syntax. It provides the integration between Cucumber and JUnit5 testing framework, allowing you to run Cucumber tests as JUnit5 tests.

To use the JUnit5 Runner, you need to annotate a class with **`@RunWith(Cucumber.class)`** and specify the paths to your feature files and glue code.

Example of using JUnit5 Runner:

```java
package org.example.StepDefinitions;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("org/example/StepDefinitions")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.example.StepDefinitions")
public class CucumberTest {
}
```
