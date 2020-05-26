package CitatnikTests.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CitataModel {
    @JsonProperty(value = "citataId")
    private int citataId;
    @JsonProperty(value = "title")
    private String title;
    @JsonProperty(value = "content")
    private String content;
    @JsonProperty(value = "creationDate")
    private String creationDate;

    public int getCitataId() {
        return citataId;
    }
    public void setCitataId(int citataId) {
        this.citataId = citataId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getCretionDate() {
        return creationDate;
    }
    public void setCretionDate(String cretionDate) {
        this.creationDate = cretionDate;
    }
}

