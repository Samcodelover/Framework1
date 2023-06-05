package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static steps.PageInitializer.dashboardPage;

public class DashboardSteps {

    @Then("user verify dashboard page")
    public void user_verify_dashboard_page() {
        System.out.println("I am happy from now and ever");
    }

    @Then("user verify all the dashboard tabs")
    public void user_verify_all_the_dashboard_tabs(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();

        List<String> actualTabs = new ArrayList<>();

        for(WebElement element: dashboardPage.dashboardTabs
        ){
            actualTabs.add(element.getText());
        }

        System.out.println(expectedTabs);
        System.out.println(actualTabs);

        Assert.assertTrue(expectedTabs.equals(actualTabs));

    }
}
