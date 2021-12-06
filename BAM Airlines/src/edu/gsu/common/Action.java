package edu.gsu.common;

//i changed the formatting

public class Action 
{ 
	private String action = null;
	public static final String LOGIN = "LOGIN";
	public static final String GET_FLIGHTS = "GET_FLIGHTS";
	public static final String CREATE_ACCOUNT = "CREATE_ACCOUNT";
	public static final String FORGOT_PASSWORD = "FORGOT_PASSWORD";
	
	public String getAction() 
	{
		return action;
	}
	public void setAction(String action) 
	{
		this.action = action;
	}
	
}
