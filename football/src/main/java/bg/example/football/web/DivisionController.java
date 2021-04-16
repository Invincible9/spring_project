package bg.example.football.web;

import bg.example.football.model.binding.DivisionBindingModel;
import bg.example.football.model.binding.DivisionEditBindingModel;
import bg.example.football.model.service.DivisionServiceModel;
import bg.example.football.model.view.DivisionViewModel;
import bg.example.football.service.divisions.DivisionService;
import bg.example.football.service.nationalities.NationalityService;
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
@RequestMapping("/divisions")
public class DivisionController {

    private final DivisionService divisionService;
    private final NationalityService nationalityService;
    private final ModelMapper modelMapper;

    public DivisionController(DivisionService divisionService,
                              NationalityService nationalityService, ModelMapper modelMapper) {
        this.divisionService = divisionService;
        this.nationalityService = nationalityService;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/create")
    public String create(Model model) {
        if(!model.containsAttribute("divisionBindingModel")) {
            model.addAttribute("divisionBindingModel", new DivisionBindingModel());
            model.addAttribute("nationalities", this.nationalityService.getAll());
        }
        return "divisions/create";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public String createProcess(@Valid @ModelAttribute("divisionBindingModel")
                                            DivisionBindingModel divisionBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("divisionBindingModel", divisionBindingModel);
            redirectAttributes.addFlashAttribute("nationalities",  this.nationalityService.getAll());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.divisionBindingModel", bindingResult);
            return "redirect:create";
        }

        this.divisionService.create(this.modelMapper.map(divisionBindingModel, DivisionServiceModel.class));
        redirectAttributes.addFlashAttribute("success", "Division created successfully!");
        return "redirect:list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("divisions", this.divisionService.getAll());
        return "divisions/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        DivisionViewModel divisionViewModel = this.divisionService.getOneById(id);
        DivisionEditBindingModel divisionBindingModel = this.modelMapper.map(divisionViewModel, DivisionEditBindingModel.class);
        divisionBindingModel.setNationalityName(divisionViewModel.getNationalityViewModel().getName());

        model.addAttribute("divisionBindingModel", divisionBindingModel);
        model.addAttribute("nationalities", this.nationalityService.getAll());
        return "divisions/edit";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/edit")
    public String editProcess(@RequestParam("id") String id, @Valid @ModelAttribute("divisionBindingModel")
                                DivisionEditBindingModel divisionBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("divisionBindingModel", divisionBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.divisionBindingModel", bindingResult);
            return "redirect:/divisions/edit/" + id;
        }

        this.divisionService.edit(this.modelMapper.map(divisionBindingModel, DivisionServiceModel.class), id);
        redirectAttributes.addFlashAttribute("success", "Division edited successfully!");
        return "redirect:/divisions/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        this.divisionService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Division removed successfully!");
        return "redirect:/divisions/list";
    }


}
