package bg.example.football.web;

import bg.example.football.model.binding.NationalityBindingModel;
import bg.example.football.model.service.NationalityServiceModel;
import bg.example.football.model.view.NationalityViewModel;
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
import java.util.List;

@Controller
@RequestMapping("/nationalities")
public class NationalityController {

    private final NationalityService nationalityService;
    private final ModelMapper modelMapper;

    public NationalityController(NationalityService nationalityService, ModelMapper modelMapper) {
        this.nationalityService = nationalityService;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Model model) {
        List<NationalityViewModel> nationalities = this.nationalityService.getAll();
        model.addAttribute("nationalities", nationalities);
        return "nationalities/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/create")
    public String create(Model model) {
        if(!model.containsAttribute("nationalityBindingModel")) {
            model.addAttribute("nationalityBindingModel", new NationalityBindingModel());
        }
        return "nationalities/create";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public String createProcess(@Valid @ModelAttribute("nationalityBindingModel")
                                 NationalityBindingModel nationalityBindingModel,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("nationalityBindingModel", nationalityBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.nationalityBindingModel", bindingResult);
            return "redirect:create";
        }

        this.nationalityService.create(this.modelMapper.map(nationalityBindingModel, NationalityServiceModel.class));

        return "redirect:list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        model.addAttribute("nameExist", false);
        NationalityBindingModel nationalityBindingModel = this.modelMapper.map(this.nationalityService.getOneById(id), NationalityBindingModel.class);
        model.addAttribute("nationalityBindingModel", nationalityBindingModel);
        return "nationalities/edit";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/edit")
    public String editProcess(@RequestParam("id") String id, @Valid @ModelAttribute("nationalityBindingModel")
                                   NationalityBindingModel nationalityBindingModel,
                       BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        if(bindingResult.hasErrors() || !this.nationalityService.edit(
                this.modelMapper.map(nationalityBindingModel, NationalityServiceModel.class), id)) {
            redirectAttributes.addFlashAttribute("nameExist", true);
            redirectAttributes.addFlashAttribute("nationalityBindingModel", nationalityBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.nationalityBindingModel", bindingResult);
            return "redirect:/nationalities/edit/" + id;
        }

        return "redirect:/nationalities/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        this.nationalityService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Nationality removed successfully!");
        return "redirect:/nationalities/list";
    }

}
