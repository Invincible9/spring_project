package bg.example.football.service.divisions;

import bg.example.football.model.entities.DivisionEntity;
import bg.example.football.model.service.DivisionServiceModel;
import bg.example.football.model.view.DivisionViewModel;

import java.io.IOException;
import java.util.List;

public interface DivisionService {
    void create(DivisionServiceModel divisionServiceModel) throws IOException;
    void edit(DivisionServiceModel divisionServiceModel, String id) throws IOException;
    void remove(String id);
    List<DivisionViewModel> getAll();
    DivisionEntity getOneByName(String name);
    DivisionViewModel getOneById(String id);
    List<DivisionViewModel> getAllByNationalityId(String id);
}
