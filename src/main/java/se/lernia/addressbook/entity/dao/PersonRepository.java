package se.lernia.addressbook.entity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se.lernia.addressbook.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	public List<Person> findAllByOrderByLastNameAsc();

}
