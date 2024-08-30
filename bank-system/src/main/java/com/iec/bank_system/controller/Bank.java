package com.iec.bank_system.controller;

import java.util.HashMap;
import java.util.Map;

import com.iec.bank_system.model.Customer;
import com.iec.bank_system.view.Main;

/*
Ez az osztály biztosítja a bank működéséhez szükséges alapvető szolgáltatásokat:
● Mezők: customers (ügyfelek listája, Map).
● Metódusok: addCustomer (ügyfél hozzáadása), removeCustomer (ügyfél eltávolítása),
findCustomer (ügyfél keresése), listCustomers (ügyfelek listázása).
 */

public class Bank {

	//lookup table for name -> Customer
	private Map<String, Customer> customers;

	public Bank(HashMap<String, Customer> initialCustomers) {
		if (initialCustomers == null) {
			customers = new HashMap<String, Customer>();
		} else {
			customers = new HashMap<String, Customer>(initialCustomers);
		}
	}

	public boolean AddCustomer(String name,  Customer customer) {
		if (customers.containsKey(name)) {
			Main.LOGGER.severe("Customer already exists!");
			return false;
		} else {
			customers.put(name, customer);
			Main.LOGGER.info("Customer added.");
			return true;
		}
	}

	public boolean RemoveCustomer(String name) {
		if (!customers.containsKey(name)) {
			Main.LOGGER.severe("Customer not exists!");
			return false;
		} else {
			customers.remove(name);
			Main.LOGGER.info("Customer removed.");
			return true;
		}
	}

	public Customer FindCustomer(String name) {
		if (!customers.containsKey(name)) {
			Main.LOGGER.severe("Customer not exists!");
			return null;
		} else {
			Main.LOGGER.info("Customer found.");
			return customers.get(name);
		}
	}
	
	public void ListCustomers() {
		for (Map.Entry<String, Customer> customer : customers.entrySet()) {
			Main.LOGGER.info(customer.getKey().toString());
			Main.LOGGER.info(customer.getValue().toString());
		}
	}
}
