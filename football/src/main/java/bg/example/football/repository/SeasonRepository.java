package bg.example.football.repository;

import bg.example.football.model.entities.SeasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<SeasonEntity, String> {
    Optional<SeasonEntity> findByName(String name);
    List<SeasonEntity> findAllByDivisionId(String id);
}
