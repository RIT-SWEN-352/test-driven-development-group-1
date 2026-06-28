package edu.rit.swen352.tdd.hard;

/**
 * A Value Object for American monetary values with fixed integer
 * values for dollars and cents.
 */
record Money(int dollars, int cents) {}

/**
 * An American bank account that permits deposits and withdrawals.
 * The balance must never be negative.  The balance must be stored
 * as a {@link Money} value.
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>constructor:
 *     <ul>
 *       <li>a ctor that supplies an initial balance, as a {@link Money} value</li>
 *       <li>a no-arg ctor that defaults the initial balance to zero</li>
 *     </ul>
 *   </li>
 *   <li>{@code getBalance()}: returns the current balance</li>
 *   <li>{@code isAccountEmpty()}: queries whether the balance is zero</li>
 *   <li>{@code deposit(amount)}: add a {@link Money} amount to the balance</li>
 *   <li>{@code withdraw(amount)}: subtract a {@link Money} amount from the balance</li>
 *   <li>{@code toString()}: returns a human-friendly representation of the account balance, eg {@code $20.50}</li>
 * </ul>
 */
public class BankAccount {

    Money money;

    public BankAccount(Money money) {
        if(money.dollars() < 0 || money.cents() < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        
        if(money.cents() >= 100) {
            throw new IllegalArgumentException("Cents count must be under 100.");
        }

        this.money = money;
    }

    public BankAccount() {
        this(new Money(0, 0));
    }

    public Money getMoney() {
        return this.money;
    }

    public Money getBalance() {
        return this.money;
    }

    public boolean isAccountEmpty() {
        if(this.getBalance().cents() == 0 && this.getBalance().dollars() == 0) {
            return true;
        }
        return false;
    }

    public void deposit(Money depositMoney) {
        // check for negative deposit
        if(depositMoney.dollars() < 0 || depositMoney.cents() < 0) {
            throw new IllegalArgumentException("Deposit cannot be negative.");
        }
        
        // add dollars
        int dollars = depositMoney.dollars();
        dollars += this.getBalance().dollars();

        // add cents
        int cents = depositMoney.cents();
        cents += this.getBalance().cents();
        // check if cents will push into new dollar
        if(cents >= 100) {
            while(cents >= 100) {
                dollars++;
                cents -= 100;
            }
        }
    
        this.money = new Money(dollars, cents);
    }

    public void withdraw(Money withdrawMoney) {
        // check for negative withdraw amount
        if(withdrawMoney.dollars() < 0 || withdrawMoney.cents() < 0) {
            throw new IllegalArgumentException("Withdraw amount cannot be negative.");
        }

        // subtract dollars
        int dollars = this.getBalance().dollars();
        dollars -= withdrawMoney.dollars();

        // substract cents
        int cents = this.getBalance().cents();
        cents -= withdrawMoney.cents();
        // check if cents will push into new dollar
        if(cents < 0) {
            dollars--;
            cents = (100 - Math.abs(cents));
        }

        this.money = new Money(dollars, cents);
    }

    public String toString() {
        assert false : "Not yet implimented";
        return "0";
    }
}
