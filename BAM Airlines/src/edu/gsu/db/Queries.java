package edu.gsu.db;

public class Queries {
	
	public static final String LOGIN = "SELECT * FROM customer";
	public static final String CREATE_ACCOUNT = "INSERT INTO customer (firstName, lastName, address, zip, state, userName, password, email, ssn, customerSecurityQuestion, customerSecurityAnswer)"
	        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String FORGOT_PASSWORD = "SELECT customerSecurityAnswer FROM customer WHERE userName = ? AND customerSecurityQuestion = ?";
	public static final String GET_PASSWORD = "SELECT password FROM customer WHERE customerSecurityAnswer = ? AND userName = ?";
	public static final String CREATE_RESERVATION = "INSERT INTO reservation (reservationNum, airlineName, flightNumber, departureDate, departureTime, arrivalCity, userName)" + " VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String REMOVE_SEAT = "UPDATE flight SET seatCount = seatCount - 1 WHERE (flightNumber = ?)";
	public static final String GET_RESERVATION = "SELECT airlineName, flightNumber, departureDate, departureTime, arrivalCity FROM reservation WHERE userName = ?";
	public static final String GET_FLIGHT = "SELECT * from flight";
	// to do an already booked flight (by flight number) check, do same as login select reservation where flight number and departure date are the same, then throw exception if the count is > 1	
	public static final String DELETE_RESERVATION = "DELETE FROM reservation WHERE userName = ? AND flightNumber = ?";
	public static final String ADD_SEAT = "UPDATE flight SET seatCount = seatCount + 1 WHERE (flightNumber = ?)";
	public static final String CHECK_RESERVATION = "SELECT * FROM reservation WHERE userName = ? AND flightNumber = ?";
}


