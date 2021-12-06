package edu.gsu.db;

public class Queries {
	
	public static final String LOGIN = "SELECT * FROM customer";
	public static final String CREATE_ACCOUNT = "INSERT INTO customer (firstName, lastName, address, zip, state, userName, password, email, ssn, customerSecurityQuestion, customerSecurityAnswer)"
	        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
