package com.anydoby.enums;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalFeederTest {
    
    private AnimalFeeder sut;

    @Before
    public void prepareFeeder() {
        sut = new AnimalFeeder();
    }

    @Test
    public void cat() {
        assertEquals(Food.CAT_FOOD, sut.feed(Animal.CAT));
    }

    @Test
    public void dog() {
        assertEquals(Food.DOG_FOOD, sut.feed(Animal.DOG));
    }
    
}
