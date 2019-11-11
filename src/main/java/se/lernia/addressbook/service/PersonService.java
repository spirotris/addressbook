package se.lernia.addressbook.service;

import java.util.List;

import se.lernia.addressbook.entity.Person;

public interface PersonService {

	public List<Person> findAll();

	public Person findById(int theId);

	public void save(Person thePerson);

	public void deleteById(int theId);

}
