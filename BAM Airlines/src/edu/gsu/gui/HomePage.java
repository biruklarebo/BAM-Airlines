package edu.gsu.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import edu.gsu.common.*;
import edu.gsu.common.VO;
import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.gui.ExceptionHandler;
import edu.gsu.db.ConnectDatbase;
import edu.gsu.db.DBQueries;
import edu.gsu.db.Queries;
import edu.gsu.common.VO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class HomePage extends Application implements Initializable{
	@FXML
	private AnchorPane HomePage;
	
	@FXML
	private SplitPane CustomerPage;
	
	


	@FXML
	private TableView<Flight> FlightTable;
	
	@FXML
	private ChoiceBox<String> depart;
	
	@FXML
	private ChoiceBox<String> arrive;
	

	@FXML
	private TableColumn<Flight, Integer> FlightNumber;

	@FXML
	private TableColumn<Flight, String> arrivalCity;

	@FXML
	private TableColumn<Flight, String> departureCity;

	@FXML
	private TableColumn<Flight, String> flightDate;

	@FXML
	private TableColumn<Flight, String> departureTime;

	@FXML
	private TableColumn<Flight, Integer> seats;

	@FXML
	private TableColumn<Flight, Integer> price;

	@FXML
	private DatePicker dateSelect;
	
	@FXML 
	private TableColumn<Flight, String> airline;
	
	@FXML
	private TableColumn<Flight, String> arrivalTime;
	
	@FXML
	private TableView<Customer> cflights;
	
	@FXML
	private TableColumn<Customer, String> Airline;
	
	@FXML
	private TableColumn<Customer, Integer> cFlightNum;
	@FXML
	private TableColumn<Customer, String> cDepDate;
	@FXML
	private TableColumn<Customer, String> cDepTime;
	@FXML
	private TableColumn<Customer, String> cArrivalCity;
	
	@FXML 
	private Button search;
	
	@FXML 
	private Button refresh;
	@FXML 
	private Button reserve;
	
	@FXML 
	private Button delete;
	
	@FXML 
	private Button logout;
	
	
	public void start(Stage fourthStage) throws Exception {
		try {
			  Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			  Scene scene = new Scene(root);
			  
			  
			  fourthStage.setTitle("Home");
			  fourthStage.setScene(scene);
			  fourthStage.show();
			  
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
	}
	public static void main(String[] args) {
	    launch(args);  
	  }
	
	
	
	 ObservableList<String> departCities = FXCollections.observableArrayList("Atlanta", "New York", "London", "Paris", "Chicago", "Athens", "Barcelona", "Miami", "Los Angeles", "Washington D.C",
			"Orlando", "Austin", "Dallas", "Baltimore", "Nashville", "Rome", "Frankfurt", "Sydney", "Tokyo", "Baton Rouge", "New Orleans", "Cheyenne", "Fargo", "Pittsburg",
			"Scranton", "Boston", "Juneau", "Honolulu", "Addis Ababa", "Guatemala City", "Mexico City");
	
	 ObservableList<String> arrivalCities = FXCollections.observableArrayList("Atlanta", "New York", "London", "Paris", "Chicago", "Athens", "Barcelona", "Miami", "Los Angeles", "Washington D.C",
				"Orlando", "Austin", "Dallas", "Baltimore", "Nashville", "Rome", "Frankfurt", "Sydney", "Tokyo", "Baton Rouge", "New Orleans", "Cheyenne", "Fargo", "Pittsburg",
				"Scranton", "Boston", "Juneau", "Honolulu", "Addis Ababa", "Guatemala City", "Mexico City");
	ObservableList<Flight> flights = FXCollections.observableArrayList();
	ObservableList<Customer> customerFlights = FXCollections.observableArrayList();
	ObservableList<String> arrivaltime = FXCollections.observableArrayList("1:00 AM" , "2:00 AM" , "3:00 AM", "7:00 AM" , "1:00 PM" , "3:00 PM" , "5:00 PM" , "9:00 PM");
	ObservableList<String> departuretime = FXCollections.observableArrayList("1:00 AM" , "2:00 AM" , "3:00 AM", "7:00 AM" , "1:00 PM" , "3:00 PM" , "5:00 PM" , "9:00 PM");
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		depart.setItems(departCities);
		depart.getSelectionModel().select(31);;
		arrive.setItems(arrivalCities);
		arrive.getSelectionModel().select(31);
		
		
		
		
	}
	
	
	public void updateFlights(String message) {
		try {
			airline.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
			FlightNumber.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
			departureCity.setCellValueFactory(new PropertyValueFactory<>("departureCity"));
			arrivalCity.setCellValueFactory(new PropertyValueFactory<>("arrivalCity"));
			departureTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
			arrivalTime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
			flightDate.setCellValueFactory(new PropertyValueFactory<>("flightDate"));
			price.setCellValueFactory(new PropertyValueFactory<>("price"));
			seats.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
			
			Connection con = ConnectDatbase.getConnection();
			ResultSet resultSet = con.createStatement().executeQuery(message);
			
			while (resultSet.next()) {
				flights.add(new Flight(resultSet.getInt("flightNumber"), resultSet.getString("airlineName"), resultSet.getString("departureCity"),
						resultSet.getString("arrivalCity"), resultSet.getString("arrivalTime"), resultSet.getString("departureTime"), resultSet.getInt("price"), resultSet.getString("flightDate"),
						resultSet.getInt("seatCount")));
			}
			FlightTable.setItems(flights);
			con.close();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void searchClicked(MouseEvent event) throws IOException {
		  flights.clear();
		  try {
			  updateFlights("SELECT * FROM flight WHERE arrivalCity =" + " '" + arrive.getValue() + "' AND departureCity =" + " '" + depart.getValue() + "' AND flightDate =" + " '" + dateSelect.getValue().toString() + "'");	  
		  }catch(Exception e) {
			  FlightTable.setItems(flights);
		  }
	}
	
	public void reserveClicked(MouseEvent event) throws IOException{
		
	}
	
	public void deleteClicked(MouseEvent event) throws IOException{
		
	}
	
	public void refreshClicked(MouseEvent event) throws IOException{
		
	}
	
	public void logOutClicked(MouseEvent event) throws IOException{
		
	}
	
	
	
}
