package se.lexicon.myjpaassignmentspringdata.model.form;

public class IngridentForm {

    private String ingredientName;


    public IngridentForm() {
    }

    public IngridentForm(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
