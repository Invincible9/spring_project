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


}
