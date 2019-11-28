package se.lernia.addressbook.service;

import java.util.List;

import se.lernia.addressbook.entity.Address;

public interface AddressService {

	public List<Address> findAll(int theId);
	
	public Address findById(int theId);

	public void save(Address theAddress);

	public void deleteById(int theId);

	public List<Address> findAllInactiveById(int theId);

	public void setActive(int theId);

}
