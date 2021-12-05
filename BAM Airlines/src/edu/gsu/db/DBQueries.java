package edu.gsu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.common.VO;
import edu.gsu.excpetions.LoginException;
import edu.gsu.db.ConnectDatbase;
public class DBQueries {
	
	public static void login(VO vo) throws Exception {
		Customer co = vo.getCustomer();	
		
		Connection con = ConnectDatbase.getConnection();
		try {
			// Create a statement
			PreparedStatement statement = con.prepareStatement(Queries.LOGIN);
	    
			statement.setString(1, co.getUserName());
			statement.setString(2, co.getPassword());
				    
			// Execute a statement
			ResultSet resultSet = statement.executeQuery();
			
			int count = 0;

			// Iterate through the result and print the student names
			while (resultSet.next()) {
				System.out.println("Number of Users:" + resultSet.getInt(1));
				count = resultSet.getInt(1);
			}
			
			if (count == 0)
				throw new LoginException("Invalid UserName or Password!");
				     
	    
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			System.out.println(e);
			throw e;
		}
		finally {
			
			con.close();
		}
	}
	  	
	/*public static void createAccount(VO vo) throws Exception {
		Customer co = vo.getCustomer();	

		String SQLquery = " insert into user (customerID, firstName, lastName, address, zip, state, userName, password, email, ssn, customerSecurityQuestion, customerSecurityAnswer)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection con = ConnectDatbase.getConnection();
		PreparedStatement smt = con.prepareStatement(SQLquery);
		smt.setInt(1, co.getCustomerID());
		smt.setString(2, co.getFirstName());
		smt.setString(3, co.getLastName());
		smt.setString(4, co.getAddress());
		smt.setInt(5, co.getZip());
		smt.setString(6, co.getState());
		smt.setString(7, co.getUserName());
		smt.setString(8, co.getPassword());
		smt.setString(9, co.getEmail());
		smt.setString(10, co.getSSN());;
		smt.setString(11, co.getCustomerSecurityQuestion());
		smt.setString(12, co.getCustomerSecurityAnswer());
		
		
		smt.execute();
		con.close();
		
	}
	*/
	public static void createAccount(VO vo) throws Exception {
		Customer co = vo.getCustomer();	

		String SQLquery = " insert into user (firstName, lastName, address, zip, state, userName, password, email, ssn, customerSecurityQuestion, customerSecurityAnswer)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection con = ConnectDatbase.getConnection();
		PreparedStatement smt = con.prepareStatement(SQLquery);
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
		login(c0);
	*/	
		
	}
}


