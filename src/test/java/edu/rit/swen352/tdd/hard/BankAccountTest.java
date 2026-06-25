package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.rit.swen352.tdd.sample.Counter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link BankAccount} component.
 */
class BankAccountTest {

        @Test
        @DisplayName("ctor with provided balance")
        void ctor_1() {
            //final Money testBalance = new Money(100, 50);
            final BankAccount CuT = new BankAccount(new Money(100, 50));
            assertAll("ctor_1 assertions"
                , () -> assertNotNull(CuT)
                , () -> assertEquals(100, CuT.money.dollars(), "Dollar value is stored correctly")
                , () -> assertEquals(50, CuT.money.cents(), "Cents value is stored correctly")
            );
        }

        @Test
        @DisplayName("ctor rejects negative input")
        void ctor_1_fail() {
            final Money testBalance = new Money (-25, 35);
            final Exception e = assertThrows(IllegalArgumentException.class, () -> new BankAccount(testBalance));
            assertEquals("Balance cannot be negative.", e.getMessage());
        }

        @Test
        @DisplayName("ctor with default balance")
        void ctor_2() {
            final BankAccount CuT = new BankAccount();
            assertNotNull(CuT);
        }
}
