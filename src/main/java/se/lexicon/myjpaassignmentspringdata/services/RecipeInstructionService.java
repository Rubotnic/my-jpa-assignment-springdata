package se.lexicon.myjpaassignmentspringdata.services;

import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeInstructionDto;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeInstruction;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeInstructionForm;
import java.util.List;

public interface RecipeInstructionService {

    RecipeInstructionDto create(RecipeInstructionForm form);
    RecipeInstructionDto findById(Integer instructionId);
    List<RecipeInstructionDto> findAll();
    RecipeInstructionDto update(Integer instructionId, RecipeInstructionForm form);
    boolean delete(Integer instructionId);
}
