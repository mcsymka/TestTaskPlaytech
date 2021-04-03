
package employeeDTO;

import java.io.Serializable;
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

public class CreatedEmployee implements Serializable
{

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private CreatedDataEmployee data;
    @JsonProperty("message")
    private String message;
    private final static long serialVersionUID = -7330483897965355890L;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("data")
    public CreatedDataEmployee getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData( CreatedDataEmployee data) {
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
