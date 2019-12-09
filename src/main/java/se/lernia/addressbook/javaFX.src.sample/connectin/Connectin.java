package main.java.se.lernia.addressbook.javaFX.src.sample.connectin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
public class Connectin {
	private static Connectin contin;
	private Connection conn;
	
	private Connectin() {}
	public static synchronized Connectin getInstance() {
		if (contin == null) {
			contin = new Connectin();
		}
		return contin;
	}
	public void ConnectTo(String ip ,String username, String password ){
		try {
			if(conn != null) {
				conn.close();
			}
			conn = DriverManager.getConnection(
					"jdbc:mysql://" + username + ":" + password + "@" + ip + "/"
					);
			System.out.println("Connected to database");
		}catch(SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public Resultset takeDBAction(DBAction dba) {
		return dba.executeFor(conn);
	}
}
