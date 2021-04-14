package bg.example.football.web.rest;

import bg.example.football.model.view.RoundViewModel;
import bg.example.football.service.rounds.RoundService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoundRestController implements RoundNamespace {
    private final RoundService roundService;
    private final ModelMapper modelMapper;

    public RoundRestController(RoundService roundService, ModelMapper modelMapper) {
        this.roundService = roundService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<RoundViewModel>> getAll() {
        return
                ResponseEntity
                        .ok()
                        .body(this.roundService.getAll());
    }

    @GetMapping("/{seasonId}")
    public ResponseEntity<List<RoundViewModel>> getAllBySeasonId(@PathVariable("seasonId") String seasonId) {
        return
                ResponseEntity
                        .ok()
                        .body(this.roundService.getAllBySeasonId(seasonId));
    }

}
