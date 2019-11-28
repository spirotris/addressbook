package se.lernia.addressbook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="active", columnDefinition="BOOLEAN DEFAULT true")
	private Boolean active;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Address> address;
	
	public Person() {
		
	}

	public Person(String firstName, String lastName, String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		if(!address.isEmpty()) {
			for(Address theAddress : address) {
				if(theAddress.isActive()) {
					return theAddress;
				}
			}
		}
		return null;
	}
	
	public List<Address> getAddresses() {
		if(!address.isEmpty()) {
			return address;
		}
		return null;
	}

	public void setAddress(Address theAddress) {
		if(!this.address.isEmpty()) {
			for(Address tempAddress : this.address) {
				if(tempAddress.getId() == theAddress.getId()) {
					tempAddress = theAddress;
				}
			}
		}
		
	}
	
	public void addAddress(Address theAddress) {
		if(address == null) {
			address = new ArrayList<>();
		}
		
		address.add(theAddress);
		
		theAddress.setPerson(this);
	}
	
	public void deleteAddress(Address theAddress) {
		if(theAddress == null) {
			return;
		}
		theAddress.setActive(false);
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + "]";
	}

}
