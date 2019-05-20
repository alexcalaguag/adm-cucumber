Feature: Incluir uma Pessoa
  Scenario: Include person successfully
	Given open a connection to the "http://localhost:8080/persons" API
	When send a correct request to insert a person
	"""
    {
      "id"	: 1,
      "name": "Steve",
      "cpf": "233349866857",
      "lastName" : "Ramirez"
    }
    """
	Then the status code is 201
	And the person is included successfully	




