package bg.example.football.web.rest;

import bg.example.football.model.view.TeamViewModel;
import bg.example.football.service.teams.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamRestController implements TeamNamespace {

    private final TeamService teamService;
    private final ModelMapper modelMapper;

    public TeamRestController(TeamService teamService, ModelMapper modelMapper) {
        this.teamService = teamService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<TeamViewModel>> getAll() {
        return
                ResponseEntity
                        .ok()
                        .body(this.teamService.getAll());
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<TeamViewModel> getOneById(@PathVariable("teamId") String teamId) {
        return
                ResponseEntity
                        .ok()
                        .body(this.teamService.getOneById(teamId));
    }

    @GetMapping("/{divisionId}")
    public ResponseEntity<List<TeamViewModel>> getAllByDivisionId(@PathVariable("divisionId") String divisionId) {
        return
                ResponseEntity
                        .ok()
                        .body(this.teamService.getAllByDivisionId(divisionId));
    }

}
