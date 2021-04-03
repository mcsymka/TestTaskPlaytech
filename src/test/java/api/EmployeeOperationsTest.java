package api;

import employeeDTO.CreatedEmployee;
import employeeDTO.DeletedEmployee;
import employeeDTO.Employee;
import employeeDTO.Employees;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.EmployeeRestService;

import java.io.File;

import static org.testng.Assert.*;

public class EmployeeOperationsTest {

    private static Logger log = Logger.getLogger( EmployeeOperationsTest.class );

    private EmployeeRestService employeeRestService;
    private String apiHost = "http://dummy.restapiexample.com/api/v1";
    private int employeeId = 5;
    private int notExistEmployeeId = -1;

    @BeforeMethod( alwaysRun = true )
    public void beforeMethod() {
        employeeRestService = new EmployeeRestService( apiHost );
    }

    @DataProvider( name = "Employees" )
    public static Object[][] getEmployees() {
        return new Object[][]{
                { "Denys", "2002", "30" },
                { "Roman", "2300", "33" },
                { "Slava", "1000", "22" }
        };
    }

    @Test( dataProvider = "Employees" )
    public void CreateEmployeesAndVerifyIt( String name, String salary, String age ) {
        log.info( "Create employee with name - " + name );
        CreatedEmployee createdEmployee = employeeRestService.createEmployee( name, salary, age );
        assertEquals( createdEmployee.getData().getName(), name, "The employee named " + name + " is not created" );
        int employeeId = createdEmployee.getData().getId();
        log.info( "Verify employee with ID - " + employeeId + " and name - " + name );
        Employee employee = employeeRestService.getEmployeeById( employeeId );
        assertEquals( employee.getData().getId(), new Integer( employeeId ), "The employee with ID - " + employeeId + " is not in the system." );
        assertEquals( employee.getData().getEmployeeName(), name, "The employee named " + name + " is not in the system." );
    }

    @Test
    public void ChangeEmployee() {
        String name = String.valueOf( getEmployees()[0][0] );
        String salary = String.valueOf( getEmployees()[0][1] );
        String age = String.valueOf( getEmployees()[0][2] );
        log.info( "Update employee with ID - " + employeeId );
        CreatedEmployee createdEmployee = employeeRestService.updateEmployee( name, salary, age, employeeId );
        assertEquals( createdEmployee.getData().getName(), name, "The employee named " + name + " is not updated" );
        log.info( "Verify that employee name with ID - " + employeeId + " changed to - " + name );
        Employee employee = employeeRestService.getEmployeeById( employeeId );
        assertEquals( employee.getData().getId(), new Integer( employeeId ), "The employee with ID - " + employeeId + " is not in the system." );
        assertEquals( employee.getData().getEmployeeName(), name, "The employee named " + name + " is not in the system." );
    }

    @Test
    public void SerializeEmployeesToJsonFile() {
        File file = new File( "src/test/resources/employees.json" );
        log.info( "Serialize all the employees and save in employees.json file" );
        Employees employees = employeeRestService.getEmployees();
        employeeRestService.writeValueIntoJsonFile( file, employees );
    }

    @Test
    public void DeleteEmployee() {
        log.info( "Delete employee with ID: " + employeeId );
        DeletedEmployee deletedEmployee = employeeRestService.deleteEmployee( employeeId, 200 );
        assertEquals( deletedEmployee.getStatus(), "success" );
        assertEquals( deletedEmployee.getData(), String.valueOf( employeeId ) );
    }

    @Test
    public void DeleteEmployeeWithNonExistentID() {
        log.info( "Delete employee with ID: " + notExistEmployeeId );
        DeletedEmployee deletedEmployee = employeeRestService.deleteEmployee( notExistEmployeeId, 404 );
        assertEquals( deletedEmployee.getStatus(), "Not Found" );
        assertEquals( deletedEmployee.getMessage(), "Employee with ID: " + notExistEmployeeId + " Not Found" );
    }
}
