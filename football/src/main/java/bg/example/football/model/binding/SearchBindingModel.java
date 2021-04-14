package bg.example.football.model.binding;

import bg.example.football.model.entities.enums.StatusName;

import javax.validation.constraints.NotNull;

public class SearchBindingModel {
    @NotNull
    private String nationalityName;
    @NotNull
    private String divisionName;
    @NotNull
    private String seasonName;
    @NotNull
    private String roundName;

    @NotNull(message = "Enter valid status name!")
    private StatusName status;

    public SearchBindingModel() {
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public SearchBindingModel setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
        return this;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public SearchBindingModel setDivisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public SearchBindingModel setSeasonName(String seasonName) {
        this.seasonName = seasonName;
        return this;
    }

    public String getRoundName() {
        return roundName;
    }

    public SearchBindingModel setRoundName(String roundName) {
        this.roundName = roundName;
        return this;
    }

    public StatusName getStatus() {
        return status;
    }

    public SearchBindingModel setStatus(StatusName status) {
        this.status = status;
        return this;
    }
}
