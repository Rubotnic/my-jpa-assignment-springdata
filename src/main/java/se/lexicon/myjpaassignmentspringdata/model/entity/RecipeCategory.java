package se.lexicon.myjpaassignmentspringdata.model.entity;

import javax.persistence.*;
import java.util.*;
import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "recipe_category")
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_category_id")
    private Integer categoryId;
    private String category;

    @ManyToMany(cascade = {MERGE, DETACH, REFRESH, PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_category_id"), inverseJoinColumns = {@JoinColumn(name = "recipe_id")})
    private Set<Recipe> recipe = new HashSet<>();


    public RecipeCategory() {
    }

    public RecipeCategory(Integer categoryId, String category, Set<Recipe> recipe) {
        this.categoryId = categoryId;
        this.category = category;
        this.recipe = recipe;
    }

    public RecipeCategory(String category) {
        this.category = category;
    }

    public RecipeCategory(String category, Set<Recipe> recipe) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return Objects.equals(categoryId, that.categoryId) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, category);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}
