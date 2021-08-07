package org.echocat.kata.java.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public abstract class Document {

	String isbn;
	private List<String> authors;
	private String title;
}
