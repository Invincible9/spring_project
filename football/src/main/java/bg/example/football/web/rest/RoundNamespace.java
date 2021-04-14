package bg.example.football.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(RoundNamespace.URI_ROUNDS)
public interface RoundNamespace {
    String URI_ROUNDS = "/rounds";
}
