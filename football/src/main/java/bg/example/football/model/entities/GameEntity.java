package bg.example.football.model.entities;

import bg.example.football.model.entities.enums.StatusName;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "games")
public class GameEntity extends BaseEntity {
    private TeamEntity homeTeam;
    private TeamEntity awayTeam;
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
    private RoundEntity roundEntity;
    private StatusName status;

    public GameEntity() {
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    public TeamEntity getHomeTeam() {
        return homeTeam;
    }

    public GameEntity setHomeTeam(TeamEntity homeTeam) {
        this.homeTeam = homeTeam;
        return this;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    public TeamEntity getAwayTeam() {
        return awayTeam;
    }

    public GameEntity setAwayTeam(TeamEntity awayTeam) {
        this.awayTeam = awayTeam;
        return this;
    }

    @Column(name = "date", nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public GameEntity setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Column(name = "home_team_goals", nullable = false)
    public Integer getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public GameEntity setHomeTeamGoals(Integer homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
        return this;
    }

    @Column(name = "away_team_goals", nullable = false)
    public Integer getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public GameEntity setAwayTeamGoals(Integer awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
        return this;
    }

    @Column(name = "home_team_score_goals_minutes")
    public String getHomeTeamScoreGoalsMinutes() {
        return homeTeamScoreGoalsMinutes;
    }

    public GameEntity setHomeTeamScoreGoalsMinutes(String homeTeamScoreGoalsMinutes) {
        this.homeTeamScoreGoalsMinutes = homeTeamScoreGoalsMinutes;
        return this;
    }

    @Column(name = "away_team_score_goals_minutes")
    public String getAwayTeamScoreGoalsMinutes() {
        return awayTeamScoreGoalsMinutes;
    }

    public GameEntity setAwayTeamScoreGoalsMinutes(String awayTeamScoreGoalsMinutes) {
        this.awayTeamScoreGoalsMinutes = awayTeamScoreGoalsMinutes;
        return this;
    }

    @Column(name = "home_team_allow_goals_minutes")
    public String getHomeTeamAllowGoalsMinutes() {
        return homeTeamAllowGoalsMinutes;
    }

    public GameEntity setHomeTeamAllowGoalsMinutes(String homeTeamAllowGoalsMinutes) {
        this.homeTeamAllowGoalsMinutes = homeTeamAllowGoalsMinutes;
        return this;
    }

    @Column(name = "away_team_allow_goals_minutes")
    public String getAwayTeamAllowGoalsMinutes() {
        return awayTeamAllowGoalsMinutes;
    }

    public GameEntity setAwayTeamAllowGoalsMinutes(String awayTeamAllowGoalsMinutes) {
        this.awayTeamAllowGoalsMinutes = awayTeamAllowGoalsMinutes;
        return this;
    }

    @Column(name = "home_team_corners", nullable = false)
    public Integer getHomeTeamCorners() {
        return homeTeamCorners;
    }

    public GameEntity setHomeTeamCorners(Integer homeTeamCorners) {
        this.homeTeamCorners = homeTeamCorners;
        return this;
    }

    @Column(name = "away_team_corners", nullable = false)
    public Integer getAwayTeamCorners() {
        return awayTeamCorners;
    }

    public GameEntity setAwayTeamCorners(Integer awayTeamCorners) {
        this.awayTeamCorners = awayTeamCorners;
        return this;
    }

    @Column(name = "home_team_shots", nullable = false)
    public Integer getHomeTeamShots() {
        return homeTeamShots;
    }

    public GameEntity setHomeTeamShots(Integer homeTeamShots) {
        this.homeTeamShots = homeTeamShots;
        return this;
    }

    @Column(name = "away_team_shots", nullable = false)
    public Integer getAwayTeamShots() {
        return awayTeamShots;
    }

    public GameEntity setAwayTeamShots(Integer awayTeamShots) {
        this.awayTeamShots = awayTeamShots;
        return this;
    }

    // бр. центрирания
    @Column(name = "home_team_crosses", nullable = false)
    public Integer getHomeTeamCrosses() {
        return homeTeamCrosses;
    }

    public GameEntity setHomeTeamCrosses(Integer homeTeamCrosses) {
        this.homeTeamCrosses = homeTeamCrosses;
        return this;
    }

    @Column(name = "away_team_crosses", nullable = false)
    public Integer getAwayTeamCrosses() {
        return awayTeamCrosses;
    }

    public GameEntity setAwayTeamCrosses(Integer awayTeamCrosses) {
        this.awayTeamCrosses = awayTeamCrosses;
        return this;
    }

    // бр. корнери
    @Column(name = "home_team_counters", nullable = false)
    public Integer getHomeTeamCounters() {
        return homeTeamCounters;
    }

    public GameEntity setHomeTeamCounters(Integer homeTeamCounters) {
        this.homeTeamCounters = homeTeamCounters;
        return this;
    }

    @Column(name = "away_team_counters", nullable = false)
    public Integer getAwayTeamCounters() {
        return awayTeamCounters;
    }

    public GameEntity setAwayTeamCounters(Integer awayTeamCounters) {
        this.awayTeamCounters = awayTeamCounters;
        return this;
    }

    // притежание на топката в проценти
    @Column(name = "home_team_possession", nullable = false)
    public Integer getHomeTeamPossession() {
        return homeTeamPossession;
    }

    public GameEntity setHomeTeamPossession(Integer homeTeamPossession) {
        this.homeTeamPossession = homeTeamPossession;
        return this;
    }

    @Column(name = "away_team_possession", nullable = false)
    public Integer getAwayTeamPossession() {
        return awayTeamPossession;
    }

    public GameEntity setAwayTeamPossession(Integer awayTeamPossession) {
        this.awayTeamPossession = awayTeamPossession;
        return this;
    }

    @Column(name = "winner", nullable = false)
    public String getWinner() {
        return winner;
    }

    public GameEntity setWinner(String winner) {
        this.winner = winner;
        return this;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    public RoundEntity getRoundEntity() {
        return roundEntity;
    }

    public GameEntity setRoundEntity(RoundEntity roundEntity) {
        this.roundEntity = roundEntity;
        return this;
    }

    @Column(name = "status", nullable = false)
    public StatusName getStatus() {
        return status;
    }

    public GameEntity setStatus(StatusName status) {
        this.status = status;
        return this;
    }
}