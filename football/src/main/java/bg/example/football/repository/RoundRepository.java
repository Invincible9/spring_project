package bg.example.football.repository;

import bg.example.football.model.entities.RoundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoundRepository extends JpaRepository<RoundEntity, String> {
    Optional<RoundEntity> findByName(String name);
}
