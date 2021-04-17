package bg.example.football.service.games;

import bg.example.football.model.entities.GameEntity;
import bg.example.football.model.entities.RoundEntity;
import bg.example.football.model.entities.TeamEntity;
import bg.example.football.model.service.GameServiceModel;
import bg.example.football.model.view.GameViewModel;
import bg.example.football.model.view.RoundViewModel;
import bg.example.football.model.view.TeamViewModel;
import bg.example.football.repository.GameRepository;
import bg.example.football.service.rounds.RoundService;
import bg.example.football.service.teams.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final RoundService roundService;
    private final TeamService teamService;

    public GameServiceImpl(GameRepository gameRepository,
                           ModelMapper modelMapper,
                           RoundService roundService, TeamService teamService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.roundService = roundService;
        this.teamService = teamService;
    }

    @Override
    public void create(GameServiceModel gameServiceModel) {
        GameEntity gameEntity = this.modelMapper.map(gameServiceModel, GameEntity.class);
        TeamEntity homeTeam = this.modelMapper.map(this.teamService.getOneById(gameServiceModel.getHomeTeam()), TeamEntity.class);
        TeamEntity awayTeam = this.modelMapper.map(this.teamService.getOneById(gameServiceModel.getAwayTeam()), TeamEntity.class);
        RoundEntity round = this.modelMapper.map(this.roundService.getOneById(gameServiceModel.getRoundName()), RoundEntity.class);
        gameEntity.setHomeTeam(homeTeam);
        gameEntity.setAwayTeam(awayTeam);
        gameEntity.setRoundEntity(round);
        this.gameRepository.save(gameEntity);
    }

    @Override
    public void edit(GameServiceModel gameServiceModel, String id) {
        GameEntity gameEntity = this.gameRepository.findById(id).orElse(null);
        TeamEntity homeTeam = this.modelMapper.map(this.teamService.getOneById(gameServiceModel.getHomeTeam()), TeamEntity.class);
        TeamEntity awayTeam = this.modelMapper.map(this.teamService.getOneById(gameServiceModel.getAwayTeam()), TeamEntity.class);
        RoundEntity round = this.modelMapper.map(this.roundService.getOneById(gameServiceModel.getRoundName()), RoundEntity.class);
        this.modelMapper.map(gameServiceModel, gameEntity);
        gameEntity.setHomeTeam(homeTeam);
        gameEntity.setAwayTeam(awayTeam);
        gameEntity.setRoundEntity(round);
        gameEntity.setId(id);
        this.gameRepository.save(gameEntity);
    }

    @Override
    public void remove(String id) {
        this.gameRepository.deleteById(id);
    }

    @Override
    public List<GameViewModel> getAll() {
        return this.gameRepository.findAll()
                .stream().map(gameEntity -> {
                    GameViewModel gameViewModel = this.modelMapper.map(gameEntity, GameViewModel.class);
                    RoundViewModel roundViewModel = this.roundService.getOneById(gameEntity.getRoundEntity().getId());
                    TeamViewModel homeTeamViewModel = this.teamService.getOneById(gameEntity.getHomeTeam().getId());
                    TeamViewModel awayTeamViewModel = this.teamService.getOneById(gameEntity.getAwayTeam().getId());
                    gameViewModel.setRoundViewModel(roundViewModel);
                    gameViewModel.setHomeTeamViewModel(homeTeamViewModel);
                    gameViewModel.setAwayTeamViewModel(awayTeamViewModel);
                    return gameViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public GameViewModel getOneById(String id) {
        return this.gameRepository.findById(id)
                .stream().map(gameEntity -> {
                    GameViewModel gameViewModel = this.modelMapper.map(gameEntity, GameViewModel.class);
                    RoundViewModel roundViewModel = this.roundService.getOneById(gameEntity.getRoundEntity().getId());
                    TeamViewModel homeTeamViewModel = this.teamService.getOneById(gameEntity.getHomeTeam().getId());
                    TeamViewModel awayTeamViewModel = this.teamService.getOneById(gameEntity.getAwayTeam().getId());
                    gameViewModel.setRoundViewModel(roundViewModel);
                    gameViewModel.setHomeTeamViewModel(homeTeamViewModel);
                    gameViewModel.setAwayTeamViewModel(awayTeamViewModel);
                    return gameViewModel;
                })
                .findFirst().orElse(null);
    }


}
