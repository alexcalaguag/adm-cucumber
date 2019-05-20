Feature: Consultar uma Pessoa
  Scenario: Get person successfully
  	Given an person with the following attributes 
  	"""
    {
      "id"	: 2,
      "name": "Ricardo",
      "cpf": "569349866999",
      "lastName" : "Marino"
    }
    """
    When user wants to get person by id 2
	Then the status code is 200
	And following person is returned 
	 | id  | name       | cpf             | lastName |
     | 2   | Ricardo    | 569349866999    | Marino   |



