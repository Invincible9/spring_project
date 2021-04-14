package bg.example.football.web;

import bg.example.football.model.binding.GameBindingModel;
import bg.example.football.model.binding.SearchBindingModel;
import bg.example.football.model.service.GameServiceModel;
import bg.example.football.service.games.GameService;
import bg.example.football.service.nationalities.NationalityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@CrossOrigin
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;
    private final NationalityService nationalityService;
    private final ModelMapper modelMapper;

    public GameController(GameService gameService,
                          NationalityService nationalityService,
                          ModelMapper modelMapper) {
        this.gameService = gameService;
        this.nationalityService = nationalityService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create")
    public String create(Model model) {
        if(!model.containsAttribute("gameBindingModel")) {
            model.addAttribute("gameBindingModel", new GameBindingModel());
            model.addAttribute("nationalities", this.nationalityService.getAll());
        }
        return "games/create";
    }

    @PostMapping("/create")
    public String createProcess(@Valid @ModelAttribute("gameBindingModel")
                                        GameBindingModel gameBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("gameBindingModel", gameBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.gameBindingModel", bindingResult);
            return "redirect:create";
        }

        this.gameService.create(this.modelMapper.map(gameBindingModel, GameServiceModel.class));
        return "redirect:list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("games", this.gameService.getAll());
        model.addAttribute("nationalities", this.nationalityService.getAll());
        model.addAttribute("searchBindingModel", new SearchBindingModel());
        return "games/list";
    }

    @GetMapping("/onlineGames")
    public String onlineGames() {

        return "games/onlineGames";
    }


}
