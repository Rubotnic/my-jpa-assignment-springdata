package se.lexicon.myjpaassignmentspringdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myjpaassignmentspringdata.exception.ResourceNotFoundException;
import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeCategoryDto;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeCategory;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeCategoryForm;
import se.lexicon.myjpaassignmentspringdata.repository.RecipeCategoryRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeCategroyServiceImpl implements RecipeCategoryService{

    private final RecipeCategoryRepository recipeCateRepository;
    private final ConversionService conversion;

    @Autowired
    public RecipeCategroyServiceImpl(RecipeCategoryRepository recipeCateRepository, ConversionService conversion) {
        this.recipeCateRepository = recipeCateRepository;
        this.conversion = conversion;
    }

    @Override
    @Transactional
    public RecipeCategoryDto create(RecipeCategoryForm form) {
        RecipeCategory entity = conversion.toRecipeCategory(form);
        RecipeCategory save = recipeCateRepository.save(entity);
        return conversion.toRecipeCategoryDto(save);
    }

    @Override
    public RecipeCategoryDto findById(Integer categoryId) {
        return conversion.toRecipeCategoryDto(recipeCateRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Not found id " + categoryId)));
    }

    @Override
    public List<RecipeCategoryDto> findAll() {
        List<RecipeCategory> allFound = (List<RecipeCategory>) recipeCateRepository.findAll();
        return allFound.stream().map(conversion::toRecipeCategoryDto).collect(Collectors.toList());
    }

    @Override
    public List<RecipeCategoryDto> findByCategory(String category) {
        return null;
    }

    @Override
    public RecipeCategoryDto update(Integer categoryId, RecipeCategoryForm form) {
        RecipeCategory found = recipeCateRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Id not found " + categoryId));
        return conversion.toRecipeCategoryDto(found);
    }

    @Override
    public boolean delete(Integer categoryId) {
        recipeCateRepository.deleteById(categoryId);
        return !recipeCateRepository.existsById(categoryId);
    }
}