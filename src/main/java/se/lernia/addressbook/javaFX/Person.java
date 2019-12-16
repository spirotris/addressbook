package se.lernia.addressbook.javaFX;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;


public class Person {

    public LocalDate timestamp;
    public SimpleIntegerProperty id;
    public SimpleStringProperty firstName;
    public SimpleStringProperty lastName;
    public SimpleStringProperty mail;
    public SimpleStringProperty telephone;
    public SimpleStringProperty address;
    public SimpleStringProperty country;

    public Person(Integer id, String firstname, String lastname, String mail, String telephonenumber, String address, String county) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstname);
        this.lastName = new SimpleStringProperty(lastname);
        this.mail = new SimpleStringProperty(mail);
        this.telephone = new SimpleStringProperty(telephonenumber);
        this.address = new SimpleStringProperty(address);
        this.country = new SimpleStringProperty(county);
        this.timestamp = LocalDate.now();


    }

    public int getId() {
        return id.getValue();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getFirstName() {
        return firstName.get();
    }


    public void setFirstName(String firstname) {
        this.firstName.set(firstname);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastname) {
        this.lastName.set(lastname);
    }

    public String getMail() {
        return mail.get();
    }

    public void setMail(String mail) {
        this.mail.set(mail);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getCountry() {
        return country.get();
    }

    public void setCounty(String county) {
        this.country.set(county);
    }
}
