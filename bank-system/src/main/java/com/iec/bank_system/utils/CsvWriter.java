package com.iec.bank_system.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

/*
Ez az osztály felelős az adatok CSV formátumba történő írásáért. Használható például az
ügyfelek és tranzakciók exportálására, hogy később könnyen feldolgozhatóak legyenek más
alkalmazások vagy elemzési célok számára.
 */

public class CsvWriter {

	private String fileName;

	public CsvWriter(String fileName) {
		fileName = "data.csv";
	}
	
	public void SetFileName(String fileName) {
		this.fileName = fileName;
	}

//	public void WriteFile(String fileName) {
//		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
//			dos.writeInt(123);
//			dos.writeDouble(4.5);
//			dos.writeBoolean(false);
//			dos.writeUTF("DOS szöveges input");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void ReadFile(String fileName) {
//		try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
//			int intVal = dis.readInt();
//			double doubleVal = dis.readDouble();
//			boolean boolVal = dis.readBoolean();
//			String stringVal = dis.readUTF();
//
//			System.out.println("Int val: " + intVal);
//			System.out.println("Int val: " + doubleVal);
//			System.out.println("Int val: " + boolVal);
//			System.out.println("Int val: " + stringVal);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public List<String[]> ReadAllCSV(boolean printOut) throws Exception {
		List<String[]> allRows = null;

		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
			try {
				allRows = reader.readAll();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (CsvException e) {
				e.printStackTrace();
			}

			if (printOut) {
				for (String[] row : allRows) {
					System.out.println(Arrays.toString(row));
				}
			}
		}
		return allRows;
	}

	// exa: String[] record = "2,Rahul,Vaidya,India,35".split(",");
	public void WriteCSV(List<String[]> records, boolean printOut) throws Exception {
		try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
			for (String[] record : records) {
				writer.writeNext(record, false);
				if (printOut) System.out.println(Arrays.toString(record));
			}
		}
	}

	public List<String> ParseCSVLineByLine(boolean printOut) throws Exception {
		List<String> parsedRecords = new ArrayList<String>();
		
		try {
			CSVParser csvParser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName)).withSkipLines(1).withCSVParser(csvParser).build();

			String[] nextLine;

			while ((nextLine = csvReader.readNext()) != null) {
				if (nextLine != null) {
					String parsedLine = Arrays.toString(nextLine);
					parsedRecords.add(parsedLine);
					if (printOut)System.out.println(parsedLine);
				}
			}
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return parsedRecords;
	}
}