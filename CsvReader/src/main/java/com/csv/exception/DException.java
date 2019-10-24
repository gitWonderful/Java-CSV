package com.csv.exception;

public class DException extends Exception {

	private static final long serialVersionUID = 1L;

	public DException(String msg, String typeName) {
		super(msg + "," + typeName);
	}

}
