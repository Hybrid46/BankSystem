package com.iec.bank_system.model;

import java.time.LocalDateTime;

/*
Ez az osztály reprezentálja a tranzakciókat, és tartalmazza a tranzakció dátumát, összegét,
típusát és leírását. Például, egy ügyfél pénzfelvétel vagy befizetés esetén egy új tranzakciós
bejegyzést hoz létre, amely részletes információkat tartalmaz az adott műveletről.
*/

public class Transaction {

	public enum TransactionType {
		  CreateAccount,
		  RemoveAccount,
		  Deposit,
		  Withdraw,
		  GetAccountDetails,
		  GetTransactions,
		  GetAccountNumber,
		  GetBalance,
		  SetBalance,		  
		  ApplyInterest
		}

	private LocalDateTime localDateTime;
	private long balance;
	private TransactionType transactionType;
	private String customerInfo;
	private String accountInfo;
	
	public Transaction(LocalDateTime localDateTime, long balance, TransactionType transactionType, String customerInfo, String accountInfo) {
		if (localDateTime == null) this.localDateTime = LocalDateTime.now();
		this.balance = balance;
		this.transactionType = transactionType;
		this.customerInfo = customerInfo;
		this.accountInfo = accountInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [");
		if (localDateTime != null) {
			builder.append("localDateTime=");
			builder.append(localDateTime);
			builder.append(", ");
		}
		builder.append("balance=");
		builder.append(balance);
		builder.append(", ");
		if (transactionType != null) {
			builder.append("transactionType=");
			builder.append(transactionType);
			builder.append(", ");
		}
		if (customerInfo != null) {
			builder.append("customerInfo=");
			builder.append(customerInfo);
			builder.append(", ");
		}
		if (accountInfo != null) {
			builder.append("accountInfo=");
			builder.append(accountInfo);
		}
		builder.append("]");
		return builder.toString();
	}
	
	

}
