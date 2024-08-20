package com.iec.bank_system.model;

import java.util.List;

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
	public boolean Withdraw(Long withdrawBalance) {
			balance -= withdrawBalance + TRANSACTION_FEE;
			return true;
	}

}
