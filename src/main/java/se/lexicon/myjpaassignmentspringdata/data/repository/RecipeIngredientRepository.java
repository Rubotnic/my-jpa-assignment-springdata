package se.lexicon.myjpaassignmentspringdata.data.repository;

import javafx.scene.effect.SepiaTone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.myjpaassignmentspringdata.entity.RecipeIngredient;

import java.util.Set;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer> {

}
