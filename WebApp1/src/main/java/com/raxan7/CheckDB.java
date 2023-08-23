package com.raxan7;

import java.sql.Connection;
import java.sql.DriverManager;

public class CheckDB {

	public static void main(String[] args) {
		  String JdbcURL = "jdbc:mysql://localhost:3306/javaDB";
	      String Username = "saidi";
	      String password = "blender1";
	      Connection con = null;
	      try {
	         System.out.println("Connecting to database..............."+JdbcURL);
	         con=DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }

	}

}