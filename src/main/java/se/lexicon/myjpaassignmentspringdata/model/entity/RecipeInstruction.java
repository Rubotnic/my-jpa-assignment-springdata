package se.lexicon.myjpaassignmentspringdata.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "recipe_instruction")
public class RecipeInstruction {

    @Id
    @Column(name = "instruction_id")
    private Integer instructionId;
    private String instruction;


    public RecipeInstruction() {
    }

    public RecipeInstruction(Integer instructionId, String instruction) {
        this.instructionId = instructionId;
        this.instruction = instruction;
    }

    public RecipeInstruction(String instruction) {
        this.instruction = instruction;
    }

        public void addRecipeInstrucation(RecipeInstruction recipeInstruction) {
        if (recipeInstruction == null) throw new IllegalArgumentException("Parameter RecipeInstruction was null");
        if (instruction == null) instruction = String.valueOf(new RecipeInstruction());

        addRecipeInstrucation(recipeInstruction);
        recipeInstruction.setInstruction(String.valueOf(this));
    }

    public void removeRecipeInstrucation(RecipeInstruction recipeInstruction) {
        if (recipeInstruction == null) throw new IllegalArgumentException("Parameter RecipeInstruction was null");

        recipeInstruction.getInstruction();
        removeRecipeInstrucation(recipeInstruction);
    }


    public Integer getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(Integer instructionId) {
        this.instructionId = instructionId;
    }



    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setRecipe(Recipe recipe) {
        this.instruction = instruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return instructionId == that.instructionId && Objects.equals(instruction, that.instruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructionId, instruction);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "instructionId=" + instructionId +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
