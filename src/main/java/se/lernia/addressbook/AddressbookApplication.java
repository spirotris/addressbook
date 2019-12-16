package se.lernia.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lernia.addressbook.connectionDB.*;
import se.lernia.addressbook.commandMethod.*;

@SpringBootApplication
public class AddressbookApplication {

	public static void main(String[] args) {
		// SpringApplication.run(AddressbookApplication.class, args);
		
		DBcommandMethods create = new DBcommandMethods ();
		
		//create.createOdropDB("create database TestSpring");
		/* create.createOdropTable("CREATE TABLE Address" 
				+"(" 
				+ "id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "street VARCHAR(30),"
				+ "areadcode VARCHAR(30),"
				+ "city VARCHAR (30),"
				+ "country VARCHAR (40)"
				+")");
		*/
		
		
		//create.ins("insert into Address (street,areadcode,city,country ) VALUE ('Sankt Eriksgatan 30','16234', 'Stockholm','Sweden')");
		//create.ins("insert into Address (street,areadcode,city,country ) VALUE ('Bäckgårdsvägen','12345', 'Gothenberg','Sweden')");
		//create.ins("insert into Address (street,areadcode,city,country ) VALUE ('Mellangatan 23','12445', 'Visby','Sweden')");
		//create.ins("insert into Address (street,areadcode,city,country ) VALUE ('Sankt Göransgatan 20','16234', 'Stockholm','Sweden')");
		//create.ins("insert into Address (street,areadcode,city,country ) VALUE ('kylevägen','12445', 'Visby','Sweden')");
		
		//create.readPersonTable("select * from Person");
		create.writeToConsole();
		
	}

}
