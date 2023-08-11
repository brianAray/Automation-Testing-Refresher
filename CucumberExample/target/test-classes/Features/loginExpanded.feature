Feature: Login

  Scenario: Successful Login
    When I navigate to "https://bonigarcia.dev/selenium-webdriver-java/login-form.html"
    And I login with the username "user" and password "user"
    And I click Submit
    Then I should be able to see the message "Login successful"

  Scenario: Failed Login
    When I navigate to "https://bonigarcia.dev/selenium-webdriver-java/login-form.html"
    And I login with the username "bad-user" and password "bad-user"
    And I click Submit
    Then I should be able to see the message "Invalid credentials"
