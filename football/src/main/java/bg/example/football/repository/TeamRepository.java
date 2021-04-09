package bg.example.football.repository;

import bg.example.football.model.entities.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, String> {
    Optional<TeamEntity> getOneByName(String name);
}
