package starter.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import starter.model.entity.Information;

public interface InformationRepository extends JpaRepository<Information, Integer> {

}
