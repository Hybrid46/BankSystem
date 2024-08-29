package com.iec.bank_system.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/*
Ez az osztály felelős a logolásért és a naplófájlok kezeléséért. Az alkalmazás minden fontos
eseményét és tranzakcióját naplózza, hogy könnyen nyomon követhetőek legyenek az
események.
 */

public class FileLogger {

	// ANSI escape codes for colors https://gist.github.com/dainkaplan/4651352
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String RED = "\u001B[31m";
	private static final String YELLOW = "\u001B[33m";
	private static final String BLUE = "\u001B[34m";
	private static final String GREEN = "\u001B[32m";
	
	private final String logFile = "BankSystem.log";

	public static Logger getLogger(String className) {
		Logger logger = Logger.getLogger(className);

		ConsoleHandler consoleHandler = new ConsoleHandler();

		consoleHandler.setLevel(Level.ALL);
		consoleHandler.setFormatter(new ColorConsoleFormatter());
		
		for (var handler : logger.getHandlers())
			logger.removeHandler(handler);
		
		logger.addHandler(consoleHandler);
		logger.setUseParentHandlers(false);

		return logger;
	}

	public static void close(boolean printResult) {
		LogManager logManager = LogManager.getLogManager();
		Enumeration<String> loggers = logManager.getLoggerNames();

		while (loggers.hasMoreElements()) {
			String loggerName = loggers.nextElement();
			Logger logger = logManager.getLogger(loggerName);

			if (logger != null) {
				for (var handler : logger.getHandlers()) {
					if (printResult)
						System.out.println("Closing handler: " + handler.getClass().getName());
					handler.close();
				}
			}
		}
	}

	public String Format(LogRecord record) {
		String color;
		switch (record.getLevel().getName()) {
		case "SEVERE":
			color = RED;
			break;
		case "WARNING":
			color = YELLOW;
			break;
		case "INFO":
			color = BLUE;
			break;
		default:
			color = GREEN;
			break;
		}
		return color + record.getMessage() + ANSI_RESET + System.lineSeparator();
	}

	public void WriteFile(String fileName) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
			dos.writeInt(123);
			dos.writeDouble(4.5);
			dos.writeBoolean(false);
			dos.writeUTF("DOS szöveges input");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ReadFile(String fileName) {
		try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
			int intVal = dis.readInt();
			double doubleVal = dis.readDouble();
			boolean boolVal = dis.readBoolean();
			String stringVal = dis.readUTF();

			System.out.println("Int val: " + intVal);
			System.out.println("Int val: " + doubleVal);
			System.out.println("Int val: " + boolVal);
			System.out.println("Int val: " + stringVal);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
