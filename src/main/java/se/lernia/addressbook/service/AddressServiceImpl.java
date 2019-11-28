package se.lernia.addressbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.lernia.addressbook.entity.Address;
import se.lernia.addressbook.entity.dao.AddressRepository;


@Service
public class AddressServiceImpl implements AddressService {
	
	private AddressRepository addressRepository;

	@Autowired
	public AddressServiceImpl(AddressRepository theAddressRepository) {
		addressRepository = theAddressRepository;
	}

	@Override
	public List<Address> findAll(int theId) {
		List<Address> resultList = new ArrayList<>();
		List<Address> addressList = addressRepository.findAll();
		
		for(Address theAddress : addressList) {
			if(theAddress.getPerson().getId() == theId) {
				resultList.add(theAddress);
			}
		}
		
		return resultList;
	}
	
	@Override
	public Address findById(int theId) {
		Optional<Address> result = addressRepository.findById(theId);

		Address theAddress = null;

		if (result.isPresent()) {
			theAddress = result.get();
		} else {
			throw new RuntimeException("Did not find address id - " + theId);
		}
		return theAddress;
	}

	@Override
	public void save(Address theAddress) {
		addressRepository.save(theAddress);
	}

	@Override
	public void deleteById(int theId) {
		Optional<Address> result = addressRepository.findById(theId);

		Address theAddress = null;

		if (result.isPresent()) {
			theAddress = result.get();
		} else {
			throw new RuntimeException("Did not find address id - " + theId);
		}
		
		theAddress.setActive(false);
		
		save(theAddress);
	}

	@Override
	public List<Address> findAllInactiveById(int theId) {
		
		List<Address> theList = findAll(theId);
		
		List<Address> inactiveAddresses = new ArrayList<>();
		for(Address tempAddr : theList) {
			if(!tempAddr.isActive()) {
				inactiveAddresses.add(tempAddr);
			}
		}
		
		return inactiveAddresses;
	}

	@Override
	public void setActive(int theId) {
		Address theAddress = findById(theId);
		
		theAddress.setActive(true);
		
		save(theAddress);
	}

}