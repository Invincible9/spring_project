package bg.example.football.model.service;

import bg.example.football.model.entities.enums.StatusName;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RoundServiceModel {

    @Length(min = 3, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String name;

    @NotEmpty(message = "Enter valid season name!")
    private String seasonId;

    @NotNull(message = "Enter valid status name!")
    private StatusName status;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public RoundServiceModel() {
    }

    public String getName() {
        return name;
    }

    public RoundServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getSeasonId() {
        return seasonId;
    }

    public RoundServiceModel setSeasonId(String seasonId) {
        this.seasonId = seasonId;
        return this;
    }

    public StatusName getStatus() {
        return status;
    }

    public RoundServiceModel setStatus(StatusName status) {
        this.status = status;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public RoundServiceModel setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public RoundServiceModel setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
}
