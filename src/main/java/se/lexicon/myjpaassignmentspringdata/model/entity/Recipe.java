package se.lexicon.myjpaassignmentspringdata.model.entity;

import javax.persistence.*;
import java.util.*;
import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Integer recipeId;

    private String recipeName;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = {PERSIST, REMOVE})
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @OneToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST}, fetch = FetchType.EAGER, targetEntity = RecipeInstruction.class)
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany(cascade = {REFRESH, DETACH, MERGE, PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = {@JoinColumn(name = "recipe_category_id")})
    private List<RecipeCategory> categories;


    public Recipe() {
    }

    public Recipe(Integer recipeId, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public void addRecipeIngredient(RecipeIngredient...recipeIngredients) {
        if (recipeIngredients == null || recipeIngredients.length == 0) return;
        if (this.recipeIngredients == null) this.recipeIngredients = new ArrayList<>();
        for (RecipeIngredient recipeIngredient : recipeIngredients) {
            if (!this.recipeIngredients.contains(recipeIngredient)) {
                this.recipeIngredients.add(recipeIngredient);
                recipeIngredient.setRecipe(this);
            }
        }
    }

    public void removeRecipeIngredient(RecipeIngredient...recipeIngredients) {
        if (recipeIngredients == null || recipeIngredients.length == 0) return;
        if (this.recipeIngredients == null) this.recipeIngredients = new ArrayList<>();
        for (RecipeIngredient recipeIngredient : recipeIngredients) {
            if (this.recipeIngredients.remove(recipeIngredient)) {
                recipeIngredient.setRecipe(null);
            }
        }
    }


    public void addRecipeInstruction(RecipeInstruction...instructions) {
        if (instructions == null || instructions.length == 0) return;
        if (this.instruction == null) this.instruction = new RecipeInstruction();
        for (RecipeInstruction recipeInstruction : instructions) {
            if (!this.instruction.equals(recipeInstruction)) {
                this.instruction.setInstruction(String.valueOf(recipeInstruction));
                recipeInstruction.setInstruction(String.valueOf(this));
            }
        }
    }

    public void removeRecipeInstruction(RecipeInstruction... instructions) {
        if (instructions == null || instructions.length == 0) return;
        if (this.instruction == null) this.instruction = new RecipeInstruction();
        for (RecipeInstruction recipeInstruction : instructions) {
            if (!this.instruction.equals(recipeInstruction)) {
                recipeInstruction.setInstruction(null);
            }
        }
    }

    public void addRecipeCategory(RecipeCategory... recipeCategories) {
        if (recipeCategories == null || recipeCategories.length == 0) return;
        if (this.categories == null) this.categories = new ArrayList<>();
        for (RecipeCategory recipeCategory : categories) {
            if (!this.categories.contains(recipeCategory)) {
                this.categories.add(recipeCategory);
                recipeCategory.setCategory(String.valueOf(this));
            }
        }
    }

    public void removeRecipeCategory(RecipeCategory... categories) {
        if (categories == null || categories.length == 0) return;
        if (this.categories == null) this.categories= new ArrayList<>();
        for (RecipeCategory recipeCategory : categories) {
            if (this.categories.remove(categories)) {
                recipeCategory.setRecipe(null);
            }
        }
    }


//    public void addRecipeCategory(RecipeCategory recipeCategory) {
//        if (categories == null) throw new IllegalArgumentException("Parameter RecipeCategory was null");
//        if (categories == null) categories = new HashSet<>();
//
//        categories.add(recipeCategory);
////        recipeCategorys.setCategory(String.valueOf(this));
//    }
//
//    public void removeRecipeCategory(RecipeCategory recipeCategorys) {
//        if (recipeCategorys == null) throw new IllegalArgumentException("Parameter RecipeCategory was null");
//        if (categories == null) setCategories(new HashSet<>());
//
//        if (categories.contains(recipeCategorys)) {
//            recipeCategorys.getRecipe().remove(this);
//            categories.remove(recipeCategorys);
//        }
//    }


//    public void addRecipeInstrucation(RecipeInstruction recipeInstruction) {
//        if (recipeInstruction == null) throw new IllegalArgumentException("Parameter RecipeInstruction was null");
//        if (instruction == null) instruction = new RecipeInstruction();
//
//        addRecipeInstrucation(instruction);
//        recipeInstruction.setInstruction(String.valueOf(this));
//    }
//
//    public void removeRecipeInstrucation(RecipeInstruction recipeInstruction) {
//        if (recipeInstruction == null) throw new IllegalArgumentException("Parameter RecipeInstruction was null");
//
//        recipeInstruction.getInstruction();
//        removeRecipeInstrucation(instruction);
//    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        if (recipeIngredients == null) recipeIngredients = new ArrayList<>();
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        if (recipeIngredients == null) recipeIngredients = new ArrayList<>();
        if (recipeIngredients.isEmpty()) {
            if (this.recipeIngredients != null) {
                for (RecipeIngredient recipeIngredient : this.recipeIngredients) {
                    recipeIngredient.setRecipe(null);
                }
            }
        } else {
            for (RecipeIngredient recipeIngredient : recipeIngredients) {
                recipeIngredient.setRecipe(this);
            }
        }
        this.recipeIngredients = recipeIngredients;
    }
//----

    public RecipeInstruction getInstruction() {
        if(instruction == null) instruction = new RecipeInstruction();
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
        instruction.setRecipe(this);
    }

//----

    public List<RecipeCategory> getCategories() {
        if (categories == null) categories = new ArrayList<>();
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        if (categories == null) categories = new ArrayList<>();
        if (categories.isEmpty()) {
            if (this.categories != null) {
                for (RecipeCategory recipeCategory : this.categories) {
                    recipeCategory.setRecipe(null);
                }
            }
        } else {
            for (RecipeCategory recipeCategory : categories)
                recipeCategory.setRecipe((Set<Recipe>) this);
        }
        this.categories = categories;
    }

    //-----
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId.equals(recipe.recipeId) && recipeName.equals(recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", instruction=" + instruction +
                ", categories=" + categories +
                '}';
    }
}
