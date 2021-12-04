package edu.gsu.common;

public class FlightTicket extends Flight
{
	//initialized the attributes
	private int ticketNumber;
	private int customerID;
	private int flightNumber;
	
	public FlightTicket() 
	{
		
	}
	//creates the object "Flight Ticket" with attributes ticket number, customerID, and flight Number.
	public FlightTicket(int ticketNumber, int customerID, int flightNumber) 
	{
		super();
		this.ticketNumber = ticketNumber;
		this.customerID = customerID;
		this.flightNumber = flightNumber;
	}
	public int getTicketNumber() 
	{
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) 
	{
		this.ticketNumber = ticketNumber;
	}
	public int getCustomerID() 
	{
		return customerID;
	}
	public void setCustomerID(int customerID) 
	{
		this.customerID = customerID;
	}
	public int getFlightNumber() 
	{
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) 
	{
		this.flightNumber = flightNumber;
	}
}
