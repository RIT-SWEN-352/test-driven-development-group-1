package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;


/**
 * Test suite for the {@link MyOptional} component.
 */
class MyOptionalTest {
    
    private String testVal = "Bojangles";
    protected MyOptional<String> x;

    @DisplayName("factories: ")
    @Nested
    class factories{

        @Test
        @DisplayName("empty")
        void empty_factory(){
            x = MyOptional.empty();

            assertAll(
                ()-> assertNotNull(x,"Object was not created"), //Was it created?
                ()-> assertNull(x.value, "Object is not empty") //Is the object empty
            );
        }  

    }

}
