package edu.gsu.gui;

import java.util.HashMap;

import java.util.HashSet;

import java.io.IOException;


import edu.gsu.common.Action;
import edu.gsu.common.Customer;
import edu.gsu.common.VO;
import edu.gsu.db.Queries;
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
import javafx.scene.Node;


//This class opens the login page which extends from Application
//The application class is a java class 
public class LoginPage extends Application {
	
/*these encapsulate the text fields and buttons that are associated with the Login Page
 In order to create events and tasks, these need to be linked to scene builder with their IDs
 */

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
  
  
  //This creates a mouse event, when a user clicks 
  //throws IOException because the application is receiving an input from the user
  @FXML
  public void loginClicked(MouseEvent event) throws IOException {
	  Customer co = new Customer();
	  if ( username.getText().isEmpty()|| password.getText().isEmpty()) {
		  AlertBox.display("Error","Please enter username and/or password");
		  
	  }
	  else {
		  VO vo = new VO(); //This creates a temp value object that stores the input text from the user
		  vo.setCustomer(co);
		  co.setUserName(username.getText());
		  co.setPassword(password.getText());
		  if(ExceptionHandler.process(vo, "LOGIN") == true) {	  	 
		  	  Stage stage = new Stage();
			  System.out.print("register clicked!");
			  String user = username.getText();
			  FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
			  
			  Parent root1 = loader.load();
			  //Parent root1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			  HomePage homePage = loader.getController();
			  
			  homePage.displayName(user);
			  Scene scene = new Scene(root1);
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  stage.setScene(scene);
			  stage.setTitle("Home");
			  stage.show(); 
		  	 
		  }
	  }
		  	 
	  
  }
	  public void registerClicked(MouseEvent event) throws IOException {
		  Stage stage = new Stage();
		  System.out.print("register clicked!");
		  Parent root = FXMLLoader.load(getClass().getResource("RegisterPage.fxml"));
		  Scene scene = new Scene(root);
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  stage.setScene(scene);
		  stage.setTitle("Create an Account");
		  stage.show();
  }
	  public void forgotPasswordClicked(MouseEvent event) throws IOException {
		  Stage stage = new Stage();
		  System.out.print("register clicked!");
		  Parent root = FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
		  Scene scene = new Scene(root);
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  stage.setScene(scene);
		  stage.setTitle("Forgot Password");
		  stage.show();  
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
	  
  




