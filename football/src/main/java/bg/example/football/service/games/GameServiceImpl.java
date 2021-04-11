package bg.example.football.service.games;

import bg.example.football.model.entities.GameEntity;
import bg.example.football.model.service.GameServiceModel;
import bg.example.football.model.view.GameViewModel;
import bg.example.football.repository.GameRepository;
import bg.example.football.service.rounds.RoundService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final RoundService roundService;

    public GameServiceImpl(GameRepository gameRepository,
                           ModelMapper modelMapper,
                           RoundService roundService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.roundService = roundService;
    }

    @Override
    public void create(GameServiceModel gameServiceModel) {
        GameEntity gameEntity = this.modelMapper.map(gameServiceModel, GameEntity.class);
//        RoundEntity roundEntity = this.roundService.getOneByName(gameServiceModel)
    }

    @Override
    public List<GameViewModel> getAll() {
        return this.gameRepository.findAll()
                .stream().map(gameEntity ->  this.modelMapper.map(gameEntity, GameViewModel.class))
                .collect(Collectors.toList());
    }



}
