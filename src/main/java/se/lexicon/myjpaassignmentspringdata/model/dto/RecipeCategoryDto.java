package se.lexicon.myjpaassignmentspringdata.model.dto;

import se.lexicon.myjpaassignmentspringdata.model.entity.Recipe;
import java.util.HashSet;
import java.util.Set;

public class RecipeCategoryDto {

    private Integer categoryId;
    private String category;
    private Set<Recipe> recipe = new HashSet<>();


    public RecipeCategoryDto() {
    }

    public RecipeCategoryDto(Integer categoryId, String category, Set<Recipe> recipe) {
        this.categoryId = categoryId;
        this.category = category;
        this.recipe = recipe;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
