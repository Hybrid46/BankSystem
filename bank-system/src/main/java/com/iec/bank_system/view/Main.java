package com.iec.bank_system.view;

import java.util.Scanner;
import java.util.logging.Logger;

import com.iec.bank_system.utils.FileLogger;

/**
 * Hello world!
 *
 */
public class Main 
{
	private static final Logger LOGGER = FileLogger.getLogger(Main.class.getName() + " consoleHandler");
	
    public static void main( String[] args )
    {
    	Scanner scan = new Scanner(System.in);    	
    	
    	LOGGER.severe("Severe!");
    	LOGGER.warning("Warning!");
    	LOGGER.info("Info!");
    	
    	scan.close();
    	FileLogger.close(false);
    }
}
