
Feature: Login Data Driven with Excel
 

@LoginDDT
Scenario Outline: Performing Login feature using Excel data
    Given Launching Browser
    And Opening URL "https://demo.nopcommerce.com/register?returnUrl=%2F"
    When Navigate to Login Page by clicking on log in link
    And check for log in Page  
    Then check the Login Confirmation by Passing the Email & Password with Excel row "<row_index>"	

Examples: 
      |row_index|
      |1|
      |2|
      |3|         
      |4|
