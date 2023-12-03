
Feature: Adding and Removing product to Wishlist
 

@A-Wishlist
Scenario Outline: Adding product into wishlist 
    Given User Opens the Browser (for WISHLIST-F)
    And   User Opening Home URL "https://demo.nopcommerce.com/" (for WISHLIST-F)
    When  User Navigate to Register page by clicking on Register link option  
    And   User check for Register Page  
    And   User Regitering the user by Filling out the Registration form Using Excel data"<row_index>" (for WISHLIST-F)
    And   User Navigate to Login Page by clicking on log in link  (for WISHLIST-F)
    And   User check for log in Page  (for WISHLIST-F)
    And   User check the Login Confirmation by Passing the Email & Password with Excel row "<login_row_index>" (for WISHLIST-F)
    And   User Search the product in search box by passing "HTC One Mini Blue"
    And   User Adding product to Wishlist by clicking on Add to wishlist option
    And   User Navigate to Wishlist Page by clicking on Wishlist link option
    And   User checking for Wishlist Page
    Then  checking HTC One Mini Blue product is in the Product column of Wishlist Table
    
Examples: 
      |row_index| login_row_index|
      |   1     |      1				 |
   
   
   
      
@R-Wishlist     
Scenario Outline: Removing the product from wishlist 
		Given User Opens the Browser (for WISHLIST-F)
    And   User Opening Home URL "https://demo.nopcommerce.com/" (for WISHLIST-F) 
    When  User Navigate to Login Page by clicking on log in link  (for WISHLIST-F)
    And   User check for log in Page  (for WISHLIST-F)
    And   User check the Login Confirmation by Passing the Email & Password with Excel row "<login_row_index>" (for WISHLIST-F)
		And   User Navigate to Wishlist Page by clicking on Wishlist link option 
    And   User checking for Wishlist Page 
    And   checking HTC One Mini Blue product is in the Product column of Wishlist Table (for R-Wishlist-F)
    Then  Remove the Product from Wishlist Table by clicking on remove button

Examples:
		 | login_row_index|
     |      1				  |
      



      

