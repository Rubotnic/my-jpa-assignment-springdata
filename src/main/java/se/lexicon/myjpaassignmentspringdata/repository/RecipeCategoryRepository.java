package se.lexicon.myjpaassignmentspringdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeCategory;
import java.util.List;

@Component
public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Integer> {



//    @Override
//    default <S extends RecipeCategory> S saveAndFlush(S entity) {
//        return null;
//    }

}
