import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LogElement {
    @JsonProperty
    private String date;
    @JsonProperty
    private String operation;
    @JsonProperty
    private String status;

    @JsonCreator
    public LogElement(@JsonProperty("Date")String date, @JsonProperty("Operation")String operation, @JsonProperty("Status")String status) {
        this.date = date;
        this.operation = operation;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + date + "]["+operation+"]["+status+"]";
    }
}
