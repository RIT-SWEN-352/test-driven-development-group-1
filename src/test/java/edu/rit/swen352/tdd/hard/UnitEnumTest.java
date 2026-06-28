package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import edu.rit.swen352.tdd.hard.UnitEnum.*;

import static org.junit.jupiter.api.Assertions.*;

/**
* Test Suite for the {@link UnitEnum} component. 
*/

class UnitEnumTest{
    
    @Nested
    @DisplayName("Mass")
    class MassTest{
        
        @Nested
        class conversion{
            @Test
            @DisplayName("convert small unit to big unit (result > 1)")
            void convert_to_big(){
                Mass CuT = Mass.GRAM;
                Mass kg = Mass.KILOGRAM;
                double conversionRatio = CuT.conversionRatio(kg);
                assertEquals(1000, conversionRatio, "Conversion calculated improperly");
            }
    
            @Test
            @DisplayName("convert big unit to small unit (decimal result)")
            void convert_to_small(){
                Mass CuT = Mass.GRAM;
                Mass mg = Mass.MILLIGRAM;
                double conversionRatio = CuT.conversionRatio(mg);
                assertEquals(.001, conversionRatio);
            }
        }

        @ParameterizedTest
        @MethodSource
        void toStringTest(Mass unit, String abbr){
            assertEquals(abbr,unit.toString());
        }

        private static Arguments[] toStringTest(){
            return new Arguments[] {
                Arguments.of(Mass.GRAM,"g"),
                Arguments.of(Mass.MILLIGRAM,"mg"),
                Arguments.of(Mass.KILOGRAM,"kg"),
                Arguments.of(Mass.OUNCE,"oz"),
                Arguments.of(Mass.POUND,"lb"),
            };
        }


    }



}
