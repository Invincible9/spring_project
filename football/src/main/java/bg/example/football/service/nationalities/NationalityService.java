package bg.example.football.service.nationalities;


import bg.example.football.model.service.NationalityServiceModel;
import bg.example.football.model.view.NationalityViewModel;

import java.io.IOException;
import java.util.List;

public interface NationalityService {
    void create(NationalityServiceModel nationalityServiceModel) throws IOException;
    void edit(NationalityServiceModel nationalityServiceModel, int id);
    List<NationalityViewModel> getAll();

}
