
Feature: SignUp

  Scenario: SignUp in TestMeApp
		Given I want to Signup in the TestMeApp
		When I open the TestMeApp Using Url
		Then Click on the SignUp Button
		And Fill the required fields
		| UserName   | First Name | Last Name | Password | Confirm Password | Gender | E -Mail          | Mobile Number | DOB        | Address   | Answer |
		| lohithhhh  | Lohith     | Pradeep   | 12345678 | 12345678				  | M      | lohith@gmail.com | 9999999999    | 27/10/1997 | asdasdasd | bza    |
		Then Click on the Register Button
		
 
