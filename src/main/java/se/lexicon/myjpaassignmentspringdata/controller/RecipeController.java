package se.lexicon.myjpaassignmentspringdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeDto;
import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeIngredientDto;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeForm;
import se.lexicon.myjpaassignmentspringdata.services.RecipeIngredientService;
import se.lexicon.myjpaassignmentspringdata.services.RecipeService;

import javax.validation.Valid;
import java.util.Collection;


@CrossOrigin("*")
@RequestMapping(path = "/api/v1/recipe")
@RestController
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeIngredientService recipeIngService;

    @Autowired
    public RecipeController(RecipeService recipeService, RecipeIngredientService recipeIngService) {
        this.recipeService = recipeService;
        this.recipeIngService = recipeIngService;
    }

    @PostMapping
    public ResponseEntity<RecipeDto> create(@RequestBody @Valid RecipeForm creationForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.create(creationForm));
    }

    @GetMapping
    public ResponseEntity<?> find(@RequestParam(value = "search", defaultValue = "all") String search) throws IllegalArgumentException {
        switch (search.toLowerCase()) {
            case "idle":
                return findIdleRecipe();
            case "all":
                return findAll();
            default:
                throw new IllegalArgumentException("Invalid search Param: valid Params Are: all, idle");
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RecipeDto> findById(@PathVariable("id") Integer recipeId) {
        return ResponseEntity.ok(recipeService.findById(recipeId));
    }

    public ResponseEntity<Collection<RecipeDto>> findAll() {
        return ResponseEntity.ok(recipeService.findAll());
    }

    public ResponseEntity<Collection<RecipeDto>> findIdleRecipe() {
        return ResponseEntity.ok(recipeService.findIdleRecipe());
    }

    @GetMapping(path = "/{id}/ingredients")
    public ResponseEntity<RecipeIngredientDto> getRecipeIngredient(@PathVariable("id") String prKey) {
        return ResponseEntity.ok(recipeIngService.findById(prKey));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer recipeId) {
        boolean delete = recipeService.delete(recipeId);
        return ResponseEntity.ok(delete ? "Recipe with id " + recipeId + " was deleted" : "Person Not Deleted");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RecipeDto> update(@PathVariable("id") Integer recipeId, @RequestBody @Valid RecipeForm updateForm) {
        return ResponseEntity.ok(recipeService.update(recipeId, updateForm));
    }

    @PutMapping("/{id}/todos/add")
    public ResponseEntity<RecipeDto> assignRecipe(@PathVariable("id") Integer recipeId, @RequestParam("prKey") String prKey) {
        return ResponseEntity.ok(recipeService.addRecipeIngredient(recipeId, String.valueOf(prKey)));
    }

    @PutMapping("/{id}/todos/remove")
    public ResponseEntity<RecipeDto> removeRecipe(@PathVariable("id") Integer recipeId, @RequestParam("prKey") String prKey) {
        return ResponseEntity.ok(recipeService.removeRecipeIngredient(recipeId, String.valueOf(prKey)));
    }
}