package bg.example.football.repository;

import bg.example.football.model.entities.NationalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NationalityRepository extends JpaRepository<NationalityEntity, String> {
    Optional<NationalityEntity> findByName(String name);
}
