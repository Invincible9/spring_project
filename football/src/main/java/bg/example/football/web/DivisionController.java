package bg.example.football.web;

import bg.example.football.model.binding.DivisionBindingModel;
import bg.example.football.model.service.DivisionServiceModel;
import bg.example.football.service.divisions.DivisionService;
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
@RequestMapping("/divisions")
public class DivisionController {

    private final DivisionService divisionService;
    private final ModelMapper modelMapper;

    public DivisionController(DivisionService divisionService, ModelMapper modelMapper) {
        this.divisionService = divisionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create")
    public String create(Model model) {
        if(!model.containsAttribute("divisionBindingModel")) {
            model.addAttribute("divisionBindingModel", new DivisionBindingModel());
        }
        return "divisions/create";
    }


    @PostMapping("/create")
    public String createProcess(@Valid @ModelAttribute("divisionBindingModel")
                                            DivisionBindingModel divisionBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("divisionBindingModel", divisionBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.divisionBindingModel", bindingResult);
            return "redirect:create";
        }

        this.divisionService.create(this.modelMapper.map(divisionBindingModel, DivisionServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/list")
    public String list() {
        return "divisions/list";
    }

}
