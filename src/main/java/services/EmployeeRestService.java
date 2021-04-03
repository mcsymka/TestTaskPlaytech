package services;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import employeeDTO.*;
import endpoints.EmployeeOperationsUri;

import java.io.File;
import java.io.IOException;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;


public class EmployeeRestService extends RestAssuredRequests {

    private static ObjectMapper objectMapper = initializeMapper();
    private final RequestSpecification specification;

    public EmployeeRestService( String host ) {
        specification = new RequestSpecBuilder().setBaseUri( host )
                                                .setUrlEncodingEnabled( false )
                                                .build();
    }

    public void writeValueIntoJsonFile( File file, Object object ) {
        try {
            objectMapper.writeValue( file, object );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    private Object readValue( String body, Class valueType ) {
        Object object = new Object();
        try {
            object = objectMapper.readValue( body, valueType );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return object;
    }

    private static ObjectMapper initializeMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.setSerializationInclusion( JsonInclude.Include.NON_EMPTY );
        objectMapper.setVisibility( objectMapper.getSerializationConfig()
                                                .getDefaultVisibilityChecker()
                                                .withFieldVisibility( JsonAutoDetect.Visibility.DEFAULT ) );
        objectMapper.disable( WRITE_DATES_AS_TIMESTAMPS );
        objectMapper.disable( FAIL_ON_UNKNOWN_PROPERTIES );
        objectMapper.disable( FAIL_ON_IGNORED_PROPERTIES );
        return objectMapper;
    }

    public Employee getEmployeeById( int employeeId ) {
        return (Employee) readValue(
                executeGet(
                        specification,
                        EmployeeOperationsUri.EMPLOYEE.getEmployeeById( employeeId ),
                        200
                ),
                Employee.class
        );
    }

    public Employees getEmployees() {
        return (Employees) readValue(
                executeGet(
                        specification,
                        EmployeeOperationsUri.EMPLOYEES.getEmployee(),
                        200
                ),
                Employees.class
        );
    }

    public CreatedEmployee createEmployee( String name, String salary, String age ) {
        NewEmployee employee = new NewEmployee();
        employee.setName( name );
        employee.setSalary( salary );
        employee.setAge( age );
        return (CreatedEmployee) readValue(
                executePost(
                        specification,
                        EmployeeOperationsUri.CREATE.getEmployee(),
                        employee,
                        200
                ),
                CreatedEmployee.class
        );
    }

    public CreatedEmployee updateEmployee( String name, String salary, String age, int employeeId ) {
        NewEmployee employee = new NewEmployee();
        employee.setName( name );
        employee.setSalary( salary );
        employee.setAge( age );
        return (CreatedEmployee) readValue(
                executePut(
                        specification,
                        EmployeeOperationsUri.UPDATE.getEmployeeById( employeeId ),
                        employee,
                        200
                ),
                CreatedEmployee.class
        );
    }

    public DeletedEmployee deleteEmployee( int employeeId, int statusCode ) {
        return (DeletedEmployee) readValue(
                executeDelete(
                        specification,
                        EmployeeOperationsUri.DELETE.getEmployeeById( employeeId ),
                        statusCode
                ),
                DeletedEmployee.class
        );
    }
}