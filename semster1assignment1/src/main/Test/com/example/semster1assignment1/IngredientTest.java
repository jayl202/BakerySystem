package com.example.semster1assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {
    @Test
    public void testConstructorAndGetters() {
        Ingredient ingredient = new Ingredient("Flour", "A powdery substance made from ground grains", "365");
        assertEquals("Flour", ingredient.getName());
        assertEquals("A powdery substance made from ground grains", ingredient.getDescription());
        assertEquals("365", ingredient.getCalories());
    }

    @Test
    public void testSetters() {
        Ingredient ingredient = new Ingredient("Flour", "A powdery substance made from ground grains", "365");
        ingredient.setName("Sugar");
        ingredient.setDescription("A sweet, white crystalline substance");
        ingredient.setCalories("387");
        assertEquals("Sugar", ingredient.getName());
        assertEquals("A sweet, white crystalline substance", ingredient.getDescription());
        assertEquals("387", ingredient.getCalories());
    }

}