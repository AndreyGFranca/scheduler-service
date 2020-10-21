package itlix.scheduler.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Andrey Franca 
 */
@Entity
@Table(name = "t_scheduling")
public class Scheduling extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "scheduling", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Property> properties = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    Status status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static final class Builder {
        private Scheduling scheduling;

        private Builder() {
            scheduling = new Scheduling();
        }

        public static Builder of() {
            return new Builder();
        }

        public Builder title(String title) {
            scheduling.setTitle(title);
            return this;
        }

        public Builder description(String description) {
            scheduling.setDescription(description);
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            scheduling.setStartDate(startDate);
            return this;
        }

        public Builder endDate(LocalDateTime endDate) {
            scheduling.setEndDate(endDate);
            return this;
        }

        public Builder properties(List<Property> properties) {
            scheduling.setProperties(properties);
            return this;
        }

        public Builder id(String id) {
            scheduling.setId(id);
            return this;
        }

        public Builder createdOn(LocalDateTime createdOn) {
            scheduling.setCreatedOn(createdOn);
            return this;
        }

        public Builder createdBy(String createdBy) {
            scheduling.setCreatedBy(createdBy);
            return this;
        }

        public Builder updatedOn(LocalDateTime updatedOn) {
            scheduling.setUpdatedOn(updatedOn);
            return this;
        }

        public Builder updatedBy(String updatedBy) {
            scheduling.setUpdatedBy(updatedBy);
            return this;
        }

        public Builder status(Status status) {
            scheduling.setStatus(status);
            return this;
        }

        public Scheduling build() {
            return scheduling;
        }
    }
}
