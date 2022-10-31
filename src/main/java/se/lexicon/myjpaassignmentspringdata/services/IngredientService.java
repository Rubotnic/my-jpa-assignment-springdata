package se.lexicon.myjpaassignmentspringdata.services;

import se.lexicon.myjpaassignmentspringdata.model.dto.IngredientDto;
import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeDto;
import se.lexicon.myjpaassignmentspringdata.model.form.IngridentForm;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeForm;

import java.util.List;

public interface IngredientService {

    IngredientDto create (IngridentForm form);
    boolean delete(Integer ingredientId);
    IngredientDto update(Integer ingredientId, IngridentForm form);
    IngredientDto findById(Integer ingredientId);
    List<IngredientDto> findAll();


}
