package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import edu.rit.swen352.tdd.hard.UnitEnum.*;

import static org.junit.jupiter.api.Assertions.*;

/**
* Test Suite for the {@link UnitEnum} component. 
*/

class UnitEnumTest{
    
    @Nested
    @DisplayName("Mass")
    class MassTest{
        
        @Test
        @DisplayName("Convert")
        void convert(){
            Mass CuT = Mass.GRAM;
            Mass kg = Mass.KILOGRAM;
            double conversionRatio = CuT.conversionRatio(kg);
            assertEquals(1000, conversionRatio);
        }

    }



}
