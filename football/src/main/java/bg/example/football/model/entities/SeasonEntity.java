package bg.example.football.model.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "seasons")
public class SeasonEntity extends BaseEntity {
    private String name;
    private DivisionEntity division;
    private LocalDate startDate;
    private LocalDate endDate;

    public SeasonEntity() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public SeasonEntity setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    public DivisionEntity getDivision() {
        return division;
    }

    public SeasonEntity setDivision(DivisionEntity division) {
        this.division = division;
        return this;
    }

    @Column(name = "start_date", nullable = false)
    public LocalDate getStartDate() {
        return startDate;
    }

    public SeasonEntity setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    @Column(name = "end_date", nullable = false)
    public LocalDate getEndDate() {
        return endDate;
    }

    public SeasonEntity setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
}
