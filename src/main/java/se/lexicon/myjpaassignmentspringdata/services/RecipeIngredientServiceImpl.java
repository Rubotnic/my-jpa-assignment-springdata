package se.lexicon.myjpaassignmentspringdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myjpaassignmentspringdata.exception.ResourceNotFoundException;
import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeIngredientDto;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeIngredient;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeIngredientForm;
import se.lexicon.myjpaassignmentspringdata.repository.RecipeIngredientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    private final RecipeIngredientRepository recipeIngRepository;
    private final ConversionService conversion;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientRepository recipeIngRepository, ConversionService conversion) {
        this.recipeIngRepository = recipeIngRepository;
        this.conversion = conversion;
    }

    @Override
    @Transactional
    public RecipeIngredientDto create(RecipeIngredientForm form) {
        RecipeIngredient entity = conversion.toRecipeIngredient(form);
        RecipeIngredient save = recipeIngRepository.save(entity);
        return conversion.toRecipeIngredientDto(save);
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeIngredientDto findById(String prKey) {
        return conversion.toRecipeIngredientDto(recipeIngRepository.findById(Integer.valueOf(prKey)).orElseThrow(() -> new ResourceNotFoundException("Could not find TodoItem with id: " + prKey)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecipeIngredientDto> findAll() {
        List<RecipeIngredient> allFound = (List<RecipeIngredient>) recipeIngRepository.findAll();
        return allFound.stream()
                .map(conversion::toRecipeIngredientDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public RecipeIngredientDto update(String prKey, RecipeIngredientForm form) {
        RecipeIngredient found = recipeIngRepository.findById(Integer.valueOf(prKey)).orElseThrow(() -> new ResourceNotFoundException("could not find by id:" + prKey));
        found.setIngredient(form.getIngredient());
        found.setAmount(form.getAmount());
        return conversion.toRecipeIngredientDto(found);
    }

    @Override
    @Transactional
    public boolean delete(String prKey) {
        recipeIngRepository.deleteById(Integer.valueOf(prKey));
        return !recipeIngRepository.existsById(Integer.valueOf(prKey));
    }

}
