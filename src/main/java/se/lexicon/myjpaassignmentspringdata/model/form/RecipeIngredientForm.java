package se.lexicon.myjpaassignmentspringdata.model.form;

import se.lexicon.myjpaassignmentspringdata.model.entity.Ingredient;

public class RecipeIngredientForm {


    private Ingredient ingredient;
    private double amount;


    public RecipeIngredientForm(Ingredient ingredient, double amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public RecipeIngredientForm() {
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
}
