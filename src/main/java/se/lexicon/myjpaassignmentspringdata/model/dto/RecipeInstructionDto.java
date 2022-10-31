package se.lexicon.myjpaassignmentspringdata.model.dto;

public class RecipeInstructionDto {

    private Integer instructionId;
    private String instruction;


    public RecipeInstructionDto() {
    }

    public RecipeInstructionDto(Integer instructionId, Integer id, String instruction) {
        this.instructionId = instructionId;
        this.instruction = instruction;
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
}