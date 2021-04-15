package bg.example.football.web;

import bg.example.football.model.binding.RoundBindingModel;
import bg.example.football.model.service.RoundServiceModel;
import bg.example.football.service.rounds.RoundService;
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
@RequestMapping("/rounds")
public class RoundController {

    private final RoundService roundService;
    private final SeasonService seasonService;
    private final ModelMapper modelMapper;

    public RoundController(RoundService roundService,
                           SeasonService seasonService,
                           ModelMapper modelMapper) {
        this.roundService = roundService;
        this.seasonService = seasonService;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/create")
    public String create(Model model) {
        if(!model.containsAttribute("roundBindingModel")) {
            model.addAttribute("roundBindingModel", new RoundBindingModel());
            model.addAttribute("seasons", this.seasonService.getAll());
        }
        return "rounds/create";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public String createProcess(@Valid @ModelAttribute("roundBindingModel")
                                            RoundBindingModel roundBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("roundBindingModel", roundBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.roundBindingModel", bindingResult);
            return "redirect:create";
        }

        this.roundService.create(this.modelMapper.map(roundBindingModel, RoundServiceModel.class));
        return "redirect:list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("rounds", this.roundService.getAll());
        return "rounds/list";
    }
}
