package itlix.scheduler.service.scheduling;


import java.time.ZoneId;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import itlix.scheduler.api.v1.dto.SchedulingDTO;
import itlix.scheduler.domain.Scheduling;
import itlix.scheduler.domain.Status;
import itlix.scheduler.repository.SchedulingRepository;

/**
 * @author Andrey Franca
 */
@Service
public class SchedulingService {

    private SchedulingRepository schedulingRepository;

    public SchedulingService(SchedulingRepository schedulingRepository) {
        this.schedulingRepository = schedulingRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Scheduling create(SchedulingDTO dto) {
        var scheduling = Scheduling.Builder.of()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .startDate(dto.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                .endDate(dto.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                .status(Status.PENDING)
                .build();
        return schedulingRepository.save(scheduling);
    }
}
