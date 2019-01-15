package softunilabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softunilabs.entities.Lab;

@Repository
public interface LabRepository extends JpaRepository<Lab, Integer> {
}
