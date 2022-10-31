package se.lexicon.myjpaassignmentspringdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myjpaassignmentspringdata.exception.ResourceNotFoundException;
import se.lexicon.myjpaassignmentspringdata.model.dto.IngredientDto;
import se.lexicon.myjpaassignmentspringdata.model.entity.Ingredient;
import se.lexicon.myjpaassignmentspringdata.model.form.IngridentForm;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeForm;
import se.lexicon.myjpaassignmentspringdata.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService{

    private final IngredientRepository ingredientRepository;
    private ConversionService conversion;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository, ConversionService conversion) {
        this.ingredientRepository = ingredientRepository;
        this.conversion = conversion;
    }

    @Override
    @Transactional
    public IngredientDto create(IngridentForm form) {
        Ingredient saved = ingredientRepository.save(conversion.toIngredient(form));
        return conversion.toIngredientDto(saved);
    }

    @Override
    @Transactional
    public boolean delete(Integer ingredientId) {
        ingredientRepository.deleteById(ingredientId);
        return !ingredientRepository.findById(ingredientId).isPresent();
    }

    @Override
    public IngredientDto update(Integer ingredientId, IngridentForm form) {
        Optional<Ingredient> foundIngredient = ingredientRepository.findById(ingredientId);
        if(foundIngredient.isPresent()) {
            foundIngredient.get().setIngredientName(form.getIngredientName());
        }
        if(foundIngredient.isPresent()) {
            return conversion.toIngredientDto(foundIngredient.get());
        }
        else {
            throw new IllegalArgumentException("Cant find id");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public IngredientDto findById(Integer ingredientId) {
        Optional<Ingredient> foundById = ingredientRepository.findById(ingredientId);
        Ingredient ingredient = foundById.orElseThrow(()-> new ResourceNotFoundException("No Id!"));
        return conversion.toIngredientDto(ingredient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IngredientDto> findAll() {
        Iterable<Ingredient> ingredientsFound = ingredientRepository.findAll();
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        ingredientsFound.forEach(ingredient -> ingredientDtoList.add(conversion.toIngredientDto(ingredient)));
        return null;
    }
}
