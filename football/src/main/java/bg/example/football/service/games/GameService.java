package bg.example.football.service.games;

import bg.example.football.model.service.GameServiceModel;
import bg.example.football.model.view.GameViewModel;

import java.util.List;

public interface GameService {
    void create(GameServiceModel gameServiceModel);
    void edit(GameServiceModel gameServiceModel, String id);
    void remove(String id);
    List<GameViewModel> getAll();
    GameViewModel getOneById(String id);
}
