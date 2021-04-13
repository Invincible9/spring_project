package bg.example.football.repository;

import bg.example.football.model.entities.DivisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DivisionRepository extends JpaRepository<DivisionEntity, String> {
    Optional<DivisionEntity> findOneByName(String name);
    List<DivisionEntity> findAllByNationalityId(String name);
}
