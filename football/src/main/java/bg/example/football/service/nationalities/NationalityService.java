package bg.example.football.service.nationalities;


import bg.example.football.model.entities.NationalityEntity;
import bg.example.football.model.service.NationalityServiceModel;
import bg.example.football.model.view.NationalityViewModel;

import java.io.IOException;
import java.util.List;

public interface NationalityService {
    void create(NationalityServiceModel nationalityServiceModel) throws IOException;
    boolean edit(NationalityServiceModel nationalityServiceModel, String id) throws IOException;
    void remove(String id);
    List<NationalityViewModel> getAll();
    NationalityEntity getOneByName(String name);
    NationalityViewModel getOneById(String id);
}
