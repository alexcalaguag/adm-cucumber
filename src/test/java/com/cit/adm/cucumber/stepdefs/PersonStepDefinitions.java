package com.cit.adm.cucumber.stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import java.util.List;
import java.util.Map;

import com.cit.adm.person.Person;
import com.google.gson.Gson;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PersonStepDefinitions {

	private Response response;
	private ValidatableResponse json;
	private Person person;

	@Given("user wants to create a person with the following attributes")
	public void a_book_exists_with_isbn(List<Person> persons) {
		person = (Person) persons.get(0);
	}

	@When("I call endpoint create person")
	public void a_user_retrieves_the_book_by_isbn() {
		Gson gson = new Gson();
		gson.toJson(person);
		response = (Response) given().contentType("application/json").body(person).when().post("http://localhost:8080/persons").body();
	}

	@Then("the status code is (\\d+)")
	public void verify_status_code(int statusCode) {
		json = response.then().statusCode(statusCode);
	}

}
