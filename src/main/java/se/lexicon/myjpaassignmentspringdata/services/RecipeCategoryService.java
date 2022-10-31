package se.lexicon.myjpaassignmentspringdata.services;

import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeCategoryDto;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeCategoryForm;
import java.util.List;

public interface RecipeCategoryService {

    RecipeCategoryDto create(RecipeCategoryForm form);
    RecipeCategoryDto findById(Integer categoryId);
    List<RecipeCategoryDto> findAll();
    List<RecipeCategoryDto> findByCategory(String category);
    RecipeCategoryDto update(Integer categoryId, RecipeCategoryForm form);
    boolean delete(Integer categoryId);
}
