package edu.gsu.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import edu.gsu.common.*;
import edu.gsu.gui.ExceptionHandler;
import edu.gsu.db.ConnectDatbase;
import edu.gsu.db.DBQueries;
import edu.gsu.db.Queries;
import edu.gsu.excpetions.DistinctException;
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
import javafx.scene.control.Label;
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
	private TableColumn<Flight, String> DepartDate;
	
	@FXML
	private TableColumn<Flight, String> ArrivalDate;

	@FXML
	private TableColumn<Flight, String> departureTime;

	@FXML
	private TableColumn<Flight, Integer> seats;

	@FXML
	private TableColumn<Flight, Integer> price;

	@FXML
	private DatePicker dateSelect;
	
	@FXML
	private DatePicker arrivedateSelect;
	
	@FXML 
	private TableColumn<Flight, String> airline;
	
	@FXML
	private TableColumn<Flight, String> arrivalTime;
	
	@FXML
	private TableView<Reservation> cflights;
	
	@FXML
	private TableColumn<Reservation, String> Airline;
	
	@FXML
	private TableColumn<Reservation, Integer> cFlightNum;
	@FXML
	private TableColumn<Reservation, String> cDepDate;
	@FXML
	private TableColumn<Reservation, String> cDepTime;
	@FXML
	private TableColumn<Reservation, String> cArrivalCity;
	
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
	
	@FXML
	private static String userName;
	
	@FXML Label userLabel;
	
	
	public void start(Stage fourthStage) throws Exception {
		try {
			  Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			  Scene scene = new Scene(root);
			  
			  
			  fourthStage.setTitle("Home");
			  fourthStage.setScene(scene);
			  fourthStage.show();
			  refreshPage();
			  
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
	}
	public static void main(String[] args) {
	    launch(args);
	  }
	public void displayName(String username) {
		userLabel.setText("Welcome " + username);
		userName = username;
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
	ObservableList<Reservation> reservation = FXCollections.observableArrayList();
	
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
			price.setCellValueFactory(new PropertyValueFactory<>("price"));
			seats.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
			ArrivalDate.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
			DepartDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
			
			Connection con = ConnectDatbase.getConnection();
			ResultSet resultSet = con.createStatement().executeQuery(message);
			
			while (resultSet.next()) {
				flights.add(new Flight(resultSet.getInt("flightNumber"), resultSet.getString("airlineName"), resultSet.getString("departureCity"),
						resultSet.getString("arrivalCity"), resultSet.getString("arrivalTime"), resultSet.getString("departureTime"), resultSet.getInt("price"), resultSet.getString("departureDate"), 
						resultSet.getString("arrivalDate"), resultSet.getInt("seatCount")));
			}
			FlightTable.setItems(flights);
			con.close();
			
			
			
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void updateReservation(String message) {
		try {
			Airline.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
			cFlightNum.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
			cArrivalCity.setCellValueFactory(new PropertyValueFactory<>("arrivalCity"));
			cDepTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
			cDepDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
			
			
			Connection con = ConnectDatbase.getConnection();
			PreparedStatement smt = con.prepareStatement(message);
			smt.setString(1, userName);
			ResultSet resultSet = smt.executeQuery();
			
			
			while (resultSet.next()) {
				reservation.add(new Reservation(resultSet.getInt("flightNumber"), resultSet.getString("airlineName"),
						resultSet.getString("arrivalCity"), resultSet.getString("departureTime"), resultSet.getString("departureDate")));
			}
			cflights.setItems(reservation);
			con.close();
			
			
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void refreshPage() {
		flights.clear();
		reservation.clear();
		updateFlights(Queries.GET_FLIGHT);
		updateReservation(Queries.GET_RESERVATION);
	}
	
	public void searchClicked(MouseEvent event) throws IOException {
		  flights.clear();
		  try {
			  updateFlights(Queries.GET_FLIGHT +" WHERE arrivalCity =" + " '" + arrive.getValue() + "' AND departureCity =" + " '" + depart.getValue() + "' AND departureDate =" + " '" + dateSelect.getValue().toString() + "' AND arrivalDate =" + " '" 
					  								+ arrivedateSelect.getValue().toString() + "'");	  
		  }catch(Exception e) {
			  FlightTable.setItems(flights);
		  }
	}
	
	public void reserveClicked(MouseEvent event) throws IOException, DistinctException{
		Flight flight = FlightTable.getSelectionModel().getSelectedItem();
		if (flight.getSeatNumber() == 0) {
			
				throw new DistinctException("Flight is full") ;
		}
		else {
			reservation.clear();
			VO vo = new VO();
			Reservation r = new Reservation();
			r.setReservationNum(("T" + (int) (Math.random() * 999)));
			r.setFlightNumber(flight.getFlightNumber());
			r.setUserName(userName);
			r.setAirlineName(flight.getAirlineName());
			r.setArrivalCity(flight.getArrivalCity());;
			r.setDepartureDate(flight.getDepartureDate().toString());
			r.setDepartureTime(flight.getDepartureTime());;
			vo.setReservation(r);
			ExceptionHandler.process(vo, "CREATE_RESERVATION");
			updateReservation(Queries.GET_RESERVATION);
			cflights.setItems(reservation);
		}
		
		
			
	}
	
	public void deleteClicked(MouseEvent event) throws IOException{
		
	}
	
	public void refreshClicked(MouseEvent event) throws IOException{
		 refreshPage();
		
	}
			
	
		
	
	
	public void logOutClicked(MouseEvent event) throws IOException{
		
	}
	
	
	
}
