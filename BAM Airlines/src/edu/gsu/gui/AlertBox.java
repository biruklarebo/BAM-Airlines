package edu.gsu.gui;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
	
	public static void display(String title, String message) 
	{
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label();
		label.setText(message);
		Button closeButton = new Button("Close the window");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

}

/*Stage window;
	Scene scene1, scene2; 
	
	
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		
		
		
		Label label1 = new Label("Welcome to the first scene!");
		Button button1 = new Button("Go to scene 2");
		button1.setOnAction(e -> window.setScene(scene2));
		
		//layout 1 - children are laid out in vertical column
		//Vbox stacks all objects on top of each other and spaces them out by 20 pixels
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout1, 200, 200);
		
		//button 2 
		Button button2 = new Button("This scene sucks, go back to scene 1");
		button2.setOnAction(e -> window.setScene(scene2));
		
		//layout2 
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(button2);
		scene2 = new Scene(layout2, 600, 300);
		
			
		//determine which window it will open since there are two 
		//write following code to pick which window opens first 
		window.setScene(scene1);
		window.setTitle("First page");
		
		//shows window
		window.show();
	}
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
*/