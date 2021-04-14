package bg.example.football.model.service;

import bg.example.football.model.entities.enums.StatusName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class GameServiceModel {
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

    public GameServiceModel() {
    }

    public String getHomeTeamNationality() {
        return homeTeamNationality;
    }

    public GameServiceModel setHomeTeamNationality(String homeTeamNationality) {
        this.homeTeamNationality = homeTeamNationality;
        return this;
    }

    public String getAwayTeamNationality() {
        return awayTeamNationality;
    }

    public GameServiceModel setAwayTeamNationality(String awayTeamNationality) {
        this.awayTeamNationality = awayTeamNationality;
        return this;
    }

    public String getHomeTeamDivision() {
        return homeTeamDivision;
    }

    public GameServiceModel setHomeTeamDivision(String homeTeamDivision) {
        this.homeTeamDivision = homeTeamDivision;
        return this;
    }

    public String getAwayTeamDivision() {
        return awayTeamDivision;
    }

    public GameServiceModel setAwayTeamDivision(String awayTeamDivision) {
        this.awayTeamDivision = awayTeamDivision;
        return this;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public GameServiceModel setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
        return this;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public GameServiceModel setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public GameServiceModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Integer getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public GameServiceModel setHomeTeamGoals(Integer homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
        return this;
    }

    public Integer getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public GameServiceModel setAwayTeamGoals(Integer awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
        return this;
    }

    public String getHomeTeamScoreGoalsMinutes() {
        return homeTeamScoreGoalsMinutes;
    }

    public GameServiceModel setHomeTeamScoreGoalsMinutes(String homeTeamScoreGoalsMinutes) {
        this.homeTeamScoreGoalsMinutes = homeTeamScoreGoalsMinutes;
        return this;
    }

    public String getAwayTeamScoreGoalsMinutes() {
        return awayTeamScoreGoalsMinutes;
    }

    public GameServiceModel setAwayTeamScoreGoalsMinutes(String awayTeamScoreGoalsMinutes) {
        this.awayTeamScoreGoalsMinutes = awayTeamScoreGoalsMinutes;
        return this;
    }

    public String getHomeTeamAllowGoalsMinutes() {
        return homeTeamAllowGoalsMinutes;
    }

    public GameServiceModel setHomeTeamAllowGoalsMinutes(String homeTeamAllowGoalsMinutes) {
        this.homeTeamAllowGoalsMinutes = homeTeamAllowGoalsMinutes;
        return this;
    }

    public String getAwayTeamAllowGoalsMinutes() {
        return awayTeamAllowGoalsMinutes;
    }

    public GameServiceModel setAwayTeamAllowGoalsMinutes(String awayTeamAllowGoalsMinutes) {
        this.awayTeamAllowGoalsMinutes = awayTeamAllowGoalsMinutes;
        return this;
    }

    public Integer getHomeTeamCorners() {
        return homeTeamCorners;
    }

    public GameServiceModel setHomeTeamCorners(Integer homeTeamCorners) {
        this.homeTeamCorners = homeTeamCorners;
        return this;
    }

    public Integer getAwayTeamCorners() {
        return awayTeamCorners;
    }

    public GameServiceModel setAwayTeamCorners(Integer awayTeamCorners) {
        this.awayTeamCorners = awayTeamCorners;
        return this;
    }

    public Integer getHomeTeamShots() {
        return homeTeamShots;
    }

    public GameServiceModel setHomeTeamShots(Integer homeTeamShots) {
        this.homeTeamShots = homeTeamShots;
        return this;
    }

    public Integer getAwayTeamShots() {
        return awayTeamShots;
    }

    public GameServiceModel setAwayTeamShots(Integer awayTeamShots) {
        this.awayTeamShots = awayTeamShots;
        return this;
    }

    public Integer getHomeTeamCrosses() {
        return homeTeamCrosses;
    }

    public GameServiceModel setHomeTeamCrosses(Integer homeTeamCrosses) {
        this.homeTeamCrosses = homeTeamCrosses;
        return this;
    }

    public Integer getAwayTeamCrosses() {
        return awayTeamCrosses;
    }

    public GameServiceModel setAwayTeamCrosses(Integer awayTeamCrosses) {
        this.awayTeamCrosses = awayTeamCrosses;
        return this;
    }

    public Integer getHomeTeamCounters() {
        return homeTeamCounters;
    }

    public GameServiceModel setHomeTeamCounters(Integer homeTeamCounters) {
        this.homeTeamCounters = homeTeamCounters;
        return this;
    }

    public Integer getAwayTeamCounters() {
        return awayTeamCounters;
    }

    public GameServiceModel setAwayTeamCounters(Integer awayTeamCounters) {
        this.awayTeamCounters = awayTeamCounters;
        return this;
    }

    public Integer getHomeTeamPossession() {
        return homeTeamPossession;
    }

    public GameServiceModel setHomeTeamPossession(Integer homeTeamPossession) {
        this.homeTeamPossession = homeTeamPossession;
        return this;
    }

    public Integer getAwayTeamPossession() {
        return awayTeamPossession;
    }

    public GameServiceModel setAwayTeamPossession(Integer awayTeamPossession) {
        this.awayTeamPossession = awayTeamPossession;
        return this;
    }

    public String getWinner() {
        return winner;
    }

    public GameServiceModel setWinner(String winner) {
        this.winner = winner;
        return this;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public GameServiceModel setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
        return this;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public GameServiceModel setDivisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public GameServiceModel setSeasonName(String seasonName) {
        this.seasonName = seasonName;
        return this;
    }

    public String getRoundName() {
        return roundName;
    }

    public GameServiceModel setRoundName(String roundName) {
        this.roundName = roundName;
        return this;
    }

    public StatusName getStatus() {
        return status;
    }

    public GameServiceModel setStatus(StatusName status) {
        this.status = status;
        return this;
    }
}
