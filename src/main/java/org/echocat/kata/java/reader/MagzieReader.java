package org.echocat.kata.java.reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.model.Author;
import org.echocat.kata.java.model.Magzine;

public class MagzieReader extends CsvReaderAbstract<Magzine> {

	@Override
	protected Magzine parseRecord(CSVRecord record) {

		try {
			return new Magzine(record.get("isbn"), Arrays.asList(record.get("authors").split(",")), record.get("title"),
					new SimpleDateFormat("dd.MM.yyyy").parse(record.get("publishedAt")));
		} catch (ParseException e) {

			throw new RuntimeException(e);
		}

	}

}
