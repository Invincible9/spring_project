package bg.example.football.service.divisions;

import bg.example.football.model.entities.DivisionEntity;
import bg.example.football.model.service.DivisionServiceModel;
import bg.example.football.repository.DivisionRepository;
import bg.example.football.service.CloudinaryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    private final DivisionRepository divisionRepository;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;

    public DivisionServiceImpl(DivisionRepository divisionRepository,
                               CloudinaryService cloudinaryService,
                               ModelMapper modelMapper) {
        this.divisionRepository = divisionRepository;
        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(DivisionServiceModel divisionServiceModel) throws IOException {
        DivisionEntity divisionEntity =
                this.modelMapper.map(divisionServiceModel, DivisionEntity.class);
        String url = this.cloudinaryService.uploadImage(divisionServiceModel.getLogo());
        divisionEntity.setLogoUrl(url);
        this.divisionRepository.save(divisionEntity);
    }

    @Override
    public List<DivisionServiceModel> list() {
        return null;
    }
}
