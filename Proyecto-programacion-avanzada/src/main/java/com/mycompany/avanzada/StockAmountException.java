package com.mycompany.avanzada;

public class StockAmountException extends Exception {
	public StockAmountException() {
		super("Insufficient stock");
	}
}