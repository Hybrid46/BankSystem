package com.iec.bank_system.view;

import java.util.Scanner;
import java.util.logging.Logger;

import com.iec.bank_system.controller.Bank;
import com.iec.bank_system.utils.FileLogger;

public class Main 
{
	public static final Logger LOGGER = FileLogger.getLogger(Main.class.getName() + " consoleHandler");
	
    public static void main( String[] args )
    {
    	Scanner scan = new Scanner(System.in);    	
    	
    	//TODO read data from disk
    	
    	Bank bank = new Bank(null); //seedable -> read data from disk
    	
    	//LOGGER.severe("Severe!");
    	//LOGGER.warning("Warning!");
    	LOGGER.info("Bank System initialized!");
    	
    	//TODO Menu
    	
    	LOGGER.info("Bank System terminated!");
    	scan.close();
    	FileLogger.close(false);
    }
}
