package com.iec.bank_system.model;

import java.util.List;

import com.iec.bank_system.view.Main;

/*
● Tranzakciós díj (TRANSACTION_FEE): Minden tranzakció esetén egy fix összegű díjat
vonunk le a számla egyenlegéből.
● Speciális metódusok: Minden tranzakciónál alkalmazza a tranzakciós díjat
 */

public final class CheckingAccount extends Account {

	private final long TRANSACTION_FEE = 10;

	public CheckingAccount(int accountNumber, long balance, List<Transaction> transactions) {
		super(accountNumber, balance, transactions);
	}

	@Override
	public boolean Withdraw(long withdrawBalance) {
		long withdrawWithFee = withdrawBalance + TRANSACTION_FEE;
		
		if (balance - withdrawWithFee> 0) {
			balance -= withdrawWithFee;
			Main.LOGGER.info("Withdrawed " + withdrawWithFee + " new balance " + balance);
			return true;
		}
		else {
			Main.LOGGER.warning("Not enough balance!");
			return false;
		}	
	}

}
