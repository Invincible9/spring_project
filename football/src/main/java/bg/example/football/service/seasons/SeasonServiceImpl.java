package bg.example.football.service.seasons;

import bg.example.football.model.entities.DivisionEntity;
import bg.example.football.model.entities.SeasonEntity;
import bg.example.football.model.service.SeasonServiceModel;
import bg.example.football.model.view.DivisionViewModel;
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
        DivisionEntity divisionEntity = this.modelMapper.map(this.divisionService.getOneById(seasonServiceModel.getDivisionId()), DivisionEntity.class);
        seasonEntity.setDivision(divisionEntity);
        this.seasonRepository.save(seasonEntity);
    }

    @Override
    public void edit(SeasonServiceModel seasonServiceModel, String id) {
        SeasonEntity seasonEntity = this.modelMapper.map(seasonServiceModel, SeasonEntity.class);
        DivisionEntity divisionEntity = this.modelMapper.map(this.divisionService.getOneById(seasonServiceModel.getDivisionId()),
                        DivisionEntity.class);
        seasonEntity.setDivision(divisionEntity);
        seasonEntity.setId(id);
        this.seasonRepository.save(seasonEntity);
    }

    @Override
    public void remove(String id) {
        this.seasonRepository.deleteById(id);
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

    @Override
    public SeasonViewModel getOneById(String id) {
        return this.seasonRepository.findById(id)
                .stream().map(seasonEntity -> {
                    SeasonViewModel seasonViewModel = this.modelMapper.map(seasonEntity, SeasonViewModel.class);
                    DivisionViewModel divisionViewModel = this.divisionService.getOneById(seasonEntity.getDivision().getId());
                    seasonViewModel.setDivision(divisionViewModel);
                    return seasonViewModel;
                })
                .findFirst().orElse(null);
    }

    @Override
    public List<SeasonViewModel> getAllByDivisionId(String id) {
        return this.seasonRepository.findAllByDivisionId(id)
                .stream().map(seasonEntity -> {
                    SeasonViewModel seasonViewModel =  this.modelMapper.map(seasonEntity, SeasonViewModel.class);
                    DivisionViewModel divisionEntity = this.divisionService.getOneById(id);
                    seasonViewModel.setDivision(divisionEntity);
                    return seasonViewModel;
                })
                .collect(Collectors.toList());
    }
}
