package com.iec.bank_system.model;

import java.util.List;

import com.iec.bank_system.view.Main;

/*
Minimális egyenleg követelmény (MIN_BALANCE): A számla egyenlege nem
csökkenhet egy meghatározott minimális összeg alá.
● Kamat (INTEREST_RATE): A számla kamata, amelyet időszakosan hozzáadunk az
egyenleghez.
● Speciális metódusok: applyInterest (kamatszámítás és hozzáadás az egyenleghez).
 */
public final class SavingsAccount extends Account {

	private final long MIN_BALANCE = 0;
	private final double INTEREST_RATE = 6.5f;
	
	public SavingsAccount(int accountNumber, long balance, List<Transaction> transactions) {
		super(accountNumber, balance, transactions);		
	}

	@Override
	public boolean Withdraw(long withdrawBalance) 
	{
		if (balance - withdrawBalance > MIN_BALANCE) {
			balance -= withdrawBalance;
			Main.LOGGER.info("Withdrawed " + withdrawBalance + " new balance " + balance);
			return true;
		}
		else {
			Main.LOGGER.warning("Not enough balance!");
			return false;
		}	
	}
	
	public void ApplyInterest() {
		long currentBalance = GetBalance();
		long interest = (long)((double)currentBalance * (INTEREST_RATE / 100d));
		SetBalance(currentBalance + interest);
	}
	
	
}
