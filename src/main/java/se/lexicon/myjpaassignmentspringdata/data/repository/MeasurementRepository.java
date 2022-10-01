package se.lexicon.myjpaassignmentspringdata.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.myjpaassignmentspringdata.entity.RecipeCategory;

public interface MeasurementRepository extends JpaRepository<RecipeCategory, Integer> {
}
