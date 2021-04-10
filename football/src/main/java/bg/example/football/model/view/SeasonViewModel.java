package bg.example.football.model.view;

import bg.example.football.model.entities.DivisionEntity;

import java.time.LocalDate;

public class SeasonViewModel {
    private String name;
    private DivisionEntity division;
    private LocalDate startDate;
    private LocalDate endDate;

    public SeasonViewModel() {
    }

    public String getName() {
        return name;
    }

    public SeasonViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public DivisionEntity getDivision() {
        return division;
    }

    public SeasonViewModel setDivision(DivisionEntity division) {
        this.division = division;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public SeasonViewModel setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public SeasonViewModel setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
}
