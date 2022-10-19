package se.lexicon.myjpaassignmentspringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myjpaassignmentspringdata.data.repository.*;
import se.lexicon.myjpaassignmentspringdata.entity.*;
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



        seedingCategory();
        seedingCategory4();

        seedingRecipeCategory();
//        seedingRecipeIngredient();


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


// --- Instruction

        private void seedingInstructionTomatoSoup() throws InterruptedException {
        RecipeInstruction potatolarkitssoup = recipeInstructionRepository.save(new RecipeInstruction(1,"Peel the potatoes, then cut them into smaller pieces. Put them in water so that they do not darken.Then mix with lakrits."));
        }

        private void seedingInstructionStromming() throws InterruptedException {
        RecipeInstruction stromminglarkitssoup = recipeInstructionRepository.save(new RecipeInstruction(2, "Open the jar with sour baltic herring and mix it with licorice.Put them in a saucepan and cook until they are soft."));
        }


// --- category

        private void seedingCategory() throws InterruptedException {

        RecipeCategory western = recipeCategoryRepository.save(new RecipeCategory("Western"));
        RecipeCategory asien = recipeCategoryRepository.save(new RecipeCategory("Asien"));
        RecipeCategory italy = recipeCategoryRepository.save(new RecipeCategory("Italy"));
        }

        private void seedingCategory4() throws InterruptedException {
        Recipe miracle = recipeRepository.save(new Recipe("Wonderful soup with a toch of lakrits."));
        RecipeInstruction soup = recipeInstructionRepository.save(new RecipeInstruction(2,"Open the jar with sour baltic herring and mix it with licorice."));
        miracle.setInstruction(soup);
        }

    // --- combination


        private void seedingRecipeCategory() throws InterruptedException {
        Recipe miraclesoup = recipeRepository.save(new Recipe("Miracle soup with a toch of lakrits."));
        RecipeCategory western = recipeCategoryRepository.save(new RecipeCategory("Western"));
        miraclesoup.addRecipeCategorys((western));

        Recipe potatolarkitssoup = recipeRepository.save(new Recipe("Miracle soup with a toch of lakrits."));
        RecipeCategory asien = recipeCategoryRepository.save(new RecipeCategory("Asien"));
        potatolarkitssoup.addRecipeCategorys(asien);
        }


//        private void seedingRecipeIngredient() throws InterruptedException {
//        Recipe miraclesoup = recipeRepository.save(new Recipe("Miracle soup with a toch of lakrits."));
//        Ingredient tomat = ingredientRepository.save(new Ingredient("tomat"));
//        RecipeIngredient ingredients = recipeIngredientRepository.save(new RecipeIngredient("123",tomat, 1, Measurement.TBSP, miraclesoup));
//
//        ingredients.getIngredient().toString();
//
//        }



// --- find

        private void findIngredientByIngredientNames(){
        Optional<Ingredient> tomat = ingredientRepository.findIngredientByIngredientNames("tomat");
        tomat.ifPresent(System.out::println);
        }

        private void findByIngredientNameFragment(){
        Optional<Ingredient> foundIngredientByIngredientNameFragment = ingredientRepository.findIngredientNameByIngredientNameContaining("sal");
        foundIngredientByIngredientNameFragment.ifPresent(System.out::println);
        }

}

