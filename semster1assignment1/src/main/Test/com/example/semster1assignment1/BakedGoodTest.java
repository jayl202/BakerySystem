package com.example.semster1assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BakedGoodTest {
    @Test
    public void testConstructorAndGetters() {
        BakedGood bg = new BakedGood("Cake", "France", "A sweet, baked dessert", "cake.jpg");
        assertEquals("Cake", bg.getGoodName());
        assertEquals("France", bg.getGoodOrigin());
        assertEquals("A sweet, baked dessert", bg.getGoodDescription());
        assertEquals("cake.jpg", bg.getGoodImage());
    }

    @Test
    public void testSetters() {
        BakedGood bg = new BakedGood("Cake", "France", "A sweet, baked dessert", "cake.jpg");
        bg.setGoodName("Pie");
        bg.setGoodOrigin("USA");
        bg.setGoodDescription("A baked dish with a pastry crust and filling");
        bg.setGoodImage("pie.jpg");
        assertEquals("Pie", bg.getGoodName());
        assertEquals("USA", bg.getGoodOrigin());
        assertEquals("A baked dish with a pastry crust and filling", bg.getGoodDescription());
        assertEquals("pie.jpg", bg.getGoodImage());
    }

}