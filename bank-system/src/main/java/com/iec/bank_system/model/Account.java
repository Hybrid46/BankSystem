package com.iec.bank_system.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import com.iec.bank_system.view.Main;

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

	long accountNumber;
	long balance;

	List<Transaction> transactions;

	public Account(int accountNumber, long balance, List<Transaction> transactions) {
		super();

		if (accountNumber == 0) {
			this.accountNumber = GenerateAccountNumber();
		} else {
			this.accountNumber = accountNumber;
		}

		this.balance = balance;
		this.transactions = transactions;
	}

	public void Deposit(long addBalance) {
		balance += addBalance;
	}

	public abstract boolean Withdraw(long withdrawBalance);

	public void GetAccountDetails() {
		Main.LOGGER.info(toString());
	}

	public List<Transaction> GetTransactions() {
		return transactions;
	}

	public long GetAccountNumber() {
		return accountNumber;
	}

	public long GetBalance() {
		return balance;
	}

	public void SetBalance(Long balance) {
		this.balance = balance;
	}

	// returns -1 on fail
	private long GenerateAccountNumber() throws NumberFormatException {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime localDateTime = LocalDateTime.now();
		String formattedTime = dateTimeFormatter.format(localDateTime);
		long accountNumber = -1;

		try {
			accountNumber = Long.parseLong(formattedTime);
		} catch (NumberFormatException e) {
			Main.LOGGER.severe("Critical error! -> " + e.getMessage());
			e.printStackTrace();
		}

		return accountNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, balance, transactions);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountNumber=").append(accountNumber).append(", balance=").append(balance)
				.append(", ");
		if (transactions != null) {
			builder.append("transactions=").append(transactions);
		}
		builder.append("]");
		return builder.toString();
	}

	
}
