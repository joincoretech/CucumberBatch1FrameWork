package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("user verify the dashboard tabs")
    public void user_verify_the_dashboard_tabs(DataTable dataTable) {
        List<String> expectedData=dataTable.asList();

        DashboardPage dashboardPage=new DashboardPage();
        List<String> actualData= new ArrayList<>();
        for(WebElement ele:dashboardPage.dashboardTabs){
            actualData.add(ele.getText());
        }

        System.out.println(expectedData);
        System.out.println(actualData);
        Assert.assertTrue(expectedData.equals(actualData));
        System.out.println("Dashboard tabs are same and test case passed");
    }

}
