package se.lernia.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import se.lernia.addressbook.entity.Person;
import se.lernia.addressbook.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/list")
	public String listPersons(Model theModel) {

		List<Person> thePersons = personService.findAllActive();

		theModel.addAttribute("persons", thePersons);

		return "persons/list-persons";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Person thePerson = new Person();

		theModel.addAttribute("person", thePerson);

		return "persons/person-form";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("personId") int theId, Model theModel) {
		Person thePerson = personService.findById(theId);

		theModel.addAttribute("person", thePerson);

		return "persons/person-form";
	}
	
	@PostMapping("/save")
	public String savePerson(@ModelAttribute("person") Person thePerson) {
		personService.save(thePerson);

		return "redirect:/persons/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("personId") int theId) {
		personService.deleteById(theId);

		return "redirect:/persons/list";
	}
	
	@GetMapping("/showFormForRestore")
	public String showFormForRestorePerson(Model theModel) {
		List<Person> thePersons = personService.findAllInactive();

		theModel.addAttribute("persons", thePersons);
		
		return "persons/restore-form";
	}
	
	@GetMapping("/restore")
	public String showFormForRestorePerson(@RequestParam("personId") int theId) {
		
		personService.restorePerson(theId);
		
		return "redirect:/persons/list";
	}
	
}
