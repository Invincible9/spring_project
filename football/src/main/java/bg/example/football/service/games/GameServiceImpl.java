package bg.example.football.service.games;

import bg.example.football.model.entities.GameEntity;
import bg.example.football.model.entities.RoundEntity;
import bg.example.football.model.entities.TeamEntity;
import bg.example.football.model.service.GameServiceModel;
import bg.example.football.model.view.GameViewModel;
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
    public List<GameViewModel> getAll() {
        return this.gameRepository.findAll()
                .stream().map(gameEntity ->  this.modelMapper.map(gameEntity, GameViewModel.class))
                .collect(Collectors.toList());
    }



}
