@SmokeTesting
Feature: User could login with credentials

  Background: User navigates to demo.nopcommerce website

  Scenario: User login with valid credentials

    Given Click on Login tab
    When User enter "test000@automation.com" and "m1234567#"
    And Click on login button

    Then User could login successfully