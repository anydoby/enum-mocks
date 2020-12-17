package com.anydoby.enums;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Animal.class)
public class AnimalFeederIllegalEnumTest {
    
    private static Animal strangeAnimal;
    private AnimalFeeder sut;

    @BeforeClass
    public static void prepareEnum() {
        int optionsLength = Animal.values().length;
        Animal[] newAnimals = new Animal[optionsLength + 1];
        System.arraycopy(Animal.values(), 0, newAnimals, 0, optionsLength);
        strangeAnimal = PowerMockito.mock(Animal.class);
        Whitebox.setInternalState(strangeAnimal, "name", Integer.toString(optionsLength));
        Whitebox.setInternalState(strangeAnimal, "ordinal", optionsLength);
        newAnimals[optionsLength] = strangeAnimal;

        try {
            // works in eclipse
            Whitebox.setInternalState(Animal.class, "ENUM$VALUES", newAnimals);
        } catch (Exception e) {
            // some JDK's put these in different field
            Whitebox.setInternalState(Animal.class, "$VALUES", newAnimals);
        }
    }
    
    @Before
    public void prepareFeeder() {
        sut = new AnimalFeeder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void unknown() {
        sut.feed(strangeAnimal);
    }
    
}
