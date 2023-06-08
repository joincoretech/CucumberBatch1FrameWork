package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoginSteps  extends CommonMethods {

    @When("User add valid userName")
    public void user_add_valid_user_name() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropertyValue("username"));
    }
    @When("User add valid password")
    public void user_add_valid_password() {
        LoginPage loginPage=new LoginPage();
       sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
    }
    @When("User click on the sign in button")
    public void user_click_on_the_sign_in_button() {
        LoginPage loginPage=new LoginPage();
       click(loginPage.submitButton);
    }
    @Then("User login successfully")
    public void user_login_successfully() {
        DashboardPage dashboardPage=new DashboardPage();
        Assert.assertTrue(dashboardPage.hrmText.isDisplayed());
    }


    @When("User add invalid username")
    public void user_add_invalid_username() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, "admin@123");
    }
    @When("User add invalid password")
    public void user_add_invalid_password() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.passwordBox, "pass123");
    }
    @Then("User see error message")
    public void user_see_error_message() {
      LoginPage loginPage=new LoginPage();
      Assert.assertEquals(loginPage.errorMessage.getText(), "Username and Password is Wrong!");
    }

    @When("User does not add password")
    public void user_does_not_add_password() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.passwordBox, "");
    }

    @When("User does not add userName")
    public void user_does_not_add_user_name() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, "");
    }
    @Then("User see error message credentials are required")
    public void user_see_error_message_credentials_are_required() {
        LoginPage loginPage=new LoginPage();
        Assert.assertEquals(loginPage.errorMessage.getText(), "UserName and Password is required");
    }


    @When("User add valid {string} and {string}")
    public void user_add_valid_and(String username, String password) {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, username);
        sendText(loginPage.passwordBox, password);
    }

    @When("user add invalid username and password and verify error message")
    public void user_add_invalid_username_and_password_and_verify_error_message(DataTable errordata) {
        List <Map<String, String>> loginData=errordata.asMaps();
        for (Map<String, String>  loginInfo: loginData ){

            String userName= loginInfo.get("username");
            String password = loginInfo.get("password");
            String errorMessage= loginInfo.get("errormessage");
            System.out.println(userName+ " "+ password+ " "+ errorMessage);

            LoginPage loginPage=new LoginPage();
            sendText(loginPage.userNameBox, userName);
            sendText(loginPage.passwordBox, password);
            click(loginPage.submitButton);
            String actualError= loginPage.errorMessage.getText();
            Assert.assertEquals("Value does not match",errorMessage, actualError );
            System.out.println("the test case passed");

        }

    }

    @When("user add username and password from excel {string} and verify the error message")
    public void user_add_username_and_password_from_excel_and_verify_the_error_message(String testdata) {
        List<Map<String, String>>  excelLoginData= ExcelReader.excelIntListMap(Constants.excelFilePath, testdata);

        LoginPage loginPage=new LoginPage();
        Iterator <Map< String, String>> it=excelLoginData.iterator();
        while (it.hasNext()){
            Map<String, String> mapNewMap=it.next();
            sendText(loginPage.userNameBox, mapNewMap.get("username"));
            sendText(loginPage.passwordBox, mapNewMap.get("password"));
            click(loginPage.submitButton);
            System.out.println(mapNewMap);
            String actualError= loginPage.errorMessage.getText();
            Assert.assertEquals("Value does not match",mapNewMap.get("errormessage"), actualError );
            System.out.println("the test case passed");

        }
    }


}
