package APIPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODYzNDA5MzMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NjM4NDEzMywidXNlcklkIjoiNTU0MiJ9.0AJFJow5wO3PyJvzBcJgf9oNDB8MLinE3oZq2NWqebo";

    static String employee_id;
    @Test
    public void bgetOneEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .queryParam("employee_id",employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        //System.out.println(response.asString());

        response.prettyPrint();
        response.then().assertThat().statusCode(200);

        String firstName = response.jsonPath().getString("employee.emp_firstname");
        System.out.println(firstName);

        Assert.assertEquals(firstName, "Kana");

        response.then().assertThat().body("employee.emp_firstname", equalTo("Kana"));
    }

    @Test
    public void acreateEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"emp_firstname\": \"Kana\",\n" +
                        "  \"emp_lastname\": \"DelRay\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2000-06-07\",\n" +
                        "  \"emp_status\": \"good\",\n" +
                        "  \"emp_job_title\": \"Singer\"\n" +
                        "}");

        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(201);
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        response.then().assertThat().body("Employee.emp_lastname",equalTo("DelRay"));
        response.then().assertThat().body("Employee.emp_middle_name",equalTo("ms"));
        response.then().assertThat().header("Server",equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));
    }

    @Test
    public void cupdateEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json").
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Angelina\",\n" +
                        "  \"emp_lastname\": \"Joly\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2000-06-07\",\n" +
                        "  \"emp_status\": \"fine\",\n" +
                        "  \"emp_job_title\": \"actress\"\n" +
                        "}" );

        Response response = request.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);

        response.then().assertThat().body("Message", equalTo("Employee record Updated"));

    }

    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("employee.emp_job_title", equalTo("Actress"));
    }
}
