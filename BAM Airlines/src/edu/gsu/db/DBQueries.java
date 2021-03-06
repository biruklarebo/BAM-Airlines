package edu.gsu.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.common.Reservation;
import edu.gsu.common.VO;
import edu.gsu.excpetions.DistinctException;
import edu.gsu.gui.AlertBox;
import edu.gsu.db.ConnectDatbase;
public class DBQueries {
	
	public static void login(VO vo) throws Exception {
		Customer co = vo.getCustomer();	//this gets the customer temporary object from the VO which only has username and password
		
		Connection con = ConnectDatbase.getConnection();//this establishes the connection. This is a method inside of the ConnectDatabase class
		try {
			// Create a statement
			PreparedStatement statement = con.prepareStatement(Queries.LOGIN); //this goes to the queries class which stores all of the queries we need
	    
			String user = co.getUserName();//this creates a new String variable assigning it the value from the VO 
			String pass = co.getPassword();//this does the same as above 
			
			// Execute a statement
			ResultSet resultSet = statement.executeQuery();//It is a set of data in our database that is a result of our query.
			
			int count = 0;//we set this equal to 0 so we can search for matches with username and password

			// Iterate through the result and print the student names
			//resultSet.next tells the query to go to the next row. It will go through all rows as it is a While statement
			while (resultSet.next()) {
				String username = resultSet.getString("userName");
				String password = resultSet.getString("password");
				if((username.equals(user) && (password.equals(pass)))){
					count = 1;
					System.out.println("Login matches");
				}
			}
			
			if (count == 0)
				throw new DistinctException("Invalid UserName or Password!");	     
	    
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			System.out.println(e);
			throw e;
		}
		finally {
			//finally always run even if in a try and catch statement. Even with or without exceptions.
			con.close();
		}
	}
	  	
		public static void createAccount(VO vo) throws Exception {
		Customer co = vo.getCustomer();	//

		Connection con = ConnectDatbase.getConnection();
		PreparedStatement smt = con.prepareStatement(Queries.CREATE_ACCOUNT);
		smt.setString(1, co.getFirstName());
		smt.setString(2, co.getLastName());
		smt.setString(3, co.getAddress());
		smt.setInt(4, co.getZip());
		smt.setString(5, co.getState());
		smt.setString(6, co.getUserName());
		smt.setString(7, co.getPassword());
		smt.setString(8, co.getEmail());
		smt.setString(9, co.getSSN());;
		smt.setString(10, co.getCustomerSecurityQuestion());
		smt.setString(11, co.getCustomerSecurityAnswer());
		
		
		smt.execute();
		con.close();
		
	}
	
	//add forgot password queries here!
		public static void forgotPassword(VO vo) throws Exception {
			Customer co = vo.getCustomer();	
			
			System.out.println("Connecting...");
			
			Connection con = ConnectDatbase.getConnection();
			PreparedStatement smt = con.prepareStatement(Queries.FORGOT_PASSWORD);
			smt.setString(1, co.getUserName());
			smt.setString(2, co.getCustomerSecurityQuestion());
			
			ResultSet resultset = smt.executeQuery();
			while (resultset.next()) {
				if(!resultset.getString("customerSecurityAnswer").equals(co.getCustomerSecurityAnswer()))
					throw new Exception("Incorrect Answer or Username");
			}		
			
			
			smt = con.prepareStatement(Queries.GET_PASSWORD);
			smt.setString(1, co.getCustomerSecurityAnswer());
			smt.setString(2, co.getUserName());
			resultset = smt.executeQuery();
			while (resultset.next()) {
				AlertBox.display("Your password", "Your password is " + resultset.getString("password"));
				}
			}
	public static void reserveFlight(VO vo) throws SQLException, Exception{
		
		Reservation reservation = vo.getReservation();
		Connection con = ConnectDatbase.getConnection();
		PreparedStatement smt = con.prepareStatement(Queries.CREATE_RESERVATION);
		smt.setString(1, reservation.getReservationNum());
		smt.setString(2, reservation.getAirlineName());
		smt.setInt(3, reservation.getFlightNumber());
		smt.setString(4, reservation.getDepartureDate());
		smt.setString(5, reservation.getDepartureTime());
		smt.setString(6, reservation.getArrivalCity());
		smt.setString(7, reservation.getUserName());
		
		
		try {
			smt.execute();
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new SQLException("You can not double book flights!");
			}
		
		PreparedStatement smt1 = con.prepareStatement(Queries.REMOVE_SEAT);
		smt1.setInt(1, reservation.getFlightNumber());
		smt1.execute();
		smt1.close();
		
		PreparedStatement smt2 = con.prepareStatement(Queries.GET_RESERVATION);
		smt2.setString(1, reservation.getUserName());
		smt2.execute();
		smt2.close();
		
	}
	
	public static void deleteFlight(VO vo) throws SQLException, Exception{
		
		Reservation reservation = vo.getReservation();
		Connection con = ConnectDatbase.getConnection();
		PreparedStatement smt = con.prepareStatement(Queries.DELETE_RESERVATION);
		smt.setString(1, reservation.getUserName());
		smt.setInt(2, reservation.getFlightNumber());
		try {
			smt.execute();
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new SQLException("You cannot delete this flight!");
			}
		
		PreparedStatement smt1 = con.prepareStatement(Queries.ADD_SEAT);
		smt1.setInt(1, reservation.getFlightNumber());
		smt1.execute();
		smt1.close();
		
		
	}
	
	public static void doubleReserve(VO vo) throws Exception {
		Reservation res = vo.getReservation();	
		
		Connection con = ConnectDatbase.getConnection();
		try {
			PreparedStatement smt = con.prepareStatement(Queries.CHECK_RESERVATION);
	    
			int flightNum = res.getFlightNumber();
			String user = res.getUserName();
			smt.setString(1, res.getUserName());
			smt.setInt(2, res.getFlightNumber());
			
			ResultSet resultSet = smt.executeQuery();
			
			while (resultSet.next()) {
				int flightNumber = resultSet.getInt("flightNumber");
				String username = resultSet.getString("userName");
				if((flightNum == flightNumber) && (user.equals(username))){
					throw new DistinctException("You cannot book the same flight twice!");
				}
			}		     
	    
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			System.out.println(e);
			throw e;
		}
		finally {
			
			con.close();
		}
	}
		
		
		
		
	public static void getFlights(VO vo) throws Exception {
		Customer co = vo.getCustomer();
		// can I run a query on reservation table that select all teh rows with customerID comes from co
		/* Flight f1 = new Flight();
		f1.setAirlineName("Delta 303");
		
		Flight f2 = new Flight();
		f2.setAirlineName("Delta 500");
		
		Flight f3 = new Flight();
		f3.setAirlineName("Delta 777");
		*/
		/*
		co.getFlights().add(f1);
		co.getFlights().add(f2);
		co.getFlights().add(f3);
		*/
	}

	public static void main(String[] args) throws Exception {
		/*
		Customer c0 = new Customer();
		login(c0); */	
		//Connection con = ConnectDatbase.getConnection();
		//PreparedStatement smt = con.prepareStatement("INSERT INTO flight (flightNumber, airlineName, arrivalCity, departureCity, flightTime, price, flightDate, seatCount)"
		  //      + " VALUES (9888888, 'Delta', 'ATL', 'LAX', '7:00', 1568, '07/22/2019', 150)");
		//smt.execute();
		//con.close();
	/*Connection con = ConnectDatbase.getConnection();
	    Statement smt = con.createStatement();
		smt.executeUpdate("INSERT INTO flight"
		        + " VALUES (348, 'Delta', 'ATL', 'LAX', 'PM', 1030, 'july', 150)");
		con.close();
*/
	}
}


