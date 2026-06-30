package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link SimpleBankAccount} component.
 */
class SimpleBankAccountTest {
    @Test
    @DisplayName("Constructor: with supplied balance (ex:3000.75")
    void testConstructorWithSuppliedBalance() {
        float balance = 3000.75f;
        SimpleBankAccount simpleAcount = new SimpleBankAccount(balance);
        assertEquals(balance, simpleAcount.getBalance());
    }

    @Test
    @DisplayName("Constructor: without supplied balance (default = 0")
    void testConstructorWithoutSuppliedBalance() {
        SimpleBankAccount simpleAcount = new SimpleBankAccount();
        float expectedBalance = 0.00f;
        assertEquals(expectedBalance, simpleAcount.getBalance());
    }
}
