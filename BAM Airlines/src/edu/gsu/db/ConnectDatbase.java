package edu.gsu.db;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatbase {
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			getConnection();
		}
		
		// REPLACE IP BASED ON WHAT WIFI YOU ARE ON 
		//  gsu IP 10.250.22.166
		// regular IP 10.0.0.103
		public static Connection getConnection() throws Exception {
			try {
				String driver = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://10.0.0.103:3306/bamdb";
				String username = "root";
				String password = "Java123*";
				Class.forName(driver);
				
				Connection conn = DriverManager.getConnection(url, username, password);
				System.out.println("Connceted");
				return conn;
			}	catch(Exception e) {System.out.print(e);
			
			
			
			return null;
			
	}

		}
}