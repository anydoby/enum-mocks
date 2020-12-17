package com.anydoby.enums;

public class AnimalFeeder {

    public Food feed(Animal animal) {
        switch (animal) {
        case CAT:
            return Food.CAT_FOOD;
        case DOG:
            return Food.DOG_FOOD;
        default:
            throw new IllegalArgumentException("I don't know about animal " + animal.name());
        }
    }

}
