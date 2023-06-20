package steps;

import io.cucumber.java.en.When;
import utils.DbUtils;
import utils.GlobalVariables;

import java.util.List;
import java.util.Map;

public class DbSteps {

    @When("user get data from backend")
    public void user_get_data_from_backend() {
        String query="select firstname, middlename, lastname from employee where employeeid=13";
        List<Map<String, String>> tableDataAsList= DbUtils.getTableDataAsListOfMaps(query);
        GlobalVariables.dbFirstName=tableDataAsList.get(0).get("FirstName");
        GlobalVariables.dbMiddleName=tableDataAsList.get(0).get("MiddleName");
        GlobalVariables.dbLastName=tableDataAsList.get(0).get("LastName");

    }

}
