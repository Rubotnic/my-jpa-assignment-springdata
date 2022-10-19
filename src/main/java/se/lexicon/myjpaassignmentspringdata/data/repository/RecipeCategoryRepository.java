package se.lexicon.myjpaassignmentspringdata.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import se.lexicon.myjpaassignmentspringdata.entity.RecipeCategory;

@Component
public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Integer> {


    @Override
    default <S extends RecipeCategory> S saveAndFlush(S entity) {
        return null;
    }




}
