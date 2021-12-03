package edu.gsu.common;

public class Flight 
{
	private int flightNo;
	private String airlineName;
	private String startCity;
	private String endCity;
	private String flightTime;
	private int price;
	private String flightDate;
	private int seats;
	
	public Flight(int flightNo, String airlineName, String startCity, String endCity, String flightTime, int price,
			String flightDate, int seats) 
	{	
		super();
		this.flightNo = flightNo;
		this.airlineName = airlineName;
		this.startCity = startCity;
		this.endCity = endCity;
		this.flightTime = flightTime;
		this.price = price;
		this.flightDate = flightDate;
		this.seats = seats;
	}
	public int getFlightNo() 
	{
		return flightNo;
	}
	public void setFlightNo(int flightNo) 
	{
		this.flightNo = flightNo;
	}
	
	public String getAirlineName() 
	{
		return airlineName;
	}
	public void setAirlineName(String airlineName) 
	{
		this.airlineName = airlineName;
	}
	public String getStartCity() 
	{
		return startCity;
	}
	public void setStartCity(String startCity) 
	{
		this.startCity = startCity;
	}
	public String getEndCity() 
	{
		return endCity;
	}
	public void setEndCity(String endCity) 
	{
		this.endCity = endCity;
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
	public int getSeats() 
	{
		return seats;
	}
	public void setSeats(int seats) 
	{
		this.seats = seats;
	}
}
