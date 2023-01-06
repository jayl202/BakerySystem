package com.example.semster1assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    @Test
    public void testRecipeConstructor() {
        Recipe recipe = new Recipe("flour", "sugar", "eggs", "2 cups");
        assertEquals("flour", recipe.getIngredient1());
        assertEquals("sugar", recipe.getIngredient2());
        assertEquals("eggs", recipe.getIngredient3());
        assertEquals("2 cups", recipe.getQuantity());
    }

    @Test
    public void testRecipeSetters() {
        Recipe recipe = new Recipe("flour", "sugar", "eggs", "2 cups");
        recipe.setIngredient1("butter");
        recipe.setIngredient2("milk");
        recipe.setIngredient3("vanilla extract");
        recipe.setQuantity("1 cup");
        assertEquals("butter", recipe.getIngredient1());
        assertEquals("milk", recipe.getIngredient2());
        assertEquals("vanilla extract", recipe.getIngredient3());
        assertEquals("1 cup", recipe.getQuantity());
    }

    @Test
    public void testRecipeToString() {
        Recipe recipe = new Recipe("flour", "sugar", "eggs", "2 cups");
        String expectedString = "   Ingredient One : flour   Ingredient Two : sugar   Ingredient Three :eggs   Quantity : 2 cups";
        assertEquals(expectedString, recipe.toString());
    }


}