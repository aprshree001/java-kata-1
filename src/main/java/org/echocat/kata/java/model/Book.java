package org.echocat.kata.java.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Book extends Document {

	private String description;

	public Book(String isbn, List<String> authors, String title, String description) {
		super(isbn, authors, title);

		setDescription(description);
	}

}
