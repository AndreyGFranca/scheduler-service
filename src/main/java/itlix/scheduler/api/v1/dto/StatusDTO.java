package itlix.scheduler.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Andrey Franca 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusDTO {
    private String id;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
