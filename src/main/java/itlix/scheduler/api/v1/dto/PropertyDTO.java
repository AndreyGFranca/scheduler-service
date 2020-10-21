package itlix.scheduler.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Andrey Franca 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyDTO {
    private String id;
    private String key;
    private String value;
    private String schedulingId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSchedulingId() {
        return schedulingId;
    }

    public void setSchedulingId(String schedulingId) {
        this.schedulingId = schedulingId;
    }
}
