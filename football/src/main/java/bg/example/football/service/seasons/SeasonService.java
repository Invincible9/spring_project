package bg.example.football.service.seasons;

import bg.example.football.model.entities.SeasonEntity;
import bg.example.football.model.service.SeasonServiceModel;
import bg.example.football.model.view.SeasonViewModel;

import java.util.List;

public interface SeasonService {
    void create(SeasonServiceModel seasonServiceModel);
    void edit(SeasonServiceModel seasonServiceModel, String id);
    void remove(String id);
    List<SeasonViewModel> getAll();
    SeasonEntity getOneByName(String name);
    SeasonViewModel getOneById(String id);
    List<SeasonViewModel> getAllByDivisionId(String id);
}
