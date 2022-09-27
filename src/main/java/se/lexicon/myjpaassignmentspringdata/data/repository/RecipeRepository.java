package se.lexicon.myjpaassignmentspringdata.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.myjpaassignmentspringdata.entity.Recipe;

//public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

//FEL!!!

    @Query("SELECT a FROM Recipe a WHERE a.recipeName = :rn")
    Recipe findRecipeByFirstName(@Param("rn") String recipeName);

//    @Query("SELECT a FROM Recipe a WHERE a.recipeIngredients IN Ingredient.ingredientName = :in")
//    Recipe findAllByRecipeNameAndRecipeIngredients(@Param("in") String recipeName);
//
//    @Query("SELECT a FROM Recipe a, IN (a.categories) WHERE RecipeCategory.category = :sc")
//    Recipe findRecipeByCategories(@Param("sc")String category);
//
//    @Query("SELECT a FROM Recipe a, IN (a.categories) WHERE RecipeCategory.category = :sco AND RecipeCategory .category = :sct")
//    Recipe findRecipeByCategoriesAndCategories(@Param("sco")String category1, @Param("sct") String category2);


}
