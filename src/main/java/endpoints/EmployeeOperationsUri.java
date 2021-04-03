package endpoints;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public enum EmployeeOperationsUri {

    EMPLOYEES( "/employees" ),
    EMPLOYEE( "/employee/" ),
    CREATE( "/create" ),
    UPDATE( "/update/" ),
    DELETE( "/delete/" ),
    ;

    private final String uri;

    EmployeeOperationsUri( String uri ) {
        this.uri = uri;
    }

    public URI getEmployee() {
        return UriBuilder.fromPath( uri ).build();
    }

    public URI getEmployeeById( int employeeId ) {
        return UriBuilder.fromPath( uri ).path( "{employeeId}" ).build( employeeId );
    }
}
