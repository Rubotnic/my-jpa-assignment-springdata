package se.lexicon.myjpaassignmentspringdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.myjpaassignmentspringdata.model.dto.IngredientDto;
import se.lexicon.myjpaassignmentspringdata.model.form.IngridentForm;
import se.lexicon.myjpaassignmentspringdata.services.IngredientService;


@CrossOrigin("*")
@RequestMapping("api/v1/ingredient")
@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;

    }

        @PostMapping()
        public ResponseEntity<IngredientDto> create(@RequestBody IngridentForm form){
            IngredientDto ingredientDtos = ingredientService.create(form);
            return ResponseEntity.status(HttpStatus.CREATED).body(ingredientDtos);
        }

        @GetMapping("/{id}")
        public ResponseEntity<IngredientDto> findById(@PathVariable("id") Integer ingredientId){
            IngredientDto ingredientDto = ingredientService.findById(ingredientId);
            return ResponseEntity.ok(ingredientDto);
        }

        @PutMapping("/{id}")
        public ResponseEntity<IngredientDto> update(@PathVariable("id") Integer ingredientId, @RequestBody IngridentForm form){
            IngredientDto ingredientDto = ingredientService.update(ingredientId, form);
            return ResponseEntity.ok(ingredientDto);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> delete(@PathVariable("id") Integer ingredientId){
            boolean deleted = ingredientService.delete(ingredientId);
            return ResponseEntity.ok(deleted ? "Ingredient with id " + ingredientId + " was deleted" : "Ingredient with id " + ingredientId + " was not deleted");
        }

    }

