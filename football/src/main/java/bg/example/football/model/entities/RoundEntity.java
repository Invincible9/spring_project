package bg.example.football.model.entities;

import bg.example.football.model.entities.enums.StatusName;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rounds")
public class RoundEntity extends BaseEntity {

    private String name;
    private SeasonEntity season;
    private StatusName status;
    private LocalDate startDate;
    private LocalDate endDate;

    public RoundEntity() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public RoundEntity setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    public SeasonEntity getSeason() {
        return season;
    }

    public RoundEntity setSeason(SeasonEntity season) {
        this.season = season;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public StatusName getStatus() {
        return status;
    }

    public RoundEntity setStatus(StatusName status) {
        this.status = status;
        return this;
    }

    @Column(name = "start_date")
    public LocalDate getStartDate() {
        return startDate;
    }

    public RoundEntity setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    @Column(name = "end_date")
    public LocalDate getEndDate() {
        return endDate;
    }

    public RoundEntity setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
}
