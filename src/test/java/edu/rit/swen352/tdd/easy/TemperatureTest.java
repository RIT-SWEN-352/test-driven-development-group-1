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
    @DisplayName("convert to CELSIUS temperature unit")
    void convert_1() {
        final Temperature CuT_1 = new Temperature(32, TemperatureUnit.FAHRENHEIT);
        assertEquals(0, CuT_1.convertTo(TemperatureUnit.CELSIUS));

        final Temperature CuT_2 = new Temperature(0, TemperatureUnit.FAHRENHEIT);
        assertEquals(-17.778, CuT_2.convertTo(TemperatureUnit.CELSIUS));

        final Temperature CuT_3 = new Temperature(2322, TemperatureUnit.KELVIN);
        assertEquals(2048.85, CuT_3.convertTo(TemperatureUnit.CELSIUS));

        final Temperature CuT_4 = new Temperature(-10.4, TemperatureUnit.KELVIN);
        assertEquals(-283.55, CuT_4.convertTo(TemperatureUnit.CELSIUS));

        final Temperature CuT_5 = new Temperature(90, TemperatureUnit.CELSIUS);
        assertEquals(90, CuT_5.convertTo(TemperatureUnit.CELSIUS));
    }

    @Test
    @DisplayName("convert to FAHRENHEIT temperature unit")
    void convert_2() {
        final Temperature CuT_1 = new Temperature(43, TemperatureUnit.CELSIUS);
        assertEquals(109.40, CuT_1.convertTo(TemperatureUnit.FAHRENHEIT));

        final Temperature CuT_2 = new Temperature(-89, TemperatureUnit.CELSIUS);
        assertEquals(-128.20, CuT_2.convertTo(TemperatureUnit.FAHRENHEIT));

        final Temperature CuT_3 = new Temperature(14, TemperatureUnit.KELVIN);
        assertEquals(-434.47, CuT_3.convertTo(TemperatureUnit.FAHRENHEIT));

        final Temperature CuT_4 = new Temperature(0, TemperatureUnit.KELVIN);
        assertEquals(-459.67, CuT_4.convertTo(TemperatureUnit.FAHRENHEIT));

        final Temperature CuT_5 = new Temperature(0, TemperatureUnit.FAHRENHEIT);
        assertEquals(0, CuT_5.convertTo(TemperatureUnit.FAHRENHEIT));
    }

    @Test
    @DisplayName("convert to KELVIN temperature unit")
    void convert_3() {
        final Temperature CuT_1 = new Temperature(20, TemperatureUnit.CELSIUS);
        assertEquals(293.15, CuT_1.convertTo(TemperatureUnit.KELVIN));

        final Temperature CuT_2 = new Temperature(1, TemperatureUnit.CELSIUS);
        assertEquals(274.15, CuT_2.convertTo(TemperatureUnit.KELVIN));

        final Temperature CuT_3 = new Temperature(32, TemperatureUnit.FAHRENHEIT);
        assertEquals(273.15, CuT_3.convertTo(TemperatureUnit.KELVIN));

        final Temperature CuT_4 = new Temperature(12223, TemperatureUnit.FAHRENHEIT);
        assertEquals(7045.928, CuT_4.convertTo(TemperatureUnit.KELVIN));

        final Temperature CuT_5 = new Temperature(45, TemperatureUnit.KELVIN);
        assertEquals(45, CuT_5.convertTo(TemperatureUnit.KELVIN));
    }

    
  }

