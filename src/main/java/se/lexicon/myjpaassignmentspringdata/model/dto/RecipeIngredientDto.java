package se.lexicon.myjpaassignmentspringdata.model.dto;

import se.lexicon.myjpaassignmentspringdata.model.entity.Ingredient;
import se.lexicon.myjpaassignmentspringdata.model.entity.Measurement;
import se.lexicon.myjpaassignmentspringdata.model.entity.Recipe;

public class RecipeIngredientDto {

    private String prKey;
    private Ingredient ingredient;
    private double amount;
    public Measurement measurement;
    private Recipe recipe;


    public RecipeIngredientDto() {
    }

    public RecipeIngredientDto(String prKey, Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.prKey = prKey;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public RecipeIngredientDto(String prKey, Ingredient ingredient, Measurement measurement, double amount, Recipe recipe) {
    }


    public String getPrKey() {
        return prKey;
    }

    public void setPrKey(String prKey) {
        this.prKey = prKey;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
