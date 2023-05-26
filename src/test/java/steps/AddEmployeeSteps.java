package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
       // WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        //pimOption.click();
        click(dashboardPage.pimOption);
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        //WebElement AddEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
        //AddEmployeeOption.click();
        click(dashboardPage.addEmployeeOption);
    }
    @When("user enter firstname and lastname")
    public void user_enter_firstname_and_lastname() {
        //WebElement firstName = driver.findElement(By.id("firstName"));
        //firstName.sendKeys("somann");
       sendText(addEmployeePage.firstNameField, "somannn");

       // WebElement lastName = driver.findElement(By.id("lastName"));
       // lastName.sendKeys("yuriaa");
        sendText(addEmployeePage.lastNameField, "hhhh");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
       // WebElement saveButton = driver.findElement(By.id("btnSave"));
        //saveButton.click();
        click(addEmployeePage.saveButton);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee Added");
    }

    @When("user enter {string} and {string}")
    public void user_enter_and(String firstName, String lastName) {
        sendText(addEmployeePage.firstNameField, firstName);
        sendText(addEmployeePage.lastNameField, lastName);
    }

    @When("user enter value for {string} and {string}")
    public void user_enter_value_for_and(String firstName, String lastName) {
        sendText(addEmployeePage.firstNameField, firstName);
        sendText(addEmployeePage.lastNameField, lastName);
    }



}
