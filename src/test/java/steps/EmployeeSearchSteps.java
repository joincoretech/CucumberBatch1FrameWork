package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.EmployeeViewPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {


    @Given("user login as admin")
    public void user_login_as_admin() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
        click(loginPage.submitButton);

    }


    @Given("user navigate to employee view page")
    public void user_navigate_to_employee_view_page() {
        DashboardPage dashboardPage=new DashboardPage();
      click(dashboardPage.employeeTab);
      click(dashboardPage.employeeView);

    }

    @When("user add employee id")
    public void user_add_employee_id() {
        EmployeeViewPage employeeViewPage=new EmployeeViewPage();
       sendText(employeeViewPage.searchBox, "105");
    }

    @When("user click on the submit button")
    public void user_click_on_the_submit_button() {
        EmployeeViewPage employeeViewPage=new EmployeeViewPage();
        click(employeeViewPage.submitButton);
    }

    @Then("user validate the employee is visible in table")
    public void user_validate_the_employee_is_visible_in_table() {
        EmployeeViewPage employeeViewPage=new EmployeeViewPage();
       String actualText= employeeViewPage.tableDta.getText();
        if (actualText.contains("Aziz")){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
    }


    @When("user add employee name")
    public void user_add_employee_name() {
        EmployeeViewPage employeeViewPage=new EmployeeViewPage();
        sendText(employeeViewPage.searchBox, "Aziz");
    }

}
