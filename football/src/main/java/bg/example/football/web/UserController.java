package bg.example.football.web;

import bg.example.football.model.binding.UserLoginBindingModel;
import bg.example.football.model.binding.UserProfileBindingModel;
import bg.example.football.model.binding.UserRegisterBindingModel;
import bg.example.football.model.service.UserProfileServiceModel;
import bg.example.football.model.service.UserRegisterServiceModel;
import bg.example.football.service.users.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if(!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("notFound", false);
        }

        return "users/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if(!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }

        return "users/register";
    }

    @PostMapping("/register")
    public String registerProcess(@Valid @ModelAttribute("userServiceModel")
                                              UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        if (!this.userService.exist(userRegisterBindingModel.getEmail())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("userExistsError", true);
            redirectAttributes.addFlashAttribute("error", "User with this email already exists!");
            return "redirect:register";
        }

        this.userService.register(this.modelMapper.map(
                userRegisterBindingModel, UserRegisterServiceModel.class));
        redirectAttributes.addFlashAttribute("success", "Registration successfully!");
        return "redirect:login";
    }


    @PostMapping("/login-error")
    public String failedLogin(@Valid @ModelAttribute("userLoginBindingModel")
                                     UserLoginBindingModel userLoginBindingModel,
                              RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
        return "redirect:login";
    }


    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal UserDetails principal) {
        if(!model.containsAttribute("userProfileBindingModel")) {
            model.addAttribute("userProfileBindingModel",
                    this.modelMapper.map(
                    this.userService.findOneByEmail(principal.getUsername()),
                    UserProfileServiceModel.class));
        }

        return "users/profile";
    }

    @PostMapping("/profile")
    public String profileProcess(@Valid @ModelAttribute("userProfileBindingModel")
                                             UserProfileBindingModel userProfileBindingModel,
                                 @AuthenticationPrincipal UserDetails principal,
                                 RedirectAttributes redirectAttributes) throws IOException {

        userProfileBindingModel.setEmail(principal.getUsername());
        this.userService.updateProfile(this.modelMapper.map(userProfileBindingModel, UserProfileServiceModel.class));
        redirectAttributes.addFlashAttribute("success", "Profile updated successfully!");
        return "redirect:profile";
    }



}
