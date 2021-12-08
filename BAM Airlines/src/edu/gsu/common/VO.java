package edu.gsu.common;
import java.util.ArrayList;

public class VO {
	
	private Customer customer;
	
	private Reservation reservation; 
	
	public VO() {
		customer = new Customer();
		
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
}
