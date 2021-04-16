package bg.example.football.service.teams;

import bg.example.football.model.entities.TeamEntity;
import bg.example.football.model.service.TeamServiceModel;
import bg.example.football.model.view.TeamViewModel;

import java.io.IOException;
import java.util.List;

public interface TeamService {
    void create(TeamServiceModel teamServiceModel) throws IOException;
    void edit(TeamServiceModel teamServiceModel, String id) throws IOException;
    void remove(String id);
    List<TeamViewModel> getAll();
    TeamEntity getOneByName(String name);
    TeamViewModel getOneById(String id);
    List<TeamViewModel> getAllByDivisionId(String id);
}
