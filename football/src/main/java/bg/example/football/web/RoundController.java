package bg.example.football.web;

import bg.example.football.model.binding.RoundBindingModel;
import bg.example.football.model.service.RoundServiceModel;
import bg.example.football.model.view.RoundViewModel;
import bg.example.football.service.rounds.RoundService;
import bg.example.football.service.seasons.SeasonService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
            redirectAttributes.addFlashAttribute("seasons", this.seasonService.getAll());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.roundBindingModel", bindingResult);
            return "redirect:create";
        }

        this.roundService.create(this.modelMapper.map(roundBindingModel, RoundServiceModel.class));
        redirectAttributes.addFlashAttribute("success", "Round created successfully!");
        return "redirect:list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("rounds", this.roundService.getAll());
        return "rounds/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        RoundViewModel roundViewModel = this.roundService.getOneById(id);
        RoundBindingModel roundBindingModel = this.modelMapper.map(roundViewModel, RoundBindingModel.class);
        roundBindingModel.setSeasonId(roundViewModel.getSeasonViewModel().getId());

        model.addAttribute("roundBindingModel", roundBindingModel);
        model.addAttribute("seasons", this.seasonService.getAll());
        return "rounds/edit";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/edit")
    public String editProcess(@RequestParam("id") String id, @Valid @ModelAttribute("roundBindingModel")
                                RoundBindingModel roundBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("roundBindingModel", roundBindingModel);
            redirectAttributes.addFlashAttribute("seasons", this.seasonService.getAll());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.roundBindingModel", bindingResult);
            return "redirect:/rounds/edit/" + id;
        }

        this.roundService.edit(this.modelMapper.map(roundBindingModel, RoundServiceModel.class), id);
        redirectAttributes.addFlashAttribute("success", "Round edited successfully!");
        return "redirect:/rounds/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        this.roundService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Round removed successfully!");
        return "redirect:/rounds/list";
    }
}
