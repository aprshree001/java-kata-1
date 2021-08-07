package org.echocat.kata.java.reader;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.util.CsvUnreadbleException;

public abstract class CsvReaderAbstract<T> {

	public InputStreamReader getFileInputStream(String filename) throws FileNotFoundException  {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filename).getFile());

		InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file));
		return inputStream;

	}

	public List<T> parseFile(String fileName) {

		List<T> parsedRecords = new ArrayList<>();
		
		
		CSVParser csvParser;
		try {
			csvParser = CSVFormat.EXCEL.withDelimiter(';').withFirstRecordAsHeader().parse(getFileInputStream(fileName));
			for (CSVRecord record : csvParser) {

				parsedRecords.add(parseRecord(record));

			}

		} catch (Exception e) {

			throw new CsvUnreadbleException("Error in reading csv file", e);
		}
		return parsedRecords;

	}

	protected abstract T parseRecord(CSVRecord record);

}
