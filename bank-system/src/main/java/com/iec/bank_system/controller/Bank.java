package com.iec.bank_system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.iec.bank_system.model.Account;
import com.iec.bank_system.model.CheckingAccount;
import com.iec.bank_system.model.Customer;
import com.iec.bank_system.model.Transaction;
import com.iec.bank_system.view.Main;

/*
Ez az osztály biztosítja a bank működéséhez szükséges alapvető szolgáltatásokat:
● Mezők: customers (ügyfelek listája, Map).
● Metódusok: addCustomer (ügyfél hozzáadása), removeCustomer (ügyfél eltávolítása),
findCustomer (ügyfél keresése), listCustomers (ügyfelek listázása).
 */

public class Bank {

	Map<Customer, Account> customers;

	public Bank(HashMap<Customer, Account> initialCustomers) {
		if (initialCustomers == null) {
			customers = new HashMap<Customer, Account>();
		} else {
			customers = new HashMap<Customer, Account>(initialCustomers);
		}
	}

	public boolean AddCustomer(Customer customer) {
		return AddCustomer(customer, null);
	}

	public boolean AddCustomer(Customer customer, Account account) {
		if (customers.containsKey(customer)) {
			Main.LOGGER.severe("Customer already exists!");
			return false;
		} else {
			if (account == null)
				account = new CheckingAccount(0, 0, new ArrayList<Transaction>());
			customers.put(customer, account);
			Main.LOGGER.info("Customer added.");
			return true;
		}
	}

	public boolean RemoveCustomer(Customer customer) {
		if (!customers.containsKey(customer)) {
			Main.LOGGER.severe("Customer not exists!");
			return false;
		} else {
			customers.remove(customer);
			Main.LOGGER.info("Customer removed.");
			return true;
		}
	}

	public Account FindCustomer(Customer customer) {
		if (!customers.containsKey(customer)) {
			Main.LOGGER.severe("Customer not exists!");
			return null;
		} else {
			Main.LOGGER.info("Customer found.");
			return customers.get(customer);
		}
	}
	
	public void ListCustomers() {
		for (Map.Entry<Customer, Account> customer : customers.entrySet()) {
			Main.LOGGER.info(customer.getKey().toString());
			Main.LOGGER.info(customer.getValue().toString());
		}
	}
}
