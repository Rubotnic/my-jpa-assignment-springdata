package se.lexicon.myjpaassignmentspringdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.lexicon.myjpaassignmentspringdata.services.RecipeService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/v1/recipe")
public class HomeController {

    private final RecipeService recipeService;

    @Autowired
    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(path = {"/index"}, method = RequestMethod.GET)
    public String homepage(Model model) {

        model.addAttribute("recipe", recipeService.findAll());
        return "index";
    }
}
