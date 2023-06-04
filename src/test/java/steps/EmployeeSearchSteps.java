package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("user navigate to hrm")
    public void user_navigate_to_hrm() {
        setUp();
    }

    @Given("user login as admin")
    public void user_login_as_admin() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
        click(loginPage.submitButton);

    }


    @Given("user navigate to employee view page")
    public void user_navigate_to_employee_view_page() {

    }

    @When("user add employee id")
    public void user_add_employee_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click on the submit button")
    public void user_click_on_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user validate the employee is visible in table")
    public void user_validate_the_employee_is_visible_in_table() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
