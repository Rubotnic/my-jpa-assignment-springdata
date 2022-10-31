package se.lexicon.myjpaassignmentspringdata.services;

import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeIngredientDto;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeIngredientForm;
import java.util.List;

public interface RecipeIngredientService {

    RecipeIngredientDto create(RecipeIngredientForm form);
    RecipeIngredientDto findById(String prKey);
    List<RecipeIngredientDto> findAll();
    RecipeIngredientDto update(String prKey, RecipeIngredientForm form);
    boolean delete(String prKey);

//    List<RecipeIngredientDto> findByNameContain();

}
