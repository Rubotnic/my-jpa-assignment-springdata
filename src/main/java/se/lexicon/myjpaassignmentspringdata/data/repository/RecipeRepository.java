package se.lexicon.myjpaassignmentspringdata.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.myjpaassignmentspringdata.entity.Recipe;


public interface RecipeRepository extends JpaRepository<Recipe, Integer> {


//    @Query("SELECT a FROM Recipe a WHERE a.recipeName = :rn")
//    Recipe findRecipeByRecipeName(@Param("rn") String recipeName);
//
////    @Query("SELECT r FROM Recipe r WHERE in(r.recipeName and r.recipeIngredients) = :rn")
//
//
//    List<RecipeCategory> findAllByRecipeNameIsContainingAndCategories(@Param("rc")String categorise);









}
