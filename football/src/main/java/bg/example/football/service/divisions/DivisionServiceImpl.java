package bg.example.football.service.divisions;

import bg.example.football.model.entities.DivisionEntity;
import bg.example.football.model.entities.NationalityEntity;
import bg.example.football.model.service.DivisionServiceModel;
import bg.example.football.model.view.DivisionViewModel;
import bg.example.football.repository.DivisionRepository;
import bg.example.football.service.CloudinaryService;
import bg.example.football.service.nationalities.NationalityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DivisionServiceImpl implements DivisionService {
    private final DivisionRepository divisionRepository;
    private final NationalityService nationalityService;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;

    public DivisionServiceImpl(DivisionRepository divisionRepository,
                               NationalityService nationalityService,
                               CloudinaryService cloudinaryService,
                               ModelMapper modelMapper) {
        this.divisionRepository = divisionRepository;
        this.nationalityService = nationalityService;
        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(DivisionServiceModel divisionServiceModel) throws IOException {
        DivisionEntity divisionEntity =
                this.modelMapper.map(divisionServiceModel, DivisionEntity.class);
        NationalityEntity nationality =
                this.nationalityService.getOneByName(divisionServiceModel.getNationalityName());
        divisionEntity.setNationality(nationality);
        String url = this.cloudinaryService.uploadImage(divisionServiceModel.getLogo());
        divisionEntity.setLogoUrl(url);
        this.divisionRepository.save(divisionEntity);
    }

    @Override
    public List<DivisionViewModel> getAll() {
        return this.divisionRepository.findAll()
                .stream().map(divisionEntity ->
                        this.modelMapper.map(divisionEntity, DivisionViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public DivisionEntity getOneByName(String name) {
        return this.divisionRepository.findOneByName(name).orElse(null);
    }

    @Override
    public DivisionViewModel getOneById(String id) {
        return this.divisionRepository.findById(id).stream().map(divisionEntity ->
                this.modelMapper.map(divisionEntity, DivisionViewModel.class)
        ).findAny().orElse(null);
    }

    @Override
    public List<DivisionViewModel> getAllByNationalityId(String id) {
        return this.divisionRepository.findAllByNationalityId(id)
                .stream().map(divisionEntity ->
                        this.modelMapper.map(divisionEntity, DivisionViewModel.class))
                .collect(Collectors.toList());
    }
}
