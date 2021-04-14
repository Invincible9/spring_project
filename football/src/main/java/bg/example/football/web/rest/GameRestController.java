package bg.example.football.web.rest;

import bg.example.football.model.view.GameViewModel;
import bg.example.football.service.games.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameRestController implements GameNamespace {
    private final GameService gameService;

    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameViewModel>> getAll() {
        return
                ResponseEntity
                        .ok()
                        .body(this.gameService.getAll());
    }
}
