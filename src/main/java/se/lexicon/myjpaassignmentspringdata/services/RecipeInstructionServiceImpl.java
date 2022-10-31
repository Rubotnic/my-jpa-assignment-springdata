package se.lexicon.myjpaassignmentspringdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myjpaassignmentspringdata.exception.ResourceNotFoundException;
import se.lexicon.myjpaassignmentspringdata.model.dto.RecipeInstructionDto;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeInstruction;
import se.lexicon.myjpaassignmentspringdata.model.form.RecipeInstructionForm;
import se.lexicon.myjpaassignmentspringdata.repository.RecipeInstructionRepository;
import se.lexicon.myjpaassignmentspringdata.repository.RecipeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeInstructionServiceImpl implements RecipeInstructionService{

    private final RecipeRepository recipeRepository;
    private final RecipeInstructionRepository recipeInstuRepository;
    private final ConversionService conversion;


    @Autowired
    public RecipeInstructionServiceImpl(RecipeRepository recipeRepository, RecipeInstructionRepository recipeInstuRepository, ConversionService conversion) {
        this.recipeInstuRepository = recipeInstuRepository;
        this.recipeRepository = recipeRepository;
        this.conversion = conversion;
    }

    @Override
    @Transactional
    public RecipeInstructionDto create(RecipeInstructionForm form) {
        RecipeInstruction save = recipeInstuRepository.save(conversion.toRecipeInstruction(form));
        return conversion.toRecipeInstructionDto(save);
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeInstructionDto findById(Integer instructionId) {
        return conversion.toRecipeInstructionDto(recipeRepository.findById(instructionId).orElseThrow(()-> new ResourceNotFoundException("Could not find TodoItem with id: " + instructionId)).getInstruction());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecipeInstructionDto> findAll() {
            List<RecipeInstruction> allFound = (List<RecipeInstruction>) recipeInstuRepository.findAll();
            return allFound.stream()
                    .map(conversion::toRecipeInstructionDto)
                    .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RecipeInstructionDto update(Integer instructionId, RecipeInstructionForm form) {

        RecipeInstruction found = recipeInstuRepository.findById(instructionId).orElseThrow( () -> new ResourceNotFoundException("could not find by id:" + instructionId));
        found.setInstruction(form.getInstruction());
        return conversion.toRecipeInstructionDto(found);
    }

    @Override
    @Transactional
    public boolean delete(Integer instructionId) {
        recipeInstuRepository.deleteById(instructionId);
        return !recipeInstuRepository.findById(instructionId).isPresent();
    }
}
