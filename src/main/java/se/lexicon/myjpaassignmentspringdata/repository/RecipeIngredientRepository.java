package se.lexicon.myjpaassignmentspringdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeIngredient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer> {

//    @Query("SELECT t FROM RecipeIngredient t WHERE UPPER(t.recipe.recipeName) LIKE UPPER(CONCAT('%',:string,'%'))")
//    List<RecipeIngredient> findByNameContains(@Param("string") String string);
//
//    @Query("SELECT t FROM RecipeIngredient t WHERE t.recipe.recipeId = :recipeId")
//    List<RecipeIngredient> findByRecipeId(@Param("recipeId") Integer recipeId);
//
//    @Query("SELECT t FROM RecipeIngredient t WHERE t.recipe IS null")
//    List<RecipeIngredient> findUnassignedRecipeIngredient();


}
