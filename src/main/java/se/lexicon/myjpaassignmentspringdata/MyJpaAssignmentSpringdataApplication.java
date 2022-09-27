package se.lexicon.myjpaassignmentspringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myjpaassignmentspringdata.data.repository.*;

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

        IngredientRepository ingredientRepository;
        RecipeCategoryRepository recipeCategoryRepository;
        RecipeIngredientRepository recipeIngredientRepository;
        RecipeInstructionRepository recipeInstructionRepository;
        RecipeRepository recipeRepository;

    @Autowired
    public MyCommandLineRunner(IngredientRepository ingredientRepository, RecipeCategoryRepository recipeCategoryRepository, RecipeIngredientRepository recipeIngredientRepository, RecipeInstructionRepository recipeInstructionRepository, RecipeRepository recipeRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeCategoryRepository = recipeCategoryRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeInstructionRepository = recipeInstructionRepository;
        this.recipeRepository = recipeRepository;

    }

    @Override
        public void run(String... args) throws Exception {


    }

}
