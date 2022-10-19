package se.lexicon.myjpaassignmentspringdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.myjpaassignmentspringdata.model.entity.RecipeCategory;

public interface MeasurementRepository extends JpaRepository<RecipeCategory, Integer> {
}
