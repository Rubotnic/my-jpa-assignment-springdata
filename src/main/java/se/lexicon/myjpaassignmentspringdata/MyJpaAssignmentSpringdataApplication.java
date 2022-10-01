package se.lexicon.myjpaassignmentspringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myjpaassignmentspringdata.data.repository.*;
import se.lexicon.myjpaassignmentspringdata.entity.Ingredient;

import java.util.Optional;

@SpringBootApplication
public class MyJpaAssignmentSpringdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyJpaAssignmentSpringdataApplication.class, args);
    }
}

@Profile("dev")
@Transactional
@Component
    class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    public MyCommandLineRunner(MeasurementRepository measurementRepository, IngredientRepository ingredientRepository, RecipeCategoryRepository recipeCategoryRepository, RecipeIngredientRepository recipeIngredientRepository, RecipeInstructionRepository recipeInstructionRepository, RecipeRepository recipeRepository) {
        this.measurementRepository = measurementRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeCategoryRepository = recipeCategoryRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeInstructionRepository = recipeInstructionRepository;
        this.recipeRepository = recipeRepository;
    }

    IngredientRepository ingredientRepository;
    RecipeCategoryRepository recipeCategoryRepository;
    RecipeIngredientRepository recipeIngredientRepository;
    RecipeInstructionRepository recipeInstructionRepository;
    MeasurementRepository measurementRepository;
    RecipeRepository recipeRepository;

    @Override
        public void run(String... args) throws Exception {

        seedingData();
        findIngredientByIngredientNames();

    }



        private void seedingData() throws InterruptedException {
        Ingredient tomat = ingredientRepository.save(new Ingredient("tomat"));
        }


        private void findIngredientByIngredientNames(){
        Optional<Ingredient> tomat = ingredientRepository.findIngredientByIngredientNames("tomat");
        tomat.ifPresent(System.out::println);
    }


    }

