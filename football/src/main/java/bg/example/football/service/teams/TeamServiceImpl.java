package bg.example.football.service.teams;

import bg.example.football.model.entities.DivisionEntity;
import bg.example.football.model.entities.TeamEntity;
import bg.example.football.model.service.TeamServiceModel;
import bg.example.football.model.view.TeamViewModel;
import bg.example.football.repository.TeamRepository;
import bg.example.football.service.CloudinaryService;
import bg.example.football.service.divisions.DivisionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final DivisionService divisionService;
    private final CloudinaryService cloudinaryService;

    public TeamServiceImpl(TeamRepository teamRepository,
                           ModelMapper modelMapper,
                           DivisionService divisionService,
                           CloudinaryService cloudinaryService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.divisionService = divisionService;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public void create(TeamServiceModel teamServiceModel) throws IOException {
        TeamEntity team = this.modelMapper.map(teamServiceModel, TeamEntity.class);
        DivisionEntity division = this.divisionService.getOneByName(teamServiceModel.getDivisionName());
        team.setDivision(division);
        String url = this.cloudinaryService.uploadImage(teamServiceModel.getLogo());
        team.setLogoUrl(url);
        this.teamRepository.save(team);
    }

    @Override
    public List<TeamViewModel> getAll() {
        return this.teamRepository.findAll()
                .stream().map(teamEntity ->  this.modelMapper.map(teamEntity, TeamViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public TeamEntity getOneByName(String name) {
        return this.teamRepository.getOneByName(name).orElse(null);
    }
}
