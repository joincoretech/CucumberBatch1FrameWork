package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayLoad;

import static io.restassured.RestAssured.given;

public class GenerateTokenStep {

     static String token;
    @Given("generate token")
    public void generate_token() {
        RequestSpecification prepareRequest= given().header(APIConstants.content_type, APIConstants.application_json)
                .body(APIPayLoad.loginPayLoad());
        Response response=prepareRequest.when().post(APIConstants.login_uri);
        response.prettyPrint();
        token="Bearer "+ response.jsonPath().getString("token");
        System.out.println(token);
    }
}
