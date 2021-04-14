package bg.example.football.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(GameNamespace.URI_GAMES)
public interface GameNamespace {
    String URI_GAMES = "/games";
}
