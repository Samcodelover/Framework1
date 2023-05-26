package pages;

import io.cucumber.java.an.E;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.PageInitializer;
import utils.CommonMethods;

public class EmployeeListPage extends CommonMethods {

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement empSearchNameField;

    @FindBy(id="empsearch_id")
    public WebElement empSearchIdField;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    public EmployeeListPage(){
        PageFactory.initElements(driver, this);
    }


}
