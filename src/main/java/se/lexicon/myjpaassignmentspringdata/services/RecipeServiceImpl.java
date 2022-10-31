package se.lexicon.myjpaassignmentspringdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myjpaassignmentspringdata.exception.ResourceNotFoundException;
import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeDto;
import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeInstructionDto;
import se.lexicon.myjpaassignmentspringdata.model.entity.Recipe;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeCategory;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeIngredient;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeInstruction;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeForm;
import se.lexicon.myjpaassignmentspringdata.repository.RecipeCategoryRepository;
import se.lexicon.myjpaassignmentspringdata.repository.RecipeIngredientRepository;
import se.lexicon.myjpaassignmentspringdata.repository.RecipeInstructionRepository;
import se.lexicon.myjpaassignmentspringdata.repository.RecipeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeIngredientRepository recipeIngRepository;
    private final RecipeCategoryRepository recipeCateRepository;
    private final RecipeInstructionRepository recipeInstruRepository;
    private final ConversionService conversion;


    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeIngredientRepository recipeIngRepository, RecipeCategoryRepository recipeCateRepository, RecipeInstructionRepository recipeInstruRepository, ConversionService conversion) {
        this.recipeInstruRepository = recipeInstruRepository;
        this.recipeCateRepository = recipeCateRepository;
        this.recipeRepository = recipeRepository;
        this.recipeIngRepository = recipeIngRepository;
        this.conversion = conversion;
    }

    @Override
    @Transactional
    public RecipeDto create(RecipeForm form) {
        Recipe saved = recipeRepository.save(conversion.toRecipe(form));
        return conversion.toRecipeDto(saved);
    }

    @Override
    @Transactional
    public boolean delete(Integer recipeId) {
        recipeRepository.deleteById(recipeId);
        return !recipeRepository.findById(recipeId).isPresent();
    }

    @Override
    @Transactional
    public RecipeDto update(Integer recipeId, RecipeForm updateForm) {
        Optional<Recipe> foundRecipe = recipeRepository.findById(recipeId);
        if (foundRecipe.isPresent()) {
            foundRecipe.get().setRecipeName(updateForm.getRecipeName());
        }
        if (foundRecipe.isPresent()) {
            return conversion.toRecipeDto(foundRecipe.get());
        } else {
            throw new IllegalArgumentException("Could not find By Id");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeDto findById(Integer recipeId) {
        Optional<Recipe> foundById = recipeRepository.findById(recipeId);
        Recipe recipe = foundById.orElseThrow(() -> new ResourceNotFoundException("Could not find Recipe By Id " + recipeId));
        return conversion.toRecipeDto(recipe);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecipeDto> findAll() {
        Iterable<Recipe> recipeFound = recipeRepository.findAll();
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        recipeFound.forEach((recipe) -> recipeDtoList.add(conversion.toRecipeDto(recipe)));
        return recipeDtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecipeDto> findIdleRecipe() {

        List<Recipe> idleRecipe = recipeRepository.findIdleRecipe();
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        idleRecipe.forEach(
                (recipe) -> recipeDtoList.add(conversion.toRecipeDto(recipe))
        );
        return recipeDtoList;
    }

    @Override
    @Transactional
    public RecipeDto addRecipeIngredient(Integer recipeId, String prKey) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new ResourceNotFoundException("Recipe Not found"));
        RecipeIngredient recipeIngredient = recipeIngRepository.findById(Integer.valueOf(prKey)).orElseThrow(() -> new ResourceNotFoundException("RecipeIngredient Not found"));
        recipe.addRecipeIngredient(recipeIngredient);
        return conversion.toRecipeDto(recipe);
    }

    @Override
    @Transactional
    public RecipeDto removeRecipeIngredient(Integer personId, String prKey) {
        Recipe recipe = recipeRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Recipe Not found"));
        RecipeIngredient recipeIngredient = recipeIngRepository.findById(Integer.valueOf(prKey)).orElseThrow(() -> new ResourceNotFoundException("RecipeIngredient Not found"));
        recipe.removeRecipeIngredient(recipeIngredient);
        return conversion.toRecipeDto(recipe);
    }

    @Override
    @Transactional
    public RecipeDto addRecipeCategory(Integer recipeId, Integer categroyId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new ResourceNotFoundException("Recipe Not found"));
        RecipeCategory recipeCategory = recipeCateRepository.findById(categroyId).orElseThrow(() -> new ResourceNotFoundException("Recipe category Not found"));
        recipe.addRecipeCategory(recipeCategory);
        return conversion.toRecipeDto(recipe);
    }

    @Override
    @Transactional
    public RecipeDto removeRecipeCategory(Integer recipeId, Integer categoryId) {

        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new ResourceNotFoundException("Recipe Not found"));
        RecipeCategory recipeCategory = recipeCateRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category Not found"));
        recipe.removeRecipeCategory(recipeCategory);
        return conversion.toRecipeDto(recipe);
    }

    @Override
    public RecipeDto addRecipeInstruction(Integer recipeId, Integer instructionId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new ResourceNotFoundException("Recipe Not found"));
        RecipeInstruction recipeInstruction = recipeInstruRepository.findById(instructionId).orElseThrow(() -> new ResourceNotFoundException("Recipe category Not found"));
        recipe.addRecipeInstruction(recipeInstruction);
        return conversion.toRecipeDto(recipe);
    }

    @Override
    public RecipeInstructionDto removeRecipeInstruction(Integer recipeId, Integer instructionId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new ResourceNotFoundException("person Not found"));
        RecipeInstruction recipeInstruction = recipeInstruRepository.findById(instructionId).orElseThrow(() -> new ResourceNotFoundException("TodoItem Not found"));
        recipe.removeRecipeInstruction(recipeInstruction);
        return conversion.toRecipeInstructionDto(recipeInstruction);
    }
}