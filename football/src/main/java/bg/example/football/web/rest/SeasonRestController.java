package bg.example.football.web.rest;

import bg.example.football.model.view.SeasonViewModel;
import bg.example.football.service.seasons.SeasonService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeasonRestController implements SeasonNamespace {
    private final SeasonService seasonService;
    private final ModelMapper modelMapper;

    public SeasonRestController(SeasonService seasonService, ModelMapper modelMapper) {
        this.seasonService = seasonService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<SeasonViewModel>> getAll() {
        return
                ResponseEntity
                        .ok()
                        .body(this.seasonService.getAll());
    }

    @GetMapping("/{divisionId}")
    public ResponseEntity<List<SeasonViewModel>> getAllByDivisionId(@PathVariable("divisionId") String divisionId) {
        return
                ResponseEntity
                        .ok()
                        .body(this.seasonService.getAllByDivisionId(divisionId));
    }
}
