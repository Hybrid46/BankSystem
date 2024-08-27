package com.iec.bank_system.utils;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ColorConsoleFormatter extends Formatter {

	private static final String ANSI_RESET = "\u001B[0m";
	//private static final String BLACK = "\u001B[30m";
	private static final String RED = "\u001B[31m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	//private static final String BLUE = "\u001B[34m";
	//private static final String MAGENTA = "\u001B[35m";
	//private static final String CYAN = "\u001B[36m";
	private static final String WHITE = "\u001B[37m";

	@Override
	public String format(LogRecord record) {
		String color = null;

		switch (record.getLevel().getName()) {
		case "SEVERE":
			color = RED;
			break;
		case "WARNING":
			color = YELLOW;
			break;
		case "INFO":
			color = WHITE;
			break;
		case "CONFIG":
			color = GREEN;
			break;
		}

		return color + formatMessage(record) + ANSI_RESET + System.lineSeparator();
	}
}
