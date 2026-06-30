package edu.rit.swen352.tdd.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link SimpleBankAccount} component.
 */
class SimpleBankAccountTest {

    // CONSTRUCTOR TESTS
    @Test
    @DisplayName("Constructor: with supplied balance (ex:3000.75")
    void testConstructorWithSuppliedBalance() {
        float balance = 3000.75f;
        SimpleBankAccount simpleAccount = new SimpleBankAccount(balance);
        assertEquals(balance, simpleAccount.getBalance());
    }

    @Test
    @DisplayName("Constructor: without supplied balance (default = 0")
    void testConstructorWithoutSuppliedBalance() {
        SimpleBankAccount simpleAccount = new SimpleBankAccount();
        float expectedBalance = 0.00f;
        assertEquals(expectedBalance, simpleAccount.getBalance());
    }

    // getBalance() TEST
    // Since constructor needed getBalance, the test for the getter passed automatically
    @Test
    @DisplayName("getBalance: returns current balance")
    void testGetBalanceNormal() {
        float balance = 10.75f;
        SimpleBankAccount simpleAccount = new SimpleBankAccount(balance);
        assertEquals(balance, simpleAccount.getBalance());
    }

    // isAccountEmpty() TESTS
    @Test
    @DisplayName("isAccountEmpty(): returns true for account balance being 0")
    void testIsAccountemptyTrue() {
        SimpleBankAccount simpleAccount = new SimpleBankAccount();
        boolean result = simpleAccount.isAccountEmpty();
        assertTrue(result);
    }

    @Test
    @DisplayName("isAccountEmpty(): returns false when account balance is non-zero")
    void testIsAccountemptyFalse() {
        float balance = 100.15f;
        SimpleBankAccount simpleAccount = new SimpleBankAccount(balance);
        boolean result = simpleAccount.isAccountEmpty();
        assertFalse(result);
    }
}
