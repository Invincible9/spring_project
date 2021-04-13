package bg.example.football.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(SeasonNamespace.URI_SEASONS)
public interface SeasonNamespace {
    String URI_SEASONS = "/seasons";
}
