package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

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

}
