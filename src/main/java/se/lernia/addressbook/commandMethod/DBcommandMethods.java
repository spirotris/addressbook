package se.lernia.addressbook.commandMethod;

	import se.lernia.addressbook.connectionDB.*;
	import java.sql.Connection;
	import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import se.lernia.addressbook.entity.*;
	import se.lernia.addressbook.entity.*;

	public class DBcommandMethods {
	
		public static void createOdropDB (String nameDB) {
			
			try {
				Connection con = DBconnection.getConnection();
				System.out.println("Connected to DataBase");
				
				Statement stmt = con.createStatement();
				stmt.executeUpdate(nameDB);
				
				if (nameDB.equalsIgnoreCase("CREATE database"));
				{} 
				if(nameDB.equalsIgnoreCase("DROP database")) 
				{}
				
				System.out.println(nameDB);
				
				con.close();
				stmt.close();
				
			} catch (SQLException e) {
				System.err.println("Error " + e.getErrorCode());
			}
		}
		
		public static void createOdropTable(String query) {
			
			try {
				
				Connection con = DBconnection.getConnection();
				System.out.println("Connected to DataBase ");
				
				Statement stmt = con.createStatement();
				
				stmt.executeUpdate(query);
				
				System.out.println("query complete: " + query);
				
				stmt.close();
				con.close();
				
			}catch (SQLException e) {
				System.err.println("Error " + e.getMessage());
			}
		}
		
		public static void ins(String insertQuery) {
			try {
				
				Connection con = DBconnection.getConnection();
				System.out.println("Connected to Database ");
				
				Statement stmt = con.createStatement();
				stmt.executeUpdate(insertQuery);
				
				System.out.println(insertQuery);
				
				stmt.close();
				con.close();
				
				
			}catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		
		public static  ArrayList <Person> readPersonTable (String select) {
			
			try {
				
				ArrayList<Person> info = new ArrayList<Person>();
				Person information = null;
				
				Connection con = DBconnection.getConnection();
				PreparedStatement statement = con.prepareStatement(select);
				ResultSet result = statement.executeQuery();
				ResultSetMetaData rsmd = result.getMetaData();
				
				while(result.next()) {
					
					information = new Person (result.getString("first_name"),result.getString("last_name"), result.getString("phone_number"), result.getString("email") );
					
					info.add(information);
					
				}
				con.close();
				
				return info;
				
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.err.println("Error " + e.getMessage());
			}
			return null;
			
		}
		
		public static  ArrayList <Address> readAddressTable (String select) {
			
			try {
				
				ArrayList<Address> info2 = new ArrayList<Address>();
				
				Address information2= null;
				
				Connection con = DBconnection.getConnection();
				PreparedStatement statement = con.prepareStatement(select);
				ResultSet result = statement.executeQuery();
				ResultSetMetaData rsmd = result.getMetaData();
				
				while(result.next()) {
					
				
					information2 = new Address (result.getString("street"),result.getString("areacode"),result.getString("city"),result.getString("country"));
					info2.add(information2);
					
				}
				con.close();
				
				return info2;
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.err.println("Error " + e.getMessage());
			}
			return null;
			
}
		
		public static void writeToConsole () {
			String Enter;
			Scanner sc = new Scanner (System.in);
			System.out.println("Enter Person to see Person Table or Enter Address to See Address Table: ");
			Enter = sc.nextLine();
			
			if (Enter.equalsIgnoreCase("Person")) {
				
				try {
					
					ArrayList<Person> info = readPersonTable("select * from Person") ;
					for (Person i: info) {
						
						System.out.println(i.getId()+ "\t"+i.getFirstName()+ "\t" + i.getLastName() +"\t" + i.getPhoneNumber()+  "\t"+ i.getEmail());
				}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(e.getMessage());
				} 
				
			} else if (Enter.equalsIgnoreCase("Address")) {
				try {
					ArrayList<Address> info2 =readAddressTable("select * from Address") ;
					
					for (Address j:info2) {
						
						System.out.println(j.getId() + "\t" +j.getStreet()+ "\t" + j.getAreacode()+ "\t" + j.getCity()+ "\t" + j.getCountry());
					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			} else {
				System.out.println();
			}
			
}
		
	}
		
