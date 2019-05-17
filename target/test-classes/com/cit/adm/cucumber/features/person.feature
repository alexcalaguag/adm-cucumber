Feature: Simple CRUD operation using person
Scenario: Should be able to create a new person
	Given user wants to create a person with the following attributes
		| id  | name    | cpf      			| lastName |
	    | 22  | Pedro   | 233349866857      | Ramirez  |
	      
	When I call endpoint create person  
	Then the status code is 200


