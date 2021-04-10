package bg.example.football.service.rounds;

import bg.example.football.model.entities.RoundEntity;
import bg.example.football.model.entities.SeasonEntity;
import bg.example.football.model.service.RoundServiceModel;
import bg.example.football.model.view.RoundViewModel;
import bg.example.football.model.view.SeasonViewModel;
import bg.example.football.repository.RoundRepository;
import bg.example.football.service.seasons.SeasonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoundServiceImpl implements RoundService {

    private final RoundRepository roundRepository;
    private final SeasonService seasonService;
    private final ModelMapper modelMapper;

    public RoundServiceImpl(RoundRepository roundRepository,
                            SeasonService seasonService,
                            ModelMapper modelMapper) {
        this.roundRepository = roundRepository;
        this.seasonService = seasonService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(RoundServiceModel roundServiceModel) {
        RoundEntity roundEntity = this.modelMapper.map(roundServiceModel, RoundEntity.class);
        SeasonEntity seasonEntity = this.seasonService.getOneByName(roundServiceModel.getSeasonName());
        roundEntity.setSeason(seasonEntity);
        this.roundRepository.save(roundEntity);
    }

    @Override
    public List<RoundViewModel> getAll() {
        return this.roundRepository.findAll()
                .stream().map(roundEntity -> {
                    RoundViewModel roundViewModel = this.modelMapper.map(roundEntity, RoundViewModel.class);
                    SeasonViewModel seasonViewModel = this.seasonService.getOneById(roundEntity.getSeason().getId());
                    roundViewModel.setSeasonViewModel(seasonViewModel);
                    return roundViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public RoundEntity getOneByName(String name) {
        return this.roundRepository.findByName(name).orElse(null);
    }
}
