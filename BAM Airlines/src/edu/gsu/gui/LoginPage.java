package edu.gsu.gui;

import java.util.HashMap;

import java.util.HashSet;

import java.io.IOException;


import edu.gsu.common.Action;
import edu.gsu.common.Customer;
import edu.gsu.common.VO;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;  
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.input.*;
import javafx.fxml.FXMLLoader;




public class LoginPage extends Application {

  @FXML
  private TextField username;
  @FXML
  private TextField password;
  @FXML
  private Button logIn;
  @FXML 
  private Button register;
  @FXML
  private Button forgotPassword;
  @FXML 
  private AnchorPane LoginScreen;
  
  @FXML
  public void loginClicked(MouseEvent event) throws IOException {
	  Customer co = new Customer();
	  if ( username.getText().isEmpty()|| password.getText().isEmpty()) {
		  AlertBox.display("Error","Please enter username and/or password");
		  
	  }
	  else {
		  VO vo = new VO();
		  vo.setCustomer(co);
		  co.setUserName(username.getText());
		  co.setPassword(password.getText());
		  	 ExceptionHandler.process(vo, "LOGIN");
	  }
  }
	  public void registerClicked(MouseEvent event) throws IOException {
		  System.out.print("register clicked!");
		 
	
	  
	  
  }

  
  
  
  
  
  
  
  
  
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage)  {
   
	  try {
		  Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		  Scene scene = new Scene(root);
		  
		  
		  primaryStage.setTitle("Welcome to BAM Airlines");
		  primaryStage.setScene(scene);
		  primaryStage.show();
		  
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
  }

 
  public static void main(String[] args) {
    launch(args);  
  }
  
  
}
	  
  




