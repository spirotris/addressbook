package se.lernia.addressbook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "timestamp")
	private java.util.Date timestamp;

	@Column(name = "street")
	private String street;

	@Column(name = "areacode")
	private String areacode;

	@Column(name = "county")
	private String county;

	@Column(name = "country")
	private String country;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personId", referencedColumnName = "id")
	private Person person;

	public Address() {
	}

	public Address(Date timestamp, String street, String areacode, String county, String country, Person person) {
		this.timestamp = timestamp;
		this.street = street;
		this.areacode = areacode;
		this.county = county;
		this.country = country;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(java.util.Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return street + ", " + areacode + " " + county + ", " + country;
	}

}
