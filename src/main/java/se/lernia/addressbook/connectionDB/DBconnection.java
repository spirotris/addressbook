package se.lernia.addressbook.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	
	public static final String connectionStringDB = "jdbc:mysql://root:Sweden2017@192.168.56.101/";
	
	public static Connection getConnection () throws SQLException {
		
		return DriverManager.getConnection(connectionStringDB); 
	}

}
