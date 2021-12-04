package edu.gsu.common;

//Flight class created to be used in our application

public class Flight 
{	
	//Initialization and encapsulation of flight attributes
	private int flightNumber;
	private String airlineName;
	private String departureCity;
	private String arrivalCity;
	private String flightTime;
	private int price;
	private String flightDate;
	private int seatNumber;
	
	
	//default no-arg constructor
	public Flight()
	{
		
	}
	
	//creates object "flight"
	public Flight(int flightNumber, String airlineName, String departureCity, String arrivalCity, String flightTime, int price,
			String flightDate, int seatNumber) 
	{	
		super(); //if any of these attributes are not used the no-arg constructor will be called
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.flightTime = flightTime;
		this.price = price;
		this.flightDate = flightDate;
		this.seatNumber = seatNumber;
	}
	public int getFlightNumber() 
	{
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) 
	{
		this.flightNumber = flightNumber;
	}
	public String getAirlineName() 
	{
		return airlineName;
	}
	public void setAirlineName(String airlineName) 
	{
		this.airlineName = airlineName;
	}
	public String getDepartureCity() 
	{
		return departureCity;
	}
	public void setDepartureCity(String departureCity) 
	{
		this.departureCity = departureCity;
	}
	public String getArrivalCity() 
	{
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) 
	{
		this.arrivalCity = arrivalCity;
	}
	public String getFlightTime() 
	{
		return flightTime;
	}
	public void setFlightTime(String flightTime) 
	{
		this.flightTime = flightTime;
	}
	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	public String getFlightDate() 
	{
		return flightDate;
	}
	public void setFlightDate(String flightDate) 
	{
		this.flightDate = flightDate;
	}
	public int getSeatNumber() 
	{
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) 
	{
		this.seatNumber = seatNumber;
	}
}
