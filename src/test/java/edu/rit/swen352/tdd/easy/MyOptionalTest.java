package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
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

        String objectNotCreated =  "Object was not created";
        String objectNotEmpty = "Object is not empty";

        @Test
        @DisplayName("empty")
        void empty_factory(){
            final MyOptional<String> x = MyOptional.empty();

            assertAll(
                ()-> assertNotNull(x,objectNotCreated), //Was it created?
                ()-> assertNull(x.value, objectNotEmpty) //Is the object empty
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
                    ()->assertNotNull(x,objectNotCreated),
                    ()->assertEquals(testVal, x.value, "Value was not set correctly")
                );
            }

            @Test
            @DisplayName("passed invalid value (null)")
            void invalid_value(){
                Exception exc = assertThrows(InvalidParameterException.class, ()->MyOptional.of(null),"Null values should throw an invalid parameter exception");
                assertEquals(MyOptional.nullParamMsg, exc.getMessage(),"InvalidParameterException message was not the correct message");
            }

        }

        @Nested
        @DisplayName("ofNullable")
        class ofNullable{ 

            @Test
            @DisplayName("passed value (of)")
            void valid_value(){
                final MyOptional<String> x = MyOptional.ofNullable(testVal);
                assertAll(
                    ()->assertNotNull(x, objectNotCreated),
                    ()->assertEquals(testVal, x.value)
                );
            }

            @Test
            @DisplayName("passed null value (empty)")
            void null_value(){
                final MyOptional<String> x = MyOptional.ofNullable(null);
                assertAll(
                    ()->assertNotNull(x,objectNotCreated),
                    ()->assertNull(x.value, objectNotEmpty)
                );
            }

            @Test
            @DisplayName("passed no value (empty)")
            void empty_value(){
                final MyOptional<String> x = MyOptional.ofNullable();
                assertAll(
                ()-> assertNotNull(x,objectNotCreated), //Was it created?
                ()-> assertNull(x.value, objectNotEmpty) //Is the object empty
                );
            }

        }

    }


    @Nested
    @DisplayName("non-static functions")
    class non_static{

        String Z = "Z";
        Consumer<String> changeZtoA = changeTo -> Z=changeTo;

        @Nested
        @DisplayName("on empty optional: ")
        class empty{
    
            @BeforeEach
            void empty_optional(){
                x = MyOptional.empty();
            }
    
            @Test
            @DisplayName("isPresent")
            void is_present(){
                boolean pres = x.isPresent();
                assertFalse(pres,"Empty optional should return false for isPresent()");
            }

            @Test
            @DisplayName("get")
            void get(){
                Exception exc = assertThrows(NoSuchElementException.class,()->x.get(),"Empty optionals should throw NoSuchElementException");
                assertEquals(MyOptional.noSuchElem, exc.getMessage());
            }

            @Test
            @DisplayName("ifPresent")
            void if_present(){
                x.ifPresent(changeZtoA);
                assertEquals("Z",Z,"Consumer should not be executed for an empty optional");
                Z="Z";
            }
    
        }
    
        @Nested
        @DisplayName("on optional with value: ")
        class value{
            @BeforeEach
            void valued_optional(){
                x = MyOptional.of(testVal);
            }
    
            @Test
            @DisplayName("isPresent")
            void is_present(){
                boolean pres = x.isPresent();
                assertTrue(pres,"Optional with value returns false");
            }

            @Test
            @DisplayName("get")
            void get(){
                String boj = assertDoesNotThrow(()->x.get(),"get should not throw an exception for a non-empty optional");
                assertEquals(testVal, boj,"get returned incorrect value");
            }

            @Test
            @DisplayName("ifPresent")
            @Tag("usesConsumer")
            void ifPresent(){
                x.ifPresent(changeZtoA);
                assertEquals(testVal, Z,"Consumer was not executed for an optional with a value");
                Z="Z";
            }
        }
    }


}
