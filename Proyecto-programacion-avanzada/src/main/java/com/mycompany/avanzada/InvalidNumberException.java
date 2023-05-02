package com.mycompany.avanzada;

public class InvalidNumberException extends Exception {
	public InvalidNumberException() {
		super("Not a valid number");
	}
}