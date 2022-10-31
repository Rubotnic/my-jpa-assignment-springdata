package se.lexicon.myjpaassignmentspringdata.model.form;

public class RecipeForm {

    private String recipeName;



    public RecipeForm() {
    }

    public RecipeForm(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
