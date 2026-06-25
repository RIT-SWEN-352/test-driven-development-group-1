package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link BankAccount} component.
 */
class BankAccountTest {

        @Test
        @DisplayName("ctor with provided balance")
        void ctor_1() {
            final BankAccount CuT = new BankAccount(100, 50);
            assertAll("ctor_1 assertions"
                , () -> assertNotNull(CuT)
                , () -> assertEquals(100, CuT.dollars, "Dollar value is stored correctly")
                , () -> assertEquals(50, CuT.cents, "Cents value is stored correctly")
            );
        }

        
}
