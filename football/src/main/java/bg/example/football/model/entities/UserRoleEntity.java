package bg.example.football.model.entities;

import bg.example.football.model.entities.enums.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {

    private UserRole role;

    @Enumerated(EnumType.STRING)
    public UserRole getRole() {
        return role;
    }

    public UserRoleEntity setRole(UserRole role) {
        this.role = role;
        return this;
    }

}