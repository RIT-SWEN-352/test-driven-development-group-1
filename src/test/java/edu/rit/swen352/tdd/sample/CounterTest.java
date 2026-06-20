package edu.rit.swen352.tdd.sample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link Counter} component.
 */
class CounterTest {

  @ParameterizedTest(name = "Test lower={0}, upper={1}")
  @CsvSource({"1,10", "42,47", "5,10"})
  @DisplayName("ctor with both bounds")
  void ctor_1(int lower, int upper) {
    final Counter CuT = new Counter(lower, upper);
    assertAll("group assertions"
      , () -> assertNotNull(CuT)
      , () -> assertEquals(lower, CuT.getLower(), "Lower bound is correct")
      , () -> assertEquals(upper, CuT.getUpper(), "Upper bound is correct")
      , () -> assertEquals(lower, CuT.getCount(), "Count is correct")
    );
  }

  @Test
  @DisplayName("ctor rejects lower >= upper")
  void ctor_1_fail() {
    final Exception e = assertThrows(IllegalArgumentException.class, () -> new Counter(10, 1));
    assertEquals("lower must be less than upper", e.getMessage());
  }

  @Test
  @DisplayName("ctor with only lower bound")
  void ctor_2() {
    final Counter CuT = new Counter(1);
    assertAll("group assertions"
      , () -> assertNotNull(CuT)
      , () -> assertEquals(1, CuT.getLower(), "Lower bound is correct")
      , () -> assertEquals(Integer.MAX_VALUE, CuT.getUpper(), "Upper bound is correct")
      , () -> assertEquals(1, CuT.getCount(), "Count is correct")
    );
  }

  @Test
  @DisplayName("ctor with no bounds supplied")
  void ctor_3() {
    final Counter CuT = new Counter();
    assertAll("group assertions"
      , () -> assertNotNull(CuT)
      , () -> assertEquals(0, CuT.getLower(), "Lower bound is correct")
      , () -> assertEquals(Integer.MAX_VALUE, CuT.getUpper(), "Upper bound is correct")
      , () -> assertEquals(0, CuT.getCount(), "Count is correct")
    );
  }

  @Test
  @DisplayName("increment with valid range")
  void increment_1() {
    // Arrange
    final Counter CuT = new Counter(4,5);
    // Act
    CuT.increment();
    // Assert
    assertEquals(5, CuT.getCount());
  }

  @Test
  @DisplayName("increment outside of upper")
  void increment_2() {
    // Arrange
    final Counter CuT = new Counter(4,5);
    // Act
    CuT.increment();
    final Exception e = assertThrows(IllegalStateException.class, () -> CuT.increment());
    // Assert
    assertAll("group assertions"
      , () -> assertEquals(5, CuT.getCount())
      , () -> assertEquals(Counter.INCREMENT_ERROR, e.getMessage())
    );
  }

  @Test
  @DisplayName("decrement with valid range")
  void decrement_1() {
    // Arrange
    final Counter CuT = new Counter(4,5);
    // Act
    CuT.increment();
    CuT.decrement();
    // Assert
    assertEquals(4, CuT.getCount());
  }

  @Test
  @DisplayName("decrement below the lower bound must fail")
  void decrement_2() {
    // Arrange
    final Counter CuT = new Counter(4,5);
    // Act
    final Exception e = assertThrows(IllegalStateException.class, () -> CuT.decrement());
    // Assert
    assertAll("group assertions"
      , () -> assertEquals(4, CuT.getCount())
      , () -> assertEquals(Counter.DECREMENT_ERROR, e.getMessage())
    );
  }

}
