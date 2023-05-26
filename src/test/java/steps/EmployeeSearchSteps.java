package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import utils.CommonMethods;

import java.util.List;

public class EmployeeSearchSteps extends CommonMethods {


    @When("user clicks on Employee list option")
    public void user_clicks_on_employee_list_option() {
        //WebElement element = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        //click(element);
        click(dashboardPage.empListOption);
    }

    @When("user enters a valid employee id")
    public void user_enters_a_valid_employee_id() {
        WebElement element = driver.findElement(By.id("empsearch_id"));
        sendText(element, "56221A");
    }

    @When("user enters a valid employee name")
    public void user_enters_a_valid_employee_name() {
        WebElement searchNameField = driver.findElement(By.id("empsearch_employee_name_empName"));
        sendText(searchNameField, "Selab");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        WebElement searchButton = driver.findElement(By.id("searchBtn"));
        click(searchButton);
        getWait();
    }
    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("Successfully found the employee");
    }

}
