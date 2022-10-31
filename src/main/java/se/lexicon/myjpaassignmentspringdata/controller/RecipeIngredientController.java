package se.lexicon.myjpaassignmentspringdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeIngredientDto;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeIngredientForm;
import se.lexicon.myjpaassignmentspringdata.services.RecipeIngredientService;

@CrossOrigin("*")
@RequestMapping("api/v1/ingredients")
@RestController
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngreService;

    @Autowired
    public RecipeIngredientController(RecipeIngredientService recipeIngreService) {
        this.recipeIngreService = recipeIngreService;
    }

    @PostMapping()
    public ResponseEntity<RecipeIngredientDto> create(@RequestBody RecipeIngredientForm form){
        RecipeIngredientDto ingredientDto = recipeIngreService.create(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredientDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeIngredientDto> findById(@PathVariable("id") String prKey){
        RecipeIngredientDto todoItemDto = recipeIngreService.findById(prKey);
        return ResponseEntity.ok(todoItemDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeIngredientDto> update(@PathVariable("id") String prKey, @RequestBody RecipeIngredientForm form){
        RecipeIngredientDto recipeIngredientDto = recipeIngreService.update(prKey, form);
        return ResponseEntity.ok(recipeIngredientDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String prKey){
        boolean deleted = recipeIngreService.delete(prKey);
        return ResponseEntity.ok(deleted ? "Recipe Ingredient with id " + prKey + " was deleted" : "Recipe Ingredient with id " + prKey + " was not deleted");
    }
}
