package bg.example.football.service.rounds;

import bg.example.football.model.entities.RoundEntity;
import bg.example.football.model.service.RoundServiceModel;
import bg.example.football.model.view.RoundViewModel;

import java.util.List;

public interface RoundService {
    void create(RoundServiceModel roundServiceModel);
    void edit(RoundServiceModel roundServiceModel, String id);
    void remove(String id);
    List<RoundViewModel> getAll();
    RoundEntity getOneByName(String name);
    RoundViewModel getOneById(String id);
    List<RoundViewModel> getAllBySeasonId(String id);
}
