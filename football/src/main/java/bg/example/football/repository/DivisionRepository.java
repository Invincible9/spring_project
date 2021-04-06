package bg.example.football.repository;

import bg.example.football.model.entities.DivisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<DivisionEntity, String> {
}
