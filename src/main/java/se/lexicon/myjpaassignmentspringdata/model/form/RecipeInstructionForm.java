package se.lexicon.myjpaassignmentspringdata.model.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RecipeInstructionForm {

    @Size(min = 4, message = "Need to contain at least 4 letters")
    @NotBlank(message = "this field is required")
    private String instruction;

    public RecipeInstructionForm() {
    }

    public RecipeInstructionForm(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}


