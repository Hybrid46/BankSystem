package com.iec.bank_system.model;

import java.util.List;

/*
Ez az absztrakt osztály alapvető mezőket és metódusokat tartalmaz minden számlatípus
számára:
● Mezők: accountNumber (számlaszám), balance (egyenleg), transactions (tranzakciók
listája).
● Konstruktor: Beállítja az alapvető adatokat.
● Metódusok: deposit (befizetés), withdraw (kivétel, absztrakt), getAccountDetails (számla
részletek lekérése), getTransactions (tranzakciók lekérése), getBalance (egyenleg
lekérése), getAccountNumber (számlaszám lekérése), setBalance (egyenleg beállítása).
*/

public abstract class Account {

	int accountNumber;
	long balance;

	List<Transaction> transactions;
	
	public Account(int accountNumber, long balance, List<Transaction> transactions) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.transactions = transactions;
	}

	public void Deposit(Long addBalance) {
		balance += addBalance;		
	}
	
	public abstract boolean Withdraw(Long withdrawBalance);
	
	//TODO return duples
	public void GetAccountDetails() {
		//return accountNumber, balance
	}
	
	public List<Transaction> GetTransactions() {
		return transactions;
	}
	
	public int GetAccountNumber() {
		return accountNumber;
	}
	
	public long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
}
