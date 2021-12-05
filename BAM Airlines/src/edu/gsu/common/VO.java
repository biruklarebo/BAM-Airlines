package edu.gsu.common;
import java.util.ArrayList;

public class VO {
	
	private Customer customer;
	private ArrayList<Flight> flight;
	private SearchDate searchDate;
	
	public VO() {
		customer = new Customer();
		flight = new ArrayList<>();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ArrayList<Flight> getFlight() {
		return flight;
	}
	public void setFlight(ArrayList<Flight> flight) {
		this.flight = flight;
	}

	public SearchDate getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(SearchDate searchDate) {
		this.searchDate = searchDate;
	}
	 
}
