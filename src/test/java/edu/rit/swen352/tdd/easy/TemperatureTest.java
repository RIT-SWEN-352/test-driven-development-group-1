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
        final Temperature CuT = new Temperature(0, TemperatureUnit.FAHRENHEIT);
        assertNotNull(CuT);
    }
    
    @Test
    @DisplayName("ctor with only value")
    void ctor_2() {
        final Temperature CuT = new Temperature(0);
        assertNotNull(CuT);
    }

  }

