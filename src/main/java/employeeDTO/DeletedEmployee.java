
package employeeDTO;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "data",
    "message",
    "code",
    "errors"
})

public class DeletedEmployee implements Serializable
{

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private String data;
    @JsonProperty("message")
    private String message;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("errors")
    private String errors;
    private final static long serialVersionUID = -3283709655852665360L;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("data")
    public String getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(String data) {
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

    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonProperty("errors")
    public String getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(String errors) {
        this.errors = errors;
    }

}
