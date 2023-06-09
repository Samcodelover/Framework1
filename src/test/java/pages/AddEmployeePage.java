package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id="firstName")
    public WebElement firstNameField;

    @FindBy(id="lastName")
    public WebElement lastNameField;

    @FindBy(id="middleName")
    public WebElement middleNameField;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(id="photofile")
    public WebElement photograph;

    @FindBy(id="chkLogin")
    public WebElement checkbox;

    @FindBy(id="user_name")
    public WebElement createUserNameField;

    @FindBy(id="user_password")
    public WebElement createPasswordField;

    @FindBy(id="re_password")
    public WebElement confirmPasswordField;

    @FindBy(id="employeeId")
    public WebElement empIdLocator;

    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }



}
