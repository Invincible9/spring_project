package bg.example.football.web.rest;

import bg.example.football.model.view.DivisionViewModel;
import bg.example.football.service.divisions.DivisionService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DivisionRestController implements DivisionNamespace {

    private final DivisionService divisionService;
    private final ModelMapper modelMapper;

    public DivisionRestController(DivisionService divisionService,
                                  ModelMapper modelMapper) {
        this.divisionService = divisionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<DivisionViewModel>> getAll() {
        return
                ResponseEntity
                        .ok()
                        .body(this.divisionService.getAll());
    }

    @GetMapping("/{nationalityId}")
    public ResponseEntity<List<DivisionViewModel>> getAllByNationalityId(@PathVariable("nationalityId") String nationalityId) {
        return
                ResponseEntity
                    .ok()
                    .body(this.divisionService.getAllByNationalityId(nationalityId));
    }

}

