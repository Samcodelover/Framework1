package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @When("user adds multiple employee and verify they are added successfully")
    public void user_adds_multiple_employee_and_verify_they_are_added_successfully(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        //getting the map from list of maps
        for(Map<String, String> employee:employeeNames
            ){
            //getting the keys and values from every map
            String firstNameValue = employee.get("firstName");
            String middleNameValue = employee.get("middleName");
            String lastNameValue = employee.get("lastName");

            sendText(addEmployeePage.firstNameField, firstNameValue);
            sendText(addEmployeePage.lastNameField, middleNameValue);
            sendText(addEmployeePage.lastNameField, lastNameValue);

            click(addEmployeePage.saveButton);
            Thread.sleep(2000);
            //till this point one employee has been added
            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);
            //String errorActual = login.errorMessage.getText();
            //Assert.assertEquals(employeeNames, errorActual);
        }
    }

    @When("user adds multiple employees from excel using {string} and verify it")
    public void user_adds_multiple_employees_from_excel_using_and_verify_it(String sheetName) throws InterruptedException {

        List<Map<String, String>> empFromExcel =
                ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH, sheetName);

        Iterator<Map<String, String>> itr = empFromExcel.iterator();
        while(itr.hasNext()){
            Map<String, String> mapNewEmp = itr.next();

            sendText(addEmployeePage.firstNameField, mapNewEmp.get("firstName"));
            sendText(addEmployeePage.middleNameField, mapNewEmp.get("middleName"));
            sendText(addEmployeePage.lastNameField, mapNewEmp.get("lastName"));
            String empIdValue = addEmployeePage.empIdLocator.getAttribute("value");
            sendText(addEmployeePage.photograph, mapNewEmp.get("photograph"));

            if(!addEmployeePage.checkbox.isSelected()){
                click(addEmployeePage.checkbox);
            }

            sendText(addEmployeePage.createUserNameField, mapNewEmp.get("username"));
            sendText(addEmployeePage.createPasswordField, mapNewEmp.get("password"));
            sendText(addEmployeePage.confirmPasswordField, mapNewEmp.get("confirmPassword"));

            click(addEmployeePage.saveButton);
            System.out.println("click taken on save button");
            Thread.sleep(3000);

            click(dashboardPage.empListOption);
            Thread.sleep(2000);
            System.out.println("click taken on emp list option");
            sendText(employeeList.empSearchIdField, empIdValue);
            click(employeeList.searchButton);

            List<WebElement> rowData =
                    driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));

            for(int i=0; i<rowData.size(); i++){
                System.out.println("I am inside of for loop");
                String rowText = rowData.get(i).getText();
                System.out.println(rowText);

                String expectedData = empIdValue + " " + mapNewEmp.get("firstName")
                        +" "+mapNewEmp.get("middleName")+" "+mapNewEmp.get("lastName");

                Assert.assertEquals(expectedData, rowText);
            }

            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);


        }
    }



}
