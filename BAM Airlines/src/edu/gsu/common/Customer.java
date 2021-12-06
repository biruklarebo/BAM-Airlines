package edu.gsu.common;

import java.util.ArrayList;

public class Customer 
{	
	private String firstName;
	private String lastName;
	private String address;
	private int zip;
	private String state;
	private String userName;
	private String password;
	private String email;
	private String SSN;
	private String customerSecurityQuestion;
	private String customerSecurityAnswer;
	private ArrayList<Flight> flights;
	private Flight deletedFlight; // would make it so that a flight is deleted add business logic so that it deletes flight
	private String action;
	//
	public Customer() 
	{	
		flights = new ArrayList<>();
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public int getZip() 
	{
		return zip;
	}
	public void setZip(int zip) 
	{
		this.zip = zip;
	}
	public String getState() 
	{
		return state;
	}
	public void setState(String state) 
	{
		this.state = state;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getSSN() 
	{
		return SSN;
	}
	public void setSSN(String SSN) 
	{
		this.SSN = SSN;
	}
	public String getCustomerSecurityQuestion() 
	{
		return customerSecurityQuestion;
	}
	public void setCustomerSecurityQuestion(String customerSecurityQuestion) 
	{
		this.customerSecurityQuestion = customerSecurityQuestion;
	}
	public String getCustomerSecurityAnswer() 
	{
		return customerSecurityAnswer;
	}
	public void setCustomerSecurityAnswer(String customerSecurityAnswer) 
	{
		this.customerSecurityAnswer = customerSecurityAnswer;
	}
	public ArrayList<Flight> getFlights() 
	{
		return flights;
	}
	public void setFlights(ArrayList<Flight> flights) 
	{
		this.flights = flights;
	}
	public String getAction() 
	{
		return action;
	}
	public void setAction(String action) 
	{
		this.action = action;
	}
	// we should decide if we want to follow what prof did with Action or take it our own way... 
	
	
}
