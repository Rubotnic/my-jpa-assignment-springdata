package se.lexicon.myjpaassignmentspringdata.services;

import org.springframework.stereotype.Service;
import se.lexicon.myjpaassignmentspringdata.model.dto.*;
import se.lexicon.myjpaassignmentspringdata.model.entity.*;
import se.lexicon.myjpaassignmentspringdata.model.form.*;

@Service
public class ConversionService {

    public Recipe toRecipe(RecipeForm formDto){
        return new Recipe(formDto.getRecipeName());
    }
    public RecipeDto toRecipeDto(Recipe recipe){
        return new RecipeDto(recipe.getRecipeId(), recipe.getRecipeName(), recipe.getRecipeIngredients(), recipe.getInstruction(), recipe.getCategories());
    }


    public RecipeIngredient toRecipeIngredient(RecipeIngredientForm formDto) {
        return new RecipeIngredient(formDto.getAmount(), formDto.getIngredient());
    }
    public RecipeIngredientDto toRecipeIngredientDto (RecipeIngredient recipeIngredient){
        return new RecipeIngredientDto(recipeIngredient.getPrKey(), recipeIngredient.getIngredient(), recipeIngredient.getMeasurement(), recipeIngredient.getAmount(), recipeIngredient.getRecipe());
    }


    public RecipeInstruction toRecipeInstruction(RecipeInstructionForm formDto){
        return new RecipeInstruction(formDto.getInstruction());
    }
    public RecipeInstructionDto toRecipeInstructionDto(RecipeInstruction instruction){
        return new RecipeInstructionDto(0, instruction.getInstructionId(), instruction.getInstruction());
    }


    public RecipeCategory toRecipeCategory (RecipeCategoryForm formDto){
        return new RecipeCategory(0, formDto.getCategory(), formDto.getRecipe());
    }

    public RecipeCategoryDto toRecipeCategoryDto(RecipeCategory recipeCategory){
        return new RecipeCategoryDto(recipeCategory.getCategoryId(), recipeCategory.getCategory(), recipeCategory.getRecipe());
    }


    public Ingredient toIngredient (IngridentForm formDto){
        return new Ingredient(formDto.getIngredientName());
    }

    public IngredientDto toIngredientDto(Ingredient ingredient){
        return new IngredientDto(ingredient.getIngredientId(), ingredient.getIngredientName());
    }

}
