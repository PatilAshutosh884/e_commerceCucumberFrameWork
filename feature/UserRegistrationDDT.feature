
Feature: User Registration with Excel data.
 

@UR_DDT
Scenario Outline: Performing User Registration Feature using Excel data
    Given User Launching Browser
    And User Opening URL "https://demo.nopcommerce.com/register?returnUrl=%2F"
    When check for Registration Page 
    Then complete registration by Filling out the Registration form Using Excel data"<row_index>"
      	

Examples: 
      |row_index|
      |1|
      |2|
      |3|
      |4|

   