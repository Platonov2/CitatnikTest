package CitatnikTests.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorModel {
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "title")
    private String title;
    @JsonProperty(value = "status")
    private String status;
    @JsonProperty(value = "traceId")
    private String traceId;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getTraceId() {
        return traceId;
    }
    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
