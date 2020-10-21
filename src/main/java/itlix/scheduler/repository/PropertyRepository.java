package itlix.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itlix.scheduler.domain.Property;

/**
 * @author Andrey Franca 
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, String> {
}
