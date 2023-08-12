package com.AariyanSahu.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.AariyanSahu.chatapp.utils.ConfigReader.getValue;

//Throw early and catch later
public interface commonDAO {
	public static Connection createConnection () throws ClassNotFoundException,SQLException{
		//Step 1 - Load a driver
		Class.forName(getValue("DRIVER"));
		//Step 2 - Making a connection
		//final String CONNECTION_STRING = "jdbc:mysql://localhost/chatdb";
		//final String USER_ID = "root";
		//final String PASSWORD = "ary@2001";
		final String CONNECTION_STRING = getValue("CONNECTION_URL");
		final String USER_ID = getValue("USER_ID");
		final String PASSWORD = getValue("PASSWORD");
	    
		Connection connection = DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
	    //Connection connection = DriverManager.getConnection(getValue("CONNECTION_URL"),getValue("USER_ID"),getValue("PASSWORD"));
		
	    if(connection != null) {
			System.out.println("Connection Created.....");
			//connection.close();
		}
		return connection;
	}
}
