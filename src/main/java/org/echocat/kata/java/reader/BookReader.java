package org.echocat.kata.java.reader;

import java.util.Arrays;

import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.model.Author;
import org.echocat.kata.java.model.Book;

public class BookReader extends CsvReaderAbstract<Book> {

	@Override
	protected Book parseRecord(CSVRecord record) {

		return new Book(record.get("isbn"), Arrays.asList(record.get("authors").split(",")), record.get("title"),
				record.get("description"));

	}
//title;isbn;authors;description
}
