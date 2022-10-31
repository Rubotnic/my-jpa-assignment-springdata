package se.lexicon.myjpaassignmentspringdata.model.form;

import se.lexicon.myjpaassignmentspringdata.model.entity.Recipe;
import java.util.HashSet;
import java.util.Set;

public class RecipeCategoryForm {


    private String category;
    private Set<Recipe> recipe = new HashSet<>();


    public RecipeCategoryForm() {
    }

    public RecipeCategoryForm(Integer categoryId, String category, Set<Recipe> recipe) {
        this.category = category;
        this.recipe = recipe;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipe = recipe;
    }
}
