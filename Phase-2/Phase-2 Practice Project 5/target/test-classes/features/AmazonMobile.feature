Feature: Test lesson End project on Amazon Page
 Scenario Outline: Create account on Amazon
   Given User navigates to create account page
   Then User Enters '<name>','<mobilenumber>','<password>'
   And User clicks on Verify mobile number
   Examples:
     | name  | mobilenumber | password  |
     | user2 |   9879878981 | password2 |
 Scenario: Add Mobile device to the Amazon Cart
   Given User gets ttile of the main Page
   Then User clicks on link Mobiles
   And User navigates to Mobiles & accessories
   And User click on Apple product
   Then User select the first apple product
   And User will switch to new window and get title
   Then user click on Add to Cart
   Then User refreshes the Page and click on Cart link
   Then User clicks on proceed to pay button
   