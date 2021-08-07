package org.echocat.kata.java.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Magzine extends Document {

	public Magzine(String isbn, List<String> authors, String title, Date publishedAt) {
		super(isbn, authors, title);
		setPublishedAt(publishedAt);
	}

	private Date publishedAt;

}
