package se.lernia.addressbook.service;

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
		personRepository.deleteById(theId);
	}

}