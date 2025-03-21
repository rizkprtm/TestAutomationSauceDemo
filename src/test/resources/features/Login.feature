@Login
Feature: Login
  As a user i want login to sauce demo

  @positive
  Scenario: Login With Valid Data
    Given User already open the website sauce demo
    When User input "standard_user" as username "secret_sauce" as password
    Then User already on homepage

  @negative
  Scenario Outline: Login With Invalid Data
    Given User already open the website sauce demo
    When User input "<username>" as username "<password>" as password
    Then User get "<error>" as error message

    Examples: Credentials Data
      | username        | password    | error                                                                     |
      | locked_out_user | secret_sauce| Epic sadface: Sorry, this user has been locked out.                       |
      | standard_user   | secret      | Epic sadface: Username and password do not match any user in this service |