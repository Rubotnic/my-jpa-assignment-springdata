package se.lexicon.myjpaassignmentspringdata.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.myjpaassignmentspringdata.model.entity.Recipe;

import java.util.List;


public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

//    @Query("SELECT a FROM Recipe a WHERE a.recipeName = :rn")
//    Recipe findRecipeByRecipeName(@Param("rn") String recipeName);

    @Query("SELECT a FROM Recipe a WHERE SIZE(a.recipeIngredients) = 0")
    List<Recipe> findIdleRecipe();



}
