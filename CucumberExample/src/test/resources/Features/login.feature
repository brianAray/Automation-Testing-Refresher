# Gherkin is a structured language used in BDD
# BDD (Behavior Driven Development) is an Agile development approach focusing on collaboration with stakeholders (developers, testers, BAs, etc)
  # It uses natural languages to describe the behavior of a system so that anyone can do it, not just developers or testers

# Gherkin is designed to be easily readable and understandable by both technical and non-technical stakeholders
  # It uses the Given-When-Then structure to describe preconditions, actions, and expected outcomes of a scenario
  # Feature: A high-level description of the system
  # Scenario: Represents a specific test scenario
  # Given: Describes the initial preconditions or setup for the scenario
  # When: Specifies the actions or events being performed in the scenario
  # Then: Defines the expected outcomes or assertions of the scenario
  # And, But: Used for adding additional steps or conditions


Feature: Login
  As a user I want to be able to login to the system so that I can access my account

  Scenario: Successful login
    Given I am on the login page
    When I enter my username and password
    And I click the login button
    Then I should be logged into the system