package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
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
            final MyOptional<String> x = MyOptional.empty();

            assertAll(
                ()-> assertNotNull(x,"Object was not created"), //Was it created?
                ()-> assertNull(x.value, "Object is not empty") //Is the object empty
            );
        }  

        @Nested
        @DisplayName("of")
        class of{ 

            @Test
            @DisplayName("passed valid value")
            void valid_value(){
                final MyOptional<String> x = MyOptional.of(testVal);
                assertAll(
                    ()->assertNotNull(x),
                    ()->assertEquals(testVal, x.value)
                );
            }

            @Test
            @DisplayName("passed invalid value (null)")
            void invalid_value(){
                Exception exc = assertThrows(InvalidParameterException.class, ()->MyOptional.of(null));
                assertEquals("Value cannot be null", exc.getMessage());
            }

        }

    }

}
