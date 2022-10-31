package se.lexicon.myjpaassignmentspringdata.model.dto;

public class IngredientDto {

    private Integer ingredientId;
    private String ingredientName;


    public IngredientDto() {
    }

    public IngredientDto(Integer ingredientId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
