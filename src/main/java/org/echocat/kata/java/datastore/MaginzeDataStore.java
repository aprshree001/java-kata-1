package org.echocat.kata.java.datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.echocat.kata.java.model.Book;
import org.echocat.kata.java.model.Magzine;
import org.echocat.kata.java.reader.BookReader;
import org.echocat.kata.java.reader.MagzieReader;

import lombok.Data;

@Data
public class MaginzeDataStore {

	List<Magzine> magzine = new ArrayList<>();

	public MaginzeDataStore(String file) {

		setMagzine(new MagzieReader().parseFile(file));

	}

	public List<Magzine> findMagzineByAuthorEmail(String authorEmail) {

		return magzine.stream().filter(b -> b.getAuthors().contains(authorEmail)).collect(Collectors.toList());

	}

	public List<Magzine> findMagzineByIsbn(String isbn) {

		return magzine.stream().filter(b -> b.getIsbn().equals(isbn)).collect(Collectors.toList());

	}

}
