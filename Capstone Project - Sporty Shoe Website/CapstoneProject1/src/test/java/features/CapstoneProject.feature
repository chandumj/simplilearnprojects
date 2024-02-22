Feature: APiTesting for sportShoe application
Scenario: Retrieve the list of all products in the store
Given User sends a get request to get product details
Scenario: Retrieve the list of all registered users
Given User sends get request to list user details
Scenario: Add the product
When User gives new product details, add the product
Scenario: Delete the Product
When User gives product id, delete the product
Scenario: Update Exisitng Product
When User gives product id and update data, update the product
