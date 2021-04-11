package bg.example.football.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(DivisionNamespace.URI_DIVISIONS)
public interface DivisionNamespace {
    String URI_DIVISIONS = "/divisions";
}