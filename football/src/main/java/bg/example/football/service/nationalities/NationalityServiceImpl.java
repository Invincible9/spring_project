package bg.example.football.service.nationalities;

import bg.example.football.model.entities.NationalityEntity;
import bg.example.football.model.service.NationalityServiceModel;
import bg.example.football.model.view.NationalityViewModel;
import bg.example.football.repository.NationalityRepository;
import bg.example.football.service.CloudinaryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NationalityServiceImpl implements NationalityService {

    private final NationalityRepository nationalityRepository;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;

    public NationalityServiceImpl(NationalityRepository nationalityRepository,
                                  ModelMapper modelMapper, CloudinaryService cloudinaryService) {
        this.nationalityRepository = nationalityRepository;
        this.modelMapper = modelMapper;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public void create(NationalityServiceModel nationalityServiceModel) throws IOException {
        NationalityEntity nationalityEntity =
                this.modelMapper.map(nationalityServiceModel, NationalityEntity.class);
        String url = this.cloudinaryService.uploadImage(nationalityServiceModel.getLogo());
        nationalityEntity.setLogoUrl(url);
        this.nationalityRepository.save(nationalityEntity);
    }

    @Override
    public void edit(NationalityServiceModel nationalityServiceModel, int id) {

    }

    @Override
    public List<NationalityViewModel> getAll() {
        return this.nationalityRepository.findAll()
                .stream().map(nationalityEntity ->
                        this.modelMapper.map(nationalityEntity, NationalityViewModel.class))
                .collect(Collectors.toList());
    }
}
