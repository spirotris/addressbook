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

import se.lernia.addressbook.entity.Address;
import se.lernia.addressbook.entity.Person;
import se.lernia.addressbook.service.AddressService;
import se.lernia.addressbook.service.PersonService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private PersonService personService;

	@Autowired
	private AddressService addressService;

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("personId") int theId, Model theModel) {
		Person thePerson = personService.findById(theId);

		Address theAddress = thePerson.getAddress();

		if (theAddress == null) {
			theAddress = new Address();
			theAddress.setPerson(thePerson);
		}

		theModel.addAttribute("address", theAddress);

		return "persons/address-form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("address") Address theAddress) {
		addressService.save(theAddress);

		return "redirect:/persons/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("addressId") int theId) {

		if (theId != 0) {
			addressService.deleteById(theId);
		}

		return "redirect:/persons/list";
	}

	@GetMapping("/restore")
	public String showFormForAddressRestore(@RequestParam("personId") int theId, Model theModel) {
		List<Address> theAddresses = addressService.findAllInactiveById(theId);

		theModel.addAttribute("addressess", theAddresses);

		return "persons/restore-address";

	}
	
	@GetMapping("/restoreAddress")
	public String restoreAddress(@RequestParam("addressId") int theId) {
		
		addressService.setActive(theId);
		
		return "redirect:/persons/list";
	}
	
}
