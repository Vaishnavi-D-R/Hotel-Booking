package com.mindtree.hotelbookingapp.exception;

import java.sql.SQLException;

public class NoSuchCityException extends Throwable{
	public NoSuchCityException(String string, NoSuchCityException e) {
		System.out.println(string);
	}

	public NoSuchCityException() {
		System.out.println("No such city out there");
			}

	public NoSuchCityException(String string) {
		System.out.println("No such city out there");
	}

	
}
