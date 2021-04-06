package bg.example.football.model.entities;

import bg.example.football.model.entities.enums.NationalityName;

import javax.persistence.*;

@Entity
@Table(name = "divisions")
public class DivisionEntity extends BaseEntity {
    private String name;
    private String logoUrl;
    private NationalityName nationality;

    public DivisionEntity() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "logo_url", columnDefinition = "text")
    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "nationality", nullable = false)
    public NationalityName getNationality() {
        return nationality;
    }

    public void setNationality(NationalityName nationality) {
        this.nationality = nationality;
    }
}
