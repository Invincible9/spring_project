package bg.example.football.web;

import bg.example.football.model.binding.SeasonBindingModel;
import bg.example.football.model.service.SeasonServiceModel;
import bg.example.football.model.view.SeasonViewModel;
import bg.example.football.service.divisions.DivisionService;
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
            redirectAttributes.addFlashAttribute("divisions", this.divisionService.getAll());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.seasonBindingModel", bindingResult);
            return "redirect:create";
        }

        this.seasonService.create(this.modelMapper.map(seasonBindingModel, SeasonServiceModel.class));
        redirectAttributes.addFlashAttribute("success", "Season created successfully!");
        return "redirect:list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("seasons", this.seasonService.getAll());
        return "seasons/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        SeasonViewModel seasonViewModel = this.seasonService.getOneById(id);
        SeasonBindingModel seasonBindingModel = this.modelMapper.map(seasonViewModel, SeasonBindingModel.class);
        seasonBindingModel.setDivisionId(seasonViewModel.getDivision().getId());

        model.addAttribute("seasonBindingModel", seasonBindingModel);
        model.addAttribute("divisions", this.divisionService.getAll());
        return "seasons/edit";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/edit")
    public String editProcess(@RequestParam("id") String id, @Valid @ModelAttribute("seasonBindingModel")
                                SeasonBindingModel seasonBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("seasonBindingModel", seasonBindingModel);
            redirectAttributes.addFlashAttribute("divisions", this.divisionService.getAll());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.seasonBindingModel", bindingResult);
            return "redirect:/seasons/edit/" + id;
        }

        this.seasonService.edit(this.modelMapper.map(seasonBindingModel, SeasonServiceModel.class), id);
        redirectAttributes.addFlashAttribute("success", "Season edited successfully!");
        return "redirect:/seasons/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        this.seasonService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Season removed successfully!");
        return "redirect:/seasons/list";
    }
}
