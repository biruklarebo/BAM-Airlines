package edu.gsu.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			getConnection();
		}

		public static Connection getConnection() throws Exception {
			try {
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://127.0.0.1:3306/AirlineDB";
				String username = "root";
				String password = "biruk123*";
				Class.forName(driver);
				
				Connection conn = DriverManager.getConnection(url, username, password);
				System.out.println("Connceted");
				return conn;
			}	catch(Exception e) {System.out.print(e);
			
			
			
			return null;
			
	}

		}
}
		
