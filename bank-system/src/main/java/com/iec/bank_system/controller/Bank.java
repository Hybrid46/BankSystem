package com.iec.bank_system.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.iec.bank_system.model.Customer;
import com.iec.bank_system.view.Main;

/*
Ez az osztály biztosítja a bank működéséhez szükséges alapvető szolgáltatásokat:
● Mezők: customers (ügyfelek listája, Map).
● Metódusok: addCustomer (ügyfél hozzáadása), removeCustomer (ügyfél eltávolítása),
findCustomer (ügyfél keresése), listCustomers (ügyfelek listázása).
 */

public class Bank {

	// lookup table for name -> Customer
	private Map<String, Customer> customers;

	public Bank(HashMap<String, Customer> initialCustomers) {
		if (initialCustomers == null) {
			customers = new HashMap<String, Customer>();
		} else {
			customers = new HashMap<String, Customer>(initialCustomers);
		}
	}

	public boolean AddCustomer(String name) {
		if (customers.containsKey(name)) {
			Main.LOGGER.severe("Customer already exists!");
			return false;
		}
		
		int ID = GenerateCustomerID();

		if (ID == -1) {
			Main.LOGGER.warning("Customer ID generation fail!");
			return false;
		}

		Customer customer = new Customer(name, ID);
		customers.put(name, customer);
		Main.LOGGER.info("Customer added.");
		return true;
	}

	// TODO check duplicates
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
			Customer foundCustomer = customers.get(name);
			Main.LOGGER.info("Customer found. " + foundCustomer.toString());
			return foundCustomer;
		}
	}

	public void ListCustomers() {
		for (Map.Entry<String, Customer> customer : customers.entrySet()) {
			Main.LOGGER.info(customer.getKey().toString());
			Main.LOGGER.info(customer.getValue().toString());
		}
	}

	// returns -1 on fail
	private int GenerateCustomerID() {
		Random rndRandom = new Random();
		int MAX_ATTEMPTS = 10;
		int ID = 0;

		for (int i = 0; i < MAX_ATTEMPTS; i++) {
			boolean exists = false;
			ID = rndRandom.nextInt();

			for (Entry<String, Customer> customer : customers.entrySet()) {
				if (ID == customer.getValue().GetCustomerId()) {
					exists = true;
					break;
				}
			}

			if (exists == false) return ID;
		}

		return -1;
	}
}
