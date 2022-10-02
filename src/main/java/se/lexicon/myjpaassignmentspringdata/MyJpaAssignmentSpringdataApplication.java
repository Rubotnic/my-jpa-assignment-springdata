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
import se.lexicon.myjpaassignmentspringdata.entity.Recipe;
import se.lexicon.myjpaassignmentspringdata.entity.RecipeCategory;
import se.lexicon.myjpaassignmentspringdata.entity.RecipeInstruction;


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

//        seedingRecipeInstruction();
//
//        seedingCategory1();
//        seedingCategory2();

        seedingSalt();
        seedingWater();
        seedingLakrits();
        seedingStromming();
        seedingTomato();
        seedingPotato();


        seedingInstructionStromming();
        seedingInstructionTomatoSoup();


        findIngredientByIngredientNames();
        findByIngredientNameFragment();

        seedingRecipe1();
        seedingRecipe2();

        seedingRecipeInstruction1();


    }



        private void seedingTomato() throws InterruptedException {
        Ingredient tomat = ingredientRepository.save(new Ingredient("tomat"));
        }
        private void seedingPotato() throws InterruptedException {
        Ingredient potatis = ingredientRepository.save(new Ingredient("potatis"));
        }
        private void seedingStromming() throws InterruptedException {
        Ingredient stromming = ingredientRepository.save(new Ingredient("surströmming"));
        }
        private void seedingLakrits() throws InterruptedException {
            Ingredient lakrits = ingredientRepository.save(new Ingredient("lakrits"));
        }
        private void seedingWater() throws InterruptedException {
        Ingredient water = ingredientRepository.save(new Ingredient("water"));
        }
        private void seedingSalt() throws InterruptedException {
        Ingredient salt = ingredientRepository.save(new Ingredient("salt"));
        }


//        private void seedingCategory1() throws InterruptedException {
//        RecipeCategory western = recipeCategoryRepository.save(new RecipeCategory("Western"));
//        }
//        private void seedingCategory2() throws InterruptedException {
//        RecipeCategory asien = recipeCategoryRepository.save(new RecipeCategory("Asien"));
//        }


        private void seedingInstructionTomatoSoup() throws InterruptedException {
        RecipeInstruction potatolarkitssoup = recipeInstructionRepository.save(new RecipeInstruction(1,"Peel the potatoes, then cut them into smaller pieces. Put them in water so that they do not darken.Then mix with lakrits."));
    }
        private void seedingInstructionStromming() throws InterruptedException {
        RecipeInstruction stromminglarkitssoup = recipeInstructionRepository.save(new RecipeInstruction(2, "Open the jar with sour baltic herring and mix it with licorice.Put them in a saucepan and cook until they are soft."));
    }


        private void seedingRecipe1() throws InterruptedException {
        Recipe miraclesoup = recipeRepository.save(new Recipe("Miracle soup with a toch of lakrits."));

        RecipeCategory western = recipeCategoryRepository.save(new RecipeCategory("Western"));
        miraclesoup.addRecipeCategory(western);
        }

        private void seedingRecipe2() throws InterruptedException {
        Recipe wonderfulsoup = recipeRepository.save(new Recipe("wonderful soup with a toch of lakrits."));

        RecipeCategory asien = recipeCategoryRepository.save(new RecipeCategory("Asien"));
        wonderfulsoup.addRecipeCategory(asien);
        }



        private void seedingRecipeInstruction1() throws  InterruptedException{
        RecipeInstruction potatolarkitssoup = recipeInstructionRepository.save(new RecipeInstruction("text"));

        Recipe wonderfulsoup = recipeRepository.save(new Recipe("wonderful soup with a toch of lakrits."));


        }






        private void findIngredientByIngredientNames(){
        Optional<Ingredient> tomat = ingredientRepository.findIngredientByIngredientNames("tomat");
        tomat.ifPresent(System.out::println);
    }

        private void findByIngredientNameFragment(){
        Optional<Ingredient> foundIngredientByIngredientNameFragment = ingredientRepository.findIngredientNameByIngredientNameContaining("sal");
        foundIngredientByIngredientNameFragment.ifPresent(System.out::println);

    }

}

