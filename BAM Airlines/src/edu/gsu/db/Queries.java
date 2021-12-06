package edu.gsu.db;

public class Queries {
	
	public static final String LOGIN = "SELECT count(*) as num  FROM login_credentials WHERE username = ? AND password =?";
	public static final String CREATE_ACCOUNT = "INSERT INTO customer (firstName, lastName, address, zip, state, userName, password, email, ssn, customerSecurityQuestion, customerSecurityAnswer)"
	        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
