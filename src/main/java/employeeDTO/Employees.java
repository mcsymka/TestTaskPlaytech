
package employeeDTO;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "data"
})

public class Employees implements Serializable
{

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private List<DataEmployees> data = null;
    private final static long serialVersionUID = 2385348049623770601L;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("data")
    public List<DataEmployees> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<DataEmployees> data) {
        this.data = data;
    }

}
