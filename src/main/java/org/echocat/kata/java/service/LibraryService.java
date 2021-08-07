package org.echocat.kata.java.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.echocat.kata.java.datastore.AuthorDateSouce;
import org.echocat.kata.java.datastore.BookDataStore;
import org.echocat.kata.java.datastore.MaginzeDataStore;
import org.echocat.kata.java.model.Book;
import org.echocat.kata.java.model.Document;
import org.echocat.kata.java.model.Magzine;

import lombok.Data;

@Data
public class LibraryService {

	AuthorDateSouce authorDateSouce;

	BookDataStore bookDataStore;

	MaginzeDataStore magzindeDataStore;

	public LibraryService() {

		initDataStore();

	}

	public void printAllBooksAndMaginzed() {

		authorDateSouce.getAuthors().forEach(author -> {

			List<Book> books = bookDataStore.findBookByAuthorEmail(author.getEmail());

			List<Magzine> magzines = magzindeDataStore.findMagzineByAuthorEmail(author.getEmail());

			System.out.println("the author details are := " + author.toString());
			System.out.println("the author has written " + books.size() + " books ");
			System.out.println("the author has  written" + magzines.size() + " magzines");

			System.out.println("book details");

			books.forEach(book -> System.out.println(book.toString()));

			System.out.println("magzine details");

			magzines.forEach(magzin -> System.out.println(magzin.toString()));

		});

	}

	public List<Document> findBookAndMagzineByIsbn(String isbn) {

		List<Book> books = bookDataStore.findBookByIsbn(isbn);

		List<Magzine> magzines = magzindeDataStore.findMagzineByIsbn(isbn);

		List<Document> documents = new ArrayList<>();

		documents.addAll(books);
		documents.addAll(magzines);

		return documents;
	}

	public List<Document> findBookAndMagzineByAuthorEmail(String email) {

		List<Book> books = bookDataStore.findBookByAuthorEmail(email);

		List<Magzine> magzines = magzindeDataStore.findMagzineByAuthorEmail(email);

		List<Document> documents = new ArrayList<>();

		documents.addAll(books);
		documents.addAll(magzines);

		return documents;

	}

	public List<Document> printAllBookAndMagzineSortedBytitle() {

		List<Document> documents = new ArrayList<>();
		documents.addAll(bookDataStore.getBooks());
		documents.addAll(magzindeDataStore.getMagzine());

		 Collections.sort(documents, (e1, e2) -> e1.getTitle().compareTo(e2.getTitle()));
		 return documents;

	}

	public void initDataStore() {

		setAuthorDateSouce(new AuthorDateSouce("authors.csv"));
		setBookDataStore(new BookDataStore("books.csv"));
		setMagzindeDataStore(new MaginzeDataStore("magazines.csv"));

	}

}
