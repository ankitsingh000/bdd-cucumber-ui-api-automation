@login @front-end
Feature: Login Test

	@UITests1
	Scenario Outline: Proceed to Checkout of amazon
		Given User Navigate to the Amazon website and clicks on Sign in button
		And User enter valid login credentials "<username>" and "<password>"
		Then Verify that the "<user>" is successfully logged in
		Examples:
			| username   | password    | user         |
			| 	inputUsername | inputPassword | Hello, Ankit |