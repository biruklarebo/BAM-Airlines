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
	private TextField confirmPassword;
	@FXML 
	private ChoiceBox<String> myChoiceBox;
	@FXML
	private Label sqLabel;
	@FXML
	private ChoiceBox<String> stateChoiceBox;

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
		
		//this populates the choice box
		myChoiceBox.getItems().addAll(securityQuestions);
		stateChoiceBox.getItems().addAll(stateOptions);
		
	}
	public void initialize1(URL arg0, ResourceBundle arg1) {
		stateChoiceBox.getItems().addAll(stateOptions);
		System.out.println("New state");
		
	}
	
	public static void main(String[] args) {
	    launch(args);  
	  }
	
	
	

}
