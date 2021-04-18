package bg.example.football.service.impl;

import bg.example.football.model.entities.DivisionEntity;
import bg.example.football.model.entities.NationalityEntity;
import bg.example.football.model.view.DivisionViewModel;
import bg.example.football.repository.DivisionRepository;
import bg.example.football.service.CloudinaryService;
import bg.example.football.service.divisions.DivisionServiceImpl;
import bg.example.football.service.nationalities.NationalityService;
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
public class DivisionServiceImplTest {

    private NationalityEntity testNationalityEntity1, testNationalityEntity2;
    private DivisionEntity divisionEntity1, divisionEntity2;

    private DivisionServiceImpl serviceToTest;

    @Mock
    DivisionRepository mockDivisionRepository;

    @Mock
    CloudinaryService cloudinaryServiceToTest;

    @Mock
    NationalityService mockNationalityServiceToTest;

    @BeforeEach
    public void init() {
        testNationalityEntity1 = new NationalityEntity();
        testNationalityEntity1.setId("nat1");
        testNationalityEntity1.setName("nationality1");
        testNationalityEntity1.setLogoUrl("image 1");

        divisionEntity1 = new DivisionEntity();
        divisionEntity1.setName("divisionName");
        divisionEntity1.setLogoUrl("divisionImg");
        divisionEntity1.setNationality(testNationalityEntity1);

        testNationalityEntity2 = new NationalityEntity();
        testNationalityEntity2.setId("nat2");
        testNationalityEntity2.setName("nationality2");
        testNationalityEntity2.setLogoUrl("image 2");

        divisionEntity2 = new DivisionEntity();
        divisionEntity2.setName("divisionName2");
        divisionEntity2.setLogoUrl("divisionImg2");
        divisionEntity2.setNationality(testNationalityEntity2);

        serviceToTest = new DivisionServiceImpl(mockDivisionRepository,mockNationalityServiceToTest,
                cloudinaryServiceToTest, new ModelMapper());
    }

    @Test
    public void testFindAll() {

        when(mockDivisionRepository.findAll()).thenReturn(List.of(divisionEntity1, divisionEntity2));

        List<DivisionViewModel> allModels = serviceToTest.getAll();

        Assertions.assertEquals(2, allModels.size());

        DivisionViewModel model1 = allModels.get(0);
        DivisionViewModel model2 = allModels.get(1);

        // verify model 1
        Assertions.assertEquals(divisionEntity1.getName(), model1.getName());
        Assertions.assertEquals(divisionEntity1.getLogoUrl(), model1.getLogoUrl());

        // verify model 2
        Assertions.assertEquals(divisionEntity2.getName(), model2.getName());
        Assertions.assertEquals(divisionEntity2.getLogoUrl(), model2.getLogoUrl());
    }

    @Test
    void testFoundOneId() {
        when(mockDivisionRepository.findById(divisionEntity1.getId())).thenReturn(Optional.of(divisionEntity1));

        DivisionViewModel divisionViewModel = serviceToTest.getOneById(divisionEntity1.getId());

        Assertions.assertEquals(divisionEntity1.getName(), divisionViewModel.getName());
        Assertions.assertEquals(divisionEntity1.getLogoUrl(), divisionViewModel.getLogoUrl());
    }

    @Test
    void testFoundOneByName() {
        when(mockDivisionRepository.findById(divisionEntity1.getName())).thenReturn(Optional.of(divisionEntity1));

        DivisionViewModel divisionViewModel = serviceToTest.getOneById(divisionEntity1.getName());

        Assertions.assertEquals(divisionEntity1.getName(), divisionViewModel.getName());
        Assertions.assertEquals(divisionEntity1.getLogoUrl(), divisionViewModel.getLogoUrl());
    }

}
