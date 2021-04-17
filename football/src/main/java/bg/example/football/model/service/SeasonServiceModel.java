package bg.example.football.model.service;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class SeasonServiceModel {
    @Length(min = 3, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    private String name;

    @NotEmpty(message = "Enter valid division name!")
    private String divisionId;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public SeasonServiceModel() {
    }

    public String getName() {
        return name;
    }

    public SeasonServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public SeasonServiceModel setDivisionId(String divisionId) {
        this.divisionId = divisionId;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public SeasonServiceModel setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public SeasonServiceModel setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
}
