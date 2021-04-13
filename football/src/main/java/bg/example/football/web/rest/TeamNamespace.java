package bg.example.football.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(TeamNamespace.URI_TEAMS)
public interface TeamNamespace {
    String URI_TEAMS = "/teams";
}
