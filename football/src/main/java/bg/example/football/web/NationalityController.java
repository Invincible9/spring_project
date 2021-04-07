package bg.example.football.web;

import bg.example.football.model.binding.NationalityBindingModel;
import bg.example.football.model.service.NationalityServiceModel;
import bg.example.football.model.view.NationalityViewModel;
import bg.example.football.service.nationalities.NationalityService;
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


    @GetMapping("/list")
    public String all(Model model) {
        List<NationalityViewModel> nationalities = this.nationalityService.getAll();
        model.addAttribute("nationalities", nationalities);
        return "nationalities/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        if(!model.containsAttribute("nationalityBindingModel")) {
            model.addAttribute("nationalityBindingModel", new NationalityBindingModel());
        }
        return "nationalities/create";
    }

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
}
