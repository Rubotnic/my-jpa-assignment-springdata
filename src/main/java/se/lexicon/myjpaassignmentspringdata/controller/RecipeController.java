package se.lexicon.myjpaassignmentspringdata.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.myjpaassignmentspringdata.exception.ResourceNotFoundException;
import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeDto;
import se.lexicon.myjpaassignmentspringdata.model.entity.Recipe;
import se.lexicon.myjpaassignmentspringdata.repository.RecipeRepository;
import java.util.List;

@RestController
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;

    public RecipeController(RecipeRepository recipeRepository, ModelMapper modelMapper){
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
    }


    @GetMapping("api/v1/recipe/{id}")
    public ResponseEntity<RecipeDto> findByRecipeId(@PathVariable("id") Integer id) {

        if(id == null) throw new IllegalArgumentException("Null!");
        Recipe foundById = recipeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Data not found!")
        );
        return ResponseEntity.ok(modelMapper.map(foundById, RecipeDto.class));
    }

    @GetMapping("api/v1/recipe/search")
    public ResponseEntity<RecipeDto> findByRecipeName(@RequestParam("recipeName") String name) {

        if(name == null) throw new IllegalArgumentException("Null!");
        Recipe foundByName = recipeRepository.findRecipeByRecipeName(name);
        return ResponseEntity.ok(modelMapper.map(foundByName, RecipeDto.class));
    }

    public ResponseEntity <RecipeDto> create(@RequestBody RecipeDto recipeForm) {
        System.out.println("### In create");

        Recipe toEntity = modelMapper.map(recipeForm, Recipe.class);
        Recipe savedRecpie = recipeRepository.save(toEntity);
        RecipeDto toDto = modelMapper.map(savedRecpie, RecipeDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(toDto);
    }


    @GetMapping("/api/v1/recipe")
    public ResponseEntity<List<RecipeDto>> findAll() {
        System.out.println("### executed! ###");
        List<Recipe> listOfRecipe = recipeRepository.findAll();
        List<RecipeDto> listOfDto = modelMapper.map(listOfRecipe, new TypeToken<List<RecipeDto>>() {
        }.getType());
        return ResponseEntity.ok(listOfDto);
    }


    @PutMapping("api/v1/recipe/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody RecipeDto recipeForm) {
        System.out.println("Deleted");
        System.out.println(id);
        System.out.println(recipeForm);

        if (id.equals(recipeForm.getId())) {
            Recipe recipe = modelMapper.map(recipeForm, Recipe.class);
            recipeRepository.save(recipe);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(418).build();
        }
    }


    @DeleteMapping("api/v1/recipe/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        System.out.println(id);
        recipeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
