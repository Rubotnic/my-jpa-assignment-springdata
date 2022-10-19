package se.lexicon.myjpaassignmentspringdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.myjpaassignmentspringdata.model.entity.Recipe;


public interface RecipeRepository extends JpaRepository<Recipe, Integer> {


    @Query("SELECT a FROM Recipe a WHERE a.recipeName = :rn")
    Recipe findRecipeByRecipeName(@Param("rn") String recipeName);
//
////    @Query("SELECT r FROM Recipe r WHERE in(r.recipeName and r.recipeIngredients) = :rn")
//
//
//    List<RecipeCategory> findAllByRecipeNameIsContainingAndCategories(@Param("rc")String categorise);









}
