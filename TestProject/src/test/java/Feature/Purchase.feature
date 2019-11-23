Feature: Purchase

Background:

    Given Launch the browser and Load URL
    When The User Clicks Signin
    And Enter the Username as "umadhanapal199@gmail.com" and password as "12345" and signin
    Then Verify the Page is Loaded
    
Scenario: Order TShirt
	
	When User Clicks TShirt
	And User Clicks AddtoCart
	And User Clicks Proceed to Checkout in Cart
	Then Verify Product displayed in Order Summary 
	When User Clicks Proceeds to Checkout in Shopping Cart Summary
	And User Clicks Proceed to Checkout in Address Page
	And User agrees to the terms of Service
	And User Clicks Proceed to Checkout in Shipping
	And User selects the Payment method
	And User Confirms the Order
	And User Clicks Back to Orders
	Then Verify Product is displayed in Order history


Scenario Outline: Update Personal Information
	
	When User selects My Personal Information
    And User Updates the First Name <fName>
   
	
Examples:
|fName|
|UmaMaheswari|
|UmaDhanapal|
	
	
	
	