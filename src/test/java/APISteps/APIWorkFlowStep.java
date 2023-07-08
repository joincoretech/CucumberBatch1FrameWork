package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayLoad;
import  static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class APIWorkFlowStep {

    RequestSpecification prepareRequest;
    Response response;

    @Given("prepare a request to create user")
    public void prepare_a_request_to_create_user() {
      prepareRequest= given().header(APIConstants.Authorization, GenerateTokenStep.token)
              .header(APIConstants.content_type, APIConstants.application_json)
              .body(APIPayLoad.createLoginPayLoad());
    }


    @When("a POST call is made to create a user")
    public void a_post_call_is_made_to_create_a_user() {
       response= prepareRequest.when().post(APIConstants.create_user_uri);
    }
    @Then("verify the status code {int}")
    public void verify_the_status_code(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("the response contain employee name {string} and value {string}")
    public void the_response_contain_employee_name_and_value(String name, String value) {

        response.then().assertThat().body(name, equalTo(value));
    }


}
