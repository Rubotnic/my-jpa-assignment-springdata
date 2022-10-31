package se.lexicon.myjpaassignmentspringdata.services;

import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeDto;
import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeInstructionDto;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeForm;
import java.util.List;

public interface RecipeService {

    RecipeDto create (RecipeForm form);
    boolean delete(Integer recipeId);
    RecipeDto update(Integer recipeId, RecipeForm updateForm);
    RecipeDto findById(Integer recipeId);
    List<RecipeDto> findAll();
    List<RecipeDto> findIdleRecipe();

    RecipeDto addRecipeIngredient(Integer recipeId, String prKey);
    RecipeDto removeRecipeIngredient(Integer recipeId, String prKey);


    RecipeDto addRecipeCategory(Integer recipeId, Integer categoryId);
    RecipeDto removeRecipeCategory(Integer recipeId, Integer categoryId);

    RecipeDto addRecipeInstruction(Integer recipeId, Integer instructionId);
    RecipeInstructionDto removeRecipeInstruction(Integer recipeId, Integer instructionId);

}
