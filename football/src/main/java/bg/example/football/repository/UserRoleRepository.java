package bg.example.football.repository;

import bg.example.football.model.entities.UserRoleEntity;
import bg.example.football.model.entities.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, String> {
    Optional<UserRoleEntity> findByRole(UserRole role);
}
