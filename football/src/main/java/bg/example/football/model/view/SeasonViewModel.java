package bg.example.football.model.view;

import java.time.LocalDate;

public class SeasonViewModel extends BaseViewModel {
    private String name;
    private DivisionViewModel division;
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

    public DivisionViewModel getDivision() {
        return division;
    }

    public SeasonViewModel setDivision(DivisionViewModel division) {
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
