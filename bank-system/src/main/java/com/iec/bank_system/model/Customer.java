package com.iec.bank_system.model;

import java.util.ArrayList;
import java.util.List;

import com.iec.bank_system.view.Main;

/*
Ez az osztály az ügyfél adatait és a hozzá kapcsolódó számlákat tartalmazza:
● Mezők: name (név), customerId (ügyfél azonosító), accounts (számlák listája).
● Metódusok: addAccount (számla hozzáadása), removeAccount (számla eltávolítása),
getAccounts (számlák lekérése), getCustomerId (ügyfél azonosító lekérése).
 */

public class Customer {

	private String name;

	private int customerId;
	private List<Account> accounts;

	public Customer(String name) {
		super();
		this.name = name;
		this.customerId = GenerateCustomerID();
		this.accounts = new ArrayList<Account>();
	}

	public boolean AddAccount(Account account) {
		if (accounts.contains(account)) {
			Main.LOGGER.severe("Account already added!");
			return false;
		} else {
			accounts.add(account);
			Main.LOGGER.info("Account added!");
			return true;
		}
	}

	public boolean RemoveAccount(long accountNumber) {
		Account foundAccount = null;
		
		for (Account account : accounts) {
			if (account.GetAccountNumber() == accountNumber) {
				foundAccount = account;
				break;
			}
		}
		
		return RemoveAccount(foundAccount);
	}

	public boolean RemoveAccount(Account account) {
		if (accounts.contains(account)) {
			accounts.remove(account);
			Main.LOGGER.info("Account removed!");
			return true;
		} else {
			Main.LOGGER.severe("Account not exists!");
			return false;
		}
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	private int GenerateCustomerID() {
		//TODO
		return 0;
	}
}
