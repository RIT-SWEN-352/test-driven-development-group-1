package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.rit.swen352.tdd.easy.Temperature.TemperatureUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link Temperature} component.
 */
class TemperatureTest {

    @Test
    @DisplayName("ctor with both values")
    void ctor_1() {
        final Temperature CuT = new Temperature(0, TemperatureUnit.KELVIN);
        assertAll("ctor_1 assertions"
            , () -> assertNotNull(CuT)
            , () -> assertEquals(0, CuT.getValue(), "Value is correct")
            , () -> assertEquals(TemperatureUnit.KELVIN, CuT.getUnit(), "Unit is correct")
        );
        
    }
    
    @Test
    @DisplayName("ctor with only value")
    void ctor_2() {
        final Temperature CuT = new Temperature(0);
        assertAll("ctor_2 assertions"
            , () -> assertNotNull(CuT)
            , () -> assertEquals(0, CuT.getValue(), "Value is correct")
            , () -> assertEquals(TemperatureUnit.FAHRENHEIT, CuT.getUnit(), "Unit is correct")
        );
    }

    @Test
    @DisplayName("convert to new temperature unit")
    void convert_1() {
        final Temperature CuT = new Temperature(32, TemperatureUnit.FAHRENHEIT);
        CuT.convertTo(TemperatureUnit.CELSIUS);
        assertEquals(0, CuT.getValue());
    }
  }

