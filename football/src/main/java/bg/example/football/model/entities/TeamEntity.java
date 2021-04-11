package bg.example.football.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class TeamEntity extends BaseEntity {

    private String name;
    private String logoUrl;
    private DivisionEntity division;

    public TeamEntity() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "logo_url")
    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    public DivisionEntity getDivision() {
        return division;
    }

    public void setDivision(DivisionEntity division) {
        this.division = division;
    }
}
