@LoginPage
 Feature: To validate queue codes login page scenario 
 
Background:  
  Given To launch the browser "chrome"
  And To enter the site url "file:///D:/Selenium/Offline%20Website/index.html"
  And To locate the elements    
  
 @ValidData 
 Scenario: To validate dashboard page title when user enter valid login data
 And To enter the uName "queuecodes@gmail.com"  
 And To enter the uPass "123456" 
 When To click on submit button  
 Then To validate the dashboard page title "Queue Codes | Dashboard"
 And To logout from the dashboard page 
 And To close the browser 
 
 @InvalidData 
Scenario Outline: To validate login page title when user enter invalid data  
And To enter the uName "<userName>"  
And To enter the uPass "<userPassword>" 
When To click on submit button  
Then To validate the Login page title "Queue Codes | Log in"  
And To close the browser
  
 Examples:     
                                              |   testname        |     userName       | userPassword|
					      |Both are empty     |                    |             |    
					      |userName is empty  |                    |   123456    |    
					      |password is empty  |queuecodes@gmail.com|             |    
					      |userName is invalid| queuecodes         |   123456    |    
					      |password is invalid|queuecodes@gmail.com|   123213    |    
					      |Both are invalid   |queuecodes@gmail.   |   121212    | 
 

 
