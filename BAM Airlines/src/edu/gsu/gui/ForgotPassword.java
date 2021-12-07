package edu.gsu.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.gsu.common.Action;
import edu.gsu.common.Customer;
import edu.gsu.common.VO;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import javafx.fxml.Initializable;

public class ForgotPassword extends Application implements Initializable{

	@FXML
	private Button getPassword;
	
	@FXML
	private Button backToLogin;
	
	@FXML
	private TextField securityQuestionAnswer;
	
	@FXML 
	private ChoiceBox<String> myChoiceBox;
	
	@FXML 
	private TextField userName;
	
	@FXML 
	private BorderPane borderPane;
	
	
	
	
	
	

	public void start(Stage thirdStage) throws Exception {
		try {
			  Parent root = FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
			  Scene scene = new Scene(root);
			  
			 
			  thirdStage.setTitle("Forgot Password");
			  thirdStage.setScene(scene);
			  thirdStage.show();
			  
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
	}
	
	private String[] securityQuestions = {"What is your favorite food?", "What was the name of your first pet?",
			"In what city were you born?", "What is the name of your favorite band?", "Who was your first roommate?"};
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//this populates the choice box
		myChoiceBox.getItems().addAll(securityQuestions);
		}
	
	public void getPassword(MouseEvent event) throws IOException {
		try {
			  Customer co = new Customer();
			  
			 
			  co.setUserName(userName.getText());
			  co.setCustomerSecurityQuestion(myChoiceBox.getValue());
			  co.setCustomerSecurityAnswer(securityQuestionAnswer.getText());
			  VO vo = new VO();
			  vo.setCustomer(co);
			  
			System.out.println("Running process...");
			  ExceptionHandler.process(vo, "FORGOT_PASSWORD");
			  
			  
			  
		  } catch(Exception e ){
			  AlertBox.display("Error",e.getMessage());
			  System.out.println(e);
		  }
	}
		public void backtoLoginClicked (MouseEvent event) throws IOException {
			  Stage stage = new Stage();
			  System.out.print("register clicked!");
			  Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
			  Scene scene = new Scene(root);
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  stage.setScene(scene);
			  stage.setTitle("Welcome to BAM airlines");
			  stage.show();  
		  }
		
	public static void main(String[] args) {
	    launch(args);  
	  }
	

}
