package bg.example.football.web;

import bg.example.football.model.binding.SeasonBindingModel;
import bg.example.football.model.service.SeasonServiceModel;
import bg.example.football.service.divisions.DivisionService;
import bg.example.football.service.seasons.SeasonService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/seasons")
public class SeasonController {
    private final SeasonService seasonService;
    private final ModelMapper modelMapper;
    private final DivisionService divisionService;

    public SeasonController(SeasonService service,
                            ModelMapper modelMapper,
                            DivisionService divisionService) {
        this.seasonService = service;
        this.modelMapper = modelMapper;
        this.divisionService = divisionService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/create")
    public String create(Model model) {
        if(!model.containsAttribute("seasonBindingModel")) {
            model.addAttribute("seasonBindingModel", new SeasonBindingModel());
            model.addAttribute("divisions", this.divisionService.getAll());
        }
        return "seasons/create";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public String createProcess(@Valid @ModelAttribute("seasonBindingModel")
                                            SeasonBindingModel seasonBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("seasonBindingModel", seasonBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.seasonBindingModel", bindingResult);
            return "redirect:create";
        }

        this.seasonService.create(this.modelMapper.map(seasonBindingModel, SeasonServiceModel.class));
        return "redirect:list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("seasons", this.seasonService.getAll());
        return "seasons/list";
    }
}
