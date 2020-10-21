package itlix.scheduler.api.v1.resource;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import itlix.scheduler.api.v1.dto.SchedulingDTO;

/**
 * @author Andrey Franca 
 */
@DisplayName("SCHEDULING INTEGRATION TESTS")
class SchedulingResourceIT extends SchedulerBaseIT {

    @Test
    @Tag("schedulerIT")
    @DisplayName("When create a new scheduling then assert that was created")
    public void testCreateSchedulingResource() {
        var scheduling = new SchedulingDTO();
        scheduling.setTitle("Hello");
        scheduling.setDescription("simple desc");
        scheduling.setEndDate(new Date());
        scheduling.setStartDate(new Date());
        scheduling.setId(UUID.randomUUID().toString());

        given()
                .body(scheduling)
                .contentType("application/json")
                .when()
                .post("/api/v1/scheduling")
                .then()
                .assertThat()
                .statusCode(201)
                .body("title", equalTo("Hello"))
                .body("description", equalTo("simple desc"));
    }


}