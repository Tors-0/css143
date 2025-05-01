/*
Questions:
2.2a) The variable watch window is in the main pane of the debugger panel of the debug tab at the bottom of the screen (doesn't appear until you run the program in debug mode at least once)
2.2b) The method call stack is in the pane to the left of the variable watch window in the debugger panel...

2.3a) F8 - goes to the next line
2.3b) F7 - goes into a method declared on the current line
2.3c) Shift + F8 - goes back out of a method that you are stepped into
2.3d) F9 (resume) - resumes program as normal, runs until next breakpoint
 */

/**
 * Account.java
 *
 * This Account class represents bank accounts that stores money for an owner.
 *
 * Author: Rae Johnston
 */
public class Account {
// Instance variables
	private double balance;	// invariant: balance >= 0 (should never be negative)
	private String owner;

//Constructor
	public Account(String name) {
		balance = 0;
		owner = name;
	}

// Instance methods
	/**
	 * Deposits 'amount' into the account
	 */
	public void deposit(int amount) throws IllegalArgumentException {
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}
		balance = balance + amount;
	}

	/**
	 * Withdraws 'amount' from the account.
	 * This only makes sense if amount <= balance.
	 * This method should be re-written so that there is not a possibility of
	 * having a negative balance.
	 */
	public void withdraw(int amount) throws IllegalArgumentException {
		if (amount > balance) {
			throw new IllegalArgumentException("Cannot overdraw account: Withdraw amount (" + amount + ") greater than balance (" + balance + ")");
		}
		balance -= amount;
	}

	/* Returns the balance of the Account
	 */
	public double getBalance() {
		return balance;
	}

	/* Returns the owner of the Account
	 */
	public String getOwner() {
		return owner;
	}
}

