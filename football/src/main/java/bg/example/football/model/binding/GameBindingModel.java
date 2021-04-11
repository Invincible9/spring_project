package bg.example.football.model.binding;

import bg.example.football.model.entities.enums.StatusName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class GameBindingModel {

    @NotNull(message = "Enter valid nationality name!")
    private String homeTeamNationality;
    @NotNull(message = "Enter valid nationality name!")
    private String awayTeamNationality;

    @NotNull(message = "Enter valid division name!")
    private String homeTeamDivision;
    @NotNull(message = "Enter valid division name!")
    private String awayTeamDivision;

    @NotNull(message = "Enter valid team name!")
    private String homeTeam;

    @NotNull(message = "Enter valid team name!")
    private String awayTeam;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull
    private Integer homeTeamGoals;
    @NotNull
    private Integer awayTeamGoals;

    private String homeTeamScoreGoalsMinutes;
    private String awayTeamScoreGoalsMinutes;

    private String homeTeamAllowGoalsMinutes;
    private String awayTeamAllowGoalsMinutes;

    @NotNull
    private Integer homeTeamCorners;
    @NotNull
    private Integer awayTeamCorners;
    @NotNull
    private Integer homeTeamShots;
    @NotNull
    private Integer awayTeamShots;
    @NotNull
    private Integer homeTeamCrosses;
    @NotNull
    private Integer awayTeamCrosses;
    @NotNull
    private Integer homeTeamCounters;
    @NotNull
    private Integer awayTeamCounters;
    @NotNull
    private Integer homeTeamPossession;
    @NotNull
    private Integer awayTeamPossession;
    @NotNull
    private String winner;
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

    public GameBindingModel() {
    }

    public String getHomeTeamNationality() {
        return homeTeamNationality;
    }

    public GameBindingModel setHomeTeamNationality(String homeTeamNationality) {
        this.homeTeamNationality = homeTeamNationality;
        return this;
    }

    public String getAwayTeamNationality() {
        return awayTeamNationality;
    }

    public GameBindingModel setAwayTeamNationality(String awayTeamNationality) {
        this.awayTeamNationality = awayTeamNationality;
        return this;
    }

    public String getHomeTeamDivision() {
        return homeTeamDivision;
    }

    public GameBindingModel setHomeTeamDivision(String homeTeamDivision) {
        this.homeTeamDivision = homeTeamDivision;
        return this;
    }

    public String getAwayTeamDivision() {
        return awayTeamDivision;
    }

    public GameBindingModel setAwayTeamDivision(String awayTeamDivision) {
        this.awayTeamDivision = awayTeamDivision;
        return this;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public GameBindingModel setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
        return this;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public GameBindingModel setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public GameBindingModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Integer getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public GameBindingModel setHomeTeamGoals(Integer homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
        return this;
    }

    public Integer getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public GameBindingModel setAwayTeamGoals(Integer awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
        return this;
    }

    public String getHomeTeamScoreGoalsMinutes() {
        return homeTeamScoreGoalsMinutes;
    }

    public GameBindingModel setHomeTeamScoreGoalsMinutes(String homeTeamScoreGoalsMinutes) {
        this.homeTeamScoreGoalsMinutes = homeTeamScoreGoalsMinutes;
        return this;
    }

    public String getAwayTeamScoreGoalsMinutes() {
        return awayTeamScoreGoalsMinutes;
    }

    public GameBindingModel setAwayTeamScoreGoalsMinutes(String awayTeamScoreGoalsMinutes) {
        this.awayTeamScoreGoalsMinutes = awayTeamScoreGoalsMinutes;
        return this;
    }

    public String getHomeTeamAllowGoalsMinutes() {
        return homeTeamAllowGoalsMinutes;
    }

    public GameBindingModel setHomeTeamAllowGoalsMinutes(String homeTeamAllowGoalsMinutes) {
        this.homeTeamAllowGoalsMinutes = homeTeamAllowGoalsMinutes;
        return this;
    }

    public String getAwayTeamAllowGoalsMinutes() {
        return awayTeamAllowGoalsMinutes;
    }

    public GameBindingModel setAwayTeamAllowGoalsMinutes(String awayTeamAllowGoalsMinutes) {
        this.awayTeamAllowGoalsMinutes = awayTeamAllowGoalsMinutes;
        return this;
    }

    public Integer getHomeTeamCorners() {
        return homeTeamCorners;
    }

    public GameBindingModel setHomeTeamCorners(Integer homeTeamCorners) {
        this.homeTeamCorners = homeTeamCorners;
        return this;
    }

    public Integer getAwayTeamCorners() {
        return awayTeamCorners;
    }

    public GameBindingModel setAwayTeamCorners(Integer awayTeamCorners) {
        this.awayTeamCorners = awayTeamCorners;
        return this;
    }

    public Integer getHomeTeamShots() {
        return homeTeamShots;
    }

    public GameBindingModel setHomeTeamShots(Integer homeTeamShots) {
        this.homeTeamShots = homeTeamShots;
        return this;
    }

    public Integer getAwayTeamShots() {
        return awayTeamShots;
    }

    public GameBindingModel setAwayTeamShots(Integer awayTeamShots) {
        this.awayTeamShots = awayTeamShots;
        return this;
    }

    public Integer getHomeTeamCrosses() {
        return homeTeamCrosses;
    }

    public GameBindingModel setHomeTeamCrosses(Integer homeTeamCrosses) {
        this.homeTeamCrosses = homeTeamCrosses;
        return this;
    }

    public Integer getAwayTeamCrosses() {
        return awayTeamCrosses;
    }

    public GameBindingModel setAwayTeamCrosses(Integer awayTeamCrosses) {
        this.awayTeamCrosses = awayTeamCrosses;
        return this;
    }

    public Integer getHomeTeamCounters() {
        return homeTeamCounters;
    }

    public GameBindingModel setHomeTeamCounters(Integer homeTeamCounters) {
        this.homeTeamCounters = homeTeamCounters;
        return this;
    }

    public Integer getAwayTeamCounters() {
        return awayTeamCounters;
    }

    public GameBindingModel setAwayTeamCounters(Integer awayTeamCounters) {
        this.awayTeamCounters = awayTeamCounters;
        return this;
    }

    public Integer getHomeTeamPossession() {
        return homeTeamPossession;
    }

    public GameBindingModel setHomeTeamPossession(Integer homeTeamPossession) {
        this.homeTeamPossession = homeTeamPossession;
        return this;
    }

    public Integer getAwayTeamPossession() {
        return awayTeamPossession;
    }

    public GameBindingModel setAwayTeamPossession(Integer awayTeamPossession) {
        this.awayTeamPossession = awayTeamPossession;
        return this;
    }

    public String getWinner() {
        return winner;
    }

    public GameBindingModel setWinner(String winner) {
        this.winner = winner;
        return this;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public GameBindingModel setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
        return this;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public GameBindingModel setDivisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public GameBindingModel setSeasonName(String seasonName) {
        this.seasonName = seasonName;
        return this;
    }

    public String getRoundName() {
        return roundName;
    }

    public GameBindingModel setRoundName(String roundName) {
        this.roundName = roundName;
        return this;
    }

    public StatusName getStatus() {
        return status;
    }

    public GameBindingModel setStatus(StatusName status) {
        this.status = status;
        return this;
    }
}
