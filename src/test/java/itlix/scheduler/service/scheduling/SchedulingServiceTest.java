package itlix.scheduler.service.scheduling;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import itlix.scheduler.api.v1.dto.SchedulingDTO;
import itlix.scheduler.domain.Scheduling;
import itlix.scheduler.domain.Status;
import itlix.scheduler.repository.SchedulingRepository;

/**
 * @author Andrey Franca 
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("SCHEDULING TESTS")
class SchedulingServiceTest {

    @InjectMocks
    private SchedulingService schedulingService;

    @Mock
    private SchedulingRepository schedulingRepository;

    @Test
    @Tag("scheduling")
    @DisplayName("When create a new scheduling then assert that was created")
    public void testCreateNewScheduling() {
        // arrange
        var id = UUID.randomUUID().toString();
        var startDate = LocalDateTime.now();
        var endDate = LocalDateTime.from(LocalDateTime.now().plusDays(3));
        var dto = buildSchedulingDTO(id, startDate, endDate);

        when(schedulingRepository.save(any(Scheduling.class))).thenReturn(buildScheduling(id, startDate, endDate));

        // act
        var scheduling = schedulingService.create(dto);

        // assert
        assertThat(scheduling).isNotNull();
        assertThat(scheduling.getId()).isEqualTo(dto.getId());
        assertThat(scheduling.getStatus()).isEqualTo(Status.PENDING);
    }

    @Test
    @Tag("scheduling")
    @DisplayName("When creating a schedule with another one at the same time then throw an exception")
    public void testCreateSchedulingWithSameTime() {
        // arrange

        // act

        // assert

    }

    private Scheduling buildScheduling(String id, LocalDateTime startDate, LocalDateTime endDate) {
        var scheduling = Scheduling.Builder.of()
                .id(id)
                .startDate(startDate)
                .endDate(endDate)
                .title("Simple 1")
                .description("This is a simple schedule")
                .build();
        return scheduling;
    }

    private SchedulingDTO buildSchedulingDTO(String id, LocalDateTime startDate, LocalDateTime endDate) {
        var dto = new SchedulingDTO();
        dto.setId(id);
        dto.setStartDate(Date.from(startDate.atZone(ZoneId.systemDefault()).toInstant()));
        dto.setEndDate(Date.from(endDate.atZone(ZoneId.systemDefault()).toInstant()));
        dto.setTitle("Simple 1");
        dto.setDescription("This is a simple schedule");
        return dto;
    }

}