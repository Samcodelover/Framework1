package steps;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;

public class PageInitializer {

    public static LoginPage login;
    public static DashboardPage dashboardPage;

    public static AddEmployeePage addEmployeePage;
    public static EmployeeListPage employeeList;
    public static void initializePageObjects(){
        login = new LoginPage();
        dashboardPage = new DashboardPage();
        addEmployeePage = new AddEmployeePage();
        employeeList = new EmployeeListPage();


    }
}
