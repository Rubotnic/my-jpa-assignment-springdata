package se.lexicon.myjpaassignmentspringdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeInstruction;

public interface RecipeInstructionRepository extends JpaRepository<RecipeInstruction, Integer> {


    @Override
    default <S extends RecipeInstruction> S saveAndFlush(S entity) {
        return null;
    }



}
