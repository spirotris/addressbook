package se.lernia.addressbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.lernia.addressbook.entity.Person;
import se.lernia.addressbook.entity.dao.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonServiceImpl(PersonRepository thePersonRepository) {
		personRepository = thePersonRepository;
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAllByOrderByLastNameAsc();
	}
	
	@Override
	public List<Person> findAllActive() {
		List<Person> persons = findAll();
		List<Person> activePersons = new ArrayList<>();
		
		for(Person thePerson : persons) {
			if(thePerson.isActive()) {
				activePersons.add(thePerson);
			}
		}
		
		return activePersons;
	}

	@Override
	public Person findById(int theId) {
		Optional<Person> result = personRepository.findById(theId);

		Person thePerson = null;

		if (result.isPresent()) {
			thePerson = result.get();

		} else {
			throw new RuntimeException("Did not find person id - " + theId);
		}
		return thePerson;
	}

	@Override
	public void save(Person thePerson) {
		personRepository.save(thePerson);
	}

	@Override
	public void deleteById(int theId) {
		Optional<Person> result = personRepository.findById(theId);

		Person thePerson = null;

		if (result.isPresent()) {
			thePerson = result.get();
			thePerson.setActive(false);
			personRepository.save(thePerson);
		}
		
	}

	@Override
	public List<Person> findAllInactive() {
		List<Person> persons = findAll();
		List<Person> activePersons = new ArrayList<>();
		
		for(Person thePerson : persons) {
			if(!thePerson.isActive()) {
				activePersons.add(thePerson);
			}
		}
		
		return activePersons;
	}

	@Override
	public void restorePerson(int theId) {
		Person thePerson = findById(theId);
		
		thePerson.setActive(true);
		
		personRepository.save(thePerson);
	}

}