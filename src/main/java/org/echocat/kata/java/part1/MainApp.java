package org.echocat.kata.java.part1;

import org.echocat.kata.java.service.LibraryService;

public class MainApp {

	public static void main(String[] args) {

		LibraryService libraryService = new LibraryService();

		libraryService.printAllBooksAndMaginzed();
	}

}
