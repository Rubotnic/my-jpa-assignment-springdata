package se.lexicon.myjpaassignmentspringdata.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.myjpaassignmentspringdata.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {


}
