package se.lexicon.myjpaassignmentspringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myjpaassignmentspringdata.model.entity.*;
import se.lexicon.myjpaassignmentspringdata.repository.*;

import java.util.Optional;


@SpringBootApplication
public class MyJpaAssignmentSpringdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyJpaAssignmentSpringdataApplication.class, args);
    }
}
//
//@Profile("dev")
//@Transactional
//@Component
//    class MyCommandLineRunner implements CommandLineRunner {
//
//    @Autowired
//    public MyCommandLineRunner(MeasurementRepository measurementRepository, IngredientRepository ingredientRepository, RecipeCategoryRepository recipeCategoryRepository, RecipeIngredientRepository recipeIngredientRepository, RecipeInstructionRepository recipeInstructionRepository, RecipeRepository recipeRepository) {
//        this.measurementRepository = measurementRepository;
//        this.ingredientRepository = ingredientRepository;
//        this.recipeCategoryRepository = recipeCategoryRepository;
//        this.recipeIngredientRepository = recipeIngredientRepository;
//        this.recipeInstructionRepository = recipeInstructionRepository;
//        this.recipeRepository = recipeRepository;
//    }
//
//    IngredientRepository ingredientRepository;
//    RecipeCategoryRepository recipeCategoryRepository;
//    RecipeIngredientRepository recipeIngredientRepository;
//    RecipeInstructionRepository recipeInstructionRepository;
//    MeasurementRepository measurementRepository;
//    RecipeRepository recipeRepository;
//
//    @Override
//        public void run(String... args) throws Exception {
//
//
//        seedingIngredient();
//
//        seedingInstructionStromming();
//        seedingInstructionTomatoSoup();
//
//        findIngredientByIngredientNames();
//        findByIngredientNameFragment();
//
//        seedingCategory();
//        seedingCategory3();
//        seedingCategory4();
//
//    }
//
//// --- Ingredient
//        private void seedingIngredient() throws InterruptedException {
//        Ingredient tomat = ingredientRepository.save(new Ingredient("tomat"));
//        Ingredient potatis = ingredientRepository.save(new Ingredient("potatis"));
//        Ingredient stromming = ingredientRepository.save(new Ingredient("surströmming"));
//        Ingredient lakrits = ingredientRepository.save(new Ingredient("licorice"));
//        Ingredient water = ingredientRepository.save(new Ingredient("water"));
//        Ingredient salt = ingredientRepository.save(new Ingredient("salt"));
//    }
//
//// --- Instruction
//        private void seedingInstructionTomatoSoup() throws InterruptedException {
//        RecipeInstruction potatolarkitssoup = recipeInstructionRepository.save(new RecipeInstruction(1,"Peel the potatoes, then cut them into smaller pieces. Put them in water so that they do not darken.Then mix with licorice."));
//    }
//
//        private void seedingInstructionStromming() throws InterruptedException {
//        RecipeInstruction stromminglarkitssoup = recipeInstructionRepository.save(new RecipeInstruction(2, "Open the jar with sour baltic herring and mix it with licorice.Put them in a saucepan and cook until they are soft."));
//    }
//
//// --- category
//        private void seedingCategory() throws InterruptedException {
//        RecipeCategory western = recipeCategoryRepository.save(new RecipeCategory("Western"));
//        RecipeCategory asien = recipeCategoryRepository.save(new RecipeCategory("Asien"));
//        RecipeCategory italy = recipeCategoryRepository.save(new RecipeCategory("Italy"));
//    }
//
//
//// --- combination
//
//        private void seedingCategory4() throws InterruptedException {
//        Recipe miracleHerring = recipeRepository.save(new Recipe("Wonderful herring dish"));
//        RecipeInstruction soup = recipeInstructionRepository.save(new RecipeInstruction(1,"Peel the potatoes, then cut them into smaller pieces. Put them in water so that they do not darken.Then mix with licorice."));
//        miracleHerring.setInstruction(soup);
//    }
//
//    private void seedingCategory3() throws InterruptedException {
//        Recipe asienFood = recipeRepository.save(new Recipe("Potato soup with a touch of licorice"));
//        RecipeInstruction soupInstructoin = recipeInstructionRepository.save(new RecipeInstruction(2,"Open the jar with sour baltic herring and mix it with licorice. Put them in a saucepan and cook until they are soft."));
//        asienFood.setInstruction(soupInstructoin);
//    }
//
//
//
//
//// --- find
//
//        private void findIngredientByIngredientNames(){
//        Optional<Ingredient> tomat = ingredientRepository.findIngredientByIngredientNames("tomat");
//        tomat.ifPresent(System.out::println);
//        }
//
//        private void findByIngredientNameFragment(){
//        Optional<Ingredient> foundIngredientByIngredientNameFragment = ingredientRepository.findIngredientNameByIngredientNameContaining("sal");
//        foundIngredientByIngredientNameFragment.ifPresent(System.out::println);
//        }
//}

