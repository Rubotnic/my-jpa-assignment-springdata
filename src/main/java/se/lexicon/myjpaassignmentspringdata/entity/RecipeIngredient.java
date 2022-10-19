package se.lexicon.myjpaassignmentspringdata.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "recipe_ingredient_id", length = 10)
    private String prKey;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "measurement")
    private Measurement measurement;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Recipe.class)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;


    public RecipeIngredient() {
    }

    public RecipeIngredient(String prKey, Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.prKey = prKey;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public RecipeIngredient(Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }



    private double measurementIngredient(){

        switch(measurement){
            case TBSP:
            default:
                return 1;
            case TSP:
                return 2;
            case G:
                return 3;
            case HG:
                return 4;
            case KG:
                return 5;
            case ML:
                return 6;
            case CL:
                return 7;
            case DL:
                return 8;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(prKey, that.prKey) && Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prKey, ingredient, amount);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "prKey='" + prKey + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", recipe=" + recipe +
                '}';
    }
}
