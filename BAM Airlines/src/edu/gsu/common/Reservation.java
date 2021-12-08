package edu.gsu.common;

public class Reservation {
	
	
	private String reservationNum;
	
	private String userName;
	
	private String airlineName;
	
	private int flightNumber;
	
	private String departureDate; //flightDate
	
	private String departureTime;
	
	private String arrivalCity;
	
	
	public Reservation(int flightNumber, String airlineName, String departureDate, String departureTime, String arrivalCity) {
		super();
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalCity = arrivalCity;
		//this.userName = userName;
		
	}
	
	public Reservation() 
	{
		
	}


	public String getReservationNum() {
		return reservationNum;
	}


	public void setReservationNum(String reservationNum) {
		this.reservationNum = reservationNum;
	}


	public String getAirlineName() {
		return airlineName;
	}


	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}


	public int getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}


	public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}


	public String getArrivalCity() {
		return arrivalCity;
	}


	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	
	
	
	
	
	
	
	
	

}
