package itlix.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itlix.scheduler.domain.Scheduling;

/**
 * @author Andrey Franca 
 */
@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
}
