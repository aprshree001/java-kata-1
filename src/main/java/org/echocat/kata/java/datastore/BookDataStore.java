package org.echocat.kata.java.datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.echocat.kata.java.model.Book;
import org.echocat.kata.java.reader.BookReader;

import lombok.Data;

@Data
public class BookDataStore {

	List<Book> books = new ArrayList<>();

	public BookDataStore(String file) {

		setBooks(new BookReader().parseFile(file));

	}

	public List<Book> findBookByAuthorEmail(String authorEmail) {

		return books.stream().filter(b -> b.getAuthors().contains(authorEmail)).collect(Collectors.toList());

	}

	public List<Book> findBookByIsbn(String isbn) {

		return books.stream().filter(b -> b.getIsbn().equals(isbn)).collect(Collectors.toList());

	}

}
