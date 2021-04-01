package bg.example.football.web;

import bg.example.football.model.entities.UserEntity;
import bg.example.football.service.users.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public HomeController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal UserDetails principal,
                        HttpSession httpSession) {
        if(principal != null) {
            UserEntity user = this.modelMapper.map(
                    this.userService.findOneByEmail(principal.getUsername()),
                    UserEntity.class);

            httpSession.setAttribute("url", user.getImageUrl());
        }
        return "home/index";
    }
}
