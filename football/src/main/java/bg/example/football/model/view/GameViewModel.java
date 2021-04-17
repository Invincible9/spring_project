package bg.example.football.model.view;

import bg.example.football.model.entities.enums.StatusName;

import java.time.LocalDate;

public class GameViewModel extends BaseViewModel {

    private TeamViewModel homeTeamViewModel;
    private TeamViewModel awayTeamViewModel;
    private LocalDate date;

    private Integer homeTeamGoals;
    private Integer awayTeamGoals;

    private String homeTeamScoreGoalsMinutes;
    private String awayTeamScoreGoalsMinutes;

    private String homeTeamAllowGoalsMinutes;
    private String awayTeamAllowGoalsMinutes;

    private Integer homeTeamCorners;
    private Integer awayTeamCorners;
    private Integer homeTeamShots;
    private Integer awayTeamShots;
    private Integer homeTeamCrosses;
    private Integer awayTeamCrosses;
    private Integer homeTeamCounters;
    private Integer awayTeamCounters;
    private Integer homeTeamPossession;
    private Integer awayTeamPossession;

    private String winner;
    private RoundViewModel roundViewModel;
    private StatusName status;

    public GameViewModel() {
    }

    public TeamViewModel getHomeTeamViewModel() {
        return homeTeamViewModel;
    }

    public GameViewModel setHomeTeamViewModel(TeamViewModel homeTeamViewModel) {
        this.homeTeamViewModel = homeTeamViewModel;
        return this;
    }

    public TeamViewModel getAwayTeamViewModel() {
        return awayTeamViewModel;
    }

    public GameViewModel setAwayTeamViewModel(TeamViewModel awayTeamViewModel) {
        this.awayTeamViewModel = awayTeamViewModel;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public GameViewModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Integer getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public GameViewModel setHomeTeamGoals(Integer homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
        return this;
    }

    public Integer getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public GameViewModel setAwayTeamGoals(Integer awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
        return this;
    }

    public String getHomeTeamScoreGoalsMinutes() {
        return homeTeamScoreGoalsMinutes;
    }

    public GameViewModel setHomeTeamScoreGoalsMinutes(String homeTeamScoreGoalsMinutes) {
        this.homeTeamScoreGoalsMinutes = homeTeamScoreGoalsMinutes;
        return this;
    }

    public String getAwayTeamScoreGoalsMinutes() {
        return awayTeamScoreGoalsMinutes;
    }

    public GameViewModel setAwayTeamScoreGoalsMinutes(String awayTeamScoreGoalsMinutes) {
        this.awayTeamScoreGoalsMinutes = awayTeamScoreGoalsMinutes;
        return this;
    }

    public String getHomeTeamAllowGoalsMinutes() {
        return homeTeamAllowGoalsMinutes;
    }

    public GameViewModel setHomeTeamAllowGoalsMinutes(String homeTeamAllowGoalsMinutes) {
        this.homeTeamAllowGoalsMinutes = homeTeamAllowGoalsMinutes;
        return this;
    }

    public String getAwayTeamAllowGoalsMinutes() {
        return awayTeamAllowGoalsMinutes;
    }

    public GameViewModel setAwayTeamAllowGoalsMinutes(String awayTeamAllowGoalsMinutes) {
        this.awayTeamAllowGoalsMinutes = awayTeamAllowGoalsMinutes;
        return this;
    }

    public Integer getHomeTeamCorners() {
        return homeTeamCorners;
    }

    public GameViewModel setHomeTeamCorners(Integer homeTeamCorners) {
        this.homeTeamCorners = homeTeamCorners;
        return this;
    }

    public Integer getAwayTeamCorners() {
        return awayTeamCorners;
    }

    public GameViewModel setAwayTeamCorners(Integer awayTeamCorners) {
        this.awayTeamCorners = awayTeamCorners;
        return this;
    }

    public Integer getHomeTeamShots() {
        return homeTeamShots;
    }

    public GameViewModel setHomeTeamShots(Integer homeTeamShots) {
        this.homeTeamShots = homeTeamShots;
        return this;
    }

    public Integer getAwayTeamShots() {
        return awayTeamShots;
    }

    public GameViewModel setAwayTeamShots(Integer awayTeamShots) {
        this.awayTeamShots = awayTeamShots;
        return this;
    }

    public Integer getHomeTeamCrosses() {
        return homeTeamCrosses;
    }

    public GameViewModel setHomeTeamCrosses(Integer homeTeamCrosses) {
        this.homeTeamCrosses = homeTeamCrosses;
        return this;
    }

    public Integer getAwayTeamCrosses() {
        return awayTeamCrosses;
    }

    public GameViewModel setAwayTeamCrosses(Integer awayTeamCrosses) {
        this.awayTeamCrosses = awayTeamCrosses;
        return this;
    }

    public Integer getHomeTeamCounters() {
        return homeTeamCounters;
    }

    public GameViewModel setHomeTeamCounters(Integer homeTeamCounters) {
        this.homeTeamCounters = homeTeamCounters;
        return this;
    }

    public Integer getAwayTeamCounters() {
        return awayTeamCounters;
    }

    public GameViewModel setAwayTeamCounters(Integer awayTeamCounters) {
        this.awayTeamCounters = awayTeamCounters;
        return this;
    }

    public Integer getHomeTeamPossession() {
        return homeTeamPossession;
    }

    public GameViewModel setHomeTeamPossession(Integer homeTeamPossession) {
        this.homeTeamPossession = homeTeamPossession;
        return this;
    }

    public Integer getAwayTeamPossession() {
        return awayTeamPossession;
    }

    public GameViewModel setAwayTeamPossession(Integer awayTeamPossession) {
        this.awayTeamPossession = awayTeamPossession;
        return this;
    }

    public String getWinner() {
        return winner;
    }

    public GameViewModel setWinner(String winner) {
        this.winner = winner;
        return this;
    }

    public RoundViewModel getRoundViewModel() {
        return roundViewModel;
    }

    public GameViewModel setRoundViewModel(RoundViewModel roundViewModel) {
        this.roundViewModel = roundViewModel;
        return this;
    }

    public StatusName getStatus() {
        return status;
    }

    public GameViewModel setStatus(StatusName status) {
        this.status = status;
        return this;
    }
}
