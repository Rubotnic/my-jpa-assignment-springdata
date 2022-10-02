package se.lexicon.myjpaassignmentspringdata.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.myjpaassignmentspringdata.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    @Query("SELECT n FROM Ingredient n WHERE n.ingredientName = :in")
    Optional<Ingredient> findIngredientByIngredientNames(@Param("in")String ingredientName);

    @Query("SELECT  n FROM Ingredient n WHERE n.ingredientName = :inb")
    List<Ingredient> findAllByIngredientByIngredientNameBetweenAndIngredientName(@Param("inb")String ingredientName);

    @Query("SELECT  n FROM Ingredient n WHERE n.ingredientName = :inb")
    List<Ingredient> findByIngredientNameFragment(@Param("inb")String ingredientName);

    Optional<Ingredient> findIngredientNameByIngredientNameContaining(String ingredient);
}
