package edu.rit.swen352.tdd.hard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.rit.swen352.tdd.sample.Counter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the {@link BankAccount} component.
 */
class BankAccountTest {

        @ParameterizedTest(name = "Test dollars={0}, cents={1}")
        @CsvSource({"100, 50", "45, 35", "0, 80"})
        @DisplayName("ctor with provided balance")
        void ctor_1(int dollars, int cents) {
            final BankAccount CuT = new BankAccount(new Money(dollars, cents));
            assertAll("ctor_1 assertions"
                , () -> assertNotNull(CuT)
                , () -> assertEquals(dollars, CuT.money.dollars(), "Money is correct")
                , () -> assertEquals(cents, CuT.money.cents(), "Money is correct")
            );
        }
        
        @Test
        @DisplayName("ctor rejects cents over 100")
        void ctor_1_fail_1() {
            final Money testBalance = new Money(15, 105);
            final Exception e = assertThrows(IllegalArgumentException.class, () -> new BankAccount(testBalance));
            assertEquals("Cents count must be under 100.", e.getMessage());
        }

        @Test
        @DisplayName("ctor rejects negative dollars")
        void ctor_1_fail_2() {
            final Money testBalance = new Money (-25, 35);
            final Exception e = assertThrows(IllegalArgumentException.class, () -> new BankAccount(testBalance));
            assertEquals("Balance cannot be negative.", e.getMessage());
        }

        @Test
        @DisplayName("ctor rejects negative cents")
        void ctor_1_fail_3() {
            final Money testBalance = new Money (25, -35);
            final Exception e = assertThrows(IllegalArgumentException.class, () -> new BankAccount(testBalance));
            assertEquals("Balance cannot be negative.", e.getMessage());
        }

        @Test
        @DisplayName("ctor with default balance")
        void ctor_2() {
            final BankAccount CuT = new BankAccount();
            assertAll("ctor_2 assertions"
                , () -> assertNotNull(CuT)
                , () -> assertEquals(0, CuT.money.dollars(), "Dollar value is stored correctly")
                , () -> assertEquals(0, CuT.money.cents(), "Cents value is stored correctly")
            );
        }

        @Test
        @DisplayName("return the current balance")
        void balance_1() {
            final BankAccount CuT = new BankAccount(new Money(75, 23));
            assertEquals(CuT.getBalance(), CuT.money);
        }

        @Test
        @DisplayName("checks whether the account balance is zero")
        void empty_1() {
            final BankAccount CuT = new BankAccount(new Money(0, 0));
            assertTrue(CuT.isAccountEmpty());
        }

        @Test
        @DisplayName("checks whether the account balance is zero")
        void empty_2() {
            final BankAccount CuT = new BankAccount(new Money(30, 12));
            assertFalse(CuT.isAccountEmpty());
        }

        @ParameterizedTest(name = "Test dollars={0}, cents={1}")
        @CsvSource({"100, 50", "45, 35", "0, 80"})
        @DisplayName("add balance to account, under 100 cents")
        void deposit_1(int dollars, int cents) {
            final BankAccount CuT = new BankAccount();
            CuT.deposit(new Money(dollars, cents));
            assertAll("deposit assertions"
                , () -> assertEquals(dollars, CuT.money.dollars(), "Dollars is correct")
                , () -> assertEquals(cents, CuT.money.cents(), "Cents is correct")
            );
        }

        @Test
        @DisplayName("add balance to account, over 100 cents")
        void deposit_2() {
            final BankAccount CuT = new BankAccount(new Money(2, 50));
            CuT.deposit(new Money(0, 80));
            assertAll("deposit_2 assertions"
                , () -> assertEquals(3, CuT.money.dollars(), "Dollars is correct")
                , () -> assertEquals(30, CuT.money.cents(), "Cents is correct")
            );
        }

        @Test
        @DisplayName("attempt to add negative balance to account")
        void deposit_fail() {
            final BankAccount CuT = new BankAccount();
            final Exception e = assertThrows(IllegalArgumentException.class, () -> CuT.deposit(new Money(-1, 0)));

            assertAll("deposit_fail assertions"
                , () -> assertEquals("Deposit cannot be negative.", e.getMessage())
                , () -> assertEquals(CuT.getBalance().dollars(), 0)
                , () -> assertEquals(CuT.getBalance().cents(), 0)
            );            
        }

        @ParameterizedTest(name = "Test dollars={0}, cents={1}")
        @CsvSource({"100, 50", "45, 35", "0, 80"})
        @DisplayName("withdraw balance from account, under 100 cents")
        void withdraw_1(int dollars, int cents) {
            final BankAccount CuT = new BankAccount(new Money(100, 80));
            CuT.withdraw(new Money(dollars, cents));
            assertAll("withdraw_1 assertions"
                , () -> assertEquals((100 - dollars), CuT.money.dollars(), "Dollars is correct")
                , () -> assertEquals((80 - cents), CuT.money.cents(), "Cents is correct")
            );
        }

        @Test
        @DisplayName("withdraw balance from account, over 100 cents")
        void withdraw_2() {
            final BankAccount CuT = new BankAccount(new Money(5, 20));
            CuT.withdraw(new Money(2, 30));
            assertAll("withdraw_2 assertions"
                , () -> assertEquals(2, CuT.money.dollars(), "Dollars is correct")
                , () -> assertEquals((90), CuT.money.cents(), "Cents is correct")
            );
        }

        @Test
        @DisplayName("attempt to withdraw negative amount")
        void withdraw_fail() {
            final BankAccount CuT = new BankAccount();
            final Exception e = assertThrows(IllegalArgumentException.class, () -> CuT.withdraw(new Money(-1, -1)));

            assertAll("withdraw_fail assertions"
                , () -> assertEquals("Withdraw amount cannot be negative.", e.getMessage())
                , () -> assertEquals(CuT.getBalance().dollars(), 0)
                , () -> assertEquals(CuT.getBalance().cents(), 0)
            );
        }
}
