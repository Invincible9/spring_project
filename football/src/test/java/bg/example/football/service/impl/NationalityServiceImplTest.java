package bg.example.football.service.impl;

import bg.example.football.model.entities.NationalityEntity;
import bg.example.football.model.view.NationalityViewModel;
import bg.example.football.repository.NationalityRepository;
import bg.example.football.service.CloudinaryService;
import bg.example.football.service.nationalities.NationalityServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NationalityServiceImplTest {

    private NationalityEntity testNationalityEntity1, testNationalityEntity2;

    private NationalityServiceImpl serviceToTest;

    @Mock
    NationalityRepository mockNationalityRepository;

    @Mock
    CloudinaryService cloudinaryServiceToTest;

    @BeforeEach
    public void init() {
        testNationalityEntity1 = new NationalityEntity();
        testNationalityEntity1.setId("nat1");
        testNationalityEntity1.setName("nationality1");
        testNationalityEntity1.setLogoUrl("image 1");

        testNationalityEntity2 = new NationalityEntity();
        testNationalityEntity2.setId("nat2");
        testNationalityEntity2.setName("nationality2");
        testNationalityEntity2.setLogoUrl("image 2");

        serviceToTest = new NationalityServiceImpl(mockNationalityRepository, new ModelMapper(), cloudinaryServiceToTest);
    }

    @Test
    public void testFindAll() {

        when(mockNationalityRepository.findAll()).thenReturn(List.of(testNationalityEntity1, testNationalityEntity2));

        List<NationalityViewModel> allModels = serviceToTest.getAll();

        Assertions.assertEquals(2, allModels.size());

        NationalityViewModel model1 = allModels.get(0);
        NationalityViewModel model2 = allModels.get(1);

        // verify model 1
        Assertions.assertEquals(testNationalityEntity1.getName(), model1.getName());
        Assertions.assertEquals(testNationalityEntity1.getLogoUrl(), model1.getLogoUrl());

        // verify model 2
        Assertions.assertEquals(testNationalityEntity2.getName(), model2.getName());
        Assertions.assertEquals(testNationalityEntity2.getLogoUrl(), model2.getLogoUrl());
    }

    @Test
    void testFoundOneId() {
        when(mockNationalityRepository.findById(testNationalityEntity1.getId())).thenReturn(Optional.of(testNationalityEntity1));

        NationalityViewModel nationalityViewOpt = serviceToTest.getOneById(testNationalityEntity1.getId());

        Assertions.assertEquals(testNationalityEntity1.getName(), nationalityViewOpt.getName());
        Assertions.assertEquals(testNationalityEntity1.getLogoUrl(), nationalityViewOpt.getLogoUrl());
    }

    @Test
    void testFoundOneByName() {
        when(mockNationalityRepository.findById(testNationalityEntity1.getName())).thenReturn(Optional.of(testNationalityEntity1));

        NationalityViewModel nationalityViewOpt = serviceToTest.getOneById(testNationalityEntity1.getName());

        Assertions.assertEquals(testNationalityEntity1.getName(), nationalityViewOpt.getName());
        Assertions.assertEquals(testNationalityEntity1.getLogoUrl(), nationalityViewOpt.getLogoUrl());
    }

}
