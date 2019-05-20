package com.cit.adm.cucumber.stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PersonStepDefinitions {
	private Response response;
	private ValidatableResponse json;
	private String url;
	private String person;
	private final static String ENDPOINT_POST_PERSON = "http://localhost:8080/persons";
	private final static String ENDPOINT_GET_PERSON_ID = "http://localhost:8080/persons/%d";

	@Given("open a connection to the \"([^\"]*)\" API$")
	public void open_connection_to_api(String endpoint) {
		url = endpoint;
	}

	@When("send a correct request to insert a person$")
	public void send_correct_request_insert_person(String personJson) {
		person = personJson;
		response = (Response) given().contentType(ContentType.APPLICATION_JSON.toString()).body(person).when()
				.post(url).body();
	}

	@Then("the status code is (\\d+)")
	public void verify_status_code(int statusCode) {
		json = response.then().statusCode(statusCode);
	}

	@And("the person is included successfully")
	public void category_included_successfully() {
		json.body(equalTo(StringUtils.EMPTY));
	}

	@Given("an person with the following attributes$")
	public void an_person_following_attributes(String personJson) {
		person = personJson;
		given().contentType(ContentType.APPLICATION_JSON.toString()).body(person).when().post(ENDPOINT_POST_PERSON)
				.body();
	}
	
	@When("user wants to get person by id (\\d+)")
	public void user_wants_get_person_by_id(int id) {
		  String s = String.format(ENDPOINT_GET_PERSON_ID, id);
		  response = (Response) given().contentType(ContentType.APPLICATION_JSON.toString()).when()
				.get(s).body();
		  json = response.then();
	}
	
	@And("following person is returned")
	public void following_person_returned(DataTable personDT) {
		JsonObject convertedObject = new Gson().fromJson(person, JsonObject.class);
		  Gson gson = new GsonBuilder().create();
		  String jsond = gson.toJson(convertedObject);
		json.body(equalTo(jsond));
	}

}