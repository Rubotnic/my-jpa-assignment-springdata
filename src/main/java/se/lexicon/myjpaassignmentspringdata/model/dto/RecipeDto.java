package se.lexicon.myjpaassignmentspringdata.model.dto;

import lombok.*;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeCategory;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeIngredient;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeInstruction;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeDto {

    private Integer id;
    private String recipeName;
    private List<RecipeIngredient> recipeIngredients;
    private RecipeInstruction instruction;
    private Set<RecipeCategory> categories;

}
