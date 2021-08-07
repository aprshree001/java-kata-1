package org.echocat.kata.java.reader;

import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.model.Author;

public class AuthorReader extends CsvReaderAbstract<Author> {

	@Override
	protected Author parseRecord(CSVRecord record) {

		return new Author(record.get("email"), record.get("firstname"), record.get("lastname"));

	}

}
