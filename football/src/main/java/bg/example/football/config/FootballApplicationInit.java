package bg.example.football.config;

import bg.example.football.service.users.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FootballApplicationInit implements CommandLineRunner {

    private final UserService userService;

    public FootballApplicationInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userService.initRoles();
        this.userService.initAdmin();
    }
}
