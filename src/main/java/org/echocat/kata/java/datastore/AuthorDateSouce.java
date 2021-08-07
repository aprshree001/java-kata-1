package org.echocat.kata.java.datastore;

import java.util.ArrayList;
import java.util.List;

import org.echocat.kata.java.model.Author;
import org.echocat.kata.java.model.Book;
import org.echocat.kata.java.reader.AuthorReader;
import org.echocat.kata.java.reader.BookReader;

import lombok.Data;

@Data
public class AuthorDateSouce {

	List<Author> authors = new ArrayList<>();

	public AuthorDateSouce(String file) {

		setAuthors(new AuthorReader().parseFile(file));

	}

}
