package se.lernia.addressbook.javaFX.connectin;

import com.mysql.cj.protocol.Resultset;
import se.lernia.addressbook.entity.Person;
import se.lernia.addressbook.service.PersonService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Connectin implements PersonService {
    private static Connectin contin;
    private Connection conn;

    private Connectin() {
    }

    public static synchronized Connectin getInstance() {
        if (contin == null) {
            contin = new Connectin();
        }
        return contin;
    }

    public boolean ConnectTo(String ip, String username, String password) {
        try {
            if (conn != null) {
                conn.close();
            }
            conn = DriverManager.getConnection(
                    "jdbc:mysql://" + username + ":" + password + "@" + ip + "/"
            );
            System.out.println("Connected to database");
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public Resultset takeDBAction(DBAction dba) {
        return dba.executeFor(conn);
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person findById(int theId) {
        return null;
    }

    @Override
    public void save(Person thePerson) {

    }

    @Override
    public void deleteById(int theId) {

    }

    @Override
    public List<Person> findAllActive() {
        return null;
    }

    @Override
    public List<Person> findAllInactive() {
        return null;
    }

    @Override
    public void restorePerson(int theId) {

    }
}
