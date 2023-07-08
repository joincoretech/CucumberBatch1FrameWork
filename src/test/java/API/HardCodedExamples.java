package API;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import  static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class HardCodedExamples {
    /*
    Note:
     -- Given  - prepare the request
     -- When - making a request to the endpiont
     -- Then - verification/ Assertion
     */
       static String token="Bearer QpwL5tke4Pnpja7X4";

       static String created_id;
     // @Test
    public void sampleTest(){
        RequestSpecification prepareRequest= given().header("Authorization", token).
                header("Content-Type", "application/json");

        Response response= prepareRequest.when().get("https://reqres.in/api/users/2");

        //printing the response using aString() method will convert it to json format
        // System.out.println()
        System.out.println(response.asString());
    }

    @Test
    public void aCreateUser(){

          RequestSpecification prepareRequest= given().header("Authorization", token).
                  header("Content-Type","application/json").body("{\n" +
                          "    \"name\": \"Aziz\",\n" +
                          "    \"job\": \"teacher\"\n" +
                          "}");

          // log().all will log or print all the information that we send in request

        Response response=prepareRequest.when().post("https://reqres.in/api/users");

        System.out.println(response.asString());
        response.prettyPrint();// this will do same as System.out.println(response.asString());

        // jsonPath() it allows us to get data from json object

        created_id=response.jsonPath().getString("id");

        System.out.println(created_id);

        /*
        Assertion
         */
        response.then().assertThat().statusCode(201);

        response.then().assertThat().body("name", equalTo("Aziz"));
        System.out.println("the name is matched");

        response.then().assertThat().body("job", equalTo("teacher"));
        System.out.println("the job is matched");


    }
     @Test
    public void bGetAllUsers(){
        RequestSpecification prepareRequest=given().header("Authorization", token)
                .header("Content-Type", "Application/json").queryParam("page", "2");

        Response response=prepareRequest.when().get("https://reqres.in/api/users");
        System.out.println(response.asString());

         JsonPath js= new JsonPath(response.prettyPrint());

         int count=js.getInt("data.size()");
         System.out.println(count);

         for (int i =0; i<count; i++){

             String  employeeId=js.getString("data["+ i +"].id");
             System.out.print(employeeId+ " ");
             if (employeeId.contentEquals("12")){
                 System.out.println(js.getString("data["+i+"].first_name"));

             }
         }


         System.out.println("total "+response.jsonPath().getString("total"));
    }

}
