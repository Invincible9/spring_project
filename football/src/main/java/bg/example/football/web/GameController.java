package bg.example.football.web;

import bg.example.football.model.binding.GameBindingModel;
import bg.example.football.model.binding.SearchBindingModel;
import bg.example.football.model.service.GameServiceModel;
import bg.example.football.model.view.GameViewModel;
import bg.example.football.service.games.GameService;
import bg.example.football.service.nationalities.NationalityService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/create")
    public String create(Model model) {
        if(!model.containsAttribute("gameBindingModel")) {
            model.addAttribute("gameBindingModel", new GameBindingModel());
            model.addAttribute("nationalities", this.nationalityService.getAll());
        }
        return "games/create";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public String createProcess(@Valid @ModelAttribute("gameBindingModel")
                                        GameBindingModel gameBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("gameBindingModel", gameBindingModel);
            redirectAttributes.addFlashAttribute("nationalities", this.nationalityService.getAll());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.gameBindingModel", bindingResult);
            return "redirect:create";
        }

        this.gameService.create(this.modelMapper.map(gameBindingModel, GameServiceModel.class));
        redirectAttributes.addFlashAttribute("success", "Game created successfully!");
        return "redirect:list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("games", this.gameService.getAll());
        model.addAttribute("nationalities", this.nationalityService.getAll());
        model.addAttribute("searchBindingModel", new SearchBindingModel());
        return "games/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/onlineGames")
    public String onlineGames() {
        return "games/onlineGames";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        GameViewModel gameViewModel = this.gameService.getOneById(id);
//        GameBindingModel gameBindingModel = this.modelMapper.map(gameViewModel, GameBindingModel.class);

        model.addAttribute("gameBindingModel", new GameBindingModel());
        model.addAttribute("nationalities", this.nationalityService.getAll());
        return "games/edit";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/edit")
    public String editProcess(@RequestParam("id") String id, @Valid @ModelAttribute("gameBindingModel")
                                GameBindingModel gameBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("gameBindingModel", gameBindingModel);
            redirectAttributes.addFlashAttribute("nationalities", this.nationalityService.getAll());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.gameBindingModel", bindingResult);
            return "redirect:/games/edit/" + id;
        }

        this.gameService.edit(this.modelMapper.map(gameBindingModel, GameServiceModel.class), id);
        redirectAttributes.addFlashAttribute("success", "Game edited successfully!");
        return "redirect:/games/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        this.gameService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Game removed successfully!");
        return "redirect:/games/list";
    }

}
