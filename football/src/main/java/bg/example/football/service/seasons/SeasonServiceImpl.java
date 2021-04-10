package bg.example.football.service.seasons;

import bg.example.football.model.entities.DivisionEntity;
import bg.example.football.model.entities.SeasonEntity;
import bg.example.football.model.service.SeasonServiceModel;
import bg.example.football.model.view.SeasonViewModel;
import bg.example.football.repository.SeasonRepository;
import bg.example.football.service.divisions.DivisionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository seasonRepository;
    private final DivisionService divisionService;
    private final ModelMapper modelMapper;

    public SeasonServiceImpl(SeasonRepository seasonRepository,
                             DivisionService divisionService,
                             ModelMapper modelMapper) {
        this.seasonRepository = seasonRepository;
        this.divisionService = divisionService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(SeasonServiceModel seasonServiceModel) {
        SeasonEntity seasonEntity = this.modelMapper.map(seasonServiceModel, SeasonEntity.class);
        DivisionEntity divisionEntity = this.divisionService.getOneByName(seasonServiceModel.getDivisionName());
        seasonEntity.setDivision(divisionEntity);
        this.seasonRepository.save(seasonEntity);
    }

    @Override
    public List<SeasonViewModel> getAll() {
        return this.seasonRepository.findAll()
                .stream().map(seasonEntity ->
                        this.modelMapper.map(seasonEntity, SeasonViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public SeasonEntity getOneByName(String name) {
        return this.seasonRepository.findByName(name).orElse(null);
    }
}
