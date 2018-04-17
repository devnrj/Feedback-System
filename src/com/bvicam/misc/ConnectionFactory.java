package com.bvicam.misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
	private static ConnectionFactory connectionFactory = null;
	private ResourceBundle rb = ResourceBundle.getBundle("dbconfig");
	private ConnectionFactory() {
		try {
			Class.forName(rb.getString("drivername"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection conn = DriverManager.getConnection(rb.getString("dburl"),rb.getString("userid"),
				rb.getString("pwd"));
		return conn;
	}
	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

}
