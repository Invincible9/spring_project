package bg.example.football.model.view;

import bg.example.football.model.entities.enums.StatusName;

import java.time.LocalDate;

public class RoundViewModel {
    private String name;
    private SeasonViewModel seasonViewModel;
    private StatusName status;
    private LocalDate startDate;
    private LocalDate endDate;

    public RoundViewModel() {
    }

    public String getName() {
        return name;
    }

    public RoundViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public SeasonViewModel getSeasonViewModel() {
        return seasonViewModel;
    }

    public RoundViewModel setSeasonViewModel(SeasonViewModel seasonViewModel) {
        this.seasonViewModel = seasonViewModel;
        return this;
    }

    public StatusName getStatus() {
        return status;
    }

    public RoundViewModel setStatus(StatusName status) {
        this.status = status;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public RoundViewModel setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public RoundViewModel setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
}
