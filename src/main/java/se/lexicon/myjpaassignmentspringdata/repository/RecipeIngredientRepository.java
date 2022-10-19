package se.lexicon.myjpaassignmentspringdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer> {

}
