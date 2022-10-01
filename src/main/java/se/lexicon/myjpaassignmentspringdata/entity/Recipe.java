package se.lexicon.myjpaassignmentspringdata.entity;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Integer id;

    private String recipeName;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = {PERSIST, REMOVE})
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = RecipeInstruction.class)
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "recipe_recipe_category",
    joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = {@JoinColumn(name = "recipe_category_id")})
    private Set<RecipeCategory> categories = new HashSet<>();


    public Recipe() {
    }

    public Recipe(Integer id, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, Set<RecipeCategory> categories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, Set<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && Objects.equals(recipeName, recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeName);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", instruction=" + instruction +
                ", categories=" + categories +
                '}';
    }
}
