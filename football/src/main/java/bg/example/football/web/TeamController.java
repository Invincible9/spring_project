package bg.example.football.web;

import bg.example.football.model.binding.TeamBindingModel;
import bg.example.football.model.service.TeamServiceModel;
import bg.example.football.service.divisions.DivisionService;
import bg.example.football.service.teams.TeamService;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;
    private final ModelMapper modelMapper;
    private final DivisionService divisionService;

    public TeamController(TeamService teamService,
                          ModelMapper modelMapper,
                          DivisionService divisionService) {
        this.teamService = teamService;
        this.modelMapper = modelMapper;
        this.divisionService = divisionService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        if(!model.containsAttribute("teamBindingModel")) {
            model.addAttribute("teamBindingModel", new TeamBindingModel());
            model.addAttribute("divisions", this.divisionService.getAll());
        }
        return "teams/create";
    }

    @PostMapping("/create")
    public String createProcess(@Valid @ModelAttribute("teamBindingModel")
                                        TeamBindingModel teamBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("teamBindingModel", teamBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.teamBindingModel", bindingResult);
            return "redirect:create";
        }

        this.teamService.create(this.modelMapper.map(teamBindingModel, TeamServiceModel.class));
        return "redirect:list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("teams", this.teamService.getAll());
        return "teams/list";
    }

}
