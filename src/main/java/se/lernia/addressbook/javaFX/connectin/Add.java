package se.lernia.addressbook.javaFX.connectin;

import com.mysql.cj.protocol.Resultset;
import se.lernia.addressbook.javaFX.Person;

import java.sql.*;


public class Add extends DBAction {
    Person person;
    String default_table1 = "person (first_name,last_name,phone_number,email) ";
    String default_table2 = "address (person_id,country) ";
    public Add(Person person) {
        this.person = person;
    }

    @Override
    public Resultset executeFor(Connection conn) {
        try {
            int id;
            //Prepare
            String s1 =  "INSERT INTO " + default_table1 + "VALUES " + "("
                    + "'" + person.getFirstName() + "',"
                    + "'" + person.getLastName() + "',"
                    + "'" + person.getTelephone() + "',"
                    + "'" + person.getMail() + "');";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            String s2 = "SELECT id FROM person " +
                    "WHERE phone_number = " + person.getTelephone() + " AND email = " + person.getMail()+ ";";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            //execute
            stmt1.executeUpdate();
            ResultSet rs = stmt2.executeQuery();
            //prepare
            id = Integer.parseInt(rs.getObject(1).toString());
            String s3 = "INSERT INTO" + default_table2 + "VALUES " + "("
                    + id +","
                    + "'" + person.getCountry() + "',);";
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            //execute
            stmt3.executeUpdate();

            //close
            stmt1.close();
            stmt2.close();
            stmt3.close();

                   /*  "INSERT INTO " + default_table2 + "VALUES " + "("
                    //+
                    + "WHERE " //Supposed to be where the id is the same as in the "person" table
                    ;*/
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
