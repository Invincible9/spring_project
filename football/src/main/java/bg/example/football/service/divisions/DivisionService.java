package bg.example.football.service.divisions;

import bg.example.football.model.service.DivisionServiceModel;

import java.io.IOException;
import java.util.List;

public interface DivisionService {
    void create(DivisionServiceModel divisionServiceModel) throws IOException;
    List<DivisionServiceModel> list();
}
