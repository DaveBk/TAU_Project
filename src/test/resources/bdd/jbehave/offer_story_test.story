Scenario: A new offer
Given a new offer
When Offer get own title - Karoca z konmi
Then user can show offer Karoca z konmi name

Scenario: Get offer by regex
Given inits offers list
When user wanna offers with Dzik 
Then user get all offers with Dzik

Scenario: Remove offer by regex
Given inits offers list 
When user wanna delete offers with Dzik 
Then user will remove all offers contains Dzik
mvn clean