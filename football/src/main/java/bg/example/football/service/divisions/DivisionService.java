package bg.example.football.service.divisions;

import bg.example.football.model.entities.DivisionEntity;
import bg.example.football.model.service.DivisionServiceModel;
import bg.example.football.model.view.DivisionViewModel;

import java.io.IOException;
import java.util.List;

public interface DivisionService {
    void create(DivisionServiceModel divisionServiceModel) throws IOException;
    List<DivisionViewModel> getAll();
    DivisionEntity getOneByName(String name);
    List<DivisionViewModel> getAllByNationalityName(String name);
}
