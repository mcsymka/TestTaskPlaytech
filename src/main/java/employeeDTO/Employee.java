
package employeeDTO;

import java.io.Serializable;
import java.util.Optional;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "data",
    "message"
})
@Generated("jsonschema2pojo")
public class Employee implements Serializable
{

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private DataEmployee data;
    @JsonProperty("message")
    private String message;
    private final static long serialVersionUID = -2289245934131164837L;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("data")
    public DataEmployee getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData( DataEmployee data) {
        this.data = data;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

}
