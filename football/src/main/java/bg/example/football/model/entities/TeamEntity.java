package bg.example.football.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class TeamEntity extends BaseEntity {

    private String name;

}
