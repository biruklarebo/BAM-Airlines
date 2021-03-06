package edu.gsu.gui;

import javafx.application.Application;

import javafx.stage.Stage;
import java.util.HashMap;


import java.util.HashSet;
import java.util.ResourceBundle;
import java.io.IOException;
import java.net.URL;

import edu.gsu.common.Action;
import edu.gsu.common.Customer;
import edu.gsu.common.VO;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;  
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.input.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import edu.gsu.common.Action;


public class RegisterPage extends Application implements Initializable{
	
	
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField email;
	@FXML
	private TextField address;
	@FXML 
	private TextField state;
	@FXML 
	private TextField zip;
	@FXML 
	private TextField userName;
	@FXML
	private TextField password;
	@FXML
	private TextField ssn;
	@FXML 
	private ChoiceBox<String> myChoiceBox;
	@FXML
	private Label sqLabel;
	@FXML
	private ChoiceBox<String> stateChoiceBox;
	@FXML 
	private TextField securityQuesitonAnswer;
	@FXML 
	private Button submit;
	@FXML 
	private Button backtologin;

	@Override
	public void start(Stage secondStage) throws Exception {
		try {
			  Parent root = FXMLLoader.load(getClass().getResource("RegisterPage.fxml"));
			  Scene scene = new Scene(root);
			  
			  
			  secondStage.setTitle("Register");
			  secondStage.setScene(scene);
			  secondStage.show();
			  
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
	}
	
	
	
	
	
	private String[] securityQuestions = {"What is your favorite food?", "What was the name of your first pet?",
			"In what city were you born?", "What is the name of your favorite band?", "Who was your first roommate?"};

private String[] stateOptions = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
			"HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO",
			"MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR","PA","RI", "SC", "SD" ,
			"TN","TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
			
	//this method is called behind the scenes to initialize a controller after its root element has already been processed
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//initialize 
		//this populates the choice box
		myChoiceBox.getItems().addAll(securityQuestions);
		stateChoiceBox.getItems().addAll(stateOptions);
		
	}
	
	
	public void submitClicked(MouseEvent event) throws IOException {
		  if (userName.getText().isEmpty()|| password.getText().isEmpty() || email.getText().isEmpty() || address.getText().isEmpty() 
				  || zip.getText().isEmpty() || userName.getText().isEmpty() || password.getText().isEmpty() || ssn.getText().isEmpty() || 
				  securityQuesitonAnswer.getText().isEmpty()) {
			  AlertBox.display("Error","All fields must be filled out.");
		  }
		  else {
			  try {
				  Customer co = new Customer();
				  
				  co.setFirstName(firstName.getText());
				  co.setLastName(lastName.getText());
				  co.setAddress(address.getText());
				  co.setZip(Integer.parseInt(zip.getText()));
				  co.setState(stateChoiceBox.getValue());
				  co.setUserName(userName.getText());
				  co.setPassword(password.getText());
				  co.setEmail(email.getText());
				  co.setCustomerSecurityQuestion(myChoiceBox.getValue());
				  co.setCustomerSecurityAnswer(securityQuesitonAnswer.getText());
				  co.setSSN(ssn.getText());
				  //
				  
				  
				  
				  
				  VO vo = new VO();
				  vo.setCustomer(co);
				
				  ExceptionHandler.process(vo, "CREATE_ACCOUNT");
				  
				  
				  
			  } catch(Exception e ){
				  AlertBox.display("Error",e.getMessage());
				  System.out.println(e);
			  }
			  Stage stage = new Stage();
			  System.out.print("login clicked!");
			  Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
			  Scene scene = new Scene(root);
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  stage.setScene(scene);
			  stage.setTitle("Login to your new account");
			  stage.show();
			  
			  
		  }
		  
		  
		 
		  
		  
	}
	
public void backToLoginClicked(MouseEvent event) throws IOException{
		
		Stage stage = new Stage();
		  System.out.print("Logout Clicked!");
		  Parent root4 = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		  Scene scene = new Scene(root4);
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  stage.setScene(scene);
		  stage.setTitle("Welcome to BAM Airlines!");
		  stage.show();
		
	}
	
	public static void main(String[] args) {
	    launch(args);  
	  }
	
	
	

}