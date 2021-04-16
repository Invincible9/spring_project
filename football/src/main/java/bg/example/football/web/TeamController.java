package bg.example.football.web;

import bg.example.football.model.binding.TeamBindingModel;
import bg.example.football.model.binding.TeamEditBindingModel;
import bg.example.football.model.service.TeamServiceModel;
import bg.example.football.model.view.TeamViewModel;
import bg.example.football.service.divisions.DivisionService;
import bg.example.football.service.teams.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/create")
    public String create(Model model) {
        if(!model.containsAttribute("teamBindingModel")) {
            model.addAttribute("teamBindingModel", new TeamBindingModel());
            model.addAttribute("divisions", this.divisionService.getAll());
        }
        return "teams/create";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public String createProcess(@Valid @ModelAttribute("teamBindingModel")
                                        TeamBindingModel teamBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("teamBindingModel", teamBindingModel);
            redirectAttributes.addFlashAttribute("divisions", this.divisionService.getAll());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.teamBindingModel", bindingResult);
            return "redirect:create";
        }

        redirectAttributes.addFlashAttribute("success", "Team created successfully!");
        this.teamService.create(this.modelMapper.map(teamBindingModel, TeamServiceModel.class));
        return "redirect:list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("teams", this.teamService.getAll());
        return "teams/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        TeamViewModel teamViewModel = this.teamService.getOneById(id);
        TeamEditBindingModel teamBindingModel = this.modelMapper.map(teamViewModel, TeamEditBindingModel.class);
        teamBindingModel.setDivisionId(teamViewModel.getDivision().getId());

        model.addAttribute("teamBindingModel", teamBindingModel);
        model.addAttribute("divisions", this.divisionService.getAll());
        return "teams/edit";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/edit")
    public String editProcess(@RequestParam("id") String id, @Valid @ModelAttribute("teamBindingModel")
                                TeamEditBindingModel teamBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("teamBindingModel", teamBindingModel);
            redirectAttributes.addFlashAttribute("divisions", this.divisionService.getAll());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.teamBindingModel", bindingResult);
            return "redirect:/teams/edit/" + id;
        }

        this.teamService.edit(this.modelMapper.map(teamBindingModel, TeamServiceModel.class), id);
        redirectAttributes.addFlashAttribute("success", "Team edited successfully!");
        return "redirect:/teams/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        this.teamService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Team removed successfully!");
        return "redirect:/teams/list";
    }

}
