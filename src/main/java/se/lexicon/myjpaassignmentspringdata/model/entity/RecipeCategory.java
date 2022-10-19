package se.lexicon.myjpaassignmentspringdata.model.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "recipe_category")
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_category_id")
    private Integer id;
    private String category;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "categories")
    private Set<Recipe> recipe = new HashSet<>();

    public RecipeCategory() {
    }

    public RecipeCategory(Integer id, String category, Set<Recipe> recipe) {
        this.id = id;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return Objects.equals(id, that.id) && Objects.equals(category, that.category);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}
