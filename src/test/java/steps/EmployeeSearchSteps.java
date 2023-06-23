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
import utils.GlobalVariables;

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


    @When("user add employee {string}")
    public void user_add_employee(String searchData) {
        EmployeeViewPage employeeViewPage=new EmployeeViewPage();
        sendText(employeeViewPage.searchBox, searchData);
    }



    @When("user get data from employee view page")
    public void user_get_data_from_employee_view_page() {
        EmployeeViewPage employeeViewPage=new EmployeeViewPage();
        sendText(employeeViewPage.searchBox, "13");
        click(employeeViewPage.submitButton);
        GlobalVariables.fullName=employeeViewPage.fullName.getText();

    }
    @Then("user verify frontend data with backend")
    public void user_verify_frontend_data_with_backend() {

        System.out.println(GlobalVariables.dbFirstName+" "+ GlobalVariables.dbMiddleName+" "+GlobalVariables.dbLastName);
        String dbFullName=GlobalVariables.dbFirstName+" "+ GlobalVariables.dbMiddleName+" "+GlobalVariables.dbLastName;
        System.out.println(GlobalVariables.fullName);
        Assert.assertEquals(dbFullName,GlobalVariables.fullName);


    }




}
