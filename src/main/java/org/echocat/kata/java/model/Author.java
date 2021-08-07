package org.echocat.kata.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Author {

	private String email;
	private String firstName;
	private String lastName;
	@Override
	public String toString() {
		return "Author [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
